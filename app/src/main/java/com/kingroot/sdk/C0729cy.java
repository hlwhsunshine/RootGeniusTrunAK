package com.kingroot.sdk;

import android.content.Context;
import android.os.Handler;
import com.kingroot.sdk.util.C0886f;
import com.kingroot.sdk.util.C0889i;
import java.util.HashMap;
import krsdk.RootConfig;
import krsdk.RootShell;

/* renamed from: com.kingroot.sdk.cy */
class C0729cy extends C0721ct {
    /* renamed from: eI */
    private static Class<?> f1775eI;
    /* renamed from: eJ */
    private Object f1776eJ;
    /* renamed from: eL */
    private C0728a f1777eL;
    /* renamed from: eM */
    private int f1778eM = 1;

    /* renamed from: com.kingroot.sdk.cy$a */
    static class C0728a {
        String className = "krsdk.XSolution";
        /* renamed from: eN */
        String f1761eN = "init";
        /* renamed from: eO */
        Class[] f1762eO = new Class[]{Context.class, String.class, ClassLoader.class};
        /* renamed from: eP */
        String f1763eP = "root";
        /* renamed from: eQ */
        Class[] f1764eQ = new Class[]{Context.class};
        /* renamed from: eR */
        String f1765eR = "destroy";
        /* renamed from: eS */
        Class[] f1766eS = new Class[]{Context.class};
        /* renamed from: eT */
        String f1767eT = "getShell";
        /* renamed from: eU */
        Class[] f1768eU = new Class[0];
        /* renamed from: eV */
        String f1769eV = "executeCommand";
        /* renamed from: eW */
        Class[] f1770eW = new Class[]{Object.class, String.class};
        /* renamed from: eX */
        String f1771eX = "closeShell";
        /* renamed from: eY */
        Class[] f1772eY = new Class[]{Object.class};
        /* renamed from: eZ */
        String f1773eZ = "init2";
        /* renamed from: fa */
        Class[] f1774fa = new Class[]{Context.class, ClassLoader.class, HashMap.class};

        C0728a() {
        }
    }

    C0729cy(Context context, Handler handler, RootConfig rootConfig, C0626ap c0626ap) {
        super(context, handler, rootConfig, c0626ap);
        C0633at.m1466r("JavaRootSolution.<init>()");
        this.f1777eL = new C0728a();
    }

    /* renamed from: aG */
    private boolean m1760aG() {
        boolean z = false;
        synchronized (C0729cy.class) {
            if (f1775eI == null) {
                Class a = C0889i.m2427a(this.f1735eo + "/vroot.jar", this.f1735eo, this.f1777eL.className, this.f1732el.getClassLoader());
                f1775eI = a;
                if (a == null) {
                    C0886f.set(7015, "jsolution fail load " + f1775eI);
                }
            }
            if (this.f1776eJ == null) {
                try {
                    this.f1776eJ = f1775eI.newInstance();
                    C0633at.m1464h("实例化方案类成功! delegate = " + this.f1776eJ);
                } catch (Throwable e) {
                    C0633at.m1458a("实例化方案类异常!", e);
                    C0886f.set(7015, "jsolution fail newInstance " + f1775eI, e);
                }
            }
            z = true;
        }
        return z;
    }

    /* renamed from: aH */
    private C0719cs m1761aH() {
        C0886f.clean();
        C0633at.m1466r("JavaRootSolution.getSolutionShell()");
        if (this.f1778eM != 0) {
            C0886f.set(7013, "jsolution getShell unroot");
            return null;
        } else if (!m1760aG()) {
            return null;
        } else {
            try {
                return new C0727cx(f1775eI, this.f1776eJ, f1775eI.getMethod(this.f1777eL.f1767eT, this.f1777eL.f1768eU).invoke(this.f1776eJ, new Object[0]), this.f1777eL);
            } catch (Throwable th) {
                C0633at.m1458a("调用JavaShell的getShell()方法异常!", th);
                C0886f.set(7014, "jsolution getShell exception", th);
                return null;
            }
        }
    }

    /* renamed from: a */
    public int mo5697a(C0756dq c0756dq) {
        C0886f.clean();
        C0633at.m1466r("JavaRootSolution.onRoot()");
        if (!m1760aG()) {
            return 1;
        }
        long nanoTime = System.nanoTime();
        C0739de.m1797a(this.f1732el, "EMID_KRSDK_EXReport_Info", this.f1734en.f1556bK, C0627aq.f1567bU, "", C0734dr.f1787fS, "0", "1");
        try {
            c0756dq.mo5747Q("onRoot() start sid = " + this.f1734en.f1556bK);
            this.f1778eM = ((Integer) f1775eI.getMethod(this.f1777eL.f1763eP, this.f1777eL.f1764eQ).invoke(this.f1776eJ, new Object[]{this.f1732el})).intValue();
            C0760dt.m1855E(this.f1732el).mo5759a("CATCH_SOLUTION_RESULT", this.f1778eM == 0 ? 0 : 1, this.f1778eM, "", this.handler, this.f1734en.f1556bK);
            C0726cw.m1751b(this.f1732el, this.f1778eM, this.f1778eM);
            String[] q = C0739de.m1803q(this.f1732el, "EMID_KRSDK_EXReport_Info");
            C0739de.m1801o(this.f1732el, "EMID_KRSDK_EXReport_Info");
            nanoTime = (System.nanoTime() - nanoTime) / 1000000;
            if (q.length >= 5) {
                C0760dt.m1855E(this.f1732el).mo5758a(null, 200039, this.f1778eM == 0 ? 0 : 1, "0", "result=" + this.f1778eM, this.handler, q[0], q[1], q[2], q[3], Long.valueOf(nanoTime), Integer.valueOf(1));
                C0769dy.m1929e(this.f1732el, this.handler);
            }
            c0756dq.mo5747Q("onRoot() end sid = " + this.f1734en.f1556bK + ", result = " + this.f1778eM + ", childDuingTime = " + nanoTime);
            if (this.f1778eM == 0) {
                RootShell aH = m1761aH();
                if (aH != null) {
                    C0633at.m1464h("Vroot.startSuc.ret = " + C0731cz.m1766a(this.f1733em.mo8167a("kd"), aH));
                    String a = this.f1733em.mo8167a("play", "su");
                    String a2 = this.f1733em.mo8167a("play", "Kinguser.apk");
                    String str = this.f1733em.workingDir.getAbsolutePath() + "/supolicy";
                    if (this.f1736ep == 1) {
                        C0633at.m1464h("Vroot.installKu.ret = " + C0718cr.m1730a(this.f1732el, aH, a, a2, str, true, this.f1733em.f5193ky, this.f1733em.f5194kz) + ", rmode = " + this.f1736ep);
                    } else if (this.f1736ep == 2) {
                        C0633at.m1464h("Vroot.installKu.ret = " + C0718cr.m1730a(this.f1732el, aH, a, a2, str, false, this.f1733em.f5193ky, this.f1733em.f5194kz) + ", rmode = " + this.f1736ep);
                    }
                } else {
                    this.f1778eM = 1;
                    C0886f.set(7010, "no tmpshell, result = " + this.f1778eM);
                }
            } else {
                this.f1778eM = 1;
                C0886f.set(7010, "root fail, result = " + this.f1778eM);
            }
            if (this.f1778eM == 0) {
                c0756dq.mo5747Q("onRoot() suc");
            } else {
                c0756dq.mo5747Q("onRoot() fail : " + C0886f.getMsgAndCause());
            }
            return this.f1778eM;
        } catch (Throwable th) {
            C0886f.set(7011, "jsolution onRoot exception", th);
            c0756dq.mo5747Q("onRoot() exception : " + C0886f.getMsgAndCause());
            return 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0062  */
    /* renamed from: aB */
    public boolean mo5698aB() {
        /*
        r9 = this;
        r1 = 1;
        r0 = 0;
        super.mo5698aB();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r9.f1735eo;
        r2 = r2.append(r3);
        r3 = "/vroot.jar";
        r2 = r2.append(r3);
        r4 = r2.toString();
        r3 = 0;
        r2 = new com.kingroot.sdk.av;	 Catch:{ Throwable -> 0x0059, all -> 0x0066 }
        r5 = "sh";
        r2.<init>(r5);	 Catch:{ Throwable -> 0x0059, all -> 0x0066 }
        r3 = "export PATH=/sbin:/vendor/bin:/system/sbin:/system/bin:/system/xbin:$PATH";
        r2.mo5609t(r3);	 Catch:{ Throwable -> 0x00e5 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00e5 }
        r5 = "cat ";
        r3.<init>(r5);	 Catch:{ Throwable -> 0x00e5 }
        r5 = r9.f1734en;	 Catch:{ Throwable -> 0x00e5 }
        r5 = r5.f1563bR;	 Catch:{ Throwable -> 0x00e5 }
        r3 = r3.append(r5);	 Catch:{ Throwable -> 0x00e5 }
        r5 = " > ";
        r3 = r3.append(r5);	 Catch:{ Throwable -> 0x00e5 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x00e5 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00e5 }
        r2.mo5609t(r3);	 Catch:{ Throwable -> 0x00e5 }
        r2.shutdown();
        com.kingroot.sdk.util.C0886f.clean();
        r2 = "JavaRootSolution.init()";
        com.kingroot.sdk.C0633at.m1466r(r2);
        r2 = r9.m1760aG();
        if (r2 != 0) goto L_0x006e;
    L_0x0058:
        return r0;
    L_0x0059:
        r1 = move-exception;
        r2 = r3;
    L_0x005b:
        r3 = "复制KU异常";
        com.kingroot.sdk.C0633at.m1458a(r3, r1);	 Catch:{ all -> 0x00e3 }
        if (r2 == 0) goto L_0x0058;
    L_0x0062:
        r2.shutdown();
        goto L_0x0058;
    L_0x0066:
        r0 = move-exception;
        r2 = r3;
    L_0x0068:
        if (r2 == 0) goto L_0x006d;
    L_0x006a:
        r2.shutdown();
    L_0x006d:
        throw r0;
    L_0x006e:
        r2 = f1775eI;	 Catch:{ Exception -> 0x00d9 }
        r2 = r2.getClassLoader();	 Catch:{ Exception -> 0x00d9 }
        r3 = f1775eI;	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r4 = r9.f1777eL;	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r4 = r4.f1773eZ;	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r5 = r9.f1777eL;	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r5 = r5.f1774fa;	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r3 = r3.getMethod(r4, r5);	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r4 = new java.util.HashMap;	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r4.<init>();	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r5 = "workDir";
        r6 = r9.f1735eo;	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r4.put(r5, r6);	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r5 = "safeMode";
        r6 = com.kingroot.sdk.C0741dg.m1804aL();	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r6 = r6.f1806em;	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r6 = r6.f5190kv;	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r4.put(r5, r6);	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r5 = r9.f1776eJ;	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r6 = 3;
        r6 = new java.lang.Object[r6];	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r7 = 0;
        r8 = r9.f1732el;	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r6[r7] = r8;	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r7 = 1;
        r6[r7] = r2;	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r7 = 2;
        r6[r7] = r4;	 Catch:{ NoSuchMethodException -> 0x00b4 }
        r3.invoke(r5, r6);	 Catch:{ NoSuchMethodException -> 0x00b4 }
    L_0x00b2:
        r0 = r1;
        goto L_0x0058;
    L_0x00b4:
        r3 = move-exception;
        r3 = f1775eI;	 Catch:{ Exception -> 0x00d9 }
        r4 = r9.f1777eL;	 Catch:{ Exception -> 0x00d9 }
        r4 = r4.f1761eN;	 Catch:{ Exception -> 0x00d9 }
        r5 = r9.f1777eL;	 Catch:{ Exception -> 0x00d9 }
        r5 = r5.f1762eO;	 Catch:{ Exception -> 0x00d9 }
        r3 = r3.getMethod(r4, r5);	 Catch:{ Exception -> 0x00d9 }
        r4 = r9.f1776eJ;	 Catch:{ Exception -> 0x00d9 }
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x00d9 }
        r6 = 0;
        r7 = r9.f1732el;	 Catch:{ Exception -> 0x00d9 }
        r5[r6] = r7;	 Catch:{ Exception -> 0x00d9 }
        r6 = 1;
        r7 = r9.f1735eo;	 Catch:{ Exception -> 0x00d9 }
        r5[r6] = r7;	 Catch:{ Exception -> 0x00d9 }
        r6 = 2;
        r5[r6] = r2;	 Catch:{ Exception -> 0x00d9 }
        r3.invoke(r4, r5);	 Catch:{ Exception -> 0x00d9 }
        goto L_0x00b2;
    L_0x00d9:
        r1 = move-exception;
        r2 = 7009; // 0x1b61 float:9.822E-42 double:3.463E-320;
        r3 = "jsolution init exception";
        com.kingroot.sdk.util.C0886f.set(r2, r3, r1);
        goto L_0x0058;
    L_0x00e3:
        r0 = move-exception;
        goto L_0x0068;
    L_0x00e5:
        r1 = move-exception;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.cy.aB():boolean");
    }

    public void destroy() {
        C0633at.m1466r("JavaRootSolution.destroy()");
        try {
            f1775eI.getMethod(this.f1777eL.f1765eR, this.f1777eL.f1766eS).invoke(this.f1776eJ, new Object[]{this.f1732el});
        } catch (Throwable th) {
            C0633at.m1458a("调用方案类destroy()方法异常!", th);
        }
    }
}
