package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.download.activate.IXMonitorActivation;

/* renamed from: com.baidu.mobads.production.g */
class C0406g implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0402f f932a;

    C0406g(C0402f c0402f) {
        this.f932a = c0402f;
    }

    public void run() {
        try {
            if (C0375a.f810a != null) {
                IXMonitorActivation xMonitorActivation = C0375a.f810a.getXMonitorActivation(this.f932a.f919a, this.f932a.f920b.f828s);
                xMonitorActivation.setIXActivateListener(new C0411h(this));
                xMonitorActivation.startMonitor();
            }
        } catch (Throwable e) {
            this.f932a.f920b.f828s.mo4928e(e);
        }
    }
}
