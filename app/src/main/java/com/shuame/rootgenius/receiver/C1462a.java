package com.shuame.rootgenius.receiver;

import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.util.NetworkUtils;
import com.shuame.rootgenius.sdk.RootGenius;

/* renamed from: com.shuame.rootgenius.receiver.a */
final class C1462a extends Thread {
    /* renamed from: a */
    final /* synthetic */ RebootReceiver f4026a;

    C1462a(RebootReceiver rebootReceiver) {
        this.f4026a = rebootReceiver;
    }

    public final void run() {
        Object obj = 1;
        int i = 0;
        while (obj != null) {
            try {
                if (NetworkUtils.m3852b()) {
                    RootGenius.onBootCompleted(RootGeniusApp.m3523a());
                    obj = null;
                } else {
                    Thread.sleep(3000);
                }
                i++;
                if (i > 30) {
                    obj = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
