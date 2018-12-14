package com.shuame.rootgenius.common.util;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

/* renamed from: com.shuame.rootgenius.common.util.aa */
final class C1384aa implements OnGlobalLayoutListener {
    /* renamed from: a */
    final /* synthetic */ TextView f3854a;
    /* renamed from: b */
    final /* synthetic */ int f3855b = 4;

    C1384aa(TextView textView) {
        this.f3854a = textView;
    }

    public final void onGlobalLayout() {
        try {
            this.f3854a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            if (this.f3854a.getLineCount() > this.f3855b) {
                this.f3854a.setText(this.f3854a.getText().subSequence(0, this.f3854a.getLayout().getLineEnd(this.f3855b - 1) - 3) + "...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
