package com.kingroot.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

/* renamed from: com.kingroot.sdk.ad */
public abstract class C0606ad extends BroadcastReceiver {
    /* renamed from: j */
    public abstract void mo5586j();

    public void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        Object obj = null;
        String action = intent.getAction();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                if (action.equals("android.net.wifi.STATE_CHANGE") && activeNetworkInfo.getState() == State.CONNECTED) {
                    obj = 1;
                }
            } else if (action.equals("android.net.conn.CONNECTIVITY_CHANGE") && activeNetworkInfo.getState() == State.CONNECTED) {
                int obj2 = 1;
            }
        }
        if (obj2 != null) {
            mo5586j();
        }
    }
}
