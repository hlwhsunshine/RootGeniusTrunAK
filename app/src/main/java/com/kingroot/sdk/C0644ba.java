package com.kingroot.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.kingroot.sdk.util.C0883c;
import com.kingroot.sdk.util.C0886f;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* renamed from: com.kingroot.sdk.ba */
public class C0644ba {
    /* renamed from: cM */
    private static volatile C0644ba f1619cM = null;
    /* renamed from: cI */
    private Handler f1620cI;
    /* renamed from: cK */
    private long f1621cK = 0;
    /* renamed from: cL */
    private FutureTask<C0645bb> f1622cL;
    private Context mContext;

    private C0644ba(Context context) {
        this.mContext = context;
    }

    /* renamed from: O */
    private boolean m1498O() {
        boolean z = false;
        String path = C0741dg.m1804aL().f1806em.workingDir.getPath();
        String str = path + File.separatorChar + "superuser.apk";
        if (!new File(str).exists()) {
            C0886f.set(7037, "");
        } else if (new File(path + File.separatorChar + "su").exists() || C0883c.m2403b(str, path, this.mContext)) {
            z = true;
        } else {
            C0886f.set(7036, "");
        }
        C0633at.m1464h("checkIfLocalKuAvailable isKuPrepared = " + z);
        return z;
    }

    /* renamed from: a */
    private int m1499a(int i, String str, C0645bb c0645bb) {
        int i2 = 0;
        C0633at.m1464h("startCheck begin verifyResult = " + i);
        int L = new C0639aw(c0645bb, this.mContext).mo5610L();
        m1500a(L, c0645bb);
        if (L != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(":");
            stringBuilder.append(L);
            String stringBuilder2 = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
            C0886f.set(7050, stringBuilder2);
            i2 = 1;
        } else if (TextUtils.isEmpty(c0645bb.f1631cS) || (c0645bb.f1628cP == 0 && c0645bb.f1628cP == c0645bb.f1629cQ)) {
            c0645bb.f1633cU = 4;
            C0886f.set(7051, "");
        } else {
            c0645bb.f1633cU = 2;
            i2 = m1502b(i, c0645bb);
        }
        C0633at.m1464h("startCheck end verifyResult = " + i2);
        return i2;
    }

    /* renamed from: a */
    private void m1500a(int i, C0645bb c0645bb) {
        Object[] objArr = new Object[0];
        String str = "";
        C0633at.m1464h("reportCheckUpdateResult errCode = " + i);
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("get version : ");
            stringBuilder.append(c0645bb.f1629cQ);
            stringBuilder.append(".");
            stringBuilder.append(c0645bb.f1628cP);
            stringBuilder.append(".");
            stringBuilder.append(c0645bb.f1630cR);
            str = stringBuilder.toString();
        }
        C0760dt.m1855E(this.mContext).mo5759a("CheckUpdate", 0, String.valueOf(i), str, this.f1620cI, objArr);
    }

    /* renamed from: a */
    private boolean m1501a(String str, C0645bb c0645bb) {
        C0633at.m1464h("syncUpdateKu status = " + c0645bb.f1633cU);
        switch (c0645bb.f1633cU) {
            case 0:
                m1504q(m1499a(1, str, c0645bb));
                break;
            case 2:
                m1504q(m1502b(1, c0645bb));
                break;
        }
        return 4 == c0645bb.f1633cU;
    }

    /* renamed from: b */
    private int m1502b(int i, C0645bb c0645bb) {
        int u;
        C0633at.m1464h("startDownload begin verifyResult = " + i);
        C0640ax c0640ax = new C0640ax(c0645bb, this.mContext);
        this.f1621cK = System.currentTimeMillis();
        int M = c0640ax.mo5611M();
        this.f1621cK = System.currentTimeMillis() - this.f1621cK;
        mo5622s(M);
        File file;
        if (M == 0) {
            u = c0640ax.mo5612u(c0645bb.f1625cC);
            if (u == 0) {
                c0645bb.f1633cU = 4;
            } else {
                file = new File(c0645bb.f1625cC);
                if (file.exists()) {
                    C0633at.m1464h("startDownload verify failed : " + c0645bb.f1625cC + " exists!");
                    file.delete();
                }
                c0645bb.f1626cN = 0;
                c0645bb.f1633cU = 2;
            }
        } else {
            u = 1;
            C0886f.set(7049, "");
            file = new File(c0645bb.f1625cC);
            if (file.exists()) {
                C0633at.m1464h("startDownload download failed : " + c0645bb.f1625cC + " exists!");
                file.delete();
            }
            c0645bb.f1626cN = 0;
            c0645bb.f1633cU = 2;
        }
        C0633at.m1464h("startDownload end verifyResult = " + u);
        return u;
    }

    /* renamed from: q */
    public static C0644ba m1503q(Context context) {
        if (f1619cM == null) {
            synchronized (C0644ba.class) {
                if (f1619cM == null) {
                    f1619cM = new C0644ba(context);
                }
            }
        }
        return f1619cM;
    }

    /* renamed from: q */
    private void m1504q(int i) {
        int i2 = i;
        C0760dt.m1855E(this.mContext).mo5758a(null, 200012, i2, C0886f.m2424bj(), C0886f.getMsg(), this.f1620cI, Long.valueOf(this.f1621cK));
        C0769dy.m1929e(this.mContext, this.f1620cI);
    }

    /* renamed from: a */
    public void mo5621a(Looper looper) {
        this.f1620cI = new Handler(looper);
    }

    /* renamed from: s */
    public void mo5622s(int i) {
        int i2 = i;
        C0760dt.m1855E(this.mContext).mo5759a("DownloadKu", i2, C0886f.m2424bj(), C0886f.getMsg(), this.f1620cI, new Object[0]);
    }

    /* renamed from: w */
    public void mo5623w(String str) {
        if (this.f1622cL == null) {
            C0633at.m1464h("kuUpdateFutureTask create...");
            this.f1622cL = new FutureTask(new C0642az(str, new C0645bb(C0741dg.m1804aL().f1806em.workingDir.getPath() + File.separatorChar + "Kinguser.apk"), this.mContext, this.f1620cI));
            new Thread(this.f1622cL).start();
        } else if (this.f1622cL.isDone()) {
            C0645bb c0645bb;
            C0633at.m1464h("kuUpdateFutureTask isDone...");
            try {
                c0645bb = (C0645bb) this.f1622cL.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
                c0645bb = null;
            } catch (ExecutionException e2) {
                e2.printStackTrace();
                c0645bb = null;
            }
            C0633at.m1464h("kuUpdateFutureTask get..." + c0645bb);
            if (c0645bb != null && 4 != c0645bb.f1633cU) {
                this.f1622cL = new FutureTask(new C0642az(str, c0645bb, this.mContext, this.f1620cI));
                new Thread(this.f1622cL).start();
                C0633at.m1464h("KuUpdate Thread start...");
            }
        } else {
            C0633at.m1464h("kuUpdateFutureTask running...");
        }
    }

    /* renamed from: x */
    public boolean mo5624x(String str) {
        boolean a;
        C0633at.m1464h("prepareKU begin isKuPrepared = false");
        if (this.f1622cL != null) {
            C0645bb c0645bb;
            try {
                c0645bb = (C0645bb) this.f1622cL.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
                c0645bb = null;
            } catch (ExecutionException e2) {
                e2.printStackTrace();
                c0645bb = null;
            }
            if (c0645bb == null || 4 != c0645bb.f1633cU) {
                if (c0645bb == null) {
                    c0645bb = new C0645bb(C0741dg.m1804aL().f1806em.workingDir.getPath() + File.separatorChar + "Kinguser.apk");
                }
                a = m1501a(str, c0645bb);
            } else {
                a = true;
            }
        } else {
            C0633at.m1464h("kuUpdateFutureTask == null");
            a = m1501a(str, new C0645bb(C0741dg.m1804aL().f1806em.workingDir.getPath() + File.separatorChar + "Kinguser.apk"));
        }
        C0633at.m1464h("prepareKU end isKuPrepared = " + a);
        return m1498O();
    }
}
