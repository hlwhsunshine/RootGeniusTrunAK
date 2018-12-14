package com.shuame.p075ad;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.shuame.ad.ae */
public class C1094ae {
    /* renamed from: a */
    private static final String f2921a = C1094ae.class.getSimpleName();
    /* renamed from: b */
    private ExecutorService f2922b;

    /* renamed from: com.shuame.ad.ae$a */
    private class C1091a implements ThreadFactory {
        /* renamed from: b */
        private final AtomicInteger f2916b = new AtomicInteger(1);
        /* renamed from: c */
        private final ThreadGroup f2917c;
        /* renamed from: d */
        private final AtomicInteger f2918d = new AtomicInteger(1);
        /* renamed from: e */
        private final String f2919e;

        C1091a(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.f2917c = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f2919e = str + "-" + this.f2916b.getAndIncrement() + "-thread-";
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f2917c, runnable, this.f2919e + this.f2918d.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(10);
            return thread;
        }
    }

    /* renamed from: com.shuame.ad.ae$b */
    private static class C1092b extends ThreadPoolExecutor {
        public C1092b(TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(0, 1, 3, timeUnit, blockingQueue, threadFactory);
        }

        protected final void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
            C1094ae.m3179b(runnable);
        }
    }

    /* renamed from: com.shuame.ad.ae$c */
    private static class C1093c {
        /* renamed from: a */
        private static C1094ae f2920a = new C1094ae();
    }

    private C1094ae() {
        this.f2922b = new C1092b(TimeUnit.SECONDS, new LinkedBlockingQueue(), new C1091a("SimpleTaskPool"));
    }

    /* synthetic */ C1094ae(byte b) {
        this();
    }

    /* renamed from: a */
    public static C1094ae m3178a() {
        return C1093c.f2920a;
    }

    /* renamed from: b */
    static /* synthetic */ void m3179b(Runnable runnable) {
        if (runnable != null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            if (future.isDone()) {
                try {
                    future.get();
                } catch (InterruptedException e) {
                } catch (ExecutionException e2) {
                    new StringBuilder("exception occured. runnalbe:").append(runnable.toString());
                    e2.getCause();
                } catch (CancellationException e3) {
                } catch (Exception e4) {
                    new StringBuilder("exception occured. runnalbe:").append(runnable.toString());
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo6680a(Runnable runnable) {
        this.f2922b.submit(runnable);
    }
}
