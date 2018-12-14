package com.shuame.p076b.p077a;

import android.p014os.SystemProperties;
import android.text.TextUtils;
import com.shuame.p078c.C1146b;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.shuame.b.a.t */
public final class C1144t extends C1124p {
    /* renamed from: b */
    private static String m3298b(String str) {
        Matcher matcher = Pattern.compile("tita_([\\d\\.]+)_(\\w+)").matcher(str.toLowerCase());
        if (!matcher.find()) {
            return "";
        }
        for (int i = 0; i <= matcher.groupCount(); i++) {
            C1146b.m3303a("TITA", "group[" + i + "]" + matcher.group(i));
        }
        return matcher.group(2);
    }

    /* renamed from: a */
    public final boolean mo6729a(Map<String, String> map, boolean z, C1141q c1141q) {
        String str = SystemProperties.get("ro.build.version.nanji.display");
        C1146b.m3303a("TitaHandler", "Tita version:" + str);
        boolean a = C1124p.m3268a();
        boolean a2 = C1124p.m3268a();
        boolean z2 = !TextUtils.isEmpty(str);
        C1146b.m3303a("TitaHandler", a + a2 + z2);
        if (z2 || a || a2) {
            if (!z) {
                C1124p.m3267a((Map) map, "rombrand", "tita");
                C1124p.m3267a((Map) map, "romversion", str);
                C1124p.m3267a((Map) map, "rombranch", C1144t.m3298b(str));
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
