package com.shuame.rootgenius.p115ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.C1446g;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.util.C1412t;
import com.shuame.rootgenius.common.util.C1416x;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p111h.C1447a;
import com.shuame.rootgenius.p113i.C1455a;
import com.shuame.rootgenius.p115ui.homepage.HomepageActivity;
import com.shuame.rootgenius.sdk.CommUtils;
import com.shuame.rootgenius.sdk.RgsdkConfig;
import com.shuame.rootgenius.sdk.proto.ProtoData.ActExit;

/* renamed from: com.shuame.rootgenius.ui.z */
final class C1616z implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ GuideActivity f4567a;

    C1616z(GuideActivity guideActivity) {
        this.f4567a = guideActivity;
    }

    public final void onClick(View view) {
        switch (view.getId()) {
            case C1450R.id.iv_logo_name:
                this.f4567a.f4211h = this.f4567a.f4211h + 1;
                if (this.f4567a.f4211h > 10 && !RgsdkConfig.TEST) {
                    RgsdkConfig.SetTest(true);
                    C1412t.f3902a = true;
                    C1323b.m3688a().mo6996a("ConnTestNet", true);
                }
                if (RgsdkConfig.TEST && C1412t.f3902a) {
                    C1416x.m3937a("已开启：测试模式");
                    return;
                }
                return;
            case C1450R.id.tv_read_treaty:
                this.f4567a.startActivity(new Intent(this.f4567a, TreatyActivity.class));
                return;
            case C1450R.id.btn_login:
                if (!C1455a.m4025a()) {
                    C1447a c1447a = new C1447a();
                    ActExit actExit = new ActExit();
                    actExit.mac = CommUtils.getWifiMacAddr(this.f4567a);
                    actExit.code = 1;
                    c1447a.mo7186a(actExit);
                    C1323b.m3688a();
                    C1323b.m3706k();
                    C1446g.m4003a();
                    C1446g.m4018l();
                    C1446g.m4003a();
                    C1446g.m4004a(this.f4567a.f4209f);
                    this.f4567a.startActivity(new Intent(this.f4567a, HomepageActivity.class));
                    this.f4567a.finish();
                    this.f4567a.overridePendingTransition(0, 0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
