package com.shuame.rootgenius.p115ui.homepage.listeners;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.shuame.mobile.module.autoboot.p085ui.AutoBootManagerActivity;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.appmanager.p096ui.activity.AppUninstallActivity;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.event.C1336a;
import com.shuame.rootgenius.common.event.C1337b;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.event.C1345i;
import com.shuame.rootgenius.common.manager.p104a.C1354c;
import com.shuame.rootgenius.common.manager.p104a.C1354c.C1352a;
import com.shuame.rootgenius.common.p087ui.p106a.C1376b;
import com.shuame.rootgenius.common.p087ui.p106a.C1376b.C1375a;
import com.shuame.rootgenius.common.p102c.C1324a;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.common.util.C1391d;
import com.shuame.rootgenius.common.util.C1416x;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p108e.C1422a;
import com.shuame.rootgenius.p108e.C1423b;
import com.shuame.rootgenius.p113i.C1455a;
import com.shuame.rootgenius.p115ui.BbxDetailActivity;
import com.shuame.rootgenius.p115ui.BbxListActivity;
import com.shuame.rootgenius.p115ui.FontReplaceActivity;
import com.shuame.rootgenius.p115ui.ShuameGuideActivity;
import com.shuame.rootgenius.p115ui.adapter.C1506a;
import com.shuame.rootgenius.pojo.BbxCategoryInfo;
import com.shuame.rootgenius.pojo.BbxCategoryInfo.Item;
import com.shuame.rootgenius.pojo.BbxCategoryInfo.Item.Type;
import com.shuame.rootgenius.service.C1489g;
import java.io.Serializable;
import java.util.Properties;

/* renamed from: com.shuame.rootgenius.ui.homepage.listeners.BbxItemClickListener */
public class BbxItemClickListener implements OnItemClickListener {
    private Activity mAct;
    private C1506a mAdapter;
    private Handler mHandler = new Handler();
    private C1376b mRemindUpdateDialog;
    private C1376b remindRootDialog;

    /* renamed from: com.shuame.rootgenius.ui.homepage.listeners.BbxItemClickListener$1 */
    class C15901 implements Runnable {
        C15901() {
        }

        public void run() {
            BbxItemClickListener.this.mAdapter.notifyDataSetChanged();
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.listeners.BbxItemClickListener$2 */
    class C15912 implements C1352a {
        C15912() {
        }

        public void onFailed(int i) {
        }

        public void onSuccess() {
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.listeners.BbxItemClickListener$3 */
    class C15923 implements OnClickListener {
        C15923() {
        }

        public void onClick(View view) {
            if (C1345i.m3749a().mo7020b()) {
                C1416x.m3936a((int) C1450R.string.jointed_core_func_goto_pc_operation);
                return;
            }
            C1323b.m3688a().mo6998d("shuame_mobile");
            RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3640k));
            C1323b.m3697d(true);
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.homepage.listeners.BbxItemClickListener$4 */
    class C15934 implements OnClickListener {
        C15934() {
        }

        public void onClick(View view) {
            if (view.getId() == C1450R.id.btn_right) {
                C1489g.m4151a().mo7312a(true);
            }
            BbxItemClickListener.this.mRemindUpdateDialog.cancel();
        }
    }

    public BbxItemClickListener(Activity activity, C1506a c1506a) {
        this.mAct = activity;
        this.mAdapter = c1506a;
    }

    private void openRemindRootDialog() {
        C1391d.m3890a(this.mAct, C1450R.string.shuame_guide_title, C1450R.string.shuame_guide_dialog_remind_root_msg, C1450R.string.shuame_guide_dialog_remind_root_btn_cancel, C1450R.string.shuame_guide_dialog_remind_root_btn_root, C1450R.color.dialog_btn_cancel, C1450R.color.dialog_btn_confirm_green, null, new C15923());
    }

    private void openRemindUpdateDialog() {
        if (this.mRemindUpdateDialog == null) {
            C1375a c1375a = new C1375a();
            c1375a.f3820d = false;
            c1375a.f3817a = C1450R.string.bbx_remind_update_msg;
            c1375a.f3823g = C1450R.string.bbx_remind_update_btn;
            c1375a.f3824h = new C15934();
            this.mRemindUpdateDialog = new C1376b(this.mAct, c1375a);
        }
        this.mRemindUpdateDialog.show();
    }

    private void reportLaunch(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            C1336a c1336a = new C1336a();
            c1336a.f3616g = str;
            c1336a.f3610a = str2;
            c1336a.f3611b = "launch";
            c1336a.f3612c = "true";
            c1336a.f3615f = 1;
            c1336a.f3613d = "APP启动成功";
            C1337b.m3738a().mo7007c(c1336a);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!C1455a.m4025a() && !C1323b.m3700e()) {
            BbxCategoryInfo a = this.mAdapter.mo7404a(i);
            if (a != null && !TextUtils.isEmpty(a.displayName)) {
                if (a.isRemind) {
                    a.isRemind = false;
                    C1323b.m3688a().mo6996a(a.name + "_isRemind", false);
                    this.mHandler.postDelayed(new C15901(), 1500);
                }
                String str = a.displayName;
                String str2 = a.name;
                Properties properties = new Properties();
                C1324a.m3722a(view.getContext());
                if ("shuame_mobile".equalsIgnoreCase(a.name)) {
                    if (C1323b.m3698d()) {
                        if (C1387ad.m3868a(RootGeniusApp.m3523a(), "com.shuame.mobile")) {
                            reportLaunch("com.shuame.mobile", "shuame_mobile");
                        } else {
                            this.mAct.startActivity(new Intent(this.mAct, ShuameGuideActivity.class));
                        }
                        C1423b.m3949a().mo7143b(new C1422a("shuame_mobile", "shuame_mobile"));
                        properties.clear();
                        C1324a.m3723a("ShuaJi", null);
                        return;
                    }
                    openRemindRootDialog();
                } else if ("huangeziti".equalsIgnoreCase(a.name)) {
                    this.mAct.startActivity(new Intent(this.mAct, FontReplaceActivity.class));
                    C1423b.m3949a().mo7143b(new C1422a("huangeziti", "huangeziti"));
                    properties.clear();
                    C1324a.m3723a("ChangeFont", null);
                } else if ("appuninstall".equalsIgnoreCase(a.name)) {
                    this.mAct.startActivity(new Intent(this.mAct, AppUninstallActivity.class));
                    C1423b.m3949a().mo7143b(new C1422a("appuninstall", "appuninstall"));
                    properties.clear();
                    C1324a.m3723a("AppUnistall", null);
                } else if ("autoboot".equalsIgnoreCase(a.name)) {
                    this.mAct.startActivity(new Intent(this.mAct, AutoBootManagerActivity.class));
                    C1423b.m3949a().mo7143b(new C1422a("autoboot", "autoboot"));
                    properties.clear();
                    C1324a.m3723a("AutoBoot", null);
                } else {
                    properties.clear();
                    C1324a.m3723a(str2, null);
                    if (a.items.size() == 1) {
                        Item item = (Item) a.items.get(0);
                        if (Type.APK == item.type) {
                            Intent intent = new Intent(this.mAct, BbxDetailActivity.class);
                            intent.putExtra("info", item);
                            this.mAct.startActivity(intent);
                        } else if (Type.URL == item.type) {
                            C1455a.m4024a(this.mAct, item.url);
                        } else if (Type.MINI_OS == item.type) {
                            C1354c.m3794a().mo7043a(this.mAct, "gh_283c766d855f", "pages/index/index?channel=40005", new C15912());
                        }
                        C1423b.m3949a().mo7143b(new C1422a(str2, item.name));
                    } else if (a.items.size() > 1) {
                        Serializable serializable = a.items;
                        Intent intent2 = new Intent(this.mAct, BbxListActivity.class);
                        intent2.putExtra("title", str);
                        intent2.putExtra("list", serializable);
                        this.mAct.startActivity(intent2);
                        C1423b.m3949a().mo7143b(new C1422a(str2, null));
                    } else {
                        openRemindUpdateDialog();
                    }
                }
            }
        }
    }
}
