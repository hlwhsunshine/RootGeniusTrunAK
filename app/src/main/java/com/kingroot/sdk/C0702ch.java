package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.ch */
public class C0702ch {
    /* renamed from: a */
    public static String m1689a(String str, String str2, boolean z) {
        if (str == null) {
            str = C0712cn.m1714av() + " chattr";
        }
        if (z) {
            return String.format("%s +aiA %s", new Object[]{str, str2});
        }
        return String.format("%s -aiA %s", new Object[]{str, str2});
    }
}
