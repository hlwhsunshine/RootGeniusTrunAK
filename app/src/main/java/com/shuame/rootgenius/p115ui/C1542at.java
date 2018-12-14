package com.shuame.rootgenius.p115ui;

import android.os.Handler.Callback;
import android.os.Message;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.common.util.C1397j;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.service.C1492j;

/* renamed from: com.shuame.rootgenius.ui.at */
final class C1542at implements Callback {
    /* renamed from: a */
    final /* synthetic */ UpdateActivity f4360a;

    C1542at(UpdateActivity updateActivity) {
        this.f4360a = updateActivity;
    }

    public final boolean handleMessage(Message message) {
        if (!this.f4360a.isFinishing()) {
            switch (message.what) {
                case 1:
                    int i = message.arg2 / 10;
                    if (this.f4360a.f4260n != i || i == 100) {
                        if (this.f4360a.f4259m == null) {
                            this.f4360a.f4259m = C1387ad.m3864a(this.f4360a.f4257k.f4009d);
                        }
                        UpdateActivity.f4247a;
                        new StringBuilder("percent:").append(i).append("--currFileName:").append(this.f4360a.f4259m);
                        this.f4360a.f4256j.mo7319a(this.f4360a.f4259m);
                        this.f4360a.f4256j.mo7320a(i);
                        this.f4360a.f4254h.setProgress(i);
                        this.f4360a.f4255i.setText(String.valueOf(i));
                        this.f4360a.f4260n = i;
                        break;
                    }
                case 3:
                    switch (C1543au.f4361a[((Status) message.obj).ordinal()]) {
                        case 1:
                            this.f4360a.f4263q.sendEmptyMessage(C1450R.layout.dialog_update_download_fail);
                            this.f4360a.getApplicationContext();
                            if (C1387ad.m3870b()) {
                                C1492j.m4165a();
                                C1492j.m4166a(this.f4360a.getApplicationContext(), this.f4360a.getString(C1450R.string.notify_download_fail));
                                break;
                            }
                            break;
                        case 2:
                            this.f4360a.f4263q.sendEmptyMessage(C1450R.layout.dialog_update_download_done);
                            C1492j.m4165a();
                            C1492j.m4170b();
                            C1492j.m4165a();
                            C1492j.m4167a(this.f4360a.getApplicationContext(), this.f4360a.getString(C1450R.string.notify_download_finish), C1397j.m3897a(this.f4360a.f4257k.mo7244b()));
                            break;
                    }
                    break;
                case C1450R.layout.dialog_update_download_done:
                    this.f4360a.f4248b.setVisibility(8);
                    this.f4360a.f4249c.setVisibility(8);
                    this.f4360a.f4250d.setVisibility(0);
                    this.f4360a.f4251e.setVisibility(8);
                    this.f4360a.f4253g.setVisibility(8);
                    this.f4360a.f4252f.setVisibility(8);
                    break;
                case C1450R.layout.dialog_update_download_fail:
                    this.f4360a.f4248b.setVisibility(8);
                    this.f4360a.f4249c.setVisibility(8);
                    this.f4360a.f4250d.setVisibility(8);
                    this.f4360a.f4251e.setVisibility(0);
                    this.f4360a.f4253g.setVisibility(8);
                    this.f4360a.f4252f.setVisibility(8);
                    break;
                case C1450R.layout.dialog_update_download_fail_no_stoarge:
                    this.f4360a.f4248b.setVisibility(8);
                    this.f4360a.f4249c.setVisibility(8);
                    this.f4360a.f4250d.setVisibility(8);
                    this.f4360a.f4251e.setVisibility(8);
                    this.f4360a.f4253g.setVisibility(8);
                    this.f4360a.f4252f.setVisibility(0);
                    break;
                case C1450R.layout.dialog_update_download_ing:
                    if (this.f4360a.f4249c.getVisibility() != 0) {
                        this.f4360a.f4248b.setVisibility(8);
                        this.f4360a.f4249c.setVisibility(0);
                        this.f4360a.f4250d.setVisibility(8);
                        this.f4360a.f4251e.setVisibility(8);
                        this.f4360a.f4253g.setVisibility(8);
                        this.f4360a.f4252f.setVisibility(8);
                        QQDownloadFile a = C1361b.m3817a().mo7068a(C1361b.m3815a(this.f4360a.f4257k.f4009d));
                        if (a == null) {
                            a = this.f4360a.f4257k.mo7244b();
                            a.f3725f = C1397j.m3897a(a);
                        }
                        this.f4360a.m4285a(a, true);
                        break;
                    }
                    break;
                case C1450R.layout.dialog_update_download_wifi_gone:
                    this.f4360a.f4248b.setVisibility(8);
                    this.f4360a.f4249c.setVisibility(8);
                    this.f4360a.f4250d.setVisibility(8);
                    this.f4360a.f4251e.setVisibility(8);
                    this.f4360a.f4253g.setVisibility(0);
                    this.f4360a.f4252f.setVisibility(8);
                    break;
                case C1450R.layout.dialog_update_remind:
                    this.f4360a.f4248b.setVisibility(0);
                    this.f4360a.f4249c.setVisibility(8);
                    this.f4360a.f4250d.setVisibility(8);
                    this.f4360a.f4251e.setVisibility(8);
                    this.f4360a.f4253g.setVisibility(8);
                    this.f4360a.f4252f.setVisibility(8);
                    break;
            }
        }
        return false;
    }
}
