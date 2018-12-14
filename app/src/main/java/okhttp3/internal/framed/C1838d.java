package okhttp3.internal.framed;

import java.io.IOException;
import okhttp3.internal.C1835i;

/* renamed from: okhttp3.internal.framed.d */
final class C1838d extends C1835i {
    /* renamed from: b */
    final /* synthetic */ int f5417b;
    /* renamed from: c */
    final /* synthetic */ ErrorCode f5418c;
    /* renamed from: d */
    final /* synthetic */ C1837c f5419d;

    C1838d(C1837c c1837c, String str, Object[] objArr, int i, ErrorCode errorCode) {
        this.f5419d = c1837c;
        this.f5417b = i;
        this.f5418c = errorCode;
        super(str, objArr);
    }

    /* renamed from: a */
    public final void mo8749a() {
        try {
            this.f5419d.mo8759b(this.f5417b, this.f5418c);
        } catch (IOException e) {
        }
    }
}
