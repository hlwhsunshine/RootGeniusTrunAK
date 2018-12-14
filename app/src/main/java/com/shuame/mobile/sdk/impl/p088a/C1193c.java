package com.shuame.mobile.sdk.impl.p088a;

import com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode;
import com.shuame.mobile.sdk.impl.utils.http.OnDownloadListener;
import java.io.File;
import java.util.Map;

/* renamed from: com.shuame.mobile.sdk.impl.a.c */
class C1193c implements OnDownloadListener {
    /* renamed from: a */
    final /* synthetic */ C1192b f3182a;
    /* renamed from: b */
    private final /* synthetic */ String f3183b;

    C1193c(C1192b c1192b, String str) {
        this.f3182a = c1192b;
        this.f3183b = str;
    }

    public void onComplete(int i, int i2, Map<String, Object> map) {
        this.f3182a.f3181f = i2;
        if (i2 == DownloadResultCode.f3242OK) {
            this.f3182a.f3176a = 0;
        } else if (i2 == DownloadResultCode.ERROR_MD5) {
            new File(this.f3183b).delete();
        }
        this.f3182a.f3180e = true;
        synchronized (this.f3182a.f3179d) {
            this.f3182a.f3179d.notify();
        }
    }

    public void onTaskInfo(int i, int i2, int i3) {
        if (this.f3182a.f3178c < i2) {
            this.f3182a.f3178c = i2;
            synchronized (this.f3182a.f3179d) {
                this.f3182a.f3179d.notify();
            }
        }
    }
}
