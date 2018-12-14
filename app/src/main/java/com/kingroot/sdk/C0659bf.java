package com.kingroot.sdk;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.kingroot.sdk.C0851gl.C0849b;
import krsdk.RootShell;
import krsdk.RootShell.ShellResult;

/* renamed from: com.kingroot.sdk.bf */
public final class C0659bf {
    /* renamed from: db */
    private static RootShell f1655db;
    /* renamed from: dc */
    private static C0851gl f1656dc;

    private C0659bf() {
    }

    /* renamed from: Y */
    public static C0851gl m1546Y() {
        if (f1656dc == null) {
            synchronized (C0659bf.class) {
                if (f1656dc == null) {
                    f1656dc = C0827fs.m2106ak(IXAdRequestInfo.SCREEN_HEIGHT);
                }
            }
        }
        return f1656dc;
    }

    /* renamed from: a */
    public static void m1547a(RootShell rootShell) {
        if (rootShell != null) {
            synchronized (C0659bf.class) {
                if (rootShell != null) {
                    f1655db = rootShell;
                }
            }
        }
    }

    /* renamed from: c */
    public static RootShell m1548c(boolean z) {
        if (f1655db == null) {
            synchronized (C0659bf.class) {
                if (f1655db == null) {
                    RootShell b = C0731cz.m1768b(C0731cz.m1767aJ(), 0);
                    f1655db = b;
                    if (b == null && z) {
                        f1655db = C0750dl.m1838aQ();
                    }
                }
            }
        }
        return f1655db;
    }

    /* renamed from: z */
    public static ShellResult m1549z(String str) {
        int i = -1;
        ShellResult shellResult = new ShellResult();
        shellResult.ret = -1;
        shellResult.stdout = null;
        try {
            C0849b c = C0659bf.m1546Y().mo5855c(str, 120000);
            if (c.f2106cu != null) {
                i = c.f2106cu.intValue();
            }
            shellResult.ret = i;
            shellResult.stdout = c.f2104cs;
        } catch (Throwable e) {
            C0633at.m1459a(e);
        }
        return shellResult;
    }
}
