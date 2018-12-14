package com.shuame.rootgenius.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shuame.rootgenius.common.util.NetworkUtils.NetworkType;

/* renamed from: com.shuame.rootgenius.common.util.r */
final class C1409r extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ C1408q f3895a;

    C1409r(C1408q c1408q) {
        this.f3895a = c1408q;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            NetworkType c = NetworkUtils.m3853c();
            if (this.f3895a.f3892a != c) {
                if (this.f3895a.f3892a == NetworkType.NONE) {
                    if (c == NetworkType.MOBILE) {
                        this.f3895a.f3893b.mo7129d();
                    } else if (c == NetworkType.WIFI) {
                        this.f3895a.f3893b.mo7128c();
                    }
                } else if (this.f3895a.f3892a == NetworkType.MOBILE) {
                    if (c == NetworkType.NONE) {
                        this.f3895a.f3893b.mo7131f();
                    } else if (c == NetworkType.WIFI) {
                        this.f3895a.f3893b.mo7130e();
                    }
                } else if (this.f3895a.f3892a == NetworkType.WIFI) {
                    if (c == NetworkType.NONE) {
                        this.f3895a.f3893b.mo7126a();
                    } else if (c == NetworkType.MOBILE) {
                        this.f3895a.f3893b.mo7127b();
                    }
                }
                this.f3895a.f3892a = c;
            }
        }
    }
}
