package okhttp3.internal.framed;

import com.tencent.xuanfeng.downloadsdkkernel.NetCallUntl;
import java.io.ByteArrayOutputStream;

/* renamed from: okhttp3.internal.framed.s */
final class C1867s {
    /* renamed from: a */
    private static final int[] f5526a = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, NetCallUntl.NET_TYPE_MORE_THAN_3G, NetCallUntl.NET_TYPE_WIFI, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
    /* renamed from: b */
    private static final byte[] f5527b = new byte[]{(byte) 13, (byte) 23, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 24, (byte) 30, (byte) 28, (byte) 28, (byte) 30, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 30, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 6, (byte) 10, (byte) 10, (byte) 12, (byte) 13, (byte) 6, (byte) 8, (byte) 11, (byte) 10, (byte) 10, (byte) 8, (byte) 11, (byte) 8, (byte) 6, (byte) 6, (byte) 6, (byte) 5, (byte) 5, (byte) 5, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 7, (byte) 8, (byte) 15, (byte) 6, (byte) 12, (byte) 10, (byte) 13, (byte) 6, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 8, (byte) 7, (byte) 8, (byte) 13, (byte) 19, (byte) 13, (byte) 14, (byte) 6, (byte) 15, (byte) 5, (byte) 6, (byte) 5, (byte) 6, (byte) 5, (byte) 6, (byte) 6, (byte) 6, (byte) 5, (byte) 7, (byte) 7, (byte) 6, (byte) 6, (byte) 6, (byte) 5, (byte) 6, (byte) 7, (byte) 6, (byte) 5, (byte) 5, (byte) 6, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 15, (byte) 11, (byte) 14, (byte) 13, (byte) 28, (byte) 20, (byte) 22, (byte) 20, (byte) 20, (byte) 22, (byte) 22, (byte) 22, (byte) 23, (byte) 22, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 24, (byte) 23, (byte) 24, (byte) 24, (byte) 22, (byte) 23, (byte) 24, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 21, (byte) 22, (byte) 23, (byte) 22, (byte) 23, (byte) 23, (byte) 24, (byte) 22, (byte) 21, (byte) 20, (byte) 22, (byte) 22, (byte) 23, (byte) 23, (byte) 21, (byte) 23, (byte) 22, (byte) 22, (byte) 24, (byte) 21, (byte) 22, (byte) 23, (byte) 23, (byte) 21, (byte) 21, (byte) 22, (byte) 21, (byte) 23, (byte) 22, (byte) 23, (byte) 23, (byte) 20, (byte) 22, (byte) 22, (byte) 22, (byte) 23, (byte) 22, (byte) 22, (byte) 23, (byte) 26, (byte) 26, (byte) 20, (byte) 19, (byte) 22, (byte) 23, (byte) 22, (byte) 25, (byte) 26, (byte) 26, (byte) 26, (byte) 27, (byte) 27, (byte) 26, (byte) 24, (byte) 25, (byte) 19, (byte) 21, (byte) 26, (byte) 27, (byte) 27, (byte) 26, (byte) 27, (byte) 24, (byte) 21, (byte) 21, (byte) 26, (byte) 26, (byte) 28, (byte) 27, (byte) 27, (byte) 27, (byte) 20, (byte) 24, (byte) 20, (byte) 21, (byte) 22, (byte) 21, (byte) 21, (byte) 23, (byte) 22, (byte) 22, (byte) 25, (byte) 25, (byte) 24, (byte) 24, (byte) 26, (byte) 23, (byte) 26, (byte) 27, (byte) 26, (byte) 26, (byte) 27, (byte) 27, (byte) 27, (byte) 27, (byte) 27, (byte) 28, (byte) 27, (byte) 27, (byte) 27, (byte) 27, (byte) 27, (byte) 26};
    /* renamed from: c */
    private static final C1867s f5528c = new C1867s();
    /* renamed from: d */
    private final C1866a f5529d = new C1866a();

    /* renamed from: okhttp3.internal.framed.s$a */
    private static final class C1866a {
        /* renamed from: a */
        private final C1866a[] f5523a;
        /* renamed from: b */
        private final int f5524b;
        /* renamed from: c */
        private final int f5525c;

        C1866a() {
            this.f5523a = new C1866a[256];
            this.f5524b = 0;
            this.f5525c = 0;
        }

        C1866a(int i, int i2) {
            this.f5523a = null;
            this.f5524b = i;
            int i3 = i2 & 7;
            if (i3 == 0) {
                i3 = 8;
            }
            this.f5525c = i3;
        }
    }

    private C1867s() {
        m5279b();
    }

    /* renamed from: a */
    public static C1867s m5278a() {
        return f5528c;
    }

    /* JADX WARNING: Missing block: B:14:0x004a, code:
            r1 = 8 - r1;
            r2 = (r4 << r1) & 255;
            r4 = 1 << r1;
            r1 = r2;
     */
    /* JADX WARNING: Missing block: B:16:0x0055, code:
            if (r1 >= (r2 + r4)) goto L_0x0060;
     */
    /* JADX WARNING: Missing block: B:17:0x0057, code:
            okhttp3.internal.framed.C1867s.C1866a.m5275a(r3)[r1] = r5;
            r1 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:18:0x0060, code:
            r0 = r0 + 1;
     */
    /* renamed from: b */
    private void m5279b() {
        /*
        r8 = this;
        r0 = 0;
    L_0x0001:
        r1 = f5527b;
        r1 = r1.length;
        if (r0 >= r1) goto L_0x0063;
    L_0x0006:
        r1 = f5526a;
        r4 = r1[r0];
        r1 = f5527b;
        r1 = r1[r0];
        r5 = new okhttp3.internal.framed.s$a;
        r5.<init>(r0, r1);
        r2 = r8.f5529d;
        r3 = r2;
    L_0x0016:
        r2 = 8;
        if (r1 <= r2) goto L_0x004a;
    L_0x001a:
        r1 = r1 + -8;
        r1 = (byte) r1;
        r2 = r4 >>> r1;
        r2 = r2 & 255;
        r6 = r3.f5523a;
        if (r6 != 0) goto L_0x002f;
    L_0x0027:
        r0 = new java.lang.IllegalStateException;
        r1 = "invalid dictionary: prefix not unique";
        r0.<init>(r1);
        throw r0;
    L_0x002f:
        r6 = r3.f5523a;
        r6 = r6[r2];
        if (r6 != 0) goto L_0x0042;
    L_0x0037:
        r6 = r3.f5523a;
        r7 = new okhttp3.internal.framed.s$a;
        r7.<init>();
        r6[r2] = r7;
    L_0x0042:
        r3 = r3.f5523a;
        r2 = r3[r2];
        r3 = r2;
        goto L_0x0016;
    L_0x004a:
        r1 = 8 - r1;
        r2 = r4 << r1;
        r2 = r2 & 255;
        r4 = 1;
        r4 = r4 << r1;
        r1 = r2;
    L_0x0053:
        r6 = r2 + r4;
        if (r1 >= r6) goto L_0x0060;
    L_0x0057:
        r6 = r3.f5523a;
        r6[r1] = r5;
        r1 = r1 + 1;
        goto L_0x0053;
    L_0x0060:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x0063:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.s.b():void");
    }

    /* renamed from: a */
    final byte[] mo8807a(byte[] bArr) {
        int i = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        C1866a c1866a = this.f5529d;
        int i3 = 0;
        while (i < bArr.length) {
            i2 = (i2 << 8) | (bArr[i] & 255);
            i3 += 8;
            while (i3 >= 8) {
                c1866a = c1866a.f5523a[(i2 >>> (i3 - 8)) & 255];
                if (c1866a.f5523a == null) {
                    byteArrayOutputStream.write(c1866a.f5524b);
                    i3 -= c1866a.f5525c;
                    c1866a = this.f5529d;
                } else {
                    i3 -= 8;
                }
            }
            i++;
        }
        while (i3 > 0) {
            C1866a c1866a2 = c1866a.f5523a[(i2 << (8 - i3)) & 255];
            if (c1866a2.f5523a != null || c1866a2.f5525c > i3) {
                break;
            }
            byteArrayOutputStream.write(c1866a2.f5524b);
            i3 -= c1866a2.f5525c;
            c1866a = this.f5529d;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
