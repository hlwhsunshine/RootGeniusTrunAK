package com.shuame.reportsdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.shuame.reportsdk.c */
final class C1237c extends Handler {
    C1237c(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                ReportSdk.m3508b((C1103b) message.obj);
                return;
            case 2:
                ReportSdk.m3500a();
                return;
            case 3:
                ReportSdk.m3507b();
                return;
            case 4:
                ReportSdk.m3500a();
                ReportSdk.f3283h.sendEmptyMessageDelayed(4, 300000);
                return;
            default:
                return;
        }
    }
}
