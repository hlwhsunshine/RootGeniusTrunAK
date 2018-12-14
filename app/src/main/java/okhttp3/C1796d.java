package okhttp3;

import java.io.Closeable;
import java.io.Flushable;
import okhttp3.internal.C1822c;
import okhttp3.internal.C1826f;

/* renamed from: okhttp3.d */
public final class C1796d implements Closeable, Flushable {
    /* renamed from: a */
    final C1826f f5269a;
    /* renamed from: b */
    private final C1822c f5270b;

    public final void close() {
        this.f5270b.close();
    }

    public final void flush() {
        this.f5270b.flush();
    }
}
