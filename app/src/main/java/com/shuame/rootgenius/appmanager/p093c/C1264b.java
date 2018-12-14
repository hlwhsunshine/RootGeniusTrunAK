package com.shuame.rootgenius.appmanager.p093c;

import com.shuame.rootgenius.appmanager.p091b.C1255b;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.util.C1412t;

/* renamed from: com.shuame.rootgenius.appmanager.c.b */
public class C1264b {
    /* renamed from: a */
    private static final String f3388a = C1264b.class.getSimpleName();
    /* renamed from: b */
    private static C1264b f3389b;
    /* renamed from: c */
    private boolean f3390c = false;

    private C1264b() {
    }

    /* renamed from: a */
    public static C1264b m3595a() {
        if (f3389b == null) {
            synchronized (C1264b.class) {
                if (f3389b == null) {
                    f3389b = new C1264b();
                }
            }
        }
        return f3389b;
    }

    /* renamed from: a */
    public static void m3596a(C1263a c1263a) {
        if (C1255b.m3548a().mo6888a(c1263a)) {
            new StringBuilder("上报db成功:").append(c1263a.toString());
        } else {
            new StringBuilder("上报db失败:").append(c1263a.toString());
        }
    }

    /* renamed from: c */
    public static String m3600c() {
        String str = "http://api2.rootjl.%s/v2/stat/m/root/app/uninstall?versionName=%s&versionCode=%s";
        Object[] objArr = new Object[3];
        objArr[0] = C1412t.f3902a ? "org" : "com";
        objArr[1] = C1323b.m3709n();
        objArr[2] = Integer.valueOf(C1323b.m3711p());
        return String.format(str, objArr);
    }

    /* renamed from: b */
    public final synchronized void mo6913b() {
        if (!this.f3390c) {
            this.f3390c = true;
            new C1265c(this).start();
        }
    }
}
