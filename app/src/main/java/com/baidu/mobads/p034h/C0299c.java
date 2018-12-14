package com.baidu.mobads.p034h;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p034h.C0307g.C0304a;
import com.baidu.mobads.p034h.C0316o.C0300a;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/* renamed from: com.baidu.mobads.h.c */
public class C0299c extends Thread {
    /* renamed from: f */
    private static volatile C0299c f549f;
    /* renamed from: a */
    C0300a f550a = new C0301d(this);
    /* renamed from: b */
    private volatile String f551b;
    /* renamed from: c */
    private String f552c = null;
    /* renamed from: d */
    private double f553d;
    /* renamed from: e */
    private Handler f554e;
    /* renamed from: g */
    private final Context f555g;
    /* renamed from: h */
    private C0316o f556h = null;
    /* renamed from: i */
    private final C0302e f557i;
    /* renamed from: j */
    private IXAdLogger f558j = C0338m.m569a().mo5033f();

    private C0299c(Context context, C0302e c0302e, String str, Handler handler) {
        this.f555g = context;
        this.f557i = c0302e;
        mo4486a(c0302e.mo4492c());
        this.f554e = handler;
        this.f552c = str;
    }

    /* renamed from: a */
    public static C0299c m416a(Context context, C0302e c0302e, String str, Handler handler) {
        if (f549f == null) {
            f549f = new C0299c(context, c0302e, str, handler);
        }
        return f549f;
    }

    /* renamed from: a */
    private String m418a() {
        String str = "__xadsdk__remote__final__" + UUID.randomUUID().toString() + ".jar";
        String str2 = this.f552c + str;
        File file = new File(str2);
        try {
            file.createNewFile();
            this.f556h.mo4520a(this.f552c, str);
            return str2;
        } catch (IOException e) {
            file.delete();
            throw e;
        }
    }

    /* renamed from: a */
    private void m420a(String str, C0302e c0302e, String str2) {
        if (str.equals("OK") || str.equals("ERROR")) {
            Message obtainMessage = this.f554e.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable("APK_INFO", c0302e);
            bundle.putString("CODE", str);
            obtainMessage.setData(bundle);
            this.f554e.sendMessage(obtainMessage);
        }
    }

    /* renamed from: b */
    private boolean m421b() {
        double d;
        try {
            this.f556h = new C0316o(this.f555g, new URL(this.f551b), this.f557i, this.f550a);
        } catch (MalformedURLException e) {
            try {
                this.f556h = new C0316o(this.f555g, this.f551b, this.f557i, this.f550a);
            } catch (Exception e2) {
                String str = "parse apk failed, error:" + e2.toString();
                this.f558j.mo4929e("XAdApkDownloadThread", str);
                throw new C0304a(str);
            }
        }
        if (C0307g.f570c != null) {
            d = C0307g.f570c.f537a;
        } else if (C0307g.f569b != null) {
            C0296a c0296a = C0307g.f569b;
            d = C0307g.f569b.f537a;
        } else {
            d = 0.0d;
        }
        this.f558j.mo4922d("XAdApkDownloadThread", "isNewApkAvailable: local apk version is: " + d + ", remote apk version: " + this.f557i.mo4491b());
        if (d > 0.0d) {
            if (this.f557i.mo4491b() > 0.0d) {
                this.f558j.mo4929e("XAdApkDownloadThread", "remote not null, local apk version is null, force upgrade");
                this.f553d = this.f557i.mo4491b();
                return true;
            }
            this.f558j.mo4929e("XAdApkDownloadThread", "remote is null, local apk version is null, do not upgrade");
            return false;
        } else if (this.f557i.mo4491b() <= 0.0d) {
            this.f558j.mo4929e("XAdApkDownloadThread", "remote apk version is: null, local apk version is: " + d + ", do not upgrade");
            return false;
        } else if (this.f557i.mo4491b() <= d) {
            return false;
        } else {
            this.f553d = this.f557i.mo4491b();
            return true;
        }
    }

    /* renamed from: a */
    public void mo4486a(String str) {
        this.f551b = str;
        interrupt();
    }

    public void run() {
        try {
            if (m421b()) {
                m418a();
                this.f558j.mo4922d("XAdApkDownloadThread", "download apk successfully, downloader exit");
                f549f = null;
                this.f558j.mo4922d("XAdApkDownloadThread", "no newer apk, downloader exit");
                f549f = null;
            }
        } catch (IOException e) {
            this.f558j.mo4929e("XAdApkDownloadThread", "create File or HTTP Get failed, exception: " + e.getMessage());
        } catch (Throwable th) {
        }
    }
}
