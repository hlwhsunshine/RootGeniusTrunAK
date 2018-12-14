package com.tencent.mid.util;

/* renamed from: com.tencent.mid.util.i */
public class C1658i {
    /* renamed from: a */
    public static String m4563a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString().toUpperCase();
    }
}
