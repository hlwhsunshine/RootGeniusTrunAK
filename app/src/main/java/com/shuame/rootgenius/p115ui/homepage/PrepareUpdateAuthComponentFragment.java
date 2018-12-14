package com.shuame.rootgenius.p115ui.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.p015v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.event.C1345i;
import com.shuame.rootgenius.common.p087ui.p106a.C1376b;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.common.util.C1389b;
import com.shuame.rootgenius.common.util.C1391d;
import com.shuame.rootgenius.common.util.C1397j;
import com.shuame.rootgenius.common.util.C1416x;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p113i.C1455a;
import com.shuame.rootgenius.pojo.C1459a;
import com.shuame.rootgenius.service.C1488f;
import com.shuame.rootgenius.service.C1492j;
import java.io.File;

/* renamed from: com.shuame.rootgenius.ui.homepage.PrepareUpdateAuthComponentFragment */
public class PrepareUpdateAuthComponentFragment extends Fragment implements OnClickListener {
    private static final String TAG = PrepareUpdateAuthComponentFragment.class.getSimpleName();
    private View btnRoot;
    private C1376b flowRemindDialog;
    private C1459a mNewSuInfo;
    private View rootView;

    /* renamed from: com.shuame.rootgenius.ui.homepage.PrepareUpdateAuthComponentFragment$1 */
    class C15661 implements OnClickListener {
        C15661() {
        }

        public void onClick(View view) {
            PrepareUpdateAuthComponentFragment.this.btnRoot.setEnabled(true);
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.PrepareUpdateAuthComponentFragment$2 */
    class C15672 implements OnClickListener {
        C15672() {
        }

        public void onClick(View view) {
            PrepareUpdateAuthComponentFragment.this.btnRoot.setEnabled(true);
            PrepareUpdateAuthComponentFragment.this.startUpdateAuthComponent();
        }
    }

    private void findViews() {
        new C1379b(this.rootView.findViewById(C1450R.id.v_titlebar), getActivity(), (int) C1450R.string.app_name).mo7104a();
        this.btnRoot = this.rootView.findViewById(C1450R.id.btn_root);
    }

    private void init() {
        this.mNewSuInfo = C1488f.m4146b().mo7309a();
    }

    private void initListeners() {
        this.btnRoot.setOnClickListener(this);
    }

    private void initUI() {
    }

    private void startUpdateAuthComponent() {
        RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3644o));
    }

    public void onClick(View view) {
        if (!C1455a.m4025a() && !C1455a.m4026a(true) && view.getId() == C1450R.id.btn_root) {
            if (C1345i.m3749a().mo7020b()) {
                C1416x.m3936a((int) C1450R.string.jointed_core_func_goto_pc_operation);
                return;
            }
            QQDownloadFile a = C1361b.m3817a().mo7068a(C1361b.m3815a(this.mNewSuInfo.f4003b));
            if (a == null) {
                a = this.mNewSuInfo.mo7242b();
                a.f3725f = C1397j.m3897a(a);
            }
            C1389b.m3884a();
            if (C1389b.m3886a(true)) {
                C1389b.m3884a();
                if (C1389b.m3885a(a, true)) {
                    int b = C1387ad.m3869b(getActivity());
                    if (b == 1 || (a.f3719C == Status.FINISHED && new File(a.f3725f).exists())) {
                        this.btnRoot.setEnabled(false);
                        startUpdateAuthComponent();
                    } else if (b == 0) {
                        this.btnRoot.setEnabled(false);
                        openFlowRemindDialog();
                    } else {
                        C1416x.m3936a((int) C1450R.string.string_no_active_network);
                    }
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.rootView == null) {
            this.rootView = layoutInflater.inflate(C1450R.layout.fragment_homepage_prepare_update_component, viewGroup, false);
            init();
            findViews();
            initListeners();
            initUI();
        }
        return this.rootView;
    }

    public void onStart() {
        C1492j.m4165a();
        C1492j.m4174d();
        super.onStart();
    }

    public void openFlowRemindDialog() {
        C1391d.m3891a(getActivity(), "", getActivity().getString(C1450R.string.update_component_flow_remind_text, new Object[]{C1488f.m4146b().mo7310c()}), null, getResources().getString(C1450R.string.string_cancel), getResources().getString(C1450R.string.string_continue), C1450R.color.dialog_btn_cancel, C1450R.color.dialog_btn_confirm_green, new C15661(), new C15672());
    }
}
