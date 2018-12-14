package com.shuame.p076b.p077a;

import android.p014os.SystemProperties;
import android.text.TextUtils;
import com.shuame.p078c.C1146b;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.shuame.b.a.r */
public final class C1142r extends C1124p {
    /* renamed from: a */
    public final boolean mo6729a(Map<String, String> map, boolean z, C1141q c1141q) {
        boolean z2;
        CharSequence charSequence = SystemProperties.get("ro.shendu.version");
        C1146b.m3303a("ShenduHandler", "Shendu version:" + charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            z2 = false;
        } else {
            if (!z) {
                C1124p.m3267a((Map) map, "rombrand", "shendu");
                String str = "romversion";
                Matcher matcher = Pattern.compile("(\\d+\\.)+\\d+-\\d+").matcher(charSequence);
                C1124p.m3267a((Map) map, str, matcher.find() ? matcher.group() : "");
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
