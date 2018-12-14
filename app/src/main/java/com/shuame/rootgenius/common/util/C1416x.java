package com.shuame.rootgenius.common.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.shuame.rootgenius.common.C1325c;

/* renamed from: com.shuame.rootgenius.common.util.x */
public final class C1416x {
    /* renamed from: a */
    private static Handler f3907a = new Handler(Looper.getMainLooper(), new C1417y());
    /* renamed from: b */
    private static Toast f3908b = null;
    /* renamed from: c */
    private static View f3909c = null;

    /* renamed from: a */
    public static void m3936a(int i) {
        String str = null;
        try {
            str = C1325c.m3724a().getString(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C1416x.m3937a(str);
    }

    /* renamed from: a */
    public static void m3937a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Message obtain = Message.obtain();
            obtain.obj = str;
            f3907a.sendMessage(obtain);
        }
    }
}
