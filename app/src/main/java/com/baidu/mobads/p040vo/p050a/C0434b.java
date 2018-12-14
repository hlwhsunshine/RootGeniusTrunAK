package com.baidu.mobads.p040vo.p050a;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.p021j.C0338m;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.vo.a.b */
public class C0434b extends C0433a {
    /* renamed from: n */
    public boolean f1070n = true;
    /* renamed from: o */
    private Context f1071o;
    /* renamed from: p */
    private IXAppInfo f1072p;

    public C0434b(Context context, IXAppInfo iXAppInfo) {
        super(iXAppInfo.getAdId(), iXAppInfo.getQk(), iXAppInfo.getProd());
        this.f1071o = context;
        this.f1072p = iXAppInfo;
    }

    /* renamed from: b */
    protected HashMap<String, String> mo5263b() {
        String str = C0338m.m569a().mo5041n().getCurrentProcessId(this.f1071o);
        HashMap<String, String> hashMap = new HashMap();
        try {
            hashMap.put("autoOpen", this.f1070n ? "true" : "false");
            hashMap.put(IXAdRequestInfo.PACKAGE, this.f1072p.getPackageName());
            hashMap.put("c", "0");
            hashMap.put("clickProcId", str);
            hashMap.put("clickTime", this.f1072p.getClickTime());
            hashMap.put("contentLength", this.f1072p.getAppSize());
            hashMap.put("dlCnt", "1");
            hashMap.put("dlTime", String.valueOf(System.currentTimeMillis() - this.f1072p.getClickTime()));
            hashMap.put("dlTunnel", "3");
            hashMap.put("dlWay", this.f1072p.isTooLarge() ? "1" : "0");
            hashMap.put("exp_id", "");
            hashMap.put("exp2", "");
            hashMap.put("pkg", this.f1072p.getPackageName());
            hashMap.put("typeProcId", str);
            hashMap.put("url2", "");
            hashMap.put(IXAdRequestInfo.f649SN, C0338m.m569a().mo5032e().encode(C0338m.m569a().mo5041n().getDeviceId(this.f1071o)));
        } catch (Throwable e) {
            C0338m.m569a().mo5033f().mo4924d(e);
        }
        return hashMap;
    }
}
