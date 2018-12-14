package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0479d;
import com.google.gson.C0507s;
import com.google.gson.p052b.C0475a;

/* renamed from: com.google.gson.internal.a.as */
final class C0517as implements C0507s {
    /* renamed from: a */
    final /* synthetic */ Class f1290a;
    /* renamed from: b */
    final /* synthetic */ Class f1291b;
    /* renamed from: c */
    final /* synthetic */ C0477r f1292c;

    C0517as(Class cls, Class cls2, C0477r c0477r) {
        this.f1290a = cls;
        this.f1291b = cls2;
        this.f1292c = c0477r;
    }

    /* renamed from: a */
    public final <T> C0477r<T> mo5478a(C0479d c0479d, C0475a<T> c0475a) {
        Class a = c0475a.mo5371a();
        return (a == this.f1290a || a == this.f1291b) ? this.f1292c : null;
    }

    public final String toString() {
        return "Factory[type=" + this.f1290a.getName() + "+" + this.f1291b.getName() + ",adapter=" + this.f1292c + "]";
    }
}
