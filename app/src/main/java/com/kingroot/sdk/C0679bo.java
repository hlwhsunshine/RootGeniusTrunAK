package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.bo */
public class C0679bo extends C0668bj {
    /* renamed from: ds */
    private String f1682ds;

    public C0679bo(String str, int i) {
        super(i);
        this.f1682ds = str;
    }

    /* renamed from: ac */
    public int mo5647ac() {
        if (this.f1670do == null) {
            return 0;
        }
        C0871m c0871m = (C0871m) this.f1670do;
        return (c0871m.f2174S == 1 && C0659bf.m1548c(true) == null) ? 2 : C0671bk.m1588a(getContext(), c0871m, this.f1682ds);
    }

    /* renamed from: ad */
    public boolean mo5648ad() {
        return this.f1670do != null && ((C0871m) this.f1670do).f2174S == 1;
    }

    /* renamed from: b */
    public void mo5649b(byte[] bArr) {
        mo5646a(bArr, new C0871m());
    }
}
