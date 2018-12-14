package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.fm */
public class C0821fm {
    /* renamed from: jl */
    public static final String f2063jl = C0821fm.m2079bN();
    /* renamed from: jm */
    public static final String f2064jm = C0821fm.m2080bO();

    /* renamed from: bN */
    public static String m2079bN() {
        return C0846gi.m2195I() >= 18 ? "mount -o remount -w /system" : "mount -o remount,rw /system /system";
    }

    /* renamed from: bO */
    public static String m2080bO() {
        return C0846gi.m2195I() >= 18 ? "mount -o remount -w /" : "mount -o remount,rw / /";
    }
}
