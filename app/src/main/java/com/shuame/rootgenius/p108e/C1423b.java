package com.shuame.rootgenius.p108e;

import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.util.C1412t;
import com.shuame.rootgenius.p107d.C1419a;

/* renamed from: com.shuame.rootgenius.e.b */
public class C1423b {
    /* renamed from: a */
    private static final String f3921a = C1423b.class.getSimpleName();
    /* renamed from: b */
    private static volatile C1423b f3922b;
    /* renamed from: c */
    private boolean f3923c = false;

    private C1423b() {
    }

    /* renamed from: a */
    public static C1423b m3949a() {
        if (f3922b == null) {
            synchronized (C1423b.class) {
                if (f3922b == null) {
                    f3922b = new C1423b();
                }
            }
        }
        return f3922b;
    }

    /* renamed from: a */
    public static void m3950a(C1422a c1422a) {
        if (c1422a != null) {
            if (C1419a.m3940a().mo7135a(c1422a)) {
                new StringBuilder("上报db成功:").append(c1422a.toString());
            } else {
                new StringBuilder("上报db失败:").append(c1422a.toString());
            }
        }
    }

    /* renamed from: c */
    public static String m3954c() {
        String str = "http://api2.rootjl.%s/v2/stat/m/root/must/project?versionName=%s&versionCode=%s";
        Object[] objArr = new Object[3];
        objArr[0] = C1412t.f3902a ? "org" : "com";
        objArr[1] = C1323b.m3709n();
        objArr[2] = Integer.valueOf(C1323b.m3711p());
        return String.format(str, objArr);
    }

    /* renamed from: b */
    public final synchronized void mo7142b() {
        if (!this.f3923c) {
            this.f3923c = true;
            new C1425d(this).start();
        }
    }

    /* renamed from: b */
    public final void mo7143b(C1422a c1422a) {
        new C1424c(this, c1422a).start();
    }
}
