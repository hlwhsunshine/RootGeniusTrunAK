package com.tencent.stat.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.tencent.stat.common.e */
public class C1721e {
    /* renamed from: b */
    private static StatLogger f5067b = StatCommonHelper.getLogger();
    /* renamed from: a */
    ExecutorService f5068a;

    public C1721e() {
        this.f5068a = null;
        this.f5068a = Executors.newSingleThreadExecutor();
    }

    /* renamed from: a */
    public void mo7916a(Runnable runnable) {
        try {
            this.f5068a.execute(runnable);
        } catch (Throwable e) {
            f5067b.mo7900e(e);
        }
    }
}
