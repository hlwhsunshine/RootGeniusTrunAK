package com.shuame.mobile.module.autoboot.p084e;

import android.preference.PreferenceManager;
import com.shuame.mobile.module.autoboot.C1151a;

/* renamed from: com.shuame.mobile.module.autoboot.e.a */
public final class C1163a {
    /* renamed from: a */
    public static boolean m3344a(String str, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(C1151a.m3312b()).getBoolean(str, z);
    }
}
