package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0479d;
import com.google.gson.C0507s;
import com.google.gson.p052b.C0475a;

/* renamed from: com.google.gson.internal.a.at */
final class C0518at implements C0507s {
    /* renamed from: a */
    final /* synthetic */ Class f1293a;
    /* renamed from: b */
    final /* synthetic */ C0477r f1294b;

    C0518at(Class cls, C0477r c0477r) {
        this.f1293a = cls;
        this.f1294b = c0477r;
    }

    /* renamed from: a */
    public final <T> C0477r<T> mo5478a(C0479d c0479d, C0475a<T> c0475a) {
        return this.f1293a.isAssignableFrom(c0475a.mo5371a()) ? this.f1294b : null;
    }

    public final String toString() {
        return "Factory[typeHierarchy=" + this.f1293a.getName() + ",adapter=" + this.f1294b + "]";
    }
}
