package com.kingroot.sdk;

import android.content.Context;
import com.kingroot.sdk.util.C0886f;
import java.io.File;
import krsdk.IShell;
import krsdk.RootConfig;
import krsdk.RootShell;
import krsdk.RootShell.ShellResult;

/* renamed from: com.kingroot.sdk.cz */
public class C0731cz extends C0730do implements RootShell {
    /* renamed from: fc */
    public static String f1780fc;
    /* renamed from: fb */
    private int f1781fb = 0;

    public C0731cz(C0638av c0638av) {
        this.f1779fK = c0638av;
        this.f1730ej = 2;
    }

    /* renamed from: a */
    public static void m1765a(String str, IShell iShell) {
        iShell.executeCommand("chmod 6755 " + str);
        iShell.executeCommand("chown 0.0 " + str);
        C0633at.m1464h("start kd : ");
        iShell.executeCommand(str + " -d " + new File(C0741dg.m1804aL().f1806em.workingDir, "krsdk.cert").getAbsolutePath());
        f1780fc = str;
    }

    /* renamed from: a */
    public static boolean m1766a(String str, RootShell rootShell) {
        C0886f.clean();
        rootShell.executeCommand2("chmod 6755 " + str);
        rootShell.executeCommand2("chown 0.0 " + str);
        C0633at.m1464h("start kd : ");
        ShellResult executeCommand2 = rootShell.executeCommand2(str + " -d " + new File(C0741dg.m1804aL().f1806em.workingDir, "krsdk.cert").getAbsolutePath());
        if (executeCommand2.success()) {
            f1780fc = str;
            return true;
        }
        C0886f.set(7017, "ret=" + executeCommand2.ret + ",stdout=" + executeCommand2.stdout);
        return false;
    }

    /* renamed from: aJ */
    public static String m1767aJ() {
        if (f1780fc != null && f1780fc.length() > 0) {
            return f1780fc;
        }
        RootConfig rootConfig = C0741dg.m1804aL().f1806em;
        if (rootConfig == null) {
            return null;
        }
        return rootConfig.mo8167a("kd");
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01ae A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x016f A:{LOOP_END, LOOP:0: B:1:0x002f->B:50:0x016f} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x016f A:{LOOP_END, LOOP:0: B:1:0x002f->B:50:0x016f} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01ae A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01ae A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x016f A:{LOOP_END, LOOP:0: B:1:0x002f->B:50:0x016f} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x016f A:{LOOP_END, LOOP:0: B:1:0x002f->B:50:0x016f} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01ae A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01ae A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x016f A:{LOOP_END, LOOP:0: B:1:0x002f->B:50:0x016f} */
    /* renamed from: b */
    public static com.kingroot.sdk.C0731cz m1768b(java.lang.String r11, int r12) {
        /*
        r0 = 0;
        r6 = 1;
        r1 = 0;
        com.kingroot.sdk.util.C0886f.clean();
        r2 = com.kingroot.sdk.C0741dg.m1804aL();
        r2 = r2.f1805el;
        r7 = com.kingroot.sdk.C0731cz.m1770x(r2);
        r2 = new java.lang.StringBuilder;
        r3 = "获取到保存的KD路径 : ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r3 = ", 默认的KD路径 : ";
        r2 = r2.append(r3);
        r2 = r2.append(r11);
        r2 = r2.toString();
        com.kingroot.sdk.C0633at.m1464h(r2);
        r2 = r0;
        r3 = r0;
        r0 = r1;
    L_0x002f:
        r0 = r0 + 1;
        r4 = new com.kingroot.sdk.av;	 Catch:{ Exception -> 0x01a3 }
        r4.<init>(r11);	 Catch:{ Exception -> 0x01a3 }
        r2 = "id";
        r8 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r2 = r4.mo5606b(r2, r8);	 Catch:{ Exception -> 0x01a9 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01a9 }
        r8 = "getKDRootShell() ret = ";
        r5.<init>(r8);	 Catch:{ Exception -> 0x01a9 }
        r8 = r2.f1587cu;	 Catch:{ Exception -> 0x01a9 }
        r5 = r5.append(r8);	 Catch:{ Exception -> 0x01a9 }
        r8 = ", stdout = ";
        r5 = r5.append(r8);	 Catch:{ Exception -> 0x01a9 }
        r8 = r2.f1585cs;	 Catch:{ Exception -> 0x01a9 }
        r5 = r5.append(r8);	 Catch:{ Exception -> 0x01a9 }
        r8 = ", stderr = ";
        r5 = r5.append(r8);	 Catch:{ Exception -> 0x01a9 }
        r8 = r2.f1586ct;	 Catch:{ Exception -> 0x01a9 }
        r5 = r5.append(r8);	 Catch:{ Exception -> 0x01a9 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x01a9 }
        com.kingroot.sdk.C0633at.m1465i(r5);	 Catch:{ Exception -> 0x01a9 }
        r5 = r2.f1587cu;	 Catch:{ Exception -> 0x01a9 }
        r5 = r5.intValue();	 Catch:{ Exception -> 0x01a9 }
        if (r5 != 0) goto L_0x008b;
    L_0x0072:
        r5 = r2.f1585cs;	 Catch:{ Exception -> 0x01a9 }
        r5 = com.kingroot.sdk.C0719cs.m1731L(r5);	 Catch:{ Exception -> 0x01a9 }
        if (r5 == 0) goto L_0x008b;
    L_0x007a:
        r5 = new com.kingroot.sdk.cz;	 Catch:{ Exception -> 0x01a9 }
        r5.<init>(r4);	 Catch:{ Exception -> 0x01a9 }
        r5.f1781fb = r0;	 Catch:{ Exception -> 0x014a }
        f1780fc = r11;	 Catch:{ Exception -> 0x014a }
    L_0x0083:
        if (r5 == 0) goto L_0x008a;
    L_0x0085:
        r0 = "cd /";
        r5.executeCommand(r0);	 Catch:{ Exception -> 0x0198 }
    L_0x008a:
        return r5;
    L_0x008b:
        r4.shutdown();	 Catch:{ Exception -> 0x01a9 }
        if (r7 == 0) goto L_0x0118;
    L_0x0090:
        r5 = r7.equals(r11);	 Catch:{ Exception -> 0x01a9 }
        if (r5 != 0) goto L_0x0118;
    L_0x0096:
        r2 = r6;
        r5 = r3;
    L_0x0098:
        if (r2 == 0) goto L_0x01b1;
    L_0x009a:
        r2 = new java.lang.StringBuilder;
        r3 = "尝试另一个KD : ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        com.kingroot.sdk.C0633at.m1464h(r2);
        r3 = new com.kingroot.sdk.av;	 Catch:{ Exception -> 0x0188 }
        r3.<init>(r7);	 Catch:{ Exception -> 0x0188 }
        r2 = "export PATH=/sbin:/vendor/bin:/system/sbin:/system/bin:/system/xbin:$PATH";
        r3.mo5609t(r2);	 Catch:{ Exception -> 0x019e }
        r2 = "id";
        r8 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r2 = r3.mo5606b(r2, r8);	 Catch:{ Exception -> 0x019e }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x019e }
        r8 = "getKDRootShell() realPath ret = ";
        r4.<init>(r8);	 Catch:{ Exception -> 0x019e }
        r8 = r2.f1587cu;	 Catch:{ Exception -> 0x019e }
        r4 = r4.append(r8);	 Catch:{ Exception -> 0x019e }
        r8 = ", stdout = ";
        r4 = r4.append(r8);	 Catch:{ Exception -> 0x019e }
        r8 = r2.f1585cs;	 Catch:{ Exception -> 0x019e }
        r4 = r4.append(r8);	 Catch:{ Exception -> 0x019e }
        r8 = ", stderr = ";
        r4 = r4.append(r8);	 Catch:{ Exception -> 0x019e }
        r8 = r2.f1586ct;	 Catch:{ Exception -> 0x019e }
        r4 = r4.append(r8);	 Catch:{ Exception -> 0x019e }
        r4 = r4.toString();	 Catch:{ Exception -> 0x019e }
        com.kingroot.sdk.C0633at.m1465i(r4);	 Catch:{ Exception -> 0x019e }
        r4 = r2.f1587cu;	 Catch:{ Exception -> 0x019e }
        r4 = r4.intValue();	 Catch:{ Exception -> 0x019e }
        if (r4 != 0) goto L_0x016b;
    L_0x00f2:
        r2 = r2.f1585cs;	 Catch:{ Exception -> 0x019e }
        r2 = com.kingroot.sdk.C0719cs.m1731L(r2);	 Catch:{ Exception -> 0x019e }
        if (r2 == 0) goto L_0x016b;
    L_0x00fa:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x019e }
        r4 = "另一个KD成功连接 : ";
        r2.<init>(r4);	 Catch:{ Exception -> 0x019e }
        r2 = r2.append(r7);	 Catch:{ Exception -> 0x019e }
        r2 = r2.toString();	 Catch:{ Exception -> 0x019e }
        com.kingroot.sdk.C0633at.m1464h(r2);	 Catch:{ Exception -> 0x019e }
        r4 = new com.kingroot.sdk.cz;	 Catch:{ Exception -> 0x019e }
        r4.<init>(r3);	 Catch:{ Exception -> 0x019e }
        r4.f1781fb = r0;	 Catch:{ Exception -> 0x01a1 }
        f1780fc = r7;	 Catch:{ Exception -> 0x01a1 }
        r5 = r4;
        goto L_0x0083;
    L_0x0118:
        r5 = 7018; // 0x1b6a float:9.834E-42 double:3.4674E-320;
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01a9 }
        r9 = "ret=";
        r8.<init>(r9);	 Catch:{ Exception -> 0x01a9 }
        r9 = r2.f1587cu;	 Catch:{ Exception -> 0x01a9 }
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x01a9 }
        r9 = ",stdout=";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x01a9 }
        r9 = r2.f1585cs;	 Catch:{ Exception -> 0x01a9 }
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x01a9 }
        r9 = ",stdout=";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x01a9 }
        r2 = r2.f1586ct;	 Catch:{ Exception -> 0x01a9 }
        r2 = r8.append(r2);	 Catch:{ Exception -> 0x01a9 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x01a9 }
        com.kingroot.sdk.util.C0886f.set(r5, r2);	 Catch:{ Exception -> 0x01a9 }
        r2 = r1;
        r5 = r3;
        goto L_0x0098;
    L_0x014a:
        r2 = move-exception;
        r3 = r4;
        r4 = r5;
    L_0x014d:
        r5 = "VirtualTerminal create fail";
        com.kingroot.sdk.C0633at.m1458a(r5, r2);
        r5 = 7019; // 0x1b6b float:9.836E-42 double:3.468E-320;
        r8 = "";
        com.kingroot.sdk.util.C0886f.set(r5, r8, r2);
        if (r3 == 0) goto L_0x015e;
    L_0x015b:
        r3.shutdown();
    L_0x015e:
        if (r7 == 0) goto L_0x01b4;
    L_0x0160:
        r2 = r7.equals(r11);
        if (r2 != 0) goto L_0x01b4;
    L_0x0166:
        r2 = r6;
        r5 = r4;
        r4 = r3;
        goto L_0x0098;
    L_0x016b:
        r2 = r3;
        r3 = r5;
    L_0x016d:
        if (r0 > r12) goto L_0x01ae;
    L_0x016f:
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        com.kingroot.sdk.util.C0889i.m2429f(r4);
        r4 = new java.lang.StringBuilder;
        r5 = "try again to get kd shell. i = ";
        r4.<init>(r5);
        r4 = r4.append(r0);
        r4 = r4.toString();
        com.kingroot.sdk.C0633at.m1464h(r4);
        goto L_0x002f;
    L_0x0188:
        r2 = move-exception;
        r3 = r4;
        r4 = r5;
    L_0x018b:
        r5 = "VirtualTerminal create2 fail";
        com.kingroot.sdk.C0633at.m1458a(r5, r2);
        if (r3 == 0) goto L_0x0195;
    L_0x0192:
        r3.shutdown();
    L_0x0195:
        r2 = r3;
        r3 = r4;
        goto L_0x016d;
    L_0x0198:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x008a;
    L_0x019e:
        r2 = move-exception;
        r4 = r5;
        goto L_0x018b;
    L_0x01a1:
        r2 = move-exception;
        goto L_0x018b;
    L_0x01a3:
        r4 = move-exception;
        r10 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r10;
        goto L_0x014d;
    L_0x01a9:
        r2 = move-exception;
        r10 = r4;
        r4 = r3;
        r3 = r10;
        goto L_0x014d;
    L_0x01ae:
        r5 = r3;
        goto L_0x0083;
    L_0x01b1:
        r2 = r4;
        r3 = r5;
        goto L_0x016d;
    L_0x01b4:
        r2 = r1;
        r5 = r4;
        r4 = r3;
        goto L_0x0098;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.cz.b(java.lang.String, int):com.kingroot.sdk.cz");
    }

    /* renamed from: n */
    public static void m1769n(Context context, String str) {
        C0739de.m1795a(context, "REAL_KD_PATH", str);
    }

    /* renamed from: x */
    public static String m1770x(Context context) {
        String p = C0739de.m1802p(context, "REAL_KD_PATH");
        if (!(p == null || "".equals(p))) {
            File file = new File(p);
            if (file.exists() && file.length() > 0) {
                return p;
            }
            C0739de.m1801o(context, "REAL_KD_PATH");
        }
        return null;
    }

    /* renamed from: aI */
    public int mo5707aI() {
        return this.f1781fb;
    }
}
