package com.kingroot.sdk;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.kingroot.sdk.go */
class C0854go {
    /* renamed from: jN */
    protected HashMap<String, HashMap<String, byte[]>> f2118jN = new HashMap();
    /* renamed from: jO */
    protected HashMap<String, Object> f2119jO = new HashMap();
    /* renamed from: jP */
    private HashMap<String, Object> f2120jP = new HashMap();
    /* renamed from: jQ */
    protected String f2121jQ = "GBK";
    /* renamed from: jR */
    C0863gw f2122jR = new C0863gw();

    C0854go() {
    }

    /* renamed from: a */
    private void m2207a(ArrayList<String> arrayList, Object obj) {
        Object obj2 = obj;
        while (true) {
            if (obj2.getClass().isArray()) {
                if (!obj2.getClass().getComponentType().toString().equals("byte")) {
                    throw new IllegalArgumentException("only byte[] is supported");
                } else if (Array.getLength(obj2) > 0) {
                    arrayList.add("java.util.List");
                    obj2 = Array.get(obj2, 0);
                } else {
                    arrayList.add("Array");
                    arrayList.add("?");
                    return;
                }
            } else if (obj2 instanceof Array) {
                throw new IllegalArgumentException("can not support Array, please use List");
            } else if (obj2 instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj2;
                if (list.size() > 0) {
                    obj2 = list.get(0);
                } else {
                    arrayList.add("?");
                    return;
                }
            } else if (obj2 instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj2;
                if (map.size() > 0) {
                    Object next = map.keySet().iterator().next();
                    obj2 = map.get(next);
                    arrayList.add(next.getClass().getName());
                } else {
                    arrayList.add("?");
                    arrayList.add("?");
                    return;
                }
            } else {
                arrayList.add(obj2.getClass().getName());
                return;
            }
        }
    }

    /* renamed from: aq */
    public void mo5858aq(String str) {
        this.f2121jQ = str;
    }

    /* renamed from: ck */
    public byte[] mo5859ck() {
        C0864gx c0864gx = new C0864gx(0);
        c0864gx.mo5932au(this.f2121jQ);
        c0864gx.mo5922a(this.f2118jN, 0);
        return C0865gz.m2307a(c0864gx.mo5934cq());
    }

    /* renamed from: m */
    public void mo5860m(byte[] bArr) {
        this.f2122jR.mo5913o(bArr);
        this.f2122jR.mo5910au(this.f2121jQ);
        Map hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f2118jN = this.f2122jR.mo5897a(hashMap, 0, false);
    }

    public <T> void put(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        } else {
            C0864gx c0864gx = new C0864gx();
            c0864gx.mo5932au(this.f2121jQ);
            c0864gx.mo5920a((Object) t, 0);
            Object a = C0865gz.m2307a(c0864gx.mo5934cq());
            HashMap hashMap = new HashMap(1);
            ArrayList arrayList = new ArrayList(1);
            m2207a(arrayList, t);
            hashMap.put(C0852gm.m2206f(arrayList), a);
            this.f2120jP.remove(str);
            this.f2118jN.put(str, hashMap);
        }
    }
}
