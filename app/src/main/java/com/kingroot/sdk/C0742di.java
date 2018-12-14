package com.kingroot.sdk;

import android.content.Context;

/* renamed from: com.kingroot.sdk.di */
public class C0742di {
    /* renamed from: B */
    public static String m1806B(Context context) {
        C0904y a;
        String str = "";
        try {
            a = C0904y.m2484a(context.getAssets(), "krsdk.cert");
        } catch (Exception e) {
            e.printStackTrace();
            a = null;
        }
        return a != null ? a.mo5999b() : str;
    }

    /* renamed from: a */
    public static void m1807a(Context context, Context context2) {
        C0904y a;
        try {
            a = C0904y.m2484a(context2.getAssets(), "krsdk.cert");
        } catch (Exception e) {
            e.printStackTrace();
            a = null;
        }
        if (a == null) {
            throw new RuntimeException("generate license failed");
        } else if (!a.mo5998a(context)) {
            throw new RuntimeException("invalid license");
        }
    }
}
