package com.kingroot.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.Handler;
import android.os.Looper;

/* renamed from: com.kingroot.sdk.dx */
public class C0764dx extends BroadcastReceiver {
    private Handler handler;

    public C0764dx(Looper looper) {
        this.handler = new Handler(looper);
    }

    public void onReceive(Context context, Intent intent) {
        try {
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                return;
            }
            if (C0741dg.m1804aL().f1804ei) {
                Object obj;
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (State.CONNECTED == connectivityManager.getNetworkInfo(1).getState()) {
                    obj = 1;
                } else {
                    if (State.CONNECTED == connectivityManager.getNetworkInfo(0).getState()) {
                        int obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                }
                if (obj2 != null) {
                    C0769dy.m1931g(context, this.handler);
                    return;
                }
                return;
            }
            C0633at.m1465i("NetworkBroadcastReceiver Not inited.");
        } catch (Throwable e) {
            C0633at.m1458a("获取网络状态出错", e);
        }
    }
}
