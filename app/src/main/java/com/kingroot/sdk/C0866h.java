package com.kingroot.sdk;

import java.util.ArrayList;

/* renamed from: com.kingroot.sdk.h */
public final class C0866h extends C0597gy implements Cloneable {
    /* renamed from: A */
    static ArrayList<C0837g> f2154A;
    /* renamed from: c */
    static final /* synthetic */ boolean f2155c = (!C0866h.class.desiredAssertionStatus());
    /* renamed from: z */
    public ArrayList<C0837g> f2156z = null;

    public C0866h() {
        mo5939d(this.f2156z);
    }

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        if (f2154A == null) {
            f2154A = new ArrayList();
            f2154A.add(new C0837g());
        }
        mo5939d((ArrayList) c0863gw.mo5911b(f2154A, 1, true));
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5921a(this.f2156z, 1);
    }

    /* renamed from: a */
    public final void mo5571a(StringBuilder stringBuilder, int i) {
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f2155c) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: d */
    public final void mo5939d(ArrayList<C0837g> arrayList) {
        this.f2156z = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return C0865gz.equals(this.f2156z, ((C0866h) obj).f2156z);
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
