package com.shuame.rootgenius.common.qqdownload;

/* renamed from: com.shuame.rootgenius.common.qqdownload.e */
final class C1364e implements Runnable {
    /* renamed from: a */
    final /* synthetic */ QQDownloadFile f3782a;
    /* renamed from: b */
    final /* synthetic */ C1361b f3783b;

    C1364e(C1361b c1361b, QQDownloadFile qQDownloadFile) {
        this.f3783b = c1361b;
        this.f3782a = qQDownloadFile;
    }

    public final void run() {
        this.f3783b.onFileName(this.f3782a.f3722c, this.f3782a.f3725f);
        this.f3783b.onComplete(this.f3782a.f3722c, 10002);
    }
}
