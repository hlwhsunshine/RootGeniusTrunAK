package com.tencent.stat.lifecycle;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* renamed from: com.tencent.stat.lifecycle.a */
final class C1754a implements ActivityLifecycleCallbacks {
    /* renamed from: a */
    final /* synthetic */ MtaActivityLifecycleCallback f5158a;

    C1754a(MtaActivityLifecycleCallback mtaActivityLifecycleCallback) {
        this.f5158a = mtaActivityLifecycleCallback;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.f5158a.onActivityCreated(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.f5158a.onActivityDestroyed(activity);
    }

    public final void onActivityPaused(Activity activity) {
        MtaActivityLifeCycle.f5157a.mo7897d("onActivityPaused " + activity.getClass().getSimpleName());
        this.f5158a.onActivityPaused(activity);
    }

    public final void onActivityResumed(Activity activity) {
        MtaActivityLifeCycle.f5157a.mo7897d("onActivityResumed " + activity.getClass().getSimpleName());
        this.f5158a.onActivityResumed(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f5158a.onActivitySaveInstanceState(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
        this.f5158a.onActivityStarted(activity);
    }

    public final void onActivityStopped(Activity activity) {
        this.f5158a.onActivityStopped(activity);
    }
}
