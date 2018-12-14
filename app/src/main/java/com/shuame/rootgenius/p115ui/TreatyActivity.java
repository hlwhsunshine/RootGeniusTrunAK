package com.shuame.rootgenius.p115ui;

import android.app.Activity;
import android.os.Bundle;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.ui.TreatyActivity */
public class TreatyActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.activity_treaty);
        new C1379b(findViewById(C1450R.id.v_titlebar), (Activity) this, (int) C1450R.string.treaty_title).mo7105b();
    }
}
