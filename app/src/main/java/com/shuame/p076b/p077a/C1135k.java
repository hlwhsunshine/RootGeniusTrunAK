package com.shuame.p076b.p077a;

import android.p014os.SystemProperties;
import android.text.TextUtils;
import com.shuame.p078c.C1146b;
import java.util.Map;

/* renamed from: com.shuame.b.a.k */
public final class C1135k extends C1124p {
    /* renamed from: a */
    public final boolean mo6729a(Map<String, String> map, boolean z, C1141q c1141q) {
        boolean z2;
        String c = c1141q.mo6734c();
        Object obj = SystemProperties.get("ro.build.host");
        C1146b.m3303a("MokeeHandler", "displayId:" + c);
        CharSequence charSequence = SystemProperties.get("ro.mk.version");
        if (c.toLowerCase().contains("mokeeos") || (!TextUtils.isEmpty(obj) && obj.toLowerCase().contains("mokee"))) {
            if (!z) {
                C1124p.m3267a((Map) map, "rombrand", "mokee");
                if (!TextUtils.isEmpty(charSequence)) {
                    CharSequence c2 = charSequence;
                }
                C1124p.m3267a((Map) map, "romversion", c2);
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
