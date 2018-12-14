package com.shuame.rootgenius.hook.p112ui;

import android.app.Activity;
import android.content.p013pm.PackageInfo;
import android.content.p013pm.PackageManager;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.hook.HookModule;
import com.shuame.rootgenius.hook.service.DefenseHolder;
import com.shuame.rootgenius.sdk.CommUtils;

/* renamed from: com.shuame.rootgenius.hook.ui.UninstallWarnActivity */
public class UninstallWarnActivity extends Activity implements OnClickListener {
    private static final String TAG = UninstallWarnActivity.class.getSimpleName();
    private boolean isOneOperated = false;

    private void initListeners() {
        findViewById(C1450R.C1449id.btn_uninstall_cancel).setOnClickListener(this);
        findViewById(C1450R.C1449id.btn_uninstall_ok).setOnClickListener(this);
    }

    private boolean removeKinguser35() {
        PackageManager packageManager = HookModule.getContext().getPackageManager();
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = packageManager.getApplicationInfo("com.shuame.rootgenius", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (applicationInfo == null) {
            return false;
        }
        for (PackageInfo packageInfo : packageManager.getInstalledPackages(0)) {
            if (packageInfo.packageName.compareTo("com.kingroot.kinguser") == 0 && packageInfo.versionCode >= 87) {
                String execCmd = CommUtils.execCmd(true, String.format("am startservice -n com.kingroot.kinguser/com.kingroot.kinguser.service.KuCommonService -f '%d' --ei req_type '%d' --ei req_CallerUid '%d' ", new Object[]{Integer.valueOf(268435456), Integer.valueOf(1), Integer.valueOf(applicationInfo.uid)}));
                if (execCmd.indexOf("Starting service: Intent") >= 0 && execCmd.indexOf("no service started") < 0) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private void setAllow(boolean z) {
        if (!this.isOneOperated) {
            this.isOneOperated = true;
            new StringBuilder("=============user choose result allow: ").append(z).append(" ========== ");
            Handler serviceHandler = DefenseHolder.getInstance().getServiceHandler();
            Message obtain = Message.obtain();
            obtain.what = 1;
            Bundle bundle = new Bundle();
            bundle.putBoolean("allow", z);
            obtain.setData(bundle);
            serviceHandler.sendMessage(obtain);
            finish();
        }
    }

    public void onClick(View view) {
        if (view.getId() == C1450R.C1449id.btn_uninstall_cancel) {
            setAllow(false);
        } else if (view.getId() == C1450R.C1449id.btn_uninstall_ok) {
            removeKinguser35();
            setAllow(true);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.activity_uninstall_warn);
        initListeners();
    }

    protected void onPause() {
        if (!this.isOneOperated) {
            setAllow(false);
        }
        super.onPause();
    }
}
