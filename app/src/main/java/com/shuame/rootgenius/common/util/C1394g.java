package com.shuame.rootgenius.common.util;

import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.common.p087ui.p106a.C1376b;

/* renamed from: com.shuame.rootgenius.common.util.g */
final class C1394g implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1376b f3870a;
    /* renamed from: b */
    final /* synthetic */ OnClickListener f3871b = null;

    C1394g(C1376b c1376b) {
        this.f3870a = c1376b;
    }

    public final void onClick(View view) {
        this.f3870a.cancel();
        if (this.f3871b != null) {
            this.f3871b.onClick(view);
        }
    }
}
