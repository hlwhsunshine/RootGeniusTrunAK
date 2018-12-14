package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;
import java.util.Locale;
import java.util.StringTokenizer;

/* renamed from: com.google.gson.internal.a.am */
final class C0511am extends C0477r<Locale> {
    C0511am() {
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo5377a(C0531a c0531a) {
        if (c0531a.mo5490f() == JsonToken.NULL) {
            c0531a.mo5494j();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(c0531a.mo5492h(), "_");
        String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5378a(C0534c c0534c, Object obj) {
        Locale locale = (Locale) obj;
        c0534c.mo5510b(locale == null ? null : locale.toString());
    }
}
