package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.ed */
public final class C0775ed extends C0597gy {
    /* renamed from: he */
    static C0779eg f1890he;
    /* renamed from: hb */
    public String f1891hb = "";
    /* renamed from: hc */
    public C0779eg f1892hc = null;
    /* renamed from: hd */
    public int f1893hd = 0;

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        this.f1891hb = c0863gw.mo5896a(0, true);
        if (f1890he == null) {
            f1890he = new C0779eg();
        }
        this.f1892hc = (C0779eg) c0863gw.mo5895a(f1890he, 1, false);
        this.f1893hd = c0863gw.mo5893a(this.f1893hd, 2, false);
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5935d(this.f1891hb, 0);
        if (this.f1892hc != null) {
            c0864gx.mo5919a(this.f1892hc, 1);
        }
        c0864gx.mo5936f(this.f1893hd, 2);
    }
}
