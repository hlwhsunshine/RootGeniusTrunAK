package com.kingroot.sdk;

import java.util.ArrayList;

/* renamed from: com.kingroot.sdk.ee */
public final class C0776ee extends C0597gy {
    /* renamed from: hj */
    static ArrayList<String> f1894hj;
    /* renamed from: hk */
    static C0787eo f1895hk;
    /* renamed from: hl */
    static C0787eo f1896hl;
    /* renamed from: hf */
    public long f1897hf = 0;
    /* renamed from: hg */
    public ArrayList<String> f1898hg = null;
    /* renamed from: hh */
    public C0787eo f1899hh = null;
    /* renamed from: hi */
    public C0787eo f1900hi = null;

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        this.f1897hf = c0863gw.mo5894a(this.f1897hf, 0, true);
        if (f1894hj == null) {
            f1894hj = new ArrayList();
            f1894hj.add("");
        }
        this.f1898hg = (ArrayList) c0863gw.mo5911b(f1894hj, 1, true);
        if (f1895hk == null) {
            f1895hk = new C0787eo();
        }
        this.f1899hh = (C0787eo) c0863gw.mo5895a(f1895hk, 2, false);
        if (f1896hl == null) {
            f1896hl = new C0787eo();
        }
        this.f1900hi = (C0787eo) c0863gw.mo5895a(f1896hl, 3, false);
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5918a(this.f1897hf, 0);
        c0864gx.mo5921a(this.f1898hg, 1);
        if (this.f1899hh != null) {
            c0864gx.mo5919a(this.f1899hh, 2);
        }
        if (this.f1900hi != null) {
            c0864gx.mo5919a(this.f1900hi, 3);
        }
    }
}
