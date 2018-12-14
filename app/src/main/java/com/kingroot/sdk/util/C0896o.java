package com.kingroot.sdk.util;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.kingroot.sdk.util.o */
public final class C0896o {
    /* renamed from: a */
    public static byte[] m2458a(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(1, secretKeySpec);
        return instance.doFinal(bArr2);
    }

    /* renamed from: b */
    public static byte[] m2459b(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(2, secretKeySpec);
        return instance.doFinal(bArr2);
    }

    /* renamed from: i */
    public static byte[] m2460i(byte[] bArr) {
        return C0890j.m2431d(bArr).getBytes();
    }
}
