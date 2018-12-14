package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.JsonToken;

/* renamed from: com.google.gson.internal.a.z */
final class C0558z extends C0477r<String> {
    C0558z() {
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo5377a(C0531a c0531a) {
        JsonToken f = c0531a.mo5490f();
        if (f != JsonToken.NULL) {
            return f == JsonToken.BOOLEAN ? Boolean.toString(c0531a.mo5493i()) : c0531a.mo5492h();
        } else {
            c0531a.mo5494j();
            return null;
        }
    }
}
