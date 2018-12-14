package com.baidu.mobads;

import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebView;

/* renamed from: com.baidu.mobads.af */
public class C0245af extends WebView {
    public C0245af(Context context) {
        super(context);
        m310a();
    }

    /* renamed from: a */
    private void m310a() {
        try {
            if (Integer.parseInt(VERSION.SDK) >= 11) {
                Class.forName("android.webkit.WebView").getDeclaredMethod("removeJavascriptInterface", new Class[]{String.class}).invoke(this, new Object[]{"searchBoxJavaBridge_"});
            }
        } catch (Exception e) {
        }
    }
}
