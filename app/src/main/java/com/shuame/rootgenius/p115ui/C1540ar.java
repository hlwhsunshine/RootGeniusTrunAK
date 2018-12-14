package com.shuame.rootgenius.p115ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.service.C1492j;

/* renamed from: com.shuame.rootgenius.ui.ar */
final class C1540ar extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ UpdateActivity f4358a;

    C1540ar(UpdateActivity updateActivity) {
        this.f4358a = updateActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        this.f4358a.f4263q.sendEmptyMessage(C1450R.layout.dialog_update_download_wifi_gone);
        this.f4358a.getApplicationContext();
        if (C1387ad.m3870b()) {
            C1492j.m4165a();
            C1492j.m4166a(this.f4358a.getApplicationContext(), this.f4358a.getString(C1450R.string.notify_download_wifigone));
        }
    }
}
