package com.kingroot.sdk;

import android.content.Context;
import com.kingroot.sdk.util.C0891k;
import com.p070qq.p071e.comm.constants.ErrorCode.InitError;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.InflaterInputStream;
import org.apache.http.client.ClientProtocolException;

/* renamed from: com.kingroot.sdk.dv */
public final class C0762dv {
    /* renamed from: cS */
    private String f1851cS;
    /* renamed from: gA */
    private boolean f1852gA = true;
    /* renamed from: gB */
    private byte f1853gB = (byte) 0;
    /* renamed from: gC */
    private byte f1854gC = (byte) 0;
    /* renamed from: gu */
    private String f1855gu = "GET";
    /* renamed from: gv */
    private HttpURLConnection f1856gv;
    /* renamed from: gw */
    private byte[] f1857gw;
    /* renamed from: gx */
    private int f1858gx = -1;
    /* renamed from: gy */
    private Hashtable<String, String> f1859gy = new Hashtable(0);
    /* renamed from: gz */
    private boolean f1860gz = false;
    private Context mContext;

    private C0762dv(Context context, String str) {
        this.mContext = context;
        this.f1851cS = str;
    }

    /* renamed from: a */
    public static synchronized C0762dv m1890a(Context context, C0762dv c0762dv) {
        C0762dv c0762dv2;
        byte b = (byte) 2;
        synchronized (C0762dv.class) {
            byte J = C0891k.m2436J(context);
            c0762dv2 = new C0762dv(context, c0762dv.mo5777bx());
            if ((byte) -1 == J) {
                throw new C0763dw(-1052, "no connection!");
            }
            try {
                if (!c0762dv.f1860gz || J == (byte) 2) {
                    b = (c0762dv.f1860gz || J != (byte) 2) ? J : (byte) 1;
                }
                c0762dv2.m1891a(new URL(c0762dv2.f1851cS), b);
                c0762dv2.setRequestMethod(c0762dv.getRequestMethod());
                c0762dv2.mo5785k(c0762dv.mo5773bt());
                c0762dv2.mo5771a(c0762dv.m1892by());
            } catch (MalformedURLException e) {
                throw new C0763dw(-1053, "invalide url: " + c0762dv2.f1851cS + " " + e.getMessage());
            }
        }
        return c0762dv2;
    }

    /* renamed from: a */
    private void m1891a(URL url, byte b) {
        if ((byte) -1 != b) {
            if ((byte) 2 == b) {
                try {
                    this.f1856gv = (HttpURLConnection) url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress(C0891k.m2437K(this.mContext), C0891k.m2438L(this.mContext))));
                    this.f1860gz = true;
                } catch (IllegalArgumentException e) {
                    throw new C0763dw(-1057, "arg error: " + e.getMessage());
                } catch (SecurityException e2) {
                    throw new C0763dw(-1058, "security error: " + e2.getMessage());
                } catch (UnsupportedOperationException e3) {
                    throw new C0763dw(-1059, "unsupported operation error: " + e3.getMessage());
                } catch (IOException e4) {
                    throw new C0763dw(-1056, "IOException : " + e4.getMessage());
                }
            }
            this.f1856gv = (HttpURLConnection) url.openConnection();
            this.f1860gz = false;
            this.f1856gv.setReadTimeout(30000);
            this.f1856gv.setConnectTimeout(30000);
        }
    }

    /* renamed from: by */
    private Hashtable<String, String> m1892by() {
        return this.f1859gy;
    }

    /* renamed from: c */
    private static byte[] m1893c(InputStream inputStream) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bArr = new byte[2048];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    bArr = byteArrayOutputStream.toByteArray();
                    try {
                        bufferedInputStream.close();
                        byteArrayOutputStream.close();
                        return bArr;
                    } catch (Exception e) {
                        throw new C0763dw(-56, "get Bytes from inputStream: " + e.getMessage());
                    }
                }
            } catch (IOException e2) {
                throw new C0763dw(-56, "get Bytes from inputStream when read buffer: " + e2.getMessage());
            }
        }
    }

    private boolean isConnected() {
        return this.f1858gx == 200 || this.f1858gx == 206;
    }

    /* renamed from: u */
    public static synchronized C0762dv m1894u(Context context, String str) {
        C0762dv c0762dv;
        synchronized (C0762dv.class) {
            c0762dv = new C0762dv(context, str);
            byte J = C0891k.m2436J(context);
            if ((byte) -1 == J) {
                throw new C0763dw(-1052, "no connecition!");
            }
            try {
                c0762dv.m1891a(new URL(c0762dv.f1851cS), J);
            } catch (MalformedURLException e) {
                throw new C0763dw(-1053, "malformed url: " + str + " " + e.getMessage());
            }
        }
        return c0762dv;
    }

    /* renamed from: a */
    public final int mo5770a(boolean z, AtomicReference<byte[]> atomicReference) {
        if (this.f1856gv == null || !isConnected()) {
            return -4000;
        }
        InputStream inflaterInputStream;
        if (z) {
            try {
                inflaterInputStream = new InflaterInputStream(this.f1856gv.getInputStream());
            } catch (Exception e) {
                throw new C0763dw(-4002, "get response exception : " + e.getMessage());
            }
        }
        inflaterInputStream = this.f1856gv.getInputStream();
        atomicReference.set(C0762dv.m1893c(inflaterInputStream));
        return 0;
    }

    /* renamed from: a */
    public final void mo5771a(Hashtable<String, String> hashtable) {
        if (this.f1856gv != null && hashtable != null) {
            for (Entry entry : hashtable.entrySet()) {
                setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    /* renamed from: b */
    public final void mo5772b(Hashtable<String, String> hashtable) {
        if (hashtable != null && hashtable.size() != 0 && this.f1856gv != null) {
            for (Entry entry : hashtable.entrySet()) {
                this.f1856gv.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    /* renamed from: bt */
    public final byte[] mo5773bt() {
        return this.f1857gw;
    }

    /* renamed from: bu */
    public final int mo5774bu() {
        int i;
        UnknownHostException e;
        IllegalAccessError e2;
        IllegalStateException e3;
        ProtocolException e4;
        ClientProtocolException e5;
        SocketException e6;
        SocketTimeoutException e7;
        C0763dw e8;
        Exception e9;
        while (true) {
            try {
                this.f1856gv.setRequestProperty("Cookie", "");
                this.f1856gv.setRequestProperty("Accept", "*/*");
                this.f1856gv.setRequestProperty("Accept-Charset", "utf-8");
                this.f1856gv.setRequestProperty("Content-Type", "application/octet-stream");
                this.f1856gv.setInstanceFollowRedirects(true);
                System.setProperty("http.keepAlive", "false");
                if ("GET".equalsIgnoreCase(this.f1855gu)) {
                    i = -3000;
                    try {
                        this.f1856gv.setRequestMethod("GET");
                    } catch (UnknownHostException e10) {
                        e = e10;
                        if (this.f1852gA) {
                            this.f1852gA = false;
                            this.f1856gv.disconnect();
                            try {
                                if ((byte) 2 == C0891k.m2436J(this.mContext) && this.f1860gz) {
                                    m1891a(new URL(this.f1851cS), (byte) 1);
                                } else if (!((byte) 2 == C0891k.m2436J(this.mContext) || this.f1860gz)) {
                                    m1891a(new URL(this.f1851cS), (byte) 2);
                                }
                                setRequestMethod(this.f1855gu);
                                if ("POST".equalsIgnoreCase(this.f1855gu) && this.f1857gw != null) {
                                    mo5785k(this.f1857gw);
                                }
                                mo5772b(this.f1859gy);
                            } catch (MalformedURLException e11) {
                                throw new C0763dw(i - 53, "malformed url: " + this.f1851cS + " " + e.getMessage());
                            }
                        }
                        throw new C0763dw(i - 62, "sendRequest UnknownHostException: " + e.getMessage());
                    } catch (IllegalAccessError e12) {
                        e2 = e12;
                        throw new C0763dw(i - 60, "sendRequest IllegalAccessError: " + e2.getMessage());
                    } catch (IllegalStateException e13) {
                        e3 = e13;
                        throw new C0763dw(i - 61, "sendRequest IllegalStateException: " + e3.getMessage());
                    } catch (ProtocolException e14) {
                        e4 = e14;
                        throw new C0763dw(i - 51, "sendRequest ProtocolException: " + e4.getMessage());
                    } catch (ClientProtocolException e15) {
                        e5 = e15;
                        throw new C0763dw(i - 51, "sendRequest ClientProtocolException: " + e5.getMessage());
                    } catch (SocketException e16) {
                        e6 = e16;
                        throw new C0763dw(i - 54, "sendRequest SocketException: " + e6.getMessage());
                    } catch (SocketTimeoutException e17) {
                        e7 = e17;
                        throw new C0763dw(i - 55, "sendRequest SocketTimeoutException: " + e7.getMessage());
                    } catch (C0763dw e18) {
                        e8 = e18;
                        throw new C0763dw(i - 56, "sendRequest NetWorkException: " + e8.getMessage());
                    } catch (Exception e19) {
                        e9 = e19;
                        e9.printStackTrace();
                        throw new C0763dw(i, "sendRequest Exception: " + e9.getMessage());
                    }
                }
                i = -2000;
                this.f1856gv.setRequestMethod("POST");
                this.f1856gv.setDoOutput(true);
                this.f1856gv.setDoInput(true);
                this.f1856gv.setUseCaches(false);
                if (this.f1857gw != null) {
                    this.f1856gv.setRequestProperty("Content-length", this.f1857gw.length);
                    OutputStream outputStream = this.f1856gv.getOutputStream();
                    outputStream.write(this.f1857gw);
                    outputStream.flush();
                    outputStream.close();
                }
                this.f1858gx = this.f1856gv.getResponseCode();
                C0633at.m1464h("mResponseCode = " + this.f1858gx);
                byte b;
                if (this.f1858gx >= InitError.INIT_ADMANGER_ERROR && this.f1858gx <= 305) {
                    b = this.f1853gB;
                    this.f1853gB = (byte) (b + 1);
                    if (b < (byte) 2) {
                        this.f1851cS = mo5776bw();
                        this.f1856gv.disconnect();
                        m1891a(new URL(this.f1851cS), C0891k.m2436J(this.mContext));
                        setRequestMethod(this.f1855gu);
                        if ("POST".equalsIgnoreCase(this.f1855gu) && this.f1857gw != null) {
                            mo5785k(this.f1857gw);
                        }
                        mo5772b(this.f1859gy);
                        return mo5774bu();
                    }
                } else if (this.f1858gx == 200) {
                    String contentType = getContentType();
                    if (!((byte) 2 != C0891k.m2436J(this.mContext) || contentType == null || contentType.toLowerCase().indexOf("vnd.wap.wml") == -1)) {
                        b = this.f1854gC;
                        this.f1854gC = (byte) (b + 1);
                        if (b <= (byte) 0) {
                            this.f1856gv.disconnect();
                            m1891a(new URL(this.f1851cS), C0891k.m2436J(this.mContext));
                            setRequestMethod(this.f1855gu);
                            if ("POST".equalsIgnoreCase(this.f1855gu) && this.f1857gw != null) {
                                mo5785k(this.f1857gw);
                            }
                            mo5772b(this.f1859gy);
                            return mo5774bu();
                        }
                    }
                }
            } catch (UnknownHostException e20) {
                e = e20;
                i = 0;
            } catch (IllegalAccessError e21) {
                e2 = e21;
                i = 0;
            } catch (IllegalStateException e22) {
                e3 = e22;
                i = 0;
            } catch (ProtocolException e23) {
                e4 = e23;
                i = 0;
            } catch (ClientProtocolException e24) {
                e5 = e24;
                i = 0;
            } catch (SocketException e25) {
                e6 = e25;
                i = 0;
            } catch (SocketTimeoutException e26) {
                e7 = e26;
                i = 0;
            } catch (C0763dw e27) {
                e8 = e27;
                i = 0;
            } catch (Exception e28) {
                e9 = e28;
                i = 0;
            }
            mo5772b(this.f1859gy);
        }
        if (this.f1858gx == 206 || this.f1858gx == 200) {
            return this.f1858gx;
        }
        throw new C0763dw(this.f1858gx + i, "response code is unnormal: " + this.f1858gx);
    }

    /* renamed from: bv */
    public final long mo5775bv() {
        String headerField = getHeaderField("Content-Range");
        if (headerField == null) {
            return -1;
        }
        try {
            return Long.parseLong(headerField.substring(headerField.lastIndexOf(47) + 1).trim());
        } catch (Exception e) {
            throw new C0763dw(-56, "get breakpoint total size: " + e.getMessage());
        }
    }

    /* renamed from: bw */
    public final String mo5776bw() {
        try {
            return this.f1856gv.getHeaderField("Location");
        } catch (Exception e) {
            throw new C0763dw(-56, "get redirect url: " + e.getMessage());
        }
    }

    /* renamed from: bx */
    public final String mo5777bx() {
        return this.f1851cS;
    }

    public final void close() {
        if (this.f1856gv != null) {
            try {
                this.f1856gv.disconnect();
            } catch (Throwable th) {
                C0633at.m1458a("HttpConnection.close() throw e", th);
            }
            this.f1856gv = null;
        }
    }

    public final long getContentLength() {
        String headerField = getHeaderField("content-length");
        if (headerField == null) {
            return -1;
        }
        try {
            return Long.parseLong(headerField.trim());
        } catch (Exception e) {
            throw new C0763dw(-56, "get content length: " + e.getMessage());
        }
    }

    public final String getContentType() {
        try {
            return this.f1856gv.getHeaderField("Content-Type");
        } catch (Exception e) {
            throw new C0763dw(-56, "get content type: " + e.getMessage());
        }
    }

    public final String getHeaderField(String str) {
        try {
            return this.f1856gv.getHeaderField(str);
        } catch (Exception e) {
            throw new C0763dw(-56, "get header field: " + e.getMessage());
        }
    }

    public final InputStream getInputStream() {
        try {
            return this.f1856gv.getInputStream();
        } catch (Exception e) {
            throw new C0763dw(-56, "get inputStream: " + e.getMessage());
        }
    }

    public final String getRequestMethod() {
        return this.f1855gu;
    }

    public final int getResponseCode() {
        return this.f1858gx;
    }

    /* renamed from: k */
    public final void mo5785k(byte[] bArr) {
        this.f1857gw = bArr;
    }

    public final void setRequestMethod(String str) {
        this.f1855gu = str;
        if ("GET".equalsIgnoreCase(str)) {
            this.f1855gu = "GET";
        } else if ("POST".equalsIgnoreCase(str)) {
            this.f1855gu = "POST";
        }
    }

    public final void setRequestProperty(String str, String str2) {
        if (str != null && str2 != null && this.f1856gv != null) {
            this.f1856gv.setRequestProperty(str, str2);
            this.f1859gy.put(str, str2);
        }
    }
}
