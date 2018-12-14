package com.tencent.mid.p117b;

import android.content.Context;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.util.Util;

/* renamed from: com.tencent.mid.b.f */
public abstract class C1645f {
    /* renamed from: a */
    protected Context f4694a = null;

    protected C1645f(Context context) {
        this.f4694a = context;
    }

    /* renamed from: d */
    private void m4496d(String str) {
        if (mo7651b()) {
            Util.logInfo("writeMid " + str + " in " + mo7645a());
            mo7648a(mo7649b(str));
        }
    }

    /* renamed from: f */
    public static String m4497f() {
        return Util.decode("6X8Y4XdM2Vhvn0I=");
    }

    /* renamed from: g */
    public static String m4498g() {
        return Util.decode("6X8Y4XdM2Vhvn0KfzcEatGnWaNU=");
    }

    /* renamed from: h */
    public static String m4499h() {
        return Util.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U=");
    }

    /* renamed from: m */
    private String m4500m() {
        if (!mo7651b()) {
            return null;
        }
        Util.logInfo("read mid from:" + mo7645a());
        return mo7653c(mo7652c());
    }

    /* renamed from: a */
    public abstract int mo7645a();

    /* renamed from: a */
    public void mo7646a(MidEntity midEntity) {
        if (midEntity != null) {
            m4496d(midEntity.toString());
        }
    }

    /* renamed from: a */
    protected abstract void mo7647a(C1643a c1643a);

    /* renamed from: a */
    protected abstract void mo7648a(String str);

    /* renamed from: b */
    protected String mo7649b(String str) {
        return Util.encode(str);
    }

    /* renamed from: b */
    public void mo7650b(C1643a c1643a) {
        if (c1643a != null && mo7651b()) {
            mo7647a(c1643a);
        }
    }

    /* renamed from: b */
    protected abstract boolean mo7651b();

    /* renamed from: c */
    protected abstract String mo7652c();

    /* renamed from: c */
    protected String mo7653c(String str) {
        return Util.decode(str);
    }

    /* renamed from: d */
    protected abstract void mo7654d();

    /* renamed from: e */
    protected abstract C1643a mo7655e();

    /* renamed from: i */
    public MidEntity mo7656i() {
        String m = m4500m();
        return m != null ? MidEntity.parse(m) : null;
    }

    /* renamed from: j */
    void mo7657j() {
        if (mo7651b()) {
            mo7654d();
        }
    }

    /* renamed from: k */
    public C1643a mo7658k() {
        return mo7651b() ? mo7655e() : null;
    }

    /* renamed from: l */
    protected String mo7659l() {
        return Util.decode("4kU71lN96TJUomD1vOU9lgj9Tw==");
    }
}
