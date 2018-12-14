package com.shuame.rootgenius.p115ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.ui.view.b */
final class C1611b implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ScreenShotScrollView f4562a;

    C1611b(ScreenShotScrollView screenShotScrollView) {
        this.f4562a = screenShotScrollView;
    }

    public final void onClick(View view) {
        if (this.f4562a.f4549e != null) {
            this.f4562a.f4549e;
            ((Integer) view.getTag(C1450R.id.tag_data)).intValue();
        }
    }
}
