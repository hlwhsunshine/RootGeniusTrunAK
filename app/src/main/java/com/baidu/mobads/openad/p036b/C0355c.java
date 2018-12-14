package com.baidu.mobads.openad.p036b;

import android.webkit.CookieManager;

/* renamed from: com.baidu.mobads.openad.b.c */
final class C0355c implements Runnable {
    C0355c() {
    }

    public final void run() {
        CookieManager.getInstance().removeExpiredCookie();
    }
}
