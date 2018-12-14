package okhttp3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.C1910m;
import okhttp3.internal.http.C1893f;

/* renamed from: okhttp3.l */
public final class C1915l {
    /* renamed from: a */
    private static final Pattern f5694a = Pattern.compile("(\\d{2,4})[^\\d]*");
    /* renamed from: b */
    private static final Pattern f5695b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    /* renamed from: c */
    private static final Pattern f5696c = Pattern.compile("(\\d{1,2})[^\\d]*");
    /* renamed from: d */
    private static final Pattern f5697d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    /* renamed from: e */
    private final String f5698e;
    /* renamed from: f */
    private final String f5699f;
    /* renamed from: g */
    private final long f5700g;
    /* renamed from: h */
    private final String f5701h;
    /* renamed from: i */
    private final String f5702i;
    /* renamed from: j */
    private final boolean f5703j;
    /* renamed from: k */
    private final boolean f5704k;
    /* renamed from: l */
    private final boolean f5705l;
    /* renamed from: m */
    private final boolean f5706m;

    private C1915l(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f5698e = str;
        this.f5699f = str2;
        this.f5700g = j;
        this.f5701h = str3;
        this.f5702i = str4;
        this.f5703j = z;
        this.f5704k = z2;
        this.f5706m = z3;
        this.f5705l = z4;
    }

    /* renamed from: a */
    private static int m5486a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            Object obj = ((charAt >= ' ' || charAt == 9) && charAt < 127 && ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && charAt != ':')))) ? null : 1;
            if (obj == (!z ? 1 : null)) {
                return i3;
            }
        }
        return i2;
    }

    /* renamed from: a */
    private static long m5487a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            return parseLong <= 0 ? Long.MIN_VALUE : parseLong;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return !str.startsWith("-") ? Long.MAX_VALUE : Long.MIN_VALUE;
            } else {
                throw e;
            }
        }
    }

    /* renamed from: a */
    public static List<C1915l> m5488a(HttpUrl httpUrl, C1923s c1923s) {
        String str = "Set-Cookie";
        int a = c1923s.mo8914a();
        List list = null;
        for (int i = 0; i < a; i++) {
            if (str.equalsIgnoreCase(c1923s.mo8915a(i))) {
                if (list == null) {
                    list = new ArrayList(2);
                }
                list.add(c1923s.mo8917b(i));
            }
        }
        List unmodifiableList = list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
        int size = unmodifiableList.size();
        List list2 = null;
        int i2 = 0;
        while (i2 < size) {
            C1915l a2 = C1915l.m5489a(System.currentTimeMillis(), httpUrl, (String) unmodifiableList.get(i2));
            if (a2 != null) {
                list = list2 == null ? new ArrayList() : list2;
                list.add(a2);
            } else {
                list = list2;
            }
            i2++;
            list2 = list;
        }
        return list2 != null ? Collections.unmodifiableList(list2) : Collections.emptyList();
    }

    /* renamed from: a */
    private static C1915l m5489a(long j, HttpUrl httpUrl, String str) {
        int length = str.length();
        int a = C1910m.m5443a(str, 0, length, ';');
        int a2 = C1910m.m5443a(str, 0, a, '=');
        if (a2 == a) {
            return null;
        }
        String c = C1910m.m5465c(str, 0, a2);
        if (c.isEmpty()) {
            return null;
        }
        String c2;
        String f;
        String c3 = C1910m.m5465c(str, a2 + 1, a);
        long j2 = 253402300799999L;
        long j3 = -1;
        String str2 = null;
        String str3 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        a++;
        while (a < length) {
            String str4;
            int a3 = C1910m.m5443a(str, a, length, ';');
            int a4 = C1910m.m5443a(str, a, a3, '=');
            String c4 = C1910m.m5465c(str, a, a4);
            c2 = a4 < a3 ? C1910m.m5465c(str, a4 + 1, a3) : "";
            if (c4.equalsIgnoreCase("expires")) {
                try {
                    int length2 = c2.length();
                    int a5 = C1915l.m5486a(c2, 0, length2, false);
                    int i = -1;
                    int i2 = -1;
                    int i3 = -1;
                    int i4 = -1;
                    int i5 = -1;
                    a4 = -1;
                    Matcher matcher = f5697d.matcher(c2);
                    while (a5 < length2) {
                        int a6 = C1915l.m5486a(c2, a5 + 1, length2, true);
                        matcher.region(a5, a6);
                        if (i == -1 && matcher.usePattern(f5697d).matches()) {
                            i = Integer.parseInt(matcher.group(1));
                            i2 = Integer.parseInt(matcher.group(2));
                            i3 = Integer.parseInt(matcher.group(3));
                        } else {
                            if (i4 == -1) {
                                if (matcher.usePattern(f5696c).matches()) {
                                    i4 = Integer.parseInt(matcher.group(1));
                                }
                            }
                            if (i5 == -1 && matcher.usePattern(f5695b).matches()) {
                                i5 = f5695b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                            } else if (a4 == -1 && matcher.usePattern(f5694a).matches()) {
                                a4 = Integer.parseInt(matcher.group(1));
                            }
                        }
                        a5 = C1915l.m5486a(c2, a6 + 1, length2, false);
                    }
                    a = (a4 < 70 || a4 > 99) ? a4 : a4 + 1900;
                    if (a >= 0 && a <= 69) {
                        a += 2000;
                    }
                    if (a < 1601) {
                        throw new IllegalArgumentException();
                    } else if (i5 == -1) {
                        throw new IllegalArgumentException();
                    } else if (i4 <= 0 || i4 > 31) {
                        throw new IllegalArgumentException();
                    } else if (i < 0 || i > 23) {
                        throw new IllegalArgumentException();
                    } else if (i2 < 0 || i2 > 59) {
                        throw new IllegalArgumentException();
                    } else if (i3 < 0 || i3 > 59) {
                        throw new IllegalArgumentException();
                    } else {
                        Calendar gregorianCalendar = new GregorianCalendar(C1910m.f5677d);
                        gregorianCalendar.setLenient(false);
                        gregorianCalendar.set(1, a);
                        gregorianCalendar.set(2, i5 - 1);
                        gregorianCalendar.set(5, i4);
                        gregorianCalendar.set(11, i);
                        gregorianCalendar.set(12, i2);
                        gregorianCalendar.set(13, i3);
                        gregorianCalendar.set(14, 0);
                        j2 = gregorianCalendar.getTimeInMillis();
                        z4 = true;
                        c2 = str3;
                        str3 = str2;
                    }
                } catch (IllegalArgumentException e) {
                    c2 = str3;
                    str3 = str2;
                }
            } else if (c4.equalsIgnoreCase("max-age")) {
                try {
                    j3 = C1915l.m5487a(c2);
                    z4 = true;
                    c2 = str3;
                    str3 = str2;
                } catch (NumberFormatException e2) {
                    c2 = str3;
                    str3 = str2;
                }
            } else if (c4.equalsIgnoreCase("domain")) {
                try {
                    if (c2.endsWith(".")) {
                        throw new IllegalArgumentException();
                    }
                    if (c2.startsWith(".")) {
                        c2 = c2.substring(1);
                    }
                    c2 = C1910m.m5462b(c2);
                    if (c2 == null) {
                        throw new IllegalArgumentException();
                    }
                    z3 = false;
                    str4 = str3;
                    str3 = c2;
                    c2 = str4;
                } catch (IllegalArgumentException e3) {
                    c2 = str3;
                    str3 = str2;
                }
            } else if (c4.equalsIgnoreCase("path")) {
                str3 = str2;
            } else {
                if (c4.equalsIgnoreCase("secure")) {
                    z = true;
                    c2 = str3;
                    str3 = str2;
                } else {
                    if (c4.equalsIgnoreCase("httponly")) {
                        z2 = true;
                        c2 = str3;
                        str3 = str2;
                    } else {
                        c2 = str3;
                        str3 = str2;
                    }
                }
            }
            str4 = c2;
            a = a3 + 1;
            str2 = str3;
            str3 = str4;
        }
        if (j3 == Long.MIN_VALUE) {
            j2 = Long.MIN_VALUE;
        } else if (j3 != -1) {
            j2 = j + (j3 <= 9223372036854775L ? j3 * 1000 : Long.MAX_VALUE);
            if (j2 < j || j2 > 253402300799999L) {
                j2 = 253402300799999L;
            }
        }
        if (str2 == null) {
            c2 = httpUrl.mo8588f();
        } else {
            f = httpUrl.mo8588f();
            Object obj = f.equals(str2) ? 1 : (f.endsWith(str2) && f.charAt((f.length() - str2.length()) - 1) == '.' && !C1910m.m5466c(f)) ? 1 : null;
            if (obj == null) {
                return null;
            }
            c2 = str2;
        }
        if (str3 == null || !str3.startsWith("/")) {
            f = httpUrl.mo8590h();
            int lastIndexOf = f.lastIndexOf(47);
            str3 = lastIndexOf != 0 ? f.substring(0, lastIndexOf) : "/";
        }
        return new C1915l(c, c3, j2, c2, str3, z, z2, z3, z4);
    }

    /* renamed from: a */
    public final String mo8895a() {
        return this.f5698e;
    }

    /* renamed from: b */
    public final String mo8896b() {
        return this.f5699f;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1915l)) {
            return false;
        }
        C1915l c1915l = (C1915l) obj;
        return c1915l.f5698e.equals(this.f5698e) && c1915l.f5699f.equals(this.f5699f) && c1915l.f5701h.equals(this.f5701h) && c1915l.f5702i.equals(this.f5702i) && c1915l.f5700g == this.f5700g && c1915l.f5703j == this.f5703j && c1915l.f5704k == this.f5704k && c1915l.f5705l == this.f5705l && c1915l.f5706m == this.f5706m;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.f5705l ? 0 : 1) + (((this.f5704k ? 0 : 1) + (((this.f5703j ? 0 : 1) + ((((((((((this.f5698e.hashCode() + 527) * 31) + this.f5699f.hashCode()) * 31) + this.f5701h.hashCode()) * 31) + this.f5702i.hashCode()) * 31) + ((int) (this.f5700g ^ (this.f5700g >>> 32)))) * 31)) * 31)) * 31)) * 31;
        if (!this.f5706m) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f5698e);
        stringBuilder.append('=');
        stringBuilder.append(this.f5699f);
        if (this.f5705l) {
            if (this.f5700g == Long.MIN_VALUE) {
                stringBuilder.append("; max-age=0");
            } else {
                stringBuilder.append("; expires=").append(C1893f.m5368a(new Date(this.f5700g)));
            }
        }
        if (!this.f5706m) {
            stringBuilder.append("; domain=").append(this.f5701h);
        }
        stringBuilder.append("; path=").append(this.f5702i);
        if (this.f5703j) {
            stringBuilder.append("; secure");
        }
        if (this.f5704k) {
            stringBuilder.append("; httponly");
        }
        return stringBuilder.toString();
    }
}
