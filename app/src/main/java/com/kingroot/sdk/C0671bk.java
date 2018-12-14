package com.kingroot.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.kingroot.sdk.C0692by.C0669a;
import com.kingroot.sdk.C0851gl.C0849b;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import krsdk.RootShell;
import krsdk.RootShell.ShellResult;

/* renamed from: com.kingroot.sdk.bk */
public class C0671bk {
    /* renamed from: A */
    public static boolean m1586A(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        List arrayList = new ArrayList();
        arrayList.add(String.format("chown %d.%d %s", new Object[]{Integer.valueOf(0), Integer.valueOf(0), str}));
        arrayList.add(String.format("chmod 0%o %s", new Object[]{Integer.valueOf(493), str}));
        RootShell c = C0659bf.m1548c(true);
        if (c == null) {
            return false;
        }
        List executeCommand2 = c.executeCommand2(arrayList);
        if (executeCommand2 != null && executeCommand2.size() == arrayList.size()) {
            for (int i = 0; i < executeCommand2.size(); i++) {
                if (!((ShellResult) executeCommand2.get(i)).success()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public static int m1587a(Context context, C0869k c0869k) {
        if (c0869k == null) {
            return 2;
        }
        int j = C0674bl.m1604j(context, c0869k.f2167L);
        return j == 0 ? 1 : j == 1 ? 0 : 2;
    }

    /* renamed from: a */
    public static int m1588a(Context context, C0871m c0871m, String str) {
        if (c0871m == null) {
            return 2;
        }
        C0633at.m1463g("ccmd:" + c0871m.f2173R);
        if (TextUtils.isEmpty(c0871m.f2173R.toLowerCase(Locale.getDefault()))) {
            return 2;
        }
        if (c0871m.f2174S == 1) {
            RootShell ae = C0674bl.m1601ae();
            if (ae != null) {
                ShellResult executeCommand2 = ae.executeCommand2(c0871m.f2173R);
                C0633at.m1463g(c0871m.f2173R + " " + executeCommand2.stdout);
                return !executeCommand2.success() ? 0 : 1;
            }
        } else {
            try {
                C0849b c = C0659bf.m1546Y().mo5855c(c0871m.f2173R, 120000);
                C0633at.m1463g(c.f2103cr + " " + c.f2104cs);
                return !c.success() ? 0 : 1;
            } catch (Throwable e) {
                C0633at.m1459a(e);
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m1589a(final Context context, C0873o c0873o) {
        final int i = c0873o.f2178U;
        C0674bl.m1599a(c0873o.f2177M, "temp" + System.currentTimeMillis() + ".apk", new C0692by(context, context.getFilesDir().getAbsolutePath(), new C0669a() {
            /* renamed from: a */
            public final void mo5651a(C0689bx c0689bx) {
                if (c0689bx == null) {
                    return;
                }
                if (i == 1) {
                    C0674bl.m1602h(context, c0689bx.getAbsolutePath());
                } else {
                    C0674bl.m1603i(context, c0689bx.getAbsolutePath());
                }
            }

            /* renamed from: b */
            public final void mo5652b(C0689bx c0689bx) {
            }
        }));
        return 1;
    }

    /* renamed from: a */
    public static C0837g m1590a(String str, int i, int i2, int i3, int i4, int i5) {
        C0771e c0771e = new C0771e();
        c0771e.f1877j = i;
        c0771e.f1878l = i5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c0771e);
        C0837g c0837g = new C0837g();
        c0837g.f2090g = str;
        c0837g.action = i2;
        c0837g.f2093v = i3;
        c0837g.f2094w = i4;
        c0837g.f2095x = (int) (System.currentTimeMillis() / 1000);
        c0837g.f2092u = arrayList;
        c0837g.f2091l = i5;
        return c0837g;
    }

    /* renamed from: a */
    public static C0837g m1591a(String str, int i, int i2, int i3, ArrayList<C0771e> arrayList, int i4) {
        C0837g c0837g = new C0837g();
        c0837g.f2090g = str;
        c0837g.action = i;
        c0837g.f2093v = i2;
        c0837g.f2094w = i3;
        c0837g.f2095x = (int) (System.currentTimeMillis() / 1000);
        c0837g.f2092u = arrayList;
        c0837g.f2091l = i4;
        return c0837g;
    }

    /* renamed from: a */
    public static C0837g m1592a(String str, C0732d c0732d) {
        C0872n c0872n = (C0872n) C0671bk.m1593a(c0732d, new C0872n());
        if (c0872n == null) {
            return null;
        }
        int w = C0682br.m1635w(c0872n.f2175T);
        return C0671bk.m1590a(str, c0732d.f1786j, 0, 3, 0, w);
    }

    /* renamed from: a */
    private static <T extends C0597gy> T m1593a(C0732d c0732d, T t) {
        C0855gp c0855gp = new C0855gp();
        c0855gp.mo5858aq("UTF-8");
        c0855gp.mo5860m(c0732d.f1785i);
        return (C0597gy) c0855gp.mo5862a("cloudcmd", (Object) t);
    }

    /* renamed from: b */
    public static C0837g m1594b(String str, C0732d c0732d) {
        C0877s c0877s = (C0877s) C0671bk.m1593a(c0732d, new C0877s());
        if (c0877s == null) {
            return null;
        }
        int a = C0682br.m1634a(str, c0877s.f2191ae, c0877s.f2192af, c0877s.f2193ag, c0877s.f2194ah);
        return C0671bk.m1590a(str, c0732d.f1786j, 0, 3, 0, a);
    }

    /* renamed from: c */
    public static List<C0802f> m1595c(String str, C0732d c0732d) {
        Context context = C0741dg.m1804aL().f1805el;
        if (context == null) {
            return null;
        }
        C0643b c0643b = new C0643b();
        c0643b.f1618e = 11;
        c0643b.f1617d = new C0902w();
        c0643b.f1617d.f2225ap = context.getPackageName();
        AtomicReference atomicReference = new AtomicReference();
        if (C0769dy.m1911a(context, c0643b, atomicReference) == 0) {
            C0598a c0598a = (C0598a) atomicReference.get();
            if (c0598a != null) {
                return c0598a.f1469a;
            }
        }
        return null;
    }

    /* renamed from: e */
    public static int m1596e(Context context, String str) {
        if (str == null) {
            return 2;
        }
        ApplicationInfo m = C0674bl.m1607m(context, str);
        return (m == null || !C0674bl.m1600a(context, m)) ? 0 : 1;
    }

    /* renamed from: f */
    public static int m1597f(Context context, String str) {
        return str == null ? 2 : (C0674bl.m1607m(context, str) == null || !C0674bl.m1605k(context, str)) ? 0 : 1;
    }

    /* renamed from: g */
    public static int m1598g(Context context, String str) {
        return str == null ? 2 : (C0674bl.m1607m(context, str) == null || !C0674bl.m1606l(context, str)) ? 0 : 1;
    }
}
