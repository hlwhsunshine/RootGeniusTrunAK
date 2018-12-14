package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import okhttp3.internal.C1910m;
import okhttp3.internal.http.C1893f;

/* renamed from: okhttp3.s */
public final class C1923s {
    /* renamed from: a */
    private final String[] f5719a;

    /* renamed from: okhttp3.s$a */
    public static final class C1922a {
        /* renamed from: a */
        private final List<String> f5718a = new ArrayList(20);

        /* renamed from: c */
        private C1922a m5504c(String str, String str2) {
            this.f5718a.add(str);
            this.f5718a.add(str2.trim());
            return this;
        }

        /* renamed from: d */
        private static void m5505d(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            } else {
                int i;
                char charAt;
                int length = str.length();
                for (i = 0; i < length; i++) {
                    charAt = str.charAt(i);
                    if (charAt <= 31 || charAt >= 127) {
                        throw new IllegalArgumentException(C1910m.m5445a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                    }
                }
                if (str2 == null) {
                    throw new NullPointerException("value == null");
                }
                length = str2.length();
                for (i = 0; i < length; i++) {
                    charAt = str2.charAt(i);
                    if (charAt <= 31 || charAt >= 127) {
                        throw new IllegalArgumentException(C1910m.m5445a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str, str2));
                    }
                }
            }
        }

        /* renamed from: a */
        final C1922a mo8909a(String str) {
            int indexOf = str.indexOf(":", 1);
            return indexOf != -1 ? m5504c(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? m5504c("", str.substring(1)) : m5504c("", str);
        }

        /* renamed from: a */
        public final C1922a mo8910a(String str, String str2) {
            C1922a.m5505d(str, str2);
            return m5504c(str, str2);
        }

        /* renamed from: a */
        public final C1923s mo8911a() {
            return new C1923s(this, (byte) 0);
        }

        /* renamed from: b */
        public final C1922a mo8912b(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f5718a.size()) {
                    return this;
                }
                if (str.equalsIgnoreCase((String) this.f5718a.get(i2))) {
                    this.f5718a.remove(i2);
                    this.f5718a.remove(i2);
                    i2 -= 2;
                }
                i = i2 + 2;
            }
        }

        /* renamed from: b */
        public final C1922a mo8913b(String str, String str2) {
            C1922a.m5505d(str, str2);
            mo8912b(str);
            m5504c(str, str2);
            return this;
        }
    }

    private C1923s(C1922a c1922a) {
        this.f5719a = (String[]) c1922a.f5718a.toArray(new String[c1922a.f5718a.size()]);
    }

    /* synthetic */ C1923s(C1922a c1922a, byte b) {
        this(c1922a);
    }

    /* renamed from: a */
    public final int mo8914a() {
        return this.f5719a.length / 2;
    }

    /* renamed from: a */
    public final String mo8915a(int i) {
        return this.f5719a[i * 2];
    }

    /* renamed from: a */
    public final String mo8916a(String str) {
        String[] strArr = this.f5719a;
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: b */
    public final String mo8917b(int i) {
        return this.f5719a[(i * 2) + 1];
    }

    /* renamed from: b */
    public final Date mo8918b(String str) {
        String a = mo8916a(str);
        return a != null ? C1893f.m5369a(a) : null;
    }

    /* renamed from: b */
    public final C1922a mo8919b() {
        C1922a c1922a = new C1922a();
        Collections.addAll(c1922a.f5718a, this.f5719a);
        return c1922a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C1923s) && Arrays.equals(((C1923s) obj).f5719a, this.f5719a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5719a);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = this.f5719a.length / 2;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(mo8915a(i)).append(": ").append(mo8917b(i)).append("\n");
        }
        return stringBuilder.toString();
    }
}
