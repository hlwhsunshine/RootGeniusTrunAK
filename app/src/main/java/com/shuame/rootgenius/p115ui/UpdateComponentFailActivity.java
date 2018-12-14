package com.shuame.rootgenius.p115ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.service.C1492j;

/* renamed from: com.shuame.rootgenius.ui.UpdateComponentFailActivity */
public class UpdateComponentFailActivity extends Activity implements OnClickListener {
    public void onClick(View view) {
        switch (view.getId()) {
            case C1450R.id.btn_done:
                finish();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.activity_update_component_fail);
        findViewById(C1450R.id.btn_done).setOnClickListener(this);
    }

    public void onStart() {
        C1492j.m4165a();
        C1492j.m4174d();
        super.onStart();
    }
}
