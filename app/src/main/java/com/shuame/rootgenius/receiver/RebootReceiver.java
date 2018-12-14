package com.shuame.rootgenius.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.shuame.rootgenius.C1446g;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.hook.util.HookManager;
import com.shuame.rootgenius.hook.util.RebootRecordUtil;

public class RebootReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static final String f4025a = RebootReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        long oldRebootTimeDiffer = RebootRecordUtil.getOldRebootTimeDiffer();
        long currRebootTimeDiffer = RebootRecordUtil.getCurrRebootTimeDiffer();
        long abs = Math.abs(oldRebootTimeDiffer - currRebootTimeDiffer);
        boolean isRebootProcessed = RebootRecordUtil.isRebootProcessed();
        new StringBuilder("currentTimeMillis:").append(System.currentTimeMillis()).append("--elapsedRealtime:").append(SystemClock.elapsedRealtime());
        new StringBuilder("oldRebootTime:").append(oldRebootTimeDiffer).append("--newRebootTime:").append(currRebootTimeDiffer).append("--differRange:").append(abs);
        if (oldRebootTimeDiffer > 0 && oldRebootTimeDiffer != currRebootTimeDiffer && abs > 1000) {
            RebootRecordUtil.setOldRebootTimeDiffer(currRebootTimeDiffer);
            isRebootProcessed = false;
        }
        if (!isRebootProcessed) {
            RebootRecordUtil.setRebootProcessed(true);
            C1446g.m4003a();
            if (!C1446g.m4009c()) {
                C1446g.m4003a();
                C1446g.m4005a(true);
                C1387ad.m3868a(RootGeniusApp.m3523a(), C1323b.m3710o());
            }
            new C1462a(this).start();
            HookManager.registerHook();
        }
    }
}
