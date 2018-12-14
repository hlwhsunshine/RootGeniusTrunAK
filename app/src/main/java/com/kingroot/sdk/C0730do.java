package com.kingroot.sdk;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.kingroot.sdk.C0638av.C0636b;
import com.kingroot.sdk.util.C0886f;
import com.kingroot.sdk.util.C0897q;
import krsdk.RootShell.ShellResult;

/* renamed from: com.kingroot.sdk.do */
public class C0730do extends C0719cs {
    /* renamed from: fK */
    protected C0638av f1779fK;

    /* renamed from: aT */
    public void mo5706aT() {
        try {
            this.f1779fK = new C0638av(IXAdRequestInfo.SCREEN_HEIGHT);
            this.f1779fK.mo5609t("export PATH=/sbin:/vendor/bin:/system/sbin:/system/bin:/system/xbin:$PATH");
        } catch (Throwable e) {
            C0633at.m1458a("KD(SU)RootShell.initShell", e);
        }
    }

    public void close() {
        if (this.f1779fK != null) {
            this.f1779fK.shutdown();
        }
    }

    public String executeCommand(String str) {
        C0886f.clean();
        C0747dj.m1814N(str);
        String str2 = null;
        try {
            str2 = this.f1779fK.mo5609t(str).f1585cs;
        } catch (Throwable th) {
            C0633at.m1458a("KD(SU)RootShell.executeCommand:" + str, th);
            C0886f.set(7016, "kd(su)shell throw exception", th);
        }
        C0633at.m1464h("cmd: " + str + ", ret: " + str2);
        return str2;
    }

    public ShellResult executeCommand2(String str) {
        return executeCommand2(str, 120000);
    }

    public ShellResult executeCommand2(String str, long j) {
        C0747dj.m1814N(str);
        ShellResult shellResult = new ShellResult();
        try {
            C0636b b = this.f1779fK.mo5606b(str, j);
            shellResult.ret = b.f1587cu.intValue();
            shellResult.stdout = b.f1585cs + b.f1586ct;
        } catch (Throwable th) {
            C0633at.m1458a("KD(SU)RootShell.executeCommand:" + str, th);
            shellResult.ret = -1;
            shellResult.stdout = C0897q.m2464b(th);
        }
        if (shellResult.ret == 0) {
            C0633at.m1464h("cmd: " + str + ", ret: " + shellResult.ret + ", stdout = " + shellResult.stdout);
        } else {
            C0633at.m1465i("cmd: " + str + ", ret: " + shellResult.ret + ", stdout = " + shellResult.stdout);
        }
        return shellResult;
    }
}
