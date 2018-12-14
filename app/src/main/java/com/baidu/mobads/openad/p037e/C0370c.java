package com.baidu.mobads.openad.p037e;

import com.baidu.mobads.p021j.C0336j;

/* renamed from: com.baidu.mobads.openad.e.c */
class C0370c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0368a f793a;

    C0370c(C0368a c0368a) {
        this.f793a = c0368a;
    }

    public void run() {
        try {
            if (this.f793a.f788g != null && this.f793a.f786e.getAndSet(false)) {
                this.f793a.f788g.disconnect();
                this.f793a.f788g = null;
            }
        } catch (Throwable e) {
            C0336j.m550a().mo4928e(e);
        }
    }
}
