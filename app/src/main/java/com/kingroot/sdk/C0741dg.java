package com.kingroot.sdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.kingroot.sdk.C0726cw.C0725a;
import com.kingroot.sdk.util.C0883c;
import com.kingroot.sdk.util.C0886f;
import com.kingroot.sdk.util.C0894m;
import com.kingroot.sdk.util.C0898r;
import com.kingroot.sdk.util.Cryptor;
import com.kingroot.sdk.util.Posix;
import com.shuame.mobile.sdk.FlashEngine.FlashResult;
import java.io.File;
import krsdk.C1773a;
import krsdk.IShell;
import krsdk.KRError;
import krsdk.RootConfig;
import krsdk.RootExecutor;
import krsdk.RootExecutorFactory;
import krsdk.RootShell;

/* renamed from: com.kingroot.sdk.dg */
public class C0741dg {
    /* renamed from: fj */
    private static C0741dg f1803fj;
    /* renamed from: ei */
    public volatile boolean f1804ei = false;
    /* renamed from: el */
    public Context f1805el;
    /* renamed from: em */
    public RootConfig f1806em;
    /* renamed from: fk */
    public HandlerThread f1807fk;
    /* renamed from: fl */
    public Context f1808fl;
    /* renamed from: fm */
    private boolean f1809fm = false;
    /* renamed from: fn */
    private long f1810fn = 0;

    private C0741dg() {
    }

    /* renamed from: aL */
    public static C0741dg m1804aL() {
        if (f1803fj == null) {
            synchronized (C0741dg.class) {
                if (f1803fj == null) {
                    f1803fj = new C0741dg();
                }
            }
        }
        return f1803fj;
    }

    /* renamed from: aM */
    public synchronized void mo5734aM() {
        C0633at.m1464h("func.RootExecutorFactory.initThreadIfNeed()");
        if (this.f1807fk == null) {
            C0633at.m1464h("Init KRSDKReportThread");
            this.f1807fk = new HandlerThread("KRSDK.ReportThread");
            this.f1807fk.start();
        }
    }

    public int checkHasRooted() {
        return C1773a.m4829k(false);
    }

    public C0726cw dealWithUnFinishSolution(Context context) {
        C0633at.m1464h("func.RootExecutorFactory.dealWithUnFinishSolution()");
        C0726cw v = C0726cw.m1756v(context);
        if (v == null) {
            return v;
        }
        C0633at.m1464h("有未执行完的方案记录");
        if (v.mo5705aF()) {
            C0633at.m1464h("Ignore reboot");
            return null;
        }
        boolean z;
        boolean z2;
        C0725a t = C0726cw.m1754t(this.f1805el);
        int i = v.f1756ez;
        RootShell rootShell = null;
        Handler handler = new Handler(this.f1807fk.getLooper());
        C0760dt E = C0760dt.m1855E(this.f1805el);
        v.f1751eE = true;
        boolean z3 = t.f1745eH == 1 || t.f1745eH == 2;
        if (z3) {
            boolean z4;
            boolean z5;
            int k = C1773a.m4829k(t.f1745eH == 2);
            rootShell = C0750dl.m1838aQ();
            int a = C1773a.m4823a(rootShell, t.f1745eH);
            boolean z6 = a == 0;
            if (z6) {
                C0633at.m1464h("客户端可上报Root成功！");
                v.f1750eD = true;
                C0633at.m1464h("记录成功方案，移除下一个待执行方案标记");
                C0739de.m1795a(this.f1805el, "solution_success_id", v.f1746bK);
                C0739de.m1801o(this.f1805el, "next_execute_solution_id");
                z4 = true;
                z5 = false;
            } else {
                C0749dk.m1837r(this.f1805el, v.f1746bK);
                z4 = false;
                z5 = true;
            }
            E.mo5761a(null, handler, null, k, v, 0);
            E.mo5764a(null, handler, null, z6, v, 0, a);
            z = z4;
            z2 = z5;
        } else {
            z = false;
            z2 = false;
        }
        E.mo5762a(null, handler, null, v);
        RootShell b = C0731cz.m1768b(this.f1806em.workingDir.getAbsolutePath() + "/kd", 0);
        E.mo5763a(null, handler, null, b, v);
        E.mo5760a(null, handler, v, t, b, rootShell, z3);
        C0769dy.m1929e(context, handler);
        E.mo5755a(handler, v, i == 0 ? 0 : 1);
        C0769dy.m1930f(context, handler);
        if (C0605ac.m1338d().mo5582e()) {
            C0633at.m1466r("EnvScanner.大杀器导致重启： needReportEnv = " + z2 + ", needDeleteEnvFile = " + z);
            if (z2) {
                C0605ac.m1338d().mo5581c(context);
                C0605ac.m1338d().mo5580a(context, handler);
            }
            if (z) {
                C0605ac.m1338d().mo5583f();
            }
        } else {
            C0633at.m1466r("EnvScanner.非大杀器导致重启");
        }
        C0739de.m1801o(context, "apptime_runned_sids");
        return v;
    }

    public synchronized void destoryThread() {
        C0633at.m1464h("func.RootExecutorFactory.destoryThread()");
        this.f1807fk.quit();
        this.f1807fk = null;
    }

    public boolean extractAndInit(Context context, RootConfig rootConfig) {
        if (rootConfig == null) {
            rootConfig = new RootConfig();
        }
        File dir = context.getDir("krsdk", 0);
        if (!extractFileToWorkDir(context, "krsdk.res", dir, true)) {
            return false;
        }
        rootConfig.workingDir = dir;
        return RootExecutorFactory.init(context, rootConfig);
    }

    public boolean extractFileToWorkDir(Context context, String str, File file, boolean z) {
        KRError.clean();
        try {
            C0883c.m2390a(context, str, new File(file, str));
            return true;
        } catch (Throwable th) {
            KRError.set(FlashResult.ERROR_UNKONW, "extractFileToWorkDir throw exception", th);
            return false;
        }
    }

    public RootExecutor getRootExecutor() {
        C0742di.m1807a(this.f1805el, this.f1808fl);
        C0633at.m1464h("RootExecutorFactory.getRootExecutor()");
        if (this.f1806em == null) {
            throw new RuntimeException("请在你的Application的onCreate()中调用onApplicationCreate(Context, RootConfig)方法");
        }
        switch (Integer.parseInt(C0625ao.f1552bJ.trim())) {
            case 105006:
                return new C0735da(this.f1805el.getApplicationContext(), this.f1806em, this.f1807fk.getLooper());
            case 105016:
            case 105056:
                return new C0734dr(this.f1805el.getApplicationContext(), this.f1806em, this.f1807fk.getLooper());
            case 105026:
                return new C0752dn(this.f1805el.getApplicationContext(), this.f1806em, this.f1807fk.getLooper());
            case 105036:
                return new C0757ds(this.f1805el.getApplicationContext(), this.f1806em, this.f1807fk.getLooper());
            case 105066:
            case 105076:
                return new C0753dp(this.f1805el.getApplicationContext(), this.f1806em, this.f1807fk.getLooper());
            default:
                return new C0740df(this.f1805el, this.f1806em, this.f1807fk.getLooper());
        }
    }

    public boolean init(Context context, RootConfig rootConfig, Context context2) {
        KRError.clean();
        this.f1804ei = false;
        C0627aq.m1445a(rootConfig.useTestServer, rootConfig.logSwitchOn);
        C0633at.m1461b(rootConfig.logSwitchOn);
        try {
            C0742di.m1807a(context, context2);
            C0633at.m1464h("RootExecutorFactory.init()");
            this.f1805el = context;
            this.f1808fl = context2;
            this.f1806em = rootConfig;
            Cryptor.m2364c(context2, rootConfig.enable64so);
            C0624an.m1426h(context);
            C0625ao.m1432a(rootConfig.f5189ku, context);
            if (this.f1807fk != null) {
                this.f1807fk.quit();
                this.f1807fk = null;
            }
            mo5734aM();
            Handler handler = new Handler(this.f1807fk.getLooper());
            C0760dt E = C0760dt.m1855E(context);
            File file = new File(rootConfig.workingDir, rootConfig.resFileName);
            File file2 = new File(rootConfig.workingDir, "__krsdk.res__");
            boolean a = C0883c.m2394a(context, file, file2);
            if (a) {
                try {
                    if (C0883c.m2395a(context, file2, rootConfig.workingDir.getAbsolutePath())) {
                        C0883c.m2391a(file2, rootConfig.workingDir.getAbsolutePath(), context);
                    }
                    C0633at.m1464h("descrypt and extract krsdk.res done.");
                    String B = C0742di.m1806B(context2);
                    C0625ao.m1441p(B);
                    if (rootConfig.f5191kw == null || "".equals(rootConfig.f5191kw) || "0".equals(rootConfig.f5191kw)) {
                        rootConfig.f5191kw = B;
                    }
                    try {
                        if (C0883c.m2410t(context2, "su") && !C0883c.m2401b(context2, "su", new File(rootConfig.workingDir, "su")) && "105006".equals(C0625ao.f1552bJ)) {
                            E.mo5759a("DESCRYPT_FILE_FAIL", 1, C0886f.m2424bj(), C0886f.getMsgAndCause(), handler, new Object[0]);
                        }
                        try {
                            if (C0883c.m2410t(context2, "superuser.apk") && !C0883c.m2401b(context2, "superuser.apk", new File(rootConfig.workingDir, "superuser.apk")) && "105006".equals(C0625ao.f1552bJ)) {
                                E.mo5759a("DESCRYPT_FILE_FAIL", 1, C0886f.m2424bj(), C0886f.getMsgAndCause(), handler, new Object[0]);
                            }
                            try {
                                if (C0883c.m2410t(context2, "ku-config")) {
                                    C0883c.m2390a(context2, "ku-config", new File(rootConfig.workingDir, "ku-config"));
                                }
                            } catch (Throwable th) {
                                KRError.set(10007, "extract kuconfig fail.", th);
                            }
                            try {
                                if (C0883c.m2410t(context2, "krsdk.cert")) {
                                    C0883c.m2390a(context2, "krsdk.cert", new File(rootConfig.workingDir, "krsdk.cert"));
                                }
                            } catch (Throwable th2) {
                                KRError.set(10011, "extract krsdk cert fail.", th2);
                            }
                            try {
                                C0633at.m1464h("Posix.chmod start.");
                                File[] listFiles = rootConfig.workingDir.listFiles();
                                if (listFiles != null) {
                                    for (File file3 : listFiles) {
                                        if (file3.isFile()) {
                                            Posix.chmod(file3.getAbsolutePath(), 493);
                                        }
                                    }
                                }
                                C0898r.m2468ad("ls -lZ " + rootConfig.workingDir.getAbsolutePath() + "/");
                                C0894m.m2452T(context2);
                                if (rootConfig.f5192kx) {
                                    context.registerReceiver(new C0764dx(this.f1807fk.getLooper()), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                                    C0633at.m1464h("register network broadcast.");
                                }
                                C0644ba.m1503q(context).mo5621a(this.f1807fk.getLooper());
                                C0633at.m1464h("init OK");
                                this.f1804ei = true;
                                E.mo5768b(handler);
                                C0712cn.m1712at();
                                try {
                                    IntentFilter intentFilter = new IntentFilter();
                                    intentFilter.addAction("com.kingroot.kinguser.action.update");
                                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                                    this.f1805el.registerReceiver(new C0649bd(), intentFilter);
                                    C0665bg.m1554Z().mo5644d(true);
                                } catch (Throwable th3) {
                                }
                                return true;
                            } catch (Throwable th4) {
                                KRError.set(10009, "chmod fail.", th4);
                                return false;
                            }
                        } catch (Throwable th42) {
                            KRError.set(10007, "extract suku fail.", th42);
                            return false;
                        }
                    } catch (Throwable th422) {
                        KRError.set(10007, "extract suku fail.", th422);
                        return false;
                    }
                } catch (Throwable th22) {
                    Throwable th5 = th22;
                    E.mo5759a("UNZIP_RES", 1, "7055", C0886f.getThrowMsg(th5), handler, new Object[0]);
                    C0633at.m1458a("krsdk.res checkZipFileUpdate unzipFiles fail.", th5);
                    KRError.set(10006, "unzip res fail. ", th5);
                    return false;
                }
            }
            E.mo5759a("DESCRYPT_FILE_FAIL", a ? 0 : 1, C0886f.m2424bj(), C0886f.getMsgAndCause(), handler, new Object[0]);
            C0633at.m1465i("krsdk.res descryptFile fail.");
            KRError.set(10005, "descrypt res fail. " + C0886f.getMsgAndCause());
            return false;
        } catch (Throwable th4222) {
            KRError.set(10010, "unkown exception", th4222);
            this.f1804ei = false;
            return false;
        }
    }

    public boolean saveShell(IShell iShell) {
        boolean z = false;
        synchronized (C0741dg.class) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z2 = currentTimeMillis - this.f1810fn > 0 && currentTimeMillis - this.f1810fn < 3000;
            if (iShell == null || z2) {
            } else {
                String str = this.f1806em.workingDir + File.separator + "kd";
                if (!this.f1809fm) {
                    C0601aa c0601aa = new C0601aa();
                    c0601aa.f1476as = C0625ao.f1552bJ;
                    c0601aa.f1477at = "5CA2B7587B0CDF63";
                    c0601aa.f1478au = C0627aq.f1567bU;
                    c0601aa.f1479av = C0627aq.m1447z();
                    c0601aa.f1480aw = this.f1806em.useTestServer;
                    C0601aa.m1335a(this.f1806em.workingDir, c0601aa);
                    C0618aj.m1390h(this.f1805el);
                    C0617ai.f1510aW = this.f1806em.logSwitchOn;
                    this.f1809fm = true;
                }
                RootShell b = C0731cz.m1768b(str, 0);
                if (b == null) {
                    C0731cz.m1765a(str, iShell);
                    b = C0731cz.m1768b(str, 3);
                }
                C0613ae.m1362e(this.f1805el).start();
                if (b != null) {
                    b.close();
                }
                if (b != null) {
                    z = true;
                }
            }
        }
        return z;
    }
}
