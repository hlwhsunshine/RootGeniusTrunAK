package com.shuame.rootgenius.service;

import java.util.ArrayList;

/* renamed from: com.shuame.rootgenius.service.l */
final class C1494l extends Thread {
    /* renamed from: a */
    final /* synthetic */ C1493k f4114a;

    C1494l(C1493k c1493k) {
        this.f4114a = c1493k;
    }

    public final void run() {
        synchronized (this.f4114a.f4113d) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f4114a.f4113d);
            C1493k.m4184b(arrayList);
            this.f4114a.f4113d.clear();
            this.f4114a.f4113d.addAll(arrayList);
        }
    }
}
