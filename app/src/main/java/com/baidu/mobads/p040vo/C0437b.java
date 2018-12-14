package com.baidu.mobads.p040vo;

import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.vo.b */
public class C0437b implements IXAdProdInfo {
    /* renamed from: a */
    private C0378d f1094a;
    /* renamed from: b */
    private SlotType f1095b;
    /* renamed from: c */
    private JSONObject f1096c;
    /* renamed from: d */
    private boolean f1097d = false;

    public C0437b(C0378d c0378d, SlotType slotType) {
        this.f1094a = c0378d;
        this.f1095b = slotType;
    }

    /* renamed from: a */
    public void mo5270a(JSONObject jSONObject) {
        this.f1096c = jSONObject;
    }

    /* renamed from: a */
    public void mo5271a(boolean z) {
        this.f1097d = z;
    }

    public String getAdPlacementId() {
        return this.f1094a.getApid();
    }

    public String getAdRequestURL() {
        return this.f1094a.mo5174b();
    }

    public int getApt() {
        return this.f1094a.getApt();
    }

    public JSONObject getAttribute() {
        return this.f1096c != null ? this.f1096c : new JSONObject();
    }

    public int getInstanceCount() {
        return 0;
    }

    public String getProdType() {
        return this.f1094a.getProd();
    }

    public int getRequestAdHeight() {
        return this.f1094a.getH();
    }

    public int getRequestAdWidth() {
        return this.f1094a.getW();
    }

    public SlotType getType() {
        return this.f1095b;
    }

    public boolean isAutoPlay() {
        return this.f1097d;
    }

    public boolean isMsspTagAvailable() {
        return false;
    }
}
