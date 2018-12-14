package com.shuame.rootgenius.p115ui;

import android.os.Handler.Callback;
import android.os.Message;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;

/* renamed from: com.shuame.rootgenius.ui.ai */
final class C1531ai implements Callback {
    /* renamed from: a */
    final /* synthetic */ ShuameGuideActivity f4348a;

    C1531ai(ShuameGuideActivity shuameGuideActivity) {
        this.f4348a = shuameGuideActivity;
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ShuameGuideActivity.m4268a(this.f4348a, message);
                break;
            case 3:
                this.f4348a.m4266a((Status) message.obj);
                break;
            case 4:
                ShuameGuideActivity.m4276c(this.f4348a, message);
                break;
        }
        return false;
    }
}
