package com.baidu.mobads.p034h;

import android.os.Build;
import android.os.Build.VERSION;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.openad.p037e.C0368a;
import com.baidu.mobads.openad.p037e.C0371d;
import com.baidu.mobads.p021j.C0338m;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.h.l */
class C0313l implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0312k f585a;

    C0313l(C0312k c0312k) {
        this.f585a = c0312k;
    }

    public void run() {
        try {
            IXAdURIUitls i = C0338m.m569a().mo5036i();
            double d = this.f585a.f583a ? C0307g.f569b.f537a : 0.0d;
            IOAdEventListener c0314m = new C0314m(this, d);
            HashMap hashMap = new HashMap();
            hashMap.put(IXAdRequestInfo.f650V, String.valueOf(d));
            hashMap.put(IXAdRequestInfo.f648OS, "android");
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, C0338m.m569a().mo5040m().getTextEncoder(Build.MODEL));
            hashMap.put(IXAdRequestInfo.BDR, C0338m.m569a().mo5040m().getTextEncoder(VERSION.SDK));
            C0371d c0371d = new C0371d(i.addParameters(C0307g.f572h, hashMap), "");
            c0371d.f798e = 1;
            this.f585a.f584b.f576i = new C0368a();
            this.f585a.f584b.f576i.addEventListener("URLLoader.Load.Complete", c0314m);
            this.f585a.f584b.f576i.addEventListener("URLLoader.Load.Error", c0314m);
            this.f585a.f584b.f576i.mo5116a(c0371d);
        } catch (Exception e) {
        }
    }
}
