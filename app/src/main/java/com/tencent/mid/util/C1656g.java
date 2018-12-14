package com.tencent.mid.util;

/* renamed from: com.tencent.mid.util.g */
public class C1656g {
    /* renamed from: a */
    static final byte[] f4738a = "03a976511e2cbe3a7f26808fb7af3c05".getBytes();

    /* renamed from: a */
    public static byte[] m4551a(byte[] bArr) {
        return C1656g.m4552a(bArr, f4738a);
    }

    /* renamed from: a */
    static byte[] m4552a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        int length = bArr2.length;
        if (length <= 0 || length > 256) {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        int i2;
        int i3;
        for (i2 = 0; i2 < 256; i2++) {
            iArr[i2] = i2;
            iArr2[i2] = bArr2[i2 % length];
        }
        i2 = 0;
        for (length = 0; length < 256; length++) {
            i2 = ((i2 + iArr[length]) + iArr2[length]) & 255;
            i3 = iArr[length];
            iArr[length] = iArr[i2];
            iArr[i2] = i3;
        }
        byte[] bArr3 = new byte[bArr.length];
        i2 = 0;
        length = 0;
        while (i < bArr.length) {
            i2 = (i2 + 1) & 255;
            length = (length + iArr[i2]) & 255;
            i3 = iArr[i2];
            iArr[i2] = iArr[length];
            iArr[length] = i3;
            bArr3[i] = (byte) (iArr[(iArr[i2] + iArr[length]) & 255] ^ bArr[i]);
            i++;
        }
        return bArr3;
    }

    /* renamed from: b */
    public static byte[] m4553b(byte[] bArr) {
        return C1656g.m4554b(bArr, f4738a);
    }

    /* renamed from: b */
    static byte[] m4554b(byte[] bArr, byte[] bArr2) {
        return C1656g.m4552a(bArr, bArr2);
    }
}
