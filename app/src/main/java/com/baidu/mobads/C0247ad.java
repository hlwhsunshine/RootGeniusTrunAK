package com.baidu.mobads;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.baidu.mobads.ad */
public class C0247ad extends WebViewClient {
    /* renamed from: a */
    private void m323a(WebView webView, String str) {
        if (webView != null) {
            try {
                webView.loadUrl(str);
            } catch (Exception e) {
            }
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        m323a(webView, str);
        return true;
    }
}
