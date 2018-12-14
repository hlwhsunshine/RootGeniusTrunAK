package com.nostra13.universalimageloader.p057a.p058a.p059a.p060a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.nostra13.universalimageloader.p057a.p058a.C0979b;
import com.nostra13.universalimageloader.p057a.p058a.p059a.p060a.C0975a.C0972a;
import com.nostra13.universalimageloader.p057a.p058a.p061b.C0986a;
import com.nostra13.universalimageloader.p064b.C0998b;
import com.nostra13.universalimageloader.p064b.C0998b.C0997a;
import com.nostra13.universalimageloader.p064b.C0999c;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.nostra13.universalimageloader.a.a.a.a.d */
public final class C0980d implements C0979b {
    /* renamed from: a */
    public static final CompressFormat f2452a = CompressFormat.PNG;
    /* renamed from: b */
    protected C0975a f2453b;
    /* renamed from: c */
    protected final C0986a f2454c;
    /* renamed from: d */
    protected int f2455d = 32768;
    /* renamed from: e */
    protected CompressFormat f2456e = f2452a;
    /* renamed from: f */
    protected int f2457f = 100;
    /* renamed from: g */
    private File f2458g;

    public C0980d(File file, File file2, C0986a c0986a, long j, int i) {
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        } else if (j < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        } else if (i < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        } else if (c0986a == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        } else {
            long j2 = j == 0 ? Long.MAX_VALUE : j;
            int i2 = i == 0 ? Integer.MAX_VALUE : i;
            this.f2458g = file2;
            this.f2454c = c0986a;
            m2780a(file, file2, j2, i2);
        }
    }

    /* renamed from: a */
    private void m2780a(File file, File file2, long j, int i) {
        try {
            this.f2453b = C0975a.m2750a(file, j, i);
        } catch (Throwable e) {
            C0999c.m2832a(e);
            if (file2 != null) {
                m2780a(file2, null, j, i);
            }
            if (this.f2453b == null) {
                throw e;
            }
        }
    }

    /* renamed from: b */
    private String m2781b(String str) {
        return this.f2454c.mo6146a(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0028  */
    /* renamed from: a */
    public final java.io.File mo6140a(java.lang.String r4) {
        /*
        r3 = this;
        r0 = 0;
        r1 = r3.f2453b;	 Catch:{ IOException -> 0x0018, all -> 0x0023 }
        r2 = r3.m2781b(r4);	 Catch:{ IOException -> 0x0018, all -> 0x0023 }
        r2 = r1.mo6134a(r2);	 Catch:{ IOException -> 0x0018, all -> 0x0023 }
        if (r2 != 0) goto L_0x0013;
    L_0x000d:
        if (r2 == 0) goto L_0x0012;
    L_0x000f:
        r2.close();
    L_0x0012:
        return r0;
    L_0x0013:
        r0 = r2.mo6132a();	 Catch:{ IOException -> 0x002e }
        goto L_0x000d;
    L_0x0018:
        r1 = move-exception;
        r2 = r0;
    L_0x001a:
        com.nostra13.universalimageloader.p064b.C0999c.m2832a(r1);	 Catch:{ all -> 0x002c }
        if (r2 == 0) goto L_0x0012;
    L_0x001f:
        r2.close();
        goto L_0x0012;
    L_0x0023:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x0026:
        if (r2 == 0) goto L_0x002b;
    L_0x0028:
        r2.close();
    L_0x002b:
        throw r0;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0026;
    L_0x002e:
        r1 = move-exception;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.a.a.a.a.d.a(java.lang.String):java.io.File");
    }

    /* renamed from: a */
    public final boolean mo6141a(String str, Bitmap bitmap) {
        C0972a b = this.f2453b.mo6135b(m2781b(str));
        if (b == null) {
            return false;
        }
        Closeable bufferedOutputStream = new BufferedOutputStream(b.mo6126a(), this.f2455d);
        try {
            boolean compress = bitmap.compress(this.f2456e, this.f2457f, bufferedOutputStream);
            if (compress) {
                b.mo6127b();
                return compress;
            }
            b.mo6128c();
            return compress;
        } finally {
            C0998b.m2827a(bufferedOutputStream);
        }
    }

    /* renamed from: a */
    public final boolean mo6142a(String str, InputStream inputStream, C0997a c0997a) {
        C0972a b = this.f2453b.mo6135b(m2781b(str));
        if (b == null) {
            return false;
        }
        Closeable bufferedOutputStream = new BufferedOutputStream(b.mo6126a(), this.f2455d);
        try {
            boolean a = C0998b.m2829a(inputStream, bufferedOutputStream, c0997a, this.f2455d);
            C0998b.m2827a(bufferedOutputStream);
            if (a) {
                b.mo6127b();
                return a;
            }
            b.mo6128c();
            return a;
        } catch (Throwable th) {
            C0998b.m2827a(bufferedOutputStream);
            b.mo6128c();
        }
    }
}
