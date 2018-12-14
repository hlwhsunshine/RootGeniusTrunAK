package com.shuame.rootgenius.common.util;

import android.os.Process;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.shuame.rootgenius.common.util.c */
public final class C1390c implements UncaughtExceptionHandler {
    /* renamed from: b */
    private static C1390c f3862b = new C1390c();
    /* renamed from: a */
    private UncaughtExceptionHandler f3863a;
    /* renamed from: c */
    private Map<String, Object> f3864c = new HashMap();
    /* renamed from: d */
    private SimpleDateFormat f3865d = new SimpleDateFormat("yyyyMMdd_HH-mm-ss");

    private C1390c() {
    }

    /* renamed from: a */
    public static C1390c m3888a() {
        return f3862b;
    }

    /* renamed from: b */
    public final void mo7116b() {
        this.f3863a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        int i;
        if (th == null) {
            i = 0;
        } else {
            th.printStackTrace();
            i = 1;
        }
        if (i != 0 || this.f3863a == null) {
            Process.killProcess(Process.myPid());
            System.exit(1);
            return;
        }
        this.f3863a.uncaughtException(thread, th);
    }
}
