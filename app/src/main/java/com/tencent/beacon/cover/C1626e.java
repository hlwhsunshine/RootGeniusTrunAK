package com.tencent.beacon.cover;

import android.content.Context;
import com.tencent.stat.common.DeviceInfo;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.beacon.cover.e */
public final class C1626e {
    /* renamed from: b */
    private static C1626e f4609b = null;
    /* renamed from: c */
    private static String f4610c = "qua_info";
    /* renamed from: a */
    private Context f4611a;
    /* renamed from: d */
    private JSONArray f4612d = null;
    /* renamed from: e */
    private String f4613e = null;

    private C1626e(Context context) {
        if (context == null) {
            C1627f.m4428a("W", "context is null!", new Object[0]);
            return;
        }
        this.f4611a = context.getApplicationContext();
        this.f4613e = C1627f.m4445f(this.f4611a);
        this.f4612d = new JSONArray();
    }

    /* renamed from: a */
    public static synchronized C1626e m4414a(Context context) {
        C1626e c1626e;
        synchronized (C1626e.class) {
            if (f4609b == null) {
                f4609b = new C1626e(context);
            }
            c1626e = f4609b;
        }
        return c1626e;
    }

    /* renamed from: b */
    private String m4415b(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", C1627f.m4434b(this.f4611a));
            jSONObject.put("appversion", C1627f.m4439c(this.f4611a));
            jSONObject.put("model", C1627f.m4419a());
            jSONObject.put(DeviceInfo.TAG_ANDROID_ID, C1627f.m4441d(this.f4611a));
            jSONObject.put("cpuabi", C1627f.m4433b());
            jSONObject.put("coverSDKver", "1.0.9");
            String jSONObject2 = jSONObject.toString();
            String b = C1627f.m4435b(this.f4611a, f4610c, "");
            jSONObject2 = "".equals(b) ? jSONObject2 + "|" : jSONObject2 + "|[" + b + "]";
            if (!z) {
                return jSONObject2 + "|";
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("compsDownRes", false);
            jSONObject3.put("compsDownErr", this.f4612d);
            return jSONObject2 + "|" + jSONObject3.toString();
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: a */
    protected final void mo7602a(String str) {
        String str2 = null;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("res", false);
            jSONObject.put("msg", str.replace(10, ' ').replace(13, ' '));
            str2 = jSONObject.toString();
        } catch (JSONException e) {
        }
        if (str2 != null) {
            try {
                String b = C1627f.m4435b(this.f4611a, f4610c, "");
                if ("".equals(b)) {
                    C1627f.m4429a(this.f4611a, f4610c, str2);
                } else {
                    C1627f.m4429a(this.f4611a, f4610c, b + "," + str2);
                }
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    protected final void mo7603a(boolean z) {
        int i = 0;
        String b = m4415b(z);
        String a = C1627f.m4422a(this.f4613e);
        try {
            byte[] a2 = C1627f.m4432a(true, this.f4613e, b.getBytes("utf-8"));
            if (a2 != null) {
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/x-www-form-urlencoded");
                hashMap.put("Content-Length", String.valueOf(a2.length));
                hashMap.put("encr_type", "rsapost");
                hashMap.put("rsa_encr_key", a);
                hashMap.put("qua_log", "1");
                while (true) {
                    int i2 = i + 1;
                    if (i < 3) {
                        HttpURLConnection a3 = C1629h.m4456a("http://oth.update.mdt.qq.com:8080/beacon/vercheck", hashMap);
                        if (a3 == null || C1629h.m4458a(a3, a2) == null) {
                            C1627f.m4426a(10000);
                            i = i2;
                        } else {
                            C1627f.m4429a(this.f4611a, f4610c, "");
                            return;
                        }
                    }
                    return;
                }
            }
        } catch (Exception e) {
            C1627f.m4428a("E", "Encry post data error!", new Object[0]);
        }
    }

    /* renamed from: b */
    protected final void mo7604b(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("res", false);
            jSONObject.put("msg", str.replace(10, ' ').replace(13, ' '));
            this.f4612d.put(jSONObject);
        } catch (Exception e) {
        }
    }
}
