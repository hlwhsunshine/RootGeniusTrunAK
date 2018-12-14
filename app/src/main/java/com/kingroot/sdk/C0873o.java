package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.o */
public final class C0873o extends C0597gy {
    /* renamed from: Z */
    static C0876r f2176Z;
    /* renamed from: M */
    public String f2177M = "";
    /* renamed from: U */
    public int f2178U = 0;
    /* renamed from: V */
    public C0876r f2179V = null;
    /* renamed from: W */
    public String f2180W = "";
    /* renamed from: X */
    public String f2181X = "";
    /* renamed from: Y */
    public int f2182Y = 0;

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        this.f2178U = c0863gw.mo5893a(this.f2178U, 0, true);
        this.f2177M = c0863gw.mo5896a(1, true);
        if (f2176Z == null) {
            f2176Z = new C0876r();
        }
        this.f2179V = (C0876r) c0863gw.mo5895a(f2176Z, 2, false);
        this.f2180W = c0863gw.mo5896a(3, false);
        this.f2181X = c0863gw.mo5896a(4, false);
        this.f2182Y = c0863gw.mo5893a(this.f2182Y, 5, false);
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5936f(this.f2178U, 0);
        c0864gx.mo5935d(this.f2177M, 1);
        if (this.f2179V != null) {
            c0864gx.mo5919a(this.f2179V, 2);
        }
        if (this.f2180W != null) {
            c0864gx.mo5935d(this.f2180W, 3);
        }
        if (this.f2181X != null) {
            c0864gx.mo5935d(this.f2181X, 4);
        }
        if (this.f2182Y != 0) {
            c0864gx.mo5936f(this.f2182Y, 5);
        }
    }

    /* renamed from: a */
    public final void mo5571a(StringBuilder stringBuilder, int i) {
    }
}
