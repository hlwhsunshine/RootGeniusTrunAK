package com.shuame.rootgenius.p115ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.Formatter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.C1029c.C1025a;
import com.nostra13.universalimageloader.core.C1033d;
import com.nostra13.universalimageloader.core.p066b.C1022b;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.event.C1337b;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.manager.AppManager;
import com.shuame.rootgenius.common.manager.AppManager.C1348b;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.common.p101b.C1320a;
import com.shuame.rootgenius.common.p101b.C1321b;
import com.shuame.rootgenius.common.p102c.C1324a;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.common.util.C1389b;
import com.shuame.rootgenius.common.util.C1397j;
import com.shuame.rootgenius.common.util.C1416x;
import com.shuame.rootgenius.common.util.C1418z;
import com.shuame.rootgenius.common.util.NetworkUtils;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p115ui.view.ScreenShotScrollView;
import com.shuame.rootgenius.p115ui.view.ScreenShotScrollView.C1544a;
import com.shuame.rootgenius.p115ui.view.TextProgressBar;
import com.shuame.rootgenius.pojo.BbxCategoryInfo.Item;
import java.io.File;
import java.util.Properties;

/* renamed from: com.shuame.rootgenius.ui.BbxDetailActivity */
public class BbxDetailActivity extends Activity implements OnClickListener {
    /* renamed from: a */
    private static final String f4116a = BbxDetailActivity.class.getSimpleName();
    /* renamed from: b */
    private Item f4117b;
    /* renamed from: c */
    private TextProgressBar f4118c;
    /* renamed from: d */
    private ScreenShotScrollView f4119d;
    /* renamed from: e */
    private Properties f4120e = new Properties();
    /* renamed from: f */
    private C1324a f4121f = C1324a.m3722a(this);
    /* renamed from: g */
    private ImageView f4122g;
    /* renamed from: h */
    private TextView f4123h;
    /* renamed from: i */
    private Handler f4124i = new Handler(new C1499a(this));
    /* renamed from: j */
    private C1544a f4125j = new C1545b(this);
    /* renamed from: k */
    private C1320a f4126k = new C1546c(this);
    /* renamed from: l */
    private BroadcastReceiver f4127l = new C1547d(this);

    /* renamed from: com.shuame.rootgenius.ui.BbxDetailActivity$a */
    private class C1495a implements OnClickListener {
        private C1495a() {
        }

        /* synthetic */ C1495a(BbxDetailActivity bbxDetailActivity, byte b) {
            this();
        }

        public final void onClick(View view) {
            BbxDetailActivity.f4116a;
            QQDownloadFile a = C1361b.m3817a().mo7068a(BbxDetailActivity.this.f4117b.getTaskId());
            if (C1387ad.m3871b(BbxDetailActivity.this.f4117b.packageName)) {
                C1387ad.m3868a(BbxDetailActivity.this.getBaseContext(), BbxDetailActivity.this.f4117b.packageName);
                BbxDetailActivity.m4198a(a);
                BbxDetailActivity.this.f4120e.clear();
                BbxDetailActivity.this.f4120e.setProperty("StartAPP", "打开" + BbxDetailActivity.this.f4117b.displayName);
                BbxDetailActivity.this.f4121f;
                C1324a.m3723a(BbxDetailActivity.this.f4117b.cName, BbxDetailActivity.this.f4120e);
                return;
            }
            TextProgressBar textProgressBar = (TextProgressBar) view;
            if (a != null) {
                BbxDetailActivity.f4116a;
                new StringBuilder("downloadFile.status == ").append(a.f3719C).append("; downloadFile.path == ").append(a.f3725f);
                switch (C1551f.f4378a[a.f3719C.ordinal()]) {
                    case 1:
                    case 2:
                    case 8:
                        C1361b.m3817a().mo7073b(BbxDetailActivity.this.f4117b.getTaskId());
                        break;
                    case 3:
                        BbxDetailActivity.f4116a;
                        return;
                    case 4:
                    case 5:
                    case 6:
                        BbxDetailActivity.m4199a(a, true);
                        return;
                    case 7:
                        break;
                    default:
                        return;
                }
                BbxDetailActivity.f4116a;
                int taskId = BbxDetailActivity.this.f4117b.getTaskId();
                QQDownloadFile a2 = C1361b.m3817a().mo7068a(taskId);
                String text = textProgressBar.getText();
                if (text.equals(BbxDetailActivity.this.getString(C1450R.string.status_lanch))) {
                    if (C1387ad.m3868a(BbxDetailActivity.this.getBaseContext(), a2.f3739t)) {
                        BbxDetailActivity.m4198a(a2);
                        return;
                    }
                    BbxDetailActivity.this.f4118c.setProgressDrawable(BbxDetailActivity.this.getResources().getDrawable(C1450R.drawable.selector_app_detail_button));
                    BbxDetailActivity.this.m4195a((int) C1450R.string.status_download, true);
                    return;
                } else if (text.equals(BbxDetailActivity.this.getString(C1450R.string.status_install_pending))) {
                    AppManager.m3771a().mo7032a(taskId);
                    return;
                } else if (!text.substring(0, 2).equals(BbxDetailActivity.this.getString(C1450R.string.status_download).substring(0, 2))) {
                    BbxDetailActivity.f4116a;
                    return;
                } else if (new File(a2.f3725f).exists()) {
                    AppManager.m3776a(a2);
                    return;
                } else {
                    C1361b.m3817a().mo7076d(taskId);
                    a = BbxDetailActivity.this.f4117b.toQQDownloadFile();
                    a.f3725f = C1397j.m3897a(a);
                    BbxDetailActivity.m4199a(a, true);
                    BbxDetailActivity.this.f4120e.clear();
                    BbxDetailActivity.this.f4120e.setProperty("DownloadAPP", "下载" + BbxDetailActivity.this.f4117b.displayName);
                    BbxDetailActivity.this.f4121f;
                    C1324a.m3723a(BbxDetailActivity.this.f4117b.cName, BbxDetailActivity.this.f4120e);
                    return;
                }
            }
            a = BbxDetailActivity.this.f4117b.toQQDownloadFile();
            a.f3725f = C1397j.m3897a(a);
            BbxDetailActivity.m4199a(a, true);
            BbxDetailActivity.this.f4120e.clear();
            BbxDetailActivity.this.f4120e.setProperty("DownloadAPP", "下载" + BbxDetailActivity.this.f4117b.displayName);
            BbxDetailActivity.this.f4121f;
            C1324a.m3723a(BbxDetailActivity.this.f4117b.cName, BbxDetailActivity.this.f4120e);
        }
    }

    /* renamed from: a */
    private void m4195a(int i, boolean z) {
        if (C1450R.string.status_download == i) {
            this.f4118c.setText(getString(i, new Object[]{Formatter.formatFileSize(RootGeniusApp.m3523a(), this.f4117b.size)}));
        } else {
            this.f4118c.setText(i);
        }
        this.f4118c.setEnabled(z);
    }

    /* renamed from: a */
    private void m4196a(C1348b c1348b) {
        new StringBuilder("---install--initInstallStatus----status=").append(c1348b.f3679d);
        switch (C1551f.f4379b[c1348b.f3679d.ordinal()]) {
            case 1:
                m4195a((int) C1450R.string.status_install_pending, true);
                return;
            case 2:
                m4195a((int) C1450R.string.status_download, true);
                return;
            case 3:
                m4195a((int) C1450R.string.status_installing, false);
                return;
            case 4:
                m4195a((int) C1450R.string.status_download, true);
                return;
            case 5:
                m4195a((int) C1450R.string.status_installing, false);
                return;
            case 6:
                m4195a((int) C1450R.string.status_lanch, true);
                this.f4118c.setProgressDrawable(getResources().getDrawable(C1450R.drawable.selector_app_lanch_button));
                return;
            case 7:
                m4195a((int) C1450R.string.status_download, true);
                return;
            case 8:
                m4195a((int) C1450R.string.status_download, true);
                return;
            case 9:
                m4195a((int) C1450R.string.status_lanch, true);
                this.f4118c.setProgressDrawable(getResources().getDrawable(C1450R.drawable.selector_app_lanch_button));
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m4197a(Status status) {
        new StringBuilder("initTextProgressBarByStatus = ").append(status);
        QQDownloadFile a = C1361b.m3817a().mo7068a(this.f4117b.getTaskId());
        this.f4118c.setProgress(a.f3728i / 10);
        switch (C1551f.f4378a[a.f3719C.ordinal()]) {
            case 1:
                m4195a((int) C1450R.string.status_download_pending, true);
                this.f4118c.setProgressDrawable(getResources().getDrawable(C1450R.drawable.app_detail_progressbar));
                return;
            case 2:
                this.f4118c.setText(getString(C1450R.string.status_downloading, new Object[]{Integer.valueOf(a.f3728i / 10)}));
                this.f4118c.setProgressDrawable(getResources().getDrawable(C1450R.drawable.app_detail_progressbar));
                return;
            case 3:
                m4195a((int) C1450R.string.status_pausing, true);
                this.f4118c.setProgressDrawable(getResources().getDrawable(C1450R.drawable.app_detail_progressbar));
                return;
            case 4:
            case 5:
            case 6:
                m4195a((int) C1450R.string.status_resume, true);
                this.f4118c.setProgressDrawable(getResources().getDrawable(C1450R.drawable.app_detail_progressbar));
                return;
            case 7:
                C1348b c1348b = (C1348b) AppManager.m3771a().f3689a.get(Integer.valueOf(a.f3722c));
                if (c1348b != null) {
                    m4196a(c1348b);
                } else if (C1387ad.m3871b(this.f4117b.packageName)) {
                    m4195a((int) C1450R.string.status_lanch, true);
                    this.f4118c.setProgressDrawable(getResources().getDrawable(C1450R.drawable.selector_app_lanch_button));
                } else if (new File(a.f3725f).exists()) {
                    m4195a((int) C1450R.string.status_download, true);
                } else {
                    C1361b.m3817a().mo7076d(this.f4117b.getTaskId());
                    m4195a((int) C1450R.string.status_download, true);
                }
                this.f4118c.setProgressDrawable(getResources().getDrawable(C1450R.drawable.selector_app_detail_button));
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private static void m4199a(QQDownloadFile qQDownloadFile, boolean z) {
        C1389b.m3884a();
        if (C1389b.m3887b(z)) {
            C1389b.m3884a();
            if (C1389b.m3886a(z)) {
                C1389b.m3884a();
                if (C1389b.m3885a(qQDownloadFile, z)) {
                    C1361b.m3817a().mo7067a(qQDownloadFile, null);
                }
            }
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m4205c(BbxDetailActivity bbxDetailActivity, Message message) {
        C1348b c1348b = (C1348b) message.obj;
        new StringBuilder("---install--onStatusChanged----status=").append(c1348b.f3679d);
        bbxDetailActivity.m4196a(c1348b);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1450R.id.btn_back:
                finish();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        QQDownloadFile a;
        super.onCreate(bundle);
        setContentView(C1450R.layout.activity_bbx_detail);
        Intent intent = getIntent();
        this.f4117b = (Item) intent.getSerializableExtra("info");
        if (this.f4117b == null) {
            C1416x.m3937a("详情展示失败！");
            finish();
        } else if (intent.getBooleanExtra("auto_download", false) && NetworkUtils.m3854d()) {
            a = C1361b.m3817a().mo7068a(this.f4117b.getTaskId());
            if (a == null) {
                a = this.f4117b.toQQDownloadFile();
                a.f3725f = C1397j.m3897a(a);
            }
            BbxDetailActivity.m4199a(a, false);
        }
        new C1379b(findViewById(C1450R.id.v_titlebar), (Activity) this, this.f4117b.displayName).mo7105b();
        this.f4122g = (ImageView) findViewById(C1450R.id.iv_logo);
        this.f4123h = (TextView) findViewById(C1450R.id.tv_description);
        this.f4119d = (ScreenShotScrollView) findViewById(C1450R.id.screen_shot_scrollview);
        this.f4118c = (TextProgressBar) findViewById(C1450R.id.tpb_detail_progress);
        C1418z.m3939a(this.f4123h);
        C1321b.m3685a().mo6990a(this.f4126k);
        registerReceiver(this.f4127l, new IntentFilter(C1340e.f3632c));
        this.f4119d.setOnScrollViewListener(this.f4125j);
        this.f4118c.setOnClickListener(new C1495a(this, (byte) 0));
        this.f4123h.setText(this.f4117b.description);
        this.f4119d.setData(this.f4117b.screenshots);
        if (C1387ad.m3871b(this.f4117b.packageName)) {
            m4195a((int) C1450R.string.status_lanch, true);
            this.f4118c.setProgressDrawable(getResources().getDrawable(C1450R.drawable.selector_app_lanch_button));
        } else {
            a = C1361b.m3817a().mo7068a(this.f4117b.getTaskId());
            if (a != null) {
                m4197a(a.f3719C);
            } else {
                this.f4118c.setProgressDrawable(getResources().getDrawable(C1450R.drawable.selector_app_detail_button));
                m4195a((int) C1450R.string.status_download, true);
            }
        }
        C1033d.m2984a().mo6286a(this.f4117b.iconUrl, this.f4122g, new C1025a().mo6247a(true).mo6241a().mo6242a((int) C1450R.drawable.def_logo_icon).mo6248b((int) C1450R.drawable.def_logo_icon).mo6250c((int) C1450R.drawable.def_logo_icon).mo6245a(new C1022b(20)).mo6249b(), null);
    }

    protected void onDestroy() {
        unregisterReceiver(this.f4127l);
        C1321b.m3685a().mo6991b(this.f4126k);
        super.onDestroy();
    }

    protected void onStart() {
        super.onStart();
        C1337b.m3738a().mo7006b();
    }
}
