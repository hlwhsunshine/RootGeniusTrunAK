package com.changefontmanager.sdk;

import android.content.Context;
import android.graphics.Typeface;
import com.changefontmanager.sdk.utils.Constant;
import com.changefontmanager.sdk.utils.FileUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class MIUIChangeFont {
    private static int OTHER = -1;
    private static int index = 0;
    /* renamed from: u */
    private static int f1140u = 1;
    /* renamed from: v */
    private static int f1141v = 2;
    /* renamed from: w */
    private static String[] f1142w = new String[]{"be835e57c2b23544972c34391e1a4e98b2235ad7", "83d41006dcc29a3d25ce77c47abf27d7103d04e9", "753495ae150d2aaee6521d70b3f568f9543ee500", "60720d2ea265bcca04a84fdeed26139dc2073f7c", "d2fa233fbcb19b1e208f01580d469cfee49cd451", "b1c041123b6343d4a58ffb590f7562231b3c5849", "899868409382d5a96592cee8d39fad8425c44d3d", "da34090105c503de5e34d73f1d6bdf3e818a999e", "96bba518cca523fea51cd4cc548a33e43a443cb1", "03b8b009a3720b1cd49a113f21e26f46d03aae2d"};
    /* renamed from: x */
    private static String[] f1143x = new String[]{"d11e8963791cda99122d5d63607cb0c16df8af3d", "17a4b29c181e08dbe00c5b7c88108d7dafa9f0be", "8698fbfc682bf74da2bbbb97077939c4620508a4", "f2830deeae27fa25270e08fb629aaea8346aab94", "1e46291b02891abf450ea753b13ebe04657946e7", "9f778200bb7ea2f804002d4a1c604d844a9f88fd", "f24a5cced6c8299863600261989fdb1448caa8d6", "b72ace606b1b7be721991c1de1bd03e378b92db7", "e9281e169828d131408a2adebbb505a461ffbaae", "e6e13ce41c114cec54a9443268deff5db1bcb765"};
    /* renamed from: y */
    private static String[] f1144y = new String[]{"711cc7bf-52e2-4587-96cb-2a3f87bcd02c", "5c339625-961e-4d00-a657-2589b1dc12da", "e53c993f-4b25-4357-accc-86090acc7890", "fb73c8bf-4ff6-4b30-86c8-bb3b061561b1", "32776b3f-2c8d-4227-adaa-7995ec6e46ec", "d8ff8582-69c9-4d2f-8c85-92d23a9523c3", "dfa27385-8506-41a5-a2cb-56a22aa9c5cf", "be388605-7a9c-45d4-a6a3-7f94d220bb28", "988fde9d-d8fa-4839-835a-4eef666e6564", "eb4a448b-088a-4565-bacf-6cbc9a85c13f"};

    /* renamed from: a */
    public static int m925a(Context context, String str, String str2) {
        File file = new File(str2);
        if (!file.exists()) {
            return -1;
        }
        Typeface.createFromFile(str2);
        try {
            File file2 = new File(Constant.FOLDER_MIUI_SYSTEM_FONT + ".data/content/fonts");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(Constant.FOLDER_MIUI_SYSTEM_FONT + ".data/content/theme");
            if (!file3.exists()) {
                file3.mkdirs();
            }
            File file4 = new File(Constant.FOLDER_MIUI_SYSTEM_FONT + ".data/meta/fonts");
            if (!file4.exists()) {
                file4.mkdirs();
            }
            File file5 = new File(Constant.FOLDER_MIUI_SYSTEM_FONT + ".data/meta/theme");
            if (!file5.exists()) {
                file5.mkdirs();
            }
            File file6 = new File(Constant.FOLDER_MIUI_SYSTEM_FONT + ".data/rights/theme");
            if (!file6.exists()) {
                file6.mkdirs();
            }
            File file7 = new File(Constant.FOLDER_MIUI_SYSTEM_FONT + "/.data/preview/theme/" + str + "theme");
            if (!file7.exists()) {
                file7.mkdirs();
            }
            FileUtils.m966e(str2, file2.getAbsolutePath() + "/" + str + ".mrc");
            new File(file3.getAbsolutePath() + "/" + str + "theme.mrc").createNewFile();
            new File(file2.getAbsolutePath() + "/" + str + "theme.mrc").createNewFile();
            String valueOf = String.valueOf(file.length());
            int length = index % f1142w.length;
            Context context2 = context;
            String str3 = str;
            m927a(context2, str3, file4.getAbsolutePath() + "/" + str + ".mrm", "###miui.mrm", valueOf, f1142w[length], f1144y[length]);
            context2 = context;
            str3 = str;
            m927a(context2, str3, file5.getAbsolutePath() + "/" + str + "theme.mrm", "###miuitheme.mrm", valueOf, f1143x[length], f1144y[length]);
            m929c(context, file6.getAbsolutePath() + "/" + f1144y[length] + ".mra", new StringBuilder(String.valueOf(f1144y[length])).append(".mra").toString());
            file = new File(file7.getAbsolutePath() + "/preview_fonts_0.png");
            if (!file.exists()) {
                file.createNewFile();
            }
            file = new File(file7.getAbsolutePath() + "/preview_fonts_small_0.png");
            if (!file.exists()) {
                file.createNewFile();
            }
            index++;
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    private static void m926a(Context context, String str, String str2, String str3, String str4) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str3)));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str2));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedWriter.write(stringBuilder.toString().replaceAll("###", str).replaceAll("@@@", str4).replaceAll("preview_fonts_small_0.jpg", Constant.FOLDER_MIUI_SYSTEM_FONT + "/.data/preview/theme/" + str + "theme/preview_fonts_small_0.jpg").replaceAll("preview_fonts_0.jpg", Constant.FOLDER_MIUI_SYSTEM_FONT + "/.data/preview/theme/" + str + "theme/preview_fonts_0.jpg"));
                bufferedWriter.close();
                return;
            }
            stringBuilder.append(readLine);
        }
    }

    /* renamed from: a */
    private static void m927a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str3)));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str2));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedWriter.write(stringBuilder.toString().replaceAll("###", str).replaceAll("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "aaaaaaaaa" + index).replaceAll("HHHHHHHHHHHHHHHHHHHHHHHHHHHHH", str5).replaceAll("CCCCCCCCCCCCCCCCCCCCCC", str6).replaceAll("DDDDDDDDDDDD", String.valueOf(System.currentTimeMillis())).replaceAll("@@@", str4).replaceAll("preview_fonts_small_0.jpg", Constant.FOLDER_MIUI_SYSTEM_FONT + "/.data/preview/theme/" + str + "theme/preview_fonts_small_0.jpg").replaceAll("preview_fonts_0.jpg", Constant.FOLDER_MIUI_SYSTEM_FONT + "/.data/preview/theme/" + str + "theme/preview_fonts_0.jpg"));
                bufferedWriter.close();
                return;
            }
            stringBuilder.append(new StringBuilder(String.valueOf(readLine)).toString());
        }
    }

    /* renamed from: b */
    private static void m928b(Context context, String str, String str2) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str2)));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedWriter.write(stringBuilder.toString());
                bufferedWriter.close();
                return;
            }
            stringBuilder.append(new StringBuilder(String.valueOf(readLine)).toString());
        }
    }

    /* renamed from: c */
    private static void m929c(Context context, String str, String str2) {
        if (!new File(str).exists()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str2)));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str));
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedWriter.write(stringBuilder.toString());
                    bufferedWriter.close();
                    return;
                }
                stringBuilder.append(new StringBuilder(String.valueOf(readLine)).toString());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0079 A:{SYNTHETIC, Splitter: B:39:0x0079} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0070 A:{SYNTHETIC, Splitter: B:33:0x0070} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0079 A:{SYNTHETIC, Splitter: B:39:0x0079} */
    /* renamed from: d */
    private static int m930d() {
        /*
        r0 = 1;
        r2 = -1;
        r1 = 0;
        r3 = java.lang.Runtime.getRuntime();	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r4 = "getprop ";
        r4 = r3.exec(r4);	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r3 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r5 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r4 = r4.getInputStream();	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r5.<init>(r4);	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3.<init>(r5, r4);	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r1 = r2;
    L_0x001e:
        r4 = r3.readLine();	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        if (r4 != 0) goto L_0x002c;
    L_0x0024:
        r3.close();	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        r3.close();	 Catch:{ IOException -> 0x0083 }
    L_0x002a:
        r0 = r1;
    L_0x002b:
        return r0;
    L_0x002c:
        r5 = "ro.miui.ui.version.code";
        r5 = r4.contains(r5);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        if (r5 == 0) goto L_0x0058;
    L_0x0034:
        r1 = ":";
        r1 = r4.indexOf(r1);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        r5 = r1 + 3;
        r1 = r1 + 4;
        r1 = r4.substring(r5, r1);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        r1 = r1.intValue();	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        r2 = 3;
        if (r1 < r2) goto L_0x0052;
    L_0x004d:
        r3.close();	 Catch:{ IOException -> 0x007d }
    L_0x0050:
        r0 = 2;
        goto L_0x002b;
    L_0x0052:
        r3.close();	 Catch:{ IOException -> 0x0056 }
        goto L_0x002b;
    L_0x0056:
        r1 = move-exception;
        goto L_0x002b;
    L_0x0058:
        r5 = "miui";
        r5 = r4.contains(r5);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        if (r5 != 0) goto L_0x0068;
    L_0x0060:
        r5 = "MIUI";
        r4 = r4.contains(r5);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        if (r4 == 0) goto L_0x001e;
    L_0x0068:
        r1 = r0;
        goto L_0x001e;
    L_0x006a:
        r0 = move-exception;
    L_0x006b:
        r0.printStackTrace();	 Catch:{ all -> 0x0087 }
        if (r1 == 0) goto L_0x0073;
    L_0x0070:
        r1.close();	 Catch:{ IOException -> 0x007f }
    L_0x0073:
        r0 = r2;
        goto L_0x002b;
    L_0x0075:
        r0 = move-exception;
        r3 = r1;
    L_0x0077:
        if (r3 == 0) goto L_0x007c;
    L_0x0079:
        r3.close();	 Catch:{ IOException -> 0x0081 }
    L_0x007c:
        throw r0;
    L_0x007d:
        r0 = move-exception;
        goto L_0x0050;
    L_0x007f:
        r0 = move-exception;
        goto L_0x0073;
    L_0x0081:
        r1 = move-exception;
        goto L_0x007c;
    L_0x0083:
        r0 = move-exception;
        goto L_0x002a;
    L_0x0085:
        r0 = move-exception;
        goto L_0x0077;
    L_0x0087:
        r0 = move-exception;
        r3 = r1;
        goto L_0x0077;
    L_0x008a:
        r0 = move-exception;
        r1 = r3;
        goto L_0x006b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.changefontmanager.sdk.MIUIChangeFont.d():int");
    }
}
