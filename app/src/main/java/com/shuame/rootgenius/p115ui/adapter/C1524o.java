package com.shuame.rootgenius.p115ui.adapter;

import android.os.Handler.Callback;
import android.os.Message;

/* renamed from: com.shuame.rootgenius.ui.adapter.o */
final class C1524o implements Callback {
    /* renamed from: a */
    final /* synthetic */ C1523n f4340a;

    C1524o(C1523n c1523n) {
        this.f4340a = c1523n;
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                C1523n.m4343a(message, this.f4340a.m4340a(message.arg1));
                break;
            case 3:
                C1523n.m4346a(this.f4340a, message, this.f4340a.m4340a(message.arg1));
                break;
            case 4:
                C1523n.m4352b(this.f4340a, message, this.f4340a.m4340a(message.arg1));
                break;
        }
        return false;
    }
}
