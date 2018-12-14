package com.baidu.mobads.openad.p029c;

import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.p021j.C0338m;

/* renamed from: com.baidu.mobads.openad.c.c */
class C0360c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0359b f767a;

    C0360c(C0359b c0359b) {
        this.f767a = c0359b;
    }

    public void run() {
        try {
            if (this.f767a.f762c.f470g == DownloadStatus.CANCELLED) {
                C0359b.f759a.cancel(this.f767a.f762c.f469f);
                return;
            }
            C0359b.f759a.notify(this.f767a.f762c.f469f, this.f767a.m633d());
            if (this.f767a.f762c.f470g == DownloadStatus.ERROR) {
                C0338m.m569a().mo5033f().mo4922d("OAdApkDownloaderObserver", "status >> error");
            } else if (this.f767a.f762c.f470g == DownloadStatus.INITING && this.f767a.f762c.f480q == 1) {
                this.f767a.m634d("开始下载 " + this.f767a.f762c.f464a);
            }
        } catch (Throwable e) {
            C0338m.m569a().mo5033f().mo4923d("OAdApkDownloaderObserver", e);
        }
    }
}
