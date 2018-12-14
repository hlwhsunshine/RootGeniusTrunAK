package okio;

import android.support.p015v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: okio.t */
final class C1951t extends InputStream {
    /* renamed from: a */
    final /* synthetic */ C1950s f5834a;

    C1951t(C1950s c1950s) {
        this.f5834a = c1950s;
    }

    public final int available() {
        if (!this.f5834a.f5833c) {
            return (int) Math.min(this.f5834a.f5831a.f5807b, 2147483647L);
        }
        throw new IOException("closed");
    }

    public final void close() {
        this.f5834a.close();
    }

    public final int read() {
        if (!this.f5834a.f5833c) {
            return (this.f5834a.f5831a.f5807b == 0 && this.f5834a.f5832b.mo8763a(this.f5834a.f5831a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) ? -1 : this.f5834a.f5831a.mo9032g() & 255;
        } else {
            throw new IOException("closed");
        }
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (this.f5834a.f5833c) {
            throw new IOException("closed");
        }
        C1933aa.m5591a((long) bArr.length, (long) i, (long) i2);
        return (this.f5834a.f5831a.f5807b == 0 && this.f5834a.f5832b.mo8763a(this.f5834a.f5831a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) ? -1 : this.f5834a.f5831a.mo9040a(bArr, i, i2);
    }

    public final String toString() {
        return this.f5834a + ".inputStream()";
    }
}
