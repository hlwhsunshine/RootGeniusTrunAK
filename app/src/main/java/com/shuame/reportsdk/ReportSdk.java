package com.shuame.reportsdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.C0479d;
import com.p070qq.p071e.comm.constants.ErrorCode.NetWorkError;
import com.shuame.rootgenius.sdk.RgsdkConfig;
import com.shuame.utils.C1619c;
import com.shuame.utils.C1621e;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import okhttp3.C1788z;
import okhttp3.C1791ab;
import okhttp3.C1925u;
import okhttp3.C1927v;
import okhttp3.C1927v.C1926a;
import okhttp3.C1932y.C1931a;

public class ReportSdk {
    /* renamed from: a */
    private static final String f3276a = ReportSdk.class.getSimpleName();
    /* renamed from: b */
    private static String f3277b;
    /* renamed from: c */
    private static Context f3278c;
    /* renamed from: d */
    private static C1241f f3279d;
    /* renamed from: e */
    private static String f3280e;
    /* renamed from: f */
    private static short[] f3281f;
    /* renamed from: g */
    private static HashMap<String, short[]> f3282g = new HashMap();
    /* renamed from: h */
    private static Handler f3283h;
    /* renamed from: i */
    private static HandlerThread f3284i;
    /* renamed from: j */
    private static Object f3285j = new Object();
    /* renamed from: k */
    private static boolean f3286k = false;
    /* renamed from: l */
    private static Map<String, C1235a> f3287l = new ConcurrentHashMap();
    /* renamed from: m */
    private static boolean f3288m = false;
    /* renamed from: n */
    private static boolean f3289n = false;
    /* renamed from: o */
    private static C1927v f3290o;

    public static class ReportException extends Exception {
        private static final long serialVersionUID = 1;

        public ReportException(String str) {
            super(str);
        }
    }

    /* renamed from: com.shuame.reportsdk.ReportSdk$a */
    public interface C1235a {
        /* renamed from: a */
        String mo6864a();
    }

    /* renamed from: a */
    static int m3500a() {
        List<C1236a> a = f3279d.mo6876a(null);
        Map hashMap = new HashMap();
        int i = 0;
        for (C1236a c1236a : a) {
            if (c1236a.f3295e) {
                String str = c1236a.f3296f;
                if (!hashMap.containsKey(str)) {
                    hashMap.put(str, new ArrayList());
                }
                ((List) hashMap.get(str)).add(c1236a);
            } else {
                try {
                    if (m3506b(c1236a.f3292b, c1236a.f3293c) == 200) {
                        f3279d.mo6874a(c1236a.f3291a);
                    }
                } catch (ReportException e) {
                    new StringBuilder("report exception occur. reason:").append(e.getMessage());
                }
            }
            i++;
        }
        for (String str2 : hashMap.keySet()) {
            try {
                if (m3506b(m3511c(str2), ((C1236a) ((List) hashMap.get(str2)).get(0)).f3293c) == 200) {
                    f3279d.mo6880d(str2);
                }
            } catch (ReportException e2) {
                new StringBuilder("report exception occur. reason:").append(e2.getMessage());
            }
        }
        return i;
    }

    /* renamed from: a */
    private static String m3501a(String str, String str2) {
        for (String str3 : f3287l.keySet()) {
            String str32;
            new StringBuilder("modifyContent: urlPrefix: ").append(str32).append("  requestPath: ").append(str);
            if (str.startsWith(str32)) {
                m3512d(str);
                C1235a c1235a = (C1235a) f3287l.get(str32);
                if (c1235a != null) {
                    str32 = c1235a.mo6864a();
                    if (!TextUtils.equals(str2, str32)) {
                        new StringBuilder("report event changed. report ==[url:").append(str).append("] content:").append(str32).append(" ");
                        return str32;
                    }
                } else {
                    continue;
                }
            }
        }
        return str2;
    }

    /* renamed from: a */
    public static synchronized void m3502a(Context context) {
        synchronized (ReportSdk.class) {
            if (!f3288m) {
                f3278c = context;
                f3277b = "POST";
                f3279d = new C1241f(context);
                f3281f = C1619c.f4580c;
                m3513d();
                HandlerThread handlerThread = new HandlerThread("ReportThread");
                f3284i = handlerThread;
                handlerThread.start();
                Handler c1237c = new C1237c(f3284i.getLooper());
                f3283h = c1237c;
                c1237c.sendEmptyMessage(4);
                f3288m = true;
            }
        }
    }

    /* renamed from: a */
    public static void m3503a(C1103b c1103b) {
        if (f3277b != null && f3278c != null && f3283h != null) {
            Message obtainMessage = f3283h.obtainMessage(1);
            obtainMessage.obj = c1103b;
            f3283h.sendMessage(obtainMessage);
        }
    }

    /* renamed from: a */
    public static void m3504a(String str) {
        f3280e = str;
    }

    /* renamed from: a */
    public static void m3505a(short[] sArr) {
        if (!f3289n || f3281f.equals(sArr)) {
            f3281f = sArr;
            f3289n = true;
            return;
        }
        throw new IllegalArgumentException("EncryptSeed has been set already, there is no need to call setEncryptSeed again!");
    }

    /* renamed from: b */
    private static int m3506b(String str, String str2) {
        if (!(!C1621e.m4394a(f3278c) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
            String d = m3512d(str2);
            new StringBuilder("report to server: [url:").append(d).append("] content:").append(str).append(" ");
            try {
                Object a = m3501a(str2, str);
                if (TextUtils.isEmpty(a)) {
                    return 415;
                }
                byte[] bytes = a.getBytes("UTF-8");
                C1619c.m4390a(bytes, m3509b(str2));
                C1791ab a2 = f3290o.mo8935a(new C1931a().mo8960a(C1788z.m4880a(C1925u.m5518a("*/*"), bytes)).mo8956a(d).mo8961a()).mo8666a();
                if (!a2.mo8631c()) {
                    new StringBuilder().append("report event to sever failed. url:" + str2).append(" status:").append(a2.mo8630b());
                }
                return a2.mo8630b();
            } catch (UnsupportedEncodingException e) {
                return NetWorkError.STUB_NETWORK_ERROR;
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
            } catch (IOException e3) {
            }
        }
        return 408;
    }

    /* renamed from: b */
    static /* synthetic */ void m3507b() {
        m3500a();
        synchronized (f3285j) {
            f3286k = true;
            f3285j.notifyAll();
        }
    }

    /* renamed from: b */
    static boolean m3508b(C1103b c1103b) {
        long a;
        String a2 = new C0479d().mo5385a((Object) c1103b);
        String a3 = c1103b.mo6700a();
        String str = "";
        if (TextUtils.isEmpty(str)) {
            a = f3279d.mo6875a(a2, a3, false, null);
        } else {
            a = f3279d.mo6875a(a2, a3, true, str);
            f3279d.mo6877a(str, "");
        }
        if (a == -1) {
            return false;
        }
        if (TextUtils.isEmpty("")) {
            try {
                if (m3506b(new C0479d().mo5385a((Object) c1103b), c1103b.mo6700a()) != 200) {
                    return false;
                }
                f3279d.mo6874a(a);
            } catch (ReportException e) {
                new StringBuilder("report exception occur. reason:").append(e.getMessage());
                return false;
            }
        }
        a2 = "";
        int c = f3279d.mo6879c(a2);
        if (c > 0) {
            try {
                if (m3506b(m3511c(a2), c1103b.mo6700a()) != 200) {
                    return false;
                }
                f3279d.mo6880d(a2);
                f3279d.mo6881e(a2);
            } catch (ReportException e2) {
                new StringBuilder("report exception occur. reason:").append(e2.getMessage());
                return false;
            }
        }
        new StringBuilder("it's batch event type. require least 1 now there are ").append(c).append(" events need ").append(1 - c).append(" more");
        return true;
    }

    /* renamed from: b */
    private static short[] m3509b(String str) {
        short[] sArr = f3281f;
        int i = 0;
        Iterator it = f3282g.keySet().iterator();
        while (true) {
            short[] sArr2 = sArr;
            int i2 = i;
            if (!it.hasNext()) {
                return sArr2;
            }
            String str2 = (String) it.next();
            if (str.contains(str2)) {
                int length = str2.length();
                if (length > i2) {
                    sArr = (short[]) f3282g.get(str2);
                    i = length;
                }
            }
            i = i2;
            sArr = sArr2;
        }
    }

    /* renamed from: c */
    private static String m3511c(String str) {
        List<C1236a> a = f3279d.mo6876a(str);
        StringBuilder stringBuilder = new StringBuilder();
        for (C1236a c1236a : a) {
            stringBuilder.append(c1236a.f3292b).append(",");
        }
        String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
        if (TextUtils.isEmpty(f3279d.mo6878b(str))) {
            return String.format("{\"%s\":[%s]}", new Object[]{str, substring});
        }
        return String.format("{%s,\"%s\":[%s]}", new Object[]{f3279d.mo6878b(str), str, substring});
    }

    /* renamed from: d */
    private static String m3512d(String str) {
        String toLowerCase = str.toLowerCase();
        return (toLowerCase.startsWith(RgsdkConfig.SCHEME) || toLowerCase.startsWith("https://")) ? str : f3280e + str;
    }

    /* renamed from: d */
    private static synchronized void m3513d() {
        synchronized (ReportSdk.class) {
            C1926a c1926a = new C1926a();
            c1926a.mo8929a(TimeUnit.SECONDS);
            c1926a.mo8933b(TimeUnit.SECONDS);
            c1926a.mo8931a(m3514e());
            c1926a.mo8930a(new C1238d());
            f3290o = c1926a.mo8932a();
        }
    }

    /* renamed from: e */
    private static SSLSocketFactory m3514e() {
        SSLSocketFactory sSLSocketFactory = null;
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[]{new C1239e()}, new SecureRandom());
            return instance.getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            return sSLSocketFactory;
        } catch (KeyManagementException e2) {
            return sSLSocketFactory;
        }
    }
}
