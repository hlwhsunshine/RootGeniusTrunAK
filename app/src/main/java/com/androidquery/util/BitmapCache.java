package com.androidquery.util;

import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class BitmapCache extends LinkedHashMap<String, Bitmap> {
    private static final long serialVersionUID = 1;
    private int maxCount;
    private int maxPixels;
    private int maxTotalPixels;
    private int pixels;

    public BitmapCache(int i, int i2, int i3) {
        super(8, 0.75f, true);
        this.maxCount = i;
        this.maxPixels = i2;
        this.maxTotalPixels = i3;
    }

    private int pixels(Bitmap bitmap) {
        return bitmap == null ? 0 : bitmap.getWidth() * bitmap.getHeight();
    }

    private void shrink() {
        if (this.pixels > this.maxTotalPixels) {
            Iterator it = keySet().iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
                if (this.pixels <= this.maxTotalPixels) {
                    return;
                }
            }
        }
    }

    public void clear() {
        super.clear();
        this.pixels = 0;
    }

    public Bitmap put(String str, Bitmap bitmap) {
        Bitmap bitmap2 = null;
        int pixels = pixels(bitmap);
        if (pixels <= this.maxPixels) {
            this.pixels += pixels;
            bitmap2 = (Bitmap) super.put(str, bitmap);
            if (bitmap2 != null) {
                this.pixels -= pixels(bitmap2);
            }
        }
        return bitmap2;
    }

    public Bitmap remove(Object obj) {
        Bitmap bitmap = (Bitmap) super.remove(obj);
        if (bitmap != null) {
            this.pixels -= pixels(bitmap);
        }
        return bitmap;
    }

    public boolean removeEldestEntry(Entry<String, Bitmap> entry) {
        if (this.pixels > this.maxTotalPixels || size() > this.maxCount) {
            remove(entry.getKey());
        }
        shrink();
        return false;
    }
}
