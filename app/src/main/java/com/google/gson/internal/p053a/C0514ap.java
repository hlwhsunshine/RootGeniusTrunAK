package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0479d;
import com.google.gson.C0507s;
import com.google.gson.p052b.C0475a;

/* renamed from: com.google.gson.internal.a.ap */
final class C0514ap implements C0507s {
    /* renamed from: a */
    final /* synthetic */ Class f1285a;
    /* renamed from: b */
    final /* synthetic */ C0477r f1286b;

    C0514ap(Class cls, C0477r c0477r) {
        this.f1285a = cls;
        this.f1286b = c0477r;
    }

    /* renamed from: a */
    public final <T> C0477r<T> mo5478a(C0479d c0479d, C0475a<T> c0475a) {
        return c0475a.mo5371a() == this.f1285a ? this.f1286b : null;
    }

    public final String toString() {
        return "Factory[type=" + this.f1285a.getName() + ",adapter=" + this.f1286b + "]";
    }
}
