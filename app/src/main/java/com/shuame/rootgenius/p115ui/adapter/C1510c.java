package com.shuame.rootgenius.p115ui.adapter;

import android.os.Handler.Callback;
import android.os.Message;
import com.shuame.rootgenius.p115ui.view.TextProgressBar;

/* renamed from: com.shuame.rootgenius.ui.adapter.c */
final class C1510c implements Callback {
    /* renamed from: a */
    final /* synthetic */ C1509b f4305a;

    C1510c(C1509b c1509b) {
        this.f4305a = c1509b;
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                C1509b.m4319a(message, ((TextProgressBar) this.f4305a.f4298d.findViewWithTag(Integer.valueOf(message.arg1))));
                break;
            case 3:
                C1509b.m4323a(this.f4305a, message, ((TextProgressBar) this.f4305a.f4298d.findViewWithTag(Integer.valueOf(message.arg1))));
                break;
            case 4:
                C1509b.m4327b(this.f4305a, message, ((TextProgressBar) this.f4305a.f4298d.findViewWithTag(Integer.valueOf(message.arg1))));
                break;
        }
        return false;
    }
}
