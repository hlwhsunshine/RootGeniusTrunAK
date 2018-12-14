package com.shuame.p076b.p077a;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.shuame.p078c.C1145a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.shuame.b.a.o */
public final class C1140o {
    /* renamed from: a */
    private Map<String, String> f3016a;

    /* renamed from: com.shuame.b.a.o$a */
    private static class C1139a {
        /* renamed from: a */
        private static C1140o f3015a = new C1140o();
    }

    private C1140o() {
        this.f3016a = new HashMap();
    }

    /* synthetic */ C1140o(byte b) {
        this();
    }

    /* renamed from: a */
    public static C1140o m3287a() {
        return C1139a.f3015a;
    }

    /* renamed from: c */
    private String m3288c() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : this.f3016a.entrySet()) {
            String str = (String) entry.getKey();
            stringBuilder.append("[" + str + "]: [" + ((String) entry.getValue()) + "]\n");
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public final String mo6730a(Context context) {
        if (!this.f3016a.isEmpty()) {
            return m3288c();
        }
        C1141q c1141q = new C1141q(context);
        C1125a c1125a = new C1125a();
        C1124p c1128d = new C1128d();
        C1124p c1132h = new C1132h();
        C1124p c1133i = new C1133i();
        C1124p c1138n = new C1138n();
        C1124p c1134j = new C1134j();
        C1124p c1135k = new C1135k();
        C1124p c1142r = new C1142r();
        C1124p c1144t = new C1144t();
        C1124p c1136l = new C1136l();
        C1124p c1143s = new C1143s();
        C1124p c1137m = new C1137m();
        C1124p c1126b = new C1126b();
        C1124p c1130f = new C1130f();
        c1125a.mo6728a(c1128d).mo6728a(c1136l).mo6728a(c1132h).mo6728a(c1133i).mo6728a(c1138n).mo6728a(c1134j).mo6728a(c1135k).mo6728a(c1142r).mo6728a(c1144t).mo6728a(c1130f).mo6728a(new C1131g()).mo6728a(new C1129e()).mo6728a(new C1127c()).mo6728a(c1143s);
        c1143s.mo6728a(c1137m);
        c1137m.mo6728a(c1126b);
        if (!c1125a.mo6729a(this.f3016a, false, c1141q)) {
            this.f3016a.put("rombrand", "unknown");
            this.f3016a.put("romversion", "unknown");
        }
        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        Object a = C1145a.m3302a(context);
        if (TextUtils.isEmpty(a)) {
            a = "";
        }
        this.f3016a.put("imei", deviceId);
        this.f3016a.put("mac", a);
        return m3288c();
    }

    /* renamed from: b */
    public final Map<String, String> mo6731b() {
        return this.f3016a;
    }
}
