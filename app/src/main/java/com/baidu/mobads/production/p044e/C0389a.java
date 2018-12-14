package com.baidu.mobads.production.p044e;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.p040vo.C0378d;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.e.a */
public class C0389a extends C0378d {
    public C0389a(Context context) {
        super(context, null, SlotType.SLOT_TYPE_FRONTLINK);
        this.f838b = "http://mobads.baidu.com/cpro/ui/mads.php";
        mo5176b(this.f844h.getSupportedActionType4RequestingLandingPage());
        mo5185f(this.f844h.getAdCreativeTypeImage() + this.f844h.getAdCreativeTypeText());
        mo5180d(1);
    }

    /* renamed from: a */
    protected HashMap<String, String> mo5170a() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put(IXAdRequestInfo.FET, "LU,ANTI,HTML,MSSP");
        return hashMap;
    }

    /* renamed from: b */
    public String mo5174b() {
        return super.mo5174b();
    }
}
