package com.shuame.rootgenius.p115ui.homepage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.p015v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.shuame.rootgenius.C1446g;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.manager.AppManager.C1348b;
import com.shuame.rootgenius.common.p087ui.p106a.C1376b;
import com.shuame.rootgenius.common.p087ui.p106a.C1376b.C1375a;
import com.shuame.rootgenius.common.p101b.C1320a;
import com.shuame.rootgenius.common.p101b.C1321b;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.common.util.C1397j;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p115ui.UpdateComponentFailActivity;
import com.shuame.rootgenius.p115ui.view.RootProgressBar;
import com.shuame.rootgenius.pojo.C1459a;
import com.shuame.rootgenius.sdk.RootGenius;
import com.shuame.rootgenius.sdk.RootGenius.RootListener;
import com.shuame.rootgenius.service.C1488f;
import com.shuame.rootgenius.service.C1492j;
import com.tencent.xuanfeng.libInterface.LinkStruct;
import java.io.File;

/* renamed from: com.shuame.rootgenius.ui.homepage.UpdatingAuthComponentFragment */
public class UpdatingAuthComponentFragment extends Fragment implements RootListener {
    private static final String TAG = UpdatingAuthComponentFragment.class.getSimpleName();
    private static final int UPDATE_DONE_FAIL = -1;
    private static final int UPDATE_DONE_SUCC = 1;
    public static boolean isComponentUpdating = false;
    private Handler mHandler = new Handler(new C15843());
    private C1320a mIListener = new C15854();
    private C1459a mNewSuInfo;
    private int mPercent;
    private BroadcastReceiver mWifi2MobileReceiver = new C15886();
    private TextView mvTvTip;
    private View rootView;
    private RootProgressBar vRootProgressBar;
    private C1376b wifiGoneRemindDialog;

    /* renamed from: com.shuame.rootgenius.ui.homepage.UpdatingAuthComponentFragment$2 */
    class C15832 extends Thread {
        C15832() {
        }

        public void run() {
            QQDownloadFile a = C1361b.m3817a().mo7068a(C1361b.m3815a(UpdatingAuthComponentFragment.this.mNewSuInfo.f4003b));
            if (a.f3719C == Status.FINISHED) {
                try {
                    RootGenius.updateSU(a.f3725f, UpdatingAuthComponentFragment.this);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            UpdatingAuthComponentFragment.this.UpdateDone(-1);
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.UpdatingAuthComponentFragment$3 */
    class C15843 implements Callback {
        C15843() {
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    int i = message.arg2;
                    if (UpdatingAuthComponentFragment.this.mPercent != i) {
                        UpdatingAuthComponentFragment.this.mPercent = i;
                        UpdatingAuthComponentFragment.this.vRootProgressBar.mo7545a(UpdatingAuthComponentFragment.this.mPercent);
                    }
                    UpdatingAuthComponentFragment.TAG;
                    new StringBuilder("mPercent:").append(UpdatingAuthComponentFragment.this.mPercent);
                    break;
                case 3:
                    switch (C15897.f4383xad0ed16c[((Status) message.obj).ordinal()]) {
                        case 1:
                            UpdatingAuthComponentFragment.TAG;
                            UpdatingAuthComponentFragment.this.UpdateDone(-1);
                            break;
                        case 2:
                            UpdatingAuthComponentFragment.TAG;
                            UpdatingAuthComponentFragment.this.mvTvTip.setText(C1450R.string.installing_su_suit);
                            UpdatingAuthComponentFragment.this.installNewSU();
                            break;
                    }
                    break;
            }
            return false;
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.UpdatingAuthComponentFragment$4 */
    class C15854 implements C1320a {
        C15854() {
        }

        public void onComplete(int i, long j) {
        }

        public void onDonwloadInfo(int i, LinkStruct[] linkStructArr) {
        }

        public void onFileName(int i, String str) {
        }

        public void onOnlySrcUrl(int i) {
        }

        public void onStatusChanged(int i, Status status) {
            if (i == C1361b.m3815a(UpdatingAuthComponentFragment.this.mNewSuInfo.f4003b)) {
                UpdatingAuthComponentFragment.TAG;
                new StringBuilder("onStatusChanged taskId:").append(i).append(";status:").append(status);
                Message obtainMessage = UpdatingAuthComponentFragment.this.mHandler.obtainMessage();
                obtainMessage.what = 3;
                obtainMessage.arg1 = i;
                obtainMessage.obj = status;
                UpdatingAuthComponentFragment.this.mHandler.sendMessage(obtainMessage);
            }
        }

        public void onStatusChanged(C1348b c1348b) {
        }

        public void onStorageErrorInfo(int i, int i2, String str) {
        }

        public void onTaskInfo(int i, int i2, int i3) {
            if (i == C1361b.m3815a(UpdatingAuthComponentFragment.this.mNewSuInfo.f4003b)) {
                UpdatingAuthComponentFragment.TAG;
                new StringBuilder("onTaskInfo taskId:").append(i).append(";thousandth:").append(i2).append(";speed:").append(i3);
                Message obtainMessage = UpdatingAuthComponentFragment.this.mHandler.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.arg1 = i;
                obtainMessage.arg2 = (i2 / 10) / 2;
                UpdatingAuthComponentFragment.this.mHandler.sendMessage(obtainMessage);
            }
        }

        public void onWaitStart(int i) {
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.UpdatingAuthComponentFragment$5 */
    class C15875 implements Runnable {

        /* renamed from: com.shuame.rootgenius.ui.homepage.UpdatingAuthComponentFragment$5$1 */
        class C15861 implements OnClickListener {
            C15861() {
            }

            public void onClick(View view) {
                if (view.getId() == C1450R.id.btn_right) {
                    UpdatingAuthComponentFragment.this.startDownload();
                } else {
                    UpdatingAuthComponentFragment.this.UpdateDone(-1);
                }
                UpdatingAuthComponentFragment.this.wifiGoneRemindDialog.cancel();
            }
        }

        C15875() {
        }

        public void run() {
            if (UpdatingAuthComponentFragment.this.wifiGoneRemindDialog == null) {
                C1375a c1375a = new C1375a();
                c1375a.f3817a = C1450R.string.update_wifi_changed_msg;
                c1375a.f3822f = C1450R.string.string_cancel;
                c1375a.f3823g = C1450R.string.string_continue;
                c1375a.f3824h = new C15861();
                UpdatingAuthComponentFragment.this.wifiGoneRemindDialog = new C1376b(UpdatingAuthComponentFragment.this.getActivity(), c1375a);
            }
            UpdatingAuthComponentFragment.this.wifiGoneRemindDialog.show();
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.UpdatingAuthComponentFragment$6 */
    class C15886 extends BroadcastReceiver {
        C15886() {
        }

        public void onReceive(Context context, Intent intent) {
            UpdatingAuthComponentFragment.this.startDownload();
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.UpdatingAuthComponentFragment$7 */
    /* synthetic */ class C15897 {
        /* renamed from: $SwitchMap$com$shuame$rootgenius$common$qqdownload$QQDownloadFile$Status */
        static final /* synthetic */ int[] f4383xad0ed16c = new int[Status.values().length];

        static {
            try {
                f4383xad0ed16c[Status.ERROR_STOPED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4383xad0ed16c[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private void UpdateDone(final int i) {
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                if (1 == i) {
                    UpdatingAuthComponentFragment.TAG;
                    RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3645p));
                    UpdatingAuthComponentFragment.this.getActivity();
                    if (C1387ad.m3870b()) {
                        C1492j.m4165a();
                        C1492j.m4166a(UpdatingAuthComponentFragment.this.getActivity(), UpdatingAuthComponentFragment.this.getString(C1450R.string.notify_component_update_succ));
                        return;
                    }
                    return;
                }
                UpdatingAuthComponentFragment.TAG;
                RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3643n));
                UpdatingAuthComponentFragment.this.startActivity(new Intent(UpdatingAuthComponentFragment.this.getActivity(), UpdateComponentFailActivity.class));
                UpdatingAuthComponentFragment.this.getActivity();
                if (C1387ad.m3870b()) {
                    C1492j.m4165a();
                    C1492j.m4166a(UpdatingAuthComponentFragment.this.getActivity(), UpdatingAuthComponentFragment.this.getString(C1450R.string.notify_component_update_fail));
                }
            }
        }, 800);
        RootGeniusApp.m3523a().unregisterReceiver(this.mWifi2MobileReceiver);
        C1321b.m3685a().mo6991b(this.mIListener);
        isComponentUpdating = false;
    }

    private void findViews() {
        this.mvTvTip = (TextView) this.rootView.findViewById(C1450R.id.tv_tip);
        this.vRootProgressBar = (RootProgressBar) this.rootView.findViewById(C1450R.id.root_progress_bar);
    }

    private void init() {
        this.mNewSuInfo = C1488f.m4146b().mo7309a();
    }

    private void initListeners() {
        C1321b.m3685a().mo6990a(this.mIListener);
        RootGeniusApp.m3523a().registerReceiver(this.mWifi2MobileReceiver, new IntentFilter(C1340e.f3632c));
    }

    private void initUI() {
        this.mvTvTip.setText(C1450R.string.homepage_updating_root_component_wait_text);
        startUpdate();
    }

    private void installNewSU() {
        new C15832().start();
    }

    private void startDownload() {
        QQDownloadFile a = C1361b.m3817a().mo7068a(C1361b.m3815a(this.mNewSuInfo.f4003b));
        if (a == null) {
            a = this.mNewSuInfo.mo7242b();
            a.f3725f = C1397j.m3902b(a);
        } else if (a.f3719C == Status.FINISHED && !new File(a.f3725f).exists()) {
            C1361b.m3817a().mo7076d(a.f3722c);
            a = this.mNewSuInfo.mo7242b();
            a.f3725f = C1397j.m3902b(a);
        }
        C1361b.m3817a().mo7067a(a, null);
    }

    private void startUpdate() {
        isComponentUpdating = true;
        startDownload();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.rootView == null) {
            this.rootView = layoutInflater.inflate(C1450R.layout.fragment_homepage_updating_component, viewGroup, false);
            init();
            findViews();
            initListeners();
            initUI();
        }
        return this.rootView;
    }

    public void onProcess(int i) {
    }

    public void onProgress(int i) {
        new StringBuilder("onProgress percent:").append(i).append("%");
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.arg2 = (i / 2) + 50;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void onResult(int i) {
        C1446g.f3976a = i;
        if (i == 1 || i == 2) {
            UpdateDone(1);
        } else {
            UpdateDone(-1);
        }
    }

    public void onStart() {
        C1492j.m4165a();
        C1492j.m4174d();
        super.onStart();
    }

    public void openWifiGoneRemindDialog() {
        getActivity().runOnUiThread(new C15875());
    }
}
