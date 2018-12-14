package com.nostra13.universalimageloader.p057a.p062b.p063a;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.p057a.p062b.C0990b;
import java.util.Collection;
import java.util.Comparator;

/* renamed from: com.nostra13.universalimageloader.a.b.a.a */
public final class C0991a implements C0990b {
    /* renamed from: a */
    private final C0990b f2474a;
    /* renamed from: b */
    private final Comparator<String> f2475b;

    public C0991a(C0990b c0990b, Comparator<String> comparator) {
        this.f2474a = c0990b;
        this.f2475b = comparator;
    }

    /* renamed from: a */
    private boolean m2802a(String str, Bitmap bitmap) {
        synchronized (this.f2474a) {
            for (Object obj : this.f2474a.mo6148a()) {
                if (this.f2475b.compare(str, obj) == 0) {
                    break;
                }
            }
            Object obj2 = null;
            if (obj2 != null) {
                this.f2474a.mo6147a(obj2);
            }
        }
        return this.f2474a.mo6149a(str, bitmap);
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo6147a(Object obj) {
        return (Bitmap) this.f2474a.mo6147a((String) obj);
    }

    /* renamed from: a */
    public final Collection<String> mo6148a() {
        return this.f2474a.mo6148a();
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ Object mo6150b(Object obj) {
        return (Bitmap) this.f2474a.mo6150b((String) obj);
    }
}
