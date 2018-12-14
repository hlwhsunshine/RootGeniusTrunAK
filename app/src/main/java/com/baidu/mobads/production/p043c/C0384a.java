package com.baidu.mobads.production.p043c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;

/* renamed from: com.baidu.mobads.production.c.a */
public class C0384a {
    /* renamed from: a */
    public static int m773a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return 0;
        }
        activeNetworkInfo = connectivityManager.getNetworkInfo(1);
        if (activeNetworkInfo != null && C0384a.m774a(activeNetworkInfo.getState())) {
            return 100;
        }
        if (VERSION.SDK_INT >= 13) {
            activeNetworkInfo = connectivityManager.getNetworkInfo(9);
            if (activeNetworkInfo != null && C0384a.m774a(activeNetworkInfo.getState())) {
                return 101;
            }
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        if (networkInfo == null || !C0384a.m774a(networkInfo.getState())) {
            return 999;
        }
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 1;
        }
    }

    /* renamed from: a */
    private static boolean m774a(State state) {
        return state != null && (state == State.CONNECTED || state == State.CONNECTING);
    }
}
