package com.tencent.stat;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.tencent.stat.common.C1717a;
import com.tencent.stat.common.C1721e;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import com.tencent.stat.event.C1735f;
import com.tencent.stat.event.C1736a;
import com.tencent.stat.event.C1740d;
import com.tencent.stat.event.C1744i;
import com.tencent.stat.event.C1746l;
import com.tencent.stat.lifecycle.MtaActivityLifeCycle;
import com.tencent.stat.lifecycle.MtaActivityLifecycleCallback;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public class StatServiceImpl {
    /* renamed from: A */
    private static volatile long f4866A = -1;
    /* renamed from: B */
    private static StatSpecifyReportedInfo f4867B = null;
    /* renamed from: a */
    static volatile int f4868a = 0;
    /* renamed from: b */
    static volatile long f4869b = 0;
    /* renamed from: c */
    static volatile long f4870c = 0;
    /* renamed from: d */
    private static C1721e f4871d;
    /* renamed from: e */
    private static volatile Map<C1740d, Long> f4872e = new ConcurrentHashMap();
    /* renamed from: f */
    private static volatile Map<String, Properties> f4873f = new ConcurrentHashMap();
    /* renamed from: g */
    private static volatile Map<Integer, Integer> f4874g = new ConcurrentHashMap(10);
    /* renamed from: h */
    private static volatile long f4875h = 0;
    /* renamed from: i */
    private static volatile long f4876i = 0;
    /* renamed from: j */
    private static volatile long f4877j = 0;
    /* renamed from: k */
    private static String f4878k = "";
    /* renamed from: l */
    private static volatile int f4879l = 0;
    /* renamed from: m */
    private static volatile String f4880m = "";
    /* renamed from: n */
    private static volatile String f4881n = "";
    /* renamed from: o */
    private static Map<String, Long> f4882o = new ConcurrentHashMap();
    /* renamed from: p */
    private static Map<String, Long> f4883p = new ConcurrentHashMap();
    /* renamed from: q */
    private static StatLogger f4884q = StatCommonHelper.getLogger();
    /* renamed from: r */
    private static UncaughtExceptionHandler f4885r = null;
    /* renamed from: s */
    private static volatile boolean f4886s = true;
    /* renamed from: t */
    private static Context f4887t = null;
    /* renamed from: u */
    private static volatile boolean f4888u = false;
    /* renamed from: v */
    private static volatile boolean f4889v = false;
    /* renamed from: w */
    private static volatile boolean f4890w = true;
    /* renamed from: x */
    private static Handler f4891x = new Handler();
    /* renamed from: y */
    private static List<StatActionListener> f4892y = new CopyOnWriteArrayList();
    /* renamed from: z */
    private static volatile Runnable f4893z = null;

    /* renamed from: a */
    static int m4619a(Context context, boolean z, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        int i;
        int i2 = 1;
        long currentTimeMillis = System.currentTimeMillis();
        if (!z || currentTimeMillis - f4876i < ((long) StatConfig.getSessionTimoutMillis())) {
            boolean i3 = false;
        } else {
            i3 = 1;
        }
        f4876i = currentTimeMillis;
        if (f4877j == 0) {
            f4877j = StatCommonHelper.getTomorrowStartMilliseconds();
        }
        if (currentTimeMillis >= f4877j) {
            f4877j = StatCommonHelper.getTomorrowStartMilliseconds();
            if (C1706ba.m4673a(context).mo7875b(context).getUserType() != 1) {
                C1706ba.m4673a(context).mo7875b(context).setUserType(1);
            }
            StatConfig.m4606b(0);
            f4868a = 0;
            f4878k = StatCommonHelper.getDateString(0);
            i3 = 1;
        }
        Object obj = f4878k;
        if (StatCommonHelper.isSpecifyReportedValid(statSpecifyReportedInfo)) {
            obj = statSpecifyReportedInfo.getAppKey() + f4878k;
        }
        if (f4883p.containsKey(obj)) {
            i2 = i3;
        }
        if (i2 != 0) {
            if (StatCommonHelper.isSpecifyReportedValid(statSpecifyReportedInfo)) {
                m4626a(context, statSpecifyReportedInfo);
            } else if (StatConfig.m4612d() < StatConfig.getMaxDaySessionNumbers()) {
                StatCommonHelper.checkFirstTimeActivate(context);
                m4626a(context, null);
            } else {
                f4884q.mo7899e((Object) "Exceed StatConfig.getMaxDaySessionNumbers().");
            }
            f4883p.put(obj, Long.valueOf(1));
        }
        if (f4886s && !StatCommonHelper.isSpecifyReportedValid(statSpecifyReportedInfo)) {
            testSpeed(context);
            m4645d(context);
            f4886s = false;
        }
        return f4879l;
    }

    /* renamed from: a */
    static synchronized void m4623a(Context context) {
        synchronized (StatServiceImpl.class) {
            if (context != null) {
                if (f4871d == null && m4639b(context)) {
                    Context applicationContext = context.getApplicationContext();
                    f4887t = applicationContext;
                    f4871d = new C1721e();
                    f4878k = StatCommonHelper.getDateString(0);
                    f4875h = System.currentTimeMillis() + StatConfig.f4836i;
                    f4871d.mo7916a(new C1755m(applicationContext));
                }
            }
        }
    }

    /* renamed from: a */
    private static void m4624a(Context context, long j, StatSpecifyReportedInfo statSpecifyReportedInfo, boolean z) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.trackBackground() can not be null!");
            } else if (m4641c(context2) != null) {
                f4871d.mo7916a(new C1691am(j, context2, statSpecifyReportedInfo, z));
            }
        }
    }

    /* renamed from: a */
    static void m4626a(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (m4641c(context) != null) {
            if (StatConfig.isDebugEnable()) {
                f4884q.mo7897d("start new session.");
            }
            if (statSpecifyReportedInfo == null || f4879l == 0) {
                f4879l = StatCommonHelper.getNextSessionID();
            }
            StatConfig.m4595a(0);
            StatConfig.m4610c();
            C1735f c1746l = new C1746l(context, f4879l, m4635b(), statSpecifyReportedInfo);
            String c = c1746l.mo7927c();
            if (StatCommonHelper.isStringValid(c) && StatConfig.shouldSkipSessionReport(c)) {
                f4884q.mo7912w("appkey :" + c + " skip session report.");
            } else {
                new C1700av(c1746l).mo7867a();
            }
        }
    }

    /* renamed from: a */
    static void m4629a(Context context, Throwable th) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.reportSdkSelfException() can not be null!");
            } else if (m4641c(context2) != null) {
                f4871d.mo7916a(new C1761s(context2, th));
            }
        }
    }

    /* renamed from: a */
    static boolean m4630a() {
        if (f4868a < 2) {
            return false;
        }
        f4869b = System.currentTimeMillis();
        return true;
    }

    /* renamed from: a */
    static boolean m4631a(String str) {
        return str == null || str.length() == 0;
    }

    public static void addActionListener(StatActionListener statActionListener) {
        f4892y.add(statActionListener);
    }

    /* renamed from: b */
    static JSONObject m4635b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (StatConfig.f4829b.f5132d != 0) {
                jSONObject2.put(IXAdRequestInfo.f650V, StatConfig.f4829b.f5132d);
            }
            jSONObject.put(Integer.toString(StatConfig.f4829b.f5129a), jSONObject2);
            jSONObject2 = new JSONObject();
            if (StatConfig.f4824a.f5132d != 0) {
                jSONObject2.put(IXAdRequestInfo.f650V, StatConfig.f4824a.f5132d);
            }
            jSONObject.put(Integer.toString(StatConfig.f4824a.f5129a), jSONObject2);
        } catch (Throwable e) {
            f4884q.mo7900e(e);
        }
        return jSONObject;
    }

    /* renamed from: b */
    private static void m4636b(Context context, StatAccount statAccount, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        try {
            new C1700av(new C1736a(context, m4619a(context, false, statSpecifyReportedInfo), statAccount, statSpecifyReportedInfo)).mo7867a();
        } catch (Throwable th) {
            f4884q.mo7900e(th);
            m4629a(context, th);
        }
    }

    /* renamed from: b */
    private static void m4637b(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, boolean z) {
        if (statSpecifyReportedInfo == null) {
            try {
                statSpecifyReportedInfo = f4867B;
            } catch (Throwable th) {
                f4884q.mo7900e(th);
            }
        }
        f4884q.mo7897d("trackBackground lastForegroundTs:" + f4866A);
        if (f4866A > 0) {
            m4624a(f4887t, (System.currentTimeMillis() - f4866A) / 1000, statSpecifyReportedInfo, z);
        }
        f4866A = -1;
    }

    /* renamed from: b */
    private static void m4638b(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        String str2 = new String(str);
        if (m4641c(context) != null) {
            f4871d.mo7916a(new C1687ai(context, str2, statSpecifyReportedInfo));
        }
    }

    /* renamed from: b */
    static boolean m4639b(Context context) {
        boolean z = false;
        long j = StatPreferences.getLong(context, StatConfig.f4830c, 0);
        long sDKLongVersion = StatCommonHelper.getSDKLongVersion(StatConstants.VERSION);
        boolean z2 = true;
        if (sDKLongVersion <= j) {
            f4884q.error("MTA is disable for current version:" + sDKLongVersion + ",wakeup version:" + j);
            z2 = false;
        }
        j = StatPreferences.getLong(context, StatConfig.f4831d, 0);
        if (j > System.currentTimeMillis()) {
            f4884q.error("MTA is disable for current time:" + System.currentTimeMillis() + ",wakeup time:" + j);
        } else {
            z = z2;
        }
        StatConfig.setEnableStatService(z);
        return z;
    }

    /* renamed from: c */
    static C1721e m4641c(Context context) {
        if (f4871d == null) {
            synchronized (StatServiceImpl.class) {
                if (f4871d == null) {
                    try {
                        m4623a(context);
                    } catch (Throwable th) {
                        f4884q.error(th);
                        StatConfig.setEnableStatService(false);
                    }
                }
            }
        }
        return f4871d;
    }

    /* renamed from: c */
    static void m4643c() {
        f4868a = 0;
        f4869b = 0;
    }

    public static void commitEvents(Context context, int i) {
        if (StatConfig.isEnableStatService()) {
            if (StatConfig.isDebugEnable()) {
                f4884q.mo7904i("commitEvents, maxNumber=" + i);
            }
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.commitEvents() can not be null!");
            } else if (i < -1 || i == 0) {
                f4884q.error((Object) "The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
            } else if (NetworkManager.getInstance(context2).isNetworkAvailable() && m4641c(context2) != null) {
                f4871d.mo7916a(new C1685ag(context2, i));
            }
        }
    }

    /* renamed from: d */
    static void m4644d() {
        f4868a++;
        f4869b = System.currentTimeMillis();
        flushDataToDB(f4887t);
    }

    /* renamed from: d */
    static void m4645d(Context context) {
        if (StatConfig.isEnableStatService() && m4641c(context) != null) {
            f4871d.mo7916a(new C1763u(context));
        }
    }

    /* renamed from: e */
    static void m4647e(Context context) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.sendNetworkDetector() can not be null!");
                return;
            }
            try {
                C1748g.m4809b(context2).mo7948a(new C1744i(context2), new C1765w());
            } catch (Throwable th) {
                f4884q.mo7900e(th);
            }
        }
    }

    /* renamed from: f */
    static void m4649f(Context context) {
        f4870c = System.currentTimeMillis() + ((long) (60000 * StatConfig.getSendPeriodMinutes()));
        StatPreferences.putLong(context, "last_period_ts", f4870c);
        commitEvents(context, -1);
    }

    public static void flushDataToDB(Context context) {
        if (StatConfig.isEnableStatService() && StatConfig.f4840m > 0) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.testSpeed() can not be null!");
            } else {
                C1706ba.m4673a(context2).mo7876c();
            }
        }
    }

    public static Properties getCommonKeyValueForKVEvent(String str) {
        return (Properties) f4873f.get(str);
    }

    public static Context getContext(Context context) {
        return context != null ? context : f4887t;
    }

    public static void getFeedBackMessage(Context context, int i, int i2, StatFBDispatchCallback statFBDispatchCallback) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.getFeedBackMessage() can not be null!");
                return;
            }
            try {
                C1748g.m4809b(context2).mo7952b(i, i2, statFBDispatchCallback);
            } catch (Throwable th) {
                f4884q.mo7900e(th);
            }
        }
    }

    public static void inerTrackBeginPage(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        String str2 = new String(str);
        if (m4641c(context) != null) {
            f4871d.mo7916a(new C1766x(str2, context, statSpecifyReportedInfo));
        }
    }

    public static boolean isBackground() {
        return f4889v;
    }

    public static boolean isForeground() {
        return f4889v;
    }

    public static void onLowMemory(Context context) {
        if (StatConfig.isEnableStatService() && m4641c(getContext(context)) != null) {
            f4871d.mo7916a(new C1759q(context));
        }
    }

    public static void onPause(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        trackEndPage(context, StatCommonHelper.getActivityName(context), statSpecifyReportedInfo);
    }

    public static void onResume(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        trackBeginPage(context, StatCommonHelper.getActivityName(context), statSpecifyReportedInfo);
    }

    public static void onStop(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (m4641c(context2) != null) {
                f4871d.mo7916a(new C1758p(context2));
            }
        }
    }

    public static void postFeedBackFiles(Context context, String str, String str2, StatFBDispatchCallback statFBDispatchCallback) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.postFeedBackFiles() can not be null!");
                return;
            }
            try {
                C1748g.m4809b(context2).mo7953b(str, str2, statFBDispatchCallback);
            } catch (Throwable th) {
                f4884q.mo7900e(th);
            }
        }
    }

    public static void registerActivityLifecycleCallbacks(Application application, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (!f4888u && application != null && VERSION.SDK_INT >= 14) {
            f4887t = application.getApplicationContext();
            f4867B = statSpecifyReportedInfo;
            synchronized (StatServiceImpl.class) {
                if (f4888u) {
                    return;
                }
                MtaActivityLifecycleCallback c1692an = new C1692an(statSpecifyReportedInfo);
                try {
                    addActionListener(new C1694ap(statSpecifyReportedInfo));
                    f4888u = MtaActivityLifeCycle.registerActivityLifecycleCallbacks(application, c1692an).booleanValue();
                    f4884q.mo7897d("enableAutoMonitorActivityCycle:" + f4888u + ",isAntoActivityLifecycleStat:" + StatConfig.isAntoActivityLifecycleStat());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void removeActionListener(StatActionListener statActionListener) {
        f4892y.remove(statActionListener);
    }

    public static void replyFeedBackMessage(Context context, String str, String str2, StatFBDispatchCallback statFBDispatchCallback) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.replyFeedBackMessage() can not be null!");
                return;
            }
            try {
                C1748g.m4809b(context2).mo7955c(str, str2, statFBDispatchCallback);
            } catch (Throwable th) {
                f4884q.mo7900e(th);
            }
        }
    }

    public static void reportAccount(Context context, StatAccount statAccount, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.mo7899e((Object) "context is null in reportAccount.");
            } else if (m4641c(context2) != null) {
                f4871d.mo7916a(new C1696ar(statAccount, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void reportAppMonitorStat(Context context, StatAppMonitor statAppMonitor, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.reportAppMonitorStat() can not be null!");
            } else if (statAppMonitor == null) {
                f4884q.error((Object) "The StatAppMonitor of StatService.reportAppMonitorStat() can not be null!");
            } else if (statAppMonitor.getInterfaceName() == null) {
                f4884q.error((Object) "The interfaceName of StatAppMonitor on StatService.reportAppMonitorStat() can not be null!");
            } else {
                StatAppMonitor clone = statAppMonitor.clone();
                if (m4641c(context2) != null) {
                    f4871d.mo7916a(new C1682ad(context2, statSpecifyReportedInfo, clone));
                }
            }
        }
    }

    public static void reportError(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.reportError() can not be null!");
            } else if (m4641c(context2) != null) {
                f4871d.mo7916a(new C1760r(str, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void reportException(Context context, Throwable th, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.reportException() can not be null!");
            } else if (m4641c(context2) != null) {
                f4871d.mo7916a(new C1762t(th, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void reportGameUser(Context context, StatGameUser statGameUser, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.reportGameUser() can not be null!");
            } else if (m4641c(context2) != null) {
                f4871d.mo7916a(new C1756n(statGameUser, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void reportQQ(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "context is null in reportQQ()");
            } else if (m4641c(context2) != null) {
                f4871d.mo7916a(new C1695aq(str, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void setCommonKeyValueForKVEvent(String str, Properties properties) {
        if (!StatCommonHelper.isStringValid(str)) {
            f4884q.mo7899e((Object) "event_id or commonProp for setCommonKeyValueForKVEvent is invalid.");
        } else if (properties == null || properties.size() <= 0) {
            f4873f.remove(str);
        } else {
            f4873f.put(str, (Properties) properties.clone());
        }
    }

    public static void setContext(Context context) {
        if (context != null) {
            f4887t = context.getApplicationContext();
        }
    }

    public static void setEnvAttributes(Context context, Map<String, String> map) {
        if (map == null || map.size() > 512) {
            f4884q.error((Object) "The map in setEnvAttributes can't be null or its size can't exceed 512.");
            return;
        }
        try {
            C1717a.m4733a(context, (Map) map);
        } catch (Throwable e) {
            f4884q.mo7900e(e);
        }
    }

    public static void startNewSession(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.startNewSession() can not be null!");
            } else if (m4641c(context2) != null) {
                f4871d.mo7916a(new C1690al(context2, statSpecifyReportedInfo));
            }
        }
    }

    public static boolean startStatService(Context context, String str, String str2, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        try {
            if (StatConfig.isEnableStatService()) {
                String str3 = StatConstants.VERSION;
                if (StatConfig.isDebugEnable()) {
                    f4884q.mo7897d("MTA SDK version, current: " + str3 + " ,required: " + str2);
                }
                if (context == null || str2 == null) {
                    f4884q.error((Object) "Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
                    StatConfig.setEnableStatService(false);
                    return false;
                } else if (StatCommonHelper.getSDKLongVersion(str3) < StatCommonHelper.getSDKLongVersion(str2)) {
                    f4884q.error(("MTA SDK version conflicted, current: " + str3 + ",required: " + str2) + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/");
                    StatConfig.setEnableStatService(false);
                    return false;
                } else {
                    str3 = StatConfig.getInstallChannel(context);
                    if (str3 == null || str3.length() == 0) {
                        StatConfig.setInstallChannel("-");
                    }
                    if (str != null) {
                        StatConfig.setAppKey(context, str);
                    }
                    if (m4641c(context) != null) {
                        f4871d.mo7916a(new C1757o(context, statSpecifyReportedInfo));
                    }
                    return true;
                }
            }
            f4884q.error((Object) "MTA StatService is disable.");
            return false;
        } catch (Throwable th) {
            f4884q.mo7900e(th);
            return false;
        }
    }

    public static void stopSession() {
        f4876i = 0;
    }

    public static void testSpeed(Context context) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.testSpeed() can not be null!");
            } else if (m4641c(context2) != null) {
                f4871d.mo7916a(new C1686ah(context2));
            }
        }
    }

    public static void testSpeed(Context context, Map<String, Integer> map, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.testSpeed() can not be null!");
            } else if (map == null || map.size() == 0) {
                f4884q.error((Object) "The domainMap of StatService.testSpeed() can not be null or empty!");
            } else {
                Map hashMap = new HashMap(map);
                if (m4641c(context2) != null) {
                    f4871d.mo7916a(new C1688aj(context2, hashMap, statSpecifyReportedInfo));
                }
            }
        }
    }

    public static void trackBackground(Context context, long j, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        m4624a(context, j, statSpecifyReportedInfo, false);
    }

    public static void trackBeginPage(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (!f4888u || !StatConfig.f4844q) {
            Context context2 = getContext(context);
            if (context2 == null || str == null || str.length() == 0) {
                f4884q.error((Object) "The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
            } else {
                inerTrackBeginPage(context2, str, statSpecifyReportedInfo);
            }
        }
    }

    public static void trackCustomBeginEvent(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo, String... strArr) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.trackCustomBeginEvent() can not be null!");
                return;
            }
            C1740d c1740d = new C1740d(str, strArr, null);
            if (m4641c(context2) != null) {
                f4871d.mo7916a(new C1768z(str, c1740d, context2));
            }
        }
    }

    public static void trackCustomBeginKVEvent(Context context, String str, Properties properties, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.trackCustomBeginEvent() can not be null!");
                return;
            }
            C1740d c1740d = new C1740d(str, null, properties);
            if (m4641c(context2) != null) {
                f4871d.mo7916a(new C1680ab(str, c1740d, context2));
            }
        }
    }

    public static void trackCustomEndEvent(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo, String... strArr) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.trackCustomEndEvent() can not be null!");
                return;
            }
            C1740d c1740d = new C1740d(str, strArr, null);
            if (m4641c(context2) != null) {
                f4871d.mo7916a(new C1679aa(str, c1740d, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void trackCustomEndKVEvent(Context context, String str, Properties properties, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.trackCustomEndEvent() can not be null!");
                return;
            }
            C1740d c1740d = new C1740d(str, null, properties);
            if (m4641c(context2) != null) {
                f4871d.mo7916a(new C1681ac(str, c1740d, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void trackCustomEvent(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo, String... strArr) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.trackCustomEvent() can not be null!");
            } else if (m4631a(str)) {
                f4884q.error((Object) "The event_id of StatService.trackCustomEvent() can not be null or empty.");
            } else {
                C1740d c1740d = new C1740d(str, strArr, null);
                if (m4641c(context2) != null) {
                    f4871d.mo7916a(new C1764v(context2, statSpecifyReportedInfo, c1740d));
                }
            }
        }
    }

    public static void trackCustomKVEvent(Context context, String str, Properties properties, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.trackCustomEvent() can not be null!");
            } else if (m4631a(str)) {
                f4884q.error((Object) "The event_id of StatService.trackCustomEvent() can not be null or empty.");
            } else {
                C1740d c1740d = new C1740d(str, null, properties);
                if (m4641c(context2) != null) {
                    f4871d.mo7916a(new C1767y(context2, statSpecifyReportedInfo, c1740d));
                }
            }
        }
    }

    public static void trackCustomKVTimeIntervalEvent(Context context, String str, Properties properties, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f4884q.error((Object) "The Context of StatService.trackCustomEndEvent() can not be null!");
            } else if (m4631a(str)) {
                f4884q.error((Object) "The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
            } else {
                C1740d c1740d = new C1740d(str, null, properties);
                if (m4641c(context2) != null) {
                    f4871d.mo7916a(new C1684af(context2, statSpecifyReportedInfo, c1740d, i));
                }
            }
        }
    }

    public static void trackCustomTimeIntervalEvent(Context context, int i, String str, String... strArr) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (i <= 0) {
            f4884q.error((Object) "The intervalSecond of StatService.trackCustomTimeIntervalEvent() can must bigger than 0!");
            return;
        }
        Context context2 = getContext(context);
        if (context2 == null) {
            f4884q.error((Object) "The Context of StatService.trackCustomTimeIntervalEvent() can not be null!");
        } else if (m4641c(context2) != null) {
            f4871d.mo7916a(new C1683ae());
        }
    }

    public static void trackEndPage(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (!f4888u || !StatConfig.f4844q) {
            Context context2 = getContext(context);
            if (context2 == null || str == null || str.length() == 0) {
                f4884q.error((Object) "The Context or pageName of StatService.trackEndPage() can not be null or empty!");
            } else {
                m4638b(context2, str, statSpecifyReportedInfo);
            }
        }
    }
}
