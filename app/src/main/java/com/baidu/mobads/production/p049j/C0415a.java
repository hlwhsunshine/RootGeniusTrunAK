package com.baidu.mobads.production.p049j;

import android.content.Context;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.production.p042d.C0381a;
import com.baidu.mobads.production.p048i.C0412a;

/* renamed from: com.baidu.mobads.production.j.a */
public class C0415a extends C0381a {
    /* renamed from: x */
    private C0412a f942x;

    public C0415a(Context context, String str) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(null);
        this.f825p = SlotType.SLOT_TYPE_PREROLL;
        this.f942x = new C0412a(getApplicationContext(), getActivity(), SlotType.SLOT_TYPE_PREROLL, this);
        this.f942x.mo5177c(AdSize.PrerollVideoNative.getValue());
        this.f942x.mo5181d(str);
    }

    /* renamed from: a */
    public void mo5190a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.f942x.mo5171a(width);
            this.f942x.mo5175b(height);
        }
    }

    public void request() {
        super.mo5149a(this.f942x);
    }
}
