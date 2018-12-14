package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* renamed from: okio.q */
final class C1948q extends C1853a {
    /* renamed from: a */
    final /* synthetic */ Socket f5827a;

    C1948q(Socket socket) {
        this.f5827a = socket;
    }

    /* renamed from: a */
    protected final IOException mo8775a(IOException iOException) {
        IOException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    /* renamed from: a */
    protected final void mo8776a() {
        try {
            this.f5827a.close();
        } catch (Throwable e) {
            C1945n.f5822a.log(Level.WARNING, "Failed to close timed out socket " + this.f5827a, e);
        } catch (AssertionError e2) {
            if (C1945n.m5710a(e2)) {
                C1945n.f5822a.log(Level.WARNING, "Failed to close timed out socket " + this.f5827a, e2);
                return;
            }
            throw e2;
        }
    }
}
