package okhttp3.internal.p122a;

import java.io.File;
import java.io.IOException;

/* renamed from: okhttp3.internal.a.b */
final class C1806b implements C1805a {
    C1806b() {
    }

    /* renamed from: a */
    public final void mo8678a(File file) {
        if (!file.delete() && file.exists()) {
            throw new IOException("failed to delete " + file);
        }
    }
}
