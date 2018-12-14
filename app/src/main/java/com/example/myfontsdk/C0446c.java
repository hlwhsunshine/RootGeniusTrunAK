package com.example.myfontsdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.HttpHandler;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.example.myfontsdk.c */
public final class C0446c {
    /* renamed from: a */
    static FinalHttp f1207a = new FinalHttp();
    /* renamed from: b */
    static Handler f1208b = new C0447d(Looper.getMainLooper());
    /* renamed from: c */
    private static String f1209c = "http://wfs.xinmei365.com/ttfapi/getsubfont";
    /* renamed from: d */
    private static Map<String, HttpHandler<File>> f1210d = new HashMap();
    /* renamed from: e */
    private static List<Font> f1211e = new ArrayList();

    /* renamed from: a */
    private static Font m979a(String str) {
        Font font;
        Exception e;
        try {
            JSONObject jSONObject = new JSONObject(str);
            font = new Font();
            try {
                font.setFontId(jSONObject.getInt("id"));
                font.setFontName(jSONObject.getString("name"));
                font.setFontSize(jSONObject.getLong("zipSize"));
                font.setUserName(jSONObject.getString("userName"));
                font.setDownloadUr(jSONObject.getString("zipUrl"));
                font.setThumbnailUrl(jSONObject.getString("preview"));
                if (jSONObject.has("lau")) {
                    font.setLauguage(jSONObject.getString("lau"));
                }
                if (jSONObject.has("hot")) {
                    font.setHot(jSONObject.getBoolean("hot"));
                }
                if (jSONObject.has("new")) {
                    font.setNew(jSONObject.getBoolean("new"));
                }
                if (jSONObject.has("dlDate")) {
                    font.setDownloadDate(jSONObject.getLong("dlDate"));
                }
                if (jSONObject.has("backupUrl")) {
                    font.setBackUpUrl(jSONObject.getString("backupUrl"));
                }
                if (jSONObject.has("origPath")) {
                    font.setFontLocalPath(jSONObject.getString("origPath"));
                }
                if (jSONObject.has("zhLocalPath")) {
                    font.setZhLocalPath(jSONObject.getString("zhLocalPath"));
                }
                if (jSONObject.has("enLocalPath")) {
                    font.setEnLocalPath(jSONObject.getString("enLocalPath"));
                }
                if (jSONObject.has("thumbnailLocalPath")) {
                    font.setThumbnailLocalPath(jSONObject.getString("thumbnailLocalPath"));
                }
                font.setThumbnailLocalPath(C0444a.f1189b + C0454k.m992a(font.getThumbnailUrl()) + ".dat");
                font.setDownloaded(true);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return font;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            font = null;
            e = exception;
            e.printStackTrace();
            return font;
        }
        return font;
    }

    /* renamed from: a */
    public static String m980a(C0453j c0453j, Context context) {
        new C0451h(c0453j, context).start();
        return "";
    }

    /* renamed from: a */
    public static List<Font> m981a() {
        List<Font> arrayList = new ArrayList();
        List<Font> c = C0446c.m990c();
        HashMap hashMap = new HashMap();
        for (Font font : c) {
            hashMap.put(Integer.valueOf(font.getFontId()), font);
        }
        try {
            String[] strArr = new String[]{"{\"MD5\":\"8e176931e8988db0e146912ed983ebf4\",\"fontName\":\"安卓出厂字体\",\"fontPreviewUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-06/anzhuochuchangyulan.zip\",\"fontDownloadBackUpUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-06/anzhuochuchangziti.apk\",\"lan\":\"zh\",\"isNewFont\":true,\"fontUser\":\"蜜酱\",\"isHotFont\":false,\"fontDownloadUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-06/anzhuochuchangziti.apk\",\"fontSize\":2221770,\"fontId\":46}", "{\"MD5\":\"9cfd950c987a6b354c0d4fd69af1e212\",\"fontName\":\"宇宙体\",\"fontPreviewUrl\":\"http://upaicdn.xinmei365.com/newwfs/previewfile/yuzhoutiyulan.zip\",\"fontDownloadBackUpUrl\":\"http://upaicdn.xinmei365.com/newwfs/fontfile/yuzhouti.apk\",\"lan\":\"zh\",\"isNewFont\":true,\"fontUser\":\"蜜酱\",\"isHotFont\":false,\"fontDownloadUrl\":\"http://upaicdn.xinmei365.com/newwfs/fontfile/yuzhouti.apk\",\"fontSize\":11790025,\"fontId\":1691}", "{\"MD5\":\"0e2e7d10277cb2c3ac3d9785c29e4050\",\"fontName\":\"寻找小天使\",\"fontPreviewUrl\":\"http://upaicdn.xinmei365.com/newwfs/previewfile/xiaotianshiyulan.zip\",\"fontDownloadBackUpUrl\":\"http://upaicdn.xinmei365.com/newwfs/fontfile/xunzhaoxiaotianshi.apk\",\"lan\":\"zh\",\"isNewFont\":true,\"fontUser\":\"蜜酱\",\"isHotFont\":false,\"fontDownloadUrl\":\"http://upaicdn.xinmei365.com/newwfs/fontfile/xunzhaoxiaotianshi.apk\",\"fontSize\":9133262,\"fontId\":1690}", "{\"MD5\":\"e44a0c2039e8edc5d12abc76cc11ae71\",\"fontName\":\"明尚体\",\"fontPreviewUrl\":\"http://upaicdn.xinmei365.com/newwfs/previewfile/mingshangtiyulan.zip\",\"fontDownloadBackUpUrl\":\"http://upaicdn.xinmei365.com/newwfs/fontfile/mingshangti.apk\",\"lan\":\"zh\",\"isNewFont\":true,\"fontUser\":\"蜜酱\",\"isHotFont\":false,\"fontDownloadUrl\":\"http://upaicdn.xinmei365.com/newwfs/fontfile/mingshangti.apk\",\"fontSize\":5664721,\"fontId\":1683}", "{\"MD5\":\"f2d631a9a69ec9ecd2036067329d0415\",\"fontName\":\"眼泪\",\"fontPreviewUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-08/yanleiyulan.zip\",\"fontDownloadBackUpUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-08/yanlei.apk\",\"lan\":\"zh\",\"isNewFont\":true,\"fontUser\":\"蜜酱\",\"isHotFont\":false,\"fontDownloadUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-08/yanlei.apk\",\"fontSize\":6953760,\"fontId\":1634}", "{\"MD5\":\"96d3d3699409d5cb87909691bc2bc7fb\",\"fontName\":\"淡墨痕\",\"fontPreviewUrl\":\"http://upaicdn.xinmei365.com/newwfs/previewfile/danmohenyulan.zip\",\"fontDownloadBackUpUrl\":\"http://upaicdn.xinmei365.com/newwfs/fontfile/danmohen.apk\",\"lan\":\"zh\",\"isNewFont\":true,\"fontUser\":\"蜜酱\",\"isHotFont\":false,\"fontDownloadUrl\":\"http://upaicdn.xinmei365.com/newwfs/fontfile/danmohen.apk\",\"fontSize\":6857976,\"fontId\":1681}", "{\"MD5\":\"37d4600b6f309ec37d124752d6350272\",\"fontName\":\"花节体\",\"fontPreviewUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-07/huajietiyulan.zip\",\"fontDownloadBackUpUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-07/huajieti.apk\",\"lan\":\"zh\",\"isNewFont\":true,\"fontUser\":\"蜜酱\",\"isHotFont\":false,\"fontDownloadUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-07/huajieti.apk\",\"fontSize\":6671957,\"fontId\":1603}", "{\"MD5\":\"49badb74fe950f533d94afcbba76016e\",\"fontName\":\"心版甜妞\",\"fontPreviewUrl\":\"http://upaicdn.xinmei365.com/newwfs/previewfile/xinbantianniu.zip\",\"fontDownloadBackUpUrl\":\"http://upaicdn.xinmei365.com/wfs/2013-10/7f4d0f3d7ca1443ea092c062eb3bd0d4.apk\",\"lan\":\"zh\",\"isNewFont\":true,\"fontUser\":\"蜜酱\",\"isHotFont\":false,\"fontDownloadUrl\":\"http://upaicdn.xinmei365.com/wfs/2013-10/7f4d0f3d7ca1443ea092c062eb3bd0d4.apk\",\"fontSize\":11432886,\"fontId\":1688}", "{\"MD5\":\"5df44558b32fc61fd1162194cd961fe0\",\"fontName\":\"萝莉小猫咪\",\"fontPreviewUrl\":\"http://upaicdn.xinmei365.com/wfs/2013-06/5f39b909cead489dbb3d48b32fcee3db.zip\",\"fontDownloadBackUpUrl\":\"http://cdn2.xinmei365.com/files/wfs/2013-10/8c49f8322cfc4020b6facd7661061261.apk\",\"lan\":\"zh\",\"isNewFont\":true,\"fontUser\":\"蜜酱\",\"isHotFont\":false,\"fontDownloadUrl\":\"http://cdn2.xinmei365.com/files/wfs/2013-10/8c49f8322cfc4020b6facd7661061261.apk\",\"fontSize\":9712679,\"fontId\":571}", "{\"MD5\":\"f4ac36924e471b859610feefaabcf306\",\"fontName\":\"白马梦船\",\"fontPreviewUrl\":\"http://upaicdn.xinmei365.com/newwfs/previewfile/baimamengchuanyulan.zip\",\"fontDownloadBackUpUrl\":\"http://upaicdn.xinmei365.com/newwfs/fontfile/baimamengchuan.apk\",\"lan\":\"zh\",\"isNewFont\":true,\"fontUser\":\"蜜酱\",\"isHotFont\":false,\"fontDownloadUrl\":\"http://upaicdn.xinmei365.com/newwfs/fontfile/baimamengchuan.apk\",\"fontSize\":2276034,\"fontId\":1675}", "{\"MD5\":\"b2374ef6d9eb02f7ee3210ab09551772\",\"fontName\":\"秀气中文\",\"fontPreviewUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-07/xiuqizhongwenyulan.zip\",\"fontDownloadBackUpUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-07/xiuqizhongwen.apk\",\"lan\":\"zh\",\"isNewFont\":true,\"fontUser\":\"蜜酱\",\"isHotFont\":false,\"fontDownloadUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-07/xiuqizhongwen.apk\",\"fontSize\":8743620,\"fontId\":1601}", "{\"MD5\":\"da839ae14ca149fe64a5d206eb62fb8b\",\"fontName\":\"小苹果\",\"fontPreviewUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-07/appleyulan.zip\",\"fontDownloadBackUpUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-07/xiaopingguo.apk\",\"lan\":\"zh\",\"isNewFont\":true,\"fontUser\":\"蜜酱\",\"isHotFont\":false,\"fontDownloadUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-07/xiaopingguo.apk\",\"fontSize\":13430720,\"fontId\":1577}", "{\"MD5\":\"136dee37e9228b242c2572d8357d187f\",\"fontName\":\"沁惜体\",\"fontPreviewUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-05/qinxitiyulan.zip\",\"fontDownloadBackUpUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-05/qinxiti.apk\",\"lan\":\"zh\",\"isNewFont\":true,\"fontUser\":\"蜜酱\",\"isHotFont\":false,\"fontDownloadUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-05/qinxiti.apk\",\"fontSize\":9258017,\"fontId\":1199}", "{\"MD5\":\"5fbbd32e49ef8e4e750b23f1249b5c2c\",\"fontName\":\"麦甜体\",\"fontPreviewUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-05/maitiantiyulan.zip\",\"fontDownloadBackUpUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-05/maitianti.apk\",\"lan\":\"zh\",\"isNewFont\":true,\"fontUser\":\"蜜酱\",\"isHotFont\":false,\"fontDownloadUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-05/maitianti.apk\",\"fontSize\":10029290,\"fontId\":1197}", "{\"MD5\":\"5124cb9827dd055a8373f8d0aab6954c\",\"fontName\":\"情书翩翩体\",\"fontPreviewUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-05/qingshupianpianyulan.zip\",\"fontDownloadBackUpUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-05/qingshupianpianti.apk\",\"lan\":\"zh\",\"isNewFont\":true,\"fontUser\":\"蜜酱\",\"isHotFont\":false,\"fontDownloadUrl\":\"http://upaicdn.xinmei365.com/wfs/2014-05/qingshupianpianti.apk\",\"fontSize\":15521696,\"fontId\":1195}"};
            for (int i = 0; i < 15; i++) {
                Object b = C0446c.m987b(strArr[i]);
                int fontId = b.getFontId();
                if (hashMap.containsKey(Integer.valueOf(fontId))) {
                    b = (Font) hashMap.get(Integer.valueOf(fontId));
                }
                arrayList.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<Font> m982a(Context context, List<Font> list) {
        List<Font> arrayList = new ArrayList();
        List c = C0446c.m990c();
        arrayList.addAll(list);
        int i = context.getSharedPreferences("", 0).getInt("used_id", -1);
        for (Font font : arrayList) {
            if (c.contains(font)) {
                ((Font) c.get(c.indexOf(font))).setDownloaded(true);
            } else {
                font.setDownloaded(false);
            }
        }
        for (Font font2 : C0446c.m990c()) {
            if (!arrayList.contains(font2)) {
                font2.setDownloaded(true);
                if (font2.getFontId() == i) {
                    font2.setUsed(true);
                } else {
                    font2.setUsed(false);
                }
                arrayList.add(font2);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0160 A:{SYNTHETIC, Splitter: B:53:0x0160} */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0154 A:{SYNTHETIC, Splitter: B:46:0x0154} */
    /* renamed from: a */
    public static void m983a(com.example.myfontsdk.Font r8) {
        /*
        r2 = 0;
        r1 = com.example.myfontsdk.C0444a.f1188a;	 Catch:{ Exception -> 0x013e }
        r0 = r8.getDownloadUr();	 Catch:{ Exception -> 0x013e }
        r3 = com.example.myfontsdk.C0454k.m992a(r0);	 Catch:{ Exception -> 0x013e }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x013e }
        r4 = java.lang.String.valueOf(r1);	 Catch:{ Exception -> 0x013e }
        r0.<init>(r4);	 Catch:{ Exception -> 0x013e }
        r0 = r0.append(r3);	 Catch:{ Exception -> 0x013e }
        r4 = ".apk";
        r0 = r0.append(r4);	 Catch:{ Exception -> 0x013e }
        r4 = r0.toString();	 Catch:{ Exception -> 0x013e }
        if (r8 == 0) goto L_0x0130;
    L_0x0024:
        r0 = new java.io.File;	 Catch:{ Exception -> 0x013e }
        r0.<init>(r4);	 Catch:{ Exception -> 0x013e }
        r5 = 0;
        r6 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0131 }
        r6.<init>(r0);	 Catch:{ Exception -> 0x0131 }
        r6.close();	 Catch:{ Exception -> 0x013e }
    L_0x0032:
        r8.setFontLocalPath(r4);	 Catch:{ Exception -> 0x013e }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x013e }
        r5 = java.lang.String.valueOf(r1);	 Catch:{ Exception -> 0x013e }
        r0.<init>(r5);	 Catch:{ Exception -> 0x013e }
        r0 = r0.append(r3);	 Catch:{ Exception -> 0x013e }
        r5 = "-zh.ttf";
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x013e }
        r0 = r0.toString();	 Catch:{ Exception -> 0x013e }
        r8.setZhLocalPath(r0);	 Catch:{ Exception -> 0x013e }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x013e }
        r5 = java.lang.String.valueOf(r1);	 Catch:{ Exception -> 0x013e }
        r0.<init>(r5);	 Catch:{ Exception -> 0x013e }
        r0 = r0.append(r3);	 Catch:{ Exception -> 0x013e }
        r5 = "-en.ttf";
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x013e }
        r0 = r0.toString();	 Catch:{ Exception -> 0x013e }
        r8.setEnLocalPath(r0);	 Catch:{ Exception -> 0x013e }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x013e }
        r8.setDownloadDate(r6);	 Catch:{ Exception -> 0x013e }
        com.example.myfontsdk.C0445b.m978a(r4, r1, r3);	 Catch:{ Exception -> 0x013e }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x013e }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Exception -> 0x013e }
        r0.<init>(r1);	 Catch:{ Exception -> 0x013e }
        r0 = r0.append(r3);	 Catch:{ Exception -> 0x013e }
        r1 = ".meta";
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x013e }
        r3 = r0.toString();	 Catch:{ Exception -> 0x013e }
        r4 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0148 }
        r4.<init>();	 Catch:{ JSONException -> 0x0148 }
        r0 = "id";
        r1 = r8.getFontId();	 Catch:{ JSONException -> 0x0148 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x0148 }
        r0 = "name";
        r1 = r8.getFontName();	 Catch:{ JSONException -> 0x0148 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x0148 }
        r0 = "zipSize";
        r6 = r8.getFontSize();	 Catch:{ JSONException -> 0x0148 }
        r4.put(r0, r6);	 Catch:{ JSONException -> 0x0148 }
        r0 = "userName";
        r1 = r8.getUserName();	 Catch:{ JSONException -> 0x0148 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x0148 }
        r0 = "zipUrl";
        r1 = r8.getDownloadUr();	 Catch:{ JSONException -> 0x0148 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x0148 }
        r0 = "backupUrl";
        r1 = r8.getBackUpUrl();	 Catch:{ JSONException -> 0x0148 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x0148 }
        r0 = "preview";
        r1 = r8.getThumbnailUrl();	 Catch:{ JSONException -> 0x0148 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x0148 }
        r0 = "hot";
        r1 = r8.isHot();	 Catch:{ JSONException -> 0x0148 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x0148 }
        r0 = "new";
        r1 = r8.isNew();	 Catch:{ JSONException -> 0x0148 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x0148 }
        r0 = r8.getLauguage();	 Catch:{ Exception -> 0x0143 }
        if (r0 == 0) goto L_0x00ef;
    L_0x00e6:
        r0 = "lau";
        r1 = r8.getLauguage();	 Catch:{ Exception -> 0x0143 }
        r4.put(r0, r1);	 Catch:{ Exception -> 0x0143 }
    L_0x00ef:
        r0 = "dlDate";
        r6 = r8.getDownloadDate();	 Catch:{ JSONException -> 0x0148 }
        r4.put(r0, r6);	 Catch:{ JSONException -> 0x0148 }
        r0 = "origPath";
        r1 = r8.getFontLocalPath();	 Catch:{ JSONException -> 0x0148 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x0148 }
        r0 = "zhLocalPath";
        r1 = r8.getZhLocalPath();	 Catch:{ JSONException -> 0x0148 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x0148 }
        r0 = "enLocalPath";
        r1 = r8.getEnLocalPath();	 Catch:{ JSONException -> 0x0148 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x0148 }
        r0 = "thumbnailLocalPath";
        r1 = r8.getThumbnailLocalPath();	 Catch:{ JSONException -> 0x0148 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x0148 }
        r1 = new java.io.BufferedWriter;	 Catch:{ IOException -> 0x014d, all -> 0x015d }
        r0 = new java.io.FileWriter;	 Catch:{ IOException -> 0x014d, all -> 0x015d }
        r0.<init>(r3);	 Catch:{ IOException -> 0x014d, all -> 0x015d }
        r1.<init>(r0);	 Catch:{ IOException -> 0x014d, all -> 0x015d }
        r0 = r4.toString();	 Catch:{ IOException -> 0x0171 }
        r1.write(r0);	 Catch:{ IOException -> 0x0171 }
        r1.close();	 Catch:{ IOException -> 0x0169 }
    L_0x0130:
        return;
    L_0x0131:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0137 }
        goto L_0x0032;
    L_0x0137:
        r0 = move-exception;
        if (r2 == 0) goto L_0x013d;
    L_0x013a:
        r5.close();	 Catch:{ Exception -> 0x013e }
    L_0x013d:
        throw r0;	 Catch:{ Exception -> 0x013e }
    L_0x013e:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0130;
    L_0x0143:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ JSONException -> 0x0148 }
        goto L_0x00ef;
    L_0x0148:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x013e }
        goto L_0x0130;
    L_0x014d:
        r0 = move-exception;
        r1 = r2;
    L_0x014f:
        r0.printStackTrace();	 Catch:{ all -> 0x016e }
        if (r1 == 0) goto L_0x0130;
    L_0x0154:
        r1.close();	 Catch:{ IOException -> 0x0158 }
        goto L_0x0130;
    L_0x0158:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ JSONException -> 0x0148 }
        goto L_0x0130;
    L_0x015d:
        r0 = move-exception;
    L_0x015e:
        if (r2 == 0) goto L_0x0163;
    L_0x0160:
        r2.close();	 Catch:{ IOException -> 0x0164 }
    L_0x0163:
        throw r0;	 Catch:{ JSONException -> 0x0148 }
    L_0x0164:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ JSONException -> 0x0148 }
        goto L_0x0163;
    L_0x0169:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ JSONException -> 0x0148 }
        goto L_0x0130;
    L_0x016e:
        r0 = move-exception;
        r2 = r1;
        goto L_0x015e;
    L_0x0171:
        r0 = move-exception;
        goto L_0x014f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.myfontsdk.c.a(com.example.myfontsdk.Font):void");
    }

    /* renamed from: a */
    public static void m984a(C0459q c0459q, Font font) {
        new C0448e(font, c0459q).start();
    }

    /* renamed from: a */
    public static void m985a(C0459q c0459q, Font font, String str) {
        new C0449f(str, font, c0459q).start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x010c A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0111 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:95:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0116 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012b A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0130 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0135 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012b A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0130 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0135 A:{SYNTHETIC} */
    /* renamed from: a */
    public static void m986a(java.lang.String r9, com.example.myfontsdk.Font r10) {
        /*
        r1 = 0;
        r0 = new java.lang.StringBuilder;
        r2 = com.example.myfontsdk.C0444a.f1189b;
        r2 = java.lang.String.valueOf(r2);
        r0.<init>(r2);
        r2 = new java.lang.StringBuilder;
        r3 = r10.getFontId();
        r3 = java.lang.String.valueOf(r3);
        r2.<init>(r3);
        r2 = r2.append(r9);
        r2 = r2.toString();
        r2 = com.example.myfontsdk.C0454k.m992a(r2);
        r0 = r0.append(r2);
        r2 = ".dat";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r2 = new java.io.File;
        r2.<init>(r0);
        r3 = r2.exists();
        if (r3 != 0) goto L_0x00fd;
    L_0x003e:
        r2 = r2.getParentFile();
        r3 = r2.exists();
        if (r3 != 0) goto L_0x004b;
    L_0x0048:
        r2.mkdirs();
    L_0x004b:
        r4 = f1209c;
        r3 = new org.apache.http.impl.client.DefaultHttpClient;	 Catch:{ Exception -> 0x015e, all -> 0x0126 }
        r3.<init>();	 Catch:{ Exception -> 0x015e, all -> 0x0126 }
        r2 = r3.getParams();	 Catch:{ Exception -> 0x0162, all -> 0x0159 }
        r5 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r2, r5);	 Catch:{ Exception -> 0x0162, all -> 0x0159 }
        r5 = 35000; // 0x88b8 float:4.9045E-41 double:1.72923E-319;
        org.apache.http.params.HttpConnectionParams.setSoTimeout(r2, r5);	 Catch:{ Exception -> 0x0162, all -> 0x0159 }
        r2 = new org.apache.http.client.methods.HttpPost;	 Catch:{ Exception -> 0x0162, all -> 0x0159 }
        r2.<init>(r4);	 Catch:{ Exception -> 0x0162, all -> 0x0159 }
        r4 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0106 }
        r4.<init>();	 Catch:{ Exception -> 0x0106 }
        r5 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0106 }
        r5.<init>();	 Catch:{ Exception -> 0x0106 }
        r6 = "packageName";
        r7 = "wenzisuoping";
        r5.put(r6, r7);	 Catch:{ Exception -> 0x0106 }
        r6 = "fTag";
        r7 = r10.getFlag();	 Catch:{ Exception -> 0x0106 }
        r5.put(r6, r7);	 Catch:{ Exception -> 0x0106 }
        r6 = "content";
        r7 = "%";
        r8 = "";
        r7 = r9.replace(r7, r8);	 Catch:{ Exception -> 0x0106 }
        r5.put(r6, r7);	 Catch:{ Exception -> 0x0106 }
        r6 = new org.apache.http.message.BasicNameValuePair;	 Catch:{ Exception -> 0x0106 }
        r7 = "param";
        r5 = r5.toString();	 Catch:{ Exception -> 0x0106 }
        r6.<init>(r7, r5);	 Catch:{ Exception -> 0x0106 }
        r4.add(r6);	 Catch:{ Exception -> 0x0106 }
        r5 = new org.apache.http.client.entity.UrlEncodedFormEntity;	 Catch:{ Exception -> 0x0106 }
        r6 = "utf-8";
        r5.<init>(r4, r6);	 Catch:{ Exception -> 0x0106 }
        r2.setEntity(r5);	 Catch:{ Exception -> 0x0106 }
        r4 = r3.execute(r2);	 Catch:{ Exception -> 0x0106 }
        r5 = r4.getStatusLine();	 Catch:{ Exception -> 0x0106 }
        r5 = r5.getStatusCode();	 Catch:{ Exception -> 0x0106 }
        r6 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r5 != r6) goto L_0x00ee;
    L_0x00b5:
        r4 = r4.getEntity();	 Catch:{ Exception -> 0x0106 }
        if (r4 == 0) goto L_0x00ee;
    L_0x00bb:
        r5 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r5 = new byte[r5];	 Catch:{ Exception -> 0x0106 }
        r6 = ".dat";
        r7 = ".tmp";
        r6 = r0.replaceAll(r6, r7);	 Catch:{ Exception -> 0x0106 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x0106 }
        r7.<init>(r6);	 Catch:{ Exception -> 0x0106 }
        r8 = r7.exists();	 Catch:{ Exception -> 0x0106 }
        if (r8 != 0) goto L_0x00d5;
    L_0x00d2:
        r7.createNewFile();	 Catch:{ Exception -> 0x0106 }
    L_0x00d5:
        r7 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0106 }
        r7.<init>(r6);	 Catch:{ Exception -> 0x0106 }
        r1 = r4.getContent();	 Catch:{ Exception -> 0x0106 }
    L_0x00de:
        r4 = 0;
        r8 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r4 = r1.read(r5, r4, r8);	 Catch:{ Exception -> 0x0106 }
        r8 = -1;
        if (r4 != r8) goto L_0x00fe;
    L_0x00e8:
        r7.close();	 Catch:{ Exception -> 0x0106 }
        com.example.myfontsdk.C0445b.m977a(r6, r0);	 Catch:{ Exception -> 0x0106 }
    L_0x00ee:
        r2.abort();	 Catch:{ Exception -> 0x0151, all -> 0x0143 }
    L_0x00f1:
        if (r1 == 0) goto L_0x00f6;
    L_0x00f3:
        r1.close();	 Catch:{ IOException -> 0x0153, all -> 0x0145 }
    L_0x00f6:
        r0 = r3.getConnectionManager();	 Catch:{ Exception -> 0x0155, all -> 0x0147 }
        r0.shutdown();	 Catch:{ Exception -> 0x0155, all -> 0x0147 }
    L_0x00fd:
        return;
    L_0x00fe:
        r8 = 0;
        r7.write(r5, r8, r4);	 Catch:{ Exception -> 0x0106 }
        r7.flush();	 Catch:{ Exception -> 0x0106 }
        goto L_0x00de;
    L_0x0106:
        r0 = move-exception;
    L_0x0107:
        r0.printStackTrace();	 Catch:{ all -> 0x015c }
        if (r2 == 0) goto L_0x010f;
    L_0x010c:
        r2.abort();	 Catch:{ Exception -> 0x0149, all -> 0x0120 }
    L_0x010f:
        if (r1 == 0) goto L_0x0114;
    L_0x0111:
        r1.close();	 Catch:{ IOException -> 0x014b, all -> 0x0122 }
    L_0x0114:
        if (r3 == 0) goto L_0x00fd;
    L_0x0116:
        r0 = r3.getConnectionManager();	 Catch:{ Exception -> 0x011e, all -> 0x0124 }
        r0.shutdown();	 Catch:{ Exception -> 0x011e, all -> 0x0124 }
        goto L_0x00fd;
    L_0x011e:
        r0 = move-exception;
        goto L_0x00fd;
    L_0x0120:
        r0 = move-exception;
        throw r0;
    L_0x0122:
        r0 = move-exception;
        throw r0;
    L_0x0124:
        r0 = move-exception;
        throw r0;
    L_0x0126:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
    L_0x0129:
        if (r2 == 0) goto L_0x012e;
    L_0x012b:
        r2.abort();	 Catch:{ Exception -> 0x014d, all -> 0x013d }
    L_0x012e:
        if (r1 == 0) goto L_0x0133;
    L_0x0130:
        r1.close();	 Catch:{ IOException -> 0x014f, all -> 0x013f }
    L_0x0133:
        if (r3 == 0) goto L_0x013c;
    L_0x0135:
        r1 = r3.getConnectionManager();	 Catch:{ Exception -> 0x0157, all -> 0x0141 }
        r1.shutdown();	 Catch:{ Exception -> 0x0157, all -> 0x0141 }
    L_0x013c:
        throw r0;
    L_0x013d:
        r0 = move-exception;
        throw r0;
    L_0x013f:
        r0 = move-exception;
        throw r0;
    L_0x0141:
        r0 = move-exception;
        throw r0;
    L_0x0143:
        r0 = move-exception;
        throw r0;
    L_0x0145:
        r0 = move-exception;
        throw r0;
    L_0x0147:
        r0 = move-exception;
        throw r0;
    L_0x0149:
        r0 = move-exception;
        goto L_0x010f;
    L_0x014b:
        r0 = move-exception;
        goto L_0x0114;
    L_0x014d:
        r2 = move-exception;
        goto L_0x012e;
    L_0x014f:
        r1 = move-exception;
        goto L_0x0133;
    L_0x0151:
        r0 = move-exception;
        goto L_0x00f1;
    L_0x0153:
        r0 = move-exception;
        goto L_0x00f6;
    L_0x0155:
        r0 = move-exception;
        goto L_0x00fd;
    L_0x0157:
        r1 = move-exception;
        goto L_0x013c;
    L_0x0159:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0129;
    L_0x015c:
        r0 = move-exception;
        goto L_0x0129;
    L_0x015e:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
        goto L_0x0107;
    L_0x0162:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0107;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.myfontsdk.c.a(java.lang.String, com.example.myfontsdk.Font):void");
    }

    /* renamed from: b */
    private static Font m987b(String str) {
        Font font = new Font();
        try {
            JSONObject jSONObject = new JSONObject(str);
            font.setMD5(jSONObject.getString("MD5"));
            font.setFontId(jSONObject.getInt("fontId"));
            font.setFontName(jSONObject.getString("fontName"));
            font.setFontSize(jSONObject.getLong("fontSize"));
            font.setUserName(jSONObject.getString("fontUser"));
            font.setDownloadUr(jSONObject.getString("fontDownloadUrl"));
            font.setLauguage(jSONObject.getString("lan"));
            font.setThumbnailUrl(jSONObject.getString("fontPreviewUrl"));
            if (jSONObject.has("isHotFont")) {
                font.setHot(jSONObject.getBoolean("isHotFont"));
            }
            if (jSONObject.has("isNewFont")) {
                font.setNew(jSONObject.getBoolean("isNewFont"));
            }
            if (jSONObject.has("fontDownloadBackUpUrl")) {
                font.setBackUpUrl(jSONObject.getString("fontDownloadBackUpUrl"));
            }
            font.setThumbnailLocalPath(C0444a.f1189b + C0454k.m992a(font.getThumbnailUrl()) + ".dat");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return font;
    }

    /* renamed from: b */
    public static String m988b() {
        return C0444a.f1188a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x007c A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0087 A:{SYNTHETIC, Splitter: B:37:0x0087} */
    /* renamed from: c */
    private static java.util.List<com.example.myfontsdk.Font> m990c() {
        /*
        r0 = 0;
        r4 = new java.util.ArrayList;
        r4.<init>();
        r1 = android.os.Environment.getExternalStorageState();
        r2 = "mounted";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x003d;
    L_0x0012:
        r1 = android.os.Environment.getExternalStorageDirectory();
        r1 = r1.canWrite();
        if (r1 == 0) goto L_0x003d;
    L_0x001c:
        r1 = 1;
    L_0x001d:
        if (r1 == 0) goto L_0x003c;
    L_0x001f:
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0095 }
        r2 = com.example.myfontsdk.C0444a.f1188a;	 Catch:{ Exception -> 0x0095 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0095 }
        r2 = r1.exists();	 Catch:{ Exception -> 0x0095 }
        if (r2 != 0) goto L_0x002f;
    L_0x002c:
        r1.mkdir();	 Catch:{ Exception -> 0x0095 }
    L_0x002f:
        r2 = new com.example.myfontsdk.g;	 Catch:{ Exception -> 0x0090 }
        r2.<init>();	 Catch:{ Exception -> 0x0090 }
        r5 = r1.listFiles(r2);	 Catch:{ Exception -> 0x0090 }
        r6 = r5.length;	 Catch:{ Exception -> 0x0090 }
        r3 = r0;
    L_0x003a:
        if (r3 < r6) goto L_0x003f;
    L_0x003c:
        return r4;
    L_0x003d:
        r1 = r0;
        goto L_0x001d;
    L_0x003f:
        r0 = r5[r3];	 Catch:{ Exception -> 0x0090 }
        r2 = 0;
        r1 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0080, all -> 0x009a }
        r7 = new java.io.FileReader;	 Catch:{ Exception -> 0x0080, all -> 0x009a }
        r7.<init>(r0);	 Catch:{ Exception -> 0x0080, all -> 0x009a }
        r1.<init>(r7);	 Catch:{ Exception -> 0x0080, all -> 0x009a }
        r0 = r1.readLine();	 Catch:{ Exception -> 0x00ae }
        if (r0 == 0) goto L_0x0079;
    L_0x0052:
        r0 = com.example.myfontsdk.C0446c.m979a(r0);	 Catch:{ Exception -> 0x00ae }
        if (r0 == 0) goto L_0x0079;
    L_0x0058:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x00ae }
        r7 = r0.getZhLocalPath();	 Catch:{ Exception -> 0x00ae }
        r2.<init>(r7);	 Catch:{ Exception -> 0x00ae }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x00ae }
        r8 = r0.getEnLocalPath();	 Catch:{ Exception -> 0x00ae }
        r7.<init>(r8);	 Catch:{ Exception -> 0x00ae }
        r2 = r2.exists();	 Catch:{ Exception -> 0x00ae }
        if (r2 != 0) goto L_0x0076;
    L_0x0070:
        r2 = r7.exists();	 Catch:{ Exception -> 0x00ae }
        if (r2 == 0) goto L_0x0079;
    L_0x0076:
        r4.add(r0);	 Catch:{ Exception -> 0x00ae }
    L_0x0079:
        r1.close();	 Catch:{ Exception -> 0x00a7 }
    L_0x007c:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x003a;
    L_0x0080:
        r0 = move-exception;
        r1 = r2;
    L_0x0082:
        r0.printStackTrace();	 Catch:{ all -> 0x00ac }
        if (r1 == 0) goto L_0x007c;
    L_0x0087:
        r1.close();	 Catch:{ Exception -> 0x008b }
        goto L_0x007c;
    L_0x008b:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0090 }
        goto L_0x007c;
    L_0x0090:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0095 }
        goto L_0x003c;
    L_0x0095:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x003c;
    L_0x009a:
        r0 = move-exception;
        r1 = r2;
    L_0x009c:
        if (r1 == 0) goto L_0x00a1;
    L_0x009e:
        r1.close();	 Catch:{ Exception -> 0x00a2 }
    L_0x00a1:
        throw r0;	 Catch:{ Exception -> 0x0090 }
    L_0x00a2:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ Exception -> 0x0090 }
        goto L_0x00a1;
    L_0x00a7:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0090 }
        goto L_0x007c;
    L_0x00ac:
        r0 = move-exception;
        goto L_0x009c;
    L_0x00ae:
        r0 = move-exception;
        goto L_0x0082;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.myfontsdk.c.c():java.util.List<com.example.myfontsdk.Font>");
    }
}
