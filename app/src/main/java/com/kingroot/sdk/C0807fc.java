package com.kingroot.sdk;

import android.os.Build;
import com.kingroot.sdk.C0831fu.C0795a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kingroot.sdk.fc */
public class C0807fc extends C0793et {
    /* renamed from: gt */
    private static byte[] f2046gt;
    /* renamed from: iR */
    private boolean f2047iR = false;
    /* renamed from: iS */
    private boolean f2048iS = false;
    /* renamed from: iT */
    private boolean f2049iT = false;
    /* renamed from: iU */
    private boolean f2050iU = false;
    /* renamed from: iV */
    private boolean f2051iV = false;
    /* renamed from: iW */
    private boolean f2052iW = false;
    /* renamed from: iX */
    private boolean f2053iX = false;

    static {
        byte[] bArr = new byte[16];
        bArr[0] = Byte.MAX_VALUE;
        bArr[1] = (byte) 69;
        bArr[2] = (byte) 76;
        bArr[3] = (byte) 70;
        bArr[4] = (byte) 1;
        bArr[5] = (byte) 1;
        bArr[6] = (byte) 1;
        f2046gt = bArr;
    }

    /* renamed from: a */
    private static void m2021a(C0716ga c0716ga, final String str, final String str2) {
        C0831fu.m2119a(c0716ga, new C0795a<Object>() {
            /* renamed from: b */
            public Object mo5806b(C0716ga c0716ga, List<Object> list) {
                if (c0716ga.mo5684f(true)) {
                    List arrayList = new ArrayList(8);
                    arrayList.add(C0821fm.f2063jl);
                    arrayList.add(C0820fl.m2077b(str2, false));
                    if (new File(str2).exists()) {
                        arrayList.add(String.format("cat %s > %s", new Object[]{str2, str2 + "-ku.bak"}));
                        arrayList.add("rm " + str2);
                    }
                    arrayList.add(String.format("cat %s > %s", new Object[]{str, str2}));
                    arrayList.add("chown 0.0 " + str2);
                    arrayList.add("chmod 0755 " + str2);
                    arrayList.add("chcon u:object_r:system_file:s0 " + str2);
                    arrayList.add("rm " + str);
                    arrayList.add(C0820fl.m2077b(str2, true));
                    c0716ga.mo5685i(arrayList);
                }
                return null;
            }
        }, new Object[0]);
    }

    /* renamed from: a */
    private static void m2022a(C0716ga c0716ga, final String str, final String str2, final boolean z) {
        C0831fu.m2119a(c0716ga, new C0795a<Object>() {
            /* renamed from: b */
            public Object mo5806b(C0716ga c0716ga, List<Object> list) {
                if (c0716ga.mo5684f(true) && new File(str).exists()) {
                    List arrayList = new ArrayList(8);
                    arrayList.add(C0821fm.f2063jl);
                    arrayList.add(String.format("cat %s > %s", new Object[]{str, str2}));
                    arrayList.add("chown 0.0 " + str2);
                    arrayList.add("chmod 0755 " + str2);
                    if (z) {
                        arrayList.add(C0820fl.m2077b(str, false));
                        arrayList.add("rm " + str);
                    }
                    c0716ga.mo5685i(arrayList);
                }
                return null;
            }
        }, new Object[0]);
    }

    /* renamed from: a */
    private boolean m2023a(C0716ga c0716ga, String str) {
        File file = new File("/system/bin/ddexereal");
        if (file.exists()) {
            C0807fc.m2022a(c0716ga, file.getAbsolutePath(), "/system/bin/ddexe_real", true);
        } else if (!C0807fc.m2025af("/system/bin/ddexe")) {
            C0807fc.m2022a(c0716ga, "/system/bin/ddexe", "/system/bin/ddexe_real", false);
        }
        return C0807fc.m2027b(c0716ga, str);
    }

    /* renamed from: a */
    private boolean m2024a(C0716ga c0716ga, String str, String str2, String str3) {
        if (this.f2051iV) {
            if (!this.f2052iW || !this.f2053iX) {
                return true;
            }
            C0807fc.m2029c(c0716ga, "/system/etc/install-recovery-2.sh", "/system/xbin/ku.sud");
            return true;
        } else if (this.f2052iW && this.f2053iX && !Build.MODEL.equals("SM-N9002")) {
            return true;
        } else {
            C0807fc.m2026b(c0716ga, str, str3);
            this.f2051iV = C0807fc.m2030c(str, str2, str3);
            if (!this.f2051iV) {
                if (this.f2052iW && !this.f2053iX) {
                    C0807fc.m2026b(c0716ga, "/system/etc/install-recovery-2.sh", str3);
                    this.f2053iX = C0807fc.m2030c("/system/etc/install-recovery-2.sh", str2, str3);
                }
                return this.f2052iW && this.f2053iX;
            } else if (!this.f2052iW) {
                return true;
            } else {
                C0807fc.m2029c(c0716ga, "/system/etc/install-recovery-2.sh", "/system/xbin/ku.sud");
                return true;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0069 A:{SYNTHETIC, Splitter: B:44:0x0069} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005c A:{SYNTHETIC, Splitter: B:37:0x005c} */
    /* renamed from: af */
    private static boolean m2025af(java.lang.String r8) {
        /*
        r1 = 1;
        r0 = 0;
        r4 = new java.io.File;
        r4.<init>(r8);
        r2 = r4.exists();
        if (r2 != 0) goto L_0x000e;
    L_0x000d:
        return r0;
    L_0x000e:
        r3 = 0;
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r5 = new byte[r2];
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0055, all -> 0x0065 }
        r2.<init>(r4);	 Catch:{ Exception -> 0x0055, all -> 0x0065 }
        r3 = 0;
        r4 = 1023; // 0x3ff float:1.434E-42 double:5.054E-321;
        r3 = r2.read(r5, r3, r4);	 Catch:{ Exception -> 0x0074 }
        r4 = -1;
        if (r3 == r4) goto L_0x0030;
    L_0x0022:
        r3 = new java.lang.String;	 Catch:{ Exception -> 0x0074 }
        r3.<init>(r5);	 Catch:{ Exception -> 0x0074 }
        r4 = "#!/system/bin/sh";
        r3 = r3.contains(r4);	 Catch:{ Exception -> 0x0074 }
        if (r3 == 0) goto L_0x0039;
    L_0x002f:
        r0 = r1;
    L_0x0030:
        r2.close();	 Catch:{ IOException -> 0x0034 }
        goto L_0x000d;
    L_0x0034:
        r1 = move-exception;
        com.kingroot.sdk.C0825fq.m2096a(r1);
        goto L_0x000d;
    L_0x0039:
        r3 = r0;
    L_0x003a:
        r4 = f2046gt;	 Catch:{ Exception -> 0x0074 }
        r4 = r4.length;	 Catch:{ Exception -> 0x0074 }
        if (r3 < r4) goto L_0x0047;
    L_0x003f:
        r1 = r0;
    L_0x0040:
        r4 = f2046gt;	 Catch:{ Exception -> 0x0076 }
        r4 = r4.length;	 Catch:{ Exception -> 0x0076 }
        if (r3 == r4) goto L_0x0030;
    L_0x0045:
        r0 = r1;
        goto L_0x0030;
    L_0x0047:
        r4 = f2046gt;	 Catch:{ Exception -> 0x0074 }
        r4 = r4[r3];	 Catch:{ Exception -> 0x0074 }
        r6 = r5[r3];	 Catch:{ Exception -> 0x0074 }
        if (r4 == r6) goto L_0x0052;
    L_0x004f:
        r4 = 4;
        if (r3 < r4) goto L_0x0040;
    L_0x0052:
        r3 = r3 + 1;
        goto L_0x003a;
    L_0x0055:
        r1 = move-exception;
        r2 = r3;
    L_0x0057:
        com.kingroot.sdk.C0825fq.m2096a(r1);	 Catch:{ all -> 0x0072 }
        if (r2 == 0) goto L_0x000d;
    L_0x005c:
        r2.close();	 Catch:{ IOException -> 0x0060 }
        goto L_0x000d;
    L_0x0060:
        r1 = move-exception;
        com.kingroot.sdk.C0825fq.m2096a(r1);
        goto L_0x000d;
    L_0x0065:
        r0 = move-exception;
        r2 = r3;
    L_0x0067:
        if (r2 == 0) goto L_0x006c;
    L_0x0069:
        r2.close();	 Catch:{ IOException -> 0x006d }
    L_0x006c:
        throw r0;
    L_0x006d:
        r1 = move-exception;
        com.kingroot.sdk.C0825fq.m2096a(r1);
        goto L_0x006c;
    L_0x0072:
        r0 = move-exception;
        goto L_0x0067;
    L_0x0074:
        r1 = move-exception;
        goto L_0x0057;
    L_0x0076:
        r0 = move-exception;
        r7 = r0;
        r0 = r1;
        r1 = r7;
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.fc.af(java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c2  */
    /* renamed from: b */
    private static int m2026b(com.kingroot.sdk.C0716ga r7, java.lang.String r8, java.lang.String r9) {
        /*
        r2 = -1;
        r1 = 0;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r0 = new java.io.File;
        r0.<init>(r8);
        r4 = r0.exists();
        if (r4 == 0) goto L_0x008d;
    L_0x0012:
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x0089 }
        r0 = r0.getAbsolutePath();	 Catch:{ Exception -> 0x0089 }
        r0 = com.kingroot.sdk.C0840gd.m2166W(r0);	 Catch:{ Exception -> 0x0089 }
        r4.<init>(r0);	 Catch:{ Exception -> 0x0089 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0089 }
        r0.<init>(r4);	 Catch:{ Exception -> 0x0089 }
    L_0x0024:
        r1 = "#!/system/bin/sh";
        r3.append(r1);
        r1 = new java.lang.StringBuilder;
        r4 = "\n";
        r1.<init>(r4);
        r1 = r1.append(r9);
        r4 = "\n";
        r1 = r1.append(r4);
        r1 = r1.toString();
        r3.append(r1);
        if (r0 == 0) goto L_0x00b6;
    L_0x0043:
        r1 = r0.length();
        if (r1 <= 0) goto L_0x00b6;
    L_0x0049:
        r0 = r0.toString();
        r1 = "\n";
        r1 = r0.split(r1);
        if (r1 == 0) goto L_0x005c;
    L_0x0055:
        r0 = r1.length;
        if (r0 <= 0) goto L_0x005c;
    L_0x0058:
        r0 = 0;
    L_0x0059:
        r4 = r1.length;
        if (r0 < r4) goto L_0x008f;
    L_0x005c:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c8 }
        r0.<init>();	 Catch:{ Exception -> 0x00c8 }
        r1 = com.kingroot.sdk.C0818fj.getFilesDir();	 Catch:{ Exception -> 0x00c8 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x00c8 }
        r1 = java.io.File.separator;	 Catch:{ Exception -> 0x00c8 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x00c8 }
        r1 = "sh.tmp";
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x00c8 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00c8 }
        r1 = r3.toString();	 Catch:{ Exception -> 0x00c8 }
        r1 = r1.getBytes();	 Catch:{ Exception -> 0x00c8 }
        com.kingroot.sdk.C0840gd.m2168a(r1, r0);	 Catch:{ Exception -> 0x00c8 }
        com.kingroot.sdk.C0807fc.m2021a(r7, r0, r8);	 Catch:{ Exception -> 0x00c8 }
        r0 = 1;
    L_0x0088:
        return r0;
    L_0x0089:
        r0 = move-exception;
        com.kingroot.sdk.C0825fq.m2096a(r0);
    L_0x008d:
        r0 = r1;
        goto L_0x0024;
    L_0x008f:
        r4 = r1[r0];
        r5 = "#!/system/bin/sh";
        r5 = r4.contains(r5);
        if (r5 != 0) goto L_0x00b3;
    L_0x0099:
        r5 = "/system/xbin/ku.sud";
        r5 = r4.contains(r5);
        if (r5 != 0) goto L_0x00b3;
    L_0x00a1:
        r5 = new java.lang.StringBuilder;
        r6 = "\n";
        r5.<init>(r6);
        r4 = r5.append(r4);
        r4 = r4.toString();
        r3.append(r4);
    L_0x00b3:
        r0 = r0 + 1;
        goto L_0x0059;
    L_0x00b6:
        r0 = r8.trim();
        r1 = "install-recovery-2.sh";
        r0 = r0.endsWith(r1);
        if (r0 != 0) goto L_0x005c;
    L_0x00c2:
        r0 = "\n/system/etc/install-recovery-2.sh\n";
        r3.append(r0);
        goto L_0x005c;
    L_0x00c8:
        r0 = move-exception;
        com.kingroot.sdk.C0825fq.m2096a(r0);
        r0 = r2;
        goto L_0x0088;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.fc.b(com.kingroot.sdk.ga, java.lang.String, java.lang.String):int");
    }

    /* renamed from: b */
    private static boolean m2027b(C0716ga c0716ga, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File("/system/bin/ddexe");
        File file2 = new File("/system/bin/ddexe_real");
        if (!file.exists() && !file2.exists()) {
            return false;
        }
        stringBuilder.append("#!/system/bin/sh\n");
        stringBuilder.append(new StringBuilder(String.valueOf(str)).append("\n\n").toString());
        stringBuilder.append("/system/bin/ddexe_real\n");
        try {
            String str2 = C0818fj.getFilesDir() + File.separator + "sh.tmp";
            C0840gd.m2168a(stringBuilder.toString().getBytes(), str2);
            C0807fc.m2021a(c0716ga, str2, "/system/bin/ddexe");
            return true;
        } catch (Throwable e) {
            C0825fq.m2096a(e);
            return false;
        }
    }

    /* renamed from: b */
    private boolean m2028b(String str, String str2, String str3) {
        this.f2051iV = false;
        this.f2052iW = false;
        this.f2053iX = false;
        this.f2051iV = C0807fc.m2030c(str, str2, str3);
        this.f2052iW = C0807fc.m2030c(str, "/system/etc/install-recovery-2.sh", "/system/etc/install-recovery-2.sh");
        this.f2053iX = C0807fc.m2030c("/system/etc/install-recovery-2.sh", str2, str3);
        return this.f2051iV ? this.f2052iW && this.f2053iX : (this.f2052iW && this.f2053iX && !Build.MODEL.equals("SM-N9002")) ? false : true;
    }

    /* renamed from: c */
    private static int m2029c(C0716ga c0716ga, String str, String str2) {
        StringBuilder stringBuilder;
        int i;
        int i2 = 0;
        StringBuilder stringBuilder2 = new StringBuilder();
        File file = new File(str);
        if (file.exists()) {
            try {
                stringBuilder = new StringBuilder(new String(C0840gd.m2166W(file.getAbsolutePath())));
                i = 0;
            } catch (Throwable e) {
                C0825fq.m2096a(e);
                stringBuilder = null;
                i = -1;
            }
        } else {
            stringBuilder = null;
            i = 0;
        }
        if (stringBuilder != null && stringBuilder.length() > 0) {
            String[] split = stringBuilder.toString().split("\n");
            if (split != null && split.length > 0) {
                for (String str3 : split) {
                    if (str3.contains(str2)) {
                        stringBuilder2.append("\n");
                        i2 = 1;
                    } else {
                        stringBuilder2.append("\n" + str3);
                    }
                }
            }
            if (i2 != 0) {
                try {
                    String str4 = C0818fj.getFilesDir() + File.separator + "sh.tmp";
                    C0840gd.m2168a(stringBuilder2.toString().getBytes(), str4);
                    C0807fc.m2021a(c0716ga, str4, str);
                    return 1;
                } catch (Throwable e2) {
                    C0825fq.m2096a(e2);
                    return -1;
                }
            }
        }
        return i;
    }

    /* renamed from: c */
    private static boolean m2030c(String str, String str2, String str3) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        String str4;
        try {
            str4 = new String(C0840gd.m2166W(file.getAbsolutePath()));
        } catch (Exception e) {
            e.printStackTrace();
            str4 = null;
        }
        if (str4 == null || str4.length() <= 0) {
            return false;
        }
        String[] split = str4.split("\n");
        if (split.length <= 0) {
            return false;
        }
        int i = 0;
        boolean z = false;
        for (String str5 : split) {
            if (str5.contains(str2)) {
                if (str5.trim().equals(str3)) {
                    z = true;
                }
                i++;
            }
        }
        return (i == 1 || !z) ? z : false;
    }

    /* renamed from: o */
    private static boolean m2031o(String str, String str2) {
        if (!new File(str).exists() && !new File("/system/bin/ddexe_real").exists()) {
            return true;
        }
        if (new File("/system/bin/ddexereal").exists() || !C0807fc.m2025af(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        String str3;
        try {
            str3 = new String(C0840gd.m2166W(file.getAbsolutePath()));
        } catch (Throwable e) {
            C0825fq.m2096a(e);
            str3 = null;
        }
        if (str3 == null || str3.length() <= 0) {
            return false;
        }
        String[] split = str3.split("\n");
        if (split.length <= 0) {
            return false;
        }
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < split.length; i2++) {
            if (split[i2].contains("/system/xbin/ku.sud")) {
                if (split[i2].trim().equals(str2)) {
                    z = true;
                }
                i++;
            }
        }
        return (i == 1 || !z) ? z : false;
    }

    /* renamed from: a */
    public boolean mo5804a(C0716ga c0716ga) {
        this.f2047iR = false;
        this.f2048iS = false;
        this.f2049iT = false;
        this.f2050iU = false;
        String str = "/system/xbin/ku.sud -d";
        String str2 = "/system/xbin/ku.sud -d &";
        this.f2047iR = !C0807fc.m2031o("/system/bin/ddexe", str2);
        if (!this.f2047iR) {
            C0799ex c0799ex = new C0799ex();
            c0799ex.f2016dZ = 0;
            c0799ex.f2017ea = 0;
            c0799ex.mode = 493;
            c0799ex.f2018eb = "u:object_r:system_file:s0";
            this.f2049iT = C0809fd.m2035a(c0716ga, "/system/bin/ddexe", c0799ex) != 0;
        }
        String g = C0804fb.m2018g(c0716ga);
        this.f2048iS = m2028b(g, str, str2);
        if (!this.f2048iS) {
            C0799ex c0799ex2 = new C0799ex();
            c0799ex2.f2016dZ = 0;
            c0799ex2.f2017ea = 0;
            c0799ex2.mode = 493;
            c0799ex2.f2018eb = "u:object_r:system_file:s0";
            List arrayList = new ArrayList();
            arrayList.add(g);
            arrayList.add("/system/etc/install-recovery-2.sh");
            this.f2050iU = C0809fd.m2036a(c0716ga, arrayList, c0799ex2);
        }
        return (this.f2047iR || this.f2048iS || this.f2049iT || this.f2050iU) ? false : true;
    }

    /* renamed from: b */
    public boolean mo5805b(C0716ga c0716ga) {
        boolean z = true;
        String str = "/system/xbin/ku.sud -d";
        String str2 = "/system/xbin/ku.sud -d &";
        if (this.f2047iR) {
            C0825fq.m2099g("check_su_files", "repair ddexe");
            z = m2023a(c0716ga, str2);
        } else if (this.f2049iT) {
            C0799ex c0799ex = new C0799ex();
            c0799ex.f2016dZ = 0;
            c0799ex.f2017ea = 0;
            c0799ex.mode = 493;
            c0799ex.f2018eb = "u:object_r:system_file:s0";
            C0809fd.m2037b(c0716ga, "/system/bin/ddexe", c0799ex);
        }
        String g = C0804fb.m2018g(c0716ga);
        if (this.f2048iS) {
            C0825fq.m2099g("check_su_files", "repair install-recovery.sh");
            return m2024a(c0716ga, g, str, str2);
        } else if (!this.f2050iU) {
            return z;
        } else {
            C0799ex c0799ex2 = new C0799ex();
            c0799ex2.f2016dZ = 0;
            c0799ex2.f2017ea = 0;
            c0799ex2.mode = 493;
            c0799ex2.f2018eb = "u:object_r:system_file:s0";
            List arrayList = new ArrayList();
            arrayList.add(g);
            arrayList.add("/system/etc/install-recovery-2.sh");
            C0809fd.m2038b(c0716ga, arrayList, c0799ex2);
            return z;
        }
    }
}
