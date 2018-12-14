package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.r */
public final class C0876r extends C0597gy implements Cloneable {
    /* renamed from: c */
    static final /* synthetic */ boolean f2187c = (!C0876r.class.desiredAssertionStatus());
    /* renamed from: ab */
    public int f2188ab = 0;
    /* renamed from: ac */
    public int f2189ac = 0;
    /* renamed from: ad */
    public int f2190ad = 0;

    public C0876r() {
        mo5949h(this.f2188ab);
        mo5951i(this.f2189ac);
        mo5952j(this.f2190ad);
    }

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        mo5949h(c0863gw.mo5893a(this.f2188ab, 1, true));
        mo5951i(c0863gw.mo5893a(this.f2189ac, 2, true));
        mo5952j(c0863gw.mo5893a(this.f2190ad, 3, true));
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5936f(this.f2188ab, 1);
        c0864gx.mo5936f(this.f2189ac, 2);
        c0864gx.mo5936f(this.f2190ad, 3);
    }

    /* renamed from: a */
    public final void mo5571a(StringBuilder stringBuilder, int i) {
        C0860gu c0860gu = new C0860gu(stringBuilder, i);
        c0860gu.mo5887d(this.f2188ab, "pversion");
        c0860gu.mo5887d(this.f2189ac, "cversion");
        c0860gu.mo5887d(this.f2190ad, "hotfix");
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f2187c) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0876r c0876r = (C0876r) obj;
        return C0865gz.equals(this.f2188ab, c0876r.f2188ab) && C0865gz.equals(this.f2189ac, c0876r.f2189ac) && C0865gz.equals(this.f2190ad, c0876r.f2190ad);
    }

    /* renamed from: h */
    public final void mo5949h(int i) {
        this.f2188ab = i;
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: i */
    public final void mo5951i(int i) {
        this.f2189ac = i;
    }

    /* renamed from: j */
    public final void mo5952j(int i) {
        this.f2190ad = i;
    }
}
