package com.shuame.p075ad;

import com.google.gson.p051a.C0471c;
import com.shuame.reportsdk.C1103b;
import java.util.Collection;

/* renamed from: com.shuame.ad.i */
final class C1104i extends C1103b {
    @C0471c(a = "imei")
    /* renamed from: a */
    public String f2939a;
    @C0471c(a = "imsi")
    /* renamed from: b */
    public String f2940b;
    @C0471c(a = "qimei")
    /* renamed from: c */
    public String f2941c;
    @C0471c(a = "channel")
    /* renamed from: d */
    public String f2942d;
    @C0471c(a = "product")
    /* renamed from: e */
    public String f2943e;
    @C0471c(a = "mac_address")
    /* renamed from: f */
    public String f2944f;
    @C0471c(a = "version_code")
    /* renamed from: g */
    public int f2945g;
    @C0471c(a = "imei_dk")
    /* renamed from: h */
    public Collection f2946h;
    @C0471c(a = "a")
    /* renamed from: i */
    public String f2947i;
    @C0471c(a = "b")
    /* renamed from: j */
    public String f2948j;
    @C0471c(a = "c")
    /* renamed from: k */
    public String f2949k;
    @C0471c(a = "d")
    /* renamed from: l */
    public int f2950l;
    @C0471c(a = "e")
    /* renamed from: m */
    public int f2951m = 0;
    @C0471c(a = "f")
    /* renamed from: n */
    public int f2952n;
    @C0471c(a = "g")
    /* renamed from: o */
    public int f2953o;
    @C0471c(a = "h")
    /* renamed from: p */
    public String f2954p;
    @C0471c(a = "k")
    /* renamed from: q */
    public long f2955q;
    @C0471c(a = "l")
    /* renamed from: r */
    public long f2956r;
    @C0471c(a = "m")
    /* renamed from: s */
    public String f2957s;
    @C0471c(a = "n")
    /* renamed from: t */
    public String f2958t;

    C1104i() {
    }

    /* renamed from: a */
    protected final String mo6700a() {
        return "/v2/stat/ad";
    }

    /* renamed from: a */
    public final void mo6701a(EventType eventType) {
        this.f2952n = eventType.ordinal();
    }
}
