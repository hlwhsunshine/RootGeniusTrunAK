package com.shuame.rootgenius.hook.util;

import android.content.Context;
import android.content.p013pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.shuame.mobile.sdk.impl.utils.ShellUtils;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.common.util.C1397j;
import com.shuame.rootgenius.common.util.C1412t;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.hook.HookData;
import com.shuame.rootgenius.hook.event.HookEventHandler;
import java.io.File;

public class HookTool {
    private static final String TAG = HookTool.class.getSimpleName();

    private static String getInjectCmd(Context context, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = context.getFilesDir().getParentFile().getAbsolutePath() + "/lib";
        String str4 = str3 + "/librt.so";
        if (C1412t.f3902a) {
            str4 = str3 + "/librt_d.so";
        }
        stringBuilder.append(str).append("  ");
        stringBuilder.append("system_server  ");
        stringBuilder.append(str4).append("  ");
        stringBuilder.append("-p ").append(str2).append(" ");
        stringBuilder.append("-t system_server ");
        stringBuilder.append("-n ").append(context.getPackageName()).append(" ");
        int i = 1;
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        stringBuilder.append("-v ").append(i).append(" ");
        new StringBuilder("cmd : \n ").append(stringBuilder.toString());
        return stringBuilder.toString();
    }

    private static String getUninjectCmd(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str).append("  ");
        stringBuilder.append("stop system_server");
        new StringBuilder("cmd : \n ").append(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static boolean injectDefenseService(Context context) {
        String str;
        File file;
        String str2 = context.getFilesDir().getAbsolutePath() + "/rtlib.jar";
        if (C1412t.f3902a) {
            str2 = context.getFilesDir().getAbsolutePath() + "/rtlib_d.jar";
        }
        if (C1412t.f3902a) {
            C1397j.m3900a(C1450R.raw.rtlib_d, str2);
        } else {
            C1397j.m3900a(C1450R.raw.rtlib, str2);
        }
        String str3;
        File file2;
        int i;
        if (VERSION.SDK_INT >= 21) {
            str3 = context.getFilesDir().getAbsolutePath() + "/inject_pie";
            if (C1412t.f3902a) {
                str3 = context.getFilesDir().getAbsolutePath() + "/inject_pie_d";
            }
            file2 = new File(str3);
            i = C1450R.raw.inject_pie;
            if (C1412t.f3902a) {
                i = C1450R.raw.inject_pie_d;
            }
            C1397j.m3900a(i, str3);
            str = str3;
            file = file2;
        } else {
            str3 = context.getFilesDir().getAbsolutePath() + "/inject";
            if (C1412t.f3902a) {
                str3 = context.getFilesDir().getAbsolutePath() + "/inject_d";
            }
            file2 = new File(str3);
            i = C1450R.raw.inject;
            if (C1412t.f3902a) {
                i = C1450R.raw.inject_d;
            }
            C1397j.m3900a(i, str3);
            str = str3;
            file = file2;
        }
        if (!file.canExecute() && !C1397j.m3901a(str)) {
            return false;
        }
        boolean z;
        str2 = ShellUtils.execSuCmd(getInjectCmd(context, str, str2), 30000);
        HookData.getInstance().saveInjectResultDesc(str2 + C1387ad.m3876e());
        if (str2.equals("success")) {
            HookData.getInstance().saveInjectResultCode(0);
            z = true;
        } else {
            HookData.getInstance().saveInjectResultCode(-1);
            z = false;
        }
        HookEventHandler.getInstance().asyncReport();
        return z;
    }

    public static void uninjectDefenseService(Context context) {
        String str;
        int i;
        if (VERSION.SDK_INT >= 21) {
            str = context.getFilesDir().getAbsolutePath() + "/inject_pie";
            if (C1412t.f3902a) {
                str = context.getFilesDir().getAbsolutePath() + "/inject_pie_d";
            }
            if (!new File(str).exists()) {
                i = C1450R.raw.inject_pie;
                if (C1412t.f3902a) {
                    i = C1450R.raw.inject_pie_d;
                }
                C1397j.m3900a(i, str);
            }
        } else {
            str = context.getFilesDir().getAbsolutePath() + "/inject";
            if (C1412t.f3902a) {
                str = context.getFilesDir().getAbsolutePath() + "/inject_d";
            }
            if (!new File(str).exists()) {
                i = C1450R.raw.inject;
                if (C1412t.f3902a) {
                    i = C1450R.raw.inject_d;
                }
                C1397j.m3900a(i, str);
            }
        }
        ShellUtils.execSuCmd(getUninjectCmd(context, str), 30000);
    }
}
