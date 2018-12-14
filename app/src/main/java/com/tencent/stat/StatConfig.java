package com.tencent.stat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.p070qq.p071e.comm.constants.ErrorCode.AdError;
import com.tencent.mid.api.MidService;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import com.tencent.stat.common.Util;
import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class StatConfig {
    /* renamed from: A */
    private static int f4798A = 10;
    /* renamed from: B */
    private static int f4799B = 100;
    /* renamed from: C */
    private static int f4800C = 30;
    /* renamed from: D */
    private static int f4801D = 1;
    /* renamed from: E */
    private static String f4802E = null;
    /* renamed from: F */
    private static String f4803F;
    /* renamed from: G */
    private static String f4804G;
    /* renamed from: H */
    private static String f4805H = "mta_channel";
    /* renamed from: I */
    private static int f4806I = 180;
    /* renamed from: J */
    private static String f4807J;
    /* renamed from: K */
    private static int f4808K = 1024;
    /* renamed from: L */
    private static long f4809L = 0;
    /* renamed from: M */
    private static long f4810M = 300000;
    /* renamed from: N */
    private static volatile String f4811N = StatConstants.MTA_REPORT_FULL_URL;
    /* renamed from: O */
    private static int f4812O = 0;
    /* renamed from: P */
    private static volatile int f4813P = 0;
    /* renamed from: Q */
    private static int f4814Q = 20;
    /* renamed from: R */
    private static int f4815R = 0;
    /* renamed from: S */
    private static boolean f4816S = false;
    /* renamed from: T */
    private static int f4817T = 4096;
    /* renamed from: U */
    private static boolean f4818U = false;
    /* renamed from: V */
    private static String f4819V = null;
    /* renamed from: W */
    private static boolean f4820W = false;
    /* renamed from: X */
    private static StatCustomLogger f4821X = null;
    /* renamed from: Y */
    private static StatExceptionCallBack f4822Y = null;
    /* renamed from: Z */
    private static String f4823Z = null;
    /* renamed from: a */
    static C1747f f4824a = new C1747f(2);
    /* renamed from: aa */
    private static JSONObject f4825aa = null;
    /* renamed from: ab */
    private static HashSet<String> f4826ab = new HashSet();
    /* renamed from: ac */
    private static long f4827ac = 800;
    /* renamed from: ad */
    private static StatActionListener f4828ad = null;
    /* renamed from: b */
    static C1747f f4829b = new C1747f(1);
    /* renamed from: c */
    static String f4830c = "__HIBERNATE__";
    /* renamed from: d */
    static String f4831d = "__HIBERNATE__TIME";
    /* renamed from: e */
    static String f4832e = "__MTA_KILL__";
    /* renamed from: f */
    static String f4833f = "";
    /* renamed from: g */
    static boolean f4834g = false;
    /* renamed from: h */
    static int f4835h = AdError.PLACEMENT_ERROR;
    /* renamed from: i */
    static long f4836i = 10000;
    public static boolean isAutoExceptionCaught = true;
    /* renamed from: j */
    static boolean f4837j = true;
    /* renamed from: k */
    static volatile String f4838k = StatConstants.MTA_SERVER;
    /* renamed from: l */
    static boolean f4839l = true;
    /* renamed from: m */
    static int f4840m = 0;
    /* renamed from: n */
    static long f4841n = 10000;
    /* renamed from: o */
    static int f4842o = 512;
    /* renamed from: p */
    static StatDataTransfer f4843p = null;
    /* renamed from: q */
    static boolean f4844q = false;
    /* renamed from: r */
    private static StatLogger f4845r = StatCommonHelper.getLogger();
    /* renamed from: s */
    private static StatReportStrategy f4846s = StatReportStrategy.APP_LAUNCH;
    /* renamed from: t */
    private static boolean f4847t = false;
    /* renamed from: u */
    private static boolean f4848u = true;
    /* renamed from: v */
    private static int f4849v = 30000;
    /* renamed from: w */
    private static HashSet<String> f4850w = null;
    /* renamed from: x */
    private static HashSet<String> f4851x = new HashSet();
    /* renamed from: y */
    private static int f4852y = 100000;
    /* renamed from: z */
    private static int f4853z = 30;

    /* renamed from: a */
    static String m4593a(Context context) {
        return Util.decode(StatPreferences.getString(context, "_mta_ky_tag_", null));
    }

    /* renamed from: a */
    static void m4594a() {
        if (f4829b != null) {
            m4608b(f4829b.f5130b.optString("__INSTANT_EI_LIST__", null));
            updateDontReportEventIdsSet(f4829b.f5130b.optString("__DONT_REPORT_EI_LIST__", null));
        }
    }

    /* renamed from: a */
    static synchronized void m4595a(int i) {
        synchronized (StatConfig.class) {
            f4813P = i;
        }
    }

    /* renamed from: a */
    static void m4596a(long j) {
        StatPreferences.putLong(C1748g.m4803a(), f4830c, j);
        setEnableStatService(false);
        f4845r.warn("MTA is disable for current SDK version");
    }

    /* renamed from: a */
    static void m4597a(Context context, C1747f c1747f) {
        if (c1747f.f5129a == f4829b.f5129a) {
            f4829b = c1747f;
            m4601a(c1747f.f5130b);
            m4594a();
        } else if (c1747f.f5129a == f4824a.f5129a) {
            f4824a = c1747f;
        }
    }

    /* renamed from: a */
    static void m4598a(Context context, C1747f c1747f, JSONObject jSONObject) {
        Object obj = null;
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase(IXAdRequestInfo.f650V)) {
                    int i = jSONObject.getInt(str);
                    Object obj2 = c1747f.f5132d != i ? 1 : obj;
                    c1747f.f5132d = i;
                    obj = obj2;
                } else if (str.equalsIgnoreCase("c")) {
                    str = jSONObject.getString("c");
                    if (str.length() > 0) {
                        c1747f.f5130b = new JSONObject(str);
                    }
                } else if (str.equalsIgnoreCase("m")) {
                    c1747f.f5131c = jSONObject.getString("m");
                }
            }
            if (obj == 1) {
                C1706ba a = C1706ba.m4673a(C1748g.m4803a());
                if (a != null) {
                    a.mo7872a(c1747f);
                }
                if (c1747f.f5129a == f4829b.f5129a) {
                    m4601a(c1747f.f5130b);
                    m4609b(c1747f.f5130b);
                }
            }
            m4597a(context, c1747f);
        } catch (Throwable e) {
            f4845r.mo7900e(e);
        } catch (Throwable e2) {
            f4845r.mo7900e(e2);
        }
    }

    /* renamed from: a */
    static void m4599a(Context context, String str) {
        if (str != null) {
            StatPreferences.putString(context, "_mta_ky_tag_", Util.encode(str));
        }
    }

    /* renamed from: a */
    static void m4600a(Context context, JSONObject jSONObject) {
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase(Integer.toString(f4829b.f5129a))) {
                    m4598a(context, f4829b, jSONObject.getJSONObject(str));
                    m4594a();
                } else if (str.equalsIgnoreCase(Integer.toString(f4824a.f5129a))) {
                    m4598a(context, f4824a, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase("rs")) {
                    StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt(str));
                    if (statReportStrategy != null) {
                        f4846s = statReportStrategy;
                        if (isDebugEnable()) {
                            f4845r.mo7897d("Change to ReportStrategy:" + statReportStrategy.name());
                        }
                    }
                } else {
                    return;
                }
            }
        } catch (Throwable e) {
            f4845r.mo7900e(e);
        }
    }

    /* renamed from: a */
    static void m4601a(JSONObject jSONObject) {
        try {
            int i = jSONObject.getInt("rs");
            f4845r.mo7904i("updateReportStrategy:" + jSONObject + ",sendStrategy:" + i);
            StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(i);
            if (statReportStrategy != null) {
                setStatSendStrategy(statReportStrategy);
            }
        } catch (JSONException e) {
            if (isDebugEnable()) {
                f4845r.mo7904i("rs not found.");
            }
        }
    }

    /* renamed from: a */
    static boolean m4602a(int i, int i2, int i3) {
        return i >= i2 && i <= i3;
    }

    /* renamed from: a */
    static boolean m4603a(String str) {
        return (f4850w == null || f4850w.size() == 0 || !StatCommonHelper.isStringValid(str)) ? false : f4850w.contains(str.toLowerCase());
    }

    /* renamed from: a */
    static boolean m4604a(JSONObject jSONObject, String str, String str2) {
        if (!jSONObject.isNull(str)) {
            String optString = jSONObject.optString(str);
            if (StatCommonHelper.isStringValid(str2) && StatCommonHelper.isStringValid(optString) && str2.equalsIgnoreCase(optString)) {
                return true;
            }
        }
        return false;
    }

    public static void addSkipSessionReportAppkey(String str) {
        if (StatCommonHelper.isStringValid(str)) {
            f4826ab.add(str);
        }
    }

    /* renamed from: b */
    static int m4605b() {
        return f4853z;
    }

    /* renamed from: b */
    static void m4606b(int i) {
        if (i >= 0) {
            f4815R = i;
        }
    }

    /* renamed from: b */
    static void m4607b(Context context, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(f4832e);
            if (StatCommonHelper.isStringValid(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                if (jSONObject2.length() != 0) {
                    Object obj;
                    if (!jSONObject2.isNull("sm")) {
                        obj = jSONObject2.get("sm");
                        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : obj instanceof String ? Integer.valueOf((String) obj).intValue() : 0;
                        if (intValue > 0) {
                            if (isDebugEnable()) {
                                f4845r.mo7904i("match sleepTime:" + intValue + " minutes");
                            }
                            StatPreferences.putLong(context, f4831d, System.currentTimeMillis() + ((long) ((intValue * 60) * 1000)));
                            setEnableStatService(false);
                            f4845r.warn("MTA is disable for current SDK version");
                        }
                    }
                    if (m4604a(jSONObject2, "sv", StatConstants.VERSION)) {
                        f4845r.mo7904i("match sdk version:2.1.0");
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (m4604a(jSONObject2, IXAdRequestInfo.TEST_MODE, Build.MODEL)) {
                        f4845r.mo7904i("match MODEL:" + Build.MODEL);
                        obj = 1;
                    }
                    if (m4604a(jSONObject2, "av", StatCommonHelper.getCurAppVersion(context))) {
                        f4845r.mo7904i("match app version:" + StatCommonHelper.getCurAppVersion(context));
                        obj = 1;
                    }
                    if (m4604a(jSONObject2, "mf", Build.MANUFACTURER)) {
                        f4845r.mo7904i("match MANUFACTURER:" + Build.MANUFACTURER);
                        obj = 1;
                    }
                    if (m4604a(jSONObject2, IXAdRequestInfo.OSV, VERSION.SDK_INT)) {
                        f4845r.mo7904i("match android SDK version:" + VERSION.SDK_INT);
                        obj = 1;
                    }
                    if (m4604a(jSONObject2, "ov", VERSION.SDK_INT)) {
                        f4845r.mo7904i("match android SDK version:" + VERSION.SDK_INT);
                        obj = 1;
                    }
                    if (m4604a(jSONObject2, "ui", C1706ba.m4673a(context).mo7875b(context).getImei())) {
                        f4845r.mo7904i("match imei:" + C1706ba.m4673a(context).mo7875b(context).getImei());
                        obj = 1;
                    }
                    if (m4604a(jSONObject2, "mid", getLocalMidOnly(context))) {
                        f4845r.mo7904i("match mid:" + getLocalMidOnly(context));
                        obj = 1;
                    }
                    if (obj != null) {
                        m4596a(StatCommonHelper.getSDKLongVersion(StatConstants.VERSION));
                    }
                }
            }
        } catch (Throwable e) {
            f4845r.mo7900e(e);
        }
    }

    /* renamed from: b */
    static void m4608b(String str) {
        if (StatCommonHelper.isStringValid(str)) {
            String[] split = str.toLowerCase().split(";");
            if (split.length > 0) {
                if (f4850w == null) {
                    f4850w = new HashSet(split.length);
                }
                f4850w.addAll(Arrays.asList(split));
            }
        }
    }

    /* renamed from: b */
    static void m4609b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                m4607b(C1748g.m4803a(), jSONObject);
                String string = jSONObject.getString(f4830c);
                if (isDebugEnable()) {
                    f4845r.mo7897d("hibernateVer:" + string + ", current version:2.1.0");
                }
                long sDKLongVersion = StatCommonHelper.getSDKLongVersion(string);
                if (StatCommonHelper.getSDKLongVersion(StatConstants.VERSION) <= sDKLongVersion) {
                    m4596a(sDKLongVersion);
                }
            } catch (JSONException e) {
                f4845r.mo7897d("__HIBERNATE__ not found.");
            }
        }
    }

    /* renamed from: c */
    static void m4610c() {
        f4815R++;
    }

    /* renamed from: c */
    private static boolean m4611c(String str) {
        if (str == null) {
            return false;
        }
        if (f4803F == null) {
            f4803F = str;
            return true;
        } else if (f4803F.contains(str)) {
            return false;
        } else {
            f4803F += "|" + str;
            return true;
        }
    }

    /* renamed from: d */
    static int m4612d() {
        return f4815R;
    }

    /* renamed from: e */
    protected static StatExceptionCallBack m4613e() {
        return f4822Y;
    }

    public static void enableCommitEventAtBackground(Context context, boolean z) {
        if (z) {
            if (f4828ad == null) {
                StatActionListener c1734e = new C1734e(context);
                f4828ad = c1734e;
                StatService.addActionListener(c1734e);
            }
        } else if (f4828ad != null) {
            StatService.removeActionListener(f4828ad);
            f4828ad = null;
        }
    }

    public static synchronized String getAppKey(Context context) {
        String str;
        synchronized (StatConfig.class) {
            if (f4803F != null) {
                str = f4803F;
            } else {
                if (context != null) {
                    if (f4803F == null) {
                        f4803F = StatCommonHelper.getAppKey(context);
                    }
                }
                if (f4803F == null || f4803F.trim().length() == 0) {
                    f4845r.mo7899e((Object) "AppKey can not be null or empty, please read Developer's Guide first!");
                }
                str = f4803F;
            }
        }
        return str;
    }

    public static String getAppVersion() {
        return f4823Z;
    }

    public static long getBackgroundDelayTimestamp() {
        return f4827ac;
    }

    public static int getCurSessionStatReportCount() {
        return f4813P;
    }

    public static JSONObject getCustomGlobalReportContent() {
        return f4825aa;
    }

    public static StatCustomLogger getCustomLogger() {
        return f4821X;
    }

    public static String getCustomProperty(String str) {
        try {
            return f4824a.f5130b.getString(str);
        } catch (Throwable th) {
            f4845r.mo7900e(th);
            return null;
        }
    }

    public static String getCustomProperty(String str, String str2) {
        try {
            String string = f4824a.f5130b.getString(str);
            return string != null ? string : str2;
        } catch (Throwable th) {
            f4845r.mo7900e(th);
            return str2;
        }
    }

    public static String getCustomUserId(Context context) {
        if (context == null) {
            f4845r.error((Object) "Context for getCustomUid is null.");
            return null;
        }
        if (f4819V == null) {
            try {
                f4819V = StatPreferences.getString(context, "MTA_CUSTOM_UID", "");
            } catch (Throwable e) {
                f4845r.mo7900e(e);
            }
        }
        return f4819V;
    }

    public static StatDataTransfer getDataTransfer() {
        return f4843p;
    }

    public static long getFlushDBSpaceMS() {
        return f4841n;
    }

    public static synchronized String getInstallChannel(Context context) {
        String str;
        synchronized (StatConfig.class) {
            if (f4804G != null) {
                str = f4804G;
            } else {
                str = StatPreferences.getString(context, f4805H, "");
                f4804G = str;
                if (str == null || f4804G.trim().length() == 0) {
                    f4804G = StatCommonHelper.getInstallChannel(context);
                }
                if (f4804G == null || f4804G.trim().length() == 0) {
                    f4845r.mo7912w("installChannel can not be null or empty, please read Developer's Guide first!");
                }
                str = f4804G;
            }
        }
        return str;
    }

    public static String getLocalMidOnly(Context context) {
        return MidService.getLocalMidOnly(context);
    }

    public static String getMTAPreferencesFileName() {
        return f4807J;
    }

    public static int getMaxBatchReportCount() {
        return f4800C;
    }

    public static int getMaxDaySessionNumbers() {
        return f4814Q;
    }

    public static int getMaxImportantDataSendRetryCount() {
        return f4799B;
    }

    public static int getMaxParallelTimmingEvents() {
        return f4808K;
    }

    public static int getMaxReportEventLength() {
        return f4817T;
    }

    public static int getMaxSendRetryCount() {
        return f4798A;
    }

    public static int getMaxSessionStatReportCount() {
        return f4812O;
    }

    public static int getMaxStoreEventCount() {
        return f4852y;
    }

    public static String getMid(Context context) {
        return MidService.getMid(context);
    }

    public static long getMsPeriodForMethodsCalledLimitClear() {
        return f4836i;
    }

    public static int getNumEventsCachedInMemory() {
        return f4840m;
    }

    public static int getNumEventsCommitPerSec() {
        return f4801D;
    }

    public static int getNumOfMethodsCalledLimit() {
        return f4835h;
    }

    public static String getQQ(Context context) {
        return StatPreferences.getString(context, "mta.acc.qq", f4833f);
    }

    public static int getReportCompressedSize() {
        return f4842o;
    }

    public static String getSDKProperty(String str) {
        try {
            return f4829b.f5130b.getString(str);
        } catch (Throwable th) {
            f4845r.mo7912w(th);
            return null;
        }
    }

    public static String getSDKProperty(String str, String str2) {
        try {
            String string = f4829b.f5130b.getString(str);
            return string != null ? string : str2;
        } catch (Throwable th) {
            f4845r.mo7897d("can't find SDK Properties key:" + str);
            return str2;
        }
    }

    public static int getSendPeriodMinutes() {
        return f4806I;
    }

    public static int getSessionTimoutMillis() {
        return f4849v;
    }

    public static String getStatReportHost() {
        return f4838k;
    }

    public static String getStatReportUrl() {
        return f4811N;
    }

    public static StatReportStrategy getStatSendStrategy() {
        return f4846s;
    }

    public static void init(Context context) {
        f4824a.mo7943b(context);
        f4829b.mo7943b(context);
        m4594a();
    }

    public static void initNativeCrashReport(Context context, String str) {
        if (!isEnableStatService()) {
            return;
        }
        if (context == null) {
            f4845r.error((Object) "The Context of StatConfig.initNativeCrashReport() can not be null!");
        } else {
            StatNativeCrashReport.initNativeCrash(context, str);
        }
    }

    public static boolean isAntoActivityLifecycleStat() {
        return f4844q;
    }

    public static boolean isAutoExceptionCaught() {
        return isAutoExceptionCaught;
    }

    public static boolean isDebugEnable() {
        return f4847t;
    }

    public static boolean isEnableConcurrentProcess() {
        return f4818U;
    }

    public static boolean isEnableSmartReporting() {
        return f4837j;
    }

    public static boolean isEnableStatService() {
        return f4848u;
    }

    public static boolean isEventIdInDontReportEventIdsSet(String str) {
        return (f4851x == null || f4851x.size() == 0 || !StatCommonHelper.isStringValid(str)) ? false : f4851x.contains(str.toLowerCase());
    }

    public static boolean isReportEventsByOrder() {
        return f4839l;
    }

    public static boolean isXGProMode() {
        return f4820W;
    }

    public static void removeSkipSessionReportAppkey(String str) {
        f4826ab.remove(str);
    }

    public static void setAntoActivityLifecycleStat(boolean z) {
        f4844q = z;
    }

    public static void setAppKey(Context context, String str) {
        if (context == null) {
            f4845r.error((Object) "ctx in StatConfig.setAppKey() is null");
        } else if (str == null || str.length() > 256) {
            f4845r.error((Object) "appkey in StatConfig.setAppKey() is null or exceed 256 bytes");
        } else {
            if (f4803F == null) {
                f4803F = m4593a(context);
            }
            if ((m4611c(str) | m4611c(StatCommonHelper.getAppKey(context))) != 0) {
                m4599a(context, f4803F);
            }
        }
    }

    public static void setAppKey(String str) {
        if (str == null) {
            f4845r.error((Object) "appkey in StatConfig.setAppKey() is null");
        } else if (str.length() > 256) {
            f4845r.error((Object) "The length of appkey cann't exceed 256 bytes.");
        } else {
            f4803F = str;
        }
    }

    public static void setAppVersion(String str) {
        f4823Z = str;
    }

    public static void setAutoExceptionCaught(boolean z) {
        isAutoExceptionCaught = z;
    }

    public static void setBackgroundDelayTimestamp(long j) {
        if (j <= 0 || j >= 10000) {
            new StringBuilder("setBackgroundDelayTimestamp falied, timestamp:").append(j).append(" is invalid.");
        } else {
            f4827ac = j;
        }
    }

    public static void setCustomGlobalReportContent(JSONObject jSONObject) {
        f4825aa = jSONObject;
    }

    public static void setCustomLogger(StatCustomLogger statCustomLogger) {
        f4821X = statCustomLogger;
    }

    public static void setCustomUserId(Context context, String str) {
        if (context == null) {
            f4845r.error((Object) "Context for setCustomUid is null.");
            return;
        }
        StatPreferences.putString(context, "MTA_CUSTOM_UID", str);
        f4819V = str;
    }

    public static void setDataTransfer(StatDataTransfer statDataTransfer) {
        f4843p = statDataTransfer;
    }

    public static void setDebugEnable(boolean z) {
        f4847t = z;
        StatCommonHelper.getLogger().setDebugEnable(z);
    }

    public static void setEnableConcurrentProcess(boolean z) {
        f4818U = z;
    }

    public static void setEnableSmartReporting(boolean z) {
        f4837j = z;
    }

    public static void setEnableStatService(boolean z) {
        f4848u = z;
        if (!z) {
            f4845r.warn("!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    public static void setFlushDBSpaceMS(long j) {
        if (j > 0) {
            f4841n = j;
        }
    }

    public static void setInstallChannel(Context context, String str) {
        if (str.length() > 128) {
            f4845r.error((Object) "the length of installChannel can not exceed the range of 128 bytes.");
            return;
        }
        f4804G = str;
        StatPreferences.putString(context, f4805H, str);
    }

    public static void setInstallChannel(String str) {
        if (str.length() > 128) {
            f4845r.error((Object) "the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            f4804G = str;
        }
    }

    public static void setMTAPreferencesFileName(String str) {
        f4807J = str;
    }

    public static void setMaxBatchReportCount(int i) {
        if (m4602a(i, 2, 1000)) {
            f4800C = i;
        } else {
            f4845r.error((Object) "setMaxBatchReportCount can not exceed the range of [2,1000].");
        }
    }

    public static void setMaxDaySessionNumbers(int i) {
        if (i <= 0) {
            f4845r.mo7899e((Object) "maxDaySessionNumbers must be greater than 0.");
        } else {
            f4814Q = i;
        }
    }

    public static void setMaxImportantDataSendRetryCount(int i) {
        if (i > 100) {
            f4799B = i;
        }
    }

    public static void setMaxParallelTimmingEvents(int i) {
        if (m4602a(i, 1, 4096)) {
            f4808K = i;
        } else {
            f4845r.error((Object) "setMaxParallelTimmingEvents can not exceed the range of [1, 4096].");
        }
    }

    public static void setMaxReportEventLength(int i) {
        if (i <= 0) {
            f4845r.error((Object) "maxReportEventLength on setMaxReportEventLength() must greater than 0.");
        } else {
            f4817T = i;
        }
    }

    public static void setMaxSendRetryCount(int i) {
        if (m4602a(i, 1, 1000)) {
            f4798A = i;
        } else {
            f4845r.error((Object) "setMaxSendRetryCount can not exceed the range of [1,1000].");
        }
    }

    public static void setMaxSessionStatReportCount(int i) {
        if (i < 0) {
            f4845r.error((Object) "maxSessionStatReportCount cannot be less than 0.");
        } else {
            f4812O = i;
        }
    }

    public static void setMaxStoreEventCount(int i) {
        if (m4602a(i, 0, 500000)) {
            f4852y = i;
        } else {
            f4845r.error((Object) "setMaxStoreEventCount can not exceed the range of [0, 500000].");
        }
    }

    public static void setNativeCrashDebugEnable(boolean z) {
        StatNativeCrashReport.setNativeCrashDebugEnable(z);
    }

    public static void setNumEventsCachedInMemory(int i) {
        if (i >= 0) {
            f4840m = i;
        }
    }

    public static void setNumEventsCommitPerSec(int i) {
        if (i > 0) {
            f4801D = i;
        }
    }

    public static void setNumOfMethodsCalledLimit(int i, long j) {
        f4835h = i;
        if (j >= 1000) {
            f4836i = j;
        }
    }

    public static void setQQ(Context context, String str) {
        StatPreferences.putString(context, "mta.acc.qq", str);
        f4833f = str;
    }

    public static void setReportCompressedSize(int i) {
        if (i > 0) {
            f4842o = i;
        }
    }

    public static void setReportEventsByOrder(boolean z) {
        f4839l = z;
    }

    public static void setSendPeriodMinutes(int i) {
        if (m4602a(i, 1, 10080)) {
            f4806I = i;
        } else {
            f4845r.error((Object) "setSendPeriodMinutes can not exceed the range of [1, 7*24*60] minutes.");
        }
    }

    public static void setSessionTimoutMillis(int i) {
        if (m4602a(i, 1000, 86400000)) {
            f4849v = i;
        } else {
            f4845r.error((Object) "setSessionTimoutMillis can not exceed the range of [1000, 24 * 60 * 60 * 1000].");
        }
    }

    public static void setStatExCallBack(StatExceptionCallBack statExceptionCallBack) {
        f4822Y = statExceptionCallBack;
    }

    public static void setStatReportUrl(String str) {
        if (str == null || str.length() == 0) {
            f4845r.error((Object) "statReportUrl cannot be null or empty.");
            return;
        }
        f4811N = str;
        try {
            f4838k = new URI(f4811N).getHost();
        } catch (Exception e) {
            f4845r.mo7912w(e);
        }
        if (isDebugEnable()) {
            f4845r.mo7904i("url:" + f4811N + ", domain:" + f4838k);
        }
    }

    public static void setStatSendStrategy(StatReportStrategy statReportStrategy) {
        f4846s = statReportStrategy;
        if (statReportStrategy != StatReportStrategy.PERIOD) {
            StatServiceImpl.f4870c = 0;
        }
        if (isDebugEnable()) {
            f4845r.mo7897d("Change to statSendStrategy: " + statReportStrategy);
        }
    }

    public static void setXGProMode(boolean z) {
        f4820W = z;
    }

    public static boolean shouldSkipSessionReport(String str) {
        return f4826ab.contains(str);
    }

    public static void updateDontReportEventIdsSet(String str) {
        if (StatCommonHelper.isStringValid(str)) {
            String[] split = str.toLowerCase().split(";");
            if (split.length > 0) {
                if (f4851x == null) {
                    f4851x = new HashSet(split.length);
                }
                f4851x.addAll(Arrays.asList(split));
            }
        }
    }
}
