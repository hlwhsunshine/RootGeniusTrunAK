package p000a.p001a.p002a.p008d;

import java.io.IOException;
import java.io.InputStream;
import p000a.p001a.p002a.p007c.C0010a;

/* renamed from: a.a.a.d.d */
public final class C0014d extends InputStream {
    /* renamed from: a */
    private C0011a f60a;

    public C0014d(C0011a c0011a) {
        this.f60a = c0011a;
    }

    public final int available() {
        return this.f60a.available();
    }

    public final void close() {
        try {
            this.f60a.close();
            if (this.f60a.mo24a() != null) {
                this.f60a.mo24a().mo161a();
            }
        } catch (C0010a e) {
            throw new IOException(e.getMessage());
        }
    }

    public final int read() {
        int read = this.f60a.read();
        if (read != -1) {
            this.f60a.mo24a().mo162a(read);
        }
        return read;
    }

    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) {
        int read = this.f60a.read(bArr, i, i2);
        if (read > 0 && this.f60a.mo24a() != null) {
            this.f60a.mo24a().mo164a(bArr, i, read);
        }
        return read;
    }

    public final long skip(long j) {
        return this.f60a.skip(j);
    }
}
