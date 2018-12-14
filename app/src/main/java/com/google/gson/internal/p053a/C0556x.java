package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.JsonToken;

/* renamed from: com.google.gson.internal.a.x */
final class C0556x extends C0477r<Number> {
    C0556x() {
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo5377a(C0531a c0531a) {
        JsonToken f = c0531a.mo5490f();
        switch (f) {
            case NUMBER:
                return new LazilyParsedNumber(c0531a.mo5492h());
            case NULL:
                c0531a.mo5494j();
                return null;
            default:
                throw new JsonSyntaxException("Expecting number, got: " + f);
        }
    }
}
