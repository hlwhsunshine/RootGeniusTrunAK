package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.openad.interfaces.utils.IOAdTimer.EventHandler;

/* renamed from: com.baidu.mobads.production.i */
class C0414i implements EventHandler {
    /* renamed from: a */
    final /* synthetic */ C0375a f941a;

    C0414i(C0375a c0375a) {
        this.f941a = c0375a;
    }

    public void onTimer(int i) {
    }

    public void onTimerComplete() {
        this.f941a.mo5163h();
        this.f941a.mo5162g();
        this.f941a.m679a(XAdErrorCode.REQUEST_TIMEOUT, "");
    }
}
