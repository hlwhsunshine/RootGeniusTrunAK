package com.shuame.rootgenius.p115ui.rootremove;

import android.os.Bundle;
import android.support.p015v4.app.Fragment;
import android.support.p015v4.app.FragmentActivity;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.service.C1492j;

/* renamed from: com.shuame.rootgenius.ui.rootremove.RootRemoveDoneActivity */
public class RootRemoveDoneActivity extends FragmentActivity {
    /* renamed from: a */
    private static final String f4399a = RootRemoveDoneActivity.class.getSimpleName();

    protected void onCreate(Bundle bundle) {
        Fragment c1604a;
        super.onCreate(bundle);
        setContentView(C1450R.layout.activity_def_container);
        if (C1323b.m3698d()) {
            c1604a = new C1604a();
            getApplicationContext();
            if (C1387ad.m3870b()) {
                C1492j.m4165a();
                C1492j.m4166a(this, getString(C1450R.string.notify_root_rm_fail));
            }
        } else {
            c1604a = new C1605b();
            getApplicationContext();
            if (C1387ad.m3870b()) {
                C1492j.m4165a();
                C1492j.m4166a(getApplicationContext(), getString(C1450R.string.notify_root_rm_succ));
            }
        }
        getSupportFragmentManager().beginTransaction().replace(C1450R.id.fragment_container, c1604a).commitAllowingStateLoss();
    }

    public void onStart() {
        C1492j.m4165a();
        C1492j.m4174d();
        super.onStart();
    }
}
