package com.shuame.rootgenius.p115ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p015v4.view.ViewPager;
import android.support.p015v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.manager.AppManager;
import com.shuame.rootgenius.common.manager.AppManager.C1348b;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.common.p101b.C1320a;
import com.shuame.rootgenius.common.p101b.C1321b;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.common.util.C1389b;
import com.shuame.rootgenius.common.util.C1397j;
import com.shuame.rootgenius.common.util.C1416x;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p115ui.adapter.C1520m;
import com.shuame.rootgenius.p115ui.view.TextProgressBar;
import com.shuame.rootgenius.pojo.C1461c;
import com.shuame.rootgenius.service.C1491i;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.shuame.rootgenius.ui.ShuameGuideActivity */
public class ShuameGuideActivity extends Activity implements OnPageChangeListener, OnClickListener {
    /* renamed from: a */
    private static final String f4229a = ShuameGuideActivity.class.getSimpleName();
    /* renamed from: b */
    private static final int[] f4230b = new int[]{C1450R.drawable.shuame_guide_item_yxlc, C1450R.drawable.shuame_guide_item_jjqs, C1450R.drawable.shuame_guide_item_aqhh, C1450R.drawable.shuame_guide_item_qssj, C1450R.drawable.shuame_guide_item_zxgx};
    /* renamed from: c */
    private static final int[] f4231c = new int[]{C1450R.string.shuame_guide_item_title_yxlc, C1450R.string.shuame_guide_item_title_jjqs, C1450R.string.shuame_guide_item_title_aqhh, C1450R.string.shuame_guide_item_title_qssj, C1450R.string.shuame_guide_item_title_zxgx};
    /* renamed from: d */
    private static final int[] f4232d = new int[]{C1450R.string.shuame_guide_item_msg_yxlc, C1450R.string.shuame_guide_item_msg_jjqs, C1450R.string.shuame_guide_item_msg_aqhh, C1450R.string.shuame_guide_item_msg_qssj, C1450R.string.shuame_guide_item_msg_zxgx};
    /* renamed from: e */
    private ViewPager f4233e;
    /* renamed from: f */
    private ViewGroup f4234f;
    /* renamed from: g */
    private C1520m f4235g;
    /* renamed from: h */
    private View f4236h;
    /* renamed from: i */
    private View f4237i;
    /* renamed from: j */
    private TextProgressBar f4238j;
    /* renamed from: k */
    private C1461c f4239k;
    /* renamed from: l */
    private Handler f4240l = new Handler(new C1531ai(this));
    /* renamed from: m */
    private C1320a f4241m = new C1532aj(this);
    /* renamed from: n */
    private BroadcastReceiver f4242n = new C1533ak(this);

    /* renamed from: com.shuame.rootgenius.ui.ShuameGuideActivity$a */
    private class C1498a implements OnClickListener {
        private C1498a() {
        }

        /* synthetic */ C1498a(ShuameGuideActivity shuameGuideActivity, byte b) {
            this();
        }

        public final void onClick(View view) {
            ShuameGuideActivity.f4229a;
            QQDownloadFile a = C1361b.m3817a().mo7068a(ShuameGuideActivity.this.f4239k.mo7245a());
            if (C1387ad.m3871b("com.shuame.mobile")) {
                C1387ad.m3868a(ShuameGuideActivity.this.getBaseContext(), "com.shuame.mobile");
                ShuameGuideActivity.m4270b(a);
                return;
            }
            TextProgressBar textProgressBar = (TextProgressBar) view;
            if (a != null) {
                ShuameGuideActivity.f4229a;
                new StringBuilder("downloadFile.status == ").append(a.f3719C).append("; downloadFile.path == ").append(a.f3725f);
                switch (C1535am.f4352a[a.f3719C.ordinal()]) {
                    case 1:
                    case 2:
                    case 8:
                        C1361b.m3817a().mo7073b(ShuameGuideActivity.this.f4239k.mo7245a());
                        return;
                    case 3:
                        ShuameGuideActivity.f4229a;
                        return;
                    case 4:
                    case 5:
                    case 6:
                        ShuameGuideActivity.m4277d(ShuameGuideActivity.this);
                        return;
                    case 7:
                        ShuameGuideActivity.f4229a;
                        int a2 = ShuameGuideActivity.this.f4239k.mo7245a();
                        QQDownloadFile a3 = C1361b.m3817a().mo7068a(a2);
                        String text = textProgressBar.getText();
                        if (text.equals(ShuameGuideActivity.this.getString(C1450R.string.status_lanch))) {
                            if (C1387ad.m3868a(ShuameGuideActivity.this.getBaseContext(), "com.shuame.mobile")) {
                                ShuameGuideActivity.m4270b(a3);
                                return;
                            }
                            ShuameGuideActivity.this.f4238j.setProgressDrawable(ShuameGuideActivity.this.getResources().getDrawable(C1450R.drawable.selector_app_detail_button));
                            ShuameGuideActivity.this.m4264a((int) C1450R.string.status_download, true);
                            return;
                        } else if (text.equals(ShuameGuideActivity.this.getString(C1450R.string.status_install_pending))) {
                            AppManager.m3771a().mo7032a(a2);
                            return;
                        } else if (!text.substring(0, 2).equals(ShuameGuideActivity.this.getString(C1450R.string.status_download).substring(0, 2))) {
                            ShuameGuideActivity.f4229a;
                            return;
                        } else if (new File(a3.f3725f).exists()) {
                            AppManager.m3776a(a3);
                            return;
                        } else {
                            C1361b.m3817a().mo7076d(a2);
                            ShuameGuideActivity.m4277d(ShuameGuideActivity.this);
                            return;
                        }
                    default:
                        return;
                }
            }
            ShuameGuideActivity.m4277d(ShuameGuideActivity.this);
        }
    }

    /* renamed from: a */
    private void m4264a(int i, boolean z) {
        if (C1450R.string.status_download == i) {
            this.f4238j.setText(getString(i, new Object[]{"10 M"}));
        } else {
            this.f4238j.setText(i);
        }
        this.f4238j.setEnabled(z);
    }

    /* renamed from: a */
    private void m4265a(C1348b c1348b) {
        new StringBuilder("---install--initInstallStatus----status=").append(c1348b.f3679d);
        switch (C1535am.f4353b[c1348b.f3679d.ordinal()]) {
            case 1:
                m4264a((int) C1450R.string.status_install_pending, true);
                return;
            case 2:
                m4264a((int) C1450R.string.status_download, true);
                return;
            case 3:
                m4264a((int) C1450R.string.status_installing, false);
                return;
            case 4:
                m4264a((int) C1450R.string.status_download, true);
                return;
            case 5:
                m4264a((int) C1450R.string.status_installing, false);
                return;
            case 6:
                m4264a((int) C1450R.string.status_lanch, true);
                return;
            case 7:
                m4264a((int) C1450R.string.status_download, true);
                return;
            case 8:
                m4264a((int) C1450R.string.status_download, true);
                return;
            case 9:
                m4264a((int) C1450R.string.status_lanch, true);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m4266a(Status status) {
        new StringBuilder("initTextProgressBarByStatus = ").append(status);
        QQDownloadFile a = C1361b.m3817a().mo7068a(this.f4239k.mo7245a());
        this.f4238j.setProgress(a.f3728i / 10);
        switch (C1535am.f4352a[a.f3719C.ordinal()]) {
            case 1:
                m4264a((int) C1450R.string.status_download_pending, true);
                this.f4238j.setProgressDrawable(getResources().getDrawable(C1450R.drawable.app_detail_progressbar));
                return;
            case 2:
                this.f4238j.setText(getString(C1450R.string.status_downloading, new Object[]{Integer.valueOf(a.f3728i / 10)}));
                this.f4238j.setProgressDrawable(getResources().getDrawable(C1450R.drawable.app_detail_progressbar));
                return;
            case 3:
                m4264a((int) C1450R.string.status_pausing, true);
                this.f4238j.setProgressDrawable(getResources().getDrawable(C1450R.drawable.app_detail_progressbar));
                return;
            case 4:
            case 5:
            case 6:
                m4264a((int) C1450R.string.status_resume, true);
                this.f4238j.setProgressDrawable(getResources().getDrawable(C1450R.drawable.app_detail_progressbar));
                return;
            case 7:
                C1348b c1348b = (C1348b) AppManager.m3771a().f3689a.get(Integer.valueOf(a.f3722c));
                if (c1348b != null) {
                    m4265a(c1348b);
                } else if (C1387ad.m3871b("com.shuame.mobile")) {
                    m4264a((int) C1450R.string.status_lanch, true);
                } else if (new File(a.f3725f).exists()) {
                    m4264a((int) C1450R.string.status_download, true);
                } else {
                    C1361b.m3817a().mo7076d(this.f4239k.mo7245a());
                    m4264a((int) C1450R.string.status_download, true);
                }
                this.f4238j.setProgressDrawable(getResources().getDrawable(C1450R.drawable.selector_app_detail_button));
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private void m4269b() {
        List arrayList = new ArrayList();
        for (int i = 0; i < f4230b.length; i++) {
            View inflate = getLayoutInflater().inflate(C1450R.layout.shuame_guide_item, null);
            TextView textView = (TextView) inflate.findViewById(C1450R.id.item_title);
            TextView textView2 = (TextView) inflate.findViewById(C1450R.id.item_msg);
            ((ImageView) inflate.findViewById(C1450R.id.item_img)).setImageResource(f4230b[i]);
            textView.setText(f4231c[i]);
            textView2.setText(f4232d[i]);
            arrayList.add(inflate);
        }
        int i2 = 0;
        while (i2 < f4230b.length) {
            ImageView imageView = (ImageView) getLayoutInflater().inflate(C1450R.layout.view_guide_dot, null);
            imageView.setImageResource(C1450R.drawable.selector_shuame_guide_dot);
            imageView.setPadding(10, 10, 10, 10);
            imageView.setEnabled(i2 == 0);
            this.f4234f.addView(imageView, new LayoutParams(-2, -2));
            i2++;
        }
        this.f4235g = new C1520m(arrayList);
        this.f4233e.setAdapter(this.f4235g);
        m4274c();
        this.f4236h.setEnabled(false);
    }

    /* renamed from: c */
    private void m4274c() {
        if (C1387ad.m3871b("com.shuame.mobile")) {
            m4264a((int) C1450R.string.status_lanch, true);
            this.f4238j.setProgressDrawable(getResources().getDrawable(C1450R.drawable.selector_app_detail_button));
            return;
        }
        QQDownloadFile a = C1361b.m3817a().mo7068a(this.f4239k.mo7245a());
        if (a != null) {
            m4266a(a.f3719C);
            return;
        }
        this.f4238j.setProgressDrawable(getResources().getDrawable(C1450R.drawable.selector_app_detail_button));
        m4264a((int) C1450R.string.status_download, true);
    }

    /* renamed from: c */
    private static void m4275c(QQDownloadFile qQDownloadFile) {
        C1389b.m3884a();
        if (C1389b.m3886a(true)) {
            C1389b.m3884a();
            if (C1389b.m3885a(qQDownloadFile, true)) {
                C1361b.m3817a().mo7067a(qQDownloadFile, null);
            }
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m4276c(ShuameGuideActivity shuameGuideActivity, Message message) {
        C1348b c1348b = (C1348b) message.obj;
        new StringBuilder("---install--onStatusChanged----status=").append(c1348b.f3679d);
        shuameGuideActivity.m4265a(c1348b);
    }

    /* renamed from: d */
    static /* synthetic */ void m4277d(ShuameGuideActivity shuameGuideActivity) {
        if (!C1387ad.m3873c(shuameGuideActivity.getBaseContext())) {
            C1416x.m3936a((int) C1450R.string.string_no_active_network);
        } else if (shuameGuideActivity.f4239k.f4014a) {
            QQDownloadFile a = C1361b.m3817a().mo7068a(shuameGuideActivity.f4239k.mo7245a());
            if (a == null) {
                a = shuameGuideActivity.f4239k.mo7246b();
                a.f3725f = C1397j.m3897a(a);
            }
            ShuameGuideActivity.m4275c(a);
        } else {
            shuameGuideActivity.f4238j.setProgress(0);
            shuameGuideActivity.m4264a((int) C1450R.string.status_download_pending, true);
            shuameGuideActivity.f4238j.setProgressDrawable(shuameGuideActivity.getResources().getDrawable(C1450R.drawable.app_detail_progressbar));
            new C1529ag(shuameGuideActivity).start();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1450R.id.v_page_btn_left:
                this.f4233e.setCurrentItem(this.f4233e.getCurrentItem() - 1);
                return;
            case C1450R.id.v_page_btn_right:
                this.f4233e.setCurrentItem(this.f4233e.getCurrentItem() + 1);
                return;
            case C1450R.id.btn_back:
                finish();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.activity_shuame_guide);
        this.f4239k = C1491i.m4161a().mo7316b();
        new C1379b(findViewById(C1450R.id.v_titlebar), (Activity) this, (int) C1450R.string.shuame_guide_title).mo7105b();
        this.f4233e = (ViewPager) findViewById(C1450R.id.view_pager);
        this.f4234f = (ViewGroup) findViewById(C1450R.id.page_indicator);
        this.f4236h = findViewById(C1450R.id.v_page_btn_left);
        this.f4237i = findViewById(C1450R.id.v_page_btn_right);
        this.f4238j = (TextProgressBar) findViewById(C1450R.id.tpb_detail_progress);
        C1321b.m3685a().mo6990a(this.f4241m);
        registerReceiver(this.f4242n, new IntentFilter(C1340e.f3632c));
        findViewById(C1450R.id.btn_back).setOnClickListener(this);
        this.f4233e.setOnPageChangeListener(this);
        this.f4236h.setOnClickListener(this);
        this.f4237i.setOnClickListener(this);
        this.f4238j.setOnClickListener(new C1498a(this, (byte) 0));
        m4269b();
    }

    protected void onDestroy() {
        unregisterReceiver(this.f4242n);
        C1321b.m3685a().mo6991b(this.f4241m);
        super.onDestroy();
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.f4233e != null) {
            this.f4233e.invalidate();
        }
    }

    public void onPageSelected(int i) {
        int i2 = 0;
        while (i2 < f4230b.length) {
            this.f4234f.getChildAt(i2).setEnabled(i2 == i);
            i2++;
        }
        if (i == 0) {
            this.f4236h.setEnabled(false);
            this.f4237i.setEnabled(true);
        } else if (i == f4230b.length - 1) {
            this.f4236h.setEnabled(true);
            this.f4237i.setEnabled(false);
        } else {
            this.f4236h.setEnabled(true);
            this.f4237i.setEnabled(true);
        }
    }
}
