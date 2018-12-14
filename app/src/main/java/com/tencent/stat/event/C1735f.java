package com.tencent.stat.event;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.tencent.mid.util.Util;
import com.tencent.stat.C1706ba;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.DeviceInfo;
import com.tencent.stat.common.StatCommonHelper;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.f */
public abstract class C1735f {
    /* renamed from: j */
    protected static String f5093j = null;
    /* renamed from: l */
    protected static int f5094l = -1;
    /* renamed from: a */
    private StatSpecifyReportedInfo f5095a = null;
    /* renamed from: b */
    protected String f5096b = null;
    /* renamed from: c */
    protected long f5097c;
    /* renamed from: d */
    protected int f5098d;
    /* renamed from: e */
    protected DeviceInfo f5099e = null;
    /* renamed from: f */
    protected int f5100f;
    /* renamed from: g */
    protected String f5101g = null;
    /* renamed from: h */
    protected String f5102h = null;
    /* renamed from: i */
    protected String f5103i = null;
    /* renamed from: k */
    protected boolean f5104k = false;
    /* renamed from: m */
    protected Context f5105m;

    C1735f(Context context, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5105m = context;
        this.f5097c = System.currentTimeMillis() / 1000;
        this.f5098d = i;
        this.f5102h = StatConfig.getInstallChannel(context);
        this.f5103i = StatCommonHelper.getCurAppVersion(context);
        this.f5096b = StatConfig.getAppKey(context);
        if (statSpecifyReportedInfo != null) {
            this.f5095a = statSpecifyReportedInfo;
            if (StatCommonHelper.isStringValid(statSpecifyReportedInfo.getAppKey())) {
                this.f5096b = statSpecifyReportedInfo.getAppKey();
            }
            if (StatCommonHelper.isStringValid(statSpecifyReportedInfo.getInstallChannel())) {
                this.f5102h = statSpecifyReportedInfo.getInstallChannel();
            }
            if (StatCommonHelper.isStringValid(statSpecifyReportedInfo.getVersion())) {
                this.f5103i = statSpecifyReportedInfo.getVersion();
            }
            this.f5104k = statSpecifyReportedInfo.isImportant();
        }
        this.f5101g = StatConfig.getCustomUserId(context);
        this.f5099e = C1706ba.m4673a(context).mo7875b(context);
        if (mo7924a() != EventType.NETWORK_DETECTOR) {
            this.f5100f = StatCommonHelper.getNextEventIndexNo(context).intValue();
        } else {
            this.f5100f = -EventType.NETWORK_DETECTOR.mo7923a();
        }
        if (!Util.isMidValid(f5093j)) {
            String localMidOnly = StatConfig.getLocalMidOnly(context);
            f5093j = localMidOnly;
            if (!StatCommonHelper.isStringValid(localMidOnly)) {
                f5093j = "0";
            }
        }
        if (f5094l == -1) {
            f5094l = StatCommonHelper.hasRootAccess(context);
        }
    }

    /* renamed from: a */
    public abstract EventType mo7924a();

    /* renamed from: a */
    public abstract boolean mo7925a(JSONObject jSONObject);

    /* renamed from: b */
    public boolean mo7926b(JSONObject jSONObject) {
        try {
            com.tencent.stat.common.Util.jsonPut(jSONObject, "ky", this.f5096b);
            jSONObject.put("et", mo7924a().mo7923a());
            if (this.f5099e != null) {
                jSONObject.put("ui", this.f5099e.getImei());
                com.tencent.stat.common.Util.jsonPut(jSONObject, "mc", this.f5099e.getMac());
                int userType = this.f5099e.getUserType();
                jSONObject.put("ut", userType);
                if (userType == 0 && StatCommonHelper.isTheFirstTimeActivate(this.f5105m) == 1) {
                    jSONObject.put("ia", 1);
                }
            }
            com.tencent.stat.common.Util.jsonPut(jSONObject, "cui", this.f5101g);
            String appVersion = StatConfig.getAppVersion();
            if (StatCommonHelper.isStringValid(appVersion)) {
                com.tencent.stat.common.Util.jsonPut(jSONObject, "av", appVersion);
                com.tencent.stat.common.Util.jsonPut(jSONObject, "appv", this.f5103i);
            } else {
                com.tencent.stat.common.Util.jsonPut(jSONObject, "av", this.f5103i);
            }
            com.tencent.stat.common.Util.jsonPut(jSONObject, "ch", this.f5102h);
            if (this.f5104k) {
                jSONObject.put("impt", 1);
            }
            com.tencent.stat.common.Util.jsonPut(jSONObject, "mid", f5093j);
            jSONObject.put("idx", this.f5100f);
            jSONObject.put("si", this.f5098d);
            jSONObject.put("ts", this.f5097c);
            jSONObject.put("dts", StatCommonHelper.getDiffTime(this.f5105m, false));
            jSONObject.put(IXAdRequestInfo.f648OS, 1);
            com.tencent.stat.common.Util.jsonPut(jSONObject, "ov", Integer.toString(VERSION.SDK_INT));
            com.tencent.stat.common.Util.jsonPut(jSONObject, IXAdRequestInfo.TEST_MODE, Build.MODEL);
            jSONObject.put("jb", f5094l);
            com.tencent.stat.common.Util.jsonPut(jSONObject, "mf", Build.MANUFACTURER);
            JSONObject customGlobalReportContent = StatConfig.getCustomGlobalReportContent();
            if (customGlobalReportContent != null && customGlobalReportContent.length() > 0) {
                jSONObject.put("cc", customGlobalReportContent.toString());
            }
            return mo7925a(jSONObject);
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: c */
    public String mo7927c() {
        return this.f5096b;
    }

    /* renamed from: d */
    public long mo7928d() {
        return this.f5097c;
    }

    /* renamed from: e */
    public StatSpecifyReportedInfo mo7929e() {
        return this.f5095a;
    }

    /* renamed from: f */
    public Context mo7930f() {
        return this.f5105m;
    }

    /* renamed from: g */
    public boolean mo7931g() {
        return this.f5104k;
    }

    /* renamed from: h */
    public String mo7932h() {
        try {
            JSONObject jSONObject = new JSONObject();
            mo7926b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }
}
