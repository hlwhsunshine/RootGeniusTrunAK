package com.kingroot.sdk.util;

import android.content.Context;
import com.kingroot.sdk.C0633at;
import com.kingroot.sdk.C0659bf;
import com.kingroot.sdk.C0739de;
import com.kingroot.sdk.C0761du;
import java.io.File;
import krsdk.RootShell;
import krsdk.RootShell.ShellResult;

/* renamed from: com.kingroot.sdk.util.m */
public class C0894m {
    /* renamed from: T */
    public static void m2452T(Context context) {
        Object obj = null;
        String str = "krperm";
        long currentTimeMillis = System.currentTimeMillis();
        if (C0899s.m2469a(C0739de.m1800d(context, str), currentTimeMillis, 86400000)) {
            C0739de.m1794a(context, str, currentTimeMillis);
            String[] split = C0894m.m2453aa("ls /data/local/tmp").split("\n");
            C0633at.m1464h("lsResult.length = " + split.length);
            int i = 0;
            while (i < split.length) {
                if (split[i] != null && split[i].startsWith("krperm") && split[i].endsWith("txt")) {
                    C0633at.m1464h("target: " + split[i]);
                    obj = 1;
                    C0894m.m2453aa("cat /data/local/tmp/" + split[i] + " >> /data/local/tmp/tp.txt");
                }
                i++;
            }
            if (obj == null) {
                C0633at.m1464h("No Exist krperm, return directly");
                return;
            }
            File file = new File("/data/local/tmp", "tp.txt");
            C0894m.m2453aa("chmod 777 /data/local/tmp/tp.txt");
            i = -1;
            C0633at.m1464h("exists: " + file.exists() + ", can read: " + file.canRead());
            if (file.exists()) {
                C0633at.m1464h("call reportKrperm");
                try {
                    i = C0761du.m1885a(context, file);
                    C0633at.m1464h("reportKrperm returnCode: " + i);
                } catch (Exception e) {
                    C0633at.m1465i(e.toString());
                }
            }
            if (file.exists() && r0 == 0) {
                C0894m.m2453aa("rm -rf /data/local/tmp/tp.txt");
                C0633at.m1464h("tp delete");
            }
            C0633at.m1464h("END ...... ");
            return;
        }
        C0633at.m1464h("report krperm time limit");
    }

    /* renamed from: aa */
    public static String m2453aa(String str) {
        ShellResult shellResult = null;
        RootShell c = C0659bf.m1548c(true);
        if (c != null) {
            shellResult = c.executeCommand2(str);
        }
        if (shellResult == null || !shellResult.success()) {
            shellResult = C0659bf.m1549z(str);
        }
        return (!shellResult.success() || shellResult.stdout == null) ? "" : shellResult.stdout.trim();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007a  */
    /* renamed from: bp */
    public static java.lang.String m2454bp() {
        /*
        r2 = 0;
        r1 = new com.kingroot.sdk.av;	 Catch:{ Throwable -> 0x005d, all -> 0x007e }
        r0 = "sh";
        r1.<init>(r0);	 Catch:{ Throwable -> 0x005d, all -> 0x007e }
        r0 = "export PATH=/sbin:/vendor/bin:/system/sbin:/system/bin:/system/xbin:$PATH";
        r1.mo5609t(r0);	 Catch:{ Throwable -> 0x0088 }
        r0 = "su -v";
        r2 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r0 = r1.mo5606b(r0, r2);	 Catch:{ Throwable -> 0x0088 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0088 }
        r3 = "RootUtil.getSuInfo su -v r.success() = ";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0088 }
        r3 = r0.success();	 Catch:{ Throwable -> 0x0088 }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0088 }
        r3 = ", r.mStdOut = ";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0088 }
        r3 = r0.f1585cs;	 Catch:{ Throwable -> 0x0088 }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0088 }
        r3 = ", r.mStdErr = ";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0088 }
        r3 = r0.f1586ct;	 Catch:{ Throwable -> 0x0088 }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0088 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0088 }
        com.kingroot.sdk.C0633at.m1464h(r2);	 Catch:{ Throwable -> 0x0088 }
        r2 = r0.success();	 Catch:{ Throwable -> 0x0088 }
        if (r2 == 0) goto L_0x0057;
    L_0x0049:
        r2 = r0.f1585cs;	 Catch:{ Throwable -> 0x0088 }
        if (r2 == 0) goto L_0x0057;
    L_0x004d:
        r0 = r0.f1585cs;	 Catch:{ Throwable -> 0x0088 }
        r0 = r0.trim();	 Catch:{ Throwable -> 0x0088 }
        r1.shutdown();
    L_0x0056:
        return r0;
    L_0x0057:
        r1.shutdown();
    L_0x005a:
        r0 = "";
        goto L_0x0056;
    L_0x005d:
        r0 = move-exception;
        r1 = r2;
    L_0x005f:
        r0.printStackTrace();	 Catch:{ all -> 0x0086 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0086 }
        r3 = "su -v exception : ";
        r2.<init>(r3);	 Catch:{ all -> 0x0086 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0086 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x0086 }
        r0 = r0.toString();	 Catch:{ all -> 0x0086 }
        com.kingroot.sdk.C0633at.m1464h(r0);	 Catch:{ all -> 0x0086 }
        if (r1 == 0) goto L_0x005a;
    L_0x007a:
        r1.shutdown();
        goto L_0x005a;
    L_0x007e:
        r0 = move-exception;
        r1 = r2;
    L_0x0080:
        if (r1 == 0) goto L_0x0085;
    L_0x0082:
        r1.shutdown();
    L_0x0085:
        throw r0;
    L_0x0086:
        r0 = move-exception;
        goto L_0x0080;
    L_0x0088:
        r0 = move-exception;
        goto L_0x005f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.util.m.bp():java.lang.String");
    }

    /* renamed from: bq */
    public static String m2455bq() {
        return C0894m.m2453aa("ls -l /dev/kmem");
    }

    /* JADX WARNING: Missing block: B:15:?, code:
            r4.close();
            r2.close();
            r3.close();
     */
    /* JADX WARNING: Missing block: B:16:0x0033, code:
            com.kingroot.sdk.util.C0885e.m2419a(r4);
            com.kingroot.sdk.util.C0885e.m2419a(r2);
            com.kingroot.sdk.util.C0885e.m2419a(r3);
     */
    /* JADX WARNING: Missing block: B:38:0x0076, code:
            r1 = e;
     */
    /* renamed from: br */
    public static java.lang.String m2456br() {
        /*
        r1 = 0;
        r5 = "";
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x003d, all -> 0x0050 }
        r0 = "/proc/kallsyms";
        r3.<init>(r0);	 Catch:{ Exception -> 0x003d, all -> 0x0050 }
        r2 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0067, all -> 0x005e }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0067, all -> 0x005e }
        r4 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x006d, all -> 0x0062 }
        r4.<init>(r2);	 Catch:{ Exception -> 0x006d, all -> 0x0062 }
    L_0x0014:
        r0 = r4.readLine();	 Catch:{ Exception -> 0x0072 }
        if (r0 == 0) goto L_0x0078;
    L_0x001a:
        r1 = " load_module";
        r1 = r0.contains(r1);	 Catch:{ Exception -> 0x0072 }
        if (r1 == 0) goto L_0x0014;
    L_0x0022:
        r1 = "load_module";
        r1 = r0.endsWith(r1);	 Catch:{ Exception -> 0x0072 }
        if (r1 == 0) goto L_0x0014;
    L_0x002a:
        r4.close();	 Catch:{ Exception -> 0x0076 }
        r2.close();	 Catch:{ Exception -> 0x0076 }
        r3.close();	 Catch:{ Exception -> 0x0076 }
        com.kingroot.sdk.util.C0885e.m2419a(r4);
        com.kingroot.sdk.util.C0885e.m2419a(r2);
        com.kingroot.sdk.util.C0885e.m2419a(r3);
    L_0x003c:
        return r0;
    L_0x003d:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
        r4 = r1;
        r1 = r0;
        r0 = r5;
    L_0x0043:
        com.kingroot.sdk.C0633at.m1459a(r1);	 Catch:{ all -> 0x0065 }
        com.kingroot.sdk.util.C0885e.m2419a(r4);
        com.kingroot.sdk.util.C0885e.m2419a(r2);
        com.kingroot.sdk.util.C0885e.m2419a(r3);
        goto L_0x003c;
    L_0x0050:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
        r4 = r1;
    L_0x0054:
        com.kingroot.sdk.util.C0885e.m2419a(r4);
        com.kingroot.sdk.util.C0885e.m2419a(r2);
        com.kingroot.sdk.util.C0885e.m2419a(r3);
        throw r0;
    L_0x005e:
        r0 = move-exception;
        r2 = r1;
        r4 = r1;
        goto L_0x0054;
    L_0x0062:
        r0 = move-exception;
        r4 = r1;
        goto L_0x0054;
    L_0x0065:
        r0 = move-exception;
        goto L_0x0054;
    L_0x0067:
        r0 = move-exception;
        r2 = r1;
        r4 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x0043;
    L_0x006d:
        r0 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x0043;
    L_0x0072:
        r0 = move-exception;
        r1 = r0;
        r0 = r5;
        goto L_0x0043;
    L_0x0076:
        r1 = move-exception;
        goto L_0x0043;
    L_0x0078:
        r0 = r5;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.util.m.br():java.lang.String");
    }
}
