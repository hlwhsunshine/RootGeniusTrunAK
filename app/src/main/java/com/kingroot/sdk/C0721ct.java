package com.kingroot.sdk;

import android.content.Context;
import android.os.Handler;
import com.kingroot.sdk.util.C0886f;
import krsdk.C1773a;
import krsdk.RootConfig;
import krsdk.RootShell;

/* renamed from: com.kingroot.sdk.ct */
abstract class C0721ct implements C0720dh {
    /* renamed from: el */
    protected Context f1732el;
    /* renamed from: em */
    protected RootConfig f1733em;
    /* renamed from: en */
    protected C0626ap f1734en;
    /* renamed from: eo */
    protected String f1735eo;
    /* renamed from: ep */
    protected int f1736ep = 1;
    protected Handler handler;

    public C0721ct(Context context, Handler handler, RootConfig rootConfig, C0626ap c0626ap) {
        this.f1732el = context;
        this.handler = handler;
        this.f1733em = rootConfig;
        this.f1734en = c0626ap;
        this.f1735eo = rootConfig.mo8167a("play");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0109  */
    /* renamed from: aB */
    public boolean mo5698aB() {
        /*
        r9 = this;
        r6 = 1;
        r7 = 0;
        r0 = "beforeRoot()...";
        com.kingroot.sdk.C0633at.m1464h(r0);
        r0 = r9.f1735eo;
        com.kingroot.sdk.util.C0883c.m2388X(r0);
        r0 = new java.io.File;
        r1 = r9.f1735eo;
        r0.<init>(r1);
        r0.mkdirs();
        r0 = r9.f1733em;
        r1 = new java.lang.String[r6];
        r2 = "superuser.apk";
        r1[r7] = r2;
        r0 = r0.mo8167a(r1);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r9.f1735eo;
        r1 = r1.append(r2);
        r2 = "/Kinguser.apk";
        r1 = r1.append(r2);
        r3 = r1.toString();
        r1 = r9.f1733em;
        r2 = new java.lang.String[r6];
        r4 = "superuser.apk";
        r2[r7] = r4;
        r4 = r1.mo8167a(r2);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r9.f1735eo;
        r1 = r1.append(r2);
        r2 = "/Superuser.apk";
        r1 = r1.append(r2);
        r5 = r1.toString();
        r1 = r9.f1733em;
        r2 = new java.lang.String[r6];
        r6 = "su";
        r2[r7] = r6;
        r6 = r1.mo8167a(r2);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r9.f1735eo;
        r1 = r1.append(r2);
        r2 = "/su";
        r1 = r1.append(r2);
        r7 = r1.toString();
        r2 = 0;
        r1 = new com.kingroot.sdk.av;	 Catch:{ Throwable -> 0x0100, all -> 0x010d }
        r8 = "sh";
        r1.<init>(r8);	 Catch:{ Throwable -> 0x0100, all -> 0x010d }
        r2 = "export PATH=/sbin:/vendor/bin:/system/sbin:/system/bin:/system/xbin:$PATH";
        r1.mo5609t(r2);	 Catch:{ Throwable -> 0x0117 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0117 }
        r8 = "cat ";
        r2.<init>(r8);	 Catch:{ Throwable -> 0x0117 }
        r0 = r2.append(r0);	 Catch:{ Throwable -> 0x0117 }
        r2 = " > ";
        r0 = r0.append(r2);	 Catch:{ Throwable -> 0x0117 }
        r0 = r0.append(r3);	 Catch:{ Throwable -> 0x0117 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0117 }
        r1.mo5609t(r0);	 Catch:{ Throwable -> 0x0117 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0117 }
        r2 = "cat ";
        r0.<init>(r2);	 Catch:{ Throwable -> 0x0117 }
        r0 = r0.append(r6);	 Catch:{ Throwable -> 0x0117 }
        r2 = " > ";
        r0 = r0.append(r2);	 Catch:{ Throwable -> 0x0117 }
        r0 = r0.append(r7);	 Catch:{ Throwable -> 0x0117 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0117 }
        r1.mo5609t(r0);	 Catch:{ Throwable -> 0x0117 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0117 }
        r2 = "cat ";
        r0.<init>(r2);	 Catch:{ Throwable -> 0x0117 }
        r0 = r0.append(r4);	 Catch:{ Throwable -> 0x0117 }
        r2 = " > ";
        r0 = r0.append(r2);	 Catch:{ Throwable -> 0x0117 }
        r0 = r0.append(r5);	 Catch:{ Throwable -> 0x0117 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0117 }
        r1.mo5609t(r0);	 Catch:{ Throwable -> 0x0117 }
        r1.shutdown();
    L_0x00dd:
        r0 = r9.f1734en;
        r1 = r9.f1735eo;
        r0 = com.kingroot.sdk.C0749dk.m1833a(r0, r1);
        r1 = new java.lang.StringBuilder;
        r2 = "ls -lZ ";
        r1.<init>(r2);
        r2 = r9.f1735eo;
        r1 = r1.append(r2);
        r2 = "/";
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.kingroot.sdk.util.C0898r.m2468ad(r1);
        return r0;
    L_0x0100:
        r0 = move-exception;
        r1 = r2;
    L_0x0102:
        r2 = "复制KU异常";
        com.kingroot.sdk.C0633at.m1458a(r2, r0);	 Catch:{ all -> 0x0115 }
        if (r1 == 0) goto L_0x00dd;
    L_0x0109:
        r1.shutdown();
        goto L_0x00dd;
    L_0x010d:
        r0 = move-exception;
        r1 = r2;
    L_0x010f:
        if (r1 == 0) goto L_0x0114;
    L_0x0111:
        r1.shutdown();
    L_0x0114:
        throw r0;
    L_0x0115:
        r0 = move-exception;
        goto L_0x010f;
    L_0x0117:
        r0 = move-exception;
        goto L_0x0102;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.ct.aB():boolean");
    }

    /* renamed from: aC */
    public C0719cs mo5699aC() {
        C0719cs b = C0731cz.m1768b(this.f1733em.mo8167a("kd"), 5);
        int aI = b != null ? b.mo5707aI() : 0;
        C0760dt.m1855E(this.f1732el).mo5759a("RETRY_KD_SHELL", b != null ? 0 : 1, C0886f.m2424bj(), C0886f.getMsgAndCause(), this.handler, this.f1734en.f1556bK, Integer.valueOf(aI));
        return b;
    }

    /* renamed from: c */
    public void mo5700c(RootShell rootShell) {
        if (rootShell != null && this.f1736ep == 1) {
            if (!C1773a.m4825cr()) {
                C1773a.m4824a(this.f1732el, rootShell);
            }
            C1773a.m4827d(rootShell);
            rootShell.executeCommand("rm -f " + this.f1733em.workingDir.getAbsolutePath() + "/krshell/*");
        }
    }

    public void destroy() {
    }

    /* renamed from: z */
    public void mo5702z(int i) {
        this.f1736ep = i;
    }
}
