package com.shuame.rootgenius.appmanager.p096ui.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.support.p015v4.view.ViewPager;
import android.support.p015v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.shuame.rootgenius.appmanager.C1253a;
import com.shuame.rootgenius.appmanager.p090a.C1251a;
import com.shuame.rootgenius.appmanager.p091b.C1254a;
import com.shuame.rootgenius.appmanager.p091b.C1259d;
import com.shuame.rootgenius.appmanager.p091b.C1259d.C1258b;
import com.shuame.rootgenius.appmanager.p094d.C1267b;
import com.shuame.rootgenius.appmanager.p095f.C1270a;
import com.shuame.rootgenius.appmanager.p095f.C1272b.C1271a;
import com.shuame.rootgenius.appmanager.p096ui.p097a.C1274a;
import com.shuame.rootgenius.appmanager.p096ui.p097a.C1276b;
import com.shuame.rootgenius.appmanager.p096ui.p097a.C1280c;
import com.shuame.rootgenius.appmanager.p096ui.view.SwipeDismissListView;
import com.shuame.rootgenius.common.C1150a;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.event.C1345i;
import com.shuame.rootgenius.common.p087ui.LoadingView;
import com.shuame.rootgenius.p089a.C1248a.C1245c;
import com.shuame.rootgenius.p089a.C1248a.C1246d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.shuame.rootgenius.appmanager.ui.activity.AppUninstallActivity */
public class AppUninstallActivity extends Activity implements OnClickListener, C1258b {
    /* renamed from: A */
    private TextView f3466A;
    /* renamed from: B */
    private C1254a f3467B;
    /* renamed from: C */
    private Handler f3468C = new C1287a(this);
    /* renamed from: D */
    private BroadcastReceiver f3469D = new C1289c(this);
    /* renamed from: E */
    private BroadcastReceiver f3470E = new C1290d(this);
    /* renamed from: F */
    private TextView f3471F;
    /* renamed from: a */
    private String f3472a;
    /* renamed from: b */
    private List<C1254a> f3473b;
    /* renamed from: c */
    private List<C1254a> f3474c;
    /* renamed from: d */
    private List<C1254a> f3475d;
    /* renamed from: e */
    private List<C1254a> f3476e;
    /* renamed from: f */
    private C1271a f3477f;
    /* renamed from: g */
    private Context f3478g = this;
    /* renamed from: h */
    private C1259d f3479h;
    /* renamed from: i */
    private ImageView f3480i;
    /* renamed from: j */
    private int f3481j = 0;
    /* renamed from: k */
    private TextView f3482k;
    /* renamed from: l */
    private TextView f3483l;
    /* renamed from: m */
    private ViewPager f3484m;
    /* renamed from: n */
    private List<View> f3485n;
    /* renamed from: o */
    private int f3486o = 0;
    /* renamed from: p */
    private SwipeDismissListView f3487p;
    /* renamed from: q */
    private SwipeDismissListView f3488q;
    /* renamed from: r */
    private View f3489r;
    /* renamed from: s */
    private View f3490s;
    /* renamed from: t */
    private Button f3491t;
    /* renamed from: u */
    private ImageView f3492u;
    /* renamed from: v */
    private C1280c f3493v;
    /* renamed from: w */
    private C1276b f3494w;
    /* renamed from: x */
    private View f3495x;
    /* renamed from: y */
    private LoadingView f3496y;
    /* renamed from: z */
    private View f3497z;

    /* renamed from: com.shuame.rootgenius.appmanager.ui.activity.AppUninstallActivity$a */
    public class C1285a implements OnClickListener {
        /* renamed from: b */
        private int f3464b = 0;

        public C1285a(int i) {
            this.f3464b = i;
        }

        public final void onClick(View view) {
            AppUninstallActivity.this.f3484m.setCurrentItem(this.f3464b);
        }
    }

    /* renamed from: com.shuame.rootgenius.appmanager.ui.activity.AppUninstallActivity$b */
    public class C1286b implements OnPageChangeListener {
        public final void onPageScrollStateChanged(int i) {
        }

        public final void onPageScrolled(int i, float f, int i2) {
        }

        public final void onPageSelected(int i) {
            Animation animation = null;
            switch (i) {
                case 0:
                    if (AppUninstallActivity.this.f3486o == 1) {
                        animation = new TranslateAnimation((float) AppUninstallActivity.this.f3481j, 0.0f, 0.0f, 0.0f);
                        break;
                    }
                    break;
                case 1:
                    if (AppUninstallActivity.this.f3486o == 0) {
                        animation = new TranslateAnimation(0.0f, (float) AppUninstallActivity.this.f3481j, 0.0f, 0.0f);
                        break;
                    }
                    break;
            }
            AppUninstallActivity.this.f3486o = i;
            animation.setFillAfter(true);
            animation.setDuration(300);
            AppUninstallActivity.this.f3480i.startAnimation(animation);
        }
    }

    /* renamed from: e */
    private static void m3632e() {
        Intent intent = new Intent();
        C1323b.m3688a();
        if (!C1323b.m3705j()) {
            intent.putExtra("EXTAR_ACTIVITY", "GuideActivity");
            intent.addFlags(268435456);
        } else if (!C1323b.m3693b()) {
            intent.putExtra("EXTAR_ACTIVITY", "HomepageActivity");
        }
        if (intent.hasExtra("EXTAR_ACTIVITY")) {
            C1150a.m3309a(C1253a.m3545a(), intent);
        }
    }

    /* renamed from: a */
    public final void mo6895a() {
        mo6947d();
        if (this.f3493v != null) {
            this.f3493v.notifyDataSetChanged();
        }
    }

    /* renamed from: b */
    public final Handler mo6945b() {
        return this.f3468C;
    }

    /* renamed from: c */
    public final void mo6946c() {
        if (this.f3479h.mo6904b().booleanValue()) {
            this.f3479h.mo6898a(this.f3475d.size() - 1);
            if (this.f3475d.size() != 0 && ((C1254a) this.f3475d.get(0)).f3345i == 2) {
                C1259d.m3569l().setVisibility(0);
            }
            this.f3493v = new C1280c(this, this.f3475d, this.f3472a);
        } else {
            this.f3493v = new C1280c(this, this.f3474c, this.f3472a);
        }
        this.f3494w = new C1276b(this, this.f3473b, this.f3472a);
        this.f3487p.setAdapter(this.f3493v);
        this.f3487p.setOnDismissCallback(new C1292e(this));
        this.f3488q.setAdapter(this.f3494w);
        this.f3488q.setOnDismissCallback(new C1293f(this));
        if (this.f3473b.isEmpty()) {
            this.f3488q.setVisibility(8);
            this.f3471F.setVisibility(0);
        }
    }

    /* renamed from: d */
    public final void mo6947d() {
        long a = this.f3479h.mo6896a("recyclebin");
        this.f3491t.setText(a == 0 ? "回收站" : "回收站(" + a + ")");
    }

    public void onBackPressed() {
        super.onBackPressed();
        AppUninstallActivity.m3632e();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == C1245c.btn_recycle) {
            if (C1259d.f3371m || System.currentTimeMillis() - C1259d.f3369k >= 1500) {
                startActivity(new Intent(this, RecycleBinActivity.class));
            } else {
                Toast.makeText(this.f3478g, "回收站初始化中，请稍等", 0).show();
            }
        } else if (id == C1245c.iv_back) {
            finish();
            AppUninstallActivity.m3632e();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1246d.app_manager);
        C1345i.m3749a().mo7026h();
        this.f3479h = C1259d.m3554a((Context) this);
        new StringBuilder("appInfoCounts: ").append(this.f3479h.mo6896a("recyclebin"));
        this.f3474c = this.f3479h.mo6908d();
        this.f3473b = this.f3479h.mo6909e();
        this.f3476e = this.f3479h.mo6910f();
        this.f3475d = this.f3479h.mo6911g();
        this.f3479h.mo6900a((C1258b) this);
        this.f3480i = (ImageView) findViewById(C1245c.cusor);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f3481j = displayMetrics.widthPixels / 2;
        Matrix matrix = new Matrix();
        matrix.postTranslate((float) this.f3481j, 0.0f);
        this.f3480i.setImageMatrix(matrix);
        this.f3482k = (TextView) findViewById(C1245c.tv_systemApp);
        this.f3483l = (TextView) findViewById(C1245c.tv_app);
        this.f3492u = (ImageView) findViewById(C1245c.iv_back);
        this.f3492u.setOnClickListener(this);
        this.f3482k.setOnClickListener(new C1285a(0));
        this.f3483l.setOnClickListener(new C1285a(1));
        LayoutInflater layoutInflater = getLayoutInflater();
        this.f3484m = (ViewPager) findViewById(C1245c.viewPager);
        this.f3485n = new ArrayList();
        this.f3489r = layoutInflater.inflate(C1246d.sysapp_list, null);
        this.f3490s = layoutInflater.inflate(C1246d.app_list, null);
        this.f3485n.add(this.f3489r);
        this.f3485n.add(this.f3490s);
        this.f3484m.setAdapter(new C1274a(this.f3485n));
        this.f3484m.setCurrentItem(0);
        this.f3484m.setOnPageChangeListener(new C1286b());
        this.f3497z = this.f3489r.findViewById(C1245c.get_root_indication);
        getLayoutInflater();
        this.f3487p = (SwipeDismissListView) this.f3489r.findViewById(C1245c.lv_sysapp);
        this.f3488q = (SwipeDismissListView) this.f3490s.findViewById(C1245c.lv_applist);
        this.f3471F = (TextView) this.f3490s.findViewById(C1245c.normal_app_empty);
        this.f3466A = (TextView) this.f3489r.findViewById(C1245c.tv_preinstallapp_empty);
        C1259d.m3559a(this.f3487p);
        C1259d.m3560b(this.f3488q);
        C1259d.m3558a(this.f3466A);
        this.f3491t = (Button) this.f3489r.findViewById(C1245c.btn_recycle);
        this.f3491t.setOnClickListener(this);
        C1259d.m3557a(this.f3491t);
        mo6947d();
        this.f3495x = findViewById(C1245c.background_loading);
        this.f3496y = (LoadingView) findViewById(C1245c.loading_img);
        this.f3484m.setVisibility(8);
        this.f3495x.setVisibility(0);
        this.f3496y.mo7087a();
        this.f3472a = C1270a.m3605a((Context) this);
        C1259d.m3564c(this.f3472a);
        new StringBuilder("busybox path: ").append(C1259d.m3570m());
        C1259d.m3561b(Boolean.valueOf(false));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(C1267b.f3394a);
        intentFilter.addAction(C1340e.f3630a);
        registerReceiver(this.f3470E, intentFilter);
        if (!C1259d.f3362d.booleanValue()) {
            new C1251a(this, this.f3473b, this.f3474c, this.f3476e, this.f3475d, this.f3479h).start();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f3470E);
        C1259d.m3560b(null);
        C1259d.m3559a(null);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C1345i.m3749a().mo7026h();
    }
}
