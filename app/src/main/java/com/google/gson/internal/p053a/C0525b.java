package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0479d;
import com.google.gson.C0507s;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.p052b.C0475a;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* renamed from: com.google.gson.internal.a.b */
final class C0525b implements C0507s {
    C0525b() {
    }

    /* renamed from: a */
    public final <T> C0477r<T> mo5478a(C0479d c0479d, C0475a<T> c0475a) {
        Type b = c0475a.mo5372b();
        if (!(b instanceof GenericArrayType) && (!(b instanceof Class) || !((Class) b).isArray())) {
            return null;
        }
        b = C$Gson$Types.m1040d(b);
        return new C0497a(c0479d, c0479d.mo5380a(C0475a.m1006a(b)), C$Gson$Types.m1036b(b));
    }
}
