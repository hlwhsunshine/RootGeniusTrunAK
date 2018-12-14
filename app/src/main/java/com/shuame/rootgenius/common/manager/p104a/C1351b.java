package com.shuame.rootgenius.common.manager.p104a;

import com.tencent.p105mm.opensdk.modelbase.BaseReq;
import com.tencent.p105mm.opensdk.modelbase.BaseResp;
import com.tencent.p105mm.opensdk.openapi.IWXAPIEventHandler;

/* renamed from: com.shuame.rootgenius.common.manager.a.b */
final class C1351b implements IWXAPIEventHandler {
    /* renamed from: a */
    final /* synthetic */ C1350a f3702a;

    C1351b(C1350a c1350a) {
        this.f3702a = c1350a;
    }

    public final void onReq(BaseReq baseReq) {
    }

    public final void onResp(BaseResp baseResp) {
        C1350a.f3699a;
        new StringBuilder("handle result err code = ").append(baseResp.errCode).append(" , msg = ").append(baseResp.errStr);
        if (baseResp.getType() == 19) {
            C1350a.f3699a;
        }
    }
}
