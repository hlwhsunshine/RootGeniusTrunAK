package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.JsonToken;
import java.math.BigInteger;

/* renamed from: com.google.gson.internal.a.ab */
final class C0499ab extends C0477r<BigInteger> {
    C0499ab() {
    }

    /* renamed from: b */
    private static BigInteger m1055b(C0531a c0531a) {
        if (c0531a.mo5490f() == JsonToken.NULL) {
            c0531a.mo5494j();
            return null;
        }
        try {
            return new BigInteger(c0531a.mo5492h());
        } catch (Throwable e) {
            throw new JsonSyntaxException(e);
        }
    }
}
