package okhttp3.internal;

import android.support.p015v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import okio.ByteString;
import okio.C1850x;
import okio.C1939e;

/* renamed from: okhttp3.internal.m */
public final class C1910m {
    /* renamed from: a */
    public static final byte[] f5674a = new byte[0];
    /* renamed from: b */
    public static final String[] f5675b = new String[0];
    /* renamed from: c */
    public static final Charset f5676c = Charset.forName("UTF-8");
    /* renamed from: d */
    public static final TimeZone f5677d = TimeZone.getTimeZone("GMT");
    /* renamed from: e */
    private static final Pattern f5678e = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* renamed from: a */
    public static int m5442a(String str, int i, int i2) {
        int i3 = i;
        while (i3 < i2) {
            switch (str.charAt(i3)) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    i3++;
                default:
                    return i3;
            }
        }
        return i2;
    }

    /* renamed from: a */
    public static int m5443a(String str, int i, int i2, char c) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str.charAt(i3) == c) {
                return i3;
            }
        }
        return i2;
    }

    /* renamed from: a */
    public static int m5444a(String str, int i, int i2, String str2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str2.indexOf(str.charAt(i3)) != -1) {
                return i3;
            }
        }
        return i2;
    }

    /* renamed from: a */
    public static String m5445a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: a */
    public static String m5446a(HttpUrl httpUrl, boolean z) {
        String f = httpUrl.mo8588f().contains(":") ? "[" + httpUrl.mo8588f() + "]" : httpUrl.mo8588f();
        return (z || httpUrl.mo8589g() != HttpUrl.m4843a(httpUrl.mo8582b())) ? f + ":" + httpUrl.mo8589g() : f;
    }

    /* renamed from: a */
    public static <T> List<T> m5447a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    /* renamed from: a */
    public static <T> List<T> m5448a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* renamed from: a */
    public static ThreadFactory m5449a(String str) {
        return new C1911n(str);
    }

    /* renamed from: a */
    public static ByteString m5450a(ByteString byteString) {
        try {
            return ByteString.m5587of(MessageDigest.getInstance("SHA-1").digest(byteString.toByteArray()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public static void m5451a(long j, long j2) {
        if ((0 | j2) < 0 || 0 > j || j - 0 < j2) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: a */
    public static void m5452a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    public static void m5453a(Closeable closeable, Closeable closeable2) {
        Object th = null;
        try {
            closeable.close();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            closeable2.close();
        } catch (Throwable th3) {
            if (th == null) {
                Throwable th4 = th3;
            }
        }
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            } else if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            } else if (th instanceof Error) {
                throw ((Error) th);
            } else {
                throw new AssertionError(th);
            }
        }
    }

    /* renamed from: a */
    public static void m5454a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!C1910m.m5455a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m5455a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: a */
    public static boolean m5456a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static boolean m5457a(C1850x c1850x, int i, TimeUnit timeUnit) {
        long nanoTime = System.nanoTime();
        long d = c1850x.mo8764a().mo8770c_() ? c1850x.mo8764a().mo8771d() - nanoTime : Long.MAX_VALUE;
        c1850x.mo8764a().mo8767a(Math.min(d, timeUnit.toNanos((long) i)) + nanoTime);
        try {
            C1939e c1939e = new C1939e();
            while (c1850x.mo8763a(c1939e, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                c1939e.mo9063q();
            }
            if (d == Long.MAX_VALUE) {
                c1850x.mo8764a().mo8773f();
            } else {
                c1850x.mo8764a().mo8767a(d + nanoTime);
            }
            return true;
        } catch (InterruptedIOException e) {
            if (d == Long.MAX_VALUE) {
                c1850x.mo8764a().mo8773f();
            } else {
                c1850x.mo8764a().mo8767a(d + nanoTime);
            }
            return false;
        } catch (Throwable th) {
            if (d == Long.MAX_VALUE) {
                c1850x.mo8764a().mo8773f();
            } else {
                c1850x.mo8764a().mo8767a(d + nanoTime);
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static boolean m5458a(C1850x c1850x, TimeUnit timeUnit) {
        try {
            return C1910m.m5457a(c1850x, 100, timeUnit);
        } catch (IOException e) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m5459a(String[] strArr, String str) {
        return Arrays.asList(strArr).contains(str);
    }

    /* renamed from: a */
    public static <T> T[] m5460a(Class<T> cls, T[] tArr, T[] tArr2) {
        List arrayList = new ArrayList();
        for (Object obj : tArr) {
            for (Object obj2 : tArr2) {
                if (obj.equals(obj2)) {
                    arrayList.add(obj2);
                    break;
                }
            }
        }
        return arrayList.toArray((Object[]) Array.newInstance(cls, arrayList.size()));
    }

    /* renamed from: b */
    public static int m5461b(String str, int i, int i2) {
        int i3 = i2 - 1;
        while (i3 >= i) {
            switch (str.charAt(i3)) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    i3--;
                default:
                    return i3 + 1;
            }
        }
        return i;
    }

    /* renamed from: b */
    public static String m5462b(String str) {
        Object obj = 1;
        try {
            String toLowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (toLowerCase.isEmpty()) {
                return null;
            }
            for (int i = 0; i < toLowerCase.length(); i++) {
                char charAt = toLowerCase.charAt(i);
                if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                    break;
                }
            }
            obj = null;
            return obj == null ? toLowerCase : null;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /* renamed from: b */
    public static ByteString m5463b(ByteString byteString) {
        try {
            return ByteString.m5587of(MessageDigest.getInstance("SHA-256").digest(byteString.toByteArray()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: b */
    public static String[] m5464b(String[] strArr, String str) {
        Object obj = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, obj, 0, strArr.length);
        obj[obj.length - 1] = str;
        return obj;
    }

    /* renamed from: c */
    public static String m5465c(String str, int i, int i2) {
        int a = C1910m.m5442a(str, i, i2);
        return str.substring(a, C1910m.m5461b(str, a, i2));
    }

    /* renamed from: c */
    public static boolean m5466c(String str) {
        return f5678e.matcher(str).matches();
    }
}
