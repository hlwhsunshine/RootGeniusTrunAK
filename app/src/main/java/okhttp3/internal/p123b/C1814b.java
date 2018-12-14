package okhttp3.internal.p123b;

import android.support.p015v4.view.MotionEventCompat;
import javax.security.auth.x500.X500Principal;

/* renamed from: okhttp3.internal.b.b */
final class C1814b {
    /* renamed from: a */
    private final String f5332a;
    /* renamed from: b */
    private final int f5333b = this.f5332a.length();
    /* renamed from: c */
    private int f5334c;
    /* renamed from: d */
    private int f5335d;
    /* renamed from: e */
    private int f5336e;
    /* renamed from: f */
    private int f5337f;
    /* renamed from: g */
    private char[] f5338g;

    public C1814b(X500Principal x500Principal) {
        this.f5332a = x500Principal.getName("RFC2253");
    }

    /* renamed from: a */
    private int m5005a(int i) {
        if (i + 1 >= this.f5333b) {
            throw new IllegalStateException("Malformed DN: " + this.f5332a);
        }
        int i2;
        int i3;
        char c = this.f5338g[i];
        if (c >= '0' && c <= '9') {
            i2 = c - 48;
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 87;
        } else if (c < 'A' || c > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f5332a);
        } else {
            i2 = c - 55;
        }
        char c2 = this.f5338g[i + 1];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - 48;
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 87;
        } else if (c2 < 'A' || c2 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f5332a);
        } else {
            i3 = c2 - 55;
        }
        return (i2 << 4) + i3;
    }

    /* renamed from: a */
    private String m5006a() {
        while (this.f5334c < this.f5333b && this.f5338g[this.f5334c] == ' ') {
            this.f5334c++;
        }
        if (this.f5334c == this.f5333b) {
            return null;
        }
        this.f5335d = this.f5334c;
        this.f5334c++;
        while (this.f5334c < this.f5333b && this.f5338g[this.f5334c] != '=' && this.f5338g[this.f5334c] != ' ') {
            this.f5334c++;
        }
        if (this.f5334c >= this.f5333b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f5332a);
        }
        this.f5336e = this.f5334c;
        if (this.f5338g[this.f5334c] == ' ') {
            while (this.f5334c < this.f5333b && this.f5338g[this.f5334c] != '=' && this.f5338g[this.f5334c] == ' ') {
                this.f5334c++;
            }
            if (this.f5338g[this.f5334c] != '=' || this.f5334c == this.f5333b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f5332a);
            }
        }
        do {
            this.f5334c++;
            if (this.f5334c >= this.f5333b) {
                break;
            }
        } while (this.f5338g[this.f5334c] == ' ');
        if (this.f5336e - this.f5335d > 4 && this.f5338g[this.f5335d + 3] == '.' && ((this.f5338g[this.f5335d] == 'O' || this.f5338g[this.f5335d] == 'o') && ((this.f5338g[this.f5335d + 1] == 'I' || this.f5338g[this.f5335d + 1] == 'i') && (this.f5338g[this.f5335d + 2] == 'D' || this.f5338g[this.f5335d + 2] == 'd')))) {
            this.f5335d += 4;
        }
        return new String(this.f5338g, this.f5335d, this.f5336e - this.f5335d);
    }

    /* renamed from: b */
    private String m5007b() {
        if (this.f5334c + 4 >= this.f5333b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f5332a);
        }
        int i;
        this.f5335d = this.f5334c;
        this.f5334c++;
        while (this.f5334c != this.f5333b && this.f5338g[this.f5334c] != '+' && this.f5338g[this.f5334c] != ',' && this.f5338g[this.f5334c] != ';') {
            int i2;
            if (this.f5338g[this.f5334c] == ' ') {
                this.f5336e = this.f5334c;
                this.f5334c++;
                while (this.f5334c < this.f5333b && this.f5338g[this.f5334c] == ' ') {
                    this.f5334c++;
                }
                i = this.f5336e - this.f5335d;
                if (i >= 5 || (i & 1) == 0) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f5332a);
                }
                byte[] bArr = new byte[(i / 2)];
                int i3 = this.f5335d + 1;
                for (i2 = 0; i2 < bArr.length; i2++) {
                    bArr[i2] = (byte) m5005a(i3);
                    i3 += 2;
                }
                return new String(this.f5338g, this.f5335d, i);
            }
            if (this.f5338g[this.f5334c] >= 'A' && this.f5338g[this.f5334c] <= 'F') {
                char[] cArr = this.f5338g;
                i2 = this.f5334c;
                cArr[i2] = (char) (cArr[i2] + 32);
            }
            this.f5334c++;
        }
        this.f5336e = this.f5334c;
        i = this.f5336e - this.f5335d;
        if (i >= 5) {
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f5332a);
    }

    /* renamed from: c */
    private String m5008c() {
        this.f5335d = this.f5334c;
        this.f5336e = this.f5334c;
        while (this.f5334c < this.f5333b) {
            char[] cArr;
            int i;
            switch (this.f5338g[this.f5334c]) {
                case ' ':
                    this.f5337f = this.f5336e;
                    this.f5334c++;
                    cArr = this.f5338g;
                    i = this.f5336e;
                    this.f5336e = i + 1;
                    cArr[i] = ' ';
                    while (this.f5334c < this.f5333b && this.f5338g[this.f5334c] == ' ') {
                        cArr = this.f5338g;
                        i = this.f5336e;
                        this.f5336e = i + 1;
                        cArr[i] = ' ';
                        this.f5334c++;
                    }
                    if (this.f5334c != this.f5333b && this.f5338g[this.f5334c] != ',' && this.f5338g[this.f5334c] != '+' && this.f5338g[this.f5334c] != ';') {
                        break;
                    }
                    return new String(this.f5338g, this.f5335d, this.f5337f - this.f5335d);
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /*43*/:
                case MotionEventCompat.AXIS_GENERIC_13 /*44*/:
                case ';':
                    return new String(this.f5338g, this.f5335d, this.f5336e - this.f5335d);
                case '\\':
                    cArr = this.f5338g;
                    i = this.f5336e;
                    this.f5336e = i + 1;
                    cArr[i] = m5009d();
                    this.f5334c++;
                    break;
                default:
                    cArr = this.f5338g;
                    i = this.f5336e;
                    this.f5336e = i + 1;
                    cArr[i] = this.f5338g[this.f5334c];
                    this.f5334c++;
                    break;
            }
        }
        return new String(this.f5338g, this.f5335d, this.f5336e - this.f5335d);
    }

    /* renamed from: d */
    private char m5009d() {
        this.f5334c++;
        if (this.f5334c == this.f5333b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f5332a);
        }
        switch (this.f5338g[this.f5334c]) {
            case ' ':
            case '\"':
            case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
            case MotionEventCompat.AXIS_GENERIC_6 /*37*/:
            case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
            case MotionEventCompat.AXIS_GENERIC_12 /*43*/:
            case MotionEventCompat.AXIS_GENERIC_13 /*44*/:
            case ';':
            case '<':
            case '=':
            case '>':
            case '\\':
            case '_':
                return this.f5338g[this.f5334c];
            default:
                return m5010e();
        }
    }

    /* renamed from: e */
    private char m5010e() {
        int a = m5005a(this.f5334c);
        this.f5334c++;
        if (a < 128) {
            return (char) a;
        }
        if (a < 192 || a > 247) {
            return '?';
        }
        int i;
        if (a <= 223) {
            i = 1;
            a &= 31;
        } else if (a <= 239) {
            i = 2;
            a &= 15;
        } else {
            i = 3;
            a &= 7;
        }
        int i2 = a;
        for (a = 0; a < i; a++) {
            this.f5334c++;
            if (this.f5334c == this.f5333b || this.f5338g[this.f5334c] != '\\') {
                return '?';
            }
            this.f5334c++;
            int a2 = m5005a(this.f5334c);
            this.f5334c++;
            if ((a2 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a2 & 63);
        }
        return (char) i2;
    }

    /* renamed from: a */
    public final String mo8693a(String str) {
        this.f5334c = 0;
        this.f5335d = 0;
        this.f5336e = 0;
        this.f5337f = 0;
        this.f5338g = this.f5332a.toCharArray();
        String a = m5006a();
        if (a == null) {
            return null;
        }
        do {
            String str2 = "";
            if (this.f5334c == this.f5333b) {
                return null;
            }
            switch (this.f5338g[this.f5334c]) {
                case '\"':
                    this.f5334c++;
                    this.f5335d = this.f5334c;
                    this.f5336e = this.f5335d;
                    while (this.f5334c != this.f5333b) {
                        if (this.f5338g[this.f5334c] == '\"') {
                            this.f5334c++;
                            while (this.f5334c < this.f5333b && this.f5338g[this.f5334c] == ' ') {
                                this.f5334c++;
                            }
                            str2 = new String(this.f5338g, this.f5335d, this.f5336e - this.f5335d);
                            break;
                        }
                        if (this.f5338g[this.f5334c] == '\\') {
                            this.f5338g[this.f5336e] = m5009d();
                        } else {
                            this.f5338g[this.f5336e] = this.f5338g[this.f5334c];
                        }
                        this.f5334c++;
                        this.f5336e++;
                    }
                    throw new IllegalStateException("Unexpected end of DN: " + this.f5332a);
                case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
                    str2 = m5007b();
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /*43*/:
                case MotionEventCompat.AXIS_GENERIC_13 /*44*/:
                case ';':
                    break;
                default:
                    str2 = m5008c();
                    break;
            }
            if (str.equalsIgnoreCase(a)) {
                return str2;
            }
            if (this.f5334c >= this.f5333b) {
                return null;
            }
            if (this.f5338g[this.f5334c] == ',' || this.f5338g[this.f5334c] == ';' || this.f5338g[this.f5334c] == '+') {
                this.f5334c++;
                a = m5006a();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.f5332a);
            }
        } while (a != null);
        throw new IllegalStateException("Malformed DN: " + this.f5332a);
    }
}
