package com.kingroot.sdk;

import java.util.ArrayList;

/* renamed from: com.kingroot.sdk.g */
public final class C0837g extends C0597gy implements Cloneable {
    /* renamed from: c */
    static final /* synthetic */ boolean f2088c = (!C0837g.class.desiredAssertionStatus());
    /* renamed from: y */
    static ArrayList<C0771e> f2089y;
    public int action = 0;
    /* renamed from: g */
    public String f2090g = "";
    /* renamed from: l */
    public int f2091l = 0;
    /* renamed from: u */
    public ArrayList<C0771e> f2092u = null;
    /* renamed from: v */
    public int f2093v = 0;
    /* renamed from: w */
    public int f2094w = 0;
    /* renamed from: x */
    public int f2095x = 0;

    public C0837g() {
        mo5840a(this.f2090g);
        setAction(this.action);
        mo5843d(this.f2091l);
        mo5841c(this.f2092u);
        mo5844e(this.f2093v);
        mo5846f(this.f2094w);
        mo5847g(this.f2095x);
    }

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        mo5840a(c0863gw.mo5896a(1, true));
        setAction(c0863gw.mo5893a(this.action, 2, true));
        mo5843d(c0863gw.mo5893a(this.f2091l, 3, true));
        if (f2089y == null) {
            f2089y = new ArrayList();
            f2089y.add(new C0771e());
        }
        mo5841c((ArrayList) c0863gw.mo5911b(f2089y, 4, true));
        mo5844e(c0863gw.mo5893a(this.f2093v, 5, false));
        mo5846f(c0863gw.mo5893a(this.f2094w, 6, false));
        mo5847g(c0863gw.mo5893a(this.f2095x, 7, false));
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5935d(this.f2090g, 1);
        c0864gx.mo5936f(this.action, 2);
        c0864gx.mo5936f(this.f2091l, 3);
        c0864gx.mo5921a(this.f2092u, 4);
        c0864gx.mo5936f(this.f2093v, 5);
        c0864gx.mo5936f(this.f2094w, 6);
        c0864gx.mo5936f(this.f2095x, 7);
    }

    /* renamed from: a */
    public final void mo5840a(String str) {
        this.f2090g = str;
    }

    /* renamed from: a */
    public final void mo5571a(StringBuilder stringBuilder, int i) {
    }

    /* renamed from: c */
    public final void mo5841c(ArrayList<C0771e> arrayList) {
        this.f2092u = arrayList;
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f2088c) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: d */
    public final void mo5843d(int i) {
        this.f2091l = i;
    }

    /* renamed from: e */
    public final void mo5844e(int i) {
        this.f2093v = i;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0837g c0837g = (C0837g) obj;
        return C0865gz.equals(this.f2090g, c0837g.f2090g) && C0865gz.equals(this.action, c0837g.action) && C0865gz.equals(this.f2091l, c0837g.f2091l) && C0865gz.equals(this.f2092u, c0837g.f2092u) && C0865gz.equals(this.f2093v, c0837g.f2093v) && C0865gz.equals(this.f2094w, c0837g.f2094w) && C0865gz.equals(this.f2095x, c0837g.f2095x);
    }

    /* renamed from: f */
    public final void mo5846f(int i) {
        this.f2094w = i;
    }

    /* renamed from: g */
    public final void mo5847g(int i) {
        this.f2095x = i;
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final void setAction(int i) {
        this.action = i;
    }
}
