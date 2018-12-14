package com.baidu.mobads.p034h;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.openad.p020d.C0232b;
import com.baidu.mobads.p022a.C0239b;

/* renamed from: com.baidu.mobads.h.m */
class C0314m implements IOAdEventListener {
    /* renamed from: a */
    final /* synthetic */ double f586a;
    /* renamed from: b */
    final /* synthetic */ C0313l f587b;

    C0314m(C0313l c0313l, double d) {
        this.f587b = c0313l;
        this.f586a = d;
    }

    public void run(IOAdEvent iOAdEvent) {
        boolean z = true;
        this.f587b.f585a.f584b.m460l();
        if ("URLLoader.Load.Complete".equals(iOAdEvent.getType())) {
            this.f587b.f585a.f584b.f577j = new C0302e((String) iOAdEvent.getData().get(C0232b.EVENT_MESSAGE));
            double a = C0239b.m288a();
            float f = this.f587b.f585a.f584b.m458j().getFloat("__badApkVersion__8.25", 0.0f);
            Boolean valueOf = Boolean.valueOf(((float) this.f587b.f585a.f584b.f577j.mo4491b()) == f);
            if (a >= this.f587b.f585a.f584b.f577j.mo4491b() || Math.floor(a) != Math.floor(this.f587b.f585a.f584b.f577j.mo4491b())) {
                z = false;
            }
            Boolean valueOf2 = Boolean.valueOf(z);
            new StringBuilder("try to download apk badVer=").append(f).append(", isBad=").append(valueOf).append(", compatible=").append(valueOf2);
            if (this.f586a < this.f587b.f585a.f584b.f577j.mo4491b() && this.f587b.f585a.f584b.f577j != null && this.f587b.f585a.f584b.f577j.mo4490a().booleanValue() && valueOf2.booleanValue() && !valueOf.booleanValue()) {
                this.f587b.f585a.f584b.m440a(this.f587b.f585a.f584b.f577j);
            }
        }
    }
}
