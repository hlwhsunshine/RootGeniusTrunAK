package com.loopj.android.http;

import com.loopj.android.http.C0907a.C0906a;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.loopj.android.http.c */
final class C0909c implements HttpResponseInterceptor {
    /* renamed from: a */
    final /* synthetic */ C0907a f2239a;

    C0909c(C0907a c0907a) {
        this.f2239a = c0907a;
    }

    public final void process(HttpResponse httpResponse, HttpContext httpContext) {
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            Header contentEncoding = entity.getContentEncoding();
            if (contentEncoding != null) {
                for (HeaderElement name : contentEncoding.getElements()) {
                    if (name.getName().equalsIgnoreCase("gzip")) {
                        httpResponse.setEntity(new C0906a(httpResponse.getEntity()));
                        return;
                    }
                }
            }
        }
    }
}
