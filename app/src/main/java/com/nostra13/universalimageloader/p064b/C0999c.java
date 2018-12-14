package com.nostra13.universalimageloader.p064b;

import android.util.Log;
import com.nostra13.universalimageloader.core.C1033d;

/* renamed from: com.nostra13.universalimageloader.b.c */
public final class C0999c {
    /* renamed from: a */
    private static volatile boolean f2482a = false;
    /* renamed from: b */
    private static volatile boolean f2483b = true;

    /* renamed from: a */
    private static void m2830a(int i, Throwable th, String str, Object... objArr) {
        if (f2483b) {
            String format = objArr.length > 0 ? String.format(str, objArr) : str;
            if (th != null) {
                if (format == null) {
                    format = th.getMessage();
                }
                String stackTraceString = Log.getStackTraceString(th);
                format = String.format("%1$s\n%2$s", new Object[]{format, stackTraceString});
            }
            Log.println(i, C1033d.f2593a, format);
        }
    }

    /* renamed from: a */
    public static void m2831a(String str, Object... objArr) {
        if (f2482a) {
            C0999c.m2830a(3, null, str, objArr);
        }
    }

    /* renamed from: a */
    public static void m2832a(Throwable th) {
        C0999c.m2830a(6, th, null, new Object[0]);
    }

    /* renamed from: a */
    public static void m2833a(boolean z) {
        f2482a = z;
    }

    /* renamed from: b */
    public static void m2834b(String str, Object... objArr) {
        C0999c.m2830a(4, null, str, objArr);
    }

    /* renamed from: c */
    public static void m2835c(String str, Object... objArr) {
        C0999c.m2830a(5, null, str, objArr);
    }

    /* renamed from: d */
    public static void m2836d(String str, Object... objArr) {
        C0999c.m2830a(6, null, str, objArr);
    }
}
