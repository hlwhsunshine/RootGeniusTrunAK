package com.kingroot.sdk;

import java.util.ArrayList;

/* renamed from: com.kingroot.sdk.t */
public final class C0878t extends C0597gy implements Cloneable {
    /* renamed from: b */
    static ArrayList<C0802f> f2195b;
    /* renamed from: c */
    static final /* synthetic */ boolean f2196c = (!C0878t.class.desiredAssertionStatus());
    /* renamed from: a */
    public ArrayList<C0802f> f2197a = null;
    /* renamed from: ai */
    public int f2198ai = 0;
    /* renamed from: aj */
    public String f2199aj = "";

    public C0878t() {
        mo5953a(this.f2197a);
        mo5958k(this.f2198ai);
        mo5954c(this.f2199aj);
    }

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        if (f2195b == null) {
            f2195b = new ArrayList();
            f2195b.add(new C0802f());
        }
        mo5953a((ArrayList) c0863gw.mo5911b(f2195b, 1, true));
        mo5958k(c0863gw.mo5893a(this.f2198ai, 2, true));
        mo5954c(c0863gw.mo5896a(3, false));
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5921a(this.f2197a, 1);
        c0864gx.mo5936f(this.f2198ai, 2);
        if (this.f2199aj != null) {
            c0864gx.mo5935d(this.f2199aj, 3);
        }
    }

    /* renamed from: a */
    public final void mo5571a(StringBuilder stringBuilder, int i) {
    }

    /* renamed from: a */
    public final void mo5953a(ArrayList<C0802f> arrayList) {
        this.f2197a = arrayList;
    }

    /* renamed from: c */
    public final void mo5954c(String str) {
        this.f2199aj = str;
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f2196c) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0878t c0878t = (C0878t) obj;
        return C0865gz.equals(this.f2197a, c0878t.f2197a) && C0865gz.equals(this.f2198ai, c0878t.f2198ai) && C0865gz.equals(this.f2199aj, c0878t.f2199aj);
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: k */
    public final void mo5958k(int i) {
        this.f2198ai = i;
    }
}
