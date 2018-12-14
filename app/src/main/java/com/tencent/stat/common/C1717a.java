package com.tencent.stat.common;

import android.content.Context;
import com.tencent.stat.NetworkManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.common.a */
public class C1717a {
    /* renamed from: a */
    static C1719c f5041a;
    /* renamed from: d */
    private static StatLogger f5042d = StatCommonHelper.getLogger();
    /* renamed from: e */
    private static JSONObject f5043e = new JSONObject();
    /* renamed from: b */
    Integer f5044b = null;
    /* renamed from: c */
    String f5045c = null;

    public C1717a(Context context) {
        try {
            C1717a.m4732a(context);
            this.f5044b = StatCommonHelper.getTelephonyNetworkType(context.getApplicationContext());
            this.f5045c = NetworkManager.getInstance(context).getCurNetwrokName();
        } catch (Throwable th) {
            f5042d.mo7900e(th);
        }
    }

    /* renamed from: a */
    static synchronized C1719c m4732a(Context context) {
        C1719c c1719c;
        synchronized (C1717a.class) {
            if (f5041a == null) {
                f5041a = new C1719c(context.getApplicationContext(), null);
            }
            c1719c = f5041a;
        }
        return c1719c;
    }

    /* renamed from: a */
    public static void m4733a(Context context, Map<String, String> map) {
        if (map != null) {
            for (Entry entry : new HashMap(map).entrySet()) {
                f5043e.put((String) entry.getKey(), entry.getValue());
            }
        }
    }

    /* renamed from: a */
    public void mo7914a(JSONObject jSONObject, Thread thread) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (f5041a != null) {
                f5041a.mo7915a(jSONObject2, thread);
            }
            Util.jsonPut(jSONObject2, "cn", this.f5045c);
            if (this.f5044b != null) {
                jSONObject2.put("tn", this.f5044b);
            }
            if (thread == null) {
                jSONObject.put("ev", jSONObject2);
            } else {
                jSONObject.put("errkv", jSONObject2.toString());
            }
            if (f5043e != null && f5043e.length() > 0) {
                jSONObject.put("eva", f5043e);
            }
        } catch (Throwable th) {
            f5042d.mo7900e(th);
        }
    }
}
