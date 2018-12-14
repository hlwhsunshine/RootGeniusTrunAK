package com.kingroot.sdk;

import java.util.ArrayList;

/* renamed from: com.kingroot.sdk.j */
public final class C0868j extends C0597gy {
    /* renamed from: K */
    static ArrayList<C0867i> f2165K;
    /* renamed from: J */
    public ArrayList<C0867i> f2166J = null;

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        if (f2165K == null) {
            f2165K = new ArrayList();
            f2165K.add(new C0867i());
        }
        this.f2166J = (ArrayList) c0863gw.mo5911b(f2165K, 0, true);
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5921a(this.f2166J, 0);
    }

    /* renamed from: a */
    public final void mo5571a(StringBuilder stringBuilder, int i) {
        new C0860gu(stringBuilder, i).mo5875a(this.f2166J, "vctCommList");
    }
}
