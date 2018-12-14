package com.kingroot.sdk;

import android.content.Context;
import android.os.Handler;
import dalvik.system.DexClassLoader;
import java.util.HashMap;
import krsdk.RootConfig;

/* renamed from: com.kingroot.sdk.db */
class C0736db extends C0721ct {
    public C0736db(Context context, Handler handler, RootConfig rootConfig, C0626ap c0626ap) {
        super(context, handler, rootConfig, c0626ap);
    }

    /* renamed from: a */
    public int mo5697a(C0756dq c0756dq) {
        int intValue;
        String str = this.f1735eo + "/osc.apk";
        String str2 = this.f1735eo + "/lib/armeabi";
        C0738dd c0738dd = new C0738dd(this.f1732el, str);
        try {
            Class loadClass = new DexClassLoader(str, this.f1735eo, str2, this.f1732el.getClassLoader()).loadClass("krsdk.OscSolution");
            intValue = ((Integer) loadClass.getMethod("root", new Class[]{Context.class, HashMap.class}).invoke(loadClass.newInstance(), new Object[]{c0738dd, null})).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            intValue = 1;
        }
        C0633at.m1464h("osc_ret = " + intValue);
        return intValue;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00cc  */
    /* renamed from: aB */
    public boolean mo5698aB() {
        /*
        r5 = this;
        super.mo5698aB();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r5.f1735eo;
        r0 = r0.append(r1);
        r1 = "/osc.apk";
        r0 = r0.append(r1);
        r3 = r0.toString();
        r2 = 0;
        r1 = new com.kingroot.sdk.av;	 Catch:{ Throwable -> 0x00c3, all -> 0x00d1 }
        r0 = "sh";
        r1.<init>(r0);	 Catch:{ Throwable -> 0x00c3, all -> 0x00d1 }
        r0 = "export PATH=/sbin:/vendor/bin:/system/sbin:/system/bin:/system/xbin:$PATH";
        r1.mo5609t(r0);	 Catch:{ Throwable -> 0x00f8 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00f8 }
        r2 = "cat ";
        r0.<init>(r2);	 Catch:{ Throwable -> 0x00f8 }
        r2 = r5.f1734en;	 Catch:{ Throwable -> 0x00f8 }
        r2 = r2.f1563bR;	 Catch:{ Throwable -> 0x00f8 }
        r0 = r0.append(r2);	 Catch:{ Throwable -> 0x00f8 }
        r2 = " > ";
        r0 = r0.append(r2);	 Catch:{ Throwable -> 0x00f8 }
        r0 = r0.append(r3);	 Catch:{ Throwable -> 0x00f8 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00f8 }
        r1.mo5609t(r0);	 Catch:{ Throwable -> 0x00f8 }
        r1.shutdown();
        r0 = new java.io.File;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = r5.f1732el;
        r4 = r4.getCacheDir();
        r4 = r4.getAbsolutePath();
        r2 = r2.append(r4);
        r4 = "/kr";
        r2 = r2.append(r4);
        r2 = r2.toString();
        r0.<init>(r2);
        r2 = r0.getAbsolutePath();
        com.kingroot.sdk.util.C0883c.m2388X(r2);
        r0.mkdirs();
        r2 = new com.kingroot.sdk.av;	 Catch:{ Throwable -> 0x00d9, all -> 0x00e3 }
        r4 = "sh";
        r2.<init>(r4);	 Catch:{ Throwable -> 0x00d9, all -> 0x00e3 }
        r1 = "export PATH=/sbin:/vendor/bin:/system/sbin:/system/bin:/system/xbin:$PATH";
        r2.mo5609t(r1);	 Catch:{ Throwable -> 0x00f3, all -> 0x00ee }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00f3, all -> 0x00ee }
        r4 = "cat ";
        r1.<init>(r4);	 Catch:{ Throwable -> 0x00f3, all -> 0x00ee }
        r4 = com.kingroot.sdk.C0741dg.m1804aL();	 Catch:{ Throwable -> 0x00f3, all -> 0x00ee }
        r4 = r4.f1806em;	 Catch:{ Throwable -> 0x00f3, all -> 0x00ee }
        r4 = r4.workingDir;	 Catch:{ Throwable -> 0x00f3, all -> 0x00ee }
        r4 = r4.getAbsolutePath();	 Catch:{ Throwable -> 0x00f3, all -> 0x00ee }
        r1 = r1.append(r4);	 Catch:{ Throwable -> 0x00f3, all -> 0x00ee }
        r4 = "/superuser.apk > ";
        r1 = r1.append(r4);	 Catch:{ Throwable -> 0x00f3, all -> 0x00ee }
        r0 = r0.getAbsolutePath();	 Catch:{ Throwable -> 0x00f3, all -> 0x00ee }
        r0 = r1.append(r0);	 Catch:{ Throwable -> 0x00f3, all -> 0x00ee }
        r1 = "/Kinguser.apk";
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00f3, all -> 0x00ee }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00f3, all -> 0x00ee }
        r2.mo5609t(r0);	 Catch:{ Throwable -> 0x00f3, all -> 0x00ee }
        r2.shutdown();
    L_0x00b5:
        r0 = new java.io.File;	 Catch:{ IOException -> 0x00e9 }
        r0.<init>(r3);	 Catch:{ IOException -> 0x00e9 }
        r1 = r5.f1735eo;	 Catch:{ IOException -> 0x00e9 }
        r2 = r5.f1732el;	 Catch:{ IOException -> 0x00e9 }
        com.kingroot.sdk.util.C0883c.m2391a(r0, r1, r2);	 Catch:{ IOException -> 0x00e9 }
    L_0x00c1:
        r0 = 1;
    L_0x00c2:
        return r0;
    L_0x00c3:
        r0 = move-exception;
        r1 = r2;
    L_0x00c5:
        r2 = "复制KU异常";
        com.kingroot.sdk.C0633at.m1458a(r2, r0);	 Catch:{ all -> 0x00f6 }
        if (r1 == 0) goto L_0x00cf;
    L_0x00cc:
        r1.shutdown();
    L_0x00cf:
        r0 = 0;
        goto L_0x00c2;
    L_0x00d1:
        r0 = move-exception;
        r1 = r2;
    L_0x00d3:
        if (r1 == 0) goto L_0x00d8;
    L_0x00d5:
        r1.shutdown();
    L_0x00d8:
        throw r0;
    L_0x00d9:
        r0 = move-exception;
    L_0x00da:
        r2 = "复制KU异常";
        com.kingroot.sdk.C0633at.m1458a(r2, r0);	 Catch:{ all -> 0x00f0 }
        r1.shutdown();
        goto L_0x00b5;
    L_0x00e3:
        r0 = move-exception;
        r2 = r1;
    L_0x00e5:
        r2.shutdown();
        throw r0;
    L_0x00e9:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x00c1;
    L_0x00ee:
        r0 = move-exception;
        goto L_0x00e5;
    L_0x00f0:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00e5;
    L_0x00f3:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00da;
    L_0x00f6:
        r0 = move-exception;
        goto L_0x00d3;
    L_0x00f8:
        r0 = move-exception;
        goto L_0x00c5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.db.aB():boolean");
    }

    /* renamed from: aC */
    public C0719cs mo5699aC() {
        return null;
    }

    public void destroy() {
    }
}
