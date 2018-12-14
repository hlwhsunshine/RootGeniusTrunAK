package com.shuame.rootgenius;

import android.content.p013pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.util.C1388ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/* renamed from: com.shuame.rootgenius.g */
public class C1446g {
    /* renamed from: a */
    public static int f3976a;
    /* renamed from: b */
    public static int f3977b;
    /* renamed from: e */
    private static final String f3978e = C1446g.class.getSimpleName();
    /* renamed from: g */
    private static C1446g f3979g = new C1446g();
    /* renamed from: c */
    public HashMap<String, Boolean> f3980c = new HashMap();
    /* renamed from: d */
    public ArrayList<String> f3981d = new ArrayList();
    /* renamed from: f */
    private boolean f3982f;

    /* renamed from: a */
    public static C1446g m4003a() {
        return f3979g;
    }

    /* renamed from: a */
    public static void m4004a(int i) {
        C1323b.m3688a().mo6993a("version_code", i);
    }

    /* renamed from: a */
    public static void m4005a(boolean z) {
        C1323b.m3688a().mo6996a("root_done_flag", z);
    }

    /* renamed from: b */
    public static void m4006b() {
        if (C1323b.m3688a().mo6999e("pc_root_probability") <= 0) {
            C1323b.m3688a().mo6993a("pc_root_probability", new Random().nextInt(20) + 80);
        }
        C1446g.m4011e();
    }

    /* renamed from: b */
    public static void m4007b(boolean z) {
        C1323b.m3688a().mo6996a("allowable_auto_check_auth_component_update", z);
    }

    /* renamed from: c */
    public static void m4008c(boolean z) {
        C1323b.m3688a().mo6996a("first_lanch", z);
    }

    /* renamed from: c */
    public static boolean m4009c() {
        return C1323b.m3688a().mo6997b("root_done_flag", true);
    }

    /* renamed from: d */
    public static void m4010d() {
        C1323b.m3688a().mo6994a("last_check_new_support_root_time", System.currentTimeMillis());
        C1388ae.m3880a().mo7114a("com.shuame.ACTION_CHECK_NEW_SUPPORT_ROOT");
    }

    /* renamed from: e */
    public static void m4011e() {
        C1323b.m3688a().mo6994a("last_check_component_update_time", System.currentTimeMillis());
        C1388ae.m3880a().mo7115b("com.shuame.ACTION_CHECK_AUTH_COMPONENT_UPDATE");
    }

    /* renamed from: f */
    public static long m4012f() {
        return C1323b.m3688a().mo7000f("last_check_component_update_time");
    }

    /* renamed from: g */
    public static long m4013g() {
        return C1323b.m3688a().mo7000f("last_check_new_support_root_time");
    }

    /* renamed from: h */
    public static boolean m4014h() {
        return C1323b.m3688a().mo6997b("allowable_auto_check_auth_component_update", true);
    }

    /* renamed from: i */
    public static boolean m4015i() {
        return C1323b.m3688a().mo6997b("first_lanch", false);
    }

    /* renamed from: j */
    public static int m4016j() {
        return C1323b.m3688a().mo6999e("version_code");
    }

    /* renamed from: k */
    public static boolean m4017k() {
        return C1323b.m3688a().mo6997b("ignore_pact", false);
    }

    /* renamed from: l */
    public static void m4018l() {
        C1323b.m3688a().mo6996a("ignore_pact", true);
    }

    /* renamed from: m */
    public static String m4019m() {
        Object g = C1323b.m3688a().mo7001g("auth_component_package_names_data");
        return TextUtils.isEmpty(g) ? "cn.qitu.rootangel,com.mgyun.superuser,com.noshufou.android.su,eu.chainfire.supersu,com.kingroot.kinguser,com.tencent.tcuser,com.baidu.easyroot,com.baiyi_mobile.easyroot,co.lvdou.superuser,com.qihoo.root,com.qihoo.permmgr,com.lbe.security.shuame,com.lbe.security.su,com.koushikdutta.superuser,com.noshufou.android.su.elite,com.aroot.asuperuser,com.dianxinos.superuser" : g;
    }

    /* renamed from: n */
    public static String[] m4020n() {
        return C1446g.m4019m().split(",");
    }

    /* renamed from: o */
    public final boolean mo7180o() {
        if (RootGeniusApp.m3523a() == null) {
            return this.f3982f;
        }
        try {
            this.f3982f = RootGeniusApp.m3523a().getPackageManager().getApplicationInfo(RootGeniusApp.m3523a().getPackageName(), 128).metaData.getBoolean("FirstRelease");
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        new StringBuilder("mFirstRelease:").append(this.f3982f);
        return this.f3982f;
    }
}
