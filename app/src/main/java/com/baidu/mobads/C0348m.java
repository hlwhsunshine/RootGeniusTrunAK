package com.baidu.mobads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

/* renamed from: com.baidu.mobads.m */
class C0348m implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ SslErrorHandler f719a;
    /* renamed from: b */
    final /* synthetic */ C0345j f720b;

    C0348m(C0345j c0345j, SslErrorHandler sslErrorHandler) {
        this.f720b = c0345j;
        this.f719a = sslErrorHandler;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f719a.proceed();
    }
}
