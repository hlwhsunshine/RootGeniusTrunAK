package com.shuame.rootgenius.p115ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.ui.y */
final class C1615y implements OnCheckedChangeListener {
    /* renamed from: a */
    final /* synthetic */ GuideActivity f4566a;

    C1615y(GuideActivity guideActivity) {
        this.f4566a = guideActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f4566a.f4210g.findViewById(C1450R.id.btn_login).setEnabled(z);
    }
}
