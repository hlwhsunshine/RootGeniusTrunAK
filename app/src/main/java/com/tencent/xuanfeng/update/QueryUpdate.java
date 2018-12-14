package com.tencent.xuanfeng.update;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public class QueryUpdate {
    private HttpURLConnection connection = null;
    private String moduleName = null;
    Map<String, String> postParam = new HashMap();
    private KernelInfoCallback queryCallBack = null;
    private Thread queryThread = null;

    class QuerUpdateThread implements Runnable {
        QuerUpdateThread() {
        }

        public void run() {
            QueryUpdate.this.sendPostMassage(QueryUpdate.this.postParam, Encrypt.URL);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter: B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a0 A:{SYNTHETIC, Splitter: B:29:0x00a0} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter: B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a0 A:{SYNTHETIC, Splitter: B:29:0x00a0} */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter: B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a0 A:{SYNTHETIC, Splitter: B:29:0x00a0} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter: B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a0 A:{SYNTHETIC, Splitter: B:29:0x00a0} */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A:{SYNTHETIC, RETURN} */
    private void sendPostMassage(java.util.Map<java.lang.String, java.lang.String> r14, java.lang.String r15) {
        /*
        r13 = this;
        r11 = -1;
        r5 = 2;
        r10 = 51200; // 0xc800 float:7.1746E-41 double:2.5296E-319;
        r6 = 0;
        r4 = 0;
        r3 = 0;
        r7 = new java.lang.StringBuffer;	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r7.<init>();	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r1 = r14.entrySet();	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r8 = r1.iterator();	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
    L_0x0015:
        r1 = r8.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        if (r1 != 0) goto L_0x00a4;
    L_0x001b:
        r1 = r7.length();	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r1 = r1 + -1;
        r7.deleteCharAt(r1);	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r1 = r7.toString();	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r2 = "www.tencent.com.";
        r2 = r2.getBytes();	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r7 = com.tencent.xuanfeng.update.Encrypt.oi_symmetry_encrypt2(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r1 = new java.net.URL;	 Catch:{ IOException -> 0x00ee }
        r1.<init>(r15);	 Catch:{ IOException -> 0x00ee }
        r1 = r1.openConnection();	 Catch:{ IOException -> 0x00ee }
        r1 = (java.net.HttpURLConnection) r1;	 Catch:{ IOException -> 0x00ee }
        r13.connection = r1;	 Catch:{ IOException -> 0x00ee }
        r1 = r13.connection;	 Catch:{ IOException -> 0x00ee }
        r2 = 50000; // 0xc350 float:7.0065E-41 double:2.47033E-319;
        r1.setConnectTimeout(r2);	 Catch:{ IOException -> 0x00ee }
        r1 = r13.connection;	 Catch:{ IOException -> 0x00ee }
        r2 = 1;
        r1.setDoInput(r2);	 Catch:{ IOException -> 0x00ee }
        r1 = r13.connection;	 Catch:{ IOException -> 0x00ee }
        r2 = 1;
        r1.setDoOutput(r2);	 Catch:{ IOException -> 0x00ee }
        r1 = r13.connection;	 Catch:{ IOException -> 0x00ee }
        r2 = "Content-Length";
        r8 = r7.length;	 Catch:{ IOException -> 0x00ee }
        r8 = java.lang.String.valueOf(r8);	 Catch:{ IOException -> 0x00ee }
        r1.setRequestProperty(r2, r8);	 Catch:{ IOException -> 0x00ee }
        r1 = r13.connection;	 Catch:{ IOException -> 0x00ee }
        r2 = r1.getOutputStream();	 Catch:{ IOException -> 0x00ee }
        r2.write(r7);	 Catch:{ IOException -> 0x0107, UnsupportedEncodingException -> 0x00fe }
        r1 = r13.connection;	 Catch:{ IOException -> 0x0107, UnsupportedEncodingException -> 0x00fe }
        r1 = r1.getInputStream();	 Catch:{ IOException -> 0x0107, UnsupportedEncodingException -> 0x00fe }
        r3 = 51200; // 0xc800 float:7.1746E-41 double:2.5296E-319;
        r4 = new byte[r3];	 Catch:{ IOException -> 0x010a, UnsupportedEncodingException -> 0x0101 }
        r3 = r13.connection;	 Catch:{ IOException -> 0x010a, UnsupportedEncodingException -> 0x0101 }
        r3 = r3.getResponseCode();	 Catch:{ IOException -> 0x010a, UnsupportedEncodingException -> 0x0101 }
        r7 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 != r7) goto L_0x00eb;
    L_0x007d:
        r3 = r6;
    L_0x007e:
        r7 = r10 - r3;
        if (r7 <= 0) goto L_0x008a;
    L_0x0082:
        r7 = r10 - r3;
        r7 = r1.read(r4, r3, r7);	 Catch:{ IOException -> 0x010a, UnsupportedEncodingException -> 0x0101 }
        if (r7 != r11) goto L_0x00da;
    L_0x008a:
        if (r10 != r3) goto L_0x00de;
    L_0x008c:
        r3 = r1;
        r1 = r5;
    L_0x008e:
        if (r1 == 0) goto L_0x0099;
    L_0x0090:
        r4 = r13.queryCallBack;
        if (r4 == 0) goto L_0x0099;
    L_0x0094:
        r4 = r13.queryCallBack;
        r4.DownloadUpdateError(r1);
    L_0x0099:
        if (r2 == 0) goto L_0x009e;
    L_0x009b:
        r2.close();	 Catch:{ IOException -> 0x00f4 }
    L_0x009e:
        if (r3 == 0) goto L_0x00a3;
    L_0x00a0:
        r3.close();	 Catch:{ IOException -> 0x00f9 }
    L_0x00a3:
        return;
    L_0x00a4:
        r1 = r8.next();	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r0 = r1;
        r0 = (java.util.Map.Entry) r0;	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r2 = r0;
        r1 = r2.getKey();	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r1 = (java.lang.String) r1;	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r1 = r7.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r9 = "=";
        r9 = r1.append(r9);	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r1 = r2.getValue();	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r1 = (java.lang.String) r1;	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r2 = "utf-8";
        r1 = java.net.URLEncoder.encode(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r1 = r9.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        r2 = "&";
        r1.append(r2);	 Catch:{ UnsupportedEncodingException -> 0x00d3 }
        goto L_0x0015;
    L_0x00d3:
        r1 = move-exception;
    L_0x00d4:
        r1.printStackTrace();
        r1 = 3;
        r2 = r4;
        goto L_0x008e;
    L_0x00da:
        if (r7 == r11) goto L_0x008a;
    L_0x00dc:
        r3 = r3 + r7;
        goto L_0x007e;
    L_0x00de:
        r7 = new byte[r3];	 Catch:{ IOException -> 0x010a, UnsupportedEncodingException -> 0x0101 }
        r8 = 0;
        r9 = 0;
        java.lang.System.arraycopy(r4, r8, r7, r9, r3);	 Catch:{ IOException -> 0x010a, UnsupportedEncodingException -> 0x0101 }
        r13.parser(r7);	 Catch:{ IOException -> 0x010a, UnsupportedEncodingException -> 0x0101 }
        r3 = r1;
        r1 = r6;
        goto L_0x008e;
    L_0x00eb:
        r3 = r1;
        r1 = r5;
        goto L_0x008e;
    L_0x00ee:
        r1 = move-exception;
        r1 = r3;
        r2 = r4;
    L_0x00f1:
        r3 = r1;
        r1 = r5;
        goto L_0x008e;
    L_0x00f4:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x009e;
    L_0x00f9:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00a3;
    L_0x00fe:
        r1 = move-exception;
        r4 = r2;
        goto L_0x00d4;
    L_0x0101:
        r3 = move-exception;
        r4 = r2;
        r12 = r1;
        r1 = r3;
        r3 = r12;
        goto L_0x00d4;
    L_0x0107:
        r1 = move-exception;
        r1 = r3;
        goto L_0x00f1;
    L_0x010a:
        r3 = move-exception;
        goto L_0x00f1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xuanfeng.update.QueryUpdate.sendPostMassage(java.util.Map, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052  */
    public void parser(byte[] r5) {
        /*
        r4 = this;
        r0 = "www.tencent.com.";
        r0 = r0.getBytes();
        r0 = com.tencent.xuanfeng.update.Decrypt.oi_symmetry_decrypt2(r5, r0);
        r2 = new com.tencent.xuanfeng.update.KernelModuleInfo;
        r2.<init>();
        r1 = 0;
        r3 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0048 }
        r3.<init>(r0);	 Catch:{ JSONException -> 0x0048 }
        r0 = "md5";
        r0 = r3.getString(r0);	 Catch:{ JSONException -> 0x0048 }
        r2.kernelMD5 = r0;	 Catch:{ JSONException -> 0x0048 }
        r0 = "url";
        r0 = r3.getString(r0);	 Catch:{ JSONException -> 0x0048 }
        r2.kernelUpdateUrl = r0;	 Catch:{ JSONException -> 0x0048 }
        r0 = "version";
        r0 = r3.getString(r0);	 Catch:{ JSONException -> 0x0048 }
        r2.kernelVersion = r0;	 Catch:{ JSONException -> 0x0048 }
        r0 = "enable";
        r0 = r3.getString(r0);	 Catch:{ JSONException -> 0x0048 }
        r3 = "0";
        r0 = r3.equals(r0);	 Catch:{ JSONException -> 0x0048 }
        if (r0 != 0) goto L_0x004c;
    L_0x003b:
        r0 = 1;
    L_0x003c:
        if (r0 == 0) goto L_0x004e;
    L_0x003e:
        r0 = r4.queryCallBack;
        if (r0 == 0) goto L_0x004e;
    L_0x0042:
        r0 = r4.queryCallBack;
        r0.QueryUpdateNeedUpdate(r2);
    L_0x0047:
        return;
    L_0x0048:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x004c:
        r0 = r1;
        goto L_0x003c;
    L_0x004e:
        r0 = r4.queryCallBack;
        if (r0 == 0) goto L_0x0047;
    L_0x0052:
        r0 = r4.queryCallBack;
        r0.QueryUpadteNoUpdate();
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xuanfeng.update.QueryUpdate.parser(byte[]):void");
    }

    public void setKernelInfoCallback(KernelInfoCallback kernelInfoCallback) {
        this.queryCallBack = kernelInfoCallback;
    }

    public void setModuleName(String str) {
        this.moduleName = str;
    }

    public boolean startQueryUpdate(KernelModuleInfo kernelModuleInfo) {
        if (this.queryThread != null && this.queryThread.isAlive()) {
            return false;
        }
        stopQueryUpdate();
        this.postParam.clear();
        if (this.moduleName != null) {
            this.postParam.put("t", this.moduleName);
        }
        this.postParam.put(IXAdRequestInfo.f650V, kernelModuleInfo.kernelVersion);
        this.postParam.put("m", "mobile");
        this.postParam.put("packname", "libqqdlkernel");
        if (kernelModuleInfo.kernelInstalled) {
            this.postParam.put("installed", "1");
        } else {
            this.postParam.put("installed", "0");
        }
        this.postParam.put("clicked", "0");
        this.postParam.put("lan", "zh-cn");
        this.postParam.put("product", "xfaso");
        this.queryThread = new Thread(new QuerUpdateThread());
        this.queryThread.start();
        return true;
    }

    public void stopQueryUpdate() {
        if (this.connection != null) {
            this.connection.disconnect();
            this.connection = null;
        }
        if (this.queryThread == null) {
            return;
        }
        if (this.queryThread.isAlive()) {
            try {
                this.queryThread.wait(2000);
                this.queryThread = null;
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        this.queryThread = null;
    }
}
