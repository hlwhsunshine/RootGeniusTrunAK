package com.shuame.mobile.sdk.impl.utils;

import android.content.Context;
import java.lang.ref.WeakReference;

/* renamed from: com.shuame.mobile.sdk.impl.utils.a */
public class C1219a {
    /* renamed from: a */
    private static WeakReference<Context> f3224a;

    /* renamed from: a */
    public static Context m3445a() {
        return f3224a != null ? (Context) f3224a.get() : null;
    }

    /* renamed from: a */
    public static void m3446a(Context context) {
        f3224a = new WeakReference(context);
    }

    /* renamed from: b */
    public static void m3447b() {
        if (f3224a != null) {
            f3224a.clear();
            f3224a = null;
        }
    }
}
