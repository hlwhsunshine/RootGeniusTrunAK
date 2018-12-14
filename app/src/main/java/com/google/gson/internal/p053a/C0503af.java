package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.JsonIOException;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;
import java.net.URI;

/* renamed from: com.google.gson.internal.a.af */
final class C0503af extends C0477r<URI> {
    C0503af() {
    }

    /* renamed from: b */
    private static URI m1064b(C0531a c0531a) {
        if (c0531a.mo5490f() == JsonToken.NULL) {
            c0531a.mo5494j();
            return null;
        }
        try {
            String h = c0531a.mo5492h();
            return !"null".equals(h) ? new URI(h) : null;
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5378a(C0534c c0534c, Object obj) {
        URI uri = (URI) obj;
        c0534c.mo5510b(uri == null ? null : uri.toASCIIString());
    }
}
