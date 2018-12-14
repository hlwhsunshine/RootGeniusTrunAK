package com.kingroot.sdk.util;

/* renamed from: com.kingroot.sdk.util.q */
public final class C0897q {
    /* renamed from: a */
    private static void m2461a(StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15)).append("0123456789ABCDEF".charAt(b & 15));
    }

    /* renamed from: ab */
    public static String m2462ab(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: ac */
    public static byte[] m2463ac(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = Integer.valueOf(str.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return bArr;
    }

    /* renamed from: b */
    public static String m2464b(Throwable th) {
        if (th == null) {
            return "";
        }
        String th2 = th.toString();
        Throwable cause = th.getCause();
        return cause != null ? th2 + "_cause_" + cause.toString() : th2;
    }

    /* renamed from: c */
    public static String m2465c(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte a : bArr) {
            C0897q.m2461a(stringBuffer, a);
        }
        return stringBuffer.toString();
    }

    /* renamed from: j */
    public static String m2466j(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(toHexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    /* renamed from: n */
    public static String m2467n(String str, String str2) {
        return (str == null || !str.contains(str2)) ? null : str.substring(str.indexOf(str2) + str2.length()).trim();
    }
}
