package com.tencent.mid.api;

import com.tencent.mid.util.Util;

/* renamed from: com.tencent.mid.api.a */
final class C1640a implements MidCallback {
    /* renamed from: a */
    final /* synthetic */ MidCallback f4685a;

    C1640a(MidCallback midCallback) {
        this.f4685a = midCallback;
    }

    public final void onFail(int i, String str) {
        new StringBuilder("failed to get mid, errorcode:").append(i).append(" ,msg:").append(str);
        this.f4685a.onFail(i, str);
    }

    public final void onSuccess(Object obj) {
        if (obj != null) {
            MidEntity parse = MidEntity.parse(obj.toString());
            Util.logInfo("success to get mid:" + parse.getMid());
            this.f4685a.onSuccess(parse.getMid());
        }
    }
}
