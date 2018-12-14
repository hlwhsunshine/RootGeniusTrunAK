package com.baidu.mobads.production.p045g;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.p040vo.C0378d;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.g.d */
public class C0405d extends C0378d {
    /* renamed from: a */
    private Boolean f931a;

    public C0405d(Context context, Activity activity, SlotType slotType, Boolean bool) {
        super(context, activity, slotType);
        this.f931a = bool;
        if (mo5229c().booleanValue()) {
            this.f838b = "http://mobads.baidu.com/ads/index.htm";
        }
    }

    /* renamed from: a */
    protected HashMap<String, String> mo5170a() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("xyz", "hihihi");
        return hashMap;
    }

    /* renamed from: b */
    public String mo5174b() {
        return mo5229c().booleanValue() ? super.mo5174b() : "http://211.151.146.65:8080/wlantest/shanghai_sun/mock_ad_server_intersitial_video.json";
    }

    /* renamed from: c */
    public Boolean mo5229c() {
        return this.f931a;
    }
}
