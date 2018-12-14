package com.shuame.rootgenius.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.shuame.rootgenius.common.util.v */
public final class C1414v {
    /* renamed from: a */
    private static long f3903a = 60;
    /* renamed from: b */
    private static long f3904b = 3600;

    /* renamed from: a */
    public static String m3931a(long j) {
        String valueOf = String.valueOf(j);
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
        } catch (Exception e) {
            return valueOf;
        }
    }
}
