package com.p070qq.p071e.comm.net.p072rr;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.util.EntityUtils;

/* renamed from: com.qq.e.comm.net.rr.AbstractResponse */
public abstract class AbstractResponse implements Response {
    /* renamed from: a */
    private final HttpResponse f2848a;
    /* renamed from: b */
    private final HttpUriRequest f2849b;

    public AbstractResponse(HttpResponse httpResponse, HttpUriRequest httpUriRequest) {
        this.f2848a = httpResponse;
        this.f2849b = httpUriRequest;
    }

    public void close() {
        if (!(this.f2849b == null || this.f2849b.isAborted())) {
            this.f2849b.abort();
        }
        if (this.f2848a != null) {
            this.f2848a.getEntity().getContent().close();
        }
    }

    public byte[] getBytesContent() {
        if (200 != getStatusCode()) {
            return null;
        }
        InputStream streamContent = getStreamContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = streamContent.read(bArr);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public int getStatusCode() {
        return this.f2848a.getStatusLine().getStatusCode();
    }

    public InputStream getStreamContent() {
        InputStream content = this.f2848a.getEntity().getContent();
        Header contentEncoding = this.f2848a.getEntity().getContentEncoding();
        return (contentEncoding == null || !contentEncoding.getValue().contains("gzip")) ? content : new GZIPInputStream(content);
    }

    public String getStringContent() {
        return getStringContent("UTF-8");
    }

    public String getStringContent(String str) {
        String str2 = null;
        byte[] bytesContent = getBytesContent();
        if (bytesContent == null) {
            return str2;
        }
        if (bytesContent.length == 0) {
            return "";
        }
        try {
            str2 = EntityUtils.getContentCharSet(this.f2848a.getEntity());
        } catch (Throwable th) {
        }
        if (str2 != null) {
            str = str2;
        }
        return new String(bytesContent, str);
    }
}
