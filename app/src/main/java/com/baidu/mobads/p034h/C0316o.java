package com.baidu.mobads.p034h;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build.VERSION;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.p021j.C0338m;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/* renamed from: com.baidu.mobads.h.o */
public class C0316o implements Observer {
    /* renamed from: a */
    private Context f591a;
    /* renamed from: b */
    private URL f592b = null;
    /* renamed from: c */
    private String f593c = null;
    /* renamed from: d */
    private final C0302e f594d;
    /* renamed from: e */
    private C0300a f595e;
    /* renamed from: f */
    private SharedPreferences f596f;
    /* renamed from: g */
    private OnSharedPreferenceChangeListener f597g = new C0317p(this);

    /* renamed from: com.baidu.mobads.h.o$a */
    public interface C0300a {
        /* renamed from: a */
        void mo4488a(C0302e c0302e);

        /* renamed from: b */
        void mo4489b(C0302e c0302e);
    }

    public C0316o(Context context, String str, C0302e c0302e, C0300a c0300a) {
        this.f593c = str;
        this.f594d = c0302e;
        m474a(context, c0300a);
    }

    public C0316o(Context context, URL url, C0302e c0302e, C0300a c0300a) {
        this.f592b = url;
        this.f594d = c0302e;
        m474a(context, c0300a);
    }

    /* renamed from: a */
    private void m474a(Context context, C0300a c0300a) {
        this.f591a = context;
        this.f595e = c0300a;
        this.f596f = this.f591a.getSharedPreferences("__xadsdk_downloaded__version__", 0);
        this.f596f.registerOnSharedPreferenceChangeListener(this.f597g);
    }

    /* renamed from: a */
    public void mo4520a(String str, String str2) {
        IOAdDownloader createSimpleFileDownloader = C0338m.m569a().mo5029b(this.f591a).createSimpleFileDownloader(this.f593c != null ? new URL(this.f593c) : this.f592b, str, str2, false);
        createSimpleFileDownloader.addObserver(this);
        createSimpleFileDownloader.start();
        Editor edit = this.f596f.edit();
        edit.putString("version", this.f594d.toString());
        if (VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    public void update(Observable observable, Object obj) {
        IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
        if (iOAdDownloader.getState() == DownloadStatus.COMPLETED) {
            this.f595e.mo4488a(new C0302e(this.f594d, iOAdDownloader.getOutputPath(), Boolean.valueOf(true)));
        }
        if (iOAdDownloader.getState() == DownloadStatus.ERROR) {
            this.f595e.mo4489b(new C0302e(this.f594d, iOAdDownloader.getOutputPath(), Boolean.valueOf(false)));
        }
    }
}
