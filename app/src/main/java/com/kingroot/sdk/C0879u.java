package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.u */
public final class C0879u extends C0597gy implements Cloneable {
    /* renamed from: c */
    static final /* synthetic */ boolean f2200c = (!C0879u.class.desiredAssertionStatus());
    /* renamed from: ak */
    public boolean f2201ak = true;
    /* renamed from: al */
    public int f2202al = 0;
    /* renamed from: am */
    public int f2203am = 0;
    /* renamed from: x */
    public int f2204x = 0;

    public C0879u() {
        mo5962g(this.f2204x);
        mo5959a(this.f2201ak);
        mo5964l(this.f2202al);
        mo5965m(this.f2203am);
    }

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        mo5962g(c0863gw.mo5893a(this.f2204x, 0, true));
        mo5959a(c0863gw.mo5901a(this.f2201ak, 1, true));
        mo5964l(c0863gw.mo5893a(this.f2202al, 2, false));
        mo5965m(c0863gw.mo5893a(this.f2203am, 3, false));
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5936f(this.f2204x, 0);
        c0864gx.mo5924a(this.f2201ak, 1);
        c0864gx.mo5936f(this.f2202al, 2);
        c0864gx.mo5936f(this.f2203am, 3);
    }

    /* renamed from: a */
    public final void mo5571a(StringBuilder stringBuilder, int i) {
    }

    /* renamed from: a */
    public final void mo5959a(boolean z) {
        this.f2201ak = z;
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f2200c) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0879u c0879u = (C0879u) obj;
        return C0865gz.equals(this.f2204x, c0879u.f2204x) && C0865gz.m2308c(this.f2201ak, c0879u.f2201ak) && C0865gz.equals(this.f2202al, c0879u.f2202al) && C0865gz.equals(this.f2203am, c0879u.f2203am);
    }

    /* renamed from: g */
    public final void mo5962g(int i) {
        this.f2204x = i;
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: l */
    public final void mo5964l(int i) {
        this.f2202al = i;
    }

    /* renamed from: m */
    public final void mo5965m(int i) {
        this.f2203am = i;
    }
}
