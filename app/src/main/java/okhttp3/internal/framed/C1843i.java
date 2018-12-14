package okhttp3.internal.framed;

import java.io.IOException;
import okhttp3.internal.C1835i;
import okio.C1939e;

/* renamed from: okhttp3.internal.framed.i */
final class C1843i extends C1835i {
    /* renamed from: b */
    final /* synthetic */ int f5435b;
    /* renamed from: c */
    final /* synthetic */ C1939e f5436c;
    /* renamed from: d */
    final /* synthetic */ int f5437d;
    /* renamed from: e */
    final /* synthetic */ boolean f5438e;
    /* renamed from: f */
    final /* synthetic */ C1837c f5439f;

    C1843i(C1837c c1837c, String str, Object[] objArr, int i, C1939e c1939e, int i2, boolean z) {
        this.f5439f = c1837c;
        this.f5435b = i;
        this.f5436c = c1939e;
        this.f5437d = i2;
        this.f5438e = z;
        super(str, objArr);
    }

    /* renamed from: a */
    public final void mo8749a() {
        try {
            this.f5439f.f5413v.mo8816a(this.f5436c, this.f5437d);
            this.f5439f.f5402i.mo8733a(this.f5435b, ErrorCode.CANCEL);
            synchronized (this.f5439f) {
                this.f5439f.f5416y.remove(Integer.valueOf(this.f5435b));
            }
        } catch (IOException e) {
        }
    }
}
