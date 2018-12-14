package okhttp3.internal.framed;

import java.util.Arrays;

/* renamed from: okhttp3.internal.framed.z */
public final class C1875z {
    /* renamed from: a */
    private int f5540a;
    /* renamed from: b */
    private int f5541b;
    /* renamed from: c */
    private int f5542c;
    /* renamed from: d */
    private final int[] f5543d = new int[10];

    /* renamed from: a */
    final C1875z mo8819a(int i, int i2, int i3) {
        if (i < this.f5543d.length) {
            int i4 = 1 << i;
            this.f5540a |= i4;
            if ((i2 & 1) != 0) {
                this.f5541b |= i4;
            } else {
                this.f5541b &= i4 ^ -1;
            }
            if ((i2 & 2) != 0) {
                this.f5542c = i4 | this.f5542c;
            } else {
                this.f5542c = (i4 ^ -1) & this.f5542c;
            }
            this.f5543d[i] = i3;
        }
        return this;
    }

    /* renamed from: a */
    final void mo8820a() {
        this.f5542c = 0;
        this.f5541b = 0;
        this.f5540a = 0;
        Arrays.fill(this.f5543d, 0);
    }

    /* renamed from: a */
    final boolean mo8821a(int i) {
        return ((1 << i) & this.f5540a) != 0;
    }

    /* renamed from: b */
    final int mo8822b() {
        return Integer.bitCount(this.f5540a);
    }

    /* renamed from: b */
    final int mo8823b(int i) {
        return this.f5543d[i];
    }

    /* renamed from: c */
    final int mo8824c() {
        return (this.f5540a & 2) != 0 ? this.f5543d[1] : -1;
    }

    /* renamed from: c */
    final int mo8825c(int i) {
        int i2 = 0;
        int i3 = (((1 << i) & this.f5542c) != 0 ? 1 : 0) != 0 ? 2 : 0;
        if (((1 << i) & this.f5541b) != 0) {
            i2 = 1;
        }
        return i2 != 0 ? i3 | 1 : i3;
    }

    /* renamed from: d */
    final int mo8826d() {
        return (this.f5540a & 16) != 0 ? this.f5543d[4] : Integer.MAX_VALUE;
    }

    /* renamed from: d */
    final int mo8827d(int i) {
        return (this.f5540a & 32) != 0 ? this.f5543d[5] : i;
    }

    /* renamed from: e */
    final int mo8828e() {
        return (this.f5540a & 128) != 0 ? this.f5543d[7] : 65536;
    }
}
