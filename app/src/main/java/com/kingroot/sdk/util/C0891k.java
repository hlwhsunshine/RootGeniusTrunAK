package com.kingroot.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import com.kingroot.sdk.C0633at;
import com.kingroot.sdk.C0846gi;

/* renamed from: com.kingroot.sdk.util.k */
public class C0891k {
    /* renamed from: J */
    public static byte m2436J(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            C0633at.m1458a("NetworkUtil.getNetworkType() throw e", th);
            activeNetworkInfo = null;
        }
        return (activeNetworkInfo == null || !(activeNetworkInfo.getState() == State.CONNECTING || activeNetworkInfo.getState() == State.CONNECTED)) ? (byte) -1 : activeNetworkInfo.getType() == 1 ? (byte) 0 : activeNetworkInfo.getType() == 0 ? (Proxy.getDefaultHost() == null && Proxy.getHost(context) == null) ? (byte) 1 : (byte) 2 : (C0846gi.m2195I() < 13 || activeNetworkInfo.getType() != 9) ? (byte) -1 : (byte) 0;
    }

    /* renamed from: K */
    public static String m2437K(Context context) {
        String host = Proxy.getHost(context);
        return (host == null || host.length() == 0) ? Proxy.getDefaultHost() : "";
    }

    /* renamed from: L */
    public static int m2438L(Context context) {
        int port = Proxy.getPort(context);
        return port <= 0 ? Proxy.getDefaultPort() : port;
    }
}
