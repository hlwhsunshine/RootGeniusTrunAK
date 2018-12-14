package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.w */
public final class C0902w extends C0597gy implements Cloneable {
    /* renamed from: c */
    static final /* synthetic */ boolean f2224c = (!C0902w.class.desiredAssertionStatus());
    /* renamed from: ap */
    public String f2225ap = "";

    public C0902w() {
        mo5995e(this.f2225ap);
    }

    public C0902w(String str) {
        mo5995e(str);
    }

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        mo5995e(c0863gw.mo5896a(0, false));
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        if (this.f2225ap != null) {
            c0864gx.mo5935d(this.f2225ap, 0);
        }
    }

    /* renamed from: a */
    public final void mo5571a(StringBuilder stringBuilder, int i) {
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f2224c) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: e */
    public final void mo5995e(String str) {
        this.f2225ap = str;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return C0865gz.equals(this.f2225ap, ((C0902w) obj).f2225ap);
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
