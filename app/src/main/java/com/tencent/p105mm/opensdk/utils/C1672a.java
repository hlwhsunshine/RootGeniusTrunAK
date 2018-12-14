package com.tencent.p105mm.opensdk.utils;

import android.os.Bundle;

/* renamed from: com.tencent.mm.opensdk.utils.a */
public final class C1672a {
    /* renamed from: a */
    public static int m4584a(Bundle bundle, String str) {
        int i = -1;
        if (bundle == null) {
            return i;
        }
        try {
            return bundle.getInt(str, -1);
        } catch (Exception e) {
            Log.m4580e("MicroMsg.IntentUtil", "getIntExtra exception:" + e.getMessage());
            return i;
        }
    }

    /* renamed from: b */
    public static String m4585b(Bundle bundle, String str) {
        String str2 = null;
        if (bundle == null) {
            return str2;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            Log.m4580e("MicroMsg.IntentUtil", "getStringExtra exception:" + e.getMessage());
            return str2;
        }
    }
}
