package com.loopj.android.http;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.loopj.android.http.b */
final class C0908b implements HttpRequestInterceptor {
    /* renamed from: a */
    final /* synthetic */ C0907a f2238a;

    C0908b(C0907a c0907a) {
        this.f2238a = c0907a;
    }

    public final void process(HttpRequest httpRequest, HttpContext httpContext) {
        if (!httpRequest.containsHeader("Accept-Encoding")) {
            httpRequest.addHeader("Accept-Encoding", "gzip");
        }
        for (String str : this.f2238a.f2237g.keySet()) {
            httpRequest.addHeader(str, (String) this.f2238a.f2237g.get(str));
        }
    }
}
