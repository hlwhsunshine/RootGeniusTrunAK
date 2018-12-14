package okhttp3.internal;

/* renamed from: okhttp3.internal.i */
public abstract class C1835i implements Runnable {
    /* renamed from: a */
    protected final String f5389a;

    public C1835i(String str, Object... objArr) {
        this.f5389a = C1910m.m5445a(str, objArr);
    }

    /* renamed from: a */
    protected abstract void mo8749a();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f5389a);
        try {
            mo8749a();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
