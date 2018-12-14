package com.shuame.rootgenius.appmanager.p096ui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shuame.rootgenius.appmanager.p091b.C1259d;

/* renamed from: com.shuame.rootgenius.appmanager.ui.activity.c */
final class C1289c extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ AppUninstallActivity f3513a;

    C1289c(AppUninstallActivity appUninstallActivity) {
        this.f3513a = appUninstallActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.PACKAGE_REMOVED".equals(intent.getAction())) {
            this.f3513a.f3479h = C1259d.m3554a(this.f3513a.f3478g);
            this.f3513a.f3479h.mo6909e().remove(this.f3513a.f3477f.f3409e);
            if (this.f3513a.f3473b.isEmpty()) {
                this.f3513a.f3488q.setVisibility(8);
                this.f3513a.f3471F.setVisibility(0);
            }
            this.f3513a.f3494w.notifyDataSetChanged();
            this.f3513a.unregisterReceiver(this.f3513a.f3469D);
        }
    }
}
