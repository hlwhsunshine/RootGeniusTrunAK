package krsdk;

import android.content.Context;
import com.kingroot.sdk.C0633at;
import com.kingroot.sdk.C0634au;
import com.kingroot.sdk.C0737dc;
import com.kingroot.sdk.C0741dg;
import com.kingroot.sdk.util.C0886f;
import com.kingroot.sdk.util.C0889i;
import com.kingroot.sdk.util.C0900t;
import java.io.File;
import krsdk.RootShell.ShellResult;

/* renamed from: krsdk.a */
public class C1773a {
    /* renamed from: ks */
    private static final Object f5195ks = new Object();
    /* renamed from: kt */
    private static Integer f5196kt = Integer.valueOf(-1);

    /* renamed from: a */
    public static int m4823a(RootShell rootShell, int i) {
        int i2 = 1;
        if (rootShell != null) {
            i2 = rootShell.getShellType() != 4 ? 2 : (i != 1 || rootShell.isKuInstalled()) ? !C1773a.m4828e(rootShell) ? 4 : 0 : 3;
        }
        C0633at.m1464h("isFullyKuSuMount = " + i2);
        return i2;
    }

    /* renamed from: a */
    public static boolean m4824a(Context context, RootShell rootShell) {
        String str;
        String str2;
        if (C0634au.m1468I() >= 21) {
            str = "/system/app/Kinguser/Kinguser.apk";
            str2 = "pm install -r -d " + str;
        } else if (C0634au.m1468I() < 17 || C0634au.m1468I() > 20) {
            str = "/system/app/Kinguser.apk";
            str2 = "pm install -r " + str;
        } else {
            str = "/system/app/Kinguser.apk";
            str2 = "pm install -r -d " + str;
        }
        ShellResult exists = new File(str).exists();
        if (exists != null) {
            try {
                C0737dc.m1791y(context);
                exists = rootShell.executeCommand2(str2);
                C0633at.m1464h("cmd: " + str2 + ", ret = " + exists.ret + ", stdout = " + exists.stdout);
                if (exists != null && exists.stdout != null && exists.stdout.contains("Success")) {
                    return true;
                }
                C0633at.m1467s("ku install FAIL?!");
                return false;
            } finally {
                C0737dc.m1790A(context);
            }
        } else {
            C0633at.m1467s("ku.apk NOT exists!");
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007c  */
    /* renamed from: cr */
    public static boolean m4825cr() {
        /*
        r0 = 0;
        r3 = 0;
        r2 = new com.kingroot.sdk.av;	 Catch:{ Exception -> 0x006d, all -> 0x0078 }
        r1 = "sh";
        r2.<init>(r1);	 Catch:{ Exception -> 0x006d, all -> 0x0078 }
        r1 = "export PATH=/sbin:/vendor/bin:/system/sbin:/system/bin:/system/xbin:$PATH";
        r2.mo5609t(r1);	 Catch:{ Exception -> 0x0082 }
        r1 = "pm path com.kingroot.kinguser";
        r4 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r1 = r2.mo5606b(r1, r4);	 Catch:{ Exception -> 0x0082 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0082 }
        r4 = "cmd: pm path com.kingroot.kinguser, ret = ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x0082 }
        r4 = r1.f1587cu;	 Catch:{ Exception -> 0x0082 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0082 }
        r4 = ", stdout = ";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0082 }
        r4 = r1.f1585cs;	 Catch:{ Exception -> 0x0082 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0082 }
        r4 = ", stderr = ";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0082 }
        r4 = r1.f1586ct;	 Catch:{ Exception -> 0x0082 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0082 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0082 }
        com.kingroot.sdk.C0633at.m1464h(r3);	 Catch:{ Exception -> 0x0082 }
        r3 = r1.success();	 Catch:{ Exception -> 0x0082 }
        if (r3 == 0) goto L_0x0057;
    L_0x0048:
        r3 = r1.f1585cs;	 Catch:{ Exception -> 0x0082 }
        if (r3 == 0) goto L_0x0057;
    L_0x004c:
        r1 = r1.f1585cs;	 Catch:{ Exception -> 0x0082 }
        r3 = "package:";
        r1 = r1.contains(r3);	 Catch:{ Exception -> 0x0082 }
        if (r1 == 0) goto L_0x0057;
    L_0x0056:
        r0 = 1;
    L_0x0057:
        r2.shutdown();
    L_0x005a:
        r1 = new java.lang.StringBuilder;
        r2 = "checkKuPackageInstalled = ";
        r1.<init>(r2);
        r1 = r1.append(r0);
        r1 = r1.toString();
        com.kingroot.sdk.C0633at.m1465i(r1);
        return r0;
    L_0x006d:
        r1 = move-exception;
        r2 = r3;
    L_0x006f:
        r1.printStackTrace();	 Catch:{ all -> 0x0080 }
        if (r2 == 0) goto L_0x005a;
    L_0x0074:
        r2.shutdown();
        goto L_0x005a;
    L_0x0078:
        r0 = move-exception;
        r2 = r3;
    L_0x007a:
        if (r2 == 0) goto L_0x007f;
    L_0x007c:
        r2.shutdown();
    L_0x007f:
        throw r0;
    L_0x0080:
        r0 = move-exception;
        goto L_0x007a;
    L_0x0082:
        r1 = move-exception;
        goto L_0x006f;
        */
        throw new UnsupportedOperationException("Method not decompiled: krsdk.a.cr():boolean");
    }

    /* renamed from: cs */
    public static boolean m4826cs() {
        boolean z = true;
        synchronized (f5195ks) {
            if (f5196kt.intValue() == -1) {
                if (C0634au.m1468I() >= 20) {
                    String property = System.getProperty("java.library.path", "");
                    f5196kt = Integer.valueOf(property.contains("/system/lib64") ? 1 : 0);
                    C0633at.m1463g("path : " + property);
                } else {
                    f5196kt = Integer.valueOf(0);
                }
                C0633at.m1463g("is arm64 : " + f5196kt);
            }
            if (f5196kt.intValue() != 1) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: d */
    public static boolean m4827d(RootShell rootShell) {
        C0886f.clean();
        StringBuilder stringBuilder = new StringBuilder();
        String str = "/system/bin/am start -n com.kingroot.kinguser/com.kingroot.kinguser.activitys.SuNotifyActivity";
        int i = 0;
        while (true) {
            i++;
            ShellResult executeCommand2 = rootShell.executeCommand2(str);
            if (executeCommand2.success() && (executeCommand2.stdout == null || !executeCommand2.stdout.contains("Error"))) {
                break;
            }
            stringBuilder.append("___cmd=" + str + "___stdout=" + executeCommand2.stdout);
            if (i >= 3) {
                break;
            }
            C0889i.m2429f(1000);
            C0633at.m1465i("am start kinguser, retry = " + i);
        }
        if (stringBuilder.length() <= 0) {
            return true;
        }
        C0633at.m1464h("am start kinguser: " + stringBuilder.toString());
        C0886f.set(7057, stringBuilder.toString());
        return false;
    }

    /* renamed from: e */
    public static boolean m4828e(RootShell rootShell) {
        boolean z = false;
        if (rootShell == null) {
            C0633at.m1465i("canMountSystem rootShell is NULL");
        } else {
            boolean success;
            try {
                success = rootShell.executeCommand2("mount -o rw,remount /system /system").success();
                C0633at.m1464h("执行mount命令，canMountSystem = " + success);
            } catch (Throwable th) {
                th.printStackTrace();
                C0633at.m1464h("执行mount命令异常，canMountSystem = false");
                success = false;
            }
            if (success) {
                int i = rootShell.executeCommand2(new File(C0741dg.m1804aL().f1806em.workingDir, "chkmount").getAbsolutePath(), 10000).ret;
                C0633at.m1464h("canMountSystem.retCode = " + i);
                if (i == 0) {
                    z = true;
                }
            } else {
                z = success;
            }
            C0633at.m1464h("canMountSystem 最终结果：" + z);
        }
        return z;
    }

    /* renamed from: k */
    public static int m4829k(boolean z) {
        int h = C0900t.m2470h(z);
        C0633at.m1465i("verifyR, rcode = " + h);
        return h;
    }
}
