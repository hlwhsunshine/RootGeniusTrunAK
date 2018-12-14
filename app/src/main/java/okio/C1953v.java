package okio;

import android.support.p015v4.media.session.PlaybackStateCompat;

/* renamed from: okio.v */
final class C1953v {
    /* renamed from: a */
    static C1952u f5842a;
    /* renamed from: b */
    static long f5843b;

    private C1953v() {
    }

    /* renamed from: a */
    static C1952u m5756a() {
        synchronized (C1953v.class) {
            if (f5842a != null) {
                C1952u c1952u = f5842a;
                f5842a = c1952u.f5840f;
                c1952u.f5840f = null;
                f5843b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return c1952u;
            }
            return new C1952u();
        }
    }

    /* renamed from: a */
    static void m5757a(C1952u c1952u) {
        if (c1952u.f5840f != null || c1952u.f5841g != null) {
            throw new IllegalArgumentException();
        } else if (!c1952u.f5838d) {
            synchronized (C1953v.class) {
                if (f5843b + PlaybackStateCompat.ACTION_PLAY_FROM_URI > 65536) {
                    return;
                }
                f5843b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                c1952u.f5840f = f5842a;
                c1952u.f5837c = 0;
                c1952u.f5836b = 0;
                f5842a = c1952u;
            }
        }
    }
}
