package com.kingroot.sdk;

import android.os.Build;
import com.kingroot.sdk.C0831fu.C0795a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kingroot.sdk.fe */
public class C0812fe extends C0793et {
    /* renamed from: jd */
    private boolean f2056jd = false;
    /* renamed from: je */
    private boolean f2057je = false;
    /* renamed from: jf */
    private boolean f2058jf = false;

    /* renamed from: com.kingroot.sdk.fe$1 */
    class C08101 implements C0795a<Object> {
        C08101() {
        }

        /* renamed from: b */
        public Object mo5806b(C0716ga c0716ga, List<Object> list) {
            if (c0716ga.mo5684f(true)) {
                List arrayList = new ArrayList(7);
                arrayList.add(C0821fm.f2063jl);
                arrayList.add(C0821fm.f2064jm);
                arrayList.add(C0820fl.m2077b("/sbin/su", false));
                arrayList.add("rm /sbin/su");
                arrayList.add(C0820fl.m2077b("/vendor/bin/su", false));
                arrayList.add("rm /vendor/bin/su");
                arrayList.add(C0820fl.m2077b("/system/sbin/su", false));
                arrayList.add("rm /system/sbin/su");
                c0716ga.mo5685i(arrayList);
            }
            return null;
        }
    }

    /* renamed from: a */
    private static void m2043a(C0716ga c0716ga, String str, String str2, int i) {
        List arrayList = new ArrayList(6);
        arrayList.add(C0821fm.f2063jl);
        arrayList.add(C0820fl.m2077b(str2, false));
        arrayList.add("rm " + str2);
        arrayList.add(String.format("cat %s > %s", new Object[]{str, str2}));
        arrayList.add("chown 0.0 " + str2);
        arrayList.add(String.format("chmod 0%o %s", new Object[]{Integer.valueOf(i), str2}));
        arrayList.add(C0820fl.m2077b(str2, true));
        c0716ga.mo5685i(arrayList);
    }

    /* renamed from: a */
    private static void m2044a(C0716ga c0716ga, boolean z, boolean z2) {
        List arrayList = new ArrayList(8);
        arrayList.add(C0821fm.f2063jl);
        arrayList.add(C0820fl.m2077b("/system/bin/sutemp", false));
        arrayList.add(C0820fl.m2077b("/system/xbin/sutemp", false));
        arrayList.add("rm /system/bin/sutemp");
        arrayList.add("rm /system/xbin/sutemp");
        if (z) {
            arrayList.add(C0820fl.m2077b("/system/bin/su", false));
            arrayList.add("rm /system/bin/su");
            arrayList.add(String.format("ln -s %s %s", new Object[]{"/system/xbin/su", "/system/bin/su"}));
            arrayList.add(C0820fl.m2077b("/system/bin/su", true));
        }
        if (z2) {
            arrayList.add(C0820fl.m2077b("/system/xbin/su", false));
            arrayList.add("rm /system/xbin/su");
            arrayList.add(String.format("ln -s %s %s", new Object[]{"/system/bin/su", "/system/xbin/su"}));
            arrayList.add(C0820fl.m2077b("/system/xbin/su", true));
        }
        c0716ga.mo5685i(arrayList);
    }

    /* renamed from: bJ */
    public static int m2045bJ() {
        return (Build.MODEL.equals("Coolpad 8720L") || C0826fr.m2103bY()) ? 493 : 3565;
    }

    /* renamed from: d */
    public static synchronized boolean m2046d(C0716ga c0716ga, final String str) {
        boolean booleanValue;
        synchronized (C0812fe.class) {
            booleanValue = ((Boolean) C0831fu.m2119a(c0716ga, new C0795a<Object>() {
                /* renamed from: b */
                public Object mo5806b(C0716ga c0716ga, List<Object> list) {
                    return Boolean.valueOf(C0812fe.m2048e(c0716ga, str));
                }
            }, new Object[0])).booleanValue();
        }
        return booleanValue;
    }

    /* renamed from: d */
    private static boolean m2047d(C0716ga c0716ga, String str, String str2) {
        int bJ = C0812fe.m2045bJ();
        C0812fe.m2043a(c0716ga, str, str2, bJ);
        if (bJ == 3565) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!new File(str2).exists()) {
                C0812fe.m2043a(c0716ga, str, str2, 493);
            }
        }
        return C0827fs.m2107al(str2);
    }

    /* renamed from: e */
    private static boolean m2048e(C0716ga c0716ga, String str) {
        if (!c0716ga.mo5684f(true)) {
            return false;
        }
        boolean al = C0809fd.m2040i(str, "/system/xbin/su") == 0 ? C0827fs.m2107al("/system/xbin/su") : false;
        if (al) {
            C0812fe.m2044a(c0716ga, true, false);
            return true;
        }
        if (C0812fe.m2047d(c0716ga, str, "/system/xbin/sutemp")) {
            al = C0812fe.m2047d(c0716ga, str, "/system/xbin/su");
        }
        if (al) {
            C0812fe.m2044a(c0716ga, true, false);
            return true;
        }
        al = C0809fd.m2040i(str, "/system/bin/su") == 0 ? C0827fs.m2107al("/system/bin/su") : false;
        if (al) {
            C0812fe.m2044a(c0716ga, false, true);
            return true;
        }
        if (C0812fe.m2047d(c0716ga, str, "/system/bin/sutemp")) {
            al = C0812fe.m2047d(c0716ga, str, "/system/bin/su");
        }
        if (!al) {
            return false;
        }
        C0812fe.m2044a(c0716ga, false, true);
        return true;
    }

    /* renamed from: a */
    public boolean mo5804a(C0716ga c0716ga) {
        String bS = C0823fo.m2084bS();
        this.f2057je = true;
        this.f2058jf = false;
        this.f2056jd = false;
        int i = C0809fd.m2040i(bS, "/system/bin/su");
        int i2 = C0809fd.m2040i(bS, "/system/xbin/su");
        if (i == 0 && i2 == -2) {
            this.f2057je = false;
        } else if (i == -2 && i2 == 0) {
            this.f2057je = false;
        } else if (i == 0 && i2 == 0) {
            this.f2057je = false;
        }
        if (!this.f2057je) {
            C0799ex c0799ex = new C0799ex();
            c0799ex.f2016dZ = 0;
            c0799ex.f2017ea = 0;
            c0799ex.mode = C0812fe.m2045bJ();
            c0799ex.f2018eb = "u:object_r:system_file:s0";
            List arrayList = new ArrayList();
            arrayList.add("/system/bin/su");
            arrayList.add("/system/xbin/su");
            this.f2056jd = C0809fd.m2036a(c0716ga, arrayList, c0799ex);
        }
        boolean z = new File("/sbin/su").exists() || new File("/vendor/bin/su").exists() || new File("/system/sbin/su").exists();
        this.f2058jf = z;
        return (this.f2057je || this.f2058jf || this.f2056jd) ? false : true;
    }

    /* renamed from: b */
    public boolean mo5805b(C0716ga c0716ga) {
        boolean z = true;
        if (this.f2057je) {
            C0825fq.m2099g("check_su_files", "repair su...cat,chown,chmod,chcon");
            z = C0812fe.m2046d(c0716ga, C0823fo.m2084bS());
            C0825fq.m2099g("check_su_files", "repair su..." + z);
        } else if (this.f2056jd) {
            C0799ex c0799ex = new C0799ex();
            c0799ex.f2016dZ = 0;
            c0799ex.f2017ea = 0;
            c0799ex.mode = C0812fe.m2045bJ();
            c0799ex.f2018eb = "u:object_r:system_file:s0";
            List arrayList = new ArrayList();
            arrayList.add("/system/bin/su");
            arrayList.add("/system/xbin/su");
            C0809fd.m2038b(c0716ga, arrayList, c0799ex);
        }
        if (z && this.f2058jf) {
            C0825fq.m2099g("check_su_files", "clear other su");
            C0831fu.m2119a(c0716ga, new C08101(), new Object[0]);
        }
        return z;
    }
}
