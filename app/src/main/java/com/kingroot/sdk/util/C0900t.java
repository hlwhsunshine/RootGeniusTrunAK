package com.kingroot.sdk.util;

import com.kingroot.sdk.C0633at;
import com.kingroot.sdk.C0741dg;
import java.io.File;

/* renamed from: com.kingroot.sdk.util.t */
public class C0900t {
    /* renamed from: h */
    public static int m2470h(boolean z) {
        String absolutePath = new File(C0741dg.m1804aL().f1806em.workingDir, "su_check").getAbsolutePath();
        if (z) {
            absolutePath = absolutePath + " --skipapk";
            C0633at.m1464h("exepath = " + absolutePath);
        }
        C0882b c0882b = new C0882b(absolutePath);
        c0882b.run();
        int bg = c0882b.mo5967bg();
        C0633at.m1464h("rootCode = " + bg);
        return bg;
    }
}
