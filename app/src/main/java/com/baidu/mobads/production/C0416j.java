package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.p021j.C0336j;
import com.baidu.mobads.p025c.C0265a;
import com.baidu.mobads.p032f.C0280a;
import com.baidu.mobads.p034h.C0307g.C0306c;

/* renamed from: com.baidu.mobads.production.j */
class C0416j implements C0306c {
    /* renamed from: a */
    final /* synthetic */ C0375a f943a;

    C0416j(C0375a c0375a) {
        this.f943a = c0375a;
    }

    /* renamed from: a */
    public void mo4502a(boolean z) {
        if (z) {
            try {
                if (BaiduXAdSDKContext.mApkLoader != null) {
                    C0375a.f810a = BaiduXAdSDKContext.mApkLoader.mo4512g();
                    BaiduXAdSDKContext.isRemoteLoadSuccess = Boolean.valueOf(true);
                    this.f943a.mo5146a("XAdMouldeLoader load success");
                    return;
                }
            } catch (Throwable e) {
                C0336j.m550a().mo4928e(e);
                C0265a.m334a().mo4397a("async apk on load exception: " + e.toString());
                return;
            }
        }
        BaiduXAdSDKContext.mApkLoader = null;
        this.f943a.dispatchEvent(new C0280a(IXAdEvent.AD_ERROR));
    }
}
