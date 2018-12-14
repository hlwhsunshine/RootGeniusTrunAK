package com.baidu.mobads.openad.p029c;

import android.content.Context;
import com.baidu.mobads.command.C0271a;
import com.baidu.mobads.interfaces.download.IXAdStaticImgDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import com.baidu.mobads.openad.p024a.C0351b;
import com.baidu.mobads.openad.p024a.C0352c;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p030d.C0276a;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.baidu.mobads.openad.c.d */
public class C0361d implements IOAdDownloaderManager {
    /* renamed from: b */
    private static C0361d f768b = null;
    /* renamed from: a */
    protected Context f769a;
    /* renamed from: c */
    private HashMap<String, IOAdDownloader> f770c = new HashMap();
    /* renamed from: d */
    private C0352c f771d;
    /* renamed from: e */
    private AtomicBoolean f772e = new AtomicBoolean(false);

    protected C0361d(Context context) {
        this.f769a = context;
    }

    /* renamed from: a */
    public static C0361d m637a(Context context) {
        if (f768b == null) {
            f768b = new C0361d(context);
        }
        return f768b;
    }

    /* renamed from: a */
    public void mo5095a(String str, IOAdDownloader iOAdDownloader) {
        synchronized (this.f770c) {
            this.f770c.put(str, iOAdDownloader);
        }
    }

    public synchronized IOAdDownloader createAdsApkDownloader(URL url, String str, String str2, int i, String str3, String str4) {
        IOAdDownloader c0358a;
        c0358a = new C0358a(this.f769a, url, str, str2, i, str3, str4);
        mo5095a(str4, c0358a);
        try {
            if (this.f771d == null) {
                this.f771d = new C0352c(this.f769a);
                this.f771d.mo5063a(new C0351b(this.f771d));
                this.f771d.addEventListener("network_changed", new C0362e(this));
                this.f771d.mo5062a();
            }
        } catch (Throwable e) {
            C0338m.m569a().mo5033f().mo4923d("OAdDownloadManager", e);
        }
        return c0358a;
    }

    public IXAdStaticImgDownloader createImgHttpDownloader(URL url, String str, String str2) {
        return new C0276a(this.f769a, url, str, str2);
    }

    public IOAdDownloader createSimpleFileDownloader(URL url, String str, String str2, boolean z) {
        return new C0275f(this.f769a, url, str, str2, z);
    }

    public IOAdDownloader getAdsApkDownloader(String str) {
        IOAdDownloader iOAdDownloader;
        synchronized (this.f770c) {
            iOAdDownloader = (IOAdDownloader) this.f770c.get(str);
        }
        return iOAdDownloader;
    }

    public ArrayList<IOAdDownloader> getAllAdsApkDownloaderes() {
        ArrayList<IOAdDownloader> arrayList = null;
        synchronized (this.f770c) {
            Collection<IOAdDownloader> values = this.f770c.values();
            if (values.size() > 0) {
                ArrayList<IOAdDownloader> arrayList2 = new ArrayList();
                for (IOAdDownloader add : values) {
                    arrayList2.add(add);
                }
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    public Boolean removeAdsApkDownloader(String str) {
        synchronized (this.f770c) {
            this.f770c.remove(str);
        }
        return Boolean.valueOf(true);
    }

    public void removeAllAdsApkDownloaderes() {
        synchronized (this.f770c) {
            this.f770c.clear();
        }
    }

    public void resumeUndownloadedAfterRestartApp(long j) {
        if (!this.f772e.getAndSet(true)) {
            List a = C0271a.m360a(this.f769a, j);
            if (a != null && a.size() > 0) {
                int i = 0;
                while (true) {
                    try {
                        int i2 = i;
                        if (i2 < a.size()) {
                            String str = (String) a.get(i2);
                            if (C0359b.m626a(str) == null && getAdsApkDownloader(str) == null) {
                                C0271a a2 = C0271a.m359a(this.f769a, str);
                                if (a2 == null) {
                                    C0338m.m569a().mo5033f().mo4922d("OAdDownloadManager", "pack[" + str + "] has no local data, continue");
                                } else {
                                    IOAdDownloader createAdsApkDownloader = createAdsApkDownloader(new URL(a2.f473j), a2.f466c, a2.f465b, 1, a2.f464a, a2.f472i);
                                    createAdsApkDownloader.addObserver(new C0359b(this.f769a, a2));
                                    createAdsApkDownloader.start();
                                }
                            } else {
                                C0338m.m569a().mo5033f().mo4922d("OAdDownloadManager", "pack[" + str + "] has been stated before, continue");
                            }
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    } catch (Throwable e) {
                        C0338m.m569a().mo5033f().mo4923d("OAdDownloadManager", e);
                        return;
                    }
                }
            }
        }
    }
}
