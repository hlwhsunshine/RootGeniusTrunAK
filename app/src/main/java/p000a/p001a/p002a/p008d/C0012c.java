package p000a.p001a.p002a.p008d;

import java.io.IOException;
import java.io.RandomAccessFile;
import p000a.p001a.p002a.p004b.C0005b;
import p000a.p001a.p002a.p004b.C0006a;
import p000a.p001a.p002a.p007c.C0010a;
import p000a.p001a.p002a.p011g.C0029b;

/* renamed from: a.a.a.d.c */
public class C0012c extends C0011a {
    /* renamed from: a */
    private RandomAccessFile f44a;
    /* renamed from: b */
    private long f45b;
    /* renamed from: c */
    private long f46c;
    /* renamed from: d */
    private C0029b f47d;
    /* renamed from: e */
    private C0005b f48e;
    /* renamed from: f */
    private byte[] f49f = new byte[1];
    /* renamed from: g */
    private byte[] f50g = new byte[16];
    /* renamed from: h */
    private int f51h = 0;
    /* renamed from: i */
    private boolean f52i = false;
    /* renamed from: j */
    private int f53j = -1;

    public C0012c(RandomAccessFile randomAccessFile, long j, C0029b c0029b) {
        boolean z = true;
        this.f44a = randomAccessFile;
        this.f47d = c0029b;
        this.f48e = c0029b.mo167d();
        this.f45b = 0;
        this.f46c = j;
        if (!(c0029b.mo166c().mo84l() && c0029b.mo166c().mo86n() == 99)) {
            z = false;
        }
        this.f52i = z;
    }

    /* renamed from: a */
    public C0029b mo24a() {
        return this.f47d;
    }

    public int available() {
        long j = this.f46c - this.f45b;
        return j > 2147483647L ? Integer.MAX_VALUE : (int) j;
    }

    /* renamed from: b */
    protected final void mo27b() {
        if (this.f52i && this.f48e != null && (this.f48e instanceof C0006a) && ((C0006a) this.f48e).mo19c() == null) {
            byte[] bArr = new byte[10];
            int read = this.f44a.read(bArr);
            if (read != 10) {
                if (this.f47d.mo168e().mo147c()) {
                    this.f44a.close();
                    this.f44a = this.f47d.mo165b();
                    this.f44a.read(bArr, read, 10 - read);
                } else {
                    throw new IOException("Error occured while reading stored AES authentication bytes");
                }
            }
            ((C0006a) this.f47d.mo167d()).mo17a(bArr);
        }
    }

    public void close() {
        this.f44a.close();
    }

    public int read() {
        if (this.f45b >= this.f46c) {
            return -1;
        }
        if (!this.f52i) {
            return read(this.f49f, 0, 1) != -1 ? this.f49f[0] & 255 : -1;
        } else {
            if (this.f51h == 0 || this.f51h == 16) {
                if (read(this.f50g) == -1) {
                    return -1;
                }
                this.f51h = 0;
            }
            byte[] bArr = this.f50g;
            int i = this.f51h;
            this.f51h = i + 1;
            return bArr[i] & 255;
        }
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (((long) i2) > this.f46c - this.f45b) {
            i2 = (int) (this.f46c - this.f45b);
            if (i2 == 0) {
                mo27b();
                return -1;
            }
        }
        if ((this.f47d.mo167d() instanceof C0006a) && this.f45b + ((long) i2) < this.f46c && i2 % 16 != 0) {
            i2 -= i2 % 16;
        }
        synchronized (this.f44a) {
            this.f53j = this.f44a.read(bArr, i, i2);
            if (this.f53j < i2 && this.f47d.mo168e().mo147c()) {
                this.f44a.close();
                this.f44a = this.f47d.mo165b();
                if (this.f53j < 0) {
                    this.f53j = 0;
                }
                int read = this.f44a.read(bArr, this.f53j, i2 - this.f53j);
                if (read > 0) {
                    this.f53j = read + this.f53j;
                }
            }
        }
        if (this.f53j > 0) {
            if (this.f48e != null) {
                try {
                    this.f48e.mo15a(bArr, i, this.f53j);
                } catch (C0010a e) {
                    throw new IOException(e.getMessage());
                }
            }
            this.f45b += (long) this.f53j;
        }
        if (this.f45b >= this.f46c) {
            mo27b();
        }
        return this.f53j;
    }

    public long skip(long j) {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        if (j > this.f46c - this.f45b) {
            j = this.f46c - this.f45b;
        }
        this.f45b += j;
        return j;
    }
}
