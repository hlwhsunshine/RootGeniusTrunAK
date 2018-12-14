package net.tsz.afinal.http;

import java.io.IOException;
import java.net.UnknownHostException;
import net.tsz.afinal.http.entityhandler.StringEntityHandler;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class SyncRequestHandler {
    private String charset;
    private final AbstractHttpClient client;
    private final HttpContext context;
    private final StringEntityHandler entityHandler = new StringEntityHandler();
    private int executionCount = 0;

    public SyncRequestHandler(AbstractHttpClient abstractHttpClient, HttpContext httpContext, String str) {
        this.client = abstractHttpClient;
        this.context = httpContext;
        this.charset = str;
    }

    private Object makeRequestWithRetries(HttpUriRequest httpUriRequest) {
        int i;
        IOException iOException;
        int i2;
        IOException iOException2;
        IOException e = null;
        boolean z = true;
        HttpRequestRetryHandler httpRequestRetryHandler = this.client.getHttpRequestRetryHandler();
        while (z) {
            try {
                return this.entityHandler.handleEntity(this.client.execute(httpUriRequest, this.context).getEntity(), null, this.charset);
            } catch (UnknownHostException e2) {
                e = e2;
                i = this.executionCount + 1;
                this.executionCount = i;
                z = httpRequestRetryHandler.retryRequest(e, i, this.context);
            } catch (IOException e3) {
                e = e3;
                i = this.executionCount + 1;
                this.executionCount = i;
                z = httpRequestRetryHandler.retryRequest(e, i, this.context);
            } catch (NullPointerException e4) {
                iOException = new IOException("NPE in HttpClient" + e4.getMessage());
                i2 = this.executionCount + 1;
                this.executionCount = i2;
                iOException2 = iOException;
                z = httpRequestRetryHandler.retryRequest(iOException, i2, this.context);
                e = iOException2;
            } catch (Exception e5) {
                iOException = new IOException("Exception" + e5.getMessage());
                i2 = this.executionCount + 1;
                this.executionCount = i2;
                iOException2 = iOException;
                z = httpRequestRetryHandler.retryRequest(iOException, i2, this.context);
                e = iOException2;
            }
        }
        if (e != null) {
            throw e;
        }
        throw new IOException("未知网络错误");
    }

    public Object sendRequest(HttpUriRequest... httpUriRequestArr) {
        try {
            return makeRequestWithRetries(httpUriRequestArr[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
