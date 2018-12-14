package com.p070qq.p071e.comm.managers.setting;

import com.p070qq.p071e.comm.constants.Constants.KEYS;

/* renamed from: com.qq.e.comm.managers.setting.b */
public final class C1069b extends C1068c {
    public C1069b() {
        mo6494a(KEYS.SDKServerGetADReportSamplingRate, Integer.valueOf(1));
        mo6494a(KEYS.SDKServerExpReportSamplingRate, Integer.valueOf(1));
        mo6494a(KEYS.SDKServerClickReportSamplingRate, Integer.valueOf(100));
        mo6494a(KEYS.RequireWindowFocus, Integer.valueOf(1));
        mo6494a(KEYS.SHOW_LOGO, Integer.valueOf(1));
        mo6494a(KEYS.INNER_BROWSER_SCHEME, "weixin,tel,openapp.jdmobile");
        mo6494a(KEYS.THIRD_PARTY_BROWSER, "com.android.browser,com.android.chrome,com.baidu.browser.apps,com.UCMobile,com.tencent.mtt");
        mo6494a(KEYS.Banner_RF, Integer.valueOf(30000));
        mo6494a(KEYS.SPLASH_LOADTIMEOUT, Integer.valueOf(3000));
        mo6494a(KEYS.SPLASH_EXPOSURE_TIME, Integer.valueOf(5000));
        mo6494a(KEYS.SPLASH_NETWORK_PERMISION, Integer.valueOf(26));
        mo6494a(KEYS.SPLASH_MAX_REQUEST_NUM, Integer.valueOf(100));
        mo6494a(KEYS.FORCE_EXPOSURE, Integer.valueOf(1));
    }
}
