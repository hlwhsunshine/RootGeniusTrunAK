package com.shuame.mobile.module.autoboot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.shuame.mobile.module.autoboot.p081b.C1155a;
import com.shuame.mobile.module.autoboot.p082d.C1158a;
import com.shuame.mobile.module.autoboot.service.AutoBootReceiver;
import com.shuame.mobile.module.autoboot.service.AutoBootService;
import com.shuame.rootgenius.common.C1150a;

/* renamed from: com.shuame.mobile.module.autoboot.a */
public class C1151a extends C1150a {
    /* renamed from: a */
    private static final String f3024a = C1151a.class.getSimpleName();
    /* renamed from: b */
    private static Context f3025b;
    /* renamed from: c */
    private static C1158a f3026c;

    /* renamed from: a */
    public static C1158a m3310a() {
        if (f3026c == null) {
            f3026c = new C1159b();
        }
        return f3026c;
    }

    /* renamed from: a */
    public static void m3311a(Context context) {
        f3025b = context;
        C1155a.m3320a(context);
        f3025b.startService(new Intent(f3025b, AutoBootService.class));
        BroadcastReceiver autoBootReceiver = new AutoBootReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.shuame.mobile.module.autoboot.START_AUTOBOOT_ACTIVITY_ACTION");
        f3025b.registerReceiver(autoBootReceiver, intentFilter);
    }

    /* renamed from: b */
    public static Context m3312b() {
        return f3025b;
    }
}
