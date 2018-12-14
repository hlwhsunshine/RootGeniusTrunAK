package com.tencent.mid.p117b;

import android.content.Context;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mid.b.g */
public class C1649g {
    /* renamed from: b */
    private static C1649g f4695b = null;
    /* renamed from: a */
    private Map<Integer, C1645f> f4696a;
    /* renamed from: c */
    private MidEntity f4697c;

    private C1649g(Context context) {
        this.f4696a = null;
        this.f4697c = null;
        this.f4696a = new HashMap(3);
        this.f4696a.put(Integer.valueOf(1), new C1648e(context));
        this.f4696a.put(Integer.valueOf(2), new C1646c(context));
        this.f4696a.put(Integer.valueOf(4), new C1647d(context));
    }

    /* renamed from: a */
    public static synchronized C1649g m4537a(Context context) {
        C1649g c1649g;
        synchronized (C1649g.class) {
            if (f4695b == null) {
                f4695b = new C1649g(context);
            }
            c1649g = f4695b;
        }
        return c1649g;
    }

    /* renamed from: a */
    public MidEntity mo7660a() {
        if (this.f4697c == null || !this.f4697c.isMidValid()) {
            this.f4697c = mo7661a(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4)})));
        }
        return this.f4697c;
    }

    /* renamed from: a */
    public MidEntity mo7661a(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        for (Integer num : list) {
            C1645f c1645f = (C1645f) this.f4696a.get(num);
            if (c1645f != null) {
                MidEntity i = c1645f.mo7656i();
                if (i != null && i.isMidValid()) {
                    return i;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo7662a(int i, int i2) {
        C1643a b = mo7665b();
        if (i > 0) {
            b.mo7642c(i);
        }
        if (i2 > 0) {
            b.mo7637a(i2);
        }
        b.mo7638a(System.currentTimeMillis());
        b.mo7640b(0);
        mo7664a(b);
    }

    /* renamed from: a */
    public void mo7663a(MidEntity midEntity) {
        if (midEntity.isForceWrite() || this.f4697c == null || !Util.isMidValid(this.f4697c.getMid())) {
            for (Entry value : this.f4696a.entrySet()) {
                ((C1645f) value.getValue()).mo7646a(midEntity);
            }
        }
    }

    /* renamed from: a */
    public void mo7664a(C1643a c1643a) {
        for (Entry value : this.f4696a.entrySet()) {
            ((C1645f) value.getValue()).mo7650b(c1643a);
        }
    }

    /* renamed from: b */
    public C1643a mo7665b() {
        return mo7666b(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(4)})));
    }

    /* renamed from: b */
    public C1643a mo7666b(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        for (Integer num : list) {
            C1645f c1645f = (C1645f) this.f4696a.get(num);
            if (c1645f != null) {
                C1643a k = c1645f.mo7658k();
                if (k != null) {
                    return k;
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    public void mo7667c() {
        Util.logInfo("clear mid cache");
        for (Entry value : this.f4696a.entrySet()) {
            ((C1645f) value.getValue()).mo7657j();
        }
    }
}
