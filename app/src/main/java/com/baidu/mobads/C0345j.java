package com.baidu.mobads;

import android.app.AlertDialog.Builder;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import com.baidu.mobads.AppActivity.C0223b;

/* renamed from: com.baidu.mobads.j */
class C0345j extends WebViewClient {
    /* renamed from: a */
    final /* synthetic */ C0223b f714a;
    /* renamed from: b */
    final /* synthetic */ AppActivity f715b;

    C0345j(AppActivity appActivity, C0223b c0223b) {
        this.f715b = appActivity;
        this.f714a = c0223b;
    }

    /* renamed from: a */
    private void m598a(String str) {
        if (this.f715b.f181q != null) {
            try {
                if (this.f714a.f202d) {
                    this.f715b.f159A.f1081n = str;
                    if (this.f715b.f159A.f1093z == 0) {
                        this.f715b.f159A.f1093z = System.currentTimeMillis();
                    }
                    this.f715b.f159A.f1082o = this.f715b.f182r = this.f715b.f182r + 1;
                    if (this.f715b.curWebview != null) {
                        this.f715b.f159A.f1083p = this.f715b.curWebview.getContentHeight();
                        this.f715b.f159A.f1084q = this.f715b.curWebview.getProgress();
                    }
                    this.f715b.f159A.f1088u = System.currentTimeMillis() - this.f715b.f183s;
                    this.f715b.f159A.f1089v = this.f715b.f186v;
                    this.f715b.f159A.f1091x = this.f715b.f171e;
                    this.f714a.f202d = false;
                    return;
                }
                this.f715b.f162D.mo4931i(AppActivity.f157o, "App2Activity - not send 37");
            } catch (Exception e) {
                this.f715b.f162D.mo4922d(AppActivity.f157o, e.getMessage());
            }
        }
    }

    /* renamed from: a */
    private void m599a(String str, int i) {
        if (this.f715b.f181q != null) {
            try {
                this.f715b.f159A.f1081n = str;
                if (this.f715b.f159A.f1073A == 0) {
                    this.f715b.f159A.f1073A = System.currentTimeMillis();
                }
                this.f715b.f159A.f1082o = this.f715b.f182r = this.f715b.f182r + 1;
                this.f715b.f159A.f1089v = this.f715b.f186v;
                this.f715b.f159A.f1091x = this.f715b.f171e;
                if (this.f715b.curWebview != null) {
                    this.f715b.f159A.f1083p = this.f715b.curWebview.getContentHeight();
                    this.f715b.f159A.f1084q = this.f715b.curWebview.getProgress();
                }
                this.f715b.f159A.f1088u = System.currentTimeMillis() - this.f715b.f183s;
                this.f714a.f202d = true;
            } catch (Exception e) {
                this.f715b.f162D.mo4922d(AppActivity.f157o, e.getMessage());
            }
        }
    }

    public void onLoadResource(WebView webView, String str) {
        try {
            if (!(this.f714a.f201c || str.equals(this.f714a.f200b) || this.f714a.f199a)) {
                this.f714a.f201c = true;
                if (this.f715b.f173g == -1) {
                    this.f715b.f173g = (int) (System.currentTimeMillis() - this.f715b.f183s);
                }
                m599a(this.f714a.f200b, 0);
            }
            HitTestResult hitTestResult = webView.getHitTestResult();
            if (hitTestResult != null && hitTestResult.getType() > 0) {
                this.f715b.m213a(webView, str, new C0347l(this), null);
            }
        } catch (Exception e) {
            this.f715b.f162D.mo4922d(AppActivity.f157o, e.getMessage());
        }
    }

    public void onPageFinished(WebView webView, String str) {
        if (!this.f714a.f199a && this.f714a.f200b.equals(str)) {
            if (this.f715b.f173g == -1) {
                this.f715b.f173g = (int) (System.currentTimeMillis() - this.f715b.f183s);
            }
            if (!this.f714a.f201c) {
                this.f714a.f201c = true;
                m599a(this.f714a.f200b, 0);
            }
        }
        this.f714a.f199a = false;
        this.f714a.f200b = "";
        if (this.f715b.f165H != null) {
            this.f715b.f165H.onPageFinished(webView);
        }
        super.onPageFinished(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (!(this.f715b.curWebview == null || str == null)) {
            this.f715b.curWebview.f399a = str;
        }
        this.f714a.f200b = str;
        this.f714a.f201c = false;
        if (!this.f714a.f199a) {
            m598a(str);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Builder builder = new Builder(this.f715b);
        builder.setMessage("ssl证书验证失败，是否继续访问该网页？");
        builder.setPositiveButton("继续", new C0348m(this, sslErrorHandler));
        builder.setNegativeButton("取消", new C0349n(this, sslErrorHandler));
        builder.setOnKeyListener(new C0350o(this, sslErrorHandler));
        builder.create().show();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str != null) {
            try {
                if (!str.equals("about:blank")) {
                    this.f715b.m213a(webView, str, null, new C0346k(this, str));
                    HitTestResult hitTestResult = webView.getHitTestResult();
                    if (hitTestResult == null || hitTestResult.getType() != 0) {
                        return true;
                    }
                    this.f715b.f162D.mo4922d(AppActivity.f157o, "AppActivity shouldOverrideUrlLoading and hitType==0");
                    this.f714a.f199a = true;
                    return true;
                }
            } catch (Exception e) {
                this.f715b.f162D.mo4922d(AppActivity.f157o, e.getMessage());
                return true;
            }
        }
        return false;
    }
}
