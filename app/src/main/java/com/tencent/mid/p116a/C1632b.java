package com.tencent.mid.p116a;

import com.tencent.mid.api.MidService;
import com.tencent.mid.util.C1656g;
import com.tencent.mid.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
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
import org.apache.http.util.EntityUtils;

/* renamed from: com.tencent.mid.a.b */
public class C1632b {
    /* renamed from: a */
    private static DefaultHttpClient f4657a = null;
    /* renamed from: b */
    private static int f4658b = 50000;

    /* renamed from: a */
    public static C1636f m4461a(String str) {
        f4657a = C1632b.m4465a();
        Util.logInfo("http get:" + str);
        HttpUriRequest httpGet = new HttpGet(str);
        HttpHost httpProxy = Util.getHttpProxy(C1634d.m4467a());
        Util.logInfo("proxy==" + (httpProxy == null ? "null" : httpProxy.getHostName()));
        if (httpProxy != null) {
            httpGet.addHeader("X-Online-Host", "pingmid.qq.com");
            httpGet.addHeader("Accept", "*/*");
            httpGet.removeHeaders("X-Content-Encoding");
        } else {
            f4657a.getParams().removeParameter("http.route.default-proxy");
        }
        httpGet.addHeader("Accept-Encoding", "gzip");
        HttpResponse execute = f4657a.execute(httpGet);
        int statusCode = execute.getStatusLine().getStatusCode();
        String a = C1632b.m4464a(execute);
        Util.logInfo("http get response code:" + statusCode + " ,data:" + a);
        return new C1636f(statusCode, a);
    }

    /* renamed from: a */
    public static C1636f m4462a(String str, String str2) {
        f4657a = C1632b.m4465a();
        Util.logInfo("[" + str + "]Send request(" + str2.length() + "bytes):" + str2);
        HttpPost httpPost = new HttpPost(str);
        httpPost.addHeader("Accept-Encoding", "gzip");
        httpPost.setHeader("Connection", "Keep-Alive");
        httpPost.removeHeaders("Cache-Control");
        HttpHost httpProxy = Util.getHttpProxy(C1634d.m4467a());
        Util.logInfo("proxy==" + (httpProxy == null ? "null" : httpProxy.getHostName()));
        if (httpProxy != null) {
            httpPost.addHeader("X-Online-Host", "pingmid.qq.com");
            httpPost.addHeader("Accept", "*/*");
            httpPost.addHeader("Content-Type", "json");
        } else {
            f4657a.getParams().removeParameter("http.route.default-proxy");
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = str2.getBytes("UTF-8");
        int length = bytes.length;
        if (str2.length() >= 256) {
            if (httpProxy == null) {
                httpPost.addHeader("Content-Encoding", "rc4,gzip");
            } else {
                httpPost.addHeader("X-Content-Encoding", "rc4,gzip");
            }
            byteArrayOutputStream.write(new byte[4]);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bytes);
            gZIPOutputStream.close();
            bytes = byteArrayOutputStream.toByteArray();
            ByteBuffer.wrap(bytes, 0, 4).putInt(length);
            Util.logInfo("before Gzip:" + length + " bytes, after Gzip:" + bytes.length + " bytes");
        } else if (httpProxy == null) {
            httpPost.addHeader("Content-Encoding", "rc4");
        } else {
            httpPost.addHeader("X-Content-Encoding", "rc4");
        }
        byteArrayOutputStream.close();
        httpPost.setEntity(new ByteArrayEntity(C1656g.m4551a(bytes)));
        HttpResponse execute = f4657a.execute(httpPost);
        HttpEntity entity = execute.getEntity();
        int statusCode = execute.getStatusLine().getStatusCode();
        long contentLength = entity.getContentLength();
        Util.logInfo("recv response status code:" + statusCode + ", content length:" + contentLength);
        String str3 = null;
        if (contentLength <= 0) {
            EntityUtils.toString(entity);
        } else {
            str3 = C1632b.m4464a(execute);
        }
        Util.logInfo("recv response status code:" + statusCode + ", content :" + str3);
        return new C1636f(statusCode, str3);
    }

    /* renamed from: a */
    public static String m4463a(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!(map == null || map.size() == 0)) {
            int i = 0;
            for (Entry entry : map.entrySet()) {
                int i2 = i + 1;
                stringBuilder.append(i == 0 ? "?" : "&");
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append("=");
                stringBuilder.append((String) entry.getValue());
                i = i2;
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static String m4464a(HttpResponse httpResponse) {
        InputStream content = httpResponse.getEntity().getContent();
        DataInputStream dataInputStream = new DataInputStream(content);
        byte[] bArr = new byte[((int) httpResponse.getEntity().getContentLength())];
        dataInputStream.readFully(bArr);
        content.close();
        dataInputStream.close();
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        if (firstHeader != null) {
            if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                bArr = C1656g.m4553b(Util.deocdeGZipContent(bArr));
            } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                bArr = Util.deocdeGZipContent(C1656g.m4553b(bArr));
            } else if (firstHeader.getValue().equalsIgnoreCase("gzip")) {
                bArr = Util.deocdeGZipContent(bArr);
            } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                bArr = C1656g.m4553b(bArr);
            }
        }
        return new String(bArr, "UTF-8");
    }

    /* renamed from: a */
    public static synchronized DefaultHttpClient m4465a() {
        DefaultHttpClient defaultHttpClient;
        synchronized (C1632b.class) {
            if (f4657a == null) {
                if (MidService.isEnableDebug()) {
                    try {
                        Logger.getLogger("org.apache.http.wire").setLevel(Level.FINER);
                        Logger.getLogger("org.apache.http.headers").setLevel(Level.FINER);
                        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
                        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
                        System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
                        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
                        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "debug");
                    } catch (Throwable th) {
                    }
                }
                HttpParams basicHttpParams = new BasicHttpParams();
                ConnManagerParams.setTimeout(basicHttpParams, (long) f4658b);
                ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(20));
                ConnManagerParams.setMaxTotalConnections(basicHttpParams, 100);
                HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
                HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
                HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
                HttpClientParams.setRedirecting(basicHttpParams, true);
                HttpConnectionParams.setSoTimeout(basicHttpParams, f4658b);
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, f4658b);
                HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
                SchemeRegistry schemeRegistry = new SchemeRegistry();
                schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                f4657a = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                f4657a.getParams().setParameter("http.route.default-proxy", Util.getHttpProxy(C1634d.m4467a()));
                try {
                    f4657a.setKeepAliveStrategy(new C1633c());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            f4657a.getParams().setParameter("http.route.default-proxy", Util.getHttpProxy(C1634d.m4467a()));
            defaultHttpClient = f4657a;
        }
        return defaultHttpClient;
    }

    /* renamed from: b */
    public static void m4466b() {
        try {
            if (f4657a != null) {
                f4657a.getConnectionManager().shutdown();
                f4657a = null;
                Util.logInfo("close http client.");
            }
        } catch (Throwable th) {
            Util.logWarn(th);
        }
    }
}
