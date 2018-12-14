package com.tencent.mid.p116a;

import android.content.Context;
import com.tencent.mid.api.MidCallback;
import com.tencent.mid.api.MidConstants;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.p117b.C1643a;
import com.tencent.mid.p117b.C1649g;
import com.tencent.mid.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.tencent.mid.a.h */
public class C1638h implements Runnable {
    /* renamed from: d */
    private static AtomicBoolean f4670d = new AtomicBoolean(true);
    /* renamed from: a */
    private Context f4671a = null;
    /* renamed from: b */
    private MidCallback f4672b = null;
    /* renamed from: c */
    private int f4673c = 0;

    public C1638h(Context context, int i, MidCallback midCallback) {
        this.f4671a = context;
        this.f4673c = i;
        this.f4672b = midCallback;
    }

    /* renamed from: a */
    private void m4479a() {
        MidEntity a = C1649g.m4537a(this.f4671a).mo7661a(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1)})));
        MidEntity a2 = C1649g.m4537a(this.f4671a).mo7661a(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(2)})));
        MidEntity a3 = C1649g.m4537a(this.f4671a).mo7661a(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(4)})));
        if (Util.equal(a, a2) && Util.equal(a, a3)) {
            Util.logInfo("local mid check passed.");
            return;
        }
        a = Util.getNewerMidEntity(Util.getNewerMidEntity(a, a2), Util.getNewerMidEntity(a, a3));
        Util.logInfo("local mid check failed, redress with mid:" + a.toString());
        a.setForceWrite(true);
        C1649g.m4537a(this.f4671a).mo7663a(a);
    }

    /* renamed from: b */
    private void m4480b() {
        C1634d.m4468a(this.f4671a).mo7612a(new C1637g(this.f4671a), new C1639i(this));
    }

    /* renamed from: c */
    private void m4481c() {
        C1643a b = C1649g.m4537a(this.f4671a).mo7665b();
        if (b == null) {
            Util.logInfo("CheckEntity is null");
            return;
        }
        int c = b.mo7641c() + 1;
        long abs = Math.abs(System.currentTimeMillis() - b.mo7639b());
        Util.logInfo("check entity: " + b.toString() + ",duration:" + abs);
        if ((c <= b.mo7643d() || abs <= C1631a.f4656a) && abs <= ((long) b.mo7636a()) * C1631a.f4656a) {
            b.mo7640b(c);
            C1649g.m4537a(this.f4671a).mo7664a(b);
        } else {
            m4479a();
            if (Util.isNetworkAvailable(this.f4671a)) {
                m4480b();
            }
        }
        if (f4670d.get()) {
            m4479a();
            f4670d.set(false);
        }
    }

    public void run() {
        Util.logInfo("request type:" + this.f4673c);
        switch (this.f4673c) {
            case 1:
                if (Util.isNetworkAvailable(this.f4671a)) {
                    C1634d.m4468a(this.f4671a).mo7612a(new C1637g(this.f4671a), this.f4672b);
                    return;
                } else {
                    this.f4672b.onFail(MidConstants.ERROR_NETWORK, "network not available.");
                    return;
                }
            case 2:
                m4481c();
                return;
            default:
                Util.logInfo("wrong type:" + this.f4673c);
                return;
        }
    }
}
