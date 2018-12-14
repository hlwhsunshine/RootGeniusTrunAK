package com.shuame.mobile.sdk.impl.utils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* renamed from: com.shuame.mobile.sdk.impl.utils.d */
class C1225d implements HostnameVerifier {
    C1225d() {
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
