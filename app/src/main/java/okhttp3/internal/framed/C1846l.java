package okhttp3.internal.framed;

import java.io.IOException;
import okhttp3.internal.C1809k;
import okhttp3.internal.C1835i;
import okhttp3.internal.framed.C1837c.C1836c;

/* renamed from: okhttp3.internal.framed.l */
final class C1846l extends C1835i {
    /* renamed from: b */
    final /* synthetic */ C1856o f5443b;
    /* renamed from: c */
    final /* synthetic */ C1836c f5444c;

    C1846l(C1836c c1836c, String str, Object[] objArr, C1856o c1856o) {
        this.f5444c = c1836c;
        this.f5443b = c1856o;
        super(str, objArr);
    }

    /* renamed from: a */
    public final void mo8749a() {
        try {
            C1837c.this.f5404m.mo8680a(this.f5443b);
        } catch (Throwable e) {
            C1809k.m4984c().mo8687a(4, "FramedConnection.Listener failure for " + C1837c.this.f5406o, e);
            try {
                this.f5443b.mo8786a(ErrorCode.PROTOCOL_ERROR);
            } catch (IOException e2) {
            }
        }
    }
}
