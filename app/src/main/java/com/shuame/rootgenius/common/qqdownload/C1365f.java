package com.shuame.rootgenius.common.qqdownload;

import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;

/* renamed from: com.shuame.rootgenius.common.qqdownload.f */
final class C1365f implements Runnable {
    /* renamed from: a */
    final /* synthetic */ QQDownloadFile f3784a;
    /* renamed from: b */
    final /* synthetic */ C1361b f3785b;

    C1365f(C1361b c1361b, QQDownloadFile qQDownloadFile) {
        this.f3785b = c1361b;
        this.f3784a = qQDownloadFile;
    }

    public final void run() {
        if ((this.f3784a.f3734o == Type.ROM ? this.f3785b.f3757h.mo7066c(this.f3784a.f3721b) : this.f3785b.f3757h.mo7056a(this.f3784a.f3724e)) != null) {
            this.f3785b.f3757h.mo7065b(this.f3784a);
        } else {
            this.f3785b.f3757h.mo7063a(this.f3784a);
        }
    }
}
