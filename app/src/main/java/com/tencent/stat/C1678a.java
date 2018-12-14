package com.tencent.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.tencent.stat.a */
class C1678a extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ NetworkManager f4899a;

    C1678a(NetworkManager networkManager) {
        this.f4899a = networkManager;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f4899a.f4778d != null) {
            this.f4899a.f4778d.mo7916a(new C1705b(this));
        }
    }
}
