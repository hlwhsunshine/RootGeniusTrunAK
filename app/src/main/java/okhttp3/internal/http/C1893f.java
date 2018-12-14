package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import okhttp3.internal.C1910m;

/* renamed from: okhttp3.internal.http.f */
public final class C1893f {
    /* renamed from: a */
    private static final ThreadLocal<DateFormat> f5608a = new C1894g();
    /* renamed from: b */
    private static final String[] f5609b = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    /* renamed from: c */
    private static final DateFormat[] f5610c = new DateFormat[15];

    /* renamed from: a */
    public static String m5368a(Date date) {
        return ((DateFormat) f5608a.get()).format(date);
    }

    /* renamed from: a */
    public static Date m5369a(String str) {
        int i = 0;
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = ((DateFormat) f5608a.get()).parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (f5609b) {
            int length = f5609b.length;
            while (i < length) {
                DateFormat dateFormat = f5610c[i];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f5609b[i], Locale.US);
                    dateFormat.setTimeZone(C1910m.f5677d);
                    f5610c[i] = dateFormat;
                }
                parsePosition.setIndex(0);
                parse = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse;
                }
                i++;
            }
            return null;
        }
    }
}
