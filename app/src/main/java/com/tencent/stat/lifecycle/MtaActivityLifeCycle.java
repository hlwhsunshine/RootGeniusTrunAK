package com.tencent.stat.lifecycle;

import android.app.Application;
import android.os.Build.VERSION;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;

public class MtaActivityLifeCycle {
    /* renamed from: a */
    private static StatLogger f5157a = StatCommonHelper.getLogger();

    public static Boolean registerActivityLifecycleCallbacks(Application application, MtaActivityLifecycleCallback mtaActivityLifecycleCallback) {
        if (application == null || mtaActivityLifecycleCallback == null || VERSION.SDK_INT < 14) {
            return Boolean.valueOf(false);
        }
        try {
            f5157a.mo7897d("............ start registerActivityLifecycleCallbacks.");
            application.registerActivityLifecycleCallbacks(new C1754a(mtaActivityLifecycleCallback));
            f5157a.mo7897d("............ end registerActivityLifecycleCallbacks.");
            return Boolean.valueOf(true);
        } catch (Throwable th) {
            th.printStackTrace();
            return Boolean.valueOf(false);
        }
    }
}
