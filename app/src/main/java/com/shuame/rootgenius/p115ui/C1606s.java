package com.shuame.rootgenius.p115ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.util.C1411s;
import com.shuame.rootgenius.p115ui.dialog.C1549b;
import java.io.File;

/* renamed from: com.shuame.rootgenius.ui.s */
final class C1606s implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ QQDownloadFile f4402a;
    /* renamed from: b */
    final /* synthetic */ C1549b f4403b;
    /* renamed from: c */
    final /* synthetic */ FontReplaceActivity f4404c;

    C1606s(FontReplaceActivity fontReplaceActivity, QQDownloadFile qQDownloadFile, C1549b c1549b) {
        this.f4404c = fontReplaceActivity;
        this.f4402a = qQDownloadFile;
        this.f4403b = c1549b;
    }

    public final void onClick(View view) {
        File a = FontReplaceActivity.m4244d();
        if (a != null) {
            long b = C1411s.m3926b(a.getAbsolutePath());
            FontReplaceActivity.f4182f;
            if (b > 600000) {
                C1361b.m3817a().mo7067a(this.f4402a, null);
            }
        }
        this.f4403b.dismiss();
    }
}
