package com.baidu.mobads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;

/* renamed from: com.baidu.mobads.o */
class C0350o implements OnKeyListener {
    /* renamed from: a */
    final /* synthetic */ SslErrorHandler f723a;
    /* renamed from: b */
    final /* synthetic */ C0345j f724b;

    C0350o(C0345j c0345j, SslErrorHandler sslErrorHandler) {
        this.f724b = c0345j;
        this.f723a = sslErrorHandler;
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 4) {
            return false;
        }
        this.f723a.cancel();
        dialogInterface.dismiss();
        return true;
    }
}
