package com.nostra13.universalimageloader.p057a.p062b.p063a;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.p057a.p062b.C0990b;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* renamed from: com.nostra13.universalimageloader.a.b.a.b */
public final class C0992b implements C0990b {
    /* renamed from: a */
    private final LinkedHashMap<String, Bitmap> f2476a;
    /* renamed from: b */
    private final int f2477b;
    /* renamed from: c */
    private int f2478c;

    public C0992b(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f2477b = i;
        this.f2476a = new LinkedHashMap(0, 0.75f, true);
    }

    /* renamed from: a */
    private static int m2807a(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* renamed from: a */
    private Bitmap m2808a(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        Bitmap bitmap;
        synchronized (this) {
            bitmap = (Bitmap) this.f2476a.get(str);
        }
        return bitmap;
    }

    /* JADX WARNING: Missing block: B:9:0x0031, code:
            throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* renamed from: a */
    private void m2809a(int r4) {
        /*
        r3 = this;
    L_0x0000:
        monitor-enter(r3);
        r0 = r3.f2478c;	 Catch:{ all -> 0x0032 }
        if (r0 < 0) goto L_0x0011;
    L_0x0005:
        r0 = r3.f2476a;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x000d:
        r0 = r3.f2478c;	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x0011:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0032 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = r3.getClass();	 Catch:{ all -> 0x0032 }
        r2 = r2.getName();	 Catch:{ all -> 0x0032 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r2 = ".sizeOf() is reporting inconsistent results!";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r1 = r1.toString();	 Catch:{ all -> 0x0032 }
        r0.<init>(r1);	 Catch:{ all -> 0x0032 }
        throw r0;	 Catch:{ all -> 0x0032 }
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        throw r0;
    L_0x0035:
        r0 = r3.f2478c;	 Catch:{ all -> 0x0032 }
        if (r0 <= r4) goto L_0x0041;
    L_0x0039:
        r0 = r3.f2476a;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0043;
    L_0x0041:
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
    L_0x0042:
        return;
    L_0x0043:
        r0 = r3.f2476a;	 Catch:{ all -> 0x0032 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0032 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0032 }
        r0 = r0.next();	 Catch:{ all -> 0x0032 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0032 }
        if (r0 != 0) goto L_0x0057;
    L_0x0055:
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        goto L_0x0042;
    L_0x0057:
        r1 = r0.getKey();	 Catch:{ all -> 0x0032 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0032 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0032 }
        r0 = (android.graphics.Bitmap) r0;	 Catch:{ all -> 0x0032 }
        r2 = r3.f2476a;	 Catch:{ all -> 0x0032 }
        r2.remove(r1);	 Catch:{ all -> 0x0032 }
        r1 = r3.f2478c;	 Catch:{ all -> 0x0032 }
        r0 = com.nostra13.universalimageloader.p057a.p062b.p063a.C0992b.m2807a(r0);	 Catch:{ all -> 0x0032 }
        r0 = r1 - r0;
        r3.f2478c = r0;	 Catch:{ all -> 0x0032 }
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.a.b.a.b.a(int):void");
    }

    /* renamed from: a */
    private boolean m2810a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f2478c += C0992b.m2807a(bitmap);
            Bitmap bitmap2 = (Bitmap) this.f2476a.put(str, bitmap);
            if (bitmap2 != null) {
                this.f2478c -= C0992b.m2807a(bitmap2);
            }
        }
        m2809a(this.f2477b);
        return true;
    }

    /* renamed from: b */
    private Bitmap m2811b(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        Bitmap bitmap;
        synchronized (this) {
            bitmap = (Bitmap) this.f2476a.remove(str);
            if (bitmap != null) {
                this.f2478c -= C0992b.m2807a(bitmap);
            }
        }
        return bitmap;
    }

    /* renamed from: a */
    public final Collection<String> mo6148a() {
        Collection hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f2476a.keySet());
        }
        return hashSet;
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", new Object[]{Integer.valueOf(this.f2477b)});
    }
}
