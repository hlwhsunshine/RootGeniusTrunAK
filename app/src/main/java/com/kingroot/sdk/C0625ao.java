package com.kingroot.sdk;

import android.content.Context;
import android.content.p013pm.PackageManager.NameNotFoundException;
import android.content.pm.ApplicationInfo;
import com.kingroot.sdk.util.C0880a;
import com.kingroot.sdk.util.C0891k;
import com.kingroot.sdk.util.C0893l;
import com.kingroot.sdk.util.C0895n;
import com.kingroot.sdk.util.C0897q;
import java.util.ArrayList;

/* renamed from: com.kingroot.sdk.ao */
public class C0625ao {
    /* renamed from: bA */
    private static C0791es f1543bA;
    /* renamed from: bB */
    private static C0779eg f1544bB;
    /* renamed from: bC */
    private static C0770dz f1545bC;
    /* renamed from: bD */
    private static C0789eq f1546bD;
    /* renamed from: bE */
    private static C0772ea f1547bE;
    /* renamed from: bF */
    private static C0775ed f1548bF;
    /* renamed from: bG */
    private static C0784el f1549bG;
    /* renamed from: bH */
    private static long f1550bH;
    /* renamed from: bI */
    private static ArrayList<C0778ef> f1551bI;
    /* renamed from: bJ */
    public static String f1552bJ;

    /* renamed from: a */
    public static void m1432a(int i, Context context) {
        C0791es c0791es = new C0791es();
        c0791es.f1988ay = "5CA2B7587B0CDF63";
        c0791es.f1987aA = C0627aq.f1567bU;
        c0791es.f2002it = C0893l.m2444Q(context);
        c0791es.f1989gL = 39;
        c0791es.f1993gV = C0893l.m2439I();
        String[] split = C0627aq.m1447z().trim().split("[\\.]");
        c0791es.f2004iv = new C0783ek();
        c0791es.f2004iv.f1918ab = split.length > 0 ? Integer.parseInt(split[0]) : 1;
        c0791es.f2004iv.f1919ac = split.length >= 2 ? Integer.parseInt(split[1]) : 0;
        c0791es.f2004iv.f1920ad = split.length >= 3 ? Integer.parseInt(split[2]) : 0;
        c0791es.f2005iw = C0895n.m2457g(true);
        f1543bA = c0791es;
        C0779eg c0779eg = new C0779eg();
        c0779eg.f1905hq = 2;
        c0779eg.f1906hr = 201;
        f1544bB = c0779eg;
        C0770dz c0770dz = new C0770dz();
        c0770dz.f1872gL = 39;
        c0770dz.f1873gM = 0;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 8192);
            if (!(applicationInfo == null || (applicationInfo.flags & 1) == 0)) {
                c0770dz.f1873gM = 1;
            }
        } catch (NameNotFoundException e) {
        } catch (Exception e2) {
        }
        f1545bC = c0770dz;
        C0789eq c0789eq = new C0789eq();
        c0789eq.f1949ay = "5CA2B7587B0CDF63";
        c0789eq.name = "EP_KingRoot_SDK";
        c0789eq.f1950az = C0627aq.m1447z().trim();
        c0789eq.type = 2;
        c0789eq.f1957hV = C0897q.m2462ab(C0634au.m1469J());
        c0789eq.f1958hW = C0897q.m2462ab(C0893l.m2450bn());
        c0789eq.f1959hX = "screen=" + C0893l.m2445R(context) + "*" + C0893l.m2446S(context);
        c0789eq.f1963hr = 0;
        c0789eq.f1952gM = 0;
        c0789eq.f1968if = f1543bA.f2005iw;
        f1546bD = c0789eq;
        C0772ea c0772ea = new C0772ea();
        c0772ea.f1883gU = C0897q.m2462ab(C0893l.m2449bm());
        c0772ea.f1884gV = C0634au.m1468I();
        c0772ea.f1885gW = C0897q.m2462ab(C0893l.m2450bn());
        c0772ea.f1886gX = C0897q.m2462ab(C0893l.m2451bo());
        c0772ea.f1887gY = C0897q.m2462ab(C0880a.m2374H(context));
        c0772ea.f1888gZ = C0624an.m1430v();
        f1547bE = c0772ea;
        C0775ed c0775ed = new C0775ed();
        c0775ed.f1891hb = C0623am.m1424t();
        c0775ed.f1892hc = f1544bB;
        c0775ed.f1893hd = i;
        f1548bF = c0775ed;
        f1549bG = new C0784el();
        f1551bI = new ArrayList();
        String p = C0739de.m1802p(context, "session_id");
        if (p != null) {
            try {
                f1550bH = Long.parseLong(p);
                C0633at.m1464h("local sessionId = " + f1550bH);
                return;
            } catch (Exception e3) {
                f1550bH = 0;
            }
        }
        C0633at.m1464h("no local sessionId");
    }

    /* renamed from: a */
    public static void m1433a(long j) {
        f1550bH = j;
    }

    /* renamed from: k */
    public static synchronized C0791es m1434k(Context context) {
        C0791es c0791es;
        synchronized (C0625ao.class) {
            c0791es = f1543bA;
            c0791es.f1991gQ = C0624an.m1429u();
            c0791es.f1992gR = C0897q.m2462ab(C0893l.m2441N(context));
            c0791es.f2003iu = C0891k.m2436J(context) == (byte) 0 ? 2 : 1;
            c0791es.f1998ha = C0624an.m1430v();
        }
        return c0791es;
    }

    /* renamed from: l */
    public static synchronized C0789eq m1435l(Context context) {
        C0789eq c0789eq;
        synchronized (C0625ao.class) {
            c0789eq = f1546bD;
            c0789eq.f1962ha = C0624an.m1430v();
            c0789eq.f1953gQ = C0624an.m1429u();
            c0789eq.f1954gR = C0897q.m2462ab(C0893l.m2441N(context));
        }
        return c0789eq;
    }

    /* renamed from: m */
    public static synchronized C0772ea m1436m(Context context) {
        C0772ea c0772ea;
        synchronized (C0625ao.class) {
            c0772ea = f1547bE;
            c0772ea.f1879gQ = C0624an.m1429u();
            c0772ea.f1880gR = C0897q.m2462ab(C0893l.m2441N(context));
            c0772ea.f1881gS = C0893l.m2442O(context);
            c0772ea.f1882gT = C0897q.m2462ab(C0893l.m2443P(context));
        }
        return c0772ea;
    }

    /* renamed from: n */
    public static synchronized C0775ed m1437n(Context context) {
        C0775ed c0775ed;
        synchronized (C0625ao.class) {
            c0775ed = f1548bF;
        }
        return c0775ed;
    }

    /* renamed from: n */
    public static C0779eg m1438n() {
        return f1544bB;
    }

    /* renamed from: o */
    public static synchronized C0784el m1439o(Context context) {
        C0784el c0784el;
        synchronized (C0625ao.class) {
            c0784el = f1549bG;
            c0784el.f1925hf = f1550bH;
            c0784el.f1923hA = f1551bI;
            c0784el.f1922gS = f1547bE.f1881gS;
            c0784el.f1924hB = C0628ar.m1452G();
        }
        return c0784el;
    }

    /* renamed from: p */
    public static synchronized void m1440p(int i) {
        synchronized (C0625ao.class) {
            f1543bA.f2005iw = i;
        }
    }

    /* renamed from: p */
    public static void m1441p(String str) {
        C0791es c0791es = f1543bA;
        C0770dz c0770dz = f1545bC;
        f1546bD.f1961hZ = str;
        c0770dz.f1871gK = str;
        c0791es.f1997hZ = str;
        f1552bJ = str;
    }

    /* renamed from: x */
    public static C0770dz m1442x() {
        return f1545bC;
    }
}
