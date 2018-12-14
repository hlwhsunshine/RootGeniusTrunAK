package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.fl */
public class C0820fl {
    /* renamed from: b */
    public static String m2077b(String str, boolean z) {
        String str2 = C0822fn.m2082bQ() + " chattr";
        if (z) {
            return "echo";
        }
        return String.format("%s -aiA %s", new Object[]{str2, str});
    }

    /* renamed from: bM */
    public static String m2078bM() {
        return C0822fn.m2082bQ() + " chattr";
    }
}
