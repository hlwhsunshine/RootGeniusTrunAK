package com.shuame.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;

public class NetworkUtils {
    /* renamed from: a */
    private static final String f4571a = NetworkUtils.class.getSimpleName();

    public enum NetworkType {
        NONE,
        WIFI,
        MOBILE2G,
        MOBILE3G,
        MOBILE4G
    }

    /* renamed from: a */
    public static boolean m4385a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getDetailedState() == DetailedState.CONNECTED) {
                    return true;
                }
                new StringBuilder("network is available. but connect state is :").append(activeNetworkInfo.getDetailedState());
            }
        }
        return false;
    }
}
