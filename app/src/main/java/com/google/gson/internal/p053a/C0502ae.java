package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;
import java.net.URL;

/* renamed from: com.google.gson.internal.a.ae */
final class C0502ae extends C0477r<URL> {
    C0502ae() {
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo5377a(C0531a c0531a) {
        if (c0531a.mo5490f() == JsonToken.NULL) {
            c0531a.mo5494j();
            return null;
        }
        String h = c0531a.mo5492h();
        return !"null".equals(h) ? new URL(h) : null;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5378a(C0534c c0534c, Object obj) {
        URL url = (URL) obj;
        c0534c.mo5510b(url == null ? null : url.toExternalForm());
    }
}
