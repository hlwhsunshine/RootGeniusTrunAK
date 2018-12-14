package okhttp3.internal.framed;

import java.io.IOException;
import java.util.List;
import okhttp3.internal.C1835i;

/* renamed from: okhttp3.internal.framed.g */
final class C1841g extends C1835i {
    /* renamed from: b */
    final /* synthetic */ int f5428b;
    /* renamed from: c */
    final /* synthetic */ List f5429c;
    /* renamed from: d */
    final /* synthetic */ C1837c f5430d;

    C1841g(C1837c c1837c, String str, Object[] objArr, int i, List list) {
        this.f5430d = c1837c;
        this.f5428b = i;
        this.f5429c = list;
        super(str, objArr);
    }

    /* renamed from: a */
    public final void mo8749a() {
        this.f5430d.f5413v.mo8815a();
        try {
            this.f5430d.f5402i.mo8733a(this.f5428b, ErrorCode.CANCEL);
            synchronized (this.f5430d) {
                this.f5430d.f5416y.remove(Integer.valueOf(this.f5428b));
            }
        } catch (IOException e) {
        }
    }
}
