package com.shuame.mobile.sdk.impl.utils;

import com.shuame.mobile.sdk.impl.utils.C1224c.C1222b;
import com.shuame.mobile.sdk.impl.utils.C1224c.C1223c;
import com.shuame.mobile.utils.ShuameEncrypt;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RomScanner {
    /* renamed from: a */
    private static final String f3215a = RomScanner.class.getSimpleName();
    /* renamed from: b */
    private static final byte[] f3216b = new byte[]{(byte) 64, (byte) -11, (byte) -67, (byte) 48, (byte) -24, (byte) -36, (byte) 5, (byte) -52, (byte) 14, (byte) -101, (byte) -108, (byte) 78, (byte) 30, (byte) 121, (byte) 30, (byte) 116};
    /* renamed from: c */
    private static ScanResult f3217c = ScanResult.ERROR_UNKNOWN;
    /* renamed from: d */
    private static boolean f3218d;
    /* renamed from: e */
    private static Map<String, Boolean> f3219e = new ConcurrentHashMap();
    /* renamed from: f */
    private static int f3220f;
    /* renamed from: g */
    private static byte[] f3221g = new byte[512];

    public interface ScanListener {
        void onProgress(int i);
    }

    public enum ScanResult {
        SAFE_TYPE,
        VIRUS_TYPE,
        MIDRISK_TYPE,
        LOWRISK_TYPE,
        UNKNOWN_TYPE,
        CANCEL,
        ERROR_UNKNOWN,
        ERROR_JSON,
        ERROR_SERVER
    }

    /* renamed from: a */
    private static String m3442a() {
        return new String(ShuameEncrypt.encryptBytes(C1219a.m3445a(), 0, 1, f3216b));
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x008c A:{SYNTHETIC, Splitter: B:48:0x008c} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0074 A:{SYNTHETIC, Splitter: B:34:0x0074} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0082 A:{SYNTHETIC, Splitter: B:42:0x0082} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0094 A:{ExcHandler: all (th java.lang.Throwable), Splitter: B:26:0x0067} */
    /* JADX WARNING: Missing block: B:53:0x0094, code:
            r0 = th;
     */
    /* renamed from: a */
    private static java.lang.String m3443a(java.io.InputStream r6) {
        /*
        r3 = "";
        r2 = 0;
        r1 = new java.util.zip.ZipInputStream;	 Catch:{ ZipException -> 0x00a4, IOException -> 0x007a, all -> 0x0088 }
        r1.<init>(r6);	 Catch:{ ZipException -> 0x00a4, IOException -> 0x007a, all -> 0x0088 }
    L_0x0008:
        r0 = f3218d;	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        if (r0 != 0) goto L_0x00ae;
    L_0x000c:
        r0 = r1.getNextEntry();	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        if (r0 != 0) goto L_0x0017;
    L_0x0012:
        r0 = r3;
    L_0x0013:
        r1.close();	 Catch:{ IOException -> 0x0092 }
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = r0.getName();	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        r0 = r0.toUpperCase();	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        r2 = "META-INF";
        r2 = r0.startsWith(r2);	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        if (r2 == 0) goto L_0x0067;
    L_0x0027:
        r2 = ".SF";
        r0 = r0.endsWith(r2);	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        if (r0 == 0) goto L_0x0067;
    L_0x002f:
        r0 = f3221g;	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        r0 = r1.read(r0);	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        r2 = -1;
        if (r0 == r2) goto L_0x00b1;
    L_0x0038:
        r0 = new java.lang.String;	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        r2 = f3221g;	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        r0.<init>(r2);	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        r2 = "SHA1-Digest-Manifest";
        r2 = r0.contains(r2);	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        if (r2 == 0) goto L_0x00b1;
    L_0x0047:
        r2 = "SHA1-Digest-Manifest:";
        r4 = 0;
        r4 = r0.indexOf(r2, r4);	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        r2 = r2.length();	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        r2 = r2 + r4;
        r4 = "\n";
        r4 = r0.indexOf(r4, r2);	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        r0 = r0.substring(r2, r4);	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        r3 = r0.trim();	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        r2 = r3;
    L_0x0062:
        r1.closeEntry();	 Catch:{ ZipException -> 0x00a8, IOException -> 0x009e, all -> 0x0094 }
        r0 = r2;
        goto L_0x0013;
    L_0x0067:
        r1.closeEntry();	 Catch:{ ZipException -> 0x006b, IOException -> 0x0099, all -> 0x0094 }
        goto L_0x0008;
    L_0x006b:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r3;
    L_0x006f:
        r1.printStackTrace();	 Catch:{ all -> 0x0096 }
        if (r2 == 0) goto L_0x0016;
    L_0x0074:
        r2.close();	 Catch:{ IOException -> 0x0078 }
        goto L_0x0016;
    L_0x0078:
        r1 = move-exception;
        goto L_0x0016;
    L_0x007a:
        r0 = move-exception;
        r1 = r0;
        r0 = r3;
    L_0x007d:
        r1.printStackTrace();	 Catch:{ all -> 0x0096 }
        if (r2 == 0) goto L_0x0016;
    L_0x0082:
        r2.close();	 Catch:{ IOException -> 0x0086 }
        goto L_0x0016;
    L_0x0086:
        r1 = move-exception;
        goto L_0x0016;
    L_0x0088:
        r0 = move-exception;
        r1 = r2;
    L_0x008a:
        if (r1 == 0) goto L_0x008f;
    L_0x008c:
        r1.close();	 Catch:{ IOException -> 0x0090 }
    L_0x008f:
        throw r0;
    L_0x0090:
        r1 = move-exception;
        goto L_0x008f;
    L_0x0092:
        r1 = move-exception;
        goto L_0x0016;
    L_0x0094:
        r0 = move-exception;
        goto L_0x008a;
    L_0x0096:
        r0 = move-exception;
        r1 = r2;
        goto L_0x008a;
    L_0x0099:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x007d;
    L_0x009e:
        r0 = move-exception;
        r5 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r5;
        goto L_0x007d;
    L_0x00a4:
        r0 = move-exception;
        r1 = r0;
        r0 = r3;
        goto L_0x006f;
    L_0x00a8:
        r0 = move-exception;
        r5 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r5;
        goto L_0x006f;
    L_0x00ae:
        r0 = r3;
        goto L_0x0013;
    L_0x00b1:
        r2 = r3;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.mobile.sdk.impl.utils.RomScanner.a(java.io.InputStream):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x007e A:{SYNTHETIC, Splitter: B:34:0x007e} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008b A:{SYNTHETIC, Splitter: B:42:0x008b} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0095 A:{SYNTHETIC, Splitter: B:48:0x0095} */
    /* renamed from: a */
    private static java.util.List<java.lang.String> m3444a(java.lang.String r9, com.shuame.mobile.sdk.impl.utils.RomScanner.ScanListener r10) {
        /*
        r0 = 0;
        f3220f = r0;
        r4 = new java.util.ArrayList;
        r4.<init>();
        r2 = 0;
        r1 = new java.util.zip.ZipFile;	 Catch:{ ZipException -> 0x0077, IOException -> 0x0084, all -> 0x0091 }
        r1.<init>(r9);	 Catch:{ ZipException -> 0x0077, IOException -> 0x0084, all -> 0x0091 }
        r5 = r1.entries();	 Catch:{ ZipException -> 0x00a1, IOException -> 0x009f }
        r6 = r1.size();	 Catch:{ ZipException -> 0x00a1, IOException -> 0x009f }
        r2 = r0;
        r3 = r0;
    L_0x0018:
        r0 = f3218d;	 Catch:{ ZipException -> 0x00a1, IOException -> 0x009f }
        if (r0 != 0) goto L_0x0022;
    L_0x001c:
        r0 = r5.hasMoreElements();	 Catch:{ ZipException -> 0x00a1, IOException -> 0x009f }
        if (r0 != 0) goto L_0x003c;
    L_0x0022:
        r1.close();	 Catch:{ IOException -> 0x009b }
    L_0x0025:
        r0 = f3215a;
        r1 = new java.lang.StringBuilder;
        r2 = "mTotalSleepCount:";
        r1.<init>(r2);
        r2 = f3220f;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);
        return r4;
    L_0x003c:
        r0 = r5.nextElement();	 Catch:{ ZipException -> 0x00a1, IOException -> 0x009f }
        r0 = (java.util.zip.ZipEntry) r0;	 Catch:{ ZipException -> 0x00a1, IOException -> 0x009f }
        r7 = r0.getName();	 Catch:{ ZipException -> 0x00a1, IOException -> 0x009f }
        r7 = r7.toLowerCase();	 Catch:{ ZipException -> 0x00a1, IOException -> 0x009f }
        r8 = ".apk";
        r7 = r7.endsWith(r8);	 Catch:{ ZipException -> 0x00a1, IOException -> 0x009f }
        if (r7 == 0) goto L_0x0065;
    L_0x0052:
        r0 = r1.getInputStream(r0);	 Catch:{ ZipException -> 0x00a1, IOException -> 0x009f }
        r0 = m3443a(r0);	 Catch:{ ZipException -> 0x00a1, IOException -> 0x009f }
        if (r0 == 0) goto L_0x0065;
    L_0x005c:
        r7 = android.text.TextUtils.isEmpty(r0);	 Catch:{ ZipException -> 0x00a1, IOException -> 0x009f }
        if (r7 != 0) goto L_0x0065;
    L_0x0062:
        r4.add(r0);	 Catch:{ ZipException -> 0x00a1, IOException -> 0x009f }
    L_0x0065:
        r3 = r3 + 1;
        if (r10 == 0) goto L_0x0018;
    L_0x0069:
        r0 = r3 * 90;
        r0 = r0 / r6;
        if (r0 > r2) goto L_0x0072;
    L_0x006e:
        r7 = 90;
        if (r0 != r7) goto L_0x0018;
    L_0x0072:
        r10.onProgress(r0);	 Catch:{ ZipException -> 0x00a1, IOException -> 0x009f }
        r2 = r0;
        goto L_0x0018;
    L_0x0077:
        r0 = move-exception;
        r1 = r2;
    L_0x0079:
        r0.printStackTrace();	 Catch:{ all -> 0x009d }
        if (r1 == 0) goto L_0x0025;
    L_0x007e:
        r1.close();	 Catch:{ IOException -> 0x0082 }
        goto L_0x0025;
    L_0x0082:
        r0 = move-exception;
        goto L_0x0025;
    L_0x0084:
        r0 = move-exception;
        r1 = r2;
    L_0x0086:
        r0.printStackTrace();	 Catch:{ all -> 0x009d }
        if (r1 == 0) goto L_0x0025;
    L_0x008b:
        r1.close();	 Catch:{ IOException -> 0x008f }
        goto L_0x0025;
    L_0x008f:
        r0 = move-exception;
        goto L_0x0025;
    L_0x0091:
        r0 = move-exception;
        r1 = r2;
    L_0x0093:
        if (r1 == 0) goto L_0x0098;
    L_0x0095:
        r1.close();	 Catch:{ IOException -> 0x0099 }
    L_0x0098:
        throw r0;
    L_0x0099:
        r1 = move-exception;
        goto L_0x0098;
    L_0x009b:
        r0 = move-exception;
        goto L_0x0025;
    L_0x009d:
        r0 = move-exception;
        goto L_0x0093;
    L_0x009f:
        r0 = move-exception;
        goto L_0x0086;
    L_0x00a1:
        r0 = move-exception;
        goto L_0x0079;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.mobile.sdk.impl.utils.RomScanner.a(java.lang.String, com.shuame.mobile.sdk.impl.utils.RomScanner$ScanListener):java.util.List<java.lang.String>");
    }

    public static void addVirusRom(String str) {
        C1228g.m3458a(f3215a, "addVirusRom uuid:" + str);
        f3219e.put(str, Boolean.valueOf(true));
    }

    public static void cancel() {
        C1228g.m3458a(f3215a, "cancel");
        f3218d = true;
    }

    public static void clearVirusRoms() {
        f3219e.clear();
    }

    public static ScanResult getScanResult() {
        return f3217c;
    }

    public static boolean isVirusRom(String str) {
        boolean containsKey = f3219e.containsKey(str);
        C1228g.m3458a(f3215a, "isVirusRom uuid:" + str + ";isVirus:" + containsKey);
        return containsKey;
    }

    public static void removeVirusRom(String str) {
        C1228g.m3458a(f3215a, "removeVirusRom uuid:" + str);
        f3219e.remove(str);
    }

    public static ScanResult scan(String str, ScanListener scanListener) {
        boolean z = false;
        f3218d = false;
        f3217c = ScanResult.ERROR_UNKNOWN;
        try {
            C1228g.m3458a(f3215a, "getApkSha1DigestList start");
            Collection a = m3444a(str, scanListener);
            if (f3218d) {
                C1228g.m3458a(f3215a, "cancel after getApkSha1DigestList");
                return ScanResult.CANCEL;
            }
            C1228g.m3458a(f3215a, "sha1List.size:" + a.size());
            C1228g.m3458a(f3215a, "getApkSha1DigestList end");
            JSONArray jSONArray = new JSONArray(a);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("authkey", m3442a());
            jSONObject.put("hashlist", jSONArray);
            Map hashMap = new HashMap();
            C1222b c1222b = new C1222b();
            c1222b.f3227a = "https://api.scan.qq.com/rom/scan";
            c1222b.f3228b = jSONObject.toString();
            c1222b.f3229c = hashMap;
            hashMap.put("Content-Type", "application/json");
            while (true) {
                int i = z;
                C1223c a2 = C1224c.m3449a(c1222b);
                C1228g.m3458a(f3215a, "statusCode:" + a2.f3230a + ";content:" + a2.f3231b);
                if (a2.f3230a == 200) {
                    try {
                        String string = new JSONObject(a2.f3231b).getString("safetype");
                        if (string.equalsIgnoreCase("safe")) {
                            f3217c = ScanResult.SAFE_TYPE;
                        } else if (string.equalsIgnoreCase("virus")) {
                            f3217c = ScanResult.VIRUS_TYPE;
                        } else if (string.equalsIgnoreCase("lowrisk")) {
                            f3217c = ScanResult.LOWRISK_TYPE;
                        } else if (string.equalsIgnoreCase("midrisk")) {
                            f3217c = ScanResult.MIDRISK_TYPE;
                        } else {
                            f3217c = ScanResult.UNKNOWN_TYPE;
                        }
                        i = 3;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        f3217c = ScanResult.ERROR_JSON;
                    }
                } else {
                    f3217c = ScanResult.ERROR_SERVER;
                }
                if (f3218d) {
                    C1228g.m3458a(f3215a, "cancel after post");
                    return ScanResult.CANCEL;
                }
                z = i + 1;
                if (z >= true) {
                    if (a2 != null && a2.f3230a == 504) {
                        f3217c = ScanResult.SAFE_TYPE;
                    }
                    if (scanListener != null) {
                        scanListener.onProgress(100);
                    }
                    C1228g.m3458a(f3215a, "end post");
                }
            }
            return f3217c;
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
