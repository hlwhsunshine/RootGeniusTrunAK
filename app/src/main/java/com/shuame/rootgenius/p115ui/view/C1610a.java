package com.shuame.rootgenius.p115ui.view;

import android.view.View;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.ui.view.a */
public final class C1610a {
    /* renamed from: a */
    private View f4560a;
    /* renamed from: b */
    private View f4561b;

    public C1610a(View view) {
        this.f4560a = view.findViewById(C1450R.id.tv_title_standard);
        this.f4561b = view.findViewById(C1450R.id.ll_title_special);
        this.f4560a.setVisibility(0);
        this.f4561b.setVisibility(8);
    }

    /* renamed from: a */
    public final void mo7562a() {
        this.f4560a.setVisibility(8);
        this.f4561b.setVisibility(0);
    }
}
