package com.shuame.rootgenius.common.manager.p104a;

import android.content.Context;
import android.content.Intent;
import com.shuame.rootgenius.common.manager.p104a.C1354c.C1352a;
import com.tencent.p105mm.opensdk.modelbase.BaseReq;
import com.tencent.p105mm.opensdk.modelbiz.WXLaunchMiniProgram.Req;
import com.tencent.p105mm.opensdk.openapi.IWXAPI;
import com.tencent.p105mm.opensdk.openapi.WXAPIFactory;

/* renamed from: com.shuame.rootgenius.common.manager.a.a */
public class C1350a {
    /* renamed from: a */
    private static final String f3699a = C1350a.class.getSimpleName();
    /* renamed from: b */
    private C1352a f3700b;
    /* renamed from: c */
    private IWXAPI f3701c;

    public C1350a(Context context, C1352a c1352a) {
        this.f3701c = WXAPIFactory.createWXAPI(context, "wxd97f288ed67b01b9", true);
        this.f3701c.registerApp("wxd97f288ed67b01b9");
        this.f3700b = c1352a;
    }

    /* renamed from: a */
    public final void mo7034a() {
        this.f3700b = null;
        if (this.f3701c != null) {
            this.f3701c.detach();
            this.f3701c = null;
        }
    }

    /* renamed from: a */
    public final void mo7035a(Intent intent) {
        this.f3701c.handleIntent(intent, new C1351b(this));
    }

    /* renamed from: a */
    public final void mo7036a(String str, String str2) {
        BaseReq req = new Req();
        req.userName = str;
        req.path = str2;
        req.miniprogramType = 0;
        if (this.f3701c.sendReq(req)) {
            this.f3700b.onSuccess();
        } else {
            this.f3700b.onFailed(-1);
        }
    }

    /* renamed from: b */
    final boolean mo7037b() {
        return this.f3701c != null && this.f3701c.isWXAppInstalled();
    }
}
