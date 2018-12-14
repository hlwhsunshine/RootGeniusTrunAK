package com.shuame.rootgenius.p115ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import com.shuame.rootgenius.common.event.C1340e;

/* renamed from: com.shuame.rootgenius.ui.w */
final class C1613w extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ FontReplaceActivity f4564a;

    C1613w(FontReplaceActivity fontReplaceActivity) {
        this.f4564a = fontReplaceActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null) {
                FontReplaceActivity.f4182f;
                if (!this.f4564a.f4196o) {
                    this.f4564a.m4242c();
                    this.f4564a.f4192k.setVisibility(8);
                    this.f4564a.f4197p.setVisibility(0);
                }
            }
        } else if (action.equals(C1340e.f3640k)) {
            this.f4564a.finish();
        }
    }
}
