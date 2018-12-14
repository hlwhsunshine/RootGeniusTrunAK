package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.q */
public final class C0875q extends C0597gy implements Cloneable {
    /* renamed from: c */
    static final /* synthetic */ boolean f2183c = (!C0875q.class.desiredAssertionStatus());
    /* renamed from: f */
    static C0902w f2184f;
    /* renamed from: aa */
    public String f2185aa = "";
    /* renamed from: d */
    public C0902w f2186d = null;

    public C0875q() {
        mo5943b(this.f2185aa);
        mo5942a(this.f2186d);
    }

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        mo5943b(c0863gw.mo5896a(0, true));
        if (f2184f == null) {
            f2184f = new C0902w();
        }
        mo5942a((C0902w) c0863gw.mo5895a(f2184f, 1, false));
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5935d(this.f2185aa, 0);
        if (this.f2186d != null) {
            c0864gx.mo5919a(this.f2186d, 1);
        }
    }

    /* renamed from: a */
    public final void mo5942a(C0902w c0902w) {
        this.f2186d = c0902w;
    }

    /* renamed from: a */
    public final void mo5571a(StringBuilder stringBuilder, int i) {
    }

    /* renamed from: b */
    public final void mo5943b(String str) {
        this.f2185aa = str;
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f2183c) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0875q c0875q = (C0875q) obj;
        return C0865gz.equals(this.f2185aa, c0875q.f2185aa) && C0865gz.equals(this.f2186d, c0875q.f2186d);
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
