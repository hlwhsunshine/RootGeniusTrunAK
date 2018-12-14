package com.kingroot.sdk;

import java.util.ArrayList;

/* renamed from: com.kingroot.sdk.a */
public final class C0598a extends C0597gy implements Cloneable {
    /* renamed from: b */
    static ArrayList<C0802f> f1467b;
    /* renamed from: c */
    static final /* synthetic */ boolean f1468c = (!C0598a.class.desiredAssertionStatus());
    /* renamed from: a */
    public ArrayList<C0802f> f1469a = null;

    public C0598a() {
        mo5574a(this.f1469a);
    }

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        if (f1467b == null) {
            f1467b = new ArrayList();
            f1467b.add(new C0802f());
        }
        mo5574a((ArrayList) c0863gw.mo5911b(f1467b, 1, true));
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5921a(this.f1469a, 1);
    }

    /* renamed from: a */
    public final void mo5571a(StringBuilder stringBuilder, int i) {
    }

    /* renamed from: a */
    public final void mo5574a(ArrayList<C0802f> arrayList) {
        this.f1469a = arrayList;
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f1468c) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return C0865gz.equals(this.f1469a, ((C0598a) obj).f1469a);
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
