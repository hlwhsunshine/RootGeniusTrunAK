package com.kingroot.sdk;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.p014os.SystemProperties;
import android.text.TextUtils;
import com.kingroot.sdk.C0726cw.C0725a;
import com.kingroot.sdk.util.C0880a;
import com.kingroot.sdk.util.C0883c;
import com.kingroot.sdk.util.C0885e;
import com.kingroot.sdk.util.C0886f;
import com.kingroot.sdk.util.C0887g;
import com.kingroot.sdk.util.C0894m;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import krsdk.RootShell;

/* renamed from: com.kingroot.sdk.dt */
public class C0760dt {
    /* renamed from: fW */
    private static C0760dt f1848fW;
    /* renamed from: fX */
    private File f1849fX;
    /* renamed from: fY */
    private File f1850fY;

    private C0760dt(Context context) {
        this.f1849fX = new File(context.getDir("slog", 0), "actsts");
        this.f1850fY = new File(context.getDir("slog", 0), "rest");
    }

    /* renamed from: C */
    private boolean m1854C(int i) {
        return i == 200022 || i == 200023 || i == 200027 || i == 200028 || i == 200029 || i == 200040 || i == 200041 || i == 200042 || i == 200043 || i == 200021 || i == 200013 || i == 200014 || i == 200015 || i == 200016 || i == 200020 || i == 200048 || i == 200049;
    }

    /* renamed from: E */
    public static synchronized C0760dt m1855E(Context context) {
        C0760dt c0760dt;
        synchronized (C0760dt.class) {
            if (f1848fW == null) {
                f1848fW = new C0760dt(context);
            }
            c0760dt = f1848fW;
        }
        return c0760dt;
    }

    /* renamed from: S */
    private static C0788ep m1856S(String str) {
        C0788ep c0788ep = null;
        if (str != null) {
            String[] split = str.split("\t");
            if (split.length >= 4) {
                c0788ep = new C0788ep();
                try {
                    c0788ep.f1947id = Integer.parseInt(split[0]);
                } catch (Throwable e) {
                    C0633at.m1458a("line2sui_1", e);
                    c0788ep.f1947id = -1;
                }
                try {
                    c0788ep.f1948x = Integer.parseInt(split[1]);
                } catch (Throwable e2) {
                    C0633at.m1458a("line2sui_2", e2);
                    c0788ep.f1948x = -1;
                }
                c0788ep.f1943hN = split[2];
                c0788ep.f1945hP = str.substring(((split[0].length() + split[1].length()) + split[2].length()) + 3);
            }
        }
        return c0788ep;
    }

    /* renamed from: T */
    private static C0778ef m1857T(String str) {
        C0778ef c0778ef = null;
        if (str != null) {
            String[] split = str.split("\t");
            if (split.length >= 5) {
                c0778ef = new C0778ef();
                c0778ef.f1901hm = split[0];
                try {
                    c0778ef.index = Integer.parseInt(split[1]);
                } catch (NumberFormatException e) {
                    c0778ef.index = -1;
                }
                try {
                    c0778ef.f1902hn = Integer.parseInt(split[2]);
                } catch (NumberFormatException e2) {
                    c0778ef.f1902hn = -1;
                }
                try {
                    c0778ef.f1903ho = Integer.parseInt(split[3]);
                } catch (NumberFormatException e3) {
                    c0778ef.f1903ho = -1;
                }
                try {
                    c0778ef.f1904hp = Long.parseLong(split[4]);
                } catch (NumberFormatException e4) {
                    c0778ef.f1904hp = -1;
                }
            }
        }
        return c0778ef;
    }

    /* renamed from: U */
    private String m1858U(String str) {
        return m1868j(C0628ar.m1453q(str));
    }

    /* renamed from: a */
    private String m1860a(int i, int i2, int i3, int i4, String str, String str2) {
        if (str2 != null) {
            str2 = m1868j(str2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append('|');
        stringBuilder.append(i2);
        stringBuilder.append('|');
        stringBuilder.append(m1868j(C0628ar.m1450E()));
        stringBuilder.append('|');
        stringBuilder.append(m1868j(C0628ar.m1451F()));
        stringBuilder.append('|');
        stringBuilder.append(Build.BRAND);
        stringBuilder.append('|');
        stringBuilder.append(Build.MODEL);
        stringBuilder.append('|');
        stringBuilder.append(VERSION.SDK);
        stringBuilder.append('|');
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append('|');
        stringBuilder.append(i3);
        stringBuilder.append('|');
        stringBuilder.append(C0741dg.m1804aL().f1806em.f5191kw);
        stringBuilder.append('|');
        stringBuilder.append(i4);
        stringBuilder.append('|');
        stringBuilder.append(str);
        stringBuilder.append('|');
        stringBuilder.append(str2);
        String stringBuilder2 = stringBuilder.toString();
        stringBuilder.delete(0, stringBuilder.length());
        return stringBuilder2;
    }

    /* renamed from: a */
    private static String m1861a(C0778ef c0778ef) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c0778ef.f1901hm).append("\t");
        stringBuilder.append(c0778ef.index).append("\t");
        stringBuilder.append(c0778ef.f1902hn).append("\t");
        stringBuilder.append(c0778ef.f1903ho).append("\t");
        stringBuilder.append(c0778ef.f1904hp);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static String m1862a(C0788ep c0788ep) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c0788ep.f1947id).append("\t");
        stringBuilder.append(c0788ep.f1948x).append("\t");
        stringBuilder.append(c0788ep.f1943hN).append("\t");
        stringBuilder.append(c0788ep.f1945hP);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private String m1863a(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? str3.replace(str, str2) : str3;
    }

    /* renamed from: a */
    private void m1864a(int i, String str, Handler handler) {
        final C0788ep c0788ep = new C0788ep();
        c0788ep.f1947id = i;
        c0788ep.f1948x = (int) (System.currentTimeMillis() / 1000);
        c0788ep.f1943hN = "1";
        c0788ep.f1945hP = str;
        handler.post(new Runnable() {
            public void run() {
                try {
                    C0885e.m2420a(C0760dt.this.f1849fX, C0760dt.m1862a(c0788ep));
                    C0739de.m1798b(C0741dg.m1804aL().f1805el, "has_action_stats", 1);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* renamed from: j */
    private String m1868j(String str) {
        return m1863a("\t", "%09", m1863a("\n", "%0A", m1863a("|", "%7C", m1863a(";", "%3B", str))));
    }

    /* renamed from: a */
    public void mo5754a(Handler handler, Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m1860a(2, 1, 0, 0, "0", ""));
        stringBuilder.append('|');
        stringBuilder.append(m1868j(SystemProperties.get("ro.board.platform")) + ';' + m1868j(SystemProperties.get("ro.mtk.hardware")) + ';' + m1868j(SystemProperties.get("ro.hardware")));
        stringBuilder.append('|');
        stringBuilder.append(m1868j(SystemProperties.get("ro.miui.ui.version.code")) + ';' + m1868j(SystemProperties.get("ro.miui.ui.version.name")));
        stringBuilder.append('|');
        stringBuilder.append(m1868j(SystemProperties.get("ro.cm.device")) + ';' + m1868j(SystemProperties.get("ro.cm.version")));
        stringBuilder.append('|');
        stringBuilder.append(m1868j(SystemProperties.get("ro.build.version.opporom")));
        stringBuilder.append('|');
        stringBuilder.append(C0627aq.m1443A());
        stringBuilder.append('|');
        stringBuilder.append(C0627aq.f1567bU);
        for (int i = 6; i < 10; i++) {
            stringBuilder.append('|');
        }
        stringBuilder.append(C0625ao.f1552bJ);
        String stringBuilder2 = stringBuilder.toString();
        stringBuilder.delete(0, stringBuilder.length());
        C0756dq.f1839fM = stringBuilder2;
        m1864a(200011, stringBuilder2, handler);
    }

    /* renamed from: a */
    public void mo5755a(Handler handler, C0726cw c0726cw, int i) {
        if (c0726cw != null) {
            C0778ef c0778ef = new C0778ef();
            c0778ef.f1904hp = (long) i;
            c0778ef.f1901hm = c0726cw.f1746bK;
            c0778ef.index = c0726cw.f1752ev;
            c0778ef.type = c0726cw.f1753ew;
            c0778ef.f1902hn = (int) (c0726cw.startTime / 1000);
            c0778ef.f1903ho = c0778ef.f1902hn + ((int) (((c0726cw.f1755ey - c0726cw.f1754ex) / 1000000) / 1000));
            mo5757a(c0778ef, handler);
        }
    }

    /* renamed from: a */
    public void mo5756a(Handler handler, String str, int i, long j, long j2, int i2, String str2) {
        mo5758a(null, 200053, 0, "0", "", handler, str, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), str2);
    }

    /* renamed from: a */
    public void mo5757a(final C0778ef c0778ef, Handler handler) {
        handler.post(new Runnable() {
            public void run() {
                C0885e.m2420a(C0760dt.this.f1850fY, C0760dt.m1861a(c0778ef));
            }
        });
    }

    /* renamed from: a */
    public void mo5758a(String str, int i, int i2, String str2, String str3, Handler handler, Object... objArr) {
        int length;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m1860a(0, 1, C0627aq.f1567bU, i2, str2, str3));
        for (Object obj : objArr) {
            stringBuilder.append('|');
            if (obj != null) {
                stringBuilder.append(m1868j(obj.toString()));
            }
        }
        for (length = objArr.length; length < 10; length++) {
            stringBuilder.append('|');
            if (length == 8 && m1854C(i)) {
                stringBuilder.append(C0887g.m2425bk());
            }
        }
        if (str == null || str.trim().length() == 0) {
            str = C0625ao.f1552bJ;
        }
        stringBuilder.append(str);
        String stringBuilder2 = stringBuilder.toString();
        stringBuilder.delete(0, stringBuilder.length());
        m1864a(i, stringBuilder2, handler);
        C0633at.m1464h("EMID : " + C0773eb.getAction(i) + ", pv = " + stringBuilder2);
    }

    /* renamed from: a */
    public void mo5759a(String str, int i, String str2, String str3, Handler handler, Object... objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m1860a(1, 1, C0627aq.f1567bU, i, str2, str3));
        stringBuilder.append('|').append(str);
        for (Object obj : objArr) {
            stringBuilder.append('|');
            if (obj != null) {
                stringBuilder.append(obj.toString());
            }
        }
        int length = objArr.length;
        while (true) {
            length++;
            if (length < 10) {
                stringBuilder.append('|');
            } else {
                stringBuilder.append(C0625ao.f1552bJ);
                String stringBuilder2 = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                m1864a(200034, stringBuilder2, handler);
                C0633at.m1466r("[Trace] " + str + " : " + stringBuilder2);
                return;
            }
        }
    }

    /* renamed from: a */
    public void mo5760a(String str, Handler handler, C0726cw c0726cw, C0725a c0725a, RootShell rootShell, RootShell rootShell2, boolean z) {
        String str2;
        int i;
        int i2;
        long j;
        Object obj;
        if (c0726cw == null) {
            str2 = "0";
            i = -1;
            i2 = 0;
            j = 0;
        } else {
            long j2 = (c0726cw.f1755ey - c0725a.f1743eF) / 1000000;
            int i3 = c0726cw.f1752ev + 1;
            str2 = c0726cw.f1746bK;
            i = c0726cw.f1756ez;
            i2 = i3;
            j = j2;
        }
        Object obj2 = rootShell != null ? 1 : null;
        Object obj3 = rootShell2 != null ? 1 : null;
        if (c0726cw == null || !(c0726cw == null || c0726cw.f1751eE)) {
            obj2 = (obj2 == null || i != 0) ? null : 1;
            obj = (obj3 == null || i != 0) ? null : 1;
            obj3 = obj;
        }
        obj = (c0726cw == null || !c0726cw.f1751eE) ? obj2 : obj3;
        int b = C0719cs.m1732b(rootShell);
        int i4 = obj != null ? 0 : 1;
        String str3 = (c0726cw == null || !c0726cw.f1751eE) ? "0" : "7034";
        String str4 = "";
        Object[] objArr = new Object[5];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Integer.valueOf(c0725a.f1744eG);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(b);
        objArr[4] = obj2 != null ? str2 : "";
        mo5758a(str, 200016, i4, str3, str4, handler, objArr);
        if (z) {
            i4 = obj3 != null ? 0 : 1;
            str3 = "0";
            str4 = "";
            objArr = new Object[6];
            objArr[0] = Integer.valueOf(b);
            objArr[1] = c0725a.f1742eB;
            objArr[2] = Long.valueOf(C0880a.m2380be());
            objArr[3] = Long.valueOf(C0880a.m2381bf());
            if (obj3 == null) {
                str2 = "";
            }
            objArr[4] = str2;
            objArr[5] = Integer.valueOf(1);
            mo5758a(str, 200020, i4, str3, str4, handler, objArr);
        }
    }

    /* renamed from: a */
    public void mo5761a(String str, Handler handler, C0756dq c0756dq, int i, C0726cw c0726cw, int i2) {
        if (c0726cw != null) {
            if (c0756dq != null) {
                C0633at.m1456a(c0756dq, "end verifyR, rootCode = " + i);
            }
            mo5758a(str, 200040, i == 0 ? 0 : 1, String.valueOf(i), "", handler, c0726cw.f1746bK, c0726cw.f1748eB, Integer.valueOf(i2));
        }
    }

    /* renamed from: a */
    public void mo5762a(String str, Handler handler, C0756dq c0756dq, C0726cw c0726cw) {
        if (c0726cw != null) {
            long j = (c0726cw.f1755ey - c0726cw.f1754ex) / 1000000;
            if (c0756dq != null) {
                c0756dq.mo5747Q("sid = " + c0726cw.f1746bK + ", onRoot done. exploitSuc = " + c0726cw.f1756ez + ", childDuingTime = " + j);
            }
            boolean z = c0726cw.f1751eE ? c0726cw.f1750eD : c0726cw.f1756ez == 0;
            String str2 = c0726cw.f1747eA;
            if (str2 == null || str2.equals("0") || str2.equals("")) {
                str2 = C0886f.m2424bj();
            }
            int i = z ? 0 : 1;
            if (c0726cw.f1751eE) {
                str2 = "7034";
            }
            mo5758a(str, 200028, i, str2, C0886f.getMsgAndCause(), handler, c0726cw.f1746bK, Long.valueOf(j));
        }
    }

    /* renamed from: a */
    public void mo5763a(String str, Handler handler, C0756dq c0756dq, RootShell rootShell, C0726cw c0726cw) {
        if (c0726cw != null) {
            if (c0756dq != null) {
                c0756dq.mo5747Q("tmpShell = " + rootShell);
                c0756dq.mo5747Q("KdRootShell.getKDRootShell() : " + C0886f.getMsgAndCause());
            }
            mo5758a(str, 200029, rootShell != null ? 0 : 1, c0726cw.f1751eE ? "7034" : C0886f.m2424bj(), C0886f.getMsgAndCause(), handler, c0726cw.f1746bK, Integer.valueOf(C0719cs.m1732b(rootShell)));
        }
    }

    /* renamed from: a */
    public void mo5764a(String str, Handler handler, C0756dq c0756dq, boolean z, C0726cw c0726cw, int i, int i2) {
        if (c0726cw != null) {
            if (c0756dq != null) {
                c0756dq.mo5747Q("SuRootShell.getSuRootShell() : " + C0886f.getMsgAndCause());
            }
            mo5758a(str, 200041, z ? 0 : 1, C0886f.m2424bj(), C0886f.getMsgAndCause(), handler, c0726cw.f1746bK, c0726cw.f1748eB, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    /* renamed from: aX */
    public ArrayList<C0788ep> mo5765aX() {
        List<String> j = C0885e.m2422j(this.f1849fX);
        ArrayList<C0788ep> arrayList = new ArrayList();
        for (String str : j) {
            C0788ep S = C0760dt.m1856S(str);
            if (S != null) {
                arrayList.add(S);
            } else {
                C0633at.m1465i("sui = null, line = " + str);
            }
        }
        return arrayList;
    }

    /* renamed from: aY */
    public void mo5766aY() {
        C0883c.m2406h(this.f1849fX);
    }

    /* renamed from: aZ */
    public ArrayList<C0778ef> mo5767aZ() {
        List<String> j = C0885e.m2422j(this.f1850fY);
        ArrayList<C0778ef> arrayList = new ArrayList();
        for (String str : j) {
            C0778ef T = C0760dt.m1857T(str);
            if (T != null) {
                arrayList.add(T);
            } else {
                C0633at.m1465i("rootResult = null, line = " + str);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public void mo5768b(Handler handler) {
        int i;
        r8 = new Object[8];
        String str = ";";
        r8[0] = m1858U("ro.board.platform") + str + m1858U("ro.mtk.hardware") + str + m1858U("ro.hardware");
        r8[1] = m1858U("ro.miui.ui.version.code") + str + m1858U("ro.miui.ui.version.name");
        r8[2] = m1858U("ro.cm.device") + str + m1858U("ro.cm.version");
        r8[3] = m1858U("ro.build.version.opporom");
        r8[4] = m1858U("ro.product.cpu.abi");
        r8[5] = m1858U("ro.build.description");
        r8[6] = C0894m.m2455bq();
        r8[7] = C0894m.m2456br();
        C0633at.m1464h(r8.toString());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m1860a(0, 1, C0627aq.f1567bU, 0, "", ""));
        for (i = 0; i < 8; i++) {
            Object obj = r8[i];
            stringBuilder.append('|');
            if (obj != null) {
                stringBuilder.append(obj.toString());
            }
        }
        for (i = 8; i < 10; i++) {
            stringBuilder.append('|');
        }
        stringBuilder.append(C0625ao.f1552bJ);
        str = stringBuilder.toString();
        stringBuilder.delete(0, stringBuilder.length());
        m1864a(200046, str, handler);
        C0633at.m1464h("EMID : " + C0773eb.getAction(200046) + ", pv = " + str);
    }

    /* renamed from: ba */
    public void mo5769ba() {
        C0883c.m2406h(this.f1850fY);
    }
}
