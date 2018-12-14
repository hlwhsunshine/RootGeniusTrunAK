package com.shuame.rootgenius.common.util;

import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.common.p087ui.p106a.C1374a;

/* renamed from: com.shuame.rootgenius.common.util.f */
final class C1393f implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1374a f3868a;
    /* renamed from: b */
    final /* synthetic */ OnClickListener f3869b;

    C1393f(C1374a c1374a, OnClickListener onClickListener) {
        this.f3868a = c1374a;
        this.f3869b = onClickListener;
    }

    public final void onClick(View view) {
        this.f3868a.cancel();
        if (this.f3869b != null) {
            this.f3869b.onClick(view);
        }
    }
}
