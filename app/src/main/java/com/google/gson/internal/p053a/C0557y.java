package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;

/* renamed from: com.google.gson.internal.a.y */
final class C0557y extends C0477r<Character> {
    C0557y() {
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo5377a(C0531a c0531a) {
        if (c0531a.mo5490f() == JsonToken.NULL) {
            c0531a.mo5494j();
            return null;
        }
        String h = c0531a.mo5492h();
        if (h.length() == 1) {
            return Character.valueOf(h.charAt(0));
        }
        throw new JsonSyntaxException("Expecting character, got: " + h);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5378a(C0534c c0534c, Object obj) {
        Character ch = (Character) obj;
        c0534c.mo5510b(ch == null ? null : String.valueOf(ch));
    }
}
