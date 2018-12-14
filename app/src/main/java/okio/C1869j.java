package okio;

/* renamed from: okio.j */
public abstract class C1869j implements C1850x {
    /* renamed from: a */
    private final C1850x f5533a;

    public C1869j(C1850x c1850x) {
        if (c1850x == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f5533a = c1850x;
    }

    /* renamed from: a */
    public long mo8763a(C1939e c1939e, long j) {
        return this.f5533a.mo8763a(c1939e, j);
    }

    /* renamed from: a */
    public final C1852y mo8764a() {
        return this.f5533a.mo8764a();
    }

    public void close() {
        this.f5533a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f5533a.toString() + ")";
    }
}
