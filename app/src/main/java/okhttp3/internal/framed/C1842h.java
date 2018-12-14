package okhttp3.internal.framed;

import java.io.IOException;
import java.util.List;
import okhttp3.internal.C1835i;

/* renamed from: okhttp3.internal.framed.h */
final class C1842h extends C1835i {
    /* renamed from: b */
    final /* synthetic */ int f5431b;
    /* renamed from: c */
    final /* synthetic */ List f5432c;
    /* renamed from: d */
    final /* synthetic */ boolean f5433d;
    /* renamed from: e */
    final /* synthetic */ C1837c f5434e;

    C1842h(C1837c c1837c, String str, Object[] objArr, int i, List list, boolean z) {
        this.f5434e = c1837c;
        this.f5431b = i;
        this.f5432c = list;
        this.f5433d = z;
        super(str, objArr);
    }

    /* renamed from: a */
    public final void mo8749a() {
        this.f5434e.f5413v.mo8817b();
        try {
            this.f5434e.f5402i.mo8733a(this.f5431b, ErrorCode.CANCEL);
            synchronized (this.f5434e) {
                this.f5434e.f5416y.remove(Integer.valueOf(this.f5431b));
            }
        } catch (IOException e) {
        }
    }
}
