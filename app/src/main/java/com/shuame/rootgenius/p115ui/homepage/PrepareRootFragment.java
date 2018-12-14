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
import android.widget.GridView;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.event.C1345i;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.common.util.C1416x;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p109f.C1432b;
import com.shuame.rootgenius.p109f.C1433a;
import com.shuame.rootgenius.p113i.C1455a;
import com.shuame.rootgenius.p115ui.adapter.C1506a;
import com.shuame.rootgenius.p115ui.homepage.listeners.BbxItemClickListener;
import com.shuame.rootgenius.p115ui.homepage.listeners.IFragmentOnBackPressedListener;
import com.shuame.rootgenius.p115ui.view.C1610a;
import com.shuame.rootgenius.sdk.RootGenius;
import com.shuame.rootgenius.service.C1483c;
import com.shuame.rootgenius.service.C1492j;

/* renamed from: com.shuame.rootgenius.ui.homepage.PrepareRootFragment */
public class PrepareRootFragment extends Fragment implements OnClickListener, C1432b, IFragmentOnBackPressedListener {
    private static final String TAG = PrepareRootFragment.class.getSimpleName();
    private boolean isBbxShown = false;
    private View llBbx;
    private View llPrepareRoot;
    private View llTitleSpecial;
    private C1506a mBbxGridAdapter;
    private GridView mBbxGridView;
    private Handler mHandler = new Handler();
    private View rootView;
    private View vIntroduce;

    /* renamed from: com.shuame.rootgenius.ui.homepage.PrepareRootFragment$1 */
    class C15631 implements AnimationListener {
        C15631() {
        }

        public void onAnimationEnd(Animation animation) {
            PrepareRootFragment.this.isBbxShown = true;
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            PrepareRootFragment.this.vIntroduce.setEnabled(false);
            PrepareRootFragment.this.llTitleSpecial.setEnabled(true);
            PrepareRootFragment.this.llBbx.setVisibility(0);
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.PrepareRootFragment$2 */
    class C15642 implements AnimationListener {
        C15642() {
        }

        public void onAnimationEnd(Animation animation) {
            PrepareRootFragment.this.vIntroduce.setEnabled(true);
            PrepareRootFragment.this.llTitleSpecial.setEnabled(false);
            PrepareRootFragment.this.llBbx.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            PrepareRootFragment.this.isBbxShown = false;
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.PrepareRootFragment$3 */
    class C15653 implements Runnable {
        C15653() {
        }

        public void run() {
            PrepareRootFragment.this.mBbxGridAdapter.mo7405a(C1483c.m4131a().mo7305b());
            PrepareRootFragment.this.mBbxGridAdapter.notifyDataSetChanged();
        }
    }

    private void closeBbx() {
        Animation animationSet = new AnimationSet(true);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new C15642());
        this.llPrepareRoot.startAnimation(animationSet);
        animationSet = new AnimationSet(true);
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) getResources().getDisplayMetrics().heightPixels);
        translateAnimation.setDuration(500);
        animationSet.addAnimation(translateAnimation);
        this.llBbx.startAnimation(animationSet);
    }

    private void findViews() {
        new C1379b(this.rootView.findViewById(C1450R.id.v_titlebar), getActivity(), (int) C1450R.string.app_name).mo7104a();
        new C1610a(this.rootView.findViewById(C1450R.id.ll_bbx)).mo7562a();
        this.llPrepareRoot = this.rootView.findViewById(C1450R.id.ll_prepare_root);
        this.vIntroduce = this.rootView.findViewById(C1450R.id.v_introduce);
        this.llTitleSpecial = this.rootView.findViewById(C1450R.id.ll_title_special);
        this.llBbx = this.rootView.findViewById(C1450R.id.ll_bbx);
        this.mBbxGridView = (GridView) this.rootView.findViewById(C1450R.id.gv_bbx);
    }

    private void init() {
        this.mBbxGridAdapter = new C1506a();
        if (!C1323b.m3703h() && C1323b.m3701f()) {
            RootGenius.setRootBySupportTip();
            C1323b.m3704i();
        }
    }

    private void initListeners() {
        C1433a.m3964a().mo7151a(this);
        this.rootView.findViewById(C1450R.id.btn_root).setOnClickListener(this);
        this.vIntroduce.setOnClickListener(this);
        this.llTitleSpecial.setOnClickListener(this);
        this.mBbxGridView.setOnItemClickListener(new BbxItemClickListener(getActivity(), this.mBbxGridAdapter));
    }

    private void initUI() {
        this.rootView.findViewById(C1450R.id.ll_title_special).setVisibility(0);
        this.rootView.findViewById(C1450R.id.tv_title_standard).setVisibility(8);
        this.llBbx.setVisibility(8);
        this.mBbxGridView.setAdapter(this.mBbxGridAdapter);
        this.mBbxGridAdapter.mo7405a(C1483c.m4131a().mo7305b());
    }

    private void openBbx() {
        Animation animationSet = new AnimationSet(true);
        animationSet.setAnimationListener(new C15631());
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setFillAfter(true);
        this.llPrepareRoot.startAnimation(animationSet);
        animationSet = new AnimationSet(true);
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) getResources().getDisplayMetrics().heightPixels, 0.0f);
        translateAnimation.setDuration(500);
        animationSet.addAnimation(translateAnimation);
        this.llBbx.startAnimation(animationSet);
    }

    public boolean onBackPressed() {
        if (!this.isBbxShown) {
            return false;
        }
        closeBbx();
        return true;
    }

    public void onChange() {
        this.mHandler.post(new C15653());
    }

    public void onClick(View view) {
        if (!C1455a.m4025a() && !C1455a.m4026a(true)) {
            switch (view.getId()) {
                case C1450R.id.v_introduce:
                    openBbx();
                    return;
                case C1450R.id.btn_root:
                    if (C1345i.m3749a().mo7020b()) {
                        C1416x.m3936a((int) C1450R.string.jointed_core_func_goto_pc_operation);
                        return;
                    }
                    view.setEnabled(false);
                    C1323b.m3697d(true);
                    RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3640k));
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
        if (this.rootView == null) {
            this.rootView = layoutInflater.inflate(C1450R.layout.fragment_homepage_prepare_root, viewGroup, false);
            init();
            findViews();
            initListeners();
            initUI();
        }
        return this.rootView;
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
