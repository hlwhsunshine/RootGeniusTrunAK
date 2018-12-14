package android.support.p015v4.p017os;

import android.os.Build.VERSION;

/* renamed from: android.support.v4.os.TraceCompat */
public final class TraceCompat {
    private TraceCompat() {
    }

    public static void beginSection(String str) {
        if (VERSION.SDK_INT >= 18) {
            TraceJellybeanMR2.beginSection(str);
        }
    }

    public static void endSection() {
        if (VERSION.SDK_INT >= 18) {
            TraceJellybeanMR2.endSection();
        }
    }
}
