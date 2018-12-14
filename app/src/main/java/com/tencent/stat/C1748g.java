package com.tencent.stat;

import android.content.Context;
import android.os.Build.VERSION;
import com.p070qq.p071e.comm.constants.Constants.KEYS;
import com.tencent.mid.api.MidService;
import com.tencent.mid.util.Util;
import com.tencent.stat.common.C1720d;
import com.tencent.stat.common.C1721e;
import com.tencent.stat.common.C1722f;
import com.tencent.stat.common.C1723g;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.event.C1735f;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.g */
class C1748g {
    /* renamed from: d */
    private static StatLogger f5134d = StatCommonHelper.getLogger();
    /* renamed from: e */
    private static C1748g f5135e = null;
    /* renamed from: f */
    private static Context f5136f = null;
    /* renamed from: a */
    DefaultHttpClient f5137a = null;
    /* renamed from: b */
    C1721e f5138b = null;
    /* renamed from: c */
    StringBuilder f5139c = new StringBuilder(4096);
    /* renamed from: g */
    private long f5140g = 0;

    private C1748g(Context context) {
        try {
            f5136f = context.getApplicationContext();
            this.f5140g = System.currentTimeMillis() / 1000;
            this.f5138b = new C1721e();
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
            this.f5137a = new DefaultHttpClient(basicHttpParams);
            this.f5137a.setKeepAliveStrategy(new C1749h(this));
        } catch (Throwable th) {
            f5134d.mo7900e(th);
        }
    }

    /* renamed from: a */
    static Context m4803a() {
        return f5136f;
    }

    /* renamed from: a */
    private String m4804a(int i, String str) {
        String str2 = "{\"code\":-1,\"msg\":\"调用失败\",\"data\":null}";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", "null");
            jSONObject.put("msg", "error:" + str);
            jSONObject.put("code", String.valueOf(i));
            return jSONObject.toString();
        } catch (Throwable th) {
            f5134d.mo7900e(th);
            return str2;
        }
    }

    /* renamed from: a */
    static void m4806a(Context context) {
        f5136f = context.getApplicationContext();
    }

    /* renamed from: a */
    private void m4807a(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("mid");
            if (Util.isMidValid(optString)) {
                if (StatConfig.isDebugEnable()) {
                    f5134d.mo7904i("update mid:" + optString);
                }
                Util.updateIfLocalInvalid(f5136f, optString);
            }
            if (!jSONObject.isNull("cfg")) {
                StatConfig.m4600a(f5136f, jSONObject.getJSONObject("cfg"));
            }
            if (!jSONObject.isNull("ncts")) {
                int i = jSONObject.getInt("ncts");
                int currentTimeMillis = (int) (((long) i) - (System.currentTimeMillis() / 1000));
                if (StatConfig.isDebugEnable()) {
                    f5134d.mo7904i("server time:" + i + ", diff time:" + currentTimeMillis);
                }
                StatCommonHelper.updateCheckTime(f5136f);
                StatCommonHelper.writeDiffTimeFromServer(f5136f, currentTimeMillis);
            }
        } catch (Throwable th) {
            f5134d.mo7912w(th);
        }
    }

    /* renamed from: b */
    private long m4808b() {
        long j = 0;
        try {
            return System.currentTimeMillis() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    /* renamed from: b */
    static C1748g m4809b(Context context) {
        if (f5135e == null) {
            synchronized (C1748g.class) {
                if (f5135e == null) {
                    f5135e = new C1748g(context);
                }
            }
        }
        return f5135e;
    }

    /* renamed from: a */
    public String mo7945a(String str, String str2) {
        String appKey = StatConfig.getAppKey(f5136f);
        String localMidOnly = MidService.getLocalMidOnly(f5136f);
        String curAppVersion = StatCommonHelper.getCurAppVersion(f5136f);
        String str3 = VERSION.RELEASE;
        String deviceModel = StatCommonHelper.getDeviceModel(f5136f);
        String linkedWay = StatCommonHelper.getLinkedWay(f5136f);
        String str4 = m4808b();
        Map hashMap = new HashMap();
        hashMap.put("UserName", "user");
        hashMap.put("AppKey", appKey);
        hashMap.put("Mid", localMidOnly);
        hashMap.put("Content", str);
        hashMap.put("AppVersion", curAppVersion);
        hashMap.put("OSVersion", str3);
        hashMap.put("Model", deviceModel);
        hashMap.put("NetWork", linkedWay);
        hashMap.put("FileType", "img");
        hashMap.put("TimeStamp", str4);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com.tencent.stat.common.Util.decode(StatConstants.FB_KEY));
        stringBuilder.append("AppKey=" + appKey);
        stringBuilder.append("AppVersion=" + curAppVersion);
        stringBuilder.append("Mid=" + localMidOnly);
        stringBuilder.append("Model=" + deviceModel);
        stringBuilder.append("NetWork=" + linkedWay);
        stringBuilder.append("OSVersion=" + str3);
        stringBuilder.append("TimeStamp=" + str4);
        hashMap.put("Sign", StatCommonHelper.md5sum(stringBuilder.toString()));
        C1720d.m4737a(f5136f);
        appKey = f5136f.getFilesDir() + "/feedback.log";
        Map hashMap2 = new HashMap();
        hashMap2.put("log", new File(appKey));
        if (str2 != null && str2.trim().length() > 0) {
            File file = new File(f5136f.getFilesDir() + "/feedback.png");
            C1723g.m4748a(str2, file);
            hashMap2.put("screenshot", file);
        }
        return mo7946a(hashMap, hashMap2);
    }

    /* renamed from: a */
    public String mo7946a(Map<String, String> map, Map<String, File> map2) {
        String stringBuilder;
        String uuid = UUID.randomUUID().toString();
        String str = "--";
        String str2 = "\r\n";
        String str3 = "UTF-8";
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://mta.qq.com/mta/api/ctr_feedback/add_feedback").openConnection();
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("connection", "keep-alive");
        httpURLConnection.setRequestProperty("Charsert", "UTF-8");
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data" + ";boundary=" + uuid);
        StringBuilder stringBuilder2 = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder2.append(str);
            stringBuilder2.append(uuid);
            stringBuilder2.append(str2);
            stringBuilder2.append("Content-Disposition: form-data; name=\"" + ((String) entry.getKey()) + "\"" + str2);
            stringBuilder2.append("Content-Type: text/plain; charset=" + str3 + str2);
            stringBuilder2.append("Content-Transfer-Encoding: 8bit" + str2);
            stringBuilder2.append(str2);
            stringBuilder2.append((String) entry.getValue());
            stringBuilder2.append(str2);
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(stringBuilder2.toString().getBytes());
        if (map2 != null) {
            for (Entry entry2 : map2.entrySet()) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str);
                stringBuilder3.append(uuid);
                stringBuilder3.append(str2);
                stringBuilder3.append("Content-Disposition: form-data; name=\"" + ((String) entry2.getKey()) + "\"; filename=\"" + ((File) entry2.getValue()).getName() + "\"" + str2);
                stringBuilder3.append("Content-Type: application/octet-stream; charset=" + str3 + str2);
                stringBuilder3.append(str2);
                dataOutputStream.write(stringBuilder3.toString().getBytes());
                InputStream fileInputStream = new FileInputStream((File) entry2.getValue());
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                dataOutputStream.write(str2.getBytes());
            }
        }
        dataOutputStream.write((str + uuid + str + str2).getBytes());
        dataOutputStream.flush();
        StringBuilder stringBuilder4 = new StringBuilder();
        if (httpURLConnection.getResponseCode() == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            while (true) {
                int read2 = inputStream.read();
                if (read2 == -1) {
                    break;
                }
                stringBuilder4.append((char) read2);
            }
            stringBuilder = stringBuilder4.toString();
        } else {
            stringBuilder = m4804a(-1, httpURLConnection.getResponseCode());
        }
        dataOutputStream.close();
        httpURLConnection.disconnect();
        return stringBuilder;
    }

    /* renamed from: a */
    void mo7947a(int i, int i2, StatFBDispatchCallback statFBDispatchCallback) {
        String appKey = StatConfig.getAppKey(f5136f);
        String localMidOnly = MidService.getLocalMidOnly(f5136f);
        String str = m4808b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com.tencent.stat.common.Util.decode(StatConstants.FB_KEY));
        stringBuilder.append("AppKey=" + appKey);
        stringBuilder.append("Mid=" + localMidOnly);
        stringBuilder.append("TimeStamp=" + str);
        String md5sum = StatCommonHelper.md5sum(stringBuilder.toString());
        Map hashMap = new HashMap();
        hashMap.put("AppKey", appKey);
        hashMap.put("Limit", Integer.toString(i2));
        hashMap.put("Mid", localMidOnly);
        hashMap.put("Offset", Integer.toString(i));
        hashMap.put("TimeStamp", str);
        hashMap.put("Sign", md5sum);
        mo7950a("http://mta.qq.com/mta/api/ctr_feedback/get_feedback", hashMap, statFBDispatchCallback);
    }

    /* renamed from: a */
    void mo7948a(C1735f c1735f, StatDispatchCallback statDispatchCallback) {
        mo7954b(Arrays.asList(new String[]{c1735f.mo7932h()}), statDispatchCallback);
    }

    /* renamed from: a */
    void mo7949a(String str, String str2, StatFBDispatchCallback statFBDispatchCallback) {
        String appKey = StatConfig.getAppKey(f5136f);
        String localMidOnly = MidService.getLocalMidOnly(f5136f);
        String str3 = m4808b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com.tencent.stat.common.Util.decode(StatConstants.FB_KEY));
        stringBuilder.append("AppKey=" + appKey);
        stringBuilder.append("FeedbackId=" + str);
        stringBuilder.append("Mid=" + localMidOnly);
        stringBuilder.append("TimeStamp=" + str3);
        String md5sum = StatCommonHelper.md5sum(stringBuilder.toString());
        Map hashMap = new HashMap();
        hashMap.put("AppKey", appKey);
        hashMap.put("Mid", localMidOnly);
        hashMap.put("FeedbackId", str);
        hashMap.put("Content", str2);
        hashMap.put("TimeStamp", str3);
        hashMap.put("Sign", md5sum);
        mo7950a("http://mta.qq.com/mta/api/ctr_feedback/reply_feedback", hashMap, statFBDispatchCallback);
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x01cc A:{Catch:{ Throwable -> 0x0062, all -> 0x00da }} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0167 A:{Catch:{ Throwable -> 0x0062, all -> 0x00da }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01fd A:{SYNTHETIC, Splitter: B:67:0x01fd} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006a A:{Catch:{ all -> 0x0216 }} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006a A:{Catch:{ all -> 0x0216 }} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01fd A:{SYNTHETIC, Splitter: B:67:0x01fd} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00dd  */
    /* renamed from: a */
    void mo7950a(java.lang.String r14, java.util.Map<java.lang.String, java.lang.String> r15, com.tencent.stat.StatFBDispatchCallback r16) {
        /*
        r13 = this;
        r5 = 0;
        r4 = "";
        r2 = "rc4";
        r6 = new org.apache.http.client.methods.HttpPost;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r6.<init>(r14);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = "Connection";
        r7 = "Keep-Alive";
        r6.setHeader(r3, r7);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = "Cache-Control";
        r6.removeHeaders(r3);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = f5136f;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = com.tencent.stat.NetworkManager.getInstance(r3);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = r3.getHttpProxy();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r7 = "Content-Encoding";
        r6.addHeader(r7, r2);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        if (r3 != 0) goto L_0x009a;
    L_0x0027:
        r2 = r13.f5137a;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2 = r2.getParams();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = "http.route.default-proxy";
        r2.removeParameter(r3);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
    L_0x0032:
        r7 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r7.<init>();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2 = r15.entrySet();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r8 = r2.iterator();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
    L_0x003f:
        r2 = r8.hasNext();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        if (r2 == 0) goto L_0x00e3;
    L_0x0045:
        r2 = r8.next();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r0 = r2;
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = r0;
        r9 = new org.apache.http.message.BasicNameValuePair;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2 = r3.getKey();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = r3.getValue();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r9.<init>(r2, r3);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r7.add(r9);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        goto L_0x003f;
    L_0x0062:
        r2 = move-exception;
        r3 = r4;
    L_0x0064:
        r4 = "";
        r5 = r2 instanceof java.lang.OutOfMemoryError;	 Catch:{ all -> 0x0216 }
        if (r5 == 0) goto L_0x01fd;
    L_0x006a:
        r4 = "OOM";
    L_0x006c:
        r5 = -1;
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0216 }
        r6.<init>();	 Catch:{ all -> 0x0216 }
        r4 = r6.append(r4);	 Catch:{ all -> 0x0216 }
        r6 = "exception happen";
        r4 = r4.append(r6);	 Catch:{ all -> 0x0216 }
        r4 = r4.toString();	 Catch:{ all -> 0x0216 }
        r3 = r13.m4804a(r5, r4);	 Catch:{ all -> 0x0216 }
        if (r16 == 0) goto L_0x008b;
    L_0x0086:
        r0 = r16;
        r0.onFBDispatch(r3);
    L_0x008b:
        if (r2 == 0) goto L_0x0099;
    L_0x008d:
        r3 = f5134d;
        r3.error(r2);
        r2 = r2 instanceof java.lang.OutOfMemoryError;
        if (r2 == 0) goto L_0x0099;
    L_0x0096:
        java.lang.System.gc();
    L_0x0099:
        return;
    L_0x009a:
        r2 = com.tencent.stat.StatConfig.isDebugEnable();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        if (r2 == 0) goto L_0x00b8;
    L_0x00a0:
        r2 = f5134d;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r8 = "proxy:";
        r7.<init>(r8);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r8 = r3.toHostString();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r7 = r7.append(r8);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2.mo7897d(r7);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
    L_0x00b8:
        r2 = r13.f5137a;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2 = r2.getParams();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r7 = "http.route.default-proxy";
        r2.setParameter(r7, r3);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2 = "X-Online-Host";
        r3 = "mta.qq.com:80";
        r6.addHeader(r2, r3);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2 = "Accept";
        r3 = "*/*";
        r6.addHeader(r2, r3);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2 = "Content-Type";
        r3 = "text/plain";
        r6.addHeader(r2, r3);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        goto L_0x0032;
    L_0x00da:
        r2 = move-exception;
    L_0x00db:
        if (r16 == 0) goto L_0x00e2;
    L_0x00dd:
        r0 = r16;
        r0.onFBDispatch(r4);
    L_0x00e2:
        throw r2;
    L_0x00e3:
        r2 = new org.apache.http.client.entity.UrlEncodedFormEntity;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = "UTF-8";
        r2.<init>(r7, r3);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r6.setEntity(r2);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2 = r13.f5137a;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = r2.execute(r6);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2 = r3.getEntity();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r6 = r3.getStatusLine();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r6 = r6.getStatusCode();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r8 = r2.getContentLength();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r7 = com.tencent.stat.StatConfig.isDebugEnable();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        if (r7 == 0) goto L_0x0127;
    L_0x0109:
        r7 = f5134d;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r10 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r11 = "http recv response status code:";
        r10.<init>(r11);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r10 = r10.append(r6);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r11 = ", content length:";
        r10 = r10.append(r11);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r10 = r10.append(r8);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r10 = r10.toString();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r7.mo7904i(r10);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
    L_0x0127:
        r10 = 0;
        r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r7 <= 0) goto L_0x01ea;
    L_0x012d:
        r7 = r2.getContent();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r8 = new java.io.DataInputStream;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r8.<init>(r7);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r10 = r2.getContentLength();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2 = (int) r10;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2 = new byte[r2];	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r8.readFully(r2);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r7.close();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r8.close();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r7 = "Content-Encoding";
        r3 = r3.getFirstHeader(r7);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        if (r3 == 0) goto L_0x0226;
    L_0x014e:
        r7 = r3.getValue();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r8 = "gzip,rc4";
        r7 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        if (r7 == 0) goto L_0x0192;
    L_0x015a:
        r2 = com.tencent.stat.common.StatCommonHelper.deocdeGZipContent(r2);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2 = com.tencent.stat.common.C1722f.m4741b(r2);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = r2;
    L_0x0163:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r6 != r2) goto L_0x01cc;
    L_0x0167:
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r6 = "UTF-8";
        r2.<init>(r3, r6);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = com.tencent.stat.StatConfig.isDebugEnable();	 Catch:{ Throwable -> 0x021a, all -> 0x020d }
        if (r3 == 0) goto L_0x0188;
    L_0x0174:
        r3 = f5134d;	 Catch:{ Throwable -> 0x021a, all -> 0x020d }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x021a, all -> 0x020d }
        r6 = "http get response data:";
        r4.<init>(r6);	 Catch:{ Throwable -> 0x021a, all -> 0x020d }
        r4 = r4.append(r2);	 Catch:{ Throwable -> 0x021a, all -> 0x020d }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x021a, all -> 0x020d }
        r3.mo7904i(r4);	 Catch:{ Throwable -> 0x021a, all -> 0x020d }
    L_0x0188:
        if (r16 == 0) goto L_0x0223;
    L_0x018a:
        r0 = r16;
        r0.onFBDispatch(r2);
        r2 = r5;
        goto L_0x008b;
    L_0x0192:
        r7 = r3.getValue();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r8 = "rc4,gzip";
        r7 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        if (r7 == 0) goto L_0x01a8;
    L_0x019e:
        r2 = com.tencent.stat.common.C1722f.m4741b(r2);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2 = com.tencent.stat.common.StatCommonHelper.deocdeGZipContent(r2);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = r2;
        goto L_0x0163;
    L_0x01a8:
        r7 = r3.getValue();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r8 = "gzip";
        r7 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        if (r7 == 0) goto L_0x01ba;
    L_0x01b4:
        r2 = com.tencent.stat.common.StatCommonHelper.deocdeGZipContent(r2);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = r2;
        goto L_0x0163;
    L_0x01ba:
        r3 = r3.getValue();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r7 = "rc4";
        r3 = r3.equalsIgnoreCase(r7);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        if (r3 == 0) goto L_0x0226;
    L_0x01c6:
        r2 = com.tencent.stat.common.C1722f.m4741b(r2);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = r2;
        goto L_0x0163;
    L_0x01cc:
        r2 = f5134d;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r7 = "Server response error code:";
        r3.<init>(r7);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = r3.append(r6);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2.error(r3);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2 = -1;
        r3 = java.lang.String.valueOf(r6);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r2 = r13.m4804a(r2, r3);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        goto L_0x0188;
    L_0x01ea:
        r3 = f5134d;	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r6 = "Server response no data.";
        r3.mo7899e(r6);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        r3 = -1;
        r6 = "no data";
        r3 = r13.m4804a(r3, r6);	 Catch:{ Throwable -> 0x0062, all -> 0x00da }
        org.apache.http.util.EntityUtils.toString(r2);	 Catch:{ Throwable -> 0x0220, all -> 0x0212 }
        r2 = r3;
        goto L_0x0188;
    L_0x01fd:
        r5 = r2 instanceof java.net.UnknownHostException;	 Catch:{ all -> 0x0216 }
        if (r5 == 0) goto L_0x0205;
    L_0x0201:
        r4 = "UnknownHost";
        goto L_0x006c;
    L_0x0205:
        r5 = r2 instanceof java.net.SocketTimeoutException;	 Catch:{ all -> 0x0216 }
        if (r5 == 0) goto L_0x006c;
    L_0x0209:
        r4 = "SocketTimeOut";
        goto L_0x006c;
    L_0x020d:
        r3 = move-exception;
        r4 = r2;
        r2 = r3;
        goto L_0x00db;
    L_0x0212:
        r2 = move-exception;
        r4 = r3;
        goto L_0x00db;
    L_0x0216:
        r2 = move-exception;
        r4 = r3;
        goto L_0x00db;
    L_0x021a:
        r3 = move-exception;
        r12 = r3;
        r3 = r2;
        r2 = r12;
        goto L_0x0064;
    L_0x0220:
        r2 = move-exception;
        goto L_0x0064;
    L_0x0223:
        r2 = r5;
        goto L_0x008b;
    L_0x0226:
        r3 = r2;
        goto L_0x0163;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.g.a(java.lang.String, java.util.Map, com.tencent.stat.StatFBDispatchCallback):void");
    }

    /* renamed from: a */
    void mo7951a(List<?> list, StatDispatchCallback statDispatchCallback) {
        Object obj = null;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            Throwable th;
            try {
                String str;
                this.f5139c.delete(0, this.f5139c.length());
                this.f5139c.append("[");
                String str2 = "rc4";
                for (int i = 0; i < size; i++) {
                    this.f5139c.append(list.get(i).toString());
                    if (i != size - 1) {
                        this.f5139c.append(",");
                    }
                }
                this.f5139c.append("]");
                String stringBuilder = this.f5139c.toString();
                size = stringBuilder.length();
                String str3 = StatConfig.getStatReportUrl() + "/?index=" + this.f5140g;
                this.f5140g++;
                if (StatConfig.isDebugEnable()) {
                    f5134d.mo7904i("[" + str3 + "]Send request(" + size + "bytes), content:" + stringBuilder);
                }
                HttpPost httpPost = new HttpPost(str3);
                httpPost.addHeader("Accept-Encoding", "gzip");
                httpPost.setHeader("Connection", "Keep-Alive");
                httpPost.removeHeaders("Cache-Control");
                HttpHost httpProxy = NetworkManager.getInstance(f5136f).getHttpProxy();
                httpPost.addHeader("Content-Encoding", str2);
                if (httpProxy == null) {
                    this.f5137a.getParams().removeParameter("http.route.default-proxy");
                } else {
                    if (StatConfig.isDebugEnable()) {
                        f5134d.mo7897d("proxy:" + httpProxy.toHostString());
                    }
                    httpPost.addHeader("X-Content-Encoding", str2);
                    this.f5137a.getParams().setParameter("http.route.default-proxy", httpProxy);
                    httpPost.addHeader("X-Online-Host", StatConfig.f4838k);
                    httpPost.addHeader("Accept", "*/*");
                    httpPost.addHeader("Content-Type", "json");
                }
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream(size);
                byte[] bytes = stringBuilder.getBytes("UTF-8");
                int length = bytes.length;
                if (size > StatConfig.f4842o) {
                    obj = 1;
                }
                if (obj != null) {
                    httpPost.removeHeaders("Content-Encoding");
                    str = str2 + ",gzip";
                    httpPost.addHeader("Content-Encoding", str);
                    if (httpProxy != null) {
                        httpPost.removeHeaders("X-Content-Encoding");
                        httpPost.addHeader("X-Content-Encoding", str);
                    }
                    byteArrayOutputStream.write(new byte[4]);
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                    bytes = byteArrayOutputStream.toByteArray();
                    ByteBuffer.wrap(bytes, 0, 4).putInt(length);
                    if (StatConfig.isDebugEnable()) {
                        f5134d.mo7897d("before Gzip:" + length + " bytes, after Gzip:" + bytes.length + " bytes");
                    }
                }
                httpPost.setEntity(new ByteArrayEntity(C1722f.m4739a(bytes)));
                HttpResponse execute = this.f5137a.execute(httpPost);
                HttpEntity entity = execute.getEntity();
                size = execute.getStatusLine().getStatusCode();
                long contentLength = entity.getContentLength();
                if (StatConfig.isDebugEnable()) {
                    f5134d.mo7904i("http recv response status code:" + size + ", content length:" + contentLength);
                }
                if (contentLength == 0) {
                    f5134d.mo7899e((Object) "Server response no data.");
                    if (statDispatchCallback != null) {
                        statDispatchCallback.onDispatchFailure();
                    }
                    EntityUtils.toString(entity);
                    return;
                }
                if (contentLength > 0) {
                    InputStream content = entity.getContent();
                    DataInputStream dataInputStream = new DataInputStream(content);
                    bytes = new byte[((int) entity.getContentLength())];
                    dataInputStream.readFully(bytes);
                    content.close();
                    dataInputStream.close();
                    Header firstHeader = execute.getFirstHeader("Content-Encoding");
                    if (firstHeader != null) {
                        if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                            bytes = C1722f.m4741b(StatCommonHelper.deocdeGZipContent(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                            bytes = StatCommonHelper.deocdeGZipContent(C1722f.m4741b(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("gzip")) {
                            bytes = StatCommonHelper.deocdeGZipContent(bytes);
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                            bytes = C1722f.m4741b(bytes);
                        }
                    }
                    str = new String(bytes, "UTF-8");
                    if (StatConfig.isDebugEnable()) {
                        f5134d.mo7904i("http get response data:" + str);
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (size == 200) {
                        m4807a(jSONObject);
                        if (statDispatchCallback != null) {
                            if (jSONObject.optInt(KEYS.RET) == 0) {
                                statDispatchCallback.onDispatchSuccess();
                            } else {
                                f5134d.error((Object) "response error data.");
                                statDispatchCallback.onDispatchFailure();
                            }
                        }
                    } else {
                        f5134d.error("Server response error code:" + size + ", error:" + new String(bytes, "UTF-8"));
                        if (statDispatchCallback != null) {
                            statDispatchCallback.onDispatchFailure();
                        }
                    }
                    content.close();
                } else {
                    EntityUtils.toString(entity);
                }
                byteArrayOutputStream.close();
                th = null;
                if (th != null) {
                    f5134d.error(th);
                    if (statDispatchCallback != null) {
                        try {
                            statDispatchCallback.onDispatchFailure();
                        } catch (Throwable th2) {
                            f5134d.mo7900e(th2);
                        }
                    }
                    if (th instanceof OutOfMemoryError) {
                        System.gc();
                        this.f5139c = null;
                        this.f5139c = new StringBuilder(2048);
                    }
                    NetworkManager.getInstance(f5136f).onDispatchFailed();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* renamed from: b */
    void mo7952b(int i, int i2, StatFBDispatchCallback statFBDispatchCallback) {
        if (this.f5138b != null) {
            this.f5138b.mo7916a(new C1752k(this, i, i2, statFBDispatchCallback));
        }
    }

    /* renamed from: b */
    void mo7953b(String str, String str2, StatFBDispatchCallback statFBDispatchCallback) {
        if (this.f5138b != null) {
            this.f5138b.mo7916a(new C1751j(this, str, str2, statFBDispatchCallback));
        }
    }

    /* renamed from: b */
    void mo7954b(List<?> list, StatDispatchCallback statDispatchCallback) {
        if (this.f5138b != null) {
            this.f5138b.mo7916a(new C1750i(this, list, statDispatchCallback));
        }
    }

    /* renamed from: c */
    void mo7955c(String str, String str2, StatFBDispatchCallback statFBDispatchCallback) {
        if (this.f5138b != null) {
            this.f5138b.mo7916a(new C1753l(this, str, str2, statFBDispatchCallback));
        }
    }
}
