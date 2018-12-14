package com.kingroot.sdk;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* renamed from: com.kingroot.sdk.co */
public class C0713co {
    /* renamed from: J */
    public static String m1720J(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return String.format("%s \"%s\" \"%s\"", new Object[]{C0713co.m1721aA(), Integer.valueOf(2), str});
    }

    /* renamed from: aA */
    public static String m1721aA() {
        return Build.BRAND.toLowerCase(Locale.ENGLISH).contains("samsung") ? C0712cn.m1715aw() + " kuCmd" : C0712cn.m1714av() + " kuCmd";
    }
}
