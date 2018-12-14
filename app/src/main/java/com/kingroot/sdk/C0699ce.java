package com.kingroot.sdk;

import android.text.TextUtils;
import java.io.File;

/* renamed from: com.kingroot.sdk.ce */
public class C0699ce implements C0698cd {
    /* renamed from: dX */
    protected String f1718dX;

    C0699ce(String str) {
        this.f1718dX = str;
    }

    /* renamed from: a */
    public boolean mo5678a(Object obj) {
        if (TextUtils.isEmpty(this.f1718dX) || obj == null) {
            return false;
        }
        boolean a;
        synchronized (this) {
            a = C0701cg.m1688a(obj, this.f1718dX);
        }
        return a;
    }

    /* renamed from: am */
    public Object mo5679am() {
        if (TextUtils.isEmpty(this.f1718dX)) {
            return null;
        }
        Object E;
        synchronized (this) {
            E = C0701cg.m1687E(this.f1718dX);
        }
        return E;
    }

    public boolean delete() {
        return TextUtils.isEmpty(this.f1718dX) ? false : new File(this.f1718dX).delete();
    }
}
