package com.kingroot.sdk;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.kingroot.sdk.gp */
public class C0855gp extends C0854go {
    /* renamed from: jP */
    private HashMap<String, Object> f2123jP = new HashMap();
    /* renamed from: jR */
    C0863gw f2124jR = new C0863gw();
    /* renamed from: jS */
    protected HashMap<String, byte[]> f2125jS = null;

    /* renamed from: a */
    private Object m2211a(byte[] bArr, Object obj) {
        this.f2124jR.mo5913o(bArr);
        this.f2124jR.mo5910au(this.f2121jQ);
        return this.f2124jR.mo5911b(obj, 0, true);
    }

    /* renamed from: b */
    private void m2212b(String str, Object obj) {
        this.f2123jP.put(str, obj);
    }

    /* renamed from: a */
    public <T> T mo5862a(String str, T t) {
        T a;
        if (this.f2125jS != null) {
            if (!this.f2125jS.containsKey(str)) {
                return null;
            }
            if (this.f2123jP.containsKey(str)) {
                return this.f2123jP.get(str);
            }
            try {
                a = m2211a((byte[]) this.f2125jS.get(str), (Object) t);
                if (a == null) {
                    return a;
                }
                m2212b(str, a);
                return a;
            } catch (Exception e) {
                throw new C0853gn(e);
            }
        } else if (!this.f2118jN.containsKey(str)) {
            return null;
        } else {
            if (this.f2123jP.containsKey(str)) {
                return this.f2123jP.get(str);
            }
            byte[] bArr;
            byte[] bArr2 = new byte[0];
            Iterator it = ((HashMap) this.f2118jN.get(str)).entrySet().iterator();
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                entry.getKey();
                bArr = (byte[]) entry.getValue();
            } else {
                bArr = bArr2;
            }
            try {
                this.f2124jR.mo5913o(bArr);
                this.f2124jR.mo5910au(this.f2121jQ);
                a = this.f2124jR.mo5911b(t, 0, true);
                m2212b(str, a);
                return a;
            } catch (Exception e2) {
                throw new C0853gn(e2);
            }
        }
    }

    /* renamed from: ck */
    public byte[] mo5859ck() {
        if (this.f2125jS == null) {
            return super.mo5859ck();
        }
        C0864gx c0864gx = new C0864gx(0);
        c0864gx.mo5932au(this.f2121jQ);
        c0864gx.mo5922a(this.f2125jS, 0);
        return C0865gz.m2307a(c0864gx.mo5934cq());
    }

    /* renamed from: cl */
    public void mo5863cl() {
        this.f2125jS = new HashMap();
    }

    /* renamed from: m */
    public void mo5860m(byte[] bArr) {
        try {
            super.mo5860m(bArr);
        } catch (Exception e) {
            this.f2124jR.mo5913o(bArr);
            this.f2124jR.mo5910au(this.f2121jQ);
            Map hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f2125jS = this.f2124jR.mo5897a(hashMap, 0, false);
        }
    }

    public <T> void put(String str, T t) {
        if (this.f2125jS == null) {
            super.put(str, t);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        } else {
            C0864gx c0864gx = new C0864gx();
            c0864gx.mo5932au(this.f2121jQ);
            c0864gx.mo5920a((Object) t, 0);
            this.f2125jS.put(str, C0865gz.m2307a(c0864gx.mo5934cq()));
        }
    }
}
