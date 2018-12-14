package okhttp3.internal.framed;

import java.io.IOException;
import okhttp3.internal.C1835i;
import okhttp3.internal.framed.C1837c.C1836c;

/* renamed from: okhttp3.internal.framed.n */
final class C1848n extends C1835i {
    /* renamed from: b */
    final /* synthetic */ C1875z f5446b;
    /* renamed from: c */
    final /* synthetic */ C1836c f5447c;

    C1848n(C1836c c1836c, String str, Object[] objArr, C1875z c1875z) {
        this.f5447c = c1836c;
        this.f5446b = c1875z;
        super(str, objArr);
    }

    /* renamed from: a */
    public final void mo8749a() {
        try {
            C1837c.this.f5402i.mo8735a(this.f5446b);
        } catch (IOException e) {
        }
    }
}
