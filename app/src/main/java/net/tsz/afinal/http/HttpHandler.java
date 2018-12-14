package net.tsz.afinal.http;

import android.os.SystemClock;
import com.p070qq.p071e.comm.constants.ErrorCode.InitError;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import net.tsz.afinal.core.AsyncTask;
import net.tsz.afinal.http.entityhandler.EntityCallBack;
import net.tsz.afinal.http.entityhandler.FileEntityHandler;
import net.tsz.afinal.http.entityhandler.StringEntityHandler;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class HttpHandler<T> extends AsyncTask<Object, Object, Object> implements EntityCallBack {
    private static final int UPDATE_FAILURE = 3;
    private static final int UPDATE_LOADING = 2;
    private static final int UPDATE_START = 1;
    private static final int UPDATE_SUCCESS = 4;
    private final AjaxCallBack<T> callback;
    private String charset;
    private final AbstractHttpClient client;
    private final HttpContext context;
    private int executionCount = 0;
    private boolean isResume = false;
    private final FileEntityHandler mFileEntityHandler = new FileEntityHandler();
    private final StringEntityHandler mStrEntityHandler = new StringEntityHandler();
    private String targetUrl = null;
    private long time;

    public HttpHandler(AbstractHttpClient abstractHttpClient, HttpContext httpContext, AjaxCallBack<T> ajaxCallBack, String str) {
        this.client = abstractHttpClient;
        this.context = httpContext;
        this.callback = ajaxCallBack;
        this.charset = str;
    }

    private void handleResponse(HttpResponse httpResponse) {
        StatusLine statusLine = httpResponse.getStatusLine();
        if (statusLine.getStatusCode() >= InitError.INIT_AD_ERROR) {
            String str = "response status error code:" + statusLine.getStatusCode();
            if (statusLine.getStatusCode() == 416 && this.isResume) {
                str = new StringBuilder(String.valueOf(str)).append(" \n maybe you have download complete.").toString();
            }
            publishProgress(Integer.valueOf(3), new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()), Integer.valueOf(statusLine.getStatusCode()), str);
            return;
        }
        try {
            HttpEntity entity = httpResponse.getEntity();
            Object obj = null;
            if (entity != null) {
                this.time = SystemClock.uptimeMillis();
                obj = this.targetUrl != null ? this.mFileEntityHandler.handleEntity(entity, this, this.targetUrl, this.isResume) : this.mStrEntityHandler.handleEntity(entity, this, this.charset);
            }
            publishProgress(Integer.valueOf(4), obj);
        } catch (IOException e) {
            publishProgress(Integer.valueOf(3), e, Integer.valueOf(0), e.getMessage());
        }
    }

    private void makeRequestWithRetries(HttpUriRequest httpUriRequest) {
        IOException iOException;
        int i;
        IOException iOException2;
        if (this.isResume && this.targetUrl != null) {
            File file = new File(this.targetUrl);
            long length = (file.isFile() && file.exists()) ? file.length() : 0;
            if (length > 0) {
                httpUriRequest.setHeader("RANGE", "bytes=" + length + "-");
            }
        }
        IOException e = null;
        HttpRequestRetryHandler httpRequestRetryHandler = this.client.getHttpRequestRetryHandler();
        boolean z = true;
        while (z) {
            try {
                if (!isCancelled()) {
                    HttpResponse execute = this.client.execute(httpUriRequest, this.context);
                    if (!isCancelled()) {
                        handleResponse(execute);
                        return;
                    }
                    return;
                }
                return;
            } catch (UnknownHostException e2) {
                publishProgress(Integer.valueOf(3), e2, Integer.valueOf(0), "unknownHostException：can't resolve host");
                return;
            } catch (IOException e3) {
                e = e3;
                int i2 = this.executionCount + 1;
                this.executionCount = i2;
                z = httpRequestRetryHandler.retryRequest(e, i2, this.context);
            } catch (NullPointerException e4) {
                iOException = new IOException("NPE in HttpClient" + e4.getMessage());
                i = this.executionCount + 1;
                this.executionCount = i;
                iOException2 = iOException;
                z = httpRequestRetryHandler.retryRequest(iOException, i, this.context);
                e = iOException2;
            } catch (Exception e5) {
                iOException = new IOException("Exception" + e5.getMessage());
                i = this.executionCount + 1;
                this.executionCount = i;
                iOException2 = iOException;
                z = httpRequestRetryHandler.retryRequest(iOException, i, this.context);
                e = iOException2;
            }
        }
        if (e != null) {
            throw e;
        }
        throw new IOException("未知网络错误");
    }

    public void callBack(long j, long j2, boolean z) {
        if (this.callback != null && this.callback.isProgress()) {
            if (z) {
                publishProgress(Integer.valueOf(2), Long.valueOf(j), Long.valueOf(j2));
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.time >= ((long) this.callback.getRate())) {
                this.time = uptimeMillis;
                publishProgress(Integer.valueOf(2), Long.valueOf(j), Long.valueOf(j2));
            }
        }
    }

    protected Object doInBackground(Object... objArr) {
        if (objArr != null && objArr.length == 3) {
            this.targetUrl = String.valueOf(objArr[1]);
            this.isResume = ((Boolean) objArr[2]).booleanValue();
        }
        try {
            publishProgress(Integer.valueOf(1));
            makeRequestWithRetries((HttpUriRequest) objArr[0]);
        } catch (IOException e) {
            publishProgress(Integer.valueOf(3), e, Integer.valueOf(0), e.getMessage());
        }
        return null;
    }

    public boolean isStop() {
        return this.mFileEntityHandler.isStop();
    }

    protected void onProgressUpdate(Object... objArr) {
        switch (Integer.valueOf(String.valueOf(objArr[0])).intValue()) {
            case 1:
                if (this.callback != null) {
                    this.callback.onStart();
                    break;
                }
                break;
            case 2:
                if (this.callback != null) {
                    this.callback.onLoading(Long.valueOf(String.valueOf(objArr[1])).longValue(), Long.valueOf(String.valueOf(objArr[2])).longValue());
                    break;
                }
                break;
            case 3:
                if (this.callback != null) {
                    this.callback.onFailure((Throwable) objArr[1], ((Integer) objArr[2]).intValue(), (String) objArr[3]);
                    break;
                }
                break;
            case 4:
                if (this.callback != null) {
                    this.callback.onSuccess(objArr[1]);
                    break;
                }
                break;
        }
        super.onProgressUpdate(objArr);
    }

    public void stop() {
        this.mFileEntityHandler.setStop(true);
    }
}
