package okhttp3.internal.framed;

import okhttp3.internal.C1835i;

/* renamed from: okhttp3.internal.framed.j */
final class C1844j extends C1835i {
    /* renamed from: b */
    final /* synthetic */ int f5440b;
    /* renamed from: c */
    final /* synthetic */ ErrorCode f5441c;
    /* renamed from: d */
    final /* synthetic */ C1837c f5442d;

    C1844j(C1837c c1837c, String str, Object[] objArr, int i, ErrorCode errorCode) {
        this.f5442d = c1837c;
        this.f5440b = i;
        this.f5441c = errorCode;
        super(str, objArr);
    }

    /* renamed from: a */
    public final void mo8749a() {
        this.f5442d.f5413v.mo8818c();
        synchronized (this.f5442d) {
            this.f5442d.f5416y.remove(Integer.valueOf(this.f5440b));
        }
    }
}
