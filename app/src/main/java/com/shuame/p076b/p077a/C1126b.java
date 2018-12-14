package com.shuame.p076b.p077a;

import android.p014os.SystemProperties;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.shuame.p078c.C1146b;
import java.util.Map;

/* renamed from: com.shuame.b.a.b */
public final class C1126b extends C1124p {
    /* renamed from: a */
    public final C1124p mo6728a(C1124p c1124p) {
        throw new RuntimeException("Cm handler must be at the end of the responsbility chain");
    }

    /* renamed from: a */
    public final boolean mo6729a(Map<String, String> map, boolean z, C1141q c1141q) {
        boolean z2 = false;
        String str = SystemProperties.get("ro.modversion");
        C1146b.m3303a("CmHandler", "Cm version:" + str);
        if (!TextUtils.isEmpty(str)) {
            z2 = true;
            if (z) {
                C1124p.m3267a((Map) map, "rombase", IXAdRequestInfo.MAX_CONTENT_LENGTH);
                C1124p.m3267a((Map) map, "rombasever", str);
            } else {
                C1124p.m3267a((Map) map, "rombrand", IXAdRequestInfo.MAX_CONTENT_LENGTH);
                C1124p.m3267a((Map) map, "romversion", str);
            }
        }
        return z2;
    }
}
