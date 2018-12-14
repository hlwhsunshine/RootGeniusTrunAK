package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.c */
public final class C0695c extends C0597gy implements Cloneable {
    /* renamed from: c */
    static final /* synthetic */ boolean f1707c = (!C0695c.class.desiredAssertionStatus());
    /* renamed from: g */
    public String f1708g = "";

    public C0695c() {
        mo5671a(this.f1708g);
    }

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        mo5671a(c0863gw.mo5896a(0, true));
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5935d(this.f1708g, 0);
    }

    /* renamed from: a */
    public final void mo5671a(String str) {
        this.f1708g = str;
    }

    /* renamed from: a */
    public final void mo5571a(StringBuilder stringBuilder, int i) {
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f1707c) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return C0865gz.equals(this.f1708g, ((C0695c) obj).f1708g);
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
