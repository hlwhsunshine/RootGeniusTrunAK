package com.kingroot.sdk;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.kingroot.sdk.cf */
public class C0700cf {
    /* renamed from: dY */
    private static Map<String, C0698cd> f1719dY = new HashMap();

    /* renamed from: D */
    public static synchronized C0698cd m1686D(String str) {
        C0698cd c0698cd;
        synchronized (C0700cf.class) {
            c0698cd = (C0698cd) f1719dY.get(str);
            if (c0698cd == null) {
                c0698cd = new C0699ce(str);
                f1719dY.put(str, c0698cd);
            }
        }
        return c0698cd;
    }
}
