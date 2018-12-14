package okhttp3.internal.http;

/* renamed from: okhttp3.internal.http.c */
public final class C1882c {
    /* renamed from: a */
    public static int m5323a(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            return parseLong > 2147483647L ? Integer.MAX_VALUE : parseLong < 0 ? 0 : (int) parseLong;
        } catch (NumberFormatException e) {
            return i;
        }
    }

    /* renamed from: a */
    public static int m5324a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }
}
