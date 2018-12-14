package com.shuame.rootgenius.p115ui;

import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.util.C1397j;
import com.shuame.rootgenius.service.C1491i;

/* renamed from: com.shuame.rootgenius.ui.ag */
final class C1529ag extends Thread {
    /* renamed from: a */
    final /* synthetic */ ShuameGuideActivity f4346a;

    C1529ag(ShuameGuideActivity shuameGuideActivity) {
        this.f4346a = shuameGuideActivity;
    }

    public final void run() {
        C1491i.m4161a().mo7317c();
        this.f4346a.f4239k = C1491i.m4161a().mo7316b();
        if (this.f4346a.f4239k.f4014a) {
            QQDownloadFile b = this.f4346a.f4239k.mo7246b();
            b.f3725f = C1397j.m3897a(b);
            ShuameGuideActivity.m4275c(b);
            return;
        }
        this.f4346a.f4240l.post(new C1530ah(this));
    }
}
