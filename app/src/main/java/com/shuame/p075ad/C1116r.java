package com.shuame.p075ad;

import android.content.Context;
import com.shuame.utils.C1621e;

/* renamed from: com.shuame.ad.r */
final class C1116r {
    /* renamed from: a */
    public static String m3248a() {
        String str = "http://client.shuame.com";
        if (C1106j.m3208a().mo6707f()) {
            str = "http://client.shuame.org";
        }
        Context c = C1106j.m3208a().mo6705c();
        String e = C1621e.m4398e(c);
        int f = C1621e.m4399f(c);
        String packageName = c.getPackageName();
        return str + String.format("/api/shuameandroid/adcloud/?versionName=%s&versionCode=%d&format=json&dataStatus=1&pkgName=%s", new Object[]{e, Integer.valueOf(f), packageName});
    }
}
