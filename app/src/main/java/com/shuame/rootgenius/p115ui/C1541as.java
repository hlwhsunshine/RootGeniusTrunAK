package com.shuame.rootgenius.p115ui;

import android.os.Message;
import com.shuame.rootgenius.common.manager.AppManager.C1348b;
import com.shuame.rootgenius.common.p101b.C1320a;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.tencent.xuanfeng.libInterface.LinkStruct;

/* renamed from: com.shuame.rootgenius.ui.as */
final class C1541as implements C1320a {
    /* renamed from: a */
    final /* synthetic */ UpdateActivity f4359a;

    C1541as(UpdateActivity updateActivity) {
        this.f4359a = updateActivity;
    }

    public final void onComplete(int i, long j) {
    }

    public final void onDonwloadInfo(int i, LinkStruct[] linkStructArr) {
    }

    public final void onFileName(int i, String str) {
    }

    public final void onOnlySrcUrl(int i) {
    }

    public final void onStatusChanged(int i, Status status) {
        if (i == C1361b.m3815a(this.f4359a.f4257k.f4009d)) {
            UpdateActivity.f4247a;
            new StringBuilder("onStatusChanged taskId:").append(i).append(";status:").append(status);
            Message obtainMessage = this.f4359a.f4263q.obtainMessage();
            obtainMessage.what = 3;
            obtainMessage.arg1 = i;
            obtainMessage.obj = status;
            this.f4359a.f4263q.sendMessage(obtainMessage);
        }
    }

    public final void onStatusChanged(C1348b c1348b) {
    }

    public final void onStorageErrorInfo(int i, int i2, String str) {
    }

    public final void onTaskInfo(int i, int i2, int i3) {
        if (i == C1361b.m3815a(this.f4359a.f4257k.f4009d)) {
            UpdateActivity.f4247a;
            new StringBuilder("onTaskInfo taskId:").append(i).append(";thousandth:").append(i2).append(";speed:").append(i3);
            Message obtainMessage = this.f4359a.f4263q.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.arg1 = i;
            obtainMessage.arg2 = i2;
            this.f4359a.f4263q.sendMessage(obtainMessage);
        }
    }

    public final void onWaitStart(int i) {
    }
}
