package com.shuame.mobile.sdk.impl.utils;

import android.text.TextUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/* renamed from: com.shuame.mobile.sdk.impl.utils.i */
public class C1233i {
    /* renamed from: a */
    private static final String[] f3264a = new String[]{"/system/bin/su", "/system/xbin/su", "/data/bin/su"};
    /* renamed from: b */
    private static C1233i f3265b;
    /* renamed from: c */
    private static C1233i f3266c;
    /* renamed from: d */
    private static C1233i f3267d;
    /* renamed from: e */
    private Process f3268e;
    /* renamed from: f */
    private DataOutputStream f3269f;
    /* renamed from: g */
    private DataInputStream f3270g;
    /* renamed from: h */
    private String f3271h;
    /* renamed from: i */
    private String f3272i;
    /* renamed from: j */
    private boolean f3273j;
    /* renamed from: k */
    private boolean f3274k;

    public C1233i() {
        this(false, false);
    }

    public C1233i(boolean z, boolean z2) {
        this.f3273j = z;
        this.f3274k = z2;
    }

    /* renamed from: a */
    public static C1233i m3471a() {
        if (f3265b == null) {
            synchronized (C1233i.class) {
                if (f3265b == null) {
                    f3265b = new C1233i(true, true);
                }
            }
        }
        return f3265b;
    }

    /* renamed from: a */
    private static void m3472a(DataOutputStream dataOutputStream, String str) {
        if (dataOutputStream != null) {
            dataOutputStream.write(("echo " + str + "\n").getBytes());
            dataOutputStream.flush();
        }
    }

    /* renamed from: a */
    private static void m3473a(DataOutputStream dataOutputStream, String str, String str2) {
        if (dataOutputStream != null) {
            dataOutputStream.write(new StringBuilder(String.valueOf(str)).append("\n").toString().getBytes());
            dataOutputStream.flush();
            C1233i.m3472a(dataOutputStream, str2);
        }
    }

    /* renamed from: a */
    private synchronized boolean m3474a(long j) {
        return this.f3273j ? m3480c(j) : m3477b(j);
    }

    /* renamed from: a */
    private boolean m3475a(String str) {
        return m3478b(str) || m3481c(str);
    }

    /* renamed from: b */
    public static C1233i m3476b() {
        if (f3266c == null) {
            synchronized (C1233i.class) {
                if (f3266c == null) {
                    f3266c = new C1233i(true, false);
                }
            }
        }
        return f3266c;
    }

    /* renamed from: b */
    private synchronized boolean m3477b(long j) {
        boolean z = true;
        synchronized (this) {
            try {
                mo6863h();
                ProcessBuilder processBuilder = new ProcessBuilder(new String[]{"/system/bin/sh"});
                processBuilder.redirectErrorStream(true);
                this.f3268e = processBuilder.start();
                this.f3269f = new DataOutputStream(this.f3268e.getOutputStream());
                this.f3270g = new DataInputStream(this.f3268e.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
                z = false;
            }
            C1228g.m3458a("ShellUtils", "initShellProcess isOk:" + z);
            if (!z) {
                mo6863h();
            }
        }
        return z;
    }

    /* renamed from: b */
    private boolean m3478b(String str) {
        if (!TextUtils.isEmpty(str)) {
            String toLowerCase = str.toLowerCase();
            if (toLowerCase.contains("permission denied") || toLowerCase.contains("operation not permitted")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static C1233i m3479c() {
        if (f3267d == null) {
            synchronized (C1233i.class) {
                if (f3267d == null) {
                    f3267d = new C1233i();
                }
            }
        }
        return f3267d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c8 A:{LOOP_END, LOOP:0: B:6:0x000e->B:39:0x00c8} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009c A:{SYNTHETIC} */
    /* renamed from: c */
    private synchronized boolean m3480c(long r14) {
        /*
        r13 = this;
        r4 = 1;
        r2 = 0;
        monitor-enter(r13);
        r3 = r13.f3274k;	 Catch:{ all -> 0x00c5 }
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x00c5 }
        r1 = 18;
        if (r0 < r1) goto L_0x00d0;
    L_0x000b:
        r3 = r2;
        r1 = r2;
        r6 = r14;
    L_0x000e:
        r5 = "su";
        r0 = new java.io.File;	 Catch:{ all -> 0x00c5 }
        r8 = "/system/bin/shuamesu";
        r0.<init>(r8);	 Catch:{ all -> 0x00c5 }
        if (r3 == 0) goto L_0x00a3;
    L_0x0019:
        r0 = r0.exists();	 Catch:{ all -> 0x00c5 }
        if (r0 == 0) goto L_0x00a3;
    L_0x001f:
        r0 = "/system/bin/shuamesu";
        r6 = -1;
    L_0x0023:
        r5 = "ShellUtils";
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c5 }
        r9 = "cmd:";
        r8.<init>(r9);	 Catch:{ all -> 0x00c5 }
        r8 = r8.append(r0);	 Catch:{ all -> 0x00c5 }
        r8 = r8.toString();	 Catch:{ all -> 0x00c5 }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r5, r8);	 Catch:{ all -> 0x00c5 }
        r13.f3272i = r0;	 Catch:{ all -> 0x00c5 }
        r13.mo6863h();	 Catch:{ IOException -> 0x00bd }
        r5 = new java.lang.ProcessBuilder;	 Catch:{ IOException -> 0x00bd }
        r8 = 1;
        r8 = new java.lang.String[r8];	 Catch:{ IOException -> 0x00bd }
        r9 = 0;
        r8[r9] = r0;	 Catch:{ IOException -> 0x00bd }
        r5.<init>(r8);	 Catch:{ IOException -> 0x00bd }
        r8 = 1;
        r5.redirectErrorStream(r8);	 Catch:{ IOException -> 0x00bd }
        r5 = r5.start();	 Catch:{ IOException -> 0x00bd }
        r13.f3268e = r5;	 Catch:{ IOException -> 0x00bd }
        r5 = new java.io.DataOutputStream;	 Catch:{ IOException -> 0x00bd }
        r8 = r13.f3268e;	 Catch:{ IOException -> 0x00bd }
        r8 = r8.getOutputStream();	 Catch:{ IOException -> 0x00bd }
        r5.<init>(r8);	 Catch:{ IOException -> 0x00bd }
        r13.f3269f = r5;	 Catch:{ IOException -> 0x00bd }
        r5 = new java.io.DataInputStream;	 Catch:{ IOException -> 0x00bd }
        r8 = r13.f3268e;	 Catch:{ IOException -> 0x00bd }
        r8 = r8.getInputStream();	 Catch:{ IOException -> 0x00bd }
        r5.<init>(r8);	 Catch:{ IOException -> 0x00bd }
        r13.f3270g = r5;	 Catch:{ IOException -> 0x00bd }
        r1 = r13.m3483d(r6);	 Catch:{ IOException -> 0x00bd }
        if (r1 != 0) goto L_0x00cc;
    L_0x0071:
        r5 = "/system/bin/shuamesu";
        r0 = r0.equals(r5);	 Catch:{ IOException -> 0x00bd }
        if (r0 == 0) goto L_0x00cc;
    L_0x0079:
        r0 = "ShellUtils";
        r5 = "initSuProcess shuamesu Permission denied, try again with system su";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r5);	 Catch:{ IOException -> 0x00bd }
        r13.mo6863h();	 Catch:{ IOException -> 0x00bd }
        r0 = r2;
        r3 = r1;
        r1 = r4;
    L_0x0086:
        r5 = "ShellUtils";
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c5 }
        r9 = "initSuProcess isOk:";
        r8.<init>(r9);	 Catch:{ all -> 0x00c5 }
        r8 = r8.append(r3);	 Catch:{ all -> 0x00c5 }
        r8 = r8.toString();	 Catch:{ all -> 0x00c5 }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r5, r8);	 Catch:{ all -> 0x00c5 }
        if (r1 != 0) goto L_0x00c8;
    L_0x009c:
        if (r3 != 0) goto L_0x00a1;
    L_0x009e:
        r13.mo6863h();	 Catch:{ all -> 0x00c5 }
    L_0x00a1:
        monitor-exit(r13);
        return r3;
    L_0x00a3:
        r9 = f3264a;	 Catch:{ all -> 0x00c5 }
        r10 = r9.length;	 Catch:{ all -> 0x00c5 }
        r8 = r2;
    L_0x00a7:
        if (r8 < r10) goto L_0x00ac;
    L_0x00a9:
        r0 = r5;
        goto L_0x0023;
    L_0x00ac:
        r0 = r9[r8];	 Catch:{ all -> 0x00c5 }
        r11 = new java.io.File;	 Catch:{ all -> 0x00c5 }
        r11.<init>(r0);	 Catch:{ all -> 0x00c5 }
        r11 = r11.exists();	 Catch:{ all -> 0x00c5 }
        if (r11 != 0) goto L_0x0023;
    L_0x00b9:
        r0 = r8 + 1;
        r8 = r0;
        goto L_0x00a7;
    L_0x00bd:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00c5 }
        r0 = r3;
        r3 = r1;
        r1 = r2;
        goto L_0x0086;
    L_0x00c5:
        r0 = move-exception;
        monitor-exit(r13);
        throw r0;
    L_0x00c8:
        r1 = r3;
        r3 = r0;
        goto L_0x000e;
    L_0x00cc:
        r0 = r3;
        r3 = r1;
        r1 = r2;
        goto L_0x0086;
    L_0x00d0:
        r1 = r2;
        r6 = r14;
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.mobile.sdk.impl.utils.i.c(long):boolean");
    }

    /* renamed from: c */
    private boolean m3481c(String str) {
        if (!TextUtils.isEmpty(str)) {
            String toLowerCase = str.toLowerCase();
            if (toLowerCase.contains("connect ui: timer expired") || toLowerCase.contains("can't set uid 0") || toLowerCase.contains("can't set gid 0") || toLowerCase.contains("operation not supported on transport endpoint") || toLowerCase.contains("error: not found; no service started")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m3482d() {
        if (new File("/system/bin/shuamesu").exists()) {
            return true;
        }
        for (String file : f3264a) {
            if (new File(file).exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    private synchronized boolean m3483d(long j) {
        boolean z;
        z = false;
        C1228g.m3458a("ShellUtils", "checkSuProcess check permission start");
        try {
            String readLine;
            String j2 = C1233i.m3486j();
            C1233i.m3472a(this.f3269f, j2);
            Object obj = null;
            if (j <= 0) {
                j = 35000;
            }
            long currentTimeMillis = System.currentTimeMillis() + j;
            while (true) {
                if ((j > 0 && System.currentTimeMillis() < currentTimeMillis) || j < 0) {
                    while (this.f3270g.available() > 0) {
                        readLine = this.f3270g.readLine();
                        if (readLine != null) {
                            C1228g.m3458a("ShellUtils", "checkSuProcess stdout:" + readLine);
                            if (m3475a(readLine)) {
                                this.f3271h = readLine;
                                z = false;
                                obj = 1;
                            } else if (readLine.contains(j2)) {
                                z = true;
                                obj = 1;
                            }
                        }
                    }
                    try {
                        int exitValue = this.f3268e.exitValue();
                        if (exitValue > 0) {
                            z = false;
                            obj = 1;
                        }
                        C1228g.m3458a("ShellUtils", "isSuProcessRunning exitValue:" + exitValue);
                    } catch (Exception e) {
                    }
                    if (obj != null) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                CharSequence stringBuilder = new StringBuilder(String.valueOf(new Random(System.currentTimeMillis()).nextLong())).toString();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("echo " + stringBuilder + " > /cache/.shuame-mobile-root-check\n");
                stringBuilder2.append("cat /cache/.shuame-mobile-root-check\n");
                stringBuilder2.append("rm /cache/.shuame-mobile-root-check");
                readLine = C1233i.m3486j();
                C1233i.m3473a(this.f3269f, stringBuilder2.toString(), readLine);
                currentTimeMillis = 5000 + System.currentTimeMillis();
                obj = null;
                z = false;
                while (System.currentTimeMillis() < currentTimeMillis) {
                    while (this.f3270g.available() > 0) {
                        String readLine2 = this.f3270g.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        C1228g.m3458a("ShellUtils", "checkSuProcess /cache/.shuame-mobile-root-check stdout:" + readLine2);
                        if (readLine2.toLowerCase().contains("read-only file system")) {
                            z = true;
                            obj = 1;
                        } else if (readLine2.contains(stringBuilder)) {
                            z = true;
                            obj = 1;
                        } else if (readLine2.contains(readLine)) {
                            obj = 1;
                        }
                    }
                    if (obj != null) {
                        break;
                    }
                }
                C1228g.m3458a("ShellUtils", "checkSuProcess /cache/.shuame-mobile-root-check isOk:" + z);
            }
        } catch (Throwable e2) {
            e2.printStackTrace();
            C1228g.m3459a("ShellUtils", "checkSuProcess Exception:", e2);
        }
        C1228g.m3458a("ShellUtils", "checkSuProcess check permission end");
        return z;
    }

    /* renamed from: d */
    private static boolean m3484d(String str) {
        return !TextUtils.isEmpty(str) && str.contains("--SHUAME_MOBILE-") && str.contains("-MAGIC_TEXT--");
    }

    /* renamed from: i */
    private synchronized boolean m3485i() {
        IOException e;
        boolean z = false;
        synchronized (this) {
            if (this.f3268e == null) {
                C1228g.m3458a("ShellUtils", "isProcessRunning mProcess null");
            } else {
                boolean z2;
                try {
                    C1228g.m3458a("ShellUtils", "isProcessRunning exitValue:" + this.f3268e.exitValue());
                    z2 = false;
                } catch (Exception e2) {
                    z2 = true;
                }
                if (z2) {
                    C1228g.m3458a("ShellUtils", "isProcessRunning start");
                    try {
                        String j = C1233i.m3486j();
                        C1233i.m3472a(this.f3269f, j);
                        long currentTimeMillis = System.currentTimeMillis() + 5000;
                        boolean z3 = false;
                        z2 = false;
                        while (System.currentTimeMillis() < currentTimeMillis) {
                            try {
                                while (this.f3270g.available() > 0) {
                                    String readLine = this.f3270g.readLine();
                                    if (readLine != null) {
                                        boolean z4;
                                        C1228g.m3458a("ShellUtils", "isProcessRunning stdout:" + readLine);
                                        if (m3475a(readLine)) {
                                            this.f3271h = readLine;
                                            z2 = true;
                                            z3 = false;
                                        } else if (readLine.contains(j)) {
                                            z2 = true;
                                            z3 = true;
                                        } else {
                                            z4 = z3;
                                            z3 = z2;
                                            z2 = z4;
                                        }
                                        if (z2) {
                                            z4 = z2;
                                            z2 = z3;
                                            z3 = z4;
                                            break;
                                        }
                                        z4 = z2;
                                        z2 = z3;
                                        z3 = z4;
                                    } else {
                                        break;
                                    }
                                }
                                if (z3) {
                                    break;
                                }
                            } catch (IOException e3) {
                                e = e3;
                                e.printStackTrace();
                                z = z2;
                                C1228g.m3458a("ShellUtils", "isProcessRunning end, isPermitted:" + z);
                                return z;
                            }
                        }
                        if (!z2) {
                            mo6863h();
                            z = z2;
                            C1228g.m3458a("ShellUtils", "isProcessRunning end, isPermitted:" + z);
                        }
                    } catch (IOException e4) {
                        IOException iOException = e4;
                        z2 = false;
                        e = iOException;
                        e.printStackTrace();
                        z = z2;
                        C1228g.m3458a("ShellUtils", "isProcessRunning end, isPermitted:" + z);
                        return z;
                    }
                    z = z2;
                    C1228g.m3458a("ShellUtils", "isProcessRunning end, isPermitted:" + z);
                }
            }
        }
        return z;
    }

    /* renamed from: j */
    private static String m3486j() {
        return String.format("%s%s%s", new Object[]{"--SHUAME_MOBILE-", Long.valueOf(System.currentTimeMillis()), "-MAGIC_TEXT--"});
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x00d0 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00d0 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d2 A:{SYNTHETIC, Splitter: B:42:0x00d2} */
    /* renamed from: a */
    public synchronized java.lang.String mo6858a(java.lang.String r13, int r14) {
        /*
        r12 = this;
        r3 = 1;
        r4 = 0;
        monitor-enter(r12);
        r0 = r12.f3273j;	 Catch:{ all -> 0x0117 }
        if (r0 == 0) goto L_0x0042;
    L_0x0007:
        r0 = "execSuCmd";
        r5 = r0;
    L_0x000a:
        r0 = "ShellUtils";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0117 }
        r2 = java.lang.String.valueOf(r5);	 Catch:{ all -> 0x0117 }
        r1.<init>(r2);	 Catch:{ all -> 0x0117 }
        r2 = " start cmd:";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0117 }
        r1 = r1.append(r13);	 Catch:{ all -> 0x0117 }
        r1 = r1.toString();	 Catch:{ all -> 0x0117 }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);	 Catch:{ all -> 0x0117 }
        r6 = new java.lang.StringBuffer;	 Catch:{ all -> 0x0117 }
        r6.<init>();	 Catch:{ all -> 0x0117 }
        r1 = r4;
    L_0x002c:
        r0 = r12.m3485i();	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        if (r0 != 0) goto L_0x0049;
    L_0x0032:
        r8 = 0;
        r0 = r12.m3474a(r8);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        if (r0 != 0) goto L_0x0049;
    L_0x003a:
        r0 = r12.f3273j;	 Catch:{ IOException -> 0x0164, Exception -> 0x0161 }
        if (r0 == 0) goto L_0x0046;
    L_0x003e:
        r0 = "Create su process failed!";
    L_0x0040:
        monitor-exit(r12);
        return r0;
    L_0x0042:
        r0 = "execCmd";
        r5 = r0;
        goto L_0x000a;
    L_0x0046:
        r0 = "Create shell process failed!";
        goto L_0x0040;
    L_0x0049:
        r0 = 0;
        r6.setLength(r0);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
    L_0x004d:
        r0 = r12.f3270g;	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r0 = r0.available();	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        if (r0 <= 0) goto L_0x005d;
    L_0x0055:
        r0 = r12.f3270g;	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r0 = r0.readLine();	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        if (r0 != 0) goto L_0x00f4;
    L_0x005d:
        r0 = "ShellUtils";
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r7 = java.lang.String.valueOf(r5);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r2.<init>(r7);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r7 = " tryCount:";
        r2 = r2.append(r7);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r2 = r2.append(r1);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r7 = "; cmd:";
        r2 = r2.append(r7);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r2 = r2.append(r13);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r2);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r7 = com.shuame.mobile.sdk.impl.utils.C1233i.m3486j();	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r0 = r12.f3269f;	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        com.shuame.mobile.sdk.impl.utils.C1233i.m3473a(r0, r13, r7);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r0 = "ShellUtils";
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r8 = java.lang.String.valueOf(r5);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r2.<init>(r8);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r8 = " before while";
        r2 = r2.append(r8);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r2);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r2 = r4;
        r0 = r4;
    L_0x00a6:
        r8 = r12.f3270g;	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r8 = r8.readLine();	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        if (r8 != 0) goto L_0x011a;
    L_0x00ae:
        r2 = "ShellUtils";
        r7 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r8 = java.lang.String.valueOf(r5);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r7.<init>(r8);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r8 = " after while";
        r7 = r7.append(r8);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r7 = r7.toString();	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r2, r7);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        if (r0 == 0) goto L_0x015a;
    L_0x00c8:
        r1 = r14;
    L_0x00c9:
        if (r1 >= r14) goto L_0x00d0;
    L_0x00cb:
        r8 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        java.lang.Thread.sleep(r8);	 Catch:{ InterruptedException -> 0x015e }
    L_0x00d0:
        if (r1 < r14) goto L_0x002c;
    L_0x00d2:
        r0 = "ShellUtils";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0117 }
        r2 = java.lang.String.valueOf(r5);	 Catch:{ all -> 0x0117 }
        r1.<init>(r2);	 Catch:{ all -> 0x0117 }
        r2 = " end cmd:";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0117 }
        r1 = r1.append(r13);	 Catch:{ all -> 0x0117 }
        r1 = r1.toString();	 Catch:{ all -> 0x0117 }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);	 Catch:{ all -> 0x0117 }
        r0 = r6.toString();	 Catch:{ all -> 0x0117 }
        goto L_0x0040;
    L_0x00f4:
        r2 = "ShellUtils";
        r7 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r8 = java.lang.String.valueOf(r5);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r7.<init>(r8);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r8 = " prev stdout:";
        r7 = r7.append(r8);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r0 = r7.append(r0);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r2, r0);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        goto L_0x004d;
    L_0x0112:
        r0 = move-exception;
    L_0x0113:
        r0.printStackTrace();	 Catch:{ all -> 0x0117 }
        goto L_0x00c9;
    L_0x0117:
        r0 = move-exception;
        monitor-exit(r12);
        throw r0;
    L_0x011a:
        r9 = "ShellUtils";
        r10 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r11 = java.lang.String.valueOf(r5);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r10.<init>(r11);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r11 = " stdout:";
        r10 = r10.append(r11);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r10 = r10.append(r8);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r10 = r10.toString();	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r9, r10);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        r9 = r8.contains(r7);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        if (r9 == 0) goto L_0x0141;
    L_0x013c:
        r0 = r3;
    L_0x013d:
        if (r0 != 0) goto L_0x00ae;
    L_0x013f:
        goto L_0x00a6;
    L_0x0141:
        r9 = com.shuame.mobile.sdk.impl.utils.C1233i.m3484d(r8);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        if (r9 != 0) goto L_0x013d;
    L_0x0147:
        if (r2 == 0) goto L_0x0158;
    L_0x0149:
        r9 = "\n";
        r6.append(r9);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
    L_0x014e:
        r6.append(r8);	 Catch:{ IOException -> 0x0112, Exception -> 0x0152 }
        goto L_0x013d;
    L_0x0152:
        r0 = move-exception;
    L_0x0153:
        r0.printStackTrace();	 Catch:{ all -> 0x0117 }
        goto L_0x00c9;
    L_0x0158:
        r2 = r3;
        goto L_0x014e;
    L_0x015a:
        r1 = r1 + 1;
        goto L_0x00c9;
    L_0x015e:
        r0 = move-exception;
        goto L_0x00d0;
    L_0x0161:
        r0 = move-exception;
        r1 = r14;
        goto L_0x0153;
    L_0x0164:
        r0 = move-exception;
        r1 = r14;
        goto L_0x0113;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.mobile.sdk.impl.utils.i.a(java.lang.String, int):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fb A:{SYNTHETIC, Splitter: B:43:0x00fb} */
    /* renamed from: a */
    public synchronized java.lang.String mo6859a(java.lang.String r15, long r16, int r18) {
        /*
        r14 = this;
        monitor-enter(r14);
        r2 = r14.f3273j;	 Catch:{ all -> 0x0140 }
        if (r2 == 0) goto L_0x0060;
    L_0x0005:
        r2 = "execSuCmd";
        r5 = r2;
    L_0x0008:
        r2 = "ShellUtils";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0140 }
        r4 = java.lang.String.valueOf(r5);	 Catch:{ all -> 0x0140 }
        r3.<init>(r4);	 Catch:{ all -> 0x0140 }
        r4 = " suCmd:";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0140 }
        r4 = r14.mo6861f();	 Catch:{ all -> 0x0140 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0140 }
        r3 = r3.toString();	 Catch:{ all -> 0x0140 }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r2, r3);	 Catch:{ all -> 0x0140 }
        r2 = "ShellUtils";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0140 }
        r4 = java.lang.String.valueOf(r5);	 Catch:{ all -> 0x0140 }
        r3.<init>(r4);	 Catch:{ all -> 0x0140 }
        r4 = " start cmd:";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0140 }
        r3 = r3.append(r15);	 Catch:{ all -> 0x0140 }
        r3 = r3.toString();	 Catch:{ all -> 0x0140 }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r2, r3);	 Catch:{ all -> 0x0140 }
        r6 = new java.lang.StringBuffer;	 Catch:{ all -> 0x0140 }
        r6.<init>();	 Catch:{ all -> 0x0140 }
        r3 = 0;
    L_0x004a:
        r2 = r14.m3485i();	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        if (r2 != 0) goto L_0x0067;
    L_0x0050:
        r8 = 0;
        r2 = r14.m3474a(r8);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        if (r2 != 0) goto L_0x0067;
    L_0x0058:
        r2 = r14.f3273j;	 Catch:{ IOException -> 0x019e, Exception -> 0x019a }
        if (r2 == 0) goto L_0x0064;
    L_0x005c:
        r2 = "Create su process failed!";
    L_0x005e:
        monitor-exit(r14);
        return r2;
    L_0x0060:
        r2 = "execCmd";
        r5 = r2;
        goto L_0x0008;
    L_0x0064:
        r2 = "Create shell process failed!";
        goto L_0x005e;
    L_0x0067:
        r2 = 0;
        r6.setLength(r2);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
    L_0x006b:
        r2 = r14.f3270g;	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r2 = r2.available();	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        if (r2 <= 0) goto L_0x007b;
    L_0x0073:
        r2 = r14.f3270g;	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r2 = r2.readLine();	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        if (r2 != 0) goto L_0x011d;
    L_0x007b:
        r2 = "ShellUtils";
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r7 = java.lang.String.valueOf(r5);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r4.<init>(r7);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r7 = " tryCount:";
        r4 = r4.append(r7);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r4 = r4.append(r3);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r7 = "; cmd:";
        r4 = r4.append(r7);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r4 = r4.append(r15);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r4 = r4.toString();	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r2, r4);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r7 = com.shuame.mobile.sdk.impl.utils.C1233i.m3486j();	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r2 = r14.f3269f;	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        com.shuame.mobile.sdk.impl.utils.C1233i.m3473a(r2, r15, r7);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r2 = 0;
        r4 = 0;
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r8 = r8 + r16;
        r10 = "ShellUtils";
        r11 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r12 = java.lang.String.valueOf(r5);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r11.<init>(r12);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r12 = " before while";
        r11 = r11.append(r12);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r11 = r11.toString();	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r10, r11);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
    L_0x00ca:
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
        if (r10 < 0) goto L_0x0166;
    L_0x00d2:
        r4 = "ShellUtils";
        r7 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r8 = java.lang.String.valueOf(r5);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r7.<init>(r8);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r8 = " after while";
        r7 = r7.append(r8);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r7 = r7.toString();	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r4, r7);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        if (r2 == 0) goto L_0x0193;
    L_0x00ec:
        r3 = r18;
    L_0x00ee:
        r0 = r18;
        if (r3 >= r0) goto L_0x00f7;
    L_0x00f2:
        r8 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        java.lang.Thread.sleep(r8);	 Catch:{ InterruptedException -> 0x0197 }
    L_0x00f7:
        r0 = r18;
        if (r3 < r0) goto L_0x004a;
    L_0x00fb:
        r2 = "ShellUtils";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0140 }
        r4 = java.lang.String.valueOf(r5);	 Catch:{ all -> 0x0140 }
        r3.<init>(r4);	 Catch:{ all -> 0x0140 }
        r4 = " end cmd:";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0140 }
        r3 = r3.append(r15);	 Catch:{ all -> 0x0140 }
        r3 = r3.toString();	 Catch:{ all -> 0x0140 }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r2, r3);	 Catch:{ all -> 0x0140 }
        r2 = r6.toString();	 Catch:{ all -> 0x0140 }
        goto L_0x005e;
    L_0x011d:
        r4 = "ShellUtils";
        r7 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r8 = java.lang.String.valueOf(r5);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r7.<init>(r8);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r8 = " prev stdout:";
        r7 = r7.append(r8);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r2 = r7.append(r2);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r2 = r2.toString();	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r4, r2);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        goto L_0x006b;
    L_0x013b:
        r2 = move-exception;
    L_0x013c:
        r2.printStackTrace();	 Catch:{ all -> 0x0140 }
        goto L_0x00ee;
    L_0x0140:
        r2 = move-exception;
        monitor-exit(r14);
        throw r2;
    L_0x0143:
        r11 = "ShellUtils";
        r12 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r13 = java.lang.String.valueOf(r5);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r12.<init>(r13);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r13 = " stdout:";
        r12 = r12.append(r13);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r12 = r12.append(r10);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r12 = r12.toString();	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r11, r12);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r11 = r10.contains(r7);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        if (r11 == 0) goto L_0x017a;
    L_0x0165:
        r2 = 1;
    L_0x0166:
        r10 = r14.f3270g;	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r10 = r10.available();	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        if (r10 <= 0) goto L_0x0176;
    L_0x016e:
        r10 = r14.f3270g;	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        r10 = r10.readLine();	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        if (r10 != 0) goto L_0x0143;
    L_0x0176:
        if (r2 != 0) goto L_0x00d2;
    L_0x0178:
        goto L_0x00ca;
    L_0x017a:
        r11 = com.shuame.mobile.sdk.impl.utils.C1233i.m3484d(r10);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        if (r11 != 0) goto L_0x0166;
    L_0x0180:
        if (r4 == 0) goto L_0x0191;
    L_0x0182:
        r11 = "\n";
        r6.append(r11);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
    L_0x0187:
        r6.append(r10);	 Catch:{ IOException -> 0x013b, Exception -> 0x018b }
        goto L_0x0166;
    L_0x018b:
        r2 = move-exception;
    L_0x018c:
        r2.printStackTrace();	 Catch:{ all -> 0x0140 }
        goto L_0x00ee;
    L_0x0191:
        r4 = 1;
        goto L_0x0187;
    L_0x0193:
        r3 = r3 + 1;
        goto L_0x00ee;
    L_0x0197:
        r2 = move-exception;
        goto L_0x00f7;
    L_0x019a:
        r2 = move-exception;
        r3 = r18;
        goto L_0x018c;
    L_0x019e:
        r2 = move-exception;
        r3 = r18;
        goto L_0x013c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.mobile.sdk.impl.utils.i.a(java.lang.String, long, int):java.lang.String");
    }

    /* renamed from: e */
    public boolean mo6860e() {
        return "/system/bin/shuamesu".equals(this.f3272i);
    }

    /* renamed from: f */
    public String mo6861f() {
        return TextUtils.isEmpty(this.f3272i) ? "su" : this.f3272i;
    }

    /* renamed from: g */
    public synchronized int mo6862g() {
        int i = 1;
        synchronized (this) {
            C1228g.m3458a("ShellUtils", "obtainRoot start");
            if (C1233i.m3482d()) {
                int i2 = (m3485i() || m3480c(-1)) ? 1 : 0;
                if (i2 == 0) {
                    i = 2;
                    if (m3481c(this.f3271h)) {
                        i = 3;
                    }
                }
                C1228g.m3458a("ShellUtils", "obtainRoot end result:" + i);
            } else {
                C1228g.m3458a("ShellUtils", "obtainRoot end result:4");
                i = 4;
            }
        }
        return i;
    }

    /* renamed from: h */
    public synchronized void mo6863h() {
        C1228g.m3458a("ShellUtils", "release");
        if (this.f3269f != null) {
            try {
                this.f3269f.writeBytes("exit\n");
                this.f3269f.flush();
                this.f3269f.close();
            } catch (IOException e) {
            }
            this.f3269f = null;
        }
        if (this.f3270g != null) {
            try {
                this.f3270g.close();
            } catch (IOException e2) {
            }
            this.f3270g = null;
        }
        if (this.f3268e != null) {
            try {
                this.f3268e.destroy();
            } catch (Exception e3) {
            }
            this.f3268e = null;
        }
    }
}
