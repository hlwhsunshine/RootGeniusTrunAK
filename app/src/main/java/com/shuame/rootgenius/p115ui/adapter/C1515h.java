package com.shuame.rootgenius.p115ui.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.example.myfontsdk.Font;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.p115ui.dialog.C1549b;

/* renamed from: com.shuame.rootgenius.ui.adapter.h */
final class C1515h implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ QQDownloadFile f4312a;
    /* renamed from: b */
    final /* synthetic */ View f4313b;
    /* renamed from: c */
    final /* synthetic */ Font f4314c;
    /* renamed from: d */
    final /* synthetic */ C1549b f4315d;
    /* renamed from: e */
    final /* synthetic */ FontListAdapter f4316e;

    C1515h(FontListAdapter fontListAdapter, QQDownloadFile qQDownloadFile, View view, Font font, C1549b c1549b) {
        this.f4316e = fontListAdapter;
        this.f4312a = qQDownloadFile;
        this.f4313b = view;
        this.f4314c = font;
        this.f4315d = c1549b;
    }

    public final void onClick(View view) {
        this.f4316e.f4281j.post(new C1516i(this));
        this.f4315d.dismiss();
    }
}
