package com.shuame.rootgenius.appmanager.p096ui.p097a;

import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.appmanager.p090a.C1252b;
import com.shuame.rootgenius.appmanager.p091b.C1254a;
import com.shuame.rootgenius.appmanager.p091b.C1259d;
import com.shuame.rootgenius.appmanager.p095f.C1270a;

/* renamed from: com.shuame.rootgenius.appmanager.ui.a.e */
final class C1282e implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1254a f3451a;
    /* renamed from: b */
    final /* synthetic */ C1280c f3452b;

    C1282e(C1280c c1280c, C1254a c1254a) {
        this.f3452b = c1280c;
        this.f3451a = c1254a;
    }

    public final void onClick(View view) {
        this.f3451a.f3341e = C1270a.m3606a(this.f3452b.f3445d, this.f3451a.f3340d);
        C1280c.m3618a(this.f3452b.f3446e, this.f3451a.f3339c, this.f3451a);
        C1259d.m3571n().offer(this.f3451a);
        if (!C1259d.m3572o().booleanValue()) {
            C1259d.m3563c(Boolean.valueOf(true));
            new C1252b(this.f3452b.f3446e, this.f3452b.f3445d, this.f3452b.f3449h, this.f3452b.f3448g).start();
        }
    }
}
