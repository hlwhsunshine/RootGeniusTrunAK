package com.nostra13.universalimageloader.p057a.p062b;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* renamed from: com.nostra13.universalimageloader.a.b.a */
public abstract class C0993a implements C0990b {
    /* renamed from: a */
    private final Map<String, Reference<Bitmap>> f2479a = Collections.synchronizedMap(new HashMap());

    /* renamed from: a */
    protected abstract Reference<Bitmap> mo6152a(Bitmap bitmap);

    /* renamed from: a */
    public final Collection<String> mo6148a() {
        Collection hashSet;
        synchronized (this.f2479a) {
            hashSet = new HashSet(this.f2479a.keySet());
        }
        return hashSet;
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo6149a(Object obj, Object obj2) {
        this.f2479a.put((String) obj, mo6152a((Bitmap) obj2));
        return true;
    }

    /* renamed from: b */
    public final /* synthetic */ Object mo6150b(Object obj) {
        Reference reference = (Reference) this.f2479a.get((String) obj);
        return reference != null ? (Bitmap) reference.get() : null;
    }
}
