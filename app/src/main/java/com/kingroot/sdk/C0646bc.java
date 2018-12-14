package com.kingroot.sdk;

import android.content.SharedPreferences;
import android.content.p013pm.PackageManager;

/* renamed from: com.kingroot.sdk.bc */
public class C0646bc {
    /* renamed from: P */
    private static SharedPreferences m1509P() {
        return C0741dg.m1804aL().f1805el.getSharedPreferences("nuclear_setting", 0);
    }

    /* renamed from: Q */
    public static long m1510Q() {
        return C0646bc.m1509P().getLong("S01", 0);
    }

    /* renamed from: R */
    public static long m1511R() {
        return C0646bc.m1509P().getLong("S04", PackageManager.MAXIMUM_VERIFICATION_TIMEOUT);
    }

    /* renamed from: S */
    public static String m1512S() {
        return C0646bc.m1509P().getString("S03", "");
    }

    /* renamed from: b */
    public static void m1513b(long j) {
        C0646bc.m1509P().edit().putLong("S01", j).commit();
    }

    /* renamed from: c */
    public static void m1514c(long j) {
        C0646bc.m1509P().edit().putLong("S04", j).commit();
    }

    /* renamed from: d */
    public static void m1515d(long j) {
        C0646bc.m1509P().edit().putLong("S02", j).commit();
    }

    /* renamed from: y */
    public static void m1516y(String str) {
        C0646bc.m1509P().edit().putString("S03", str).commit();
    }
}
