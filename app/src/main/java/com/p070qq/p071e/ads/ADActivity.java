package com.p070qq.p071e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.p070qq.p071e.comm.managers.GDTADManager;
import com.p070qq.p071e.comm.p073pi.ACTD;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.StringUtil;

/* renamed from: com.qq.e.ads.ADActivity */
public class ADActivity extends Activity {
    /* renamed from: a */
    private ACTD f2681a;

    public void onBackPressed() {
        super.onBackPressed();
        if (this.f2681a != null) {
            this.f2681a.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f2681a != null) {
            this.f2681a.onConfigurationChanged(configuration);
        }
    }

    protected void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        String string = intent.getExtras().getString(ACTD.DELEGATE_NAME_KEY);
        String string2 = intent.getExtras().getString("appid");
        if (!(StringUtil.isEmpty(string) || StringUtil.isEmpty(string2))) {
            try {
                if (GDTADManager.getInstance().initWith(getApplicationContext(), string2)) {
                    this.f2681a = GDTADManager.getInstance().getPM().getPOFactory().getActivityDelegate(string, this);
                    if (this.f2681a == null) {
                        GDTLogger.m3131e("Init ADActivity Delegate return null,delegateName" + string);
                    }
                } else {
                    GDTLogger.m3131e("Init GDTADManager fail in AdActivity");
                }
            } catch (Throwable th) {
                GDTLogger.m3132e("Init ADActivity Delegate Faile,DelegateName:" + string, th);
            }
        }
        if (this.f2681a != null) {
            this.f2681a.onBeforeCreate(bundle);
        } else {
            finish();
        }
        super.onCreate(bundle);
        if (this.f2681a != null) {
            this.f2681a.onAfterCreate(bundle);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f2681a != null) {
            this.f2681a.onDestroy();
        }
    }

    public void onPause() {
        if (this.f2681a != null) {
            this.f2681a.onPause();
        }
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        if (this.f2681a != null) {
            this.f2681a.onResume();
        }
    }

    protected void onStop() {
        if (this.f2681a != null) {
            this.f2681a.onStop();
        }
        super.onStop();
    }
}
