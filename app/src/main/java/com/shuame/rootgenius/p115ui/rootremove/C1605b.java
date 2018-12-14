package com.shuame.rootgenius.p115ui.rootremove;

import android.os.Bundle;
import android.support.p015v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.ui.rootremove.b */
public final class C1605b extends Fragment implements OnClickListener {
    /* renamed from: a */
    private View f4401a;

    public final void onClick(View view) {
        if (view.getId() == C1450R.id.btn_done) {
            getActivity().finish();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f4401a == null) {
            this.f4401a = layoutInflater.inflate(C1450R.layout.fragment_root_remove_succ, viewGroup, false);
            this.f4401a.findViewById(C1450R.id.btn_done).setOnClickListener(this);
        }
        return this.f4401a;
    }
}
