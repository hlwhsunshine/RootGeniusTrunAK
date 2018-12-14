package com.shuame.rootgenius.common.qqdownload;

import android.text.TextUtils;
import java.io.File;

/* renamed from: com.shuame.rootgenius.common.qqdownload.c */
final class C1362c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f3776a;
    /* renamed from: b */
    final /* synthetic */ boolean f3777b = false;
    /* renamed from: c */
    final /* synthetic */ QQDownloadFile f3778c;
    /* renamed from: d */
    final /* synthetic */ C1361b f3779d;

    C1362c(C1361b c1361b, int i, QQDownloadFile qQDownloadFile) {
        this.f3779d = c1361b;
        this.f3776a = i;
        this.f3778c = qQDownloadFile;
    }

    public final void run() {
        this.f3779d.f3757h.mo7064b(this.f3776a);
        if (this.f3777b && !TextUtils.isEmpty(this.f3778c.f3725f)) {
            File file = new File(this.f3778c.f3725f);
            File file2 = new File(this.f3778c.mo7051a());
            QQDownloadFile qQDownloadFile = this.f3778c;
            File file3 = new File(!TextUtils.isEmpty(qQDownloadFile.f3725f) ? qQDownloadFile.f3725f + ".tmp.qdlc" : null);
            if (file.exists()) {
                file.delete();
            }
            if (file2.exists()) {
                file2.delete();
            }
            if (file3.exists()) {
                file3.delete();
            }
        }
    }
}
