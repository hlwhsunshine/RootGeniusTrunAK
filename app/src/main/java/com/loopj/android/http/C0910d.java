package com.loopj.android.http;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.loopj.android.http.d */
final class C0910d implements Runnable {
    /* renamed from: a */
    private final AbstractHttpClient f2240a;
    /* renamed from: b */
    private final HttpContext f2241b;
    /* renamed from: c */
    private final HttpUriRequest f2242c;
    /* renamed from: d */
    private final C0911e f2243d;
    /* renamed from: e */
    private boolean f2244e;
    /* renamed from: f */
    private int f2245f;

    public C0910d(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, C0911e c0911e) {
        this.f2240a = abstractHttpClient;
        this.f2241b = httpContext;
        this.f2242c = httpUriRequest;
        this.f2243d = c0911e;
        if (c0911e instanceof C0913g) {
            this.f2244e = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053 A:{ExcHandler: java.io.IOException (r0_24 'e' java.lang.Throwable), Splitter: B:1:0x0001} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074 A:{ExcHandler: java.lang.Exception (r0_25 'e' java.lang.Throwable), Splitter: B:1:0x0001} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:24:0x0053, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:26:0x0056, code:
            if (r7.f2243d != null) goto L_0x0058;
     */
    /* JADX WARNING: Missing block: B:27:0x0058, code:
            r7.f2243d.mo6016b();
     */
    /* JADX WARNING: Missing block: B:28:0x005f, code:
            if (r7.f2244e != false) goto L_0x0061;
     */
    /* JADX WARNING: Missing block: B:29:0x0061, code:
            r7.f2243d.mo6014a(r0, null);
     */
    /* JADX WARNING: Missing block: B:35:0x0074, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:37:0x0077, code:
            if (r7.f2243d != null) goto L_0x0079;
     */
    /* JADX WARNING: Missing block: B:38:0x0079, code:
            r7.f2243d.mo6016b();
     */
    /* JADX WARNING: Missing block: B:39:0x0080, code:
            if (r7.f2244e != false) goto L_0x0082;
     */
    /* JADX WARNING: Missing block: B:40:0x0082, code:
            r7.f2243d.mo6014a(r0, null);
     */
    /* JADX WARNING: Missing block: B:51:0x00a5, code:
            r2 = false;
     */
    /* JADX WARNING: Missing block: B:57:0x00db, code:
            r7.f2243d.mo6018b(r0, null);
     */
    /* JADX WARNING: Missing block: B:58:0x00e2, code:
            r7.f2243d.mo6018b(r0, null);
     */
    /* JADX WARNING: Missing block: B:67:?, code:
            return;
     */
    /* JADX WARNING: Missing block: B:68:?, code:
            return;
     */
    /* JADX WARNING: Missing block: B:69:?, code:
            return;
     */
    /* JADX WARNING: Missing block: B:70:?, code:
            return;
     */
    /* JADX WARNING: Missing block: B:71:?, code:
            return;
     */
    /* JADX WARNING: Missing block: B:72:?, code:
            return;
     */
    public final void run() {
        /*
        r7 = this;
        r1 = 0;
        r0 = r7.f2243d;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        if (r0 == 0) goto L_0x000a;
    L_0x0005:
        r0 = r7.f2243d;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r0.mo6010a();	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
    L_0x000a:
        r0 = 1;
        r2 = r7.f2240a;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r3 = r2.getHttpRequestRetryHandler();	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r2 = r0;
        r0 = r1;
    L_0x0013:
        if (r2 == 0) goto L_0x00d2;
    L_0x0015:
        r0 = java.lang.Thread.currentThread();	 Catch:{ UnknownHostException -> 0x0046, SocketException -> 0x0067, SocketTimeoutException -> 0x0088, IOException -> 0x0095, NullPointerException -> 0x00a8, Exception -> 0x0074 }
        r0 = r0.isInterrupted();	 Catch:{ UnknownHostException -> 0x0046, SocketException -> 0x0067, SocketTimeoutException -> 0x0088, IOException -> 0x0095, NullPointerException -> 0x00a8, Exception -> 0x0074 }
        if (r0 != 0) goto L_0x003c;
    L_0x001f:
        r0 = r7.f2240a;	 Catch:{ UnknownHostException -> 0x0046, SocketException -> 0x0067, SocketTimeoutException -> 0x0088, IOException -> 0x0095, NullPointerException -> 0x00a8, Exception -> 0x0074 }
        r2 = r7.f2242c;	 Catch:{ UnknownHostException -> 0x0046, SocketException -> 0x0067, SocketTimeoutException -> 0x0088, IOException -> 0x0095, NullPointerException -> 0x00a8, Exception -> 0x0074 }
        r4 = r7.f2241b;	 Catch:{ UnknownHostException -> 0x0046, SocketException -> 0x0067, SocketTimeoutException -> 0x0088, IOException -> 0x0095, NullPointerException -> 0x00a8, Exception -> 0x0074 }
        r0 = r0.execute(r2, r4);	 Catch:{ UnknownHostException -> 0x0046, SocketException -> 0x0067, SocketTimeoutException -> 0x0088, IOException -> 0x0095, NullPointerException -> 0x00a8, Exception -> 0x0074 }
        r2 = java.lang.Thread.currentThread();	 Catch:{ UnknownHostException -> 0x0046, SocketException -> 0x0067, SocketTimeoutException -> 0x0088, IOException -> 0x0095, NullPointerException -> 0x00a8, Exception -> 0x0074 }
        r2 = r2.isInterrupted();	 Catch:{ UnknownHostException -> 0x0046, SocketException -> 0x0067, SocketTimeoutException -> 0x0088, IOException -> 0x0095, NullPointerException -> 0x00a8, Exception -> 0x0074 }
        if (r2 != 0) goto L_0x003c;
    L_0x0033:
        r2 = r7.f2243d;	 Catch:{ UnknownHostException -> 0x0046, SocketException -> 0x0067, SocketTimeoutException -> 0x0088, IOException -> 0x0095, NullPointerException -> 0x00a8, Exception -> 0x0074 }
        if (r2 == 0) goto L_0x003c;
    L_0x0037:
        r2 = r7.f2243d;	 Catch:{ UnknownHostException -> 0x0046, SocketException -> 0x0067, SocketTimeoutException -> 0x0088, IOException -> 0x0095, NullPointerException -> 0x00a8, Exception -> 0x0074 }
        r2.mo6015a(r0);	 Catch:{ UnknownHostException -> 0x0046, SocketException -> 0x0067, SocketTimeoutException -> 0x0088, IOException -> 0x0095, NullPointerException -> 0x00a8, Exception -> 0x0074 }
    L_0x003c:
        r0 = r7.f2243d;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        if (r0 == 0) goto L_0x0045;
    L_0x0040:
        r0 = r7.f2243d;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r0.mo6016b();	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
    L_0x0045:
        return;
    L_0x0046:
        r0 = move-exception;
        r2 = r7.f2243d;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        if (r2 == 0) goto L_0x003c;
    L_0x004b:
        r2 = r7.f2243d;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r3 = "can't resolve host";
        r2.mo6018b(r0, r3);	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        goto L_0x003c;
    L_0x0053:
        r0 = move-exception;
        r2 = r7.f2243d;
        if (r2 == 0) goto L_0x0045;
    L_0x0058:
        r2 = r7.f2243d;
        r2.mo6016b();
        r2 = r7.f2244e;
        if (r2 == 0) goto L_0x00db;
    L_0x0061:
        r2 = r7.f2243d;
        r2.mo6014a(r0, r1);
        goto L_0x0045;
    L_0x0067:
        r0 = move-exception;
        r2 = r7.f2243d;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        if (r2 == 0) goto L_0x003c;
    L_0x006c:
        r2 = r7.f2243d;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r3 = "can't resolve host";
        r2.mo6018b(r0, r3);	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        goto L_0x003c;
    L_0x0074:
        r0 = move-exception;
        r2 = r7.f2243d;
        if (r2 == 0) goto L_0x0045;
    L_0x0079:
        r2 = r7.f2243d;
        r2.mo6016b();
        r2 = r7.f2244e;
        if (r2 == 0) goto L_0x00e2;
    L_0x0082:
        r2 = r7.f2243d;
        r2.mo6014a(r0, r1);
        goto L_0x0045;
    L_0x0088:
        r0 = move-exception;
        r2 = r7.f2243d;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        if (r2 == 0) goto L_0x003c;
    L_0x008d:
        r2 = r7.f2243d;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r3 = "socket time out";
        r2.mo6018b(r0, r3);	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        goto L_0x003c;
    L_0x0095:
        r0 = move-exception;
        r2 = r7.f2245f;	 Catch:{ Exception -> 0x00a4, IOException -> 0x0053 }
        r2 = r2 + 1;
        r7.f2245f = r2;	 Catch:{ Exception -> 0x00a4, IOException -> 0x0053 }
        r4 = r7.f2241b;	 Catch:{ Exception -> 0x00a4, IOException -> 0x0053 }
        r2 = r3.retryRequest(r0, r2, r4);	 Catch:{ Exception -> 0x00a4, IOException -> 0x0053 }
        goto L_0x0013;
    L_0x00a4:
        r2 = move-exception;
        r2 = 0;
        goto L_0x0013;
    L_0x00a8:
        r0 = move-exception;
        r2 = new java.io.IOException;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r5 = "NPE in HttpClient";
        r4.<init>(r5);	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r0 = r0.getMessage();	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r0 = r4.append(r0);	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r0 = r7.f2245f;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r0 = r0 + 1;
        r7.f2245f = r0;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r4 = r7.f2241b;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r0 = r3.retryRequest(r2, r0, r4);	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r6 = r2;
        r2 = r0;
        r0 = r6;
        goto L_0x0013;
    L_0x00d2:
        r2 = new java.net.ConnectException;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r2.<init>();	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        r2.initCause(r0);	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
        throw r2;	 Catch:{ IOException -> 0x0053, Exception -> 0x0074 }
    L_0x00db:
        r2 = r7.f2243d;
        r2.mo6018b(r0, r1);
        goto L_0x0045;
    L_0x00e2:
        r2 = r7.f2243d;
        r2.mo6018b(r0, r1);
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loopj.android.http.d.run():void");
    }
}
