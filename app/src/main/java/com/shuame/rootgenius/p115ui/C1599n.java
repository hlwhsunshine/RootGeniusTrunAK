package com.shuame.rootgenius.p115ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.p115ui.dialog.C1549b;

/* renamed from: com.shuame.rootgenius.ui.n */
final class C1599n implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ QQDownloadFile f4391a;
    /* renamed from: b */
    final /* synthetic */ C1549b f4392b;
    /* renamed from: c */
    final /* synthetic */ FontPreviewActivity f4393c;

    C1599n(FontPreviewActivity fontPreviewActivity, QQDownloadFile qQDownloadFile, C1549b c1549b) {
        this.f4393c = fontPreviewActivity;
        this.f4391a = qQDownloadFile;
        this.f4392b = c1549b;
    }

    public final void onClick(View view) {
        this.f4393c.f4170l.post(new C1600o(this));
        this.f4392b.dismiss();
    }
}
