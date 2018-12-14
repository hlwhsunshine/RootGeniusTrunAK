package com.shuame.rootgenius.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.p013pm.PackageManager.NameNotFoundException;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;

/* renamed from: com.shuame.rootgenius.common.b */
public class C1323b {
    /* renamed from: a */
    public static boolean f3579a;
    /* renamed from: b */
    private static final String f3580b = C1323b.class.getSimpleName();
    /* renamed from: d */
    private static C1323b f3581d;
    /* renamed from: e */
    private static String f3582e;
    /* renamed from: f */
    private static String f3583f;
    /* renamed from: g */
    private static int f3584g;
    /* renamed from: h */
    private static boolean f3585h = true;
    /* renamed from: i */
    private static boolean f3586i = false;
    /* renamed from: j */
    private static boolean f3587j = false;
    /* renamed from: k */
    private static boolean f3588k;
    /* renamed from: c */
    private SharedPreferences f3589c = C1325c.m3724a().getSharedPreferences("rootgenius_prefs", 0);
    /* renamed from: l */
    private String f3590l;

    private C1323b() {
    }

    /* renamed from: a */
    public static C1323b m3688a() {
        if (f3581d == null) {
            synchronized (C1323b.class) {
                if (f3581d == null) {
                    f3581d = new C1323b();
                }
            }
        }
        return f3581d;
    }

    /* renamed from: a */
    public static void m3689a(String str) {
        C1323b.m3688a().mo6995a("product_id", str);
    }

    /* renamed from: a */
    public static void m3690a(boolean z) {
        f3586i = z;
    }

    /* renamed from: b */
    public static void m3691b(String str) {
        C1323b.m3688a().mo6995a("product_name", str);
    }

    /* renamed from: b */
    public static void m3692b(boolean z) {
        f3587j = z;
    }

    /* renamed from: b */
    public static boolean m3693b() {
        return f3586i;
    }

    /* renamed from: c */
    public static void m3694c(boolean z) {
        f3579a = z;
    }

    /* renamed from: c */
    public static boolean m3695c() {
        return f3587j;
    }

    /* renamed from: c */
    public static boolean m3696c(String str) {
        return "shuame_mobile".equals(str) || "huangeziti".equals(str) || "appuninstall".equals(str) || "autoboot".equals(str) || "lottery".equals(str);
    }

    /* renamed from: d */
    public static void m3697d(boolean z) {
        f3588k = z;
    }

    /* renamed from: d */
    public static boolean m3698d() {
        return f3579a;
    }

    /* renamed from: e */
    public static void m3699e(boolean z) {
        f3585h = z;
    }

    /* renamed from: e */
    public static boolean m3700e() {
        return f3588k;
    }

    /* renamed from: f */
    public static boolean m3701f() {
        return C1323b.m3688a().mo6997b("noti_shown", false);
    }

    /* renamed from: g */
    public static void m3702g() {
        C1323b.m3688a().mo6996a("noti_shown", true);
    }

    /* renamed from: h */
    public static boolean m3703h() {
        return C1323b.m3688a().mo6997b("newroot_report", false);
    }

    /* renamed from: i */
    public static void m3704i() {
        C1323b.m3688a().mo6996a("newroot_report", true);
    }

    /* renamed from: j */
    public static boolean m3705j() {
        return C1323b.m3688a().mo6997b("ignore_guide", false);
    }

    /* renamed from: k */
    public static void m3706k() {
        C1323b.m3688a().mo6996a("ignore_guide", true);
    }

    /* renamed from: l */
    public static String m3707l() {
        Object g = C1323b.m3688a().mo7001g("product_id");
        return !TextUtils.isEmpty(g) ? g : null;
    }

    /* renamed from: m */
    public static String m3708m() {
        Object g = C1323b.m3688a().mo7001g("product_name");
        return !TextUtils.isEmpty(g) ? g : C1323b.m3688a().mo7001g("product_id");
    }

    /* renamed from: n */
    public static String m3709n() {
        if (C1325c.m3724a() == null) {
            return f3582e;
        }
        if (f3582e == null) {
            try {
                ApplicationInfo applicationInfo = C1325c.m3724a().getPackageManager().getApplicationInfo(C1325c.m3724a().getPackageName(), 128);
                String string = applicationInfo.metaData.getString("InstallChannel");
                f3582e = string;
                if (string == null) {
                    f3582e = String.valueOf(applicationInfo.metaData.getInt("InstallChannel"));
                }
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        new StringBuilder("channel:").append(f3582e);
        return f3582e;
    }

    /* renamed from: o */
    public static String m3710o() {
        if (f3583f == null) {
            f3583f = C1325c.m3724a().getPackageName();
        }
        return f3583f;
    }

    /* renamed from: p */
    public static int m3711p() {
        if (f3584g == 0) {
            try {
                f3584g = C1325c.m3724a().getPackageManager().getPackageInfo(C1323b.m3710o(), 0).versionCode;
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        new StringBuilder().append(f3584g);
        return f3584g;
    }

    /* renamed from: q */
    public static boolean m3712q() {
        return f3585h;
    }

    /* renamed from: a */
    public final void mo6993a(String str, int i) {
        Editor edit = this.f3589c.edit();
        edit.putInt(str, i);
        edit.commit();
    }

    /* renamed from: a */
    public final void mo6994a(String str, long j) {
        Editor edit = this.f3589c.edit();
        edit.putLong(str, j);
        edit.commit();
    }

    /* renamed from: a */
    public final void mo6995a(String str, String str2) {
        Editor edit = this.f3589c.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    /* renamed from: a */
    public final void mo6996a(String str, boolean z) {
        Editor edit = this.f3589c.edit();
        edit.putBoolean(str, z);
        edit.commit();
    }

    /* renamed from: b */
    public final boolean mo6997b(String str, boolean z) {
        return this.f3589c.getBoolean(str, z);
    }

    /* renamed from: d */
    public final void mo6998d(String str) {
        this.f3590l = str;
    }

    /* renamed from: e */
    public final int mo6999e(String str) {
        return this.f3589c.getInt(str, 0);
    }

    /* renamed from: f */
    public final long mo7000f(String str) {
        return this.f3589c.getLong(str, 0);
    }

    /* renamed from: g */
    public final String mo7001g(String str) {
        return this.f3589c.getString(str, "");
    }
}
