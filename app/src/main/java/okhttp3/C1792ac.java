package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import okhttp3.internal.C1910m;
import okio.C1938h;

/* renamed from: okhttp3.ac */
public abstract class C1792ac implements Closeable {
    /* renamed from: e */
    private byte[] m4937e() {
        long b = mo8642b();
        if (b > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + b);
        }
        Closeable c = mo8643c();
        try {
            byte[] p = c.mo9039p();
            if (b == -1 || b == ((long) p.length)) {
                return p;
            }
            throw new IOException("Content-Length and stream length disagree");
        } finally {
            C1910m.m5452a(c);
        }
    }

    /* renamed from: a */
    public abstract C1925u mo8641a();

    /* renamed from: b */
    public abstract long mo8642b();

    /* renamed from: c */
    public abstract C1938h mo8643c();

    public void close() {
        C1910m.m5452a(mo8643c());
    }

    /* renamed from: d */
    public final String mo8645d() {
        byte[] e = m4937e();
        C1925u a = mo8641a();
        return new String(e, (a != null ? a.mo8925a(C1910m.f5676c) : C1910m.f5676c).name());
    }
}
