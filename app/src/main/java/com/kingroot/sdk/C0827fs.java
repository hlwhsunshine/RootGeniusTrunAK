package com.kingroot.sdk;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.kingroot.sdk.C0851gl.C0849b;
import com.kingroot.sdk.C0851gl.C0850c;

/* renamed from: com.kingroot.sdk.fs */
public final class C0827fs {
    /* JADX WARNING: Removed duplicated region for block: B:23:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039  */
    /* renamed from: a */
    public static com.kingroot.sdk.C0851gl.C0849b m2104a(java.lang.String r7, com.kingroot.sdk.C0851gl.C0850c r8) {
        /*
        r1 = 0;
        r0 = new com.kingroot.sdk.gl;	 Catch:{ Exception -> 0x0030, all -> 0x0036 }
        r0.<init>(r7);	 Catch:{ Exception -> 0x0030, all -> 0x0036 }
        r2 = com.kingroot.sdk.C0846gi.m2195I();	 Catch:{ Exception -> 0x0042, all -> 0x003d }
        r3 = 14;
        if (r2 < r3) goto L_0x0015;
    L_0x000e:
        r2 = "export LD_LIBRARY_PATH=/vendor/lib:/system/lib";
        r4 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0.mo5855c(r2, r4);	 Catch:{ Exception -> 0x0042, all -> 0x003d }
    L_0x0015:
        r1 = r0.mo5854a(r8);	 Catch:{ Exception -> 0x0042, all -> 0x003d }
    L_0x0019:
        r0.shutdown();
        r0 = r1;
    L_0x001d:
        if (r0 != 0) goto L_0x002f;
    L_0x001f:
        r0 = new com.kingroot.sdk.gl$b;
        r1 = r8.f2107cr;
        r2 = 2;
        r2 = java.lang.Integer.valueOf(r2);
        r3 = "";
        r4 = "Run Cmd Exception";
        r0.<init>(r1, r2, r3, r4);
    L_0x002f:
        return r0;
    L_0x0030:
        r0 = move-exception;
        r0 = r1;
    L_0x0032:
        if (r0 != 0) goto L_0x0019;
    L_0x0034:
        r0 = r1;
        goto L_0x001d;
    L_0x0036:
        r0 = move-exception;
    L_0x0037:
        if (r1 == 0) goto L_0x003c;
    L_0x0039:
        r1.shutdown();
    L_0x003c:
        throw r0;
    L_0x003d:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x0037;
    L_0x0042:
        r2 = move-exception;
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.fs.a(java.lang.String, com.kingroot.sdk.gl$c):com.kingroot.sdk.gl$b");
    }

    /* renamed from: aj */
    public static boolean m2105aj(String str) {
        str.trim();
        C0849b t = C0827fs.m2109t(IXAdRequestInfo.SCREEN_HEIGHT, new StringBuilder(String.valueOf(str)).append(" -v").toString());
        return t.success() && t.f2104cs != null && t.f2104cs.contains("kinguser_su");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a  */
    /* renamed from: ak */
    public static com.kingroot.sdk.C0851gl m2106ak(java.lang.String r6) {
        /*
        r1 = 0;
        r0 = new com.kingroot.sdk.gl;	 Catch:{ Exception -> 0x0016 }
        r0.<init>(r6);	 Catch:{ Exception -> 0x0016 }
        r2 = com.kingroot.sdk.C0846gi.m2195I();	 Catch:{ Exception -> 0x001f }
        r3 = 14;
        if (r2 < r3) goto L_0x0015;
    L_0x000e:
        r2 = "export LD_LIBRARY_PATH=/vendor/lib:/system/lib";
        r4 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0.mo5855c(r2, r4);	 Catch:{ Exception -> 0x001f }
    L_0x0015:
        return r0;
    L_0x0016:
        r0 = move-exception;
        r0 = r1;
    L_0x0018:
        if (r0 == 0) goto L_0x0015;
    L_0x001a:
        r0.shutdown();
        r0 = r1;
        goto L_0x0015;
    L_0x001f:
        r2 = move-exception;
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.fs.ak(java.lang.String):com.kingroot.sdk.gl");
    }

    /* renamed from: al */
    public static boolean m2107al(String str) {
        C0849b t = C0827fs.m2109t(IXAdRequestInfo.SCREEN_HEIGHT, new StringBuilder(String.valueOf(str)).append(" --ping").toString());
        return t.success() && t.f2104cs.trim().equals("kinguser_su");
    }

    /* renamed from: b */
    public static C0849b m2108b(String str, String str2, boolean z) {
        return C0827fs.m2104a(str, new C0850c(str2, str2, z ? 120000 : 0));
    }

    /* renamed from: t */
    public static C0849b m2109t(String str, String str2) {
        return C0827fs.m2108b(str, str2, true);
    }
}
