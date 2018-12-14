package com.p070qq.p071e.comm.net;

import com.p070qq.p071e.comm.net.p072rr.Request;
import com.p070qq.p071e.comm.net.p072rr.Response;

/* renamed from: com.qq.e.comm.net.NetworkCallBack */
public interface NetworkCallBack {
    void onException(Exception exception);

    void onResponse(Request request, Response response);
}
