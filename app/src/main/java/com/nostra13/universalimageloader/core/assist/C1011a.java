package com.nostra13.universalimageloader.core.assist;

import java.io.InputStream;

/* renamed from: com.nostra13.universalimageloader.core.assist.a */
public final class C1011a extends InputStream {
    /* renamed from: a */
    private final InputStream f2524a;
    /* renamed from: b */
    private final int f2525b;

    public C1011a(InputStream inputStream, int i) {
        this.f2524a = inputStream;
        this.f2525b = i;
    }

    public final int available() {
        return this.f2525b;
    }

    public final void close() {
        this.f2524a.close();
    }

    public final void mark(int i) {
        this.f2524a.mark(i);
    }

    public final boolean markSupported() {
        return this.f2524a.markSupported();
    }

    public final int read() {
        return this.f2524a.read();
    }

    public final int read(byte[] bArr) {
        return this.f2524a.read(bArr);
    }

    public final int read(byte[] bArr, int i, int i2) {
        return this.f2524a.read(bArr, i, i2);
    }

    public final void reset() {
        this.f2524a.reset();
    }

    public final long skip(long j) {
        return this.f2524a.skip(j);
    }
}
