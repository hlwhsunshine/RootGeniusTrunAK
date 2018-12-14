package com.kingroot.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.kingroot.sdk.util.C0885e;
import com.kingroot.sdk.util.C0888h;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* renamed from: com.kingroot.sdk.dj */
public class C0747dj {
    /* renamed from: fo */
    private static C0888h<C0746c> f1829fo = new C0888h(100);
    /* renamed from: fp */
    private static final SimpleDateFormat f1830fp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    /* renamed from: fq */
    private static List<C0744a> f1831fq;

    /* renamed from: com.kingroot.sdk.dj$a */
    public static final class C0744a {
        /* renamed from: dQ */
        public int f1817dQ;
        /* renamed from: ds */
        public String f1818ds;
        /* renamed from: fA */
        public long f1819fA;
        /* renamed from: fw */
        public int f1820fw;
        /* renamed from: fx */
        public String f1821fx;
        /* renamed from: fy */
        public int f1822fy;
        /* renamed from: fz */
        public long f1823fz;

        private C0744a() {
        }

        /* renamed from: A */
        public static void m1808A(int i) {
            SharedPreferences aP = C0744a.m1812aP();
            int i2 = aP.getInt("configscount", 0);
            if (i2 > i) {
                String str = "configs-" + i;
                String str2 = "configs-" + (i2 - 1);
                Editor edit = aP.edit();
                edit.putString(str, aP.getString(str2, ""));
                edit.remove(str2);
                edit.putInt("configscount", i2 - 1);
                edit.commit();
            }
        }

        /* renamed from: O */
        private static String m1809O(String str) {
            return !TextUtils.isEmpty(str) ? str.replace("%3B", ";") : str;
        }

        /* renamed from: a */
        public static void m1810a(String str, String str2, int i, int i2, long j, long j2) {
            SharedPreferences aP = C0744a.m1812aP();
            int i3 = aP.getInt("configscount", 0);
            String str3 = "configs-" + i3;
            Editor edit = aP.edit();
            edit.putString(str3, TextUtils.join(";", new String[]{C0744a.m1813k(str), C0744a.m1813k(str2), String.valueOf(i), String.valueOf(i2), String.valueOf(j), String.valueOf(j2)}));
            edit.putInt("configscount", i3 + 1);
            edit.commit();
            if (C0627aq.f1564aW) {
                String format = C0747dj.f1830fp.format(new Date(j));
                C0633at.m1464h("cloudCmd.startTime = " + format + "\ncloudCmd.stopTime = " + C0747dj.f1830fp.format(new Date(j2)));
            }
        }

        /* renamed from: aO */
        public static List<C0744a> m1811aO() {
            SharedPreferences aP = C0744a.m1812aP();
            int i = aP.getInt("configscount", 0);
            List<C0744a> list = null;
            for (int i2 = 0; i2 < i; i2++) {
                Object string = aP.getString("configs-" + i2, "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        C0744a c0744a = new C0744a();
                        String[] split = string.split(";");
                        c0744a.f1820fw = i2;
                        c0744a.f1818ds = C0744a.m1809O(split[0]);
                        c0744a.f1821fx = C0744a.m1809O(split[1]);
                        c0744a.f1817dQ = Integer.parseInt(split[2]);
                        c0744a.f1822fy = Integer.parseInt(split[3]);
                        c0744a.f1823fz = Long.parseLong(split[4]);
                        c0744a.f1819fA = Long.parseLong(split[5]);
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(c0744a);
                    } catch (Throwable th) {
                        C0633at.m1459a(th);
                    }
                }
            }
            return list;
        }

        /* renamed from: aP */
        private static SharedPreferences m1812aP() {
            return C0741dg.m1804aL().f1805el.getSharedPreferences("shell_counter_config", 0);
        }

        /* renamed from: k */
        private static String m1813k(String str) {
            return !TextUtils.isEmpty(str) ? str.replace(";", "%3B") : str;
        }
    }

    /* renamed from: com.kingroot.sdk.dj$b */
    public static class C0745b {
        /* renamed from: fB */
        String f1824fB;
        /* renamed from: fC */
        long f1825fC;
        /* renamed from: fD */
        long f1826fD;
        int mCount;

        C0745b(String str, int i, long j, long j2) {
            this.f1824fB = str;
            this.mCount = i;
            this.f1825fC = j;
            this.f1826fD = j2;
        }
    }

    /* renamed from: com.kingroot.sdk.dj$c */
    private static class C0746c {
        /* renamed from: fB */
        String f1827fB;
        /* renamed from: fE */
        long f1828fE = System.currentTimeMillis();

        C0746c(String str) {
            this.f1827fB = str;
        }
    }

    /* renamed from: N */
    public static void m1814N(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (f1831fq == null || f1831fq.isEmpty()) {
                List aO = C0744a.m1811aO();
                f1831fq = aO;
                if (aO == null || f1831fq.isEmpty()) {
                    C0633at.m1464h("addCmd: No cloudcmd config.");
                    return;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            f1829fo.add(new C0746c(str));
            HashSet hashSet = null;
            for (C0744a c0744a : f1831fq) {
                if (c0744a == null) {
                    C0633at.m1465i("cloudCmdConfig is NULL.");
                } else {
                    HashSet hashSet2;
                    if (C0627aq.f1564aW) {
                        String format = f1830fp.format(new Date(c0744a.f1823fz));
                        C0633at.m1464h("addCmd: cloudCmd.startTime = " + format + "\ncloudCmd.stopTime = " + f1830fp.format(new Date(c0744a.f1819fA)) + "\nthisTime = " + f1830fp.format(new Date(currentTimeMillis)));
                    }
                    if (currentTimeMillis >= c0744a.f1819fA) {
                        C0633at.m1464h("addCmd: Finished.");
                        C0747dj.m1816a(C0741dg.m1804aL().f1805el, c0744a.f1821fx, c0744a.f1817dQ, c0744a.f1822fy, c0744a.f1823fz, c0744a.f1819fA, c0744a.f1818ds);
                        C0744a.m1808A(c0744a.f1820fw);
                        hashSet2 = hashSet == null ? new HashSet() : hashSet;
                        hashSet2.add(c0744a);
                    } else {
                        hashSet2 = hashSet;
                    }
                    hashSet = hashSet2;
                }
            }
            if (hashSet != null && hashSet.size() > 0) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    f1831fq.remove((C0744a) it.next());
                }
            }
        }
    }

    /* renamed from: a */
    private static C0745b m1815a(String str, long j, long j2) {
        C0746c[] c0746cArr = (C0746c[]) f1829fo.toArray(new C0746c[f1829fo.size()]);
        if (c0746cArr.length <= 0) {
            return null;
        }
        long j3 = c0746cArr[0].f1828fE;
        long j4 = c0746cArr[c0746cArr.length - 1].f1828fE;
        int i = 0;
        String str2 = (str == null || "0".equals(str.trim())) ? "" : str;
        Pattern compile = Pattern.compile(str2);
        for (C0746c c0746c : c0746cArr) {
            if (c0746c.f1828fE >= j && c0746c.f1828fE <= j2 && compile.matcher(c0746c.f1827fB).find()) {
                i++;
            }
        }
        if (i <= 0) {
            return null;
        }
        C0745b c0745b = new C0745b(str2, i, j3, j4);
        C0633at.m1464h("ShellCounter.calculate:: cmd = " + c0745b.f1824fB + ", count = " + c0745b.mCount + "firstTime = " + c0745b.f1825fC + ", lastTime = " + c0745b.f1826fD);
        return c0745b;
    }

    /* renamed from: a */
    public static void m1816a(Context context, String str, int i, int i2, long j, long j2, String str2) {
        HandlerThread handlerThread = C0741dg.m1804aL().f1807fk;
        if (handlerThread == null) {
            C0633at.m1465i("calculateAndReport fail: No ReportThread.");
        } else if (i == 0) {
            C0745b a = C0747dj.m1815a(str, j, j2);
            if (a != null) {
                Handler handler = new Handler(handlerThread.getLooper());
                C0760dt.m1855E(context).mo5756a(handler, str, a.mCount, a.f1825fC, a.f1826fD, i2, str2);
                C0769dy.m1929e(context, handler);
                return;
            }
            C0633at.m1464h("calculateAndReport fail: No ShellCalResult. ");
        } else if (i == 1) {
            final String str3 = str;
            final int i3 = i2;
            final long j3 = j;
            final long j4 = j2;
            final String str4 = str2;
            final Context context2 = context;
            new Handler(handlerThread.getLooper()).post(new Runnable() {
                public final void run() {
                    try {
                        byte[] b = C0747dj.m1817a(str3, i3, j3, j4, str4);
                        if (b == null || b.length <= 0) {
                            C0633at.m1464h("calculateAndReport fail: No data. ");
                        } else {
                            C0761du.m1889f(context2, b);
                        }
                    } catch (Throwable e) {
                        C0633at.m1458a("calculateAndReport fail", e);
                    }
                }
            });
        } else {
            C0633at.m1465i("calculateAndReport fail: Not Support reportType: " + i);
        }
    }

    /* renamed from: a */
    private static byte[] m1817a(String str, int i, long j, long j2, String str2) {
        C0746c[] c0746cArr = (C0746c[]) f1829fo.toArray(new C0746c[f1829fo.size()]);
        if (c0746cArr.length == 0) {
            return null;
        }
        long j3 = c0746cArr[0].f1828fE;
        long j4 = c0746cArr[c0746cArr.length - 1].f1828fE;
        if (str == null || "0".equals(str.trim())) {
            str = "";
        }
        Pattern compile = Pattern.compile(str);
        Closeable byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int i2 = 0;
            for (C0746c c0746c : c0746cArr) {
                if (c0746c.f1828fE >= j && c0746c.f1828fE <= j2 && compile.matcher(c0746c.f1827fB).find()) {
                    i2++;
                    byteArrayOutputStream.write((c0746c.f1827fB + "\n").getBytes());
                }
            }
            if (i2 > 0) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("cmd = ").append(str).append("; ");
                stringBuffer.append("count = ").append(i2).append("; ");
                stringBuffer.append("firstTime = ").append(j3).append("; ");
                stringBuffer.append("lastTime = ").append(j4).append("; ");
                stringBuffer.append("samplingRate = ").append(i).append("; ");
                stringBuffer.append("tipsId = ").append(str2).append("\n");
                byteArrayOutputStream.write(stringBuffer.toString().getBytes());
                byteArrayOutputStream.flush();
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            return toByteArray;
        } finally {
            C0885e.m2419a(byteArrayOutputStream);
        }
    }
}
