package com.shuame.rootgenius.service;

import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.util.C1406p;
import com.shuame.rootgenius.hook.util.HookManager;

/* renamed from: com.shuame.rootgenius.service.b */
final class C1482b extends Thread {
    C1482b() {
    }

    public final void run() {
        C1406p.m3910a(true);
        C1483c.m4131a().mo7306c();
        C1493k.m4179a().mo7328i();
        C1489g.m4151a().mo7312a(false);
        if (C1323b.m3698d()) {
            C1488f.m4146b().mo7311d();
            HookManager.registerHook();
        }
        C1481a.f4079a = false;
    }
}
