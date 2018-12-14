package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.cover.C1627f;
import com.tencent.beacon.cover.C1628g;
import com.tencent.beacon.cover.UserActionProxy;
import com.tencent.beacon.upload.InitHandleListener;
import com.tencent.beacon.upload.UploadHandleListener;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class UserAction {
    /* renamed from: a */
    private static boolean f4632a = false;
    /* renamed from: b */
    private static boolean f4633b = false;
    /* renamed from: c */
    private static Context f4634c;
    /* renamed from: d */
    private static boolean f4635d = true;
    /* renamed from: e */
    private static long f4636e = 0;
    /* renamed from: f */
    private static InitHandleListener f4637f;
    /* renamed from: g */
    private static UploadHandleListener f4638g;
    /* renamed from: h */
    private static Boolean f4639h;
    /* renamed from: i */
    private static Boolean f4640i;
    /* renamed from: j */
    private static String f4641j;
    /* renamed from: k */
    private static String f4642k;
    /* renamed from: l */
    private static String f4643l;
    /* renamed from: m */
    private static String f4644m;
    /* renamed from: n */
    private static String f4645n;
    /* renamed from: o */
    private static String f4646o;
    /* renamed from: p */
    private static Map<String, String> f4647p;
    /* renamed from: q */
    private static String f4648q;
    /* renamed from: r */
    private static String f4649r;
    /* renamed from: s */
    private static Boolean f4650s;
    /* renamed from: t */
    private static long f4651t;
    /* renamed from: u */
    private static Map<String, String> f4652u;
    /* renamed from: v */
    private static ArrayList<C1630a> f4653v = new ArrayList();
    /* renamed from: w */
    private static DexClassLoader f4654w;
    /* renamed from: x */
    private static UserActionProxy f4655x;

    /* renamed from: com.tencent.beacon.event.UserAction$a */
    private static class C1630a {
        /* renamed from: a */
        String f4626a;
        /* renamed from: b */
        boolean f4627b;
        /* renamed from: c */
        long f4628c;
        /* renamed from: d */
        Map<String, String> f4629d;
        /* renamed from: e */
        boolean f4630e;
        /* renamed from: f */
        boolean f4631f;

        private C1630a() {
        }

        /* synthetic */ C1630a(byte b) {
            this();
        }
    }

    /* renamed from: a */
    private static boolean m4460a() {
        if (f4655x != null) {
            return true;
        }
        if (f4654w == null) {
            return false;
        }
        try {
            f4655x = (UserActionProxy) f4654w.loadClass("com.tencent.beacon.core.UserActionProxyImpl").newInstance();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f4655x != null;
    }

    public static void doUploadRecords() {
        if (f4655x != null) {
            f4655x.doUploadRecords();
        }
    }

    public static void flushObjectsToDB(boolean z) {
        if (f4655x != null) {
            f4655x.flushObjectsToDB(z);
        }
    }

    public static String getCloudParas(String str) {
        return f4655x != null ? f4655x.getCloudParas(str) : null;
    }

    public static String getQIMEI() {
        return f4655x != null ? f4655x.getQIMEI() : "";
    }

    public static void initUserAction(Context context) {
        initUserAction(context, true);
    }

    public static void initUserAction(Context context, boolean z) {
        initUserAction(context, z, 0);
    }

    public static void initUserAction(Context context, boolean z, long j) {
        initUserAction(context, z, j, null);
    }

    public static void initUserAction(Context context, boolean z, long j, InitHandleListener initHandleListener) {
        initUserAction(context, z, j, initHandleListener, null);
    }

    public static void initUserAction(Context context, boolean z, long j, InitHandleListener initHandleListener, UploadHandleListener uploadHandleListener) {
        if (f4655x != null) {
            if (!(f4632a || f4655x == null)) {
                if (!(f4639h == null || f4640i == null)) {
                    setLogAble(f4639h.booleanValue(), f4640i.booleanValue());
                    f4639h = null;
                    f4640i = null;
                }
                if (f4647p != null) {
                    setAdditionalInfo(f4647p);
                    f4647p = null;
                }
                if (f4641j != null) {
                    setAppkey(f4641j);
                    f4641j = null;
                }
                if (f4642k != null) {
                    setAppVersion(f4642k);
                    f4642k = null;
                }
                if (f4644m != null) {
                    setChannelID(f4644m);
                    f4644m = null;
                }
                if (f4643l != null) {
                    setSDKVersion(f4643l);
                    f4643l = null;
                }
                if (f4645n != null) {
                    setQQ(f4645n);
                    f4645n = null;
                }
                if (f4646o != null) {
                    setUserID(f4646o);
                    f4646o = null;
                }
                if (!(f4648q == null || f4649r == null)) {
                    setReportDomain(f4648q, f4649r);
                    f4648q = null;
                    f4649r = null;
                }
            }
            f4655x.initUserAction(context, z, j, initHandleListener, uploadHandleListener);
            if (!f4632a) {
                if (f4650s != null) {
                    loginEvent(f4650s.booleanValue(), f4651t, f4652u);
                    f4650s = null;
                    f4652u = null;
                }
                Iterator it = f4653v.iterator();
                while (it.hasNext()) {
                    C1630a c1630a = (C1630a) it.next();
                    onUserAction(c1630a.f4626a, c1630a.f4627b, c1630a.f4628c, 0, c1630a.f4629d, c1630a.f4630e, c1630a.f4631f);
                }
                f4653v.clear();
            }
            f4632a = true;
            return;
        }
        if (!f4633b) {
            new Thread(C1628g.m4448a(context)).start();
            f4633b = true;
        }
        f4634c = context;
        f4635d = z;
        f4636e = j;
        f4637f = initHandleListener;
        f4638g = uploadHandleListener;
    }

    public static boolean loginEvent(boolean z, long j, Map<String, String> map) {
        if (f4655x != null) {
            return f4655x.loginEvent(z, j, map);
        }
        f4650s = Boolean.valueOf(z);
        f4651t = j;
        f4652u = map;
        return false;
    }

    public static void onCompLoaded(DexClassLoader dexClassLoader) {
        if (f4654w == null) {
            f4654w = dexClassLoader;
            if (m4460a() && f4634c != null) {
                initUserAction(f4634c, f4635d, f4636e, f4637f, f4638g);
                f4634c = null;
            }
        }
    }

    public static boolean onUserAction(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        return onUserAction(str, z, j, j2, map, z2, false);
    }

    public static boolean onUserAction(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        if (f4655x != null) {
            return f4655x.onUserAction(str, z, j, j2, map, z2, z3);
        }
        C1630a c1630a = new C1630a();
        c1630a.f4626a = str;
        c1630a.f4627b = z;
        c1630a.f4628c = j;
        c1630a.f4629d = map;
        c1630a.f4630e = z2;
        c1630a.f4631f = z3;
        if (f4653v.size() < 100) {
            f4653v.add(c1630a);
        }
        return false;
    }

    public static void setAdditionalInfo(Map<String, String> map) {
        if (f4655x != null) {
            f4655x.setAdditionalInfo(map);
        } else {
            f4647p = map;
        }
    }

    public static void setAppVersion(String str) {
        C1628g.f4618b = str;
        if (f4655x != null) {
            f4655x.setAppVersion(str);
        } else {
            f4642k = str;
        }
    }

    public static void setAppkey(String str) {
        C1628g.f4617a = str;
        if (f4655x != null) {
            f4655x.setAppkey(str);
        } else {
            f4641j = str;
        }
    }

    public static void setChannelID(String str) {
        if (f4655x != null) {
            f4655x.setChannelID(str);
        } else {
            f4644m = str;
        }
    }

    public static void setLogAble(boolean z, boolean z2) {
        C1627f.f4614a = z;
        if (f4655x != null) {
            f4655x.setLogAble(z, z2);
            return;
        }
        f4639h = Boolean.valueOf(z);
        f4640i = Boolean.valueOf(z2);
    }

    public static void setQQ(String str) {
        if (f4655x != null) {
            f4655x.setQQ(str);
        } else {
            f4645n = str;
        }
    }

    public static void setReportDomain(String str, String str2) {
        if (f4655x != null) {
            f4655x.setReportDomain(str, str2);
            return;
        }
        f4648q = str;
        f4649r = str2;
    }

    public static void setSDKVersion(String str) {
        C1628g.f4618b = str;
        if (f4655x != null) {
            f4655x.setSDKVersion(str);
        } else {
            f4643l = str;
        }
    }

    public static void setUploadMode(boolean z) {
        if (f4655x != null) {
            f4655x.setUploadMode(z);
        }
    }

    public static void setUserID(String str) {
        if (f4655x != null) {
            f4655x.setUserID(str);
        } else {
            f4646o = str;
        }
    }
}
