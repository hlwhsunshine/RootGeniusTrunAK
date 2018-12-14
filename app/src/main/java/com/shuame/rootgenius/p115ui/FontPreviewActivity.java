package com.shuame.rootgenius.p115ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p015v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.changefontmanager.sdk.ChangeFontManager;
import com.example.myfontsdk.C0446c;
import com.example.myfontsdk.Font;
import com.loopj.android.http.C0907a;
import com.nostra13.universalimageloader.core.C1029c;
import com.nostra13.universalimageloader.core.C1029c.C1025a;
import com.nostra13.universalimageloader.core.p068d.C1030a;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.p087ui.LoadingView;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.common.p102c.C1324a;
import com.shuame.rootgenius.common.qqdownload.C1319h;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p110g.C1440c;
import com.shuame.rootgenius.p113i.C1455a;
import com.shuame.rootgenius.p115ui.dialog.MyActivityDialog;
import com.shuame.rootgenius.p115ui.view.MyViewPager;
import com.tencent.xuanfeng.libInterface.LinkStruct;
import java.io.File;
import java.util.Properties;

@SuppressLint({"NewApi"})
/* renamed from: com.shuame.rootgenius.ui.FontPreviewActivity */
public class FontPreviewActivity extends Activity implements OnPageChangeListener, C1030a, C1319h {
    /* renamed from: e */
    private static final String f4159e = FontPreviewActivity.class.getSimpleName();
    /* renamed from: a */
    Properties f4160a = new Properties();
    /* renamed from: b */
    C1324a f4161b;
    /* renamed from: c */
    OnClickListener f4162c = new C1601p(this);
    /* renamed from: d */
    private RelativeLayout f4163d;
    /* renamed from: f */
    private Button f4164f;
    /* renamed from: g */
    private int f4165g = 0;
    /* renamed from: h */
    private boolean f4166h = true;
    /* renamed from: i */
    private ProgressBar f4167i;
    /* renamed from: j */
    private Font f4168j;
    /* renamed from: k */
    private boolean f4169k = false;
    /* renamed from: l */
    private final Handler f4170l = new C1496a();
    /* renamed from: m */
    private Typeface f4171m;
    /* renamed from: n */
    private int f4172n;
    /* renamed from: o */
    private MyViewPager f4173o;
    /* renamed from: p */
    private TextView f4174p;
    /* renamed from: q */
    private TextView[] f4175q;
    /* renamed from: r */
    private ViewGroup f4176r;
    /* renamed from: s */
    private C0907a f4177s = new C0907a();
    /* renamed from: t */
    private C1029c f4178t;
    /* renamed from: u */
    private LoadingView f4179u;
    /* renamed from: v */
    private BroadcastReceiver f4180v = new C1595j(this);

    /* renamed from: com.shuame.rootgenius.ui.FontPreviewActivity$a */
    class C1496a extends Handler {
        C1496a() {
        }

        public final void handleMessage(Message message) {
            int c;
            switch (message.what) {
                case 1:
                    if (!C1455a.m4026a(false)) {
                        FontPreviewActivity.this.f4164f.setTextColor(Color.parseColor("#ffffff"));
                        FontPreviewActivity.this.f4164f.setEnabled(true);
                        C1440c.m3984a();
                        c = C1440c.m3987c();
                        Intent intent = new Intent(FontPreviewActivity.this, MyActivityDialog.class);
                        intent.putExtra("fontName", C1440c.m3984a().mo7174e());
                        if (c != 1) {
                            if (c == 0) {
                                intent.putExtra("type", 0);
                                FontPreviewActivity.this.startActivity(intent);
                                break;
                            }
                        }
                        intent.putExtra("type", 1);
                        FontPreviewActivity.this.startActivity(intent);
                        break;
                    }
                    break;
                case 2:
                    FontPreviewActivity.this.f4164f.setText(C1450R.string.text_btn_onekey_replace);
                    FontPreviewActivity.this.f4167i.setProgress(100);
                    Toast.makeText(FontPreviewActivity.this.getApplicationContext(), FontPreviewActivity.this.getResources().getString(C1450R.string.font_download_error), 0).show();
                    break;
                case 3:
                    if (C1440c.m3984a().mo7169b()) {
                        FontPreviewActivity.this.f4164f.setText(C1450R.string.text_font_replaceing);
                    } else {
                        FontPreviewActivity.this.f4164f.setText(C1450R.string.text_waiting_replace_font);
                    }
                    FontPreviewActivity.this.f4164f.setEnabled(false);
                    break;
                case 4:
                    FontPreviewActivity.this.f4167i.setProgress(message.arg1 / 10);
                    FontPreviewActivity.this.f4164f.setText(C1450R.string.text_downloading);
                    break;
                case 5:
                    c = ((Integer) message.obj).intValue();
                    if (FontPreviewActivity.this.f4172n == c) {
                        if (C1440c.m3984a().mo7171c(c) != null) {
                            if (C1440c.m3984a().mo7171c(c).mo7159d()) {
                                FontPreviewActivity.this.f4164f.setText(C1450R.string.text_font_replaceing);
                            } else {
                                FontPreviewActivity.this.f4164f.setText(C1450R.string.text_waiting_replace_font);
                            }
                        }
                        FontPreviewActivity.this.f4167i.setProgress(100);
                        break;
                    }
                    break;
                case 7:
                    FontPreviewActivity.this.f4164f.setText(C1450R.string.text_btn_onekey_replace);
                    FontPreviewActivity.this.f4167i.setProgress(100);
                    Toast.makeText(FontPreviewActivity.this.getApplicationContext(), FontPreviewActivity.this.getResources().getString(C1450R.string.text_replace_error_font), 0).show();
                    break;
                case 9:
                    ((ScrollView) FontPreviewActivity.this.findViewById(C1450R.id.view_Default)).setVisibility(0);
                    FontPreviewActivity.this.f4173o.setVisibility(8);
                    FontPreviewActivity.this.f4176r.setVisibility(8);
                    FontPreviewActivity.this.f4163d.setVisibility(8);
                    break;
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: a */
    private void m4218a(int i, int i2) {
        Message obtainMessage = this.f4170l.obtainMessage(i);
        obtainMessage.arg1 = i2;
        this.f4170l.sendMessage(obtainMessage);
    }

    /* renamed from: a */
    private void m4219a(TextView textView) {
        if (this.f4171m != null) {
            textView.setTypeface(this.f4171m);
        } else {
            textView.setTypeface(Typeface.DEFAULT);
        }
        textView.setText(this.f4168j.getFontName());
    }

    /* renamed from: a */
    private boolean m4221a(Font font, TextView textView) {
        if (new File(font.getThumbnailLocalPath()).exists()) {
            try {
                this.f4171m = Typeface.createFromFile(font.getThumbnailLocalPath());
                textView.setTypeface(this.f4171m);
                textView.setText(font.getFontName());
            } catch (Exception e) {
                e.printStackTrace();
                textView.setTypeface(Typeface.DEFAULT);
            }
            return true;
        }
        textView.setTypeface(Typeface.DEFAULT);
        textView.setText(font.getFontName());
        return false;
    }

    public void onComplete(int i, long j) {
        int a = C1361b.m3815a(this.f4168j.getDownloadUr());
        if (a == i) {
            if (j == 0) {
                if (!C1440c.m3984a().mo7170b(a)) {
                    C0446c.m983a(this.f4168j);
                    C1440c.m3984a().mo7164a(this.f4170l);
                    ChangeFontManager.getInstance().checkPhoneType(this);
                    C1440c.m3984a();
                    if (C1440c.m3988d()) {
                        Intent intent = new Intent(this, MyActivityDialog.class);
                        intent.putExtra("type", 2);
                        intent.putExtra("taskId", a);
                        intent.putExtra("font", this.f4168j);
                        startActivity(intent);
                        return;
                    }
                    C1440c.m3984a().mo7165a(this.f4168j, a);
                }
            } else if (j != 1) {
                m4218a(2, 0);
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.font_preview);
        ScrollView scrollView = (ScrollView) findViewById(C1450R.id.view_Default);
        this.f4176r = (ViewGroup) findViewById(C1450R.id.page_indicator);
        this.f4173o = (MyViewPager) findViewById(C1450R.id.viewPager);
        scrollView.setVisibility(8);
        this.f4163d = (RelativeLayout) findViewById(C1450R.id.loading_imageview);
        this.f4163d.setVisibility(0);
        this.f4179u = (LoadingView) this.f4163d.findViewById(C1450R.id.loading_img);
        this.f4179u.mo7087a();
        this.f4168j = (Font) getIntent().getSerializableExtra("font");
        this.f4177s.mo6005a("http://www.romzj.com/theme/androidfont.php?id=" + this.f4168j.getFontId() + "&cat=" + Build.BRAND, new C1597l(this));
        C1361b.m3817a().mo7071a((C1319h) this);
        registerReceiver(this.f4180v, new IntentFilter(C1340e.f3640k));
        this.f4178t = new C1025a().mo6247a(true).mo6241a().mo6242a((int) C1450R.drawable.font_default_preview).mo6248b((int) C1450R.drawable.font_default_preview).mo6250c((int) C1450R.drawable.font_default_preview).mo6249b();
        this.f4161b = C1324a.m3722a(getApplicationContext());
    }

    protected void onDestroy() {
        super.onDestroy();
        C1361b.m3817a().mo7074b((C1319h) this);
        unregisterReceiver(this.f4180v);
    }

    public void onDonwloadInfo(int i, LinkStruct[] linkStructArr) {
    }

    public void onFileName(int i, String str) {
    }

    public final void onLoadingComplete$5848811b(View view) {
        ((ImageView) view).setScaleType(ScaleType.FIT_CENTER);
    }

    public void onOnlySrcUrl(int i) {
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        this.f4165g = i;
        for (int i2 = 0; i2 < this.f4175q.length; i2++) {
            this.f4175q[i].setBackgroundResource(C1450R.drawable.radio_sel);
            if (i != i2) {
                this.f4175q[i2].setBackgroundResource(C1450R.drawable.radio);
            }
        }
    }

    protected void onResume() {
        new C1379b(findViewById(C1450R.id.title), (Activity) this, (int) C1450R.string.text_btn_preview_font).mo7105b();
        this.f4172n = C1361b.m3815a(this.f4168j.getDownloadUr());
        QQDownloadFile a = C1361b.m3817a().mo7068a(this.f4172n);
        this.f4164f = (Button) findViewById(C1450R.id.btn_replace);
        this.f4167i = (ProgressBar) findViewById(C1450R.id.progress);
        this.f4164f.setOnClickListener(this.f4162c);
        TextView textView = (TextView) findViewById(C1450R.id.font_size);
        String str = ((double) ((this.f4168j.getFontSize() / 1024) / 1024)) + "MB";
        textView.setText(String.format(getResources().getString(C1450R.string.text_font_size), new Object[]{str}));
        m4221a(this.f4168j, (TextView) findViewById(C1450R.id.tv_font_pre));
        m4219a((TextView) findViewById(C1450R.id.tv_font_pre2));
        m4219a((TextView) findViewById(C1450R.id.tv_font_pre3));
        m4219a((TextView) findViewById(C1450R.id.tv_font_pre4));
        m4219a((TextView) findViewById(C1450R.id.tv_font_pre5));
        m4219a((TextView) findViewById(C1450R.id.tv_font_pre6));
        new StringBuilder("conatainsReplaceMap taskId == ").append(this.f4172n);
        if (a != null) {
            switch (C1602q.f4396a[a.f3719C.ordinal()]) {
                case 1:
                case 2:
                    this.f4164f.setText(C1450R.string.text_downloading);
                    this.f4167i.setProgress(a.f3728i / 10);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    if (a.f3719C != Status.PENDING) {
                        this.f4164f.setText(C1450R.string.text_btn_onekey_replace);
                        this.f4167i.setProgress(100);
                        break;
                    }
                    this.f4164f.setText(C1450R.string.text_pending);
                    this.f4167i.setProgress(a.f3728i / 10);
                    break;
                case 8:
                    this.f4167i.setProgress(100);
                    if (C1440c.m3984a().mo7170b(this.f4172n)) {
                        if (!C1440c.m3984a().mo7171c(this.f4172n).mo7159d()) {
                            this.f4164f.setText(C1450R.string.text_waiting_replace_font);
                            break;
                        } else {
                            this.f4164f.setText(C1450R.string.text_font_replaceing);
                            break;
                        }
                    }
                    this.f4164f.setText(C1450R.string.text_btn_onekey_replace);
                    break;
            }
        }
        super.onResume();
    }

    public void onStatusChanged(int i, Status status) {
    }

    public void onStorageErrorInfo(int i, int i2, String str) {
        m4218a(2, i2);
    }

    public void onTaskInfo(int i, int i2, int i3) {
        if (C1361b.m3815a(this.f4168j.getDownloadUr()) == i) {
            m4218a(4, i2);
        }
    }

    public void onWaitStart(int i) {
    }
}
