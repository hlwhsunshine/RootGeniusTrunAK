package p000a.p001a.p002a.p004b.p006b;

/* renamed from: a.a.a.b.b.b */
public final class C0008b {
    /* renamed from: b */
    private static final int[] f39b = new int[256];
    /* renamed from: a */
    private final int[] f40a = new int[3];

    static {
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            for (int i3 = 0; i3 < 8; i3++) {
                i2 = (i2 & 1) == 1 ? (i2 >>> 1) ^ -306674912 : i2 >>> 1;
            }
            f39b[i] = i2;
        }
    }

    /* renamed from: a */
    private static int m37a(int i, byte b) {
        return (i >>> 8) ^ f39b[(i ^ b) & 255];
    }

    /* renamed from: a */
    public final byte mo21a() {
        int i = this.f40a[2] | 2;
        return (byte) ((i * (i ^ 1)) >>> 8);
    }

    /* renamed from: a */
    public final void mo22a(byte b) {
        this.f40a[0] = C0008b.m37a(this.f40a[0], b);
        int[] iArr = this.f40a;
        iArr[1] = iArr[1] + (this.f40a[0] & 255);
        this.f40a[1] = (this.f40a[1] * 134775813) + 1;
        this.f40a[2] = C0008b.m37a(this.f40a[2], this.f40a[1] >> 24);
    }

    /* renamed from: a */
    public final void mo23a(char[] cArr) {
        int i = 0;
        this.f40a[0] = 305419896;
        this.f40a[1] = 591751049;
        this.f40a[2] = 878082192;
        while (i < cArr.length) {
            mo22a((byte) cArr[i]);
            i++;
        }
    }
}
