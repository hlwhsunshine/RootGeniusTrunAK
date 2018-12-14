package com.baidu.mobads.p040vo;

import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.p025c.C0265a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.vo.c */
public class C0438c implements IXAdResponseInfo {
    /* renamed from: a */
    private int f1098a = 0;
    /* renamed from: b */
    private Boolean f1099b = Boolean.valueOf(false);
    /* renamed from: c */
    private String f1100c;
    /* renamed from: d */
    private int f1101d;
    /* renamed from: e */
    private int f1102e;
    /* renamed from: f */
    private String f1103f;
    /* renamed from: g */
    private String f1104g;
    /* renamed from: h */
    private String f1105h;
    /* renamed from: i */
    private int f1106i = -1;
    /* renamed from: j */
    private int f1107j = -1;
    /* renamed from: k */
    private String f1108k;
    /* renamed from: l */
    private String f1109l;
    /* renamed from: m */
    private String f1110m;
    /* renamed from: n */
    private String f1111n;
    /* renamed from: o */
    private String f1112o;
    /* renamed from: p */
    private ArrayList<IXAdInstanceInfo> f1113p = new ArrayList();
    /* renamed from: q */
    private long f1114q;

    public C0438c(String str) {
        boolean z = true;
        this.f1112o = str;
        this.f1114q = System.currentTimeMillis();
        C0265a.f444c = str;
        JSONObject jSONObject = new JSONObject(str);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("ad");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        this.f1113p.add(new XAdInstanceInfo(jSONArray.getJSONObject(i)));
                    } catch (JSONException e) {
                    }
                }
            }
        } catch (Exception e2) {
            this.f1113p = new ArrayList();
        }
        this.f1098a = jSONObject.optInt(IXAdRequestInfo.AD_COUNT, 0);
        this.f1101d = jSONObject.optInt("x", 0);
        this.f1102e = jSONObject.optInt("y", 0);
        if (jSONObject.optInt("m", 0) != 1) {
            z = false;
        }
        this.f1099b = Boolean.valueOf(z);
        this.f1100c = jSONObject.optString("u", "");
        this.f1103f = jSONObject.optString("exp2", "{}");
        this.f1104g = jSONObject.optString("ext_act", "{}");
        this.f1106i = jSONObject.optInt("lunpan", -1);
        this.f1107j = jSONObject.optInt("intIcon", -1);
        this.f1108k = jSONObject.optString("ck", "");
        this.f1109l = jSONObject.optString("req_id");
        this.f1110m = jSONObject.optString("error_code", "");
        this.f1111n = jSONObject.optString("error_msg", "");
        try {
            this.f1105h = jSONObject.getString("theme");
        } catch (JSONException e3) {
        }
    }

    public ArrayList<IXAdInstanceInfo> getAdInstanceList() {
        return this.f1113p;
    }

    public int getAdsNum() {
        return this.f1098a;
    }

    public String getBaiduidOfCookie() {
        return this.f1108k;
    }

    public String getDefaultFillInThemeForStaticAds() {
        return this.f1105h;
    }

    public String getErrorCode() {
        return this.f1110m;
    }

    public String getErrorMessage() {
        return this.f1111n;
    }

    public String getExp2() {
        return this.f1103f;
    }

    public String getExtentionActionExp() {
        return this.f1104g;
    }

    public int getIntIcon() {
        return this.f1107j;
    }

    public int getLatitude() {
        return this.f1102e;
    }

    public int getLongitude() {
        return this.f1101d;
    }

    public int getLunpan() {
        return this.f1106i;
    }

    public Boolean getOpenPointModeForWall() {
        return this.f1099b;
    }

    public String getOriginResponseStr() {
        return this.f1112o;
    }

    public String getPointUnitForWall() {
        return this.f1100c;
    }

    public IXAdInstanceInfo getPrimaryAdInstanceInfo() {
        return this.f1113p.size() > 0 ? (IXAdInstanceInfo) this.f1113p.get(0) : null;
    }

    public String getRequestId() {
        return this.f1109l;
    }

    public long getTimeStamp() {
        return this.f1114q;
    }

    public void setAdInstanceList(ArrayList<IXAdInstanceInfo> arrayList) {
        this.f1113p = arrayList;
    }

    public void setAdsNum(int i) {
        this.f1098a = i;
    }

    public void setBaiduidOfCookie(String str) {
        this.f1108k = str;
    }

    public void setDefaultFillInThemeForStaticAds(String str) {
        this.f1105h = str;
    }

    public void setErrorCode(String str) {
        this.f1110m = str;
    }

    public void setErrorMessage(String str) {
        this.f1111n = str;
    }

    public void setExp2(String str) {
        this.f1103f = str;
    }

    public void setExtentionActionExp(String str) {
        this.f1104g = str;
    }

    public void setIntIcon(int i) {
        this.f1107j = i;
    }

    public void setLatitude(int i) {
        this.f1102e = i;
    }

    public void setLongitude(int i) {
        this.f1101d = i;
    }

    public void setLunpan(int i) {
        this.f1106i = i;
    }

    public void setOpenPointModeForWall(Boolean bool) {
        this.f1099b = bool;
    }

    public void setOriginResponseStr(String str) {
        this.f1112o = str;
    }

    public void setPointUnitForWall(String str) {
        this.f1100c = str;
    }

    public void setRequestId(String str) {
        this.f1109l = str;
    }
}
