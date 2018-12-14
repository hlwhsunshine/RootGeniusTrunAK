package com.shuame.rootgenius;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shuame.rootgenius.common.util.NetworkUtils;
import com.shuame.rootgenius.model.ExecuteTaskStatus;

/* renamed from: com.shuame.rootgenius.d */
final class C1421d extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ RootGeniusApp f3917a;

    C1421d(RootGeniusApp rootGeniusApp) {
        this.f3917a = rootGeniusApp;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            RootGeniusApp.f3304d = intent.getIntExtra("level", 0);
        }
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            return;
        }
        if (NetworkUtils.m3851a(RootGeniusApp.f3306f)) {
            ExecuteTaskStatus.m4027a().mo7217a(true);
        } else {
            ExecuteTaskStatus.m4027a().mo7217a(false);
        }
    }
}
