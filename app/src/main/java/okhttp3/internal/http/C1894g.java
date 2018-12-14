package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import okhttp3.internal.C1910m;

/* renamed from: okhttp3.internal.http.g */
final class C1894g extends ThreadLocal<DateFormat> {
    C1894g() {
    }

    protected final /* synthetic */ Object initialValue() {
        DateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(C1910m.f5677d);
        return simpleDateFormat;
    }
}
