package com.kingroot.sdk;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.kingroot.sdk.gs */
public final class C0858gs extends C0597gy {
    /* renamed from: c */
    static final /* synthetic */ boolean f2132c = (!C0858gs.class.desiredAssertionStatus());
    /* renamed from: kj */
    static byte[] f2133kj = null;
    /* renamed from: kk */
    static Map<String, String> f2134kk = null;
    /* renamed from: jZ */
    public short f2135jZ = (short) 0;
    /* renamed from: ka */
    public byte f2136ka = (byte) 0;
    /* renamed from: kb */
    public int f2137kb = 0;
    /* renamed from: kc */
    public int f2138kc = 0;
    /* renamed from: kd */
    public String f2139kd = null;
    /* renamed from: ke */
    public String f2140ke = null;
    /* renamed from: kf */
    public byte[] f2141kf;
    /* renamed from: kg */
    public int f2142kg = 0;
    /* renamed from: kh */
    public Map<String, String> f2143kh;
    /* renamed from: ki */
    public Map<String, String> f2144ki;

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        try {
            Map hashMap;
            this.f2135jZ = c0863gw.mo5899a(this.f2135jZ, 1, true);
            this.f2136ka = c0863gw.mo5890a(this.f2136ka, 2, true);
            this.f2137kb = c0863gw.mo5893a(this.f2137kb, 3, true);
            this.f2138kc = c0863gw.mo5893a(this.f2138kc, 4, true);
            this.f2139kd = c0863gw.mo5896a(5, true);
            this.f2140ke = c0863gw.mo5896a(6, true);
            if (f2133kj == null) {
                f2133kj = new byte[1];
            }
            this.f2141kf = c0863gw.mo5902a(f2133kj, 7, true);
            this.f2142kg = c0863gw.mo5893a(this.f2142kg, 8, true);
            if (f2134kk == null) {
                hashMap = new HashMap();
                f2134kk = hashMap;
                hashMap.put("", "");
            }
            this.f2143kh = (Map) c0863gw.mo5911b(f2134kk, 9, true);
            if (f2134kk == null) {
                hashMap = new HashMap();
                f2134kk = hashMap;
                hashMap.put("", "");
            }
            this.f2144ki = (Map) c0863gw.mo5911b(f2134kk, 10, true);
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("RequestPacket decode error " + C0857gr.m2227n(this.f2141kf));
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5923a(this.f2135jZ, 1);
        c0864gx.mo5933b(this.f2136ka, 2);
        c0864gx.mo5936f(this.f2137kb, 3);
        c0864gx.mo5936f(this.f2138kc, 4);
        c0864gx.mo5935d(this.f2139kd, 5);
        c0864gx.mo5935d(this.f2140ke, 6);
        c0864gx.mo5925a(this.f2141kf, 7);
        c0864gx.mo5936f(this.f2142kg, 8);
        c0864gx.mo5922a(this.f2143kh, 9);
        c0864gx.mo5922a(this.f2144ki, 10);
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f2132c) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        C0858gs c0858gs = (C0858gs) obj;
        return C0865gz.equals(1, c0858gs.f2135jZ) && C0865gz.equals(1, c0858gs.f2136ka) && C0865gz.equals(1, c0858gs.f2137kb) && C0865gz.equals(1, c0858gs.f2138kc) && C0865gz.equals(Integer.valueOf(1), c0858gs.f2139kd) && C0865gz.equals(Integer.valueOf(1), c0858gs.f2140ke) && C0865gz.equals(Integer.valueOf(1), c0858gs.f2141kf) && C0865gz.equals(1, c0858gs.f2142kg) && C0865gz.equals(Integer.valueOf(1), c0858gs.f2143kh) && C0865gz.equals(Integer.valueOf(1), c0858gs.f2144ki);
    }
}
