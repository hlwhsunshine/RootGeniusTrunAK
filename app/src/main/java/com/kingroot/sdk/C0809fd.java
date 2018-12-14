package com.kingroot.sdk;

import android.text.TextUtils;
import com.kingroot.sdk.C0831fu.C0795a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kingroot.sdk.fd */
public class C0809fd {

    /* renamed from: com.kingroot.sdk.fd$1 */
    class C08081 implements C0795a<Object> {
        C08081() {
        }

        /* renamed from: b */
        public Object mo5806b(C0716ga c0716ga, List<Object> list) {
            String str = (String) list.get(0);
            C0799ex c0799ex = (C0799ex) list.get(1);
            if (c0716ga.mo5684f(true)) {
                List arrayList = new ArrayList();
                arrayList.add(C0821fm.f2063jl);
                arrayList.add(C0820fl.m2077b(str, false));
                if (!(c0799ex.f2016dZ == -1 || c0799ex.f2017ea == -1)) {
                    arrayList.add(String.format("chown %d.%d %s", new Object[]{Integer.valueOf(c0799ex.f2016dZ), Integer.valueOf(c0799ex.f2017ea), str}));
                }
                if (c0799ex.mode != -1) {
                    arrayList.add(String.format("chmod 0%o %s", new Object[]{Integer.valueOf(c0799ex.mode), str}));
                }
                if (c0799ex.f2018eb != null) {
                    arrayList.add(String.format("chcon %s %s", new Object[]{c0799ex.f2018eb, str}));
                }
                arrayList.add(C0820fl.m2077b(str, true));
                c0716ga.mo5685i(arrayList);
            }
            return null;
        }
    }

    /* renamed from: a */
    public static int m2035a(C0716ga c0716ga, String str, C0799ex c0799ex) {
        int i = 0;
        C0799ex c = C0809fd.m2039c(c0716ga, str);
        if (c == null) {
            return 0;
        }
        if (!((c0799ex.f2016dZ == -1 || c.f2016dZ == c0799ex.f2016dZ) && (c0799ex.f2017ea == -1 || c.f2017ea == c0799ex.f2017ea))) {
            i = 1;
        }
        if (c0799ex.mode != -1 && c.mode != c0799ex.mode) {
            i |= 2;
        } else if (!(c0799ex.f2019ec == -1 || (c.mode & c0799ex.f2019ec) == c0799ex.f2019ec)) {
            i |= 2;
        }
        if (!(c0799ex.size == -1 || c.size == c0799ex.size)) {
            i |= 4;
        }
        return (TextUtils.isEmpty(c0799ex.f2018eb) || TextUtils.isEmpty(c.f2018eb) || c.f2018eb.equals(c0799ex.f2018eb)) ? i : i | 8;
    }

    /* renamed from: a */
    public static boolean m2036a(C0716ga c0716ga, List<String> list, C0799ex c0799ex) {
        for (String str : list) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    if (!(C0841ge.m2183k(file) || C0809fd.m2035a(c0716ga, str, c0799ex) == 0)) {
                        return true;
                    }
                } catch (Throwable e) {
                    C0825fq.m2096a(e);
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public static void m2037b(C0716ga c0716ga, String str, C0799ex c0799ex) {
        try {
            if (!C0841ge.m2183k(new File(str))) {
                C0825fq.m2099g("check_su_files", "repair " + str + "...chown,chmod,chcon");
                C0831fu.m2119a(c0716ga, new C08081(), str, c0799ex);
            }
        } catch (Throwable e) {
            C0825fq.m2096a(e);
        }
    }

    /* renamed from: b */
    public static void m2038b(C0716ga c0716ga, List<String> list, C0799ex c0799ex) {
        for (String b : list) {
            C0809fd.m2037b(c0716ga, b, c0799ex);
        }
    }

    /* renamed from: c */
    public static C0799ex m2039c(C0716ga c0716ga, String str) {
        C0799ex c0799ex = new C0799ex();
        C0836fz K = c0716ga.mo5683K(C0822fn.m2082bQ() + " zls " + str);
        if (!K.success() || K.f2085cs.trim().equals("Hehe")) {
            return null;
        }
        String[] split = K.f2085cs.split(" ");
        if (split.length >= 5) {
            try {
                c0799ex.mode = Integer.parseInt(split[0].trim());
                c0799ex.f2016dZ = Integer.parseInt(split[1].trim());
                c0799ex.f2017ea = Integer.parseInt(split[2].trim());
                c0799ex.size = Long.parseLong(split[3].trim());
                c0799ex.f2018eb = split[4].trim().equals("-") ? null : split[4].trim();
            } catch (Throwable e) {
                C0825fq.m2096a(e);
                return null;
            }
        }
        return c0799ex;
    }

    /* renamed from: i */
    protected static int m2040i(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            return -3;
        }
        File file2 = new File(str2);
        if (!file2.exists()) {
            return -2;
        }
        if (file.length() == file2.length()) {
            long f = C0840gd.m2175f(file);
            long f2 = C0840gd.m2175f(file2);
            if (f != 0 && f == f2) {
                return 0;
            }
        }
        return -1;
    }
}
