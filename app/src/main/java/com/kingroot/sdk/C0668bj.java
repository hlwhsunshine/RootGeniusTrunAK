package com.kingroot.sdk;

import android.content.Context;
import java.io.Serializable;

/* renamed from: com.kingroot.sdk.bj */
public abstract class C0668bj implements Serializable {
    /* renamed from: dn */
    protected int f1669dn;
    /* renamed from: do */
    protected C0597gy f1670do;
    protected Context mContext = C0741dg.m1804aL().f1805el;

    public C0668bj(int i) {
        this.f1669dn = i;
    }

    /* renamed from: a */
    protected void mo5646a(byte[] bArr, C0597gy c0597gy) {
        C0855gp c0855gp = new C0855gp();
        c0855gp.mo5858aq("UTF-8");
        c0855gp.mo5860m(bArr);
        this.f1670do = (C0597gy) c0855gp.mo5862a("cloudcmd", (Object) c0597gy);
    }

    /* renamed from: ac */
    public abstract int mo5647ac();

    /* renamed from: ad */
    public boolean mo5648ad() {
        return false;
    }

    /* renamed from: b */
    public abstract void mo5649b(byte[] bArr);

    public Context getContext() {
        return this.mContext;
    }
}
