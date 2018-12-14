package com.shuame.rootgenius.hook.util;

import android.text.TextUtils;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.common.util.C1411s;
import com.shuame.rootgenius.common.util.C1412t;
import com.shuame.rootgenius.common.util.C1414v;
import com.shuame.rootgenius.common.util.NetworkUtils;
import com.shuame.rootgenius.hook.HookData;
import com.shuame.rootgenius.hook.HookModule;
import com.shuame.rootgenius.hook.event.HookEventHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class HookManager {
    private static final String TAG = HookManager.class.getSimpleName();
    private static boolean flagRegisting = false;

    /* renamed from: com.shuame.rootgenius.hook.util.HookManager$1 */
    final class C14541 extends Thread {
        C14541() {
        }

        public final void run() {
            HookManager.saveTestLog("registerHook() start", true);
            boolean b = NetworkUtils.m3852b();
            int i = 0;
            while (!b && i <= 15) {
                i++;
                try {
                    Thread.sleep(1000);
                    b = NetworkUtils.m3852b();
                } catch (Exception e) {
                }
            }
            HookManager.saveTestLog("netUseable:" + b, true);
            if (b) {
                File file = new File("/data/.sUJhQspROPExe");
                if (file.exists()) {
                    HookData.getInstance().existHookedUninstallErrorFileFlag(true);
                    HookData.getInstance().hookedUninstallErrorReported(false);
                    HookData.getInstance().saveHookedUninstallErrorVersionCode(C1323b.m3711p());
                    file.delete();
                    HookEventHandler.getInstance().asyncReport();
                }
                if (!HookData.getInstance().existHookedUninstallErrorFileFlag() || C1323b.m3711p() > HookData.getInstance().getHookedUninstallErrorVersionCode()) {
                    HookData.getInstance().existHookedUninstallErrorFileFlag(false);
                    b = HookNetRequestUtil.getInstance().isAllowHook();
                    HookManager.TAG;
                    HookManager.saveTestLog("registerHook() isAllowHook:" + b, true);
                    if (b) {
                        try {
                            b = C1387ad.m3875d();
                            HookManager.TAG;
                            if (b) {
                                HookTool.injectDefenseService(HookModule.getContext());
                            }
                        } catch (Exception e2) {
                            HookManager.saveTestLog(e2.toString(), true);
                            e2.printStackTrace();
                        }
                    } else {
                        HookTool.uninjectDefenseService(HookModule.getContext());
                    }
                    HookManager.saveTestLog("registerHook() end", true);
                    HookManager.flagRegisting = false;
                    return;
                }
                HookManager.TAG;
                HookManager.flagRegisting = false;
                HookManager.saveTestLog("hook action interrupted. wait app update hook files!", true);
                HookManager.saveTestLog("registerHook() end", true);
                return;
            }
            HookManager.flagRegisting = false;
            HookManager.saveTestLog("registerHook() end", true);
        }
    }

    public static void registerHook() {
    }

    private static void saveTestLog(String str, boolean z) {
        if (C1412t.f3902a) {
            Object a = C1411s.m3923a(true);
            if (!TextUtils.isEmpty(a)) {
                String str2 = a + "/inject.log";
                String str3 = C1414v.m3931a(System.currentTimeMillis()) + "--" + str;
                try {
                    OutputStream fileOutputStream = new FileOutputStream(str2, z);
                    fileOutputStream.write(str3.getBytes());
                    fileOutputStream.write(10);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
