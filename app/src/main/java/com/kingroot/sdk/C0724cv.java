package com.kingroot.sdk;

import android.content.Context;
import android.os.Handler;
import com.kingroot.sdk.util.C0885e;
import com.kingroot.sdk.util.C0886f;
import com.kingroot.sdk.util.C0889i;
import com.kingroot.sdk.util.C0897q;
import com.kingroot.sdk.util.C0898r;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStreamReader;
import krsdk.RootConfig;

/* renamed from: com.kingroot.sdk.cv */
class C0724cv extends C0721ct {
    /* renamed from: eq */
    private Process f1739eq;
    /* renamed from: er */
    private String f1740er = (this.f1735eo + "/krcfg.txt");
    /* renamed from: es */
    private boolean f1741es = true;

    C0724cv(Context context, Handler handler, RootConfig rootConfig, C0626ap c0626ap) {
        super(context, handler, rootConfig, c0626ap);
    }

    /* renamed from: a */
    private void m1745a(final Process process) {
        new Thread() {
            public void run() {
                try {
                    int waitFor = process.waitFor();
                    C0724cv.this.f1741es = false;
                    C0633at.m1465i("ExeRootSolution process exit: " + waitFor);
                } catch (Throwable e) {
                    C0633at.m1458a("ExeRootSolution waitFor throw e", e);
                } catch (Throwable e2) {
                    C0633at.m1458a("ExeRootSolution waitFor throw e2", e2);
                }
            }
        }.start();
    }

    /* renamed from: a */
    public int mo5697a(C0756dq c0756dq) {
        Closeable inputStreamReader;
        Throwable th;
        Closeable closeable;
        C0886f.clean();
        StringBuilder stringBuilder = new StringBuilder();
        long nanoTime = System.nanoTime();
        String a = this.f1733em.mo8167a("play", "krmain");
        Object obj = null;
        Closeable closeable2 = null;
        Closeable closeable3 = null;
        Closeable closeable4 = null;
        Closeable inputStream;
        try {
            this.f1739eq = new ProcessBuilder(new String[]{a, "-k", this.f1740er}).redirectErrorStream(true).directory(new File(this.f1735eo)).start();
            m1745a(this.f1739eq);
            C0739de.m1797a(this.f1732el, "EMID_KRSDK_EXReport_Info", this.f1734en.f1556bK, C0627aq.f1567bU, "", C0734dr.f1787fS, "0", "1");
            c0756dq.mo5747Q("onRoot() start sid = " + this.f1734en.f1556bK);
            String str = this.f1734en.f1556bK + ".stdout : ";
            inputStream = this.f1739eq.getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream);
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                inputStreamReader = null;
                C0885e.m2419a(closeable);
                C0885e.m2419a(inputStreamReader);
                C0885e.m2419a(inputStream);
                throw th;
            }
            try {
                Object obj2;
                int i;
                boolean z;
                closeable = new BufferedReader(inputStreamReader);
                int i2 = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        boolean ready = closeable.ready();
                        if (!ready && !this.f1741es) {
                            obj2 = obj;
                            i = i2;
                            z = z2;
                            break;
                        } else if (ready) {
                            String readLine = closeable.readLine();
                            if (readLine != null) {
                                boolean z3;
                                String trim = readLine.trim();
                                C0633at.m1464h(str + trim);
                                c0756dq.mo5747Q(trim);
                                if (trim.startsWith("KR_")) {
                                    String[] split = trim.split(" ");
                                    if (split.length >= 2) {
                                        if ("SDR".equals(split[1])) {
                                            obj = 1;
                                            C0605ac.m1338d().mo5584f(trim);
                                        }
                                    }
                                }
                                Object obj3 = obj;
                                if (C0897q.m2467n(trim, "[et] KRS|FT PARAMS:") != null) {
                                    C0739de.m1797a(this.f1732el, "EMID_KRSDK_EXReport_Info", this.f1734en.f1556bK, C0627aq.f1567bU, C0897q.m2467n(trim, "[et] KRS|FT PARAMS:"), C0734dr.f1787fS, "0", "1");
                                }
                                String n = C0897q.m2467n(trim, "KRS|STAT|KD:");
                                if (n != null) {
                                    C0633at.m1464h("真实的KD路径：" + n);
                                    C0731cz.m1769n(this.f1732el, n);
                                }
                                readLine = C0897q.m2467n(trim, "krerrcode:");
                                if (readLine != null) {
                                    String[] split2 = readLine.split(",");
                                    i2 = (split2 == null || split2.length <= 0 || split2[0] == null || !"0".equals(split2[0].trim())) ? 1 : 0;
                                    C0726cw.m1751b(this.f1732el, i2, readLine);
                                    C0633at.m1465i("catch ::: errCodes = " + readLine);
                                    C0760dt.m1855E(this.f1732el).mo5759a("CATCH_SOLUTION_RESULT", i2, readLine, trim, this.handler, this.f1734en.f1556bK);
                                    C0769dy.m1929e(this.f1732el, this.handler);
                                    if (i2 != 0) {
                                        i = i2;
                                        z = true;
                                        obj2 = obj3;
                                        break;
                                    }
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (z3) {
                                    obj2 = obj3;
                                    i = i2;
                                    z = z3;
                                    break;
                                }
                                z2 = z3;
                                obj = obj3;
                            } else {
                                continue;
                            }
                        } else {
                            C0889i.m2429f(500);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        C0885e.m2419a(closeable);
                        C0885e.m2419a(inputStreamReader);
                        C0885e.m2419a(inputStream);
                        throw th;
                    }
                }
                c0756dq.mo5747Q("onRoot() end sid = " + this.f1734en.f1556bK + ", catchResult = " + z + ", exploitRet = " + i + ", childDuingTime = " + ((System.nanoTime() - nanoTime) / 1000000));
                C0633at.m1464h("执行完成1！ catchResult = " + z);
                String[] q = C0739de.m1803q(this.f1732el, "EMID_KRSDK_EXReport_Info");
                C0739de.m1801o(this.f1732el, "EMID_KRSDK_EXReport_Info");
                if (q.length >= 5) {
                    C0760dt E = C0760dt.m1855E(this.f1732el);
                    int i3 = (z && i == 0) ? 0 : 1;
                    E.mo5758a(null, 200039, i3, "0", "catchResult=" + z + ", errCode=" + i, this.handler, q[0], q[1], q[2], q[3], Long.valueOf(nanoTime), Integer.valueOf(1));
                    C0769dy.m1929e(this.f1732el, this.handler);
                }
                if (obj2 != null) {
                    C0605ac.m1338d().mo5583f();
                }
                if (C0627aq.f1564aW) {
                    C0633at.m1464h("EnvScanner.rbLog目录下有：");
                    C0898r.m2468ad("ls -l " + C0741dg.m1804aL().f1806em.workingDir.getAbsolutePath() + "/rblog/");
                }
                if (!z) {
                    C0886f.set(7010, "Exe fail, EOF");
                    c0756dq.mo5747Q("onRoot() not catchResult : " + C0886f.getMsgAndCause());
                } else if (i == 0) {
                    C0885e.m2419a(closeable);
                    C0885e.m2419a(inputStreamReader);
                    C0885e.m2419a(inputStream);
                    return 0;
                } else {
                    C0886f.set(i, stringBuilder.toString());
                }
                C0633at.m1464h("执行完成！");
                C0885e.m2419a(closeable);
                C0885e.m2419a(inputStreamReader);
                C0885e.m2419a(inputStream);
                return 1;
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                C0885e.m2419a(closeable);
                C0885e.m2419a(inputStreamReader);
                C0885e.m2419a(inputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            closeable = null;
            inputStreamReader = null;
            inputStream = null;
            C0885e.m2419a(closeable);
            C0885e.m2419a(inputStreamReader);
            C0885e.m2419a(inputStream);
            throw th;
        }
    }

    /* renamed from: aB */
    public boolean mo5698aB() {
        if (super.mo5698aB()) {
            try {
                C0885e.m2421a(new File(this.f1740er), "ver:00001", "c:" + this.f1735eo + File.separator + "krcert.jar", "mydir:" + this.f1735eo, "rmode:" + this.f1736ep, "kddir:" + this.f1733em.workingDir.getAbsolutePath(), "apkdir:" + this.f1735eo, "kdcert:" + this.f1733em.workingDir.getAbsolutePath() + File.separator + "krsdk.cert");
                return true;
            } catch (Throwable e) {
                C0633at.m1458a("生成方案配置文件出错", e);
            }
        }
        return false;
    }

    public void destroy() {
        if (this.f1739eq != null) {
            try {
                C0633at.m1465i("ExeRootSolution.destroy() start");
                this.f1741es = false;
                C0633at.m1465i("ExeRootSolution.destroy() done");
            } catch (Throwable th) {
                C0633at.m1458a("ExeRootSolution.destroy() throw e", th);
            }
        }
    }
}
