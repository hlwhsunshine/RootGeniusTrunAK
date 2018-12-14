package android.support.p015v4.app;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;

/* renamed from: android.support.v4.app.ActivityManagerCompat */
public final class ActivityManagerCompat {
    private ActivityManagerCompat() {
    }

    public static boolean isLowRamDevice(@NonNull ActivityManager activityManager) {
        return VERSION.SDK_INT >= 19 ? ActivityManagerCompatKitKat.isLowRamDevice(activityManager) : false;
    }
}
