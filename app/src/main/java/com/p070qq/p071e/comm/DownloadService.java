package com.p070qq.p071e.comm;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.p070qq.p071e.comm.managers.GDTADManager;
import com.p070qq.p071e.comm.p073pi.SVSD;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.StringUtil;

/* renamed from: com.qq.e.comm.DownloadService */
public class DownloadService extends Service {
    /* renamed from: a */
    private SVSD f2759a;

    /* renamed from: a */
    private boolean m3065a(String str) {
        if (this.f2759a == null) {
            try {
                if (GDTADManager.getInstance().initWith(getApplicationContext(), str)) {
                    this.f2759a = GDTADManager.getInstance().getPM().getPOFactory().getAPKDownloadServiceDelegate(this);
                    this.f2759a.onCreate();
                } else {
                    GDTLogger.report("Init GDTADManager fail in DownloadService.oncreate");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this.f2759a != null;
    }

    public IBinder onBind(Intent intent) {
        GDTLogger.m3130d("DownloadService.onBind");
        if (this.f2759a != null) {
            return this.f2759a.onBind(intent);
        }
        String stringExtra = intent.getStringExtra("GDT_APPID");
        GDTLogger.m3130d("DownloadService.onBind,appID=" + stringExtra);
        return (StringUtil.isEmpty(stringExtra) || !m3065a(stringExtra)) ? null : this.f2759a.onBind(intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.f2759a != null) {
            this.f2759a.onConfigurationChanged(configuration);
        }
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        if (this.f2759a != null) {
            this.f2759a.onDestroy();
        }
    }

    public void onLowMemory() {
        if (this.f2759a != null) {
            this.f2759a.onLowMemory();
        }
    }

    public void onRebind(Intent intent) {
        if (this.f2759a != null) {
            this.f2759a.onRebind(intent);
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            stopSelf(i2);
            return 2;
        }
        String stringExtra = intent.getStringExtra("GDT_APPID");
        if (!StringUtil.isEmpty(stringExtra) && m3065a(stringExtra)) {
            return this.f2759a.onStartCommand(intent, i, i2);
        }
        GDTLogger.m3134w("Failto Start new download Service");
        return 2;
    }

    public void onTaskRemoved(Intent intent) {
        if (this.f2759a != null) {
            this.f2759a.onTaskRemoved(intent);
        }
    }

    public void onTrimMemory(int i) {
        if (this.f2759a != null) {
            this.f2759a.onTrimMemory(i);
        }
    }

    public boolean onUnbind(Intent intent) {
        return this.f2759a != null ? this.f2759a.onUnbind(intent) : super.onUnbind(intent);
    }
}
