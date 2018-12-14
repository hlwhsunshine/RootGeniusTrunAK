package com.tencent.p105mm.opensdk.utils;

/* renamed from: com.tencent.mm.opensdk.utils.d */
public final class C1677d {
    /* renamed from: a */
    public static boolean m4588a(String str) {
        return str == null || str.length() <= 0;
    }

    /* renamed from: b */
    public static int m4589b(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return str.length() <= 0 ? 0 : Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }
}
