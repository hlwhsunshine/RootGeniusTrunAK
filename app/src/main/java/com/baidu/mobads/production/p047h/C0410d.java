package com.baidu.mobads.production.p047h;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.p040vo.C0378d;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.h.d */
public class C0410d extends C0378d {
    public C0410d(Context context, SlotType slotType) {
        super(context, null, slotType);
        this.f838b = "http://mobads.baidu.com/cpro/ui/mads.php";
    }

    /* renamed from: a */
    protected HashMap<String, String> mo5170a() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put(IXAdRequestInfo.FET, "ANTI,HTML,MSSP");
        return hashMap;
    }

    /* renamed from: b */
    public String mo5174b() {
        return super.mo5174b();
    }
}
