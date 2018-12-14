package com.shuame.rootgenius.appmanager;

import android.content.Context;
import com.shuame.rootgenius.appmanager.p092e.C1261a;
import com.shuame.rootgenius.common.C1150a;

/* renamed from: com.shuame.rootgenius.appmanager.a */
public final class C1253a extends C1150a {
    /* renamed from: a */
    private static Context f3335a;
    /* renamed from: b */
    private static C1261a f3336b;

    /* renamed from: a */
    public static Context m3545a() {
        return f3335a;
    }

    /* renamed from: a */
    public static void m3546a(Context context) {
        f3335a = context;
    }

    /* renamed from: b */
    public static C1261a m3547b() {
        if (f3336b == null) {
            f3336b = new C1262b();
        }
        return f3336b;
    }
}
