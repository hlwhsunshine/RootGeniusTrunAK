package com.tencent.mid.util;

import android.content.Context;
import org.json.JSONObject;

/* renamed from: com.tencent.mid.util.d */
public class C1653d {
    /* renamed from: a */
    static C1655f f4716a;
    /* renamed from: d */
    private static JSONObject f4717d = null;
    /* renamed from: b */
    Integer f4718b = null;
    /* renamed from: c */
    String f4719c = null;

    public C1653d(Context context) {
        try {
            C1653d.m4548a(context);
            this.f4718b = C1657h.m4561e(context.getApplicationContext());
            this.f4719c = C1657h.m4560d(context);
        } catch (Throwable th) {
            Util.logWarn(th);
        }
    }

    /* renamed from: a */
    static synchronized C1655f m4548a(Context context) {
        C1655f c1655f;
        synchronized (C1653d.class) {
            if (f4716a == null) {
                f4716a = new C1655f(context.getApplicationContext());
            }
            c1655f = f4716a;
        }
        return c1655f;
    }

    /* renamed from: a */
    public void mo7670a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (f4716a != null) {
                f4716a.mo7671a(jSONObject2);
            }
            Util.jsonPut(jSONObject2, "cn", this.f4719c);
            if (this.f4718b != null) {
                jSONObject2.put("tn", this.f4718b);
            }
            jSONObject.put("ev", jSONObject2);
            if (f4717d != null && f4717d.length() > 0) {
                jSONObject.put("eva", f4717d);
            }
        } catch (Throwable th) {
            Util.logWarn(th);
        }
    }
}
