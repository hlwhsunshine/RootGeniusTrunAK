package com.kingroot.sdk;

import java.util.ArrayList;

/* renamed from: com.kingroot.sdk.dz */
public final class C0770dz extends C0597gy {
    /* renamed from: gP */
    static ArrayList<C0790er> f1870gP;
    /* renamed from: gK */
    public String f1871gK = "";
    /* renamed from: gL */
    public int f1872gL = 0;
    /* renamed from: gM */
    public int f1873gM = 0;
    /* renamed from: gN */
    public String f1874gN = "";
    /* renamed from: gO */
    public ArrayList<C0790er> f1875gO = null;

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        this.f1871gK = c0863gw.mo5896a(0, true);
        this.f1872gL = c0863gw.mo5893a(this.f1872gL, 1, false);
        this.f1873gM = c0863gw.mo5893a(this.f1873gM, 2, false);
        this.f1874gN = c0863gw.mo5896a(3, false);
        if (f1870gP == null) {
            f1870gP = new ArrayList();
            f1870gP.add(new C0790er());
        }
        this.f1875gO = (ArrayList) c0863gw.mo5911b(f1870gP, 4, false);
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5935d(this.f1871gK, 0);
        if (this.f1872gL != 0) {
            c0864gx.mo5936f(this.f1872gL, 1);
        }
        if (this.f1873gM != 0) {
            c0864gx.mo5936f(this.f1873gM, 2);
        }
        if (this.f1874gN != null) {
            c0864gx.mo5935d(this.f1874gN, 3);
        }
        if (this.f1875gO != null) {
            c0864gx.mo5921a(this.f1875gO, 4);
        }
    }
}
