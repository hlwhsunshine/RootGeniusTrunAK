package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.ej */
public final class C0782ej extends C0597gy {
    /* renamed from: hy */
    static C0781ei f1914hy;
    /* renamed from: hz */
    static byte[] f1915hz;
    /* renamed from: hw */
    public C0781ei f1916hw = null;
    /* renamed from: hx */
    public byte[] f1917hx = null;

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        if (f1914hy == null) {
            f1914hy = new C0781ei();
        }
        this.f1916hw = (C0781ei) c0863gw.mo5895a(f1914hy, 0, true);
        if (f1915hz == null) {
            byte[] bArr = new byte[1];
            f1915hz = bArr;
            bArr[0] = (byte) 0;
        }
        this.f1917hx = c0863gw.mo5902a(f1915hz, 1, true);
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5919a(this.f1916hw, 0);
        c0864gx.mo5925a(this.f1917hx, 1);
    }
}
