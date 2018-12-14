package com.nostra13.universalimageloader.core;

import android.content.Context;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.p057a.p058a.C0979b;
import com.nostra13.universalimageloader.p057a.p058a.p059a.C0985b;
import com.nostra13.universalimageloader.p057a.p058a.p059a.p060a.C0980d;
import com.nostra13.universalimageloader.p057a.p058a.p061b.C0986a;
import com.nostra13.universalimageloader.p064b.C0999c;
import com.nostra13.universalimageloader.p064b.C1002f;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.nostra13.universalimageloader.core.a */
public final class C1009a {

    /* renamed from: com.nostra13.universalimageloader.core.a$a */
    private static class C1003a implements ThreadFactory {
        /* renamed from: a */
        private static final AtomicInteger f2501a = new AtomicInteger(1);
        /* renamed from: b */
        private final ThreadGroup f2502b;
        /* renamed from: c */
        private final AtomicInteger f2503c = new AtomicInteger(1);
        /* renamed from: d */
        private final String f2504d;
        /* renamed from: e */
        private final int f2505e;

        C1003a(int i, String str) {
            this.f2505e = i;
            this.f2502b = Thread.currentThread().getThreadGroup();
            this.f2504d = str + f2501a.getAndIncrement() + "-thread-";
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f2502b, runnable, this.f2504d + this.f2503c.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.f2505e);
            return thread;
        }
    }

    /* renamed from: a */
    public static C0979b m2870a(Context context, C0986a c0986a, long j, int i) {
        File a = C1002f.m2839a(context, false);
        File file = new File(a, "uil-images");
        if (file.exists() || file.mkdir()) {
            a = file;
        }
        if (j > 0 || i > 0) {
            File a2 = C1002f.m2839a(context, true);
            file = new File(a2, "uil-images");
            if (file.exists() || file.mkdir()) {
                a2 = file;
            }
            try {
                return new C0980d(a2, a, c0986a, j, i);
            } catch (Throwable e) {
                C0999c.m2832a(e);
            }
        }
        return new C0985b(C1002f.m2839a(context, true), a, c0986a);
    }

    /* renamed from: a */
    public static Executor m2871a() {
        return Executors.newCachedThreadPool(C1009a.m2873a(5, "uil-pool-d-"));
    }

    /* renamed from: a */
    public static Executor m2872a(int i, int i2, QueueProcessingType queueProcessingType) {
        return new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, (queueProcessingType == QueueProcessingType.LIFO ? 1 : null) != null ? new LIFOLinkedBlockingDeque() : new LinkedBlockingQueue(), C1009a.m2873a(i2, "uil-pool-"));
    }

    /* renamed from: a */
    private static ThreadFactory m2873a(int i, String str) {
        return new C1003a(i, str);
    }
}
