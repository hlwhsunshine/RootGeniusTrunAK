package com.tencent.stat;

import com.tencent.stat.common.StatCommonHelper;
import java.util.TimerTask;

/* renamed from: com.tencent.stat.d */
class C1733d extends TimerTask {
    /* renamed from: a */
    final /* synthetic */ C1716c f5089a;

    C1733d(C1716c c1716c) {
        this.f5089a = c1716c;
    }

    public void run() {
        if (StatConfig.isDebugEnable()) {
            StatCommonHelper.getLogger().mo7904i("TimerTask run");
        }
        StatServiceImpl.m4649f(this.f5089a.f5002c);
        cancel();
        this.f5089a.mo7888a();
    }
}
