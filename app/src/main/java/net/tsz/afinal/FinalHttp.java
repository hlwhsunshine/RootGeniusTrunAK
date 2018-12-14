package net.tsz.afinal;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import net.tsz.afinal.http.HttpHandler;
import net.tsz.afinal.http.RetryHandler;
import net.tsz.afinal.http.SyncRequestHandler;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
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

public class FinalHttp {
    private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    private static final String ENCODING_GZIP = "gzip";
    private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    private static final Executor executor = Executors.newFixedThreadPool(httpThreadCount, sThreadFactory);
    private static int httpThreadCount = 3;
    private static int maxConnections = 10;
    private static int maxRetries = 5;
    private static final ThreadFactory sThreadFactory = new C17801();
    private static int socketTimeout = 10000;
    private String charset = "utf-8";
    private final Map<String, String> clientHeaderMap;
    private final DefaultHttpClient httpClient;
    private final HttpContext httpContext;

    /* renamed from: net.tsz.afinal.FinalHttp$1 */
    class C17801 implements ThreadFactory {
        private final AtomicInteger mCount = new AtomicInteger(1);

        C17801() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "FinalHttp #" + this.mCount.getAndIncrement());
            thread.setPriority(4);
            return thread;
        }
    }

    /* renamed from: net.tsz.afinal.FinalHttp$2 */
    class C17812 implements HttpRequestInterceptor {
        C17812() {
        }

        public void process(HttpRequest httpRequest, HttpContext httpContext) {
            if (!httpRequest.containsHeader(FinalHttp.HEADER_ACCEPT_ENCODING)) {
                httpRequest.addHeader(FinalHttp.HEADER_ACCEPT_ENCODING, FinalHttp.ENCODING_GZIP);
            }
            for (String str : FinalHttp.this.clientHeaderMap.keySet()) {
                httpRequest.addHeader(str, (String) FinalHttp.this.clientHeaderMap.get(str));
            }
        }
    }

    /* renamed from: net.tsz.afinal.FinalHttp$3 */
    class C17823 implements HttpResponseInterceptor {
        C17823() {
        }

        public void process(HttpResponse httpResponse, HttpContext httpContext) {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                Header contentEncoding = entity.getContentEncoding();
                if (contentEncoding != null) {
                    for (HeaderElement name : contentEncoding.getElements()) {
                        if (name.getName().equalsIgnoreCase(FinalHttp.ENCODING_GZIP)) {
                            httpResponse.setEntity(new InflatingEntity(httpResponse.getEntity()));
                            return;
                        }
                    }
                }
            }
        }
    }

    private static class InflatingEntity extends HttpEntityWrapper {
        public InflatingEntity(HttpEntity httpEntity) {
            super(httpEntity);
        }

        public InputStream getContent() {
            return new GZIPInputStream(this.wrappedEntity.getContent());
        }

        public long getContentLength() {
            return -1;
        }
    }

    public FinalHttp() {
        HttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, (long) socketTimeout);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(maxConnections));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, socketTimeout);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, socketTimeout);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ClientConnectionManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        this.httpContext = new SyncBasicHttpContext(new BasicHttpContext());
        this.httpClient = new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        this.httpClient.addRequestInterceptor(new C17812());
        this.httpClient.addResponseInterceptor(new C17823());
        this.httpClient.setHttpRequestRetryHandler(new RetryHandler(maxRetries));
        this.clientHeaderMap = new HashMap();
    }

    private HttpEntityEnclosingRequestBase addEntityToRequestBase(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, HttpEntity httpEntity) {
        if (httpEntity != null) {
            httpEntityEnclosingRequestBase.setEntity(httpEntity);
        }
        return httpEntityEnclosingRequestBase;
    }

    public static String getUrlWithQueryString(String str, AjaxParams ajaxParams) {
        if (ajaxParams == null) {
            return str;
        }
        return new StringBuilder(String.valueOf(str)).append("?").append(ajaxParams.getParamString()).toString();
    }

    private HttpEntity paramsToEntity(AjaxParams ajaxParams) {
        return ajaxParams != null ? ajaxParams.getEntity() : null;
    }

    public void addHeader(String str, String str2) {
        this.clientHeaderMap.put(str, str2);
    }

    public void configCharset(String str) {
        if (str != null && str.trim().length() != 0) {
            this.charset = str;
        }
    }

    public void configCookieStore(CookieStore cookieStore) {
        this.httpContext.setAttribute("http.cookie-store", cookieStore);
    }

    public void configRequestExecutionRetryCount(int i) {
        this.httpClient.setHttpRequestRetryHandler(new RetryHandler(i));
    }

    public void configSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", sSLSocketFactory, 443));
    }

    public void configTimeout(int i) {
        HttpParams params = this.httpClient.getParams();
        ConnManagerParams.setTimeout(params, (long) i);
        HttpConnectionParams.setSoTimeout(params, i);
        HttpConnectionParams.setConnectionTimeout(params, i);
    }

    public void configUserAgent(String str) {
        HttpProtocolParams.setUserAgent(this.httpClient.getParams(), str);
    }

    public void delete(String str, AjaxCallBack<? extends Object> ajaxCallBack) {
        sendRequest(this.httpClient, this.httpContext, new HttpDelete(str), null, ajaxCallBack);
    }

    public void delete(String str, Header[] headerArr, AjaxCallBack<? extends Object> ajaxCallBack) {
        HttpUriRequest httpDelete = new HttpDelete(str);
        if (headerArr != null) {
            httpDelete.setHeaders(headerArr);
        }
        sendRequest(this.httpClient, this.httpContext, httpDelete, null, ajaxCallBack);
    }

    public Object deleteSync(String str) {
        return deleteSync(str, null);
    }

    public Object deleteSync(String str, Header[] headerArr) {
        HttpUriRequest httpDelete = new HttpDelete(str);
        if (headerArr != null) {
            httpDelete.setHeaders(headerArr);
        }
        return sendSyncRequest(this.httpClient, this.httpContext, httpDelete, null);
    }

    public HttpHandler<File> download(String str, String str2, AjaxCallBack<File> ajaxCallBack) {
        return download(str, null, str2, false, ajaxCallBack);
    }

    public HttpHandler<File> download(String str, String str2, boolean z, AjaxCallBack<File> ajaxCallBack) {
        return download(str, null, str2, z, ajaxCallBack);
    }

    public HttpHandler<File> download(String str, AjaxParams ajaxParams, String str2, AjaxCallBack<File> ajaxCallBack) {
        return download(str, ajaxParams, str2, false, ajaxCallBack);
    }

    public HttpHandler<File> download(String str, AjaxParams ajaxParams, String str2, boolean z, AjaxCallBack<File> ajaxCallBack) {
        HttpGet httpGet = new HttpGet(getUrlWithQueryString(str, ajaxParams));
        HttpHandler<File> httpHandler = new HttpHandler(this.httpClient, this.httpContext, ajaxCallBack, this.charset);
        httpHandler.executeOnExecutor(executor, httpGet, str2, Boolean.valueOf(z));
        return httpHandler;
    }

    public void get(String str, AjaxCallBack<? extends Object> ajaxCallBack) {
        get(str, null, ajaxCallBack);
    }

    public void get(String str, AjaxParams ajaxParams, AjaxCallBack<? extends Object> ajaxCallBack) {
        sendRequest(this.httpClient, this.httpContext, new HttpGet(getUrlWithQueryString(str, ajaxParams)), null, ajaxCallBack);
    }

    public void get(String str, Header[] headerArr, AjaxParams ajaxParams, AjaxCallBack<? extends Object> ajaxCallBack) {
        HttpUriRequest httpGet = new HttpGet(getUrlWithQueryString(str, ajaxParams));
        if (headerArr != null) {
            httpGet.setHeaders(headerArr);
        }
        sendRequest(this.httpClient, this.httpContext, httpGet, null, ajaxCallBack);
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    public HttpContext getHttpContext() {
        return this.httpContext;
    }

    public Object getSync(String str) {
        return getSync(str, null);
    }

    public Object getSync(String str, AjaxParams ajaxParams) {
        return sendSyncRequest(this.httpClient, this.httpContext, new HttpGet(getUrlWithQueryString(str, ajaxParams)), null);
    }

    public Object getSync(String str, Header[] headerArr, AjaxParams ajaxParams) {
        HttpUriRequest httpGet = new HttpGet(getUrlWithQueryString(str, ajaxParams));
        if (headerArr != null) {
            httpGet.setHeaders(headerArr);
        }
        return sendSyncRequest(this.httpClient, this.httpContext, httpGet, null);
    }

    public void post(String str, AjaxCallBack<? extends Object> ajaxCallBack) {
        post(str, null, ajaxCallBack);
    }

    public void post(String str, AjaxParams ajaxParams, AjaxCallBack<? extends Object> ajaxCallBack) {
        post(str, paramsToEntity(ajaxParams), null, ajaxCallBack);
    }

    public void post(String str, HttpEntity httpEntity, String str2, AjaxCallBack<? extends Object> ajaxCallBack) {
        sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpPost(str), httpEntity), str2, ajaxCallBack);
    }

    public <T> void post(String str, Header[] headerArr, AjaxParams ajaxParams, String str2, AjaxCallBack<T> ajaxCallBack) {
        HttpUriRequest httpPost = new HttpPost(str);
        if (ajaxParams != null) {
            httpPost.setEntity(paramsToEntity(ajaxParams));
        }
        if (headerArr != null) {
            httpPost.setHeaders(headerArr);
        }
        sendRequest(this.httpClient, this.httpContext, httpPost, str2, ajaxCallBack);
    }

    public void post(String str, Header[] headerArr, HttpEntity httpEntity, String str2, AjaxCallBack<? extends Object> ajaxCallBack) {
        HttpUriRequest addEntityToRequestBase = addEntityToRequestBase(new HttpPost(str), httpEntity);
        if (headerArr != null) {
            addEntityToRequestBase.setHeaders(headerArr);
        }
        sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase, str2, ajaxCallBack);
    }

    public Object postSync(String str) {
        return postSync(str, null);
    }

    public Object postSync(String str, AjaxParams ajaxParams) {
        return postSync(str, paramsToEntity(ajaxParams), null);
    }

    public Object postSync(String str, HttpEntity httpEntity, String str2) {
        return sendSyncRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpPost(str), httpEntity), str2);
    }

    public Object postSync(String str, Header[] headerArr, AjaxParams ajaxParams, String str2) {
        HttpUriRequest httpPost = new HttpPost(str);
        if (ajaxParams != null) {
            httpPost.setEntity(paramsToEntity(ajaxParams));
        }
        if (headerArr != null) {
            httpPost.setHeaders(headerArr);
        }
        return sendSyncRequest(this.httpClient, this.httpContext, httpPost, str2);
    }

    public Object postSync(String str, Header[] headerArr, HttpEntity httpEntity, String str2) {
        HttpUriRequest addEntityToRequestBase = addEntityToRequestBase(new HttpPost(str), httpEntity);
        if (headerArr != null) {
            addEntityToRequestBase.setHeaders(headerArr);
        }
        return sendSyncRequest(this.httpClient, this.httpContext, addEntityToRequestBase, str2);
    }

    public void put(String str, AjaxCallBack<? extends Object> ajaxCallBack) {
        put(str, null, ajaxCallBack);
    }

    public void put(String str, AjaxParams ajaxParams, AjaxCallBack<? extends Object> ajaxCallBack) {
        put(str, paramsToEntity(ajaxParams), null, ajaxCallBack);
    }

    public void put(String str, HttpEntity httpEntity, String str2, AjaxCallBack<? extends Object> ajaxCallBack) {
        sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpPut(str), httpEntity), str2, ajaxCallBack);
    }

    public void put(String str, Header[] headerArr, HttpEntity httpEntity, String str2, AjaxCallBack<? extends Object> ajaxCallBack) {
        HttpUriRequest addEntityToRequestBase = addEntityToRequestBase(new HttpPut(str), httpEntity);
        if (headerArr != null) {
            addEntityToRequestBase.setHeaders(headerArr);
        }
        sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase, str2, ajaxCallBack);
    }

    public Object putSync(String str) {
        return putSync(str, null);
    }

    public Object putSync(String str, AjaxParams ajaxParams) {
        return putSync(str, paramsToEntity(ajaxParams), null);
    }

    public Object putSync(String str, HttpEntity httpEntity, String str2) {
        return putSync(str, null, httpEntity, str2);
    }

    public Object putSync(String str, Header[] headerArr, HttpEntity httpEntity, String str2) {
        HttpUriRequest addEntityToRequestBase = addEntityToRequestBase(new HttpPut(str), httpEntity);
        if (headerArr != null) {
            addEntityToRequestBase.setHeaders(headerArr);
        }
        return sendSyncRequest(this.httpClient, this.httpContext, addEntityToRequestBase, str2);
    }

    protected <T> void sendRequest(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, AjaxCallBack<T> ajaxCallBack) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        new HttpHandler(defaultHttpClient, httpContext, ajaxCallBack, this.charset).executeOnExecutor(executor, httpUriRequest);
    }

    protected Object sendSyncRequest(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        return new SyncRequestHandler(defaultHttpClient, httpContext, this.charset).sendRequest(httpUriRequest);
    }
}
