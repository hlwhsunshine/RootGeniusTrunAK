package com.kingroot.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.p013pm.PackageManager;
import android.content.p013pm.ServiceInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.kingroot.sdk.gh */
public class C0845gh {

    /* renamed from: com.kingroot.sdk.gh$a */
    public static class C0844a {
        /* renamed from: jE */
        public int f2099jE;
        public String name;
        public int pid;
        public int uid;

        public C0844a() {
            this.pid = 0;
            this.f2099jE = 0;
            this.name = null;
            this.uid = 0;
        }

        public C0844a(int i, int i2, String str, int i3) {
            this.pid = i;
            this.f2099jE = i2;
            this.name = str;
            this.uid = i3;
        }

        public String toString() {
            return "PID=" + this.pid + " PPID=" + this.f2099jE + " NAME=" + this.name + " UID=" + this.uid;
        }
    }

    /* renamed from: A */
    private static void m2187A(Context context, String str) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        PackageManager cf = C0843gg.m2186cf();
        List<RunningServiceInfo> runningServices = activityManager.getRunningServices(100);
        if (runningServices != null) {
            for (RunningServiceInfo runningServiceInfo : runningServices) {
                if (runningServiceInfo.service.getPackageName().equals(str)) {
                    ServiceInfo serviceInfo;
                    try {
                        serviceInfo = cf.getServiceInfo(runningServiceInfo.service, 0);
                    } catch (Throwable e) {
                        C0825fq.m2096a(e);
                        serviceInfo = null;
                    } catch (RuntimeException e2) {
                        serviceInfo = null;
                    }
                    if (serviceInfo != null && serviceInfo.permission == null && serviceInfo.exported) {
                        Intent intent = new Intent();
                        intent.setComponent(runningServiceInfo.service);
                        try {
                            context.stopService(intent);
                        } catch (Exception e3) {
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:? A:{SYNTHETIC, RETURN, ORIG_RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a6 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a6 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A:{SYNTHETIC, RETURN, ORIG_RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A:{SYNTHETIC, RETURN, ORIG_RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a6 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a6 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A:{SYNTHETIC, RETURN, ORIG_RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A:{SYNTHETIC, RETURN, ORIG_RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a6 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a6 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A:{SYNTHETIC, RETURN, ORIG_RETURN, SKIP} */
    /* renamed from: I */
    private static com.kingroot.sdk.C0845gh.C0844a m2188I(int r8) {
        /*
        r0 = 0;
        r3 = -1;
        r1 = java.util.Locale.ENGLISH;	 Catch:{ Exception -> 0x00ab }
        r2 = "/proc/%d/cmdline";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00ab }
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x00ab }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00ab }
        r1 = java.lang.String.format(r1, r2, r4);	 Catch:{ Exception -> 0x00ab }
        r2 = 100;
        r1 = com.kingroot.sdk.C0840gd.m2174c(r1, r2);	 Catch:{ Exception -> 0x00ab }
        if (r1 == 0) goto L_0x00cb;
    L_0x001c:
        r2 = 0;
        r4 = 0;
        r4 = com.kingroot.sdk.C0845gh.m2189a(r1, r2, r4);	 Catch:{ Exception -> 0x00ab }
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x00ab }
        r5 = 0;
        r2.<init>(r1, r5, r4);	 Catch:{ Exception -> 0x00ab }
    L_0x0028:
        r1 = java.util.Locale.ENGLISH;	 Catch:{ Exception -> 0x00b9 }
        r4 = "/proc/%d/status";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x00b9 }
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x00b9 }
        r5[r6] = r7;	 Catch:{ Exception -> 0x00b9 }
        r1 = java.lang.String.format(r1, r4, r5);	 Catch:{ Exception -> 0x00b9 }
        r4 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r1 = com.kingroot.sdk.C0840gd.m2174c(r1, r4);	 Catch:{ Exception -> 0x00b9 }
        if (r1 == 0) goto L_0x00c7;
    L_0x0042:
        r4 = 7;
        r5 = 10;
        r5 = com.kingroot.sdk.C0845gh.m2189a(r1, r4, r5);	 Catch:{ Exception -> 0x00b9 }
        if (r5 == 0) goto L_0x00c7;
    L_0x004b:
        if (r2 != 0) goto L_0x00c5;
    L_0x004d:
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x00b9 }
        r6 = 6;
        r7 = r5 + -6;
        r4.<init>(r1, r6, r7);	 Catch:{ Exception -> 0x00b9 }
    L_0x0055:
        r2 = r5 + 1;
        r5 = 10;
        r2 = com.kingroot.sdk.C0845gh.m2189a(r1, r2, r5);	 Catch:{ Exception -> 0x00bd }
        r2 = r2 + 1;
        r5 = 10;
        r2 = com.kingroot.sdk.C0845gh.m2189a(r1, r2, r5);	 Catch:{ Exception -> 0x00bd }
        r2 = r2 + 1;
        r5 = 10;
        r2 = com.kingroot.sdk.C0845gh.m2189a(r1, r2, r5);	 Catch:{ Exception -> 0x00bd }
        if (r2 == 0) goto L_0x00c2;
    L_0x006f:
        r5 = r2 + 7;
        r2 = r2 + 1;
        r6 = 10;
        r6 = com.kingroot.sdk.C0845gh.m2189a(r1, r2, r6);	 Catch:{ Exception -> 0x00bd }
        if (r6 == 0) goto L_0x00c2;
    L_0x007b:
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x00bd }
        r7 = r6 - r5;
        r2.<init>(r1, r5, r7);	 Catch:{ Exception -> 0x00bd }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ Exception -> 0x00bd }
        r5 = r6 + 1;
        r6 = 10;
        r5 = com.kingroot.sdk.C0845gh.m2189a(r1, r5, r6);	 Catch:{ Exception -> 0x00c0 }
        if (r5 == 0) goto L_0x00b1;
    L_0x0090:
        r5 = r5 + 6;
        r6 = r5 + 1;
        r7 = 9;
        r6 = com.kingroot.sdk.C0845gh.m2189a(r1, r6, r7);	 Catch:{ Exception -> 0x00c0 }
        r7 = new java.lang.String;	 Catch:{ Exception -> 0x00c0 }
        r6 = r6 - r5;
        r7.<init>(r1, r5, r6);	 Catch:{ Exception -> 0x00c0 }
        r1 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x00c0 }
    L_0x00a4:
        if (r4 == 0) goto L_0x00aa;
    L_0x00a6:
        if (r2 == r3) goto L_0x00aa;
    L_0x00a8:
        if (r1 != r3) goto L_0x00b3;
    L_0x00aa:
        return r0;
    L_0x00ab:
        r1 = move-exception;
        r2 = r3;
        r4 = r0;
    L_0x00ae:
        com.kingroot.sdk.C0825fq.m2096a(r1);
    L_0x00b1:
        r1 = r3;
        goto L_0x00a4;
    L_0x00b3:
        r0 = new com.kingroot.sdk.gh$a;
        r0.<init>(r8, r2, r4, r1);
        goto L_0x00aa;
    L_0x00b9:
        r1 = move-exception;
        r4 = r2;
        r2 = r3;
        goto L_0x00ae;
    L_0x00bd:
        r1 = move-exception;
        r2 = r3;
        goto L_0x00ae;
    L_0x00c0:
        r1 = move-exception;
        goto L_0x00ae;
    L_0x00c2:
        r1 = r3;
        r2 = r3;
        goto L_0x00a4;
    L_0x00c5:
        r4 = r2;
        goto L_0x0055;
    L_0x00c7:
        r1 = r3;
        r4 = r2;
        r2 = r3;
        goto L_0x00a4;
    L_0x00cb:
        r2 = r0;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.gh.I(int):com.kingroot.sdk.gh$a");
    }

    /* renamed from: a */
    private static int m2189a(byte[] bArr, int i, char c) {
        int i2 = i - 1;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= bArr.length) {
                return 0;
            }
            if (i3 == bArr.length || bArr[i3] == c) {
                return i3;
            }
            i2 = i3;
        }
    }

    /* renamed from: a */
    public static boolean m2190a(Context context, C0716ga c0716ga, String str) {
        return C0846gi.m2195I() >= 8 ? C0845gh.m2193m(c0716ga, str) : C0845gh.m2194z(context, str);
    }

    /* renamed from: cg */
    private static List<C0844a> m2191cg() {
        List<C0844a> arrayList = new ArrayList();
        for (String str : new File("/proc").list()) {
            try {
                char charAt = str.charAt(0);
                if (charAt <= '9' && charAt >= '0') {
                    C0844a I = C0845gh.m2188I(Integer.parseInt(str));
                    if (I != null) {
                        arrayList.add(I);
                    }
                }
            } catch (Exception e) {
            }
        }
        return arrayList;
    }

    /* renamed from: l */
    public static final synchronized List<C0844a> m2192l(List<String> list) {
        List<C0844a> cg;
        synchronized (C0845gh.class) {
            cg = C0845gh.m2191cg();
            if (list != null) {
                HashSet hashSet = new HashSet();
                hashSet.addAll(list);
                List<C0844a> arrayList = new ArrayList();
                if (list == null || list.size() <= 0) {
                    arrayList.addAll(cg);
                } else {
                    for (C0844a c0844a : cg) {
                        if (hashSet.contains(c0844a.name)) {
                            arrayList.add(c0844a);
                        }
                    }
                }
                cg = arrayList;
            }
        }
        return cg;
    }

    /* renamed from: m */
    private static boolean m2193m(C0716ga c0716ga, String str) {
        return c0716ga.mo5684f(true) && c0716ga.mo5683K("service call activity 79 s16 " + str).success();
    }

    /* renamed from: z */
    private static boolean m2194z(Context context, String str) {
        C0845gh.m2187A(context, str);
        return true;
    }
}
