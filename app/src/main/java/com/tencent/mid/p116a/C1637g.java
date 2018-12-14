package com.tencent.mid.p116a;

import android.content.Context;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.p117b.C1649g;
import com.tencent.mid.util.C1653d;
import com.tencent.mid.util.Util;
import org.json.JSONObject;

/* renamed from: com.tencent.mid.a.g */
public class C1637g {
    /* renamed from: a */
    protected Context f4668a = null;
    /* renamed from: b */
    private int f4669b = 0;

    public C1637g(Context context) {
        this.f4668a = context;
        this.f4669b = (int) (System.currentTimeMillis() / 1000);
    }

    /* renamed from: a */
    public int mo7616a() {
        return 2;
    }

    /* renamed from: a */
    public JSONObject mo7617a(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("et", mo7616a());
        mo7618b(jSONObject);
        return jSONObject;
    }

    /* renamed from: b */
    protected void mo7618b(JSONObject jSONObject) {
        try {
            jSONObject.put("mid", "0");
            jSONObject.put("ts", this.f4669b);
            jSONObject.put("si", this.f4669b);
            Util.jsonPut(jSONObject, "ui", Util.getImei(this.f4668a));
            Util.jsonPut(jSONObject, "mc", Util.getWifiMacAddress(this.f4668a));
            MidEntity a = C1649g.m4537a(this.f4668a).mo7660a();
            if (a != null && Util.isMidValid(a.getMid())) {
                jSONObject.put("mid", a.getMid());
            }
            new C1653d(this.f4668a).mo7670a(jSONObject);
        } catch (Throwable th) {
        }
    }
}
