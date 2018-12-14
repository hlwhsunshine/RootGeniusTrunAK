package com.shuame.rootgenius.p115ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.changefontmanager.sdk.ChangeFontManager;
import com.example.myfontsdk.C0446c;
import com.example.myfontsdk.C0454k;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.p102c.C1324a;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.common.util.C1411s;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.model.DownLoadFont;
import com.shuame.rootgenius.p110g.C1440c;
import com.shuame.rootgenius.p113i.C1455a;
import com.shuame.rootgenius.p115ui.dialog.MyActivityDialog;

/* renamed from: com.shuame.rootgenius.ui.p */
final class C1601p implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FontPreviewActivity f4395a;

    C1601p(FontPreviewActivity fontPreviewActivity) {
        this.f4395a = fontPreviewActivity;
    }

    public final void onClick(View view) {
        if (!C1455a.m4025a()) {
            int a = C1361b.m3815a(this.f4395a.f4168j.getDownloadUr());
            if (!C1440c.m3984a().mo7170b(a)) {
                if (C1323b.m3698d()) {
                    this.f4395a.f4169k = true;
                } else {
                    C1440c.m3984a().mo7163a(this.f4395a);
                    this.f4395a.f4169k = false;
                }
                if (this.f4395a.f4169k) {
                    QQDownloadFile a2 = C1361b.m3817a().mo7068a(a);
                    if (a2 == null) {
                        a2 = new DownLoadFont(this.f4395a.f4168j.getDownloadUr(), this.f4395a.f4168j.getFontSize(), C0446c.m988b() + C0454k.m992a(this.f4395a.f4168j.getDownloadUr()) + ".apk", this.f4395a.f4168j.getMD5()).toQQDownloadFile();
                    }
                    this.f4395a.f4160a.clear();
                    this.f4395a.f4160a.setProperty("DownloadAPP", "下载:" + this.f4395a.f4168j.getFontName());
                    C1324a c1324a = this.f4395a.f4161b;
                    C1324a.m3723a("ChangeFont", this.f4395a.f4160a);
                    if (a2.f3727h < C1411s.m3926b(a2.f3725f)) {
                        switch (a2.f3719C) {
                            case STARTING:
                            case DOWNLOADING:
                            case PENDING:
                                C1361b.m3817a().mo7073b(a);
                                this.f4395a.f4164f.setText(C1450R.string.text_btn_onekey_replace);
                                this.f4395a.f4167i.setProgress(100);
                                return;
                            case STOPING:
                            case STOPED:
                                if (FontPreviewActivity.m4222a(this.f4395a, a2)) {
                                    C1361b.m3817a().mo7067a(a2, null);
                                    if (a2.f3719C == Status.PENDING) {
                                        this.f4395a.f4164f.setText(C1450R.string.text_pending);
                                    } else {
                                        this.f4395a.f4164f.setText(C1450R.string.text_downloading);
                                    }
                                    this.f4395a.f4167i.setProgress(a2.f3728i / 10);
                                    return;
                                }
                                return;
                            case FINISHED:
                                C1440c.m3984a().mo7164a(this.f4395a.f4170l);
                                ChangeFontManager.getInstance().checkPhoneType(this.f4395a);
                                C1440c.m3984a();
                                if (C1440c.m3988d()) {
                                    Intent intent = new Intent(this.f4395a, MyActivityDialog.class);
                                    intent.putExtra("type", 2);
                                    intent.putExtra("taskId", a);
                                    intent.putExtra("font", this.f4395a.f4168j);
                                    this.f4395a.startActivity(intent);
                                    return;
                                }
                                C1440c.m3984a().mo7165a(this.f4395a.f4168j, a);
                                if (C1440c.m3984a().mo7171c(a).mo7159d()) {
                                    this.f4395a.f4164f.setText(C1450R.string.text_font_replaceing);
                                    return;
                                } else {
                                    this.f4395a.f4164f.setText(C1450R.string.text_waiting_replace_font);
                                    return;
                                }
                            default:
                                if (FontPreviewActivity.m4222a(this.f4395a, a2)) {
                                    C1361b.m3817a().mo7067a(a2, null);
                                    if (a2.f3719C == Status.PENDING) {
                                        this.f4395a.f4164f.setText(C1450R.string.text_pending);
                                    } else {
                                        this.f4395a.f4164f.setText(C1450R.string.text_downloading);
                                    }
                                    this.f4395a.f4167i.setProgress(a2.f3728i / 10);
                                    return;
                                }
                                return;
                        }
                    } else if (C1411s.m3926b(a2.f3725f) == -1) {
                        C1440c.m3984a().mo7173d(this.f4395a);
                    } else {
                        C1440c.m3984a().mo7172c(this.f4395a);
                    }
                }
            } else if (!C1440c.m3984a().mo7171c(a).mo7159d()) {
                C1440c.m3984a().mo7166a(C1440c.m3984a().mo7171c(a));
                C1440c.m3984a().mo7162a(a);
                this.f4395a.f4164f.setText(C1450R.string.text_btn_onekey_replace);
            }
        }
    }
}
