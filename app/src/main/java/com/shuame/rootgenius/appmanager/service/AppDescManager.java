package com.shuame.rootgenius.appmanager.service;

import com.google.gson.C0479d;
import com.google.gson.p051a.C0471c;
import com.shuame.rootgenius.appmanager.C1253a;
import com.shuame.rootgenius.appmanager.p091b.C1254a;
import com.shuame.rootgenius.appmanager.p094d.C1266a;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.annotation.GsonObject;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.common.util.C1412t;
import com.shuame.rootgenius.sdk.RootGenius;
import java.util.ArrayList;
import java.util.List;

@GsonObject
public class AppDescManager {
    private static final String TAG = AppDescManager.class.getSimpleName();
    private static AppDescManager sInstance;
    private boolean isHttpReqSucc;
    private ArrayList<C1266a> mAppDescList = new ArrayList();
    private ArrayList<C1266a> mAppHideList = new ArrayList();

    @GsonObject
    static class HttpReqBean {
        public String imei = C1387ad.m3877e(C1253a.m3545a());
        public String imsi = C1387ad.m3878f(C1253a.m3545a());
        @C0471c(a = "mac_address")
        public String macAddress = C1387ad.m3874d(C1253a.m3545a());
        @C0471c(a = "apps")
        public List<AppBean> pkgList;
        @C0471c(a = "product_id")
        public String productId;
        public String qimei = C1387ad.m3865a(true);
        public String rid = RootGenius.GetDeviceInfo().phoneId.rid;
        /* renamed from: sn */
        public String f3412sn = C1387ad.m3872c();
        @C0471c(a = "report_timestamp")
        public long timestamp;

        @GsonObject
        static class AppBean {
            @C0471c(a = "pkn")
            public String packageName;
            @C0471c(a = "vc")
            public int versionCode;

            public AppBean(String str, int i) {
                this.packageName = str;
                this.versionCode = i;
            }
        }

        public HttpReqBean() {
            C1323b.m3688a();
            this.productId = C1323b.m3707l();
            this.timestamp = System.currentTimeMillis() / 1000;
            this.pkgList = new ArrayList();
        }
    }

    @GsonObject
    static class HttpRespBean {
        @C0471c(a = "apps")
        public List<C1273a> appDescList = new ArrayList();
        @C0471c(a = "hiddens")
        public List<C1273a> appHideList = new ArrayList();
        @C0471c(a = "comment")
        public String commonDesc;

        /* renamed from: com.shuame.rootgenius.appmanager.service.AppDescManager$HttpRespBean$a */
        static class C1273a {
            @C0471c(a = "pkn")
            /* renamed from: a */
            public String f3413a;
            @C0471c(a = "cgn")
            /* renamed from: b */
            public String f3414b;

            C1273a() {
            }
        }

        HttpRespBean() {
        }
    }

    private AppDescManager() {
    }

    private String getInstalledSystemApp(List<C1254a> list) {
        Object httpReqBean = new HttpReqBean();
        for (C1254a c1254a : list) {
            httpReqBean.pkgList.add(new AppBean(c1254a.f3337a, c1254a.f3344h));
        }
        return new C0479d().mo5385a(httpReqBean);
    }

    public static AppDescManager getInstance() {
        if (sInstance == null) {
            synchronized (AppDescManager.class) {
                if (sInstance == null) {
                    sInstance = new AppDescManager();
                }
            }
        }
        return sInstance;
    }

    public ArrayList<C1266a> getAppDescList() {
        return this.mAppDescList;
    }

    public ArrayList<C1266a> getAppHideList() {
        return this.mAppHideList;
    }

    public String getServant() {
        String str = "http://api1.rootjl.%s/v2/m/root/yyb_app?versionName=%s&versionCode=%s";
        Object[] objArr = new Object[3];
        objArr[0] = C1412t.f3902a ? "org" : "com";
        objArr[1] = C1323b.m3709n();
        objArr[2] = Integer.valueOf(C1323b.m3711p());
        return String.format(str, objArr);
    }

    public boolean isHttpReqSucc() {
        return (getAppDescList().size() == 0 && getAppHideList().size() == 0) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0089 A:{LOOP_END, LOOP:0: B:15:0x0083->B:17:0x0089} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d1 A:{LOOP_END, LOOP:1: B:26:0x00cb->B:28:0x00d1} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0089 A:{LOOP_END, LOOP:0: B:15:0x0083->B:17:0x0089} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d1 A:{LOOP_END, LOOP:1: B:26:0x00cb->B:28:0x00d1} */
    public boolean netQueryAppInfos(java.util.List<com.shuame.rootgenius.appmanager.p091b.C1254a> r11) {
        /*
        r10 = this;
        r1 = 1;
        r2 = 0;
        r3 = 0;
        r0 = r10.getInstalledSystemApp(r11);
        r4 = new com.shuame.rootgenius.common.util.l$b;	 Catch:{ Exception -> 0x00ac }
        r4.<init>();	 Catch:{ Exception -> 0x00ac }
        r5 = r10.getServant();	 Catch:{ Exception -> 0x00ac }
        r4.f3880a = r5;	 Catch:{ Exception -> 0x00ac }
        r5 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r4.f3883d = r5;	 Catch:{ Exception -> 0x00ac }
        r0 = r0.getBytes();	 Catch:{ Exception -> 0x00ac }
        r4.f3881b = r0;	 Catch:{ Exception -> 0x00ac }
        r0 = r4.f3881b;	 Catch:{ Exception -> 0x00ac }
        r5 = com.shuame.rootgenius.common.util.C1396i.f3874a;	 Catch:{ Exception -> 0x00ac }
        com.shuame.rootgenius.common.util.C1396i.m3893a(r0, r5);	 Catch:{ Exception -> 0x00ac }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00ac }
        r0 = com.shuame.rootgenius.common.util.C1402l.m3903a(r4);	 Catch:{ Exception -> 0x00ac }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00ac }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ac }
        r9 = "耗时：";
        r8.<init>(r9);	 Catch:{ Exception -> 0x00ac }
        r4 = r4 - r6;
        r8.append(r4);	 Catch:{ Exception -> 0x00ac }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ac }
        r5 = "response.statusCode:";
        r4.<init>(r5);	 Catch:{ Exception -> 0x00ac }
        r5 = r0.f3885a;	 Catch:{ Exception -> 0x00ac }
        r4.append(r5);	 Catch:{ Exception -> 0x00ac }
        r4 = r0.f3885a;	 Catch:{ Exception -> 0x00ac }
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r4 != r5) goto L_0x00f2;
    L_0x004c:
        r4 = r0.f3886b;	 Catch:{ Exception -> 0x00ac }
        r4 = r4.length;	 Catch:{ Exception -> 0x00ac }
        if (r4 <= 0) goto L_0x00f2;
    L_0x0051:
        r4 = r0.f3886b;	 Catch:{ Exception -> 0x00ee }
        r5 = com.shuame.rootgenius.common.util.C1396i.f3874a;	 Catch:{ Exception -> 0x00ee }
        com.shuame.rootgenius.common.util.C1396i.m3895b(r4, r5);	 Catch:{ Exception -> 0x00ee }
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x00ee }
        r0 = r0.f3886b;	 Catch:{ Exception -> 0x00ee }
        r5 = "UTF-8";
        r4.<init>(r0, r5);	 Catch:{ Exception -> 0x00ee }
        r0 = new com.google.gson.d;	 Catch:{ Exception -> 0x00ee }
        r0.<init>();	 Catch:{ Exception -> 0x00ee }
        r5 = com.shuame.rootgenius.appmanager.service.AppDescManager.HttpRespBean.class;
        r0 = r0.mo5383a(r4, r5);	 Catch:{ Exception -> 0x00ee }
        r0 = (com.shuame.rootgenius.appmanager.service.AppDescManager.HttpRespBean) r0;	 Catch:{ Exception -> 0x00ee }
        r3 = r0;
        r0 = r1;
    L_0x0070:
        r4 = r3;
        r3 = r0;
    L_0x0072:
        r0 = r10.mAppDescList;
        r0.clear();
        if (r4 == 0) goto L_0x00b5;
    L_0x0079:
        r0 = r4.appDescList;
        if (r0 == 0) goto L_0x00b5;
    L_0x007d:
        r0 = r4.appDescList;
        r5 = r0.iterator();
    L_0x0083:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x00b5;
    L_0x0089:
        r0 = r5.next();
        r0 = (com.shuame.rootgenius.appmanager.service.AppDescManager.HttpRespBean.C1273a) r0;
        r6 = new com.shuame.rootgenius.appmanager.d.a;
        r6.<init>();
        r7 = r0.f3413a;
        r6.f3392a = r7;
        r7 = r4.commonDesc;
        r8 = new java.lang.Object[r1];
        r0 = r0.f3414b;
        r8[r2] = r0;
        r0 = java.lang.String.format(r7, r8);
        r6.f3393b = r0;
        r0 = r10.mAppDescList;
        r0.add(r6);
        goto L_0x0083;
    L_0x00ac:
        r0 = move-exception;
        r4 = r0;
        r0 = r2;
    L_0x00af:
        r4.printStackTrace();
        r4 = r3;
        r3 = r0;
        goto L_0x0072;
    L_0x00b5:
        r0 = r10.mAppDescList;
        r0.toString();
        r0 = r10.mAppHideList;
        r0.clear();
        if (r4 == 0) goto L_0x00e6;
    L_0x00c1:
        r0 = r4.appHideList;
        if (r0 == 0) goto L_0x00e6;
    L_0x00c5:
        r0 = r4.appHideList;
        r1 = r0.iterator();
    L_0x00cb:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x00e6;
    L_0x00d1:
        r0 = r1.next();
        r0 = (com.shuame.rootgenius.appmanager.service.AppDescManager.HttpRespBean.C1273a) r0;
        r2 = new com.shuame.rootgenius.appmanager.d.a;
        r2.<init>();
        r0 = r0.f3413a;
        r2.f3392a = r0;
        r0 = r10.mAppHideList;
        r0.add(r2);
        goto L_0x00cb;
    L_0x00e6:
        r0 = r10.mAppHideList;
        r0.toString();
        r10.isHttpReqSucc = r3;
        return r3;
    L_0x00ee:
        r0 = move-exception;
        r4 = r0;
        r0 = r1;
        goto L_0x00af;
    L_0x00f2:
        r0 = r2;
        goto L_0x0070;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.appmanager.service.AppDescManager.netQueryAppInfos(java.util.List):boolean");
    }
}
