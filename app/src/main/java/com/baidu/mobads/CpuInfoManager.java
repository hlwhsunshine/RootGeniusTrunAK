package com.baidu.mobads;

import android.content.Context;
import android.os.Looper;

public class CpuInfoManager {
    public static final int CHANNEL_AUTOMOTIVE = 1007;
    public static final int CHANNEL_ENTERTAINMENT = 1001;
    public static final int CHANNEL_FINANCE = 1006;
    public static final int CHANNEL_HOTSPOT = 1021;
    public static final int CHANNEL_HOUSE = 1008;
    public static final int CHANNEL_MOBILE = 1005;
    public static final int CHANNEL_PICTURE = 1003;
    public static final int CHANNEL_SPORT = 1002;

    public interface UrlListener {
        void onUrl(String str);
    }

    /* renamed from: a */
    private static void m275a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread(new C0440x(runnable)).start();
        } else {
            runnable.run();
        }
    }

    public static void getCpuInfoUrl(Context context, String str, int i, UrlListener urlListener) {
        m275a(new C0432v(context, i, str, urlListener));
    }
}
