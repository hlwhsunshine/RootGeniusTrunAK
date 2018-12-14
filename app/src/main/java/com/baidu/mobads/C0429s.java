package com.baidu.mobads;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.baidu.mobads.s */
class C0429s implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ AppActivity f982a;

    C0429s(AppActivity appActivity) {
        this.f982a = appActivity;
    }

    public void onClick(View view) {
        this.f982a.runBottomViewExitAnimation(this.f982a.f161C, this.f982a.mBottomView);
    }
}
