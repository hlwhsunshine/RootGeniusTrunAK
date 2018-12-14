package com.shuame.rootgenius.p115ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.p015v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.shuame.p075ad.AdType;
import com.shuame.p075ad.C1100f;
import com.shuame.p075ad.C1106j;
import com.shuame.rootgenius.C1446g;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.p087ui.view.C1382e;
import com.shuame.rootgenius.common.p102c.C1324a;
import com.shuame.rootgenius.common.util.C1412t;
import com.shuame.rootgenius.common.util.C1416x;
import com.shuame.rootgenius.common.util.NetworkUtils;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p099c.C1314a;
import com.shuame.rootgenius.p115ui.homepage.HomepageActivity;
import com.shuame.rootgenius.sdk.CommUtils;
import com.shuame.rootgenius.sdk.RgsdkConfig;
import com.shuame.rootgenius.service.C1492j;

/* renamed from: com.shuame.rootgenius.ui.SplashActivity */
public class SplashActivity extends FragmentActivity {
    /* renamed from: a */
    private static final String f4243a = SplashActivity.class.getSimpleName();
    /* renamed from: b */
    private C1324a f4244b;
    /* renamed from: c */
    private C1100f f4245c;
    /* renamed from: d */
    private Handler f4246d = new Handler();

    /* renamed from: a */
    static /* synthetic */ void m4280a(SplashActivity splashActivity) {
        Intent intent;
        Intent intent2 = new Intent(splashActivity, HomepageActivity.class);
        try {
            int i = splashActivity.getPackageManager().getPackageInfo(splashActivity.getPackageName(), 0).versionCode;
            C1446g.m4003a();
            if (C1446g.m4016j() < i) {
                C1323b.m3688a();
                if (!C1323b.m3705j()) {
                    intent = new Intent(splashActivity, GuideActivity.class);
                } else if (splashActivity.getResources().getBoolean(C1450R.bool.is_new_feature)) {
                    intent = new Intent(splashActivity, GuideActivity.class);
                }
                splashActivity.startActivity(intent);
                splashActivity.finish();
                splashActivity.overridePendingTransition(0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        intent = intent2;
        splashActivity.startActivity(intent);
        splashActivity.finish();
        splashActivity.overridePendingTransition(0, 0);
    }

    protected void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        if (C1323b.m3688a().mo6997b("ConnTestNet", false) || C1412t.f3902a) {
            C1416x.m3937a("当前为：测试模式");
            RgsdkConfig.SetTest(true);
            C1412t.f3902a = true;
        } else {
            RgsdkConfig.SetTest(false);
        }
        RootGeniusApp.f3303c = getIntent().getStringExtra("test");
        this.f4244b = C1324a.m3722a(this);
        C1446g.m4003a();
        C1446g.m4005a(true);
        C1323b.m3688a();
        boolean j = C1323b.m3705j();
        C1446g.m4003a();
        C1446g.m4008c(!j);
        C1492j.m4165a();
        C1492j.m4175e();
        setContentView(C1450R.layout.activity_splash);
        ImageView imageView = (ImageView) findViewById(C1450R.id.iv_logo_img);
        LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
        layoutParams.topMargin = C1382e.m3848a(this, 278);
        imageView.setLayoutParams(layoutParams);
        ((TextView) findViewById(C1450R.id.tv_ver)).setText(String.format("v%s", new Object[]{CommUtils.getVersionName(this)}));
        if (C1446g.m4003a().mo7180o()) {
            findViewById(C1450R.id.iv_release_logo).setVisibility(0);
        } else {
            findViewById(C1450R.id.iv_release_logo).setVisibility(8);
        }
        String str = C1314a.f3563c;
        C1106j.m3208a();
        this.f4245c = C1106j.m3209e();
        C1106j.m3208a().mo6703a(C1412t.f3902a);
        Boolean valueOf = Boolean.valueOf(C1100f.m3193d(str));
        Boolean valueOf2 = Boolean.valueOf(NetworkUtils.m3850a());
        new StringBuilder("shouldEnable: ").append(valueOf).append(" networkdAvailable: ").append(valueOf2);
        LinearLayout linearLayout = (LinearLayout) findViewById(C1450R.id.ad_layout);
        if (valueOf.booleanValue() && valueOf2.booleanValue()) {
            linearLayout.setVisibility(0);
            this.f4245c.mo6691a(AdType.SPLASH).mo6696b(C1314a.f3564d).mo6697c(C1314a.f3565e).mo6694a(str).mo6693a(new C1538ap(this)).mo6692a(new C1537ao(this)).mo6690a().mo6695a(getSupportFragmentManager(), C1450R.id.ad_container);
            ((TextView) findViewById(C1450R.id.app_versionname)).setText(String.format("V%s", new Object[]{CommUtils.getVersionName(this)}));
        } else {
            linearLayout.setVisibility(8);
            z = false;
        }
        if (!z) {
            this.f4246d.postDelayed(new C1536an(this), 500);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onStop() {
        super.onStop();
    }
}
