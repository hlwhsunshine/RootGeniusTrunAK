package com.shuame.rootgenius.appmanager.p096ui.view;

import android.os.Handler.Callback;
import android.os.Message;

/* renamed from: com.shuame.rootgenius.appmanager.ui.view.a */
final class C1298a implements Callback {
    /* renamed from: a */
    final /* synthetic */ CursorProgressbar f3533a;

    C1298a(CursorProgressbar cursorProgressbar) {
        this.f3533a = cursorProgressbar;
    }

    public final boolean handleMessage(Message message) {
        this.f3533a.invalidate();
        return false;
    }
}
