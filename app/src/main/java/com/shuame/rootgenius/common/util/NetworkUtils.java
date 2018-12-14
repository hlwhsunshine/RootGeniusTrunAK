package com.shuame.rootgenius.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.shuame.rootgenius.common.C1325c;

public final class NetworkUtils {
    /* renamed from: a */
    private static final String f3852a = NetworkUtils.class.getSimpleName();

    public enum NetworkType {
        NONE(0),
        WIFI(1),
        MOBILE(2);
        
        private int value;

        private NetworkType(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* renamed from: a */
    public static boolean m3850a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) C1325c.m3724a().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m3851a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    /* renamed from: b */
    public static boolean m3852b() {
        return m3851a(C1325c.m3724a());
    }

    /* renamed from: c */
    public static NetworkType m3853c() {
        NetworkType networkType = NetworkType.NONE;
        ConnectivityManager connectivityManager = (ConnectivityManager) C1325c.m3724a().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return NetworkType.WIFI;
                }
                if (type == 0) {
                    return NetworkType.MOBILE;
                }
            }
        }
        return networkType;
    }

    /* renamed from: d */
    public static boolean m3854d() {
        return m3853c() == NetworkType.WIFI;
    }
}
