package com.loopj.android.http;

import android.content.Context;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

/* renamed from: com.loopj.android.http.a */
public final class C0907a {
    /* renamed from: a */
    private static int f2231a = 10;
    /* renamed from: b */
    private static int f2232b = 10000;
    /* renamed from: c */
    private final DefaultHttpClient f2233c;
    /* renamed from: d */
    private final HttpContext f2234d = new SyncBasicHttpContext(new BasicHttpContext());
    /* renamed from: e */
    private ThreadPoolExecutor f2235e;
    /* renamed from: f */
    private final Map<Context, List<WeakReference<Future<?>>>> f2236f;
    /* renamed from: g */
    private final Map<String, String> f2237g;

    /* renamed from: com.loopj.android.http.a$a */
    private static class C0906a extends HttpEntityWrapper {
        public C0906a(HttpEntity httpEntity) {
            super(httpEntity);
        }

        public final InputStream getContent() {
            return new GZIPInputStream(this.wrappedEntity.getContent());
        }

        public final long getContentLength() {
            return -1;
        }
    }

    public C0907a() {
        HttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, (long) f2232b);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(f2231a));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, f2232b);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, f2232b);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basicHttpParams, String.format("android-async-http/%s (http://loopj.com/android-async-http)", new Object[]{"1.4.1"}));
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ClientConnectionManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        this.f2233c = new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        this.f2233c.addRequestInterceptor(new C0908b(this));
        this.f2233c.addResponseInterceptor(new C0909c(this));
        this.f2233c.setHttpRequestRetryHandler(new C0914h());
        this.f2235e = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        this.f2236f = new WeakHashMap();
        this.f2237g = new HashMap();
    }

    /* renamed from: a */
    public final void mo6005a(String str, C0911e c0911e) {
        this.f2235e.submit(new C0910d(this.f2233c, this.f2234d, new HttpPost(str), c0911e));
    }
}
