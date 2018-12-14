package com.kingroot.sdk;

import java.util.ArrayList;

/* renamed from: com.kingroot.sdk.el */
public final class C0784el extends C0597gy {
    /* renamed from: hC */
    static ArrayList<C0778ef> f1921hC;
    /* renamed from: gS */
    public String f1922gS = "";
    /* renamed from: hA */
    public ArrayList<C0778ef> f1923hA = null;
    /* renamed from: hB */
    public String f1924hB = "";
    /* renamed from: hf */
    public long f1925hf = 0;

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        this.f1925hf = c0863gw.mo5894a(this.f1925hf, 0, true);
        if (f1921hC == null) {
            f1921hC = new ArrayList();
            f1921hC.add(new C0778ef());
        }
        this.f1923hA = (ArrayList) c0863gw.mo5911b(f1921hC, 1, true);
        this.f1922gS = c0863gw.mo5896a(2, false);
        this.f1924hB = c0863gw.mo5896a(3, false);
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5918a(this.f1925hf, 0);
        c0864gx.mo5921a(this.f1923hA, 1);
        if (this.f1922gS != null) {
            c0864gx.mo5935d(this.f1922gS, 2);
        }
        if (this.f1924hB != null) {
            c0864gx.mo5935d(this.f1924hB, 3);
        }
    }
}
