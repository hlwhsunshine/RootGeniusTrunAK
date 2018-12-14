package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0479d;
import com.google.gson.C0507s;
import com.google.gson.p052b.C0475a;

/* renamed from: com.google.gson.internal.a.aq */
final class C0515aq implements C0507s {
    /* renamed from: a */
    final /* synthetic */ Class f1287a;
    /* renamed from: b */
    final /* synthetic */ Class f1288b;
    /* renamed from: c */
    final /* synthetic */ C0477r f1289c;

    C0515aq(Class cls, Class cls2, C0477r c0477r) {
        this.f1287a = cls;
        this.f1288b = cls2;
        this.f1289c = c0477r;
    }

    /* renamed from: a */
    public final <T> C0477r<T> mo5478a(C0479d c0479d, C0475a<T> c0475a) {
        Class a = c0475a.mo5371a();
        return (a == this.f1287a || a == this.f1288b) ? this.f1289c : null;
    }

    public final String toString() {
        return "Factory[type=" + this.f1288b.getName() + "+" + this.f1287a.getName() + ",adapter=" + this.f1289c + "]";
    }
}
