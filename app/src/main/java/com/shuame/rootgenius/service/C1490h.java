package com.shuame.rootgenius.service;

import android.content.Intent;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.util.C1396i;
import com.shuame.rootgenius.common.util.C1402l;
import com.shuame.rootgenius.common.util.C1402l.C1400b;
import com.shuame.rootgenius.common.util.C1402l.C1401c;
import com.shuame.rootgenius.pojo.C1460b;

/* renamed from: com.shuame.rootgenius.service.h */
final class C1490h extends Thread {
    /* renamed from: a */
    final /* synthetic */ C1489g f4104a;

    C1490h(C1489g c1489g) {
        this.f4104a = c1489g;
    }

    public final void run() {
        C1460b a = this.f4104a.f4101c;
        a.f4006a = 0;
        a.f4007b = 0;
        a.f4008c = null;
        a.f4009d = null;
        a.f4010e = 0;
        a.f4011f = null;
        a.f4012g = null;
        a.f4013h = null;
        try {
            String c = C1489g.m4155c();
            C1489g.f4099a;
            C1400b c1400b = new C1400b();
            byte[] bytes = c.getBytes("UTF-8");
            C1396i.m3893a(bytes, C1396i.f3874a);
            c1400b.f3880a = C1489g.m4157d();
            c1400b.f3881b = bytes;
            C1401c a2 = C1402l.m3903a(c1400b);
            C1489g.f4099a;
            new StringBuilder("response.statusCode:").append(a2.f3885a);
            if (a2.f3885a == 200 && a2.f3886b.length > 0) {
                C1396i.m3895b(a2.f3886b, C1396i.f3874a);
                String str = new String(a2.f3886b, "UTF-8");
                C1489g.f4099a;
                C1489g.m4152a(this.f4104a, str);
            }
            this.f4104a.f4101c.f4006a = a2.f3885a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f4104a.f4103e = false;
        if (this.f4104a.f4101c.mo7243a() || this.f4104a.f4102d) {
            RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3634e));
        }
    }
}
