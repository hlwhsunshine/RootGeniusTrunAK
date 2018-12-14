package okio;

/* renamed from: okio.u */
final class C1952u {
    /* renamed from: a */
    final byte[] f5835a;
    /* renamed from: b */
    int f5836b;
    /* renamed from: c */
    int f5837c;
    /* renamed from: d */
    boolean f5838d;
    /* renamed from: e */
    boolean f5839e;
    /* renamed from: f */
    C1952u f5840f;
    /* renamed from: g */
    C1952u f5841g;

    C1952u() {
        this.f5835a = new byte[8192];
        this.f5839e = true;
        this.f5838d = false;
    }

    C1952u(C1952u c1952u) {
        this(c1952u.f5835a, c1952u.f5836b, c1952u.f5837c);
        c1952u.f5838d = true;
    }

    C1952u(byte[] bArr, int i, int i2) {
        this.f5835a = bArr;
        this.f5836b = i;
        this.f5837c = i2;
        this.f5839e = false;
        this.f5838d = true;
    }

    /* renamed from: a */
    public final C1952u mo9083a() {
        C1952u c1952u = this.f5840f != this ? this.f5840f : null;
        this.f5841g.f5840f = this.f5840f;
        this.f5840f.f5841g = this.f5841g;
        this.f5840f = null;
        this.f5841g = null;
        return c1952u;
    }

    /* renamed from: a */
    public final C1952u mo9084a(C1952u c1952u) {
        c1952u.f5841g = this;
        c1952u.f5840f = this.f5840f;
        this.f5840f.f5841g = c1952u;
        this.f5840f = c1952u;
        return c1952u;
    }

    /* renamed from: a */
    public final void mo9085a(C1952u c1952u, int i) {
        if (c1952u.f5839e) {
            if (c1952u.f5837c + i > 8192) {
                if (c1952u.f5838d) {
                    throw new IllegalArgumentException();
                } else if ((c1952u.f5837c + i) - c1952u.f5836b > 8192) {
                    throw new IllegalArgumentException();
                } else {
                    System.arraycopy(c1952u.f5835a, c1952u.f5836b, c1952u.f5835a, 0, c1952u.f5837c - c1952u.f5836b);
                    c1952u.f5837c -= c1952u.f5836b;
                    c1952u.f5836b = 0;
                }
            }
            System.arraycopy(this.f5835a, this.f5836b, c1952u.f5835a, c1952u.f5837c, i);
            c1952u.f5837c += i;
            this.f5836b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
