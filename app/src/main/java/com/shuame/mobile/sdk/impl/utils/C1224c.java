package com.shuame.mobile.sdk.impl.utils;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.shuame.mobile.sdk.impl.utils.c */
public class C1224c {
    /* renamed from: a */
    private static final String f3232a = C1224c.class.getSimpleName();

    /* renamed from: com.shuame.mobile.sdk.impl.utils.c$a */
    private static class C1221a implements X509TrustManager {
        /* renamed from: a */
        private X509Certificate[] f3226a;

        private C1221a() {
            this.f3226a = new X509Certificate[0];
        }

        /* synthetic */ C1221a(C1221a c1221a) {
            this();
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return this.f3226a;
        }
    }

    /* renamed from: com.shuame.mobile.sdk.impl.utils.c$b */
    public static class C1222b {
        /* renamed from: a */
        public String f3227a;
        /* renamed from: b */
        public String f3228b;
        /* renamed from: c */
        public Map<String, String> f3229c;
    }

    /* renamed from: com.shuame.mobile.sdk.impl.utils.c$c */
    public static class C1223c {
        /* renamed from: a */
        public int f3230a;
        /* renamed from: b */
        public String f3231b;
    }

    static {
        C1224c.m3451a();
    }

    /* renamed from: a */
    public static C1223c m3449a(C1222b c1222b) {
        return C1224c.m3450a(c1222b, true);
    }

    /* renamed from: a */
    private static C1223c m3450a(C1222b c1222b, boolean z) {
        MalformedURLException e;
        ProtocolException e2;
        EOFException e3;
        IOException e4;
        Exception e5;
        Throwable th;
        C1223c c1223c = new C1223c();
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(c1222b.f3227a).openConnection();
            try {
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setRequestMethod(z ? "POST" : "GET");
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setReadTimeout(10000);
                if (c1222b.f3229c != null) {
                    for (Entry entry : c1222b.f3229c.entrySet()) {
                        httpURLConnection2.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                OutputStream outputStream = httpURLConnection2.getOutputStream();
                outputStream.write(c1222b.f3228b.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();
                c1223c.f3230a = httpURLConnection2.getResponseCode();
                if (c1223c.f3230a == 200) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            c1223c.f3231b = stringBuffer.toString();
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (MalformedURLException e6) {
                MalformedURLException malformedURLException = e6;
                httpURLConnection = httpURLConnection2;
                e = malformedURLException;
            } catch (ProtocolException e7) {
                ProtocolException protocolException = e7;
                httpURLConnection = httpURLConnection2;
                e2 = protocolException;
            } catch (EOFException e8) {
                EOFException eOFException = e8;
                httpURLConnection = httpURLConnection2;
                e3 = eOFException;
            } catch (IOException e9) {
                IOException iOException = e9;
                httpURLConnection = httpURLConnection2;
                e4 = iOException;
            } catch (Exception e10) {
                Exception exception = e10;
                httpURLConnection = httpURLConnection2;
                e5 = exception;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                httpURLConnection = httpURLConnection2;
                th = th3;
            }
        } catch (MalformedURLException e11) {
            e = e11;
            try {
                e.printStackTrace();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return c1223c;
            } catch (Throwable th4) {
                th = th4;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (ProtocolException e12) {
            e2 = e12;
            e2.printStackTrace();
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return c1223c;
        } catch (EOFException e13) {
            e3 = e13;
            c1223c.f3230a = 504;
            e3.printStackTrace();
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return c1223c;
        } catch (IOException e14) {
            e4 = e14;
            e4.printStackTrace();
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return c1223c;
        } catch (Exception e15) {
            e5 = e15;
            e5.printStackTrace();
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return c1223c;
        }
        return c1223c;
    }

    /* renamed from: a */
    private static void m3451a() {
        HttpsURLConnection.setDefaultHostnameVerifier(new C1225d());
        try {
            TrustManager[] trustManagerArr = new TrustManager[]{new C1221a()};
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e2) {
            e2.printStackTrace();
        }
    }
}
