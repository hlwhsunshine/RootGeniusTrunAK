package com.shuame.rootgenius.p115ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.event.C1345i;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.common.util.C1416x;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p113i.C1455a;
import com.shuame.rootgenius.service.C1492j;

/* renamed from: com.shuame.rootgenius.ui.RootFailActivity */
public class RootFailActivity extends Activity implements OnClickListener {
    public void onClick(View view) {
        if (!C1455a.m4025a()) {
            switch (view.getId()) {
                case C1450R.id.btn_join_pc_root:
                    startActivity(new Intent(this, JointPCActivity.class));
                    finish();
                    return;
                case C1450R.id.btn_continue_root:
                    if (!C1345i.m3749a().mo7020b()) {
                        RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3640k));
                        C1323b.m3697d(true);
                        break;
                    }
                    C1416x.m3936a((int) C1450R.string.jointed_core_func_goto_pc_operation);
                    break;
                case C1450R.id.btn_back:
                    break;
                default:
                    return;
            }
            finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.activity_root_fail);
        new C1379b(findViewById(C1450R.id.v_titlebar), (Activity) this, (int) C1450R.string.app_name).mo7105b();
        findViewById(C1450R.id.btn_join_pc_root).setOnClickListener(this);
        findViewById(C1450R.id.btn_continue_root).setOnClickListener(this);
        ((TextView) findViewById(C1450R.id.tv_percent)).setText(String.valueOf(C1323b.m3688a().mo6999e("pc_root_probability")));
    }

    public void onStart() {
        C1492j.m4165a();
        C1492j.m4174d();
        super.onStart();
    }
}
