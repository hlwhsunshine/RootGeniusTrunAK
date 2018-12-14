package com.changefontmanager.sdk.utils;

import android.content.Context;
import android.content.p013pm.PackageInfo;
import android.content.p013pm.PackageManager.NameNotFoundException;

public class PackageUtils {
    /* renamed from: d */
    private static boolean m969d(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null;
    }
}
