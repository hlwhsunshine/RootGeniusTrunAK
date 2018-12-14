package com.shuame.rootgenius.p115ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.ui.SeeSolutionActivity */
public class SeeSolutionActivity extends Activity implements OnClickListener {
    /* renamed from: a */
    private TextView f4223a;

    public void onClick(View view) {
        switch (view.getId()) {
            case C1450R.id.tv_see_solution_getinpc:
                startActivity(new Intent(RootGeniusApp.m3523a(), JointPCActivity.class));
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.activity_see_solution);
        new C1379b(findViewById(C1450R.id.v_titlebar), (Activity) this, (int) C1450R.string.more_see_solution_title).mo7105b();
        this.f4223a = (TextView) findViewById(C1450R.id.tv_see_solution_getinpc);
        this.f4223a.setOnClickListener(this);
    }
}
