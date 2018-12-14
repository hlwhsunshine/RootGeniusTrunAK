package com.shuame.rootgenius.p115ui.homepage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.p015v4.app.FragmentActivity;
import android.support.p015v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.shuame.mobile.module.autoboot.p085ui.AutoBootManagerActivity;
import com.shuame.rootgenius.C1446g;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.appmanager.p093c.C1264b;
import com.shuame.rootgenius.appmanager.p096ui.activity.AppUninstallActivity;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.event.C1337b;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.event.C1345i;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.common.util.C1391d;
import com.shuame.rootgenius.common.util.C1412t;
import com.shuame.rootgenius.common.util.C1416x;
import com.shuame.rootgenius.common.util.NetworkUtils;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p107d.C1420b;
import com.shuame.rootgenius.p108e.C1422a;
import com.shuame.rootgenius.p108e.C1423b;
import com.shuame.rootgenius.p113i.C1455a;
import com.shuame.rootgenius.p115ui.BbxDetailActivity;
import com.shuame.rootgenius.p115ui.JointPCActivity;
import com.shuame.rootgenius.p115ui.MoreActivity;
import com.shuame.rootgenius.p115ui.UpdateActivity;
import com.shuame.rootgenius.p115ui.homepage.listeners.IFragmentOnBackPressedListener;
import com.shuame.rootgenius.pojo.BbxCategoryInfo.Item;
import com.shuame.rootgenius.pojo.BbxPopInfo;
import com.shuame.rootgenius.pojo.C1460b;
import com.shuame.rootgenius.service.C1483c;
import com.shuame.rootgenius.service.C1489g;

/* renamed from: com.shuame.rootgenius.ui.homepage.HomepageActivity */
public class HomepageActivity extends FragmentActivity implements OnClickListener {
    private static final int HANDLER_BBX_POP = 2;
    private static final int HANDLER_CHANGE_UI = 1;
    private static final int HANDLER_CHECK_NEW_VERSION_FINISH = 3;
    private static final String TAG = HomepageActivity.class.getSimpleName();
    private boolean allowAutoReport = false;
    private FrameLayout contentLayout;
    private long exitTime = 0;
    /* renamed from: fm */
    private FragmentManager f4382fm;
    private IFragmentOnBackPressedListener mFragmentOnBackPressedListener;
    private Handler mHandler = new Handler(new C15574());
    private BroadcastReceiver mReceiver = new C15563();

    /* renamed from: com.shuame.rootgenius.ui.homepage.HomepageActivity$1 */
    class C15541 implements OnClickListener {
        C15541() {
        }

        public void onClick(View view) {
            C1391d.m3890a(HomepageActivity.this, C1450R.string.bbx_pop_dialog_cancel_reconfirm_title, C1450R.string.bbx_pop_dialog_cancel_reconfirm_content, 0, C1450R.string.bbx_pop_dialog_cancel_reconfirm_ok, 0, C1450R.color.dialog21_btn_text_heigh_light, null, null);
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.HomepageActivity$3 */
    class C15563 extends BroadcastReceiver {
        C15563() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            HomepageActivity.TAG;
            Message obtainMessage;
            if (C1340e.f3635f.equals(action)) {
                int intExtra = intent.getIntExtra("param_data", 3);
                obtainMessage = HomepageActivity.this.mHandler.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = intExtra;
                HomepageActivity.this.mHandler.sendMessage(obtainMessage);
            } else if (C1340e.f3634e.equals(action)) {
                HomepageActivity.this.onProcessNewVersion();
            } else if (C1340e.f3630a.equals(action) && C1345i.m3749a().mo7020b()) {
                Message obtainMessage2 = HomepageActivity.this.mHandler.obtainMessage();
                obtainMessage2.what = 1;
                if (C1323b.m3698d()) {
                    obtainMessage2.obj = C1340e.f3642m;
                } else {
                    obtainMessage2.obj = C1340e.f3639j;
                }
                HomepageActivity.this.mHandler.sendMessage(obtainMessage2);
            } else {
                obtainMessage = HomepageActivity.this.mHandler.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.obj = action;
                HomepageActivity.this.mHandler.sendMessage(obtainMessage);
            }
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.HomepageActivity$4 */
    class C15574 implements Callback {
        C15574() {
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    HomepageActivity.this.onPrepChangeUI(String.valueOf(message.obj));
                    break;
                case 2:
                    HomepageActivity.this.onProcessPop(message.arg1);
                    break;
            }
            return false;
        }
    }

    private void asyncAutoReport() {
        if (RootGeniusApp.m3526b() && this.allowAutoReport) {
            C1337b.m3738a().mo7006b();
            C1423b.m3949a().mo7142b();
            C1264b.m3595a().mo6913b();
        }
    }

    private void findViews() {
        this.contentLayout = (FrameLayout) findViewById(C1450R.id.fragment_container);
    }

    private void init() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        RootGeniusApp.f3302b = displayMetrics.density;
        C1412t.m3929a(TAG, "RootGeniusApp.density:" + RootGeniusApp.f3302b);
        this.f4382fm = getSupportFragmentManager();
    }

    private void initListeners() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(C1340e.f3637h);
        intentFilter.addAction(C1340e.f3638i);
        intentFilter.addAction(C1340e.f3639j);
        intentFilter.addAction(C1340e.f3640k);
        intentFilter.addAction(C1340e.f3641l);
        intentFilter.addAction(C1340e.f3642m);
        intentFilter.addAction(C1340e.f3643n);
        intentFilter.addAction(C1340e.f3644o);
        intentFilter.addAction(C1340e.f3645p);
        intentFilter.addAction(C1340e.f3646q);
        intentFilter.addAction(C1340e.f3647r);
        intentFilter.addAction(C1340e.f3635f);
        intentFilter.addAction(C1340e.f3634e);
        intentFilter.addAction(C1340e.f3630a);
        registerReceiver(this.mReceiver, intentFilter);
    }

    private void initUIData() {
        this.contentLayout.removeAllViews();
        onPrepChangeUI(C1340e.f3637h);
    }

    private void onChangeUI(String str) {
        this.contentLayout.removeAllViews();
        Object rootSuccFragment;
        if (C1340e.f3646q.equals(str)) {
            this.f4382fm.beginTransaction().replace(C1450R.id.fragment_container, new RootRemoveIngFragment()).commitAllowingStateLoss();
        } else if (C1340e.f3641l.equals(str)) {
            rootSuccFragment = new RootSuccFragment();
            this.f4382fm.beginTransaction().replace(C1450R.id.fragment_container, rootSuccFragment).commitAllowingStateLoss();
            this.mFragmentOnBackPressedListener = rootSuccFragment;
        } else if (C1340e.f3642m.equals(str)) {
            rootSuccFragment = new RootedFragment();
            this.f4382fm.beginTransaction().replace(C1450R.id.fragment_container, rootSuccFragment).commitAllowingStateLoss();
            this.mFragmentOnBackPressedListener = rootSuccFragment;
        } else if (C1340e.f3645p.equals(str)) {
            rootSuccFragment = new UpdateAuthComponentSuccFragment();
            this.f4382fm.beginTransaction().replace(C1450R.id.fragment_container, rootSuccFragment).commitAllowingStateLoss();
            this.mFragmentOnBackPressedListener = rootSuccFragment;
        } else if (C1340e.f3637h.equals(str)) {
            this.f4382fm.beginTransaction().replace(C1450R.id.fragment_container, new ScanFragment()).commitAllowingStateLoss();
        } else if (C1340e.f3639j.equals(str)) {
            if (C1323b.m3698d() || !C1323b.m3712q()) {
                rootSuccFragment = new NonsupportRootFragment();
                this.f4382fm.beginTransaction().replace(C1450R.id.fragment_container, rootSuccFragment).commitAllowingStateLoss();
                this.mFragmentOnBackPressedListener = rootSuccFragment;
            } else {
                rootSuccFragment = new PrepareRootFragment();
                this.f4382fm.beginTransaction().replace(C1450R.id.fragment_container, rootSuccFragment).commitAllowingStateLoss();
                this.mFragmentOnBackPressedListener = rootSuccFragment;
            }
        } else if (C1340e.f3638i.equals(str)) {
            rootSuccFragment = new NonsupportRootFragment();
            this.f4382fm.beginTransaction().replace(C1450R.id.fragment_container, rootSuccFragment).commitAllowingStateLoss();
            this.mFragmentOnBackPressedListener = rootSuccFragment;
        } else if (C1340e.f3640k.equals(str)) {
            if (!RootingFragment.isRooting) {
                this.f4382fm.beginTransaction().replace(C1450R.id.fragment_container, new RootingFragment()).commitAllowingStateLoss();
            }
        } else if (C1340e.f3647r.equals(str)) {
            this.f4382fm.beginTransaction().replace(C1450R.id.fragment_container, new OptimizeFragment()).commitAllowingStateLoss();
        } else if (C1340e.f3643n.equals(str)) {
            this.f4382fm.beginTransaction().replace(C1450R.id.fragment_container, new PrepareUpdateAuthComponentFragment()).commitAllowingStateLoss();
        } else if (C1340e.f3644o.equals(str)) {
            this.f4382fm.beginTransaction().replace(C1450R.id.fragment_container, new UpdatingAuthComponentFragment()).commitAllowingStateLoss();
        }
        onDoneChangeUI(str);
    }

    private void onDoneChangeUI(String str) {
        if (C1323b.m3695c() && C1345i.m3749a().mo7021c()) {
            Intent intent = null;
            if (C1345i.m3749a().mo7022d()) {
                intent = new Intent(this, JointPCActivity.class);
            } else if (C1345i.m3749a().mo7023e()) {
                intent = new Intent(this, AppUninstallActivity.class);
            } else if (C1345i.m3749a().mo7024f()) {
                intent = new Intent(this, AutoBootManagerActivity.class);
            }
            if (intent != null) {
                startActivity(intent);
            }
        }
    }

    private void onPrepChangeUI(String str) {
        if (!C1340e.f3640k.equals(str)) {
            C1323b.m3697d(false);
        }
        if (!C1340e.f3637h.equals(str)) {
            this.allowAutoReport = true;
        }
        asyncAutoReport();
        this.mFragmentOnBackPressedListener = null;
        onChangeUI(str);
    }

    private void onProcessNewVersion() {
        C1460b b = C1489g.m4151a().mo7313b();
        if (b.f4006a != 200) {
            C1416x.m3936a((int) C1450R.string.check_failed);
        } else if (b.mo7243a()) {
            startActivity(new Intent(this, UpdateActivity.class));
        } else {
            C1416x.m3936a((int) C1450R.string.uptodate);
        }
    }

    private void onProcessPop(int i) {
        BbxPopInfo b = C1420b.m3944a().mo7139b();
        if (b != null && !b.isShowed) {
            switch (b.option) {
                case 1:
                    if (1 == i) {
                        C1446g.m4003a();
                        if (!C1446g.m4015i()) {
                            showBbxPop(b);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (2 == i) {
                        showBbxPop(b);
                        return;
                    }
                    return;
                case 3:
                    if (1 == i) {
                        C1446g.m4003a();
                        if (!C1446g.m4015i()) {
                            showBbxPop(b);
                            return;
                        }
                    }
                    if (2 == i) {
                        showBbxPop(b);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void showBbxPop(BbxPopInfo bbxPopInfo) {
        final Item a = C1483c.m4131a().mo7304a(bbxPopInfo.name);
        if (a != null) {
            if (C1387ad.m3871b(a.packageName)) {
                new StringBuilder("弹窗推荐-不展示，已安装该App:").append(a.displayName);
                return;
            }
            String string;
            int i;
            String str = bbxPopInfo.title;
            String str2 = bbxPopInfo.text;
            String str3 = bbxPopInfo.pic;
            String string2 = getString(C1450R.string.bbx_pop_dialog_cancel);
            if (NetworkUtils.m3854d()) {
                string = getString(C1450R.string.bbx_pop_dialog_try);
                i = C1450R.color.dialog21_btn_text_heigh_light;
            } else {
                string = getString(C1450R.string.bbx_pop_dialog_see_detail);
                i = 0;
            }
            C1391d.m3891a(this, str, str2, str3, string2, string, 0, i, new C15541(), new OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(HomepageActivity.this, BbxDetailActivity.class);
                    intent.putExtra("info", a);
                    intent.putExtra("auto_download", true);
                    HomepageActivity.this.startActivity(intent);
                    C1423b.m3949a().mo7143b(new C1422a(a.cName, a.name));
                }
            });
            bbxPopInfo.isShowed = true;
            C1420b.m3944a().mo7140b(bbxPopInfo);
        }
    }

    public void onBackPressed() {
        if (C1455a.m4026a(false)) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            startActivity(intent);
        } else if (this.mFragmentOnBackPressedListener != null && this.mFragmentOnBackPressedListener.onBackPressed()) {
        } else {
            if (System.currentTimeMillis() - this.exitTime > 2000) {
                C1416x.m3936a((int) C1450R.string.string_exit);
                this.exitTime = System.currentTimeMillis();
                return;
            }
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        if (!C1455a.m4025a() && view.getId() == C1450R.id.btn_more) {
            startActivity(MoreActivity.m4257a((Context) this));
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.activity_homepage);
        C1323b.m3690a(true);
        init();
        findViews();
        initListeners();
        initUIData();
    }

    protected void onDestroy() {
        super.onDestroy();
        C1323b.m3690a(false);
        unregisterReceiver(this.mReceiver);
        C1361b.m3817a().mo7072b();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82) {
            return super.onKeyDown(i, keyEvent);
        }
        startActivity(MoreActivity.m4257a((Context) this));
        return true;
    }

    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        sendBroadcast(new Intent(intent.getAction()));
        super.onNewIntent(intent);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
    }

    protected void onSaveInstanceState(Bundle bundle) {
    }

    protected void onStart() {
        super.onStart();
        asyncAutoReport();
    }
}
