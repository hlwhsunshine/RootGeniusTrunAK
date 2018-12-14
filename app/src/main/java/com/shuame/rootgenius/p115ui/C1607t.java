package com.shuame.rootgenius.p115ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.shuame.rootgenius.ui.t */
final class C1607t implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FontReplaceActivity f4405a;

    C1607t(FontReplaceActivity fontReplaceActivity) {
        this.f4405a = fontReplaceActivity;
    }

    public final void onClick(View view) {
        this.f4405a.startActivity(new Intent("android.settings.SETTINGS"));
    }
}
