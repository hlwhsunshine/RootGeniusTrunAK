package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;

/* renamed from: com.google.gson.internal.a.ar */
final class C0516ar extends C0477r<Boolean> {
    C0516ar() {
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo5377a(C0531a c0531a) {
        if (c0531a.mo5490f() != JsonToken.NULL) {
            return c0531a.mo5490f() == JsonToken.STRING ? Boolean.valueOf(Boolean.parseBoolean(c0531a.mo5492h())) : Boolean.valueOf(c0531a.mo5493i());
        } else {
            c0531a.mo5494j();
            return null;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5378a(C0534c c0534c, Object obj) {
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            c0534c.mo5519f();
        } else {
            c0534c.mo5508a(bool.booleanValue());
        }
    }
}
