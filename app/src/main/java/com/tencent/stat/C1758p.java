package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatCommonHelper;

/* renamed from: com.tencent.stat.p */
final class C1758p implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5165a;

    C1758p(Context context) {
        this.f5165a = context;
    }

    public final void run() {
        if (this.f5165a == null) {
            StatServiceImpl.f4884q.error((Object) "The Context of StatService.onStop() can not be null!");
            return;
        }
        StatServiceImpl.flushDataToDB(this.f5165a);
        if (!StatServiceImpl.m4630a()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (StatCommonHelper.isBackgroundRunning(this.f5165a)) {
                if (StatConfig.isDebugEnable()) {
                    StatServiceImpl.f4884q.mo7904i("onStop isBackgroundRunning flushDataToDB");
                }
                StatServiceImpl.commitEvents(this.f5165a, -1);
            }
        }
    }
}
