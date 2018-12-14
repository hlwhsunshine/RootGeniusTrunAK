package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.JsonToken;
import java.math.BigDecimal;

/* renamed from: com.google.gson.internal.a.aa */
final class C0498aa extends C0477r<BigDecimal> {
    C0498aa() {
    }

    /* renamed from: b */
    private static BigDecimal m1052b(C0531a c0531a) {
        if (c0531a.mo5490f() == JsonToken.NULL) {
            c0531a.mo5494j();
            return null;
        }
        try {
            return new BigDecimal(c0531a.mo5492h());
        } catch (Throwable e) {
            throw new JsonSyntaxException(e);
        }
    }
}
