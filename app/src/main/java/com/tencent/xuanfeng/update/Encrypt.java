package com.tencent.xuanfeng.update;

import java.util.Random;

public class Encrypt {
    static final long DELTA = 2654435769L;
    public static final String KEY = "www.tencent.com.";
    public static final int LOG_ROUNDS = 4;
    public static final int ROUNDS = 16;
    public static final int SALT_LEN = 2;
    public static final String URL = "http://119.147.66.34/mobile_update/dyn_load";
    public static final int ZERO_LEN = 7;

    public static byte[] H2NL(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    public static long N2HL(byte[] bArr) {
        long[] jArr = new long[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            jArr[i] = (long) transform(bArr[i]);
        }
        long j = jArr[2] << 8;
        return (((jArr[0] << 24) | (jArr[1] << 16)) | j) | jArr[3];
    }

    static byte[] TeaEncryptECB(byte[] bArr, byte[] bArr2) {
        Object obj = new byte[8];
        long[] jArr = new long[4];
        Object obj2 = new byte[4];
        System.arraycopy(bArr, 0, obj2, 0, 4);
        long N2HL = N2HL(obj2);
        System.arraycopy(bArr, 4, obj2, 0, 4);
        long N2HL2 = N2HL(obj2);
        for (int i = 0; i < 4; i++) {
            System.arraycopy(bArr2, i * 4, obj2, 0, 4);
            jArr[i] = N2HL(obj2);
        }
        long j = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            j += DELTA;
            N2HL = cleanZero(N2HL + cleanZero(((cleanZero(N2HL2 << 4) + jArr[0]) ^ cleanZero(N2HL2 + j)) ^ cleanZero((N2HL2 >>> 5) + jArr[1])));
            long cleanZero = cleanZero(N2HL << 4) + jArr[2];
            long cleanZero2 = cleanZero(N2HL + j);
            N2HL2 = cleanZero(N2HL2 + cleanZero((cleanZero(cleanZero) ^ cleanZero2) ^ cleanZero((N2HL >>> 5) + jArr[3])));
        }
        System.arraycopy(H2NL((int) N2HL), 0, obj, 0, 4);
        System.arraycopy(H2NL((int) N2HL2), 0, obj, 4, 4);
        return obj;
    }

    public static String bytesToHexString(byte[] bArr) {
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
        return stringBuilder.toString();
    }

    public static long cleanZero(long j) {
        return 4294967295L & j;
    }

    public static void encrypt() {
        byte[] bytes = KEY.getBytes();
        final byte[] oi_symmetry_encrypt2 = oi_symmetry_encrypt2("t=m&&v=15&&i=1329965849070&&f=7&&m=MB860&&packname=com.xuanfeng&&installed=false&&clicked=true&&lan=en", bytes);
        Decrypt.oi_symmetry_decrypt2(oi_symmetry_encrypt2, bytes);
        new Thread(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:13:0x0041  */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
            public java.io.InputStream http(java.lang.String r6, byte[] r7) {
                /*
                r5 = this;
                r2 = 0;
                r0 = new java.net.URL;	 Catch:{ Exception -> 0x003a, all -> 0x0045 }
                r0.<init>(r6);	 Catch:{ Exception -> 0x003a, all -> 0x0045 }
                r0 = r0.openConnection();	 Catch:{ Exception -> 0x003a, all -> 0x0045 }
                r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x003a, all -> 0x0045 }
                r1 = "POST";
                r0.setRequestMethod(r1);	 Catch:{ Exception -> 0x0053, all -> 0x004c }
                r1 = 1;
                r0.setDoOutput(r1);	 Catch:{ Exception -> 0x0053, all -> 0x004c }
                r1 = 1;
                r0.setDoInput(r1);	 Catch:{ Exception -> 0x0053, all -> 0x004c }
                r1 = 0;
                r0.setUseCaches(r1);	 Catch:{ Exception -> 0x0053, all -> 0x004c }
                r1 = "Content-Type";
                r3 = "binary/octet-stream";
                r0.setRequestProperty(r1, r3);	 Catch:{ Exception -> 0x0053, all -> 0x004c }
                r1 = r0.getOutputStream();	 Catch:{ Exception -> 0x0053, all -> 0x004c }
                r1.write(r7);	 Catch:{ Exception -> 0x0053, all -> 0x004c }
                r1.flush();	 Catch:{ Exception -> 0x0053, all -> 0x004c }
                r1.close();	 Catch:{ Exception -> 0x0053, all -> 0x004c }
                r0.getInputStream();	 Catch:{ Exception -> 0x0053, all -> 0x004c }
                if (r0 == 0) goto L_0x0039;
            L_0x0036:
                r0.disconnect();
            L_0x0039:
                return r2;
            L_0x003a:
                r0 = move-exception;
                r1 = r2;
            L_0x003c:
                r0.printStackTrace();	 Catch:{ all -> 0x0050 }
                if (r1 == 0) goto L_0x0039;
            L_0x0041:
                r1.disconnect();
                goto L_0x0039;
            L_0x0045:
                r0 = move-exception;
            L_0x0046:
                if (r2 == 0) goto L_0x004b;
            L_0x0048:
                r2.disconnect();
            L_0x004b:
                throw r0;
            L_0x004c:
                r1 = move-exception;
                r2 = r0;
                r0 = r1;
                goto L_0x0046;
            L_0x0050:
                r0 = move-exception;
                r2 = r1;
                goto L_0x0046;
            L_0x0053:
                r1 = move-exception;
                r4 = r1;
                r1 = r0;
                r0 = r4;
                goto L_0x003c;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.xuanfeng.update.Encrypt.1.http(java.lang.String, byte[]):java.io.InputStream");
            }

            public void run() {
                http(Encrypt.URL, oi_symmetry_encrypt2);
            }
        }).start();
    }

    static byte[] oi_symmetry_encrypt2(String str, byte[] bArr) {
        int i;
        int i2;
        Object obj = new byte[1024];
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        Object obj2 = new byte[8];
        Object obj3 = new byte[8];
        Object obj4 = new byte[1024];
        int i3 = (((length + 1) + 2) + 7) % 8;
        if (i3 != 0) {
            i3 = 8 - i3;
        }
        Random random = new Random();
        obj2[0] = (byte) ((((byte) random.nextInt(255)) & 248) | ((byte) i3));
        int i4 = 1;
        while (true) {
            i = i3 - 1;
            if (i3 == 0) {
                break;
            }
            i3 = i4 + 1;
            obj2[i4] = (byte) random.nextInt(255);
            i4 = i3;
            i3 = i;
        }
        for (i3 = 0; i3 < 8; i3++) {
            obj3[i3] = (byte) 0;
        }
        i3 = 0;
        i = 1;
        while (i <= 2) {
            if (i4 < 8) {
                i2 = i4 + 1;
                obj2[i4] = (byte) random.nextInt(255);
                i++;
                i4 = i2;
            }
            if (i4 == 8) {
                for (i4 = 0; i4 < 8; i4++) {
                    obj2[i4] = (byte) (obj2[i4] ^ obj4[i4]);
                }
                System.arraycopy(TeaEncryptECB(obj2, bArr), 0, obj, i3, 8);
                for (i4 = 0; i4 < 8; i4++) {
                    i2 = i4 + i3;
                    obj[i2] = (byte) (obj[i2] ^ obj3[i4]);
                }
                System.arraycopy(obj2, 0, obj3, 0, 8);
                i4 = 0;
                System.arraycopy(obj, i3, obj4, 0, 8);
                i3 += 8;
            }
        }
        int i5 = length;
        length = 0;
        i = i4;
        while (i5 != 0) {
            if (i < 8) {
                i2 = i + 1;
                i4 = length + 1;
                obj2[i] = bytes[length];
                length = i5 - 1;
                i = i4;
                i4 = i2;
            } else {
                i4 = i;
                i = length;
                length = i5;
            }
            if (i4 == 8) {
                for (i4 = 0; i4 < 8; i4++) {
                    obj2[i4] = (byte) (obj2[i4] ^ obj4[i4]);
                }
                System.arraycopy(TeaEncryptECB(obj2, bArr), 0, obj, i3, 8);
                for (i4 = 0; i4 < 8; i4++) {
                    i2 = i4 + i3;
                    obj[i2] = (byte) (obj[i2] ^ obj3[i4]);
                }
                System.arraycopy(obj2, 0, obj3, 0, 8);
                System.arraycopy(obj, i3, obj4, 0, 8);
                i3 += 8;
                i5 = length;
                length = i;
                i = 0;
            } else {
                i5 = length;
                length = i;
                i = i4;
            }
        }
        i4 = 1;
        while (true) {
            length = i3;
            i3 = i4;
            if (i3 > 7) {
                Object obj5 = new byte[length];
                System.arraycopy(obj, 0, obj5, 0, length);
                return obj5;
            }
            if (i < 8) {
                i4 = i + 1;
                obj2[i] = (byte) 0;
                int i6 = i3 + 1;
                i3 = i4;
                i4 = i6;
            } else {
                i4 = i3;
                i3 = i;
            }
            i = 8;
            if (i3 == 8) {
                for (i3 = 0; i3 < 8; i3++) {
                    obj2[i3] = (byte) (obj2[i3] ^ obj4[i3]);
                }
                System.arraycopy(TeaEncryptECB(obj2, bArr), 0, obj, length, 8);
                for (i3 = 0; i3 < 8; i3++) {
                    i = i3 + length;
                    obj[i] = (byte) (obj[i] ^ obj3[i3]);
                }
                System.arraycopy(obj2, 0, obj3, 0, 8);
                i = 0;
                System.arraycopy(obj, length, obj4, 0, 8);
                i3 = length + 8;
            }
        }
    }

    private static int transform(byte b) {
        return b < (byte) 0 ? b + 256 : b;
    }
}
