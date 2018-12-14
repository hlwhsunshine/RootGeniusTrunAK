package com.p070qq.p071e.ads.cfg;

import com.p070qq.p071e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.cfg.MultiProcessFlag */
public class MultiProcessFlag {
    /* renamed from: a */
    private static boolean f2709a;
    /* renamed from: b */
    private static boolean f2710b;

    public static boolean isMultiProcess() {
        return f2709a;
    }

    public static void setMultiProcess(boolean z) {
        if (f2710b) {
            GDTLogger.m3134w("MultiProcessFlag has already be setted,reset will not take any effect");
            return;
        }
        f2710b = true;
        f2709a = z;
    }
}
