package com.changefontmanager.sdk;

import com.changefontmanager.sdk.utils.CmdUtils;
import com.changefontmanager.sdk.utils.Constant;
import com.changefontmanager.sdk.utils.FileUtils;
import java.io.File;

public class NormalChangeFont3 {
    /* renamed from: A */
    private static String f1146A = "/system/fonts/";
    /* renamed from: B */
    private static String f1147B = (Constant.FOLDER_FONT + "backup/");
    private static int OTHER = 5;
    /* renamed from: o */
    private static int f1148o = 2097152;
    /* renamed from: p */
    private static int f1149p = 1;
    /* renamed from: q */
    private static int f1150q = 2;
    /* renamed from: r */
    private static int f1151r = 3;
    /* renamed from: s */
    private static int f1152s = 4;
    /* renamed from: C */
    private String f1153C = "/system/fonts/DroidSansFallback.ttf";
    /* renamed from: t */
    private int f1154t;

    public NormalChangeFont3() {
        CmdUtils.m960h("chmod 777 " + CmdUtils.f1158G + " \n");
        CmdUtils.m960h("busybox chmod 777 " + CmdUtils.f1158G + " \n");
        if (ChangeFontManager.getInstance().isLenovoLenovo()) {
            this.f1153C = "/system/fonts/FangZhengLTH.ttf";
        } else {
            this.f1153C = "/system/fonts/DroidSansFallback.ttf";
        }
    }

    /* renamed from: a */
    private static int m931a() {
        int i;
        File file;
        File file2 = new File(f1146A);
        File file3 = new File(f1147B);
        if (!file3.exists()) {
            file3.mkdirs();
        }
        int i2 = 0;
        File file4 = new File("/system/fonts/DroidSans.ttf");
        Object obj = 1;
        while (obj != null && i2 < 4) {
            i = i2 + 1;
            try {
                FileUtils.m966e(file4.getAbsolutePath(), f1147B + file4.getName());
                file = new File(f1147B + file4.getName());
                if (file.exists() && file4.length() == file.length()) {
                    obj = null;
                    i2 = i;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if ("src file is not exists".equals(e.toString())) {
                    break;
                } else if (!"IO Exception".equals(e.toString())) {
                    file3.deleteOnExit();
                    return -1;
                }
            }
            i2 = i;
        }
        for (File file5 : file2.listFiles()) {
            if (file5.length() > ((long) f1148o)) {
                obj = 1;
                i2 = 0;
                while (obj != null && i2 < 4) {
                    i = i2 + 1;
                    try {
                        FileUtils.m966e(file5.getAbsolutePath(), f1147B + file5.getName());
                        file = new File(f1147B + file5.getName());
                        if (file.exists() && file5.length() == file.length()) {
                            obj = null;
                            i2 = i;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if ("src file is not exists".equals(e2.toString())) {
                            i2 = i;
                            break;
                        } else if (!"IO Exception".equals(e2.toString())) {
                            file3.deleteOnExit();
                            return -1;
                        }
                    }
                    i2 = i;
                }
                if (obj != null && r0 == 4) {
                    file3.deleteOnExit();
                    return -1;
                }
            }
        }
        return 0;
    }

    /* renamed from: a */
    private boolean m932a(String str, String str2, String str3) {
        boolean z;
        File file = new File(str);
        File file2 = new File(str2);
        if (!file.exists() || !file2.exists()) {
            FileUtils.m967j("src = " + file.exists() + " +++ des = " + file2.exists());
            z = false;
        } else if (file.length() == file2.length()) {
            z = true;
        } else {
            FileUtils.m967j(" copy error");
            z = false;
        }
        if (!z) {
            return false;
        }
        if (CmdUtils.m960h(CmdUtils.f1158G + " mv " + str2 + " " + str3) || CmdUtils.m960h("rename " + str2 + " " + str3) || !CmdUtils.m960h("mv " + str2 + " " + str3)) {
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m933b(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        if (!file.exists() || !file2.exists()) {
            FileUtils.m967j("src = " + file.exists() + " +++ des = " + file2.exists());
            return false;
        } else if (file.length() == file2.length()) {
            return true;
        } else {
            FileUtils.m967j(" copy error");
            return false;
        }
    }

    /* renamed from: c */
    private boolean m934c(String str) {
        if (!m937d(str, "/system/fonts/hifont.ttf")) {
            m936d("/system/fonts/hifont.ttf");
            return false;
        } else if (m938e()) {
            return true;
        } else {
            m936d("/system/fonts/hifont.ttf");
            return false;
        }
    }

    /* renamed from: c */
    private boolean m935c(String str, String str2) {
        String str3 = f1146A + "temp.ttf";
        if (!(CmdUtils.m960h(CmdUtils.f1158G + " cp -f " + str + " " + str3) || CmdUtils.m960h("cp -f " + str + " " + str3) || CmdUtils.m960h("cat " + str + " > " + str3) || CmdUtils.m960h("dd if=" + str + " of=" + str3) || CmdUtils.m960h("busybox cp -f " + str + " " + str3))) {
            try {
                FileUtils.m966e(str, str3);
            } catch (Exception e) {
                e.printStackTrace();
                m936d(str3);
                return false;
            }
        }
        if (!CmdUtils.m960h(CmdUtils.f1158G + " chmod 644 " + str3) && !CmdUtils.m960h("chmod 644 " + str3)) {
            m936d(str3);
            return false;
        } else if (m932a(str, str3, str2)) {
            if (!CmdUtils.m960h(CmdUtils.f1158G + " rm -r " + str3)) {
                CmdUtils.m960h("rm -r " + str3);
            }
            return true;
        } else {
            m936d(str3);
            return false;
        }
    }

    /* renamed from: d */
    private static boolean m936d(String str) {
        if (!CmdUtils.m960h(CmdUtils.f1158G + " rm -r " + str)) {
            CmdUtils.m960h("rm -r " + str);
        }
        return true;
    }

    /* renamed from: d */
    private boolean m937d(String str, String str2) {
        if (!(CmdUtils.m960h(CmdUtils.f1158G + " cp -f " + str + " " + str2) || CmdUtils.m960h("cp -f " + str + " " + str2) || CmdUtils.m960h("cat " + str + " > " + str2) || CmdUtils.m960h("dd if=" + str + " of=" + str2) || CmdUtils.m960h("busybox cp -f " + str + " " + str2))) {
            try {
                FileUtils.m966e(str, str2);
            } catch (Exception e) {
                e.printStackTrace();
                m936d(str2);
                return false;
            }
        }
        return CmdUtils.m960h(new StringBuilder(String.valueOf(CmdUtils.f1158G)).append(" chmod 644 ").append(str2).toString()) || CmdUtils.m960h("chmod 644 " + str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x015a A:{SYNTHETIC, Splitter: B:44:0x015a} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x015f A:{Catch:{ IOException -> 0x0164 }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x016e A:{SYNTHETIC, Splitter: B:54:0x016e} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0173 A:{Catch:{ IOException -> 0x0177 }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x015a A:{SYNTHETIC, Splitter: B:44:0x015a} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x015f A:{Catch:{ IOException -> 0x0164 }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x016e A:{SYNTHETIC, Splitter: B:54:0x016e} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0173 A:{Catch:{ IOException -> 0x0177 }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x016e A:{SYNTHETIC, Splitter: B:54:0x016e} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0173 A:{Catch:{ IOException -> 0x0177 }} */
    /* renamed from: e */
    private boolean m938e() {
        /*
        r12 = this;
        r3 = 0;
        r0 = 1;
        r1 = 0;
        r5 = "/system/etc/fallback_fonts.xml";
        r2 = new java.lang.StringBuilder;
        r4 = com.changefontmanager.sdk.utils.Constant.FOLDER_FONT;
        r4 = java.lang.String.valueOf(r4);
        r2.<init>(r4);
        r4 = "fallback_fonts_temp.xml";
        r2 = r2.append(r4);
        r6 = r2.toString();
        r7 = "/system/etc/fallback_fonts_temp.xml";
        r8 = "\t<family>\r\n\t\t<fileset>\r\n\t\t\t<file>hifont.ttf</file>\r\n\t\t</fileset>\r\n\t</family>\r\n";
        r4 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0153, all -> 0x0169 }
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0153, all -> 0x0169 }
        r2.<init>(r5);	 Catch:{ Exception -> 0x0153, all -> 0x0169 }
        r4.<init>(r2);	 Catch:{ Exception -> 0x0153, all -> 0x0169 }
        r9 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0234, all -> 0x0229 }
        r9.<init>(r4);	 Catch:{ Exception -> 0x0234, all -> 0x0229 }
        r2 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0234, all -> 0x0229 }
        r2.<init>(r9);	 Catch:{ Exception -> 0x0234, all -> 0x0229 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r3.<init>();	 Catch:{ Exception -> 0x0239, all -> 0x022d }
    L_0x0037:
        r9 = r2.readLine();	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        if (r9 != 0) goto L_0x011e;
    L_0x003d:
        r3 = r3.toString();	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r9 = com.changefontmanager.sdk.utils.Constant.FOLDER_FONT;	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r8.<init>(r9);	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r9 = r8.exists();	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        if (r9 != 0) goto L_0x0051;
    L_0x004e:
        r8.mkdirs();	 Catch:{ Exception -> 0x0239, all -> 0x022d }
    L_0x0051:
        r8 = new java.io.File;	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r8.<init>(r6);	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r9 = r8.exists();	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        if (r9 != 0) goto L_0x005f;
    L_0x005c:
        r8.createNewFile();	 Catch:{ Exception -> 0x0239, all -> 0x022d }
    L_0x005f:
        r9 = new java.io.FileWriter;	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r10 = 0;
        r9.<init>(r8, r10);	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r9.write(r3);	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r9.flush();	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r9.close();	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r4.close();	 Catch:{ IOException -> 0x017c }
        r2.close();	 Catch:{ IOException -> 0x017c }
    L_0x0074:
        r2 = new java.lang.StringBuilder;
        r3 = com.changefontmanager.sdk.utils.CmdUtils.f1158G;
        r3 = java.lang.String.valueOf(r3);
        r2.<init>(r3);
        r3 = " cp -f ";
        r2 = r2.append(r3);
        r2 = r2.append(r6);
        r3 = " ";
        r2 = r2.append(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r2 = com.changefontmanager.sdk.utils.CmdUtils.m960h(r2);
        if (r2 != 0) goto L_0x0182;
    L_0x009d:
        r2 = new java.lang.StringBuilder;
        r3 = "cp -f ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r3 = " ";
        r2 = r2.append(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r2 = com.changefontmanager.sdk.utils.CmdUtils.m960h(r2);
        if (r2 != 0) goto L_0x0182;
    L_0x00bc:
        r2 = new java.lang.StringBuilder;
        r3 = "cat ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r3 = " > ";
        r2 = r2.append(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r2 = com.changefontmanager.sdk.utils.CmdUtils.m960h(r2);
        if (r2 != 0) goto L_0x0182;
    L_0x00db:
        r2 = new java.lang.StringBuilder;
        r3 = "dd if=";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r3 = " of=";
        r2 = r2.append(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r2 = com.changefontmanager.sdk.utils.CmdUtils.m960h(r2);
        if (r2 != 0) goto L_0x0182;
    L_0x00fa:
        r2 = new java.lang.StringBuilder;
        r3 = "busybox cp -f ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r3 = " ";
        r2 = r2.append(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r2 = com.changefontmanager.sdk.utils.CmdUtils.m960h(r2);
        if (r2 != 0) goto L_0x0182;
    L_0x0119:
        m936d(r7);
        r0 = r1;
    L_0x011d:
        return r0;
    L_0x011e:
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r11 = java.lang.String.valueOf(r9);	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r10.<init>(r11);	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r11 = "\r\n";
        r10 = r10.append(r11);	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r10 = r10.toString();	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r3.append(r10);	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        r10 = "<familyset>";
        r10 = r10.equals(r9);	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        if (r10 == 0) goto L_0x013f;
    L_0x013c:
        r3.append(r8);	 Catch:{ Exception -> 0x0239, all -> 0x022d }
    L_0x013f:
        r10 = "hifont.ttf";
        r9 = r9.contains(r10);	 Catch:{ Exception -> 0x0239, all -> 0x022d }
        if (r9 == 0) goto L_0x0037;
    L_0x0147:
        r4.close();	 Catch:{ IOException -> 0x014e }
        r2.close();	 Catch:{ IOException -> 0x014e }
        goto L_0x011d;
    L_0x014e:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x011d;
    L_0x0153:
        r0 = move-exception;
        r2 = r3;
    L_0x0155:
        r0.printStackTrace();	 Catch:{ all -> 0x0230 }
        if (r3 == 0) goto L_0x015d;
    L_0x015a:
        r3.close();	 Catch:{ IOException -> 0x0164 }
    L_0x015d:
        if (r2 == 0) goto L_0x0162;
    L_0x015f:
        r2.close();	 Catch:{ IOException -> 0x0164 }
    L_0x0162:
        r0 = r1;
        goto L_0x011d;
    L_0x0164:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0162;
    L_0x0169:
        r0 = move-exception;
        r2 = r3;
        r4 = r3;
    L_0x016c:
        if (r4 == 0) goto L_0x0171;
    L_0x016e:
        r4.close();	 Catch:{ IOException -> 0x0177 }
    L_0x0171:
        if (r2 == 0) goto L_0x0176;
    L_0x0173:
        r2.close();	 Catch:{ IOException -> 0x0177 }
    L_0x0176:
        throw r0;
    L_0x0177:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0176;
    L_0x017c:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x0074;
    L_0x0182:
        r2 = new java.lang.StringBuilder;
        r3 = com.changefontmanager.sdk.utils.CmdUtils.f1158G;
        r3 = java.lang.String.valueOf(r3);
        r2.<init>(r3);
        r3 = " chmod 644 ";
        r2 = r2.append(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r2 = com.changefontmanager.sdk.utils.CmdUtils.m960h(r2);
        if (r2 != 0) goto L_0x01b9;
    L_0x01a1:
        r2 = new java.lang.StringBuilder;
        r3 = "chmod 644 ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r2 = com.changefontmanager.sdk.utils.CmdUtils.m960h(r2);
        if (r2 != 0) goto L_0x01b9;
    L_0x01b6:
        r0 = r1;
        goto L_0x011d;
    L_0x01b9:
        r2 = r12.m932a(r6, r7, r5);
        if (r2 != 0) goto L_0x01c5;
    L_0x01bf:
        m936d(r7);
        r0 = r1;
        goto L_0x011d;
    L_0x01c5:
        r1 = new java.lang.StringBuilder;
        r2 = com.changefontmanager.sdk.utils.CmdUtils.f1158G;
        r2 = java.lang.String.valueOf(r2);
        r1.<init>(r2);
        r2 = " rm -r ";
        r1 = r1.append(r2);
        r1 = r1.append(r7);
        r1 = r1.toString();
        r1 = com.changefontmanager.sdk.utils.CmdUtils.m960h(r1);
        if (r1 != 0) goto L_0x01f6;
    L_0x01e4:
        r1 = new java.lang.StringBuilder;
        r2 = "rm -r ";
        r1.<init>(r2);
        r1 = r1.append(r7);
        r1 = r1.toString();
        com.changefontmanager.sdk.utils.CmdUtils.m960h(r1);
    L_0x01f6:
        r1 = new java.lang.StringBuilder;
        r2 = com.changefontmanager.sdk.utils.CmdUtils.f1158G;
        r2 = java.lang.String.valueOf(r2);
        r1.<init>(r2);
        r2 = " rm -r ";
        r1 = r1.append(r2);
        r1 = r1.append(r6);
        r1 = r1.toString();
        r1 = com.changefontmanager.sdk.utils.CmdUtils.m960h(r1);
        if (r1 != 0) goto L_0x011d;
    L_0x0215:
        r1 = new java.lang.StringBuilder;
        r2 = "rm -r ";
        r1.<init>(r2);
        r1 = r1.append(r6);
        r1 = r1.toString();
        com.changefontmanager.sdk.utils.CmdUtils.m960h(r1);
        goto L_0x011d;
    L_0x0229:
        r0 = move-exception;
        r2 = r3;
        goto L_0x016c;
    L_0x022d:
        r0 = move-exception;
        goto L_0x016c;
    L_0x0230:
        r0 = move-exception;
        r4 = r3;
        goto L_0x016c;
    L_0x0234:
        r0 = move-exception;
        r2 = r3;
        r3 = r4;
        goto L_0x0155;
    L_0x0239:
        r0 = move-exception;
        r3 = r4;
        goto L_0x0155;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.changefontmanager.sdk.NormalChangeFont3.e():boolean");
    }

    /* renamed from: f */
    private static boolean m939f() {
        if (!CmdUtils.m960h(CmdUtils.f1158G + " rm -r /system/fonts/hifont.ttf")) {
            CmdUtils.m960h("rm -r /system/fonts/hifont.ttf");
        }
        return true;
    }

    /* renamed from: g */
    private boolean m940g() {
        return CmdUtils.m960h(new StringBuilder(String.valueOf(CmdUtils.f1158G)).append(" ").append(CmdUtils.f1156E).toString()) || CmdUtils.m960h(CmdUtils.f1155D) || CmdUtils.m960h(CmdUtils.f1156E) || CmdUtils.m960h(CmdUtils.f1157F);
    }

    /* renamed from: a */
    public final int mo5302a(String str, String str2) {
        int i = 0;
        int i2 = (CmdUtils.m960h(new StringBuilder(String.valueOf(CmdUtils.f1158G)).append(" ").append(CmdUtils.f1156E).toString()) || CmdUtils.m960h(CmdUtils.f1155D) || CmdUtils.m960h(CmdUtils.f1156E) || CmdUtils.m960h(CmdUtils.f1157F)) ? 1 : 0;
        if (i2 == 0) {
            return 2;
        }
        boolean c = (str2 == null || "".equals(str2)) ? false : ChangeFontManager.getInstance().isSdkGreaterThanApi14() ? m935c(str2, "/system/fonts/Roboto-Regular.ttf") : m935c(str2, "/system/fonts/DroidSans.ttf");
        if (!(str == null || "".equals(str))) {
            boolean c2 = m935c(str, this.f1153C);
            if (!m937d(str, "/system/fonts/hifont.ttf")) {
                m936d("/system/fonts/hifont.ttf");
                i2 = 0;
            } else if (m938e()) {
                i2 = 1;
            } else {
                m936d("/system/fonts/hifont.ttf");
                i2 = 0;
            }
            if (c2 || r2 != 0) {
                i = 1;
            }
        }
        return (i == 0 || !c) ? (i == 0 || c) ? (i == 0 && c) ? 4 : -1 : 3 : 1;
    }

    /* renamed from: a */
    public final boolean mo5303a(String str) {
        return (str == null || "".equals(str)) ? false : ChangeFontManager.getInstance().isSdkGreaterThanApi14() ? m935c(str, "/system/fonts/Roboto-Regular.ttf") : m935c(str, "/system/fonts/DroidSans.ttf");
    }

    /* renamed from: b */
    public final boolean mo5304b(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        boolean z;
        boolean c = m935c(str, this.f1153C);
        if (!m937d(str, "/system/fonts/hifont.ttf")) {
            m936d("/system/fonts/hifont.ttf");
            z = false;
        } else if (m938e()) {
            z = true;
        } else {
            m936d("/system/fonts/hifont.ttf");
            z = false;
        }
        return c || z;
    }
}
