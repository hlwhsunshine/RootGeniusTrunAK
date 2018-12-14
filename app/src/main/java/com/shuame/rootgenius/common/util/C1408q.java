package com.shuame.rootgenius.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.shuame.rootgenius.common.util.NetworkUtils.NetworkType;

/* renamed from: com.shuame.rootgenius.common.util.q */
public final class C1408q {
    /* renamed from: a */
    private NetworkType f3892a = NetworkUtils.m3853c();
    /* renamed from: b */
    private C1407a f3893b;
    /* renamed from: c */
    private BroadcastReceiver f3894c = new C1409r(this);

    /* renamed from: com.shuame.rootgenius.common.util.q$a */
    public interface C1407a {
        /* renamed from: a */
        void mo7126a();

        /* renamed from: b */
        void mo7127b();

        /* renamed from: c */
        void mo7128c();

        /* renamed from: d */
        void mo7129d();

        /* renamed from: e */
        void mo7130e();

        /* renamed from: f */
        void mo7131f();
    }

    public C1408q(C1407a c1407a) {
        this.f3893b = c1407a;
    }

    /* renamed from: a */
    public final void mo7132a(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(this.f3894c, intentFilter);
    }
}
