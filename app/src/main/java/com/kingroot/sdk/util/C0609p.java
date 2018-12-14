package com.kingroot.sdk.util;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kingroot.sdk.util.p */
public abstract class C0609p implements Runnable {
    /* renamed from: gp */
    private volatile Thread f1491gp = null;
    /* renamed from: gq */
    private volatile List<Object> f1492gq = null;
    /* renamed from: gr */
    private final Object f1493gr = new Object();

    /* renamed from: com.kingroot.sdk.util.p$1 */
    class C06101 implements Runnable {
        C06101() {
        }

        public void run() {
            try {
                C0609p.this.run();
                if (C0609p.this.f1492gq != null) {
                    C0609p.this.f1492gq.clear();
                    C0609p.this.f1492gq = null;
                }
                synchronized (C0609p.this.f1493gr) {
                    C0609p.this.f1491gp = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (C0609p.this.f1492gq != null) {
                    C0609p.this.f1492gq.clear();
                    C0609p.this.f1492gq = null;
                }
                synchronized (C0609p.this.f1493gr) {
                    C0609p.this.f1491gp = null;
                }
            } catch (Throwable th) {
                if (C0609p.this.f1492gq != null) {
                    C0609p.this.f1492gq.clear();
                    C0609p.this.f1492gq = null;
                }
                synchronized (C0609p.this.f1493gr) {
                    C0609p.this.f1491gp = null;
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo5589a(String str, int i, List<Object> list) {
        boolean z = false;
        if (this.f1491gp == null) {
            synchronized (this.f1493gr) {
                if (this.f1491gp == null) {
                    this.f1491gp = new Thread(new C06101());
                    if (list != null) {
                        this.f1492gq = new ArrayList();
                        this.f1492gq.addAll(list);
                    }
                    Thread thread = this.f1491gp;
                    if (str == null) {
                        str = "SingleThreadHandler";
                    }
                    thread.setName(str);
                    this.f1491gp.setPriority(i);
                    this.f1491gp.setDaemon(true);
                    this.f1491gp.start();
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: bs */
    public boolean mo5590bs() {
        return mo5589a(null, 5, null);
    }
}
