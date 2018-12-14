package com.baidu.mobads.production;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.baidu.mobads.production.q */
class C0423q extends TimerTask {
    /* renamed from: a */
    final /* synthetic */ IXAdPackageUtils f969a;
    /* renamed from: b */
    final /* synthetic */ Context f970b;
    /* renamed from: c */
    final /* synthetic */ String f971c;
    /* renamed from: d */
    final /* synthetic */ Timer f972d;
    /* renamed from: e */
    final /* synthetic */ C0421o f973e;

    C0423q(C0421o c0421o, IXAdPackageUtils iXAdPackageUtils, Context context, String str, Timer timer) {
        this.f973e = c0421o;
        this.f969a = iXAdPackageUtils;
        this.f970b = context;
        this.f971c = str;
        this.f972d = timer;
    }

    public void run() {
        if (this.f973e.f960j >= this.f973e.f961k) {
            if (this.f973e.f960j >= this.f973e.f962l) {
                this.f972d.cancel();
                this.f969a.sendDialerIsSuccess(this.f970b, true, 0, this.f971c);
            } else if (!this.f969a.isForeground(this.f970b, this.f971c) && this.f969a.isForeground(this.f970b, this.f970b.getPackageName())) {
                this.f972d.cancel();
                this.f969a.sendDialerIsSuccess(this.f970b, false, this.f973e.f960j, this.f971c);
            }
        }
        this.f973e.f960j = this.f973e.f960j + 1;
    }
}
