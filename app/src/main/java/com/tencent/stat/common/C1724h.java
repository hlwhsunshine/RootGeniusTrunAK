package com.tencent.stat.common;

/* renamed from: com.tencent.stat.common.h */
public class C1724h {
    /* renamed from: a */
    static final /* synthetic */ boolean f5070a = (!C1724h.class.desiredAssertionStatus());

    private C1724h() {
    }

    /* renamed from: a */
    public static byte[] m4749a(byte[] bArr, int i) {
        return C1724h.m4750a(bArr, 0, bArr.length, i);
    }

    /* renamed from: a */
    public static byte[] m4750a(byte[] bArr, int i, int i2, int i3) {
        C1726j c1726j = new C1726j(i3, new byte[((i2 * 3) / 4)]);
        if (!c1726j.mo7917a(bArr, i, i2, true)) {
            try {
                throw new IllegalArgumentException("bad base-64");
            } catch (Exception e) {
            }
        }
        if (c1726j.f5072b == c1726j.f5071a.length) {
            return c1726j.f5071a;
        }
        Object obj = new byte[c1726j.f5072b];
        System.arraycopy(c1726j.f5071a, 0, obj, 0, c1726j.f5072b);
        return obj;
    }

    /* renamed from: b */
    public static byte[] m4751b(byte[] bArr, int i) {
        return C1724h.m4752b(bArr, 0, bArr.length, i);
    }

    /* renamed from: b */
    public static byte[] m4752b(byte[] bArr, int i, int i2, int i3) {
        C1727k c1727k = new C1727k(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!c1727k.f5082d) {
            switch (i2 % 3) {
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (c1727k.f5083e && i2 > 0) {
            i4 += (c1727k.f5084f ? 2 : 1) * (((i2 - 1) / 57) + 1);
        }
        c1727k.f5071a = new byte[i4];
        c1727k.mo7918a(bArr, i, i2, true);
        if (f5070a || c1727k.f5072b == i4) {
            return c1727k.f5071a;
        }
        throw new AssertionError();
    }
}
