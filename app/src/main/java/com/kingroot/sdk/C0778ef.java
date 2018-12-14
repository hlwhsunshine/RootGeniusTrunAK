package com.kingroot.sdk;

import krsdk.C0777b;

/* renamed from: com.kingroot.sdk.ef */
public final class C0778ef extends C0597gy implements C0777b {
    /* renamed from: hm */
    public String f1901hm = "";
    /* renamed from: hn */
    public int f1902hn = 0;
    /* renamed from: ho */
    public int f1903ho = 0;
    /* renamed from: hp */
    public long f1904hp = 0;
    public int index = 0;
    public int type;

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        this.f1901hm = c0863gw.mo5896a(0, true);
        this.index = c0863gw.mo5893a(this.index, 1, true);
        this.f1902hn = c0863gw.mo5893a(this.f1902hn, 2, true);
        this.f1903ho = c0863gw.mo5893a(this.f1903ho, 3, true);
        this.f1904hp = c0863gw.mo5894a(this.f1904hp, 4, true);
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5935d(this.f1901hm, 0);
        c0864gx.mo5936f(this.index, 1);
        c0864gx.mo5936f(this.f1902hn, 2);
        c0864gx.mo5936f(this.f1903ho, 3);
        c0864gx.mo5918a(this.f1904hp, 4);
    }
}
