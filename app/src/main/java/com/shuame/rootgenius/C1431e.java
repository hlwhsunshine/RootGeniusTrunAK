package com.shuame.rootgenius;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;

/* renamed from: com.shuame.rootgenius.e */
final class C1431e extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ RootGeniusApp f3935a;

    C1431e(RootGeniusApp rootGeniusApp) {
        this.f3935a = rootGeniusApp;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.f3935a.f3310j != null) {
            for (QQDownloadFile a : this.f3935a.f3310j) {
                C1361b.m3817a().mo7067a(a, null);
            }
        }
        if (this.f3935a.f3309i != null) {
            for (QQDownloadFile a2 : this.f3935a.f3309i) {
                C1361b.m3817a().mo7067a(a2, null);
            }
        }
        this.f3935a.f3310j.clear();
        this.f3935a.f3309i.clear();
    }
}
