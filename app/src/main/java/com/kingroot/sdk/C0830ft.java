package com.kingroot.sdk;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.kingroot.sdk.C0831fu.C0795a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.kingroot.sdk.ft */
public class C0830ft {
    /* renamed from: c */
    public static boolean m2114c(C0716ga c0716ga, final List<String> list, final Map map) {
        if (list == null || list.size() == 0) {
            return true;
        }
        boolean booleanValue = ((Boolean) C0831fu.m2119a(c0716ga, new C0795a<Boolean>() {
            /* renamed from: a */
            public Boolean mo5806b(C0716ga c0716ga, List<Object> list) {
                boolean z = false;
                if (c0716ga.mo5684f(true)) {
                    String str;
                    int i;
                    List arrayList = new ArrayList();
                    arrayList.add(C0821fm.f2063jl);
                    for (String str2 : list) {
                        if (!TextUtils.isEmpty(str2)) {
                            i = -1;
                            if (C0830ft.m2117j(c0716ga, str2)) {
                                arrayList.add(C0820fl.m2077b(str2, false));
                                arrayList.add("rm -r " + str2);
                                i = 0;
                            }
                            if (map != null) {
                                map.put(str2, Integer.valueOf(i));
                            }
                        }
                    }
                    List i2 = c0716ga.mo5685i(arrayList);
                    if (i2 != null && i2.size() == arrayList.size()) {
                        for (i = 0; i < i2.size(); i++) {
                            if (!((C0836fz) i2.get(i)).success()) {
                                str2 = ((C0836fz) i2.get(i)).f2084cr;
                                if (!(str2.startsWith("rm ") || str2.startsWith("mount") || str2.startsWith(C0820fl.m2078bM()))) {
                                    break;
                                }
                            }
                        }
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            }
        }, new Object[0])).booleanValue();
        if (map != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str) && C0830ft.m2117j(c0716ga, str)) {
                    map.put(str, Integer.valueOf(1));
                }
            }
        }
        return booleanValue;
    }

    /* renamed from: e */
    public static boolean m2115e(C0716ga c0716ga, final String str, final String str2) {
        return ((Boolean) C0831fu.m2119a(c0716ga, new C0795a<Boolean>() {
            /* renamed from: a */
            public Boolean mo5806b(C0716ga c0716ga, List<Object> list) {
                boolean z = false;
                if (c0716ga.mo5684f(true)) {
                    String str = str2;
                    if (VERSION.SDK_INT >= 20) {
                        str = "Kinguser" + File.separator + str2;
                    }
                    str = "/system/app" + File.separator + str;
                    List arrayList = new ArrayList();
                    arrayList.add(C0821fm.f2063jl);
                    arrayList.add("rm -r " + str);
                    if (VERSION.SDK_INT >= 20) {
                        arrayList.add("rm -r /system/app" + File.separator + str2);
                        File file = new File("/system/app" + File.separator + "Kinguser");
                        if (!file.exists()) {
                            C0825fq.m2099g("Test", "installKinguser create dir:" + file.getAbsolutePath());
                            arrayList.add("mkdir " + file.getAbsolutePath());
                            arrayList.add("chown 0.0 " + file.getAbsolutePath());
                            arrayList.add("chmod 0755 " + file.getAbsolutePath());
                            arrayList.add("chcon u:object_r:system_file:s0 " + file.getAbsolutePath());
                        }
                    }
                    arrayList.add(String.format("touch %s", new Object[]{str}));
                    arrayList.add("chmod 0755 " + str);
                    arrayList.add(String.format("cat %s > %s", new Object[]{str, str}));
                    arrayList.add("chmod 0644 " + str);
                    List i = c0716ga.mo5685i(arrayList);
                    if (i != null && i.size() == arrayList.size()) {
                        for (int i2 = 0; i2 < i.size(); i2++) {
                            if (!((C0836fz) i.get(i2)).success()) {
                                str = ((C0836fz) i.get(i2)).f2084cr;
                                if (!(str.startsWith("rm ") || str.startsWith("mount"))) {
                                    break;
                                }
                            }
                        }
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            }
        }, new Object[0])).booleanValue();
    }

    /* renamed from: j */
    private static boolean m2117j(C0716ga c0716ga, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = "ls " + str;
        C0836fz k = C0830ft.m2118k(c0716ga, str2);
        C0825fq.m2099g("Test", "ls result:" + k.f2085cs);
        if (k == null || (k.success() && !k.f2085cs.contains("Failure"))) {
            return true;
        }
        C0825fq.m2101r("Test", "ls failed! script: " + str2 + "; error:" + k.f2086ct);
        return false;
    }

    /* renamed from: k */
    private static C0836fz m2118k(C0716ga c0716ga, String str) {
        return c0716ga.mo5683K(str);
    }
}
