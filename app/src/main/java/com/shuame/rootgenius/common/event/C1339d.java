package com.shuame.rootgenius.common.event;

import com.shuame.rootgenius.common.p100a.C1316a;
import com.shuame.rootgenius.common.util.C1387ad;
import java.util.Iterator;

/* renamed from: com.shuame.rootgenius.common.event.d */
final class C1339d extends Thread {
    /* renamed from: a */
    final /* synthetic */ C1337b f3629a;

    C1339d(C1337b c1337b) {
        this.f3629a = c1337b;
    }

    public final void run() {
        C1336a c1336a;
        Iterator it = C1316a.m3680a().mo6976a(-1).iterator();
        while (it.hasNext()) {
            c1336a = (C1336a) it.next();
            c1336a.f3615f = 1;
            if (C1387ad.m3871b(c1336a.f3616g)) {
                c1336a.f3612c = "true";
            }
            C1316a.m3680a().mo6978b(c1336a);
            C1337b.m3739a(c1336a);
        }
        it = C1316a.m3680a().mo6976a(1).iterator();
        while (it.hasNext()) {
            c1336a = (C1336a) it.next();
            C1316a.m3680a().mo6978b(c1336a);
            C1337b.m3739a(c1336a);
        }
        this.f3629a.f3626c = false;
    }
}
