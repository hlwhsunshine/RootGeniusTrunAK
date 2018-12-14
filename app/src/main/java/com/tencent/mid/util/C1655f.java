package com.tencent.mid.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mid.util.f */
class C1655f {
    /* renamed from: a */
    String f4720a;
    /* renamed from: b */
    String f4721b;
    /* renamed from: c */
    DisplayMetrics f4722c;
    /* renamed from: d */
    int f4723d;
    /* renamed from: e */
    String f4724e;
    /* renamed from: f */
    String f4725f;
    /* renamed from: g */
    String f4726g;
    /* renamed from: h */
    String f4727h;
    /* renamed from: i */
    String f4728i;
    /* renamed from: j */
    String f4729j;
    /* renamed from: k */
    String f4730k;
    /* renamed from: l */
    int f4731l;
    /* renamed from: m */
    String f4732m;
    /* renamed from: n */
    Context f4733n;
    /* renamed from: o */
    private String f4734o;
    /* renamed from: p */
    private String f4735p;
    /* renamed from: q */
    private String f4736q;
    /* renamed from: r */
    private String f4737r;

    private C1655f(Context context) {
        this.f4721b = "2.2";
        this.f4723d = VERSION.SDK_INT;
        this.f4724e = Build.MODEL;
        this.f4725f = Build.MANUFACTURER;
        this.f4726g = Locale.getDefault().getLanguage();
        this.f4731l = 0;
        this.f4732m = null;
        this.f4733n = null;
        this.f4734o = null;
        this.f4735p = null;
        this.f4736q = null;
        this.f4737r = null;
        this.f4733n = context;
        this.f4722c = C1657h.m4555a(context);
        this.f4720a = C1657h.m4559c(context);
        this.f4728i = C1657h.m4558b(context);
        this.f4729j = TimeZone.getDefault().getID();
        this.f4730k = C1657h.m4562f(context);
        this.f4732m = context.getPackageName();
        this.f4737r = C1657h.m4556a();
    }

    /* renamed from: a */
    void mo7671a(JSONObject jSONObject) {
        jSONObject.put("sr", this.f4722c.widthPixels + "*" + this.f4722c.heightPixels);
        Util.jsonPut(jSONObject, "av", this.f4720a);
        Util.jsonPut(jSONObject, "ch", this.f4727h);
        Util.jsonPut(jSONObject, "mf", this.f4725f);
        Util.jsonPut(jSONObject, "sv", this.f4721b);
        Util.jsonPut(jSONObject, "ov", Integer.toString(this.f4723d));
        jSONObject.put(IXAdRequestInfo.f648OS, 1);
        Util.jsonPut(jSONObject, "op", this.f4728i);
        Util.jsonPut(jSONObject, "lg", this.f4726g);
        Util.jsonPut(jSONObject, IXAdRequestInfo.TEST_MODE, this.f4724e);
        Util.jsonPut(jSONObject, "tz", this.f4729j);
        if (this.f4731l != 0) {
            jSONObject.put("jb", this.f4731l);
        }
        Util.jsonPut(jSONObject, "sd", this.f4730k);
        Util.jsonPut(jSONObject, "apn", this.f4732m);
        if (Util.isNetworkAvailable(this.f4733n) && Util.isWifiNet(this.f4733n)) {
            JSONObject jSONObject2 = new JSONObject();
            Util.jsonPut(jSONObject2, "bs", Util.getWiFiBBSID(this.f4733n));
            Util.jsonPut(jSONObject2, "ss", Util.getWiFiSSID(this.f4733n));
            if (jSONObject2.length() > 0) {
                Util.jsonPut(jSONObject, "wf", jSONObject2.toString());
            }
        }
        JSONArray wifiTopN = Util.getWifiTopN(this.f4733n, 10);
        if (wifiTopN != null && wifiTopN.length() > 0) {
            Util.jsonPut(jSONObject, "wflist", wifiTopN.toString());
        }
        Util.jsonPut(jSONObject, "sen", this.f4734o);
        Util.jsonPut(jSONObject, "cpu", this.f4735p);
        Util.jsonPut(jSONObject, "ram", this.f4736q);
        Util.jsonPut(jSONObject, "rom", this.f4737r);
    }
}
