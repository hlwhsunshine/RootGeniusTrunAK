package com.shuame.rootgenius.p115ui.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.p015v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p108e.C1429h;
import com.shuame.rootgenius.p115ui.adapter.C1523n;
import com.shuame.rootgenius.p115ui.homepage.listeners.IOptimizeItemListener;
import com.shuame.rootgenius.p115ui.view.MobileOptimizeProgressBar;
import com.shuame.rootgenius.pojo.OptimizeInfo;
import com.shuame.rootgenius.service.C1493k;

/* renamed from: com.shuame.rootgenius.ui.homepage.OptimizeFragment */
public class OptimizeFragment extends Fragment implements OnClickListener {
    private static final String TAG = OptimizeFragment.class.getSimpleName();
    private C1523n mAdapter;
    private Handler mHandler = new Handler();
    private IOptimizeItemListener mOptimizeItemListen = new C15622();
    private Button mvBtnOnekeyOptimize;
    private Button mvBtnSkip;
    private ListView mvListview;
    private MobileOptimizeProgressBar mvOptimizeProgressBar;
    private TextView mvTvPercent;
    private TextView mvTvSuggest;
    private View rootView;

    /* renamed from: com.shuame.rootgenius.ui.homepage.OptimizeFragment$1 */
    class C15611 implements Runnable {
        C15611() {
        }

        public void run() {
            OptimizeFragment.this.doFinish();
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.OptimizeFragment$2 */
    class C15622 implements IOptimizeItemListener {
        C15622() {
        }

        public void onItemOptimized(OptimizeInfo optimizeInfo) {
            OptimizeFragment.TAG;
            new StringBuilder("已完成优化的项：").append(optimizeInfo.appInfo).append("--isOptimized:").append(optimizeInfo.isOptimized);
            OptimizeFragment.this.onChangePercentUI(C1493k.m4179a().mo7324e(), C1493k.m4179a().mo7325f(), C1493k.m4179a().mo7326g());
        }

        public void onOptimizedItemCountChanged(int i, int i2, boolean z) {
            OptimizeFragment.TAG;
            new StringBuilder("onOptimizedItemCountChanged:").append(i).append("--optimizedItemCount:").append(i2).append("--haveTaskOptimizing:").append(z);
            if (i == i2) {
                OptimizeFragment.this.mvBtnOnekeyOptimize.setEnabled(false);
            } else {
                OptimizeFragment.this.mvBtnOnekeyOptimize.setEnabled(true);
            }
            if (z || i == i2) {
                OptimizeFragment.this.mvBtnSkip.setVisibility(4);
            } else {
                OptimizeFragment.this.mvBtnSkip.setVisibility(0);
            }
        }
    }

    private void doFinish() {
        RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3641l));
        report();
        C1493k.m4179a().mo7327h();
    }

    private void findViews() {
        this.rootView.findViewById(C1450R.id.tv_suggest);
        this.mvOptimizeProgressBar = (MobileOptimizeProgressBar) this.rootView.findViewById(C1450R.id.v_progressbar);
        this.mvListview = (ListView) this.rootView.findViewById(C1450R.id.listview);
        this.mvTvPercent = (TextView) this.rootView.findViewById(C1450R.id.tv_percent);
        this.mvTvSuggest = (TextView) this.rootView.findViewById(C1450R.id.tv_suggest);
        this.mvBtnOnekeyOptimize = (Button) this.rootView.findViewById(C1450R.id.btn_onekey_optimize);
        this.mvBtnSkip = (Button) this.rootView.findViewById(C1450R.id.btn_skip);
    }

    private void init() {
    }

    private void initListeners() {
        this.mvBtnSkip.setOnClickListener(this);
        this.mvBtnOnekeyOptimize.setOnClickListener(this);
        this.mAdapter = new C1523n(this.mvListview);
        this.mvListview.setAdapter(this.mAdapter);
        this.mAdapter.mo7428a(this.mOptimizeItemListen);
        this.mAdapter.mo7429b();
    }

    private void initUI() {
        C1379b c1379b = new C1379b(this.rootView.findViewById(C1450R.id.v_titlebar), getActivity(), (int) C1450R.string.app_name);
        c1379b.mo7104a();
        c1379b.mo7105b();
        c1379b.mo7106c();
        onChangePercentUI(C1493k.m4179a().mo7324e(), C1493k.m4179a().mo7325f(), C1493k.m4179a().mo7326g());
    }

    private void onChangePercentUI(int i, int i2, int i3) {
        new StringBuilder("totalScore:").append(i).append("--currScore:").append(i2).append("--currPercent:").append(i3);
        if (i != 0) {
            this.mvOptimizeProgressBar.setTotalScore(i);
            this.mvOptimizeProgressBar.mo7531a(i2);
            this.mvTvPercent.setText(i3 + "%");
            if (i3 < 75) {
                this.mvTvSuggest.setText(C1450R.string.optimize_suggest_text_1);
            } else {
                this.mvTvSuggest.setText(C1450R.string.optimize_suggest_text_2);
            }
            if (i3 == 100) {
                this.mHandler.postDelayed(new C15611(), 1500);
            }
        }
    }

    private void report() {
        C1429h.m3960a().mo7147a(C1493k.m4179a().mo7321b());
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1450R.id.btn_skip:
                doFinish();
                return;
            case C1450R.id.btn_onekey_optimize:
                this.mAdapter.mo7427a();
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.rootView == null) {
            this.rootView = layoutInflater.inflate(C1450R.layout.fragment_homepage_optimize, viewGroup, false);
            init();
            findViews();
            initListeners();
            initUI();
        }
        return this.rootView;
    }

    public void onDestroy() {
        super.onDestroy();
        this.mAdapter.mo7430c();
    }
}
