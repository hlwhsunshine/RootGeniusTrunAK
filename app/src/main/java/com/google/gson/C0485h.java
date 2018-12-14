package com.google.gson;

import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;

/* renamed from: com.google.gson.h */
final class C0485h extends C0477r<Number> {
    /* renamed from: a */
    final /* synthetic */ C0479d f1243a;

    C0485h(C0479d c0479d) {
        this.f1243a = c0479d;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo5377a(C0531a c0531a) {
        if (c0531a.mo5490f() != JsonToken.NULL) {
            return Float.valueOf((float) c0531a.mo5495k());
        }
        c0531a.mo5494j();
        return null;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5378a(C0534c c0534c, Object obj) {
        Number number = (Number) obj;
        if (number == null) {
            c0534c.mo5519f();
            return;
        }
        C0479d.m1017a((double) number.floatValue());
        c0534c.mo5506a(number);
    }
}
