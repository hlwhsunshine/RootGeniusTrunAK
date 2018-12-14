package com.tencent.stat;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkMonitor {
    /* renamed from: a */
    private long f4782a = 0;
    /* renamed from: b */
    private int f4783b = 0;
    /* renamed from: c */
    private String f4784c = "";
    /* renamed from: d */
    private int f4785d = 0;
    /* renamed from: e */
    private String f4786e = "";

    public String getDomain() {
        return this.f4784c;
    }

    public long getMillisecondsConsume() {
        return this.f4782a;
    }

    public int getPort() {
        return this.f4785d;
    }

    public String getRemoteIp() {
        return this.f4786e;
    }

    public int getStatusCode() {
        return this.f4783b;
    }

    public void setDomain(String str) {
        this.f4784c = str;
    }

    public void setMillisecondsConsume(long j) {
        this.f4782a = j;
    }

    public void setPort(int i) {
        this.f4785d = i;
    }

    public void setRemoteIp(String str) {
        this.f4786e = str;
    }

    public void setStatusCode(int i) {
        this.f4783b = i;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IXAdRequestInfo.MAX_TITLE_LENGTH, this.f4782a);
            jSONObject.put("st", this.f4783b);
            if (this.f4784c != null) {
                jSONObject.put("dm", this.f4784c);
            }
            jSONObject.put("pt", this.f4785d);
            if (this.f4786e != null) {
                jSONObject.put("rip", this.f4786e);
            }
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
