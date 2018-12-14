package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* renamed from: com.google.gson.stream.c */
public class C0534c implements Closeable, Flushable {
    /* renamed from: a */
    private static final String[] f1322a = new String[128];
    /* renamed from: b */
    private static final String[] f1323b;
    /* renamed from: c */
    private final Writer f1324c;
    /* renamed from: d */
    private int[] f1325d = new int[32];
    /* renamed from: e */
    private int f1326e = 0;
    /* renamed from: f */
    private String f1327f;
    /* renamed from: g */
    private String f1328g;
    /* renamed from: h */
    private boolean f1329h;
    /* renamed from: i */
    private boolean f1330i;
    /* renamed from: j */
    private String f1331j;
    /* renamed from: k */
    private boolean f1332k;

    static {
        for (int i = 0; i <= 31; i++) {
            f1322a[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        f1322a[34] = "\\\"";
        f1322a[92] = "\\\\";
        f1322a[9] = "\\t";
        f1322a[8] = "\\b";
        f1322a[10] = "\\n";
        f1322a[13] = "\\r";
        f1322a[12] = "\\f";
        String[] strArr = (String[]) f1322a.clone();
        f1323b = strArr;
        strArr[60] = "\\u003c";
        f1323b[62] = "\\u003e";
        f1323b[38] = "\\u0026";
        f1323b[61] = "\\u003d";
        f1323b[39] = "\\u0027";
    }

    public C0534c(Writer writer) {
        m1178a(6);
        this.f1328g = ":";
        this.f1332k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f1324c = writer;
    }

    /* renamed from: a */
    private int mo5524a() {
        if (this.f1326e != 0) {
            return this.f1325d[this.f1326e - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* renamed from: a */
    private C0534c m1176a(int i, int i2, String str) {
        int a = mo5524a();
        if (a != i2 && a != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f1331j != null) {
            throw new IllegalStateException("Dangling name: " + this.f1331j);
        } else {
            this.f1326e--;
            if (a == i2) {
                m1183k();
            }
            this.f1324c.write(str);
            return this;
        }
    }

    /* renamed from: a */
    private C0534c m1177a(int i, String str) {
        m1181e(true);
        m1178a(i);
        this.f1324c.write(str);
        return this;
    }

    /* renamed from: a */
    private void m1178a(int i) {
        if (this.f1326e == this.f1325d.length) {
            Object obj = new int[(this.f1326e * 2)];
            System.arraycopy(this.f1325d, 0, obj, 0, this.f1326e);
            this.f1325d = obj;
        }
        int[] iArr = this.f1325d;
        int i2 = this.f1326e;
        this.f1326e = i2 + 1;
        iArr[i2] = i;
    }

    /* renamed from: b */
    private void m1179b(int i) {
        this.f1325d[this.f1326e - 1] = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0030  */
    /* renamed from: d */
    private void m1180d(java.lang.String r8) {
        /*
        r7 = this;
        r1 = 0;
        r0 = r7.f1330i;
        if (r0 == 0) goto L_0x0025;
    L_0x0005:
        r0 = f1323b;
    L_0x0007:
        r2 = r7.f1324c;
        r3 = "\"";
        r2.write(r3);
        r4 = r8.length();
        r3 = r1;
    L_0x0013:
        if (r3 >= r4) goto L_0x0046;
    L_0x0015:
        r2 = r8.charAt(r3);
        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r2 >= r5) goto L_0x0028;
    L_0x001d:
        r2 = r0[r2];
        if (r2 != 0) goto L_0x002e;
    L_0x0021:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0013;
    L_0x0025:
        r0 = f1322a;
        goto L_0x0007;
    L_0x0028:
        r5 = 8232; // 0x2028 float:1.1535E-41 double:4.067E-320;
        if (r2 != r5) goto L_0x003f;
    L_0x002c:
        r2 = "\\u2028";
    L_0x002e:
        if (r1 >= r3) goto L_0x0037;
    L_0x0030:
        r5 = r7.f1324c;
        r6 = r3 - r1;
        r5.write(r8, r1, r6);
    L_0x0037:
        r1 = r7.f1324c;
        r1.write(r2);
        r1 = r3 + 1;
        goto L_0x0021;
    L_0x003f:
        r5 = 8233; // 0x2029 float:1.1537E-41 double:4.0676E-320;
        if (r2 != r5) goto L_0x0021;
    L_0x0043:
        r2 = "\\u2029";
        goto L_0x002e;
    L_0x0046:
        if (r1 >= r4) goto L_0x004f;
    L_0x0048:
        r0 = r7.f1324c;
        r2 = r4 - r1;
        r0.write(r8, r1, r2);
    L_0x004f:
        r0 = r7.f1324c;
        r1 = "\"";
        r0.write(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.c.d(java.lang.String):void");
    }

    /* renamed from: e */
    private void m1181e(boolean z) {
        switch (mo5524a()) {
            case 1:
                m1179b(2);
                m1183k();
                return;
            case 2:
                this.f1324c.append(',');
                m1183k();
                return;
            case 4:
                this.f1324c.append(this.f1328g);
                m1179b(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.f1329h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        if (this.f1329h || z) {
            m1179b(7);
            return;
        }
        throw new IllegalStateException("JSON must start with an array or an object.");
    }

    /* renamed from: j */
    private void m1182j() {
        if (this.f1331j != null) {
            int a = mo5524a();
            if (a == 5) {
                this.f1324c.write(44);
            } else if (a != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            m1183k();
            m1179b(4);
            m1180d(this.f1331j);
            this.f1331j = null;
        }
    }

    /* renamed from: k */
    private void m1183k() {
        if (this.f1327f != null) {
            this.f1324c.write("\n");
            int i = this.f1326e;
            for (int i2 = 1; i2 < i; i2++) {
                this.f1324c.write(this.f1327f);
            }
        }
    }

    /* renamed from: a */
    public C0534c mo5505a(long j) {
        m1182j();
        m1181e(false);
        this.f1324c.write(Long.toString(j));
        return this;
    }

    /* renamed from: a */
    public C0534c mo5378a(Number number) {
        if (number == null) {
            return mo5519f();
        }
        m1182j();
        CharSequence obj = number.toString();
        if (this.f1329h || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            m1181e(false);
            this.f1324c.append(obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    /* renamed from: a */
    public C0534c mo5507a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f1331j != null) {
            throw new IllegalStateException();
        } else if (this.f1326e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.f1331j = str;
            return this;
        }
    }

    /* renamed from: a */
    public C0534c mo5508a(boolean z) {
        m1182j();
        m1181e(false);
        this.f1324c.write(z ? "true" : "false");
        return this;
    }

    /* renamed from: b */
    public C0534c mo5509b() {
        m1182j();
        return m1177a(1, "[");
    }

    /* renamed from: b */
    public C0534c mo5510b(String str) {
        if (str == null) {
            return mo5519f();
        }
        m1182j();
        m1181e(false);
        m1180d(str);
        return this;
    }

    /* renamed from: b */
    public final void mo5511b(boolean z) {
        this.f1329h = z;
    }

    /* renamed from: c */
    public C0534c mo5512c() {
        return m1176a(1, 2, "]");
    }

    /* renamed from: c */
    public final void mo5513c(String str) {
        if (str.length() == 0) {
            this.f1327f = null;
            this.f1328g = ":";
            return;
        }
        this.f1327f = str;
        this.f1328g = ": ";
    }

    /* renamed from: c */
    public final void mo5514c(boolean z) {
        this.f1330i = z;
    }

    public void close() {
        this.f1324c.close();
        int i = this.f1326e;
        if (i > 1 || (i == 1 && this.f1325d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f1326e = 0;
    }

    /* renamed from: d */
    public C0534c mo5516d() {
        m1182j();
        return m1177a(3, "{");
    }

    /* renamed from: d */
    public final void mo5517d(boolean z) {
        this.f1332k = z;
    }

    /* renamed from: e */
    public C0534c mo5518e() {
        return m1176a(3, 5, "}");
    }

    /* renamed from: f */
    public C0534c mo5519f() {
        if (this.f1331j != null) {
            if (this.f1332k) {
                m1182j();
            } else {
                this.f1331j = null;
                return this;
            }
        }
        m1181e(false);
        this.f1324c.write("null");
        return this;
    }

    public void flush() {
        if (this.f1326e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f1324c.flush();
    }

    /* renamed from: g */
    public final boolean mo5521g() {
        return this.f1329h;
    }

    /* renamed from: h */
    public final boolean mo5522h() {
        return this.f1330i;
    }

    /* renamed from: i */
    public final boolean mo5523i() {
        return this.f1332k;
    }
}
