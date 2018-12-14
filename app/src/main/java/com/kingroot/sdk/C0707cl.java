package com.kingroot.sdk;

import android.text.TextUtils;
import java.io.File;
import krsdk.RootShell;
import krsdk.RootShell.ShellResult;

/* renamed from: com.kingroot.sdk.cl */
public class C0707cl {

    /* renamed from: com.kingroot.sdk.cl$a */
    public static class C0706a {
        /* renamed from: dZ */
        public int f1720dZ = -1;
        /* renamed from: ea */
        public int f1721ea = -1;
        /* renamed from: eb */
        public String f1722eb = null;
        /* renamed from: ec */
        public int f1723ec = -1;
        public int mode = -1;
        public long size = -1;
    }

    /* renamed from: a */
    public static int m1694a(String str, String str2, C0706a c0706a) {
        int i = 0;
        C0706a j = C0707cl.m1696j(str, str2);
        if (j == null) {
            return -1;
        }
        if (!((c0706a.f1720dZ == -1 || j.f1720dZ == c0706a.f1720dZ) && (c0706a.f1721ea == -1 || j.f1721ea == c0706a.f1721ea))) {
            i = 1;
        }
        if (c0706a.mode != -1 && j.mode != c0706a.mode) {
            i |= 2;
        } else if (!(c0706a.f1723ec == -1 || (j.mode & c0706a.f1723ec) == c0706a.f1723ec)) {
            i |= 2;
        }
        if (!(c0706a.size == -1 || j.size == c0706a.size)) {
            i |= 4;
        }
        return (TextUtils.isEmpty(c0706a.f1722eb) || TextUtils.isEmpty(j.f1722eb) || j.f1722eb.equals(c0706a.f1722eb)) ? i : i | 8;
    }

    /* renamed from: i */
    public static int m1695i(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            return -3;
        }
        if (file.length() == 0) {
            return -4;
        }
        File file2 = new File(str2);
        if (!file2.exists()) {
            return -2;
        }
        if (file.length() == file2.length()) {
            long f = C0704cj.m1692f(file);
            long f2 = C0704cj.m1692f(file2);
            if (f != 0 && f == f2) {
                return 0;
            }
        }
        return -1;
    }

    /* renamed from: j */
    public static C0706a m1696j(String str, String str2) {
        C0706a c0706a = new C0706a();
        if (str == null) {
            str = C0712cn.m1714av() + " zls";
        }
        RootShell c = C0659bf.m1548c(true);
        ShellResult executeCommand2 = c != null ? c.executeCommand2(str + " " + str2) : null;
        if (executeCommand2 == null || !executeCommand2.success()) {
            executeCommand2 = C0659bf.m1549z(str + " " + str2);
        }
        if (executeCommand2 == null || !executeCommand2.success() || executeCommand2.stdout == null || executeCommand2.stdout.trim().equals("Hehe")) {
            return null;
        }
        String[] split = executeCommand2.stdout.split(" ");
        if (split.length < 5) {
            return null;
        }
        try {
            c0706a.mode = Integer.parseInt(split[0].trim());
            c0706a.f1720dZ = Integer.parseInt(split[1].trim());
            c0706a.f1721ea = Integer.parseInt(split[2].trim());
            c0706a.size = Long.parseLong(split[3].trim());
            c0706a.f1722eb = split[4].trim().equals("-") ? null : split[4].trim();
            return c0706a;
        } catch (Throwable e) {
            C0633at.m1459a(e);
            return null;
        }
    }
}
