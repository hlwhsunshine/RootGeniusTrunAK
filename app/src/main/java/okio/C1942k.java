package okio;

import java.util.concurrent.TimeUnit;

/* renamed from: okio.k */
public final class C1942k extends C1852y {
    /* renamed from: a */
    private C1852y f5812a;

    public C1942k(C1852y c1852y) {
        if (c1852y == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f5812a = c1852y;
    }

    /* renamed from: a */
    public final C1942k mo9071a(C1852y c1852y) {
        if (c1852y == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f5812a = c1852y;
        return this;
    }

    /* renamed from: a */
    public final C1852y mo9072a() {
        return this.f5812a;
    }

    /* renamed from: a */
    public final C1852y mo8767a(long j) {
        return this.f5812a.mo8767a(j);
    }

    /* renamed from: a */
    public final C1852y mo8768a(long j, TimeUnit timeUnit) {
        return this.f5812a.mo8768a(j, timeUnit);
    }

    /* renamed from: b_ */
    public final long mo8769b_() {
        return this.f5812a.mo8769b_();
    }

    /* renamed from: c_ */
    public final boolean mo8770c_() {
        return this.f5812a.mo8770c_();
    }

    /* renamed from: d */
    public final long mo8771d() {
        return this.f5812a.mo8771d();
    }

    /* renamed from: d_ */
    public final C1852y mo8772d_() {
        return this.f5812a.mo8772d_();
    }

    /* renamed from: f */
    public final C1852y mo8773f() {
        return this.f5812a.mo8773f();
    }

    /* renamed from: g */
    public final void mo8774g() {
        this.f5812a.mo8774g();
    }
}
