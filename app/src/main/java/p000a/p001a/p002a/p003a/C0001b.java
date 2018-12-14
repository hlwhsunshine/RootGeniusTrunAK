package p000a.p001a.p002a.p003a;

import com.shuame.rootgenius.sdk.C1468c;
import java.io.File;
import java.util.ArrayList;
import p000a.p001a.p002a.p007c.C0010a;
import p000a.p001a.p002a.p009e.C0020f;
import p000a.p001a.p002a.p009e.C0026l;
import p000a.p001a.p002a.p010f.C0027a;
import p000a.p001a.p002a.p011g.C0028a;

/* renamed from: a.a.a.a.b */
public final class C0001b {
    /* renamed from: a */
    private String f2a;
    /* renamed from: b */
    private int f3b;
    /* renamed from: c */
    private C0026l f4c;
    /* renamed from: d */
    private boolean f5d;
    /* renamed from: e */
    private C0027a f6e;
    /* renamed from: f */
    private boolean f7f;

    private C0001b(File file) {
        this.f2a = file.getPath();
        this.f3b = 2;
        this.f6e = new C0027a();
        this.f7f = false;
    }

    public C0001b(String str) {
        this(new File(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0065 A:{SYNTHETIC, Splitter: B:30:0x0065} */
    /* renamed from: b */
    private void m12b() {
        /*
        r4 = this;
        r0 = r4.f2a;
        r0 = com.shuame.rootgenius.sdk.C1468c.m4064d(r0);
        if (r0 != 0) goto L_0x0010;
    L_0x0008:
        r0 = new a.a.a.c.a;
        r1 = "zip file does not exist";
        r0.<init>(r1);
        throw r0;
    L_0x0010:
        r0 = r4.f2a;
        r0 = com.shuame.rootgenius.sdk.C1468c.m4062c(r0);
        if (r0 != 0) goto L_0x0020;
    L_0x0018:
        r0 = new a.a.a.c.a;
        r1 = "no read access for the input zip file";
        r0.<init>(r1);
        throw r0;
    L_0x0020:
        r0 = r4.f3b;
        r1 = 2;
        if (r0 == r1) goto L_0x002d;
    L_0x0025:
        r0 = new a.a.a.c.a;
        r1 = "Invalid mode";
        r0.<init>(r1);
        throw r0;
    L_0x002d:
        r2 = 0;
        r1 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x005a, all -> 0x006d }
        r0 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x005a, all -> 0x006d }
        r3 = r4.f2a;	 Catch:{ FileNotFoundException -> 0x005a, all -> 0x006d }
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x005a, all -> 0x006d }
        r3 = "r";
        r1.<init>(r0, r3);	 Catch:{ FileNotFoundException -> 0x005a, all -> 0x006d }
        r0 = r4.f4c;	 Catch:{ FileNotFoundException -> 0x0070 }
        if (r0 != 0) goto L_0x0056;
    L_0x0040:
        r0 = new a.a.a.a.a;	 Catch:{ FileNotFoundException -> 0x0070 }
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0070 }
        r0 = r0.mo2a();	 Catch:{ FileNotFoundException -> 0x0070 }
        r4.f4c = r0;	 Catch:{ FileNotFoundException -> 0x0070 }
        r0 = r4.f4c;	 Catch:{ FileNotFoundException -> 0x0070 }
        if (r0 == 0) goto L_0x0056;
    L_0x004f:
        r0 = r4.f4c;	 Catch:{ FileNotFoundException -> 0x0070 }
        r2 = r4.f2a;	 Catch:{ FileNotFoundException -> 0x0070 }
        r0.mo143a(r2);	 Catch:{ FileNotFoundException -> 0x0070 }
    L_0x0056:
        r1.close();	 Catch:{ IOException -> 0x006b }
    L_0x0059:
        return;
    L_0x005a:
        r0 = move-exception;
        r1 = r2;
    L_0x005c:
        r2 = new a.a.a.c.a;	 Catch:{ all -> 0x0062 }
        r2.<init>(r0);	 Catch:{ all -> 0x0062 }
        throw r2;	 Catch:{ all -> 0x0062 }
    L_0x0062:
        r0 = move-exception;
    L_0x0063:
        if (r1 == 0) goto L_0x0068;
    L_0x0065:
        r1.close();	 Catch:{ IOException -> 0x0069 }
    L_0x0068:
        throw r0;
    L_0x0069:
        r1 = move-exception;
        goto L_0x0068;
    L_0x006b:
        r0 = move-exception;
        goto L_0x0059;
    L_0x006d:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0063;
    L_0x0070:
        r0 = move-exception;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.b():void");
    }

    /* renamed from: a */
    public final void mo3a(String str) {
        if (C1468c.m4056a(str)) {
            C1468c.m4060b(str);
            if (this.f4c == null) {
                m12b();
            }
            if (this.f4c == null) {
                throw new C0010a("Internal error occurred when extracting zip file");
            } else if (this.f6e.mo155a() == 1) {
                throw new C0010a("invalid operation - Zip4j is in busy state");
            } else {
                new C0028a(this.f4c).mo160a(str, this.f6e);
                return;
            }
        }
        throw new C0010a("output path is null or invalid");
    }

    /* renamed from: a */
    public final void mo4a(char[] cArr) {
        if (this.f4c == null) {
            m12b();
            if (this.f4c == null) {
                throw new C0010a("Zip Model is null");
            }
        }
        if (this.f4c.mo138a() == null || this.f4c.mo138a().mo42a() == null) {
            throw new C0010a("invalid zip file");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f4c.mo138a().mo42a().size()) {
                if (this.f4c.mo138a().mo42a().get(i2) != null && ((C0020f) this.f4c.mo138a().mo42a().get(i2)).mo84l()) {
                    ((C0020f) this.f4c.mo138a().mo42a().get(i2)).mo65a(cArr);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public final boolean mo5a() {
        if (this.f4c == null) {
            m12b();
            if (this.f4c == null) {
                throw new C0010a("Zip Model is null");
            }
        }
        if (this.f4c.mo138a() == null || this.f4c.mo138a().mo42a() == null) {
            throw new C0010a("invalid zip file");
        }
        ArrayList a = this.f4c.mo138a().mo42a();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < a.size()) {
                C0020f c0020f = (C0020f) a.get(i2);
                if (c0020f != null && c0020f.mo84l()) {
                    this.f5d = true;
                    break;
                }
                i = i2 + 1;
            } else {
                break;
            }
        }
        return this.f5d;
    }
}
