package com.shuame.rootgenius.p115ui.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.p015v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p115ui.rootremove.RootRemoveDoneActivity;
import com.shuame.rootgenius.p115ui.view.RemoveRootView;
import com.shuame.rootgenius.sdk.RootGenius;

/* renamed from: com.shuame.rootgenius.ui.homepage.RootRemoveIngFragment */
public class RootRemoveIngFragment extends Fragment {
    private static final String TAG = RootRemoveIngFragment.class.getSimpleName();
    public static boolean isRootRemoveing = false;
    private Handler mHandler = new Handler();
    private View rootView;

    /* renamed from: com.shuame.rootgenius.ui.homepage.RootRemoveIngFragment$1 */
    class C15691 extends Thread {

        /* renamed from: com.shuame.rootgenius.ui.homepage.RootRemoveIngFragment$1$1 */
        class C15681 implements Runnable {
            C15681() {
            }

            public void run() {
                if (C1323b.m3698d()) {
                    RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3642m));
                } else {
                    RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3639j));
                }
                RootRemoveIngFragment.isRootRemoveing = false;
            }
        }

        C15691() {
        }

        public void run() {
            int removeRoot;
            try {
                removeRoot = RootGenius.removeRoot();
            } catch (Exception e) {
                removeRoot = -1;
                e.printStackTrace();
            }
            if (removeRoot == 1) {
                C1323b.m3694c(false);
            }
            RootRemoveIngFragment.this.startActivity(new Intent(RootRemoveIngFragment.this.getActivity(), RootRemoveDoneActivity.class));
            RootRemoveIngFragment.this.mHandler.postDelayed(new C15681(), 500);
        }
    }

    private void executeRemoveRoot() {
        isRootRemoveing = true;
        new C15691().start();
    }

    private void initUI() {
        ((RemoveRootView) this.rootView.findViewById(C1450R.id.remove_root_view)).mo7542a();
        executeRemoveRoot();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.rootView == null) {
            this.rootView = layoutInflater.inflate(C1450R.layout.fragment_homepage_root_remove_ing, viewGroup, false);
            initUI();
        }
        return this.rootView;
    }
}
