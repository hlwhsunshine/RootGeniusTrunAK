package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0479d;
import com.google.gson.C0507s;
import com.google.gson.internal.C0565b;
import com.google.gson.p051a.C0470b;
import com.google.gson.p052b.C0475a;

/* renamed from: com.google.gson.internal.a.f */
public final class C0530f implements C0507s {
    /* renamed from: a */
    private final C0565b f1302a;

    public C0530f(C0565b c0565b) {
        this.f1302a = c0565b;
    }

    /* renamed from: a */
    static C0477r<?> m1118a(C0565b c0565b, C0479d c0479d, C0475a<?> c0475a, C0470b c0470b) {
        Class a = c0470b.mo5364a();
        if (C0477r.class.isAssignableFrom(a)) {
            return (C0477r) c0565b.mo5532a(C0475a.m1005a(a)).mo5534a();
        }
        if (C0507s.class.isAssignableFrom(a)) {
            return ((C0507s) c0565b.mo5532a(C0475a.m1005a(a)).mo5534a()).mo5478a(c0479d, c0475a);
        }
        throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
    }

    /* renamed from: a */
    public final <T> C0477r<T> mo5478a(C0479d c0479d, C0475a<T> c0475a) {
        C0470b c0470b = (C0470b) c0475a.mo5371a().getAnnotation(C0470b.class);
        return c0470b == null ? null : C0530f.m1118a(this.f1302a, c0479d, c0475a, c0470b);
    }
}
