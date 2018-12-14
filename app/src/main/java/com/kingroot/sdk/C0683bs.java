package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.bs */
public class C0683bs extends C0668bj {
    public C0683bs(int i) {
        super(i);
    }

    /* renamed from: ac */
    public int mo5647ac() {
        if (this.f1670do != null) {
            C0903x c0903x = (C0903x) this.f1670do;
            C0633at.m1463g("UninstallCmdExecuter_" + c0903x.f2226U);
            switch (c0903x.f2226U) {
                case 1:
                    return C0671bk.m1597f(getContext(), c0903x.f2227W);
                case 5:
                    return C0671bk.m1596e(getContext(), c0903x.f2227W);
            }
        }
        return 2;
    }

    /* renamed from: ad */
    public boolean mo5648ad() {
        return this.f1670do != null && ((C0903x) this.f1670do).f2226U == 5;
    }

    /* renamed from: b */
    public void mo5649b(byte[] bArr) {
        mo5646a(bArr, new C0903x());
    }
}
