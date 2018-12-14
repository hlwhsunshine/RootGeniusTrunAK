package com.baidu.mobads;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.mobads.AppActivity.C0222a;

/* renamed from: com.baidu.mobads.d */
class C0277d extends WebChromeClient {
    /* renamed from: a */
    final /* synthetic */ C0222a f504a;
    /* renamed from: b */
    final /* synthetic */ AppActivity f505b;

    C0277d(AppActivity appActivity, C0222a c0222a) {
        this.f505b = appActivity;
        this.f504a = c0222a;
    }

    public void onProgressChanged(WebView webView, int i) {
        if (this.f504a != null) {
            this.f504a.mo4054a(i);
            if (i > 50) {
                this.f505b.m238i();
                this.f504a.setVisibility(i >= 100 ? 4 : 0);
            }
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.f505b.f169c != null) {
            this.f505b.f169c.mo4466a(str);
        }
    }
}
