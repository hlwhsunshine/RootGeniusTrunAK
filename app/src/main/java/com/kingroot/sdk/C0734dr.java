package com.kingroot.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.kingroot.sdk.util.C0880a;
import com.kingroot.sdk.util.C0886f;
import com.kingroot.sdk.util.C0894m;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import krsdk.C0777b;
import krsdk.C1773a;
import krsdk.C1774c;
import krsdk.RootConfig;
import krsdk.RootExecutor;
import krsdk.RootExecutor.C0733a;
import krsdk.RootShell;

/* renamed from: com.kingroot.sdk.dr */
class C0734dr implements RootExecutor {
    /* renamed from: fS */
    public static String f1787fS = "";
    /* renamed from: el */
    protected Context f1788el;
    /* renamed from: em */
    protected RootConfig f1789em;
    /* renamed from: fO */
    private C0760dt f1790fO;
    /* renamed from: fP */
    private String f1791fP;
    /* renamed from: fQ */
    private C0733a f1792fQ;
    /* renamed from: fR */
    private C0777b f1793fR;
    /* renamed from: fT */
    private boolean f1794fT = false;
    /* renamed from: fU */
    private boolean f1795fU = false;
    /* renamed from: fV */
    private C1774c f1796fV;
    protected Handler handler;

    public C0734dr(Context context, RootConfig rootConfig, Looper looper) {
        C0633at.m1466r("func.YunRootExecutor.<init>");
        this.f1788el = context;
        this.f1789em = rootConfig;
        this.f1791fP = rootConfig.workingDir + File.separator + "kd";
        this.f1790fO = C0760dt.m1855E(context);
        this.handler = new Handler(looper);
        C0760dt.m1855E(context).mo5754a(this.handler, context);
    }

    /* renamed from: a */
    private void m1779a(String str, int i, int i2, String str2, String str3, Object... objArr) {
        this.f1790fO.mo5758a(str, i, i2, str2, str3, this.handler, objArr);
    }

    /* renamed from: B */
    public RootShell mo5723B(int i) {
        return mo5729c(i, null);
    }

    /* renamed from: R */
    protected int mo5724R(String str) {
        C0633at.m1466r("func.RootExecutor.prepare()");
        C0733a c0733a = this.f1792fQ;
        m1779a(str, 200013, 0, "", "", Long.valueOf(C0880a.m2380be()), Long.valueOf(C0880a.m2381bf()));
        long nanoTime = System.nanoTime();
        Object obj = null;
        List arrayList = new ArrayList();
        if (this.f1796fV == null || this.f1796fV.f5200kB == null) {
            C0633at.m1465i("prepare() yis is null or solutionInfoArray is null");
            return 0;
        }
        Object obj2;
        long nanoTime2;
        C0626ap[] c0626apArr = this.f1796fV.f5200kB;
        int i = 0;
        while (true) {
            int i2 = i;
            obj2 = obj;
            if (i2 >= c0626apArr.length) {
                break;
            }
            C0626ap c0626ap = c0626apArr[i2];
            C0633at.m1463g("准备方案：sid = " + c0626ap.f1556bK);
            if (c0733a != null) {
                c0733a.mo5722a(1, i2 + 1, c0626apArr.length, c0626ap.f1556bK);
            }
            boolean a = C0749dk.m1830a(this.f1788el, c0626ap, this.f1789em);
            m1779a(str, 200022, a ? 0 : 1, C0886f.m2424bj(), C0886f.getMsgAndCause(), c0626ap.f1556bK);
            if (a) {
                Object obj3;
                boolean z;
                long nanoTime3 = System.nanoTime();
                boolean a2 = C0749dk.m1829a(this.f1788el, c0626ap);
                if (a2) {
                    a2 = C0749dk.m1832a(c0626ap, i2);
                    if (a2) {
                        obj3 = obj2;
                        z = a2;
                    } else {
                        C0749dk.m1821P(c0626ap.f1556bK);
                        obj3 = obj2;
                        z = a2;
                    }
                } else {
                    C0749dk.m1821P(c0626ap.f1556bK);
                    int obj32 = 1;
                    z = a2;
                }
                nanoTime2 = (System.nanoTime() - nanoTime3) / 1000000;
                m1779a(str, 200023, z ? 0 : 1, C0886f.m2424bj(), C0886f.getMsgAndCause(), c0626ap.f1556bK, Long.valueOf(nanoTime2));
                if (z) {
                    C0633at.m1463g("准备方案成功：sid = " + c0626ap.f1556bK);
                    arrayList.add(c0626ap);
                    obj = obj32;
                } else {
                    C0633at.m1465i("准备方案失败：sid = " + c0626ap.f1556bK);
                    obj = obj32;
                }
            } else {
                C0633at.m1467s("不允许执行2, sid = " + c0626ap.f1556bK + ", KError.code = " + C0886f.m2424bj());
                this.f1790fO.mo5759a("DONT_ALLOW_SOLUTION", 1, C0886f.m2424bj(), C0886f.getMsgAndCause(), this.handler, c0626ap.f1556bK);
                C0749dk.m1821P(c0626ap.f1556bK);
                obj = obj2;
            }
            i = i2 + 1;
        }
        this.f1796fV.f5201kC = (C0626ap[]) arrayList.toArray(new C0626ap[arrayList.size()]);
        if (obj2 != null && this.f1796fV.f5201kC.length == 0) {
            C0633at.m1465i("没有方案下载成功，只怪网络问题");
            this.f1796fV.f5199kA = -6000;
        }
        nanoTime2 = (System.nanoTime() - nanoTime) / 1000000;
        m1779a(str, 200014, this.f1796fV.f5201kC.length > 0 ? 0 : 1, "", "", Long.valueOf(nanoTime2), Integer.valueOf(c0626apArr.length), Integer.valueOf(this.f1796fV.f5201kC.length), Integer.valueOf(0), Long.valueOf(C0880a.m2380be()), Long.valueOf(C0880a.m2381bf()), Long.valueOf(C0880a.m2375I(this.f1788el)));
        C0769dy.m1929e(this.f1788el, this.handler);
        return this.f1796fV.f5201kC.length;
    }

    /* renamed from: a */
    protected int mo5725a(int i, String str) {
        int i2;
        int i3;
        C0633at.m1466r("func.RootExecutor.checkCanRoot(" + i + ")");
        C0769dy.m1931g(this.f1788el, this.handler);
        if (mo5726aD()) {
            C0633at.m1466r("needCheckKuUpdate here");
            C0644ba.m1503q(this.f1788el).mo5623w("prepare");
        }
        Object obj = (i & 1) == 1 ? 1 : null;
        if (obj != null) {
            m1779a(str, 200042, 0, "", "", new Object[0]);
        }
        this.f1796fV = C0749dk.m1823a(this.f1788el, this.f1789em, i);
        if (obj != null) {
            if (this.f1796fV == null || this.f1796fV.f5199kA != 0 || this.f1796fV.f5198hi == null) {
                m1779a(str, 200043, 1, "", "Network Fail.", new Object[0]);
            } else {
                m1779a(str, 200043, 0, "", "", Integer.valueOf(this.f1796fV.f5198hi.f1936hI), Integer.valueOf(this.f1796fV.f5198hi.f1939hL), Integer.valueOf(this.f1796fV.f5198hi.f1937hJ), Integer.valueOf(this.f1796fV.f5198hi.f1938hK), Integer.valueOf(this.f1796fV.mo8168ct()));
            }
        }
        String str2 = "";
        if (this.f1796fV != null) {
            C0626ap[] c0626apArr = this.f1796fV.f5200kB;
            if (c0626apArr != null) {
                ArrayList arrayList = new ArrayList();
                for (C0626ap c0626ap : c0626apArr) {
                    String str3;
                    if (C0749dk.m1830a(this.f1788el, c0626ap, this.f1789em)) {
                        arrayList.add(c0626ap);
                        boolean z = this.f1794fT || c0626ap.f1561bP == 5;
                        this.f1794fT = z;
                        z = this.f1795fU || c0626ap.f1561bP == 6;
                        this.f1795fU = z;
                        str3 = str2 + c0626ap.f1556bK + "_";
                    } else {
                        C0633at.m1467s("不允许执行, sid = " + c0626ap.f1556bK + ", KError.code = " + C0886f.m2424bj());
                        this.f1790fO.mo5759a("DONT_ALLOW_SOLUTION", 1, C0886f.m2424bj(), C0886f.getMsgAndCause(), this.handler, c0626ap.f1556bK);
                        C0749dk.m1821P(c0626ap.f1556bK);
                        str3 = str2;
                    }
                    str2 = str3;
                }
                int size = arrayList.size();
                this.f1796fV.f5200kB = (C0626ap[]) arrayList.toArray(new C0626ap[size]);
                i3 = i2;
                i2 = size;
                C0633at.m1465i("方案执行列表 = " + str2);
                m1779a(str, 200021, 0, "", "", Integer.valueOf(i3), str2, Integer.valueOf(i2));
                return i2;
            }
        }
        i2 = 0;
        i3 = 0;
        C0633at.m1465i("方案执行列表 = " + str2);
        m1779a(str, 200021, 0, "", "", Integer.valueOf(i3), str2, Integer.valueOf(i2));
        return i2;
    }

    /* renamed from: aD */
    protected boolean mo5726aD() {
        return C0722cu.m1744aD();
    }

    /* renamed from: aU */
    public RootShell mo5727aU() {
        RootShell b = C0731cz.m1768b(this.f1791fP, 0);
        m1779a(null, 200018, b != null ? 0 : 1, C0886f.m2424bj(), C0886f.getMsgAndCause(), Integer.valueOf(C0719cs.m1732b(b)));
        C0769dy.m1929e(this.f1788el, this.handler);
        return b;
    }

    /* renamed from: b */
    protected int mo5728b(int i, String str) {
        int a = mo5725a(i, str);
        return a > 0 ? mo5724R(str) : a;
    }

    /* renamed from: c */
    protected RootShell mo5729c(int i, String str) {
        int i2;
        C0726cw c0726cw;
        RootShell rootShell;
        RootShell rootShell2;
        C0633at.m1466r("func.RootExecutor.execute(" + i + ")");
        this.f1790fO.mo5759a("EXEC_BEGIN", 0, "", "", this.handler, new Object[0]);
        C0769dy.m1929e(this.f1788el, this.handler);
        C0626ap[] c0626apArr = (this.f1796fV == null || this.f1796fV.f5201kC == null) ? new C0626ap[0] : this.f1796fV.f5201kC;
        m1779a(str, 200015, 0, "", "", Integer.valueOf(c0626apArr.length));
        boolean z = i == 1 || i == 2;
        String bp = C0894m.m2454bp();
        f1787fS = bp;
        if (bp == null) {
            f1787fS = "";
        }
        if (mo5726aD()) {
            boolean x = C0644ba.m1503q(this.f1788el).mo5624x("installSuAndManager");
            m1779a(str, 200035, x ? 0 : 1, C0886f.m2424bj(), C0886f.getMsgAndCause(), Integer.valueOf(0));
            C0633at.m1464h("kuOk = " + x);
        }
        C0605ac.m1338d().mo5585g();
        C0733a c0733a = this.f1792fQ;
        RootShell rootShell3 = null;
        RootShell rootShell4 = null;
        System.nanoTime();
        C0726cw c0726cw2 = null;
        int i3 = 1;
        C0739de.m1801o(this.f1788el, "runned_sids");
        C0726cw.m1749a(this.f1788el, f1787fS, c0626apArr.length, i);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= c0626apArr.length) {
                i2 = i3;
                c0726cw = c0726cw2;
                rootShell = rootShell4;
                rootShell2 = rootShell3;
                break;
            }
            C0626ap c0626ap = c0626apArr[i5];
            C0633at.m1463g("执行方案：sid = " + c0626ap.f1556bK);
            if (i5 + 1 == c0626apArr.length) {
                C0739de.m1801o(this.f1788el, "next_execute_solution_id");
            } else {
                C0739de.m1795a(this.f1788el, "next_execute_solution_id", c0626apArr[i5 + 1].f1556bK);
            }
            if (c0733a != null) {
                c0733a.mo5722a(2, i5 + 1, c0626apArr.length, c0626ap.f1556bK);
            }
            C0720dh a = C0749dk.m1822a(this.f1788el, this.handler, this.f1789em, c0626ap);
            if (a == null) {
                this.f1790fO.mo5759a("MAKE_SOLUTION_FAIL", 1, C0886f.m2424bj(), C0886f.getMsgAndCause(), this.handler, c0626ap.f1556bK);
                i4 = i3;
            } else {
                m1779a(str, 200026, 0, "", "", c0626ap.f1556bK);
                a.mo5702z(i);
                C0633at.m1464h("init solution idx = " + i5 + ", sid = " + c0626ap.f1556bK);
                boolean aB = a.mo5698aB();
                m1779a(str, 200027, aB ? 0 : 1, C0886f.m2424bj(), C0886f.getMsgAndCause(), c0626ap.f1556bK);
                if (aB) {
                    this.f1790fO.mo5759a("KRSDK_Solution_Execute_Begin", 0, "", "", this.handler, c0626ap.f1556bK);
                    C0769dy.m1929e(this.f1788el, this.handler);
                    C0756dq c0756dq = new C0756dq();
                    boolean z2 = str == null;
                    try {
                        RootShell aQ;
                        RootShell rootShell5;
                        int i6;
                        C0749dk.m1826a(this.f1788el, this.handler, c0626ap.f1556bK, new WeakReference(a), z2);
                        C0726cw.m1750a(this.f1788el, c0626ap.f1556bK, i5, c0626ap.type, str);
                        i2 = a.mo5697a(c0756dq);
                        C0749dk.m1827a(this.f1788el, z2, c0626ap.f1556bK);
                        c0726cw2 = C0726cw.m1756v(this.f1788el);
                        if (c0726cw2 != null) {
                            c0726cw2.f1756ez = i2;
                            this.f1793fR = c0726cw2.mo5704aE();
                        }
                        this.f1790fO.mo5762a(str, this.handler, c0756dq, c0726cw2);
                        i4 = 1;
                        if (i2 == 0) {
                            Object obj;
                            int i7;
                            Object obj2;
                            RootShell aC = a.mo5699aC();
                            if (aC != null) {
                                aC.mo5696M(c0626ap.f1556bK);
                                obj = 1;
                                i7 = 0;
                                C0633at.m1463g("方案临时Root成功：sid = " + c0626ap.f1556bK);
                            } else {
                                i7 = 1;
                                obj = null;
                            }
                            i3 = this.f1790fO;
                            i3.mo5763a(str, this.handler, c0756dq, aC, c0726cw2);
                            if (z) {
                                int i8;
                                int i9;
                                int i10;
                                RootShell rootShell6;
                                a.mo5700c(aC);
                                boolean z3 = i == 2;
                                i3 = C1773a.m4829k(z3);
                                RootShell b = C0750dl.m1840b(20000, 10);
                                if (b != null) {
                                    b.mo5696M(c0626ap.f1556bK);
                                    obj2 = 1;
                                    i8 = 0;
                                } else {
                                    obj2 = obj;
                                    i8 = i7;
                                }
                                int a2 = C1773a.m4823a(b, i);
                                if (aC == null || (i3 == 0 && a2 == 0)) {
                                    i9 = a2;
                                    i10 = i3;
                                    a2 = 0;
                                    rootShell6 = b;
                                } else {
                                    if (C0718cr.m1730a(this.f1788el, aC, this.f1789em.workingDir.getAbsolutePath() + "/su", this.f1789em.workingDir.getAbsolutePath() + "/superuser.apk", this.f1789em.workingDir.getAbsolutePath() + "/supolicy", i == 1, this.f1789em.f5193ky, this.f1789em.f5194kz)) {
                                        i7 = C1773a.m4829k(z3);
                                        aQ = C0750dl.m1838aQ();
                                        i4 = C1773a.m4823a(aQ, i);
                                    } else {
                                        i4 = a2;
                                        i7 = i3;
                                        aQ = b;
                                    }
                                    a2 = 1;
                                    i9 = i4;
                                    i10 = i7;
                                    rootShell6 = aQ;
                                }
                                boolean z4 = i9 == 0;
                                this.f1790fO.mo5761a(str, this.handler, c0756dq, i10, c0726cw2, a2);
                                i3 = this.f1790fO;
                                i3.mo5764a(str, this.handler, c0756dq, z4, c0726cw2, a2, i9);
                                C0769dy.m1929e(this.f1788el, this.handler);
                                i7 = i10;
                                aQ = rootShell6;
                                i4 = i8;
                            } else {
                                obj2 = obj;
                                i4 = i7;
                                i7 = -1;
                                aQ = rootShell3;
                            }
                            if (obj2 != null) {
                                C0633at.m1464h("记录成功方案，移除下一个待执行方案标记");
                                C0739de.m1795a(this.f1788el, "solution_success_id", c0626ap.f1556bK);
                                C0739de.m1801o(this.f1788el, "next_execute_solution_id");
                            }
                            int i11 = i7;
                            rootShell5 = aC;
                            i6 = i11;
                        } else {
                            C0749dk.m1837r(this.f1788el, c0626ap.f1556bK);
                            i6 = -1;
                            rootShell5 = rootShell4;
                            aQ = rootShell3;
                        }
                        C0633at.m1456a(c0756dq, "sid = " + c0626ap.f1556bK + ", exploitRet = " + i2 + ", rootCode = " + i6 + ", tmpShell = " + rootShell5 + ", suShell = " + aQ);
                        this.f1790fO.mo5755a(this.handler, c0726cw2, i4);
                        C0769dy.m1930f(this.f1788el, this.handler);
                        C0769dy.m1929e(this.f1788el, this.handler);
                        if (i2 != 0 || i6 != 0 || rootShell5 == null || (z && aQ == null)) {
                            c0756dq.mo5749c(this.f1788el, this.handler);
                        } else {
                            c0756dq.mo5748aV();
                        }
                        if (i4 == 0) {
                            rootShell = rootShell5;
                            rootShell2 = aQ;
                            c0726cw = c0726cw2;
                            break;
                        }
                        i4 = i2;
                        rootShell4 = rootShell5;
                        rootShell3 = aQ;
                    } catch (Throwable th) {
                        C0749dk.m1827a(this.f1788el, z2, c0626ap.f1556bK);
                        C0726cw v = C0726cw.m1756v(this.f1788el);
                        if (v != null) {
                            v.f1756ez = i3;
                            this.f1793fR = v.mo5704aE();
                        }
                    }
                } else {
                    i4 = i3;
                }
            }
            i5++;
        }
        this.f1790fO.mo5760a(str, this.handler, c0726cw, C0726cw.m1754t(this.f1788el), rootShell, rootShell2, z);
        C0769dy.m1929e(this.f1788el, this.handler);
        C0739de.m1801o(this.f1788el, "runned_sids");
        if (i2 != 0) {
            rootShell2 = null;
        } else if (rootShell2 == null) {
            rootShell2 = rootShell;
        }
        if (rootShell2 != null) {
            C0659bf.m1547a(rootShell2);
            C0665bg.m1554Z().mo5645e(true);
        }
        return rootShell2;
    }

    public int checkAndPrepare() {
        return checkAndPrepare(1);
    }

    public int checkAndPrepare(int i) {
        return mo5728b(i, null);
    }

    public int checkCanRoot() {
        return checkCanRoot(1);
    }

    public int checkCanRoot(int i) {
        return mo5725a(i, null);
    }

    public RootShell execute() {
        return mo5723B(1);
    }

    public RootShell getHoldShell() {
        return mo5727aU();
    }

    public RootShell getShell() {
        RootShell b;
        C0750dl aQ = C0750dl.m1838aQ();
        if (aQ == null) {
            b = C0731cz.m1768b(this.f1791fP, 0);
        } else {
            Object b2 = aQ;
        }
        m1779a(null, 200018, b2 != null ? 0 : 1, C0886f.m2424bj(), C0886f.getMsgAndCause(), Integer.valueOf(C0719cs.m1732b(b2)));
        C0769dy.m1929e(this.f1788el, this.handler);
        return b2;
    }

    public int prepare() {
        return mo5724R(null);
    }
}
