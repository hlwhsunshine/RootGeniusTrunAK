package com.shuame.p076b.p077a;

import android.p014os.SystemProperties;
import android.text.TextUtils;
import java.util.Map;

/* renamed from: com.shuame.b.a.e */
public final class C1129e extends C1124p {
    /* renamed from: a */
    public final boolean mo6729a(Map<String, String> map, boolean z, C1141q c1141q) {
        boolean z2;
        if (z) {
            z2 = false;
        } else {
            String str = SystemProperties.get("ro.build.display.id");
            Object obj = SystemProperties.get("ro.build.version.emui");
            if (TextUtils.isEmpty(str) || !str.toUpperCase().contains("EMUI")) {
                z2 = false;
            } else {
                C1124p.m3267a((Map) map, "rombrand", "emui");
                C1124p.m3267a((Map) map, "romversion", str);
                C1124p.m3267a((Map) map, "rombranch", "develop");
                z2 = true;
            }
            if (!TextUtils.isEmpty(obj) && obj.toUpperCase().contains("EMOTIONUI")) {
                C1124p.m3267a((Map) map, "rombrand", "emui");
                C1124p.m3267a((Map) map, "romversion", str);
                C1124p.m3267a((Map) map, "rombranch", "stable");
                z2 = true;
            }
        }
        if (this.f3014b == null) {
            return z2;
        }
        C1124p c1124p = this.f3014b;
        boolean z3 = z || z2;
        return z2 || c1124p.mo6729a((Map) map, z3, c1141q);
    }
}
