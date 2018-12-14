package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.bh */
public class C0666bh {
    /* renamed from: a */
    public static C0668bj m1576a(C0732d c0732d, String str) {
        C0668bj c0668bj = null;
        if (c0732d != null) {
            int i = c0732d.f1784h;
            switch (i) {
                case 1:
                    c0668bj = new C0683bs(i);
                    break;
                case 3:
                    c0668bj = new C0681bq(i);
                    break;
                case 4:
                    c0668bj = new C0675bm(i);
                    break;
                case 6:
                    c0668bj = new C0680bp(i);
                    break;
                case 9:
                    c0668bj = new C0679bo(str, i);
                    break;
                case 350:
                    c0668bj = new C0678bn(i, str, c0732d);
                    break;
            }
        }
        if (c0668bj != null) {
            c0668bj.mo5649b(c0732d.f1785i);
        }
        return c0668bj;
    }
}
