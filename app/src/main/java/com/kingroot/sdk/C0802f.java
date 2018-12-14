package com.kingroot.sdk;

import java.util.ArrayList;

/* renamed from: com.kingroot.sdk.f */
public final class C0802f extends C0597gy implements Cloneable {
    /* renamed from: c */
    static final /* synthetic */ boolean f2030c = (!C0802f.class.desiredAssertionStatus());
    /* renamed from: q */
    static C0695c f2031q;
    /* renamed from: r */
    static C0879u f2032r;
    /* renamed from: s */
    static C0901v f2033s;
    /* renamed from: t */
    static ArrayList<C0732d> f2034t;
    /* renamed from: m */
    public C0695c f2035m = null;
    /* renamed from: n */
    public C0879u f2036n = null;
    /* renamed from: o */
    public C0901v f2037o = null;
    /* renamed from: p */
    public ArrayList<C0732d> f2038p = null;

    public C0802f() {
        mo5810a(this.f2035m);
        mo5811a(this.f2036n);
        mo5812a(this.f2037o);
        mo5813b(this.f2038p);
    }

    /* renamed from: a */
    public final ArrayList<C0732d> mo5809a() {
        return this.f2038p;
    }

    /* renamed from: a */
    public final void mo5810a(C0695c c0695c) {
        this.f2035m = c0695c;
    }

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        if (f2031q == null) {
            f2031q = new C0695c();
        }
        mo5810a((C0695c) c0863gw.mo5895a(f2031q, 0, true));
        if (f2032r == null) {
            f2032r = new C0879u();
        }
        mo5811a((C0879u) c0863gw.mo5895a(f2032r, 1, true));
        if (f2033s == null) {
            f2033s = new C0901v();
        }
        mo5812a((C0901v) c0863gw.mo5895a(f2033s, 2, false));
        if (f2034t == null) {
            f2034t = new ArrayList();
            f2034t.add(new C0732d());
        }
        mo5813b((ArrayList) c0863gw.mo5911b(f2034t, 3, false));
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5919a(this.f2035m, 0);
        c0864gx.mo5919a(this.f2036n, 1);
        if (this.f2037o != null) {
            c0864gx.mo5919a(this.f2037o, 2);
        }
        if (this.f2038p != null) {
            c0864gx.mo5921a(this.f2038p, 3);
        }
    }

    /* renamed from: a */
    public final void mo5811a(C0879u c0879u) {
        this.f2036n = c0879u;
    }

    /* renamed from: a */
    public final void mo5812a(C0901v c0901v) {
        this.f2037o = c0901v;
    }

    /* renamed from: a */
    public final void mo5571a(StringBuilder stringBuilder, int i) {
    }

    /* renamed from: b */
    public final void mo5813b(ArrayList<C0732d> arrayList) {
        this.f2038p = arrayList;
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f2030c) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0802f c0802f = (C0802f) obj;
        return C0865gz.equals(this.f2035m, c0802f.f2035m) && C0865gz.equals(this.f2036n, c0802f.f2036n) && C0865gz.equals(this.f2037o, c0802f.f2037o) && C0865gz.equals(this.f2038p, c0802f.f2038p);
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
