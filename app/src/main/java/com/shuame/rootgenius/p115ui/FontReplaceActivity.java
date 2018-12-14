package com.shuame.rootgenius.p115ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.changefontmanager.sdk.ChangeFontManager;
import com.example.myfontsdk.C0446c;
import com.example.myfontsdk.Font;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.manager.AppManager.AppStatus;
import com.shuame.rootgenius.common.manager.AppManager.C1318c;
import com.shuame.rootgenius.common.manager.AppManager.C1348b;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.common.p102c.C1324a;
import com.shuame.rootgenius.common.qqdownload.C1319h;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;
import com.shuame.rootgenius.common.util.C1411s;
import com.shuame.rootgenius.common.util.C1415w;
import com.shuame.rootgenius.common.util.NetworkUtils;
import com.shuame.rootgenius.common.util.NetworkUtils.NetworkType;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p110g.C1440c;
import com.shuame.rootgenius.p115ui.adapter.FontListAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

/* renamed from: com.shuame.rootgenius.ui.FontReplaceActivity */
public class FontReplaceActivity extends Activity implements C1318c {
    /* renamed from: f */
    private static final String f4182f = FontReplaceActivity.class.getSimpleName();
    /* renamed from: a */
    final Handler f4183a = new C1497a();
    /* renamed from: b */
    Properties f4184b = new Properties();
    /* renamed from: c */
    C1324a f4185c;
    /* renamed from: d */
    OnItemClickListener f4186d = new C1608u(this);
    /* renamed from: e */
    C1319h f4187e = new C1609v(this);
    /* renamed from: g */
    private boolean f4188g = false;
    /* renamed from: h */
    private final String f4189h = "http://upaicdn.xinmei365.com/support/zitiguanjia_sjjl.apk";
    /* renamed from: i */
    private ArrayList<Font> f4190i = new ArrayList();
    /* renamed from: j */
    private ProgressBar f4191j;
    /* renamed from: k */
    private View f4192k;
    /* renamed from: l */
    private TextView f4193l;
    /* renamed from: m */
    private FontListAdapter f4194m;
    /* renamed from: n */
    private View f4195n;
    /* renamed from: o */
    private boolean f4196o = true;
    /* renamed from: p */
    private ListView f4197p;
    /* renamed from: q */
    private BroadcastReceiver f4198q = new C1613w(this);

    /* renamed from: com.shuame.rootgenius.ui.FontReplaceActivity$a */
    class C1497a extends Handler {
        C1497a() {
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    FontReplaceActivity.this.f4193l.setText(FontReplaceActivity.this.getResources().getText(C1450R.string.font_download_error));
                    FontReplaceActivity.this.f4191j.setVisibility(8);
                    break;
                case 3:
                    FontReplaceActivity.this.f4193l.setText(FontReplaceActivity.this.getResources().getText(C1450R.string.install_zitiguanjia));
                    FontReplaceActivity.this.f4191j.setVisibility(8);
                    break;
                case 4:
                    FontReplaceActivity.this.f4191j.setProgress(message.arg1 / 10);
                    break;
                case 5:
                    FontReplaceActivity.this.f4193l.setText(FontReplaceActivity.this.getResources().getText(C1450R.string.font_text));
                    FontReplaceActivity.this.f4191j.setVisibility(8);
                    break;
                case 6:
                    FontReplaceActivity.this.f4193l.setText(FontReplaceActivity.this.getResources().getText(C1450R.string.font_stop_download));
                    FontReplaceActivity.this.f4191j.setVisibility(8);
                    break;
                case 7:
                    FontReplaceActivity.this.f4193l.setText(C1450R.string.font_install_finish);
                    FontReplaceActivity.this.f4191j.setVisibility(8);
                    break;
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: a */
    private void m4235a(int i, int i2) {
        Message obtainMessage = this.f4183a.obtainMessage(i);
        obtainMessage.arg1 = i2;
        this.f4183a.sendMessage(obtainMessage);
    }

    /* renamed from: c */
    private void m4242c() {
        String str = Build.MANUFACTURER;
        this.f4192k = findViewById(C1450R.id.exception_error_layout);
        this.f4190i = (ArrayList) C0446c.m981a();
        for (int i = 0; i < this.f4190i.size(); i++) {
            new StringBuilder("name ==").append(((Font) this.f4190i.get(i)).getFontName()).append(" || id == ").append(((Font) this.f4190i.get(i)).getFontId());
        }
        ChangeFontManager.getInstance().setCustomizedSu(C1415w.m3932a());
        this.f4194m = new FontListAdapter(this, this.f4197p);
        this.f4194m.mo7398a(this.f4190i);
        this.f4193l = (TextView) this.f4195n.findViewById(C1450R.id.tv_font_text);
        this.f4191j = (ProgressBar) this.f4195n.findViewById(C1450R.id.progress);
        C1440c.m3984a().mo7167a(this.f4190i);
        this.f4197p.setAdapter(this.f4194m);
        this.f4197p.setOnItemClickListener(this.f4186d);
        ((TextView) findViewById(C1450R.id.tv_err_desc)).setText(C1450R.string.no_net);
        Button button = (Button) findViewById(C1450R.id.btn2);
        button.setText(C1450R.string.setnow);
        button.setOnClickListener(new C1607t(this));
        if (!NetworkUtils.m3851a(this)) {
            this.f4196o = false;
            this.f4192k.setVisibility(0);
            this.f4197p.setVisibility(8);
        } else if (NetworkUtils.m3853c().equals(NetworkType.WIFI)) {
            File d = FontReplaceActivity.m4244d();
            if (d != null && !d.exists() && C1411s.m3926b(d.getAbsolutePath()) > 600000) {
                QQDownloadFile a = C1361b.m3817a().mo7068a(C1361b.m3815a("http://upaicdn.xinmei365.com/support/zitiguanjia_sjjl.apk"));
                if (a == null) {
                    a = new QQDownloadFile();
                    a.f3724e = "http://upaicdn.xinmei365.com/support/zitiguanjia_sjjl.apk";
                    a.f3725f = d.getAbsolutePath();
                    a.f3717A = -1;
                    a.f3734o = Type.FONT_MANAGER;
                }
                C1361b.m3817a().mo7067a(a, null);
                new StringBuilder("networkType startDownload downloadFile.long5 ==").append(a.f3717A);
            }
        }
    }

    /* renamed from: d */
    private static File m4244d() {
        String b = C1411s.m3928b(true);
        if (b == null || "".equals(b)) {
            b = C1411s.m3923a(true);
            if (b == null || "".equals(b)) {
                return null;
            }
        }
        return new File(b + "/zitiguanjia.apk");
    }

    /* renamed from: a */
    public final boolean mo7352a(String str) {
        try {
            return getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception e) {
            return false;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.font_listview);
        new C1379b(findViewById(C1450R.id.title), (Activity) this, (int) C1450R.string.text_btn_replace_font).mo7105b();
        this.f4185c = C1324a.m3722a(getApplicationContext());
        this.f4197p = (ListView) findViewById(C1450R.id.list);
        this.f4195n = getLayoutInflater().inflate(C1450R.layout.font_footer_view, null);
        this.f4197p.addFooterView(this.f4195n);
        m4242c();
        registerReceiver(this.f4198q, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        registerReceiver(this.f4198q, new IntentFilter(C1340e.f3640k));
        C1361b.m3817a().mo7071a(C1440c.m3984a());
        C1361b.m3817a().mo7071a(this.f4194m);
    }

    public void onDestroy() {
        super.onDestroy();
        C1361b.m3817a().mo7074b(this.f4194m);
        C1361b.m3817a().mo7074b(this.f4187e);
        unregisterReceiver(this.f4198q);
        this.f4194m.mo7397a();
        C1440c.f3951a = true;
    }

    protected void onResume() {
        this.f4194m.notifyDataSetChanged();
        super.onResume();
    }

    protected void onStart() {
        super.onStart();
        this.f4194m.mo7399a(true);
        this.f4194m.notifyDataSetChanged();
        C1440c.f3951a = false;
    }

    public void onStatusChanged(C1348b c1348b) {
        if (c1348b.f3679d == AppStatus.SYSTEM_INSTALL) {
            m4235a(5, 0);
        } else if (c1348b.f3679d == AppStatus.SILENT_INSTALL_SUCCESS) {
            m4235a(7, 0);
        }
    }

    protected void onStop() {
        super.onStop();
        this.f4194m.mo7399a(false);
    }
}
