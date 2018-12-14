package com.shuame.rootgenius.appmanager.p096ui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shuame.rootgenius.appmanager.p094d.C1267b;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.event.C1340e;

/* renamed from: com.shuame.rootgenius.appmanager.ui.activity.d */
final class C1290d extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ AppUninstallActivity f3514a;

    C1290d(AppUninstallActivity appUninstallActivity) {
        this.f3514a = appUninstallActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (C1340e.f3630a.equals(action)) {
            if (C1323b.m3698d()) {
                this.f3514a.f3497z.setVisibility(8);
            } else {
                this.f3514a.f3497z.setVisibility(0);
            }
        } else if (C1267b.f3394a.equals(action)) {
            this.f3514a.f3468C.sendEmptyMessage(0);
        }
    }
}
