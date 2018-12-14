package com.kingroot.sdk.util;

import com.kingroot.sdk.C0633at;
import dalvik.system.DexClassLoader;
import java.io.File;

/* renamed from: com.kingroot.sdk.util.i */
public class C0889i {
    /* renamed from: Z */
    public static int m2426Z(String str) {
        long length;
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return -2;
        }
        int i = 3;
        do {
            try {
                System.load(str);
                return 0;
            } catch (Throwable th) {
                C0633at.m1458a("load " + str + " fail. ", th);
                C0889i.m2428bl();
                i--;
                if (i <= 0) {
                    length = file.length();
                    C0633at.m1465i("loadSo fail : length = " + length + ", md5 = " + C0883c.m2405g(file));
                    return -1;
                }
            }
        } while (i <= 0);
        try {
            length = file.length();
            C0633at.m1465i("loadSo fail : length = " + length + ", md5 = " + C0883c.m2405g(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /* renamed from: a */
    public static Class<?> m2427a(String str, String str2, String str3, ClassLoader classLoader) {
        int i = 3;
        do {
            try {
                return new DexClassLoader(str, str2, null, classLoader).loadClass(str3);
            } catch (Throwable th) {
                C0633at.m1458a("load " + str + "fail. ", th);
                C0889i.m2428bl();
                i--;
                if (i <= 0) {
                    return null;
                }
            }
        } while (i <= 0);
        return null;
    }

    /* renamed from: bl */
    public static void m2428bl() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    /* renamed from: f */
    public static void m2429f(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
        }
    }

    /* renamed from: g */
    public static boolean m2430g(long j) {
        try {
            Thread.sleep(j);
            return false;
        } catch (InterruptedException e) {
            return true;
        }
    }
}
