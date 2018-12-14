package com.shuame.rootgenius.hook.util;

import android.os.SystemClock;
import com.shuame.rootgenius.common.C1323b;

public class RebootRecordUtil {
    private static final String PREF_OLD_REBOOT_TIME = "old_reboot_time";
    private static final String PREF_REBOOT_PROCESSED_FLAG = "reboot_processed_flag";

    public static long getCurrRebootTimeDiffer() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public static long getOldRebootTimeDiffer() {
        return C1323b.m3688a().mo7000f(PREF_OLD_REBOOT_TIME);
    }

    public static boolean isRebootProcessed() {
        return C1323b.m3688a().mo6997b(PREF_REBOOT_PROCESSED_FLAG, true);
    }

    public static void setOldRebootTimeDiffer(long j) {
        C1323b.m3688a().mo6994a(PREF_OLD_REBOOT_TIME, j);
    }

    public static void setRebootProcessed(boolean z) {
        C1323b.m3688a().mo6996a(PREF_REBOOT_PROCESSED_FLAG, z);
    }
}
