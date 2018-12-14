package com.kingroot.sdk;

import android.text.TextUtils;
import com.kingroot.sdk.C0601aa.C0600b;
import com.kingroot.sdk.util.C0885e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kingroot.sdk.ak */
public abstract class C0619ak {
    /* renamed from: bf */
    private static final File f1519bf;

    /* renamed from: com.kingroot.sdk.ak$a */
    public static final class C0620a extends C0619ak {
        /* renamed from: bg */
        private static final File f1520bg = new File(C0619ak.f1519bf, "250002");
        /* renamed from: bh */
        public String f1521bh = "";
        /* renamed from: bi */
        public String f1522bi = "";
        /* renamed from: bj */
        public String f1523bj = "";
        /* renamed from: bk */
        public long f1524bk = 0;
        /* renamed from: bl */
        public String f1525bl = "";
        /* renamed from: bm */
        public long f1526bm = 0;
        /* renamed from: bn */
        public String f1527bn = "";
        /* renamed from: bo */
        public String f1528bo = "";
        public int mCount = 1;

        /* renamed from: r */
        public static List<String> m1405r() {
            return C0619ak.m1397b(f1520bg);
        }

        /* renamed from: s */
        public static boolean m1406s() {
            return C0619ak.m1399c(f1520bg);
        }

        /* renamed from: q */
        public final void mo5595q() {
            C0619ak.m1396a(this, f1520bg);
        }

        public final String toString() {
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder(C0618aj.m1385a(2, 3, C0600b.f1472aA, 0, 0, this.f1527bn, '|'));
            stringBuilder.append('|');
            stringBuilder.append(C0619ak.m1402k(this.f1521bh));
            stringBuilder.append('|');
            stringBuilder.append(C0619ak.m1402k(this.f1522bi));
            stringBuilder.append('|');
            stringBuilder.append(this.f1524bk);
            stringBuilder.append('|');
            stringBuilder.append(this.f1525bl);
            stringBuilder.append('|');
            stringBuilder.append(C0615ag.m1372l() ? 0 : 1);
            stringBuilder.append('|');
            stringBuilder.append(this.f1528bo);
            stringBuilder.append('|');
            stringBuilder.append(this.f1523bj);
            stringBuilder.append('|');
            stringBuilder.append(this.mCount);
            stringBuilder.append('|');
            stringBuilder.append(this.f1526bm);
            stringBuilder.append('|');
            if (!C0615ag.m1373m()) {
                i = 1;
            }
            stringBuilder.append(i);
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.kingroot.sdk.ak$b */
    public static final class C0621b extends C0619ak {
        /* renamed from: bg */
        private static final File f1529bg = new File(C0619ak.f1519bf, "250003");
        /* renamed from: bm */
        public long f1530bm = 0;
        /* renamed from: bo */
        public String f1531bo = "";
        /* renamed from: bp */
        public String f1532bp = "";
        /* renamed from: bq */
        public String f1533bq = "";
        /* renamed from: br */
        public String f1534br = "";
        /* renamed from: bs */
        public long f1535bs = 0;
        /* renamed from: bt */
        public String f1536bt = "";
        /* renamed from: bu */
        public String f1537bu = "";
        public int mCount = 1;

        /* renamed from: r */
        public static List<String> m1408r() {
            return C0619ak.m1397b(f1529bg);
        }

        /* renamed from: s */
        public static boolean m1409s() {
            return C0619ak.m1399c(f1529bg);
        }

        /* renamed from: q */
        public final void mo5597q() {
            C0619ak.m1396a(this, f1529bg);
        }

        public final String toString() {
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder(C0618aj.m1385a(2, 3, C0600b.f1472aA, 0, 0, this.f1537bu, '|'));
            stringBuilder.append('|');
            stringBuilder.append(C0619ak.m1402k(this.f1533bq));
            stringBuilder.append('|');
            stringBuilder.append(C0619ak.m1402k(this.f1532bp));
            stringBuilder.append('|');
            stringBuilder.append(this.f1535bs);
            stringBuilder.append('|');
            stringBuilder.append(this.f1536bt);
            stringBuilder.append('|');
            stringBuilder.append(C0615ag.m1372l() ? 0 : 1);
            stringBuilder.append('|');
            stringBuilder.append(this.f1531bo);
            stringBuilder.append('|');
            stringBuilder.append(this.f1534br);
            stringBuilder.append('|');
            stringBuilder.append(this.mCount);
            stringBuilder.append('|');
            stringBuilder.append(this.f1530bm);
            stringBuilder.append('|');
            if (!C0615ag.m1373m()) {
                i = 1;
            }
            stringBuilder.append(i);
            return stringBuilder.toString();
        }
    }

    static {
        File file = new File(C0602ab.f1482aC, "stat_points");
        if (!file.exists()) {
            file.mkdirs();
        }
        f1519bf = file;
    }

    /* renamed from: a */
    private static String m1395a(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? str3.replace(str, str2) : str3;
    }

    /* renamed from: a */
    private static void m1396a(C0619ak c0619ak, File file) {
        if (file != null) {
            C0885e.m2420a(file, c0619ak.toString());
        }
    }

    /* renamed from: b */
    private static List<String> m1397b(File file) {
        return file == null ? new ArrayList() : C0885e.m2422j(file);
    }

    /* renamed from: c */
    private static boolean m1399c(File file) {
        if (file == null) {
            return false;
        }
        boolean z = true;
        try {
            return file.delete();
        } catch (Exception e) {
            return z;
        }
    }

    /* renamed from: k */
    private static String m1402k(String str) {
        return C0619ak.m1395a("\n", "%0A", C0619ak.m1395a("|", "%7C", C0619ak.m1395a(";", "%3B", str)));
    }
}
