package com.shuame.rootgenius.p115ui.homepage;

import android.os.Bundle;
import android.os.Handler;
import android.support.p015v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import com.shuame.rootgenius.C1446g;
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

/* renamed from: com.shuame.rootgenius.ui.homepage.RootedFragment */
public class RootedFragment extends Fragment implements OnClickListener, C1432b, IFragmentOnBackPressedListener {
    private static final String TAG = RootedFragment.class.getSimpleName();
    private C1506a mBbxGridAdapter;
    private GridView mBbxGridView;
    private Handler mHandler = new Handler();
    private View rootView;

    /* renamed from: com.shuame.rootgenius.ui.homepage.RootedFragment$1 */
    class C15721 implements Runnable {
        C15721() {
        }

        public void run() {
            RootedFragment.this.mBbxGridAdapter.mo7405a(C1483c.m4131a().mo7305b());
            RootedFragment.this.mBbxGridAdapter.notifyDataSetChanged();
        }
    }

    private void findViews() {
        new C1379b(this.rootView.findViewById(C1450R.id.v_titlebar), getActivity(), (int) C1450R.string.app_name).mo7104a();
        this.mBbxGridView = (GridView) this.rootView.findViewById(C1450R.id.gv_bbx);
    }

    private void init() {
        this.mBbxGridAdapter = new C1506a();
    }

    private void initListener() {
        C1433a.m3964a().mo7151a(this);
        this.mBbxGridView.setOnItemClickListener(new BbxItemClickListener(getActivity(), this.mBbxGridAdapter));
    }

    private void initUI() {
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
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onChange() {
        this.mHandler.post(new C15721());
    }

    public void onClick(View view) {
        if (C1455a.m4025a()) {
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.rootView == null) {
            this.rootView = layoutInflater.inflate(C1450R.layout.fragment_homepage_rooted, viewGroup, false);
            init();
            findViews();
            initListener();
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
