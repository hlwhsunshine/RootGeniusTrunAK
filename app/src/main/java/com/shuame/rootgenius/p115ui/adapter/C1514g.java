package com.shuame.rootgenius.p115ui.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.p115ui.dialog.C1549b;

/* renamed from: com.shuame.rootgenius.ui.adapter.g */
final class C1514g implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1549b f4310a;
    /* renamed from: b */
    final /* synthetic */ FontListAdapter f4311b;

    C1514g(FontListAdapter fontListAdapter, C1549b c1549b) {
        this.f4311b = fontListAdapter;
        this.f4310a = c1549b;
    }

    public final void onClick(View view) {
        this.f4310a.dismiss();
    }
}
