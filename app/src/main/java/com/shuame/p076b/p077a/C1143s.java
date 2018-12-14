package com.shuame.p076b.p077a;

import android.p014os.SystemProperties;
import android.text.TextUtils;
import com.shuame.p078c.C1146b;
import java.util.Map;

/* renamed from: com.shuame.b.a.s */
public final class C1143s extends C1124p {
    /* renamed from: a */
    public final boolean mo6729a(Map<String, String> map, boolean z, C1141q c1141q) {
        CharSequence charSequence = SystemProperties.get("romzj.rom.id");
        C1146b.m3303a("ShuameHandler", "romzj.rom.id:" + charSequence);
        C1146b.m3303a("ShuameHandler", "romzj.rom.version:" + SystemProperties.get("romzj.rom.version"));
        C1146b.m3303a("ShuameHandler", "romzj.rom.version.code:" + SystemProperties.get("romzj.rom.version.code"));
        if (TextUtils.isEmpty(charSequence)) {
            C1124p.m3267a((Map) map, "shuame", "false");
        } else {
            C1124p.m3267a((Map) map, "shuame", "true");
        }
        return this.f3014b == null ? false : this.f3014b.mo6729a((Map) map, z, c1141q);
    }
}
