package okio;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* renamed from: okio.n */
public final class C1945n {
    /* renamed from: a */
    static final Logger f5822a = Logger.getLogger(C1945n.class.getName());

    private C1945n() {
    }

    /* renamed from: a */
    public static C1937g m5707a(C1823w c1823w) {
        if (c1823w != null) {
            return new C1949r(c1823w);
        }
        throw new IllegalArgumentException("sink == null");
    }

    /* renamed from: a */
    public static C1938h m5708a(C1850x c1850x) {
        if (c1850x != null) {
            return new C1950s(c1850x);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public static C1823w m5709a(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        C1852y c = C1945n.m5712c(socket);
        OutputStream outputStream = socket.getOutputStream();
        if (outputStream != null) {
            return new C1934b(c, new C1946o(c, outputStream));
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: a */
    static boolean m5710a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: b */
    public static C1850x m5711b(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        C1852y c = C1945n.m5712c(socket);
        InputStream inputStream = socket.getInputStream();
        if (inputStream != null) {
            return new C1935c(c, new C1947p(c, inputStream));
        }
        throw new IllegalArgumentException("in == null");
    }

    /* renamed from: c */
    private static C1853a m5712c(Socket socket) {
        return new C1948q(socket);
    }
}
