package com.kingroot.sdk.util;

import java.util.Locale;

/* renamed from: com.kingroot.sdk.util.g */
public class C0887g {
    /* renamed from: bk */
    public static String m2425bk() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Locale.getDefault().getLanguage());
        stringBuilder.append("_");
        stringBuilder.append(Locale.getDefault().getCountry());
        return stringBuilder.toString();
    }
}
