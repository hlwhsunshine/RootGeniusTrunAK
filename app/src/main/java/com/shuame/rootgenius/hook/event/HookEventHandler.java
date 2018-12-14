package com.shuame.rootgenius.hook.event;

import android.os.Build.VERSION;
import android.p014os.SystemProperties;
import android.text.TextUtils;
import com.shuame.p076b.p077a.C1140o;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.common.util.C1396i;
import com.shuame.rootgenius.common.util.C1402l;
import com.shuame.rootgenius.common.util.C1402l.C1400b;
import com.shuame.rootgenius.common.util.C1412t;
import com.shuame.rootgenius.hook.HookData;
import com.shuame.rootgenius.hook.HookModule;
import com.shuame.rootgenius.sdk.RgsdkConfig;
import com.shuame.rootgenius.sdk.RootGenius;
import com.shuame.rootgenius.sdk.proto.ProtoData.DeviceSolution;

public class HookEventHandler {
    private static final String TAG = HookEventHandler.class.getSimpleName();
    private static volatile HookEventHandler sInstance;
    private boolean isChecking = false;

    /* renamed from: com.shuame.rootgenius.hook.event.HookEventHandler$1 */
    class C14511 extends Thread {
        C14511() {
        }

        public void run() {
            C1323b.m3688a();
            CharSequence l = C1323b.m3707l();
            if (TextUtils.isEmpty(l)) {
                try {
                    DeviceSolution preQueryRoot = RootGenius.preQueryRoot();
                    if (!(preQueryRoot == null || TextUtils.isEmpty(preQueryRoot.productId))) {
                        l = preQueryRoot.productId;
                        C1323b.m3688a();
                        C1323b.m3689a((String) l);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(l)) {
                HookEventHandler.TAG;
                return;
            }
            HookEventHandler.this.reportInjectResult();
            HookEventHandler.this.reportHookedUninstallResult();
            HookEventHandler.this.isChecking = false;
        }
    }

    private HookEventHandler() {
    }

    private void addChildXmlHookedUninstallAppInfo(StringBuilder stringBuilder) {
        if (stringBuilder != null) {
            stringBuilder.append("<action_type>hooked_uninstall</action_type>");
            stringBuilder.append("<error_code>").append("-1").append("</error_code>");
        }
    }

    private void addChildXmlInjectInfo(StringBuilder stringBuilder, int i, String str) {
        if (stringBuilder != null) {
            stringBuilder.append("<action_type>inject</action_type>");
            stringBuilder.append("<error_code>").append(i).append("</error_code>");
            if (str != null) {
                stringBuilder.append("<desc>").append(str).append("</desc>");
            }
        }
    }

    private void addXmlFootder(StringBuilder stringBuilder) {
        if (stringBuilder != null) {
            stringBuilder.append("</report>");
        }
    }

    private void addXmlHeader(StringBuilder stringBuilder) {
        if (stringBuilder != null) {
            C1140o.m3287a().mo6730a(HookModule.getContext());
            String str = (String) C1140o.m3287a().mo6731b().get("rombrand");
            String str2 = SystemProperties.get("romzj.rom.id");
            int i = VERSION.SDK_INT;
            String str3 = VERSION.RELEASE;
            String valueOf = String.valueOf(C1323b.m3711p());
            String str4 = RgsdkConfig.sChVersionName;
            String str5 = RootGenius.GetDeviceInfo().phoneId.rid;
            String e = C1387ad.m3877e(HookModule.getContext());
            String f = C1387ad.m3878f(HookModule.getContext());
            String a = C1387ad.m3865a(true);
            String d = C1387ad.m3874d(HookModule.getContext());
            String c = C1387ad.m3872c();
            C1323b.m3688a();
            String l = C1323b.m3707l();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
            stringBuilder.append("<report>");
            if (str != null) {
                stringBuilder.append("<rom_type>").append(str).append("</rom_type>");
            }
            if (l != null) {
                stringBuilder.append("<product_id>").append(l).append("</product_id>");
            }
            stringBuilder.append("<romzj_rom_id>").append(str2).append("</romzj_rom_id>");
            stringBuilder.append("<android_sdk>").append(i).append("</android_sdk>");
            stringBuilder.append("<android_version>").append(str3).append("</android_version>");
            stringBuilder.append("<version_code>").append(valueOf).append("</version_code>");
            stringBuilder.append("<version_name>").append(str4).append("</version_name>");
            if (str5 != null) {
                stringBuilder.append("<rid>").append(str5).append("</rid>");
            }
            if (e != null) {
                stringBuilder.append("<imei>").append(e).append("</imei>");
            }
            if (f != null) {
                stringBuilder.append("<imsi>").append(f).append("</imsi>");
            }
            if (a != null) {
                stringBuilder.append("<qimei>").append(a).append("</qimei>");
            }
            if (d != null) {
                stringBuilder.append("<mac_address>").append(d).append("</mac_address>");
            }
            if (c != null) {
                stringBuilder.append("<sn>").append(c).append("</sn>");
            }
            if (currentTimeMillis != 0) {
                stringBuilder.append("<report_timestamp>").append(currentTimeMillis).append("</report_timestamp>");
            }
        }
    }

    public static HookEventHandler getInstance() {
        if (sInstance == null) {
            synchronized (HookEventHandler.class) {
                if (sInstance == null) {
                    sInstance = new HookEventHandler();
                }
            }
        }
        return sInstance;
    }

    private void reportHookedUninstallResult() {
        if (!HookData.getInstance().isHookedUninstallErrorReported()) {
            StringBuilder stringBuilder = new StringBuilder();
            addXmlHeader(stringBuilder);
            addChildXmlHookedUninstallAppInfo(stringBuilder);
            addXmlFootder(stringBuilder);
            new StringBuilder("reportHookedUninstallAppResult:").append(stringBuilder.toString());
            try {
                C1400b c1400b = new C1400b();
                byte[] bytes = stringBuilder.toString().getBytes("UTF-8");
                C1396i.m3893a(bytes, C1396i.f3874a);
                c1400b.f3880a = getServant();
                c1400b.f3881b = bytes;
                c1400b.f3883d = 5000;
                if (C1402l.m3903a(c1400b).f3885a == 200) {
                    HookData.getInstance().hookedUninstallErrorReported(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void reportInjectResult() {
        Object injectResultDesc = HookData.getInstance().getInjectResultDesc();
        if (!TextUtils.isEmpty(injectResultDesc)) {
            int injectResultCode = HookData.getInstance().getInjectResultCode();
            StringBuilder stringBuilder = new StringBuilder();
            addXmlHeader(stringBuilder);
            addChildXmlInjectInfo(stringBuilder, injectResultCode, injectResultDesc);
            addXmlFootder(stringBuilder);
            new StringBuilder("reportInjectkResult:").append(stringBuilder.toString());
            try {
                C1400b c1400b = new C1400b();
                byte[] bytes = stringBuilder.toString().getBytes("UTF-8");
                C1396i.m3893a(bytes, C1396i.f3874a);
                c1400b.f3880a = getServant();
                c1400b.f3881b = bytes;
                c1400b.f3883d = 5000;
                if (C1402l.m3903a(c1400b).f3885a == 200) {
                    HookData.getInstance().saveInjectResultDesc("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void asyncReport() {
        if (!this.isChecking) {
            this.isChecking = true;
            new C14511().start();
        }
    }

    public String getServant() {
        String str = "http://api2.rootjl.%s/v2/stat/m/root/hook?versionName=%s&versionCode=%s";
        Object[] objArr = new Object[3];
        objArr[0] = C1412t.f3902a ? "org" : "com";
        objArr[1] = C1323b.m3709n();
        objArr[2] = Integer.valueOf(C1323b.m3711p());
        return String.format(str, objArr);
    }
}
