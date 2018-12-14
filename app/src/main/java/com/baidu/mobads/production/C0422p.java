package com.baidu.mobads.production;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.baidu.mobads.production.p */
class C0422p extends TimerTask {
    /* renamed from: a */
    final /* synthetic */ IXAdPackageUtils f963a;
    /* renamed from: b */
    final /* synthetic */ Context f964b;
    /* renamed from: c */
    final /* synthetic */ String f965c;
    /* renamed from: d */
    final /* synthetic */ Timer f966d;
    /* renamed from: e */
    final /* synthetic */ String f967e;
    /* renamed from: f */
    final /* synthetic */ C0421o f968f;

    C0422p(C0421o c0421o, IXAdPackageUtils iXAdPackageUtils, Context context, String str, Timer timer, String str2) {
        this.f968f = c0421o;
        this.f963a = iXAdPackageUtils;
        this.f964b = context;
        this.f965c = str;
        this.f966d = timer;
        this.f967e = str2;
    }

    public void run() {
        if (this.f968f.f957g >= this.f968f.f958h) {
            if (this.f968f.f957g >= this.f968f.f959i) {
                this.f966d.cancel();
                this.f963a.sendAPOIsSuccess(this.f964b, true, 0, this.f967e, this.f965c);
            } else if (!this.f963a.isForeground(this.f964b, this.f965c)) {
                this.f966d.cancel();
                this.f963a.sendAPOIsSuccess(this.f964b, false, this.f968f.f957g, this.f967e, this.f965c);
            }
        }
        this.f968f.f957g = this.f968f.f957g + 1;
    }
}
