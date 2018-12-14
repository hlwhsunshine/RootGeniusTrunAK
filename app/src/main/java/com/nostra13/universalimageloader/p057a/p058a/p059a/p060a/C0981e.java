package com.nostra13.universalimageloader.p057a.p058a.p059a.p060a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* renamed from: com.nostra13.universalimageloader.a.a.a.a.e */
final class C0981e implements Closeable {
    /* renamed from: a */
    private final InputStream f2459a;
    /* renamed from: b */
    private final Charset f2460b;
    /* renamed from: c */
    private byte[] f2461c;
    /* renamed from: d */
    private int f2462d;
    /* renamed from: e */
    private int f2463e;

    public C0981e(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private C0981e(InputStream inputStream, Charset charset, byte b) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (charset.equals(C0983g.f2465a)) {
            this.f2459a = inputStream;
            this.f2460b = charset;
            this.f2461c = new byte[8192];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    /* renamed from: b */
    private void m2786b() {
        int read = this.f2459a.read(this.f2461c, 0, this.f2461c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f2462d = 0;
        this.f2463e = read;
    }

    /* renamed from: a */
    public final String mo6143a() {
        String str;
        synchronized (this.f2459a) {
            if (this.f2461c == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.f2462d >= this.f2463e) {
                m2786b();
            }
            int i2 = this.f2462d;
            while (i2 != this.f2463e) {
                if (this.f2461c[i2] == (byte) 10) {
                    int i3 = (i2 == this.f2462d || this.f2461c[i2 - 1] != (byte) 13) ? i2 : i2 - 1;
                    str = new String(this.f2461c, this.f2462d, i3 - this.f2462d, this.f2460b.name());
                    this.f2462d = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream c0982f = new C0982f(this, (this.f2463e - this.f2462d) + 80);
            loop1:
            while (true) {
                c0982f.write(this.f2461c, this.f2462d, this.f2463e - this.f2462d);
                this.f2463e = -1;
                m2786b();
                i = this.f2462d;
                while (i != this.f2463e) {
                    if (this.f2461c[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f2462d) {
                c0982f.write(this.f2461c, this.f2462d, i - this.f2462d);
            }
            this.f2462d = i + 1;
            str = c0982f.toString();
        }
        return str;
    }

    public final void close() {
        synchronized (this.f2459a) {
            if (this.f2461c != null) {
                this.f2461c = null;
                this.f2459a.close();
            }
        }
    }
}
