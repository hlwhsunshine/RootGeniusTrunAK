package com.shuame.p076b.p077a;

import android.p014os.SystemProperties;
import android.text.TextUtils;
import com.shuame.p078c.C1146b;
import java.util.Map;

/* renamed from: com.shuame.b.a.h */
public final class C1132h extends C1124p {
    /* renamed from: a */
    public final boolean mo6729a(Map<String, String> map, boolean z, C1141q c1141q) {
        boolean z2;
        Object obj = SystemProperties.get("ro.lewa.version");
        String str = SystemProperties.get("ro.lewa.version.type");
        C1146b.m3303a("LeWaHandler", "ro_lewa_version:" + obj);
        if (TextUtils.isEmpty(obj) || z) {
            z2 = false;
        } else {
            C1124p.m3267a((Map) map, "rombrand", "lewa");
            C1124p.m3267a((Map) map, "romversion", (String) obj);
            if ("1".equals(str)) {
                C1124p.m3267a((Map) map, "rombranch", "stable");
            } else {
                C1124p.m3267a((Map) map, "rombranch", "develop");
            }
            z2 = true;
        }
        if (this.f3014b == null) {
            return z2;
        }
        C1124p c1124p = this.f3014b;
        boolean z3 = z || z2;
        return z2 || c1124p.mo6729a((Map) map, z3, c1141q);
    }
}
