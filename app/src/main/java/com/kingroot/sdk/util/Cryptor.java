package com.kingroot.sdk.util;

import android.content.Context;
import com.kingroot.sdk.C0633at;
import com.shuame.mobile.sdk.FlashEngine.FlashResult;
import java.io.File;
import krsdk.C1773a;
import krsdk.KRError;
import krsdk.RootConfig;

public final class Cryptor {
    /* renamed from: gc */
    private static Integer f2205gc = Integer.valueOf(0);
    /* renamed from: gd */
    private static boolean f2206gd = true;
    private static final Object lock = new Object();

    /* renamed from: F */
    private static void m2362F(Context context) {
        if (f2205gc.intValue() == 0) {
            synchronized (lock) {
                if (f2205gc.intValue() == 0 && m2366d(context, f2206gd)) {
                    f2205gc = Integer.valueOf(1);
                }
            }
        }
    }

    /* renamed from: b */
    public static byte[] m2363b(Context context, byte[] bArr) {
        m2362F(context);
        byte[] bArr2 = new byte[0];
        try {
            return m2369x(context, bArr);
        } catch (UnsatisfiedLinkError e) {
            C0633at.m1465i("UnsatisfiedLinkError:" + e.getMessage());
            return bArr2;
        }
    }

    /* renamed from: c */
    public static void m2364c(Context context, boolean z) {
        synchronized (lock) {
            if (f2205gc.intValue() == 0 && m2366d(context, z)) {
                f2205gc = Integer.valueOf(1);
            }
        }
    }

    /* renamed from: c */
    public static byte[] m2365c(Context context, byte[] bArr) {
        m2362F(context);
        byte[] bArr2 = new byte[0];
        try {
            return m2370x2(context, bArr);
        } catch (UnsatisfiedLinkError e) {
            C0633at.m1465i("UnsatisfiedLinkError:" + e.getMessage());
            return bArr2;
        }
    }

    /* renamed from: d */
    private static boolean m2366d(Context context, boolean z) {
        f2206gd = z;
        String str = RootConfig.soFileName;
        if (z && C1773a.m4826cs()) {
            str = "64_" + str;
        }
        File file = new File(context.getFilesDir(), str);
        C0633at.m1464h("checkFileUpdate start");
        try {
            if (C0883c.m2402b(context, file.getAbsolutePath(), str)) {
                C0633at.m1464h("checkFileUpdate suc");
                C0883c.m2390a(context, str, file);
                C0633at.m1464h(str + " update done.");
            } else {
                C0633at.m1464h(str + " no changed.");
            }
            int Z = C0889i.m2426Z(file.getAbsolutePath());
            if (Z != 0) {
                C0633at.m1465i(str + " load fail, ret = " + Z);
                KRError.set(10004, "load so fail. ret = " + Z);
                return false;
            }
            new StringBuilder().append(str).append(" load done.");
            return true;
        } catch (Throwable th) {
            KRError.set(FlashResult.ERROR_DOWNLOAD_LUA, "extract so fail.", th);
            return false;
        }
    }

    /* renamed from: d */
    public static byte[] m2367d(Context context, byte[] bArr) {
        m2362F(context);
        byte[] bArr2 = new byte[0];
        try {
            return m2371y(context, bArr);
        } catch (UnsatisfiedLinkError e) {
            C0633at.m1465i("UnsatisfiedLinkError:" + e.getMessage());
            return bArr2;
        }
    }

    /* renamed from: e */
    public static final byte[] m2368e(Context context, byte[] bArr) {
        m2362F(context);
        byte[] bArr2 = new byte[0];
        try {
            return m2372z(bArr);
        } catch (UnsatisfiedLinkError e) {
            C0633at.m1465i("UnsatisfiedLinkError:" + e.getMessage());
            return bArr2;
        }
    }

    /* renamed from: x */
    private static native byte[] m2369x(Context context, byte[] bArr);

    /* renamed from: x2 */
    private static native byte[] m2370x2(Context context, byte[] bArr);

    /* renamed from: y */
    private static native byte[] m2371y(Context context, byte[] bArr);

    /* renamed from: z */
    private static final native byte[] m2372z(byte[] bArr);
}
