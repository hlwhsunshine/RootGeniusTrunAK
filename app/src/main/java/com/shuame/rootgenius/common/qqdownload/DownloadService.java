package com.shuame.rootgenius.common.qqdownload;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;
import com.tencent.xuanfeng.libInterface.LinkStruct;

public class DownloadService extends Service {
    /* renamed from: b */
    private static Context f3715b;
    /* renamed from: a */
    private C1358a f3716a;

    /* renamed from: com.shuame.rootgenius.common.qqdownload.DownloadService$a */
    public class C1358a implements C1319h {
        public final void onComplete(int i, long j) {
            QQDownloadFile a = C1361b.m3817a().mo7068a(i);
            if (a == null) {
                return;
            }
            if ((a.f3734o != Type.ROM && a.f3734o != Type.APK) || j == 1) {
                return;
            }
            if (j == 0) {
                if (a.f3734o == Type.ROM || a.f3734o != Type.APK) {
                }
            } else if (a.f3734o != Type.ROM) {
                Type type = Type.APK;
            }
        }

        public final void onDonwloadInfo(int i, LinkStruct[] linkStructArr) {
        }

        public final void onFileName(int i, String str) {
        }

        public final void onOnlySrcUrl(int i) {
        }

        public final void onStatusChanged(int i, Status status) {
        }

        public final void onStorageErrorInfo(int i, int i2, String str) {
        }

        public final void onTaskInfo(int i, int i2, int i3) {
            QQDownloadFile a = C1361b.m3817a().mo7068a(i);
            if (a == null) {
                return;
            }
            if (a.f3734o != Type.ROM && a.f3734o != Type.APK) {
                return;
            }
            if (i2 != 0 || i3 != 0) {
                if (a.f3729j <= 0 || i3 != 0) {
                    a.f3728i = i2;
                    a.f3729j = i3;
                } else {
                    a.f3729j = i3;
                }
                DownloadService.m3800a(a);
            }
        }

        public final void onWaitStart(int i) {
        }
    }

    /* renamed from: a */
    public static void m3800a(QQDownloadFile qQDownloadFile) {
        if (qQDownloadFile != null && qQDownloadFile.f3734o != Type.APK) {
            Type type = Type.ROM;
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        f3715b = this;
        this.f3716a = new C1358a();
        C1361b.m3817a().mo7071a(this.f3716a);
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            QQDownloadFile a = C1361b.m3817a().mo7068a(intent.getIntExtra("roms_key", -1));
            new StringBuilder("sendNotification dFile:").append(a);
            if (a != null && (a.f3734o == Type.ROM || a.f3734o == Type.APK)) {
                m3800a(a);
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
