package com.shuame.mobile.module.autoboot.p080a;

import com.shuame.mobile.module.autoboot.p083c.C1161a;
import java.util.List;

/* renamed from: com.shuame.mobile.module.autoboot.a.b */
public final class C1149b implements C1148a {
    /* renamed from: a */
    private List<C1148a> f3023a;

    public C1149b(List<C1148a> list) {
        this.f3023a = list;
    }

    /* renamed from: a */
    public final void mo6744a(C1161a c1161a, boolean z) {
        if (this.f3023a != null) {
            int size;
            Object obj = null;
            synchronized (this.f3023a) {
                size = this.f3023a.size();
                if (size > 0) {
                    obj = new C1148a[size];
                    System.arraycopy(this.f3023a.toArray(), 0, obj, 0, size);
                }
            }
            if (obj != null) {
                for (int i = 0; i < size; i++) {
                    C1148a c1148a = obj[i];
                    if (c1148a != null) {
                        try {
                            c1148a.mo6744a(c1161a, z);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo6745a(C1161a c1161a, boolean z, int i) {
        if (this.f3023a != null) {
            int size;
            Object obj = null;
            synchronized (this.f3023a) {
                size = this.f3023a.size();
                if (size > 0) {
                    obj = new C1148a[size];
                    System.arraycopy(this.f3023a.toArray(), 0, obj, 0, size);
                }
            }
            if (obj != null) {
                for (int i2 = 0; i2 < size; i2++) {
                    C1148a c1148a = obj[i2];
                    if (c1148a != null) {
                        try {
                            c1148a.mo6745a(c1161a, z, i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
