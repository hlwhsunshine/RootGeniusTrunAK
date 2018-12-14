package com.shuame.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.shuame.utils.d */
public class C1620d {
    /* renamed from: a */
    private static final String f4582a = C1620d.class.getSimpleName();

    /* renamed from: a */
    public static String m4391a(String str) {
        return C1620d.m4392a(str.getBytes());
    }

    /* renamed from: a */
    private static String m4392a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr, 0, bArr.length);
            byte[] digest = instance.digest();
            char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            char[] cArr2 = new char[(digest.length * 2)];
            for (int i = 0; i < digest.length; i++) {
                byte b = digest[i];
                cArr2[i * 2] = cArr[(b >>> 4) & 15];
                cArr2[(i * 2) + 1] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
