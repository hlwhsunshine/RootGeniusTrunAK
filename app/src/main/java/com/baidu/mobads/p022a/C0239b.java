package com.baidu.mobads.p022a;

/* renamed from: com.baidu.mobads.a.b */
public class C0239b {
    /* renamed from: a */
    public static final Boolean f385a = Boolean.valueOf(false);
    /* renamed from: b */
    public static final Boolean f386b = Boolean.valueOf(false);

    /* renamed from: a */
    public static double m288a() {
        try {
            return Double.parseDouble("8.25");
        } catch (Exception e) {
            return 0.0d;
        }
    }

    /* renamed from: b */
    public static int m289b() {
        int i = 0;
        try {
            return Integer.valueOf("8.25".split("\\.")[0]).intValue();
        } catch (Exception e) {
            return i;
        }
    }
}
