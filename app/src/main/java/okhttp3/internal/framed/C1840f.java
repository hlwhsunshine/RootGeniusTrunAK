package okhttp3.internal.framed;

import java.io.IOException;
import okhttp3.internal.C1835i;

/* renamed from: okhttp3.internal.framed.f */
final class C1840f extends C1835i {
    /* renamed from: b */
    final /* synthetic */ boolean f5423b = true;
    /* renamed from: c */
    final /* synthetic */ int f5424c;
    /* renamed from: d */
    final /* synthetic */ int f5425d;
    /* renamed from: e */
    final /* synthetic */ C1872w f5426e;
    /* renamed from: f */
    final /* synthetic */ C1837c f5427f;

    C1840f(C1837c c1837c, String str, Object[] objArr, int i, int i2) {
        this.f5427f = c1837c;
        this.f5424c = i;
        this.f5425d = i2;
        this.f5426e = null;
        super(str, objArr);
    }

    /* renamed from: a */
    public final void mo8749a() {
        try {
            C1837c.m5126a(this.f5427f, this.f5423b, this.f5424c, this.f5425d, this.f5426e);
        } catch (IOException e) {
        }
    }
}
