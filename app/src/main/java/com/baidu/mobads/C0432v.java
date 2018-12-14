package com.baidu.mobads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.CpuInfoManager.UrlListener;
import com.baidu.mobads.production.p043c.C0385b;

/* renamed from: com.baidu.mobads.v */
final class C0432v implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f987a;
    /* renamed from: b */
    final /* synthetic */ int f988b;
    /* renamed from: c */
    final /* synthetic */ String f989c;
    /* renamed from: d */
    final /* synthetic */ UrlListener f990d;

    C0432v(Context context, int i, String str, UrlListener urlListener) {
        this.f987a = context;
        this.f988b = i;
        this.f989c = str;
        this.f990d = urlListener;
    }

    public final void run() {
        String a = new C0385b(this.f987a.getApplicationContext(), this.f988b, this.f989c).mo5199a();
        if (this.f990d != null) {
            new Handler(Looper.getMainLooper()).post(new C0439w(this, a));
        }
    }
}
