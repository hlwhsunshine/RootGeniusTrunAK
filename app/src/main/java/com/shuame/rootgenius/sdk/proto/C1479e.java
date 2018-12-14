package com.shuame.rootgenius.sdk.proto;

import android.util.Xml;
import com.shuame.rootgenius.sdk.C1473h;
import com.shuame.rootgenius.sdk.RgsdkConfig;
import com.shuame.rootgenius.sdk.proto.ProtoData.RootResult;
import com.shuame.rootgenius.sdk.proto.ProtoData.Tried;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.shuame.rootgenius.sdk.proto.e */
public class C1479e extends ProtoBase {
    /* renamed from: a */
    private static C1479e f4077a = new C1479e();

    private C1479e() {
    }

    /* renamed from: a */
    public static C1479e m4121a() {
        return f4077a;
    }

    /* renamed from: c */
    private static String m4122c(RootResult rootResult, Map map) {
        Writer stringWriter = new StringWriter();
        XmlSerializer newSerializer = Xml.newSerializer();
        try {
            newSerializer.setOutput(stringWriter);
            newSerializer.startDocument(null, Boolean.valueOf(true));
            newSerializer.startTag(null, "report");
            ProtoEncoding.addElement(newSerializer, "version_name", RgsdkConfig.sChVersionName);
            ProtoEncoding.addElement(newSerializer, "version_code", "84");
            ProtoEncoding.addElement(newSerializer, "mac_address", rootResult.phoneId.mac);
            ProtoEncoding.addElement(newSerializer, "imei", rootResult.phoneId.phimei);
            ProtoEncoding.addElement(newSerializer, "imsi", rootResult.phoneId.imsi);
            ProtoEncoding.addElement(newSerializer, "qimei", rootResult.phoneId.qimei);
            ProtoEncoding.addElement(newSerializer, "adb_device", rootResult.phoneInfo.adb.serial);
            ProtoEncoding.addElement(newSerializer, "rid", rootResult.phoneId.rid);
            ProtoEncoding.addElement(newSerializer, "package_name", rootResult.phoneId.packageName);
            ProtoEncoding.addElement(newSerializer, "product_id", rootResult.phoneInfo.productId);
            ProtoEncoding.addElement(newSerializer, "ro_product_model", rootResult.phoneInfo.productModel);
            ProtoEncoding.addElement(newSerializer, "cpu_hardware", rootResult.phoneInfo.hardware);
            ProtoEncoding.addElement(newSerializer, "kernel_version", rootResult.phoneInfo.kernel);
            ProtoEncoding.addElement(newSerializer, "android_version", rootResult.phoneInfo.androidVersion);
            ProtoEncoding.addElement(newSerializer, "ro_build_id", rootResult.phoneInfo.buildId);
            ProtoEncoding.addElement(newSerializer, "flag", String.valueOf(rootResult.flag));
            ProtoEncoding.addElement(newSerializer, "ro_product_device", rootResult.phoneInfo.productDevice);
            ProtoEncoding.addElement(newSerializer, "ro_product_board", rootResult.phoneInfo.productBoard);
            ProtoEncoding.addElement(newSerializer, "ro_product_brand", rootResult.phoneInfo.productBrand);
            ProtoEncoding.addElement(newSerializer, "ro_product_manufacturer", rootResult.phoneInfo.productManufacturer);
            ProtoEncoding.addElement(newSerializer, "ro_product_model", rootResult.phoneInfo.productModel);
            ProtoEncoding.addElement(newSerializer, "ro_hardware", rootResult.phoneInfo.phoneHardware);
            ProtoEncoding.addElement(newSerializer, "ro_build_description", rootResult.phoneInfo.buildDescription);
            ProtoEncoding.addElement(newSerializer, "ro_build_version_sdk", rootResult.phoneInfo.buildVersionSdk);
            ProtoEncoding.addElement(newSerializer, "ro_build_fingerprint", rootResult.phoneInfo.buildFingerPrint);
            ProtoEncoding.addElement(newSerializer, "VID", rootResult.phoneInfo.adb.vid);
            ProtoEncoding.addElement(newSerializer, "PID", rootResult.phoneInfo.adb.pid);
            ProtoEncoding.addElement(newSerializer, "PROT", rootResult.phoneInfo.adb.prot);
            ProtoEncoding.addElement(newSerializer, "SN", rootResult.phoneInfo.adb.serial);
            ProtoEncoding.addElement(newSerializer, "time_used", String.valueOf(rootResult.totalTimeUsed));
            ProtoEncoding.addElement(newSerializer, "rooted", String.valueOf(rootResult.triedSolutions.rooted));
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= rootResult.triedSolutions.triedList.size()) {
                    break;
                }
                Tried tried = (Tried) rootResult.triedSolutions.triedList.get(i2);
                newSerializer.startTag(null, "tried");
                ProtoEncoding.addElement(newSerializer, "id", String.valueOf(tried.f4069id));
                ProtoEncoding.addElement(newSerializer, "result", String.valueOf(tried.result));
                if (tried.description.length() > 4096) {
                    tried.description = tried.description.substring(tried.description.length() - 4096);
                }
                ProtoEncoding.addElement(newSerializer, "desc", tried.description);
                ProtoEncoding.addElement(newSerializer, "time_used", String.valueOf(tried.timeUsed));
                newSerializer.endTag(null, "tried");
                i = i2 + 1;
            }
            if (map != null) {
                newSerializer.startTag(null, "su");
                for (String str : map.keySet()) {
                    ProtoEncoding.addElement(newSerializer, str, (String) map.get(str));
                }
                newSerializer.endTag(null, "su");
            }
            newSerializer.endTag(null, "report");
            newSerializer.endDocument();
            newSerializer.flush();
            try {
                stringWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            C1473h.m4106e(C1479e.class.getSimpleName(), e2.toString());
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

    public void OnResponse(int i, String str) {
    }

    /* renamed from: a */
    public final void mo7293a(RootResult rootResult, Map map) {
        asyncPosReq(C1479e.m4122c(rootResult, map));
    }

    /* renamed from: b */
    public final int mo7294b(RootResult rootResult, Map map) {
        return postReq(C1479e.m4122c(rootResult, map));
    }

    public String getServant() {
        return getServant(true, "/root/report");
    }
}
