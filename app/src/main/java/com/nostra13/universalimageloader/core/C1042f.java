package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.p067c.C1026a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.nostra13.universalimageloader.core.f */
final class C1042f {
    /* renamed from: a */
    final C1041e f2650a;
    /* renamed from: b */
    private Executor f2651b;
    /* renamed from: c */
    private Executor f2652c;
    /* renamed from: d */
    private Executor f2653d;
    /* renamed from: e */
    private final Map<Integer, String> f2654e = Collections.synchronizedMap(new HashMap());
    /* renamed from: f */
    private final Map<String, ReentrantLock> f2655f = new WeakHashMap();
    /* renamed from: g */
    private final AtomicBoolean f2656g = new AtomicBoolean(false);
    /* renamed from: h */
    private final AtomicBoolean f2657h = new AtomicBoolean(false);
    /* renamed from: i */
    private final AtomicBoolean f2658i = new AtomicBoolean(false);
    /* renamed from: j */
    private final Object f2659j = new Object();

    C1042f(C1041e c1041e) {
        this.f2650a = c1041e;
        this.f2651b = c1041e.f2636g;
        this.f2652c = c1041e.f2637h;
        this.f2653d = C1009a.m2871a();
    }

    /* renamed from: e */
    private void m3023e() {
        if (!this.f2650a.f2638i && ((ExecutorService) this.f2651b).isShutdown()) {
            this.f2651b = m3024f();
        }
        if (!this.f2650a.f2639j && ((ExecutorService) this.f2652c).isShutdown()) {
            this.f2652c = m3024f();
        }
    }

    /* renamed from: f */
    private Executor m3024f() {
        return C1009a.m2872a(this.f2650a.f2640k, this.f2650a.f2641l, this.f2650a.f2642m);
    }

    /* renamed from: a */
    final String mo6296a(C1026a c1026a) {
        return (String) this.f2654e.get(Integer.valueOf(c1026a.mo6258f()));
    }

    /* renamed from: a */
    final AtomicBoolean mo6297a() {
        return this.f2656g;
    }

    /* renamed from: a */
    final ReentrantLock mo6298a(String str) {
        ReentrantLock reentrantLock = (ReentrantLock) this.f2655f.get(str);
        if (reentrantLock != null) {
            return reentrantLock;
        }
        reentrantLock = new ReentrantLock();
        this.f2655f.put(str, reentrantLock);
        return reentrantLock;
    }

    /* renamed from: a */
    final void mo6299a(LoadAndDisplayImageTask loadAndDisplayImageTask) {
        this.f2653d.execute(new C1043g(this, loadAndDisplayImageTask));
    }

    /* renamed from: a */
    final void mo6300a(C1026a c1026a, String str) {
        this.f2654e.put(Integer.valueOf(c1026a.mo6258f()), str);
    }

    /* renamed from: a */
    final void mo6301a(C1048l c1048l) {
        m3023e();
        this.f2652c.execute(c1048l);
    }

    /* renamed from: a */
    final void mo6302a(Runnable runnable) {
        this.f2653d.execute(runnable);
    }

    /* renamed from: b */
    final Object mo6303b() {
        return this.f2659j;
    }

    /* renamed from: b */
    final void mo6304b(C1026a c1026a) {
        this.f2654e.remove(Integer.valueOf(c1026a.mo6258f()));
    }

    /* renamed from: c */
    final boolean mo6305c() {
        return this.f2657h.get();
    }

    /* renamed from: d */
    final boolean mo6306d() {
        return this.f2658i.get();
    }
}
