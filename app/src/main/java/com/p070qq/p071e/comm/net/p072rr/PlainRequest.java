package com.p070qq.p071e.comm.net.p072rr;

import com.p070qq.p071e.comm.net.p072rr.Request.Method;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

/* renamed from: com.qq.e.comm.net.rr.PlainRequest */
public class PlainRequest extends AbstractRequest {
    public PlainRequest(String str, Method method, byte[] bArr) {
        super(str, method, bArr);
    }

    public Response initResponse(HttpUriRequest httpUriRequest, HttpResponse httpResponse) {
        return new PlainResponse(httpResponse, httpUriRequest);
    }
}
