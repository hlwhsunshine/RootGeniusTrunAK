package android.support.p015v4.p017os;

import android.os.Trace;

/* renamed from: android.support.v4.os.TraceJellybeanMR2 */
class TraceJellybeanMR2 {
    TraceJellybeanMR2() {
    }

    public static void beginSection(String str) {
        Trace.beginSection(str);
    }

    public static void endSection() {
        Trace.endSection();
    }
}
