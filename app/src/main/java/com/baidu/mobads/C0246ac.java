package com.baidu.mobads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.baidu.mobads.p021j.C0336j;
import java.lang.reflect.Method;
import java.util.Locale;

/* renamed from: com.baidu.mobads.ac */
public class C0246ac extends C0245af {
    /* renamed from: a */
    public String f399a = "";

    /* renamed from: com.baidu.mobads.ac$a */
    static class C0244a {
        /* renamed from: a */
        private static String[] f391a = "apk,zip,rar,7z,tar.gz,bz".split(",");
        /* renamed from: b */
        private static String[] f392b = "mp4,3gp,3g2,avi,rm,rmvb,wmv,flv,mkv,mov,asf,asx".split(",");
        /* renamed from: c */
        private static String[] f393c = "mp3,ra,wma,m4a,wav,aac,mmf,amr,ogg,adp".split(",");
        /* renamed from: d */
        private static String[] f394d = "sms,smsto,mms".split(",");
        /* renamed from: e */
        private static final String[] f395e = new String[]{"tel"};
        /* renamed from: f */
        private static final String[] f396f = new String[]{"mailto"};
        /* renamed from: g */
        private static String[] f397g = "http,https".split(",");
        /* renamed from: h */
        private static String[] f398h = "http,https,sms,smsto,mms,tel,fax,ftp,mailto,gopher,news,telnet,file".split(",");
    }

    @TargetApi(3)
    public C0246ac(Context context, boolean z, boolean z2) {
        super(context);
        setClickable(true);
        if (z) {
            setBackgroundColor(0);
        }
        if (z2) {
            setFocusable(true);
        } else {
            setFocusable(false);
        }
        setScrollBarStyle(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setNeedInitialFocus(false);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setAllowFileAccess(true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        String path = context.getApplicationContext().getDir("database", 0).getPath();
        try {
            WebSettings.class.getMethod("setDatabasePath", new Class[]{String.class}).invoke(settings, new Object[]{path});
            WebSettings.class.getMethod("setDomStorageEnabled", new Class[]{Boolean.TYPE}).invoke(settings, new Object[]{Boolean.valueOf(true)});
            WebSettings.class.getMethod("setDatabaseEnabled", new Class[]{Boolean.TYPE}).invoke(settings, new Object[]{Boolean.valueOf(true)});
        } catch (Exception e) {
        }
        try {
            WebSettings.class.getMethod("setAppCacheEnabled", new Class[]{Boolean.TYPE}).invoke(settings, new Object[]{Boolean.valueOf(true)});
            WebSettings.class.getMethod("setAppCachePath", new Class[]{String.class}).invoke(settings, new Object[]{path});
            WebSettings.class.getMethod("setAppCacheMaxSize", new Class[]{Long.TYPE}).invoke(settings, new Object[]{Long.valueOf(5242880)});
        } catch (Exception e2) {
        }
        try {
            WebSettings.class.getMethod("setGeolocationEnabled", new Class[]{Boolean.TYPE}).invoke(settings, new Object[]{Boolean.valueOf(true)});
            WebSettings.class.getMethod("setGeolocationDatabasePath", new Class[]{String.class}).invoke(settings, new Object[]{path});
        } catch (Exception e3) {
        }
        setWebViewClient(new C0247ad());
        setWebChromeClient(new WebChromeClient());
        try {
            if (Integer.parseInt(VERSION.SDK) >= 14) {
                Method declaredMethod = Class.forName("android.view.View").getDeclaredMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this, new Object[]{Integer.valueOf(1), null});
            }
        } catch (Throwable e4) {
            C0336j.m550a().mo4928e(e4);
        }
    }

    /* renamed from: a */
    public static boolean m311a(String str) {
        return !C0246ac.m315c(str) || C0246ac.m319g(str) || C0246ac.m320h(str) || C0246ac.m321i(str);
    }

    /* renamed from: a */
    private static boolean m312a(String[] strArr, String str) {
        if (str == null) {
            return false;
        }
        boolean z;
        Uri parse = Uri.parse(str);
        String toLowerCase = parse.getPath() == null ? "" : parse.getPath().toLowerCase(Locale.getDefault());
        for (String str2 : strArr) {
            if (toLowerCase.trim().endsWith("." + str2)) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    /* renamed from: b */
    public static boolean m313b(String str) {
        return C0246ac.m316d(str) || C0246ac.m317e(str) || C0246ac.m318f(str) || (C0246ac.m322j(str) && (!C0246ac.m315c(str) || C0246ac.m319g(str) || C0246ac.m320h(str) || C0246ac.m321i(str)));
    }

    /* renamed from: b */
    private static boolean m314b(String[] strArr, String str) {
        if (str == null) {
            return false;
        }
        String toLowerCase = str.toLowerCase(Locale.getDefault());
        for (String str2 : strArr) {
            if (toLowerCase.trim().startsWith(str2 + ":")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m315c(String str) {
        return C0246ac.m314b(C0244a.f397g, str);
    }

    /* renamed from: d */
    public static boolean m316d(String str) {
        return C0246ac.m314b(C0244a.f394d, str);
    }

    /* renamed from: e */
    public static boolean m317e(String str) {
        return C0246ac.m314b(C0244a.f395e, str);
    }

    /* renamed from: f */
    public static boolean m318f(String str) {
        return C0246ac.m314b(C0244a.f396f, str);
    }

    /* renamed from: g */
    public static boolean m319g(String str) {
        return C0246ac.m312a(C0244a.f391a, str);
    }

    /* renamed from: h */
    public static boolean m320h(String str) {
        return C0246ac.m312a(C0244a.f392b, str);
    }

    /* renamed from: i */
    public static boolean m321i(String str) {
        return C0246ac.m312a(C0244a.f393c, str);
    }

    /* renamed from: j */
    private static boolean m322j(String str) {
        return C0246ac.m314b(C0244a.f398h, str);
    }
}
