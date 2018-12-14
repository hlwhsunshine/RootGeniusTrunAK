package com.example.myfontsdk;

import android.os.Environment;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.example.myfontsdk.a */
public final class C0444a {
    /* renamed from: a */
    protected static String f1188a = (C0444a.m976a() + "/font/");
    /* renamed from: b */
    protected static String f1189b = (C0444a.m976a() + "/font/cache/");
    /* renamed from: c */
    public static String f1190c = "plugSoftware.dat";
    /* renamed from: d */
    public static String f1191d = "localAds.dat";
    /* renamed from: e */
    public static String f1192e = "supportSoftware.dat";
    /* renamed from: f */
    public static String f1193f = "softwareConfig.dat";
    /* renamed from: g */
    public static final String f1194g = (f1188a + "default.apk");
    /* renamed from: h */
    public static final String f1195h = (f1188a + "default-zh.ttf");
    /* renamed from: i */
    public static final String f1196i = (f1188a + "default-en.ttf");
    /* renamed from: j */
    public static final String f1197j = (C0444a.m976a() + "/MIUI/theme/");
    /* renamed from: k */
    public static final String f1198k = (C0444a.m976a() + "/MIUI/theme/.data/meta/fonts");
    /* renamed from: l */
    public static final String f1199l = (f1188a + "/miui/");
    /* renamed from: m */
    public static final String f1200m = (f1188a + "image/");
    /* renamed from: n */
    public static String f1201n = "subject";
    /* renamed from: o */
    public static String f1202o = "hot";
    /* renamed from: p */
    public static String f1203p = "new";
    /* renamed from: q */
    private static String f1204q = "";
    /* renamed from: r */
    private static String f1205r = "";

    /* renamed from: a */
    private static String m976a() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (absolutePath != null && !"".equals(absolutePath) && new File(absolutePath).canWrite()) {
            return absolutePath;
        }
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
            processBuilder.command(new String[]{"mount"});
            processBuilder.redirectErrorStream(true);
            Process start = processBuilder.start();
            start.waitFor();
            InputStream inputStream = start.getInputStream();
            byte[] bArr = new byte[1024];
            while (-1 != inputStream.read(bArr)) {
                absolutePath = new StringBuilder(String.valueOf(absolutePath)).append(new String(bArr)).toString();
            }
            inputStream.close();
            start.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] split = absolutePath.split("\n");
        String str = "";
        int i = 0;
        while (i < split.length) {
            if (-1 != split[i].indexOf(" vfat ") || -1 != split[i].indexOf(" sdcardfs ")) {
                String[] split2 = split[i].split("\\s");
                if (split2.length > 1 && !"".equals(split2[1]) && new File(split2[1]).canWrite()) {
                    return split2[1];
                }
            }
            i++;
        }
        return str;
    }
}
