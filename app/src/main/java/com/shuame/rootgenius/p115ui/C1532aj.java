package com.shuame.rootgenius.p115ui;

import android.os.Message;
import com.shuame.rootgenius.common.manager.AppManager.C1348b;
import com.shuame.rootgenius.common.p101b.C1320a;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.tencent.xuanfeng.libInterface.LinkStruct;

/* renamed from: com.shuame.rootgenius.ui.aj */
final class C1532aj implements C1320a {
    /* renamed from: a */
    final /* synthetic */ ShuameGuideActivity f4349a;

    C1532aj(ShuameGuideActivity shuameGuideActivity) {
        this.f4349a = shuameGuideActivity;
    }

    public final void onComplete(int i, long j) {
        if (i == this.f4349a.f4239k.mo7245a()) {
            ShuameGuideActivity.f4229a;
            new StringBuilder("onComplete taskId:").append(i).append(";resultCode:").append(j);
        }
    }

    public final void onDonwloadInfo(int i, LinkStruct[] linkStructArr) {
    }

    public final void onFileName(int i, String str) {
    }

    public final void onOnlySrcUrl(int i) {
    }

    public final void onStatusChanged(int i, Status status) {
        if (i == this.f4349a.f4239k.mo7245a()) {
            ShuameGuideActivity.f4229a;
            new StringBuilder("onStatusChanged taskId:").append(i).append(";status:").append(status);
            Message obtainMessage = this.f4349a.f4240l.obtainMessage();
            obtainMessage.what = 3;
            obtainMessage.arg1 = i;
            obtainMessage.obj = status;
            this.f4349a.f4240l.sendMessage(obtainMessage);
        }
    }

    public final void onStatusChanged(C1348b c1348b) {
        if (c1348b.f3676a == this.f4349a.f4239k.mo7245a()) {
            C1348b c1348b2 = new C1348b();
            c1348b2.f3679d = c1348b.f3679d;
            c1348b2.f3683h = c1348b.f3683h;
            c1348b2.f3676a = c1348b.f3676a;
            c1348b2.f3678c = c1348b.f3678c;
            Message obtainMessage = this.f4349a.f4240l.obtainMessage();
            obtainMessage.obj = c1348b2;
            obtainMessage.what = 4;
            this.f4349a.f4240l.sendMessage(obtainMessage);
        }
    }

    public final void onStorageErrorInfo(int i, int i2, String str) {
        if (i == this.f4349a.f4239k.mo7245a()) {
            ShuameGuideActivity.f4229a;
        }
    }

    public final void onTaskInfo(int i, int i2, int i3) {
        if (i == this.f4349a.f4239k.mo7245a()) {
            ShuameGuideActivity.f4229a;
            new StringBuilder("onTaskInfo taskId:").append(i).append(";thousandth:").append(i2).append(";speed:").append(i3);
            Message obtainMessage = this.f4349a.f4240l.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.arg1 = i;
            obtainMessage.arg2 = i2;
            obtainMessage.obj = Integer.valueOf(i3);
            this.f4349a.f4240l.sendMessage(obtainMessage);
        }
    }

    public final void onWaitStart(int i) {
    }
}
