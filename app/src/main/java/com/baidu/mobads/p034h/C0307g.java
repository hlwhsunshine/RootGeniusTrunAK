package com.baidu.mobads.p034h;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.p037e.C0368a;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p022a.C0239b;
import java.io.File;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.baidu.mobads.h.g */
public class C0307g {
    /* renamed from: a */
    protected static UncaughtExceptionHandler f568a;
    /* renamed from: b */
    protected static volatile C0296a f569b = null;
    /* renamed from: c */
    protected static volatile C0296a f570c = null;
    /* renamed from: e */
    protected static final Handler f571e = new C0308h(Looper.getMainLooper());
    /* renamed from: h */
    private static String f572h;
    /* renamed from: d */
    protected String f573d = null;
    /* renamed from: f */
    protected Handler f574f = f571e;
    @SuppressLint({"HandlerLeak"})
    /* renamed from: g */
    protected final Handler f575g = new C0309i(this, Looper.getMainLooper());
    /* renamed from: i */
    private C0368a f576i;
    /* renamed from: j */
    private C0302e f577j;
    /* renamed from: k */
    private final Context f578k;
    /* renamed from: l */
    private IXAdLogger f579l = C0338m.m569a().mo5033f();
    /* renamed from: m */
    private C0306c f580m;

    /* renamed from: com.baidu.mobads.h.g$a */
    public static final class C0304a extends Exception {
        public C0304a(String str) {
            C0338m.m569a().mo5033f().mo4926e(str);
        }
    }

    /* renamed from: com.baidu.mobads.h.g$b */
    protected static final class C0305b extends Exception {
        public C0305b(String str) {
            C0338m.m569a().mo5033f().mo4926e(str);
        }
    }

    /* renamed from: com.baidu.mobads.h.g$c */
    public interface C0306c {
        /* renamed from: a */
        void mo4502a(boolean z);
    }

    public C0307g(Context context) {
        if (f572h == null) {
            f572h = "http://mobads.baidu.com/ads/pa/" + C0239b.m289b() + "/__pasys_remote_banner.php";
        }
        this.f578k = context;
        this.f573d = context.getDir("baidu_ad_sdk", 0).getAbsolutePath() + "/";
        if (f568a == null) {
            f568a = C0318q.m476a(context);
            C0318q.m476a(context).mo4524a(new C0311j(this));
        }
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof C0318q)) {
            Thread.setDefaultUncaughtExceptionHandler(f568a);
        }
    }

    /* renamed from: a */
    private IXAdContainerFactory m437a(C0296a c0296a) {
        IXAdContainerFactory iXAdContainerFactory = null;
        if (c0296a == null) {
            return iXAdContainerFactory;
        }
        try {
            return c0296a.mo4479a();
        } catch (Exception e) {
            return iXAdContainerFactory;
        }
    }

    /* renamed from: a */
    private void m439a(C0298b c0298b) {
        Class b = c0298b.mo4484b();
        synchronized (this) {
            f570c = new C0296a(b, this.f578k, C0239b.m288a(), C0239b.f385a);
        }
    }

    /* renamed from: a */
    private void m440a(C0302e c0302e) {
        if (c0302e.mo4490a().booleanValue()) {
            C0299c a = C0299c.m416a(this.f578k, c0302e, this.f573d, this.f575g);
            if (a.isAlive()) {
                this.f579l.mo4922d("XAdApkLoader", "XApkDownloadThread already started");
                a.mo4486a(c0302e.mo4492c());
                return;
            }
            this.f579l.mo4922d("XAdApkLoader", "XApkDownloadThread starting ...");
            a.start();
        }
    }

    /* renamed from: a */
    private void m444a(boolean z) {
        Message obtainMessage = this.f574f.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", z);
        obtainMessage.setData(bundle);
        obtainMessage.what = 0;
        this.f574f.sendMessage(obtainMessage);
    }

    /* renamed from: a */
    private void m445a(boolean z, String str) {
        if (this.f580m != null) {
            this.f580m.mo4502a(z);
        }
    }

    /* renamed from: b */
    private void m447b(C0298b c0298b) {
        new StringBuilder("len=").append(c0298b.length()).append(", path=").append(c0298b.getAbsolutePath());
        if (f569b == null) {
            f569b = new C0296a(c0298b.mo4484b(), this.f578k, C0239b.m288a(), C0239b.f385a);
            try {
                this.f579l.mo4922d("XAdApkLoader", "preloaded apk.version=" + f569b.mo4479a().getRemoteVersion());
                return;
            } catch (C0304a e) {
                this.f579l.mo4939w("XAdApkLoader", "preload local apk " + c0298b.getAbsolutePath() + " failed, msg:" + e.getMessage() + ", v=" + f569b.f537a);
                mo4506a(e.getMessage());
                throw e;
            }
        }
        this.f579l.mo4939w("XAdApkLoader", "mApkBuilder already initialized, version: " + f569b.f537a);
    }

    /* renamed from: b */
    private void m448b(C0306c c0306c, Handler handler) {
        this.f580m = c0306c;
        this.f574f = handler;
        if (f569b == null) {
            mo4511f();
        } else {
            m451b(true);
        }
    }

    /* renamed from: b */
    private void m451b(boolean z) {
        m445a(z, z ? "apk Successfully Loaded" : "apk Load Failed");
        new Handler(Looper.getMainLooper()).postDelayed(new C0312k(this, z), 5000);
    }

    /* renamed from: c */
    private void m452c(C0298b c0298b) {
        synchronized (this) {
            m447b(c0298b);
            this.f579l.mo4922d("XAdApkLoader", "loaded: " + c0298b.getPath());
            m451b(true);
        }
    }

    /* renamed from: j */
    private SharedPreferences m458j() {
        return this.f578k.getSharedPreferences("com.baidu.mobads.loader", 0);
    }

    /* renamed from: k */
    private boolean m459k() {
        String string = m458j().getString("previousProxyVersion", null);
        return string == null || !string.equals(mo4503a());
    }

    /* renamed from: l */
    private synchronized void m460l() {
        try {
            if (this.f576i != null) {
                this.f576i.removeAllListeners();
                this.f576i.mo5114a();
            }
            this.f576i = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    /* renamed from: a */
    public final String mo4503a() {
        return "8.25";
    }

    /* renamed from: a */
    public void mo4504a(C0306c c0306c) {
        mo4505a(c0306c, f571e);
    }

    @TargetApi(9)
    /* renamed from: a */
    public void mo4505a(C0306c c0306c, Handler handler) {
        new Thread(new C0315n(this, c0306c, handler)).start();
    }

    @TargetApi(9)
    /* renamed from: a */
    protected void mo4506a(String str) {
        if (f569b != null) {
            Editor edit = m458j().edit();
            edit.putFloat("__badApkVersion__8.25", (float) f569b.f537a);
            if (VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }

    /* renamed from: b */
    protected void mo4507b() {
        new File(mo4510e()).delete();
    }

    /* renamed from: c */
    protected String mo4508c() {
        return this.f573d + "__xadsdk__remote__final__builtin__.jar";
    }

    /* renamed from: d */
    protected void mo4509d() {
        String c = mo4508c();
        C0298b c0298b = new C0298b(c, this.f578k);
        try {
            C0338m.m569a().mo5038k().copyFileFromAssetsTo(this.f578k, "__xadsdk__remote__final__.jar", c);
            if (c0298b.exists() && c0298b.canRead()) {
                m452c(c0298b);
                return;
            }
            throw new C0305b("loadBuiltInApk failed: " + c);
        } catch (IOException e) {
            throw new C0305b("loadBuiltInApk failed: " + e.toString());
        }
    }

    /* renamed from: e */
    protected String mo4510e() {
        return this.f573d + "__xadsdk__remote__final__downloaded__.jar";
    }

    /* renamed from: f */
    protected void mo4511f() {
        C0298b c0298b = new C0298b(mo4510e(), this.f578k);
        Boolean valueOf = Boolean.valueOf(c0298b.exists());
        Boolean valueOf2 = Boolean.valueOf(c0298b.canRead());
        long length = c0298b.length();
        if (valueOf.booleanValue() && valueOf2.booleanValue() && length > 0) {
            try {
                if (Boolean.valueOf(m459k()).booleanValue()) {
                    throw new C0304a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
                }
                synchronized (this) {
                    new StringBuilder("loadDownloadedOrBuiltInApk len=").append(c0298b.length()).append(", path=").append(c0298b.getAbsolutePath());
                    m447b(c0298b);
                    double d = (double) m458j().getFloat("__badApkVersion__8.25", -1.0f);
                    this.f579l.mo4922d("XAdApkLoader", "downloadedApkFile.getApkVersion(): " + c0298b.mo4485c() + ", badApkVersion: " + d);
                    if (c0298b.mo4485c() == d) {
                        throw new C0304a("downloaded file marked bad, drop it and use built-in");
                    }
                    this.f579l.mo4922d("XAdApkLoader", "loaded: " + c0298b.getPath());
                    m451b(true);
                }
                return;
            } catch (C0304a e) {
                this.f579l.mo4929e("XAdApkLoader", "load downloaded apk failed: " + e.toString() + ", fallback to built-in");
                if (c0298b.exists()) {
                    c0298b.delete();
                }
                mo4513h();
                try {
                    mo4509d();
                    return;
                } catch (C0305b e2) {
                    throw new C0304a("load built-in apk also failed" + e2.toString());
                }
            }
        }
        this.f579l.mo4922d("XAdApkLoader", "no downloaded file yet, use built-in apk file");
        try {
            mo4509d();
        } catch (C0305b e22) {
            this.f579l.mo4929e("XAdApkLoader", "loadBuiltInApk failed: " + e22.toString());
            throw new C0304a("load built-in apk failed" + e22.toString());
        }
    }

    /* renamed from: g */
    public IXAdContainerFactory mo4512g() {
        return m437a(f569b);
    }

    /* renamed from: h */
    protected void mo4513h() {
        if (f569b != null) {
            f569b.mo4480b();
            f569b = null;
        }
    }
}
