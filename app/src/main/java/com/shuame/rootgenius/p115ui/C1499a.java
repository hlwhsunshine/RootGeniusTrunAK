package com.shuame.rootgenius.p115ui;

import android.os.Handler.Callback;
import android.os.Message;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;

/* renamed from: com.shuame.rootgenius.ui.a */
final class C1499a implements Callback {
    /* renamed from: a */
    final /* synthetic */ BbxDetailActivity f4264a;

    C1499a(BbxDetailActivity bbxDetailActivity) {
        this.f4264a = bbxDetailActivity;
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                BbxDetailActivity.m4200a(this.f4264a, message);
                break;
            case 3:
                this.f4264a.m4197a((Status) message.obj);
                break;
            case 4:
                BbxDetailActivity.m4205c(this.f4264a, message);
                break;
        }
        return false;
    }
}
