package com.shuame.mobile.module.autoboot.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.shuame.mobile.module.autoboot.p084e.C1163a;
import com.shuame.mobile.module.autoboot.p085ui.AutoBootManagerActivity;

public class AutoBootReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static final String f3073a = AutoBootReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Intent intent2;
        if ("com.shuame.mobile.module.autoboot.START_AUTOBOOT_ACTIVITY_ACTION".equals(action)) {
            intent2 = new Intent(context, AutoBootManagerActivity.class);
            intent2.addFlags(67108864);
            intent2.addFlags(268435456);
            intent2.putExtra("EXTRA_FROM_AUTOBOOT_NOTIFICATION", true);
            context.startActivity(intent2);
        } else if (C1163a.m3344a("AUTOBOOT", true)) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                dataString = dataString.substring(dataString.lastIndexOf(58) + 1);
                if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REPLACED".equals(action) || "android.intent.action.PACKAGE_INSTALL".equals(action)) {
                    intent2 = new Intent(context, AutoBootService.class);
                    intent2.putExtra("INSTALL_PACKAGE", dataString);
                    context.startService(intent2);
                }
            }
        }
    }
}
