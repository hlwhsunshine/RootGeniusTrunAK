package com.kingroot.sdk;

import com.kingroot.sdk.C0831fu.C0795a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kingroot.sdk.fb */
public class C0804fb {
    /* renamed from: iP */
    private static final Object f2039iP = new Object();
    /* renamed from: iQ */
    private static String f2040iQ = null;

    /* renamed from: com.kingroot.sdk.fb$1 */
    class C08031 implements C0795a<Object> {
        C08031() {
        }

        /* renamed from: b */
        public Object mo5806b(C0716ga c0716ga, List<Object> list) {
            if (c0716ga.mo5684f(true)) {
                List arrayList = new ArrayList(5);
                arrayList.add(C0820fl.m2077b("/data/system/tmp_init.rc", false));
                arrayList.add("rm /data/system/tmp_init.rc");
                arrayList.add(String.format("cat %s > %s", new Object[]{"/init.rc", "/data/system/tmp_init.rc"}));
                arrayList.add("chmod 0755 /data/system/tmp_init.rc");
                c0716ga.mo5685i(arrayList);
            }
            return null;
        }
    }

    /* renamed from: ae */
    public static void m2015ae(String str) {
        synchronized (f2039iP) {
            f2040iQ = str;
        }
    }

    /* renamed from: e */
    private static void m2016e(C0716ga c0716ga) {
        C0831fu.m2119a(c0716ga, new C08031(), new Object[0]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0087 A:{SYNTHETIC, Splitter: B:34:0x0087} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0094 A:{SYNTHETIC, Splitter: B:41:0x0094} */
    /* JADX WARNING: Missing block: B:25:0x0063, code:
            r1 = r3.getAbsolutePath();
     */
    /* JADX WARNING: Missing block: B:27:?, code:
            com.kingroot.sdk.C0825fq.m2099g("check_su_files", "find install-recovery.sh location..." + r1);
     */
    /* JADX WARNING: Missing block: B:28:0x007b, code:
            r0 = r1;
     */
    /* JADX WARNING: Missing block: B:35:?, code:
            r2.close();
     */
    /* JADX WARNING: Missing block: B:36:0x008b, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:37:0x008c, code:
            com.kingroot.sdk.C0825fq.m2096a(r1);
     */
    /* JADX WARNING: Missing block: B:51:0x00aa, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:52:0x00ab, code:
            r5 = r0;
            r0 = r1;
            r1 = r5;
     */
    /* renamed from: f */
    private static void m2017f(com.kingroot.sdk.C0716ga r6) {
        /*
        r1 = 0;
        if (r6 != 0) goto L_0x0004;
    L_0x0003:
        return;
    L_0x0004:
        com.kingroot.sdk.C0804fb.m2016e(r6);
        r2 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x007d, all -> 0x0090 }
        r0 = new java.io.FileReader;	 Catch:{ IOException -> 0x007d, all -> 0x0090 }
        r3 = "/data/system/tmp_init.rc";
        r0.<init>(r3);	 Catch:{ IOException -> 0x007d, all -> 0x0090 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x007d, all -> 0x0090 }
    L_0x0013:
        r0 = r2.readLine();	 Catch:{ IOException -> 0x00a5 }
        if (r0 != 0) goto L_0x0027;
    L_0x0019:
        r0 = r1;
    L_0x001a:
        r2.close();	 Catch:{ IOException -> 0x009d }
    L_0x001d:
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x0003;
    L_0x0023:
        com.kingroot.sdk.C0804fb.m2015ae(r0);
        goto L_0x0003;
    L_0x0027:
        r0 = r0.trim();	 Catch:{ IOException -> 0x00a5 }
        r3 = "service";
        r3 = r0.startsWith(r3);	 Catch:{ IOException -> 0x00a5 }
        if (r3 == 0) goto L_0x0013;
    L_0x0033:
        r3 = "\\s+";
        r0 = r0.split(r3);	 Catch:{ IOException -> 0x00a5 }
        r3 = r0.length;	 Catch:{ IOException -> 0x00a5 }
        r4 = 3;
        if (r3 < r4) goto L_0x0013;
    L_0x003d:
        r3 = new java.io.File;	 Catch:{ IOException -> 0x00a5 }
        r4 = 2;
        r0 = r0[r4];	 Catch:{ IOException -> 0x00a5 }
        r0 = r0.trim();	 Catch:{ IOException -> 0x00a5 }
        r3.<init>(r0);	 Catch:{ IOException -> 0x00a5 }
        r0 = r3.getName();	 Catch:{ IOException -> 0x00a5 }
        r4 = android.text.TextUtils.isEmpty(r0);	 Catch:{ IOException -> 0x00a5 }
        if (r4 != 0) goto L_0x0013;
    L_0x0053:
        r4 = "install";
        r4 = r0.startsWith(r4);	 Catch:{ IOException -> 0x00a5 }
        if (r4 == 0) goto L_0x0013;
    L_0x005b:
        r4 = "recovery.sh";
        r0 = r0.endsWith(r4);	 Catch:{ IOException -> 0x00a5 }
        if (r0 == 0) goto L_0x0013;
    L_0x0063:
        r1 = r3.getAbsolutePath();	 Catch:{ IOException -> 0x00a5 }
        r0 = "check_su_files";
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00aa }
        r4 = "find install-recovery.sh location...";
        r3.<init>(r4);	 Catch:{ IOException -> 0x00aa }
        r3 = r3.append(r1);	 Catch:{ IOException -> 0x00aa }
        r3 = r3.toString();	 Catch:{ IOException -> 0x00aa }
        com.kingroot.sdk.C0825fq.m2099g(r0, r3);	 Catch:{ IOException -> 0x00aa }
        r0 = r1;
        goto L_0x001a;
    L_0x007d:
        r0 = move-exception;
        r2 = r1;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x0082:
        com.kingroot.sdk.C0825fq.m2096a(r1);	 Catch:{ all -> 0x00a3 }
        if (r2 == 0) goto L_0x001d;
    L_0x0087:
        r2.close();	 Catch:{ IOException -> 0x008b }
        goto L_0x001d;
    L_0x008b:
        r1 = move-exception;
        com.kingroot.sdk.C0825fq.m2096a(r1);
        goto L_0x001d;
    L_0x0090:
        r0 = move-exception;
        r2 = r1;
    L_0x0092:
        if (r2 == 0) goto L_0x0097;
    L_0x0094:
        r2.close();	 Catch:{ IOException -> 0x0098 }
    L_0x0097:
        throw r0;
    L_0x0098:
        r1 = move-exception;
        com.kingroot.sdk.C0825fq.m2096a(r1);
        goto L_0x0097;
    L_0x009d:
        r1 = move-exception;
        com.kingroot.sdk.C0825fq.m2096a(r1);
        goto L_0x001d;
    L_0x00a3:
        r0 = move-exception;
        goto L_0x0092;
    L_0x00a5:
        r0 = move-exception;
        r5 = r0;
        r0 = r1;
        r1 = r5;
        goto L_0x0082;
    L_0x00aa:
        r0 = move-exception;
        r5 = r0;
        r0 = r1;
        r1 = r5;
        goto L_0x0082;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.fb.f(com.kingroot.sdk.ga):void");
    }

    /* renamed from: g */
    public static String m2018g(C0716ga c0716ga) {
        String str;
        synchronized (f2039iP) {
            if (f2040iQ == null) {
                f2040iQ = "/system/etc/install-recovery.sh";
                C0804fb.m2017f(c0716ga);
            }
            str = f2040iQ;
        }
        return str;
    }
}
