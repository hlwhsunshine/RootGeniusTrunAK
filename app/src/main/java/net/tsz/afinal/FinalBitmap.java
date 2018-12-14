package net.tsz.afinal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import net.tsz.afinal.bitmap.core.BitmapCache;
import net.tsz.afinal.bitmap.core.BitmapCache.ImageCacheParams;
import net.tsz.afinal.bitmap.core.BitmapDisplayConfig;
import net.tsz.afinal.bitmap.core.BitmapProcess;
import net.tsz.afinal.bitmap.display.Displayer;
import net.tsz.afinal.bitmap.display.SimpleDisplayer;
import net.tsz.afinal.bitmap.download.Downloader;
import net.tsz.afinal.bitmap.download.SimpleDownloader;
import net.tsz.afinal.core.AsyncTask;
import net.tsz.afinal.utils.Utils;

public class FinalBitmap {
    private static FinalBitmap mFinalBitmap;
    private ExecutorService bitmapLoadAndDisplayExecutor;
    private HashMap<String, BitmapDisplayConfig> configMap = new HashMap();
    private BitmapProcess mBitmapProcess;
    private FinalBitmapConfig mConfig;
    private Context mContext;
    private boolean mExitTasksEarly = false;
    private BitmapCache mImageCache;
    private boolean mInit = false;
    private boolean mPauseWork = false;
    private final Object mPauseWorkLock = new Object();

    /* renamed from: net.tsz.afinal.FinalBitmap$1 */
    class C17751 implements ThreadFactory {
        C17751() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(4);
            return thread;
        }
    }

    private static class AsyncDrawable extends BitmapDrawable {
        private final WeakReference<BitmapLoadAndDisplayTask> bitmapWorkerTaskReference;

        public AsyncDrawable(Resources resources, Bitmap bitmap, BitmapLoadAndDisplayTask bitmapLoadAndDisplayTask) {
            super(resources, bitmap);
            this.bitmapWorkerTaskReference = new WeakReference(bitmapLoadAndDisplayTask);
        }

        public BitmapLoadAndDisplayTask getBitmapWorkerTask() {
            return (BitmapLoadAndDisplayTask) this.bitmapWorkerTaskReference.get();
        }
    }

    private class BitmapLoadAndDisplayTask extends AsyncTask<Object, Void, Bitmap> {
        private Object data;
        private final BitmapDisplayConfig displayConfig;
        private final WeakReference<View> imageViewReference;

        public BitmapLoadAndDisplayTask(View view, BitmapDisplayConfig bitmapDisplayConfig) {
            this.imageViewReference = new WeakReference(view);
            this.displayConfig = bitmapDisplayConfig;
        }

        private View getAttachedImageView() {
            View view = (View) this.imageViewReference.get();
            return this == FinalBitmap.getBitmapTaskFromImageView(view) ? view : null;
        }

        protected Bitmap doInBackground(Object... objArr) {
            this.data = objArr[0];
            String valueOf = String.valueOf(this.data);
            Bitmap bitmap = null;
            synchronized (FinalBitmap.this.mPauseWorkLock) {
                while (FinalBitmap.this.mPauseWork && !isCancelled()) {
                    try {
                        FinalBitmap.this.mPauseWorkLock.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            if (!(isCancelled() || getAttachedImageView() == null || FinalBitmap.this.mExitTasksEarly)) {
                bitmap = FinalBitmap.this.processBitmap(valueOf, this.displayConfig);
            }
            if (bitmap != null) {
                FinalBitmap.this.mImageCache.addToMemoryCache(valueOf, bitmap);
            }
            return bitmap;
        }

        protected void onCancelled(Bitmap bitmap) {
            super.onCancelled(bitmap);
            synchronized (FinalBitmap.this.mPauseWorkLock) {
                FinalBitmap.this.mPauseWorkLock.notifyAll();
            }
        }

        protected void onPostExecute(Bitmap bitmap) {
            if (isCancelled() || FinalBitmap.this.mExitTasksEarly) {
                bitmap = null;
            }
            View attachedImageView = getAttachedImageView();
            if (bitmap != null && attachedImageView != null) {
                FinalBitmap.this.mConfig.displayer.loadCompletedisplay(attachedImageView, bitmap, this.displayConfig);
            } else if (bitmap == null && attachedImageView != null) {
                FinalBitmap.this.mConfig.displayer.loadFailDisplay(attachedImageView, this.displayConfig.getLoadfailBitmap());
            }
        }
    }

    private class CacheExecutecTask extends AsyncTask<Object, Void, Void> {
        public static final int MESSAGE_CLEAR = 1;
        public static final int MESSAGE_CLEAR_DISK = 3;
        public static final int MESSAGE_CLEAR_KEY = 4;
        public static final int MESSAGE_CLEAR_KEY_IN_DISK = 5;
        public static final int MESSAGE_CLOSE = 2;

        private CacheExecutecTask() {
        }

        /* synthetic */ CacheExecutecTask(FinalBitmap finalBitmap, CacheExecutecTask cacheExecutecTask) {
            this();
        }

        protected Void doInBackground(Object... objArr) {
            switch (((Integer) objArr[0]).intValue()) {
                case 1:
                    FinalBitmap.this.clearCacheInternalInBackgroud();
                    break;
                case 2:
                    FinalBitmap.this.closeCacheInternalInBackgroud();
                    break;
                case 3:
                    FinalBitmap.this.clearDiskCacheInBackgroud();
                    break;
                case 4:
                    FinalBitmap.this.clearCacheInBackgroud(String.valueOf(objArr[1]));
                    break;
                case 5:
                    FinalBitmap.this.clearDiskCacheInBackgroud(String.valueOf(objArr[1]));
                    break;
            }
            return null;
        }
    }

    private class FinalBitmapConfig {
        public String cachePath;
        public BitmapDisplayConfig defaultDisplayConfig = new BitmapDisplayConfig();
        public int diskCacheSize;
        public Displayer displayer;
        public Downloader downloader;
        public int memCacheSize;
        public float memCacheSizePercent;
        public int poolSize = 3;
        public boolean recycleImmediately = true;

        public FinalBitmapConfig(Context context) {
            this.defaultDisplayConfig.setAnimation(null);
            this.defaultDisplayConfig.setAnimationType(1);
            int floor = (int) Math.floor((double) (context.getResources().getDisplayMetrics().widthPixels / 2));
            this.defaultDisplayConfig.setBitmapHeight(floor);
            this.defaultDisplayConfig.setBitmapWidth(floor);
        }
    }

    private FinalBitmap(Context context) {
        this.mContext = context;
        this.mConfig = new FinalBitmapConfig(context);
        configDiskCachePath(Utils.getDiskCacheDir(context, "afinalCache").getAbsolutePath());
        configDisplayer(new SimpleDisplayer());
        configDownlader(new SimpleDownloader());
    }

    public static boolean checkImageTask(Object obj, View view) {
        BitmapLoadAndDisplayTask bitmapTaskFromImageView = getBitmapTaskFromImageView(view);
        if (bitmapTaskFromImageView == null) {
            return true;
        }
        Object access$3 = bitmapTaskFromImageView.data;
        if (access$3 != null && access$3.equals(obj)) {
            return false;
        }
        bitmapTaskFromImageView.cancel(true);
        return true;
    }

    private void clearCacheInBackgroud(String str) {
        if (this.mImageCache != null) {
            this.mImageCache.clearCache(str);
        }
    }

    private void clearCacheInternalInBackgroud() {
        if (this.mImageCache != null) {
            this.mImageCache.clearCache();
        }
    }

    private void clearDiskCacheInBackgroud() {
        if (this.mImageCache != null) {
            this.mImageCache.clearDiskCache();
        }
    }

    private void clearDiskCacheInBackgroud(String str) {
        if (this.mImageCache != null) {
            this.mImageCache.clearDiskCache(str);
        }
    }

    private void closeCacheInternalInBackgroud() {
        if (this.mImageCache != null) {
            this.mImageCache.close();
            this.mImageCache = null;
            mFinalBitmap = null;
        }
    }

    public static synchronized FinalBitmap create(Context context) {
        FinalBitmap finalBitmap;
        synchronized (FinalBitmap.class) {
            if (mFinalBitmap == null) {
                mFinalBitmap = new FinalBitmap(context.getApplicationContext());
            }
            finalBitmap = mFinalBitmap;
        }
        return finalBitmap;
    }

    private void doDisplay(View view, String str, BitmapDisplayConfig bitmapDisplayConfig) {
        if (!this.mInit) {
            init();
        }
        if (!TextUtils.isEmpty(str) && view != null) {
            if (bitmapDisplayConfig == null) {
                bitmapDisplayConfig = this.mConfig.defaultDisplayConfig;
            }
            Bitmap bitmap = null;
            if (this.mImageCache != null) {
                bitmap = this.mImageCache.getBitmapFromMemoryCache(str);
            }
            if (bitmap != null) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageBitmap(bitmap);
                } else {
                    view.setBackgroundDrawable(new BitmapDrawable(bitmap));
                }
            } else if (checkImageTask(str, view)) {
                BitmapLoadAndDisplayTask bitmapLoadAndDisplayTask = new BitmapLoadAndDisplayTask(view, bitmapDisplayConfig);
                Drawable asyncDrawable = new AsyncDrawable(this.mContext.getResources(), bitmapDisplayConfig.getLoadingBitmap(), bitmapLoadAndDisplayTask);
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(asyncDrawable);
                } else {
                    view.setBackgroundDrawable(asyncDrawable);
                }
                bitmapLoadAndDisplayTask.executeOnExecutor(this.bitmapLoadAndDisplayExecutor, str);
            }
        }
    }

    private static BitmapLoadAndDisplayTask getBitmapTaskFromImageView(View view) {
        if (view != null) {
            Drawable drawable = view instanceof ImageView ? ((ImageView) view).getDrawable() : view.getBackground();
            if (drawable instanceof AsyncDrawable) {
                return ((AsyncDrawable) drawable).getBitmapWorkerTask();
            }
        }
        return null;
    }

    private BitmapDisplayConfig getDisplayConfig() {
        BitmapDisplayConfig bitmapDisplayConfig = new BitmapDisplayConfig();
        bitmapDisplayConfig.setAnimation(this.mConfig.defaultDisplayConfig.getAnimation());
        bitmapDisplayConfig.setAnimationType(this.mConfig.defaultDisplayConfig.getAnimationType());
        bitmapDisplayConfig.setBitmapHeight(this.mConfig.defaultDisplayConfig.getBitmapHeight());
        bitmapDisplayConfig.setBitmapWidth(this.mConfig.defaultDisplayConfig.getBitmapWidth());
        bitmapDisplayConfig.setLoadfailBitmap(this.mConfig.defaultDisplayConfig.getLoadfailBitmap());
        bitmapDisplayConfig.setLoadingBitmap(this.mConfig.defaultDisplayConfig.getLoadingBitmap());
        return bitmapDisplayConfig;
    }

    private FinalBitmap init() {
        if (!this.mInit) {
            ImageCacheParams imageCacheParams = new ImageCacheParams(this.mConfig.cachePath);
            if (((double) this.mConfig.memCacheSizePercent) > 0.05d && ((double) this.mConfig.memCacheSizePercent) < 0.8d) {
                imageCacheParams.setMemCacheSizePercent(this.mContext, this.mConfig.memCacheSizePercent);
            } else if (this.mConfig.memCacheSize > 2097152) {
                imageCacheParams.setMemCacheSize(this.mConfig.memCacheSize);
            } else {
                imageCacheParams.setMemCacheSizePercent(this.mContext, 0.3f);
            }
            if (this.mConfig.diskCacheSize > 5242880) {
                imageCacheParams.setDiskCacheSize(this.mConfig.diskCacheSize);
            }
            imageCacheParams.setRecycleImmediately(this.mConfig.recycleImmediately);
            this.mImageCache = new BitmapCache(imageCacheParams);
            this.bitmapLoadAndDisplayExecutor = Executors.newFixedThreadPool(this.mConfig.poolSize, new C17751());
            this.mBitmapProcess = new BitmapProcess(this.mConfig.downloader, this.mImageCache);
            this.mInit = true;
        }
        return this;
    }

    private Bitmap processBitmap(String str, BitmapDisplayConfig bitmapDisplayConfig) {
        return this.mBitmapProcess != null ? this.mBitmapProcess.getBitmap(str, bitmapDisplayConfig) : null;
    }

    public void clearCache() {
        new CacheExecutecTask(this, null).execute(Integer.valueOf(1));
    }

    public void clearCache(String str) {
        new CacheExecutecTask(this, null).execute(Integer.valueOf(4), str);
    }

    public void clearDiskCache() {
        new CacheExecutecTask(this, null).execute(Integer.valueOf(3));
    }

    public void clearDiskCache(String str) {
        new CacheExecutecTask(this, null).execute(Integer.valueOf(5), str);
    }

    public void clearMemoryCache() {
        if (this.mImageCache != null) {
            this.mImageCache.clearMemoryCache();
        }
    }

    public void clearMemoryCache(String str) {
        if (this.mImageCache != null) {
            this.mImageCache.clearMemoryCache(str);
        }
    }

    public void closeCache() {
        new CacheExecutecTask(this, null).execute(Integer.valueOf(2));
    }

    public FinalBitmap configBitmapLoadThreadSize(int i) {
        if (i > 0) {
            this.mConfig.poolSize = i;
        }
        return this;
    }

    public FinalBitmap configBitmapMaxHeight(int i) {
        this.mConfig.defaultDisplayConfig.setBitmapHeight(i);
        return this;
    }

    public FinalBitmap configBitmapMaxWidth(int i) {
        this.mConfig.defaultDisplayConfig.setBitmapWidth(i);
        return this;
    }

    public FinalBitmap configDiskCachePath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mConfig.cachePath = str;
        }
        return this;
    }

    public FinalBitmap configDiskCacheSize(int i) {
        this.mConfig.diskCacheSize = i;
        return this;
    }

    public FinalBitmap configDisplayer(Displayer displayer) {
        this.mConfig.displayer = displayer;
        return this;
    }

    public FinalBitmap configDownlader(Downloader downloader) {
        this.mConfig.downloader = downloader;
        return this;
    }

    public FinalBitmap configLoadfailImage(int i) {
        this.mConfig.defaultDisplayConfig.setLoadfailBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), i));
        return this;
    }

    public FinalBitmap configLoadfailImage(Bitmap bitmap) {
        this.mConfig.defaultDisplayConfig.setLoadfailBitmap(bitmap);
        return this;
    }

    public FinalBitmap configLoadingImage(int i) {
        this.mConfig.defaultDisplayConfig.setLoadingBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), i));
        return this;
    }

    public FinalBitmap configLoadingImage(Bitmap bitmap) {
        this.mConfig.defaultDisplayConfig.setLoadingBitmap(bitmap);
        return this;
    }

    public FinalBitmap configMemoryCachePercent(float f) {
        this.mConfig.memCacheSizePercent = f;
        return this;
    }

    public FinalBitmap configMemoryCacheSize(int i) {
        this.mConfig.memCacheSize = i;
        return this;
    }

    public FinalBitmap configRecycleImmediately(boolean z) {
        this.mConfig.recycleImmediately = z;
        return this;
    }

    public void display(View view, String str) {
        doDisplay(view, str, null);
    }

    public void display(View view, String str, int i, int i2) {
        BitmapDisplayConfig bitmapDisplayConfig = (BitmapDisplayConfig) this.configMap.get(new StringBuilder(String.valueOf(i)).append("_").append(i2).toString());
        if (bitmapDisplayConfig == null) {
            bitmapDisplayConfig = getDisplayConfig();
            bitmapDisplayConfig.setBitmapHeight(i2);
            bitmapDisplayConfig.setBitmapWidth(i);
            this.configMap.put(new StringBuilder(String.valueOf(i)).append("_").append(i2).toString(), bitmapDisplayConfig);
        }
        doDisplay(view, str, bitmapDisplayConfig);
    }

    public void display(View view, String str, int i, int i2, Bitmap bitmap, Bitmap bitmap2) {
        BitmapDisplayConfig bitmapDisplayConfig = (BitmapDisplayConfig) this.configMap.get(new StringBuilder(String.valueOf(i)).append("_").append(i2).append("_").append(String.valueOf(bitmap)).append("_").append(String.valueOf(bitmap2)).toString());
        if (bitmapDisplayConfig == null) {
            bitmapDisplayConfig = getDisplayConfig();
            bitmapDisplayConfig.setBitmapHeight(i2);
            bitmapDisplayConfig.setBitmapWidth(i);
            bitmapDisplayConfig.setLoadingBitmap(bitmap);
            bitmapDisplayConfig.setLoadfailBitmap(bitmap2);
            this.configMap.put(new StringBuilder(String.valueOf(i)).append("_").append(i2).append("_").append(String.valueOf(bitmap)).append("_").append(String.valueOf(bitmap2)).toString(), bitmapDisplayConfig);
        }
        doDisplay(view, str, bitmapDisplayConfig);
    }

    public void display(View view, String str, Bitmap bitmap) {
        BitmapDisplayConfig bitmapDisplayConfig = (BitmapDisplayConfig) this.configMap.get(String.valueOf(bitmap));
        if (bitmapDisplayConfig == null) {
            bitmapDisplayConfig = getDisplayConfig();
            bitmapDisplayConfig.setLoadingBitmap(bitmap);
            this.configMap.put(String.valueOf(bitmap), bitmapDisplayConfig);
        }
        doDisplay(view, str, bitmapDisplayConfig);
    }

    public void display(View view, String str, Bitmap bitmap, Bitmap bitmap2) {
        BitmapDisplayConfig bitmapDisplayConfig = (BitmapDisplayConfig) this.configMap.get(String.valueOf(bitmap) + "_" + String.valueOf(bitmap2));
        if (bitmapDisplayConfig == null) {
            bitmapDisplayConfig = getDisplayConfig();
            bitmapDisplayConfig.setLoadingBitmap(bitmap);
            bitmapDisplayConfig.setLoadfailBitmap(bitmap2);
            this.configMap.put(String.valueOf(bitmap) + "_" + String.valueOf(bitmap2), bitmapDisplayConfig);
        }
        doDisplay(view, str, bitmapDisplayConfig);
    }

    public void display(View view, String str, BitmapDisplayConfig bitmapDisplayConfig) {
        doDisplay(view, str, bitmapDisplayConfig);
    }

    public void exitTasksEarly(boolean z) {
        this.mExitTasksEarly = z;
        if (z) {
            pauseWork(false);
        }
    }

    public Bitmap getBitmapFromCache(String str) {
        Bitmap bitmapFromMemoryCache = getBitmapFromMemoryCache(str);
        return bitmapFromMemoryCache == null ? getBitmapFromDiskCache(str) : bitmapFromMemoryCache;
    }

    public Bitmap getBitmapFromDiskCache(String str) {
        return getBitmapFromDiskCache(str, null);
    }

    public Bitmap getBitmapFromDiskCache(String str, BitmapDisplayConfig bitmapDisplayConfig) {
        return this.mBitmapProcess.getFromDisk(str, bitmapDisplayConfig);
    }

    public Bitmap getBitmapFromMemoryCache(String str) {
        return this.mImageCache.getBitmapFromMemoryCache(str);
    }

    public void onDestroy() {
        closeCache();
    }

    public void onPause() {
        setExitTasksEarly(true);
    }

    public void onResume() {
        setExitTasksEarly(false);
    }

    public void pauseWork(boolean z) {
        synchronized (this.mPauseWorkLock) {
            this.mPauseWork = z;
            if (!this.mPauseWork) {
                this.mPauseWorkLock.notifyAll();
            }
        }
    }

    public void setExitTasksEarly(boolean z) {
        this.mExitTasksEarly = z;
    }
}
