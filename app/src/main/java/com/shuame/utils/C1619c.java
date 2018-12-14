package com.shuame.utils;

/* renamed from: com.shuame.utils.c */
public final class C1619c {
    /* renamed from: a */
    public static final short[] f4578a = new short[]{(short) 243, (short) 209, (short) 234, (short) 67, (short) 71, (short) 177, (short) 179, (short) 197, (short) 118, (short) 180, (short) 14, (short) 151, (short) 181, (short) 228, (short) 186, (short) 175, (short) 125, (short) 211, (short) 214, (short) 212, (short) 210, (short) 186, (short) 125, (short) 12, (short) 122, (short) 228, (short) 182, (short) 139, (short) 107, (short) 44, (short) 89, (short) 70, (short) 30, (short) 177, (short) 15, (short) 97, (short) 6, (short) 154, (short) 20, (short) 130, (short) 72, (short) 126, (short) 78, (short) 62, (short) 134, (short) 51, (short) 101, (short) 191, (short) 193, (short) 57, (short) 161, (short) 138, (short) 29, (short) 175, (short) 152, (short) 104, (short) 78, (short) 94, (short) 16, (short) 38, (short) 151, (short) 230, (short) 6, (short) 82};
    /* renamed from: b */
    public static final short[] f4579b = new short[]{(short) 177, (short) 15, (short) 105, (short) 78, (short) 94, (short) 1, (short) 38, (short) 151, (short) 230, (short) 6, (short) 82, (short) 6, (short) 154, (short) 20, (short) 97, (short) 191, (short) 193, (short) 57, (short) 161, (short) 138, (short) 29, (short) 175, (short) 152, (short) 130, (short) 72, (short) 113, (short) 78, (short) 62, (short) 134, (short) 51, (short) 21, (short) 71, (short) 177, (short) 179, (short) 197, (short) 118, (short) 190, (short) 243, (short) 209, (short) 234, (short) 67, (short) 14, (short) 151, (short) 180, (short) 228, (short) 186, (short) 210, (short) 186, (short) 109, (short) 12, (short) 122, (short) 228, (short) 182, (short) 139, (short) 107, (short) 44, (short) 175, (short) 125, (short) 210, (short) 214, (short) 212, (short) 89, (short) 70, (short) 30};
    /* renamed from: c */
    public static final short[] f4580c = new short[]{(short) 214, (short) 190, (short) 159, (short) 65, (short) 85, (short) 170, (short) 121, (short) 215, (short) 49, (short) 63, (short) 229, (short) 179, (short) 225, (short) 233, (short) 253, (short) 22, (short) 162, (short) 29, (short) 211, (short) 213, (short) 240, (short) 97, (short) 111, (short) 207, (short) 239, (short) 99, (short) 64, (short) 0, (short) 232, (short) 244, (short) 195, (short) 64, (short) 16, (short) 232, (short) 137, (short) 131, (short) 133, (short) 80, (short) 245, (short) 151, (short) 177, (short) 44, (short) 134, (short) 236, (short) 109, (short) 157, (short) 183, (short) 15, (short) 228, (short) 111, (short) 120, (short) 152, (short) 161, (short) 93, (short) 86, (short) 57, (short) 46, (short) 88, (short) 173, (short) 87, (short) 14, (short) 148, (short) 86, (short) 62};
    /* renamed from: d */
    private static final char[] f4581d = new char[]{0, 1, 3, 7, 15, 31, '?', 127, 255};

    /* renamed from: a */
    public static void m4390a(byte[] bArr, short[] sArr) {
        int i = 0;
        int length = bArr.length - 1;
        int length2 = bArr.length;
        if (bArr != null) {
            int length3 = sArr.length;
            short[] sArr2 = new short[length3];
            short s = (short) (length2 % 256);
            for (length2 = 0; length2 < length3; length2++) {
                sArr2[length2] = (short) (sArr[length2] ^ s);
            }
            while (i <= length) {
                length2 = sArr2[i % length3] % 8;
                int i2 = bArr[i] ^ -1;
                int i3 = f4581d[length2] & i2;
                bArr[i] = (byte) (((i2 & (f4581d[8 - length2] << length2)) >>> length2) | (i3 << (8 - length2)));
                i++;
            }
        }
    }
}
