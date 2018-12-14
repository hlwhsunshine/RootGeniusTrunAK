package com.shuame.rootgenius.common.event;

import com.shuame.rootgenius.common.p100a.C1316a;

/* renamed from: com.shuame.rootgenius.common.event.b */
public class C1337b {
    /* renamed from: a */
    private static final String f3624a = C1337b.class.getSimpleName();
    /* renamed from: b */
    private static volatile C1337b f3625b;
    /* renamed from: c */
    private boolean f3626c = false;

    private C1337b() {
    }

    /* renamed from: a */
    public static C1337b m3738a() {
        if (f3625b == null) {
            synchronized (C1337b.class) {
                if (f3625b == null) {
                    f3625b = new C1337b();
                }
            }
        }
        return f3625b;
    }

    /* JADX WARNING: Missing block: B:8:0x0059, code:
            if (r2.f3885a == 200) goto L_0x005b;
     */
    /* renamed from: a */
    public static void m3739a(com.shuame.rootgenius.common.event.C1336a r8) {
        /*
        r0 = 1;
        r1 = 0;
        if (r8 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r3 = new com.shuame.rootgenius.common.util.l$b;	 Catch:{ Exception -> 0x0076 }
        r3.<init>();	 Catch:{ Exception -> 0x0076 }
        r2 = r8.mo7004a();	 Catch:{ Exception -> 0x0076 }
        r4 = "UTF-8";
        r4 = r2.getBytes(r4);	 Catch:{ Exception -> 0x0076 }
        r2 = com.shuame.rootgenius.common.util.C1396i.f3874a;	 Catch:{ Exception -> 0x0076 }
        com.shuame.rootgenius.common.util.C1396i.m3893a(r4, r2);	 Catch:{ Exception -> 0x0076 }
        r5 = "http://api2.rootjl.%s/v2/stat/m/root/treasurebox?versionName=%s&versionCode=%s";
        r2 = 3;
        r6 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0076 }
        r7 = 0;
        r2 = com.shuame.rootgenius.common.util.C1412t.f3902a;	 Catch:{ Exception -> 0x0076 }
        if (r2 == 0) goto L_0x0073;
    L_0x0023:
        r2 = "org";
    L_0x0025:
        r6[r7] = r2;	 Catch:{ Exception -> 0x0076 }
        r2 = 1;
        r7 = com.shuame.rootgenius.common.C1323b.m3709n();	 Catch:{ Exception -> 0x0076 }
        r6[r2] = r7;	 Catch:{ Exception -> 0x0076 }
        r2 = 2;
        r7 = com.shuame.rootgenius.common.C1323b.m3711p();	 Catch:{ Exception -> 0x0076 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0076 }
        r6[r2] = r7;	 Catch:{ Exception -> 0x0076 }
        r2 = java.lang.String.format(r5, r6);	 Catch:{ Exception -> 0x0076 }
        r3.f3880a = r2;	 Catch:{ Exception -> 0x0076 }
        r3.f3881b = r4;	 Catch:{ Exception -> 0x0076 }
        r2 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r3.f3883d = r2;	 Catch:{ Exception -> 0x0076 }
        r2 = com.shuame.rootgenius.common.util.C1402l.m3903a(r3);	 Catch:{ Exception -> 0x0076 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0076 }
        r4 = "response.statusCode:";
        r3.<init>(r4);	 Catch:{ Exception -> 0x0076 }
        r4 = r2.f3885a;	 Catch:{ Exception -> 0x0076 }
        r3.append(r4);	 Catch:{ Exception -> 0x0076 }
        r2 = r2.f3885a;	 Catch:{ Exception -> 0x0076 }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 != r3) goto L_0x007a;
    L_0x005b:
        if (r0 == 0) goto L_0x007c;
    L_0x005d:
        r0 = new java.lang.StringBuilder;
        r1 = "上报成功:";
        r0.<init>(r1);
        r1 = r8.toString();
        r0.append(r1);
        r0 = com.shuame.rootgenius.common.p100a.C1316a.m3680a();
        r0.mo6978b(r8);
        goto L_0x0004;
    L_0x0073:
        r2 = "com";
        goto L_0x0025;
    L_0x0076:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x007a:
        r0 = r1;
        goto L_0x005b;
    L_0x007c:
        r0 = new java.lang.StringBuilder;
        r1 = "上报失败:";
        r0.<init>(r1);
        r1 = r8.toString();
        r0.append(r1);
        r0 = com.shuame.rootgenius.common.p100a.C1316a.m3680a();
        r0.mo6977a(r8);
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.common.event.b.a(com.shuame.rootgenius.common.event.a):void");
    }

    /* renamed from: b */
    public static void m3741b(C1336a c1336a) {
        new StringBuilder("静默安装失败，等待执行asyncCheckDbReportThenSubmit:").append(c1336a.toString());
        C1316a.m3680a().mo6977a(c1336a);
    }

    /* renamed from: b */
    public final void mo7006b() {
        if (!this.f3626c) {
            this.f3626c = true;
            new C1339d(this).start();
        }
    }

    /* renamed from: c */
    public final void mo7007c(C1336a c1336a) {
        new C1338c(this, c1336a).start();
    }
}
