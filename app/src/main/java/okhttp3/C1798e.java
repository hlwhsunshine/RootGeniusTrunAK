package okhttp3;

import java.util.concurrent.TimeUnit;
import okhttp3.internal.http.C1882c;

/* renamed from: okhttp3.e */
public final class C1798e {
    /* renamed from: a */
    public static final C1798e f5278a;
    /* renamed from: b */
    public static final C1798e f5279b;
    /* renamed from: c */
    String f5280c;
    /* renamed from: d */
    private final boolean f5281d;
    /* renamed from: e */
    private final boolean f5282e;
    /* renamed from: f */
    private final int f5283f;
    /* renamed from: g */
    private final int f5284g;
    /* renamed from: h */
    private final boolean f5285h;
    /* renamed from: i */
    private final boolean f5286i;
    /* renamed from: j */
    private final boolean f5287j;
    /* renamed from: k */
    private final int f5288k;
    /* renamed from: l */
    private final int f5289l;
    /* renamed from: m */
    private final boolean f5290m;
    /* renamed from: n */
    private final boolean f5291n;

    /* renamed from: okhttp3.e$a */
    public static final class C1797a {
        /* renamed from: a */
        boolean f5271a;
        /* renamed from: b */
        boolean f5272b;
        /* renamed from: c */
        int f5273c = -1;
        /* renamed from: d */
        int f5274d = -1;
        /* renamed from: e */
        int f5275e = -1;
        /* renamed from: f */
        boolean f5276f;
        /* renamed from: g */
        boolean f5277g;

        /* renamed from: a */
        public final C1798e mo8655a() {
            return new C1798e(this, (byte) 0);
        }
    }

    static {
        C1797a c1797a = new C1797a();
        c1797a.f5271a = true;
        f5278a = c1797a.mo8655a();
        C1797a c1797a2 = new C1797a();
        c1797a2.f5276f = true;
        long toSeconds = TimeUnit.SECONDS.toSeconds(2147483647L);
        c1797a2.f5274d = toSeconds > 2147483647L ? Integer.MAX_VALUE : (int) toSeconds;
        f5279b = c1797a2.mo8655a();
    }

    private C1798e(C1797a c1797a) {
        this.f5281d = c1797a.f5271a;
        this.f5282e = c1797a.f5272b;
        this.f5283f = c1797a.f5273c;
        this.f5284g = -1;
        this.f5285h = false;
        this.f5286i = false;
        this.f5287j = false;
        this.f5288k = c1797a.f5274d;
        this.f5289l = c1797a.f5275e;
        this.f5290m = c1797a.f5276f;
        this.f5291n = c1797a.f5277g;
    }

    /* synthetic */ C1798e(C1797a c1797a, byte b) {
        this(c1797a);
    }

    private C1798e(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.f5281d = z;
        this.f5282e = z2;
        this.f5283f = i;
        this.f5284g = i2;
        this.f5285h = z3;
        this.f5286i = z4;
        this.f5287j = z5;
        this.f5288k = i3;
        this.f5289l = i4;
        this.f5290m = z6;
        this.f5291n = z7;
        this.f5280c = str;
    }

    /* renamed from: a */
    public static C1798e m4949a(C1923s c1923s) {
        boolean z;
        boolean z2 = false;
        boolean z3 = false;
        int i = -1;
        int i2 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i3 = -1;
        int i4 = -1;
        boolean z7 = false;
        boolean z8 = false;
        Object obj = 1;
        int a = c1923s.mo8914a();
        int i5 = 0;
        String str = null;
        while (true) {
            z = z2;
            if (i5 >= a) {
                break;
            }
            String a2 = c1923s.mo8915a(i5);
            String b = c1923s.mo8917b(i5);
            if (a2.equalsIgnoreCase("Cache-Control")) {
                if (str != null) {
                    obj = null;
                } else {
                    str = b;
                }
            } else if (a2.equalsIgnoreCase("Pragma")) {
                obj = null;
            } else {
                z2 = z;
                i5++;
            }
            z2 = z;
            int i6 = 0;
            while (i6 < b.length()) {
                String str2;
                int a3 = C1882c.m5324a(b, i6, "=,;");
                String trim = b.substring(i6, a3).trim();
                if (a3 == b.length() || b.charAt(a3) == ',' || b.charAt(a3) == ';') {
                    i6 = a3 + 1;
                    str2 = null;
                } else {
                    i6 = a3 + 1;
                    while (i6 < b.length()) {
                        char charAt = b.charAt(i6);
                        if (charAt != ' ' && charAt != 9) {
                            break;
                        }
                        i6++;
                    }
                    String trim2;
                    if (i6 >= b.length() || b.charAt(i6) != '\"') {
                        a3 = C1882c.m5324a(b, i6, ",;");
                        trim2 = b.substring(i6, a3).trim();
                        i6 = a3;
                        str2 = trim2;
                    } else {
                        i6++;
                        a3 = C1882c.m5324a(b, i6, "\"");
                        trim2 = b.substring(i6, a3);
                        i6 = a3 + 1;
                        str2 = trim2;
                    }
                }
                if ("no-cache".equalsIgnoreCase(trim)) {
                    z2 = true;
                } else if ("no-store".equalsIgnoreCase(trim)) {
                    z3 = true;
                } else if ("max-age".equalsIgnoreCase(trim)) {
                    i = C1882c.m5323a(str2, -1);
                } else if ("s-maxage".equalsIgnoreCase(trim)) {
                    i2 = C1882c.m5323a(str2, -1);
                } else if ("private".equalsIgnoreCase(trim)) {
                    z4 = true;
                } else if ("public".equalsIgnoreCase(trim)) {
                    z5 = true;
                } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                    z6 = true;
                } else if ("max-stale".equalsIgnoreCase(trim)) {
                    i3 = C1882c.m5323a(str2, Integer.MAX_VALUE);
                } else if ("min-fresh".equalsIgnoreCase(trim)) {
                    i4 = C1882c.m5323a(str2, -1);
                } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                    z7 = true;
                } else if ("no-transform".equalsIgnoreCase(trim)) {
                    z8 = true;
                }
            }
            i5++;
        }
        return new C1798e(z, z3, i, i2, z4, z5, z6, i3, i4, z7, z8, obj == null ? null : str);
    }

    /* renamed from: a */
    public final boolean mo8656a() {
        return this.f5281d;
    }

    /* renamed from: b */
    public final boolean mo8657b() {
        return this.f5282e;
    }

    /* renamed from: c */
    public final int mo8658c() {
        return this.f5283f;
    }

    /* renamed from: d */
    public final boolean mo8659d() {
        return this.f5285h;
    }

    /* renamed from: e */
    public final boolean mo8660e() {
        return this.f5286i;
    }

    /* renamed from: f */
    public final boolean mo8661f() {
        return this.f5287j;
    }

    /* renamed from: g */
    public final int mo8662g() {
        return this.f5288k;
    }

    /* renamed from: h */
    public final int mo8663h() {
        return this.f5289l;
    }

    /* renamed from: i */
    public final boolean mo8664i() {
        return this.f5290m;
    }

    public final String toString() {
        String str = this.f5280c;
        if (str == null) {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.f5281d) {
                stringBuilder.append("no-cache, ");
            }
            if (this.f5282e) {
                stringBuilder.append("no-store, ");
            }
            if (this.f5283f != -1) {
                stringBuilder.append("max-age=").append(this.f5283f).append(", ");
            }
            if (this.f5284g != -1) {
                stringBuilder.append("s-maxage=").append(this.f5284g).append(", ");
            }
            if (this.f5285h) {
                stringBuilder.append("private, ");
            }
            if (this.f5286i) {
                stringBuilder.append("public, ");
            }
            if (this.f5287j) {
                stringBuilder.append("must-revalidate, ");
            }
            if (this.f5288k != -1) {
                stringBuilder.append("max-stale=").append(this.f5288k).append(", ");
            }
            if (this.f5289l != -1) {
                stringBuilder.append("min-fresh=").append(this.f5289l).append(", ");
            }
            if (this.f5290m) {
                stringBuilder.append("only-if-cached, ");
            }
            if (this.f5291n) {
                stringBuilder.append("no-transform, ");
            }
            if (stringBuilder.length() == 0) {
                str = "";
            } else {
                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
                str = stringBuilder.toString();
            }
            this.f5280c = str;
        }
        return str;
    }
}
