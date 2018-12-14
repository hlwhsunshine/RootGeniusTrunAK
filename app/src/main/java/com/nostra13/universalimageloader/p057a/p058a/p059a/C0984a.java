package com.nostra13.universalimageloader.p057a.p058a.p059a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.nostra13.universalimageloader.p057a.p058a.C0979b;
import com.nostra13.universalimageloader.p057a.p058a.p061b.C0986a;
import com.nostra13.universalimageloader.p064b.C0998b;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;

/* renamed from: com.nostra13.universalimageloader.a.a.a.a */
public abstract class C0984a implements C0979b {
    /* renamed from: a */
    public static final CompressFormat f2467a = CompressFormat.PNG;
    /* renamed from: b */
    protected final File f2468b;
    /* renamed from: c */
    protected final File f2469c;
    /* renamed from: d */
    protected final C0986a f2470d;
    /* renamed from: e */
    protected int f2471e = 32768;
    /* renamed from: f */
    protected CompressFormat f2472f = f2467a;
    /* renamed from: g */
    protected int f2473g = 100;

    public C0984a(File file, File file2, C0986a c0986a) {
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        } else if (c0986a == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        } else {
            this.f2468b = file;
            this.f2469c = file2;
            this.f2470d = c0986a;
        }
    }

    /* renamed from: b */
    private File m2790b(String str) {
        String a = this.f2470d.mo6146a(str);
        File file = this.f2468b;
        if (!(this.f2468b.exists() || this.f2468b.mkdirs() || this.f2469c == null || (!this.f2469c.exists() && !this.f2469c.mkdirs()))) {
            file = this.f2469c;
        }
        return new File(file, a);
    }

    /* renamed from: a */
    public final File mo6140a(String str) {
        return m2790b(str);
    }

    /* renamed from: a */
    public final boolean mo6141a(String str, Bitmap bitmap) {
        File b = m2790b(str);
        File file = new File(b.getAbsolutePath() + ".tmp");
        Closeable bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.f2471e);
        try {
            boolean compress = bitmap.compress(this.f2472f, this.f2473g, bufferedOutputStream);
            C0998b.m2827a(bufferedOutputStream);
            if (compress && !file.renameTo(b)) {
                compress = false;
            }
            if (!compress) {
                file.delete();
            }
            bitmap.recycle();
            return compress;
        } catch (Throwable th) {
            C0998b.m2827a(bufferedOutputStream);
            file.delete();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x005d  */
    /* renamed from: a */
    public final boolean mo6142a(java.lang.String r7, java.io.InputStream r8, com.nostra13.universalimageloader.p064b.C0998b.C0997a r9) {
        /*
        r6 = this;
        r2 = 0;
        r3 = r6.m2790b(r7);
        r4 = new java.io.File;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r3.getAbsolutePath();
        r0 = r0.append(r1);
        r1 = ".tmp";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r4.<init>(r0);
        r5 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x004d }
        r0 = new java.io.FileOutputStream;	 Catch:{ all -> 0x004d }
        r0.<init>(r4);	 Catch:{ all -> 0x004d }
        r1 = r6.f2471e;	 Catch:{ all -> 0x004d }
        r5.<init>(r0, r1);	 Catch:{ all -> 0x004d }
        r0 = r6.f2471e;	 Catch:{ all -> 0x0048 }
        r1 = com.nostra13.universalimageloader.p064b.C0998b.m2829a(r8, r5, r9, r0);	 Catch:{ all -> 0x0048 }
        com.nostra13.universalimageloader.p064b.C0998b.m2827a(r5);	 Catch:{ all -> 0x0061 }
        com.nostra13.universalimageloader.p064b.C0998b.m2827a(r8);
        if (r1 == 0) goto L_0x0042;
    L_0x003b:
        r0 = r4.renameTo(r3);
        if (r0 != 0) goto L_0x0042;
    L_0x0041:
        r1 = r2;
    L_0x0042:
        if (r1 != 0) goto L_0x0047;
    L_0x0044:
        r4.delete();
    L_0x0047:
        return r1;
    L_0x0048:
        r0 = move-exception;
        com.nostra13.universalimageloader.p064b.C0998b.m2827a(r5);	 Catch:{ all -> 0x004d }
        throw r0;	 Catch:{ all -> 0x004d }
    L_0x004d:
        r0 = move-exception;
        r1 = r2;
    L_0x004f:
        com.nostra13.universalimageloader.p064b.C0998b.m2827a(r8);
        if (r1 == 0) goto L_0x005b;
    L_0x0054:
        r3 = r4.renameTo(r3);
        if (r3 != 0) goto L_0x005b;
    L_0x005a:
        r1 = r2;
    L_0x005b:
        if (r1 != 0) goto L_0x0060;
    L_0x005d:
        r4.delete();
    L_0x0060:
        throw r0;
    L_0x0061:
        r0 = move-exception;
        goto L_0x004f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.a.a.a.a.a(java.lang.String, java.io.InputStream, com.nostra13.universalimageloader.b.b$a):boolean");
    }
}
