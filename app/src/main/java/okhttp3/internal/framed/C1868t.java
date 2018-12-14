package okhttp3.internal.framed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;
import okio.C1938h;
import okio.C1944m;
import okio.C1945n;

/* renamed from: okhttp3.internal.framed.t */
final class C1868t {
    /* renamed from: a */
    private final C1944m f5530a;
    /* renamed from: b */
    private int f5531b;
    /* renamed from: c */
    private final C1938h f5532c = C1945n.m5708a(this.f5530a);

    public C1868t(C1938h c1938h) {
        this.f5530a = new C1944m(new C1870u(this, c1938h), new C1871v(this));
    }

    /* renamed from: b */
    private ByteString m5283b() {
        return this.f5532c.mo9026c((long) this.f5532c.mo9034i());
    }

    /* renamed from: a */
    public final List<C1857p> mo8808a(int i) {
        this.f5531b += i;
        int i2 = this.f5532c.mo9034i();
        if (i2 < 0) {
            throw new IOException("numberOfPairs < 0: " + i2);
        } else if (i2 > 1024) {
            throw new IOException("numberOfPairs > 1024: " + i2);
        } else {
            List<C1857p> arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                ByteString toAsciiLowercase = m5283b().toAsciiLowercase();
                ByteString b = m5283b();
                if (toAsciiLowercase.size() == 0) {
                    throw new IOException("name.size == 0");
                }
                arrayList.add(new C1857p(toAsciiLowercase, b));
            }
            if (this.f5531b > 0) {
                this.f5530a.mo9073b();
                if (this.f5531b != 0) {
                    throw new IOException("compressedLimit > 0: " + this.f5531b);
                }
            }
            return arrayList;
        }
    }

    /* renamed from: a */
    public final void mo8809a() {
        this.f5532c.close();
    }
}
