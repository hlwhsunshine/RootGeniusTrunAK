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
            ProtoEncoding.addElement(newSerializer, "version_name", RgsdkConfig.sChVersionName);//版本名称 general_mobile
            ProtoEncoding.addElement(newSerializer, "version_code", "84");//版本号
            ProtoEncoding.addElement(newSerializer, "product_id", rootingDev.phoneInfo.productId);//app产品ID，string类型
            ProtoEncoding.addElement(newSerializer, "VID", rootingDev.phoneInfo.adb.vid);//vid 供应商ID
            ProtoEncoding.addElement(newSerializer, "PID", rootingDev.phoneInfo.adb.pid);//pid 手机产品ID
            ProtoEncoding.addElement(newSerializer, "PROT", rootingDev.phoneInfo.adb.prot); //不清楚意思，可以为空
            ProtoEncoding.addElement(newSerializer, "SN", rootingDev.phoneInfo.adb.serial);//手机序列号
            ProtoEncoding.addElement(newSerializer, "adb_device", rootingDev.phoneInfo.adb.serial);//手机序列号
            ProtoEncoding.addElement(newSerializer, "imei", rootingDev.phoneId.phimei);//imei
            ProtoEncoding.addElement(newSerializer, "imsi", rootingDev.phoneId.imsi);//imsi SIM卡的电子串号
            ProtoEncoding.addElement(newSerializer, "qimei", rootingDev.phoneId.qimei);//可以为空
            ProtoEncoding.addElement(newSerializer, "rid", rootingDev.phoneId.rid);//自己生成的
            ProtoEncoding.addElement(newSerializer, "phone_id", rootingDev.phoneInfo.phoneId);//代码里自己按规则生成的，不用管
            ProtoEncoding.addElement(newSerializer, "mac_address", rootingDev.phoneId.mac);//mac地址
            ProtoEncoding.addElement(newSerializer, "package_name", rootingDev.phoneId.packageName);//包名
            ProtoEncoding.addElement(newSerializer, "ro_product_device", rootingDev.phoneInfo.productDevice);//手机代号  例如小米3和4 代号CANCRO
            ProtoEncoding.addElement(newSerializer, "ro_product_model", rootingDev.phoneInfo.productModel);//手机型号 例如MI 4LTE
            ProtoEncoding.addElement(newSerializer, "ro_hardware", rootingDev.phoneInfo.phoneHardware);//硬件  例如qcom
            ProtoEncoding.addElement(newSerializer, "ro_product_board", rootingDev.phoneInfo.productBoard);//芯片系列代号
            ProtoEncoding.addElement(newSerializer, "ro_product_brand", rootingDev.phoneInfo.productBrand);//手机品牌
            ProtoEncoding.addElement(newSerializer, "ro_product_manufacturer", rootingDev.phoneInfo.productManufacturer);//制造商
            ProtoEncoding.addElement(newSerializer, "ro_product_productid", rootingDev.phoneInfo.productId);//可以为空
            ProtoEncoding.addElement(newSerializer, "android_version", rootingDev.phoneInfo.androidVersion);//sdk的版本
            ProtoEncoding.addElement(newSerializer, "firmware_version", rootingDev.phoneInfo.buildId);//系统（固件）版本号 例如小米4 KTU84P
            ProtoEncoding.addElement(newSerializer, "cpu_hardware", rootingDev.phoneInfo.hardware);//cpu具体的型号
            ProtoEncoding.addElement(newSerializer, "core_version", rootingDev.phoneInfo.kernel);//内核
            ProtoEncoding.addElement(newSerializer, "region", rootingDev.phoneInfo.region);//地区  可以为空
            ProtoEncoding.addElement(newSerializer, "ro_build_description", rootingDev.phoneInfo.buildDescription);//手机具体描述 例如 cancro-user 4.4.4 KTU84P 4.9.18 test-keys
            ProtoEncoding.addElement(newSerializer, "ro_build_version_sdk", rootingDev.phoneInfo.buildVersionSdk);//sdk的版本号  例如19
            ProtoEncoding.addElement(newSerializer, "ro_build_fingerprint", rootingDev.phoneInfo.buildFingerPrint);//指纹  例如Xiaomi/cancro/cancro:4.4.4/KTU84P/4.9.18:user/test-keys
            HashMap hashMap = new HashMap();
            hashMap.put("cores", String.valueOf(rootingDev.phoneInfo.cpuInfo.cores));//核心数
            hashMap.put("arch", rootingDev.phoneInfo.cpuInfo.arch);//cpu架构
            hashMap.put("hardware", rootingDev.phoneInfo.cpuInfo.hardware);//cpu型号
            ProtoEncoding.addElement(newSerializer, "cpu", rootingDev.phoneInfo.cpuInfo.processor, hashMap);//处理器信息
            ProtoEncoding.addElement(newSerializer, "resolution", rootingDev.phoneInfo.resolution);//分辨率
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

    /**
     *请求网络的结果会回调到这里
     * @param i    ResponseCode
     * @param str   result
     */
    public void OnResponse(int i, String str) {
        if (this.f4073b != null) {
            this.f4073b.result = i;
            this.f4073b.solus.clear();
            if (ProtoBase.isSuccess(i)) {
                C1473h.m4103b(this.f4072a, "response:" + str);
                C1476b.m4114a(str, this.f4073b);//把数据写入到queryRootingResult中
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

    /**
     *
     * @param rootingDev 机型信息
     * @param queryRootingResult  root需要的一些信息
     */
    /* renamed from: a */
    public final void mo7290a(RootingDev rootingDev, QueryRootingResult queryRootingResult) {
        this.f4073b = queryRootingResult;
        postReq(C1476b.m4113a(rootingDev));
    }

    public String getServant() {
        return getServant(false, "/root/solution");
    }
}
