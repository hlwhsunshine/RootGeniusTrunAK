package okhttp3.internal.framed;

import java.util.zip.Inflater;

/* renamed from: okhttp3.internal.framed.v */
final class C1871v extends Inflater {
    /* renamed from: a */
    final /* synthetic */ C1868t f5535a;

    C1871v(C1868t c1868t) {
        this.f5535a = c1868t;
    }

    public final int inflate(byte[] bArr, int i, int i2) {
        int inflate = super.inflate(bArr, i, i2);
        if (inflate != 0 || !needsDictionary()) {
            return inflate;
        }
        setDictionary(C1833aa.f5380a);
        return super.inflate(bArr, i, i2);
    }
}
