package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: okhttp3.u */
public final class C1925u {
    /* renamed from: a */
    private static final Pattern f5720a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    /* renamed from: b */
    private static final Pattern f5721b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    /* renamed from: c */
    private final String f5722c;
    /* renamed from: d */
    private final String f5723d;
    /* renamed from: e */
    private final String f5724e;
    /* renamed from: f */
    private final String f5725f;

    private C1925u(String str, String str2, String str3, String str4) {
        this.f5722c = str;
        this.f5723d = str2;
        this.f5724e = str3;
        this.f5725f = str4;
    }

    /* renamed from: a */
    public static C1925u m5518a(String str) {
        Matcher matcher = f5720a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String toLowerCase = matcher.group(1).toLowerCase(Locale.US);
        String toLowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f5721b.matcher(str);
        int end = matcher.end();
        String str2 = null;
        while (end < str.length()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group == null || !group.equalsIgnoreCase("charset")) {
                group = str2;
            } else {
                group = matcher2.group(2) != null ? matcher2.group(2) : matcher2.group(3);
                if (!(str2 == null || group.equalsIgnoreCase(str2))) {
                    throw new IllegalArgumentException("Multiple different charsets: " + str);
                }
            }
            String str3 = group;
            end = matcher2.end();
            str2 = str3;
        }
        return new C1925u(str, toLowerCase, toLowerCase2, str2);
    }

    /* renamed from: a */
    public final Charset mo8924a() {
        return this.f5725f != null ? Charset.forName(this.f5725f) : null;
    }

    /* renamed from: a */
    public final Charset mo8925a(Charset charset) {
        return this.f5725f != null ? Charset.forName(this.f5725f) : charset;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C1925u) && ((C1925u) obj).f5722c.equals(this.f5722c);
    }

    public final int hashCode() {
        return this.f5722c.hashCode();
    }

    public final String toString() {
        return this.f5722c;
    }
}
