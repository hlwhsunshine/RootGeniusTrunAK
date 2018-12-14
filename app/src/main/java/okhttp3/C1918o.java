package okhttp3;

import java.util.ArrayDeque;
import java.util.Deque;

/* renamed from: okhttp3.o */
public final class C1918o {
    /* renamed from: a */
    private int f5708a = 64;
    /* renamed from: b */
    private int f5709b = 5;
    /* renamed from: c */
    private final Deque<Object> f5710c = new ArrayDeque();
    /* renamed from: d */
    private final Deque<Object> f5711d = new ArrayDeque();
    /* renamed from: e */
    private final Deque<C1930x> f5712e = new ArrayDeque();

    /* renamed from: a */
    final synchronized void mo8902a(C1799f c1799f) {
        if (!this.f5712e.remove(c1799f)) {
            throw new AssertionError("Call wasn't in-flight!");
        }
    }

    /* renamed from: a */
    final synchronized void mo8903a(C1930x c1930x) {
        this.f5712e.add(c1930x);
    }
}
