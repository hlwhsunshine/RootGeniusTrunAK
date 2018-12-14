package com.tencent.stat;

import com.tencent.stat.event.C1741e;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.tencent.stat.as */
class C1697as implements UncaughtExceptionHandler {
    C1697as() {
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (StatConfig.isEnableStatService() && StatServiceImpl.f4887t != null) {
            try {
                StatServiceImpl.m4637b(StatServiceImpl.f4887t, null, true);
                if (StatConfig.isAutoExceptionCaught()) {
                    C1706ba.m4673a(StatServiceImpl.f4887t).mo7871a(new C1741e(StatServiceImpl.f4887t, StatServiceImpl.m4619a(StatServiceImpl.f4887t, false, null), 2, th, thread, null), null, false, true);
                    StatServiceImpl.f4884q.debug("MTA has caught the following uncaught exception:");
                } else {
                    StatServiceImpl.f4884q.mo7912w("crash happened, but MTA AutoExceptionCaught is desable.");
                }
                StatServiceImpl.f4884q.error(th);
                StatServiceImpl.flushDataToDB(StatServiceImpl.f4887t);
                if (StatServiceImpl.f4885r != null) {
                    StatServiceImpl.f4884q.mo7897d("Call the original uncaught exception handler.");
                    if (!(StatServiceImpl.f4885r instanceof C1697as)) {
                        StatServiceImpl.f4885r.uncaughtException(thread, th);
                    }
                }
                if (StatConfig.m4613e() != null) {
                    StatConfig.m4613e().onMtaException(th);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }
}
