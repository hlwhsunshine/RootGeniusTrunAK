package com.tencent.mid.p116a;

import com.tencent.mid.api.MidCallback;
import com.tencent.mid.util.Util;

/* renamed from: com.tencent.mid.a.i */
class C1639i implements MidCallback {
    /* renamed from: a */
    final /* synthetic */ C1638h f4674a;

    C1639i(C1638h c1638h) {
        this.f4674a = c1638h;
    }

    public void onFail(int i, String str) {
        Util.logInfo("checkServer failed, errCode:" + i + ",msg:" + str);
    }

    public void onSuccess(Object obj) {
        Util.logInfo("checkServer success:" + obj);
    }
}
