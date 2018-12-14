package com.tencent.mid.p116a;

import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.tencent.mid.a.c */
final class C1633c implements ConnectionKeepAliveStrategy {
    C1633c() {
    }

    public final long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        long j = 10;
        if (httpResponse == null) {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        BasicHeaderElementIterator basicHeaderElementIterator = new BasicHeaderElementIterator(httpResponse.headerIterator("Keep-Alive"));
        while (basicHeaderElementIterator.hasNext()) {
            HeaderElement nextElement = basicHeaderElementIterator.nextElement();
            String name = nextElement.getName();
            String value = nextElement.getValue();
            if (value != null && name.equalsIgnoreCase("timeout")) {
                try {
                    long parseLong = Long.parseLong(value);
                    if (parseLong > 11) {
                        j = parseLong - 10;
                    }
                    return j * 1000;
                } catch (NumberFormatException e) {
                }
            }
        }
        return 180000;
    }
}
