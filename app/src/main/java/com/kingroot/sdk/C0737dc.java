package com.kingroot.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.kingroot.sdk.util.C0889i;

/* renamed from: com.kingroot.sdk.dc */
public class C0737dc extends BroadcastReceiver {
    /* renamed from: fd */
    private static C0737dc f1797fd;
    /* renamed from: fe */
    private boolean f1798fe = false;

    /* renamed from: A */
    public static void m1790A(Context context) {
        C0633at.m1465i("PkgAddBroadcastReceiver.waitForReceiveAndUnRegister....");
        if (f1797fd != null && !f1797fd.f1798fe) {
            int i = 0;
            do {
                boolean g = C0889i.m2430g(1000);
                C0633at.m1465i("PkgAddBroadcastReceiver.wait...." + i + ", tid = " + Thread.currentThread().getId());
                if (f1797fd.f1798fe || g) {
                    C0633at.m1465i("PkgAddBroadcastReceiver.timeout....");
                    C0737dc.m1792z(context);
                } else {
                    i++;
                }
            } while (i < 15);
            C0633at.m1465i("PkgAddBroadcastReceiver.timeout....");
            C0737dc.m1792z(context);
        }
    }

    /* renamed from: y */
    public static void m1791y(Context context) {
        f1797fd = new C0737dc();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(f1797fd, intentFilter);
        C0633at.m1465i("PkgAddBroadcastReceiver.register()");
    }

    /* renamed from: z */
    private static void m1792z(Context context) {
        if (f1797fd != null) {
            context.unregisterReceiver(f1797fd);
            f1797fd = null;
        }
        C0633at.m1465i("PkgAddBroadcastReceiver.unregister()");
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REPLACED".equals(action)) {
            action = intent.getDataString();
            C0633at.m1465i("PkgAddBroadcastReceiver.onReceive() packageName = " + action);
            if ("package:com.kingroot.kinguser".equals(action)) {
                this.f1798fe = true;
            }
        }
    }
}
