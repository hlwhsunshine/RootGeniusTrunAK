package com.kingroot.sdk;

import java.nio.ByteBuffer;

/* renamed from: com.kingroot.sdk.gz */
public final class C0865gz {
    /* renamed from: kq */
    private static final byte[] f2152kq;
    /* renamed from: kr */
    private static final byte[] f2153kr;

    static {
        byte[] bArr = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = bArr[i >>> 4];
            bArr3[i] = bArr[i & 15];
        }
        f2152kq = bArr2;
        f2153kr = bArr3;
    }

    /* renamed from: a */
    public static <T extends Comparable<T>> int m2306a(T t, T t2) {
        return t.compareTo(t2);
    }

    /* renamed from: a */
    public static byte[] m2307a(ByteBuffer byteBuffer) {
        Object obj = new byte[byteBuffer.position()];
        System.arraycopy(byteBuffer.array(), 0, obj, 0, obj.length);
        return obj;
    }

    /* renamed from: c */
    public static boolean m2308c(boolean z, boolean z2) {
        return z == z2;
    }

    public static boolean equals(int i, int i2) {
        return i == i2;
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj.equals(obj2);
    }
}
