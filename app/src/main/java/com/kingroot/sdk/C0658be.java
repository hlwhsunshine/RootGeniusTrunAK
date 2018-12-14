package com.kingroot.sdk;

import android.content.Context;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kingroot.sdk.be */
public class C0658be {

    /* renamed from: com.kingroot.sdk.be$a */
    private static class C0655a implements Serializable {
        /* renamed from: j */
        int f1646j = 0;
        /* renamed from: l */
        int f1647l = 0;

        private C0655a() {
        }

        /* renamed from: a */
        static C0655a m1533a(C0771e c0771e) {
            if (c0771e == null) {
                return null;
            }
            C0655a c0655a = new C0655a();
            c0655a.f1646j = c0771e.f1877j;
            c0655a.f1647l = c0771e.f1878l;
            return c0655a;
        }

        /* renamed from: V */
        C0771e mo5640V() {
            C0771e c0771e = new C0771e();
            c0771e.f1877j = this.f1646j;
            c0771e.f1878l = this.f1647l;
            return c0771e;
        }
    }

    /* renamed from: com.kingroot.sdk.be$b */
    private static class C0656b implements Serializable {
        int action = 0;
        /* renamed from: cZ */
        List<C0655a> f1648cZ = null;
        /* renamed from: g */
        String f1649g = "";
        /* renamed from: l */
        int f1650l = 0;
        /* renamed from: v */
        int f1651v = 0;
        /* renamed from: w */
        int f1652w = 0;
        /* renamed from: x */
        int f1653x = 0;

        private C0656b() {
        }

        /* renamed from: a */
        static C0656b m1535a(C0837g c0837g) {
            if (c0837g == null) {
                return null;
            }
            C0656b c0656b = new C0656b();
            c0656b.f1649g = c0837g.f2090g;
            c0656b.action = c0837g.action;
            c0656b.f1650l = c0837g.f2091l;
            c0656b.f1651v = c0837g.f2093v;
            c0656b.f1652w = c0837g.f2094w;
            c0656b.f1653x = c0837g.f2095x;
            if (c0837g.f2092u == null) {
                return c0656b;
            }
            c0656b.f1648cZ = new ArrayList();
            Iterator it = c0837g.f2092u.iterator();
            while (it.hasNext()) {
                C0655a a = C0655a.m1533a((C0771e) it.next());
                if (a != null) {
                    c0656b.f1648cZ.add(a);
                }
            }
            return c0656b;
        }

        /* renamed from: W */
        C0837g mo5641W() {
            C0837g c0837g = new C0837g();
            c0837g.f2090g = this.f1649g;
            c0837g.action = this.action;
            c0837g.f2091l = this.f1650l;
            c0837g.f2093v = this.f1651v;
            c0837g.f2094w = this.f1652w;
            c0837g.f2095x = this.f1653x;
            if (this.f1648cZ != null) {
                c0837g.f2092u = new ArrayList();
                for (C0655a V : this.f1648cZ) {
                    c0837g.f2092u.add(V.mo5640V());
                }
            }
            return c0837g;
        }
    }

    /* renamed from: com.kingroot.sdk.be$c */
    private static class C0657c implements Serializable {
        /* renamed from: da */
        List<C0656b> f1654da = null;

        private C0657c() {
        }

        /* renamed from: d */
        static C0657c m1537d(C0866h c0866h) {
            if (c0866h == null) {
                return null;
            }
            C0657c c0657c = new C0657c();
            if (c0866h.f2156z == null) {
                return c0657c;
            }
            c0657c.f1654da = new ArrayList();
            Iterator it = c0866h.f2156z.iterator();
            while (it.hasNext()) {
                C0656b a = C0656b.m1535a((C0837g) it.next());
                if (a != null) {
                    c0657c.f1654da.add(a);
                }
            }
            return c0657c;
        }

        /* renamed from: X */
        C0866h mo5642X() {
            C0866h c0866h = new C0866h();
            if (this.f1654da != null) {
                c0866h.f2156z = new ArrayList();
                for (C0656b W : this.f1654da) {
                    c0866h.f2156z.add(W.mo5641W());
                }
            }
            return c0866h;
        }
    }

    /* renamed from: T */
    private static List<C0866h> m1539T() {
        Context context = C0741dg.m1804aL().f1805el;
        if (context == null) {
            return null;
        }
        try {
            List<C0657c> list = (List) C0700cf.m1686D(context.getFilesDir().getAbsolutePath() + File.separator + "clres.db").mo5679am();
            if (list != null) {
                List<C0866h> arrayList = new ArrayList();
                for (C0657c X : list) {
                    arrayList.add(X.mo5642X());
                }
                return arrayList;
            }
        } catch (Throwable th) {
            C0633at.m1459a(th);
        }
        return null;
    }

    /* renamed from: a */
    public static synchronized void m1541a(final C0866h c0866h) {
        synchronized (C0658be.class) {
            new C0650gj() {
                public final void run() {
                    List U = C0658be.m1539T();
                    if (U == null) {
                        U = new ArrayList();
                    }
                    if (c0866h != null) {
                        U.add(0, c0866h);
                    }
                    List list = null;
                    for (C0866h c0866h : U) {
                        if (C0658be.m1543b(c0866h)) {
                            if (C0769dy.m1914a(C0741dg.m1804aL().f1805el, c0866h) != 0) {
                                if (list == null) {
                                    list = new ArrayList();
                                }
                                list.add(c0866h);
                            } else {
                                C0703ci.m1691h("reportCloudCmdResult", "reportCloudCmdResult SUCCESS");
                            }
                        }
                    }
                    if (list != null && list.size() > 0) {
                        C0658be.m1542b(list);
                    }
                }
            }.mo5630bs();
        }
    }

    /* renamed from: b */
    private static void m1542b(List<C0866h> list) {
        Context context = C0741dg.m1804aL().f1805el;
        if (context != null) {
            C0698cd D = C0700cf.m1686D(context.getFilesDir().getAbsolutePath() + File.separator + "clres.db");
            List list2 = null;
            if (list != null) {
                for (C0866h d : list) {
                    List arrayList;
                    C0657c d2 = C0657c.m1537d(d);
                    if (d2 != null) {
                        arrayList = list2 == null ? new ArrayList() : list2;
                        arrayList.add(d2);
                    } else {
                        arrayList = list2;
                    }
                    list2 = arrayList;
                }
            }
            if (list2 != null) {
                try {
                    if (list2.size() > 0) {
                        D.mo5678a(list2);
                        return;
                    }
                } catch (Throwable th) {
                    C0633at.m1459a(th);
                    return;
                }
            }
            D.delete();
        }
    }

    /* renamed from: b */
    private static boolean m1543b(C0866h c0866h) {
        boolean z = false;
        if (!(c0866h == null || c0866h.f2156z == null)) {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            int size = c0866h.f2156z.size() - 1;
            while (size >= 0) {
                boolean z2;
                C0837g c0837g = (C0837g) c0866h.f2156z.get(size);
                if (c0837g == null || currentTimeMillis - c0837g.f2095x > 604800) {
                    c0866h.f2156z.remove(size);
                    z2 = z;
                } else {
                    z2 = true;
                }
                size--;
                z = z2;
            }
        }
        return z;
    }
}
