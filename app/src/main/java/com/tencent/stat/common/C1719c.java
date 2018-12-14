package com.tencent.stat.common;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.tencent.stat.C1706ba;
import com.tencent.stat.NetworkManager;
import com.tencent.stat.StatConfig;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.common.c */
class C1719c {
    /* renamed from: a */
    String f5046a;
    /* renamed from: b */
    String f5047b;
    /* renamed from: c */
    DisplayMetrics f5048c;
    /* renamed from: d */
    int f5049d;
    /* renamed from: e */
    String f5050e;
    /* renamed from: f */
    String f5051f;
    /* renamed from: g */
    String f5052g;
    /* renamed from: h */
    String f5053h;
    /* renamed from: i */
    String f5054i;
    /* renamed from: j */
    String f5055j;
    /* renamed from: k */
    String f5056k;
    /* renamed from: l */
    int f5057l;
    /* renamed from: m */
    String f5058m;
    /* renamed from: n */
    String f5059n;
    /* renamed from: o */
    String f5060o;
    /* renamed from: p */
    Context f5061p;
    /* renamed from: q */
    private String f5062q;
    /* renamed from: r */
    private String f5063r;
    /* renamed from: s */
    private String f5064s;
    /* renamed from: t */
    private String f5065t;
    /* renamed from: u */
    private String f5066u;

    private C1719c(Context context) {
        this.f5047b = StatConstants.VERSION;
        this.f5049d = VERSION.SDK_INT;
        this.f5050e = Build.MODEL;
        this.f5051f = Build.MANUFACTURER;
        this.f5052g = Locale.getDefault().getLanguage();
        this.f5057l = 0;
        this.f5059n = null;
        this.f5060o = null;
        this.f5061p = null;
        this.f5062q = null;
        this.f5063r = null;
        this.f5064s = null;
        this.f5065t = null;
        this.f5066u = null;
        this.f5061p = context.getApplicationContext();
        this.f5048c = StatCommonHelper.getDisplayMetrics(this.f5061p);
        this.f5046a = StatCommonHelper.getCurAppVersion(this.f5061p);
        this.f5053h = StatConfig.getInstallChannel(this.f5061p);
        this.f5054i = StatCommonHelper.getSimOperator(this.f5061p);
        this.f5055j = TimeZone.getDefault().getID();
        this.f5057l = StatCommonHelper.hasRootAccess(this.f5061p);
        this.f5056k = StatCommonHelper.getExternalStorageInfo(this.f5061p);
        this.f5059n = this.f5061p.getPackageName();
        this.f5063r = StatCommonHelper.getCpuInfo(this.f5061p).toString();
        this.f5064s = StatCommonHelper.getSystemMemory(this.f5061p);
        this.f5065t = StatCommonHelper.getRomMemory();
        this.f5060o = StatCommonHelper.getLauncherPackageName(this.f5061p);
        this.f5066u = StatCommonHelper.getCurAppSHA1Signature(this.f5061p);
        this.f5058m = StatCommonHelper.getDeviceIMSI(this.f5061p);
    }

    /* synthetic */ C1719c(Context context, C1718b c1718b) {
        this(context);
    }

    /* renamed from: a */
    void mo7915a(JSONObject jSONObject, Thread thread) {
        if (thread == null) {
            if (this.f5048c != null) {
                jSONObject.put("sr", this.f5048c.widthPixels + "*" + this.f5048c.heightPixels);
                jSONObject.put("dpi", this.f5048c.xdpi + "*" + this.f5048c.ydpi);
            }
            if (NetworkManager.getInstance(this.f5061p).isWifi()) {
                JSONObject jSONObject2 = new JSONObject();
                Util.jsonPut(jSONObject2, "bs", Util.getWiFiBBSID(this.f5061p));
                Util.jsonPut(jSONObject2, "ss", Util.getWiFiSSID(this.f5061p));
                if (jSONObject2.length() > 0) {
                    Util.jsonPut(jSONObject, "wf", jSONObject2.toString());
                }
            }
            JSONArray wifiTopN = Util.getWifiTopN(this.f5061p, 10);
            if (wifiTopN != null && wifiTopN.length() > 0) {
                Util.jsonPut(jSONObject, "wflist", wifiTopN.toString());
            }
            Util.jsonPut(jSONObject, "sen", this.f5062q);
        } else {
            Util.jsonPut(jSONObject, "thn", thread.getName());
            Util.jsonPut(jSONObject, "qq", StatConfig.getQQ(this.f5061p));
            Util.jsonPut(jSONObject, "cui", StatConfig.getCustomUserId(this.f5061p));
            if (StatCommonHelper.isStringValid(this.f5064s) && this.f5064s.split("/").length == 2) {
                Util.jsonPut(jSONObject, "fram", this.f5064s.split("/")[0]);
            }
            if (StatCommonHelper.isStringValid(this.f5065t) && this.f5065t.split("/").length == 2) {
                Util.jsonPut(jSONObject, "from", this.f5065t.split("/")[0]);
            }
            if (C1706ba.m4673a(this.f5061p).mo7875b(this.f5061p) != null) {
                jSONObject.put("ui", C1706ba.m4673a(this.f5061p).mo7875b(this.f5061p).getImei());
            }
            Util.jsonPut(jSONObject, "mid", StatConfig.getLocalMidOnly(this.f5061p));
        }
        Util.jsonPut(jSONObject, "pcn", StatCommonHelper.m4720a(this.f5061p));
        Util.jsonPut(jSONObject, "osn", VERSION.RELEASE);
        Util.jsonPut(jSONObject, "av", this.f5046a);
        Util.jsonPut(jSONObject, "ch", this.f5053h);
        Util.jsonPut(jSONObject, "mf", this.f5051f);
        Util.jsonPut(jSONObject, "sv", this.f5047b);
        Util.jsonPut(jSONObject, "osd", Build.DISPLAY);
        Util.jsonPut(jSONObject, "prod", Build.PRODUCT);
        Util.jsonPut(jSONObject, "tags", Build.TAGS);
        Util.jsonPut(jSONObject, "id", Build.ID);
        Util.jsonPut(jSONObject, "fng", Build.FINGERPRINT);
        Util.jsonPut(jSONObject, "lch", this.f5060o);
        Util.jsonPut(jSONObject, "ov", Integer.toString(this.f5049d));
        jSONObject.put(IXAdRequestInfo.f648OS, 1);
        Util.jsonPut(jSONObject, "op", this.f5054i);
        Util.jsonPut(jSONObject, "lg", this.f5052g);
        Util.jsonPut(jSONObject, IXAdRequestInfo.TEST_MODE, this.f5050e);
        Util.jsonPut(jSONObject, "tz", this.f5055j);
        if (this.f5057l != 0) {
            jSONObject.put("jb", this.f5057l);
        }
        Util.jsonPut(jSONObject, "sd", this.f5056k);
        Util.jsonPut(jSONObject, "apn", this.f5059n);
        Util.jsonPut(jSONObject, "cpu", this.f5063r);
        Util.jsonPut(jSONObject, "abi", Build.CPU_ABI);
        Util.jsonPut(jSONObject, "abi2", Build.CPU_ABI2);
        Util.jsonPut(jSONObject, "ram", this.f5064s);
        Util.jsonPut(jSONObject, "rom", this.f5065t);
        Util.jsonPut(jSONObject, IXAdRequestInfo.IMSI, this.f5058m);
        Util.jsonPut(jSONObject, "asg", this.f5066u);
    }
}
