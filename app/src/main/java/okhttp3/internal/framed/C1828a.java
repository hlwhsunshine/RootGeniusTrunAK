package okhttp3.internal.framed;

import java.io.Closeable;
import java.util.List;
import okio.ByteString;
import okio.C1938h;

/* renamed from: okhttp3.internal.framed.a */
public interface C1828a extends Closeable {

    /* renamed from: okhttp3.internal.framed.a$a */
    public interface C1827a {
        /* renamed from: a */
        void mo8720a(int i, long j);

        /* renamed from: a */
        void mo8721a(int i, List<C1857p> list);

        /* renamed from: a */
        void mo8722a(int i, ErrorCode errorCode);

        /* renamed from: a */
        void mo8723a(int i, ByteString byteString);

        /* renamed from: a */
        void mo8724a(boolean z, int i, int i2);

        /* renamed from: a */
        void mo8725a(boolean z, int i, C1938h c1938h, int i2);

        /* renamed from: a */
        void mo8726a(boolean z, C1875z c1875z);

        /* renamed from: a */
        void mo8727a(boolean z, boolean z2, int i, List<C1857p> list, HeadersMode headersMode);
    }

    /* renamed from: a */
    void mo8728a();

    /* renamed from: a */
    boolean mo8729a(C1827a c1827a);
}
