package com.kingroot.sdk;

import android.content.Context;
import krsdk.RootShell;

/* renamed from: com.kingroot.sdk.cr */
public class C0718cr {
    /* renamed from: ei */
    private static boolean f1729ei = false;

    /* renamed from: a */
    public static boolean m1730a(Context context, RootShell rootShell, String str, String str2, String str3, boolean z, boolean z2, String str4) {
        C0716ga c0717cq = new C0717cq(rootShell);
        if (!f1729ei) {
            C0834fw.m2132a(c0717cq, context, str, str3, new C0715cp(), str4);
            f1729ei = true;
        }
        C0834fw.m2134a(c0717cq, Boolean.valueOf(z2));
        return z ? C0834fw.m2138l(c0717cq, str2) : C0834fw.m2137h(c0717cq);
    }
}
