package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.JsonToken;

/* renamed from: com.google.gson.internal.a.av */
final class C0520av extends C0477r<Number> {
    C0520av() {
    }

    /* renamed from: b */
    private static Number m1095b(C0531a c0531a) {
        if (c0531a.mo5490f() == JsonToken.NULL) {
            c0531a.mo5494j();
            return null;
        }
        try {
            return Byte.valueOf((byte) c0531a.mo5497m());
        } catch (Throwable e) {
            throw new JsonSyntaxException(e);
        }
    }
}
