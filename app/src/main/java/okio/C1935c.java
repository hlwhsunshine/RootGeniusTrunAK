package okio;

import java.io.IOException;

/* renamed from: okio.c */
final class C1935c implements C1850x {
    /* renamed from: a */
    final /* synthetic */ C1850x f5801a;
    /* renamed from: b */
    final /* synthetic */ C1853a f5802b;

    C1935c(C1853a c1853a, C1850x c1850x) {
        this.f5802b = c1853a;
        this.f5801a = c1850x;
    }

    /* renamed from: a */
    public final long mo8763a(C1939e c1939e, long j) {
        this.f5802b.mo8780c();
        try {
            long a = this.f5801a.mo8763a(c1939e, j);
            this.f5802b.mo8777a(true);
            return a;
        } catch (IOException e) {
            throw this.f5802b.mo8779b(e);
        } catch (Throwable th) {
            this.f5802b.mo8777a(false);
        }
    }

    /* renamed from: a */
    public final C1852y mo8764a() {
        return this.f5802b;
    }

    public final void close() {
        try {
            this.f5801a.close();
            this.f5802b.mo8777a(true);
        } catch (IOException e) {
            throw this.f5802b.mo8779b(e);
        } catch (Throwable th) {
            this.f5802b.mo8777a(false);
        }
    }

    public final String toString() {
        return "AsyncTimeout.source(" + this.f5801a + ")";
    }
}
