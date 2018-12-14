package com.lzyblog.uninstalldemo;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class UninstalledObserver {
    /* renamed from: a */
    private static final String f2253a = UninstalledObserver.class.getSimpleName();
    /* renamed from: c */
    private static UninstalledObserver f2254c;
    /* renamed from: b */
    private Context f2255b = null;
    /* renamed from: d */
    private String f2256d = "http://m.shuame.com/uninstall/root";
    /* renamed from: e */
    private int f2257e = -1;
    /* renamed from: f */
    private String f2258f = "/data/data/com.shuame.rootgenius";
    /* renamed from: g */
    private String f2259g = "/data/data/com.shuame.rootgenius/files";
    /* renamed from: h */
    private String f2260h = "/data/data/com.shuame.rootgenius/files/observedFile";

    static {
        System.loadLibrary("uninstalled_observer");
    }

    private UninstalledObserver(Context context) {
        this.f2255b = context;
    }

    /* renamed from: a */
    public static synchronized UninstalledObserver m2505a(Context context) {
        UninstalledObserver uninstalledObserver;
        synchronized (UninstalledObserver.class) {
            if (f2254c == null) {
                f2254c = new UninstalledObserver(context);
            }
            uninstalledObserver = f2254c;
        }
        return uninstalledObserver;
    }

    /* renamed from: a */
    private String m2506a() {
        Object systemService = this.f2255b.getSystemService("user");
        if (systemService == null) {
            return null;
        }
        try {
            Object invoke = Process.class.getMethod("myUserHandle", null).invoke(Process.class, null);
            return String.valueOf(((Long) systemService.getClass().getMethod("getSerialNumberForUser", new Class[]{invoke.getClass()}).invoke(systemService, new Object[]{invoke})).longValue());
        } catch (NoSuchMethodException e) {
        } catch (IllegalArgumentException e2) {
        } catch (IllegalAccessException e3) {
        } catch (InvocationTargetException e4) {
        }
        return null;
    }

    private native int init(String str, String str2);

    /* renamed from: a */
    public final int mo6021a(String str) {
        File file = new File(this.f2260h);
        if (!file.exists()) {
            try {
                File file2 = new File(this.f2259g);
                if (file2.exists() || file2.mkdir()) {
                    if (file.createNewFile()) {
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str)) {
            this.f2256d = str;
        }
        if (VERSION.SDK_INT < 17) {
            this.f2257e = init(null, this.f2256d);
        } else {
            String a = m2506a();
            if (a == null) {
                a = "0";
            }
            this.f2257e = init(a, this.f2256d);
        }
        return this.f2257e;
    }
}
