package com.tencent.xuanfeng.update;

public class Decrypt {
    static byte[] TeaDecryptECB(byte[] bArr, byte[] bArr2) {
        Object obj = new byte[8];
        long[] jArr = new long[4];
        Object obj2 = new byte[4];
        System.arraycopy(bArr, 0, obj2, 0, 4);
        long N2HL = Encrypt.N2HL(obj2);
        System.arraycopy(bArr, 4, obj2, 0, 4);
        long N2HL2 = Encrypt.N2HL(obj2);
        for (int i = 0; i < 4; i++) {
            System.arraycopy(bArr2, i * 4, obj2, 0, 4);
            jArr[i] = Encrypt.N2HL(obj2);
        }
        long cleanZero = Encrypt.cleanZero(42470972304L);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            long j = cleanZero;
            if (i3 >= 16) {
                System.arraycopy(Encrypt.H2NL((int) N2HL), 0, obj, 0, 4);
                System.arraycopy(Encrypt.H2NL((int) N2HL2), 0, obj, 4, 4);
                return obj;
            }
            N2HL2 -= (Encrypt.cleanZero(Encrypt.cleanZero(N2HL << 4) + jArr[2]) ^ Encrypt.cleanZero(N2HL + j)) ^ Encrypt.cleanZero(jArr[3] + Encrypt.cleanZero(N2HL >>> 5));
            if (N2HL2 < 0) {
                N2HL2 += 4294967296L;
            }
            cleanZero = N2HL - ((Encrypt.cleanZero(Encrypt.cleanZero(N2HL2 << 4) + jArr[0]) ^ Encrypt.cleanZero(N2HL2 + j)) ^ Encrypt.cleanZero(Encrypt.cleanZero(N2HL2 >>> 5) + jArr[1]));
            N2HL = cleanZero < 0 ? cleanZero + 4294967296L : cleanZero;
            cleanZero = j - 2654435769L;
            if (cleanZero < 0) {
                cleanZero += 4294967296L;
            }
            i2 = i3 + 1;
        }
    }

    public static String oi_symmetry_decrypt2(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[8];
        Object obj = new byte[8];
        Object obj2 = new byte[1024];
        int length = bArr.length;
        Object obj3 = new byte[1024];
        Object obj4 = new byte[1024];
        if (length % 8 != 0 || length < 16) {
            return null;
        }
        int i;
        Object obj5;
        System.arraycopy(TeaDecryptECB(bArr, bArr2), 0, bArr3, 0, 8);
        int i2 = bArr3[0] & 7;
        int i3 = (((length - 1) - i2) - 2) - 7;
        for (i = 0; i < 8; i++) {
            obj[i] = (byte) 0;
        }
        System.arraycopy(obj, 0, obj3, 0, 8);
        System.arraycopy(bArr, 0, obj4, 0, bArr.length);
        i = length - 8;
        Object obj6 = new byte[i];
        System.arraycopy(bArr, 8, obj6, 0, i);
        int i4 = 8;
        int i5 = i2 + 1;
        int i6 = 1;
        while (i6 <= 2) {
            if (i5 < 8) {
                i5++;
                i6++;
            } else if (i5 == 8) {
                System.arraycopy(obj4, 0, obj3, 0, 1024);
                System.arraycopy(obj6, 0, obj4, 0, obj6.length);
                for (i2 = 0; i2 < 8; i2++) {
                    if (i4 + i2 >= length) {
                        return null;
                    }
                    bArr3[i2] = (byte) (bArr3[i2] ^ obj6[i2]);
                }
                bArr3 = TeaDecryptECB(bArr3, bArr2);
                i -= 8;
                obj5 = new byte[i];
                System.arraycopy(obj6, 8, obj5, 0, i);
                i4 += 8;
                i5 = 0;
                obj6 = obj5;
            } else {
                continue;
            }
        }
        i6 = 0;
        int i7 = i3;
        while (i7 != 0) {
            if (i5 < 8) {
                obj2[i6] = (byte) (bArr3[i5] ^ obj3[i5]);
                i5++;
                i7--;
                i6++;
            } else if (i5 == 8) {
                System.arraycopy(obj4, 0, obj3, 0, 1024);
                System.arraycopy(obj6, 0, obj4, 0, obj6.length);
                for (i2 = 0; i2 < 8; i2++) {
                    if (i4 + i2 >= length) {
                        return null;
                    }
                    bArr3[i2] = (byte) (bArr3[i2] ^ obj6[i2]);
                }
                bArr3 = TeaDecryptECB(bArr3, bArr2);
                i -= 8;
                obj5 = new byte[i];
                System.arraycopy(obj6, 8, obj5, 0, i);
                i4 += 8;
                i5 = 0;
                obj6 = obj5;
            } else {
                continue;
            }
        }
        Object obj7 = obj6;
        byte[] bArr4 = bArr3;
        i2 = i4;
        i4 = i;
        i = i5;
        i5 = 1;
        while (i5 <= 7) {
            if (i < 8) {
                if ((bArr4[i] ^ obj3[i]) != 0) {
                    return null;
                }
                i5++;
                i++;
            } else if (i == 8) {
                System.arraycopy(obj4, 0, obj3, 0, 1024);
                System.arraycopy(obj7, 0, obj4, 0, obj7.length);
                for (i = 0; i < 8; i++) {
                    if (i2 + i >= length) {
                        return null;
                    }
                    bArr4[i] = (byte) (bArr4[i] ^ obj7[i]);
                }
                bArr3 = TeaDecryptECB(bArr4, bArr2);
                i = i4 - 8;
                obj6 = new byte[i];
                System.arraycopy(obj7, 8, obj6, 0, i);
                obj7 = obj6;
                bArr4 = bArr3;
                i2 += 8;
                i4 = i;
                i = 0;
            } else {
                continue;
            }
        }
        obj = new byte[i2];
        System.arraycopy(obj2, 0, obj, 0, i3);
        return new String(obj);
    }
}
