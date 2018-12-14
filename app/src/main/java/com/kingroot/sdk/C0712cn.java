package com.kingroot.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.kingroot.sdk.C0667bi.C0647a;
import com.kingroot.sdk.util.Posix;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import krsdk.RootShell;
import krsdk.RootShell.ShellResult;

/* renamed from: com.kingroot.sdk.cn */
public class C0712cn {
    /* renamed from: ed */
    private static final Object f1724ed = new Object();
    /* renamed from: ee */
    private static final String f1725ee = ("/dev" + File.separator + "ktools");
    /* renamed from: ef */
    private static C0650gj f1726ef = new C07091();
    /* renamed from: eg */
    private static C0650gj f1727eg = new C07113();

    /* renamed from: com.kingroot.sdk.cn$1 */
    final class C07091 extends C0650gj {
        C07091() {
        }

        /* JADX WARNING: Missing block: B:10:0x0069, code:
            if (r1 == -1) goto L_0x006b;
     */
        public final void run() {
            /*
            r8 = this;
            r7 = -1;
            r0 = 15;
            r2 = com.kingroot.sdk.C0712cn.f1724ed;
            monitor-enter(r2);
            super.run();	 Catch:{ all -> 0x0072 }
            r3 = com.kingroot.sdk.C0712cn.m1709aq();	 Catch:{ all -> 0x0072 }
            r4 = com.kingroot.sdk.C0712cn.m1711as();	 Catch:{ all -> 0x0072 }
            r1 = new java.io.File;	 Catch:{ all -> 0x0072 }
            r1.<init>(r3);	 Catch:{ all -> 0x0072 }
            r1 = r1.exists();	 Catch:{ all -> 0x0072 }
            if (r1 == 0) goto L_0x006b;
        L_0x001e:
            r1 = com.kingroot.sdk.C0707cl.m1695i(r4, r3);	 Catch:{ all -> 0x0072 }
            if (r1 != 0) goto L_0x006b;
        L_0x0024:
            r5 = new com.kingroot.sdk.cl$a;	 Catch:{ all -> 0x0072 }
            r5.<init>();	 Catch:{ all -> 0x0072 }
            r1 = 0;
            r5.f1720dZ = r1;	 Catch:{ all -> 0x0072 }
            r1 = 0;
            r5.f1721ea = r1;	 Catch:{ all -> 0x0072 }
            r1 = 493; // 0x1ed float:6.91E-43 double:2.436E-321;
            r5.mode = r1;	 Catch:{ all -> 0x0072 }
            r1 = "u:object_r:system_file:s0";
            r5.f1722eb = r1;	 Catch:{ all -> 0x0072 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0072 }
            r1.<init>();	 Catch:{ all -> 0x0072 }
            r1 = r1.append(r4);	 Catch:{ all -> 0x0072 }
            r6 = " zls";
            r1 = r1.append(r6);	 Catch:{ all -> 0x0072 }
            r1 = r1.toString();	 Catch:{ all -> 0x0072 }
            r1 = com.kingroot.sdk.C0707cl.m1694a(r1, r3, r5);	 Catch:{ all -> 0x0072 }
            r1 = r1 | 0;
            if (r1 != r7) goto L_0x0075;
        L_0x0052:
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0072 }
            r1.<init>();	 Catch:{ all -> 0x0072 }
            r1 = r1.append(r3);	 Catch:{ all -> 0x0072 }
            r6 = " zls";
            r1 = r1.append(r6);	 Catch:{ all -> 0x0072 }
            r1 = r1.toString();	 Catch:{ all -> 0x0072 }
            r1 = com.kingroot.sdk.C0707cl.m1694a(r1, r3, r5);	 Catch:{ all -> 0x0072 }
            if (r1 != r7) goto L_0x0075;
        L_0x006b:
            if (r0 == 0) goto L_0x0070;
        L_0x006d:
            com.kingroot.sdk.C0712cn.m1707a(r4, r3, r0);	 Catch:{ all -> 0x0072 }
        L_0x0070:
            monitor-exit(r2);	 Catch:{ all -> 0x0072 }
            return;
        L_0x0072:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0072 }
            throw r0;
        L_0x0075:
            r0 = r1;
            goto L_0x006b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.cn.1.run():void");
        }
    }

    /* renamed from: com.kingroot.sdk.cn$2 */
    final class C07102 implements C0647a<Boolean> {
        C07102() {
        }

        /* renamed from: h */
        public final Boolean mo5626a(List<Object> list) {
            boolean z = false;
            String str = (String) list.get(0);
            String str2 = (String) list.get(1);
            int intValue = ((Integer) list.get(2)).intValue();
            RootShell c = C0659bf.m1548c(true);
            if (c != null) {
                List arrayList = new ArrayList(8);
                arrayList.add(C0702ch.m1689a(str + " chattr", str2, false));
                arrayList.add(C0702ch.m1689a(str2 + " chattr", str2, false));
                String substring = (str2.length() <= 1 || !str2.endsWith(File.separator)) ? str2 : str2.substring(0, str2.length() - 1);
                int i = 0;
                while (true) {
                    i = substring.indexOf(File.separatorChar, i + 1);
                    if (i == -1) {
                        break;
                    }
                    File file = new File(substring.substring(0, i));
                    if (!file.getAbsolutePath().equals("/data")) {
                        if (!file.exists()) {
                            C0633at.m1463g("repair " + file.getAbsolutePath() + "...create " + file.getAbsolutePath());
                            arrayList.add("mkdir " + file.getAbsolutePath());
                            arrayList.add("chown 0.0 " + file.getAbsolutePath());
                            arrayList.add("chmod 0755 " + file.getAbsolutePath());
                            arrayList.add("chcon u:object_r:system_data_file:s0 " + file.getAbsolutePath());
                        } else if (file.isDirectory()) {
                            C0633at.m1463g("repair " + file.getAbsolutePath() + "...chown,chmod,chcon " + file.getAbsolutePath());
                            arrayList.add("chown 0.0 " + file.getAbsolutePath());
                            arrayList.add("chmod 0755 " + file.getAbsolutePath());
                            arrayList.add("chcon u:object_r:system_data_file:s0 " + file.getAbsolutePath());
                        } else {
                            C0633at.m1463g("repair " + file.getAbsolutePath() + "...recreate " + file.getAbsolutePath());
                            arrayList.add(C0702ch.m1689a(str + " chattr", file.getAbsolutePath(), false));
                            arrayList.add(C0702ch.m1689a(substring + " chattr", file.getAbsolutePath(), false));
                            arrayList.add("rm " + file.getAbsolutePath());
                            arrayList.add("mkdir " + file.getAbsolutePath());
                            arrayList.add("chown 0.0 " + file.getAbsolutePath());
                            arrayList.add("chmod 0755 " + file.getAbsolutePath());
                            arrayList.add("chcon u:object_r:system_data_file:s0 " + file.getAbsolutePath());
                        }
                    }
                }
                if (C0819fk.m2076c(intValue, 4)) {
                    C0633at.m1463g("repair " + substring + "...cat");
                    arrayList.add("rm " + substring);
                    arrayList.add(String.format("cat %s > %s", new Object[]{str, substring}));
                }
                if (C0819fk.m2076c(intValue, 1)) {
                    C0633at.m1463g("repair " + substring + "...chown");
                    arrayList.add("chown 0.0 " + substring);
                    i = intValue | 2;
                } else {
                    i = intValue;
                }
                if (C0819fk.m2076c(i, 2)) {
                    C0633at.m1463g("repair " + substring + "...chmod");
                    arrayList.add("chmod 0755 " + substring);
                }
                if (C0819fk.m2076c(i, 8)) {
                    C0633at.m1463g("repair " + substring + "...chcon");
                    arrayList.add("chcon u:object_r:system_file:s0 " + substring);
                }
                List executeCommand2 = c.executeCommand2(arrayList);
                for (intValue = 0; intValue < executeCommand2.size(); intValue++) {
                    if (!((ShellResult) executeCommand2.get(intValue)).success()) {
                        str2 = (String) arrayList.get(intValue);
                        if (!(str2.startsWith("rm ") || str2.startsWith("mount") || str2.startsWith("mkdir ") || str2.startsWith(str) || str2.startsWith(substring))) {
                            break;
                        }
                    }
                }
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    /* renamed from: com.kingroot.sdk.cn$3 */
    final class C07113 extends C0650gj {
        C07113() {
        }

        /* JADX WARNING: Missing block: B:17:?, code:
            return;
     */
        /* renamed from: a */
        public final void mo5628a(com.kingroot.sdk.C0650gj.C0651a r4) {
            /*
            r3 = this;
            r1 = com.kingroot.sdk.C0712cn.f1724ed;
            monitor-enter(r1);
            super.run();	 Catch:{ all -> 0x0025 }
            r0 = r4.mo5635cj();	 Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0014;
        L_0x000e:
            r2 = r0.size();	 Catch:{ all -> 0x0025 }
            if (r2 > 0) goto L_0x0016;
        L_0x0014:
            monitor-exit(r1);	 Catch:{ all -> 0x0025 }
        L_0x0015:
            return;
        L_0x0016:
            r2 = 0;
            r0 = r0.get(r2);	 Catch:{ all -> 0x0025 }
            r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0025 }
            r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0025 }
            if (r2 == 0) goto L_0x0028;
        L_0x0023:
            monitor-exit(r1);	 Catch:{ all -> 0x0025 }
            goto L_0x0015;
        L_0x0025:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0025 }
            throw r0;
        L_0x0028:
            com.kingroot.sdk.C0712cn.m1705H(r0);	 Catch:{ all -> 0x0025 }
            monitor-exit(r1);	 Catch:{ all -> 0x0025 }
            goto L_0x0015;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.cn.3.a(com.kingroot.sdk.gj$a):void");
        }
    }

    /* renamed from: G */
    private static void m1704G(String str) {
        if (!TextUtils.isEmpty(str)) {
            List arrayList = new ArrayList();
            arrayList.add(str);
            f1727eg.mo5633m(arrayList);
        }
    }

    /* JADX WARNING: Missing block: B:10:0x0067, code:
            if (r1 == -1) goto L_0x0069;
     */
    /* renamed from: H */
    private static java.lang.String m1705H(java.lang.String r6) {
        /*
        r4 = 0;
        r5 = -1;
        r0 = 15;
        r1 = android.text.TextUtils.isEmpty(r6);
        if (r1 == 0) goto L_0x000f;
    L_0x000a:
        r6 = com.kingroot.sdk.C0712cn.m1711as();
    L_0x000e:
        return r6;
    L_0x000f:
        r2 = com.kingroot.sdk.C0712cn.m1711as();
        r1 = new java.io.File;
        r1.<init>(r6);
        r1 = r1.exists();
        if (r1 == 0) goto L_0x0069;
    L_0x001e:
        r1 = com.kingroot.sdk.C0707cl.m1695i(r2, r6);
        if (r1 != 0) goto L_0x0069;
    L_0x0024:
        r3 = new com.kingroot.sdk.cl$a;
        r3.<init>();
        r3.f1720dZ = r4;
        r3.f1721ea = r4;
        r1 = 493; // 0x1ed float:6.91E-43 double:2.436E-321;
        r3.mode = r1;
        r1 = "u:object_r:system_file:s0";
        r3.f1722eb = r1;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r2);
        r4 = " zls";
        r1 = r1.append(r4);
        r1 = r1.toString();
        r1 = com.kingroot.sdk.C0707cl.m1694a(r1, r6, r3);
        r1 = r1 | 0;
        if (r1 != r5) goto L_0x0076;
    L_0x0050:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r4 = " zls";
        r1 = r1.append(r4);
        r1 = r1.toString();
        r1 = com.kingroot.sdk.C0707cl.m1694a(r1, r6, r3);
        if (r1 != r5) goto L_0x0076;
    L_0x0069:
        if (r0 == 0) goto L_0x0071;
    L_0x006b:
        r0 = com.kingroot.sdk.C0712cn.m1707a(r2, r6, r0);
        if (r0 != 0) goto L_0x000e;
    L_0x0071:
        r6 = com.kingroot.sdk.C0712cn.m1711as();
        goto L_0x000e;
    L_0x0076:
        r0 = r1;
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.cn.H(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private static boolean m1707a(String str, String str2, int i) {
        return ((Boolean) C0667bi.m1577a(new C07102(), str, str2, Integer.valueOf(i))).booleanValue();
    }

    /* renamed from: ap */
    private static boolean m1708ap() {
        return Build.BRAND.toLowerCase(Locale.ENGLISH).contains("samsung");
    }

    /* renamed from: aq */
    private static String m1709aq() {
        Context context = C0741dg.m1804aL().f1805el;
        return context == null ? "/ktools" : Environment.getDataDirectory().getAbsolutePath() + File.separator + "data-lib" + File.separator + context.getPackageName() + File.separator + "ktools";
    }

    /* renamed from: ar */
    public static String m1710ar() {
        return C0708cm.m1699ao().getAbsolutePath() + File.separator + "ktools";
    }

    @TargetApi(9)
    /* renamed from: as */
    private static String m1711as() {
        String ar = C0712cn.m1710ar();
        File file = new File(ar);
        if (!file.exists()) {
            try {
                String absolutePath = new File(C0741dg.m1804aL().f1806em.workingDir, "ktools").getAbsolutePath();
                C0659bf.m1549z("chmod 0755 " + absolutePath);
                Posix.chmod(absolutePath, 493);
                C0659bf.m1549z(String.format("cat %s > %s", new Object[]{absolutePath, ar}));
                C0659bf.m1549z("chmod 0755 " + ar);
                Posix.chmod(ar, 493);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (C0846gi.m2195I() >= 9 && file.exists() && !file.canExecute()) {
            file.setExecutable(true, true);
        }
        return ar;
    }

    /* renamed from: at */
    public static void m1712at() {
        C0712cn.m1713au();
        if (C0712cn.m1708ap()) {
            C0712cn.m1704G(f1725ee);
        }
    }

    /* renamed from: au */
    private static void m1713au() {
        f1726ef.mo5630bs();
    }

    /* renamed from: av */
    public static String m1714av() {
        String aq;
        synchronized (f1724ed) {
            aq = C0712cn.m1709aq();
            File file = new File(C0712cn.m1711as());
            File file2 = new File(aq);
            if (file2.exists() && file2.length() == file.length()) {
            } else {
                C0712cn.m1713au();
                aq = C0712cn.m1711as();
            }
        }
        return aq;
    }

    /* renamed from: aw */
    public static String m1715aw() {
        String str;
        synchronized (f1724ed) {
            File file = new File(C0712cn.m1711as());
            File file2 = new File(f1725ee);
            if (file2.exists() && file2.length() == file.length()) {
                str = f1725ee;
            } else {
                C0712cn.m1704G(f1725ee);
                str = C0712cn.m1711as();
            }
        }
        return str;
    }
}
