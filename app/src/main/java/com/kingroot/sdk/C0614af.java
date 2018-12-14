package com.kingroot.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.kingroot.sdk.C0619ak.C0620a;
import com.kingroot.sdk.C0619ak.C0621b;
import com.kingroot.sdk.util.C0883c;
import java.io.File;

/* renamed from: com.kingroot.sdk.af */
public final class C0614af {
    /* renamed from: aR */
    private static final File f1505aR = new File(C0602ab.f1482aC, "reportroot");
    /* renamed from: aS */
    static final File f1506aS = new File("/dev", "reportroot");
    /* renamed from: aT */
    private static File f1507aT = null;

    /* renamed from: a */
    private static String m1364a(Context context, int i, String str) {
        String str2 = null;
        C0614af.m1370f(context);
        if (f1507aT != null) {
            String str3 = f1507aT.getAbsolutePath() + " " + str + " " + i;
            C0617ai.m1381h("Start scan:" + str3);
            C0731cz b = C0731cz.m1768b(C0731cz.m1767aJ(), 3);
            if (b != null) {
                str2 = b.executeCommand(str3);
            }
            C0617ai.m1381h("Scan ended:" + str2);
        }
        return str2;
    }

    /* renamed from: a */
    private static void m1365a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("\n");
            int length = split.length;
            if (length > 2) {
                long parseLong = Long.parseLong(split[length - 1]);
                int i = 0;
                while (i < length - 1) {
                    Object obj = split[i];
                    if (!TextUtils.isEmpty(obj)) {
                        String[] split2 = obj.split("\t");
                        int length2 = split2.length;
                        if (length2 == 6 || length2 == 7) {
                            C0620a c0620a = new C0620a();
                            c0620a.f1521bh = split2[0];
                            c0620a.f1522bi = split2[1];
                            c0620a.f1523bj = split2[2];
                            c0620a.f1524bk = Long.parseLong(split2[3]);
                            c0620a.f1525bl = split2[4];
                            c0620a.mCount = Integer.parseInt(split2[5]);
                            if (length2 == 7) {
                                c0620a.f1527bn = split2[6];
                            }
                            c0620a.f1526bm = parseLong;
                            c0620a.f1528bo = C0615ag.m1371g(context);
                            c0620a.mo5595q();
                        }
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m1366a(Context context, boolean z) {
        if (C0616ah.m1376c(context, "shell_scan_count") < Integer.MAX_VALUE) {
            C0614af.m1367a(context, true, z);
        }
    }

    /* renamed from: a */
    private static synchronized void m1367a(Context context, boolean z, boolean z2) {
        synchronized (C0614af.class) {
            String str;
            if (z) {
                try {
                    str = "shell_scan_count";
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                str = "su_scan_count";
            }
            String str2 = z ? "shell_last_scan_timestamp" : "su_last_scan_timestamp";
            C0616ah.m1375b(context, str, C0616ah.m1376c(context, str) + 1);
            if (z2 || System.currentTimeMillis() - C0616ah.m1377d(context, str2) >= 259200000) {
                String a = C0614af.m1364a(context, z ? 30 : 180, z ? "shell" : "su");
                if (z) {
                    C0614af.m1365a(context, a);
                } else {
                    C0614af.m1368b(context, a);
                }
                C0616ah.m1374a(context, str2, System.currentTimeMillis());
            } else {
                C0617ai.m1380g("Don't do the scanning, not the time");
            }
        }
        return;
    }

    /* renamed from: b */
    private static void m1368b(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("\n");
            int length = split.length;
            if (length > 2) {
                long parseLong = Long.parseLong(split[length - 1]);
                int i = 0;
                while (i < length - 1) {
                    Object obj = split[i];
                    if (!TextUtils.isEmpty(obj)) {
                        String[] split2 = obj.split("\t");
                        int length2 = split2.length;
                        if (length2 == 6 || length2 == 7) {
                            C0621b c0621b = new C0621b();
                            c0621b.f1532bp = split2[0];
                            c0621b.f1533bq = split2[1];
                            c0621b.f1534br = split2[2];
                            c0621b.f1535bs = Long.parseLong(split2[3]);
                            c0621b.f1536bt = split2[4];
                            c0621b.mCount = Integer.parseInt(split2[5]);
                            if (length2 == 7) {
                                c0621b.f1537bu = split2[6];
                            }
                            c0621b.f1530bm = parseLong;
                            c0621b.f1531bo = C0615ag.m1371g(context);
                            c0621b.mo5597q();
                        }
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static void m1369b(Context context, boolean z) {
        if (C0616ah.m1376c(context, "su_scan_count") < Integer.MAX_VALUE) {
            C0614af.m1367a(context, false, z);
        }
    }

    /* renamed from: f */
    private static void m1370f(Context context) {
        String i = C0883c.m2407i(f1505aR);
        if (i == null) {
            i = "";
        }
        if (!(f1506aS.exists() && i.equalsIgnoreCase(C0883c.m2407i(f1506aS)))) {
            C0731cz.m1768b(C0731cz.m1767aJ(), 3).executeCommand("cat " + f1505aR.getAbsolutePath() + " > " + f1506aS.getAbsolutePath());
            C0731cz b = C0731cz.m1768b(C0731cz.m1767aJ(), 3);
            if (b != null) {
                b.executeCommand("chmod 0755 " + f1506aS.getAbsolutePath());
            }
        }
        if (f1506aS.exists() && i.equalsIgnoreCase(C0883c.m2407i(f1506aS))) {
            f1507aT = f1506aS;
        } else {
            f1507aT = f1505aR;
        }
    }
}
