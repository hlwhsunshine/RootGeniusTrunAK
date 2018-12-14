package com.baidu.mobads.openad.p029c;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.mobads.command.C0271a;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p025c.C0265a;
import java.util.List;

/* renamed from: com.baidu.mobads.openad.c.e */
class C0362e implements IOAdEventListener {
    /* renamed from: a */
    final /* synthetic */ C0361d f773a;

    C0362e(C0361d c0361d) {
        this.f773a = c0361d;
    }

    public void run(IOAdEvent iOAdEvent) {
        try {
            C0338m.m569a().mo5033f().mo4922d("OAdDownloadManager", "网络状态已经改变");
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f773a.f769a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                C0338m.m569a().mo5033f().mo4922d("OAdDownloadManager", "没有可用网络");
                return;
            }
            String typeName = activeNetworkInfo.getTypeName();
            int type = activeNetworkInfo.getType();
            C0338m.m569a().mo5033f().mo4922d("OAdDownloadManager", "当前网络名称：" + typeName + "; 网络类型：" + type);
            List<IOAdDownloader> allAdsApkDownloaderes = this.f773a.getAllAdsApkDownloaderes();
            if (allAdsApkDownloaderes != null) {
                for (IOAdDownloader iOAdDownloader : allAdsApkDownloaderes) {
                    if (type == 1) {
                        if (iOAdDownloader.getState() == DownloadStatus.ERROR || iOAdDownloader.getState() == DownloadStatus.PAUSED) {
                            try {
                                iOAdDownloader.resume();
                            } catch (Throwable e) {
                                C0338m.m569a().mo5033f().mo4923d("OAdDownloadManager", e);
                            }
                        }
                    } else if (type == 0) {
                        C0338m.m569a().mo5033f().mo4922d("OAdDownloadManager", "mobile net work");
                        C0359b a = C0359b.m626a(iOAdDownloader.getPackageName());
                        if (a != null) {
                            C0271a a2 = a.mo5083a();
                            if (a2 == null) {
                                continue;
                            } else if (!a2.f481r) {
                                try {
                                    iOAdDownloader.pause();
                                } catch (Throwable e2) {
                                    C0338m.m569a().mo5033f().mo4923d("OAdDownloadManager", e2);
                                }
                            } else if (iOAdDownloader.getState() == DownloadStatus.ERROR || iOAdDownloader.getState() == DownloadStatus.PAUSED) {
                                try {
                                    iOAdDownloader.resume();
                                } catch (Throwable e22) {
                                    C0338m.m569a().mo5033f().mo4923d("OAdDownloadManager", e22);
                                }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (Throwable e222) {
            C0338m.m569a().mo5033f().mo4923d("OAdDownloadManager", e222);
            C0265a.m334a().mo4397a("create apk downloader failed: " + e222.toString());
        }
    }
}
