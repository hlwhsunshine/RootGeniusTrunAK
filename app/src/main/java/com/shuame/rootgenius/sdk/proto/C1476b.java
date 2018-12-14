package com.shuame.rootgenius.sdk.proto;

import android.util.Xml;
import com.shuame.rootgenius.sdk.C1473h;
import com.shuame.rootgenius.sdk.RgsdkConfig;
import com.shuame.rootgenius.sdk.proto.ProtoData.Asset;
import com.shuame.rootgenius.sdk.proto.ProtoData.QueryRootingResult;
import com.shuame.rootgenius.sdk.proto.ProtoData.RootSolution;
import com.shuame.rootgenius.sdk.proto.ProtoData.RootingDev;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.shuame.rootgenius.sdk.proto.b */
public class C1476b extends ProtoBase {
    /* renamed from: a */
    private String f4072a = C1476b.class.getSimpleName();
    /* renamed from: b */
    private QueryRootingResult f4073b = null;

    /* renamed from: a */
    private static Asset m4111a(XmlPullParser xmlPullParser, String str) {
        Asset asset = new Asset();
        Object obj = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                switch (eventType) {
                    case 2:
                        if (!xmlPullParser.getName().equals(str)) {
                            String nextText = xmlPullParser.nextText();
                            if (!xmlPullParser.getName().equals("url")) {
                                if (xmlPullParser.getName().equals("md5")) {
                                    asset.md5 = nextText;
                                    break;
                                }
                            }
                            asset.url = nextText;
                            break;
                        }
                        break;
                    case 3:
                        if (xmlPullParser.getName().equals(str)) {
                            int obj2 = 1;
                            break;
                        }
                        break;
                }
                if (obj2 != null) {
                    return asset;
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return asset;
    }

    /* renamed from: a */
    private static RootSolution m4112a(XmlPullParser xmlPullParser) {
        RootSolution rootSolution = new RootSolution();
        Object obj = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                switch (eventType) {
                    case 2:
                        if (!xmlPullParser.getName().equals("solution")) {
                            String nextText = xmlPullParser.nextText();
                            if (!xmlPullParser.getName().equals("root_id")) {
                                if (!xmlPullParser.getName().equals("url")) {
                                    if (!xmlPullParser.getName().equals("md5")) {
                                        if (!xmlPullParser.getName().equals("type")) {
                                            if (xmlPullParser.getName().equals("param")) {
                                                rootSolution.param = nextText;
                                                break;
                                            }
                                        }
                                        rootSolution.type = nextText;
                                        break;
                                    }
                                    rootSolution.md5 = nextText;
                                    break;
                                }
                                rootSolution.url = nextText;
                                break;
                            }
                            rootSolution.f4068id = Integer.parseInt(nextText, 10);
                            break;
                        }
                        break;
                    case 3:
                        if (xmlPullParser.getName().equals("solution")) {
                            int obj2 = 1;
                            break;
                        }
                        break;
                }
                if (obj2 != null) {
                    return rootSolution;
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return rootSolution;
    }

    /* renamed from: a */
    public static String m4113a(RootingDev rootingDev) {
        Writer stringWriter = new StringWriter();
        XmlSerializer newSerializer = Xml.newSerializer();
        try {
            newSerializer.setOutput(stringWriter);
            newSerializer.startDocument(null, Boolean.valueOf(true));
            newSerializer.startTag(null, "param");
            ProtoEncoding.addElement(newSerializer, "version_name", RgsdkConfig.sChVersionName);
            ProtoEncoding.addElement(newSerializer, "version_code", "84");
            ProtoEncoding.addElement(newSerializer, "product_id", rootingDev.phoneInfo.productId);
            ProtoEncoding.addElement(newSerializer, "VID", rootingDev.phoneInfo.adb.vid);
            ProtoEncoding.addElement(newSerializer, "PID", rootingDev.phoneInfo.adb.pid);
            ProtoEncoding.addElement(newSerializer, "PROT", rootingDev.phoneInfo.adb.prot);
            ProtoEncoding.addElement(newSerializer, "SN", rootingDev.phoneInfo.adb.serial);
            ProtoEncoding.addElement(newSerializer, "adb_device", rootingDev.phoneInfo.adb.serial);
            ProtoEncoding.addElement(newSerializer, "imei", rootingDev.phoneId.phimei);
            ProtoEncoding.addElement(newSerializer, "imsi", rootingDev.phoneId.imsi);
            ProtoEncoding.addElement(newSerializer, "qimei", rootingDev.phoneId.qimei);
            ProtoEncoding.addElement(newSerializer, "rid", rootingDev.phoneId.rid);
            ProtoEncoding.addElement(newSerializer, "phone_id", rootingDev.phoneInfo.phoneId);
            ProtoEncoding.addElement(newSerializer, "mac_address", rootingDev.phoneId.mac);
            ProtoEncoding.addElement(newSerializer, "package_name", rootingDev.phoneId.packageName);
            ProtoEncoding.addElement(newSerializer, "ro_product_device", rootingDev.phoneInfo.productDevice);
            ProtoEncoding.addElement(newSerializer, "ro_product_model", rootingDev.phoneInfo.productModel);
            ProtoEncoding.addElement(newSerializer, "ro_hardware", rootingDev.phoneInfo.phoneHardware);
            ProtoEncoding.addElement(newSerializer, "ro_product_board", rootingDev.phoneInfo.productBoard);
            ProtoEncoding.addElement(newSerializer, "ro_product_brand", rootingDev.phoneInfo.productBrand);
            ProtoEncoding.addElement(newSerializer, "ro_product_manufacturer", rootingDev.phoneInfo.productManufacturer);
            ProtoEncoding.addElement(newSerializer, "ro_product_productid", rootingDev.phoneInfo.productId);
            ProtoEncoding.addElement(newSerializer, "android_version", rootingDev.phoneInfo.androidVersion);
            ProtoEncoding.addElement(newSerializer, "firmware_version", rootingDev.phoneInfo.buildId);
            ProtoEncoding.addElement(newSerializer, "cpu_hardware", rootingDev.phoneInfo.hardware);
            ProtoEncoding.addElement(newSerializer, "core_version", rootingDev.phoneInfo.kernel);
            ProtoEncoding.addElement(newSerializer, "region", rootingDev.phoneInfo.region);
            ProtoEncoding.addElement(newSerializer, "ro_build_description", rootingDev.phoneInfo.buildDescription);
            ProtoEncoding.addElement(newSerializer, "ro_build_version_sdk", rootingDev.phoneInfo.buildVersionSdk);
            ProtoEncoding.addElement(newSerializer, "ro_build_fingerprint", rootingDev.phoneInfo.buildFingerPrint);
            HashMap hashMap = new HashMap();
            hashMap.put("cores", String.valueOf(rootingDev.phoneInfo.cpuInfo.cores));
            hashMap.put("arch", rootingDev.phoneInfo.cpuInfo.arch);
            hashMap.put("hardware", rootingDev.phoneInfo.cpuInfo.hardware);
            ProtoEncoding.addElement(newSerializer, "cpu", rootingDev.phoneInfo.cpuInfo.processor, hashMap);
            ProtoEncoding.addElement(newSerializer, "resolution", rootingDev.phoneInfo.resolution);
            newSerializer.endTag(null, "param");
            newSerializer.endDocument();
            newSerializer.flush();
            try {
                stringWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            C1473h.m4106e(C1476b.class.getSimpleName(), e2.toString());
            try {
                stringWriter.close();
            } catch (IOException e3) {
                e3.printStackTrace();
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

    /* renamed from: a */
    private static void m4114a(String str, QueryRootingResult queryRootingResult) {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new StringReader(str));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 2:
                        if (!newPullParser.getName().equals("solution")) {
                            if (!newPullParser.getName().equals("product_id")) {
                                if (!newPullParser.getName().equals("product_name")) {
                                    if (!newPullParser.getName().equals("superuser")) {
                                        if (!newPullParser.getName().equals("root_engine")) {
                                            if (!newPullParser.getName().equals("neo")) {
                                                break;
                                            }
                                            queryRootingResult.neo = newPullParser.nextText();
                                            break;
                                        }
                                        queryRootingResult.rootEngine = C1476b.m4111a(newPullParser, "root_engine");
                                        break;
                                    }
                                    queryRootingResult.f4067su = C1476b.m4111a(newPullParser, "superuser");
                                    break;
                                }
                                queryRootingResult.productName = newPullParser.nextText();
                                break;
                            }
                            queryRootingResult.productId = newPullParser.nextText();
                            break;
                        }
                        queryRootingResult.solus.add(C1476b.m4112a(newPullParser));
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

    public void OnResponse(int i, String str) {
        if (this.f4073b != null) {
            this.f4073b.result = i;
            this.f4073b.solus.clear();
            if (ProtoBase.isSuccess(i)) {
                C1473h.m4103b(this.f4072a, "response:" + str);
                C1476b.m4114a(str, this.f4073b);
                if (this.f4073b.f4067su == null || this.f4073b.f4067su.url == null || this.f4073b.f4067su.md5 == null) {
                    C1473h.m4103b(this.f4072a, "root_engine empty");
                } else {
                    C1473h.m4103b(this.f4072a, "superuser:" + this.f4073b.f4067su.url + " md5:" + this.f4073b.f4067su.md5);
                }
                if (this.f4073b.rootEngine == null || this.f4073b.rootEngine.url == null || this.f4073b.rootEngine.md5 == null) {
                    C1473h.m4103b(this.f4072a, "root_engine empty");
                } else {
                    C1473h.m4103b(this.f4072a, "root_engine" + this.f4073b.rootEngine.url + " md5:" + this.f4073b.rootEngine.md5);
                }
                C1473h.m4103b(this.f4072a, "neo:" + (this.f4073b.neo != null ? this.f4073b.neo : "empty"));
            }
        }
    }

    /* renamed from: a */
    public final void mo7290a(RootingDev rootingDev, QueryRootingResult queryRootingResult) {
        this.f4073b = queryRootingResult;
        postReq(C1476b.m4113a(rootingDev));
    }

    public String getServant() {
        return getServant(false, "/root/solution");
    }
}
