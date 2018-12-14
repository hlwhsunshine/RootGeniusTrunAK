package com.shuame.p076b.p077a;

import android.p014os.SystemProperties;
import com.shuame.p078c.C1146b;
import java.io.File;
import java.util.Map;

/* renamed from: com.shuame.b.a.d */
public final class C1128d extends C1124p {
    /* renamed from: a */
    public final boolean mo6729a(Map<String, String> map, boolean z, C1141q c1141q) {
        boolean exists = new File("/system/dxversion").exists();
        C1146b.m3303a("DianXinHandler", "File /system/dxversion exisits:" + exists);
        if (!z && exists) {
            C1124p.m3267a((Map) map, "rombrand", "dianxin");
            String str = SystemProperties.get("ro.dianxinos.os.version");
            C1124p.m3267a((Map) map, "romversion", str);
            C1146b.m3303a("DianXinHandler", "----------------dianxinVersion:" + str);
        }
        if (this.f3014b == null) {
            return exists;
        }
        C1124p c1124p = this.f3014b;
        boolean z2 = z || exists;
        return exists || c1124p.mo6729a((Map) map, z2, c1141q);
    }
}
