package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.er */
public final class C0790er extends C0597gy implements Comparable<C0790er> {
    /* renamed from: W */
    public String f1969W = "";
    /* renamed from: X */
    public String f1970X = "";
    /* renamed from: az */
    public String f1971az = "";
    /* renamed from: gM */
    public int f1972gM = 0;
    /* renamed from: ig */
    public String f1973ig = "";
    /* renamed from: ih */
    public String f1974ih = "";
    /* renamed from: ii */
    public int f1975ii = 0;
    /* renamed from: ij */
    public String f1976ij = "";
    /* renamed from: ik */
    public int f1977ik = 0;
    /* renamed from: il */
    public int f1978il = 0;
    /* renamed from: im */
    public int f1979im = 0;
    /* renamed from: in */
    public int f1980in = 0;
    /* renamed from: io */
    public int f1981io = 0;
    /* renamed from: ip */
    public int f1982ip = 0;
    /* renamed from: iq */
    public int f1983iq = 0;
    /* renamed from: ir */
    public int f1984ir = 0;
    /* renamed from: is */
    public String f1985is = "";
    public String name = "";

    /* renamed from: a */
    public final int compareTo(C0790er c0790er) {
        int[] iArr = new int[]{C0865gz.m2306a(this.f1969W, c0790er.f1969W), C0865gz.m2306a(this.f1973ig, c0790er.f1973ig), C0865gz.m2306a(this.f1971az, c0790er.f1971az), C0865gz.m2306a(this.f1974ih, c0790er.f1974ih)};
        for (int i = 0; i < 4; i++) {
            if (iArr[i] != 0) {
                return iArr[i];
            }
        }
        return 0;
    }

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        this.f1969W = c0863gw.mo5896a(0, true);
        this.f1973ig = c0863gw.mo5896a(1, true);
        this.f1971az = c0863gw.mo5896a(2, true);
        this.f1974ih = c0863gw.mo5896a(3, false);
        this.f1970X = c0863gw.mo5896a(4, false);
        this.f1975ii = c0863gw.mo5893a(this.f1975ii, 5, false);
        this.name = c0863gw.mo5896a(6, false);
        this.f1972gM = c0863gw.mo5893a(this.f1972gM, 7, false);
        this.f1976ij = c0863gw.mo5896a(8, false);
        this.f1977ik = c0863gw.mo5893a(this.f1977ik, 9, false);
        this.f1978il = c0863gw.mo5893a(this.f1978il, 10, false);
        this.f1979im = c0863gw.mo5893a(this.f1979im, 11, false);
        this.f1980in = c0863gw.mo5893a(this.f1980in, 12, false);
        this.f1981io = c0863gw.mo5893a(this.f1981io, 13, false);
        this.f1982ip = c0863gw.mo5893a(this.f1982ip, 14, false);
        this.f1983iq = c0863gw.mo5893a(this.f1983iq, 15, false);
        this.f1984ir = c0863gw.mo5893a(this.f1984ir, 16, false);
        this.f1985is = c0863gw.mo5896a(17, false);
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5935d(this.f1969W, 0);
        c0864gx.mo5935d(this.f1973ig, 1);
        c0864gx.mo5935d(this.f1971az, 2);
        if (this.f1974ih != null) {
            c0864gx.mo5935d(this.f1974ih, 3);
        }
        if (this.f1970X != null) {
            c0864gx.mo5935d(this.f1970X, 4);
        }
        if (this.f1975ii != 0) {
            c0864gx.mo5936f(this.f1975ii, 5);
        }
        if (this.name != null) {
            c0864gx.mo5935d(this.name, 6);
        }
        if (this.f1972gM != 0) {
            c0864gx.mo5936f(this.f1972gM, 7);
        }
        if (this.f1976ij != null) {
            c0864gx.mo5935d(this.f1976ij, 8);
        }
        if (this.f1977ik != 0) {
            c0864gx.mo5936f(this.f1977ik, 9);
        }
        if (this.f1978il != 0) {
            c0864gx.mo5936f(this.f1978il, 10);
        }
        if (this.f1979im != 0) {
            c0864gx.mo5936f(this.f1979im, 11);
        }
        if (this.f1980in != 0) {
            c0864gx.mo5936f(this.f1980in, 12);
        }
        if (this.f1981io != 0) {
            c0864gx.mo5936f(this.f1981io, 13);
        }
        if (this.f1982ip != 0) {
            c0864gx.mo5936f(this.f1982ip, 14);
        }
        if (this.f1983iq != 0) {
            c0864gx.mo5936f(this.f1983iq, 15);
        }
        if (this.f1984ir != 0) {
            c0864gx.mo5936f(this.f1984ir, 16);
        }
        if (this.f1985is != null) {
            c0864gx.mo5935d(this.f1985is, 17);
        }
    }
}
