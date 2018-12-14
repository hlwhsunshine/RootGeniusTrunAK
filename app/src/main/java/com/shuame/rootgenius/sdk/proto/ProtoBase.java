package com.shuame.rootgenius.sdk.proto;

import com.shuame.rootgenius.sdk.C1473h;
import com.shuame.rootgenius.sdk.RgsdkConfig;

public abstract class ProtoBase {
    private static final String TAG = ProtoBase.class.getSimpleName();

    public static byte[] DecodeBytes(byte[] bArr) {
        int i = 0;
        int length = bArr.length;
        C1473h.m4102a(TAG, "DecodeBytes len:" + length);
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ 107);
        }
        while (i < length / 2) {
            byte b = bArr[i];
            bArr[i] = bArr[(length - i) - 1];
            bArr[(length - i) - 1] = b;
            i++;
        }
        return bArr;
    }

    public static boolean isSuccess(int i) {
        return i == 200 || i == 206;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0156  */
    public static byte[] postReq(java.lang.String r10, java.lang.String r11) {
        /*
        r1 = 0;
        r3 = -1;
        r0 = TAG;	 Catch:{ SocketTimeoutException -> 0x01ae, ConnectException -> 0x019f, UnknownHostException -> 0x0184, IOException -> 0x011b, all -> 0x0152 }
        r2 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x01ae, ConnectException -> 0x019f, UnknownHostException -> 0x0184, IOException -> 0x011b, all -> 0x0152 }
        r4 = "posting url:";
        r2.<init>(r4);	 Catch:{ SocketTimeoutException -> 0x01ae, ConnectException -> 0x019f, UnknownHostException -> 0x0184, IOException -> 0x011b, all -> 0x0152 }
        r2 = r2.append(r10);	 Catch:{ SocketTimeoutException -> 0x01ae, ConnectException -> 0x019f, UnknownHostException -> 0x0184, IOException -> 0x011b, all -> 0x0152 }
        r2 = r2.toString();	 Catch:{ SocketTimeoutException -> 0x01ae, ConnectException -> 0x019f, UnknownHostException -> 0x0184, IOException -> 0x011b, all -> 0x0152 }
        com.shuame.rootgenius.sdk.C1473h.m4104c(r0, r2);	 Catch:{ SocketTimeoutException -> 0x01ae, ConnectException -> 0x019f, UnknownHostException -> 0x0184, IOException -> 0x011b, all -> 0x0152 }
        r4 = new java.net.URL;	 Catch:{ SocketTimeoutException -> 0x01ae, ConnectException -> 0x019f, UnknownHostException -> 0x0184, IOException -> 0x011b, all -> 0x0152 }
        r4.<init>(r10);	 Catch:{ SocketTimeoutException -> 0x01ae, ConnectException -> 0x019f, UnknownHostException -> 0x0184, IOException -> 0x011b, all -> 0x0152 }
        r0 = r4.openConnection();	 Catch:{ SocketTimeoutException -> 0x01b3, ConnectException -> 0x01a4, UnknownHostException -> 0x01b7, IOException -> 0x0197, all -> 0x018d }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ SocketTimeoutException -> 0x01b3, ConnectException -> 0x01a4, UnknownHostException -> 0x01b7, IOException -> 0x0197, all -> 0x018d }
        r2 = 1;
        r0.setDoOutput(r2);	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        r2 = "POST";
        r0.setRequestMethod(r2);	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        r2 = "Connection";
        r5 = "Close";
        r0.setRequestProperty(r2, r5);	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        r2 = "Content-Type";
        r5 = "text/plain";
        r0.setRequestProperty(r2, r5);	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setConnectTimeout(r2);	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        if (r11 == 0) goto L_0x005b;
    L_0x003f:
        r2 = r11.length();	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        if (r2 <= 0) goto L_0x005b;
    L_0x0045:
        r2 = r11.getBytes();	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        r2 = DecodeBytes(r2);	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        r2 = com.shuame.rootgenius.sdk.JniHelper.encrypt(r2);	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        r5 = r0.getOutputStream();	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        r5.write(r2);	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        r5.close();	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
    L_0x005b:
        r3 = r0.getResponseCode();	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        r2 = isSuccess(r3);	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        if (r2 == 0) goto L_0x00ea;
    L_0x0065:
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        r5 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r2.<init>(r5);	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        r5 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r5 = new byte[r5];	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        r6 = r0.getInputStream();	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
    L_0x0074:
        r7 = r6.read(r5);	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        if (r7 <= 0) goto L_0x00d6;
    L_0x007a:
        r8 = 0;
        r2.write(r5, r8, r7);	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        goto L_0x0074;
    L_0x007f:
        r2 = move-exception;
        r9 = r2;
        r2 = r0;
        r0 = r9;
    L_0x0083:
        r5 = TAG;	 Catch:{ all -> 0x0194 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0194 }
        r7 = "post url ";
        r6.<init>(r7);	 Catch:{ all -> 0x0194 }
        r6 = r6.append(r10);	 Catch:{ all -> 0x0194 }
        r7 = " fail by time out";
        r6 = r6.append(r7);	 Catch:{ all -> 0x0194 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0194 }
        r0 = r6.append(r0);	 Catch:{ all -> 0x0194 }
        r0 = r0.toString();	 Catch:{ all -> 0x0194 }
        com.shuame.rootgenius.sdk.C1473h.m4106e(r5, r0);	 Catch:{ all -> 0x0194 }
        if (r2 == 0) goto L_0x00aa;
    L_0x00a7:
        r2.disconnect();
    L_0x00aa:
        r0 = TAG;
        r2 = new java.lang.StringBuilder;
        r5 = "[PostReq]url:";
        r2.<init>(r5);
        r5 = r4.getHost();
        r2 = r2.append(r5);
        r4 = r4.getFile();
        r2 = r2.append(r4);
        r4 = ",response:";
        r2 = r2.append(r4);
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.rootgenius.sdk.C1473h.m4104c(r0, r2);
        r0 = r1;
    L_0x00d5:
        return r0;
    L_0x00d6:
        r6.close();	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        r2 = r2.toByteArray();	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        if (r2 == 0) goto L_0x00ea;
    L_0x00df:
        r5 = r2.length;	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        if (r5 <= 0) goto L_0x00ea;
    L_0x00e2:
        r2 = com.shuame.rootgenius.sdk.JniHelper.decrypt(r2);	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
        r1 = DecodeBytes(r2);	 Catch:{ SocketTimeoutException -> 0x007f, ConnectException -> 0x01a8, UnknownHostException -> 0x01bb, IOException -> 0x019a, all -> 0x018f }
    L_0x00ea:
        if (r0 == 0) goto L_0x00ef;
    L_0x00ec:
        r0.disconnect();
    L_0x00ef:
        r0 = TAG;
        r2 = new java.lang.StringBuilder;
        r5 = "[PostReq]url:";
        r2.<init>(r5);
        r5 = r4.getHost();
        r2 = r2.append(r5);
        r4 = r4.getFile();
        r2 = r2.append(r4);
        r4 = ",response:";
        r2 = r2.append(r4);
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.rootgenius.sdk.C1473h.m4104c(r0, r2);
        r0 = r1;
        goto L_0x00d5;
    L_0x011b:
        r0 = move-exception;
        r2 = r1;
        r4 = r1;
    L_0x011e:
        r0.printStackTrace();	 Catch:{ all -> 0x0194 }
        if (r2 == 0) goto L_0x0126;
    L_0x0123:
        r2.disconnect();
    L_0x0126:
        r0 = TAG;
        r2 = new java.lang.StringBuilder;
        r5 = "[PostReq]url:";
        r2.<init>(r5);
        r5 = r4.getHost();
        r2 = r2.append(r5);
        r4 = r4.getFile();
        r2 = r2.append(r4);
        r4 = ",response:";
        r2 = r2.append(r4);
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.rootgenius.sdk.C1473h.m4104c(r0, r2);
        r0 = r1;
        goto L_0x00d5;
    L_0x0152:
        r0 = move-exception;
        r4 = r1;
    L_0x0154:
        if (r1 == 0) goto L_0x0159;
    L_0x0156:
        r1.disconnect();
    L_0x0159:
        r1 = TAG;
        r2 = new java.lang.StringBuilder;
        r5 = "[PostReq]url:";
        r2.<init>(r5);
        r5 = r4.getHost();
        r2 = r2.append(r5);
        r4 = r4.getFile();
        r2 = r2.append(r4);
        r4 = ",response:";
        r2 = r2.append(r4);
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.rootgenius.sdk.C1473h.m4104c(r1, r2);
        throw r0;
    L_0x0184:
        r0 = move-exception;
        r2 = r3;
        r4 = r1;
        r3 = r1;
    L_0x0188:
        r9 = r2;
        r2 = r3;
        r3 = r9;
        goto L_0x0083;
    L_0x018d:
        r0 = move-exception;
        goto L_0x0154;
    L_0x018f:
        r1 = move-exception;
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x0154;
    L_0x0194:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0154;
    L_0x0197:
        r0 = move-exception;
        r2 = r1;
        goto L_0x011e;
    L_0x019a:
        r2 = move-exception;
        r9 = r2;
        r2 = r0;
        r0 = r9;
        goto L_0x011e;
    L_0x019f:
        r0 = move-exception;
        r2 = r1;
        r4 = r1;
        goto L_0x0083;
    L_0x01a4:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0083;
    L_0x01a8:
        r2 = move-exception;
        r9 = r2;
        r2 = r0;
        r0 = r9;
        goto L_0x0083;
    L_0x01ae:
        r0 = move-exception;
        r2 = r1;
        r4 = r1;
        goto L_0x0083;
    L_0x01b3:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0083;
    L_0x01b7:
        r0 = move-exception;
        r2 = r3;
        r3 = r1;
        goto L_0x0188;
    L_0x01bb:
        r2 = move-exception;
        r9 = r2;
        r2 = r3;
        r3 = r0;
        r0 = r9;
        goto L_0x0188;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.sdk.proto.ProtoBase.postReq(java.lang.String, java.lang.String):byte[]");
    }

    public static void setChannel(String str) {
    }

    public abstract void OnResponse(int i, String str);

    public void asyncPosReq(String str) {
        new Thread(new C1475a(this, str)).start();
    }

    public abstract String getServant();

    protected String getServant(boolean z, String str) {
        return z ? new StringBuilder(RgsdkConfig.SCHEME).append(RgsdkConfig.sServerStat).append(RgsdkConfig.SERV_STAT_PREFIX).append(str).toString() : new StringBuilder(RgsdkConfig.SCHEME).append(RgsdkConfig.sServer).append(RgsdkConfig.SERV_PREFIX).append(str).toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00f3 A:{SYNTHETIC, SKIP, EDGE_INSN: B:127:0x00f3->B:33:0x00f3 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    public int postReq(java.lang.String r13) {
        /*
        r12 = this;
        r4 = 0;
        r0 = 0;
        r6 = -1;
        r3 = "";
        r1 = "";
        r7 = r0;
        r5 = r4;
    L_0x0009:
        r1 = r12.getServant();	 Catch:{ SocketTimeoutException -> 0x0295, ConnectException -> 0x0225, UnknownHostException -> 0x022d, IOException -> 0x0144, IllegalStateException -> 0x017e, Exception -> 0x01b8, all -> 0x01f2 }
        r0 = TAG;	 Catch:{ SocketTimeoutException -> 0x0295, ConnectException -> 0x0225, UnknownHostException -> 0x022d, IOException -> 0x0144, IllegalStateException -> 0x017e, Exception -> 0x01b8, all -> 0x01f2 }
        r2 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x0295, ConnectException -> 0x0225, UnknownHostException -> 0x022d, IOException -> 0x0144, IllegalStateException -> 0x017e, Exception -> 0x01b8, all -> 0x01f2 }
        r8 = "posting url:";
        r2.<init>(r8);	 Catch:{ SocketTimeoutException -> 0x0295, ConnectException -> 0x0225, UnknownHostException -> 0x022d, IOException -> 0x0144, IllegalStateException -> 0x017e, Exception -> 0x01b8, all -> 0x01f2 }
        r2 = r2.append(r1);	 Catch:{ SocketTimeoutException -> 0x0295, ConnectException -> 0x0225, UnknownHostException -> 0x022d, IOException -> 0x0144, IllegalStateException -> 0x017e, Exception -> 0x01b8, all -> 0x01f2 }
        r2 = r2.toString();	 Catch:{ SocketTimeoutException -> 0x0295, ConnectException -> 0x0225, UnknownHostException -> 0x022d, IOException -> 0x0144, IllegalStateException -> 0x017e, Exception -> 0x01b8, all -> 0x01f2 }
        com.shuame.rootgenius.sdk.C1473h.m4104c(r0, r2);	 Catch:{ SocketTimeoutException -> 0x0295, ConnectException -> 0x0225, UnknownHostException -> 0x022d, IOException -> 0x0144, IllegalStateException -> 0x017e, Exception -> 0x01b8, all -> 0x01f2 }
        r2 = new java.net.URL;	 Catch:{ SocketTimeoutException -> 0x0295, ConnectException -> 0x0225, UnknownHostException -> 0x022d, IOException -> 0x0144, IllegalStateException -> 0x017e, Exception -> 0x01b8, all -> 0x01f2 }
        r2.<init>(r1);	 Catch:{ SocketTimeoutException -> 0x0295, ConnectException -> 0x0225, UnknownHostException -> 0x022d, IOException -> 0x0144, IllegalStateException -> 0x017e, Exception -> 0x01b8, all -> 0x01f2 }
        r0 = r2.openConnection();	 Catch:{ SocketTimeoutException -> 0x0299, ConnectException -> 0x0289, UnknownHostException -> 0x02a2, IOException -> 0x0274, IllegalStateException -> 0x025f, Exception -> 0x024a, all -> 0x0239 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ SocketTimeoutException -> 0x0299, ConnectException -> 0x0289, UnknownHostException -> 0x02a2, IOException -> 0x0274, IllegalStateException -> 0x025f, Exception -> 0x024a, all -> 0x0239 }
        r4 = 1;
        r0.setDoOutput(r4);	 Catch:{ SocketTimeoutException -> 0x029c, ConnectException -> 0x028b, UnknownHostException -> 0x02a8, IOException -> 0x027b, IllegalStateException -> 0x0266, Exception -> 0x0251, all -> 0x023c }
        r4 = "POST";
        r0.setRequestMethod(r4);	 Catch:{ SocketTimeoutException -> 0x029c, ConnectException -> 0x028b, UnknownHostException -> 0x02a8, IOException -> 0x027b, IllegalStateException -> 0x0266, Exception -> 0x0251, all -> 0x023c }
        r4 = "Connection";
        r5 = "Close";
        r0.setRequestProperty(r4, r5);	 Catch:{ SocketTimeoutException -> 0x029c, ConnectException -> 0x028b, UnknownHostException -> 0x02a8, IOException -> 0x027b, IllegalStateException -> 0x0266, Exception -> 0x0251, all -> 0x023c }
        r4 = "Content-Type";
        r5 = "text/plain";
        r0.setRequestProperty(r4, r5);	 Catch:{ SocketTimeoutException -> 0x029c, ConnectException -> 0x028b, UnknownHostException -> 0x02a8, IOException -> 0x027b, IllegalStateException -> 0x0266, Exception -> 0x0251, all -> 0x023c }
        r4 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r0.setConnectTimeout(r4);	 Catch:{ SocketTimeoutException -> 0x029c, ConnectException -> 0x028b, UnknownHostException -> 0x02a8, IOException -> 0x027b, IllegalStateException -> 0x0266, Exception -> 0x0251, all -> 0x023c }
        r4 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r0.setReadTimeout(r4);	 Catch:{ SocketTimeoutException -> 0x029c, ConnectException -> 0x028b, UnknownHostException -> 0x02a8, IOException -> 0x027b, IllegalStateException -> 0x0266, Exception -> 0x0251, all -> 0x023c }
        if (r13 == 0) goto L_0x006b;
    L_0x004f:
        r4 = r13.length();	 Catch:{ SocketTimeoutException -> 0x029c, ConnectException -> 0x028b, UnknownHostException -> 0x02a8, IOException -> 0x027b, IllegalStateException -> 0x0266, Exception -> 0x0251, all -> 0x023c }
        if (r4 <= 0) goto L_0x006b;
    L_0x0055:
        r4 = r13.getBytes();	 Catch:{ SocketTimeoutException -> 0x029c, ConnectException -> 0x028b, UnknownHostException -> 0x02a8, IOException -> 0x027b, IllegalStateException -> 0x0266, Exception -> 0x0251, all -> 0x023c }
        r4 = DecodeBytes(r4);	 Catch:{ SocketTimeoutException -> 0x029c, ConnectException -> 0x028b, UnknownHostException -> 0x02a8, IOException -> 0x027b, IllegalStateException -> 0x0266, Exception -> 0x0251, all -> 0x023c }
        r4 = com.shuame.rootgenius.sdk.JniHelper.encrypt(r4);	 Catch:{ SocketTimeoutException -> 0x029c, ConnectException -> 0x028b, UnknownHostException -> 0x02a8, IOException -> 0x027b, IllegalStateException -> 0x0266, Exception -> 0x0251, all -> 0x023c }
        r5 = r0.getOutputStream();	 Catch:{ SocketTimeoutException -> 0x029c, ConnectException -> 0x028b, UnknownHostException -> 0x02a8, IOException -> 0x027b, IllegalStateException -> 0x0266, Exception -> 0x0251, all -> 0x023c }
        r5.write(r4);	 Catch:{ SocketTimeoutException -> 0x029c, ConnectException -> 0x028b, UnknownHostException -> 0x02a8, IOException -> 0x027b, IllegalStateException -> 0x0266, Exception -> 0x0251, all -> 0x023c }
        r5.close();	 Catch:{ SocketTimeoutException -> 0x029c, ConnectException -> 0x028b, UnknownHostException -> 0x02a8, IOException -> 0x027b, IllegalStateException -> 0x0266, Exception -> 0x0251, all -> 0x023c }
    L_0x006b:
        r4 = r0.getResponseCode();	 Catch:{ SocketTimeoutException -> 0x029c, ConnectException -> 0x028b, UnknownHostException -> 0x02a8, IOException -> 0x027b, IllegalStateException -> 0x0266, Exception -> 0x0251, all -> 0x023c }
        r5 = isSuccess(r4);	 Catch:{ SocketTimeoutException -> 0x008f, ConnectException -> 0x0290, UnknownHostException -> 0x02af, IOException -> 0x0283, IllegalStateException -> 0x026e, Exception -> 0x0259, all -> 0x0241 }
        if (r5 == 0) goto L_0x0111;
    L_0x0075:
        r5 = new java.io.ByteArrayOutputStream;	 Catch:{ SocketTimeoutException -> 0x008f, ConnectException -> 0x0290, UnknownHostException -> 0x02af, IOException -> 0x0283, IllegalStateException -> 0x026e, Exception -> 0x0259, all -> 0x0241 }
        r6 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r5.<init>(r6);	 Catch:{ SocketTimeoutException -> 0x008f, ConnectException -> 0x0290, UnknownHostException -> 0x02af, IOException -> 0x0283, IllegalStateException -> 0x026e, Exception -> 0x0259, all -> 0x0241 }
        r6 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r6 = new byte[r6];	 Catch:{ SocketTimeoutException -> 0x008f, ConnectException -> 0x0290, UnknownHostException -> 0x02af, IOException -> 0x0283, IllegalStateException -> 0x026e, Exception -> 0x0259, all -> 0x0241 }
        r8 = r0.getInputStream();	 Catch:{ SocketTimeoutException -> 0x008f, ConnectException -> 0x0290, UnknownHostException -> 0x02af, IOException -> 0x0283, IllegalStateException -> 0x026e, Exception -> 0x0259, all -> 0x0241 }
    L_0x0084:
        r9 = r8.read(r6);	 Catch:{ SocketTimeoutException -> 0x008f, ConnectException -> 0x0290, UnknownHostException -> 0x02af, IOException -> 0x0283, IllegalStateException -> 0x026e, Exception -> 0x0259, all -> 0x0241 }
        if (r9 <= 0) goto L_0x00f7;
    L_0x008a:
        r10 = 0;
        r5.write(r6, r10, r9);	 Catch:{ SocketTimeoutException -> 0x008f, ConnectException -> 0x0290, UnknownHostException -> 0x02af, IOException -> 0x0283, IllegalStateException -> 0x026e, Exception -> 0x0259, all -> 0x0241 }
        goto L_0x0084;
    L_0x008f:
        r5 = move-exception;
        r6 = r4;
        r4 = r0;
        r0 = r5;
    L_0x0093:
        r5 = r0;
        r0 = r1;
        r1 = r4;
        r4 = r6;
    L_0x0097:
        r6 = TAG;	 Catch:{ all -> 0x0247 }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0247 }
        r9 = "post url ";
        r8.<init>(r9);	 Catch:{ all -> 0x0247 }
        r8 = r8.append(r0);	 Catch:{ all -> 0x0247 }
        r9 = " fail by time out";
        r8 = r8.append(r9);	 Catch:{ all -> 0x0247 }
        r5 = r5.getMessage();	 Catch:{ all -> 0x0247 }
        r5 = r8.append(r5);	 Catch:{ all -> 0x0247 }
        r5 = r5.toString();	 Catch:{ all -> 0x0247 }
        com.shuame.rootgenius.sdk.C1473h.m4106e(r6, r5);	 Catch:{ all -> 0x0247 }
        if (r1 == 0) goto L_0x00be;
    L_0x00bb:
        r1.disconnect();
    L_0x00be:
        r5 = TAG;
        r6 = new java.lang.StringBuilder;
        r8 = "[PostReq]url:";
        r6.<init>(r8);
        r8 = r2.getHost();
        r6 = r6.append(r8);
        r8 = r2.getFile();
        r6 = r6.append(r8);
        r8 = ",response:";
        r6 = r6.append(r8);
        r6 = r6.append(r4);
        r6 = r6.toString();
        com.shuame.rootgenius.sdk.C1473h.m4104c(r5, r6);
    L_0x00e8:
        r5 = r7 + 1;
        r6 = isSuccess(r4);
        if (r6 != 0) goto L_0x00f3;
    L_0x00f0:
        r6 = 3;
        if (r5 < r6) goto L_0x02b7;
    L_0x00f3:
        r12.OnResponse(r4, r3);
        return r4;
    L_0x00f7:
        r8.close();	 Catch:{ SocketTimeoutException -> 0x008f, ConnectException -> 0x0290, UnknownHostException -> 0x02af, IOException -> 0x0283, IllegalStateException -> 0x026e, Exception -> 0x0259, all -> 0x0241 }
        r6 = r5.toByteArray();	 Catch:{ SocketTimeoutException -> 0x008f, ConnectException -> 0x0290, UnknownHostException -> 0x02af, IOException -> 0x0283, IllegalStateException -> 0x026e, Exception -> 0x0259, all -> 0x0241 }
        if (r6 == 0) goto L_0x0111;
    L_0x0100:
        r5 = r6.length;	 Catch:{ SocketTimeoutException -> 0x008f, ConnectException -> 0x0290, UnknownHostException -> 0x02af, IOException -> 0x0283, IllegalStateException -> 0x026e, Exception -> 0x0259, all -> 0x0241 }
        if (r5 <= 0) goto L_0x0111;
    L_0x0103:
        r5 = new java.lang.String;	 Catch:{ SocketTimeoutException -> 0x008f, ConnectException -> 0x0290, UnknownHostException -> 0x02af, IOException -> 0x0283, IllegalStateException -> 0x026e, Exception -> 0x0259, all -> 0x0241 }
        r6 = com.shuame.rootgenius.sdk.JniHelper.decrypt(r6);	 Catch:{ SocketTimeoutException -> 0x008f, ConnectException -> 0x0290, UnknownHostException -> 0x02af, IOException -> 0x0283, IllegalStateException -> 0x026e, Exception -> 0x0259, all -> 0x0241 }
        r6 = DecodeBytes(r6);	 Catch:{ SocketTimeoutException -> 0x008f, ConnectException -> 0x0290, UnknownHostException -> 0x02af, IOException -> 0x0283, IllegalStateException -> 0x026e, Exception -> 0x0259, all -> 0x0241 }
        r5.<init>(r6);	 Catch:{ SocketTimeoutException -> 0x008f, ConnectException -> 0x0290, UnknownHostException -> 0x02af, IOException -> 0x0283, IllegalStateException -> 0x026e, Exception -> 0x0259, all -> 0x0241 }
        r3 = r5;
    L_0x0111:
        if (r0 == 0) goto L_0x0116;
    L_0x0113:
        r0.disconnect();
    L_0x0116:
        r5 = TAG;
        r6 = new java.lang.StringBuilder;
        r8 = "[PostReq]url:";
        r6.<init>(r8);
        r8 = r2.getHost();
        r6 = r6.append(r8);
        r8 = r2.getFile();
        r6 = r6.append(r8);
        r8 = ",response:";
        r6 = r6.append(r8);
        r6 = r6.append(r4);
        r6 = r6.toString();
        com.shuame.rootgenius.sdk.C1473h.m4104c(r5, r6);
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x00e8;
    L_0x0144:
        r0 = move-exception;
        r2 = r5;
        r5 = r0;
        r0 = r1;
        r1 = r4;
        r4 = r6;
    L_0x014a:
        r5.printStackTrace();	 Catch:{ all -> 0x0247 }
        if (r1 == 0) goto L_0x0152;
    L_0x014f:
        r1.disconnect();
    L_0x0152:
        r5 = TAG;
        r6 = new java.lang.StringBuilder;
        r8 = "[PostReq]url:";
        r6.<init>(r8);
        r8 = r2.getHost();
        r6 = r6.append(r8);
        r8 = r2.getFile();
        r6 = r6.append(r8);
        r8 = ",response:";
        r6 = r6.append(r8);
        r6 = r6.append(r4);
        r6 = r6.toString();
        com.shuame.rootgenius.sdk.C1473h.m4104c(r5, r6);
        goto L_0x00e8;
    L_0x017e:
        r0 = move-exception;
        r2 = r5;
        r5 = r0;
        r0 = r1;
        r1 = r4;
        r4 = r6;
    L_0x0184:
        r5.printStackTrace();	 Catch:{ all -> 0x0247 }
        if (r1 == 0) goto L_0x018c;
    L_0x0189:
        r1.disconnect();
    L_0x018c:
        r5 = TAG;
        r6 = new java.lang.StringBuilder;
        r8 = "[PostReq]url:";
        r6.<init>(r8);
        r8 = r2.getHost();
        r6 = r6.append(r8);
        r8 = r2.getFile();
        r6 = r6.append(r8);
        r8 = ",response:";
        r6 = r6.append(r8);
        r6 = r6.append(r4);
        r6 = r6.toString();
        com.shuame.rootgenius.sdk.C1473h.m4104c(r5, r6);
        goto L_0x00e8;
    L_0x01b8:
        r0 = move-exception;
        r2 = r5;
        r5 = r0;
        r0 = r1;
        r1 = r4;
        r4 = r6;
    L_0x01be:
        r5.printStackTrace();	 Catch:{ all -> 0x0247 }
        if (r1 == 0) goto L_0x01c6;
    L_0x01c3:
        r1.disconnect();
    L_0x01c6:
        r5 = TAG;
        r6 = new java.lang.StringBuilder;
        r8 = "[PostReq]url:";
        r6.<init>(r8);
        r8 = r2.getHost();
        r6 = r6.append(r8);
        r8 = r2.getFile();
        r6 = r6.append(r8);
        r8 = ",response:";
        r6 = r6.append(r8);
        r6 = r6.append(r4);
        r6 = r6.toString();
        com.shuame.rootgenius.sdk.C1473h.m4104c(r5, r6);
        goto L_0x00e8;
    L_0x01f2:
        r0 = move-exception;
        r1 = r4;
        r2 = r5;
    L_0x01f5:
        if (r1 == 0) goto L_0x01fa;
    L_0x01f7:
        r1.disconnect();
    L_0x01fa:
        r1 = TAG;
        r3 = new java.lang.StringBuilder;
        r4 = "[PostReq]url:";
        r3.<init>(r4);
        r4 = r2.getHost();
        r3 = r3.append(r4);
        r2 = r2.getFile();
        r2 = r3.append(r2);
        r3 = ",response:";
        r2 = r2.append(r3);
        r2 = r2.append(r6);
        r2 = r2.toString();
        com.shuame.rootgenius.sdk.C1473h.m4104c(r1, r2);
        throw r0;
    L_0x0225:
        r0 = move-exception;
        r2 = r5;
    L_0x0227:
        r5 = r0;
        r0 = r1;
        r1 = r4;
        r4 = r6;
        goto L_0x0097;
    L_0x022d:
        r0 = move-exception;
        r2 = r4;
        r4 = r5;
        r5 = r6;
    L_0x0231:
        r11 = r0;
        r0 = r1;
        r1 = r2;
        r2 = r4;
        r4 = r5;
        r5 = r11;
        goto L_0x0097;
    L_0x0239:
        r0 = move-exception;
        r1 = r4;
        goto L_0x01f5;
    L_0x023c:
        r1 = move-exception;
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x01f5;
    L_0x0241:
        r1 = move-exception;
        r6 = r4;
        r11 = r0;
        r0 = r1;
        r1 = r11;
        goto L_0x01f5;
    L_0x0247:
        r0 = move-exception;
        r6 = r4;
        goto L_0x01f5;
    L_0x024a:
        r0 = move-exception;
        r5 = r0;
        r0 = r1;
        r1 = r4;
        r4 = r6;
        goto L_0x01be;
    L_0x0251:
        r4 = move-exception;
        r5 = r4;
        r4 = r6;
        r11 = r0;
        r0 = r1;
        r1 = r11;
        goto L_0x01be;
    L_0x0259:
        r5 = move-exception;
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x01be;
    L_0x025f:
        r0 = move-exception;
        r5 = r0;
        r0 = r1;
        r1 = r4;
        r4 = r6;
        goto L_0x0184;
    L_0x0266:
        r4 = move-exception;
        r5 = r4;
        r4 = r6;
        r11 = r0;
        r0 = r1;
        r1 = r11;
        goto L_0x0184;
    L_0x026e:
        r5 = move-exception;
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x0184;
    L_0x0274:
        r0 = move-exception;
        r5 = r0;
        r0 = r1;
        r1 = r4;
        r4 = r6;
        goto L_0x014a;
    L_0x027b:
        r4 = move-exception;
        r5 = r4;
        r4 = r6;
        r11 = r0;
        r0 = r1;
        r1 = r11;
        goto L_0x014a;
    L_0x0283:
        r5 = move-exception;
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x014a;
    L_0x0289:
        r0 = move-exception;
        goto L_0x0227;
    L_0x028b:
        r4 = move-exception;
        r11 = r4;
        r4 = r0;
        r0 = r11;
        goto L_0x0227;
    L_0x0290:
        r5 = move-exception;
        r6 = r4;
        r4 = r0;
        r0 = r5;
        goto L_0x0227;
    L_0x0295:
        r0 = move-exception;
        r2 = r5;
        goto L_0x0093;
    L_0x0299:
        r0 = move-exception;
        goto L_0x0093;
    L_0x029c:
        r4 = move-exception;
        r11 = r4;
        r4 = r0;
        r0 = r11;
        goto L_0x0093;
    L_0x02a2:
        r0 = move-exception;
        r5 = r6;
        r11 = r2;
        r2 = r4;
        r4 = r11;
        goto L_0x0231;
    L_0x02a8:
        r4 = move-exception;
        r5 = r6;
        r11 = r0;
        r0 = r4;
        r4 = r2;
        r2 = r11;
        goto L_0x0231;
    L_0x02af:
        r5 = move-exception;
        r11 = r5;
        r5 = r4;
        r4 = r2;
        r2 = r0;
        r0 = r11;
        goto L_0x0231;
    L_0x02b7:
        r7 = r5;
        r6 = r4;
        r4 = r1;
        r5 = r2;
        r1 = r0;
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.sdk.proto.ProtoBase.postReq(java.lang.String):int");
    }
}
