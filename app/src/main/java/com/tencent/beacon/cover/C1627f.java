package com.tencent.beacon.cover;

import android.content.Context;
import android.content.p013pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Base64;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.tencent.beacon.cover.f */
public final class C1627f {
    /* renamed from: a */
    public static boolean f4614a = false;
    /* renamed from: b */
    static int f4615b = 1;
    /* renamed from: c */
    static int f4616c = 2;

    /* renamed from: a */
    public static String m4419a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            return "";
        }
    }

    /* renamed from: a */
    public static String m4420a(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream open = context.getAssets().open(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine);
            }
            bufferedReader.close();
            open.close();
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e2) {
            C1627f.m4428a("E", "read string from assets file error.", new Object[0]);
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static String m4421a(File file) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return C1627f.m4425a(instance.digest());
                }
            }
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m4422a(String str) {
        String str2 = "";
        try {
            return Base64.encodeToString(C1627f.m4444e(str), 2);
        } catch (Exception e) {
            return str2;
        }
    }

    /* renamed from: a */
    private static String m4423a(String str, Object... objArr) {
        return str == null ? "[cover] null" : (objArr == null || objArr.length == 0) ? "[cover] " + str : "[cover] " + String.format(Locale.US, str, objArr);
    }

    /* renamed from: a */
    public static String m4424a(List<C1622a> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (C1622a c1622a : list) {
            if (c1622a != null) {
                stringBuilder.append(c1622a.f4588a).append(",");
                stringBuilder.append(c1622a.f4589b).append(",");
                stringBuilder.append(c1622a.f4590c).append(",");
                stringBuilder.append(c1622a.f4591d).append(",");
                stringBuilder.append(c1622a.f4593f).append(",");
                stringBuilder.append(c1622a.f4594g).append(",");
                stringBuilder.append(c1622a.f4595h).append(";");
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static String m4425a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(toHexString);
        }
        return stringBuffer.toString().toLowerCase();
    }

    /* renamed from: a */
    public static void m4426a(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
        }
    }

    /* renamed from: a */
    public static void m4427a(Context context) {
        context.getSharedPreferences("DENGTA_META", 0).edit().putInt("load_so", 0).commit();
    }

    /* renamed from: a */
    public static void m4428a(String str, String str2, Object... objArr) {
        if (str.equalsIgnoreCase("I")) {
            if (f4614a) {
                C1627f.m4423a(str2, objArr);
            }
        } else if (str.equalsIgnoreCase("D")) {
            if (f4614a) {
                C1627f.m4423a(str2, objArr);
            }
        } else if (str.equalsIgnoreCase("W")) {
            if (f4614a) {
                C1627f.m4423a(str2, objArr);
            }
        } else if (str.equalsIgnoreCase("E") && f4614a) {
            C1627f.m4423a(str2, objArr);
        }
    }

    /* renamed from: a */
    public static boolean m4429a(Context context, String str, String str2) {
        return context.getSharedPreferences("beacon_cover", 0).edit().putString(str, str2).commit();
    }

    /* renamed from: a */
    public static boolean m4430a(Context context, String str, String str2, String str3, long j, byte[] bArr) {
        boolean z;
        String str4 = str2 + File.separator + str3;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            InputStream open = context.getResources().getAssets().open(str);
            if (((long) open.available()) == j) {
                FileOutputStream fileOutputStream = new FileOutputStream(str4);
                while (true) {
                    int read = open.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.close();
                z = true;
            } else {
                z = false;
            }
            try {
                open.close();
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            z = false;
            C1627f.m4428a("E", "copy assets error.", new Object[0]);
            return z;
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m4431a(String str, String str2) {
        try {
            InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);
            while (zipInputStream.getNextEntry() != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                while (true) {
                    int read = zipInputStream.read();
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream.write(read);
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            }
            zipInputStream.close();
            bufferedInputStream.close();
            File file = new File(str);
            if (!file.exists() || !file.isFile()) {
                return true;
            }
            file.delete();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public static byte[] m4432a(boolean z, String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return null;
        }
        for (int length = str.length(); length < 16; length++) {
            str = str + "0";
        }
        String substring = str.substring(0, 16);
        Key secretKeySpec = new SecretKeySpec(substring.getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(substring.getBytes());
        if (z) {
            instance.init(1, secretKeySpec, ivParameterSpec);
        } else {
            instance.init(2, secretKeySpec, ivParameterSpec);
        }
        return instance.doFinal(bArr);
    }

    /* renamed from: b */
    public static String m4433b() {
        String str = "";
        try {
            return Build.CPU_ABI;
        } catch (Exception e) {
            return str;
        }
    }

    /* renamed from: b */
    public static String m4434b(Context context) {
        if (C1628g.f4617a == null) {
            try {
                Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("APPKEY_DENGTA");
                if (obj != null) {
                    C1628g.f4617a = obj.toString().trim();
                }
            } catch (Throwable th) {
            }
        }
        return C1628g.f4617a;
    }

    /* renamed from: b */
    public static String m4435b(Context context, String str, String str2) {
        return context.getSharedPreferences("beacon_cover", 0).getString(str, str2);
    }

    /* renamed from: b */
    public static List<C1622a> m4436b(String str) {
        List<C1622a> arrayList = new ArrayList();
        for (String split : str.split(";")) {
            String[] split2 = split.split(",");
            if (split2.length >= 6) {
                try {
                    C1622a c1622a = new C1622a();
                    c1622a.f4588a = Integer.valueOf(split2[0]).intValue();
                    c1622a.f4589b = split2[1];
                    c1622a.f4590c = Integer.valueOf(split2[2]).intValue();
                    c1622a.f4591d = split2[3];
                    c1622a.f4593f = Integer.valueOf(split2[4]).intValue();
                    c1622a.f4594g = split2[5];
                    if (split2.length > 6) {
                        c1622a.f4595h = split2[6];
                    }
                    arrayList.add(c1622a);
                } catch (Exception e) {
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private static boolean m4437b(Context context, String str) {
        int i = 0;
        if (context == null) {
            return false;
        }
        boolean z = context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        if (!z) {
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    int length = strArr.length;
                    while (i < length) {
                        if (str.equals(strArr[i])) {
                            return true;
                        }
                        i++;
                    }
                }
                return z;
            } catch (Throwable th) {
            }
        }
        return z;
    }

    /* renamed from: c */
    public static long m4438c() {
        long j = 0;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            return j;
        }
    }

    /* renamed from: c */
    public static String m4439c(Context context) {
        int i = 0;
        if (C1628g.f4618b == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                String str = packageInfo.versionName;
                int i2 = packageInfo.versionCode;
                if (str == null || str.trim().length() <= 0) {
                    return String.valueOf(i2);
                }
                String str2;
                String replace = str.trim().replace(10, ' ').replace(13, ' ').replace("|", "%7C");
                char[] toCharArray = replace.toCharArray();
                for (char c : toCharArray) {
                    if (c == '.') {
                        i++;
                    }
                }
                if (i < 3) {
                    C1627f.m4428a("I", "versionCode: %s", Integer.valueOf(i2));
                    str2 = replace + "." + i2;
                } else {
                    str2 = replace;
                }
                C1628g.f4618b = str2;
            } catch (Exception e) {
            }
        }
        return C1628g.f4618b;
    }

    /* renamed from: c */
    private static String m4440c(String str) {
        String d = C1627f.m4442d(str);
        if (d == null) {
            return d;
        }
        try {
            return d.substring(8, 24);
        } catch (Exception e) {
            return d;
        }
    }

    /* renamed from: d */
    public static String m4441d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String string = Secure.getString(context.getContentResolver(), "android_id");
            if (string != null) {
                return string.toLowerCase();
            }
        } catch (Exception e) {
        }
        return "";
    }

    /* renamed from: d */
    private static String m4442d(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            return str;
        }
    }

    /* renamed from: e */
    public static String m4443e(Context context) {
        String str = "";
        if (context == null) {
            C1627f.m4428a("E", "getImei but context == null!", new Object[0]);
            return str;
        }
        String deviceId;
        try {
            if (C1627f.m4437b(context, "android.permission.READ_PHONE_STATE")) {
                deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId == null) {
                    try {
                        deviceId = "";
                    } catch (Throwable th) {
                    }
                } else {
                    deviceId = deviceId.toLowerCase();
                }
            } else {
                deviceId = str;
            }
            C1627f.m4428a("I", "IMEI:" + deviceId, new Object[0]);
            return deviceId;
        } catch (Throwable th2) {
            deviceId = str;
            C1627f.m4428a("E", "getImei error!", new Object[0]);
            return deviceId;
        }
    }

    /* renamed from: e */
    private static byte[] m4444e(String str) {
        if (str == null) {
            return null;
        }
        byte[] doFinal;
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA", "BC").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsAxNCSLyNUCOP1QqYStE8ZeiU\nv4afaMqEmoLCKb0mUZYvYOoVN7LPMi2IVY2MRaFJvuND3glVw1RDm2VJJtjQkwUd\n3kpR9TrHAf7UQOVTpNo3Vi7pXTOqZ6bh3ZA/fs56jDCCKV6+wT/pCeu8N6vVnPrD\nz3SdHIeNeWb/woazCwIDAQAB", 0)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, rSAPublicKey);
            doFinal = instance.doFinal(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            doFinal = null;
        }
        return doFinal;
    }

    /* renamed from: f */
    public static String m4445f(Context context) {
        try {
            return C1627f.m4440c(C1628g.f4617a + "_" + C1627f.m4441d(context) + "_" + new Date().getTime() + "_" + ((int) (Math.random() * 2.147483647E9d)));
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: g */
    public static boolean m4446g(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                    return true;
                }
            }
        } catch (Exception e) {
            C1627f.m4428a("e", e.getMessage(), new Object[0]);
        }
        return false;
    }
}
