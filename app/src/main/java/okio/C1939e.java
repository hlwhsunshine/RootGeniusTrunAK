package okio;

import android.content.p013pm.PermissionInfo;
import android.support.p015v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* renamed from: okio.e */
public final class C1939e implements Cloneable, C1937g, C1938h {
    /* renamed from: c */
    private static final byte[] f5805c = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    /* renamed from: a */
    C1952u f5806a;
    /* renamed from: b */
    long f5807b;

    /* renamed from: a */
    private String m5631a(long j, Charset charset) {
        C1933aa.m5591a(this.f5807b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            C1952u c1952u = this.f5806a;
            if (((long) c1952u.f5836b) + j > ((long) c1952u.f5837c)) {
                return new String(mo9029e(j), charset);
            }
            String str = new String(c1952u.f5835a, c1952u.f5836b, (int) j, charset);
            c1952u.f5836b = (int) (((long) c1952u.f5836b) + j);
            this.f5807b -= j;
            if (c1952u.f5836b != c1952u.f5837c) {
                return str;
            }
            this.f5806a = c1952u.mo9083a();
            C1953v.m5757a(c1952u);
            return str;
        }
    }

    /* renamed from: c */
    private void m5632c(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int a = mo9040a(bArr, i, bArr.length - i);
            if (a == -1) {
                throw new EOFException();
            }
            i += a;
        }
    }

    /* renamed from: k */
    private String m5633k(long j) {
        return m5631a(j, C1933aa.f5798a);
    }

    /* renamed from: a */
    public final int mo9040a(byte[] bArr, int i, int i2) {
        C1933aa.m5591a((long) bArr.length, (long) i, (long) i2);
        C1952u c1952u = this.f5806a;
        if (c1952u == null) {
            return -1;
        }
        int min = Math.min(i2, c1952u.f5837c - c1952u.f5836b);
        System.arraycopy(c1952u.f5835a, c1952u.f5836b, bArr, i, min);
        c1952u.f5836b += min;
        this.f5807b -= (long) min;
        if (c1952u.f5836b != c1952u.f5837c) {
            return min;
        }
        this.f5806a = c1952u.mo9083a();
        C1953v.m5757a(c1952u);
        return min;
    }

    /* renamed from: a */
    public final long mo9024a(byte b) {
        return mo9041a(b, 0);
    }

    /* renamed from: a */
    public final long mo9041a(byte b, long j) {
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        C1952u c1952u = this.f5806a;
        if (c1952u == null) {
            return -1;
        }
        C1952u c1952u2;
        if (this.f5807b - j >= j) {
            c1952u2 = c1952u;
            while (true) {
                long j3 = ((long) (c1952u2.f5837c - c1952u2.f5836b)) + j2;
                if (j3 >= j) {
                    break;
                }
                c1952u2 = c1952u2.f5840f;
                j2 = j3;
            }
        } else {
            j2 = this.f5807b;
            c1952u2 = c1952u;
            while (j2 > j) {
                c1952u2 = c1952u2.f5841g;
                j2 -= (long) (c1952u2.f5837c - c1952u2.f5836b);
            }
        }
        while (j2 < this.f5807b) {
            byte[] bArr = c1952u2.f5835a;
            int i = c1952u2.f5837c;
            for (int i2 = (int) ((((long) c1952u2.f5836b) + j) - j2); i2 < i; i2++) {
                if (bArr[i2] == b) {
                    return j2 + ((long) (i2 - c1952u2.f5836b));
                }
            }
            j2 += (long) (c1952u2.f5837c - c1952u2.f5836b);
            c1952u2 = c1952u2.f5840f;
            j = j2;
        }
        return -1;
    }

    /* renamed from: a */
    public final long mo8763a(C1939e c1939e, long j) {
        if (c1939e == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f5807b == 0) {
            return -1;
        } else {
            if (j > this.f5807b) {
                j = this.f5807b;
            }
            c1939e.mo8704a_(this, j);
            return j;
        }
    }

    /* renamed from: a */
    public final long mo9011a(C1850x c1850x) {
        if (c1850x == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a = c1850x.mo8763a(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (a == -1) {
                return j;
            }
            j += a;
        }
    }

    /* renamed from: a */
    public final C1939e mo9042a(int i) {
        if (i < 128) {
            mo9020h(i);
        } else if (i < 2048) {
            mo9020h((i >> 6) | 192);
            mo9020h((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                mo9020h((i >> 12) | 224);
                mo9020h(((i >> 6) & 63) | 128);
                mo9020h((i & 63) | 128);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
        } else if (i <= 1114111) {
            mo9020h((i >> 18) | PermissionInfo.PROTECTION_MASK_FLAGS);
            mo9020h(((i >> 12) & 63) | 128);
            mo9020h(((i >> 6) & 63) | 128);
            mo9020h((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    /* renamed from: a */
    public final C1939e mo9012b(String str) {
        return mo9044a(str, 0, str.length());
    }

    /* renamed from: a */
    public final C1939e mo9044a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else {
            while (i < i2) {
                char charAt = str.charAt(i);
                int i3;
                if (charAt < 128) {
                    int i4;
                    C1952u e = mo9056e(1);
                    byte[] bArr = e.f5835a;
                    int i5 = e.f5837c - i;
                    int min = Math.min(i2, 8192 - i5);
                    i3 = i + 1;
                    bArr[i5 + i] = (byte) charAt;
                    while (i3 < min) {
                        char charAt2 = str.charAt(i3);
                        if (charAt2 >= 128) {
                            break;
                        }
                        i4 = i3 + 1;
                        bArr[i3 + i5] = (byte) charAt2;
                        i3 = i4;
                    }
                    i4 = (i3 + i5) - e.f5837c;
                    e.f5837c += i4;
                    this.f5807b += (long) i4;
                    i = i3;
                } else if (charAt < 2048) {
                    mo9020h((charAt >> 6) | 192);
                    mo9020h((charAt & 63) | 128);
                    i++;
                } else if (charAt < 55296 || charAt > 57343) {
                    mo9020h((charAt >> 12) | 224);
                    mo9020h(((charAt >> 6) & 63) | 128);
                    mo9020h((charAt & 63) | 128);
                    i++;
                } else {
                    i3 = i + 1 < i2 ? str.charAt(i + 1) : 0;
                    if (charAt > 56319 || i3 < 56320 || i3 > 57343) {
                        mo9020h(63);
                        i++;
                    } else {
                        i3 = ((i3 & -56321) | ((charAt & -55297) << 10)) + 65536;
                        mo9020h((i3 >> 18) | PermissionInfo.PROTECTION_MASK_FLAGS);
                        mo9020h(((i3 >> 12) & 63) | 128);
                        mo9020h(((i3 >> 6) & 63) | 128);
                        mo9020h((i3 & 63) | 128);
                        i += 2;
                    }
                }
            }
            return this;
        }
    }

    /* renamed from: a */
    public final C1939e mo9013b(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write(this);
        return this;
    }

    /* renamed from: a */
    public final C1939e mo9046a(C1939e c1939e, long j, long j2) {
        if (c1939e == null) {
            throw new IllegalArgumentException("out == null");
        }
        C1933aa.m5591a(this.f5807b, j, j2);
        if (j2 != 0) {
            c1939e.f5807b += j2;
            C1952u c1952u = this.f5806a;
            while (j >= ((long) (c1952u.f5837c - c1952u.f5836b))) {
                j -= (long) (c1952u.f5837c - c1952u.f5836b);
                c1952u = c1952u.f5840f;
            }
            while (j2 > 0) {
                C1952u c1952u2 = new C1952u(c1952u);
                c1952u2.f5836b = (int) (((long) c1952u2.f5836b) + j);
                c1952u2.f5837c = Math.min(c1952u2.f5836b + ((int) j2), c1952u2.f5837c);
                if (c1939e.f5806a == null) {
                    c1952u2.f5841g = c1952u2;
                    c1952u2.f5840f = c1952u2;
                    c1939e.f5806a = c1952u2;
                } else {
                    c1939e.f5806a.f5841g.mo9084a(c1952u2);
                }
                j2 -= (long) (c1952u2.f5837c - c1952u2.f5836b);
                c1952u = c1952u.f5840f;
                j = 0;
            }
        }
        return this;
    }

    /* renamed from: a */
    public final C1939e mo9014b(byte[] bArr) {
        if (bArr != null) {
            return mo9016c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public final C1852y mo8703a() {
        return C1852y.f5460b;
    }

    /* renamed from: a */
    public final void mo9025a(long j) {
        if (this.f5807b < j) {
            throw new EOFException();
        }
    }

    /* renamed from: a_ */
    public final void mo8704a_(C1939e c1939e, long j) {
        if (c1939e == null) {
            throw new IllegalArgumentException("source == null");
        } else if (c1939e == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            C1933aa.m5591a(c1939e.f5807b, 0, j);
            while (j > 0) {
                C1952u c1952u;
                C1952u c1952u2;
                if (j < ((long) (c1939e.f5806a.f5837c - c1939e.f5806a.f5836b))) {
                    c1952u = this.f5806a != null ? this.f5806a.f5841g : null;
                    if (c1952u != null && c1952u.f5839e) {
                        if ((((long) c1952u.f5837c) + j) - ((long) (c1952u.f5838d ? 0 : c1952u.f5836b)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            c1939e.f5806a.mo9085a(c1952u, (int) j);
                            c1939e.f5807b -= j;
                            this.f5807b += j;
                            return;
                        }
                    }
                    c1952u = c1939e.f5806a;
                    int i = (int) j;
                    if (i <= 0 || i > c1952u.f5837c - c1952u.f5836b) {
                        throw new IllegalArgumentException();
                    }
                    if (i >= 1024) {
                        c1952u2 = new C1952u(c1952u);
                    } else {
                        c1952u2 = C1953v.m5756a();
                        System.arraycopy(c1952u.f5835a, c1952u.f5836b, c1952u2.f5835a, 0, i);
                    }
                    c1952u2.f5837c = c1952u2.f5836b + i;
                    c1952u.f5836b = i + c1952u.f5836b;
                    c1952u.f5841g.mo9084a(c1952u2);
                    c1939e.f5806a = c1952u2;
                }
                c1952u2 = c1939e.f5806a;
                long j2 = (long) (c1952u2.f5837c - c1952u2.f5836b);
                c1939e.f5806a = c1952u2.mo9083a();
                if (this.f5806a == null) {
                    this.f5806a = c1952u2;
                    c1952u2 = this.f5806a;
                    c1952u = this.f5806a;
                    C1952u c1952u3 = this.f5806a;
                    c1952u.f5841g = c1952u3;
                    c1952u2.f5840f = c1952u3;
                } else {
                    c1952u = this.f5806a.f5841g.mo9084a(c1952u2);
                    if (c1952u.f5841g == c1952u) {
                        throw new IllegalStateException();
                    } else if (c1952u.f5841g.f5839e) {
                        int i2 = c1952u.f5837c - c1952u.f5836b;
                        if (i2 <= (c1952u.f5841g.f5838d ? 0 : c1952u.f5841g.f5836b) + (8192 - c1952u.f5841g.f5837c)) {
                            c1952u.mo9085a(c1952u.f5841g, i2);
                            c1952u.mo9083a();
                            C1953v.m5757a(c1952u);
                        }
                    }
                }
                c1939e.f5807b -= j2;
                this.f5807b += j2;
                j -= j2;
            }
        }
    }

    /* renamed from: b */
    public final byte mo9048b(long j) {
        C1933aa.m5591a(this.f5807b, j, 1);
        C1952u c1952u = this.f5806a;
        while (true) {
            int i = c1952u.f5837c - c1952u.f5836b;
            if (j < ((long) i)) {
                return c1952u.f5835a[c1952u.f5836b + ((int) j)];
            }
            j -= (long) i;
            c1952u = c1952u.f5840f;
        }
    }

    /* renamed from: b */
    public final long mo9049b() {
        return this.f5807b;
    }

    /* renamed from: b */
    public final C1939e mo9020h(int i) {
        C1952u e = mo9056e(1);
        byte[] bArr = e.f5835a;
        int i2 = e.f5837c;
        e.f5837c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f5807b++;
        return this;
    }

    /* renamed from: b */
    public final C1939e mo9016c(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        C1933aa.m5591a((long) bArr.length, (long) i, (long) i2);
        int i3 = i + i2;
        while (i < i3) {
            C1952u e = mo9056e(1);
            int min = Math.min(i3 - i, 8192 - e.f5837c);
            System.arraycopy(bArr, i, e.f5835a, e.f5837c, min);
            i += min;
            e.f5837c = min + e.f5837c;
        }
        this.f5807b += (long) i2;
        return this;
    }

    /* renamed from: c */
    public final ByteString mo9026c(long j) {
        return new ByteString(mo9029e(j));
    }

    /* renamed from: c */
    public final C1939e mo9015c() {
        return this;
    }

    /* renamed from: c */
    public final C1939e mo9019g(int i) {
        C1952u e = mo9056e(2);
        byte[] bArr = e.f5835a;
        int i2 = e.f5837c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.f5837c = i2;
        this.f5807b += 2;
        return this;
    }

    public final /* synthetic */ Object clone() {
        C1939e c1939e = new C1939e();
        if (this.f5807b == 0) {
            return c1939e;
        }
        c1939e.f5806a = new C1952u(this.f5806a);
        C1952u c1952u = c1939e.f5806a;
        C1952u c1952u2 = c1939e.f5806a;
        C1952u c1952u3 = c1939e.f5806a;
        c1952u2.f5841g = c1952u3;
        c1952u.f5840f = c1952u3;
        for (c1952u = this.f5806a.f5840f; c1952u != this.f5806a; c1952u = c1952u.f5840f) {
            c1939e.f5806a.f5841g.mo9084a(new C1952u(c1952u));
        }
        c1939e.f5807b = this.f5807b;
        return c1939e;
    }

    public final void close() {
    }

    /* renamed from: d */
    final String mo9054d(long j) {
        String k;
        if (j <= 0 || mo9048b(j - 1) != (byte) 13) {
            k = m5633k(j);
            mo9031f(1);
            return k;
        }
        k = m5633k(j - 1);
        mo9031f(2);
        return k;
    }

    /* renamed from: d */
    public final C1939e mo9018f(int i) {
        C1952u e = mo9056e(4);
        byte[] bArr = e.f5835a;
        int i2 = e.f5837c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.f5837c = i2;
        this.f5807b += 4;
        return this;
    }

    /* renamed from: d */
    public final C1937g mo9017d() {
        return this;
    }

    /* renamed from: e */
    final C1952u mo9056e(int i) {
        C1952u c1952u;
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        } else if (this.f5806a == null) {
            this.f5806a = C1953v.m5756a();
            C1952u c1952u2 = this.f5806a;
            C1952u c1952u3 = this.f5806a;
            c1952u = this.f5806a;
            c1952u3.f5841g = c1952u;
            c1952u2.f5840f = c1952u;
            return c1952u;
        } else {
            c1952u = this.f5806a.f5841g;
            return (c1952u.f5837c + i > 8192 || !c1952u.f5839e) ? c1952u.mo9084a(C1953v.m5756a()) : c1952u;
        }
    }

    /* renamed from: e */
    public final boolean mo9028e() {
        return this.f5807b == 0;
    }

    /* renamed from: e */
    public final byte[] mo9029e(long j) {
        C1933aa.m5591a(this.f5807b, 0, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[((int) j)];
        m5632c(bArr);
        return bArr;
    }

    public final boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1939e)) {
            return false;
        }
        C1939e c1939e = (C1939e) obj;
        if (this.f5807b != c1939e.f5807b) {
            return false;
        }
        if (this.f5807b == 0) {
            return true;
        }
        C1952u c1952u = this.f5806a;
        C1952u c1952u2 = c1939e.f5806a;
        int i = c1952u.f5836b;
        int i2 = c1952u2.f5836b;
        while (j < this.f5807b) {
            long min = (long) Math.min(c1952u.f5837c - i, c1952u2.f5837c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                byte b = c1952u.f5835a[i];
                i = i2 + 1;
                if (b != c1952u2.f5835a[i2]) {
                    return false;
                }
                i3++;
                i2 = i;
                i = i4;
            }
            if (i == c1952u.f5837c) {
                c1952u = c1952u.f5840f;
                i = c1952u.f5836b;
            }
            if (i2 == c1952u2.f5837c) {
                c1952u2 = c1952u2.f5840f;
                i2 = c1952u2.f5836b;
            }
            j += min;
        }
        return true;
    }

    /* renamed from: f */
    public final InputStream mo9030f() {
        return new C1940f(this);
    }

    /* renamed from: f */
    public final void mo9031f(long j) {
        while (j > 0) {
            if (this.f5806a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.f5806a.f5837c - this.f5806a.f5836b));
            this.f5807b -= (long) min;
            j -= (long) min;
            C1952u c1952u = this.f5806a;
            c1952u.f5836b = min + c1952u.f5836b;
            if (this.f5806a.f5836b == this.f5806a.f5837c) {
                C1952u c1952u2 = this.f5806a;
                this.f5806a = c1952u2.mo9083a();
                C1953v.m5757a(c1952u2);
            }
        }
    }

    public final void flush() {
    }

    /* renamed from: g */
    public final byte mo9032g() {
        if (this.f5807b == 0) {
            throw new IllegalStateException("size == 0");
        }
        C1952u c1952u = this.f5806a;
        int i = c1952u.f5836b;
        int i2 = c1952u.f5837c;
        int i3 = i + 1;
        byte b = c1952u.f5835a[i];
        this.f5807b--;
        if (i3 == i2) {
            this.f5806a = c1952u.mo9083a();
            C1953v.m5757a(c1952u);
        } else {
            c1952u.f5836b = i3;
        }
        return b;
    }

    /* renamed from: g */
    public final C1939e mo9022j(long j) {
        if (j == 0) {
            return mo9020h(48);
        }
        long j2;
        Object obj;
        if (j < 0) {
            j2 = -j;
            if (j2 < 0) {
                return mo9012b("-9223372036854775808");
            }
            obj = 1;
        } else {
            obj = null;
            j2 = j;
        }
        int i = j2 < 100000000 ? j2 < 10000 ? j2 < 100 ? j2 < 10 ? 1 : 2 : j2 < 1000 ? 3 : 4 : j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8 : j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        if (obj != null) {
            i++;
        }
        C1952u e = mo9056e(i);
        byte[] bArr = e.f5835a;
        int i2 = e.f5837c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = f5805c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (obj != null) {
            bArr[i2 - 1] = (byte) 45;
        }
        e.f5837c += i;
        this.f5807b = ((long) i) + this.f5807b;
        return this;
    }

    /* renamed from: h */
    public final C1939e mo9021i(long j) {
        if (j == 0) {
            return mo9020h(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        C1952u e = mo9056e(numberOfTrailingZeros);
        byte[] bArr = e.f5835a;
        int i = e.f5837c;
        for (int i2 = (e.f5837c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f5805c[(int) (15 & j)];
            j >>>= 4;
        }
        e.f5837c += numberOfTrailingZeros;
        this.f5807b = ((long) numberOfTrailingZeros) + this.f5807b;
        return this;
    }

    /* renamed from: h */
    public final short mo9033h() {
        if (this.f5807b < 2) {
            throw new IllegalStateException("size < 2: " + this.f5807b);
        }
        C1952u c1952u = this.f5806a;
        int i = c1952u.f5836b;
        int i2 = c1952u.f5837c;
        if (i2 - i < 2) {
            return (short) (((mo9032g() & 255) << 8) | (mo9032g() & 255));
        }
        byte[] bArr = c1952u.f5835a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f5807b -= 2;
        if (i4 == i2) {
            this.f5806a = c1952u.mo9083a();
            C1953v.m5757a(c1952u);
        } else {
            c1952u.f5836b = i4;
        }
        return (short) i;
    }

    public final int hashCode() {
        C1952u c1952u = this.f5806a;
        if (c1952u == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = c1952u.f5836b;
            while (i2 < c1952u.f5837c) {
                int i3 = c1952u.f5835a[i2] + (i * 31);
                i2++;
                i = i3;
            }
            c1952u = c1952u.f5840f;
        } while (c1952u != this.f5806a);
        return i;
    }

    /* renamed from: i */
    public final int mo9034i() {
        if (this.f5807b < 4) {
            throw new IllegalStateException("size < 4: " + this.f5807b);
        }
        C1952u c1952u = this.f5806a;
        int i = c1952u.f5836b;
        int i2 = c1952u.f5837c;
        if (i2 - i < 4) {
            return ((((mo9032g() & 255) << 24) | ((mo9032g() & 255) << 16)) | ((mo9032g() & 255) << 8)) | (mo9032g() & 255);
        }
        byte[] bArr = c1952u.f5835a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        i3 = i4 + 1;
        i |= (bArr[i4] & 255) << 8;
        i4 = i3 + 1;
        i |= bArr[i3] & 255;
        this.f5807b -= 4;
        if (i4 == i2) {
            this.f5806a = c1952u.mo9083a();
            C1953v.m5757a(c1952u);
            return i;
        }
        c1952u.f5836b = i4;
        return i;
    }

    /* renamed from: j */
    public final short mo9035j() {
        return C1933aa.m5590a(mo9033h());
    }

    /* renamed from: k */
    public final int mo9036k() {
        return C1933aa.m5589a(mo9034i());
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a9 A:{SYNTHETIC, EDGE_INSN: B:39:0x00a9->B:35:0x00a9 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a3  */
    /* renamed from: l */
    public final long mo9037l() {
        /*
        r18 = this;
        r0 = r18;
        r2 = r0.f5807b;
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0012;
    L_0x000a:
        r2 = new java.lang.IllegalStateException;
        r3 = "size == 0";
        r2.<init>(r3);
        throw r2;
    L_0x0012:
        r4 = 0;
        r3 = 0;
        r2 = 0;
    L_0x0016:
        r0 = r18;
        r10 = r0.f5806a;
        r11 = r10.f5835a;
        r6 = r10.f5836b;
        r12 = r10.f5837c;
        r7 = r6;
    L_0x0021:
        if (r7 >= r12) goto L_0x0094;
    L_0x0023:
        r8 = r11[r7];
        r6 = 48;
        if (r8 < r6) goto L_0x005e;
    L_0x0029:
        r6 = 57;
        if (r8 > r6) goto L_0x005e;
    L_0x002d:
        r6 = r8 + -48;
    L_0x002f:
        r14 = -1152921504606846976; // 0xf000000000000000 float:0.0 double:-3.105036184601418E231;
        r14 = r14 & r4;
        r16 = 0;
        r9 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r9 == 0) goto L_0x00b5;
    L_0x0038:
        r2 = new okio.e;
        r2.<init>();
        r2 = r2.mo9021i(r4);
        r2 = r2.mo9020h(r8);
        r3 = new java.lang.NumberFormatException;
        r4 = new java.lang.StringBuilder;
        r5 = "Number too large: ";
        r4.<init>(r5);
        r2 = r2.mo9062n();
        r2 = r4.append(r2);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x005e:
        r6 = 97;
        if (r8 < r6) goto L_0x006b;
    L_0x0062:
        r6 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r8 > r6) goto L_0x006b;
    L_0x0066:
        r6 = r8 + -97;
        r6 = r6 + 10;
        goto L_0x002f;
    L_0x006b:
        r6 = 65;
        if (r8 < r6) goto L_0x0078;
    L_0x006f:
        r6 = 70;
        if (r8 > r6) goto L_0x0078;
    L_0x0073:
        r6 = r8 + -65;
        r6 = r6 + 10;
        goto L_0x002f;
    L_0x0078:
        if (r3 != 0) goto L_0x0093;
    L_0x007a:
        r2 = new java.lang.NumberFormatException;
        r3 = new java.lang.StringBuilder;
        r4 = "Expected leading [0-9a-fA-F] character but was 0x";
        r3.<init>(r4);
        r4 = java.lang.Integer.toHexString(r8);
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2.<init>(r3);
        throw r2;
    L_0x0093:
        r2 = 1;
    L_0x0094:
        if (r7 != r12) goto L_0x00c1;
    L_0x0096:
        r6 = r10.mo9083a();
        r0 = r18;
        r0.f5806a = r6;
        okio.C1953v.m5757a(r10);
    L_0x00a1:
        if (r2 != 0) goto L_0x00a9;
    L_0x00a3:
        r0 = r18;
        r6 = r0.f5806a;
        if (r6 != 0) goto L_0x0016;
    L_0x00a9:
        r0 = r18;
        r6 = r0.f5807b;
        r2 = (long) r3;
        r2 = r6 - r2;
        r0 = r18;
        r0.f5807b = r2;
        return r4;
    L_0x00b5:
        r8 = 4;
        r4 = r4 << r8;
        r8 = (long) r6;
        r8 = r8 | r4;
        r4 = r7 + 1;
        r3 = r3 + 1;
        r7 = r4;
        r4 = r8;
        goto L_0x0021;
    L_0x00c1:
        r10.f5836b = r7;
        goto L_0x00a1;
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.e.l():long");
    }

    /* renamed from: m */
    public final ByteString mo9061m() {
        return new ByteString(mo9039p());
    }

    /* renamed from: n */
    public final String mo9062n() {
        try {
            return m5631a(this.f5807b, C1933aa.f5798a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: o */
    public final String mo9038o() {
        long a = mo9041a((byte) 10, 0);
        if (a != -1) {
            return mo9054d(a);
        }
        C1939e c1939e = new C1939e();
        mo9046a(c1939e, 0, Math.min(32, this.f5807b));
        throw new EOFException("\\n not found: size=" + this.f5807b + " content=" + c1939e.mo9061m().hex() + "…");
    }

    /* renamed from: p */
    public final byte[] mo9039p() {
        try {
            return mo9029e(this.f5807b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: q */
    public final void mo9063q() {
        try {
            mo9031f(this.f5807b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: r */
    public final /* bridge */ /* synthetic */ C1937g mo9023r() {
        return this;
    }

    public final String toString() {
        if (this.f5807b > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f5807b);
        }
        int i = (int) this.f5807b;
        return (i == 0 ? ByteString.EMPTY : new SegmentedByteString(this, i)).toString();
    }
}
