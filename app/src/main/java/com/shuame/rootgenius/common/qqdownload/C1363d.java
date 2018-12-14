package com.shuame.rootgenius.common.qqdownload;

/* renamed from: com.shuame.rootgenius.common.qqdownload.d */
final class C1363d implements Runnable {
    /* renamed from: a */
    final /* synthetic */ QQDownloadFile f3780a;
    /* renamed from: b */
    final /* synthetic */ C1361b f3781b;

    C1363d(C1361b c1361b, QQDownloadFile qQDownloadFile) {
        this.f3781b = c1361b;
        this.f3780a = qQDownloadFile;
    }

    public final void run() {
        C1361b.f3754e;
        new StringBuilder("download file already ok path:").append(this.f3780a.f3725f);
        this.f3781b.onFileName(this.f3780a.f3722c, this.f3780a.f3725f);
        this.f3781b.onTaskInfo(this.f3780a.f3722c, 1000, 0);
        this.f3781b.onComplete(this.f3780a.f3722c, 0);
    }
}
