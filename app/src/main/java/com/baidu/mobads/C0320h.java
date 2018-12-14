package com.baidu.mobads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.p037e.C0368a;
import com.baidu.mobads.openad.p037e.C0371d;
import com.baidu.mobads.p021j.C0338m;

/* renamed from: com.baidu.mobads.h */
class C0320h extends Handler {
    /* renamed from: a */
    final /* synthetic */ AppActivity f604a;

    C0320h(AppActivity appActivity, Looper looper) {
        this.f604a = appActivity;
        super(looper);
    }

    public void handleMessage(Message message) {
        C0338m.m569a().mo5040m();
        IXAdURIUitls i = C0338m.m569a().mo5036i();
        StringBuilder stringBuilder = new StringBuilder("type=" + message.what + "&");
        String str = "";
        if (message.what == AppActivity.f155G) {
            str = this.f604a.f159A.toString();
        }
        try {
            C0371d c0371d = new C0371d(i.addParameters("http://mobads-logs.baidu.com/dz.zb?" + stringBuilder.append(str).toString(), null), "");
            c0371d.f798e = 1;
            new C0368a().mo5116a(c0371d);
        } catch (Exception e) {
            this.f604a.f162D.mo4922d(AppActivity.f157o, e.getMessage());
        }
    }
}
