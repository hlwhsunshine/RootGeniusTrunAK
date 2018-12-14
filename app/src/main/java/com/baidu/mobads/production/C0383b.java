package com.baidu.mobads.production;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.openad.p020d.C0232b;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p025c.C0265a;
import com.baidu.mobads.p040vo.C0438c;
import org.json.JSONException;

/* renamed from: com.baidu.mobads.production.b */
class C0383b implements IOAdEventListener {
    /* renamed from: a */
    final /* synthetic */ C0375a f863a;

    C0383b(C0375a c0375a) {
        this.f863a = c0375a;
    }

    public void run(IOAdEvent iOAdEvent) {
        String str;
        this.f863a.mo5162g();
        if ("URLLoader.Load.Complete".equals(iOAdEvent.getType())) {
            try {
                this.f863a.setAdResponseInfo(new C0438c((String) iOAdEvent.getData().get(C0232b.EVENT_MESSAGE)));
                if (this.f863a.getAdResponseInfo().getAdInstanceList().size() > 0) {
                    this.f863a.f812b = Boolean.valueOf(true);
                    this.f863a.mo5146a("XAdMouldeLoader ad-server requesting success");
                    return;
                }
                C0338m.m569a().mo5044q().printErrorMessage(this.f863a.getAdResponseInfo().getErrorCode(), this.f863a.getAdResponseInfo().getErrorMessage(), "");
                this.f863a.mo5153b(this.f863a.getAdResponseInfo().getErrorMessage());
                return;
            } catch (JSONException e) {
                str = "response json parsing error";
                C0338m.m569a().mo5044q().printErrorMessage("", str, "");
                this.f863a.mo5153b(str);
                C0265a.m334a().mo4397a(str);
                return;
            }
        }
        str = "request ad-server error, io_err/timeout";
        C0338m.m569a().mo5044q().printErrorMessage("", str, "");
        this.f863a.mo5153b(str);
        C0265a.m334a().mo4397a(str);
    }
}
