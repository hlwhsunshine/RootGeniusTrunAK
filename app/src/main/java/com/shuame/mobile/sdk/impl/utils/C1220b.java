package com.shuame.mobile.sdk.impl.utils;

import java.io.File;

/* renamed from: com.shuame.mobile.sdk.impl.utils.b */
public class C1220b {
    /* renamed from: a */
    private static final String f3225a = C1226e.class.getSimpleName();

    /* renamed from: a */
    public static boolean m3448a(String str, String str2, int i) {
        File file = new File(str);
        File file2 = new File(str2);
        if (i <= 0) {
            i = 1;
        }
        int i2 = 0;
        while (!file.renameTo(file2)) {
            i2++;
            if (i2 >= i) {
                return false;
            }
        }
        return true;
    }
}
