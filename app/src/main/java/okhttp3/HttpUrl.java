package okhttp3;

import android.support.p015v4.internal.view.SupportMenu;
import android.support.p015v4.media.TransportMediator;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.C1910m;
import okio.C1939e;

public final class HttpUrl {
    /* renamed from: a */
    private static final char[] f5215a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* renamed from: b */
    private final String f5216b;
    /* renamed from: c */
    private final String f5217c;
    /* renamed from: d */
    private final String f5218d;
    /* renamed from: e */
    private final String f5219e;
    /* renamed from: f */
    private final int f5220f;
    /* renamed from: g */
    private final List<String> f5221g;
    /* renamed from: h */
    private final List<String> f5222h;
    /* renamed from: i */
    private final String f5223i;
    /* renamed from: j */
    private final String f5224j;

    public static final class Builder {
        /* renamed from: a */
        String f5207a;
        /* renamed from: b */
        String f5208b = "";
        /* renamed from: c */
        String f5209c = "";
        /* renamed from: d */
        String f5210d;
        /* renamed from: e */
        int f5211e = -1;
        /* renamed from: f */
        final List<String> f5212f = new ArrayList();
        /* renamed from: g */
        List<String> f5213g;
        /* renamed from: h */
        String f5214h;

        enum ParseResult {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public Builder() {
            this.f5212f.add("");
        }

        /* renamed from: a */
        private void m4832a(String str, int i, int i2) {
            if (i != i2) {
                int i3;
                char charAt = str.charAt(i);
                if (charAt == '/' || charAt == '\\') {
                    this.f5212f.clear();
                    this.f5212f.add("");
                    i3 = i + 1;
                } else {
                    this.f5212f.set(this.f5212f.size() - 1, "");
                    i3 = i;
                }
                while (i3 < i2) {
                    int a = C1910m.m5444a(str, i3, i2, "/\\");
                    boolean z = a < i2;
                    String a2 = HttpUrl.m4844a(str, i3, a, " \"<>^`{}|/\\?#", true, false, false, true);
                    boolean z2 = a2.equals(".") || a2.equalsIgnoreCase("%2e");
                    if (!z2) {
                        z2 = a2.equals("..") || a2.equalsIgnoreCase("%2e.") || a2.equalsIgnoreCase(".%2e") || a2.equalsIgnoreCase("%2e%2e");
                        if (!z2) {
                            if (((String) this.f5212f.get(this.f5212f.size() - 1)).isEmpty()) {
                                this.f5212f.set(this.f5212f.size() - 1, a2);
                            } else {
                                this.f5212f.add(a2);
                            }
                            if (z) {
                                this.f5212f.add("");
                            }
                        } else if (!((String) this.f5212f.remove(this.f5212f.size() - 1)).isEmpty() || this.f5212f.isEmpty()) {
                            this.f5212f.add("");
                        } else {
                            this.f5212f.set(this.f5212f.size() - 1, "");
                        }
                    }
                    if (z) {
                        a++;
                    }
                    i3 = a;
                }
            }
        }

        /* JADX WARNING: Missing block: B:6:0x000f, code:
            if (r0 >= r5) goto L_0x000a;
     */
        /* renamed from: b */
        private static int m4833b(java.lang.String r3, int r4, int r5) {
            /*
            r0 = r4;
        L_0x0001:
            if (r0 >= r5) goto L_0x001a;
        L_0x0003:
            r1 = r3.charAt(r0);
            switch(r1) {
                case 58: goto L_0x001b;
                case 91: goto L_0x000d;
                default: goto L_0x000a;
            };
        L_0x000a:
            r0 = r0 + 1;
            goto L_0x0001;
        L_0x000d:
            r0 = r0 + 1;
            if (r0 >= r5) goto L_0x000a;
        L_0x0011:
            r1 = r3.charAt(r0);
            r2 = 93;
            if (r1 != r2) goto L_0x000d;
        L_0x0019:
            goto L_0x000a;
        L_0x001a:
            r0 = r5;
        L_0x001b:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.b(java.lang.String, int, int):int");
        }

        /* renamed from: c */
        private static String m4834c(String str, int i, int i2) {
            int i3 = 0;
            String a = HttpUrl.m4845a(str, i, i2, false);
            if (!a.contains(":")) {
                return C1910m.m5462b(a);
            }
            InetAddress d = (a.startsWith("[") && a.endsWith("]")) ? m4835d(a, 1, a.length() - 1) : m4835d(a, 0, a.length());
            if (d == null) {
                return null;
            }
            byte[] address = d.getAddress();
            if (address.length == 16) {
                int i4 = 0;
                int i5 = -1;
                int i6 = 0;
                while (i6 < address.length) {
                    int i7 = i6;
                    while (i7 < 16 && address[i7] == (byte) 0 && address[i7 + 1] == (byte) 0) {
                        i7 += 2;
                    }
                    int i8 = i7 - i6;
                    if (i8 > i4) {
                        i4 = i8;
                        i5 = i6;
                    }
                    i6 = i7 + 2;
                }
                C1939e c1939e = new C1939e();
                while (i3 < address.length) {
                    if (i3 == i5) {
                        c1939e.mo9020h(58);
                        i3 += i4;
                        if (i3 == 16) {
                            c1939e.mo9020h(58);
                        }
                    } else {
                        if (i3 > 0) {
                            c1939e.mo9020h(58);
                        }
                        c1939e.mo9021i((long) (((address[i3] & 255) << 8) | (address[i3 + 1] & 255)));
                        i3 += 2;
                    }
                }
                return c1939e.mo9062n();
            }
            throw new AssertionError();
        }

        /* renamed from: d */
        private static InetAddress m4835d(String str, int i, int i2) {
            Object obj = new byte[16];
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            int i6 = i;
            while (i6 < i2) {
                if (i3 == 16) {
                    return null;
                }
                int i7;
                int i8;
                int i9;
                if (i6 + 2 > i2 || !str.regionMatches(i6, "::", 0, 2)) {
                    if (i3 == 0) {
                        i7 = i4;
                        i4 = i3;
                        i3 = i6;
                        i6 = i7;
                    } else if (str.regionMatches(i6, ":", 0, 1)) {
                        i7 = i4;
                        i4 = i3;
                        i3 = i6 + 1;
                        i6 = i7;
                    } else if (!str.regionMatches(i6, ".", 0, 1)) {
                        return null;
                    } else {
                        Object obj2;
                        int i10 = i3 - 2;
                        i8 = i10;
                        i6 = i5;
                        loop2:
                        while (i6 < i2) {
                            if (i8 == 16) {
                                obj2 = null;
                                break;
                            }
                            if (i8 != i10) {
                                if (str.charAt(i6) != '.') {
                                    obj2 = null;
                                    break;
                                }
                                i6++;
                            }
                            i9 = 0;
                            i5 = i6;
                            while (i5 < i2) {
                                char charAt = str.charAt(i5);
                                if (charAt >= '0' && charAt <= '9') {
                                    if (i9 == 0 && i6 != i5) {
                                        obj2 = null;
                                        break loop2;
                                    }
                                    i9 = ((i9 * 10) + charAt) - 48;
                                    if (i9 > 255) {
                                        obj2 = null;
                                        break loop2;
                                    }
                                    i5++;
                                } else {
                                    break;
                                }
                            }
                            if (i5 - i6 == 0) {
                                obj2 = null;
                                break;
                            }
                            i6 = i8 + 1;
                            obj[i8] = (byte) i9;
                            i8 = i6;
                            i6 = i5;
                        }
                        obj2 = i8 != i10 + 4 ? null : 1;
                        if (obj2 == null) {
                            return null;
                        }
                        i6 = i3 + 2;
                    }
                } else if (i4 != -1) {
                    return null;
                } else {
                    i4 = i6 + 2;
                    i6 = i3 + 2;
                    if (i4 == i2) {
                        i4 = i6;
                        break;
                    }
                    i3 = i4;
                    i4 = i6;
                }
                i9 = 0;
                i5 = i3;
                while (i5 < i2) {
                    i8 = HttpUrl.m4842a(str.charAt(i5));
                    if (i8 == -1) {
                        break;
                    }
                    i9 = (i9 << 4) + i8;
                    i5++;
                }
                i8 = i5 - i3;
                if (i8 == 0 || i8 > 4) {
                    return null;
                }
                i8 = i4 + 1;
                obj[i4] = (byte) ((i9 >>> 8) & 255);
                i4 = i8 + 1;
                obj[i8] = (byte) (i9 & 255);
                i7 = i3;
                i3 = i4;
                i4 = i6;
                i6 = i5;
                i5 = i7;
            }
            i6 = i3;
            if (i6 != 16) {
                if (i4 == -1) {
                    return null;
                }
                System.arraycopy(obj, i4, obj, 16 - (i6 - i4), i6 - i4);
                Arrays.fill(obj, i4, (16 - i6) + i4, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(obj);
            } catch (UnknownHostException e) {
                throw new AssertionError();
            }
        }

        /* renamed from: e */
        private static int m4836e(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(HttpUrl.m4844a(str, i, i2, "", false, false, false, true));
                return (parseInt <= 0 || parseInt > SupportMenu.USER_MASK) ? -1 : parseInt;
            } catch (NumberFormatException e) {
                return -1;
            }
        }

        /* renamed from: a */
        final int mo8575a() {
            return this.f5211e != -1 ? this.f5211e : HttpUrl.m4843a(this.f5207a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:52:0x00a4  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x002e  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x00f1  */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x00cb  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x00d3 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x00f3  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x002e  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x00a4  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00b3 A:{SKIP} */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x00cb  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x00f1  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x00d3 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x00f3  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x018a  */
        /* renamed from: a */
        final okhttp3.HttpUrl.Builder.ParseResult mo8576a(okhttp3.HttpUrl r14, java.lang.String r15) {
            /*
            r13 = this;
            r0 = 0;
            r1 = r15.length();
            r2 = okhttp3.internal.C1910m.m5442a(r15, r0, r1);
            r0 = r15.length();
            r11 = okhttp3.internal.C1910m.m5461b(r15, r2, r0);
            r0 = r11 - r2;
            r1 = 2;
            if (r0 < r1) goto L_0x008c;
        L_0x0016:
            r0 = r15.charAt(r2);
            r1 = 97;
            if (r0 < r1) goto L_0x0022;
        L_0x001e:
            r1 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
            if (r0 <= r1) goto L_0x0057;
        L_0x0022:
            r1 = 65;
            if (r0 < r1) goto L_0x002a;
        L_0x0026:
            r1 = 90;
            if (r0 <= r1) goto L_0x0057;
        L_0x002a:
            r0 = -1;
        L_0x002b:
            r1 = -1;
            if (r0 == r1) goto L_0x00a4;
        L_0x002e:
            r1 = 1;
            r3 = "https:";
            r4 = 0;
            r5 = 6;
            r0 = r15;
            r0 = r0.regionMatches(r1, r2, r3, r4, r5);
            if (r0 == 0) goto L_0x008e;
        L_0x003a:
            r0 = "https";
            r13.f5207a = r0;
            r2 = r2 + 6;
        L_0x0040:
            r9 = 0;
            r8 = 0;
            r0 = 0;
            r1 = r2;
        L_0x0044:
            if (r1 >= r11) goto L_0x00b0;
        L_0x0046:
            r3 = r15.charAt(r1);
            r4 = 92;
            if (r3 == r4) goto L_0x0052;
        L_0x004e:
            r4 = 47;
            if (r3 != r4) goto L_0x00b0;
        L_0x0052:
            r0 = r0 + 1;
            r1 = r1 + 1;
            goto L_0x0044;
        L_0x0057:
            r0 = r2 + 1;
        L_0x0059:
            if (r0 >= r11) goto L_0x008c;
        L_0x005b:
            r1 = r15.charAt(r0);
            r3 = 97;
            if (r1 < r3) goto L_0x0067;
        L_0x0063:
            r3 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
            if (r1 <= r3) goto L_0x0089;
        L_0x0067:
            r3 = 65;
            if (r1 < r3) goto L_0x006f;
        L_0x006b:
            r3 = 90;
            if (r1 <= r3) goto L_0x0089;
        L_0x006f:
            r3 = 48;
            if (r1 < r3) goto L_0x0077;
        L_0x0073:
            r3 = 57;
            if (r1 <= r3) goto L_0x0089;
        L_0x0077:
            r3 = 43;
            if (r1 == r3) goto L_0x0089;
        L_0x007b:
            r3 = 45;
            if (r1 == r3) goto L_0x0089;
        L_0x007f:
            r3 = 46;
            if (r1 == r3) goto L_0x0089;
        L_0x0083:
            r3 = 58;
            if (r1 == r3) goto L_0x002b;
        L_0x0087:
            r0 = -1;
            goto L_0x002b;
        L_0x0089:
            r0 = r0 + 1;
            goto L_0x0059;
        L_0x008c:
            r0 = -1;
            goto L_0x002b;
        L_0x008e:
            r1 = 1;
            r3 = "http:";
            r4 = 0;
            r5 = 5;
            r0 = r15;
            r0 = r0.regionMatches(r1, r2, r3, r4, r5);
            if (r0 == 0) goto L_0x00a1;
        L_0x009a:
            r0 = "http";
            r13.f5207a = r0;
            r2 = r2 + 5;
            goto L_0x0040;
        L_0x00a1:
            r0 = okhttp3.HttpUrl.Builder.ParseResult.UNSUPPORTED_SCHEME;
        L_0x00a3:
            return r0;
        L_0x00a4:
            if (r14 == 0) goto L_0x00ad;
        L_0x00a6:
            r0 = r14.f5216b;
            r13.f5207a = r0;
            goto L_0x0040;
        L_0x00ad:
            r0 = okhttp3.HttpUrl.Builder.ParseResult.MISSING_SCHEME;
            goto L_0x00a3;
        L_0x00b0:
            r1 = 2;
            if (r0 >= r1) goto L_0x00c1;
        L_0x00b3:
            if (r14 == 0) goto L_0x00c1;
        L_0x00b5:
            r1 = r14.f5216b;
            r3 = r13.f5207a;
            r1 = r1.equals(r3);
            if (r1 != 0) goto L_0x01c9;
        L_0x00c1:
            r1 = r2 + r0;
        L_0x00c3:
            r0 = "@/\\?#";
            r10 = okhttp3.internal.C1910m.m5444a(r15, r1, r11, r0);
            if (r10 == r11) goto L_0x00f1;
        L_0x00cb:
            r0 = r15.charAt(r10);
        L_0x00cf:
            switch(r0) {
                case -1: goto L_0x00d3;
                case 35: goto L_0x00d3;
                case 47: goto L_0x00d3;
                case 63: goto L_0x00d3;
                case 64: goto L_0x00f3;
                case 92: goto L_0x00d3;
                default: goto L_0x00d2;
            };
        L_0x00d2:
            goto L_0x00c3;
        L_0x00d3:
            r0 = m4833b(r15, r1, r10);
            r2 = r0 + 1;
            if (r2 >= r10) goto L_0x0168;
        L_0x00db:
            r1 = m4834c(r15, r1, r0);
            r13.f5210d = r1;
            r0 = r0 + 1;
            r0 = m4836e(r15, r0, r10);
            r13.f5211e = r0;
            r0 = r13.f5211e;
            r1 = -1;
            if (r0 != r1) goto L_0x0176;
        L_0x00ee:
            r0 = okhttp3.HttpUrl.Builder.ParseResult.INVALID_PORT;
            goto L_0x00a3;
        L_0x00f1:
            r0 = -1;
            goto L_0x00cf;
        L_0x00f3:
            if (r8 != 0) goto L_0x013e;
        L_0x00f5:
            r0 = 58;
            r2 = okhttp3.internal.C1910m.m5443a(r15, r1, r10, r0);
            r3 = " \"':;<=>@[]^`{}|/\\?#";
            r4 = 1;
            r5 = 0;
            r6 = 0;
            r7 = 1;
            r0 = r15;
            r0 = okhttp3.HttpUrl.m4844a(r0, r1, r2, r3, r4, r5, r6, r7);
            if (r9 == 0) goto L_0x0121;
        L_0x0108:
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r3 = r13.f5208b;
            r1 = r1.append(r3);
            r3 = "%40";
            r1 = r1.append(r3);
            r0 = r1.append(r0);
            r0 = r0.toString();
        L_0x0121:
            r13.f5208b = r0;
            if (r2 == r10) goto L_0x0136;
        L_0x0125:
            r8 = 1;
            r1 = r2 + 1;
            r3 = " \"':;<=>@[]^`{}|/\\?#";
            r4 = 1;
            r5 = 0;
            r6 = 0;
            r7 = 1;
            r0 = r15;
            r2 = r10;
            r0 = okhttp3.HttpUrl.m4844a(r0, r1, r2, r3, r4, r5, r6, r7);
            r13.f5209c = r0;
        L_0x0136:
            r0 = r8;
            r1 = 1;
        L_0x0138:
            r2 = r10 + 1;
            r8 = r0;
            r9 = r1;
            r1 = r2;
            goto L_0x00c3;
        L_0x013e:
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r2 = r13.f5209c;
            r0 = r0.append(r2);
            r2 = "%40";
            r12 = r0.append(r2);
            r3 = " \"':;<=>@[]^`{}|/\\?#";
            r4 = 1;
            r5 = 0;
            r6 = 0;
            r7 = 1;
            r0 = r15;
            r2 = r10;
            r0 = okhttp3.HttpUrl.m4844a(r0, r1, r2, r3, r4, r5, r6, r7);
            r0 = r12.append(r0);
            r0 = r0.toString();
            r13.f5209c = r0;
            r0 = r8;
            r1 = r9;
            goto L_0x0138;
        L_0x0168:
            r0 = m4834c(r15, r1, r0);
            r13.f5210d = r0;
            r0 = r13.f5207a;
            r0 = okhttp3.HttpUrl.m4843a(r0);
            r13.f5211e = r0;
        L_0x0176:
            r0 = r13.f5210d;
            if (r0 != 0) goto L_0x017e;
        L_0x017a:
            r0 = okhttp3.HttpUrl.Builder.ParseResult.INVALID_HOST;
            goto L_0x00a3;
        L_0x017e:
            r2 = r10;
        L_0x017f:
            r0 = "?#";
            r0 = okhttp3.internal.C1910m.m5444a(r15, r2, r11, r0);
            r13.m4832a(r15, r2, r0);
            if (r0 >= r11) goto L_0x0202;
        L_0x018a:
            r1 = r15.charAt(r0);
            r2 = 63;
            if (r1 != r2) goto L_0x0202;
        L_0x0192:
            r1 = 35;
            r2 = okhttp3.internal.C1910m.m5443a(r15, r0, r11, r1);
            r1 = r0 + 1;
            r3 = " \"'<>#";
            r4 = 1;
            r5 = 0;
            r6 = 1;
            r7 = 1;
            r0 = r15;
            r0 = okhttp3.HttpUrl.m4844a(r0, r1, r2, r3, r4, r5, r6, r7);
            r0 = okhttp3.HttpUrl.m4853b(r0);
            r13.f5213g = r0;
        L_0x01ab:
            if (r2 >= r11) goto L_0x01c5;
        L_0x01ad:
            r0 = r15.charAt(r2);
            r1 = 35;
            if (r0 != r1) goto L_0x01c5;
        L_0x01b5:
            r1 = r2 + 1;
            r3 = "";
            r4 = 1;
            r5 = 0;
            r6 = 0;
            r7 = 0;
            r0 = r15;
            r2 = r11;
            r0 = okhttp3.HttpUrl.m4844a(r0, r1, r2, r3, r4, r5, r6, r7);
            r13.f5214h = r0;
        L_0x01c5:
            r0 = okhttp3.HttpUrl.Builder.ParseResult.SUCCESS;
            goto L_0x00a3;
        L_0x01c9:
            r0 = r14.mo8585d();
            r13.f5208b = r0;
            r0 = r14.mo8586e();
            r13.f5209c = r0;
            r0 = r14.f5219e;
            r13.f5210d = r0;
            r0 = r14.f5220f;
            r13.f5211e = r0;
            r0 = r13.f5212f;
            r0.clear();
            r0 = r13.f5212f;
            r1 = r14.mo8592i();
            r0.addAll(r1);
            if (r2 == r11) goto L_0x01f9;
        L_0x01f1:
            r0 = r15.charAt(r2);
            r1 = 35;
            if (r0 != r1) goto L_0x017f;
        L_0x01f9:
            r0 = r14.mo8593j();
            r13.mo8578b(r0);
            goto L_0x017f;
        L_0x0202:
            r2 = r0;
            goto L_0x01ab;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.a(okhttp3.HttpUrl, java.lang.String):okhttp3.HttpUrl$Builder$ParseResult");
        }

        /* renamed from: a */
        public final Builder mo8577a(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String c = m4834c(str, 0, str.length());
            if (c == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.f5210d = c;
            return this;
        }

        /* renamed from: b */
        public final Builder mo8578b(String str) {
            this.f5213g = str != null ? HttpUrl.m4853b(HttpUrl.m4846a(str, " \"'<>#", false, true, true)) : null;
            return this;
        }

        /* renamed from: b */
        public final HttpUrl mo8579b() {
            if (this.f5207a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f5210d != null) {
                return new HttpUrl(this, (byte) 0);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f5207a);
            stringBuilder.append("://");
            if (!(this.f5208b.isEmpty() && this.f5209c.isEmpty())) {
                stringBuilder.append(this.f5208b);
                if (!this.f5209c.isEmpty()) {
                    stringBuilder.append(':');
                    stringBuilder.append(this.f5209c);
                }
                stringBuilder.append('@');
            }
            if (this.f5210d.indexOf(58) != -1) {
                stringBuilder.append('[');
                stringBuilder.append(this.f5210d);
                stringBuilder.append(']');
            } else {
                stringBuilder.append(this.f5210d);
            }
            int a = mo8575a();
            if (a != HttpUrl.m4843a(this.f5207a)) {
                stringBuilder.append(':');
                stringBuilder.append(a);
            }
            HttpUrl.m4850a(stringBuilder, this.f5212f);
            if (this.f5213g != null) {
                stringBuilder.append('?');
                HttpUrl.m4854b(stringBuilder, this.f5213g);
            }
            if (this.f5214h != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.f5214h);
            }
            return stringBuilder.toString();
        }
    }

    private HttpUrl(Builder builder) {
        String str = null;
        this.f5216b = builder.f5207a;
        this.f5217c = m4847a(builder.f5208b, false);
        this.f5218d = m4847a(builder.f5209c, false);
        this.f5219e = builder.f5210d;
        this.f5220f = builder.mo8575a();
        this.f5221g = m4849a(builder.f5212f, false);
        this.f5222h = builder.f5213g != null ? m4849a(builder.f5213g, true) : null;
        if (builder.f5214h != null) {
            str = m4847a(builder.f5214h, false);
        }
        this.f5223i = str;
        this.f5224j = builder.toString();
    }

    /* synthetic */ HttpUrl(Builder builder, byte b) {
        this(builder);
    }

    /* renamed from: a */
    static int m4842a(char c) {
        return (c < '0' || c > '9') ? (c < 'a' || c > 'f') ? (c < 'A' || c > 'F') ? -1 : (c - 65) + 10 : (c - 97) + 10 : c - 48;
    }

    /* renamed from: a */
    public static int m4843a(String str) {
        return str.equals("http") ? 80 : str.equals("https") ? 443 : -1;
    }

    /* renamed from: a */
    static String m4844a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt < 32 || codePointAt == TransportMediator.KEYCODE_MEDIA_PAUSE || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z || (z2 && !m4851a(str, i3, i2)))) || (codePointAt == 43 && z3)))) {
                C1939e c1939e = new C1939e();
                c1939e.mo9044a(str, i, i3);
                int i4 = i3;
                C1939e c1939e2 = null;
                while (i4 < i2) {
                    int codePointAt2 = str.codePointAt(i4);
                    if (!(z && (codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13))) {
                        if (codePointAt2 == 43 && z3) {
                            c1939e.mo9012b(z ? "+" : "%2B");
                        } else if (codePointAt2 < 32 || codePointAt2 == TransportMediator.KEYCODE_MEDIA_PAUSE || ((codePointAt2 >= 128 && z4) || str2.indexOf(codePointAt2) != -1 || (codePointAt2 == 37 && (!z || (z2 && !m4851a(str, i4, i2)))))) {
                            if (c1939e2 == null) {
                                c1939e2 = new C1939e();
                            }
                            c1939e2.mo9042a(codePointAt2);
                            while (!c1939e2.mo9028e()) {
                                codePointAt = c1939e2.mo9032g() & 255;
                                c1939e.mo9020h(37);
                                c1939e.mo9020h(f5215a[(codePointAt >> 4) & 15]);
                                c1939e.mo9020h(f5215a[codePointAt & 15]);
                            }
                        } else {
                            c1939e.mo9042a(codePointAt2);
                        }
                    }
                    i4 = Character.charCount(codePointAt2) + i4;
                }
                return c1939e.mo9062n();
            }
            i3 += Character.charCount(codePointAt);
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static String m4845a(String str, int i, int i2, boolean z) {
        int i3 = i;
        while (i3 < i2) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                C1939e c1939e = new C1939e();
                c1939e.mo9044a(str, i, i3);
                while (i3 < i2) {
                    int codePointAt = str.codePointAt(i3);
                    if (codePointAt != 37 || i3 + 2 >= i2) {
                        if (codePointAt == 43 && z) {
                            c1939e.mo9020h(32);
                        }
                        c1939e.mo9042a(codePointAt);
                    } else {
                        int a = m4842a(str.charAt(i3 + 1));
                        int a2 = m4842a(str.charAt(i3 + 2));
                        if (!(a == -1 || a2 == -1)) {
                            c1939e.mo9020h((a << 4) + a2);
                            i3 += 2;
                        }
                        c1939e.mo9042a(codePointAt);
                    }
                    i3 += Character.charCount(codePointAt);
                }
                return c1939e.mo9062n();
            }
            i3++;
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static String m4846a(String str, String str2, boolean z, boolean z2, boolean z3) {
        return m4844a(str, 0, str.length(), str2, true, z, z2, z3);
    }

    /* renamed from: a */
    private static String m4847a(String str, boolean z) {
        return m4845a(str, 0, str.length(), z);
    }

    /* renamed from: a */
    private static List<String> m4849a(List<String> list, boolean z) {
        List arrayList = new ArrayList(list.size());
        for (String str : list) {
            arrayList.add(str != null ? m4847a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    static void m4850a(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append('/');
            stringBuilder.append((String) list.get(i));
        }
    }

    /* renamed from: a */
    private static boolean m4851a(String str, int i, int i2) {
        return i + 2 < i2 && str.charAt(i) == '%' && m4842a(str.charAt(i + 1)) != -1 && m4842a(str.charAt(i + 2)) != -1;
    }

    /* renamed from: b */
    static List<String> m4853b(String str) {
        List<String> arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    /* renamed from: b */
    static void m4854b(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(str);
            if (str2 != null) {
                stringBuilder.append('=');
                stringBuilder.append(str2);
            }
        }
    }

    /* renamed from: d */
    public static HttpUrl m4856d(String str) {
        Builder builder = new Builder();
        return builder.mo8576a(null, str) == ParseResult.SUCCESS ? builder.mo8579b() : null;
    }

    /* renamed from: a */
    public final URI mo8581a() {
        int i;
        Builder builder = new Builder();
        builder.f5207a = this.f5216b;
        builder.f5208b = mo8585d();
        builder.f5209c = mo8586e();
        builder.f5210d = this.f5219e;
        builder.f5211e = this.f5220f != m4843a(this.f5216b) ? this.f5220f : -1;
        builder.f5212f.clear();
        builder.f5212f.addAll(mo8592i());
        builder.mo8578b(mo8593j());
        builder.f5214h = this.f5223i == null ? null : this.f5224j.substring(this.f5224j.indexOf(35) + 1);
        int size = builder.f5212f.size();
        for (i = 0; i < size; i++) {
            builder.f5212f.set(i, m4846a((String) builder.f5212f.get(i), "[]", true, false, true));
        }
        if (builder.f5213g != null) {
            size = builder.f5213g.size();
            for (i = 0; i < size; i++) {
                String str = (String) builder.f5213g.get(i);
                if (str != null) {
                    builder.f5213g.set(i, m4846a(str, "\\^`{|}", true, true, true));
                }
            }
        }
        if (builder.f5214h != null) {
            builder.f5214h = m4846a(builder.f5214h, " \"#<>\\^`{|}", true, false, false);
        }
        String builder2 = builder.toString();
        try {
            return new URI(builder2);
        } catch (Throwable e) {
            try {
                return URI.create(builder2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception e2) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: b */
    public final String mo8582b() {
        return this.f5216b;
    }

    /* renamed from: c */
    public final HttpUrl mo8583c(String str) {
        Builder builder = new Builder();
        if (builder.mo8576a(this, str) != ParseResult.SUCCESS) {
            builder = null;
        }
        return builder != null ? builder.mo8579b() : null;
    }

    /* renamed from: c */
    public final boolean mo8584c() {
        return this.f5216b.equals("https");
    }

    /* renamed from: d */
    public final String mo8585d() {
        if (this.f5217c.isEmpty()) {
            return "";
        }
        int length = this.f5216b.length() + 3;
        return this.f5224j.substring(length, C1910m.m5444a(this.f5224j, length, this.f5224j.length(), ":@"));
    }

    /* renamed from: e */
    public final String mo8586e() {
        if (this.f5218d.isEmpty()) {
            return "";
        }
        return this.f5224j.substring(this.f5224j.indexOf(58, this.f5216b.length() + 3) + 1, this.f5224j.indexOf(64));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).f5224j.equals(this.f5224j);
    }

    /* renamed from: f */
    public final String mo8588f() {
        return this.f5219e;
    }

    /* renamed from: g */
    public final int mo8589g() {
        return this.f5220f;
    }

    /* renamed from: h */
    public final String mo8590h() {
        int indexOf = this.f5224j.indexOf(47, this.f5216b.length() + 3);
        return this.f5224j.substring(indexOf, C1910m.m5444a(this.f5224j, indexOf, this.f5224j.length(), "?#"));
    }

    public final int hashCode() {
        return this.f5224j.hashCode();
    }

    /* renamed from: i */
    public final List<String> mo8592i() {
        int indexOf = this.f5224j.indexOf(47, this.f5216b.length() + 3);
        int a = C1910m.m5444a(this.f5224j, indexOf, this.f5224j.length(), "?#");
        List<String> arrayList = new ArrayList();
        while (indexOf < a) {
            int i = indexOf + 1;
            indexOf = C1910m.m5443a(this.f5224j, i, a, '/');
            arrayList.add(this.f5224j.substring(i, indexOf));
        }
        return arrayList;
    }

    /* renamed from: j */
    public final String mo8593j() {
        if (this.f5222h == null) {
            return null;
        }
        int indexOf = this.f5224j.indexOf(63) + 1;
        return this.f5224j.substring(indexOf, C1910m.m5443a(this.f5224j, indexOf + 1, this.f5224j.length(), '#'));
    }

    /* renamed from: k */
    public final String mo8594k() {
        if (this.f5222h == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        m4854b(stringBuilder, this.f5222h);
        return stringBuilder.toString();
    }

    public final String toString() {
        return this.f5224j;
    }
}
