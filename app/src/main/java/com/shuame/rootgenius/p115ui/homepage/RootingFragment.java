package com.shuame.rootgenius.p115ui.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.p015v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.shuame.p075ad.AdType;
import com.shuame.p075ad.C1100f;
import com.shuame.p075ad.C1101g;
import com.shuame.p075ad.C1106j;
import com.shuame.rootgenius.C1446g;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.hook.util.HookManager;
import com.shuame.rootgenius.p099c.C1314a;
import com.shuame.rootgenius.p115ui.RootFailActivity;
import com.shuame.rootgenius.p115ui.view.RootProgressBar;
import com.shuame.rootgenius.sdk.RootGenius;
import com.shuame.rootgenius.sdk.RootGenius.RootListener;
import com.shuame.rootgenius.service.C1492j;
import com.shuame.rootgenius.service.C1493k;

/* renamed from: com.shuame.rootgenius.ui.homepage.RootingFragment */
public class RootingFragment extends Fragment implements RootListener {
    private static final String TAG = RootingFragment.class.getSimpleName();
    public static boolean isRooting = false;
    private Handler mHandler = new Handler();
    private int mPercent;
    private TextView mTvRootEvent;
    private RootProgressBar mvRootProgressBar;
    private View mvRootView;

    /* renamed from: com.shuame.rootgenius.ui.homepage.RootingFragment$1 */
    class C15731 implements Runnable {
        C15731() {
        }

        public void run() {
            if (C1446g.f3977b == 1 || C1446g.f3977b == 2) {
                if (C1446g.f3977b != 1) {
                    RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3641l));
                } else if (C1493k.m4179a().mo7323d()) {
                    RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3641l));
                } else {
                    RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3647r));
                }
                RootingFragment.this.getActivity();
                if (C1387ad.m3870b()) {
                    C1492j.m4165a();
                    C1492j.m4166a(RootingFragment.this.getActivity(), RootingFragment.this.getString(C1450R.string.notify_root_succ));
                }
            } else if (C1323b.m3712q()) {
                RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3639j));
                RootingFragment.this.getActivity();
                if (C1387ad.m3870b()) {
                    C1492j.m4165a();
                    C1492j.m4166a(RootingFragment.this.getActivity(), RootingFragment.this.getString(C1450R.string.notify_root_fail));
                }
                RootingFragment.this.startActivity(new Intent(RootingFragment.this.getActivity(), RootFailActivity.class));
            } else {
                RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3638i));
            }
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.RootingFragment$2 */
    class C15742 implements Runnable {
        C15742() {
        }

        public void run() {
            RootingFragment.this.mTvRootEvent.setText(C1450R.string.installing_su_suit);
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.RootingFragment$3 */
    class C15753 implements Runnable {
        C15753() {
        }

        public void run() {
            RootingFragment.this.mvRootProgressBar.mo7545a(RootingFragment.this.mPercent);
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.RootingFragment$4 */
    class C15764 implements Runnable {
        C15764() {
        }

        public void run() {
            RootingFragment.this.mvRootProgressBar.mo7545a(RootingFragment.this.mPercent);
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.RootingFragment$5 */
    class C15785 extends Thread {

        /* renamed from: com.shuame.rootgenius.ui.homepage.RootingFragment$5$1 */
        class C15771 implements Runnable {
            C15771() {
            }

            public void run() {
                RootingFragment.this.onResult(-1);
            }
        }

        C15785() {
        }

        public void run() {
            try {
                RootGenius.startRoot(RootingFragment.this);
            } catch (Exception e) {
                e.printStackTrace();
                RootingFragment.this.mHandler.postDelayed(new C15771(), 5000);
            }
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.RootingFragment$6 */
    class C15796 implements C1101g {
        C15796() {
        }

        public void onAdDismissed() {
        }
    }

    private void initAd() {
        String str = C1314a.f3566f;
        C1106j.m3208a();
        C1100f e = C1106j.m3209e();
        Boolean valueOf = Boolean.valueOf(C1100f.m3193d(str));
        new StringBuilder("shouldEnable: ").append(valueOf);
        if (valueOf.booleanValue()) {
            e.mo6691a(AdType.BANNER).mo6696b(C1314a.f3567g).mo6697c(C1314a.f3568h).mo6694a(str).mo6692a(new C15796()).mo6690a().mo6695a(getActivity().getSupportFragmentManager(), C1450R.id.banner_ad_container);
        }
    }

    private void initUI() {
        this.mvRootProgressBar = (RootProgressBar) this.mvRootView.findViewById(C1450R.id.root_progress_bar);
        this.mTvRootEvent = (TextView) this.mvRootView.findViewById(C1450R.id.tv_root_event);
        startRoot();
    }

    private void rootDone() {
        if (C1446g.f3977b == 1) {
            HookManager.registerHook();
        }
        this.mHandler.postDelayed(new C15731(), 800);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mvRootView == null) {
            this.mvRootView = layoutInflater.inflate(C1450R.layout.fragment_homepage_rooting, viewGroup, false);
            initUI();
        }
        initAd();
        return this.mvRootView;
    }

    public void onProcess(int i) {
        switch (i) {
            case 4:
                getActivity().runOnUiThread(new C15742());
                return;
            default:
                return;
        }
    }

    public void onProgress(int i) {
        new StringBuilder("onProgress percent:").append(i).append("%");
        if (i != 100) {
            this.mPercent = i;
            this.mHandler.post(new C15753());
        }
    }

    public void onResult(int i) {
        C1446g.f3977b = i;
        if (i == 1 || i == 2) {
            C1323b.m3694c(true);
        } else {
            C1323b.m3694c(false);
        }
        this.mPercent = 100;
        this.mHandler.post(new C15764());
        rootDone();
        isRooting = false;
        C1446g.m4003a();
        C1446g.m4005a(true);
    }

    public void onStart() {
        C1492j.m4165a();
        C1492j.m4174d();
        super.onStart();
    }

    public void startRoot() {
        isRooting = true;
        C1446g.m4003a();//获取sp的实例
        C1446g.m4005a(false);//sp写入root_done_flag 为flase
        new C15785().start();//线程运行
    }
}
