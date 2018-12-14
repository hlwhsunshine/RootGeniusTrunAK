package okhttp3.internal.http;

import java.net.ProtocolException;
import okhttp3.Protocol;

/* renamed from: okhttp3.internal.http.r */
public final class C1906r {
    /* renamed from: a */
    public final Protocol f5658a;
    /* renamed from: b */
    public final int f5659b;
    /* renamed from: c */
    public final String f5660c;

    private C1906r(Protocol protocol, int i, String str) {
        this.f5658a = protocol;
        this.f5659b = i;
        this.f5660c = str;
    }

    /* renamed from: a */
    public static C1906r m5418a(String str) {
        Protocol protocol;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - 48;
            if (charAt == 0) {
                protocol = Protocol.HTTP_1_0;
            } else if (charAt == 1) {
                protocol = Protocol.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            protocol = Protocol.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        if (str.length() < i + 3) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            String str2;
            int parseInt = Integer.parseInt(str.substring(i, i + 3));
            String str3 = "";
            if (str.length() <= i + 3) {
                str2 = str3;
            } else if (str.charAt(i + 3) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            } else {
                str2 = str.substring(i + 4);
            }
            return new C1906r(protocol, parseInt, str2);
        } catch (NumberFormatException e) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f5658a == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        stringBuilder.append(' ').append(this.f5659b);
        if (this.f5660c != null) {
            stringBuilder.append(' ').append(this.f5660c);
        }
        return stringBuilder.toString();
    }
}
