package com.baidu.mobads.openad.p036b;

import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.mobads.openad.p037e.C0368a;

/* renamed from: com.baidu.mobads.openad.b.b */
public class C0354b implements C0353a {
    /* renamed from: a */
    public static Context f729a;

    public C0354b() {
        Class.forName("android.webkit.CookieManager", true, C0368a.class.getClassLoader());
    }

    /* renamed from: a */
    public static void m606a(Context context) {
        if (f729a == null) {
            f729a = context;
            CookieSyncManager.createInstance(context);
            if (VERSION.SDK_INT < 21) {
                new Thread(new C0355c()).start();
            }
        }
    }

    /* renamed from: a */
    public String mo5065a(String str) {
        return CookieManager.getInstance().getCookie(str);
    }

    /* renamed from: a */
    public void mo5066a() {
        CookieManager.getInstance().removeExpiredCookie();
    }

    /* renamed from: a */
    public void mo5067a(String str, String str2) {
        CookieManager.getInstance().setCookie(str, str2);
        CookieSyncManager.getInstance().sync();
    }
}
