package com.tencent.stat.common;

import com.tencent.stat.StatConfig;
import com.tencent.stat.StatCustomLogger;

public final class StatLogger {
    /* renamed from: a */
    private String f5036a = "default";
    /* renamed from: b */
    private boolean f5037b = true;
    /* renamed from: c */
    private int f5038c = 2;

    public StatLogger(String str) {
        this.f5036a = str;
    }

    /* renamed from: a */
    private String m4724a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(getClass().getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    /* renamed from: d */
    public final void mo7897d(Object obj) {
        if (isDebugEnable()) {
            debug(obj);
        }
    }

    public final void debug(Object obj) {
        if (this.f5038c <= 3) {
            String a = m4724a();
            Object obj2 = a == null ? obj.toString() : a + " - " + obj;
            StatCustomLogger customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.debug(obj2);
            }
        }
    }

    /* renamed from: e */
    public final void mo7899e(Object obj) {
        if (isDebugEnable()) {
            error(obj);
        }
    }

    /* renamed from: e */
    public final void mo7900e(Throwable th) {
        if (isDebugEnable()) {
            error(th);
        }
    }

    public final void error(Object obj) {
        if (this.f5038c <= 6) {
            String a = m4724a();
            Object obj2 = a == null ? obj.toString() : a + " - " + obj;
            StatCustomLogger customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.error(obj2);
            }
        }
    }

    public final void error(Throwable th) {
        if (this.f5038c <= 6) {
            StatCustomLogger customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.error((Object) th);
            }
        }
    }

    public final int getLogLevel() {
        return this.f5038c;
    }

    /* renamed from: i */
    public final void mo7904i(Object obj) {
        if (isDebugEnable()) {
            info(obj);
        }
    }

    public final void info(Object obj) {
        if (this.f5038c <= 4) {
            String a = m4724a();
            Object obj2 = a == null ? obj.toString() : a + " - " + obj;
            StatCustomLogger customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.info(obj2);
            }
        }
    }

    public final boolean isDebugEnable() {
        return this.f5037b;
    }

    public final void setDebugEnable(boolean z) {
        this.f5037b = z;
    }

    public final void setLogLevel(int i) {
        this.f5038c = i;
    }

    public final void setTag(String str) {
        this.f5036a = str;
    }

    /* renamed from: v */
    public final void mo7910v(Object obj) {
        if (isDebugEnable()) {
            verbose(obj);
        }
    }

    public final void verbose(Object obj) {
        if (this.f5038c <= 2) {
            String a = m4724a();
            Object obj2 = a == null ? obj.toString() : a + " - " + obj;
            StatCustomLogger customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.verbose(obj2);
            }
        }
    }

    /* renamed from: w */
    public final void mo7912w(Object obj) {
        if (isDebugEnable()) {
            warn(obj);
        }
    }

    public final void warn(Object obj) {
        if (this.f5038c <= 5) {
            String a = m4724a();
            Object obj2 = a == null ? obj.toString() : a + " - " + obj;
            StatCustomLogger customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.warn(obj2);
            }
        }
    }
}
