package com.kingroot.sdk;

import android.content.p013pm.PackageInfo;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.kingroot.sdk.ff */
public class C0813ff {
    /* renamed from: a */
    public static void m2052a(C0716ga c0716ga, List<String> list, Map map) {
        C0825fq.m2099g("KuSdkClean", "cleanApps()");
        if (list != null && list.size() != 0) {
            List<String> arrayList = new ArrayList();
            for (String str : list) {
                if (C0813ff.m2053ag(str)) {
                    arrayList.add(str);
                } else {
                    map.put(str, Integer.valueOf(-1));
                }
            }
            C0813ff.m2055c(c0716ga, arrayList);
            for (String str2 : arrayList) {
                if (C0813ff.m2056g(c0716ga, str2)) {
                    map.put(str2, Integer.valueOf(0));
                } else {
                    C0813ff.m2057h(c0716ga, str2);
                    map.put(str2, Integer.valueOf(1));
                }
            }
        }
    }

    /* renamed from: ag */
    public static boolean m2053ag(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return C0843gg.m2186cf().getPackageInfo(str, 0) != null;
        } catch (Throwable e) {
            C0825fq.m2096a(e);
            return false;
        }
    }

    /* renamed from: b */
    protected static void m2054b(C0716ga c0716ga, List<String> list, Map map) {
        if (list != null && list.size() != 0) {
            C0830ft.m2114c(c0716ga, list, map);
        }
    }

    /* renamed from: c */
    protected static void m2055c(C0716ga c0716ga, List<String> list) {
        if (list != null && list.size() != 0) {
            List a = new C0824fp(c0716ga).mo5822a((List) list, new C0817fi());
            if (a != null && a.size() > 0) {
                C0813ff.m2054b(c0716ga, a, new HashMap());
            }
        }
    }

    /* renamed from: g */
    private static boolean m2056g(C0716ga c0716ga, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C0845gh.m2190a(C0823fo.m2083bR(), c0716ga, str);
        return C0813ff.m2058i(c0716ga, "pm uninstall " + str);
    }

    /* renamed from: h */
    private static boolean m2057h(C0716ga c0716ga, String str) {
        C0825fq.m2099g("KuSdkClean", "forceUninstallApk(), pkgName:" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            PackageInfo packageInfo = C0843gg.m2186cf().getPackageInfo(str, 0);
            if (packageInfo != null) {
                C0845gh.m2190a(C0823fo.m2083bR(), c0716ga, str);
                C0813ff.m2058i(c0716ga, "rm " + packageInfo.applicationInfo.publicSourceDir);
            }
        } catch (Throwable e) {
            C0825fq.m2096a(e);
        }
        try {
            Thread.sleep(2000);
        } catch (Throwable e2) {
            C0825fq.m2096a(e2);
        }
        C0813ff.m2058i(c0716ga, "pm uninstall " + str);
        return true;
    }

    /* renamed from: i */
    private static boolean m2058i(C0716ga c0716ga, String str) {
        C0836fz K = c0716ga.mo5683K(str);
        if (K == null || (K.success() && !K.f2085cs.contains("Failure"))) {
            return true;
        }
        C0825fq.m2102s("KuSdkClean", "script failed: " + str);
        return false;
    }
}
