package com.p070qq.p071e.comm.net;

import com.p070qq.p071e.comm.net.NetworkClient.Priority;
import com.p070qq.p071e.comm.net.p072rr.Request;
import com.p070qq.p071e.comm.net.p072rr.Response;
import com.p070qq.p071e.comm.util.GDTLogger;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

/* renamed from: com.qq.e.comm.net.NetworkClientImpl */
public class NetworkClientImpl implements NetworkClient {
    /* renamed from: a */
    private static final HttpClient f2832a;
    /* renamed from: b */
    private static final NetworkClient f2833b = new NetworkClientImpl();
    /* renamed from: c */
    private final ExecutorService f2834c = new ThreadPoolExecutor(5, 10, 180, TimeUnit.SECONDS, this.f2835d);
    /* renamed from: d */
    private PriorityBlockingQueue<Runnable> f2835d = new PriorityBlockingQueue(15);

    /* renamed from: com.qq.e.comm.net.NetworkClientImpl$NetFutureTask */
    class NetFutureTask<T> extends FutureTask<T> implements Comparable<NetFutureTask<T>> {
        /* renamed from: a */
        private final Priority f2829a;

        public NetFutureTask(NetworkClientImpl networkClientImpl, Callable<T> callable, Priority priority) {
            super(callable);
            this.f2829a = priority;
        }

        public int compareTo(NetFutureTask<T> netFutureTask) {
            return netFutureTask == null ? 1 : this.f2829a.value() - netFutureTask.f2829a.value();
        }
    }

    /* renamed from: com.qq.e.comm.net.NetworkClientImpl$TaskCallable */
    static class TaskCallable implements Callable<Response> {
        /* renamed from: a */
        private Request f2830a;
        /* renamed from: b */
        private NetworkCallBack f2831b;

        public TaskCallable(Request request) {
            this(request, null);
        }

        public TaskCallable(Request request, NetworkCallBack networkCallBack) {
            this.f2830a = request;
            this.f2831b = networkCallBack;
        }

        /* renamed from: a */
        private void m3114a(HttpRequestBase httpRequestBase) {
            for (Entry entry : this.f2830a.getHeaders().entrySet()) {
                httpRequestBase.setHeader((String) entry.getKey(), (String) entry.getValue());
            }
            httpRequestBase.setHeader("User-Agent", "GDTADNetClient-[" + System.getProperty("http.agent") + "]");
            httpRequestBase.addHeader("Accept-Encoding", "gzip");
            HttpParams params = httpRequestBase.getParams();
            if (params == null) {
                params = new BasicHttpParams();
            }
            if (this.f2830a.getConnectionTimeOut() > 0) {
                HttpConnectionParams.setConnectionTimeout(params, this.f2830a.getConnectionTimeOut());
            }
            if (this.f2830a.getSocketTimeOut() > 0) {
                HttpConnectionParams.setSoTimeout(params, this.f2830a.getSocketTimeOut());
            }
            httpRequestBase.setParams(params);
        }

        public Response call() {
            Throwable e;
            Response response = null;
            try {
                HttpUriRequest httpPost;
                HttpClient a = NetworkClientImpl.f2832a;
                switch (this.f2830a.getMethod()) {
                    case POST:
                        httpPost = new HttpPost(this.f2830a.getUrlWithParas());
                        m3114a(httpPost);
                        byte[] postData = this.f2830a.getPostData();
                        if (postData != null && postData.length > 0) {
                            httpPost.setEntity(new ByteArrayEntity(postData));
                            break;
                        }
                    case GET:
                        httpPost = new HttpGet(this.f2830a.getUrlWithParas());
                        m3114a(httpPost);
                        break;
                    default:
                        httpPost = null;
                        break;
                }
                response = this.f2830a.initResponse(httpPost, a.execute(httpPost));
                e = null;
            } catch (Exception e2) {
                e = e2;
            }
            if (e == null) {
                if (this.f2831b != null) {
                    this.f2831b.onResponse(this.f2830a, response);
                }
                if (this.f2830a.isAutoClose()) {
                    response.close();
                }
            } else if (this.f2831b != null) {
                GDTLogger.m3135w("NetworkClientException", e);
                this.f2831b.onException(e);
                if (response != null) {
                    response.close();
                }
            } else {
                throw e;
            }
            return response;
        }
    }

    static {
        HttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, 30000);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(3));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(basicHttpParams, "GDTADNetClient-[" + System.getProperty("http.agent") + "]");
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        f2832a = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    private NetworkClientImpl() {
    }

    public static NetworkClient getInstance() {
        return f2833b;
    }

    public Future<Response> submit(Request request) {
        return submit(request, Priority.Mid);
    }

    public Future<Response> submit(Request request, Priority priority) {
        Object netFutureTask = new NetFutureTask(this, new TaskCallable(request), priority);
        this.f2834c.execute(netFutureTask);
        GDTLogger.m3130d("QueueSize:" + this.f2835d.size());
        return netFutureTask;
    }

    public void submit(Request request, NetworkCallBack networkCallBack) {
        submit(request, Priority.Mid, networkCallBack);
    }

    public void submit(Request request, Priority priority, NetworkCallBack networkCallBack) {
        this.f2834c.execute(new NetFutureTask(this, new TaskCallable(request, networkCallBack), priority));
        GDTLogger.m3130d("QueueSize:" + this.f2835d.size());
    }
}
