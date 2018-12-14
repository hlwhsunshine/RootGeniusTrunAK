package com.p070qq.p071e.comm.util;

import com.p070qq.p071e.comm.services.C1078a;

/* renamed from: com.qq.e.comm.util.GDTLogger */
public class GDTLogger {
    public static final boolean DEBUG_ENABLE = false;

    /* renamed from: d */
    public static void m3130d(String str) {
    }

    /* renamed from: e */
    public static void m3131e(String str) {
    }

    /* renamed from: e */
    public static void m3132e(String str, Throwable th) {
        if (th == null) {
        }
    }

    /* renamed from: i */
    public static void m3133i(String str) {
    }

    public static void report(String str) {
        GDTLogger.report(str, null);
    }

    public static void report(String str, Throwable th) {
        GDTLogger.m3132e(str, th);
        C1078a.m3125a();
        C1078a.m3128a(str, th);
    }

    /* renamed from: w */
    public static void m3134w(String str) {
    }

    /* renamed from: w */
    public static void m3135w(String str, Throwable th) {
        if (th == null) {
        }
    }
}
