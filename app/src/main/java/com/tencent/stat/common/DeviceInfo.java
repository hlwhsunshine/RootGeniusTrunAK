package com.tencent.stat.common;

import org.json.JSONException;
import org.json.JSONObject;

public class DeviceInfo {
    public static final int NEW_USER = 0;
    public static final int OLD_USER = 1;
    public static final String TAG_ANDROID_ID = "aid";
    public static final String TAG_FLAG = "__MTA_DEVICE_INFO__";
    public static final String TAG_IMEI = "ui";
    public static final String TAG_MAC = "mc";
    public static final String TAG_MID = "mid";
    public static final String TAG_TIMESTAMPS = "ts";
    public static final String TAG_VERSION = "ver";
    public static final int UPGRADE_USER = 2;
    /* renamed from: a */
    private String f5003a = null;
    /* renamed from: b */
    private String f5004b = null;
    /* renamed from: c */
    private String f5005c = null;
    /* renamed from: d */
    private String f5006d = "0";
    /* renamed from: e */
    private int f5007e;
    /* renamed from: f */
    private int f5008f = 0;
    /* renamed from: g */
    private long f5009g = 0;

    public DeviceInfo(String str, String str2, int i) {
        this.f5003a = str;
        this.f5004b = str2;
        this.f5007e = i;
    }

    /* renamed from: a */
    JSONObject mo7890a() {
        JSONObject jSONObject = new JSONObject();
        try {
            Util.jsonPut(jSONObject, "ui", this.f5003a);
            Util.jsonPut(jSONObject, "mc", this.f5004b);
            Util.jsonPut(jSONObject, "mid", this.f5006d);
            Util.jsonPut(jSONObject, TAG_ANDROID_ID, this.f5005c);
            jSONObject.put("ts", this.f5009g);
            jSONObject.put(TAG_VERSION, this.f5008f);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String getImei() {
        return this.f5003a;
    }

    public String getMac() {
        return this.f5004b;
    }

    public String getMid() {
        return this.f5006d;
    }

    public int getUserType() {
        return this.f5007e;
    }

    public void setUserType(int i) {
        this.f5007e = i;
    }

    public String toString() {
        return mo7890a().toString();
    }
}
