package android.support.p015v4.p017os;

import android.os.CancellationSignal;

/* renamed from: android.support.v4.os.CancellationSignalCompatJellybean */
class CancellationSignalCompatJellybean {
    CancellationSignalCompatJellybean() {
    }

    public static void cancel(Object obj) {
        ((CancellationSignal) obj).cancel();
    }

    public static Object create() {
        return new CancellationSignal();
    }
}
