package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.gr */
public class C0857gr {
    /* renamed from: jX */
    private static final char[] f2130jX = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* renamed from: jY */
    public static final byte[] f2131jY = new byte[0];

    /* renamed from: n */
    public static String m2227n(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            cArr[(i * 2) + 1] = f2130jX[b & 15];
            cArr[(i * 2) + 0] = f2130jX[((byte) (b >>> 4)) & 15];
        }
        return new String(cArr);
    }
}
