package com.shuame.rootgenius.p115ui.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.p015v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import com.shuame.rootgenius.C1446g;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p109f.C1432b;
import com.shuame.rootgenius.p109f.C1433a;
import com.shuame.rootgenius.p113i.C1455a;
import com.shuame.rootgenius.p115ui.SeeSolutionActivity;
import com.shuame.rootgenius.p115ui.adapter.C1506a;
import com.shuame.rootgenius.p115ui.homepage.listeners.BbxItemClickListener;
import com.shuame.rootgenius.p115ui.homepage.listeners.IFragmentOnBackPressedListener;
import com.shuame.rootgenius.p115ui.view.C1610a;
import com.shuame.rootgenius.service.C1483c;
import com.shuame.rootgenius.service.C1492j;

/* renamed from: com.shuame.rootgenius.ui.homepage.NonsupportRootFragment */
public class NonsupportRootFragment extends Fragment implements OnClickListener, C1432b, IFragmentOnBackPressedListener {
    private static final String TAG = NonsupportRootFragment.class.getSimpleName();
    private boolean isBbxShown = false;
    private View llBbx;
    private View llNonsupportRoot;
    private View llTitleSpecial;
    private C1506a mBbxGridAdapter;
    private GridView mBbxGridView;
    private Button mBtnSeeSolution;
    private Handler mHandler = new Handler();
    private TextView mTvPercent;
    private View mvRootView;
    private View vIntroduce;

    /* renamed from: com.shuame.rootgenius.ui.homepage.NonsupportRootFragment$1 */
    class C15581 implements AnimationListener {
        C15581() {
        }

        public void onAnimationEnd(Animation animation) {
            NonsupportRootFragment.this.isBbxShown = true;
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            NonsupportRootFragment.this.vIntroduce.setEnabled(false);
            NonsupportRootFragment.this.llTitleSpecial.setEnabled(true);
            NonsupportRootFragment.this.llBbx.setVisibility(0);
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.NonsupportRootFragment$2 */
    class C15592 implements AnimationListener {
        C15592() {
        }

        public void onAnimationEnd(Animation animation) {
            NonsupportRootFragment.this.vIntroduce.setEnabled(true);
            NonsupportRootFragment.this.llTitleSpecial.setEnabled(false);
            NonsupportRootFragment.this.llBbx.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            NonsupportRootFragment.this.isBbxShown = false;
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.NonsupportRootFragment$3 */
    class C15603 implements Runnable {
        C15603() {
        }

        public void run() {
            NonsupportRootFragment.this.mBbxGridAdapter.mo7405a(C1483c.m4131a().mo7305b());
            NonsupportRootFragment.this.mBbxGridAdapter.notifyDataSetChanged();
        }
    }

    private void closeBbx() {
        Animation animationSet = new AnimationSet(true);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new C15592());
        this.llNonsupportRoot.startAnimation(animationSet);
        animationSet = new AnimationSet(true);
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) getResources().getDisplayMetrics().heightPixels);
        translateAnimation.setDuration(500);
        animationSet.addAnimation(translateAnimation);
        this.llBbx.startAnimation(animationSet);
    }

    private void findViews() {
        new C1379b(this.mvRootView.findViewById(C1450R.id.v_titlebar), getActivity(), (int) C1450R.string.app_name).mo7104a();
        new C1610a(this.mvRootView.findViewById(C1450R.id.ll_bbx)).mo7562a();
        this.llNonsupportRoot = this.mvRootView.findViewById(C1450R.id.ll_nonsupport_root);
        this.vIntroduce = this.mvRootView.findViewById(C1450R.id.v_introduce);
        this.llTitleSpecial = this.mvRootView.findViewById(C1450R.id.ll_title_special);
        this.llBbx = this.mvRootView.findViewById(C1450R.id.ll_bbx);
        this.mBbxGridView = (GridView) this.mvRootView.findViewById(C1450R.id.gv_bbx);
        this.mTvPercent = (TextView) this.mvRootView.findViewById(C1450R.id.tv_percent);
        this.mBtnSeeSolution = (Button) this.mvRootView.findViewById(C1450R.id.btn_see_solution);
    }

    private void init() {
        this.mBbxGridAdapter = new C1506a();
        if (!C1323b.m3701f()) {
            resetNewSupportRootCheck();
        }
    }

    private void initListeners() {
        C1433a.m3964a().mo7151a(this);
        this.vIntroduce.setOnClickListener(this);
        this.llTitleSpecial.setOnClickListener(this);
        this.mBbxGridView.setOnItemClickListener(new BbxItemClickListener(getActivity(), this.mBbxGridAdapter));
        this.mBtnSeeSolution.setOnClickListener(this);
    }

    private void initUI() {
        this.mTvPercent.setText(String.valueOf(C1323b.m3688a().mo6999e("pc_root_probability")));
        this.mvRootView.findViewById(C1450R.id.ll_title_special).setVisibility(0);
        this.mvRootView.findViewById(C1450R.id.tv_title_standard).setVisibility(8);
        this.llBbx.setVisibility(8);
        this.mBbxGridView.setAdapter(this.mBbxGridAdapter);
        this.mBbxGridAdapter.mo7405a(C1483c.m4131a().mo7305b());
    }

    private void openBbx() {
        Animation animationSet = new AnimationSet(true);
        animationSet.setAnimationListener(new C15581());
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setFillAfter(true);
        this.llNonsupportRoot.startAnimation(animationSet);
        animationSet = new AnimationSet(true);
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) getResources().getDisplayMetrics().heightPixels, 0.0f);
        translateAnimation.setDuration(500);
        animationSet.addAnimation(translateAnimation);
        this.llBbx.startAnimation(animationSet);
    }

    private void resetNewSupportRootCheck() {
        RootGeniusApp.m3523a().sendBroadcast(new Intent("com.shuame.ACTION_CHECK_NEW_SUPPORT_ROOT"));
        C1446g.m4003a();
        if (C1446g.m4013g() == 0) {
            C1446g.m4003a();
            C1446g.m4010d();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("LAST_CHECK_NEW_SUPPORT_ROOT_TIME:");
        C1446g.m4003a();
        stringBuilder.append(C1446g.m4013g());
    }

    public boolean onBackPressed() {
        if (!this.isBbxShown) {
            return false;
        }
        closeBbx();
        return true;
    }

    public void onChange() {
        this.mHandler.post(new C15603());
    }

    public void onClick(View view) {
        if (!C1455a.m4025a()) {
            switch (view.getId()) {
                case C1450R.id.btn_see_solution:
                    startActivity(new Intent(RootGeniusApp.m3523a(), SeeSolutionActivity.class));
                    return;
                case C1450R.id.v_introduce:
                    openBbx();
                    return;
                case C1450R.id.ll_title_special:
                    closeBbx();
                    return;
                default:
                    return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mvRootView == null) {
            this.mvRootView = layoutInflater.inflate(C1450R.layout.fragment_homepage_nonsupport_root, viewGroup, false);
            init();
            findViews();
            initListeners();
            initUI();
        }
        return this.mvRootView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        C1433a.m3964a().mo7152b(this);
    }

    public void onStart() {
        C1492j.m4165a();
        C1492j.m4174d();
        super.onStart();
    }
}
