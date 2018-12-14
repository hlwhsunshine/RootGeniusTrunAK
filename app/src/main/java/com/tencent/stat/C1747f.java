package com.tencent.stat;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.stat.common.StatPreferences;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.f */
class C1747f {
    /* renamed from: a */
    int f5129a;
    /* renamed from: b */
    JSONObject f5130b = new JSONObject();
    /* renamed from: c */
    String f5131c = "";
    /* renamed from: d */
    int f5132d = 0;
    /* renamed from: e */
    private boolean f5133e = false;

    public C1747f(int i) {
        this.f5129a = i;
    }

    /* renamed from: a */
    private void m4797a(String str) {
        try {
            if (StatConfig.isDebugEnable()) {
                StatConfig.f4845r.mo7897d("load config begin:" + str);
            }
            JSONObject jSONObject = new JSONObject(str);
            this.f5129a = jSONObject.optInt("type");
            this.f5130b = new JSONObject(jSONObject.optString("props", ""));
            this.f5131c = jSONObject.optString("md5sum", "");
            this.f5132d = jSONObject.optInt("version", 0);
            if (StatConfig.isDebugEnable()) {
                StatConfig.f4845r.mo7897d("load config end, type=" + this.f5129a + " ,props=" + this.f5130b + " ,version=" + this.f5132d);
            }
            StatConfig.m4594a();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public String mo7940a() {
        return "com.tencent.mta.cfg.store" + this.f5129a;
    }

    /* renamed from: a */
    public void mo7941a(Context context) {
        StatPreferences.putString(context, mo7940a(), mo7942b().toString());
    }

    /* renamed from: b */
    public JSONObject mo7942b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f5129a);
            jSONObject.put("props", this.f5130b);
            jSONObject.put("md5sum", this.f5131c);
            jSONObject.put("version", this.f5132d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: b */
    public boolean mo7943b(Context context) {
        if (this.f5133e) {
            return true;
        }
        this.f5133e = true;
        String string = StatPreferences.getString(context, mo7940a(), "");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        m4797a(string);
        return true;
    }

    /* renamed from: c */
    String mo7944c() {
        return this.f5130b.toString();
    }
}
