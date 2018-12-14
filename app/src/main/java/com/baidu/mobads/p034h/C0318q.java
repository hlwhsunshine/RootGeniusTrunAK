package com.baidu.mobads.p034h;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Log;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.production.p042d.C0381a;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.baidu.mobads.h.q */
public class C0318q implements UncaughtExceptionHandler {
    /* renamed from: a */
    private static UncaughtExceptionHandler f599a;
    /* renamed from: b */
    private static volatile C0318q f600b;
    /* renamed from: c */
    private Context f601c;
    /* renamed from: d */
    private C0310a f602d;

    /* renamed from: com.baidu.mobads.h.q$a */
    interface C0310a {
        /* renamed from: a */
        void mo4516a(String str);
    }

    private C0318q(Context context) {
        this.f601c = context.getApplicationContext();
        f599a = Thread.getDefaultUncaughtExceptionHandler();
        new Thread(new C0319r(this)).start();
    }

    /* renamed from: a */
    public static C0318q m476a(Context context) {
        if (f600b == null) {
            synchronized (C0318q.class) {
                if (f600b == null) {
                    f600b = new C0318q(context);
                }
            }
        }
        return f600b;
    }

    /* renamed from: a */
    private String m478a(String str) {
        return m482b().getString(str, "");
    }

    /* renamed from: a */
    private String m479a(Throwable th) {
        th.printStackTrace();
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            for (StackTraceElement className : stackTrace) {
                String className2 = className.getClassName();
                if (className2.startsWith("junit.framework")) {
                    return null;
                }
                if (className2.startsWith("com.baidu.mobads.container")) {
                    return "remote";
                }
                if (className2.startsWith("com.baidu.mobads.loader")) {
                    return "loader";
                }
                if (className2.startsWith("com.baidu.mobads")) {
                    return "proxy";
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m481a(String str, String str2) {
        Editor c = m483c();
        c.putString("key_crash_source", str);
        c.putString("key_crash_trace", str2);
        c.putString("key_crash_ad", C0381a.f859w);
        if (VERSION.SDK_INT >= 9) {
            c.apply();
        } else {
            c.commit();
        }
    }

    /* renamed from: b */
    private SharedPreferences m482b() {
        return this.f601c.getSharedPreferences("baidu_mobads_crash", 0);
    }

    /* renamed from: c */
    private Editor m483c() {
        return m482b().edit();
    }

    /* renamed from: d */
    private void m484d() {
        Editor c = m483c();
        c.clear();
        if (VERSION.SDK_INT >= 9) {
            c.apply();
        } else {
            c.commit();
        }
    }

    /* renamed from: a */
    public void mo4523a() {
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof C0318q)) {
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    /* renamed from: a */
    public void mo4524a(C0310a c0310a) {
        this.f602d = c0310a;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String a = m479a(th);
            if (a != null) {
                m481a(a, Log.getStackTraceString(th));
                th.printStackTrace();
                if (this.f602d != null) {
                    this.f602d.mo4516a(a);
                }
            }
            if (f599a != null) {
                f599a.uncaughtException(thread, th);
            }
        } catch (Throwable e) {
            C0338m.m569a().mo5033f().mo4928e(e);
        }
    }
}
