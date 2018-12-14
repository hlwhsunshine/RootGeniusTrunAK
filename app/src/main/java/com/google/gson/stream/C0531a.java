package com.google.gson.stream;

import android.support.p015v4.view.MotionEventCompat;
import com.google.gson.internal.C0581q;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* renamed from: com.google.gson.stream.a */
public class C0531a implements Closeable {
    /* renamed from: a */
    private static final char[] f1303a = ")]}'\n".toCharArray();
    /* renamed from: b */
    private final Reader f1304b;
    /* renamed from: c */
    private boolean f1305c = false;
    /* renamed from: d */
    private final char[] f1306d = new char[1024];
    /* renamed from: e */
    private int f1307e = 0;
    /* renamed from: f */
    private int f1308f = 0;
    /* renamed from: g */
    private int f1309g = 0;
    /* renamed from: h */
    private int f1310h = 0;
    /* renamed from: i */
    private int f1311i = 0;
    /* renamed from: j */
    private long f1312j;
    /* renamed from: k */
    private int f1313k;
    /* renamed from: l */
    private String f1314l;
    /* renamed from: m */
    private int[] f1315m = new int[32];
    /* renamed from: n */
    private int f1316n = 0;
    /* renamed from: o */
    private String[] f1317o;
    /* renamed from: p */
    private int[] f1318p;

    static {
        C0581q.f1455a = new C0596b();
    }

    public C0531a(Reader reader) {
        int[] iArr = this.f1315m;
        int i = this.f1316n;
        this.f1316n = i + 1;
        iArr[i] = 6;
        this.f1317o = new String[32];
        this.f1318p = new int[32];
        this.f1304b = reader;
    }

    /* renamed from: a */
    private IOException m1122a(String str) {
        throw new MalformedJsonException(str + " at line " + (this.f1309g + 1) + " column " + m1136u() + " path " + mo5500q());
    }

    /* renamed from: a */
    private void m1123a(int i) {
        if (this.f1316n == this.f1315m.length) {
            Object obj = new int[(this.f1316n * 2)];
            Object obj2 = new int[(this.f1316n * 2)];
            Object obj3 = new String[(this.f1316n * 2)];
            System.arraycopy(this.f1315m, 0, obj, 0, this.f1316n);
            System.arraycopy(this.f1318p, 0, obj2, 0, this.f1316n);
            System.arraycopy(this.f1317o, 0, obj3, 0, this.f1316n);
            this.f1315m = obj;
            this.f1318p = obj2;
            this.f1317o = obj3;
        }
        int[] iArr = this.f1315m;
        int i2 = this.f1316n;
        this.f1316n = i2 + 1;
        iArr[i2] = i;
    }

    /* renamed from: a */
    private boolean m1124a(char c) {
        switch (c) {
            case 9:
            case 10:
            case 12:
            case 13:
            case ' ':
            case MotionEventCompat.AXIS_GENERIC_13 /*44*/:
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                break;
            case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
            case MotionEventCompat.AXIS_GENERIC_16 /*47*/:
            case ';':
            case '=':
            case '\\':
                m1137v();
                break;
            default:
                return true;
        }
        return false;
    }

    /* renamed from: b */
    private int m1126b(boolean z) {
        char[] cArr = this.f1306d;
        int i = this.f1307e;
        int i2 = this.f1308f;
        while (true) {
            if (i == i2) {
                this.f1307e = i;
                if (m1128b(1)) {
                    i = this.f1307e;
                    i2 = this.f1308f;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input at line " + (this.f1309g + 1) + " column " + m1136u());
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == 10) {
                this.f1309g++;
                this.f1310h = i3;
                i = i3;
            } else if (c == ' ' || c == 13 || c == 9) {
                i = i3;
            } else if (c == '/') {
                this.f1307e = i3;
                if (i3 == i2) {
                    this.f1307e--;
                    boolean b = m1128b(2);
                    this.f1307e++;
                    if (!b) {
                        return c;
                    }
                }
                m1137v();
                switch (cArr[this.f1307e]) {
                    case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                        this.f1307e++;
                        String str = "*/";
                        while (true) {
                            if (this.f1307e + str.length() <= this.f1308f || m1128b(str.length())) {
                                if (this.f1306d[this.f1307e] == 10) {
                                    this.f1309g++;
                                    this.f1310h = this.f1307e + 1;
                                } else {
                                    i2 = 0;
                                    while (i2 < str.length()) {
                                        if (this.f1306d[this.f1307e + i2] == str.charAt(i2)) {
                                            i2++;
                                        }
                                    }
                                    i2 = 1;
                                }
                                this.f1307e++;
                            } else {
                                i2 = 0;
                            }
                        }
                        if (i2 != 0) {
                            i = this.f1307e + 2;
                            i2 = this.f1308f;
                            break;
                        }
                        throw m1122a("Unterminated comment");
                    case MotionEventCompat.AXIS_GENERIC_16 /*47*/:
                        this.f1307e++;
                        m1138w();
                        i = this.f1307e;
                        i2 = this.f1308f;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.f1307e = i3;
                m1137v();
                m1138w();
                i = this.f1307e;
                i2 = this.f1308f;
            } else {
                this.f1307e = i3;
                return c;
            }
        }
    }

    /* renamed from: b */
    private String m1127b(char c) {
        char[] cArr = this.f1306d;
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int i = this.f1307e;
            int i2 = this.f1308f;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f1307e = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    return stringBuilder.toString();
                } else if (c2 == '\\') {
                    this.f1307e = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    stringBuilder.append(m1139x());
                    break;
                } else {
                    if (c2 == 10) {
                        this.f1309g++;
                        this.f1310h = i4;
                    }
                    i3 = i4;
                }
            }
            stringBuilder.append(cArr, i, i3 - i);
            this.f1307e = i3;
            if (!m1128b(1)) {
                throw m1122a("Unterminated string");
            }
        }
    }

    /* renamed from: b */
    private boolean m1128b(int i) {
        Object obj = this.f1306d;
        this.f1310h -= this.f1307e;
        if (this.f1308f != this.f1307e) {
            this.f1308f -= this.f1307e;
            System.arraycopy(obj, this.f1307e, obj, 0, this.f1308f);
        } else {
            this.f1308f = 0;
        }
        this.f1307e = 0;
        do {
            int read = this.f1304b.read(obj, this.f1308f, obj.length - this.f1308f);
            if (read == -1) {
                return false;
            }
            this.f1308f = read + this.f1308f;
            if (this.f1309g == 0 && this.f1310h == 0 && this.f1308f > 0 && obj[0] == 65279) {
                this.f1307e++;
                this.f1310h++;
                i++;
            }
        } while (this.f1308f < i);
        return true;
    }

    /* renamed from: c */
    private void m1130c(char c) {
        char[] cArr = this.f1306d;
        while (true) {
            int i = this.f1307e;
            int i2 = this.f1308f;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.f1307e = i3;
                    return;
                } else if (c2 == '\\') {
                    this.f1307e = i3;
                    m1139x();
                    break;
                } else {
                    if (c2 == 10) {
                        this.f1309g++;
                        this.f1310h = i3;
                    }
                    i = i3;
                }
            }
            this.f1307e = i;
            if (!m1128b(1)) {
                throw m1122a("Unterminated string");
            }
        }
    }

    /* renamed from: o */
    private int mo5502o() {
        int b;
        int i = this.f1315m[this.f1316n - 1];
        if (i == 1) {
            this.f1315m[this.f1316n - 1] = 2;
        } else if (i == 2) {
            switch (m1126b(true)) {
                case MotionEventCompat.AXIS_GENERIC_13 /*44*/:
                    break;
                case 59:
                    m1137v();
                    break;
                case 93:
                    this.f1311i = 4;
                    return 4;
                default:
                    throw m1122a("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.f1315m[this.f1316n - 1] = 4;
            if (i == 5) {
                switch (m1126b(true)) {
                    case MotionEventCompat.AXIS_GENERIC_13 /*44*/:
                        break;
                    case 59:
                        m1137v();
                        break;
                    case 125:
                        this.f1311i = 2;
                        return 2;
                    default:
                        throw m1122a("Unterminated object");
                }
            }
            b = m1126b(true);
            switch (b) {
                case 34:
                    this.f1311i = 13;
                    return 13;
                case 39:
                    m1137v();
                    this.f1311i = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.f1311i = 2;
                        return 2;
                    }
                    throw m1122a("Expected name");
                default:
                    m1137v();
                    this.f1307e--;
                    if (m1124a((char) b)) {
                        this.f1311i = 14;
                        return 14;
                    }
                    throw m1122a("Expected name");
            }
        } else if (i == 4) {
            this.f1315m[this.f1316n - 1] = 5;
            switch (m1126b(true)) {
                case 58:
                    break;
                case 61:
                    m1137v();
                    if ((this.f1307e < this.f1308f || m1128b(1)) && this.f1306d[this.f1307e] == '>') {
                        this.f1307e++;
                        break;
                    }
                default:
                    throw m1122a("Expected ':'");
            }
        } else if (i == 6) {
            if (this.f1305c) {
                m1126b(true);
                this.f1307e--;
                if (this.f1307e + f1303a.length <= this.f1308f || m1128b(f1303a.length)) {
                    for (b = 0; b < f1303a.length; b++) {
                        if (this.f1306d[this.f1307e + b] != f1303a[b]) {
                            break;
                        }
                    }
                    this.f1307e += f1303a.length;
                }
            }
            this.f1315m[this.f1316n - 1] = 7;
        } else if (i == 7) {
            if (m1126b(false) == -1) {
                this.f1311i = 17;
                return 17;
            }
            m1137v();
            this.f1307e--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (m1126b(true)) {
            case 34:
                if (this.f1316n == 1) {
                    m1137v();
                }
                this.f1311i = 9;
                return 9;
            case 39:
                m1137v();
                this.f1311i = 8;
                return 8;
            case MotionEventCompat.AXIS_GENERIC_13 /*44*/:
            case 59:
                break;
            case 91:
                this.f1311i = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.f1311i = 4;
                    return 4;
                }
                break;
            case 123:
                this.f1311i = 1;
                return 1;
            default:
                this.f1307e--;
                if (this.f1316n == 1) {
                    m1137v();
                }
                b = m1133r();
                if (b != 0) {
                    return b;
                }
                b = m1134s();
                if (b != 0) {
                    return b;
                }
                if (m1124a(this.f1306d[this.f1307e])) {
                    m1137v();
                    this.f1311i = 10;
                    return 10;
                }
                throw m1122a("Expected value");
        }
        if (i == 1 || i == 2) {
            m1137v();
            this.f1307e--;
            this.f1311i = 7;
            return 7;
        }
        throw m1122a("Unexpected value");
    }

    /* renamed from: r */
    private int m1133r() {
        String str;
        int i;
        char c = this.f1306d[this.f1307e];
        String str2;
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            if (this.f1307e + i2 >= this.f1308f && !m1128b(i2 + 1)) {
                return 0;
            }
            char c2 = this.f1306d[this.f1307e + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
            i2++;
        }
        if ((this.f1307e + length < this.f1308f || m1128b(length + 1)) && m1124a(this.f1306d[this.f1307e + length])) {
            return 0;
        }
        this.f1307e += length;
        this.f1311i = i;
        return i;
    }

    /* renamed from: s */
    private int m1134s() {
        char c;
        char[] cArr = this.f1306d;
        int i = this.f1307e;
        long j = 0;
        Object obj = null;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.f1308f;
        while (true) {
            Object obj2;
            int i6 = i;
            if (i6 + i4 == i5) {
                if (i4 == cArr.length) {
                    return 0;
                }
                if (m1128b(i4 + 1)) {
                    i6 = this.f1307e;
                    i5 = this.f1308f;
                }
            }
            c = cArr[i6 + i4];
            int i7;
            switch (c) {
                case MotionEventCompat.AXIS_GENERIC_12 /*43*/:
                    if (i3 != 5) {
                        return 0;
                    }
                    i = 6;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case MotionEventCompat.AXIS_GENERIC_14 /*45*/:
                    if (i3 == 0) {
                        i = 1;
                        i7 = i2;
                        obj2 = 1;
                        i3 = i7;
                        continue;
                    } else if (i3 == 5) {
                        i = 6;
                        i3 = i2;
                        obj2 = obj;
                        break;
                    } else {
                        return 0;
                    }
                case MotionEventCompat.AXIS_GENERIC_15 /*46*/:
                    if (i3 != 2) {
                        return 0;
                    }
                    i = 3;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case 'E':
                case 'e':
                    if (i3 != 2 && i3 != 4) {
                        return 0;
                    }
                    i = 5;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                default:
                    if (c >= '0' && c <= '9') {
                        if (i3 != 1 && i3 != 0) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 5 && i3 != 6) {
                                        i = i3;
                                        i3 = i2;
                                        obj2 = obj;
                                        break;
                                    }
                                    i = 7;
                                    i3 = i2;
                                    obj2 = obj;
                                    break;
                                }
                                i = 4;
                                i3 = i2;
                                obj2 = obj;
                                break;
                            } else if (j != 0) {
                                long j2 = (10 * j) - ((long) (c - 48));
                                i = (j > -922337203685477580L || (j == -922337203685477580L && j2 < j)) ? 1 : 0;
                                i &= i2;
                                obj2 = obj;
                                j = j2;
                                i7 = i3;
                                i3 = i;
                                i = i7;
                                break;
                            } else {
                                return 0;
                            }
                        }
                        j = (long) (-(c - 48));
                        i = 2;
                        i3 = i2;
                        obj2 = obj;
                        continue;
                    } else {
                        break;
                    }
                    break;
            }
            i4++;
            obj = obj2;
            i2 = i3;
        }
        if (m1124a(c)) {
            return 0;
        }
        if (i3 == 2 && i2 != 0 && (j != Long.MIN_VALUE || obj != null)) {
            if (obj == null) {
                j = -j;
            }
            this.f1312j = j;
            this.f1307e += i4;
            this.f1311i = 15;
            return 15;
        } else if (i3 != 2 && i3 != 4 && i3 != 7) {
            return 0;
        } else {
            this.f1313k = i4;
            this.f1311i = 16;
            return 16;
        }
    }

    /* renamed from: t */
    private String m1135t() {
        String str;
        StringBuilder stringBuilder = null;
        int i = 0;
        while (true) {
            if (this.f1307e + i < this.f1308f) {
                switch (this.f1306d[this.f1307e + i]) {
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                    case MotionEventCompat.AXIS_GENERIC_13 /*44*/:
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
                    case MotionEventCompat.AXIS_GENERIC_16 /*47*/:
                    case ';':
                    case '=':
                    case '\\':
                        m1137v();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.f1306d.length) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(this.f1306d, this.f1307e, i);
                this.f1307e = i + this.f1307e;
                i = !m1128b(1) ? 0 : 0;
            } else if (m1128b(i + 1)) {
            }
        }
        if (stringBuilder == null) {
            str = new String(this.f1306d, this.f1307e, i);
        } else {
            stringBuilder.append(this.f1306d, this.f1307e, i);
            str = stringBuilder.toString();
        }
        this.f1307e = i + this.f1307e;
        return str;
    }

    /* renamed from: u */
    private int m1136u() {
        return (this.f1307e - this.f1310h) + 1;
    }

    /* renamed from: v */
    private void m1137v() {
        if (!this.f1305c) {
            throw m1122a("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* renamed from: w */
    private void m1138w() {
        char c;
        do {
            if (this.f1307e < this.f1308f || m1128b(1)) {
                char[] cArr = this.f1306d;
                int i = this.f1307e;
                this.f1307e = i + 1;
                c = cArr[i];
                if (c == 10) {
                    this.f1309g++;
                    this.f1310h = this.f1307e;
                    return;
                }
            } else {
                return;
            }
        } while (c != 13);
    }

    /* renamed from: x */
    private char m1139x() {
        if (this.f1307e != this.f1308f || m1128b(1)) {
            char[] cArr = this.f1306d;
            int i = this.f1307e;
            this.f1307e = i + 1;
            char c = cArr[i];
            switch (c) {
                case 10:
                    this.f1309g++;
                    this.f1310h = this.f1307e;
                    return c;
                case 'b':
                    return 8;
                case 'f':
                    return 12;
                case 'n':
                    return 10;
                case 'r':
                    return 13;
                case 't':
                    return 9;
                case 'u':
                    if (this.f1307e + 4 <= this.f1308f || m1128b(4)) {
                        int i2 = this.f1307e;
                        int i3 = i2 + 4;
                        int i4 = i2;
                        c = 0;
                        for (i = i4; i < i3; i++) {
                            int i5;
                            char c2 = this.f1306d[i];
                            c = (char) (c << 4);
                            if (c2 >= '0' && c2 <= '9') {
                                i5 = c2 - 48;
                            } else if (c2 >= 'a' && c2 <= 'f') {
                                i5 = (c2 - 97) + 10;
                            } else if (c2 < 'A' || c2 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.f1306d, this.f1307e, 4));
                            } else {
                                i5 = (c2 - 65) + 10;
                            }
                            c = (char) (c + i5);
                        }
                        this.f1307e += 4;
                        return c;
                    }
                    throw m1122a("Unterminated escape sequence");
                default:
                    return c;
            }
        }
        throw m1122a("Unterminated escape sequence");
    }

    /* renamed from: a */
    public void mo5483a() {
        int i = this.f1311i;
        if (i == 0) {
            i = mo5502o();
        }
        if (i == 3) {
            m1123a(1);
            this.f1318p[this.f1316n - 1] = 0;
            this.f1311i = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + mo5490f() + " at line " + (this.f1309g + 1) + " column " + m1136u() + " path " + mo5500q());
    }

    /* renamed from: a */
    public final void mo5484a(boolean z) {
        this.f1305c = z;
    }

    /* renamed from: b */
    public void mo5485b() {
        int i = this.f1311i;
        if (i == 0) {
            i = mo5502o();
        }
        if (i == 4) {
            this.f1316n--;
            int[] iArr = this.f1318p;
            int i2 = this.f1316n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f1311i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + mo5490f() + " at line " + (this.f1309g + 1) + " column " + m1136u() + " path " + mo5500q());
    }

    /* renamed from: c */
    public void mo5486c() {
        int i = this.f1311i;
        if (i == 0) {
            i = mo5502o();
        }
        if (i == 1) {
            m1123a(3);
            this.f1311i = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + mo5490f() + " at line " + (this.f1309g + 1) + " column " + m1136u() + " path " + mo5500q());
    }

    public void close() {
        this.f1311i = 0;
        this.f1315m[0] = 8;
        this.f1316n = 1;
        this.f1304b.close();
    }

    /* renamed from: d */
    public void mo5488d() {
        int i = this.f1311i;
        if (i == 0) {
            i = mo5502o();
        }
        if (i == 2) {
            this.f1316n--;
            this.f1317o[this.f1316n] = null;
            int[] iArr = this.f1318p;
            int i2 = this.f1316n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f1311i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + mo5490f() + " at line " + (this.f1309g + 1) + " column " + m1136u() + " path " + mo5500q());
    }

    /* renamed from: e */
    public boolean mo5489e() {
        int i = this.f1311i;
        if (i == 0) {
            i = mo5502o();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    /* renamed from: f */
    public JsonToken mo5490f() {
        int i = this.f1311i;
        if (i == 0) {
            i = mo5502o();
        }
        switch (i) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* renamed from: g */
    public String mo5491g() {
        String t;
        int i = this.f1311i;
        if (i == 0) {
            i = mo5502o();
        }
        if (i == 14) {
            t = m1135t();
        } else if (i == 12) {
            t = m1127b('\'');
        } else if (i == 13) {
            t = m1127b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + mo5490f() + " at line " + (this.f1309g + 1) + " column " + m1136u() + " path " + mo5500q());
        }
        this.f1311i = 0;
        this.f1317o[this.f1316n - 1] = t;
        return t;
    }

    /* renamed from: h */
    public String mo5492h() {
        String t;
        int i = this.f1311i;
        if (i == 0) {
            i = mo5502o();
        }
        if (i == 10) {
            t = m1135t();
        } else if (i == 8) {
            t = m1127b('\'');
        } else if (i == 9) {
            t = m1127b('\"');
        } else if (i == 11) {
            t = this.f1314l;
            this.f1314l = null;
        } else if (i == 15) {
            t = Long.toString(this.f1312j);
        } else if (i == 16) {
            t = new String(this.f1306d, this.f1307e, this.f1313k);
            this.f1307e += this.f1313k;
        } else {
            throw new IllegalStateException("Expected a string but was " + mo5490f() + " at line " + (this.f1309g + 1) + " column " + m1136u() + " path " + mo5500q());
        }
        this.f1311i = 0;
        int[] iArr = this.f1318p;
        int i2 = this.f1316n - 1;
        iArr[i2] = iArr[i2] + 1;
        return t;
    }

    /* renamed from: i */
    public boolean mo5493i() {
        int i = this.f1311i;
        if (i == 0) {
            i = mo5502o();
        }
        if (i == 5) {
            this.f1311i = 0;
            int[] iArr = this.f1318p;
            i = this.f1316n - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        } else if (i == 6) {
            this.f1311i = 0;
            int[] iArr2 = this.f1318p;
            int i2 = this.f1316n - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + mo5490f() + " at line " + (this.f1309g + 1) + " column " + m1136u() + " path " + mo5500q());
        }
    }

    /* renamed from: j */
    public void mo5494j() {
        int i = this.f1311i;
        if (i == 0) {
            i = mo5502o();
        }
        if (i == 7) {
            this.f1311i = 0;
            int[] iArr = this.f1318p;
            int i2 = this.f1316n - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + mo5490f() + " at line " + (this.f1309g + 1) + " column " + m1136u() + " path " + mo5500q());
    }

    /* renamed from: k */
    public double mo5495k() {
        int i = this.f1311i;
        if (i == 0) {
            i = mo5502o();
        }
        if (i == 15) {
            this.f1311i = 0;
            int[] iArr = this.f1318p;
            int i2 = this.f1316n - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.f1312j;
        }
        if (i == 16) {
            this.f1314l = new String(this.f1306d, this.f1307e, this.f1313k);
            this.f1307e += this.f1313k;
        } else if (i == 8 || i == 9) {
            this.f1314l = m1127b(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.f1314l = m1135t();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + mo5490f() + " at line " + (this.f1309g + 1) + " column " + m1136u() + " path " + mo5500q());
        }
        this.f1311i = 11;
        double parseDouble = Double.parseDouble(this.f1314l);
        if (this.f1305c || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.f1314l = null;
            this.f1311i = 0;
            int[] iArr2 = this.f1318p;
            int i3 = this.f1316n - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + " at line " + (this.f1309g + 1) + " column " + m1136u() + " path " + mo5500q());
    }

    /* renamed from: l */
    public long mo5496l() {
        int i = this.f1311i;
        if (i == 0) {
            i = mo5502o();
        }
        if (i == 15) {
            this.f1311i = 0;
            int[] iArr = this.f1318p;
            int i2 = this.f1316n - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f1312j;
        }
        long parseLong;
        int[] iArr2;
        int i3;
        if (i == 16) {
            this.f1314l = new String(this.f1306d, this.f1307e, this.f1313k);
            this.f1307e += this.f1313k;
        } else if (i == 8 || i == 9) {
            this.f1314l = m1127b(i == 8 ? '\'' : '\"');
            try {
                parseLong = Long.parseLong(this.f1314l);
                this.f1311i = 0;
                iArr2 = this.f1318p;
                i3 = this.f1316n - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + mo5490f() + " at line " + (this.f1309g + 1) + " column " + m1136u() + " path " + mo5500q());
        }
        this.f1311i = 11;
        double parseDouble = Double.parseDouble(this.f1314l);
        parseLong = (long) parseDouble;
        if (((double) parseLong) != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.f1314l + " at line " + (this.f1309g + 1) + " column " + m1136u() + " path " + mo5500q());
        }
        this.f1314l = null;
        this.f1311i = 0;
        iArr2 = this.f1318p;
        i3 = this.f1316n - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseLong;
    }

    /* renamed from: m */
    public int mo5497m() {
        int i = this.f1311i;
        if (i == 0) {
            i = mo5502o();
        }
        int[] iArr;
        int i2;
        if (i == 15) {
            i = (int) this.f1312j;
            if (this.f1312j != ((long) i)) {
                throw new NumberFormatException("Expected an int but was " + this.f1312j + " at line " + (this.f1309g + 1) + " column " + m1136u() + " path " + mo5500q());
            }
            this.f1311i = 0;
            iArr = this.f1318p;
            i2 = this.f1316n - 1;
            iArr[i2] = iArr[i2] + 1;
            return i;
        }
        if (i == 16) {
            this.f1314l = new String(this.f1306d, this.f1307e, this.f1313k);
            this.f1307e += this.f1313k;
        } else if (i == 8 || i == 9) {
            this.f1314l = m1127b(i == 8 ? '\'' : '\"');
            try {
                i = Integer.parseInt(this.f1314l);
                this.f1311i = 0;
                iArr = this.f1318p;
                i2 = this.f1316n - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + mo5490f() + " at line " + (this.f1309g + 1) + " column " + m1136u() + " path " + mo5500q());
        }
        this.f1311i = 11;
        double parseDouble = Double.parseDouble(this.f1314l);
        i = (int) parseDouble;
        if (((double) i) != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.f1314l + " at line " + (this.f1309g + 1) + " column " + m1136u() + " path " + mo5500q());
        }
        this.f1314l = null;
        this.f1311i = 0;
        iArr = this.f1318p;
        i2 = this.f1316n - 1;
        iArr[i2] = iArr[i2] + 1;
        return i;
    }

    /* renamed from: n */
    public void mo5498n() {
        int i = 0;
        do {
            int i2 = this.f1311i;
            if (i2 == 0) {
                i2 = mo5502o();
            }
            if (i2 == 3) {
                m1123a(1);
                i++;
            } else if (i2 == 1) {
                m1123a(3);
                i++;
            } else if (i2 == 4) {
                this.f1316n--;
                i--;
            } else if (i2 == 2) {
                this.f1316n--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                do {
                    i2 = 0;
                    while (this.f1307e + i2 < this.f1308f) {
                        switch (this.f1306d[this.f1307e + i2]) {
                            case 9:
                            case 10:
                            case 12:
                            case 13:
                            case ' ':
                            case MotionEventCompat.AXIS_GENERIC_13 /*44*/:
                            case ':':
                            case '[':
                            case ']':
                            case '{':
                            case '}':
                                break;
                            case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
                            case MotionEventCompat.AXIS_GENERIC_16 /*47*/:
                            case ';':
                            case '=':
                            case '\\':
                                m1137v();
                                break;
                            default:
                                i2++;
                        }
                        this.f1307e = i2 + this.f1307e;
                    }
                    this.f1307e = i2 + this.f1307e;
                } while (m1128b(1));
            } else if (i2 == 8 || i2 == 12) {
                m1130c('\'');
            } else if (i2 == 9 || i2 == 13) {
                m1130c('\"');
            } else if (i2 == 16) {
                this.f1307e += this.f1313k;
            }
            this.f1311i = 0;
        } while (i != 0);
        int[] iArr = this.f1318p;
        int i3 = this.f1316n - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f1317o[this.f1316n - 1] = "null";
    }

    /* renamed from: p */
    public final boolean mo5499p() {
        return this.f1305c;
    }

    /* renamed from: q */
    public final String mo5500q() {
        StringBuilder stringBuilder = new StringBuilder("$");
        int i = this.f1316n;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.f1315m[i2]) {
                case 1:
                case 2:
                    stringBuilder.append('[').append(this.f1318p[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    stringBuilder.append('.');
                    if (this.f1317o[i2] == null) {
                        break;
                    }
                    stringBuilder.append(this.f1317o[i2]);
                    break;
                default:
                    break;
            }
        }
        return stringBuilder.toString();
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + (this.f1309g + 1) + " column " + m1136u();
    }
}
