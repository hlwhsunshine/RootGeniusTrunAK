package com.shuame.rootgenius.hook;

import android.content.Context;
import com.shuame.rootgenius.hook.util.RebootRecordUtil;

public class HookModule {
    private static Context sContext;

    public static Context getContext() {
        return sContext;
    }

    public static void init(Context context) {
        sContext = context;
        if (0 == RebootRecordUtil.getOldRebootTimeDiffer()) {
            RebootRecordUtil.setOldRebootTimeDiffer(RebootRecordUtil.getCurrRebootTimeDiffer());
        }
    }
}
