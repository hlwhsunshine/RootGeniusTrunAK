package com.shuame.rootgenius.common.util;

import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.common.p087ui.p106a.C1376b;

/* renamed from: com.shuame.rootgenius.common.util.h */
final class C1395h implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1376b f3872a;
    /* renamed from: b */
    final /* synthetic */ OnClickListener f3873b;

    C1395h(C1376b c1376b, OnClickListener onClickListener) {
        this.f3872a = c1376b;
        this.f3873b = onClickListener;
    }

    public final void onClick(View view) {
        this.f3872a.cancel();
        if (this.f3873b != null) {
            this.f3873b.onClick(view);
        }
    }
}
