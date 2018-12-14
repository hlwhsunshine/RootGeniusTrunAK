package com.shuame.rootgenius.p115ui;

import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.ui.o */
final class C1600o implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1599n f4394a;

    C1600o(C1599n c1599n) {
        this.f4394a = c1599n;
    }

    public final void run() {
        C1361b.m3817a().mo7067a(this.f4394a.f4391a, null);
        if (this.f4394a.f4391a.f3719C == Status.PENDING) {
            this.f4394a.f4393c.f4164f.setText(C1450R.string.text_pending);
        } else {
            this.f4394a.f4393c.f4164f.setText(C1450R.string.text_downloading);
        }
        this.f4394a.f4393c.f4167i.setProgress(this.f4394a.f4391a.f3728i / 10);
    }
}
