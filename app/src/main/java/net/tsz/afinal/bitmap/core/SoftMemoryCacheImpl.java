package net.tsz.afinal.bitmap.core;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import net.tsz.afinal.utils.Utils;

public class SoftMemoryCacheImpl implements IMemoryCache {
    private final LruMemoryCache<String, SoftReference<Bitmap>> mMemoryCache;

    public SoftMemoryCacheImpl(int i) {
        this.mMemoryCache = new LruMemoryCache<String, SoftReference<Bitmap>>(i) {
            protected int sizeOf(String str, SoftReference<Bitmap> softReference) {
                Bitmap bitmap = softReference == null ? null : (Bitmap) softReference.get();
                return bitmap == null ? 1 : Utils.getBitmapSize(bitmap);
            }
        };
    }

    public void evictAll() {
        this.mMemoryCache.evictAll();
    }

    public Bitmap get(String str) {
        SoftReference softReference = (SoftReference) this.mMemoryCache.get(str);
        return softReference != null ? (Bitmap) softReference.get() : null;
    }

    public void put(String str, Bitmap bitmap) {
        this.mMemoryCache.put(str, new SoftReference(bitmap));
    }

    public void remove(String str) {
        this.mMemoryCache.remove(str);
    }
}
