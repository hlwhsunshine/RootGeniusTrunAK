package com.shuame.rootgenius.p115ui;

import com.shuame.rootgenius.common.manager.AppManager;
import com.shuame.rootgenius.common.manager.AppManager.C1348b;
import com.shuame.rootgenius.common.manager.AppManager.HandleType;
import com.shuame.rootgenius.common.qqdownload.C1319h;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.tencent.xuanfeng.libInterface.LinkStruct;
import java.io.File;

/* renamed from: com.shuame.rootgenius.ui.v */
final class C1609v implements C1319h {
    /* renamed from: a */
    final /* synthetic */ FontReplaceActivity f4407a;

    C1609v(FontReplaceActivity fontReplaceActivity) {
        this.f4407a = fontReplaceActivity;
    }

    public final void onComplete(int i, long j) {
        FontReplaceActivity.f4182f;
        QQDownloadFile a = C1361b.m3817a().mo7068a(i);
        if (j == 0) {
            if (a.f3717A == 1) {
                this.f4407a.m4235a(3, 0);
                File a2 = FontReplaceActivity.m4244d();
                if (a2 != null && a2.exists()) {
                    FontReplaceActivity.f4182f;
                    C1348b c1348b = new C1348b();
                    c1348b.f3677b = a2.getAbsolutePath();
                    c1348b.f3676a = i;
                    c1348b.f3678c = "com.xinmei365.font";
                    c1348b.f3682g = HandleType.SILENT_THEN_SYSTEM;
                    AppManager.m3771a().mo7031a(c1348b, this.f4407a);
                }
            }
        } else if (j == 1) {
            this.f4407a.m4235a(6, 0);
        } else {
            this.f4407a.m4235a(2, 0);
        }
        this.f4407a.f4188g = false;
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
        this.f4407a.m4235a(4, i2);
    }

    public final void onWaitStart(int i) {
    }
}
