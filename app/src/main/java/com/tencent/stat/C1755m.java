package com.tencent.stat;

import android.content.Context;
import com.tencent.mid.api.MidService;
import com.tencent.mid.util.Util;
import com.tencent.stat.common.StatCommonHelper;

/* renamed from: com.tencent.stat.m */
final class C1755m implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5159a;

    C1755m(Context context) {
        this.f5159a = context;
    }

    public final void run() {
        NetworkManager.getInstance(this.f5159a).registerBroadcast();
        if (Util.isMidValid(MidService.getLocalMidOnly(this.f5159a))) {
            MidService.getMid(this.f5159a);
        }
        StatCommonHelper.getDiffTime(this.f5159a, true);
        C1706ba.m4673a(this.f5159a);
        C1748g.m4809b(this.f5159a);
        StatServiceImpl.f4885r = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new C1697as());
        if (StatConfig.getStatSendStrategy() == StatReportStrategy.APP_LAUNCH) {
            StatServiceImpl.commitEvents(this.f5159a, -1);
        }
        if (StatConfig.isDebugEnable()) {
            StatServiceImpl.f4884q.mo7897d("Init MTA StatService success with sdk version2.1.0");
        }
    }
}
