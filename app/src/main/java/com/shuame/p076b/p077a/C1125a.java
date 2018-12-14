package com.shuame.p076b.p077a;

import android.p014os.SystemProperties;
import android.text.TextUtils;
import com.shuame.p078c.C1146b;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.shuame.b.a.a */
public final class C1125a extends C1124p {
    /* renamed from: a */
    public final boolean mo6729a(Map<String, String> map, boolean z, C1141q c1141q) {
        String str;
        boolean z2;
        String str2;
        CharSequence charSequence = SystemProperties.get("ro.baidu.build.version.release");
        Object obj = SystemProperties.get("ro.product.manufacturer");
        CharSequence charSequence2 = SystemProperties.get("ro.version.type");
        CharSequence charSequence3 = SystemProperties.get("ro.build.version.incremental");
        Map hashMap = new HashMap();
        hashMap.put("1", "alpha");
        hashMap.put("2", "beta");
        hashMap.put("3", "release");
        hashMap.put("s", "release");
        hashMap.put("r", "beta");
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = "";
        } else {
            str = (String) hashMap.get(charSequence2);
        }
        CharSequence charSequence4;
        if (!TextUtils.isEmpty(charSequence) || (!TextUtils.isEmpty(obj) && obj.toLowerCase().equals("baidu"))) {
            Matcher matcher = Pattern.compile("(\\w*)_(\\w*)_([\\d\\.]+)").matcher(charSequence3);
            if (matcher.find()) {
                for (int i = 0; i <= matcher.groupCount(); i++) {
                    C1146b.m3303a("BaiDuYunHandler", "group[" + i + "]" + matcher.group(i));
                }
                if (TextUtils.isEmpty(charSequence2)) {
                    charSequence2 = (String) hashMap.get(matcher.group(2).toLowerCase());
                }
                matcher.group(3).split("\\.");
                z2 = true;
                charSequence4 = charSequence2;
                str = charSequence3;
                str2 = charSequence4;
            } else {
                z2 = true;
                charSequence4 = charSequence2;
                charSequence2 = charSequence3;
                charSequence3 = charSequence4;
            }
        } else {
            z2 = false;
            charSequence4 = charSequence2;
            charSequence2 = charSequence3;
            charSequence3 = charSequence4;
        }
        if (!z && z2) {
            C1124p.m3267a((Map) map, "rombrand", "baiduyun");
            C1124p.m3267a((Map) map, "romversion", str);
            C1124p.m3267a((Map) map, "rombranch", str2);
        }
        if (this.f3014b == null) {
            return z2;
        }
        C1124p c1124p = this.f3014b;
        boolean z3 = z || z2;
        return z2 || c1124p.mo6729a((Map) map, z3, c1141q);
    }
}
