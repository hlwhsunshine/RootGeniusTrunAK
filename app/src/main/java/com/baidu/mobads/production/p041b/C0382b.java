package com.baidu.mobads.production.p041b;

import android.content.Context;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.production.p042d.C0381a;

/* renamed from: com.baidu.mobads.production.b.b */
public class C0382b extends C0381a {
    /* renamed from: x */
    private C0380a f862x;

    public C0382b(Context context, String str) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(null);
        this.f825p = SlotType.SLOT_TYPE_VERLINK;
        this.f862x = new C0380a(getApplicationContext(), getActivity(), this.f825p);
        this.f862x.mo5181d(str);
    }

    /* renamed from: a */
    public void mo5190a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.f862x.mo5171a(width);
            this.f862x.mo5175b(height);
        }
    }

    public void request() {
        super.mo5149a(this.f862x);
    }
}
