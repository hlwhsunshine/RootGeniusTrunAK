package com.shuame.p075ad;

import com.baidu.mobads.AdView;
import com.baidu.mobads.AdViewListener;
import org.json.JSONObject;

/* renamed from: com.shuame.ad.m */
final class C1110m implements AdViewListener {
    /* renamed from: a */
    final /* synthetic */ C1108k f2982a;

    C1110m(C1108k c1108k) {
        this.f2982a = c1108k;
    }

    public final void onAdClick(JSONObject jSONObject) {
        C1108k.f2976f;
        new StringBuilder("onAdClick ").append(C1108k.m3230a(jSONObject));
        if (this.f2982a.f2966a != null) {
            this.f2982a.f2966a.mo6684b(this.f2982a);
        }
    }

    public final void onAdClose(JSONObject jSONObject) {
        C1108k.f2976f;
        new StringBuilder("onAdClose ").append(C1108k.m3230a(jSONObject));
    }

    public final void onAdFailed(String str) {
        C1108k.f2976f;
        if (this.f2982a.f2966a != null) {
            this.f2982a.f2966a.mo6683a(this.f2982a, str);
        }
    }

    public final void onAdReady(AdView adView) {
        C1108k.f2976f;
        new StringBuilder("onAdReady ").append(adView);
    }

    public final void onAdShow(JSONObject jSONObject) {
        new StringBuilder("onAdShow ").append(C1108k.m3230a(jSONObject));
        if (this.f2982a.f2966a != null) {
            this.f2982a.f2966a.mo6682a(this.f2982a);
        }
    }

    public final void onAdSwitch() {
        C1108k.f2976f;
    }
}
