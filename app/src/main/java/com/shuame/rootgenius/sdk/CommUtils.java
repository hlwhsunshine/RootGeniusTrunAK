package com.shuame.rootgenius.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.p013pm.PackageInfo;
import android.content.p013pm.PackageManager.NameNotFoundException;
import android.content.p013pm.Signature;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;

import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.shuame.rootgenius.sdk.proto.ProtoData.AdbInfo;
import com.shuame.rootgenius.sdk.proto.ProtoData.RootingDev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import p000a.p001a.p002a.p003a.C0001b;
import p000a.p001a.p002a.p007c.C0010a;

public class CommUtils {
    private static final String CHECK_CMD_END_TEXT = "rg_cmd_end_magic";
    private static final String CHECK_CMD_START_TEXT = "rg_cmd_start_magic";
    private static final String TAG = CommUtils.class.getSimpleName();
    protected static final char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static Map StringSplitToHash(String str, char c, char c2) {
        int i = 0;
        Map hashMap = new HashMap();
        String str2 = "";
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == c) {
                str2 = str.substring(i, i2).trim();
                i = i2 + 1;
            } else if (str.charAt(i2) == c2) {
                hashMap.put(str2, str.substring(i, i2).trim());
                str2 = "";
                i = i2 + 1;
            }
        }
        if (!str2.isEmpty()) {
            hashMap.put(str2, str.substring(i).trim());
        }
        return hashMap;
    }

    public static boolean aysnDownload(String str, String str2, ExecutorService executorService, Runnable runnable) {
        Executors.newSingleThreadExecutor();
        return true;
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length << 1)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i << 1] = hexArray[i2 >>> 4];
            cArr[(i << 1) + 1] = hexArray[i2 & 15];
        }
        return new String(cArr);
    }

    public static String calcFileMd5(InputStream inputStream) {
        String str = "";
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return bytesToHex(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return str;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return str;
        } catch (IOException e3) {
            e3.printStackTrace();
            return str;
        }
    }

    public static String calcFileMd5(String str) {
        String str2 = "";
        try {
            if (!new File(str).exists()) {
                return str2;
            }
            InputStream fileInputStream = new FileInputStream(str);
            str2 = calcFileMd5(fileInputStream);
            fileInputStream.close();
            return str2;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return str2;
        } catch (IOException e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    public static String calcMd5(byte[] bArr) {
        String str = "";
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr, 0, bArr.length);
            return bytesToHex(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static boolean checkActiveNetworkConnected(Context context, int i) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        while (true) {
            if (activeNetworkInfo != null) {
                try {
                    if (activeNetworkInfo.isConnected()) {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (NullPointerException e2) {
                    e2.printStackTrace();
                }
            }
            if (i <= 0) {
                break;
            }
            Thread.sleep(1000);
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i -= 1000;
        }
        C1473h.m4102a(TAG, "checkActiveNetworkConnected:" + activeNetworkInfo.isConnected());
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private static boolean checkFileMd5(InputStream inputStream, String str) {
        return (str == null || str.isEmpty() || !calcFileMd5(inputStream).equalsIgnoreCase(str)) ? false : true;
    }

    public static boolean checkFileMd5(String str, String str2) {
        boolean checkFileMd5;
        FileNotFoundException e;
        IOException e2;
        try {
            InputStream fileInputStream = new FileInputStream(str);
            checkFileMd5 = checkFileMd5(fileInputStream, str2);
            try {
                fileInputStream.close();
            } catch (FileNotFoundException e3) {
                e = e3;
                e.printStackTrace();
                return checkFileMd5;
            } catch (IOException e4) {
                e2 = e4;
                e2.printStackTrace();
                return checkFileMd5;
            }
        } catch (FileNotFoundException e5) {
            FileNotFoundException fileNotFoundException = e5;
            checkFileMd5 = false;
            e = fileNotFoundException;
        } catch (IOException e6) {
            IOException iOException = e6;
            checkFileMd5 = false;
            e2 = iOException;
            e2.printStackTrace();
            return checkFileMd5;
        }
        return checkFileMd5;
    }

    private static String checkRid(Context context, String str) {
        String group;
        int i = 0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("/sdcard/.rid");
        arrayList.add(context.getFilesDir().getAbsolutePath() + "/.rid");
        Pattern compile = Pattern.compile("rid:(\\d+)");
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Matcher matcher = compile.matcher(readFrom((String) arrayList.get(i2)));
            if (matcher.find()) {
                group = matcher.group(1);
                break;
            }
        }
        group = null;
        if (group == null || group.isEmpty()) {
            CRC32 crc32 = new CRC32();
            if (str == null || str.isEmpty()) {
                str = String.valueOf(System.currentTimeMillis());
            }
            crc32.update(str.getBytes());
            group = String.format("%d", new Object[]{Long.valueOf(crc32.getValue())});
        }
        if (group == null || group.isEmpty()) {
            return "0";
        }
        while (i < arrayList.size()) {
            writeTo("rid:" + group, new File((String) arrayList.get(i)).getAbsolutePath());
            i++;
        }
        return group;
    }

    public static void delete(File file) {
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                return;
            }
            for (File delete : listFiles) {
                delete(delete);
            }
            file.delete();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006b A:{ExcHandler: all (r1_8 'th' java.lang.Throwable), Splitter: B:7:0x0018} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:24:0x0052, code:
            r2.disconnect();
     */
    /* JADX WARNING: Missing block: B:32:0x0067, code:
            r2.disconnect();
     */
    /* JADX WARNING: Missing block: B:34:0x006b, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:35:0x006c, code:
            r2 = r0;
            r0 = r1;
     */
    /* JADX WARNING: Missing block: B:38:0x0074, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:39:0x0075, code:
            r8 = r2;
            r2 = r0;
            r0 = -1;
            r1 = r8;
     */
    /* JADX WARNING: Missing block: B:43:?, code:
            return r0;
     */
    /* JADX WARNING: Missing block: B:44:?, code:
            return r0;
     */
    public static int download(java.lang.String r9, java.lang.String r10) {
        /*
        r3 = 0;
        r1 = -1;
        r0 = r9.isEmpty();
        if (r0 == 0) goto L_0x000a;
    L_0x0008:
        r0 = r1;
    L_0x0009:
        return r0;
    L_0x000a:
        r2 = 0;
        r0 = new java.net.URL;	 Catch:{ IOException -> 0x006f }
        r0.<init>(r9);	 Catch:{ IOException -> 0x006f }
        r0 = r0.openConnection();	 Catch:{ IOException -> 0x006f }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IOException -> 0x006f }
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setConnectTimeout(r2);	 Catch:{ IOException -> 0x0074, all -> 0x006b }
        r2 = "GET";
        r0.setRequestMethod(r2);	 Catch:{ IOException -> 0x0074, all -> 0x006b }
        r2 = r0.getResponseCode();	 Catch:{ IOException -> 0x0074, all -> 0x006b }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 == r1) goto L_0x002c;
    L_0x0028:
        r1 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r2 != r1) goto L_0x007c;
    L_0x002c:
        r1 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0049, all -> 0x006b }
        r1.<init>(r10);	 Catch:{ IOException -> 0x0049, all -> 0x006b }
        r4 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0049, all -> 0x006b }
        r5 = r0.getInputStream();	 Catch:{ IOException -> 0x0049, all -> 0x006b }
        r4.<init>(r5);	 Catch:{ IOException -> 0x0049, all -> 0x006b }
        r5 = 8092; // 0x1f9c float:1.134E-41 double:3.998E-320;
        r5 = new byte[r5];	 Catch:{ IOException -> 0x0049, all -> 0x006b }
    L_0x003e:
        r6 = r4.read(r5);	 Catch:{ IOException -> 0x0049, all -> 0x006b }
        if (r6 <= 0) goto L_0x0056;
    L_0x0044:
        r7 = 0;
        r1.write(r5, r7, r6);	 Catch:{ IOException -> 0x0049, all -> 0x006b }
        goto L_0x003e;
    L_0x0049:
        r1 = move-exception;
        r8 = r0;
        r0 = r2;
        r2 = r8;
    L_0x004d:
        r1.printStackTrace();	 Catch:{ all -> 0x0064 }
        if (r2 == 0) goto L_0x0009;
    L_0x0052:
        r2.disconnect();
        goto L_0x0009;
    L_0x0056:
        r4.close();	 Catch:{ IOException -> 0x0049, all -> 0x006b }
        r1.close();	 Catch:{ IOException -> 0x0049, all -> 0x006b }
        r1 = r3;
    L_0x005d:
        if (r0 == 0) goto L_0x007a;
    L_0x005f:
        r0.disconnect();
        r0 = r1;
        goto L_0x0009;
    L_0x0064:
        r0 = move-exception;
    L_0x0065:
        if (r2 == 0) goto L_0x006a;
    L_0x0067:
        r2.disconnect();
    L_0x006a:
        throw r0;
    L_0x006b:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x0065;
    L_0x006f:
        r0 = move-exception;
        r8 = r0;
        r0 = r1;
        r1 = r8;
        goto L_0x004d;
    L_0x0074:
        r2 = move-exception;
        r8 = r2;
        r2 = r0;
        r0 = r1;
        r1 = r8;
        goto L_0x004d;
    L_0x007a:
        r0 = r1;
        goto L_0x0009;
    L_0x007c:
        r1 = r2;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.sdk.CommUtils.download(java.lang.String, java.lang.String):int");
    }

    public static String exec(String str) {
        String readErrInStream;
        IOException e;
        InterruptedException e2;
        if (str == null || str.isEmpty()) {
            return "";
        }
        String str2 = "";
        try {
            Process exec = Runtime.getRuntime().exec(str);
            readErrInStream = readErrInStream(exec);
            try {
                exec.waitFor();
                return readErrInStream;
            } catch (IOException e3) {
                e = e3;
            } catch (InterruptedException e4) {
                e2 = e4;
                e2.printStackTrace();
                return readErrInStream;
            }
        } catch (IOException e5) {
            IOException iOException = e5;
            readErrInStream = str2;
            e = iOException;
        } catch (InterruptedException e6) {
            InterruptedException interruptedException = e6;
            readErrInStream = str2;
            e2 = interruptedException;
            e2.printStackTrace();
            return readErrInStream;
        }
        e.printStackTrace();
        return readErrInStream;
    }

    public static String exec(String[] strArr) {
        String readErrInStream;
        IOException e;
        InterruptedException e2;
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        String str = "";
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            readErrInStream = readErrInStream(exec);
            try {
                exec.waitFor();
                return readErrInStream;
            } catch (IOException e3) {
                e = e3;
            } catch (InterruptedException e4) {
                e2 = e4;
                e2.printStackTrace();
                return readErrInStream;
            }
        } catch (IOException e5) {
            IOException iOException = e5;
            readErrInStream = str;
            e = iOException;
        } catch (InterruptedException e6) {
            InterruptedException interruptedException = e6;
            readErrInStream = str;
            e2 = interruptedException;
            e2.printStackTrace();
            return readErrInStream;
        }
        e.printStackTrace();
        return readErrInStream;
    }

    public static String execCmd(String str) {
        return execCmd(false, str, 20000);
    }

    public static String execCmd(String str, int i) {
        return execCmd(false, str, (long) i);
    }

    public static String execCmd(boolean z, String str) {
        return execCmd(z, str, 60000);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0188 A:{LOOP_END, LOOP:0: B:1:0x000a->B:106:0x0188} */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x00e2 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x013d A:{SYNTHETIC, Splitter: B:65:0x013d} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0142 A:{SYNTHETIC, Splitter: B:68:0x0142} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0147 A:{SYNTHETIC, Splitter: B:71:0x0147} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x00e2 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0188 A:{LOOP_END, LOOP:0: B:1:0x000a->B:106:0x0188} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x013d A:{SYNTHETIC, Splitter: B:65:0x013d} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0142 A:{SYNTHETIC, Splitter: B:68:0x0142} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0147 A:{SYNTHETIC, Splitter: B:71:0x0147} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0188 A:{LOOP_END, LOOP:0: B:1:0x000a->B:106:0x0188} */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x00e2 A:{SYNTHETIC} */
    public static java.lang.String execCmd(boolean r18, java.lang.String r19, long r20) {
        /*
        r10 = new java.lang.StringBuffer;
        r10.<init>();
        r5 = 0;
        r4 = 0;
        r3 = 0;
        r2 = 0;
        r7 = r2;
    L_0x000a:
        r6 = new java.lang.ProcessBuilder;	 Catch:{ Exception -> 0x017f }
        r2 = 1;
        r8 = new java.lang.String[r2];	 Catch:{ Exception -> 0x017f }
        r9 = 0;
        if (r18 == 0) goto L_0x00e7;
    L_0x0012:
        r2 = "su";
    L_0x0014:
        r8[r9] = r2;	 Catch:{ Exception -> 0x017f }
        r6.<init>(r8);	 Catch:{ Exception -> 0x017f }
        r2 = 1;
        r6.redirectErrorStream(r2);	 Catch:{ Exception -> 0x017f }
        r6 = r6.start();	 Catch:{ Exception -> 0x017f }
        r5 = new java.io.DataOutputStream;	 Catch:{ Exception -> 0x0181, all -> 0x0178 }
        r2 = r6.getOutputStream();	 Catch:{ Exception -> 0x0181, all -> 0x0178 }
        r5.<init>(r2);	 Catch:{ Exception -> 0x0181, all -> 0x0178 }
        r4 = new java.io.DataInputStream;	 Catch:{ Exception -> 0x0184, all -> 0x017c }
        r2 = r6.getInputStream();	 Catch:{ Exception -> 0x0184, all -> 0x017c }
        r4.<init>(r2);	 Catch:{ Exception -> 0x0184, all -> 0x017c }
        r2 = 0;
        r10.setLength(r2);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r2 = TAG;	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r8 = "execCmd tryCount:";
        r3.<init>(r8);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r3 = r3.append(r7);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r8 = "; cmd:";
        r3 = r3.append(r8);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r0 = r19;
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r3 = r3.toString();	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        com.shuame.rootgenius.sdk.C1473h.m4102a(r2, r3);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r2 = "echo rg_cmd_start_magic\n";
        r5.writeBytes(r2);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r2.<init>();	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r0 = r19;
        r2 = r2.append(r0);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r3 = "\n";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r2 = r2.toString();	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r5.writeBytes(r2);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r5.flush();	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r2 = "echo rg_cmd_end_magic\n";
        r5.writeBytes(r2);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r5.flush();	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r8 = 0;
        r3 = 0;
        r2 = 0;
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r12 = r12 + r20;
        r16 = r2;
        r2 = r8;
        r8 = r3;
        r3 = r16;
    L_0x008e:
        r14 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r9 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1));
        if (r9 >= 0) goto L_0x00c7;
    L_0x0096:
        r9 = r4.available();	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        if (r9 <= 0) goto L_0x00c5;
    L_0x009c:
        r9 = r4.readLine();	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        if (r9 == 0) goto L_0x00c5;
    L_0x00a2:
        r11 = TAG;	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r15 = "execCmd stdout:";
        r14.<init>(r15);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r14 = r14.append(r9);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r14 = r14.toString();	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        com.shuame.rootgenius.sdk.C1473h.m4102a(r11, r14);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        if (r3 != 0) goto L_0x00eb;
    L_0x00b8:
        r11 = r9.toLowerCase();	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r14 = "permission denied";
        r11 = r11.contains(r14);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        if (r11 == 0) goto L_0x00eb;
    L_0x00c4:
        r2 = 1;
    L_0x00c5:
        if (r2 == 0) goto L_0x008e;
    L_0x00c7:
        if (r2 == 0) goto L_0x0116;
    L_0x00c9:
        r7 = 0;
    L_0x00ca:
        r5.close();	 Catch:{ IOException -> 0x0160 }
    L_0x00cd:
        r4.close();	 Catch:{ IOException -> 0x0163 }
    L_0x00d0:
        if (r6 == 0) goto L_0x018e;
    L_0x00d2:
        r6.destroy();	 Catch:{ Exception -> 0x0119 }
        r2 = r7;
        r3 = r4;
        r4 = r5;
        r5 = r6;
    L_0x00d9:
        if (r2 >= 0) goto L_0x00e0;
    L_0x00db:
        r6 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        java.lang.Thread.sleep(r6);	 Catch:{ InterruptedException -> 0x0170 }
    L_0x00e0:
        if (r2 < 0) goto L_0x0188;
    L_0x00e2:
        r2 = r10.toString();
        return r2;
    L_0x00e7:
        r2 = "sh";
        goto L_0x0014;
    L_0x00eb:
        if (r3 != 0) goto L_0x00f6;
    L_0x00ed:
        r3 = 1;
        r11 = "rg_cmd_start_magic";
        r11 = r9.contains(r11);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        if (r11 != 0) goto L_0x0096;
    L_0x00f6:
        r11 = "rg_cmd_end_magic";
        r11 = r9.contains(r11);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        if (r11 == 0) goto L_0x0107;
    L_0x00fe:
        r2 = "rg_cmd_end_magic";
        r11 = "";
        r9 = r9.replace(r2, r11);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        r2 = 1;
    L_0x0107:
        if (r8 == 0) goto L_0x0114;
    L_0x0109:
        r11 = 10;
        r10.append(r11);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
    L_0x010e:
        r10.append(r9);	 Catch:{ Exception -> 0x011f, all -> 0x014f }
        if (r2 == 0) goto L_0x0096;
    L_0x0113:
        goto L_0x00c5;
    L_0x0114:
        r8 = 1;
        goto L_0x010e;
    L_0x0116:
        r7 = r7 + 1;
        goto L_0x00ca;
    L_0x0119:
        r2 = move-exception;
        r2 = r7;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        goto L_0x00d9;
    L_0x011f:
        r2 = move-exception;
        r3 = r4;
        r4 = r5;
        r5 = r6;
    L_0x0123:
        r6 = TAG;	 Catch:{ all -> 0x0173 }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0173 }
        r9 = "execCmd exception:";
        r8.<init>(r9);	 Catch:{ all -> 0x0173 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0173 }
        r2 = r8.append(r2);	 Catch:{ all -> 0x0173 }
        r2 = r2.toString();	 Catch:{ all -> 0x0173 }
        com.shuame.rootgenius.sdk.C1473h.m4105d(r6, r2);	 Catch:{ all -> 0x0173 }
        if (r4 == 0) goto L_0x0140;
    L_0x013d:
        r4.close();	 Catch:{ IOException -> 0x0166 }
    L_0x0140:
        if (r3 == 0) goto L_0x0145;
    L_0x0142:
        r3.close();	 Catch:{ IOException -> 0x0168 }
    L_0x0145:
        if (r5 == 0) goto L_0x018b;
    L_0x0147:
        r5.destroy();	 Catch:{ Exception -> 0x014c }
        r2 = r7;
        goto L_0x00d9;
    L_0x014c:
        r2 = move-exception;
        r2 = r7;
        goto L_0x00d9;
    L_0x014f:
        r2 = move-exception;
    L_0x0150:
        if (r5 == 0) goto L_0x0155;
    L_0x0152:
        r5.close();	 Catch:{ IOException -> 0x016a }
    L_0x0155:
        if (r4 == 0) goto L_0x015a;
    L_0x0157:
        r4.close();	 Catch:{ IOException -> 0x016c }
    L_0x015a:
        if (r6 == 0) goto L_0x015f;
    L_0x015c:
        r6.destroy();	 Catch:{ Exception -> 0x016e }
    L_0x015f:
        throw r2;
    L_0x0160:
        r2 = move-exception;
        goto L_0x00cd;
    L_0x0163:
        r2 = move-exception;
        goto L_0x00d0;
    L_0x0166:
        r2 = move-exception;
        goto L_0x0140;
    L_0x0168:
        r2 = move-exception;
        goto L_0x0145;
    L_0x016a:
        r3 = move-exception;
        goto L_0x0155;
    L_0x016c:
        r3 = move-exception;
        goto L_0x015a;
    L_0x016e:
        r3 = move-exception;
        goto L_0x015f;
    L_0x0170:
        r6 = move-exception;
        goto L_0x00e0;
    L_0x0173:
        r2 = move-exception;
        r6 = r5;
        r5 = r4;
        r4 = r3;
        goto L_0x0150;
    L_0x0178:
        r2 = move-exception;
        r5 = r4;
        r4 = r3;
        goto L_0x0150;
    L_0x017c:
        r2 = move-exception;
        r4 = r3;
        goto L_0x0150;
    L_0x017f:
        r2 = move-exception;
        goto L_0x0123;
    L_0x0181:
        r2 = move-exception;
        r5 = r6;
        goto L_0x0123;
    L_0x0184:
        r2 = move-exception;
        r4 = r5;
        r5 = r6;
        goto L_0x0123;
    L_0x0188:
        r7 = r2;
        goto L_0x000a;
    L_0x018b:
        r2 = r7;
        goto L_0x00d9;
    L_0x018e:
        r2 = r7;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        goto L_0x00d9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.sdk.CommUtils.execCmd(boolean, java.lang.String, long):java.lang.String");
    }

    private static void getAdbInfo(AdbInfo adbInfo) {
        if (VERSION.SDK_INT >= 14) {
            String str = "/sys/class/android_usb/android0/";
            adbInfo.serial = readFrom(str + "iSerial").replaceAll("\n", "");
            adbInfo.pid = readFrom(str + "idProduct").replaceAll("\n", "");
            adbInfo.vid = readFrom(str + "idVendor").replaceAll("\n", "");
        }
    }

    public static String getFileNameFromUrl(String str) {
        return str.substring(str.lastIndexOf(47) + 1).split("\\?")[0].split("#")[0];
    }

    public static String getImei(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }

    public static String getImsi(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
    }

    public static int getNumCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new C1466a()).length;
        } catch (Exception e) {
            return 1;
        }
    }

    @SuppressLint({"NewApi"})
    public static String getResolution(Context context) {
        int i;
        int i2;
        Point point = new Point();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (VERSION.SDK_INT >= 13) {
            windowManager.getDefaultDisplay().getSize(point);
            i = point.x;
            i2 = point.y;
        } else {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            i = defaultDisplay.getWidth();
            i2 = defaultDisplay.getHeight();
        }
        return String.valueOf(i) + "x" + String.valueOf(i2);
    }

    public static String getSignatureMd5(Context context, String str) {
        String str2 = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                return str2;
            }
            Signature[] signatureArr = packageInfo.signatures;
            return (signatureArr == null || signatureArr.length <= 0) ? str2 : calcMd5(signatureArr[0].toByteArray());
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static int getVersionCode(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static String getVersionName(Context context) {
        String str = "";
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getWifiMacAddr(Context context) {
        String readPrefWifiMacAddr = readPrefWifiMacAddr(context);
        if (readPrefWifiMacAddr.isEmpty()) {
            WifiManager wifiManager = (WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI);
            if (wifiManager.isWifiEnabled()) {
                readPrefWifiMacAddr = wifiManager.getConnectionInfo().getMacAddress();
            } else {
                wifiManager.setWifiEnabled(true);
                String macAddress = wifiManager.getConnectionInfo().getMacAddress();
                wifiManager.setWifiEnabled(false);
                readPrefWifiMacAddr = macAddress;
            }
        }
        writePrefWifiMacAddr(context, readPrefWifiMacAddr);
        return readPrefWifiMacAddr == null ? "" : readPrefWifiMacAddr;
    }

    public static int parseInt(String str) {
        int i = 0;
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static RootingDev parseRootingDev(Context context) {
        RootingDev rootingDev = new RootingDev();
        try {
            char[] cArr = new char[1024];
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            Properties properties = new Properties();
            properties.load(new StringReader(String.valueOf(cArr, 0, fileReader.read(cArr)).replaceAll("CPU\\s+", "CPU_")));
            fileReader.close();
            rootingDev.phoneInfo.hardware = properties.getProperty("Hardware", "");
            rootingDev.phoneInfo.cpuInfo.hardware = properties.getProperty("Hardware", "");
            rootingDev.phoneInfo.cpuInfo.processor = properties.getProperty("Processor", "");
            rootingDev.phoneInfo.cpuInfo.arch = properties.getProperty("CPU_architecture", "");
            rootingDev.phoneInfo.cpuInfo.cores = getNumCores();
            fileReader = new FileReader("/proc/version");
            int read = fileReader.read(cArr);
            fileReader.close();
            rootingDev.phoneInfo.kernel = String.valueOf(cArr, 0, read).trim();
            Reader stringReader = new StringReader(execCmd("getprop").replaceAll("[\\[\\]]", ""));
            properties.clear();
            properties.load(stringReader);
            stringReader.close();
            rootingDev.phoneInfo.buildId = properties.getProperty("ro.build.id", "");
            rootingDev.phoneInfo.productDevice = properties.getProperty("ro.product.device", "");
            rootingDev.phoneInfo.productModel = properties.getProperty("ro.product.model", "");
            rootingDev.phoneInfo.phoneHardware = properties.getProperty("ro.hardware", "");
            rootingDev.phoneInfo.productBoard = properties.getProperty("ro.product.board", "");
            rootingDev.phoneInfo.productBrand = properties.getProperty("ro.product.brand", "");
            rootingDev.phoneInfo.buildFingerPrint = properties.getProperty("ro.build.fingerprint");
            rootingDev.phoneInfo.productManufacturer = properties.getProperty("ro.product.manufacturer", "");
            rootingDev.phoneInfo.androidVersion = properties.getProperty("ro.build.version.release", "");
            rootingDev.phoneInfo.buildDescription = properties.getProperty("ro.build.description", "");
            rootingDev.phoneInfo.buildVersionSdk = properties.getProperty("ro.build.version.sdk", "");
            rootingDev.phoneInfo.region = properties.getProperty("ro.csc.sales_code", "");
            if (rootingDev.phoneInfo.region.isEmpty()) {
                rootingDev.phoneInfo.region = properties.getProperty("rli.sales_code", "");
            }
            rootingDev.phoneId.mac = getWifiMacAddr(context);
            rootingDev.phoneId.packageName = context.getPackageName();
            if (rootingDev.phoneId.phimei.isEmpty()) {
                rootingDev.phoneId.phimei = getImei(context);
            }
            if (rootingDev.phoneId.imsi.isEmpty()) {
                rootingDev.phoneId.imsi = getImsi(context);
            }
            getAdbInfo(rootingDev.phoneInfo.adb);
            rootingDev.phoneId.phsn = rootingDev.phoneInfo.adb.serial;
            rootingDev.phoneId.rid = checkRid(context, rootingDev.phoneId.phsn + rootingDev.phoneInfo.productModel + String.valueOf(System.currentTimeMillis()));
            rootingDev.phoneInfo.resolution = getResolution(context);
            Object obj = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            rootingDev.phoneInfo.phoneId = TextUtils.isEmpty(obj) ? null : C1468c.m4052a(obj.toCharArray(), 16);
            rootingDev.inited = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return rootingDev;
    }

    public static String readErrInStream(Process process) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            String readLine;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while (true) {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
                stringBuffer.append("\n");
            }
            bufferedReader.close();
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (true) {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
                stringBuffer.append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static String readFrom(String str) {
        String str2 = "";
        try {
            InputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                str2 = str2 + new String(bArr, 0, read);
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
        }
        return str2;
    }

    private static String readPrefWifiMacAddr(Context context) {
        return context != null ? context.getSharedPreferences(RgsdkConfig.RGSDK_PREF, 0).getString("wifi_mac_addr", "") : "";
    }

    public static void unzip(InputStream inputStream, String str) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            byte[] bArr = new byte[4096];
            File file = new File(str);
            file.mkdirs();
            file.setExecutable(true, false);
            file.setReadable(true, false);
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    File file2 = new File(str + nextEntry.getName());
                    if (nextEntry.isDirectory()) {
                        file2.mkdirs();
                    } else {
                        file = file2.getParentFile();
                        if (!file.exists()) {
                            file.mkdirs();
                            file.setExecutable(true, false);
                            file.setReadable(true, false);
                        }
                        OutputStream fileOutputStream = new FileOutputStream(file2);
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.close();
                    }
                    file2.setExecutable(true, false);
                    file2.setReadable(true, false);
                } else {
                    zipInputStream.close();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void unzip(InputStream inputStream, String str, String str2) {
        try {
            ZipEntry nextEntry;
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            byte[] bArr = new byte[4096];
            do {
                nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
            } while (!nextEntry.getName().equals(str));
            File file = new File(str2);
            if (nextEntry.isDirectory()) {
                file.mkdirs();
            } else {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                    parentFile.setExecutable(true, false);
                    parentFile.setReadable(true, false);
                }
                OutputStream fileOutputStream = new FileOutputStream(file);
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.close();
            }
            file.setExecutable(true, false);
            file.setReadable(true, false);
            zipInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean unzip(String str, String str2) {
        try {
            unzip(new FileInputStream(str), str2);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean unzip(String str, String str2, String str3) {
        try {
            C0001b c0001b = new C0001b(str);
            if (c0001b.mo5a()) {
                if (C1468c.m4056a(str3)) {
                    c0001b.mo4a(str3.toCharArray());
                } else {
                    throw new NullPointerException();
                }
            }
            c0001b.mo3a(str2);
            return true;
        } catch (C0010a e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void writePrefWifiMacAddr(Context context, String str) {
        if (context != null) {
            Editor edit = context.getSharedPreferences(RgsdkConfig.RGSDK_PREF, 0).edit();
            edit.putString("wifi_mac_addr", str);
            edit.commit();
        }
    }

    public static String writeTo(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            OutputStream fileOutputStream = new FileOutputStream(str2);
            fileOutputStream.write(str.getBytes(), 0, str.length());
            fileOutputStream.close();
            return str;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return str;
        } catch (IOException e2) {
            e2.printStackTrace();
            return str;
        }
    }
}
