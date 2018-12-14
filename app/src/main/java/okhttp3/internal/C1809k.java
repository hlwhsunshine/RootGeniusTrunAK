package okhttp3.internal;

import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.C1927v;
import okhttp3.Protocol;

/* renamed from: okhttp3.internal.k */
public class C1809k {
    /* renamed from: a */
    private static final C1809k f5322a;
    /* renamed from: b */
    private static final Logger f5323b = Logger.getLogger(C1927v.class.getName());

    static {
        C1809k b = C1810a.m4993b();
        if (b == null) {
            b = C1876g.m5310b();
            if (b == null) {
                b = C1878h.m5315b();
                if (b == null) {
                    b = new C1809k();
                }
            }
        }
        f5322a = b;
    }

    /* renamed from: a */
    static <T> T m4982a(Object obj, Class<T> cls, String str) {
        do {
            Class cls2 = obj.getClass();
            while (cls2 != Object.class) {
                try {
                    Field declaredField = cls2.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    return (obj2 == null || !cls.isInstance(obj2)) ? null : cls.cast(obj2);
                } catch (NoSuchFieldException e) {
                    cls2 = cls2.getSuperclass();
                } catch (IllegalAccessException e2) {
                    throw new AssertionError();
                }
            }
            if (str.equals("delegate")) {
                break;
            }
            obj = C1809k.m4982a(obj, Object.class, "delegate");
        } while (obj != null);
        return null;
    }

    /* renamed from: a */
    public static List<String> m4983a(List<Protocol> list) {
        List<String> arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public static C1809k m4984c() {
        return f5322a;
    }

    /* renamed from: d */
    public static String m4985d() {
        return "OkHttp";
    }

    /* renamed from: a */
    public String mo8685a(SSLSocket sSLSocket) {
        return null;
    }

    /* renamed from: a */
    public X509TrustManager mo8686a(SSLSocketFactory sSLSocketFactory) {
        try {
            Object a = C1809k.m4982a((Object) sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            return a == null ? null : (X509TrustManager) C1809k.m4982a(a, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /* renamed from: a */
    public void mo8687a(int i, String str, Throwable th) {
        f5323b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* renamed from: a */
    public void mo8688a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    /* renamed from: a */
    public void mo8689a(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    /* renamed from: a */
    public boolean mo8690a() {
        return true;
    }

    /* renamed from: b */
    public void mo8691b(SSLSocket sSLSocket) {
    }
}
