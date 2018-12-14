package com.shuame.rootgenius.common.event;

/* renamed from: com.shuame.rootgenius.common.event.h */
final class C1343h extends Thread {
    /* renamed from: a */
    final /* synthetic */ C1341f f3662a;
    /* renamed from: b */
    final /* synthetic */ C1342g f3663b;

    C1343h(C1342g c1342g, C1341f c1341f) {
        this.f3663b = c1342g;
        this.f3662a = c1341f;
    }

    /* JADX WARNING: Missing block: B:8:0x005a, code:
            if (r2.f3885a == 200) goto L_0x005c;
     */
    public final void run() {
        /*
        r9 = this;
        r0 = 1;
        r1 = 0;
        r3 = r9.f3662a;
        if (r3 == 0) goto L_0x006c;
    L_0x0006:
        r4 = new com.shuame.rootgenius.common.util.l$b;	 Catch:{ Exception -> 0x0070 }
        r4.<init>();	 Catch:{ Exception -> 0x0070 }
        r2 = r3.mo7010a();	 Catch:{ Exception -> 0x0070 }
        r5 = "UTF-8";
        r5 = r2.getBytes(r5);	 Catch:{ Exception -> 0x0070 }
        r2 = com.shuame.rootgenius.common.util.C1396i.f3874a;	 Catch:{ Exception -> 0x0070 }
        com.shuame.rootgenius.common.util.C1396i.m3893a(r5, r2);	 Catch:{ Exception -> 0x0070 }
        r6 = "http://api2.rootjl.%s/v2/stat/m/root/feedback?versionName=%s&versionCode=%s";
        r2 = 3;
        r7 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0070 }
        r8 = 0;
        r2 = com.shuame.rootgenius.common.util.C1412t.f3902a;	 Catch:{ Exception -> 0x0070 }
        if (r2 == 0) goto L_0x006d;
    L_0x0024:
        r2 = "org";
    L_0x0026:
        r7[r8] = r2;	 Catch:{ Exception -> 0x0070 }
        r2 = 1;
        r8 = com.shuame.rootgenius.common.C1323b.m3709n();	 Catch:{ Exception -> 0x0070 }
        r7[r2] = r8;	 Catch:{ Exception -> 0x0070 }
        r2 = 2;
        r8 = com.shuame.rootgenius.common.C1323b.m3711p();	 Catch:{ Exception -> 0x0070 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0070 }
        r7[r2] = r8;	 Catch:{ Exception -> 0x0070 }
        r2 = java.lang.String.format(r6, r7);	 Catch:{ Exception -> 0x0070 }
        r4.f3880a = r2;	 Catch:{ Exception -> 0x0070 }
        r4.f3881b = r5;	 Catch:{ Exception -> 0x0070 }
        r2 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r4.f3883d = r2;	 Catch:{ Exception -> 0x0070 }
        r2 = com.shuame.rootgenius.common.util.C1402l.m3903a(r4);	 Catch:{ Exception -> 0x0070 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0070 }
        r5 = "response.statusCode:";
        r4.<init>(r5);	 Catch:{ Exception -> 0x0070 }
        r5 = r2.f3885a;	 Catch:{ Exception -> 0x0070 }
        r4.append(r5);	 Catch:{ Exception -> 0x0070 }
        r2 = r2.f3885a;	 Catch:{ Exception -> 0x0070 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 != r4) goto L_0x0074;
    L_0x005c:
        if (r0 == 0) goto L_0x0076;
    L_0x005e:
        r0 = new java.lang.StringBuilder;
        r1 = "上报成功:";
        r0.<init>(r1);
        r1 = r3.toString();
        r0.append(r1);
    L_0x006c:
        return;
    L_0x006d:
        r2 = "com";
        goto L_0x0026;
    L_0x0070:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0074:
        r0 = r1;
        goto L_0x005c;
    L_0x0076:
        r0 = new java.lang.StringBuilder;
        r1 = "上报失败:";
        r0.<init>(r1);
        r1 = r3.toString();
        r0.append(r1);
        goto L_0x006c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.common.event.h.run():void");
    }
}
