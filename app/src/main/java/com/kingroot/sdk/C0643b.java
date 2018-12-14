package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.b */
public final class C0643b extends C0597gy implements Cloneable {
    /* renamed from: c */
    static final /* synthetic */ boolean f1615c = (!C0643b.class.desiredAssertionStatus());
    /* renamed from: f */
    static C0902w f1616f;
    /* renamed from: d */
    public C0902w f1617d = null;
    /* renamed from: e */
    public int f1618e = 0;

    public C0643b() {
        mo5617a(this.f1617d);
        mo5616a(this.f1618e);
    }

    /* renamed from: a */
    public final void mo5616a(int i) {
        this.f1618e = i;
    }

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        if (f1616f == null) {
            f1616f = new C0902w();
        }
        mo5617a((C0902w) c0863gw.mo5895a(f1616f, 0, false));
        mo5616a(c0863gw.mo5893a(this.f1618e, 1, false));
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        if (this.f1617d != null) {
            c0864gx.mo5919a(this.f1617d, 0);
        }
        c0864gx.mo5936f(this.f1618e, 1);
    }

    /* renamed from: a */
    public final void mo5617a(C0902w c0902w) {
        this.f1617d = c0902w;
    }

    /* renamed from: a */
    public final void mo5571a(StringBuilder stringBuilder, int i) {
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f1615c) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0643b c0643b = (C0643b) obj;
        return C0865gz.equals(this.f1617d, c0643b.f1617d) && C0865gz.equals(this.f1618e, c0643b.f1618e);
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
