package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0479d;
import com.google.gson.internal.p053a.C0544n.C0542a;
import com.google.gson.p052b.C0475a;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* renamed from: com.google.gson.internal.a.t */
final class C0550t<T> extends C0477r<T> {
    /* renamed from: a */
    private final C0479d f1365a;
    /* renamed from: b */
    private final C0477r<T> f1366b;
    /* renamed from: c */
    private final Type f1367c;

    C0550t(C0479d c0479d, C0477r<T> c0477r, Type type) {
        this.f1365a = c0479d;
        this.f1366b = c0477r;
        this.f1367c = type;
    }

    /* renamed from: a */
    public final T mo5377a(C0531a c0531a) {
        return this.f1366b.mo5377a(c0531a);
    }

    /* renamed from: a */
    public final void mo5378a(C0534c c0534c, T t) {
        C0477r a;
        C0477r c0477r = this.f1366b;
        Type type = this.f1367c;
        if (t != null && (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) {
            type = t.getClass();
        }
        if (type != this.f1367c) {
            a = this.f1365a.mo5380a(C0475a.m1006a(type));
            if ((a instanceof C0542a) && !(this.f1366b instanceof C0542a)) {
                a = this.f1366b;
            }
        } else {
            a = c0477r;
        }
        a.mo5378a(c0534c, t);
    }
}
