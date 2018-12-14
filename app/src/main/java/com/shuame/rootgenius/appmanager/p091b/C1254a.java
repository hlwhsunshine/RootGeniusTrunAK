package com.shuame.rootgenius.appmanager.p091b;

import android.graphics.drawable.Drawable;

/* renamed from: com.shuame.rootgenius.appmanager.b.a */
public final class C1254a {
    /* renamed from: a */
    public String f3337a;
    /* renamed from: b */
    public Drawable f3338b;
    /* renamed from: c */
    public String f3339c;
    /* renamed from: d */
    public String f3340d;
    /* renamed from: e */
    public String f3341e;
    /* renamed from: f */
    public String f3342f;
    /* renamed from: g */
    public String f3343g;
    /* renamed from: h */
    public int f3344h;
    /* renamed from: i */
    public int f3345i;
    /* renamed from: j */
    public Boolean f3346j = Boolean.valueOf(false);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C1254a c1254a = (C1254a) obj;
        if (this.f3339c == null) {
            if (c1254a.f3339c != null) {
                return false;
            }
        } else if (!this.f3339c.equals(c1254a.f3339c)) {
            return false;
        }
        return this.f3337a == null ? c1254a.f3337a == null : this.f3337a.equals(c1254a.f3337a);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.f3339c == null ? 0 : this.f3339c.hashCode()) + 31) * 31;
        if (this.f3337a != null) {
            i = this.f3337a.hashCode();
        }
        return hashCode + i;
    }
}
