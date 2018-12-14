package com.shuame.rootgenius.common.p103d;

import android.os.Build.VERSION;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

/* renamed from: com.shuame.rootgenius.common.d.a */
public final class C1326a {
    /* renamed from: a */
    private static final String[] f3598a = new String[]{"/system/bin/su", "/system/xbin/su", "/data/bin/su"};
    /* renamed from: b */
    private Process f3599b;
    /* renamed from: c */
    private DataOutputStream f3600c;
    /* renamed from: d */
    private DataInputStream f3601d;
    /* renamed from: e */
    private String f3602e;
    /* renamed from: f */
    private String f3603f;
    /* renamed from: g */
    private boolean f3604g;
    /* renamed from: h */
    private boolean f3605h;

    public C1326a() {
        this(false);
    }

    public C1326a(byte b) {
        this(true);
    }

    private C1326a(boolean z) {
        this.f3604g = z;
        this.f3605h = false;
    }

    /* renamed from: a */
    private static void m3726a(DataOutputStream dataOutputStream, String str) {
        if (dataOutputStream != null) {
            dataOutputStream.write(("echo " + str + "\n").getBytes());
            dataOutputStream.flush();
        }
    }

    /* renamed from: a */
    private static void m3727a(DataOutputStream dataOutputStream, String str, String str2) {
        if (dataOutputStream != null) {
            dataOutputStream.write((str + "\n").getBytes());
            dataOutputStream.flush();
            C1326a.m3726a(dataOutputStream, str2);
        }
    }

    /* renamed from: a */
    private synchronized boolean m3728a() {
        IOException e;
        boolean z = false;
        synchronized (this) {
            if (this.f3599b != null) {
                boolean z2;
                try {
                    this.f3599b.exitValue();
                    z2 = false;
                } catch (Exception e2) {
                    z2 = true;
                }
                if (z2) {
                    try {
                        CharSequence e3 = C1326a.m3735e();
                        C1326a.m3726a(this.f3600c, e3);
                        long currentTimeMillis = System.currentTimeMillis() + 5000;
                        boolean z3 = false;
                        z2 = false;
                        do {
                            try {
                                if (System.currentTimeMillis() >= currentTimeMillis) {
                                    break;
                                }
                                while (this.f3601d.available() > 0) {
                                    String readLine = this.f3601d.readLine();
                                    if (readLine == null) {
                                        continue;
                                        break;
                                    }
                                    boolean z4;
                                    if (C1326a.m3730a(readLine)) {
                                        this.f3602e = readLine;
                                        z2 = true;
                                        z3 = false;
                                    } else if (readLine.contains(e3)) {
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
                                        continue;
                                        break;
                                    }
                                    z4 = z2;
                                    z2 = z3;
                                    z3 = z4;
                                }
                            } catch (IOException e4) {
                                IOException iOException = e4;
                                z = z2;
                                e = iOException;
                            }
                        } while (!z3);
                        z = z2;
                        if (!z) {
                            m3731b();
                        }
                    } catch (IOException e5) {
                        e = e5;
                    }
                }
            }
        }
        return z;
        e.printStackTrace();
        return z;
    }

    /* renamed from: a */
    private synchronized boolean m3729a(long j) {
        boolean z;
        long j2;
        boolean z2 = this.f3605h;
        if (VERSION.SDK_INT >= 18) {
            z2 = false;
            z = false;
            j2 = j;
        } else {
            z = false;
            j2 = j;
        }
        Object obj;
        do {
            String str;
            String str2 = "su";
            File file = new File("/system/bin/shuamesu");
            if (z2 && file.exists()) {
                str = "/system/bin/shuamesu";
                j2 = -1;
            } else {
                for (String str3 : f3598a) {
                    if (new File(str3).exists()) {
                        break;
                    }
                }
                str3 = str2;
            }
            this.f3603f = str3;
            try {
                m3731b();
                ProcessBuilder processBuilder = new ProcessBuilder(new String[]{str3});
                processBuilder.redirectErrorStream(true);
                this.f3599b = processBuilder.start();
                this.f3600c = new DataOutputStream(this.f3599b.getOutputStream());
                this.f3601d = new DataInputStream(this.f3599b.getInputStream());
                z = m3732b(j2);
                if (!z && str3.equals("/system/bin/shuamesu")) {
                    m3731b();
                    z2 = false;
                    obj = 1;
                    continue;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            obj = null;
            continue;
        } while (obj != null);
        if (!z) {
            m3731b();
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m3730a(String str) {
        String toLowerCase = str.toLowerCase();
        return toLowerCase.contains("permission denied") || toLowerCase.contains("operation not permitted") || toLowerCase.contains("connect ui: timer expired") || toLowerCase.contains("can't set uid 0") || toLowerCase.contains("can't set gid 0") || toLowerCase.contains("operation not supported on transport endpoint");
    }

    /* renamed from: b */
    private synchronized void m3731b() {
        if (this.f3600c != null) {
            try {
                this.f3600c.writeBytes("exit\n");
                this.f3600c.flush();
                this.f3600c.close();
            } catch (IOException e) {
            }
            this.f3600c = null;
        }
        if (this.f3601d != null) {
            try {
                this.f3601d.close();
            } catch (IOException e2) {
            }
            this.f3601d = null;
        }
        if (this.f3599b != null) {
            try {
                this.f3599b.destroy();
            } catch (Exception e3) {
            }
            this.f3599b = null;
        }
    }

    /* JADX WARNING: Missing block: B:12:0x0026, code:
            if (java.lang.System.currentTimeMillis() >= r6) goto L_0x0028;
     */
    /* renamed from: b */
    private synchronized boolean m3732b(long r14) {
        /*
        r13 = this;
        r10 = 0;
        r3 = 0;
        r1 = 1;
        monitor-enter(r13);
        r4 = com.shuame.rootgenius.common.p103d.C1326a.m3735e();	 Catch:{ Exception -> 0x00fc }
        r0 = r13.f3600c;	 Catch:{ Exception -> 0x00fc }
        com.shuame.rootgenius.common.p103d.C1326a.m3726a(r0, r4);	 Catch:{ Exception -> 0x00fc }
        r0 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1));
        if (r0 > 0) goto L_0x0015;
    L_0x0012:
        r14 = 35000; // 0x88b8 float:4.9045E-41 double:1.72923E-319;
    L_0x0015:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00fc }
        r6 = r6 + r14;
        r0 = r3;
        r2 = r3;
    L_0x001c:
        r5 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1));
        if (r5 <= 0) goto L_0x0028;
    L_0x0020:
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0106 }
        r5 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r5 < 0) goto L_0x002c;
    L_0x0028:
        r5 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1));
        if (r5 >= 0) goto L_0x0111;
    L_0x002c:
        r5 = r13.f3601d;	 Catch:{ Exception -> 0x0106 }
        r5 = r5.available();	 Catch:{ Exception -> 0x0106 }
        if (r5 <= 0) goto L_0x0050;
    L_0x0034:
        r5 = r13.f3601d;	 Catch:{ Exception -> 0x0106 }
        r5 = r5.readLine();	 Catch:{ Exception -> 0x0106 }
        if (r5 == 0) goto L_0x0050;
    L_0x003c:
        r8 = com.shuame.rootgenius.common.p103d.C1326a.m3730a(r5);	 Catch:{ Exception -> 0x0106 }
        if (r8 == 0) goto L_0x0047;
    L_0x0042:
        r13.f3602e = r5;	 Catch:{ Exception -> 0x0106 }
        r0 = r1;
        r2 = r3;
        goto L_0x002c;
    L_0x0047:
        r5 = r5.contains(r4);	 Catch:{ Exception -> 0x0106 }
        if (r5 == 0) goto L_0x002c;
    L_0x004d:
        r0 = r1;
        r2 = r1;
        goto L_0x002c;
    L_0x0050:
        r5 = r13.f3599b;	 Catch:{ Exception -> 0x00df }
        r5 = r5.exitValue();	 Catch:{ Exception -> 0x00df }
        if (r5 <= 0) goto L_0x005a;
    L_0x0058:
        r0 = r1;
        r2 = r3;
    L_0x005a:
        r12 = r0;
        r0 = r2;
        r2 = r12;
    L_0x005d:
        if (r2 == 0) goto L_0x010c;
    L_0x005f:
        if (r0 == 0) goto L_0x00fa;
    L_0x0061:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x010a }
        r2.<init>();	 Catch:{ Exception -> 0x010a }
        r4 = new java.util.Random;	 Catch:{ Exception -> 0x010a }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x010a }
        r4.<init>(r6);	 Catch:{ Exception -> 0x010a }
        r4 = r4.nextLong();	 Catch:{ Exception -> 0x010a }
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x010a }
        r4 = r2.toString();	 Catch:{ Exception -> 0x010a }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x010a }
        r2.<init>();	 Catch:{ Exception -> 0x010a }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x010a }
        r6 = "echo ";
        r5.<init>(r6);	 Catch:{ Exception -> 0x010a }
        r5 = r5.append(r4);	 Catch:{ Exception -> 0x010a }
        r6 = " > /cache/.shuame-mobile-root-check\n";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x010a }
        r5 = r5.toString();	 Catch:{ Exception -> 0x010a }
        r2.append(r5);	 Catch:{ Exception -> 0x010a }
        r5 = "cat /cache/.shuame-mobile-root-check\n";
        r2.append(r5);	 Catch:{ Exception -> 0x010a }
        r5 = "rm /cache/.shuame-mobile-root-check";
        r2.append(r5);	 Catch:{ Exception -> 0x010a }
        r5 = com.shuame.rootgenius.common.p103d.C1326a.m3735e();	 Catch:{ Exception -> 0x010a }
        r6 = r13.f3600c;	 Catch:{ Exception -> 0x010a }
        r2 = r2.toString();	 Catch:{ Exception -> 0x010a }
        com.shuame.rootgenius.common.p103d.C1326a.m3727a(r6, r2, r5);	 Catch:{ Exception -> 0x010a }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x010a }
        r8 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r6 = r6 + r8;
        r2 = r3;
        r0 = r3;
    L_0x00b8:
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x010a }
        r3 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r3 >= 0) goto L_0x00fa;
    L_0x00c0:
        r3 = r13.f3601d;	 Catch:{ Exception -> 0x010a }
        r3 = r3.available();	 Catch:{ Exception -> 0x010a }
        if (r3 <= 0) goto L_0x00f8;
    L_0x00c8:
        r3 = r13.f3601d;	 Catch:{ Exception -> 0x010a }
        r3 = r3.readLine();	 Catch:{ Exception -> 0x010a }
        if (r3 == 0) goto L_0x00f8;
    L_0x00d0:
        r5 = r3.toLowerCase();	 Catch:{ Exception -> 0x010a }
        r8 = "read-only file system";
        r5 = r5.contains(r8);	 Catch:{ Exception -> 0x010a }
        if (r5 == 0) goto L_0x00e5;
    L_0x00dc:
        r2 = r1;
        r0 = r1;
        goto L_0x00c0;
    L_0x00df:
        r5 = move-exception;
        r12 = r0;
        r0 = r2;
        r2 = r12;
        goto L_0x005d;
    L_0x00e5:
        r5 = r3.contains(r4);	 Catch:{ Exception -> 0x010a }
        if (r5 == 0) goto L_0x00ee;
    L_0x00eb:
        r2 = r1;
        r0 = r1;
        goto L_0x00c0;
    L_0x00ee:
        r5 = "--SHUAME_MOBILE_CHECK_CMD_END--";
        r3 = r3.contains(r5);	 Catch:{ Exception -> 0x010a }
        if (r3 == 0) goto L_0x00c0;
    L_0x00f6:
        r2 = r1;
        goto L_0x00c0;
    L_0x00f8:
        if (r2 == 0) goto L_0x00b8;
    L_0x00fa:
        monitor-exit(r13);
        return r0;
    L_0x00fc:
        r0 = move-exception;
        r1 = r0;
        r0 = r3;
    L_0x00ff:
        r1.printStackTrace();	 Catch:{ all -> 0x0103 }
        goto L_0x00fa;
    L_0x0103:
        r0 = move-exception;
        monitor-exit(r13);
        throw r0;
    L_0x0106:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
        goto L_0x00ff;
    L_0x010a:
        r1 = move-exception;
        goto L_0x00ff;
    L_0x010c:
        r12 = r2;
        r2 = r0;
        r0 = r12;
        goto L_0x001c;
    L_0x0111:
        r0 = r2;
        goto L_0x005f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.common.d.a.b(long):boolean");
    }

    /* renamed from: c */
    private synchronized boolean m3733c() {
        return this.f3604g ? m3729a(0) : m3734d();
    }

    /* renamed from: d */
    private synchronized boolean m3734d() {
        boolean z = true;
        synchronized (this) {
            try {
                m3731b();
                ProcessBuilder processBuilder = new ProcessBuilder(new String[]{"/system/bin/sh"});
                processBuilder.redirectErrorStream(true);
                this.f3599b = processBuilder.start();
                this.f3600c = new DataOutputStream(this.f3599b.getOutputStream());
                this.f3601d = new DataInputStream(this.f3599b.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
                z = false;
            }
            if (!z) {
                m3731b();
            }
        }
        return z;
    }

    /* renamed from: e */
    private static String m3735e() {
        return "--SHUAME_MOBILE_CHECK_CMD_END--" + System.currentTimeMillis();
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0092 A:{SYNTHETIC, Splitter: B:45:0x0092} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0092 A:{SYNTHETIC, Splitter: B:45:0x0092} */
    /* JADX WARNING: Missing block: B:69:0x012c, code:
            if (r2 != null) goto L_0x012e;
     */
    /* renamed from: a */
    public final synchronized java.lang.String mo7002a(java.lang.String r15, long r16, int r18) {
        /*
        r14 = this;
        monitor-enter(r14);
        r2 = r14.f3604g;	 Catch:{ all -> 0x0127 }
        if (r2 == 0) goto L_0x0050;
    L_0x0005:
        r2 = "execSuCmd";
        r5 = r2;
    L_0x0008:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0127 }
        r2.<init>();	 Catch:{ all -> 0x0127 }
        r2 = r2.append(r5);	 Catch:{ all -> 0x0127 }
        r3 = " suCmd:";
        r3 = r2.append(r3);	 Catch:{ all -> 0x0127 }
        r2 = r14.f3603f;	 Catch:{ all -> 0x0127 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x0127 }
        if (r2 == 0) goto L_0x0054;
    L_0x001f:
        r2 = "su";
    L_0x0021:
        r3.append(r2);	 Catch:{ all -> 0x0127 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0127 }
        r2.<init>();	 Catch:{ all -> 0x0127 }
        r2 = r2.append(r5);	 Catch:{ all -> 0x0127 }
        r3 = " start cmd:";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0127 }
        r2.append(r15);	 Catch:{ all -> 0x0127 }
        r6 = new java.lang.StringBuffer;	 Catch:{ all -> 0x0127 }
        r6.<init>();	 Catch:{ all -> 0x0127 }
        r3 = 0;
    L_0x003c:
        r2 = r14.m3728a();	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        if (r2 != 0) goto L_0x005a;
    L_0x0042:
        r2 = r14.m3733c();	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        if (r2 != 0) goto L_0x005a;
    L_0x0048:
        r2 = r14.f3604g;	 Catch:{ IOException -> 0x014d, Exception -> 0x0149 }
        if (r2 == 0) goto L_0x0057;
    L_0x004c:
        r2 = "Create su process failed!";
    L_0x004e:
        monitor-exit(r14);
        return r2;
    L_0x0050:
        r2 = "execCmd";
        r5 = r2;
        goto L_0x0008;
    L_0x0054:
        r2 = r14.f3603f;	 Catch:{ all -> 0x0127 }
        goto L_0x0021;
    L_0x0057:
        r2 = "Create shell process failed!";
        goto L_0x004e;
    L_0x005a:
        r2 = 0;
        r6.setLength(r2);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
    L_0x005e:
        r2 = r14.f3601d;	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r2 = r2.available();	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        if (r2 <= 0) goto L_0x00a9;
    L_0x0066:
        r2 = r14.f3601d;	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r2 = r2.readLine();	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        if (r2 == 0) goto L_0x00a9;
    L_0x006e:
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r4.<init>();	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r7 = " prev stdout:";
        r4 = r4.append(r7);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r4.append(r2);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        goto L_0x005e;
    L_0x0081:
        r2 = move-exception;
    L_0x0082:
        r2.printStackTrace();	 Catch:{ all -> 0x0127 }
    L_0x0085:
        r0 = r18;
        if (r3 >= r0) goto L_0x008e;
    L_0x0089:
        r8 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        java.lang.Thread.sleep(r8);	 Catch:{ InterruptedException -> 0x0146 }
    L_0x008e:
        r0 = r18;
        if (r3 < r0) goto L_0x003c;
    L_0x0092:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0127 }
        r2.<init>();	 Catch:{ all -> 0x0127 }
        r2 = r2.append(r5);	 Catch:{ all -> 0x0127 }
        r3 = " end cmd:";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0127 }
        r2.append(r15);	 Catch:{ all -> 0x0127 }
        r2 = r6.toString();	 Catch:{ all -> 0x0127 }
        goto L_0x004e;
    L_0x00a9:
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r2.<init>();	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r2 = r2.append(r5);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r4 = " tryCount:";
        r2 = r2.append(r4);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r4 = "; cmd:";
        r2 = r2.append(r4);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r2.append(r15);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r7 = com.shuame.rootgenius.common.p103d.C1326a.m3735e();	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r2 = r14.f3600c;	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        com.shuame.rootgenius.common.p103d.C1326a.m3727a(r2, r15, r7);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r2 = 0;
        r4 = 0;
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r8 = r8 + r16;
        r10 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r10.<init>();	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r10 = r10.append(r5);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r11 = " before while";
        r10.append(r11);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
    L_0x00e4:
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
        if (r10 >= 0) goto L_0x012e;
    L_0x00ec:
        r10 = r14.f3601d;	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r10 = r10.available();	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        if (r10 <= 0) goto L_0x012c;
    L_0x00f4:
        r10 = r14.f3601d;	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r10 = r10.readLine();	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        if (r10 == 0) goto L_0x012c;
    L_0x00fc:
        r11 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r11.<init>();	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r11 = r11.append(r5);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r12 = " stdout:";
        r11 = r11.append(r12);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r11.append(r10);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r11 = r10.contains(r7);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        if (r11 == 0) goto L_0x0116;
    L_0x0114:
        r2 = 1;
        goto L_0x00ec;
    L_0x0116:
        if (r4 == 0) goto L_0x012a;
    L_0x0118:
        r11 = "\n";
        r6.append(r11);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
    L_0x011d:
        r6.append(r10);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        goto L_0x00ec;
    L_0x0121:
        r2 = move-exception;
    L_0x0122:
        r2.printStackTrace();	 Catch:{ all -> 0x0127 }
        goto L_0x0085;
    L_0x0127:
        r2 = move-exception;
        monitor-exit(r14);
        throw r2;
    L_0x012a:
        r4 = 1;
        goto L_0x011d;
    L_0x012c:
        if (r2 == 0) goto L_0x00e4;
    L_0x012e:
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r4.<init>();	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        r7 = " after while";
        r4.append(r7);	 Catch:{ IOException -> 0x0081, Exception -> 0x0121 }
        if (r2 == 0) goto L_0x0142;
    L_0x013e:
        r3 = r18;
        goto L_0x0085;
    L_0x0142:
        r3 = r3 + 1;
        goto L_0x0085;
    L_0x0146:
        r2 = move-exception;
        goto L_0x008e;
    L_0x0149:
        r2 = move-exception;
        r3 = r18;
        goto L_0x0122;
    L_0x014d:
        r2 = move-exception;
        r3 = r18;
        goto L_0x0082;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.common.d.a.a(java.lang.String, long, int):java.lang.String");
    }
}
