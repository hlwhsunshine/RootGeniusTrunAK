package com.baidu.mobads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

/* renamed from: com.baidu.mobads.n */
class C0349n implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ SslErrorHandler f721a;
    /* renamed from: b */
    final /* synthetic */ C0345j f722b;

    C0349n(C0345j c0345j, SslErrorHandler sslErrorHandler) {
        this.f722b = c0345j;
        this.f721a = sslErrorHandler;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f721a.cancel();
    }
}
