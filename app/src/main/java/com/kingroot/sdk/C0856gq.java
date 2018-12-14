package com.kingroot.sdk;

import java.nio.ByteBuffer;
import java.util.HashMap;

/* renamed from: com.kingroot.sdk.gq */
public class C0856gq extends C0855gp {
    /* renamed from: jU */
    static HashMap<String, byte[]> f2126jU = null;
    /* renamed from: jV */
    static HashMap<String, HashMap<String, byte[]>> f2127jV = null;
    /* renamed from: jT */
    protected C0858gs f2128jT;
    /* renamed from: jW */
    private int f2129jW;

    public C0856gq() {
        this.f2128jT = new C0858gs();
        this.f2129jW = 0;
        this.f2128jT.f2135jZ = (short) 2;
    }

    public C0856gq(boolean z) {
        this.f2128jT = new C0858gs();
        this.f2129jW = 0;
        if (z) {
            mo5863cl();
        } else {
            this.f2128jT.f2135jZ = (short) 2;
        }
    }

    /* renamed from: cm */
    private void m2218cm() {
        C0863gw c0863gw = new C0863gw(this.f2128jT.f2141kf);
        c0863gw.mo5910au(this.f2121jQ);
        if (f2126jU == null) {
            HashMap hashMap = new HashMap();
            f2126jU = hashMap;
            hashMap.put("", new byte[0]);
        }
        this.f2125jS = c0863gw.mo5897a(f2126jU, 0, false);
    }

    /* renamed from: cn */
    private void m2219cn() {
        C0863gw c0863gw = new C0863gw(this.f2128jT.f2141kf);
        c0863gw.mo5910au(this.f2121jQ);
        if (f2127jV == null) {
            f2127jV = new HashMap();
            HashMap hashMap = new HashMap();
            hashMap.put("", new byte[0]);
            f2127jV.put("", hashMap);
        }
        this.f2118jN = c0863gw.mo5897a(f2127jV, 0, false);
        this.f2119jO = new HashMap();
    }

    /* renamed from: J */
    public void mo5864J(int i) {
        this.f2128jT.f2138kc = i;
    }

    /* renamed from: ar */
    public void mo5865ar(String str) {
        this.f2128jT.f2139kd = str;
    }

    /* renamed from: as */
    public void mo5866as(String str) {
        this.f2128jT.f2140ke = str;
    }

    /* renamed from: ck */
    public byte[] mo5859ck() {
        if (this.f2128jT.f2135jZ != (short) 2) {
            if (this.f2128jT.f2139kd == null) {
                this.f2128jT.f2139kd = "";
            }
            if (this.f2128jT.f2140ke == null) {
                this.f2128jT.f2140ke = "";
            }
        } else if (this.f2128jT.f2139kd == null || this.f2128jT.f2139kd.equals("")) {
            throw new IllegalArgumentException("servantName can not is null");
        } else if (this.f2128jT.f2140ke == null || this.f2128jT.f2140ke.equals("")) {
            throw new IllegalArgumentException("funcName can not is null");
        }
        C0864gx c0864gx = new C0864gx(0);
        c0864gx.mo5932au(this.f2121jQ);
        if (this.f2128jT.f2135jZ == (short) 2) {
            c0864gx.mo5922a(this.f2118jN, 0);
        } else {
            c0864gx.mo5922a(this.f2125jS, 0);
        }
        this.f2128jT.f2141kf = C0865gz.m2307a(c0864gx.mo5934cq());
        c0864gx = new C0864gx(0);
        c0864gx.mo5932au(this.f2121jQ);
        this.f2128jT.mo5570a(c0864gx);
        byte[] a = C0865gz.m2307a(c0864gx.mo5934cq());
        int length = a.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4);
        allocate.putInt(length + 4).put(a).flip();
        return allocate.array();
    }

    /* renamed from: cl */
    public void mo5863cl() {
        super.mo5863cl();
        this.f2128jT.f2135jZ = (short) 3;
    }

    /* renamed from: m */
    public void mo5860m(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            C0863gw c0863gw = new C0863gw(bArr, 4);
            c0863gw.mo5910au(this.f2121jQ);
            this.f2128jT.mo5569a(c0863gw);
            if (this.f2128jT.f2135jZ == (short) 3) {
                m2218cm();
                return;
            }
            this.f2125jS = null;
            m2219cn();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public <T> void put(String str, T t) {
        if (str.startsWith(".")) {
            throw new IllegalArgumentException("put name can not startwith . , now is " + str);
        }
        super.put(str, t);
    }
}
