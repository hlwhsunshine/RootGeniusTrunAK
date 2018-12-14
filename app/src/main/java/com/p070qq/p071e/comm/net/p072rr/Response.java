package com.p070qq.p071e.comm.net.p072rr;

import java.io.InputStream;

/* renamed from: com.qq.e.comm.net.rr.Response */
public interface Response {
    void close();

    byte[] getBytesContent();

    int getStatusCode();

    InputStream getStreamContent();

    String getStringContent();

    String getStringContent(String str);
}
