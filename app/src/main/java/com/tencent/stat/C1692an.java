package com.tencent.stat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.lifecycle.MtaActivityLifecycleCallback;

/* renamed from: com.tencent.stat.an */
final class C1692an implements MtaActivityLifecycleCallback {
    /* renamed from: a */
    final /* synthetic */ StatSpecifyReportedInfo f4934a;

    C1692an(StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f4934a = statSpecifyReportedInfo;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
        if (StatConfig.f4844q) {
            StatServiceImpl.m4638b((Context) activity, StatCommonHelper.getActivityName(activity), this.f4934a);
        }
        if (StatConfig.isEnableStatService()) {
            StatServiceImpl.f4890w = true;
            if (StatServiceImpl.f4893z != null) {
                StatServiceImpl.f4891x.removeCallbacks(StatServiceImpl.f4893z);
            }
            StatServiceImpl.f4891x.postDelayed(StatServiceImpl.f4893z = new C1693ao(this), StatConfig.getBackgroundDelayTimestamp());
        }
    }

    public final void onActivityResumed(Activity activity) {
        boolean z = false;
        if (StatConfig.f4844q) {
            StatServiceImpl.inerTrackBeginPage(activity, StatCommonHelper.getActivityName(activity), this.f4934a);
        }
        if (StatConfig.isEnableStatService()) {
            StatServiceImpl.f4890w = false;
            if (!StatServiceImpl.f4889v) {
                z = true;
            }
            StatServiceImpl.f4889v = true;
            if (StatServiceImpl.f4893z != null) {
                StatServiceImpl.f4891x.removeCallbacks(StatServiceImpl.f4893z);
            }
            if (z) {
                StatServiceImpl.f4884q.mo7904i("went foreground");
                for (StatActionListener onBecameForeground : StatServiceImpl.f4892y) {
                    try {
                        onBecameForeground.onBecameForeground();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return;
            }
            StatServiceImpl.f4884q.mo7904i("still foreground");
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
