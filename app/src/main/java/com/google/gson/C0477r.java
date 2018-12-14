package com.google.gson;

import com.google.gson.internal.p053a.C0535i;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;

/* renamed from: com.google.gson.r */
public abstract class C0477r<T> {
    /* renamed from: a */
    public final C0591m mo5376a(T t) {
        try {
            C0534c c0535i = new C0535i();
            mo5378a(c0535i, t);
            return c0535i.mo5524a();
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }

    /* renamed from: a */
    public abstract T mo5377a(C0531a c0531a);

    /* renamed from: a */
    public abstract void mo5378a(C0534c c0534c, T t);
}
