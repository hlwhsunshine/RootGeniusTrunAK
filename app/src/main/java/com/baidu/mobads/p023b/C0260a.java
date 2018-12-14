package com.baidu.mobads.p023b;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mobads.command.C0271a;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p025c.C0265a;

/* renamed from: com.baidu.mobads.b.a */
public class C0260a extends BroadcastReceiver {
    /* renamed from: a */
    protected final IXAdLogger f433a = C0338m.m569a().mo5033f();
    /* renamed from: b */
    private C0271a f434b;

    public C0260a(C0271a c0271a) {
        this.f434b = c0271a;
    }

    @TargetApi(3)
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            String replace = intent.getDataString().replace("package:", "");
            if (replace.equals(this.f434b.f472i)) {
                IXAdPackageUtils l = C0338m.m569a().mo5039l();
                if (this.f434b.f485v && this.f434b.f486w != null && !this.f434b.f486w.equals("")) {
                    IXAdConstants p = C0338m.m569a().mo5043p();
                    if (l.sendAPOInfo(context, this.f434b.f486w, replace, 381, p.getActTypeDownload())) {
                        C0338m.m569a().mo5040m().browserOutside(context, this.f434b.f486w);
                    }
                    context.unregisterReceiver(this);
                } else if (this.f434b.f475l) {
                    try {
                        Thread.sleep(600);
                        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(replace);
                        launchIntentForPackage.addFlags(268435456);
                        context.startActivity(launchIntentForPackage);
                        context.unregisterReceiver(this);
                    } catch (Throwable e) {
                        this.f433a.mo4923d("InstallReceiver", e);
                    }
                }
                C0265a.m334a().mo4399b(context, this.f434b);
            }
        }
    }
}
