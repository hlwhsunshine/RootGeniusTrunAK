package com.baidu.mobads.production.p048i;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.p040vo.C0378d;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.i.a */
public class C0412a extends C0378d {
    /* renamed from: a */
    protected IXAdProd f939a;

    public C0412a(Context context, Activity activity, SlotType slotType, IXAdProd iXAdProd) {
        super(context, activity, slotType);
        this.f838b = "http://mobads.baidu.com/cpro/ui/mads.php";
        this.f939a = iXAdProd;
    }

    /* renamed from: a */
    protected HashMap<String, String> mo5170a() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("slottype", this.f842f.getValue());
        hashMap.put("mimetype", "video/mp4,image/jpg,image/gif,image/png");
        hashMap.put("prod", "video");
        hashMap.put(IXAdRequestInfo.FET, "ANTI,HTML,MSSP,VIDEO,NMON");
        hashMap.put(IXAdRequestInfo.AD_TYPE, "10");
        hashMap.put(IXAdRequestInfo.AD_COUNT, "1");
        if (this.f939a.getProdBase() == null && getApt() != AdSize.PrerollVideoNative.getValue()) {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, "640");
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, "480");
        }
        return hashMap;
    }

    /* renamed from: b */
    public String mo5174b() {
        return super.mo5174b();
    }
}
