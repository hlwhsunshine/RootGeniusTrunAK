package com.kingroot.sdk;

import android.content.Context;

/* renamed from: com.kingroot.sdk.ah */
public class C0616ah {
    /* renamed from: a */
    public static void m1374a(Context context, String str, long j) {
        context.getSharedPreferences("pi_kr_rtcommon", 0).edit().putLong(str, j).commit();
    }

    /* renamed from: b */
    public static void m1375b(Context context, String str, int i) {
        context.getSharedPreferences("pi_kr_rtcommon", 0).edit().putInt(str, i).commit();
    }

    /* renamed from: c */
    public static int m1376c(Context context, String str) {
        return context.getSharedPreferences("pi_kr_rtcommon", 0).getInt(str, 0);
    }

    /* renamed from: d */
    public static long m1377d(Context context, String str) {
        return context.getSharedPreferences("pi_kr_rtcommon", 0).getLong(str, 0);
    }
}
