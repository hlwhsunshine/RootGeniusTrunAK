package okhttp3.internal;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.C1793ad;

/* renamed from: okhttp3.internal.l */
public final class C1909l {
    /* renamed from: a */
    private final Set<C1793ad> f5673a = new LinkedHashSet();

    /* renamed from: a */
    public final synchronized void mo8877a(C1793ad c1793ad) {
        this.f5673a.add(c1793ad);
    }

    /* renamed from: b */
    public final synchronized void mo8878b(C1793ad c1793ad) {
        this.f5673a.remove(c1793ad);
    }

    /* renamed from: c */
    public final synchronized boolean mo8879c(C1793ad c1793ad) {
        return this.f5673a.contains(c1793ad);
    }
}
