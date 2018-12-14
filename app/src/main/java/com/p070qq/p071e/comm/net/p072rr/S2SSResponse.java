package com.p070qq.p071e.comm.net.p072rr;

import com.p070qq.p071e.comm.net.p072rr.C1075a.C1074b;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

/* renamed from: com.qq.e.comm.net.rr.S2SSResponse */
public class S2SSResponse extends AbstractResponse {
    public S2SSResponse(HttpResponse httpResponse, HttpUriRequest httpUriRequest) {
        super(httpResponse, httpUriRequest);
    }

    public byte[] getBytesContent() {
        try {
            return C1075a.m3119b(super.getBytesContent());
        } catch (C1074b e) {
            e.printStackTrace();
            return null;
        }
    }
}
