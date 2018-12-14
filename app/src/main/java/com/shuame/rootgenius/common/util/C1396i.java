package com.shuame.rootgenius.common.util;

/* renamed from: com.shuame.rootgenius.common.util.i */
public final class C1396i {
    /* renamed from: a */
    public static final short[] f3874a = new short[]{(short) 177, (short) 15, (short) 105, (short) 78, (short) 94, (short) 1, (short) 38, (short) 151, (short) 230, (short) 6, (short) 82, (short) 6, (short) 154, (short) 20, (short) 97, (short) 191, (short) 193, (short) 57, (short) 161, (short) 138, (short) 29, (short) 175, (short) 152, (short) 130, (short) 72, (short) 113, (short) 78, (short) 62, (short) 134, (short) 51, (short) 21, (short) 71, (short) 177, (short) 179, (short) 197, (short) 118, (short) 190, (short) 243, (short) 209, (short) 234, (short) 67, (short) 14, (short) 151, (short) 180, (short) 228, (short) 186, (short) 210, (short) 186, (short) 109, (short) 12, (short) 122, (short) 228, (short) 182, (short) 139, (short) 107, (short) 44, (short) 175, (short) 125, (short) 210, (short) 214, (short) 212, (short) 89, (short) 70, (short) 30};
    /* renamed from: b */
    public static final short[] f3875b = new short[]{(short) 214, (short) 190, (short) 159, (short) 65, (short) 85, (short) 170, (short) 121, (short) 215, (short) 49, (short) 63, (short) 229, (short) 179, (short) 225, (short) 233, (short) 253, (short) 22, (short) 162, (short) 29, (short) 211, (short) 213, (short) 240, (short) 97, (short) 111, (short) 207, (short) 239, (short) 99, (short) 64, (short) 0, (short) 232, (short) 244, (short) 195, (short) 64, (short) 16, (short) 232, (short) 137, (short) 131, (short) 133, (short) 80, (short) 245, (short) 151, (short) 177, (short) 44, (short) 134, (short) 236, (short) 109, (short) 157, (short) 183, (short) 15, (short) 228, (short) 111, (short) 120, (short) 152, (short) 161, (short) 93, (short) 86, (short) 57, (short) 46, (short) 88, (short) 173, (short) 87, (short) 14, (short) 148, (short) 86, (short) 62};
    /* renamed from: c */
    private static final char[] f3876c = new char[]{0, 1, 3, 7, 15, 31, '?', 127, 255};

    /* renamed from: a */
    public static void m3893a(byte[] bArr, short[] sArr) {
        int length = bArr.length - 1;
        int length2 = bArr.length;
        if (bArr != null) {
            short[] a = C1396i.m3894a(sArr, length2);
            int length3 = a.length;
            for (length2 = 0; length2 <= length; length2++) {
                int i = a[length2 % length3] % 8;
                int i2 = bArr[length2] ^ -1;
                int i3 = f3876c[i] & i2;
                bArr[length2] = (byte) (((i2 & (f3876c[8 - i] << i)) >>> i) | (i3 << (8 - i)));
            }
        }
    }

    /* renamed from: a */
    private static short[] m3894a(short[] sArr, int i) {
        int length = sArr.length;
        short[] sArr2 = new short[length];
        short s = (short) (i % 256);
        for (int i2 = 0; i2 < length; i2++) {
            sArr2[i2] = (short) (sArr[i2] ^ s);
        }
        return sArr2;
    }

    /* renamed from: b */
    public static void m3895b(byte[] bArr, short[] sArr) {
        int length = bArr.length - 1;
        int length2 = bArr.length;
        if (bArr != null) {
            short[] a = C1396i.m3894a(sArr, length2);
            int length3 = a.length;
            for (length2 = 0; length2 <= length; length2++) {
                int i = a[length2 % length3] % 8;
                byte b = bArr[length2];
                int i2 = (f3876c[i] << (8 - i)) & b;
                bArr[length2] = (byte) (((i2 >>> (8 - i)) | ((b & f3876c[8 - i]) << i)) ^ -1);
            }
        }
    }
}
