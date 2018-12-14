package com.tencent.mid.api;

import com.tencent.mid.util.Util;

/* renamed from: com.tencent.mid.api.b */
final class C1641b implements MidCallback {
    C1641b() {
    }

    public final void onFail(int i, String str) {
        new StringBuilder("failed to get mid, errorcode:").append(i).append(" ,msg:").append(str);
    }

    public final void onSuccess(Object obj) {
        if (obj != null) {
            Util.logInfo("success to get mid:" + MidEntity.parse(obj.toString()).getMid());
        }
    }
}
