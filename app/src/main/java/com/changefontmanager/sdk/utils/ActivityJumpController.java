package com.changefontmanager.sdk.utils;

import android.content.Context;
import android.content.Intent;

public class ActivityJumpController {
    /* renamed from: a */
    public static void m946a(Context context) {
        try {
            m949c(context, "com.android.thememanager");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private static void m947b(Context context) {
        try {
            m949c(context, "com.baidu.thememanager.ui");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public static void m948c(Context context) {
        Intent intent = new Intent("huawei.intent.action.FONT_STYLE");
        intent.setClassName("com.huawei.android.thememanager", "com.huawei.android.thememanager.font.FontManagerActivity");
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* renamed from: c */
    private static void m949c(Context context, String str) {
        Intent intent = new Intent();
        intent = context.getPackageManager().getLaunchIntentForPackage(str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* renamed from: d */
    public static void m950d(Context context) {
        Intent intent;
        try {
            intent = new Intent();
            intent.setClassName("com.android.settings", "com.android.settings.flipfont.FontListPreference");
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            try {
                intent = new Intent();
                intent.setClassName("com.sec.android.easysettings", "com.sec.android.easysettings.font.FontSetting");
                intent.setFlags(268435456);
                context.startActivity(intent);
            } catch (Exception e2) {
                intent = new Intent("android.settings.DISPLAY_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
            }
        }
    }

    /* renamed from: d */
    private static void m951d(Context context, String str, String str2) {
        try {
            m949c(context, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private static void m952e(Context context) {
        Intent intent;
        try {
            intent = new Intent();
            intent.setClassName("com.sec.android.easysettings", "com.sec.android.easysettings.font.FontSetting");
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            intent = new Intent("android.settings.DISPLAY_SETTINGS");
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    /* renamed from: e */
    private static void m953e(Context context, String str, String str2) {
        m949c(context, str);
    }

    /* renamed from: f */
    private static void m954f(Context context, String str, String str2) {
        m949c(context, str);
    }

    public static void jumpToHtcSetting(Context context) {
        Intent intent;
        try {
            intent = new Intent();
            intent.setClassName("com.android.settings", "com.android.settings..SubSettings");
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            try {
                intent = new Intent();
                intent = context.getPackageManager().getLaunchIntentForPackage("com.android.settings");
                intent.addFlags(268435456);
                context.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
