package com.shuame.rootgenius.p115ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.p070qq.p071e.comm.constants.ErrorCode.InitError;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.event.C1345i;
import com.shuame.rootgenius.common.event.C1345i.C1344a;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.common.p087ui.view.C1382e;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p115ui.homepage.HomepageActivity;

/* renamed from: com.shuame.rootgenius.ui.JointPCActivity */
public class JointPCActivity extends Activity implements C1344a {
    /* renamed from: a */
    private static final String f4214a = JointPCActivity.class.getSimpleName();
    /* renamed from: b */
    private View f4215b;
    /* renamed from: c */
    private View f4216c;
    /* renamed from: d */
    private ImageView f4217d;

    /* renamed from: b */
    private void m4255b() {
        if (C1345i.m3749a().mo7020b()) {
            this.f4215b.setVisibility(8);
            this.f4216c.setVisibility(0);
            return;
        }
        this.f4215b.setVisibility(0);
        this.f4216c.setVisibility(8);
    }

    /* renamed from: a */
    public final void mo7014a() {
        m4255b();
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = null;
        C1323b.m3688a();
        if (!C1323b.m3705j()) {
            intent = new Intent(this, GuideActivity.class);
            intent.addFlags(268435456);
        } else if (!C1323b.m3693b()) {
            intent = new Intent(this, HomepageActivity.class);
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.activity_joint_pc);
        C1345i.m3749a().mo7025g();
        new C1379b(findViewById(C1450R.id.v_titlebar), (Activity) this, (int) C1450R.string.root_done_fail_join_pc_button_text).mo7105b();
        this.f4215b = findViewById(C1450R.id.view_joint_pc_guide);
        this.f4216c = findViewById(C1450R.id.view_jointed_pc);
        this.f4217d = (ImageView) findViewById(C1450R.id.iv_joint_pc_img);
        C1345i.m3749a().mo7015a((C1344a) this);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(C1382e.m3849b(this, 588), C1382e.m3848a(this, 569));
        layoutParams.topMargin = C1382e.m3848a(this, InitError.INIT_AD_ERROR);
        layoutParams.bottomMargin = C1382e.m3848a(this, 80);
        layoutParams.gravity = 1;
        this.f4217d.setLayoutParams(layoutParams);
        this.f4217d.setScaleType(ScaleType.FIT_XY);
        m4255b();
    }

    protected void onDestroy() {
        super.onDestroy();
        C1345i.m3749a().mo7018b((C1344a) this);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C1345i.m3749a().mo7025g();
    }
}
