package com.shuame.rootgenius.sdk.proto;

import android.util.Xml;
import com.shuame.rootgenius.sdk.C1473h;
import com.shuame.rootgenius.sdk.RgsdkConfig;
import com.shuame.rootgenius.sdk.proto.ProtoData.UnrootResult;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.shuame.rootgenius.sdk.proto.f */
public class C1480f extends ProtoBase {
    /* renamed from: a */
    private static C1480f f4078a = new C1480f();

    private C1480f() {
    }

    /* renamed from: a */
    public static C1480f m4125a() {
        return f4078a;
    }

    /* renamed from: b */
    private static String m4126b(UnrootResult unrootResult) {
        Writer stringWriter = new StringWriter();
        XmlSerializer newSerializer = Xml.newSerializer();
        try {
            newSerializer.setOutput(stringWriter);
            newSerializer.startDocument(null, Boolean.valueOf(true));
            newSerializer.startTag(null, "report");
            ProtoEncoding.addElement(newSerializer, "version_name", RgsdkConfig.sChVersionName);
            ProtoEncoding.addElement(newSerializer, "version_code", "84");
            ProtoEncoding.addElement(newSerializer, "mac_address", unrootResult.phoneId.mac);
            ProtoEncoding.addElement(newSerializer, "imei", unrootResult.phoneId.phimei);
            ProtoEncoding.addElement(newSerializer, "imsi", unrootResult.phoneId.imsi);
            ProtoEncoding.addElement(newSerializer, "qimei", unrootResult.phoneId.qimei);
            ProtoEncoding.addElement(newSerializer, "adb_device", unrootResult.phoneId.phsn);
            ProtoEncoding.addElement(newSerializer, "rid", unrootResult.phoneId.rid);
            ProtoEncoding.addElement(newSerializer, "result", String.valueOf(unrootResult.result));
            ProtoEncoding.addElement(newSerializer, "description", unrootResult.description);
            newSerializer.endTag(null, "report");
            newSerializer.endDocument();
            newSerializer.flush();
            try {
                stringWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            C1473h.m4106e(C1480f.class.getSimpleName(), e2.toString());
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
    public final void mo7295a(UnrootResult unrootResult) {
        asyncPosReq(C1480f.m4126b(unrootResult));
    }

    public String getServant() {
        return getServant(true, "/root/remove");
    }
}
