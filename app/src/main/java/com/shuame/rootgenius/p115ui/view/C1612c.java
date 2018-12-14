package com.shuame.rootgenius.p115ui.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.ui.view.c */
final class C1612c implements OnLongClickListener {
    /* renamed from: a */
    final /* synthetic */ ScreenShotScrollView f4563a;

    C1612c(ScreenShotScrollView screenShotScrollView) {
        this.f4563a = screenShotScrollView;
    }

    public final boolean onLongClick(View view) {
        if (this.f4563a.f4549e != null) {
            this.f4563a.f4549e;
            ((Integer) view.getTag(C1450R.id.tag_data)).intValue();
        }
        return false;
    }
}
