package okio;

import java.io.InputStream;

/* renamed from: okio.f */
final class C1940f extends InputStream {
    /* renamed from: a */
    final /* synthetic */ C1939e f5808a;

    C1940f(C1939e c1939e) {
        this.f5808a = c1939e;
    }

    public final int available() {
        return (int) Math.min(this.f5808a.f5807b, 2147483647L);
    }

    public final void close() {
    }

    public final int read() {
        return this.f5808a.f5807b > 0 ? this.f5808a.mo9032g() & 255 : -1;
    }

    public final int read(byte[] bArr, int i, int i2) {
        return this.f5808a.mo9040a(bArr, i, i2);
    }

    public final String toString() {
        return this.f5808a + ".inputStream()";
    }
}
