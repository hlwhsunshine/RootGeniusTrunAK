package com.baidu.mobads.production.p042d;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.p040vo.C0378d;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.d.b */
public class C0387b extends C0378d {
    public C0387b(Context context, Activity activity, SlotType slotType) {
        super(context, activity, slotType);
        this.f838b = "http://mobads.baidu.com/cpro/ui/mads.php";
        mo5172a("androidfeed");
    }

    /* renamed from: a */
    protected HashMap<String, String> mo5170a() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
        return hashMap;
    }

    /* renamed from: b */
    public String mo5174b() {
        return super.mo5174b();
    }
}
