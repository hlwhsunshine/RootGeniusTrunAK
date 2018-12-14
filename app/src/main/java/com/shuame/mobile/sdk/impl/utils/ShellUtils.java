package com.shuame.mobile.sdk.impl.utils;

import android.text.TextUtils;

public class ShellUtils {
    public static final int OBTAIN_ROOT_ERROR = 3;
    public static final int OBTAIN_ROOT_NOT_ROOT = 4;
    public static final int OBTAIN_ROOT_OK = 1;
    public static final int OBTAIN_ROOT_USER_DENIED = 2;
    /* renamed from: a */
    private static final String f3222a = ShellUtils.class.getSimpleName();
    /* renamed from: b */
    private static int f3223b = 3;

    public static String execBlockSuCmd(String str) {
        return C1233i.m3471a().mo6858a(str, 1);
    }

    public static String execCmd(String str, long j) {
        return execCmd(str, j, 1);
    }

    public static String execCmd(String str, long j, int i) {
        return C1233i.m3479c().mo6859a(str, j, i);
    }

    public static String execCmd(String str, boolean z, long j) {
        return execCmd(str, z, j, 1);
    }

    public static String execCmd(String str, boolean z, long j, int i) {
        return z ? execSuCmd(str, j, i) : execCmd(str, j, i);
    }

    public static String execSuCmd(String str, long j) {
        return execSuCmd(str, j, 1);
    }

    public static String execSuCmd(String str, long j, int i) {
        String a = C1233i.m3471a().mo6859a(str, j, i);
        if (!C1233i.m3471a().mo6860e() || !str.startsWith("am force-stop") || TextUtils.isEmpty(a) || !a.contains("Segmentation fault")) {
            return a;
        }
        C1228g.m3458a(f3222a, "am force-stop Segmentation fault, try system su");
        return C1233i.m3476b().mo6859a(str, j, i);
    }

    public static int getLastObtainRootResult() {
        return f3223b;
    }

    public static String getSelectedSuCmd() {
        return C1233i.m3471a().mo6861f();
    }

    public static boolean isRooted() {
        return C1233i.m3482d();
    }

    public static int obtainRoot() {
        int g = C1233i.m3471a().mo6862g();
        f3223b = g;
        return g;
    }
}
