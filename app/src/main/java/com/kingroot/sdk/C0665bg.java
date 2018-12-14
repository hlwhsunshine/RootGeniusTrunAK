package com.kingroot.sdk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.kingroot.sdk.C0667bi.C0647a;
import com.kingroot.sdk.util.C0899s;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.kingroot.sdk.bg */
public final class C0665bg {
    /* renamed from: dd */
    private static volatile C0665bg f1662dd = null;
    /* renamed from: de */
    private final ConcurrentLinkedQueue<C0802f> f1663de = new ConcurrentLinkedQueue();
    /* renamed from: df */
    private final ConcurrentLinkedQueue<C0802f> f1664df = new ConcurrentLinkedQueue();
    /* renamed from: dg */
    private C0650gj f1665dg = new C06611();
    /* renamed from: dh */
    private C0650gj f1666dh = new C06632();

    /* renamed from: com.kingroot.sdk.bg$1 */
    class C06611 extends C0650gj {

        /* renamed from: com.kingroot.sdk.bg$1$1 */
        class C06601 implements C0647a<Object> {
            C06601() {
            }

            /* renamed from: a */
            public Object mo5626a(List<Object> list) {
                C0665bg.this.m1562aa();
                return null;
            }
        }

        C06611() {
        }

        public void run() {
            C0667bi.m1577a(new C06601(), new Object[0]);
        }
    }

    /* renamed from: com.kingroot.sdk.bg$2 */
    class C06632 extends C0650gj {

        /* renamed from: com.kingroot.sdk.bg$2$1 */
        class C06621 implements C0647a<Object> {
            C06621() {
            }

            /* renamed from: a */
            public Object mo5626a(List<Object> list) {
                try {
                    synchronized (C0665bg.this.f1663de) {
                        ArrayList c = C0665bg.this.m1563ab();
                        if (c != null && c.size() > 0) {
                            C0866h c0866h = new C0866h();
                            c0866h.f2156z = c;
                            C0658be.m1541a(c0866h);
                        }
                    }
                    C0665bg.this.f1663de.clear();
                } catch (Throwable e) {
                    try {
                        C0633at.m1459a(e);
                    } finally {
                        C0665bg.this.f1663de.clear();
                    }
                }
                return null;
            }
        }

        C06632() {
        }

        public void run() {
            C0667bi.m1577a(new C06621(), new Object[0]);
        }
    }

    /* renamed from: com.kingroot.sdk.bg$3 */
    class C06643 implements C0647a<ArrayList<C0837g>> {
        C06643() {
        }

        /* renamed from: f */
        public ArrayList<C0837g> mo5626a(List<Object> list) {
            ArrayList<C0837g> arrayList = new ArrayList();
            Iterator it = C0665bg.this.f1663de.iterator();
            while (it.hasNext()) {
                try {
                    Collection a = C0665bg.this.m1568c((C0802f) it.next());
                    if (a != null) {
                        arrayList.addAll(a);
                    }
                } catch (Exception e) {
                }
            }
            C0665bg.this.f1663de.clear();
            return arrayList;
        }
    }

    private C0665bg() {
    }

    /* renamed from: Z */
    public static C0665bg m1554Z() {
        if (f1662dd == null) {
            synchronized (C0665bg.class) {
                if (f1662dd == null) {
                    f1662dd = new C0665bg();
                }
            }
        }
        return f1662dd;
    }

    /* renamed from: a */
    private C0837g m1555a(String str, C0732d c0732d, int i) {
        C0633at.m1463g("runAttackCloudCmd(), tipsId:" + str);
        if (c0732d == null) {
            return null;
        }
        C0668bj a = C0666bh.m1576a(c0732d, str);
        if (a == null) {
            return null;
        }
        if (a.mo5648ad() && C0659bf.m1548c(true) == null) {
            this.f1664df.add(m1564b(str, c0732d, i));
            return null;
        }
        int ac = a.mo5647ac();
        if (ac != 1) {
            this.f1664df.add(m1564b(str, c0732d, i));
        }
        C0703ci.m1691h("runAttackCloudCmd", "mCloudInfoNeedsRootList.size() = " + this.f1664df.size());
        if (c0732d.f1784h == 350) {
            return null;
        }
        C0633at.m1463g("runAttackCloudCmd, res:" + ac);
        return C0671bk.m1590a(str, c0732d.f1786j, 0, 3, 0, ac);
    }

    /* renamed from: a */
    private C0837g m1556a(String str, C0732d c0732d, C0802f c0802f) {
        String str2 = "runGeneralCloudCmd";
        if (str == null || c0732d == null || c0802f == null) {
            return null;
        }
        C0703ci.m1691h(str2, "tipSid:" + str + ";cmdid:" + c0732d.f1784h);
        switch (c0732d.f1784h) {
            case 20:
            case 24:
                List c = C0671bk.m1595c(str, c0732d);
                C0703ci.m1691h(str2, "HaveNewGeneralCmd:" + (c == null ? "(null)" : Integer.valueOf(c.size())));
                m1572e(c);
                return null;
            case 353:
                return C0671bk.m1592a(str, c0732d);
            case 354:
                return C0671bk.m1594b(str, c0732d);
            default:
                return C0671bk.m1590a(str, c0732d.f1786j, 0, 3, 0, 2);
        }
    }

    /* renamed from: a */
    private ArrayList<C0802f> m1557a(C0878t c0878t) {
        ArrayList<C0802f> arrayList = new ArrayList();
        ArrayList arrayList2 = c0878t.f2197a;
        if (arrayList2 != null && arrayList2.size() > 0) {
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                C0802f c0802f = (C0802f) arrayList2.get(size);
                if (c0802f == null || c0802f.f2038p == null) {
                    arrayList2.remove(size);
                } else if (c0802f.f2038p.size() != 0) {
                    C0732d c0732d = (C0732d) c0802f.f2038p.get(0);
                    if (c0732d != null) {
                        if (m1570d(c0802f)) {
                            switch (c0732d.f1784h) {
                                case 1:
                                case 3:
                                case 4:
                                case 6:
                                case 9:
                                case 350:
                                    arrayList.add(c0802f);
                                    arrayList2.remove(size);
                                    break;
                                default:
                                    break;
                            }
                        }
                        arrayList2.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<C0837g> m1559a(C0802f c0802f) {
        return (c0802f != null && m1570d(c0802f)) ? m1565b(c0802f) : null;
    }

    /* renamed from: a */
    private void m1561a(List<C0802f> list, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (C0802f c0802f : list) {
                int i2 = 1;
                if (!m1573e(c0802f)) {
                    i2 = 2;
                }
                arrayList.add(C0671bk.m1591a(c0802f.f2035m.f1708g, 0, i, 0, null, i2));
            }
            if (arrayList.size() > 0) {
                C0866h c0866h = new C0866h();
                c0866h.f2156z = arrayList;
                C0658be.m1541a(c0866h);
            }
        }
    }

    /* renamed from: aa */
    private void m1562aa() {
        String str = "doCheckCloudCmd";
        C0703ci.m1691h(str, str);
        Context context = C0741dg.m1804aL().f1805el;
        if (context == null) {
            C0703ci.m1691h(str, "null appContext");
            return;
        }
        AtomicReference atomicReference = new AtomicReference();
        if (C0769dy.m1915a(context, atomicReference) == 0) {
            C0703ci.m1691h(str, "success");
            C0646bc.m1513b(System.currentTimeMillis());
            C0878t c0878t = (C0878t) atomicReference.get();
            if (c0878t != null) {
                if (c0878t.f2197a == null || c0878t.f2197a.size() <= 0) {
                    C0703ci.m1691h(str, "木有云指令下发");
                } else {
                    C0703ci.m1691h(str, "有云指令下发");
                }
                m1571e(System.currentTimeMillis() + C0646bc.m1511R());
                String str2 = c0878t.f2199aj;
                if (TextUtils.isEmpty(str2) || C0646bc.m1512S().equals(str2)) {
                    C0703ci.m1690g(str, "LastTipId:" + C0646bc.m1512S() + ", newTipId:" + str2);
                    C0703ci.m1691h(str, "云指令单号为空或者和最近执行的云指令单号相同，不执行");
                    return;
                }
                m1561a(c0878t.f2197a, 0);
                C0646bc.m1516y(str2);
                C0703ci.m1690g(str, "newTipId:" + str2);
                m1569d(m1557a(c0878t));
                m1572e(c0878t.f2197a);
                if (this.f1663de != null && this.f1663de.size() > 0) {
                    mo5645e(false);
                    return;
                }
                return;
            }
            return;
        }
        C0703ci.m1691h(str, "failed");
    }

    /* renamed from: ab */
    private ArrayList<C0837g> m1563ab() {
        return this.f1663de.size() > 0 ? (ArrayList) C0667bi.m1577a(new C06643(), new Object[0]) : null;
    }

    /* renamed from: b */
    private C0802f m1564b(String str, C0732d c0732d, int i) {
        C0802f c0802f = new C0802f();
        c0802f.f2038p = new ArrayList();
        c0802f.f2038p.add(c0732d);
        c0802f.f2035m = new C0695c();
        c0802f.f2035m.f1708g = str;
        c0802f.f2036n = new C0879u();
        c0802f.f2036n.f2202al = i;
        return c0802f;
    }

    /* renamed from: b */
    private List<C0837g> m1565b(C0802f c0802f) {
        if (c0802f == null) {
            return null;
        }
        String str = c0802f.f2035m.f1708g;
        ArrayList arrayList = c0802f.f2038p;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        List<C0837g> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                C0837g a = m1556a(str, (C0732d) it.next(), c0802f);
                if (a != null) {
                    arrayList2.add(a);
                }
            } catch (Throwable e) {
                C0633at.m1459a(e);
            }
        }
        return arrayList2;
    }

    /* renamed from: c */
    private List<C0837g> m1568c(C0802f c0802f) {
        if (c0802f == null) {
            return null;
        }
        List<C0837g> arrayList = new ArrayList();
        List<C0732d> list = c0802f.f2038p;
        if (list != null && list.size() > 0) {
            for (C0732d a : list) {
                try {
                    C0837g a2 = m1555a(c0802f.f2035m.f1708g, a, c0802f.f2036n == null ? 0 : c0802f.f2036n.f2202al);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } catch (Exception e) {
                }
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    private void m1569d(List<C0802f> list) {
        if (list != null && !list.isEmpty()) {
            synchronized (this.f1663de) {
                this.f1663de.addAll(list);
            }
        }
    }

    /* renamed from: d */
    private boolean m1570d(C0802f c0802f) {
        int i = c0802f.f2036n.f2202al;
        return i == 0 || System.currentTimeMillis() / 1000 <= ((long) i);
    }

    /* renamed from: e */
    private void m1571e(long j) {
        C0703ci.m1691h("setNextRequireTime", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(new Date(j)));
        Context context = C0741dg.m1804aL().f1805el;
        if (context != null) {
            Intent intent = new Intent();
            intent.setAction("com.kingroot.kinguser.action.update");
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 0);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            alarmManager.cancel(broadcast);
            alarmManager.set(1, j, broadcast);
        }
        C0646bc.m1515d(j);
    }

    /* renamed from: e */
    private void m1572e(List<C0802f> list) {
        if (list != null && list.size() > 0) {
            List<C0802f> arrayList = new ArrayList();
            arrayList.addAll(list);
            list.clear();
            ArrayList arrayList2 = new ArrayList();
            for (C0802f a : arrayList) {
                try {
                    Collection a2 = m1559a(a);
                    if (a2 != null) {
                        arrayList2.addAll(a2);
                    }
                } catch (Throwable e) {
                    C0633at.m1459a(e);
                }
            }
            if (arrayList2.size() > 0) {
                C0866h c0866h = new C0866h();
                c0866h.f2156z = arrayList2;
                C0658be.m1541a(c0866h);
            }
        }
    }

    /* renamed from: e */
    private boolean m1573e(C0802f c0802f) {
        if (c0802f == null) {
            return false;
        }
        if (!m1570d(c0802f)) {
            return false;
        }
        ArrayList a = c0802f.mo5809a();
        return (a == null || a.size() <= 0) ? false : ((C0732d) a.get(0)) != null;
    }

    /* renamed from: d */
    public final void mo5644d(boolean z) {
        String str = "checkCloudCmd";
        C0703ci.m1691h(str, str);
        if (z) {
            if (!C0899s.m2469a(C0646bc.m1510Q(), System.currentTimeMillis(), C0646bc.m1511R())) {
                C0703ci.m1691h(str, "not the time");
                return;
            }
        }
        this.f1665dg.mo5632j(true);
    }

    /* renamed from: e */
    public final void mo5645e(boolean z) {
        String str = "executeCloudCmd";
        if (z) {
            C0703ci.m1691h(str, "executeCloudCmd after getting Root : " + this.f1664df.size());
            Iterator it = this.f1664df.iterator();
            while (it.hasNext()) {
                C0802f c0802f = (C0802f) it.next();
                if (c0802f != null && m1570d(c0802f)) {
                    this.f1663de.add(c0802f);
                }
            }
            this.f1664df.clear();
        }
        if (this.f1663de.size() > 0) {
            this.f1666dh.mo5632j(true);
        }
    }
}
