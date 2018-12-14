package com.tencent.stat;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.tencent.stat.h */
class C1749h extends DefaultConnectionKeepAliveStrategy {
    /* renamed from: a */
    final /* synthetic */ C1748g f5141a;

    C1749h(C1748g c1748g) {
        this.f5141a = c1748g;
    }

    public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        long keepAliveDuration = super.getKeepAliveDuration(httpResponse, httpContext);
        return keepAliveDuration == -1 ? 30000 : keepAliveDuration;
    }
}
