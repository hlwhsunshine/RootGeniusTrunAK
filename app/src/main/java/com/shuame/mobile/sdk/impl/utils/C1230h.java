package com.shuame.mobile.sdk.impl.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.shuame.mobile.sdk.impl.utils.h */
public class C1230h {
    /* renamed from: a */
    private static final String f3241a = C1230h.class.getSimpleName();

    /* renamed from: com.shuame.mobile.sdk.impl.utils.h$a */
    public enum C1229a {
        NONE,
        WIFI,
        MOBILE
    }

    /* renamed from: a */
    public static C1229a m3460a() {
        C1229a c1229a = C1229a.NONE;
        ConnectivityManager connectivityManager = (ConnectivityManager) C1219a.m3445a().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return C1229a.WIFI;
                }
                if (type == 0) {
                    return C1229a.MOBILE;
                }
            }
        }
        return c1229a;
    }

    /* renamed from: b */
    public static int m3461b() {
        int i = -1;
        Matcher matcher = Pattern.compile("level:\\s*(\\d+)", 10).matcher(ShellUtils.execSuCmd("dumpsys battery", 5000));
        if (matcher.find()) {
            String group = matcher.group(1);
            C1228g.m3458a(f3241a, "strLevel:" + group);
            try {
                i = Integer.valueOf(group).intValue();
            } catch (Exception e) {
            }
        }
        C1228g.m3458a(f3241a, "level:" + i);
        return i;
    }
}
