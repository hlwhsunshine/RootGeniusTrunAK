package com.shuame.rootgenius.p115ui.adapter;

import android.os.Message;
import com.shuame.rootgenius.common.manager.AppManager.C1348b;
import com.shuame.rootgenius.common.p101b.C1320a;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.tencent.xuanfeng.libInterface.LinkStruct;

/* renamed from: com.shuame.rootgenius.ui.adapter.d */
final class C1511d implements C1320a {
    /* renamed from: a */
    final /* synthetic */ C1509b f4306a;

    C1511d(C1509b c1509b) {
        this.f4306a = c1509b;
    }

    public final void onComplete(int i, long j) {
        C1509b.f4295a;
        new StringBuilder("onComplete taskId:").append(i).append(";resultCode:").append(j);
    }

    public final void onDonwloadInfo(int i, LinkStruct[] linkStructArr) {
    }

    public final void onFileName(int i, String str) {
    }

    public final void onOnlySrcUrl(int i) {
    }

    public final void onStatusChanged(int i, Status status) {
        if (this.f4306a.f4299e.containsKey(Integer.valueOf(i))) {
            C1509b.f4295a;
            new StringBuilder("onStatusChanged taskId:").append(i).append(";status:").append(status);
            Message obtainMessage = this.f4306a.f4303i.obtainMessage();
            obtainMessage.what = 3;
            obtainMessage.arg1 = i;
            obtainMessage.obj = status;
            this.f4306a.f4303i.sendMessage(obtainMessage);
        }
    }

    public final void onStatusChanged(C1348b c1348b) {
        if (this.f4306a.f4299e.containsKey(Integer.valueOf(c1348b.f3676a))) {
            C1348b c1348b2 = new C1348b();
            c1348b2.f3679d = c1348b.f3679d;
            c1348b2.f3683h = c1348b.f3683h;
            c1348b2.f3676a = c1348b.f3676a;
            c1348b2.f3678c = c1348b.f3678c;
            Message obtainMessage = this.f4306a.f4303i.obtainMessage();
            obtainMessage.arg1 = c1348b.f3676a;
            obtainMessage.obj = c1348b2;
            obtainMessage.what = 4;
            this.f4306a.f4303i.sendMessage(obtainMessage);
        }
    }

    public final void onStorageErrorInfo(int i, int i2, String str) {
        C1509b.f4295a;
    }

    public final void onTaskInfo(int i, int i2, int i3) {
        if (this.f4306a.f4299e.containsKey(Integer.valueOf(i))) {
            C1509b.f4295a;
            new StringBuilder("onTaskInfo taskId:").append(i).append(";thousandth:").append(i2).append(";speed:").append(i3);
            Message obtainMessage = this.f4306a.f4303i.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.arg1 = i;
            obtainMessage.arg2 = i2;
            obtainMessage.obj = Integer.valueOf(i3);
            this.f4306a.f4303i.sendMessage(obtainMessage);
        }
    }

    public final void onWaitStart(int i) {
    }
}
