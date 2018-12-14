package com.shuame.rootgenius.common.p101b;

import android.os.Handler;
import android.os.Looper;
import com.shuame.rootgenius.common.manager.AppManager.C1348b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.tencent.xuanfeng.libInterface.LinkStruct;
import java.util.ArrayList;

/* renamed from: com.shuame.rootgenius.common.b.b */
public class C1321b implements C1320a {
    /* renamed from: a */
    private static final String f3574a = C1321b.class.getSimpleName();
    /* renamed from: b */
    private static C1321b f3575b = new C1321b();
    /* renamed from: c */
    private ArrayList<C1320a> f3576c = new ArrayList();
    /* renamed from: d */
    private Handler f3577d = new C1322c(this, Looper.getMainLooper());

    private C1321b() {
    }

    /* renamed from: a */
    public static C1321b m3685a() {
        if (f3575b == null) {
            synchronized (C1321b.class) {
                f3575b = new C1321b();
            }
        }
        return f3575b;
    }

    /* renamed from: a */
    public final void mo6990a(C1320a c1320a) {
        if (c1320a != null && !this.f3576c.contains(c1320a)) {
            this.f3576c.add(c1320a);
        }
    }

    /* renamed from: b */
    public final void mo6991b(C1320a c1320a) {
        this.f3576c.remove(c1320a);
    }

    public void onComplete(int i, long j) {
        new StringBuilder("onComplete   taskId:").append(i).append("; resultCode:").append(j);
        this.f3577d.sendEmptyMessage((int) j);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.f3576c.size()) {
                ((C1320a) this.f3576c.get(i3)).onComplete(i, j);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void onDonwloadInfo(int i, LinkStruct[] linkStructArr) {
    }

    public void onFileName(int i, String str) {
    }

    public void onOnlySrcUrl(int i) {
    }

    public void onStatusChanged(int i, Status status) {
        new StringBuilder("onStatusChanged   taskId:").append(i).append("; status:").append(status);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.f3576c.size()) {
                ((C1320a) this.f3576c.get(i3)).onStatusChanged(i, status);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void onStatusChanged(C1348b c1348b) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f3576c.size()) {
                ((C1320a) this.f3576c.get(i2)).onStatusChanged(c1348b);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void onStorageErrorInfo(int i, int i2, String str) {
    }

    public void onTaskInfo(int i, int i2, int i3) {
        new StringBuilder("onTaskInfo:   taskId:").append(i).append("; thousandth:").append(i2).append("; speed:").append(i3);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < this.f3576c.size()) {
                ((C1320a) this.f3576c.get(i5)).onTaskInfo(i, i2, i3);
                i4 = i5 + 1;
            } else {
                return;
            }
        }
    }

    public void onWaitStart(int i) {
    }
}
