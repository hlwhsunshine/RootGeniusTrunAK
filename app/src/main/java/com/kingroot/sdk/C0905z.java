package com.kingroot.sdk;

import android.content.Context;
import android.content.p013pm.PackageInfo;

/* renamed from: com.kingroot.sdk.z */
public class C0905z {
    /* renamed from: a */
    public static PackageInfo m2489a(Context context, String str, int i) {
        PackageInfo packageInfo = null;
        try {
            return context.getPackageManager().getPackageInfo(str, i);
        } catch (Throwable th) {
            th.printStackTrace();
            return packageInfo;
        }
    }
}
