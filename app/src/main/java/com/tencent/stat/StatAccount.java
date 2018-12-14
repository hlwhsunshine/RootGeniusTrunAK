package com.tencent.stat;

import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class StatAccount {
    public static final int CUSTOM_TYPE = 7;
    public static final int DEFAULT_TYPE = 0;
    public static final int EMAIL_TYPE = 6;
    public static final int PHONE_NUM_TYPE = 5;
    public static final int QQ_NUM_TYPE = 1;
    public static final int QQ_OPENID_TYPE = 3;
    public static final int WECHAT_ID_TYPE = 2;
    public static final int WECHAT_OPENID_TYPE = 4;
    /* renamed from: a */
    private String f4787a = "";
    /* renamed from: b */
    private int f4788b = 0;
    /* renamed from: c */
    private String f4789c = "";
    /* renamed from: d */
    private String f4790d = "";

    public StatAccount(String str) {
        this.f4787a = str;
    }

    public StatAccount(String str, int i) {
        this.f4787a = str;
        this.f4788b = i;
    }

    public String getAccount() {
        return this.f4787a;
    }

    public int getAccountType() {
        return this.f4788b;
    }

    public String getExt() {
        return this.f4789c;
    }

    public String getExt1() {
        return this.f4790d;
    }

    public void setAccount(String str) {
        this.f4787a = str;
    }

    public void setAccountType(int i) {
        this.f4788b = i;
    }

    public void setExt(String str) {
        this.f4789c = str;
    }

    public void setExt1(String str) {
        this.f4790d = str;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        if (StatCommonHelper.isStringValid(this.f4787a)) {
            try {
                Util.jsonPut(jSONObject, "a", this.f4787a);
                jSONObject.put("t", this.f4788b);
                Util.jsonPut(jSONObject, "e", this.f4789c);
                Util.jsonPut(jSONObject, "e1", this.f4790d);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "StatAccount [account=" + this.f4787a + ", accountType=" + this.f4788b + ", ext=" + this.f4789c + ", ext1=" + this.f4790d + "]";
    }
}
