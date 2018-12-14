package com.google.gson;

import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;

/* renamed from: com.google.gson.i */
final class C0486i extends C0477r<Number> {
    /* renamed from: a */
    final /* synthetic */ C0479d f1244a;

    C0486i(C0479d c0479d) {
        this.f1244a = c0479d;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo5377a(C0531a c0531a) {
        if (c0531a.mo5490f() != JsonToken.NULL) {
            return Long.valueOf(c0531a.mo5496l());
        }
        c0531a.mo5494j();
        return null;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5378a(C0534c c0534c, Object obj) {
        Number number = (Number) obj;
        if (number == null) {
            c0534c.mo5519f();
        } else {
            c0534c.mo5510b(number.toString());
        }
    }
}
