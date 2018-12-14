package com.shuame.rootgenius.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.shuame.rootgenius.sdk.e */
final class C1470e extends BroadcastReceiver {
    C1470e() {
    }

    public final void onReceive(Context context, Intent intent) {
        C1473h.m4104c(C1469d.f4038a, "receiver,got action:" + intent.getAction());
        if (intent == null) {
            return;
        }
        if ("android.intent.action.PACKAGE_ADDED".equalsIgnoreCase(intent.getAction()) || "android.intent.action.PACKAGE_REPLACED".equalsIgnoreCase(intent.getAction())) {
            String replace = intent.getData().toString().replace("package:", "");
            C1469d.f4043u.put(replace, Boolean.valueOf(true));
            C1473h.m4104c(C1469d.f4038a, "receiver,package name is:" + replace);
        }
    }
}
