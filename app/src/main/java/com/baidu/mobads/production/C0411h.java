package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.download.activate.IXActivateListener;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.p025c.C0265a;

/* renamed from: com.baidu.mobads.production.h */
class C0411h implements IXActivateListener {
    /* renamed from: a */
    final /* synthetic */ C0406g f938a;

    C0411h(C0406g c0406g) {
        this.f938a = c0406g;
    }

    public void onAppActivation(IXAppInfo iXAppInfo) {
        C0265a.m334a().mo4395a(this.f938a.f932a.f919a, iXAppInfo);
    }
}
