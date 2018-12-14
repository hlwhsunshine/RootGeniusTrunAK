package com.tencent.stat.common;

import java.io.File;

/* renamed from: com.tencent.stat.common.o */
class C1731o {
    /* renamed from: a */
    private static int f5088a = -1;

    /* renamed from: a */
    public static boolean m4759a() {
        if (f5088a == 1) {
            return true;
        }
        if (f5088a == 0) {
            return false;
        }
        String[] strArr = new String[]{"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        int i = 0;
        while (i < 6) {
            try {
                if (new File(strArr[i] + "su").exists()) {
                    f5088a = 1;
                    return true;
                }
                i++;
            } catch (Exception e) {
            }
        }
        f5088a = 0;
        return false;
    }
}
