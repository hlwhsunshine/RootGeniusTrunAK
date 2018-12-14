package com.baidu.mobads.openad.p024a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.baidu.mobads.openad.a.b */
public class C0351b extends BroadcastReceiver {
    /* renamed from: a */
    private C0352c f725a;

    public C0351b(C0352c c0352c) {
        this.f725a = c0352c;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            this.f725a.mo5064b();
        }
    }
}
