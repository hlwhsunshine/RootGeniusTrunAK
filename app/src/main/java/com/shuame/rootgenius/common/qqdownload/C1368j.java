package com.shuame.rootgenius.common.qqdownload;

/* renamed from: com.shuame.rootgenius.common.qqdownload.j */
final class C1368j implements Runnable {
    /* renamed from: a */
    final /* synthetic */ QQDownloadFile f3794a;
    /* renamed from: b */
    final /* synthetic */ int f3795b;
    /* renamed from: c */
    final /* synthetic */ long f3796c;
    /* renamed from: d */
    final /* synthetic */ C1367i f3797d;

    C1368j(C1367i c1367i, QQDownloadFile qQDownloadFile, int i, long j) {
        this.f3797d = c1367i;
        this.f3794a = qQDownloadFile;
        this.f3795b = i;
        this.f3796c = j;
    }

    public final void run() {
        long j = this.f3794a.f3718B;
        if (j > 0) {
            this.f3797d.f3792f.mo7061a(this.f3795b, this.f3796c, j);
        } else {
            this.f3797d.f3792f.mo7060a(this.f3795b, this.f3796c);
        }
    }
}
