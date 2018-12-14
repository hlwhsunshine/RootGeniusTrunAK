package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0479d;
import com.google.gson.C0507s;
import com.google.gson.internal.p053a.C0553u.C0552a;
import com.google.gson.p052b.C0475a;

/* renamed from: com.google.gson.internal.a.ao */
final class C0513ao implements C0507s {
    C0513ao() {
    }

    /* renamed from: a */
    public final <T> C0477r<T> mo5478a(C0479d c0479d, C0475a<T> c0475a) {
        Class a = c0475a.mo5371a();
        if (!Enum.class.isAssignableFrom(a) || a == Enum.class) {
            return null;
        }
        if (!a.isEnum()) {
            a = a.getSuperclass();
        }
        return new C0552a(a);
    }
}
