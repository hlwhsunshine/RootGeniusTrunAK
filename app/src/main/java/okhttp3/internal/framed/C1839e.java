package okhttp3.internal.framed;

import java.io.IOException;
import okhttp3.internal.C1835i;

/* renamed from: okhttp3.internal.framed.e */
final class C1839e extends C1835i {
    /* renamed from: b */
    final /* synthetic */ int f5420b;
    /* renamed from: c */
    final /* synthetic */ long f5421c;
    /* renamed from: d */
    final /* synthetic */ C1837c f5422d;

    C1839e(C1837c c1837c, String str, Object[] objArr, int i, long j) {
        this.f5422d = c1837c;
        this.f5420b = i;
        this.f5421c = j;
        super(str, objArr);
    }

    /* renamed from: a */
    public final void mo8749a() {
        try {
            this.f5422d.f5402i.mo8732a(this.f5420b, this.f5421c);
        } catch (IOException e) {
        }
    }
}
