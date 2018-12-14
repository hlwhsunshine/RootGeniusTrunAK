package com.shuame.rootgenius.p115ui.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.p015v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.sdk.RootGenius;
import com.shuame.rootgenius.service.C1481a;
import com.shuame.rootgenius.service.C1492j;

/* renamed from: com.shuame.rootgenius.ui.homepage.ScanFragment */
public class ScanFragment extends Fragment {
    private static final String TAG = ScanFragment.class.getSimpleName();
    public static boolean isScanChecking = false;
    private View rootView;

    /* renamed from: com.shuame.rootgenius.ui.homepage.ScanFragment$1 */
    class C15801 extends Thread {
        C15801() {
        }

        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            C1323b.m3694c(false);
            while (!RootGeniusApp.m3526b()) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            C1323b.m3694c(RootGenius.connect());
            while (System.currentTimeMillis() - currentTimeMillis < 1000) {
                Thread.sleep(1000);
                ScanFragment.TAG;
            }
            if (C1323b.m3698d()) {
                RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3642m));
            } else {
                RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3639j));
            }
            RootGenius.setTestMode(RootGeniusApp.f3303c);
            C1481a.m4128a();
            C1323b.m3692b(true);
            ScanFragment.isScanChecking = false;
        }
    }

    private void launchInitCheckup() {
        isScanChecking = true;
        C1323b.m3692b(false);
        new C15801().start();
    }

    private void launchScanAnimation() {
        launchInitCheckup();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.rootView == null) {
            this.rootView = layoutInflater.inflate(C1450R.layout.fragment_homepage_scan, viewGroup, false);
            launchScanAnimation();
        }
        return this.rootView;
    }

    public void onStart() {
        C1492j.m4165a();
        C1492j.m4174d();
        super.onStart();
    }
}
