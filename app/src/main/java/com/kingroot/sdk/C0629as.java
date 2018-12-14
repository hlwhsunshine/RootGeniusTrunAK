package com.kingroot.sdk;

import java.lang.reflect.Method;

/* renamed from: com.kingroot.sdk.as */
public class C0629as {
    /* renamed from: bZ */
    private static Class<?> f1572bZ = null;
    /* renamed from: ca */
    private static Method f1573ca = null;
    /* renamed from: cb */
    private static Method f1574cb = null;

    /* renamed from: H */
    private static void m1454H() {
        try {
            if (f1572bZ == null) {
                Class cls = Class.forName("android.os.SystemProperties");
                f1572bZ = cls;
                f1573ca = cls.getMethod("get", new Class[]{String.class});
                f1574cb = f1572bZ.getMethod("getInt", new Class[]{String.class, Integer.TYPE});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String str) {
        C0629as.m1454H();
        String str2 = "";
        try {
            return (String) f1573ca.invoke(f1572bZ, new Object[]{str});
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }
}
