package com.tencent.mid.api;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mid.p116a.C1638h;
import com.tencent.mid.p117b.C1649g;
import com.tencent.mid.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MidService {
    /* renamed from: a */
    private static Context f4680a = null;
    /* renamed from: b */
    private static Handler f4681b = null;
    /* renamed from: c */
    private static MidService f4682c = null;
    /* renamed from: d */
    private static final List<String> f4683d = new ArrayList(Arrays.asList(new String[]{"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE"}));
    /* renamed from: e */
    private static boolean f4684e = false;

    private MidService(Context context) {
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName());
        handlerThread.start();
        f4681b = new Handler(handlerThread.getLooper());
        f4680a = context.getApplicationContext();
    }

    /* renamed from: a */
    static synchronized MidService m4483a(Context context) {
        MidService midService;
        synchronized (MidService.class) {
            if (f4682c == null) {
                f4682c = new MidService(context);
            }
            midService = f4682c;
        }
        return midService;
    }

    /* renamed from: a */
    private static boolean m4484a(Context context, MidCallback midCallback) {
        for (String str : f4683d) {
            if (!Util.checkPermission(context, str)) {
                midCallback.onFail(MidConstants.ERROR_PERMISSIONS, "permission :" + str + " is denyed, please set it on AndroidManifest.xml first");
                return false;
            }
        }
        if (Util.checkPermission(context, "android.permission.WRITE_SETTINGS") || Util.checkPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            Util.checkPermission(context, "android.permission.READ_PHONE_STATE");
            return true;
        }
        midCallback.onFail(MidConstants.ERROR_PERMISSIONS, "failed to get permission either permission android.permission.WRITE_SETTINGS or android.permission.WRITE_EXTERNAL_STORAGE");
        return false;
    }

    /* renamed from: b */
    private static void m4485b(Context context, MidCallback midCallback) {
        if (m4484a(context, midCallback)) {
            m4483a(context);
            MidEntity a = C1649g.m4537a(context).mo7660a();
            if (a == null || !a.isMidValid()) {
                Util.logInfo("request new mid entity.");
                if (f4681b != null) {
                    f4681b.post(new C1638h(context, 1, midCallback));
                    return;
                }
                return;
            }
            Util.logInfo("get local mid entity:" + a.toString());
            midCallback.onSuccess(a.toString());
            if (f4681b != null) {
                f4681b.post(new C1638h(context, 2, midCallback));
            }
        }
    }

    public static void enableDebug(boolean z) {
        f4684e = z;
    }

    public static String getLocalMidOnly(Context context) {
        MidEntity a = C1649g.m4537a(context).mo7660a();
        return (a == null || !a.isMidValid()) ? "" : a.getMid();
    }

    public static String getMid(Context context) {
        if (context == null) {
            return null;
        }
        m4483a(context);
        MidEntity a = C1649g.m4537a(context).mo7660a();
        if (a == null) {
            a = new MidEntity();
        }
        if (!isMidValid(a.getMid())) {
            Util.logInfo("request new mid entity.");
            if (f4681b != null) {
                f4681b.post(new C1638h(context, 1, new C1641b()));
            }
        } else if (f4681b != null) {
            f4681b.post(new C1638h(context, 2, new C1642c()));
        }
        return a.getMid();
    }

    public static boolean isEnableDebug() {
        return f4684e;
    }

    public static boolean isMidValid(String str) {
        return Util.isMidValid(str);
    }

    public static void requestMid(Context context, MidCallback midCallback) {
        if (midCallback == null) {
            throw new IllegalArgumentException("error, callback is null!");
        } else if (context == null) {
            midCallback.onFail(MidConstants.ERROR_ARGUMENT, "content is null!");
        } else {
            m4485b(context, new C1640a(midCallback));
        }
    }
}
