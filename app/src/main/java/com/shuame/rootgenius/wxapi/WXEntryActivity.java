package com.shuame.rootgenius.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.shuame.rootgenius.common.manager.p104a.C1354c;

public class WXEntryActivity extends Activity {
    /* renamed from: a */
    private static final String f4568a = WXEntryActivity.class.getSimpleName();
    /* renamed from: b */
    private boolean f4569b;
    /* renamed from: c */
    private int f4570c;

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.f4570c == 1000) {
            C1354c.m3794a().mo7044a(intent);
        }
    }

    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f4569b = true;
        this.f4570c = getIntent().getIntExtra("key_wechat_activity_type", 0);
        switch (this.f4570c) {
            case 1000:
                C1354c.m3794a().mo7042a((Activity) this);
                return;
            default:
                C1354c.m3794a().mo7044a(getIntent());
                finish();
                return;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.f4570c == 1000) {
            C1354c.m3794a().mo7044a(intent);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.f4569b) {
            this.f4569b = false;
        } else {
            finish();
        }
    }
}
