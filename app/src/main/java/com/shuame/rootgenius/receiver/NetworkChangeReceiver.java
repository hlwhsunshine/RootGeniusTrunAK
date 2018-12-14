package com.shuame.rootgenius.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NetworkChangeReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static final String f4024a = NetworkChangeReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        new StringBuilder("onReceive ").append(intent.getAction());
        context.sendBroadcast(new Intent("com.shuame.ACTION_CHECK_AUTH_COMPONENT_UPDATE"));
    }
}
