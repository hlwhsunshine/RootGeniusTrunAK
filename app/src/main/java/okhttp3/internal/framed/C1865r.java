package okhttp3.internal.framed;

import android.support.p015v4.view.ViewCompat;
import android.support.p015v4.widget.ExploreByTouchHelper;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.C1910m;
import okhttp3.internal.framed.C1828a.C1827a;
import okhttp3.internal.framed.C1860q.C1858a;
import okhttp3.internal.framed.C1860q.C1859b;
import okio.ByteString;
import okio.C1850x;
import okio.C1852y;
import okio.C1937g;
import okio.C1938h;
import okio.C1939e;

/* renamed from: okhttp3.internal.framed.r */
public final class C1865r implements C1832ab {
    /* renamed from: a */
    private static final Logger f5521a = Logger.getLogger(C1862b.class.getName());
    /* renamed from: b */
    private static final ByteString f5522b = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: okhttp3.internal.framed.r$a */
    static final class C1861a implements C1850x {
        /* renamed from: a */
        int f5502a;
        /* renamed from: b */
        byte f5503b;
        /* renamed from: c */
        int f5504c;
        /* renamed from: d */
        int f5505d;
        /* renamed from: e */
        short f5506e;
        /* renamed from: f */
        private final C1938h f5507f;

        public C1861a(C1938h c1938h) {
            this.f5507f = c1938h;
        }

        /* renamed from: a */
        public final long mo8763a(C1939e c1939e, long j) {
            while (this.f5505d == 0) {
                this.f5507f.mo9031f((long) this.f5506e);
                this.f5506e = (short) 0;
                if ((this.f5503b & 4) != 0) {
                    return -1;
                }
                int i = this.f5504c;
                int a = ((((this.f5507f.mo9032g() & 255) << 16) | ((this.f5507f.mo9032g() & 255) << 8)) | (this.f5507f.mo9032g() & 255));
                this.f5505d = a;
                this.f5502a = a;
                byte g = (byte) (this.f5507f.mo9032g() & 255);
                this.f5503b = (byte) (this.f5507f.mo9032g() & 255);
                if (C1865r.f5521a.isLoggable(Level.FINE)) {
                    C1865r.f5521a.fine(C1862b.m5247a(true, this.f5504c, this.f5502a, g, this.f5503b));
                }
                this.f5504c = this.f5507f.mo9034i() & Integer.MAX_VALUE;
                if (g != (byte) 9) {
                    throw C1865r.m5272c("%s != TYPE_CONTINUATION", Byte.valueOf(g));
                } else if (this.f5504c != i) {
                    throw C1865r.m5272c("TYPE_CONTINUATION streamId changed", new Object[0]);
                }
            }
            long a2 = this.f5507f.mo8763a(c1939e, Math.min(j, (long) this.f5505d));
            if (a2 == -1) {
                return -1;
            }
            this.f5505d = (int) (((long) this.f5505d) - a2);
            return a2;
        }

        /* renamed from: a */
        public final C1852y mo8764a() {
            return this.f5507f.mo8764a();
        }

        public final void close() {
        }
    }

    /* renamed from: okhttp3.internal.framed.r$b */
    static final class C1862b {
        /* renamed from: a */
        private static final String[] f5508a = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        /* renamed from: b */
        private static final String[] f5509b = new String[64];
        /* renamed from: c */
        private static final String[] f5510c = new String[256];

        static {
            int i;
            int i2;
            int i3 = 0;
            for (i = 0; i < f5510c.length; i++) {
                f5510c[i] = C1910m.m5445a("%8s", Integer.toBinaryString(i)).replace(' ', '0');
            }
            f5509b[0] = "";
            f5509b[1] = "END_STREAM";
            int[] iArr = new int[]{1};
            f5509b[8] = "PADDED";
            for (i = 0; i <= 0; i++) {
                i2 = iArr[i];
                f5509b[i2 | 8] = f5509b[i2] + "|PADDED";
            }
            f5509b[4] = "END_HEADERS";
            f5509b[32] = "PRIORITY";
            f5509b[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = new int[]{4, 32, 36};
            for (i2 = 0; i2 < 3; i2++) {
                int i4 = iArr2[i2];
                for (i = 0; i <= 0; i++) {
                    int i5 = iArr[i];
                    f5509b[i5 | i4] = f5509b[i5] + '|' + f5509b[i4];
                    f5509b[(i5 | i4) | 8] = f5509b[i5] + '|' + f5509b[i4] + "|PADDED";
                }
            }
            while (i3 < f5509b.length) {
                if (f5509b[i3] == null) {
                    f5509b[i3] = f5510c[i3];
                }
                i3++;
            }
        }

        C1862b() {
        }

        /* renamed from: a */
        static String m5247a(boolean z, int i, int i2, byte b, byte b2) {
            Object obj;
            String str;
            if (b < f5508a.length) {
                obj = f5508a[b];
            } else {
                String obj2 = C1910m.m5445a("0x%02x", Byte.valueOf(b));
            }
            if (b2 != (byte) 0) {
                switch (b) {
                    case (byte) 2:
                    case (byte) 3:
                    case (byte) 7:
                    case (byte) 8:
                        str = f5510c[b2];
                        break;
                    case (byte) 4:
                    case (byte) 6:
                        if (b2 != (byte) 1) {
                            str = f5510c[b2];
                            break;
                        }
                        str = "ACK";
                        break;
                    default:
                        str = b2 < f5509b.length ? f5509b[b2] : f5510c[b2];
                        if (b != (byte) 5 || (b2 & 4) == 0) {
                            if (b == (byte) 0 && (b2 & 32) != 0) {
                                str = str.replace("PRIORITY", "COMPRESSED");
                                break;
                            }
                        }
                        str = str.replace("HEADERS", "PUSH_PROMISE");
                        break;
                        break;
                }
            }
            str = "";
            String str2 = "%s 0x%08x %5d %-13s %s";
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = obj2;
            objArr[4] = str;
            return C1910m.m5445a(str2, objArr);
        }
    }

    /* renamed from: okhttp3.internal.framed.r$c */
    static final class C1863c implements C1828a {
        /* renamed from: a */
        final C1858a f5511a = new C1858a(this.f5513c);
        /* renamed from: b */
        private final C1938h f5512b;
        /* renamed from: c */
        private final C1861a f5513c = new C1861a(this.f5512b);
        /* renamed from: d */
        private final boolean f5514d;

        C1863c(C1938h c1938h, boolean z) {
            this.f5512b = c1938h;
            this.f5514d = z;
        }

        /* renamed from: a */
        private List<C1857p> m5248a(int i, short s, byte b, int i2) {
            C1861a c1861a = this.f5513c;
            this.f5513c.f5505d = i;
            c1861a.f5502a = i;
            this.f5513c.f5506e = s;
            this.f5513c.f5503b = b;
            this.f5513c.f5504c = i2;
            this.f5511a.mo8801a();
            return this.f5511a.mo8803b();
        }

        /* renamed from: b */
        private void m5249b() {
            this.f5512b.mo9034i();
            this.f5512b.mo9032g();
        }

        /* renamed from: a */
        public final void mo8728a() {
            if (!this.f5514d) {
                ByteString c = this.f5512b.mo9026c((long) C1865r.f5522b.size());
                if (C1865r.f5521a.isLoggable(Level.FINE)) {
                    C1865r.f5521a.fine(C1910m.m5445a("<< CONNECTION %s", c.hex()));
                }
                if (!C1865r.f5522b.equals(c)) {
                    throw C1865r.m5272c("Expected a connection header but was %s", c.utf8());
                }
            }
        }

        /* renamed from: a */
        public final boolean mo8729a(C1827a c1827a) {
            boolean z = false;
            try {
                this.f5512b.mo9025a(9);
                int a = ((((this.f5512b.mo9032g() & 255) << 16) | ((this.f5512b.mo9032g() & 255) << 8)) | (this.f5512b.mo9032g() & 255));
                if (a < 0 || a > 16384) {
                    throw C1865r.m5272c("FRAME_SIZE_ERROR: %s", Integer.valueOf(a));
                }
                byte g = (byte) (this.f5512b.mo9032g() & 255);
                byte g2 = (byte) (this.f5512b.mo9032g() & 255);
                int i = this.f5512b.mo9034i() & Integer.MAX_VALUE;
                if (C1865r.f5521a.isLoggable(Level.FINE)) {
                    C1865r.f5521a.fine(C1862b.m5247a(true, i, a, g, g2));
                }
                short g3;
                int h;
                switch (g) {
                    case (byte) 0:
                        boolean z2 = (g2 & 1) != 0;
                        if ((g2 & 32) != 0) {
                            throw C1865r.m5272c("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
                        }
                        if ((g2 & 8) != 0) {
                            g3 = (short) (this.f5512b.mo9032g() & 255);
                        }
                        c1827a.mo8725a(z2, i, this.f5512b, C1865r.m5265a(a, g2, g3));
                        this.f5512b.mo9031f((long) g3);
                        return true;
                    case (byte) 1:
                        if (i == 0) {
                            throw C1865r.m5272c("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
                        }
                        boolean z3 = (g2 & 1) != 0;
                        short g4 = (g2 & 8) != 0 ? (short) (this.f5512b.mo9032g() & 255) : (short) 0;
                        if ((g2 & 32) != 0) {
                            m5249b();
                            a -= 5;
                        }
                        c1827a.mo8727a(false, z3, i, m5248a(C1865r.m5265a(a, g2, g4), g4, g2, i), HeadersMode.HTTP_20_HEADERS);
                        return true;
                    case (byte) 2:
                        if (a != 5) {
                            throw C1865r.m5272c("TYPE_PRIORITY length: %d != 5", Integer.valueOf(a));
                        } else if (i == 0) {
                            throw C1865r.m5272c("TYPE_PRIORITY streamId == 0", new Object[0]);
                        } else {
                            m5249b();
                            return true;
                        }
                    case (byte) 3:
                        if (a != 4) {
                            throw C1865r.m5272c("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(a));
                        } else if (i == 0) {
                            throw C1865r.m5272c("TYPE_RST_STREAM streamId == 0", new Object[0]);
                        } else {
                            ErrorCode fromHttp2 = ErrorCode.fromHttp2(this.f5512b.mo9034i());
                            if (fromHttp2 == null) {
                                throw C1865r.m5272c("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(a));
                            }
                            c1827a.mo8722a(i, fromHttp2);
                            return true;
                        }
                    case (byte) 4:
                        if (i != 0) {
                            throw C1865r.m5272c("TYPE_SETTINGS streamId != 0", new Object[0]);
                        } else if ((g2 & 1) != 0) {
                            if (a == 0) {
                                return true;
                            }
                            throw C1865r.m5272c("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                        } else if (a % 6 != 0) {
                            throw C1865r.m5272c("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(a));
                        } else {
                            C1875z c1875z = new C1875z();
                            for (i = 0; i < a; i += 6) {
                                h = this.f5512b.mo9033h();
                                int i2 = this.f5512b.mo9034i();
                                switch (h) {
                                    case 2:
                                        if (!(i2 == 0 || i2 == 1)) {
                                            throw C1865r.m5272c("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                                        }
                                    case 3:
                                        h = 4;
                                        break;
                                    case 4:
                                        h = 7;
                                        if (i2 >= 0) {
                                            break;
                                        }
                                        throw C1865r.m5272c("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                    case 5:
                                        if (i2 >= 16384 && i2 <= ViewCompat.MEASURED_SIZE_MASK) {
                                            break;
                                        }
                                        throw C1865r.m5272c("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i2));
                                    default:
                                        break;
                                }
                                c1875z.mo8819a(h, 0, i2);
                            }
                            c1827a.mo8726a(false, c1875z);
                            if (c1875z.mo8824c() < 0) {
                                return true;
                            }
                            this.f5511a.mo8802a(c1875z.mo8824c());
                            return true;
                        }
                    case (byte) 5:
                        if (i == 0) {
                            throw C1865r.m5272c("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
                        }
                        if ((g2 & 8) != 0) {
                            g3 = (short) (this.f5512b.mo9032g() & 255);
                        }
                        c1827a.mo8721a(this.f5512b.mo9034i() & Integer.MAX_VALUE, m5248a(C1865r.m5265a(a - 4, g2, g3), g3, g2, i));
                        return true;
                    case (byte) 6:
                        if (a != 8) {
                            throw C1865r.m5272c("TYPE_PING length != 8: %s", Integer.valueOf(a));
                        } else if (i != 0) {
                            throw C1865r.m5272c("TYPE_PING streamId != 0", new Object[0]);
                        } else {
                            a = this.f5512b.mo9034i();
                            h = this.f5512b.mo9034i();
                            if ((g2 & 1) != 0) {
                                z = true;
                            }
                            c1827a.mo8724a(z, a, h);
                            return true;
                        }
                    case (byte) 7:
                        if (a < 8) {
                            throw C1865r.m5272c("TYPE_GOAWAY length < 8: %s", Integer.valueOf(a));
                        } else if (i != 0) {
                            throw C1865r.m5272c("TYPE_GOAWAY streamId != 0", new Object[0]);
                        } else {
                            h = this.f5512b.mo9034i();
                            int i3 = a - 8;
                            if (ErrorCode.fromHttp2(this.f5512b.mo9034i()) == null) {
                                throw C1865r.m5272c("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(this.f5512b.mo9034i()));
                            }
                            ByteString byteString = ByteString.EMPTY;
                            if (i3 > 0) {
                                byteString = this.f5512b.mo9026c((long) i3);
                            }
                            c1827a.mo8723a(h, byteString);
                            return true;
                        }
                    case (byte) 8:
                        if (a != 4) {
                            throw C1865r.m5272c("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(a));
                        }
                        long i4 = ((long) this.f5512b.mo9034i()) & 2147483647L;
                        if (i4 == 0) {
                            throw C1865r.m5272c("windowSizeIncrement was 0", Long.valueOf(i4));
                        }
                        c1827a.mo8720a(i, i4);
                        return true;
                    default:
                        this.f5512b.mo9031f((long) a);
                        return true;
                }
            } catch (IOException e) {
                return false;
            }
        }

        public final void close() {
            this.f5512b.close();
        }
    }

    /* renamed from: okhttp3.internal.framed.r$d */
    static final class C1864d implements C1830b {
        /* renamed from: a */
        private final C1937g f5515a;
        /* renamed from: b */
        private final boolean f5516b;
        /* renamed from: c */
        private final C1939e f5517c = new C1939e();
        /* renamed from: d */
        private final C1859b f5518d = new C1859b(this.f5517c);
        /* renamed from: e */
        private int f5519e = 16384;
        /* renamed from: f */
        private boolean f5520f;

        C1864d(C1937g c1937g, boolean z) {
            this.f5515a = c1937g;
            this.f5516b = z;
        }

        /* renamed from: a */
        private void m5252a(int i, int i2, byte b, byte b2) {
            if (C1865r.f5521a.isLoggable(Level.FINE)) {
                C1865r.f5521a.fine(C1862b.m5247a(false, i, i2, b, b2));
            }
            if (i2 > this.f5519e) {
                throw C1865r.m5270b("FRAME_SIZE_ERROR length > %d: %d", new Object[]{Integer.valueOf(this.f5519e), Integer.valueOf(i2)});
            } else if ((ExploreByTouchHelper.INVALID_ID & i) != 0) {
                throw C1865r.m5270b("reserved bit set: %s", new Object[]{Integer.valueOf(i)});
            } else {
                C1865r.m5269a(this.f5515a, i2);
                this.f5515a.mo9020h(b & 255);
                this.f5515a.mo9020h(b2 & 255);
                this.f5515a.mo9018f(Integer.MAX_VALUE & i);
            }
        }

        /* renamed from: b */
        private void m5253b(int i, long j) {
            while (j > 0) {
                int min = (int) Math.min((long) this.f5519e, j);
                j -= (long) min;
                m5252a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
                this.f5515a.mo8704a_(this.f5517c, (long) min);
            }
        }

        /* renamed from: a */
        public final synchronized void mo8731a() {
            if (this.f5520f) {
                throw new IOException("closed");
            } else if (this.f5516b) {
                if (C1865r.f5521a.isLoggable(Level.FINE)) {
                    C1865r.f5521a.fine(C1910m.m5445a(">> CONNECTION %s", C1865r.f5522b.hex()));
                }
                this.f5515a.mo9014b(C1865r.f5522b.toByteArray());
                this.f5515a.flush();
            }
        }

        /* renamed from: a */
        public final synchronized void mo8732a(int i, long j) {
            if (this.f5520f) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw C1865r.m5270b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[]{Long.valueOf(j)});
            } else {
                m5252a(i, 4, (byte) 8, (byte) 0);
                this.f5515a.mo9018f((int) j);
                this.f5515a.flush();
            }
        }

        /* renamed from: a */
        public final synchronized void mo8733a(int i, ErrorCode errorCode) {
            if (this.f5520f) {
                throw new IOException("closed");
            } else if (errorCode.httpCode == -1) {
                throw new IllegalArgumentException();
            } else {
                m5252a(i, 4, (byte) 3, (byte) 0);
                this.f5515a.mo9018f(errorCode.httpCode);
                this.f5515a.flush();
            }
        }

        /* renamed from: a */
        public final synchronized void mo8734a(int i, ErrorCode errorCode, byte[] bArr) {
            if (this.f5520f) {
                throw new IOException("closed");
            } else if (errorCode.httpCode == -1) {
                throw C1865r.m5270b("errorCode.httpCode == -1", new Object[0]);
            } else {
                m5252a(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f5515a.mo9018f(i);
                this.f5515a.mo9018f(errorCode.httpCode);
                if (bArr.length > 0) {
                    this.f5515a.mo9014b(bArr);
                }
                this.f5515a.flush();
            }
        }

        /* renamed from: a */
        public final synchronized void mo8735a(C1875z c1875z) {
            if (this.f5520f) {
                throw new IOException("closed");
            }
            this.f5519e = c1875z.mo8827d(this.f5519e);
            m5252a(0, 0, (byte) 4, (byte) 1);
            this.f5515a.flush();
        }

        /* renamed from: a */
        public final synchronized void mo8736a(boolean z, int i, int i2) {
            byte b = (byte) 0;
            synchronized (this) {
                if (this.f5520f) {
                    throw new IOException("closed");
                }
                if (z) {
                    b = (byte) 1;
                }
                m5252a(0, 8, (byte) 6, b);
                this.f5515a.mo9018f(i);
                this.f5515a.mo9018f(i2);
                this.f5515a.flush();
            }
        }

        /* renamed from: a */
        public final synchronized void mo8737a(boolean z, int i, List<C1857p> list) {
            if (this.f5520f) {
                throw new IOException("closed");
            } else if (this.f5520f) {
                throw new IOException("closed");
            } else {
                this.f5518d.mo8804a((List) list);
                long b = this.f5517c.mo9049b();
                int min = (int) Math.min((long) this.f5519e, b);
                byte b2 = b == ((long) min) ? (byte) 4 : (byte) 0;
                if (z) {
                    b2 = (byte) (b2 | 1);
                }
                m5252a(i, min, (byte) 1, b2);
                this.f5515a.mo8704a_(this.f5517c, (long) min);
                if (b > ((long) min)) {
                    m5253b(i, b - ((long) min));
                }
            }
        }

        /* renamed from: a */
        public final synchronized void mo8738a(boolean z, int i, C1939e c1939e, int i2) {
            byte b = (byte) 0;
            synchronized (this) {
                if (this.f5520f) {
                    throw new IOException("closed");
                }
                if (z) {
                    b = (byte) 1;
                }
                m5252a(i, i2, (byte) 0, b);
                if (i2 > 0) {
                    this.f5515a.mo8704a_(c1939e, (long) i2);
                }
            }
        }

        /* renamed from: b */
        public final synchronized void mo8739b() {
            if (this.f5520f) {
                throw new IOException("closed");
            }
            this.f5515a.flush();
        }

        /* renamed from: b */
        public final synchronized void mo8740b(C1875z c1875z) {
            int i = 0;
            synchronized (this) {
                if (this.f5520f) {
                    throw new IOException("closed");
                }
                m5252a(0, c1875z.mo8822b() * 6, (byte) 4, (byte) 0);
                while (i < 10) {
                    if (c1875z.mo8821a(i)) {
                        int i2 = i == 4 ? 3 : i == 7 ? 4 : i;
                        this.f5515a.mo9019g(i2);
                        this.f5515a.mo9018f(c1875z.mo8823b(i));
                    }
                    i++;
                }
                this.f5515a.flush();
            }
        }

        /* renamed from: c */
        public final int mo8741c() {
            return this.f5519e;
        }

        public final synchronized void close() {
            this.f5520f = true;
            this.f5515a.close();
        }
    }

    /* renamed from: a */
    static /* synthetic */ int m5265a(int i, byte b, short s) {
        short i2;
        if ((b & 8) != 0) {
            i2 = i2 - 1;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        throw C1865r.m5272c("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
    }

    /* renamed from: b */
    static /* synthetic */ IllegalArgumentException m5270b(String str, Object[] objArr) {
        throw new IllegalArgumentException(C1910m.m5445a(str, objArr));
    }

    /* renamed from: c */
    private static IOException m5272c(String str, Object... objArr) {
        throw new IOException(C1910m.m5445a(str, objArr));
    }

    /* renamed from: a */
    public final C1828a mo8743a(C1938h c1938h, boolean z) {
        return new C1863c(c1938h, z);
    }

    /* renamed from: a */
    public final C1830b mo8744a(C1937g c1937g, boolean z) {
        return new C1864d(c1937g, z);
    }
}
