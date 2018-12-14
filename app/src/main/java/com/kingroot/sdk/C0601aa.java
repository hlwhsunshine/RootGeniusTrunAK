package com.kingroot.sdk;

import java.io.File;

/* renamed from: com.kingroot.sdk.aa */
public final class C0601aa {
    /* renamed from: ax */
    public static String f1475ax = "0";
    public static boolean useTestServer = true;
    /* renamed from: as */
    public String f1476as = "0";
    /* renamed from: at */
    public String f1477at = "0";
    /* renamed from: au */
    public int f1478au = 0;
    /* renamed from: av */
    public String f1479av = "1.0.0";
    /* renamed from: aw */
    public boolean f1480aw = true;

    /* renamed from: com.kingroot.sdk.aa$a */
    public static final class C0599a {
        /* renamed from: ay */
        public static String f1470ay = "0";
        /* renamed from: az */
        public static String f1471az = "1.0.0";
    }

    /* renamed from: com.kingroot.sdk.aa$b */
    public static final class C0600b {
        /* renamed from: aA */
        public static int f1472aA = 0;
        /* renamed from: ay */
        public static String f1473ay = "0";
        /* renamed from: az */
        public static String f1474az = "1.0.0";
    }

    /* renamed from: a */
    public static void m1335a(File file, C0601aa c0601aa) {
        f1475ax = c0601aa.f1476as;
        useTestServer = c0601aa.f1480aw;
        C0600b.f1473ay = c0601aa.f1477at;
        C0600b.f1472aA = c0601aa.f1478au;
        C0600b.f1474az = c0601aa.f1479av;
        C0599a.f1470ay = c0601aa.f1477at;
        C0599a.f1471az = c0601aa.f1479av;
        C0602ab.m1336a(file);
    }
}
