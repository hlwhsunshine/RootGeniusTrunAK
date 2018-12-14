package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.e */
public final class C0771e extends C0597gy implements Cloneable {
    /* renamed from: c */
    static final /* synthetic */ boolean f1876c = (!C0771e.class.desiredAssertionStatus());
    /* renamed from: j */
    public int f1877j = 0;
    /* renamed from: l */
    public int f1878l = 0;

    public C0771e() {
        mo5794c(this.f1877j);
        mo5796d(this.f1878l);
    }

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        mo5794c(c0863gw.mo5893a(this.f1877j, 1, true));
        mo5796d(c0863gw.mo5893a(this.f1878l, 2, true));
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5936f(this.f1877j, 1);
        c0864gx.mo5936f(this.f1878l, 2);
    }

    /* renamed from: a */
    public final void mo5571a(StringBuilder stringBuilder, int i) {
    }

    /* renamed from: c */
    public final void mo5794c(int i) {
        this.f1877j = i;
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f1876c) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: d */
    public final void mo5796d(int i) {
        this.f1878l = i;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0771e c0771e = (C0771e) obj;
        return C0865gz.equals(this.f1877j, c0771e.f1877j) && C0865gz.equals(this.f1878l, c0771e.f1878l);
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
