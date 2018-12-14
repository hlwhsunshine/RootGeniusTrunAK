package com.baidu.mobads.p034h;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p034h.C0307g.C0304a;

/* renamed from: com.baidu.mobads.h.a */
public class C0296a {
    /* renamed from: e */
    private static IXAdContainerFactory f536e;
    /* renamed from: a */
    public double f537a = 0.1d;
    /* renamed from: b */
    private Context f538b;
    /* renamed from: c */
    private Class<?> f539c = null;
    /* renamed from: d */
    private double f540d;
    /* renamed from: f */
    private Boolean f541f;
    /* renamed from: g */
    private IXAdLogger f542g = C0338m.m569a().mo5033f();

    public C0296a(Class<?> cls, Context context, double d, Boolean bool) {
        this.f539c = cls;
        this.f538b = context;
        this.f540d = d;
        this.f541f = bool;
    }

    /* renamed from: a */
    public IXAdContainerFactory mo4479a() {
        if (f536e == null) {
            try {
                f536e = (IXAdContainerFactory) this.f539c.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.f538b});
                this.f537a = f536e.getRemoteVersion();
                f536e.setDebugMode(this.f541f);
                f536e.handleShakeVersion(this.f540d, "8.25");
            } catch (Throwable th) {
                this.f542g.mo4939w("XAdContainerFactoryBuilder", th.getMessage());
                C0304a c0304a = new C0304a("newXAdContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return f536e;
    }

    /* renamed from: b */
    public void mo4480b() {
        f536e = null;
    }
}
