package com.baidu.mobads.production.p046f;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.p040vo.C0378d;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.f.f */
public class C0401f extends C0378d {
    /* renamed from: a */
    private Boolean f918a;

    public C0401f(Context context, Activity activity, SlotType slotType, Boolean bool) {
        super(context, activity, slotType);
        this.f918a = bool;
        if (mo5224c().booleanValue()) {
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
        return mo5224c().booleanValue() ? super.mo5174b() : "http://211.151.146.65:8080/wlantest/shanghai_sun/mock_ad_server_intersitial_video.json";
    }

    /* renamed from: c */
    public Boolean mo5224c() {
        return this.f918a;
    }
}
