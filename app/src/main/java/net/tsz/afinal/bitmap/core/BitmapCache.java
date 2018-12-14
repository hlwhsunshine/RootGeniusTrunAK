package net.tsz.afinal.bitmap.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import net.tsz.afinal.utils.Utils;

public class BitmapCache {
    private static final int DEFAULT_DISK_CACHE_COUNT = 10000;
    private static final boolean DEFAULT_DISK_CACHE_ENABLED = true;
    private static final int DEFAULT_DISK_CACHE_SIZE = 52428800;
    private static final boolean DEFAULT_MEM_CACHE_ENABLED = true;
    private static final int DEFAULT_MEM_CACHE_SIZE = 8388608;
    private ImageCacheParams mCacheParams;
    private DiskCache mDiskCache;
    private IMemoryCache mMemoryCache;

    public static class ImageCacheParams {
        public int diskCacheCount = BitmapCache.DEFAULT_DISK_CACHE_COUNT;
        public File diskCacheDir;
        public boolean diskCacheEnabled = true;
        public int diskCacheSize = BitmapCache.DEFAULT_DISK_CACHE_SIZE;
        public int memCacheSize = 8388608;
        public boolean memoryCacheEnabled = true;
        public boolean recycleImmediately = true;

        public ImageCacheParams(File file) {
            this.diskCacheDir = file;
        }

        public ImageCacheParams(String str) {
            this.diskCacheDir = new File(str);
        }

        private static int getMemoryClass(Context context) {
            return ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        }

        public void setDiskCacheCount(int i) {
            this.diskCacheCount = i;
        }

        public void setDiskCacheSize(int i) {
            this.diskCacheSize = i;
        }

        public void setMemCacheSize(int i) {
            this.memCacheSize = i;
        }

        public void setMemCacheSizePercent(Context context, float f) {
            if (f < 0.05f || f > 0.8f) {
                throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)");
            }
            this.memCacheSize = Math.round(((((float) getMemoryClass(context)) * f) * 1024.0f) * 1024.0f);
        }

        public void setRecycleImmediately(boolean z) {
            this.recycleImmediately = z;
        }
    }

    public BitmapCache(ImageCacheParams imageCacheParams) {
        init(imageCacheParams);
    }

    private void init(ImageCacheParams imageCacheParams) {
        this.mCacheParams = imageCacheParams;
        if (this.mCacheParams.memoryCacheEnabled) {
            if (this.mCacheParams.recycleImmediately) {
                this.mMemoryCache = new SoftMemoryCacheImpl(this.mCacheParams.memCacheSize);
            } else {
                this.mMemoryCache = new BaseMemoryCacheImpl(this.mCacheParams.memCacheSize);
            }
        }
        if (imageCacheParams.diskCacheEnabled) {
            try {
                this.mDiskCache = new DiskCache(this.mCacheParams.diskCacheDir.getAbsolutePath(), this.mCacheParams.diskCacheCount, this.mCacheParams.diskCacheSize, false);
            } catch (IOException e) {
            }
        }
    }

    public void addToDiskCache(String str, byte[] bArr) {
        if (this.mDiskCache != null && str != null && bArr != null) {
            byte[] makeKey = Utils.makeKey(str);
            long crc64Long = Utils.crc64Long(makeKey);
            ByteBuffer allocate = ByteBuffer.allocate(makeKey.length + bArr.length);
            allocate.put(makeKey);
            allocate.put(bArr);
            synchronized (this.mDiskCache) {
                try {
                    this.mDiskCache.insert(crc64Long, allocate.array());
                } catch (IOException e) {
                }
            }
        }
    }

    public void addToMemoryCache(String str, Bitmap bitmap) {
        if (str != null && bitmap != null) {
            this.mMemoryCache.put(str, bitmap);
        }
    }

    public void clearCache() {
        clearMemoryCache();
        clearDiskCache();
    }

    public void clearCache(String str) {
        clearMemoryCache(str);
        clearDiskCache(str);
    }

    public void clearDiskCache() {
        if (this.mDiskCache != null) {
            this.mDiskCache.delete();
        }
    }

    public void clearDiskCache(String str) {
        addToDiskCache(str, new byte[0]);
    }

    public void clearMemoryCache() {
        if (this.mMemoryCache != null) {
            this.mMemoryCache.evictAll();
        }
    }

    public void clearMemoryCache(String str) {
        if (this.mMemoryCache != null) {
            this.mMemoryCache.remove(str);
        }
    }

    public void close() {
        if (this.mDiskCache != null) {
            this.mDiskCache.close();
        }
    }

    public Bitmap getBitmapFromMemoryCache(String str) {
        return this.mMemoryCache != null ? this.mMemoryCache.get(str) : null;
    }

    /* JADX WARNING: Missing block: B:19:0x0032, code:
            if (net.tsz.afinal.utils.Utils.isSameKey(r1, r4.buffer) == false) goto L_?;
     */
    /* JADX WARNING: Missing block: B:20:0x0034, code:
            r7.data = r4.buffer;
            r7.offset = r1.length;
            r7.length = r4.length - r7.offset;
     */
    /* JADX WARNING: Missing block: B:23:?, code:
            return false;
     */
    /* JADX WARNING: Missing block: B:24:?, code:
            return true;
     */
    public boolean getImageData(java.lang.String r6, net.tsz.afinal.bitmap.core.BytesBufferPool.BytesBuffer r7) {
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.mDiskCache;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r1 = net.tsz.afinal.utils.Utils.makeKey(r6);
        r2 = net.tsz.afinal.utils.Utils.crc64Long(r1);
        r4 = new net.tsz.afinal.bitmap.core.DiskCache$LookupRequest;	 Catch:{ IOException -> 0x0029 }
        r4.<init>();	 Catch:{ IOException -> 0x0029 }
        r4.key = r2;	 Catch:{ IOException -> 0x0029 }
        r2 = r7.data;	 Catch:{ IOException -> 0x0029 }
        r4.buffer = r2;	 Catch:{ IOException -> 0x0029 }
        r2 = r5.mDiskCache;	 Catch:{ IOException -> 0x0029 }
        monitor-enter(r2);	 Catch:{ IOException -> 0x0029 }
        r3 = r5.mDiskCache;	 Catch:{ all -> 0x0026 }
        r3 = r3.lookup(r4);	 Catch:{ all -> 0x0026 }
        if (r3 != 0) goto L_0x002b;
    L_0x0024:
        monitor-exit(r2);	 Catch:{ all -> 0x0026 }
        goto L_0x0005;
    L_0x0026:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0026 }
        throw r1;	 Catch:{ IOException -> 0x0029 }
    L_0x0029:
        r1 = move-exception;
        goto L_0x0005;
    L_0x002b:
        monitor-exit(r2);	 Catch:{ all -> 0x0026 }
        r2 = r4.buffer;	 Catch:{ IOException -> 0x0029 }
        r2 = net.tsz.afinal.utils.Utils.isSameKey(r1, r2);	 Catch:{ IOException -> 0x0029 }
        if (r2 == 0) goto L_0x0005;
    L_0x0034:
        r2 = r4.buffer;	 Catch:{ IOException -> 0x0029 }
        r7.data = r2;	 Catch:{ IOException -> 0x0029 }
        r1 = r1.length;	 Catch:{ IOException -> 0x0029 }
        r7.offset = r1;	 Catch:{ IOException -> 0x0029 }
        r1 = r4.length;	 Catch:{ IOException -> 0x0029 }
        r2 = r7.offset;	 Catch:{ IOException -> 0x0029 }
        r1 = r1 - r2;
        r7.length = r1;	 Catch:{ IOException -> 0x0029 }
        r0 = 1;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.tsz.afinal.bitmap.core.BitmapCache.getImageData(java.lang.String, net.tsz.afinal.bitmap.core.BytesBufferPool$BytesBuffer):boolean");
    }
}
