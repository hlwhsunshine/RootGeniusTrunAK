package com.kingroot.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Handler;
import com.kingroot.sdk.util.C0883c;
import com.kingroot.sdk.util.C0885e;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/* renamed from: com.kingroot.sdk.ac */
public class C0605ac {
    /* renamed from: aD */
    public static C0605ac f1486aD;
    /* renamed from: aE */
    private String f1487aE;
    /* renamed from: aF */
    private File f1488aF;

    /* renamed from: com.kingroot.sdk.ac$1 */
    class C06031 implements FilenameFilter {
        C06031() {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(".log");
        }
    }

    private C0605ac() {
    }

    /* renamed from: d */
    public static C0605ac m1338d() {
        C0605ac c0605ac;
        synchronized (C0605ac.class) {
            if (f1486aD == null) {
                c0605ac = new C0605ac();
                f1486aD = c0605ac;
                c0605ac.f1487aE = new File(C0741dg.m1804aL().f1806em.workingDir, "reportroot").getAbsolutePath();
                File file = new File(C0741dg.m1804aL().f1806em.workingDir, "rblog");
                if (!file.exists()) {
                    file.mkdirs();
                }
                f1486aD.f1488aF = file;
            }
            c0605ac = f1486aD;
        }
        return c0605ac;
    }

    /* renamed from: d */
    private String m1339d(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        List installedApplications = context.getPackageManager().getInstalledApplications(8192);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= installedApplications.size()) {
                break;
            }
            stringBuffer.append(((ApplicationInfo) installedApplications.get(i2)).packageName).append("\n");
            i = i2 + 1;
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
        }
        return stringBuffer.toString();
    }

    /* renamed from: h */
    private String m1340h() {
        String str = this.f1487aE + " shell-nr";
        C0730do c0730do = new C0730do();
        c0730do.mo5706aT();
        str = c0730do.executeCommand(str);
        c0730do.close();
        return str;
    }

    /* renamed from: i */
    private File[] m1341i() {
        return (this.f1488aF == null || !this.f1488aF.exists()) ? new File[0] : this.f1488aF.listFiles(new C06031());
    }

    /* renamed from: a */
    public void mo5580a(final Context context, Handler handler) {
        if ("105006".equals(C0625ao.f1552bJ)) {
            C0633at.m1466r("EnvScanner.reportEnvFiles()");
            handler.post(new Runnable() {
                public void run() {
                    C0633at.m1464h("EnvScanner.Thread.currentThread().getId()_a = " + Thread.currentThread().getId());
                    synchronized (C0605ac.class) {
                        C0633at.m1464h("EnvScanner.Thread.currentThread().getId()_b = " + Thread.currentThread().getId());
                        File[] a = C0605ac.this.m1341i();
                        if (a == null || a.length <= 0) {
                            C0633at.m1464h("EnvScanner.No reportEnvFiles");
                        } else {
                            for (File file : a) {
                                if (file.exists()) {
                                    try {
                                        String str = "DEL_FAIL_ENV_" + file.getName();
                                        C0633at.m1464h("EnvScanner.markKey = " + str);
                                        if (C0739de.m1802p(context, str) != null) {
                                            C0633at.m1464h("EnvScanner.reportEnvFiles has ever reported, delSuc = " + C0883c.m2406h(file) + ", " + str);
                                        } else {
                                            C0633at.m1464h("EnvScanner.reportEnvFiles start");
                                            int b = C0769dy.m1921b(context, file);
                                            C0633at.m1465i("EnvScanner.reportEnvFiles end.....uploadResult = " + b + ", " + file.getAbsolutePath());
                                            if (b == 0) {
                                                boolean h = C0883c.m2406h(file);
                                                if (!h) {
                                                    C0739de.m1795a(context, str, "YES");
                                                }
                                                C0633at.m1464h("EnvScanner.reportEnvFiles delete logfile, delSuc = " + h);
                                            } else {
                                                C0633at.m1464h("EnvScanner.reportEnvFiles fail, updateResult = " + b);
                                            }
                                        }
                                    } catch (Throwable e) {
                                        C0633at.m1458a("EnvScanner.reportEnvFiles exception, " + file.getAbsolutePath(), e);
                                        e.printStackTrace();
                                    }
                                } else {
                                    C0633at.m1464h("EnvScanner.reportEnvFiles not exists, " + file.getAbsolutePath());
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    /* renamed from: c */
    public void mo5581c(Context context) {
        IOException e;
        Throwable th;
        if ("105006".equals(C0625ao.f1552bJ)) {
            C0633at.m1466r("EnvScanner.scanRootProcAppListAfterReboot()");
            String h = m1340h();
            C0633at.m1464h("procListText = " + h);
            String d = m1339d(context);
            C0633at.m1464h("appListText = " + d);
            File file = new File(this.f1488aF, "kr_env.sdr");
            Closeable printWriter;
            try {
                printWriter = new PrintWriter(new FileWriter(file, true), false);
                try {
                    printWriter.println("KR_MARK_PROC_LIST2:");
                    printWriter.println(h);
                    printWriter.println("KR_MARK_APP_LIST:");
                    printWriter.println(d);
                    printWriter.println();
                    printWriter.println("KR_MARK_END:");
                    printWriter.println("THIS_TIME=" + System.currentTimeMillis());
                    h = C0739de.m1802p(context, "runned_sids");
                    String p = C0739de.m1802p(context, "apptime_runned_sids");
                    printWriter.println("RUNNED_SID=" + h);
                    printWriter.println("APPTIME_RUNNED_SID=" + p);
                    printWriter.flush();
                    C0885e.m2419a(printWriter);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        C0885e.m2419a(printWriter);
                        file.renameTo(new File(this.f1488aF, String.format("kr_env_%s.log", new Object[]{System.currentTimeMillis()})));
                    } catch (Throwable th2) {
                        th = th2;
                        C0885e.m2419a(printWriter);
                        throw th;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                printWriter = null;
                e.printStackTrace();
                C0885e.m2419a(printWriter);
                file.renameTo(new File(this.f1488aF, String.format("kr_env_%s.log", new Object[]{System.currentTimeMillis()})));
            } catch (Throwable th3) {
                th = th3;
                printWriter = null;
                C0885e.m2419a(printWriter);
                throw th;
            }
            file.renameTo(new File(this.f1488aF, String.format("kr_env_%s.log", new Object[]{System.currentTimeMillis()})));
        }
    }

    /* renamed from: e */
    public boolean mo5582e() {
        if (!"105006".equals(C0625ao.f1552bJ)) {
            return false;
        }
        File file = new File(this.f1488aF, "kr_env.sdr");
        return file.exists() && file.length() > 0;
    }

    /* renamed from: f */
    public void mo5583f() {
        if ("105006".equals(C0625ao.f1552bJ)) {
            C0633at.m1466r("EnvScanner.deleteSDRLogFile()");
            C0633at.m1466r("EnvScanner.deleteSDRLogFile delSuc = " + new File(this.f1488aF, "kr_env.sdr").delete());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:? A:{SYNTHETIC, RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x006a  */
    /* renamed from: f */
    public void mo5584f(java.lang.String r7) {
        /*
        r6 = this;
        r0 = "105006";
        r1 = com.kingroot.sdk.C0625ao.f1552bJ;
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0080;
    L_0x000a:
        r0 = "EnvScanner.confirmSdrLog()";
        com.kingroot.sdk.C0633at.m1466r(r0);
        r0 = new java.io.File;
        r1 = r6.f1488aF;
        r2 = "kr_env.tmp";
        r0.<init>(r1, r2);
        r2 = 0;
        r1 = new java.io.PrintWriter;	 Catch:{ IOException -> 0x0081, all -> 0x008a }
        r3 = new java.io.FileWriter;	 Catch:{ IOException -> 0x0081, all -> 0x008a }
        r4 = 1;
        r3.<init>(r0, r4);	 Catch:{ IOException -> 0x0081, all -> 0x008a }
        r0 = 0;
        r1.<init>(r3, r0);	 Catch:{ IOException -> 0x0081, all -> 0x008a }
        r0 = "KR_MARK_EXPLOIT_INFO:";
        r1.println(r0);	 Catch:{ IOException -> 0x0092 }
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0092 }
        r2 = "THIS_TIME=";
        r0.<init>(r2);	 Catch:{ IOException -> 0x0092 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x0092 }
        r0 = r0.append(r2);	 Catch:{ IOException -> 0x0092 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0092 }
        r1.println(r0);	 Catch:{ IOException -> 0x0092 }
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0092 }
        r2 = "SDRVERSION=";
        r0.<init>(r2);	 Catch:{ IOException -> 0x0092 }
        r0 = r0.append(r7);	 Catch:{ IOException -> 0x0092 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0092 }
        r1.println(r0);	 Catch:{ IOException -> 0x0092 }
        r1.println();	 Catch:{ IOException -> 0x0092 }
        r1.flush();	 Catch:{ IOException -> 0x0092 }
        com.kingroot.sdk.util.C0885e.m2419a(r1);
    L_0x005b:
        r0 = new java.io.File;
        r1 = r6.f1488aF;
        r2 = "kr_env.tmp";
        r0.<init>(r1, r2);
        r1 = r0.exists();
        if (r1 == 0) goto L_0x0080;
    L_0x006a:
        r2 = r0.length();
        r4 = 0;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 <= 0) goto L_0x0080;
    L_0x0074:
        r1 = new java.io.File;
        r2 = r6.f1488aF;
        r3 = "kr_env.sdr";
        r1.<init>(r2, r3);
        r0.renameTo(r1);
    L_0x0080:
        return;
    L_0x0081:
        r0 = move-exception;
        r1 = r2;
    L_0x0083:
        r0.printStackTrace();	 Catch:{ all -> 0x0090 }
        com.kingroot.sdk.util.C0885e.m2419a(r1);
        goto L_0x005b;
    L_0x008a:
        r0 = move-exception;
        r1 = r2;
    L_0x008c:
        com.kingroot.sdk.util.C0885e.m2419a(r1);
        throw r0;
    L_0x0090:
        r0 = move-exception;
        goto L_0x008c;
    L_0x0092:
        r0 = move-exception;
        goto L_0x0083;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.ac.f(java.lang.String):void");
    }

    /* renamed from: g */
    public void mo5585g() {
        IOException e;
        Throwable th;
        if ("105006".equals(C0625ao.f1552bJ)) {
            C0633at.m1466r("EnvScanner.scanRootProcBeforeReboot()");
            String h = m1340h();
            Closeable printWriter;
            try {
                printWriter = new PrintWriter(new FileWriter(new File(this.f1488aF, "kr_env.tmp")), false);
                try {
                    printWriter.println("KR_MARK_DEVICE_INFO:");
                    printWriter.println("THIS_TIME=" + System.currentTimeMillis());
                    printWriter.println("BRAND=" + Build.BRAND);
                    printWriter.println("MODEL=" + Build.MODEL);
                    printWriter.println("FINGERPRINT=" + C0628ar.m1450E());
                    printWriter.println("LINUXVERSION=" + C0628ar.m1451F());
                    printWriter.println("IMEI=" + C0624an.m1429u());
                    printWriter.println();
                    printWriter.println("KR_MARK_PROC_LIST1:");
                    printWriter.println(h);
                    printWriter.flush();
                    C0885e.m2419a(printWriter);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        C0885e.m2419a(printWriter);
                    } catch (Throwable th2) {
                        th = th2;
                        C0885e.m2419a(printWriter);
                        throw th;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                printWriter = null;
                e.printStackTrace();
                C0885e.m2419a(printWriter);
            } catch (Throwable th3) {
                th = th3;
                printWriter = null;
                C0885e.m2419a(printWriter);
                throw th;
            }
        }
    }
}
