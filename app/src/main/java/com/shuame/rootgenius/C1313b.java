package com.shuame.rootgenius;

import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.sdk.RootGenius;

/* renamed from: com.shuame.rootgenius.b */
final class C1313b extends Thread {
    /* renamed from: a */
    final /* synthetic */ RootGeniusApp f3560a;

    C1313b(RootGeniusApp rootGeniusApp) {
        this.f3560a = rootGeniusApp;
    }

    public final void run() {
        String e = C1387ad.m3877e(RootGeniusApp.m3523a());
        String f = C1387ad.m3878f(RootGeniusApp.m3523a());
        String a = C1387ad.m3865a(true);
        if (e == null) {
            e = "";
        }
        if (f == null) {
            f = "";
        }
        if (a == null) {
            a = "";
        }
        RootGenius.SetQIMEI(e, f, a);
        RootGenius.initialize(RootGeniusApp.m3523a());
        C1446g.m4003a();
        RootGenius.setSuSuite(C1446g.m4020n());
        C1323b.m3688a();
        RootGenius.SetVersionInfo(C1323b.m3709n());
        RootGeniusApp.f3307g = true;
    }
}
