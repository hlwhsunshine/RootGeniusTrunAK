package net.tsz.afinal.bitmap.core;

import android.graphics.Bitmap;
import net.tsz.afinal.utils.Utils;

public class BaseMemoryCacheImpl implements IMemoryCache {
    private final LruMemoryCache<String, Bitmap> mMemoryCache;

    public BaseMemoryCacheImpl(int i) {
        this.mMemoryCache = new LruMemoryCache<String, Bitmap>(i) {
            protected int sizeOf(String str, Bitmap bitmap) {
                return Utils.getBitmapSize(bitmap);
            }
        };
    }

    public void evictAll() {
        this.mMemoryCache.evictAll();
    }

    public Bitmap get(String str) {
        return (Bitmap) this.mMemoryCache.get(str);
    }

    public void put(String str, Bitmap bitmap) {
        this.mMemoryCache.put(str, bitmap);
    }

    public void remove(String str) {
        this.mMemoryCache.remove(str);
    }
}
