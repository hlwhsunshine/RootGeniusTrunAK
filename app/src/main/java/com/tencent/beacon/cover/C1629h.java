package com.tencent.beacon.cover;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.stat.common.DeviceInfo;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.beacon.cover.h */
public final class C1629h implements Runnable {
    /* renamed from: a */
    private String f4622a = null;
    /* renamed from: b */
    private Context f4623b;
    /* renamed from: c */
    private List<C1622a> f4624c = null;
    /* renamed from: d */
    private C1624c f4625d = null;

    public C1629h(Context context, List<C1622a> list) {
        this.f4623b = context;
        this.f4624c = new ArrayList();
        this.f4624c.addAll(list);
        this.f4622a = C1627f.m4445f(this.f4623b);
        this.f4625d = new C1624c(this.f4623b);
        this.f4625d.mo7596a();
    }

    /* renamed from: a */
    private String m4455a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkey", C1627f.m4434b(this.f4623b));
            jSONObject.put("appversion", C1627f.m4439c(this.f4623b));
            jSONObject.put("model", C1627f.m4419a());
            jSONObject.put(DeviceInfo.TAG_ANDROID_ID, C1627f.m4441d(this.f4623b));
            jSONObject.put("imei", C1627f.m4443e(this.f4623b));
            jSONObject.put("cpuabi", C1627f.m4433b());
            jSONObject.put("coverSDKver", "1.0.9");
            JSONArray jSONArray = new JSONArray();
            if (this.f4624c != null) {
                for (C1622a c1622a : this.f4624c) {
                    if (c1622a != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("compId", c1622a.f4588a);
                        jSONObject2.put("compVer", c1622a.f4589b);
                        jSONObject2.put("compType", c1622a.f4590c);
                        jSONObject2.put("md5", c1622a.f4594g);
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.put("compList", jSONArray);
        } catch (Exception e) {
        }
        C1627f.m4428a("D", "post json data:" + jSONObject.toString(), new Object[0]);
        return jSONObject.toString();
    }

    /* renamed from: a */
    protected static HttpURLConnection m4456a(String str, Map<String, String> map) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(20000);
                if (VERSION.SDK_INT > 13) {
                    httpURLConnection.setRequestProperty("Connection", "close");
                } else {
                    httpURLConnection.setRequestProperty("http.keepAlive", "false");
                }
                for (Entry entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                return httpURLConnection;
            } catch (Exception e) {
                return httpURLConnection;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    /* renamed from: a */
    private boolean m4457a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getString("appkey").equals(C1627f.m4434b(this.f4623b)) && jSONObject.getString("appversion").equals(C1627f.m4439c(this.f4623b)) && jSONObject.getString("coverSDKver").equals("1.0.9")) {
                if (jSONObject.getInt("isUpdate") != 1) {
                    return true;
                }
                JSONArray jSONArray = jSONObject.getJSONArray("updateList");
                if (jSONArray.length() <= 0) {
                    return true;
                }
                List arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    C1622a c1622a = new C1622a();
                    c1622a.f4588a = jSONObject2.getInt("compId");
                    c1622a.f4589b = jSONObject2.getString("compVer");
                    c1622a.f4590c = jSONObject2.getInt("compType");
                    c1622a.f4591d = jSONObject2.getString("name");
                    c1622a.f4592e = jSONObject2.getString("url");
                    c1622a.f4593f = jSONObject2.getInt("size");
                    c1622a.f4594g = jSONObject2.getString("md5");
                    if (c1622a.f4590c == C1627f.f4616c) {
                        c1622a.f4595h = jSONObject.getString("cpuabi");
                    }
                    arrayList.add(c1622a);
                }
                if (arrayList.size() <= 0) {
                    return true;
                }
                this.f4625d.mo7597a(arrayList);
                return true;
            }
        } catch (Exception e) {
            C1627f.m4428a("E", "parse the response data to json object failed!", new Object[0]);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e A:{SYNTHETIC, Splitter: B:24:0x005e} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0063 A:{SYNTHETIC, Splitter: B:27:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a6 A:{SYNTHETIC, Splitter: B:51:0x00a6} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ab A:{SYNTHETIC, Splitter: B:54:0x00ab} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a6 A:{SYNTHETIC, Splitter: B:51:0x00a6} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ab A:{SYNTHETIC, Splitter: B:54:0x00ab} */
    /* renamed from: a */
    protected static byte[] m4458a(java.net.HttpURLConnection r7, byte[] r8) {
        /*
        r0 = 0;
        r3 = 0;
        r1 = r7.getOutputStream();	 Catch:{ Exception -> 0x0067 }
        r1.write(r8);	 Catch:{ Exception -> 0x0067 }
        r1.flush();	 Catch:{ Exception -> 0x0067 }
    L_0x000c:
        r1 = r7.getResponseCode();	 Catch:{ Exception -> 0x008b, all -> 0x00a0 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r1 != r2) goto L_0x0066;
    L_0x0014:
        r1 = r7.getInputStream();	 Catch:{ Exception -> 0x008b, all -> 0x00a0 }
        r2 = r7.getContentEncoding();	 Catch:{ Exception -> 0x008b, all -> 0x00a0 }
        if (r2 == 0) goto L_0x0075;
    L_0x001e:
        r3 = "gzip";
        r3 = r2.equalsIgnoreCase(r3);	 Catch:{ Exception -> 0x008b, all -> 0x00a0 }
        if (r3 == 0) goto L_0x0075;
    L_0x0026:
        r2 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x008b, all -> 0x00a0 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x008b, all -> 0x00a0 }
    L_0x002b:
        r3 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x00bf, all -> 0x00b9 }
        r3.<init>();	 Catch:{ Exception -> 0x00bf, all -> 0x00b9 }
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r1 = new byte[r1];	 Catch:{ Exception -> 0x0040 }
    L_0x0034:
        r4 = r2.read(r1);	 Catch:{ Exception -> 0x0040 }
        r5 = -1;
        if (r4 == r5) goto L_0x0091;
    L_0x003b:
        r5 = 0;
        r3.write(r1, r5, r4);	 Catch:{ Exception -> 0x0040 }
        goto L_0x0034;
    L_0x0040:
        r1 = move-exception;
    L_0x0041:
        r4 = "E";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00bd }
        r6 = "parse response failure: ";
        r5.<init>(r6);	 Catch:{ all -> 0x00bd }
        r1 = r1.toString();	 Catch:{ all -> 0x00bd }
        r1 = r5.append(r1);	 Catch:{ all -> 0x00bd }
        r1 = r1.toString();	 Catch:{ all -> 0x00bd }
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00bd }
        com.tencent.beacon.cover.C1627f.m4428a(r4, r1, r5);	 Catch:{ all -> 0x00bd }
        if (r2 == 0) goto L_0x0061;
    L_0x005e:
        r2.close();	 Catch:{ IOException -> 0x00b1 }
    L_0x0061:
        if (r3 == 0) goto L_0x0066;
    L_0x0063:
        r3.close();	 Catch:{ IOException -> 0x00b3 }
    L_0x0066:
        return r0;
    L_0x0067:
        r1 = move-exception;
        r1.printStackTrace();
        r1 = "E";
        r2 = "httpURLConnection write post data error!";
        r3 = new java.lang.Object[r3];
        com.tencent.beacon.cover.C1627f.m4428a(r1, r2, r3);
        goto L_0x000c;
    L_0x0075:
        if (r2 == 0) goto L_0x008f;
    L_0x0077:
        r3 = "deflate";
        r2 = r2.equalsIgnoreCase(r3);	 Catch:{ Exception -> 0x008b, all -> 0x00a0 }
        if (r2 == 0) goto L_0x008f;
    L_0x007f:
        r2 = new java.util.zip.InflaterInputStream;	 Catch:{ Exception -> 0x008b, all -> 0x00a0 }
        r3 = new java.util.zip.Inflater;	 Catch:{ Exception -> 0x008b, all -> 0x00a0 }
        r4 = 1;
        r3.<init>(r4);	 Catch:{ Exception -> 0x008b, all -> 0x00a0 }
        r2.<init>(r1, r3);	 Catch:{ Exception -> 0x008b, all -> 0x00a0 }
        goto L_0x002b;
    L_0x008b:
        r1 = move-exception;
        r2 = r0;
        r3 = r0;
        goto L_0x0041;
    L_0x008f:
        r2 = r1;
        goto L_0x002b;
    L_0x0091:
        r0 = r3.toByteArray();	 Catch:{ Exception -> 0x0040 }
        if (r2 == 0) goto L_0x009a;
    L_0x0097:
        r2.close();	 Catch:{ IOException -> 0x00af }
    L_0x009a:
        r3.close();	 Catch:{ IOException -> 0x009e }
        goto L_0x0066;
    L_0x009e:
        r1 = move-exception;
        goto L_0x0066;
    L_0x00a0:
        r1 = move-exception;
        r2 = r0;
        r3 = r0;
        r0 = r1;
    L_0x00a4:
        if (r2 == 0) goto L_0x00a9;
    L_0x00a6:
        r2.close();	 Catch:{ IOException -> 0x00b5 }
    L_0x00a9:
        if (r3 == 0) goto L_0x00ae;
    L_0x00ab:
        r3.close();	 Catch:{ IOException -> 0x00b7 }
    L_0x00ae:
        throw r0;
    L_0x00af:
        r1 = move-exception;
        goto L_0x009a;
    L_0x00b1:
        r1 = move-exception;
        goto L_0x0061;
    L_0x00b3:
        r1 = move-exception;
        goto L_0x0066;
    L_0x00b5:
        r1 = move-exception;
        goto L_0x00a9;
    L_0x00b7:
        r1 = move-exception;
        goto L_0x00ae;
    L_0x00b9:
        r1 = move-exception;
        r3 = r0;
        r0 = r1;
        goto L_0x00a4;
    L_0x00bd:
        r0 = move-exception;
        goto L_0x00a4;
    L_0x00bf:
        r1 = move-exception;
        r3 = r0;
        goto L_0x0041;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.beacon.cover.h.a(java.net.HttpURLConnection, byte[]):byte[]");
    }

    /* renamed from: b */
    private boolean m4459b() {
        String a = m4455a();
        String a2 = C1627f.m4422a(this.f4622a);
        try {
            byte[] a3 = C1627f.m4432a(true, this.f4622a, a.getBytes("utf-8"));
            if (a3 == null) {
                return false;
            }
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Content-Length", String.valueOf(a3.length));
            hashMap.put("encr_type", "rsapost");
            hashMap.put("rsa_encr_key", a2);
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i >= 3) {
                    return false;
                }
                C1627f.m4428a("D", "start http post: http://oth.update.mdt.qq.com:8080/beacon/vercheck", new Object[0]);
                HttpURLConnection a4 = C1629h.m4456a("http://oth.update.mdt.qq.com:8080/beacon/vercheck", hashMap);
                if (a4 != null) {
                    byte[] a5 = C1629h.m4458a(a4, a3);
                    if (a5 != null) {
                        try {
                            if (C1627f.m4432a(false, this.f4622a, a5) != null) {
                                String str = new String(C1627f.m4432a(false, this.f4622a, a5));
                                C1627f.m4428a("D", "ResponseData: " + str, new Object[0]);
                                return m4457a(str);
                            }
                        } catch (Exception e) {
                            C1627f.m4428a("E", "decode response data error!", new Object[0]);
                        }
                    } else {
                        continue;
                    }
                }
                C1627f.m4426a(10000);
                i = i2;
            }
        } catch (Exception e2) {
            C1627f.m4428a("E", "Encry post data error!", new Object[0]);
            return false;
        }
    }

    public final void run() {
        if (m4459b()) {
            C1627f.m4428a("I", "version check request success!", new Object[0]);
        }
    }
}
