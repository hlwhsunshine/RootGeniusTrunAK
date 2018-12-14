package p000a.p001a.p002a.p008d;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import p000a.p001a.p002a.p011g.C0029b;

/* renamed from: a.a.a.d.b */
public final class C0013b extends C0012c {
    /* renamed from: a */
    private Inflater f54a = new Inflater(true);
    /* renamed from: b */
    private byte[] f55b = new byte[4096];
    /* renamed from: c */
    private byte[] f56c = new byte[1];
    /* renamed from: d */
    private C0029b f57d;
    /* renamed from: e */
    private long f58e;
    /* renamed from: f */
    private long f59f;

    public C0013b(RandomAccessFile randomAccessFile, long j, C0029b c0029b) {
        super(randomAccessFile, j, c0029b);
        this.f57d = c0029b;
        this.f58e = 0;
        this.f59f = c0029b.mo166c().mo77e();
    }

    /* renamed from: c */
    private void m46c() {
        do {
        } while (super.read(new byte[1024], 0, 1024) != -1);
        mo27b();
    }

    /* renamed from: a */
    public final C0029b mo24a() {
        return super.mo24a();
    }

    public final int available() {
        return this.f54a.finished() ? 0 : 1;
    }

    public final void close() {
        this.f54a.end();
        super.close();
    }

    public final int read() {
        return read(this.f56c, 0, 1) == -1 ? -1 : this.f56c[0] & 255;
    }

    public final int read(byte[] bArr) {
        if (bArr != null) {
            return read(bArr, 0, bArr.length);
        }
        throw new NullPointerException("input buffer is null");
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("input buffer is null");
        } else if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            try {
                if (this.f58e >= this.f59f) {
                    m46c();
                    return -1;
                }
                while (true) {
                    int inflate = this.f54a.inflate(bArr, i, i2);
                    if (inflate != 0) {
                        this.f58e += (long) inflate;
                        return inflate;
                    } else if (this.f54a.finished() || this.f54a.needsDictionary()) {
                        m46c();
                    } else if (this.f54a.needsInput()) {
                        inflate = super.read(this.f55b, 0, this.f55b.length);
                        if (inflate == -1) {
                            throw new EOFException("Unexpected end of ZLIB input stream");
                        }
                        this.f54a.setInput(this.f55b, 0, inflate);
                    }
                }
                m46c();
                return -1;
            } catch (DataFormatException e) {
                DataFormatException dataFormatException = e;
                String str = "Invalid ZLIB data format";
                if (dataFormatException.getMessage() != null) {
                    str = dataFormatException.getMessage();
                }
                if (this.f57d != null && this.f57d.mo169f().mo113h() && this.f57d.mo169f().mo115j() == 0) {
                    str = new StringBuffer(String.valueOf(str)).append(" - Wrong Password?").toString();
                }
                throw new IOException(str);
            }
        }
    }

    public final long skip(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("negative skip length");
        }
        int min = (int) Math.min(j, 2147483647L);
        byte[] bArr = new byte[512];
        int i = 0;
        while (i < min) {
            int i2 = min - i;
            if (i2 > 512) {
                i2 = 512;
            }
            i2 = read(bArr, 0, i2);
            if (i2 == -1) {
                break;
            }
            i = i2 + i;
        }
        return (long) i;
    }
}
