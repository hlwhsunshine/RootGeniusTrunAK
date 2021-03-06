package android.support.p015v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;

/* renamed from: android.support.v4.app.BundleCompat */
public final class BundleCompat {
    private BundleCompat() {
    }

    public static IBinder getBinder(Bundle bundle, String str) {
        return VERSION.SDK_INT >= 18 ? BundleCompatJellybeanMR2.getBinder(bundle, str) : BundleCompatDonut.getBinder(bundle, str);
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        if (VERSION.SDK_INT >= 18) {
            BundleCompatJellybeanMR2.putBinder(bundle, str, iBinder);
        } else {
            BundleCompatDonut.putBinder(bundle, str, iBinder);
        }
    }
}
