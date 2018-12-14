package okhttp3.internal.framed;

import android.support.p015v4.internal.view.SupportMenu;
import android.support.p015v4.view.ViewCompat;
import android.support.p015v4.widget.ExploreByTouchHelper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;
import okhttp3.internal.C1910m;
import okhttp3.internal.framed.C1828a.C1827a;
import okio.ByteString;
import okio.C1937g;
import okio.C1938h;
import okio.C1939e;
import okio.C1941i;
import okio.C1945n;

/* renamed from: okhttp3.internal.framed.aa */
public final class C1833aa implements C1832ab {
    /* renamed from: a */
    static final byte[] f5380a;

    /* renamed from: okhttp3.internal.framed.aa$a */
    static final class C1829a implements C1828a {
        /* renamed from: a */
        private final C1938h f5372a;
        /* renamed from: b */
        private final boolean f5373b;
        /* renamed from: c */
        private final C1868t f5374c = new C1868t(this.f5372a);

        C1829a(C1938h c1938h, boolean z) {
            this.f5372a = c1938h;
            this.f5373b = z;
        }

        /* renamed from: a */
        private static IOException m5065a(String str, Object... objArr) {
            throw new IOException(C1910m.m5445a(str, objArr));
        }

        /* renamed from: a */
        private void m5066a(C1827a c1827a, int i, int i2) {
            boolean z = true;
            int i3 = this.f5372a.mo9034i();
            if (i2 != (i3 * 8) + 4) {
                throw C1829a.m5065a("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i2), Integer.valueOf(i3));
            }
            C1875z c1875z = new C1875z();
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = this.f5372a.mo9034i();
                int i6 = (ViewCompat.MEASURED_STATE_MASK & i5) >>> 24;
                c1875z.mo8819a(i5 & ViewCompat.MEASURED_SIZE_MASK, i6, this.f5372a.mo9034i());
            }
            if ((i & 1) == 0) {
                z = false;
            }
            c1827a.mo8726a(z, c1875z);
        }

        /* renamed from: a */
        public final void mo8728a() {
        }

        /* renamed from: a */
        public final boolean mo8729a(C1827a c1827a) {
            boolean z = false;
            try {
                int i = this.f5372a.mo9034i();
                int i2 = this.f5372a.mo9034i();
                int i3 = (ViewCompat.MEASURED_STATE_MASK & i2) >>> 24;
                int i4 = ViewCompat.MEASURED_SIZE_MASK & i2;
                int i5;
                if ((ExploreByTouchHelper.INVALID_ID & i) != 0) {
                    i5 = (2147418112 & i) >>> 16;
                    i &= SupportMenu.USER_MASK;
                    if (i5 != 3) {
                        throw new ProtocolException("version != 3: " + i5);
                    }
                    switch (i) {
                        case 1:
                            i5 = this.f5372a.mo9034i();
                            this.f5372a.mo9034i();
                            i2 = i5 & Integer.MAX_VALUE;
                            this.f5372a.mo9033h();
                            List a = this.f5374c.mo8808a(i4 - 10);
                            boolean z2 = (i3 & 1) != 0;
                            if ((i3 & 2) != 0) {
                                z = true;
                            }
                            c1827a.mo8727a(z, z2, i2, a, HeadersMode.SPDY_SYN_STREAM);
                            return true;
                        case 2:
                            c1827a.mo8727a(false, (i3 & 1) != 0, this.f5372a.mo9034i() & Integer.MAX_VALUE, this.f5374c.mo8808a(i4 - 4), HeadersMode.SPDY_REPLY);
                            return true;
                        case 3:
                            if (i4 != 8) {
                                throw C1829a.m5065a("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i4));
                            }
                            i5 = this.f5372a.mo9034i() & Integer.MAX_VALUE;
                            ErrorCode fromSpdy3Rst = ErrorCode.fromSpdy3Rst(this.f5372a.mo9034i());
                            if (fromSpdy3Rst == null) {
                                throw C1829a.m5065a("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i));
                            }
                            c1827a.mo8722a(i5, fromSpdy3Rst);
                            return true;
                        case 4:
                            m5066a(c1827a, i3, i4);
                            return true;
                        case 6:
                            if (i4 != 4) {
                                throw C1829a.m5065a("TYPE_PING length: %d != 4", Integer.valueOf(i4));
                            }
                            i = this.f5372a.mo9034i();
                            c1827a.mo8724a(this.f5373b == ((i & 1) == 1), i, 0);
                            return true;
                        case 7:
                            if (i4 != 8) {
                                throw C1829a.m5065a("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i4));
                            }
                            i5 = this.f5372a.mo9034i() & Integer.MAX_VALUE;
                            if (ErrorCode.fromSpdyGoAway(this.f5372a.mo9034i()) == null) {
                                throw C1829a.m5065a("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(this.f5372a.mo9034i()));
                            }
                            c1827a.mo8723a(i5, ByteString.EMPTY);
                            return true;
                        case 8:
                            c1827a.mo8727a(false, false, this.f5372a.mo9034i() & Integer.MAX_VALUE, this.f5374c.mo8808a(i4 - 4), HeadersMode.SPDY_HEADERS);
                            return true;
                        case 9:
                            if (i4 != 8) {
                                throw C1829a.m5065a("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i4));
                            }
                            i5 = this.f5372a.mo9034i() & Integer.MAX_VALUE;
                            long i6 = (long) (this.f5372a.mo9034i() & Integer.MAX_VALUE);
                            if (i6 == 0) {
                                throw C1829a.m5065a("windowSizeIncrement was 0", Long.valueOf(i6));
                            }
                            c1827a.mo8720a(i5, i6);
                            return true;
                        default:
                            this.f5372a.mo9031f((long) i4);
                            return true;
                    }
                }
                i5 = i & Integer.MAX_VALUE;
                if ((i3 & 1) != 0) {
                    z = true;
                }
                c1827a.mo8725a(z, i5, this.f5372a, i4);
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        public final void close() {
            this.f5374c.mo8809a();
        }
    }

    /* renamed from: okhttp3.internal.framed.aa$b */
    static final class C1831b implements C1830b {
        /* renamed from: a */
        private final C1937g f5375a;
        /* renamed from: b */
        private final C1939e f5376b = new C1939e();
        /* renamed from: c */
        private final C1937g f5377c;
        /* renamed from: d */
        private final boolean f5378d;
        /* renamed from: e */
        private boolean f5379e;

        C1831b(C1937g c1937g, boolean z) {
            this.f5375a = c1937g;
            this.f5378d = z;
            Deflater deflater = new Deflater();
            deflater.setDictionary(C1833aa.f5380a);
            this.f5377c = C1945n.m5707a(new C1941i(this.f5376b, deflater));
        }

        /* renamed from: a */
        private void m5080a(List<C1857p> list) {
            this.f5377c.mo9018f(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ByteString byteString = ((C1857p) list.get(i)).f5488h;
                this.f5377c.mo9018f(byteString.size());
                this.f5377c.mo9013b(byteString);
                byteString = ((C1857p) list.get(i)).f5489i;
                this.f5377c.mo9018f(byteString.size());
                this.f5377c.mo9013b(byteString);
            }
            this.f5377c.flush();
        }

        /* renamed from: a */
        public final synchronized void mo8731a() {
        }

        /* renamed from: a */
        public final synchronized void mo8732a(int i, long j) {
            if (this.f5379e) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j);
            } else {
                this.f5375a.mo9018f(-2147287031);
                this.f5375a.mo9018f(8);
                this.f5375a.mo9018f(i);
                this.f5375a.mo9018f((int) j);
                this.f5375a.flush();
            }
        }

        /* renamed from: a */
        public final synchronized void mo8733a(int i, ErrorCode errorCode) {
            if (this.f5379e) {
                throw new IOException("closed");
            } else if (errorCode.spdyRstCode == -1) {
                throw new IllegalArgumentException();
            } else {
                this.f5375a.mo9018f(-2147287037);
                this.f5375a.mo9018f(8);
                this.f5375a.mo9018f(Integer.MAX_VALUE & i);
                this.f5375a.mo9018f(errorCode.spdyRstCode);
                this.f5375a.flush();
            }
        }

        /* renamed from: a */
        public final synchronized void mo8734a(int i, ErrorCode errorCode, byte[] bArr) {
            if (this.f5379e) {
                throw new IOException("closed");
            } else if (errorCode.spdyGoAwayCode == -1) {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            } else {
                this.f5375a.mo9018f(-2147287033);
                this.f5375a.mo9018f(8);
                this.f5375a.mo9018f(i);
                this.f5375a.mo9018f(errorCode.spdyGoAwayCode);
                this.f5375a.flush();
            }
        }

        /* renamed from: a */
        public final void mo8735a(C1875z c1875z) {
        }

        /* renamed from: a */
        public final synchronized void mo8736a(boolean z, int i, int i2) {
            boolean z2 = true;
            synchronized (this) {
                if (this.f5379e) {
                    throw new IOException("closed");
                }
                if (this.f5378d == ((i & 1) == 1)) {
                    z2 = false;
                }
                if (z != z2) {
                    throw new IllegalArgumentException("payload != reply");
                }
                this.f5375a.mo9018f(-2147287034);
                this.f5375a.mo9018f(4);
                this.f5375a.mo9018f(i);
                this.f5375a.flush();
            }
        }

        /* renamed from: a */
        public final synchronized void mo8737a(boolean z, int i, List<C1857p> list) {
            int i2 = 0;
            synchronized (this) {
                if (this.f5379e) {
                    throw new IOException("closed");
                }
                m5080a((List) list);
                int b = (int) (10 + this.f5376b.mo9049b());
                if (z) {
                    i2 = 1;
                }
                i2 |= 0;
                this.f5375a.mo9018f(-2147287039);
                this.f5375a.mo9018f(((i2 & 255) << 24) | (b & ViewCompat.MEASURED_SIZE_MASK));
                this.f5375a.mo9018f(Integer.MAX_VALUE & i);
                this.f5375a.mo9018f(0);
                this.f5375a.mo9019g(0);
                this.f5375a.mo9011a(this.f5376b);
                this.f5375a.flush();
            }
        }

        /* renamed from: a */
        public final synchronized void mo8738a(boolean z, int i, C1939e c1939e, int i2) {
            int i3 = z ? 1 : 0;
            if (this.f5379e) {
                throw new IOException("closed");
            } else if (((long) i2) > 16777215) {
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + i2);
            } else {
                this.f5375a.mo9018f(Integer.MAX_VALUE & i);
                this.f5375a.mo9018f(((i3 & 255) << 24) | (ViewCompat.MEASURED_SIZE_MASK & i2));
                if (i2 > 0) {
                    this.f5375a.mo8704a_(c1939e, (long) i2);
                }
            }
        }

        /* renamed from: b */
        public final synchronized void mo8739b() {
            if (this.f5379e) {
                throw new IOException("closed");
            }
            this.f5375a.flush();
        }

        /* renamed from: b */
        public final synchronized void mo8740b(C1875z c1875z) {
            if (this.f5379e) {
                throw new IOException("closed");
            }
            int b = c1875z.mo8822b();
            int i = (b * 8) + 4;
            this.f5375a.mo9018f(-2147287036);
            this.f5375a.mo9018f((i & ViewCompat.MEASURED_SIZE_MASK) | 0);
            this.f5375a.mo9018f(b);
            for (b = 0; b <= 10; b++) {
                if (c1875z.mo8821a(b)) {
                    this.f5375a.mo9018f(((c1875z.mo8825c(b) & 255) << 24) | (b & ViewCompat.MEASURED_SIZE_MASK));
                    this.f5375a.mo9018f(c1875z.mo8823b(b));
                }
            }
            this.f5375a.flush();
        }

        /* renamed from: c */
        public final int mo8741c() {
            return 16383;
        }

        public final synchronized void close() {
            this.f5379e = true;
            C1910m.m5453a(this.f5375a, this.f5377c);
        }
    }

    static {
        try {
            f5380a = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(C1910m.f5676c.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public final C1828a mo8743a(C1938h c1938h, boolean z) {
        return new C1829a(c1938h, z);
    }

    /* renamed from: a */
    public final C1830b mo8744a(C1937g c1937g, boolean z) {
        return new C1831b(c1937g, z);
    }
}
