package com.shuame.rootgenius.p115ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.p115ui.dialog.C1549b;

/* renamed from: com.shuame.rootgenius.ui.m */
final class C1598m implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1549b f4389a;
    /* renamed from: b */
    final /* synthetic */ FontPreviewActivity f4390b;

    C1598m(FontPreviewActivity fontPreviewActivity, C1549b c1549b) {
        this.f4390b = fontPreviewActivity;
        this.f4389a = c1549b;
    }

    public final void onClick(View view) {
        this.f4389a.dismiss();
    }
}
