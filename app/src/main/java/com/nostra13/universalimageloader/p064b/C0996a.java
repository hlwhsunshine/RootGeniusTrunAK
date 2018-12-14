package com.nostra13.universalimageloader.p064b;

import android.opengl.GLES10;
import com.nostra13.universalimageloader.core.assist.C1013c;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.p067c.C1026a;

/* renamed from: com.nostra13.universalimageloader.b.a */
public final class C0996a {
    /* renamed from: a */
    private static C1013c f2481a;

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        f2481a = new C1013c(max, max);
    }

    /* renamed from: a */
    public static int m2822a(C1013c c1013c) {
        int a = c1013c.mo6177a();
        int b = c1013c.mo6180b();
        return Math.max((int) Math.ceil((double) (((float) a) / ((float) f2481a.mo6177a()))), (int) Math.ceil((double) (((float) b) / ((float) f2481a.mo6180b()))));
    }

    /* renamed from: a */
    public static int m2823a(C1013c c1013c, C1013c c1013c2, ViewScaleType viewScaleType, boolean z) {
        int max;
        int i = 1;
        int a = c1013c.mo6177a();
        int b = c1013c.mo6180b();
        int a2 = c1013c2.mo6177a();
        int b2 = c1013c2.mo6180b();
        int i2;
        int i3;
        switch (viewScaleType) {
            case FIT_INSIDE:
                if (!z) {
                    max = Math.max(a / a2, b / b2);
                    break;
                }
                i2 = a / 2;
                i3 = b / 2;
                max = 1;
                while (true) {
                    if (i2 / max <= a2 && i3 / max <= b2) {
                        break;
                    }
                    max *= 2;
                }
                break;
            case CROP:
                if (!z) {
                    max = Math.min(a / a2, b / b2);
                    break;
                }
                i2 = a / 2;
                i3 = b / 2;
                max = 1;
                while (i2 / max > a2 && i3 / max > b2) {
                    max *= 2;
                }
                break;
            default:
                max = 1;
                break;
        }
        if (max > 0) {
            i = max;
        }
        max = f2481a.mo6177a();
        a2 = f2481a.mo6180b();
        while (true) {
            if (a / i <= max && b / i <= a2) {
                return i;
            }
            i = z ? i * 2 : i + 1;
        }
    }

    /* renamed from: a */
    public static C1013c m2824a(C1026a c1026a, C1013c c1013c) {
        int a = c1026a.mo6251a();
        if (a <= 0) {
            a = c1013c.mo6177a();
        }
        int b = c1026a.mo6254b();
        if (b <= 0) {
            b = c1013c.mo6180b();
        }
        return new C1013c(a, b);
    }

    /* renamed from: b */
    public static float m2825b(C1013c c1013c, C1013c c1013c2, ViewScaleType viewScaleType, boolean z) {
        int i;
        int a = c1013c.mo6177a();
        int b = c1013c.mo6180b();
        int a2 = c1013c2.mo6177a();
        int b2 = c1013c2.mo6180b();
        float f = ((float) a) / ((float) a2);
        float f2 = ((float) b) / ((float) b2);
        if ((viewScaleType != ViewScaleType.FIT_INSIDE || f < f2) && (viewScaleType != ViewScaleType.CROP || f >= f2)) {
            i = b2;
            b2 = (int) (((float) a) / f2);
        } else {
            i = (int) (((float) b) / f);
            b2 = a2;
        }
        return ((z || b2 >= a || i >= b) && (!z || b2 == a || i == b)) ? 1.0f : ((float) b2) / ((float) a);
    }
}
