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
import com.shuame.rootgenius.C1446g;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p109f.C1432b;
import com.shuame.rootgenius.p109f.C1433a;
import com.shuame.rootgenius.p113i.C1455a;
import com.shuame.rootgenius.p115ui.adapter.C1506a;
import com.shuame.rootgenius.p115ui.homepage.listeners.BbxItemClickListener;
import com.shuame.rootgenius.p115ui.homepage.listeners.IFragmentOnBackPressedListener;
import com.shuame.rootgenius.service.C1483c;
import com.shuame.rootgenius.service.C1492j;

/* renamed from: com.shuame.rootgenius.ui.homepage.RootSuccFragment */
public class RootSuccFragment extends Fragment implements OnClickListener, C1432b, IFragmentOnBackPressedListener {
    private static final String TAG = RootSuccFragment.class.getSimpleName();
    private View llBbx;
    private View llSplash;
    private View llText;
    private View llTitleBar;
    private C1506a mBbxGridAdapter;
    private GridView mBbxGridView;
    private Handler mHandler = new Handler();
    private View rootView;

    /* renamed from: com.shuame.rootgenius.ui.homepage.RootSuccFragment$1 */
    class C15701 implements AnimationListener {
        C15701() {
        }

        public void onAnimationEnd(Animation animation) {
            RootSuccFragment.this.llSplash.setVisibility(4);
            RootSuccFragment.this.llTitleBar.setVisibility(0);
            RootSuccFragment.this.llBbx.setVisibility(0);
            RootSuccFragment.this.llText.setVisibility(0);
            Intent intent = new Intent(C1340e.f3635f);
            intent.putExtra("param_data", 2);
            RootGeniusApp.m3523a().sendBroadcast(intent);
            RootSuccFragment.TAG;
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.RootSuccFragment$2 */
    class C15712 implements Runnable {
        C15712() {
        }

        public void run() {
            RootSuccFragment.this.mBbxGridAdapter.mo7405a(C1483c.m4131a().mo7305b());
            RootSuccFragment.this.mBbxGridAdapter.notifyDataSetChanged();
        }
    }

    private void findViews() {
        new C1379b(this.rootView.findViewById(C1450R.id.v_titlebar), getActivity(), (int) C1450R.string.app_name).mo7104a();
        this.llSplash = this.rootView.findViewById(C1450R.id.ll_splash);
        this.llTitleBar = this.rootView.findViewById(C1450R.id.v_titlebar);
        this.llText = this.rootView.findViewById(C1450R.id.ll_text);
        this.llBbx = this.rootView.findViewById(C1450R.id.ll_bbx);
        this.mBbxGridView = (GridView) this.rootView.findViewById(C1450R.id.gv_bbx);
    }

    private void init() {
        this.mBbxGridAdapter = new C1506a();
    }

    private void initListener() {
        C1433a.m3964a().mo7151a(this);
        this.mBbxGridView.setOnItemClickListener(new BbxItemClickListener(getActivity(), this.mBbxGridAdapter));
    }

    private void initUIData() {
        int i = 0;
        this.rootView.findViewById(C1450R.id.ll_title_special).setVisibility(8);
        this.rootView.findViewById(C1450R.id.tv_title_standard).setVisibility(0);
        View findViewById = this.rootView.findViewById(C1450R.id.tv_remind_msg);
        if (C1446g.f3977b != 2) {
            i = 4;
        }
        findViewById.setVisibility(i);
        this.mBbxGridView.setAdapter(this.mBbxGridAdapter);
        this.mBbxGridAdapter.mo7405a(C1483c.m4131a().mo7305b());
        rootSuccAnim();
    }

    private void rootSuccAnim() {
        Animation animationSet = new AnimationSet(true);
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300);
        Animation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(500);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setFillAfter(true);
        animationSet.setStartOffset(1500);
        this.llSplash.startAnimation(animationSet);
        animationSet = new AnimationSet(true);
        translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 2, 0.42f, 2, 0.0f);
        translateAnimation.setDuration(400);
        translateAnimation.setStartOffset(1700);
        animationSet.addAnimation(translateAnimation);
        animationSet.setFillAfter(true);
        this.llText.startAnimation(animationSet);
        animationSet = new AnimationSet(true);
        translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setDuration(400);
        translateAnimation.setStartOffset(1700);
        animationSet.addAnimation(translateAnimation);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new C15701());
        this.llBbx.setVisibility(0);
        this.llBbx.startAnimation(animationSet);
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onChange() {
        this.mHandler.post(new C15712());
    }

    public void onClick(View view) {
        if (C1455a.m4025a()) {
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.rootView == null) {
            this.rootView = layoutInflater.inflate(C1450R.layout.fragment_homepage_root_succ, viewGroup, false);
            init();
            findViews();
            initListener();
            initUIData();
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
