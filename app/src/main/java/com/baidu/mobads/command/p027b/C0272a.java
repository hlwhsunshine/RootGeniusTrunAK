package com.baidu.mobads.command.p027b;

import com.baidu.mobads.command.C0269b;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.p021j.C0338m;

/* renamed from: com.baidu.mobads.command.b.a */
public class C0272a extends C0269b {
    /* renamed from: f */
    private String f490f = null;

    public C0272a(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource, String str) {
        super(iXNonLinearAdSlot, iXAdInstanceInfo, iXAdResource);
        this.f490f = str;
    }

    /* renamed from: a */
    public void mo4423a() {
        C0338m.m569a().mo5040m().browserOutside(this.f458a, this.f490f);
    }
}
