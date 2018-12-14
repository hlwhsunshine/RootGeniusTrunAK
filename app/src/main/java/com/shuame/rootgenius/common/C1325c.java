package com.shuame.rootgenius.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

/* renamed from: com.shuame.rootgenius.common.c */
public class C1325c extends C1150a {
    /* renamed from: a */
    private static final String f3595a = C1325c.class.getSimpleName();
    /* renamed from: b */
    private static Context f3596b;
    /* renamed from: c */
    private static BroadcastReceiver f3597c = new C1327d();

    /* renamed from: a */
    public static Context m3724a() {
        return f3596b;
    }

    /* renamed from: a */
    public static void m3725a(Context context) {
        f3596b = context;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        f3596b.registerReceiver(f3597c, intentFilter);
    }
}
