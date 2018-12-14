package okhttp3.internal;

import java.util.concurrent.ThreadFactory;

/* renamed from: okhttp3.internal.n */
final class C1911n implements ThreadFactory {
    /* renamed from: a */
    final /* synthetic */ String f5679a;
    /* renamed from: b */
    final /* synthetic */ boolean f5680b = true;

    C1911n(String str) {
        this.f5679a = str;
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f5679a);
        thread.setDaemon(this.f5680b);
        return thread;
    }
}
