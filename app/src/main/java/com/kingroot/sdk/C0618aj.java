package com.kingroot.sdk;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.p014os.SystemProperties;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.kingroot.sdk.C0601aa.C0599a;
import com.kingroot.sdk.C0601aa.C0600b;
import com.kingroot.sdk.util.C0880a;
import com.kingroot.sdk.util.C0891k;
import com.kingroot.sdk.util.C0893l;
import com.kingroot.sdk.util.C0895n;
import com.kingroot.sdk.util.C0897q;

/* renamed from: com.kingroot.sdk.aj */
public final class C0618aj {
    /* renamed from: aZ */
    private static C0779eg f1513aZ;
    /* renamed from: ba */
    private static C0791es f1514ba;
    /* renamed from: bb */
    private static C0789eq f1515bb;
    /* renamed from: bc */
    private static C0772ea f1516bc;
    /* renamed from: bd */
    private static SparseArray<String> f1517bd = new SparseArray();
    /* renamed from: be */
    private static boolean f1518be = false;

    /* renamed from: a */
    public static C0791es m1383a(Context context, int i) {
        C0791es c0791es = f1514ba;
        c0791es.f1991gQ = C0897q.m2462ab(C0893l.m2440M(context));
        c0791es.f1992gR = C0897q.m2462ab(C0893l.m2441N(context));
        c0791es.f2003iu = C0891k.m2436J(context) == (byte) 0 ? 2 : 1;
        c0791es.f1998ha = C0618aj.m1394o(i);
        c0791es.f1989gL = i;
        return c0791es;
    }

    /* renamed from: a */
    public static String m1384a(int i, int i2, int i3, char c) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(c);
        stringBuilder.append(i2);
        stringBuilder.append(c);
        stringBuilder.append(C0618aj.m1391j(C0628ar.m1450E()));
        stringBuilder.append(c);
        stringBuilder.append(C0618aj.m1391j(C0628ar.m1451F()));
        stringBuilder.append(c);
        stringBuilder.append(Build.BRAND);
        stringBuilder.append(c);
        stringBuilder.append(Build.MODEL);
        stringBuilder.append(c);
        stringBuilder.append(String.valueOf(VERSION.SDK_INT));
        stringBuilder.append(c);
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append(c);
        stringBuilder.append(i3);
        stringBuilder.append(c);
        stringBuilder.append(C0601aa.f1475ax);
        String stringBuilder2 = stringBuilder.toString();
        stringBuilder.delete(0, stringBuilder.length());
        return stringBuilder2;
    }

    /* renamed from: a */
    public static String m1385a(int i, int i2, int i3, int i4, int i5, String str, char c) {
        if (str != null) {
            str = str.replaceAll("\t", "%09").replaceAll("\n", "%0A");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C0618aj.m1384a(i, i2, i3, c));
        stringBuilder.append(c);
        stringBuilder.append(i4);
        stringBuilder.append(c);
        stringBuilder.append(i5);
        stringBuilder.append(c);
        stringBuilder.append(str);
        String stringBuilder2 = stringBuilder.toString();
        stringBuilder.delete(0, stringBuilder.length());
        return stringBuilder2;
    }

    /* renamed from: a */
    private static String m1386a(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? str3.replace(str, str2) : str3;
    }

    /* renamed from: a */
    public static void m1387a(String str, int i) {
        f1517bd.append(i, str);
    }

    /* renamed from: b */
    public static synchronized C0772ea m1388b(Context context, int i) {
        C0772ea c0772ea;
        synchronized (C0618aj.class) {
            c0772ea = f1516bc;
            c0772ea.f1879gQ = C0897q.m2462ab(C0893l.m2440M(context));
            c0772ea.f1880gR = C0897q.m2462ab(C0893l.m2441N(context));
            c0772ea.f1881gS = C0893l.m2442O(context);
            c0772ea.f1882gT = C0897q.m2462ab(C0893l.m2443P(context));
            c0772ea.f1888gZ = C0897q.m2462ab(C0618aj.m1394o(i));
        }
        return c0772ea;
    }

    /* renamed from: c */
    public static C0789eq m1389c(Context context, String str, int i) {
        C0789eq c0789eq = f1515bb;
        c0789eq.f1962ha = C0618aj.m1394o(i);
        c0789eq.f1953gQ = C0897q.m2462ab(C0893l.m2440M(context));
        c0789eq.f1954gR = C0897q.m2462ab(C0893l.m2441N(context));
        c0789eq.name = str;
        return c0789eq;
    }

    /* renamed from: h */
    public static void m1390h(Context context) {
        if (!f1518be) {
            C0779eg c0779eg = new C0779eg();
            f1513aZ = c0779eg;
            c0779eg.f1905hq = 2;
            f1513aZ.f1906hr = 201;
            C0791es c0791es = new C0791es();
            f1514ba = c0791es;
            c0791es.f1988ay = C0600b.f1473ay;
            f1514ba.f1987aA = C0600b.f1472aA;
            f1514ba.f2002it = C0618aj.m1393o();
            f1514ba.f1989gL = 0;
            f1514ba.f1993gV = C0893l.m2439I();
            String[] split = C0600b.f1474az.trim().split("[\\.]");
            f1514ba.f2004iv = new C0783ek();
            try {
                f1514ba.f2004iv.f1918ab = split.length > 0 ? Integer.parseInt(split[0]) : 1;
            } catch (Exception e) {
                f1514ba.f2004iv.f1918ab = 1;
            }
            try {
                f1514ba.f2004iv.f1919ac = split.length >= 2 ? Integer.parseInt(split[1]) : 0;
            } catch (Exception e2) {
                f1514ba.f2004iv.f1919ac = 0;
            }
            try {
                f1514ba.f2004iv.f1920ad = split.length >= 3 ? Integer.parseInt(split[2]) : 0;
            } catch (Exception e3) {
                f1514ba.f2004iv.f1920ad = 0;
            }
            f1514ba.f2005iw = C0895n.m2457g(true);
            f1514ba.f1997hZ = C0601aa.f1475ax;
            C0789eq c0789eq = new C0789eq();
            f1515bb = c0789eq;
            c0789eq.f1949ay = C0599a.f1470ay;
            f1515bb.name = "";
            f1515bb.f1950az = C0599a.f1471az;
            f1515bb.type = 2;
            f1515bb.f1957hV = String.valueOf(VERSION.SDK_INT);
            f1515bb.f1958hW = C0897q.m2462ab(C0893l.m2450bn());
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            f1515bb.f1959hX = "screen=" + displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
            f1515bb.f1963hr = 0;
            f1515bb.f1952gM = 0;
            f1515bb.f1961hZ = C0601aa.f1475ax;
            f1515bb.f1968if = f1514ba.f2005iw;
            C0772ea c0772ea = new C0772ea();
            f1516bc = c0772ea;
            c0772ea.f1883gU = C0897q.m2462ab(C0893l.m2449bm());
            f1516bc.f1884gV = C0893l.m2439I();
            f1516bc.f1885gW = C0897q.m2462ab(C0893l.m2450bn());
            f1516bc.f1886gX = C0897q.m2462ab(C0893l.m2451bo());
            f1516bc.f1887gY = C0897q.m2462ab(C0880a.m2374H(context));
            f1516bc.f1888gZ = "";
            f1518be = true;
        }
    }

    /* renamed from: j */
    private static String m1391j(String str) {
        return C0618aj.m1386a("\n", "%0A", C0618aj.m1386a("|", "%7C", C0618aj.m1386a(";", "%3B", str)));
    }

    /* renamed from: n */
    public static C0779eg m1392n() {
        return f1513aZ;
    }

    /* renamed from: o */
    private static String m1393o() {
        String[] strArr = new String[]{"ro.mediatek.platform", "ro.build.hidden_ver", "ro.product.model"};
        for (int i = 0; i < 3; i++) {
            Object obj = SystemProperties.get(strArr[i]);
            if (!TextUtils.isEmpty(obj)) {
                return obj;
            }
        }
        return Build.MODEL;
    }

    /* renamed from: o */
    public static String m1394o(int i) {
        return C0897q.m2462ab((String) f1517bd.get(i));
    }
}
