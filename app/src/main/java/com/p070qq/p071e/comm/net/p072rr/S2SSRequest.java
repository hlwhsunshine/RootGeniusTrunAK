package com.p070qq.p071e.comm.net.p072rr;

import com.p070qq.p071e.comm.net.p072rr.Request.Method;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

/* renamed from: com.qq.e.comm.net.rr.S2SSRequest */
public class S2SSRequest extends AbstractRequest {
    public S2SSRequest(String str, byte[] bArr) {
        super(str, Method.POST, bArr);
    }

    public byte[] getPostData() {
        return C1075a.m3117a(super.getPostData());
    }

    public Response initResponse(HttpUriRequest httpUriRequest, HttpResponse httpResponse) {
        return new S2SSResponse(httpResponse, httpUriRequest);
    }
}
