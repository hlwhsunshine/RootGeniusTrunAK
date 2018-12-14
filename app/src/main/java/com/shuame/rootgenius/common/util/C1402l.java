package com.shuame.rootgenius.common.util;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.shuame.rootgenius.common.util.l */
public class C1402l {
    /* renamed from: a */
    private static final String f3887a = C1402l.class.getSimpleName();

    /* renamed from: com.shuame.rootgenius.common.util.l$a */
    private static class C1399a implements X509TrustManager {
        /* renamed from: a */
        private X509Certificate[] f3879a;

        private C1399a() {
            this.f3879a = new X509Certificate[0];
        }

        /* synthetic */ C1399a(byte b) {
            this();
        }

        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public final X509Certificate[] getAcceptedIssuers() {
            return this.f3879a;
        }
    }

    /* renamed from: com.shuame.rootgenius.common.util.l$b */
    public static class C1400b {
        /* renamed from: a */
        public String f3880a;
        /* renamed from: b */
        public byte[] f3881b;
        /* renamed from: c */
        public Map<String, String> f3882c;
        /* renamed from: d */
        public int f3883d = 10000;
        /* renamed from: e */
        public int f3884e = 10000;
    }

    /* renamed from: com.shuame.rootgenius.common.util.l$c */
    public static class C1401c {
        /* renamed from: a */
        public int f3885a;
        /* renamed from: b */
        public byte[] f3886b;
    }

    static {
        HttpsURLConnection.setDefaultHostnameVerifier(new C1403m());
        try {
            TrustManager[] trustManagerArr = new TrustManager[]{new C1399a()};
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public static C1401c m3903a(C1400b c1400b) {
        return C1402l.m3904a(c1400b, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e6  */
    /* renamed from: a */
    private static com.shuame.rootgenius.common.util.C1402l.C1401c m3904a(com.shuame.rootgenius.common.util.C1402l.C1400b r8, boolean r9) {
        /*
        r0 = new java.lang.StringBuilder;
        r1 = "url:";
        r0.<init>(r1);
        r1 = r8.f3880a;
        r0.append(r1);
        r3 = new com.shuame.rootgenius.common.util.l$c;
        r3.<init>();
        r1 = 0;
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0108, ProtocolException -> 0x0106, EOFException -> 0x00c8, IOException -> 0x00d6, Exception -> 0x00e0 }
        r2 = r8.f3880a;	 Catch:{ MalformedURLException -> 0x0108, ProtocolException -> 0x0106, EOFException -> 0x00c8, IOException -> 0x00d6, Exception -> 0x00e0 }
        r0.<init>(r2);	 Catch:{ MalformedURLException -> 0x0108, ProtocolException -> 0x0106, EOFException -> 0x00c8, IOException -> 0x00d6, Exception -> 0x00e0 }
        r0 = r0.openConnection();	 Catch:{ MalformedURLException -> 0x0108, ProtocolException -> 0x0106, EOFException -> 0x00c8, IOException -> 0x00d6, Exception -> 0x00e0 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ MalformedURLException -> 0x0108, ProtocolException -> 0x0106, EOFException -> 0x00c8, IOException -> 0x00d6, Exception -> 0x00e0 }
        r1 = 0;
        r0.setUseCaches(r1);	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r1 = r8.f3883d;	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r0.setConnectTimeout(r1);	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r1 = r8.f3884e;	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r0.setReadTimeout(r1);	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r1 = r8.f3882c;	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        if (r1 == 0) goto L_0x0064;
    L_0x0031:
        r1 = r8.f3882c;	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r1 = r1.entrySet();	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r4 = r1.iterator();	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
    L_0x003b:
        r1 = r4.hasNext();	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        if (r1 == 0) goto L_0x0064;
    L_0x0041:
        r1 = r4.next();	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r1 = (java.util.Map.Entry) r1;	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r2 = r1.getKey();	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r2 = (java.lang.String) r2;	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r1 = r1.getValue();	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r1 = (java.lang.String) r1;	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r0.setRequestProperty(r2, r1);	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        goto L_0x003b;
    L_0x0057:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x005b:
        r0.printStackTrace();	 Catch:{ all -> 0x00eb }
        if (r1 == 0) goto L_0x0063;
    L_0x0060:
        r1.disconnect();
    L_0x0063:
        return r3;
    L_0x0064:
        if (r9 == 0) goto L_0x008a;
    L_0x0066:
        r1 = r8.f3881b;	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        if (r1 != 0) goto L_0x0072;
    L_0x006a:
        r1 = "";
        r1 = r1.getBytes();	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r8.f3881b = r1;	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
    L_0x0072:
        r1 = 1;
        r0.setDoOutput(r1);	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r1 = "POST";
        r0.setRequestMethod(r1);	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r1 = r0.getOutputStream();	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r2 = r8.f3881b;	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r1.write(r2);	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r1.flush();	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r1.close();	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
    L_0x008a:
        r1 = r0.getResponseCode();	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r3.f3885a = r1;	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r1 = r3.f3885a;	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r1 != r2) goto L_0x00c2;
    L_0x0096:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r1.<init>();	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r2 = r0.getInputStream();	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r4 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r4 = new byte[r4];	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
    L_0x00a3:
        r5 = r2.read(r4);	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r6 = -1;
        if (r5 == r6) goto L_0x00bc;
    L_0x00aa:
        r6 = 0;
        r1.write(r4, r6, r5);	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        goto L_0x00a3;
    L_0x00af:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x00b3:
        r0.printStackTrace();	 Catch:{ all -> 0x00eb }
        if (r1 == 0) goto L_0x0063;
    L_0x00b8:
        r1.disconnect();
        goto L_0x0063;
    L_0x00bc:
        r1 = r1.toByteArray();	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
        r3.f3886b = r1;	 Catch:{ MalformedURLException -> 0x0057, ProtocolException -> 0x00af, EOFException -> 0x0101, IOException -> 0x00fc, Exception -> 0x00f7, all -> 0x00f2 }
    L_0x00c2:
        if (r0 == 0) goto L_0x0063;
    L_0x00c4:
        r0.disconnect();
        goto L_0x0063;
    L_0x00c8:
        r0 = move-exception;
    L_0x00c9:
        r2 = 504; // 0x1f8 float:7.06E-43 double:2.49E-321;
        r3.f3885a = r2;	 Catch:{ all -> 0x00eb }
        r0.printStackTrace();	 Catch:{ all -> 0x00eb }
        if (r1 == 0) goto L_0x0063;
    L_0x00d2:
        r1.disconnect();
        goto L_0x0063;
    L_0x00d6:
        r0 = move-exception;
    L_0x00d7:
        r0.printStackTrace();	 Catch:{ all -> 0x00eb }
        if (r1 == 0) goto L_0x0063;
    L_0x00dc:
        r1.disconnect();
        goto L_0x0063;
    L_0x00e0:
        r0 = move-exception;
    L_0x00e1:
        r0.printStackTrace();	 Catch:{ all -> 0x00eb }
        if (r1 == 0) goto L_0x0063;
    L_0x00e6:
        r1.disconnect();
        goto L_0x0063;
    L_0x00eb:
        r0 = move-exception;
    L_0x00ec:
        if (r1 == 0) goto L_0x00f1;
    L_0x00ee:
        r1.disconnect();
    L_0x00f1:
        throw r0;
    L_0x00f2:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x00ec;
    L_0x00f7:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x00e1;
    L_0x00fc:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x00d7;
    L_0x0101:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x00c9;
    L_0x0106:
        r0 = move-exception;
        goto L_0x00b3;
    L_0x0108:
        r0 = move-exception;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.common.util.l.a(com.shuame.rootgenius.common.util.l$b, boolean):com.shuame.rootgenius.common.util.l$c");
    }

    /* renamed from: b */
    public static C1401c m3905b(C1400b c1400b) {
        return C1402l.m3904a(c1400b, false);
    }
}
