package p000a.p001a.p002a.p011g;

import p000a.p001a.p002a.p007c.C0010a;
import p000a.p001a.p002a.p009e.C0026l;

/* renamed from: a.a.a.g.a */
public final class C0028a {
    /* renamed from: a */
    private C0026l f123a;

    public C0028a(C0026l c0026l) {
        if (c0026l == null) {
            throw new C0010a("ZipModel is null");
        }
        this.f123a = c0026l;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2 A:{ExcHandler: a.a.a.c.a (r0_22 'e' a.a.a.c.a), Splitter: B:28:0x0079} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2 A:{ExcHandler: a.a.a.c.a (r0_22 'e' a.a.a.c.a), Splitter: B:28:0x0079} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2 A:{ExcHandler: a.a.a.c.a (r0_22 'e' a.a.a.c.a), Splitter: B:28:0x0079} */
    /* JADX WARNING: Missing block: B:45:0x00d2, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:46:0x00d3, code:
            r14.mo159c();
     */
    /* JADX WARNING: Missing block: B:47:0x00d6, code:
            throw r0;
     */
    /* renamed from: a */
    public final void mo160a(java.lang.String r13, p000a.p001a.p002a.p010f.C0027a r14) {
        /*
        r12 = this;
        r4 = 0;
        r8 = 0;
        r7 = 0;
        r0 = r12.f123a;
        r0 = r0.mo138a();
        if (r0 == 0) goto L_0x0012;
    L_0x000c:
        r1 = r0.mo42a();
        if (r1 != 0) goto L_0x001a;
    L_0x0012:
        r0 = new a.a.a.c.a;
        r1 = "invalid central directory in zipModel";
        r0.<init>(r1);
        throw r0;
    L_0x001a:
        r9 = r0.mo42a();
        if (r9 != 0) goto L_0x0028;
    L_0x0020:
        r0 = new a.a.a.c.a;
        r1 = "fileHeaders is null, cannot calculate total work";
        r0.<init>(r1);
        throw r0;
    L_0x0028:
        r2 = r4;
        r6 = r7;
    L_0x002a:
        r0 = r9.size();
        if (r6 < r0) goto L_0x003d;
    L_0x0030:
        r14.mo156a(r2);
        r14.mo157b();
    L_0x0036:
        r0 = r9.size();
        if (r7 < r0) goto L_0x0069;
    L_0x003c:
        return;
    L_0x003d:
        r0 = r9.get(r6);
        r0 = (p000a.p001a.p002a.p009e.C0020f) r0;
        r1 = r0.mo91s();
        if (r1 == 0) goto L_0x0063;
    L_0x0049:
        r1 = r0.mo91s();
        r10 = r1.mo133b();
        r1 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r1 <= 0) goto L_0x0063;
    L_0x0055:
        r0 = r0.mo91s();
        r0 = r0.mo130a();
        r0 = r0 + r2;
    L_0x005e:
        r2 = r6 + 1;
        r6 = r2;
        r2 = r0;
        goto L_0x002a;
    L_0x0063:
        r0 = r0.mo74d();
        r0 = r0 + r2;
        goto L_0x005e;
    L_0x0069:
        r0 = r9.get(r7);
        r0 = (p000a.p001a.p002a.p009e.C0020f) r0;
        if (r0 != 0) goto L_0x0079;
    L_0x0071:
        r0 = new a.a.a.c.a;
        r1 = "fileHeader is null";
        r0.<init>(r1);
        throw r0;
    L_0x0079:
        r1 = p000a.p001a.p002a.p012h.C0030a.f130a;	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r1 = r13.endsWith(r1);	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        if (r1 != 0) goto L_0x0148;
    L_0x0081:
        r1 = new java.lang.StringBuffer;	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r2 = java.lang.String.valueOf(r13);	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r1.<init>(r2);	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r2 = p000a.p001a.p002a.p012h.C0030a.f130a;	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r1 = r1.append(r2);	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r1 = r1.toString();	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r2 = r1;
    L_0x0095:
        r1 = r0.mo83k();	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        if (r1 == 0) goto L_0x00d7;
    L_0x009b:
        r0 = r0.mo82j();	 Catch:{ Exception -> 0x00c8, a -> 0x00d2 }
        r1 = com.shuame.rootgenius.sdk.C1468c.m4056a(r0);	 Catch:{ Exception -> 0x00c8, a -> 0x00d2 }
        if (r1 != 0) goto L_0x00a8;
    L_0x00a5:
        r7 = r7 + 1;
        goto L_0x0036;
    L_0x00a8:
        r1 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x00c8, a -> 0x00d2 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Exception -> 0x00c8, a -> 0x00d2 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x00c8, a -> 0x00d2 }
        r0 = r1.append(r0);	 Catch:{ Exception -> 0x00c8, a -> 0x00d2 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00c8, a -> 0x00d2 }
        r1 = new java.io.File;	 Catch:{ Exception -> 0x00c8, a -> 0x00d2 }
        r1.<init>(r0);	 Catch:{ Exception -> 0x00c8, a -> 0x00d2 }
        r0 = r1.exists();	 Catch:{ Exception -> 0x00c8, a -> 0x00d2 }
        if (r0 != 0) goto L_0x00a5;
    L_0x00c4:
        r1.mkdirs();	 Catch:{ Exception -> 0x00c8, a -> 0x00d2 }
        goto L_0x00a5;
    L_0x00c8:
        r0 = move-exception;
        r14.mo159c();	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r1 = new a.a.a.c.a;	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r1.<init>(r0);	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        throw r1;	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
    L_0x00d2:
        r0 = move-exception;
        r14.mo159c();
        throw r0;
    L_0x00d7:
        if (r0 == 0) goto L_0x00df;
    L_0x00d9:
        r1 = com.shuame.rootgenius.sdk.C1468c.m4056a(r2);	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        if (r1 != 0) goto L_0x00f1;
    L_0x00df:
        r0 = new a.a.a.c.a;	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r1 = "Cannot check output directory structure...one of the parameters was null";
        r0.<init>(r1);	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        throw r0;	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
    L_0x00e7:
        r0 = move-exception;
        r14.mo159c();
        r1 = new a.a.a.c.a;
        r1.<init>(r0);
        throw r1;
    L_0x00f1:
        r1 = r0.mo82j();	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r3 = 0;
        r3 = com.shuame.rootgenius.sdk.C1468c.m4056a(r3);	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        if (r3 == 0) goto L_0x00fd;
    L_0x00fc:
        r1 = r8;
    L_0x00fd:
        r3 = com.shuame.rootgenius.sdk.C1468c.m4056a(r1);	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        if (r3 == 0) goto L_0x012b;
    L_0x0103:
        r3 = new java.lang.StringBuffer;	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r4 = java.lang.String.valueOf(r2);	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r3.<init>(r4);	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r1 = r3.append(r1);	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r1 = r1.toString();	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x0141, a -> 0x00d2 }
        r3.<init>(r1);	 Catch:{ Exception -> 0x0141, a -> 0x00d2 }
        r1 = r3.getParent();	 Catch:{ Exception -> 0x0141, a -> 0x00d2 }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x0141, a -> 0x00d2 }
        r3.<init>(r1);	 Catch:{ Exception -> 0x0141, a -> 0x00d2 }
        r1 = r3.exists();	 Catch:{ Exception -> 0x0141, a -> 0x00d2 }
        if (r1 != 0) goto L_0x012b;
    L_0x0128:
        r3.mkdirs();	 Catch:{ Exception -> 0x0141, a -> 0x00d2 }
    L_0x012b:
        r1 = new a.a.a.g.b;	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r3 = r12.f123a;	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r1.<init>(r3, r0);	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r1.mo163a(r14, r2);	 Catch:{ Exception -> 0x0137, a -> 0x00d2 }
        goto L_0x00a5;
    L_0x0137:
        r0 = move-exception;
        r14.mo159c();	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r1 = new a.a.a.c.a;	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r1.<init>(r0);	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        throw r1;	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
    L_0x0141:
        r0 = move-exception;
        r1 = new a.a.a.c.a;	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        r1.<init>(r0);	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
        throw r1;	 Catch:{ a -> 0x00d2, Exception -> 0x00e7 }
    L_0x0148:
        r2 = r13;
        goto L_0x0095;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.g.a.a(java.lang.String, a.a.a.f.a):void");
    }
}
