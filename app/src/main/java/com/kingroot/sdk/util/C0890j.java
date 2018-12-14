package com.kingroot.sdk.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.kingroot.sdk.util.j */
public class C0890j {
    /* renamed from: gm */
    private static final char[] f2217gm = "0123456789abcdef".toCharArray();

    /* renamed from: d */
    public static String m2431d(byte[] bArr) {
        return C0897q.m2466j(C0890j.m2432e(bArr));
    }

    /* renamed from: e */
    private static byte[] m2432e(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance(new String(C0897q.m2463ac("4D4435")));
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return bArr2;
        }
    }

    /* renamed from: f */
    public static String m2433f(byte[] bArr) {
        return C0890j.m2435h(C0890j.m2434g(bArr));
    }

    /* renamed from: g */
    public static byte[] m2434g(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: h */
    public static String m2435h(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 3);
        for (byte b : bArr) {
            int i = b & 255;
            stringBuilder.append(f2217gm[i >> 4]);
            stringBuilder.append(f2217gm[i & 15]);
        }
        return stringBuilder.toString().toUpperCase();
    }
}
