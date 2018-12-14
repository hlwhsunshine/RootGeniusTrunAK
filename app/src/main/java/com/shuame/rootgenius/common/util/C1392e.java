package com.shuame.rootgenius.common.util;

import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.common.p087ui.p106a.C1374a;

/* renamed from: com.shuame.rootgenius.common.util.e */
final class C1392e implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1374a f3866a;
    /* renamed from: b */
    final /* synthetic */ OnClickListener f3867b;

    C1392e(C1374a c1374a, OnClickListener onClickListener) {
        this.f3866a = c1374a;
        this.f3867b = onClickListener;
    }

    public final void onClick(View view) {
        this.f3866a.cancel();
        if (this.f3867b != null) {
            this.f3867b.onClick(view);
        }
    }
}
