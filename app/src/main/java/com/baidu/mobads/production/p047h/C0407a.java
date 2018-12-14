package com.baidu.mobads.production.p047h;

import android.content.Context;
import android.os.Handler;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.p037e.C0371d;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p040vo.C0378d;
import com.baidu.mobads.production.C0375a;
import com.baidu.mobads.production.C0426t;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.h.a */
public class C0407a extends C0375a {
    /* renamed from: w */
    protected final IXAdLogger f933w = C0338m.m569a().mo5033f();
    /* renamed from: x */
    private C0410d f934x;
    /* renamed from: y */
    private Context f935y;

    public C0407a(Context context, RelativeLayout relativeLayout, String str, boolean z, int i, int i2) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.f825p = SlotType.SLOT_TYPE_SPLASH;
        this.f935y = context;
        this.f934x = new C0410d(getApplicationContext(), this.f825p);
        this.f934x.mo5173a(z);
        IXAdConstants p = C0338m.m569a().mo5043p();
        this.f934x.mo5176b(z ? p.getSupportedActionType4RequestingNone() + "," + p.getSupportedActionType4RequestingLandingPage() + "," + p.getSupportedActionType4RequestingDownload() + "," + p.getSupportedActionType4RequestingAPO() : p.getSupportedActionType4RequestingNone());
        this.f934x.mo5171a(i);
        this.f934x.mo5175b(i2);
        this.f934x.mo5183e(0);
        this.f934x.mo5181d(str);
        this.f934x.mo5177c(8);
        this.f934x.mo5180d(1);
        this.f934x.mo5185f(p.getAdCreativeTypeImage());
        mo5156c(str);
    }

    /* renamed from: a */
    protected void mo5145a(C0371d c0371d, C0426t c0426t, int i) {
        c0426t.mo5117a(c0371d, (double) i);
    }

    /* renamed from: c */
    public void mo5154c() {
        if (this.f817h != null) {
            this.f817h.load();
        } else {
            this.f933w.mo4926e("container is null");
        }
    }

    /* renamed from: c */
    protected void mo5155c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        start();
        Handler handler = new Handler(this.f935y.getMainLooper());
        handler.post(new C0408b(this));
        handler.postDelayed(new C0409c(this), 5000);
    }

    /* renamed from: d */
    protected void mo5157d() {
        this.f823n = 4200;
    }

    /* renamed from: d */
    protected void mo5158d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    /* renamed from: m */
    public C0378d getAdRequestInfo() {
        return this.f934x;
    }

    public void request() {
        mo5164i();
        mo5149a(this.f934x);
    }
}
