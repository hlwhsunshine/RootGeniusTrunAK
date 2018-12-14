package com.shuame.rootgenius.service;

import android.text.TextUtils;
import android.util.Xml;
import com.shuame.rootgenius.C1446g;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.common.util.C1389b;
import com.shuame.rootgenius.common.util.C1412t;
import com.shuame.rootgenius.pojo.C1460b;
import com.shuame.rootgenius.pojo.C1461c;
import com.shuame.rootgenius.sdk.CommUtils;
import com.shuame.rootgenius.sdk.RootGenius;
import com.shuame.rootgenius.sdk.proto.ProtoEncoding;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.shuame.rootgenius.service.g */
public class C1489g {
    /* renamed from: a */
    private static final String f4099a = C1489g.class.getSimpleName();
    /* renamed from: b */
    private static C1489g f4100b = new C1489g();
    /* renamed from: c */
    private C1460b f4101c = new C1460b();
    /* renamed from: d */
    private boolean f4102d;
    /* renamed from: e */
    private boolean f4103e;

    private C1489g() {
    }

    /* renamed from: a */
    public static C1489g m4151a() {
        return f4100b;
    }

    /* renamed from: a */
    static /* synthetic */ void m4152a(C1489g c1489g, String str) {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new StringReader(str));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 2:
                        String name = newPullParser.getName();
                        if (!name.equals("update")) {
                            Object obj = null;
                            if (!name.equals("shuame_mobile")) {
                                obj = newPullParser.nextText();
                            }
                            if (!name.equals("version_code")) {
                                if (!name.equals("version_name")) {
                                    if (!name.equals("url")) {
                                        if (!name.equals("size")) {
                                            if (!name.equals("md5")) {
                                                if (!name.equals("kinguser_url")) {
                                                    if (!name.equals("kinguser_md5")) {
                                                        if (!name.equals("su_package_names")) {
                                                            if (!name.equals("shuame_mobile")) {
                                                                break;
                                                            }
                                                            C1489g.m4153a(newPullParser);
                                                            break;
                                                        }
                                                        C1446g.m4003a();
                                                        if (!TextUtils.isEmpty(obj)) {
                                                            String replaceAll = obj.replaceAll(" ", "");
                                                            if (!TextUtils.isEmpty(replaceAll)) {
                                                                if (!replaceAll.equals(C1446g.m4019m())) {
                                                                    RootGenius.setSuSuite(C1446g.m4020n());
                                                                }
                                                                C1323b.m3688a().mo6995a("auth_component_package_names_data", replaceAll);
                                                                break;
                                                            }
                                                            break;
                                                        }
                                                        break;
                                                    }
                                                    c1489g.f4101c.f4013h = obj;
                                                    break;
                                                }
                                                c1489g.f4101c.f4012g = obj;
                                                break;
                                            }
                                            c1489g.f4101c.f4011f = obj;
                                            break;
                                        }
                                        c1489g.f4101c.f4010e = CommUtils.parseInt(obj);
                                        break;
                                    }
                                    c1489g.f4101c.f4009d = obj;
                                    break;
                                }
                                c1489g.f4101c.f4008c = obj;
                                break;
                            }
                            c1489g.f4101c.f4007b = CommUtils.parseInt(obj);
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m4153a(XmlPullParser xmlPullParser) {
        C1461c c1461c = new C1461c();
        boolean z = false;
        xmlPullParser.getEventType();
        while (!z) {
            switch (xmlPullParser.next()) {
                case 2:
                    String nextText = xmlPullParser.nextText();
                    String name = xmlPullParser.getName();
                    if (!name.equals("url")) {
                        if (!name.equals("md5")) {
                            if (!name.equals("size")) {
                                if (!name.equals("version_code")) {
                                    if (!name.equals("version_name")) {
                                        break;
                                    }
                                    c1461c.f4019f = nextText;
                                    break;
                                }
                                c1461c.f4018e = CommUtils.parseInt(nextText);
                                break;
                            }
                            c1461c.f4016c = CommUtils.parseInt(nextText);
                            break;
                        }
                        c1461c.f4017d = nextText;
                        break;
                    }
                    c1461c.f4015b = nextText;
                    break;
                case 3:
                    if (!xmlPullParser.getName().equals("shuame_mobile")) {
                        break;
                    }
                    c1461c.f4014a = true;
                    z = true;
                    break;
                default:
                    break;
            }
        }
        C1491i.m4161a().mo7315a(c1461c);
    }

    /* renamed from: c */
    public static String m4155c() {
        Writer stringWriter = new StringWriter();
        XmlSerializer newSerializer = Xml.newSerializer();
        String wifiMacAddr = CommUtils.getWifiMacAddr(RootGeniusApp.m3523a());
        String str = "";
        String str2 = "android";
        String e = C1387ad.m3877e(RootGeniusApp.m3523a());
        String f = C1387ad.m3878f(RootGeniusApp.m3523a());
        String a = C1387ad.m3865a(true);
        try {
            newSerializer.setOutput(stringWriter);
            newSerializer.startDocument(null, Boolean.valueOf(true));
            newSerializer.startTag(null, "startup");
            ProtoEncoding.addElement(newSerializer, "mac_address", wifiMacAddr);
            ProtoEncoding.addElement(newSerializer, "os_name", str2);
            ProtoEncoding.addElement(newSerializer, "os_arch", str);
            wifiMacAddr = "imei";
            if (e == null) {
                e = "";
            }
            ProtoEncoding.addElement(newSerializer, wifiMacAddr, e);
            e = "imsi";
            if (f == null) {
                f = "";
            }
            ProtoEncoding.addElement(newSerializer, e, f);
            f = "qimei";
            if (a == null) {
                a = "";
            }
            ProtoEncoding.addElement(newSerializer, f, a);
            newSerializer.endTag(null, "startup");
            newSerializer.endDocument();
            newSerializer.flush();
            try {
                stringWriter.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            try {
                stringWriter.close();
            } catch (IOException e22) {
                e22.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                stringWriter.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
        return stringWriter.toString();
    }

    /* renamed from: d */
    public static String m4157d() {
        String str = "http://api1.rootjl.%s/v2/m/root/update?versionName=%s&versionCode=%s";
        Object[] objArr = new Object[3];
        objArr[0] = C1412t.f3902a ? "org" : "com";
        objArr[1] = C1323b.m3709n();
        objArr[2] = Integer.valueOf(C1323b.m3711p());
        return String.format(str, objArr);
    }

    /* renamed from: a */
    public final void mo7312a(boolean z) {
        this.f4102d = z;
        C1389b.m3884a();
        if (C1389b.m3887b(z) && !this.f4103e) {
            this.f4103e = true;
            new C1490h(this).start();
        }
    }

    /* renamed from: b */
    public final C1460b mo7313b() {
        return this.f4101c;
    }
}
