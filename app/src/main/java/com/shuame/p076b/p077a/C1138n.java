package com.shuame.p076b.p077a;

import com.shuame.p078c.C1146b;
import java.util.Map;

/* renamed from: com.shuame.b.a.n */
public final class C1138n extends C1124p {
    /* renamed from: a */
    public final boolean mo6729a(Map<String, String> map, boolean z, C1141q c1141q) {
        boolean z2;
        String b = c1141q.mo6733b();
        C1146b.m3303a("QissMeHandler", "build id:" + b);
        if (b.toLowerCase().contains("qiss_me")) {
            if (!z) {
                C1124p.m3267a((Map) map, "rombrand", "qiss_me");
                C1124p.m3267a((Map) map, "romversion", C1124p.m3266a(c1141q.mo6732a()));
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f3014b == null) {
            return z2;
        }
        C1124p c1124p = this.f3014b;
        boolean z3 = z || z2;
        return z2 || c1124p.mo6729a((Map) map, z3, c1141q);
    }
}
