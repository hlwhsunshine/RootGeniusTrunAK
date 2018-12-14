package okhttp3;

/* renamed from: okhttp3.j */
final class C1912j implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1804i f5681a;

    C1912j(C1804i c1804i) {
        this.f5681a = c1804i;
    }

    public final void run() {
        while (true) {
            long a = this.f5681a.mo8674a(System.nanoTime());
            if (a != -1) {
                if (a > 0) {
                    long j = a / 1000000;
                    a -= j * 1000000;
                    synchronized (this.f5681a) {
                        try {
                            this.f5681a.wait(j, (int) a);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            } else {
                return;
            }
        }
    }
}
