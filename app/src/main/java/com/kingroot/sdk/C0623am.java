package com.kingroot.sdk;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.kingroot.sdk.am */
public class C0623am {
    /* renamed from: bv */
    private static String[] f1538bv = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    /* renamed from: a */
    private static long m1419a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    /* renamed from: a */
    private static C0626ap m1420a(XmlPullParser xmlPullParser) {
        while (xmlPullParser.next() != 1) {
            String name = xmlPullParser.getName();
            if (name != null && name.equals("root_zip")) {
                return C0623am.m1421b(xmlPullParser);
            }
        }
        return null;
    }

    /* renamed from: b */
    private static C0626ap m1421b(XmlPullParser xmlPullParser) {
        C0626ap c0626ap = new C0626ap();
        try {
            xmlPullParser.nextTag();
            xmlPullParser.require(2, "", "name");
            c0626ap.name = xmlPullParser.nextText();
            xmlPullParser.require(3, "", "name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            xmlPullParser.nextTag();
            xmlPullParser.require(2, "", "sid");
            c0626ap.f1556bK = String.valueOf(Integer.parseInt(xmlPullParser.nextText()));
            xmlPullParser.require(3, "", "sid");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            xmlPullParser.nextTag();
            xmlPullParser.require(2, "", "version");
            c0626ap.f1555az = xmlPullParser.nextText();
            xmlPullParser.require(3, "", "version");
        } catch (Exception e22) {
            e22.printStackTrace();
        }
        try {
            xmlPullParser.nextTag();
            xmlPullParser.require(2, "", "type");
            c0626ap.type = C0623am.parseInt(xmlPullParser.nextText(), 1);
            xmlPullParser.require(3, "", "type");
        } catch (Exception e222) {
            e222.printStackTrace();
        }
        try {
            xmlPullParser.nextTag();
            xmlPullParser.require(2, "", "size");
            c0626ap.size = C0623am.m1419a(xmlPullParser.nextText(), 0);
            xmlPullParser.require(3, "", "size");
        } catch (Exception e2222) {
            e2222.printStackTrace();
        }
        try {
            xmlPullParser.nextTag();
            xmlPullParser.require(2, "", "verified");
            c0626ap.f1557bL = C0623am.parseInt(xmlPullParser.nextText(), 1);
            xmlPullParser.require(3, "", "verified");
        } catch (Exception e22222) {
            e22222.printStackTrace();
        }
        try {
            xmlPullParser.nextTag();
            xmlPullParser.require(2, "", "md5");
            c0626ap.f1554O = xmlPullParser.nextText();
            xmlPullParser.require(3, "", "md5");
        } catch (Exception e222222) {
            e222222.printStackTrace();
        }
        try {
            xmlPullParser.nextTag();
            xmlPullParser.require(2, "", "encrypt");
            c0626ap.f1558bM = xmlPullParser.nextText();
            xmlPullParser.require(3, "", "encrypt");
        } catch (Exception e2222222) {
            e2222222.printStackTrace();
        }
        try {
            xmlPullParser.nextTag();
            xmlPullParser.require(2, "", "url");
            c0626ap.f1553M = xmlPullParser.nextText();
            xmlPullParser.require(3, "", "url");
        } catch (Exception e22222222) {
            e22222222.printStackTrace();
        }
        try {
            xmlPullParser.nextTag();
            xmlPullParser.require(2, "", "backup_url");
            c0626ap.f1559bN = xmlPullParser.nextText();
            xmlPullParser.require(3, "", "backup_url");
        } catch (Exception e222222222) {
            e222222222.printStackTrace();
        }
        try {
            xmlPullParser.nextTag();
            xmlPullParser.require(2, "", "exploit_type");
            c0626ap.f1560bO = C0623am.parseInt(xmlPullParser.nextText(), 0);
            xmlPullParser.require(3, "", "exploit_type");
        } catch (Exception e2222222222) {
            e2222222222.printStackTrace();
            c0626ap.f1560bO = 0;
        }
        try {
            xmlPullParser.nextTag();
            xmlPullParser.require(2, "", "interface_type");
            c0626ap.f1561bP = C0623am.parseInt(xmlPullParser.nextText(), 0);
            xmlPullParser.require(3, "", "interface_type");
        } catch (Exception e22222222222) {
            e22222222222.printStackTrace();
            c0626ap.f1561bP = 0;
        }
        return c0626ap;
    }

    /* renamed from: e */
    public static C0626ap[] m1422e(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return (C0626ap[]) arrayList2.toArray(new C0626ap[arrayList2.size()]);
            }
            try {
                String str = (String) arrayList.get(i2);
                newPullParser.setInput(new StringReader(str));
                while (newPullParser.next() != 1) {
                    String name = newPullParser.getName();
                    if (name != null) {
                        int eventType = newPullParser.getEventType();
                        if (name.equals("root") && eventType == 2) {
                            C0626ap a = C0623am.m1420a(newPullParser);
                            if (a != null) {
                                a.f1562bQ = str;
                                arrayList2.add(a);
                            }
                            i = i2 + 1;
                        }
                    }
                }
            } catch (Throwable e) {
                e.printStackTrace();
                C0633at.m1458a("解析方案配置文件异常", e);
            }
            i = i2 + 1;
        }
    }

    /* renamed from: m */
    public static String m1423m(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!(str == null || "".equals(str))) {
            StringTokenizer stringTokenizer = new StringTokenizer(str.substring(str.indexOf("#") + 1), " ");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int i = 0;
                while (i < f1538bv.length) {
                    if (f1538bv[i].equalsIgnoreCase(nextToken)) {
                        i++;
                        if (i < 10) {
                            stringBuffer.append("0");
                        }
                        stringBuffer.append(i);
                        if (stringTokenizer.hasMoreTokens()) {
                            String nextToken2 = stringTokenizer.nextToken();
                            if (nextToken2.length() == 1) {
                                stringBuffer.append("0");
                            }
                            stringBuffer.append(nextToken2);
                            nextToken2 = null;
                            while (stringTokenizer.hasMoreTokens()) {
                                nextToken2 = stringTokenizer.nextToken();
                            }
                            if (nextToken2 != null && nextToken2.length() == 4) {
                                stringBuffer.insert(0, nextToken2);
                            }
                        }
                    } else {
                        i++;
                    }
                }
            }
        }
        if (stringBuffer.length() != 8) {
            C0633at.m1465i("Get Fingerprint Date wrong, fingerprint = " + str + ", date = " + stringBuffer.toString());
        }
        return stringBuffer.toString();
    }

    private static int parseInt(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    /* renamed from: t */
    public static String m1424t() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        stringBuilder.append("<root>");
        stringBuilder.append("<prop>");
        stringBuilder.append("<ro.build.id>");
        stringBuilder.append(Build.ID);
        stringBuilder.append("</ro.build.id>");
        stringBuilder.append("<ro.build.display.id>");
        stringBuilder.append(Build.DISPLAY);
        stringBuilder.append("</ro.build.display.id>");
        stringBuilder.append("<ro.product.model>");
        stringBuilder.append(Build.MODEL);
        stringBuilder.append("</ro.product.model>");
        stringBuilder.append("<ro.build.version.release>");
        stringBuilder.append(VERSION.RELEASE);
        stringBuilder.append("</ro.build.version.release>");
        stringBuilder.append("<ro.build.version.sdk>");
        stringBuilder.append(VERSION.SDK);
        stringBuilder.append("</ro.build.version.sdk>");
        stringBuilder.append("<ro.product.manufacturer>");
        stringBuilder.append(Build.MANUFACTURER);
        stringBuilder.append("</ro.product.manufacturer>");
        stringBuilder.append("<ro.product.brand>");
        stringBuilder.append(Build.BRAND);
        stringBuilder.append("</ro.product.brand>");
        stringBuilder.append("<ro.product.name>");
        stringBuilder.append(Build.PRODUCT);
        stringBuilder.append("</ro.product.name>");
        stringBuilder.append("<ro.product.cpu.abi>");
        C0633at.m1464h("Build.CPU_ABI = " + Build.CPU_ABI);
        stringBuilder.append(C0628ar.m1453q("ro.product.cpu.abi"));
        stringBuilder.append("</ro.product.cpu.abi>");
        stringBuilder.append("<ro.product.cpu.abi2>");
        C0633at.m1464h("Build.CPU_ABI2 = " + Build.CPU_ABI2);
        stringBuilder.append(C0628ar.m1453q("ro.product.cpu.abi2"));
        stringBuilder.append("</ro.product.cpu.abi2>");
        stringBuilder.append("<ro.product.device>");
        stringBuilder.append(Build.DEVICE);
        stringBuilder.append("</ro.product.device>");
        stringBuilder.append("<ro.product.board>");
        stringBuilder.append(Build.BOARD);
        stringBuilder.append("</ro.product.board>");
        stringBuilder.append("<ro.build.version.codename>");
        stringBuilder.append(VERSION.CODENAME);
        stringBuilder.append("</ro.build.version.codename>");
        stringBuilder.append("<ro.build.fingerprint>");
        stringBuilder.append(C0628ar.m1450E());
        stringBuilder.append("</ro.build.fingerprint>");
        stringBuilder.append("<linux.version>");
        String F = C0628ar.m1451F();
        stringBuilder.append(F);
        stringBuilder.append("</linux.version>");
        stringBuilder.append("<ro.build.hidden_ver>");
        stringBuilder.append(C0629as.get("ro.build.hidden_ver"));
        stringBuilder.append("</ro.build.hidden_ver>");
        stringBuilder.append("<gsm.version.baseband>");
        stringBuilder.append(C0629as.get("gsm.version.baseband"));
        stringBuilder.append("</gsm.version.baseband>");
        stringBuilder.append("<ro.serialno>");
        stringBuilder.append(C0629as.get("ro.serialno"));
        stringBuilder.append("</ro.serialno>");
        stringBuilder.append("<ro.mediatek.platform>");
        stringBuilder.append(C0629as.get("ro.mediatek.platform"));
        stringBuilder.append("</ro.mediatek.platform>");
        stringBuilder.append("<ro.product.real_model>");
        String str = C0629as.get("ro.product.real_model");
        if (str == null || "".equals(str.trim())) {
            str = C0629as.get("ro.product.model");
            C0633at.m1467s("read_model is null, model = " + str);
        }
        stringBuilder.append(str);
        stringBuilder.append("</ro.product.real_model>");
        stringBuilder.append("<ro.board.platform>");
        stringBuilder.append(C0629as.get("ro.board.platform"));
        stringBuilder.append("</ro.board.platform>");
        stringBuilder.append("<ro.hardware>");
        stringBuilder.append(C0629as.get("ro.hardware"));
        stringBuilder.append("</ro.hardware>");
        stringBuilder.append("<ro.product.brand.replace>");
        stringBuilder.append(C0629as.get("ro.product.brand.replace"));
        stringBuilder.append("</ro.product.brand.replace>");
        stringBuilder.append("<ro.product.model.replace>");
        stringBuilder.append(C0629as.get("ro.product.model.replace"));
        stringBuilder.append("</ro.product.model.replace>");
        stringBuilder.append("<linux.version.date>");
        stringBuilder.append(C0623am.m1423m(F));
        stringBuilder.append("</linux.version.date>");
        stringBuilder.append("</prop>");
        stringBuilder.append("<device>");
        stringBuilder.append("</device>");
        stringBuilder.append("</root>\r\n");
        return stringBuilder.toString();
    }
}
