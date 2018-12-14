package com.baidu.mobads.production;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;

/* renamed from: com.baidu.mobads.production.k */
class C0417k extends Handler {
    /* renamed from: a */
    final /* synthetic */ IXAdInstanceInfo f944a;
    /* renamed from: b */
    final /* synthetic */ C0375a f945b;

    C0417k(C0375a c0375a, Looper looper, IXAdInstanceInfo iXAdInstanceInfo) {
        this.f945b = c0375a;
        this.f944a = iXAdInstanceInfo;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message.getData().getBoolean("caching_result")) {
            this.f944a.setLocalCreativeURL(message.getData().getString("local_creative_url"));
        } else {
            this.f944a.setLocalCreativeURL(null);
        }
    }
}
