package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.gk */
public final class C0847gk {
    /* renamed from: a */
    private static void m2196a(StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15)).append("0123456789ABCDEF".charAt(b & 15));
    }

    /* renamed from: ao */
    public static int m2197ao(String str) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    /* renamed from: c */
    public static String m2198c(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte a : bArr) {
            C0847gk.m2196a(stringBuffer, a);
        }
        return stringBuffer.toString();
    }
}
