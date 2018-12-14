package com.kingroot.sdk;

import android.content.p013pm.PackageManager;
import android.text.TextUtils;
import com.kingroot.sdk.C0747dj.C0744a;
import java.util.Calendar;

/* renamed from: com.kingroot.sdk.br */
public final class C0682br {
    /* renamed from: a */
    public static int m1634a(String str, int i, int i2, int i3, String str2) {
        C0703ci.m1691h("runCmdShellReport", TextUtils.join(";", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2}));
        try {
            int random = (int) (Math.random() * 24.0d);
            Calendar instance = Calendar.getInstance();
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            int i4 = instance.get(11);
            long timeInMillis = i4 < random ? instance.getTimeInMillis() + (((long) (random - i4)) * PackageManager.MAXIMUM_VERIFICATION_TIMEOUT) : instance.getTimeInMillis() + (((long) ((random + 24) - i4)) * PackageManager.MAXIMUM_VERIFICATION_TIMEOUT);
            C0744a.m1810a(str, str2, i, i2, timeInMillis, timeInMillis + (((long) i3) * PackageManager.MAXIMUM_VERIFICATION_TIMEOUT));
            return 1;
        } catch (Throwable e) {
            C0633at.m1459a(e);
            return 0;
        }
    }

    /* renamed from: w */
    public static int m1635w(int i) {
        C0703ci.m1691h("runCmdSetTime", "setCheckTimeInterval: " + i + " seconds");
        long j = ((long) i) * 1000;
        if (j <= 0) {
            j = PackageManager.MAXIMUM_VERIFICATION_TIMEOUT;
        }
        try {
            C0633at.m1463g("interverTime:" + j);
            C0646bc.m1514c(j);
            return 1;
        } catch (Throwable e) {
            C0633at.m1459a(e);
            return 0;
        }
    }
}
