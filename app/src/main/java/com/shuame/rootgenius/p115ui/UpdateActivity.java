package com.shuame.rootgenius.p115ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.p101b.C1320a;
import com.shuame.rootgenius.common.p101b.C1321b;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.common.util.C1389b;
import com.shuame.rootgenius.common.util.C1397j;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p113i.C1455a;
import com.shuame.rootgenius.pojo.C1460b;
import com.shuame.rootgenius.service.C1489g;
import com.shuame.rootgenius.service.C1492j;
import java.io.File;

/* renamed from: com.shuame.rootgenius.ui.UpdateActivity */
public class UpdateActivity extends Activity implements OnClickListener {
    /* renamed from: a */
    private static final String f4247a = UpdateActivity.class.getSimpleName();
    /* renamed from: b */
    private View f4248b;
    /* renamed from: c */
    private View f4249c;
    /* renamed from: d */
    private View f4250d;
    /* renamed from: e */
    private View f4251e;
    /* renamed from: f */
    private View f4252f;
    /* renamed from: g */
    private View f4253g;
    /* renamed from: h */
    private ProgressBar f4254h;
    /* renamed from: i */
    private TextView f4255i;
    /* renamed from: j */
    private C1492j f4256j;
    /* renamed from: k */
    private C1460b f4257k;
    /* renamed from: l */
    private String f4258l;
    /* renamed from: m */
    private String f4259m;
    /* renamed from: n */
    private int f4260n;
    /* renamed from: o */
    private BroadcastReceiver f4261o = new C1540ar(this);
    /* renamed from: p */
    private C1320a f4262p = new C1541as(this);
    /* renamed from: q */
    private Handler f4263q = new Handler(new C1542at(this));

    /* renamed from: a */
    private void m4285a(QQDownloadFile qQDownloadFile, boolean z) {
        C1389b.m3884a();
        if (C1389b.m3887b(true)) {
            C1389b.m3884a();
            if (C1389b.m3886a(true)) {
                C1389b.m3884a();
                if (C1389b.m3885a(qQDownloadFile, z)) {
                    C1361b.m3817a().mo7067a(qQDownloadFile, null);
                    return;
                } else {
                    this.f4263q.sendEmptyMessage(C1450R.layout.dialog_update_download_fail_no_stoarge);
                    return;
                }
            }
            finish();
            return;
        }
        this.f4263q.sendEmptyMessage(C1450R.layout.dialog_update_download_fail);
    }

    /* renamed from: b */
    private void m4288b() {
        if ((this.f4248b.getVisibility() == 0 || this.f4249c.getVisibility() == 0) && C1387ad.m3867a((Context) this)) {
            QQDownloadFile a = C1361b.m3817a().mo7068a(C1361b.m3815a(this.f4257k.f4009d));
            if (a == null) {
                a = this.f4257k.mo7244b();
                a.f3725f = C1397j.m3897a(a);
            }
            m4285a(a, false);
        } else {
            C1361b.m3817a().mo7073b(C1361b.m3815a(this.f4257k.f4009d));
        }
        C1492j.m4165a();
        C1492j.m4175e();
    }

    public void onBackPressed() {
        m4288b();
        super.onBackPressed();
    }

    public void onClick(View view) {
        if (!C1455a.m4025a()) {
            switch (view.getId()) {
                case C1450R.id.btn_install_new:
                    Uri fromFile = Uri.fromFile(new File(C1397j.m3897a(this.f4257k.mo7244b())));
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setFlags(268435456);
                    intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
                    startActivity(intent);
                    finish();
                    return;
                case C1450R.id.btn_retry_update_cancel:
                case C1450R.id.btn_not_storage_update_cancel:
                case C1450R.id.btn_cancel_now_download:
                case C1450R.id.btn_wifi_change_download_cancel:
                case C1450R.id.btn_update_remind_cancel:
                    m4288b();
                    finish();
                    return;
                case C1450R.id.btn_retry_update_confirm:
                case C1450R.id.btn_not_storage_update_confirm:
                case C1450R.id.btn_wifi_change_download_continue:
                case C1450R.id.btn_update_remind_confirm:
                    this.f4263q.sendEmptyMessage(C1450R.layout.dialog_update_download_ing);
                    return;
                default:
                    return;
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.activity_update);
        this.f4257k = C1489g.m4151a().mo7313b();
        this.f4258l = "";
        if (VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f4248b = findViewById(C1450R.id.view_block_update_remind);
        findViewById(C1450R.id.btn_update_remind_cancel).setOnClickListener(this);
        findViewById(C1450R.id.btn_update_remind_confirm).setOnClickListener(this);
        TextView textView = (TextView) findViewById(C1450R.id.update_remind_content_tv);
        String string = getResources().getString(C1450R.string.update_remind_msg);
        if (TextUtils.isEmpty(this.f4258l)) {
            this.f4258l = "";
        }
        textView.setText(String.format(string, new Object[]{this.f4258l}));
        this.f4249c = findViewById(C1450R.id.view_block_update_download_ing);
        findViewById(C1450R.id.btn_cancel_now_download).setOnClickListener(this);
        this.f4255i = (TextView) findViewById(C1450R.id.tv_percent);
        this.f4254h = (ProgressBar) findViewById(C1450R.id.pb_percent);
        this.f4254h.setIndeterminate(false);
        this.f4254h.setMax(100);
        this.f4250d = findViewById(C1450R.id.view_block_update_download_done);
        findViewById(C1450R.id.btn_install_new).setOnClickListener(this);
        this.f4252f = findViewById(C1450R.id.view_block_update_download_fail_no_stoarge);
        findViewById(C1450R.id.btn_not_storage_update_cancel).setOnClickListener(this);
        findViewById(C1450R.id.btn_not_storage_update_confirm).setOnClickListener(this);
        this.f4251e = findViewById(C1450R.id.view_block_update_download_fail);
        findViewById(C1450R.id.btn_retry_update_cancel).setOnClickListener(this);
        findViewById(C1450R.id.btn_retry_update_confirm).setOnClickListener(this);
        this.f4253g = findViewById(C1450R.id.view_block_update_download_wifi_gone);
        findViewById(C1450R.id.btn_wifi_change_download_cancel).setOnClickListener(this);
        findViewById(C1450R.id.btn_wifi_change_download_continue).setOnClickListener(this);
        C1321b.m3685a().mo6990a(this.f4262p);
        registerReceiver(this.f4261o, new IntentFilter(C1340e.f3632c));
        this.f4256j = C1492j.m4165a().mo7318a((Context) this);
        QQDownloadFile a = C1361b.m3817a().mo7068a(C1361b.m3815a(this.f4257k.f4009d));
        if (a == null || a.f3719C != Status.FINISHED) {
            this.f4263q.sendEmptyMessage(C1450R.layout.dialog_update_remind);
        } else if (new File(a.f3725f).exists()) {
            this.f4263q.sendEmptyMessage(C1450R.layout.dialog_update_download_done);
        } else {
            C1361b.m3817a().mo7076d(C1361b.m3815a(this.f4257k.f4009d));
            this.f4263q.sendEmptyMessage(C1450R.layout.dialog_update_remind);
        }
    }

    protected void onDestroy() {
        unregisterReceiver(this.f4261o);
        C1321b.m3685a().mo6991b(this.f4262p);
        super.onDestroy();
    }
}
