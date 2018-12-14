package okio;

import android.support.p015v4.internal.view.SupportMenu;
import android.support.p015v4.view.MotionEventCompat;
import android.support.p015v4.view.ViewCompat;
import java.nio.charset.Charset;

/* renamed from: okio.aa */
final class C1933aa {
    /* renamed from: a */
    public static final Charset f5798a = Charset.forName("UTF-8");

    /* renamed from: a */
    public static int m5589a(int i) {
        return ((((ViewCompat.MEASURED_STATE_MASK & i) >>> 24) | ((16711680 & i) >>> 8)) | ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) << 8)) | ((i & 255) << 24);
    }

    /* renamed from: a */
    public static short m5590a(short s) {
        int i = SupportMenu.USER_MASK & s;
        return (short) (((i & 255) << 8) | ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) >>> 8));
    }

    /* renamed from: a */
    public static void m5591a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    /* renamed from: a */
    public static void m5592a(Throwable th) {
        throw th;
    }

    /* renamed from: a */
    public static boolean m5593a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
