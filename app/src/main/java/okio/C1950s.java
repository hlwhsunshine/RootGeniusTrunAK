package okio;

import android.support.p015v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.InputStream;

/* renamed from: okio.s */
final class C1950s implements C1938h {
    /* renamed from: a */
    public final C1939e f5831a = new C1939e();
    /* renamed from: b */
    public final C1850x f5832b;
    /* renamed from: c */
    boolean f5833c;

    C1950s(C1850x c1850x) {
        if (c1850x == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f5832b = c1850x;
    }

    /* renamed from: b */
    private boolean m5734b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f5833c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.f5831a.f5807b < j) {
                if (this.f5832b.mo8763a(this.f5831a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    public final long mo9024a(byte b) {
        long j = 0;
        if (this.f5833c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long a = this.f5831a.mo9041a(b, j);
            if (a != -1) {
                return a;
            }
            a = this.f5831a.f5807b;
            if (this.f5832b.mo8763a(this.f5831a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            j = Math.max(j, a);
        }
    }

    /* renamed from: a */
    public final long mo8763a(C1939e c1939e, long j) {
        if (c1939e == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f5833c) {
            throw new IllegalStateException("closed");
        } else if (this.f5831a.f5807b == 0 && this.f5832b.mo8763a(this.f5831a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        } else {
            return this.f5831a.mo8763a(c1939e, Math.min(j, this.f5831a.f5807b));
        }
    }

    /* renamed from: a */
    public final C1852y mo8764a() {
        return this.f5832b.mo8764a();
    }

    /* renamed from: a */
    public final void mo9025a(long j) {
        if (!m5734b(j)) {
            throw new EOFException();
        }
    }

    /* renamed from: c */
    public final ByteString mo9026c(long j) {
        mo9025a(j);
        return this.f5831a.mo9026c(j);
    }

    /* renamed from: c */
    public final C1939e mo9027c() {
        return this.f5831a;
    }

    public final void close() {
        if (!this.f5833c) {
            this.f5833c = true;
            this.f5832b.close();
            this.f5831a.mo9063q();
        }
    }

    /* renamed from: e */
    public final boolean mo9028e() {
        if (!this.f5833c) {
            return this.f5831a.mo9028e() && this.f5832b.mo8763a(this.f5831a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    /* renamed from: e */
    public final byte[] mo9029e(long j) {
        mo9025a(j);
        return this.f5831a.mo9029e(j);
    }

    /* renamed from: f */
    public final InputStream mo9030f() {
        return new C1951t(this);
    }

    /* renamed from: f */
    public final void mo9031f(long j) {
        if (this.f5833c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f5831a.f5807b == 0 && this.f5832b.mo8763a(this.f5831a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f5831a.f5807b);
            this.f5831a.mo9031f(min);
            j -= min;
        }
    }

    /* renamed from: g */
    public final byte mo9032g() {
        mo9025a(1);
        return this.f5831a.mo9032g();
    }

    /* renamed from: h */
    public final short mo9033h() {
        mo9025a(2);
        return this.f5831a.mo9033h();
    }

    /* renamed from: i */
    public final int mo9034i() {
        mo9025a(4);
        return this.f5831a.mo9034i();
    }

    /* renamed from: j */
    public final short mo9035j() {
        mo9025a(2);
        return C1933aa.m5590a(this.f5831a.mo9033h());
    }

    /* renamed from: k */
    public final int mo9036k() {
        mo9025a(4);
        return C1933aa.m5589a(this.f5831a.mo9034i());
    }

    /* renamed from: l */
    public final long mo9037l() {
        mo9025a(1);
        for (int i = 0; m5734b((long) (i + 1)); i++) {
            byte b = this.f5831a.mo9048b((long) i);
            if ((b < (byte) 48 || b > (byte) 57) && ((b < (byte) 97 || b > (byte) 102) && (b < (byte) 65 || b > (byte) 70))) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b)}));
                }
                return this.f5831a.mo9037l();
            }
        }
        return this.f5831a.mo9037l();
    }

    /* renamed from: o */
    public final String mo9038o() {
        long a = mo9024a((byte) 10);
        if (a != -1) {
            return this.f5831a.mo9054d(a);
        }
        C1939e c1939e = new C1939e();
        this.f5831a.mo9046a(c1939e, 0, Math.min(32, this.f5831a.f5807b));
        throw new EOFException("\\n not found: size=" + this.f5831a.f5807b + " content=" + c1939e.mo9061m().hex() + "…");
    }

    /* renamed from: p */
    public final byte[] mo9039p() {
        this.f5831a.mo9011a(this.f5832b);
        return this.f5831a.mo9039p();
    }

    public final String toString() {
        return "buffer(" + this.f5832b + ")";
    }
}
