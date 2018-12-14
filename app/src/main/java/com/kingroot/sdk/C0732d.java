package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.d */
public final class C0732d extends C0597gy implements Cloneable {
    /* renamed from: c */
    static final /* synthetic */ boolean f1782c = (!C0732d.class.desiredAssertionStatus());
    /* renamed from: k */
    static byte[] f1783k;
    /* renamed from: h */
    public int f1784h = 0;
    /* renamed from: i */
    public byte[] f1785i = null;
    /* renamed from: j */
    public int f1786j = 0;

    public C0732d() {
        mo5709b(this.f1784h);
        mo5708a(this.f1785i);
        mo5710c(this.f1786j);
    }

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        mo5709b(c0863gw.mo5893a(this.f1784h, 0, true));
        if (f1783k == null) {
            byte[] bArr = new byte[1];
            f1783k = bArr;
            bArr[0] = (byte) 0;
        }
        mo5708a(c0863gw.mo5902a(f1783k, 1, true));
        mo5710c(c0863gw.mo5893a(this.f1786j, 2, true));
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5936f(this.f1784h, 0);
        c0864gx.mo5925a(this.f1785i, 1);
        c0864gx.mo5936f(this.f1786j, 2);
    }

    /* renamed from: a */
    public final void mo5571a(StringBuilder stringBuilder, int i) {
    }

    /* renamed from: a */
    public final void mo5708a(byte[] bArr) {
        this.f1785i = bArr;
    }

    /* renamed from: b */
    public final void mo5709b(int i) {
        this.f1784h = i;
    }

    /* renamed from: c */
    public final void mo5710c(int i) {
        this.f1786j = i;
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f1782c) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0732d c0732d = (C0732d) obj;
        return C0865gz.equals(this.f1784h, c0732d.f1784h) && C0865gz.equals(this.f1785i, c0732d.f1785i) && C0865gz.equals(this.f1786j, c0732d.f1786j);
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
