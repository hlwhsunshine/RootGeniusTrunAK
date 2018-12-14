package com.tencent.p105mm.opensdk.utils;

/* renamed from: com.tencent.mm.opensdk.utils.Log */
public class Log {
    private static ILog logImpl;

    /* renamed from: d */
    public static void m4579d(String str, String str2) {
        if (logImpl != null) {
            logImpl.mo7750d(str, str2);
        }
    }

    /* renamed from: e */
    public static void m4580e(String str, String str2) {
        if (logImpl != null) {
            logImpl.mo7751e(str, str2);
        }
    }

    /* renamed from: i */
    public static void m4581i(String str, String str2) {
        if (logImpl != null) {
            logImpl.mo7752i(str, str2);
        }
    }

    public static void setLogImpl(ILog iLog) {
        logImpl = iLog;
    }

    /* renamed from: v */
    public static void m4582v(String str, String str2) {
        if (logImpl != null) {
            logImpl.mo7753v(str, str2);
        }
    }

    /* renamed from: w */
    public static void m4583w(String str, String str2) {
        if (logImpl != null) {
            logImpl.mo7754w(str, str2);
        }
    }
}
