package com.shuame.mobile.module.autoboot.p085ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.p070qq.p071e.comm.constants.ErrorCode.OtherError;
import com.shuame.mobile.module.autoboot.C1151a;
import com.shuame.mobile.module.autoboot.p081b.C1155a;
import com.shuame.mobile.module.autoboot.p081b.C1155a.C1152a;
import com.shuame.mobile.module.autoboot.p081b.C1155a.C1153b;
import com.shuame.mobile.module.autoboot.p083c.C1161a;
import com.shuame.mobile.module.autoboot.p083c.C1162b;
import com.shuame.mobile.module.autoboot.p085ui.p086a.C1167a;
import com.shuame.mobile.module.autoboot.p085ui.view.C1184c;
import com.shuame.mobile.module.autoboot.p085ui.view.FlowMarkView;
import com.shuame.rootgenius.common.C1150a;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.event.C1345i;
import com.shuame.rootgenius.common.p087ui.view.C1382e;
import com.shuame.rootgenius.p098b.C1312a.C1307a;
import com.shuame.rootgenius.p098b.C1312a.C1308b;
import com.shuame.rootgenius.p098b.C1312a.C1309c;
import com.shuame.rootgenius.p098b.C1312a.C1310d;
import com.shuame.rootgenius.p098b.C1312a.C1311e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.shuame.mobile.module.autoboot.ui.AutoBootManagerActivity */
public class AutoBootManagerActivity extends Activity implements OnClickListener, C1152a {
    /* renamed from: a */
    private static final String f3079a = AutoBootManagerActivity.class.getSimpleName();
    /* renamed from: b */
    private ExpandableListView f3080b;
    /* renamed from: c */
    private ArrayList<C1162b> f3081c = new ArrayList();
    /* renamed from: d */
    private C1167a f3082d;
    /* renamed from: e */
    private View f3083e;
    /* renamed from: f */
    private FlowMarkView f3084f;
    /* renamed from: g */
    private ViewGroup f3085g;
    /* renamed from: h */
    private View f3086h;
    /* renamed from: i */
    private View f3087i;
    /* renamed from: j */
    private View f3088j;
    /* renamed from: k */
    private boolean f3089k = false;
    /* renamed from: l */
    private View f3090l;
    /* renamed from: m */
    private View f3091m;
    /* renamed from: n */
    private ImageView f3092n;
    /* renamed from: o */
    private TextView f3093o;
    /* renamed from: p */
    private boolean f3094p = false;
    @SuppressLint({"HandlerLeak"})
    /* renamed from: q */
    private Handler f3095q = new C1170a(this);
    /* renamed from: r */
    private C1153b f3096r = new C1175f(this);

    /* renamed from: com.shuame.mobile.module.autoboot.ui.AutoBootManagerActivity$CheckState */
    public enum CheckState {
        check,
        normal
    }

    /* renamed from: com.shuame.mobile.module.autoboot.ui.AutoBootManagerActivity$a */
    private class C1164a implements Runnable {
        private C1164a() {
        }

        /* synthetic */ C1164a(AutoBootManagerActivity autoBootManagerActivity, byte b) {
            this();
        }

        public final void run() {
            C1155a.m3315a().mo6753a(AutoBootManagerActivity.this.f3096r);
            C1155a.m3315a().mo6761c();
        }
    }

    /* renamed from: b */
    private static void m3348b() {
        Intent intent = new Intent();
        C1323b.m3688a();
        if (!C1323b.m3705j()) {
            intent.putExtra("EXTAR_ACTIVITY", "GuideActivity");
            intent.addFlags(268435456);
        } else if (!C1323b.m3693b()) {
            intent.putExtra("EXTAR_ACTIVITY", "HomepageActivity");
        }
        if (intent.hasExtra("EXTAR_ACTIVITY")) {
            C1150a.m3309a(C1151a.m3312b(), intent);
        }
    }

    /* renamed from: c */
    private synchronized void m3349c() {
        this.f3081c.clear();
        List a = C1155a.m3315a().mo6749a(C1161a.f3055c);
        List a2 = C1155a.m3315a().mo6749a(C1161a.f3056d);
        if (a.size() > 0) {
            this.f3081c.add(new C1162b(getString(C1311e.groupName_auto_boot_disable), a, true));
            this.f3080b.expandGroup(this.f3081c.size() - 1);
        }
        if (a2.size() > 0) {
            this.f3081c.add(new C1162b(getString(C1311e.groupName_auto_boot_keep), a2, false));
            this.f3080b.expandGroup(this.f3081c.size() - 1);
        }
        if (this.f3081c.size() > 0) {
            this.f3082d.notifyDataSetChanged();
            this.f3080b.setVisibility(0);
            this.f3090l.setVisibility(8);
            int b = C1155a.m3315a().mo6756b();
            this.f3084f.setAppNum(b);
            if (b == 0) {
                this.f3087i.setBackgroundResource(C1308b.green_gradient_bg);
            }
            this.f3089k = true;
            this.f3084f.mo6804c();
            Animation c1184c = new C1184c(this.f3085g, C1382e.m3848a(getApplicationContext(), 135));
            c1184c.setInterpolator(new AccelerateDecelerateInterpolator());
            c1184c.setDuration(500);
            this.f3085g.startAnimation(c1184c);
            Animation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, (float) this.f3088j.getHeight(), 0, 0.0f);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            translateAnimation.setDuration(500);
            translateAnimation.setAnimationListener(new C1172c(this));
            this.f3088j.startAnimation(translateAnimation);
        } else {
            this.f3080b.setVisibility(8);
            this.f3090l.setVisibility(0);
            this.f3085g.setVisibility(8);
            this.f3086h.setVisibility(8);
            this.f3083e.setBackgroundColor(getResources().getColor(C1307a.commom_blue));
        }
    }

    /* renamed from: a */
    public final void mo6746a(int i) {
        runOnUiThread(new C1176g(this, i));
    }

    public void onBackPressed() {
        super.onBackPressed();
        AutoBootManagerActivity.m3348b();
    }

    public void onClick(View view) {
        if (view.getId() == C1309c.backBtn) {
            finish();
            AutoBootManagerActivity.m3348b();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1310d.auto_boot_mamager);
        C1345i.m3749a().mo7027i();
        this.f3083e = findViewById(C1309c.titlebar);
        this.f3085g = (ViewGroup) findViewById(C1309c.flowLayout);
        this.f3084f = (FlowMarkView) findViewById(C1309c.flowMarkView);
        this.f3087i = findViewById(C1309c.outsidelayout);
        this.f3086h = findViewById(C1309c.placeHolder);
        this.f3084f.setAppNum(C1155a.m3315a().mo6756b());
        this.f3087i.setBackgroundResource(C1308b.yellow_gradient_bg);
        this.f3080b = (ExpandableListView) findViewById(C1309c.self_boot_list);
        this.f3082d = new C1167a(this, this.f3081c, this, this.f3080b);
        this.f3080b.setAdapter(this.f3082d);
        this.f3080b.setOnGroupCollapseListener(new C1173d(this));
        this.f3080b.setOnChildClickListener(this.f3082d);
        this.f3084f.setOnClickListener(new C1174e(this));
        this.f3088j = findViewById(C1309c.result_layout);
        this.f3090l = findViewById(C1309c.ok_layout);
        this.f3091m = findViewById(C1309c.bottom);
        this.f3092n = (ImageView) findViewById(C1309c.img_err);
        this.f3093o = (TextView) findViewById(C1309c.tv_err_desc);
        this.f3091m.setVisibility(8);
        this.f3092n.setImageResource(C1308b.update_app_ok);
        this.f3093o.setText(C1311e.no_app_auto_boot);
        this.f3083e.getLayoutParams().height = C1382e.m3848a(this, 135);
        this.f3084f.getLayoutParams().height = C1382e.m3848a(this, OtherError.CONTAINER_INVISIBLE_ERROR);
        this.f3086h.getLayoutParams().height = C1382e.m3848a(this, OtherError.CONTAINER_INVISIBLE_ERROR);
        findViewById(C1309c.backBtn).setOnClickListener(this);
        this.f3084f.mo6803b();
        new Thread(new C1164a(this, (byte) 0)).start();
        C1155a.m3315a().mo6752a((C1152a) this);
        C1155a.m3315a().mo6751a(this.f3082d);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1155a.m3315a().mo6760b(this.f3096r);
        C1155a.m3315a().mo6759b((C1152a) this);
        C1155a.m3315a().mo6758b(this.f3082d);
        if (this.f3084f != null) {
            this.f3084f.mo6802a();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C1345i.m3749a().mo7027i();
    }
}
