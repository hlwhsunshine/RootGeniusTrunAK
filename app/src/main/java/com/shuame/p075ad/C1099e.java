package com.shuame.p075ad;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.shuame.ad.e */
final class C1099e extends Handler {
    /* renamed from: a */
    final /* synthetic */ C1083a f2928a;

    C1099e(C1083a c1083a) {
        this.f2928a = c1083a;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                C1083a.f2891b;
                C1083a.m3173p(this.f2928a);
                return;
            case 2:
                C1083a.f2891b;
                this.f2928a.m3155b();
                return;
            case 3:
                C1083a.f2891b;
                if (this.f2928a.f2903m != null) {
                    this.f2928a.f2903m.onAdDismissed();
                    return;
                }
                return;
            case 4:
                C1083a.f2891b;
                if (this.f2928a.f2903m != null) {
                    this.f2928a.f2903m.onAdDismissed();
                    return;
                }
                return;
            case 5:
                C1083a.f2891b;
                if (this.f2928a.f2907q != null) {
                    this.f2928a.f2901k = true;
                    this.f2928a.f2907q.mo6686d(this.f2928a.f2898h);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
