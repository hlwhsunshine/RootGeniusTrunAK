package com.tencent.mid.api;

import com.tencent.mid.util.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class MidEntity {
    public static final String TAG_IMEI = "ui";
    public static final String TAG_MAC = "mc";
    public static final String TAG_MID = "mid";
    public static final String TAG_TIMESTAMPS = "ts";
    /* renamed from: a */
    private String f4675a = null;
    /* renamed from: b */
    private String f4676b = null;
    /* renamed from: c */
    private String f4677c = "0";
    /* renamed from: d */
    private long f4678d = 0;
    /* renamed from: e */
    private boolean f4679e = false;

    public static MidEntity parse(String str) {
        MidEntity midEntity = new MidEntity();
        if (Util.isStringValid(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    midEntity.setImei(jSONObject.getString("ui"));
                }
                if (!jSONObject.isNull("mc")) {
                    midEntity.setMac(jSONObject.getString("mc"));
                }
                if (!jSONObject.isNull("mid")) {
                    midEntity.setMid(jSONObject.getString("mid"));
                }
                if (!jSONObject.isNull("ts")) {
                    midEntity.setTimestamps(jSONObject.getLong("ts"));
                }
            } catch (JSONException e) {
            }
        }
        return midEntity;
    }

    /* renamed from: a */
    JSONObject mo7622a() {
        JSONObject jSONObject = new JSONObject();
        try {
            Util.jsonPut(jSONObject, "ui", this.f4675a);
            Util.jsonPut(jSONObject, "mc", this.f4676b);
            Util.jsonPut(jSONObject, "mid", this.f4677c);
            jSONObject.put("ts", this.f4678d);
        } catch (Throwable e) {
            Util.logWarn(e);
        }
        return jSONObject;
    }

    public int compairTo(MidEntity midEntity) {
        return midEntity == null ? 1 : (isMidValid() && midEntity.isMidValid()) ? this.f4677c.equals(midEntity.f4677c) ? 0 : this.f4678d < midEntity.f4678d ? -1 : 1 : !isMidValid() ? -1 : 1;
    }

    public String getImei() {
        return this.f4675a;
    }

    public String getMac() {
        return this.f4676b;
    }

    public String getMid() {
        return this.f4677c;
    }

    public long getTimestamps() {
        return this.f4678d;
    }

    public boolean isForceWrite() {
        return this.f4679e;
    }

    public boolean isMidValid() {
        return Util.isMidValid(this.f4677c);
    }

    public void setForceWrite(boolean z) {
        this.f4679e = z;
    }

    public void setImei(String str) {
        this.f4675a = str;
    }

    public void setMac(String str) {
        this.f4676b = str;
    }

    public void setMid(String str) {
        this.f4677c = str;
    }

    public void setTimestamps(long j) {
        this.f4678d = j;
    }

    public String toString() {
        return mo7622a().toString();
    }
}
