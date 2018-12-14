package com.baidu.mobads.production.p039a;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.p040vo.C0378d;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.a.c */
public class C0379c extends C0378d {
    public C0379c(Context context, Activity activity, SlotType slotType) {
        super(context, activity, slotType);
        this.f838b = "http://mobads.baidu.com/ads/index.htm";
    }

    /* renamed from: a */
    protected HashMap<String, String> mo5170a() {
        return new HashMap();
    }

    /* renamed from: b */
    public String mo5174b() {
        return "http://127.0.0.1";
    }
}
