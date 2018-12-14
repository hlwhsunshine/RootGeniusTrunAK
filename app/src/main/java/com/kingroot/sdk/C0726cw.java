package com.kingroot.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.Serializable;

/* renamed from: com.kingroot.sdk.cw */
public class C0726cw implements Serializable {
    /* renamed from: bK */
    public String f1746bK;
    /* renamed from: eA */
    public String f1747eA;
    /* renamed from: eB */
    public String f1748eB;
    /* renamed from: eC */
    public String f1749eC;
    /* renamed from: eD */
    public boolean f1750eD = false;
    /* renamed from: eE */
    public boolean f1751eE = false;
    /* renamed from: ev */
    public int f1752ev;
    /* renamed from: ew */
    public int f1753ew;
    /* renamed from: ex */
    public long f1754ex;
    /* renamed from: ey */
    public long f1755ey;
    /* renamed from: ez */
    public int f1756ez;
    public long startTime;

    /* renamed from: com.kingroot.sdk.cw$a */
    public static class C0725a {
        /* renamed from: eB */
        public String f1742eB;
        /* renamed from: eF */
        public long f1743eF;
        /* renamed from: eG */
        public int f1744eG;
        /* renamed from: eH */
        public int f1745eH;
    }

    /* renamed from: a */
    public static void m1749a(Context context, String str, int i, int i2) {
        Editor edit = C0726cw.m1757w(context).edit();
        edit.putString("x_sdk_old_root_status", str);
        edit.putLong("x_sdk_start_nano_time", System.nanoTime());
        edit.putInt("x_sdk_solution_count", i);
        edit.putInt("x_sdk_su_mode", i2);
        edit.commit();
    }

    /* renamed from: a */
    public static void m1750a(Context context, String str, int i, int i2, String str2) {
        Editor edit = C0726cw.m1757w(context).edit();
        edit.putString("x_sid", str);
        edit.putInt("x_sindex", i);
        edit.putInt("x_stype", i2);
        edit.putLong("x_start_time", System.currentTimeMillis());
        edit.putLong("x_start_nano_time", System.nanoTime());
        edit.putLong("x_last_nano_time", System.nanoTime());
        edit.putInt("x_exploit_ret", 7053);
        edit.putString("x_exploit_errcodes", "7053");
        edit.putString("x_another_channel", str2);
        edit.commit();
    }

    /* renamed from: b */
    public static void m1751b(Context context, int i, String str) {
        Editor edit = C0726cw.m1757w(context).edit();
        edit.putInt("x_exploit_ret", i);
        edit.putString("x_exploit_errcodes", str);
        edit.commit();
    }

    /* renamed from: r */
    public static void m1752r(Context context) {
        Editor edit = C0726cw.m1757w(context).edit();
        edit.putLong("x_last_nano_time", System.nanoTime());
        edit.commit();
    }

    /* renamed from: s */
    public static C0726cw m1753s(Context context) {
        SharedPreferences w = C0726cw.m1757w(context);
        String string = w.getString("x_sid", null);
        if (string == null || string.length() == 0) {
            return null;
        }
        C0726cw c0726cw = new C0726cw();
        c0726cw.f1746bK = string;
        c0726cw.f1752ev = w.getInt("x_sindex", 0);
        c0726cw.f1753ew = w.getInt("x_stype", 0);
        c0726cw.startTime = w.getLong("x_start_time", 0);
        c0726cw.f1754ex = w.getLong("x_start_nano_time", 0);
        c0726cw.f1755ey = w.getLong("x_last_nano_time", 0);
        c0726cw.f1756ez = w.getInt("x_exploit_ret", 7053);
        c0726cw.f1747eA = w.getString("x_exploit_errcodes", "7053");
        c0726cw.f1748eB = w.getString("x_sdk_old_root_status", "");
        c0726cw.f1749eC = w.getString("x_another_channel", null);
        return c0726cw;
    }

    /* renamed from: t */
    public static C0725a m1754t(Context context) {
        SharedPreferences w = C0726cw.m1757w(context);
        C0725a c0725a = new C0725a();
        c0725a.f1742eB = w.getString("x_sdk_old_root_status", "");
        c0725a.f1743eF = w.getLong("x_sdk_start_nano_time", 0);
        c0725a.f1744eG = w.getInt("x_sdk_solution_count", 0);
        c0725a.f1745eH = w.getInt("x_sdk_su_mode", 1);
        return c0725a;
    }

    /* renamed from: u */
    public static void m1755u(Context context) {
        Editor edit = C0726cw.m1757w(context).edit();
        edit.remove("x_sid");
        edit.remove("x_sindex");
        edit.remove("x_stype");
        edit.remove("x_start_time");
        edit.remove("x_start_nano_time");
        edit.remove("x_last_nano_time");
        edit.remove("x_exploit_ret");
        edit.remove("x_exploit_errcodes");
        edit.remove("x_another_channel");
        edit.commit();
    }

    /* renamed from: v */
    public static C0726cw m1756v(Context context) {
        C0726cw s = C0726cw.m1753s(context);
        C0726cw.m1755u(context);
        return s;
    }

    /* renamed from: w */
    public static SharedPreferences m1757w(Context context) {
        return context.getSharedPreferences("kingrootsdk", 0);
    }

    /* renamed from: aE */
    public C0778ef mo5704aE() {
        C0778ef c0778ef = new C0778ef();
        c0778ef.f1904hp = (long) this.f1756ez;
        c0778ef.f1901hm = this.f1746bK;
        c0778ef.index = this.f1752ev;
        c0778ef.type = this.f1753ew;
        c0778ef.f1902hn = (int) (this.startTime / 1000);
        c0778ef.f1903ho = 0;
        return c0778ef;
    }

    /* renamed from: aF */
    public boolean mo5705aF() {
        return this.f1749eC != null && this.f1749eC.trim().length() > 0;
    }
}
