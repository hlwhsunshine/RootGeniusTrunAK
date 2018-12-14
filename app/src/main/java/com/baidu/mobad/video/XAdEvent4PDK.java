package com.baidu.mobad.video;

import com.baidu.mobads.interfaces.IXAdEvent4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.openad.p020d.C0232b;
import java.util.HashMap;

public class XAdEvent4PDK extends C0232b implements IXAdEvent4PDK {
    /* renamed from: a */
    private IXAdProd f273a;

    public XAdEvent4PDK(String str, int i, IXAdProd iXAdProd) {
        super(str, i);
        this.f273a = iXAdProd;
    }

    public XAdEvent4PDK(String str, int i, String str2, IXAdProd iXAdProd) {
        super(str, i, str2);
        this.f273a = iXAdProd;
    }

    public XAdEvent4PDK(String str, int i, HashMap<String, Object> hashMap, IXAdProd iXAdProd) {
        super(str, i, (HashMap) hashMap);
        this.f273a = iXAdProd;
    }

    public XAdEvent4PDK(String str, IXAdProd iXAdProd) {
        super(str);
        this.f273a = iXAdProd;
    }

    public XAdEvent4PDK(String str, String str2, IXAdProd iXAdProd) {
        super(str, str2);
        this.f273a = iXAdProd;
    }

    public XAdEvent4PDK(String str, HashMap<String, Object> hashMap, IXAdProd iXAdProd) {
        super(str, (HashMap) hashMap);
        this.f273a = iXAdProd;
    }

    public IXAdProd getAdSlot() {
        return this.f273a;
    }
}
