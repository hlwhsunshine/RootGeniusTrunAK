package com.loopj.android.http;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.loopj.android.http.h */
final class C0914h implements HttpRequestRetryHandler {
    /* renamed from: a */
    private static HashSet<Class<?>> f2250a = new HashSet();
    /* renamed from: b */
    private static HashSet<Class<?>> f2251b = new HashSet();
    /* renamed from: c */
    private final int f2252c = 5;

    static {
        f2250a.add(NoHttpResponseException.class);
        f2250a.add(UnknownHostException.class);
        f2250a.add(SocketException.class);
        f2251b.add(InterruptedIOException.class);
        f2251b.add(SSLHandshakeException.class);
    }

    public final boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        boolean z = true;
        Boolean bool = (Boolean) httpContext.getAttribute("http.request_sent");
        boolean z2 = bool != null && bool.booleanValue();
        z2 = i > this.f2252c ? false : f2251b.contains(iOException.getClass()) ? false : f2250a.contains(iOException.getClass()) ? true : !z2 ? true : true;
        if (!z2) {
            z = z2;
        } else if (((HttpUriRequest) httpContext.getAttribute("http.request")).getMethod().equals("POST")) {
            z = false;
        }
        if (z) {
            SystemClock.sleep(1500);
        } else {
            iOException.printStackTrace();
        }
        return z;
    }
}
