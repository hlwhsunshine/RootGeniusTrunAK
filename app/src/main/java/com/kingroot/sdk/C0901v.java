package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.v */
public final class C0901v extends C0597gy implements Cloneable {
    /* renamed from: c */
    static final /* synthetic */ boolean f2221c = (!C0901v.class.desiredAssertionStatus());
    /* renamed from: an */
    public String f2222an = "";
    /* renamed from: ao */
    public int f2223ao = 0;
    public String msg = "";
    public int type = 0;

    public C0901v() {
        setTitle(this.f2222an);
        mo5988d(this.msg);
        setType(this.type);
        mo5991n(this.f2223ao);
    }

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        setTitle(c0863gw.mo5896a(0, true));
        mo5988d(c0863gw.mo5896a(1, true));
        setType(c0863gw.mo5893a(this.type, 2, true));
        mo5991n(c0863gw.mo5893a(this.f2223ao, 3, true));
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5935d(this.f2222an, 0);
        c0864gx.mo5935d(this.msg, 1);
        c0864gx.mo5936f(this.type, 2);
        c0864gx.mo5936f(this.f2223ao, 3);
    }

    /* renamed from: a */
    public final void mo5571a(StringBuilder stringBuilder, int i) {
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f2221c) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: d */
    public final void mo5988d(String str) {
        this.msg = str;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0901v c0901v = (C0901v) obj;
        return C0865gz.equals(this.f2222an, c0901v.f2222an) && C0865gz.equals(this.msg, c0901v.msg) && C0865gz.equals(this.type, c0901v.type) && C0865gz.equals(this.f2223ao, c0901v.f2223ao);
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: n */
    public final void mo5991n(int i) {
        this.f2223ao = i;
    }

    public final void setTitle(String str) {
        this.f2222an = str;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
