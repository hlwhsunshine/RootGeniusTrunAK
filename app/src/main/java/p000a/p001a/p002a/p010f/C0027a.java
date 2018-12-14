package p000a.p001a.p002a.p010f;

/* renamed from: a.a.a.f.a */
public final class C0027a {
    /* renamed from: a */
    private int f119a;
    /* renamed from: b */
    private long f120b;
    /* renamed from: c */
    private long f121c;
    /* renamed from: d */
    private int f122d = 0;

    public C0027a() {
        m164d();
    }

    /* renamed from: d */
    private void m164d() {
        this.f119a = 0;
        this.f120b = 0;
        this.f121c = 0;
        this.f122d = 0;
    }

    /* renamed from: a */
    public final int mo155a() {
        return this.f119a;
    }

    /* renamed from: a */
    public final void mo156a(long j) {
        this.f120b = j;
    }

    /* renamed from: b */
    public final void mo157b() {
        this.f119a = 1;
    }

    /* renamed from: b */
    public final void mo158b(long j) {
        this.f121c += j;
        if (this.f120b > 0) {
            this.f122d = (int) ((this.f121c * 100) / this.f120b);
            if (this.f122d > 100) {
                this.f122d = 100;
            }
        }
    }

    /* renamed from: c */
    public final void mo159c() {
        m164d();
    }
}
