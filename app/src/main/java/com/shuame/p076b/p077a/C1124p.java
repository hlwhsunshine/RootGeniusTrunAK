package com.shuame.p076b.p077a;

import android.p014os.SystemProperties;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.shuame.b.a.p */
public abstract class C1124p {
    /* renamed from: a */
    protected final String f3013a = IXAdRequestInfo.MAX_CONTENT_LENGTH;
    /* renamed from: b */
    protected C1124p f3014b;

    /* renamed from: a */
    protected static String m3266a(String str) {
        Matcher matcher = Pattern.compile("(\\d+\\.)+\\d+").matcher(str);
        return matcher.find() ? matcher.group() : "";
    }

    /* renamed from: a */
    protected static void m3267a(Map<String, String> map, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        map.put(str, str2.replaceAll("[\\[\\]]", ""));
    }

    /* renamed from: a */
    protected static boolean m3268a() {
        return !TextUtils.isEmpty(SystemProperties.get("ro.build.version.nanji.display"));
    }

    /* renamed from: a */
    public C1124p mo6728a(C1124p c1124p) {
        this.f3014b = c1124p;
        return this.f3014b;
    }

    /* renamed from: a */
    public abstract boolean mo6729a(Map<String, String> map, boolean z, C1141q c1141q);
}
