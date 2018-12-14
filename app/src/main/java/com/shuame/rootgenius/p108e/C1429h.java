package com.shuame.rootgenius.p108e;

import com.shuame.rootgenius.pojo.OptimizeInfo;
import java.util.ArrayList;

/* renamed from: com.shuame.rootgenius.e.h */
public class C1429h {
    /* renamed from: a */
    private static final String f3931a = C1429h.class.getSimpleName();
    /* renamed from: b */
    private static volatile C1429h f3932b;

    private C1429h() {
    }

    /* renamed from: a */
    public static C1429h m3960a() {
        if (f3932b == null) {
            synchronized (C1429h.class) {
                if (f3932b == null) {
                    f3932b = new C1429h();
                }
            }
        }
        return f3932b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0105  */
    /* renamed from: b */
    static /* synthetic */ void m3962b(java.util.ArrayList r10) {
        /*
        r2 = 0;
        r1 = 1;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r0 = com.shuame.rootgenius.RootGeniusApp.m3523a();
        r0 = com.shuame.rootgenius.common.util.C1387ad.m3874d(r0);
        r4 = com.shuame.rootgenius.RootGeniusApp.m3523a();
        r4 = com.shuame.rootgenius.common.util.C1387ad.m3877e(r4);
        r5 = com.shuame.rootgenius.RootGeniusApp.m3523a();
        r5 = com.shuame.rootgenius.common.util.C1387ad.m3878f(r5);
        r6 = com.shuame.rootgenius.sdk.RootGenius.GetDeviceInfo();
        r6 = r6.phoneId;
        r6 = r6.rid;
        r7 = com.shuame.rootgenius.common.util.C1387ad.m3865a(r1);
        r8 = com.shuame.rootgenius.common.util.C1387ad.m3872c();
        r9 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
        r3.append(r9);
        r9 = "<report>";
        r3.append(r9);
        if (r0 == 0) goto L_0x004a;
    L_0x003b:
        r9 = "<mac_address_new>";
        r9 = r3.append(r9);
        r0 = r9.append(r0);
        r9 = "</mac_address_new>";
        r0.append(r9);
    L_0x004a:
        if (r4 == 0) goto L_0x005b;
    L_0x004c:
        r0 = "<imei>";
        r0 = r3.append(r0);
        r0 = r0.append(r4);
        r4 = "</imei>";
        r0.append(r4);
    L_0x005b:
        if (r5 == 0) goto L_0x006c;
    L_0x005d:
        r0 = "<imsi>";
        r0 = r3.append(r0);
        r0 = r0.append(r5);
        r4 = "</imsi>";
        r0.append(r4);
    L_0x006c:
        if (r6 == 0) goto L_0x007d;
    L_0x006e:
        r0 = "<rid>";
        r0 = r3.append(r0);
        r0 = r0.append(r6);
        r4 = "</rid>";
        r0.append(r4);
    L_0x007d:
        if (r7 == 0) goto L_0x008e;
    L_0x007f:
        r0 = "<qimei>";
        r0 = r3.append(r0);
        r0 = r0.append(r7);
        r4 = "</qimei>";
        r0.append(r4);
    L_0x008e:
        if (r8 == 0) goto L_0x009f;
    L_0x0090:
        r0 = "<sn>";
        r0 = r3.append(r0);
        r0 = r0.append(r8);
        r4 = "</sn>";
        r0.append(r4);
    L_0x009f:
        r4 = r10.iterator();
    L_0x00a3:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x00b3;
    L_0x00a9:
        r0 = r4.next();
        r0 = (com.shuame.rootgenius.pojo.OptimizeInfo) r0;
        r0.addChildXml(r3);
        goto L_0x00a3;
    L_0x00b3:
        r0 = "</report>";
        r3.append(r0);
        r4 = new com.shuame.rootgenius.common.util.l$b;	 Catch:{ Exception -> 0x0117 }
        r4.<init>();	 Catch:{ Exception -> 0x0117 }
        r0 = r3.toString();	 Catch:{ Exception -> 0x0117 }
        r5 = "UTF-8";
        r5 = r0.getBytes(r5);	 Catch:{ Exception -> 0x0117 }
        r0 = com.shuame.rootgenius.common.util.C1396i.f3874a;	 Catch:{ Exception -> 0x0117 }
        com.shuame.rootgenius.common.util.C1396i.m3893a(r5, r0);	 Catch:{ Exception -> 0x0117 }
        r6 = "http://api2.rootjl.%s/v2/stat/m/root/optimization?versionName=%s&versionCode=%s";
        r0 = 3;
        r7 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0117 }
        r8 = 0;
        r0 = com.shuame.rootgenius.common.util.C1412t.f3902a;	 Catch:{ Exception -> 0x0117 }
        if (r0 == 0) goto L_0x0114;
    L_0x00d6:
        r0 = "org";
    L_0x00d8:
        r7[r8] = r0;	 Catch:{ Exception -> 0x0117 }
        r0 = 1;
        r8 = com.shuame.rootgenius.common.C1323b.m3709n();	 Catch:{ Exception -> 0x0117 }
        r7[r0] = r8;	 Catch:{ Exception -> 0x0117 }
        r0 = 2;
        r8 = com.shuame.rootgenius.common.C1323b.m3711p();	 Catch:{ Exception -> 0x0117 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0117 }
        r7[r0] = r8;	 Catch:{ Exception -> 0x0117 }
        r0 = java.lang.String.format(r6, r7);	 Catch:{ Exception -> 0x0117 }
        r4.f3880a = r0;	 Catch:{ Exception -> 0x0117 }
        r4.f3881b = r5;	 Catch:{ Exception -> 0x0117 }
        r0 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r4.f3883d = r0;	 Catch:{ Exception -> 0x0117 }
        r0 = com.shuame.rootgenius.common.util.C1402l.m3903a(r4);	 Catch:{ Exception -> 0x0117 }
        r0 = r0.f3885a;	 Catch:{ Exception -> 0x0117 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r4) goto L_0x011b;
    L_0x0102:
        r0 = r1;
    L_0x0103:
        if (r0 == 0) goto L_0x011d;
    L_0x0105:
        r0 = new java.lang.StringBuilder;
        r1 = "上报成功:";
        r0.<init>(r1);
        r1 = r3.toString();
        r0.append(r1);
    L_0x0113:
        return;
    L_0x0114:
        r0 = "com";
        goto L_0x00d8;
    L_0x0117:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x011b:
        r0 = r2;
        goto L_0x0103;
    L_0x011d:
        r0 = new java.lang.StringBuilder;
        r1 = "上报失败:";
        r0.<init>(r1);
        r1 = r3.toString();
        r0.append(r1);
        goto L_0x0113;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.e.h.b(java.util.ArrayList):void");
    }

    /* renamed from: a */
    public final void mo7147a(ArrayList<OptimizeInfo> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            new C1430i(this, arrayList).start();
        }
    }
}
