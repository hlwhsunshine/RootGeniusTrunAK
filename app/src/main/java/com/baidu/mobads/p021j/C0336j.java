package com.baidu.mobads.p021j;

import android.util.Log;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.p022a.C0238a;

/* renamed from: com.baidu.mobads.j.j */
public class C0336j implements IXAdLogger {
    /* renamed from: a */
    private static volatile C0336j f678a = null;

    /* renamed from: a */
    public static C0336j m550a() {
        if (f678a == null) {
            synchronized (C0336j.class) {
                if (f678a == null) {
                    f678a = new C0336j();
                }
            }
        }
        return f678a;
    }

    /* renamed from: a */
    private String m551a(Object[] objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object append : objArr) {
            stringBuilder.append(append).append(' ');
        }
        return stringBuilder.toString();
    }

    /* renamed from: d */
    public int mo4921d(String str) {
        return mo4922d(IXAdLogger.TAG, str);
    }

    /* renamed from: d */
    public int mo4922d(String str, String str2) {
        int i = -1;
        if (!isLoggable(3)) {
            return i;
        }
        try {
            return Log.d(str, str2);
        } catch (Exception e) {
            return i;
        }
    }

    /* renamed from: d */
    public int mo4923d(String str, Throwable th) {
        int i = -1;
        if (!isLoggable(3)) {
            return i;
        }
        try {
            return Log.d(IXAdLogger.TAG, str, th);
        } catch (Exception e) {
            return i;
        }
    }

    /* renamed from: d */
    public int mo4924d(Throwable th) {
        return mo4923d("", th);
    }

    /* renamed from: d */
    public int mo4925d(Object... objArr) {
        return !isLoggable(3) ? -1 : mo4921d(m551a(objArr));
    }

    /* renamed from: e */
    public int mo4926e(String str) {
        int i = -1;
        if (!isLoggable(6)) {
            return i;
        }
        try {
            return Log.e(IXAdLogger.TAG, str);
        } catch (Exception e) {
            return i;
        }
    }

    /* renamed from: e */
    public int mo4927e(String str, Throwable th) {
        int i = -1;
        if (!isLoggable(6)) {
            return i;
        }
        try {
            return Log.e(IXAdLogger.TAG, str, th);
        } catch (Exception e) {
            return i;
        }
    }

    /* renamed from: e */
    public int mo4928e(Throwable th) {
        return mo4927e("", th);
    }

    /* renamed from: e */
    public int mo4929e(Object... objArr) {
        return !isLoggable(6) ? -1 : mo4926e(m551a(objArr));
    }

    /* renamed from: i */
    public int mo4930i(String str) {
        return mo4931i(IXAdLogger.TAG, str);
    }

    /* renamed from: i */
    public int mo4931i(String str, String str2) {
        int i = -1;
        if (!isLoggable(4)) {
            return i;
        }
        try {
            return Log.i(str, str2);
        } catch (Exception e) {
            return i;
        }
    }

    /* renamed from: i */
    public int mo4932i(String str, Throwable th) {
        int i = -1;
        if (!isLoggable(4)) {
            return i;
        }
        try {
            return Log.i(IXAdLogger.TAG, str, th);
        } catch (Exception e) {
            return i;
        }
    }

    /* renamed from: i */
    public int mo4933i(Object... objArr) {
        return !isLoggable(4) ? -1 : mo4930i(m551a(objArr));
    }

    public boolean isLoggable(int i) {
        return isLoggable(IXAdLogger.TAG, i);
    }

    public boolean isLoggable(String str, int i) {
        return i >= C0238a.f375b;
    }

    /* renamed from: w */
    public int mo4936w(String str) {
        int i = -1;
        if (!isLoggable(5)) {
            return i;
        }
        try {
            return Log.w(IXAdLogger.TAG, str);
        } catch (Exception e) {
            return i;
        }
    }

    /* renamed from: w */
    public int mo4937w(String str, Throwable th) {
        int i = -1;
        if (!isLoggable(5)) {
            return i;
        }
        try {
            return Log.w(IXAdLogger.TAG, str, th);
        } catch (Exception e) {
            return i;
        }
    }

    /* renamed from: w */
    public int mo4938w(Throwable th) {
        return mo4937w("", th);
    }

    /* renamed from: w */
    public int mo4939w(Object... objArr) {
        return !isLoggable(5) ? -1 : mo4936w(m551a(objArr));
    }
}
