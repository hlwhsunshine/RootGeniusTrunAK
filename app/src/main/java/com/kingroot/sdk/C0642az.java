package com.kingroot.sdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.kingroot.sdk.util.C0886f;
import java.io.File;
import java.util.concurrent.Callable;

/* renamed from: com.kingroot.sdk.az */
public class C0642az implements Callable<C0645bb> {
    /* renamed from: cG */
    private C0639aw f1609cG;
    /* renamed from: cH */
    private C0640ax f1610cH;
    /* renamed from: cI */
    private Handler f1611cI;
    /* renamed from: cJ */
    private final String f1612cJ;
    /* renamed from: cK */
    private long f1613cK = 0;
    /* renamed from: cx */
    private C0645bb f1614cx;
    private final Context mContext;

    public C0642az(String str, C0645bb c0645bb, Context context, Handler handler) {
        this.f1612cJ = str;
        this.f1614cx = c0645bb;
        this.mContext = context;
        this.f1611cI = handler;
        this.f1609cG = new C0639aw(c0645bb, context);
        this.f1610cH = new C0640ax(c0645bb, context);
    }

    /* renamed from: a */
    private boolean m1486a(C0639aw c0639aw) {
        C0783ek c0783ek = c0639aw.f1600cB;
        int i = c0639aw.f1599cA;
        if (c0783ek != null) {
            C0633at.m1464h("notNeedDownloadKingUser: mLocalProductVersion = " + c0783ek + ", mLocalBuildno = " + i);
            C0633at.m1464h("LocalVersion: " + c0783ek.f1918ab + "." + c0783ek.f1919ac + "." + c0783ek.f1920ad);
            C0633at.m1464h("ServerVersion: " + this.f1614cx.f1629cQ + "." + this.f1614cx.f1628cP + "." + this.f1614cx.f1630cR + ", ServerApkBuildno = " + this.f1614cx.f1627cO);
            if (c0783ek.f1918ab > this.f1614cx.f1629cQ) {
                return true;
            }
            if (c0783ek.f1918ab == this.f1614cx.f1629cQ) {
                if (c0783ek.f1919ac > this.f1614cx.f1628cP) {
                    return true;
                }
                if (c0783ek.f1919ac == this.f1614cx.f1628cP) {
                    if (c0783ek.f1920ad > this.f1614cx.f1630cR) {
                        return true;
                    }
                    if (c0783ek.f1920ad == this.f1614cx.f1630cR && i >= this.f1614cx.f1627cO) {
                        return true;
                    }
                }
            }
        }
        C0633at.m1464h("notNeedDownloadKingUser return false");
        return false;
    }

    /* renamed from: q */
    private void m1487q(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f1612cJ);
        stringBuilder.append(":");
        stringBuilder.append(C0886f.getMsg());
        String stringBuilder2 = stringBuilder.toString();
        stringBuilder.delete(0, stringBuilder.length());
        int i2 = i;
        C0760dt.m1855E(this.mContext).mo5758a(null, 200012, i2, C0886f.m2424bj(), stringBuilder2, this.f1611cI, Long.valueOf(this.f1613cK));
        C0769dy.m1929e(this.mContext, this.f1611cI);
    }

    /* renamed from: r */
    private void m1488r(int i) {
        Object[] objArr = new Object[0];
        String str = "";
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("get version : ");
            stringBuilder.append(this.f1614cx.f1629cQ);
            stringBuilder.append(".");
            stringBuilder.append(this.f1614cx.f1628cP);
            stringBuilder.append(".");
            stringBuilder.append(this.f1614cx.f1630cR);
            str = stringBuilder.toString();
        }
        C0760dt.m1855E(this.mContext).mo5759a("CheckUpdate", 0, String.valueOf(i), str, this.f1611cI, objArr);
    }

    /* renamed from: t */
    private int m1489t(int i) {
        int i2 = 0;
        C0633at.m1464h("startCheck begin verifyResult = " + i);
        int L = this.f1609cG.mo5610L();
        m1488r(L);
        if (L != 0) {
            C0886f.set(7050, String.valueOf(L));
            this.f1614cx.f1633cU = 0;
            i2 = 1;
        } else if (TextUtils.isEmpty(this.f1614cx.f1631cS) || ((this.f1614cx.f1628cP == 0 && this.f1614cx.f1628cP == this.f1614cx.f1629cQ) || m1486a(this.f1609cG))) {
            this.f1614cx.f1633cU = 4;
            C0886f.set(7051, "");
        } else {
            C0633at.m1464h("startCheck: will startDownload here...");
            this.f1614cx.f1633cU = 2;
            i2 = m1490u(i);
        }
        C0633at.m1464h("startCheck end verifyResult = " + i2);
        return i2;
    }

    /* renamed from: u */
    private int m1490u(int i) {
        C0633at.m1464h("startDownload begin verifyResult = " + i);
        this.f1613cK = System.currentTimeMillis();
        int M = this.f1610cH.mo5611M();
        this.f1613cK = System.currentTimeMillis() - this.f1613cK;
        mo5615s(M);
        if (M != 0) {
            M = 1;
            C0886f.set(7049, "");
            File file = new File(this.f1614cx.f1625cC);
            if (file.exists()) {
                C0633at.m1464h("startDownload " + this.f1614cx.f1625cC + " exists!");
                file.delete();
            }
            this.f1614cx.f1626cN = 0;
            this.f1614cx.f1633cU = 2;
        } else {
            M = this.f1610cH.mo5612u(this.f1614cx.f1625cC);
        }
        C0633at.m1464h("startDownload end verifyResult = " + M);
        return M;
    }

    /* renamed from: N */
    public C0645bb call() {
        int i = 1;
        C0633at.m1464h("KuUpdate call begin status = " + this.f1614cx.f1633cU);
        switch (this.f1614cx.f1633cU) {
            case 0:
                i = m1489t(1);
                m1487q(i);
                break;
            case 2:
                i = m1490u(1);
                m1487q(i);
                break;
        }
        C0633at.m1464h("KuUpdate call end status = " + this.f1614cx.f1633cU + ", verifyResult = " + i);
        return this.f1614cx;
    }

    /* renamed from: s */
    public void mo5615s(int i) {
        int i2 = i;
        C0760dt.m1855E(this.mContext).mo5759a("DownloadKu", i2, C0886f.m2424bj(), C0886f.getMsg(), this.f1611cI, new Object[0]);
    }
}
