package com.shuame.rootgenius.p115ui.rootremove;

import android.os.Bundle;
import android.support.p015v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.ui.rootremove.a */
public final class C1604a extends Fragment implements OnClickListener {
    /* renamed from: a */
    private View f4400a;

    public final void onClick(View view) {
        if (view.getId() == C1450R.id.btn_done) {
            getActivity().finish();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f4400a == null) {
            this.f4400a = layoutInflater.inflate(C1450R.layout.fragment_root_remove_fail, viewGroup, false);
            this.f4400a.findViewById(C1450R.id.btn_done).setOnClickListener(this);
        }
        return this.f4400a;
    }
}
