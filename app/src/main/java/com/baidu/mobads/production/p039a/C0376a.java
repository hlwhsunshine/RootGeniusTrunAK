package com.baidu.mobads.production.p039a;

import android.content.Context;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.p037e.C0371d;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p032f.C0280a;
import com.baidu.mobads.p040vo.C0378d;
import com.baidu.mobads.p040vo.C0437b;
import com.baidu.mobads.p040vo.C0438c;
import com.baidu.mobads.production.C0375a;
import com.baidu.mobads.production.C0426t;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.production.a.a */
public class C0376a extends C0375a implements IXNonLinearAdSlot {
    /* renamed from: w */
    private C0379c f835w;

    public C0376a(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.f825p = SlotType.SLOT_TYPE_BANNER;
        C0338m.m569a().mo5043p();
        this.f835w = new C0379c(getApplicationContext(), getActivity(), this.f825p);
        this.f835w.mo5177c(AdSize.Banner.getValue());
        this.f835w.mo5181d(str);
        C0437b c0437b = (C0437b) this.f835w.mo5179d();
        c0437b.mo5271a(z);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ABILITY", "BANNER_CLOSE,");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c0437b.mo5270a(jSONObject);
        mo5156c(str);
    }

    /* renamed from: a */
    protected void mo5137a() {
        new Thread(new C0377b(this)).start();
    }

    /* renamed from: a */
    protected void mo5145a(C0371d c0371d, C0426t c0426t, int i) {
        String str = "{'ad':[{'id':99999999,'url':'" + this.f835w.mo5174b() + "', type='" + CreativeType.HTML.getValue() + "'}],'n':1}";
        this.f812b = Boolean.valueOf(true);
        try {
            setAdResponseInfo(new C0438c(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mo5146a("XAdMouldeLoader ad-server requesting success");
    }

    /* renamed from: b */
    protected void mo5152b(C0378d c0378d) {
        this.f821l = c0378d;
        mo5162g();
        mo5145a(null, null, 5000);
    }

    /* renamed from: c */
    public void mo5154c() {
        load();
    }

    /* renamed from: c */
    protected void mo5155c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        start();
    }

    /* renamed from: d */
    protected void mo5157d() {
        this.f823n = 10000;
    }

    /* renamed from: d */
    protected void mo5158d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    /* renamed from: e */
    protected void mo5160e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        super.mo5167l();
        dispatchEvent(new C0280a(IXAdEvent.AD_USER_CLOSE));
    }

    /* renamed from: m */
    public C0378d getAdRequestInfo() {
        return this.f835w;
    }

    public void request() {
        mo5149a(this.f835w);
        try {
            WebView webView = new WebView(getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
