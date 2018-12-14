package com.tencent.mid.util;

import java.io.UnsupportedEncodingException;

public class Base64 {
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;
    /* renamed from: a */
    static final /* synthetic */ boolean f4698a = (!Base64.class.desiredAssertionStatus());

    private Base64() {
    }

    public static byte[] decode(String str, int i) {
        return decode(str.getBytes(), i);
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        C1651b c1651b = new C1651b(i3, new byte[((i2 * 3) / 4)]);
        if (!c1651b.mo7668a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (c1651b.f4700b == c1651b.f4699a.length) {
            return c1651b.f4699a;
        } else {
            Object obj = new byte[c1651b.f4700b];
            System.arraycopy(c1651b.f4699a, 0, obj, 0, c1651b.f4700b);
            return obj;
        }
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        C1652c c1652c = new C1652c(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!c1652c.f4710d) {
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
        if (c1652c.f4711e && i2 > 0) {
            i4 += (c1652c.f4712f ? 2 : 1) * (((i2 - 1) / 57) + 1);
        }
        c1652c.f4699a = new byte[i4];
        c1652c.mo7669a(bArr, i, i2, true);
        if (f4698a || c1652c.f4700b == i4) {
            return c1652c.f4699a;
        }
        throw new AssertionError();
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(encode(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static String encodeToString(byte[] bArr, int i, int i2, int i3) {
        try {
            return new String(encode(bArr, i, i2, i3), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
