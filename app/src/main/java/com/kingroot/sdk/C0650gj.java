package com.kingroot.sdk;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kingroot.sdk.gj */
public class C0650gj implements Runnable {
    /* renamed from: jF */
    private static List<Thread> f1637jF = new ArrayList(8);
    /* renamed from: gr */
    private final Object f1638gr = new Object();
    /* renamed from: jG */
    private volatile C0652b f1639jG = null;

    /* renamed from: com.kingroot.sdk.gj$a */
    public interface C0651a {
        /* renamed from: cj */
        List<Object> mo5635cj();

        boolean isRunning();
    }

    /* renamed from: com.kingroot.sdk.gj$b */
    public abstract class C0652b extends Thread implements C0651a {
        /* renamed from: gq */
        private List<Object> f1640gq;
        /* renamed from: jJ */
        private AtomicBoolean f1642jJ;

        public C0652b(List<Object> list) {
            if (list != null) {
                this.f1640gq = new ArrayList();
                this.f1640gq.addAll(list);
            }
            this.f1642jJ = new AtomicBoolean();
            this.f1642jJ.set(false);
        }

        /* renamed from: b */
        public abstract void mo5637b(C0651a c0651a);

        /* renamed from: cj */
        public List<Object> mo5635cj() {
            if (this.f1640gq == null) {
                this.f1640gq = new ArrayList();
            }
            return this.f1640gq;
        }

        public void interrupt() {
            this.f1642jJ.set(false);
            super.interrupt();
        }

        public boolean isRunning() {
            return this.f1642jJ.get();
        }

        public void run() {
            this.f1642jJ.set(true);
            try {
                mo5637b(this);
            } finally {
                this.f1642jJ.set(false);
            }
        }
    }

    /* renamed from: a */
    public void mo5628a(C0651a c0651a) {
        run();
    }

    /* renamed from: a */
    public boolean mo5629a(String str, int i, List<Object> list, final boolean z) {
        boolean z2 = false;
        if (this.f1639jG == null) {
            synchronized (this.f1638gr) {
                if (this.f1639jG == null) {
                    this.f1639jG = new C0652b(this, list) {
                        /* renamed from: b */
                        public void mo5637b(C0651a c0651a) {
                            try {
                                synchronized (this) {
                                    this.mo5628a(c0651a);
                                }
                                if (c0651a.isRunning()) {
                                    synchronized (this.f1638gr) {
                                        if (z) {
                                            C0650gj.f1637jF.remove(this.f1639jG);
                                        }
                                        this.f1639jG = null;
                                    }
                                }
                            } catch (Exception e) {
                                try {
                                    e.printStackTrace();
                                    if (c0651a.isRunning()) {
                                        synchronized (this.f1638gr) {
                                            if (z) {
                                                C0650gj.f1637jF.remove(this.f1639jG);
                                            }
                                            this.f1639jG = null;
                                        }
                                    }
                                } catch (Throwable th) {
                                    if (c0651a.isRunning()) {
                                        synchronized (this.f1638gr) {
                                            if (z) {
                                                C0650gj.f1637jF.remove(this.f1639jG);
                                            }
                                            this.f1639jG = null;
                                        }
                                    }
                                }
                            }
                        }
                    };
                    C0652b c0652b = this.f1639jG;
                    if (str == null) {
                        str = "SingleThread";
                    }
                    c0652b.setName(str);
                    this.f1639jG.setPriority(i);
                    this.f1639jG.setDaemon(true);
                    this.f1639jG.start();
                    if (z) {
                        f1637jF.add(this.f1639jG);
                    }
                    z2 = true;
                }
            }
        }
        return z2;
    }

    /* renamed from: bs */
    public boolean mo5630bs() {
        return mo5629a(null, 5, null, false);
    }

    /* renamed from: ch */
    public void mo5631ch() {
        if (this.f1639jG != null) {
            synchronized (this.f1638gr) {
                if (this.f1639jG != null) {
                    Thread thread = this.f1639jG;
                    this.f1639jG = null;
                    thread.interrupt();
                }
            }
        }
    }

    /* renamed from: j */
    public boolean mo5632j(boolean z) {
        return mo5629a(null, 5, null, z);
    }

    /* renamed from: m */
    public boolean mo5633m(List<Object> list) {
        return mo5629a(null, 5, list, false);
    }

    public void run() {
    }
}
