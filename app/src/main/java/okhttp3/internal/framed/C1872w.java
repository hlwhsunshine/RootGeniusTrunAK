package okhttp3.internal.framed;

import java.util.concurrent.CountDownLatch;

/* renamed from: okhttp3.internal.framed.w */
public final class C1872w {
    /* renamed from: a */
    private final CountDownLatch f5536a = new CountDownLatch(1);
    /* renamed from: b */
    private long f5537b = -1;
    /* renamed from: c */
    private long f5538c = -1;

    C1872w() {
    }

    /* renamed from: a */
    final void mo8812a() {
        if (this.f5537b != -1) {
            throw new IllegalStateException();
        }
        this.f5537b = System.nanoTime();
    }

    /* renamed from: b */
    final void mo8813b() {
        if (this.f5538c != -1 || this.f5537b == -1) {
            throw new IllegalStateException();
        }
        this.f5538c = System.nanoTime();
        this.f5536a.countDown();
    }

    /* renamed from: c */
    final void mo8814c() {
        if (this.f5538c != -1 || this.f5537b == -1) {
            throw new IllegalStateException();
        }
        this.f5538c = this.f5537b - 1;
        this.f5536a.countDown();
    }
}
