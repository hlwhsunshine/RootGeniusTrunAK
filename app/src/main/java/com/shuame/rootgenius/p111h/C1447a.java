package com.shuame.rootgenius.p111h;

import android.util.Xml;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.sdk.proto.ProtoBase;
import com.shuame.rootgenius.sdk.proto.ProtoData.ActExit;
import com.shuame.rootgenius.sdk.proto.ProtoEncoding;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.shuame.rootgenius.h.a */
public class C1447a extends ProtoBase {
    /* renamed from: b */
    private static String m4022b(ActExit actExit) {
        Writer stringWriter = new StringWriter();
        XmlSerializer newSerializer = Xml.newSerializer();
        String e = C1387ad.m3877e(RootGeniusApp.m3523a());
        String f = C1387ad.m3878f(RootGeniusApp.m3523a());
        String a = C1387ad.m3865a(true);
        try {
            newSerializer.setOutput(stringWriter);
            newSerializer.startDocument(null, Boolean.valueOf(true));
            newSerializer.startTag(null, "actions");
            newSerializer.startTag(null, "action");
            ProtoEncoding.addElement(newSerializer, "mac_address", actExit.mac);
            ProtoEncoding.addElement(newSerializer, "code", String.valueOf(actExit.code));
            String str = "imei";
            if (e == null) {
                e = "";
            }
            ProtoEncoding.addElement(newSerializer, str, e);
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
            newSerializer.endTag(null, "action");
            newSerializer.endTag(null, "actions");
            newSerializer.endDocument();
            newSerializer.flush();
            try {
                stringWriter.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            C1447a.class.getSimpleName();
            e3.toString();
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

    public void OnResponse(int i, String str) {
    }

    /* renamed from: a */
    public final void mo7186a(ActExit actExit) {
        asyncPosReq(C1447a.m4022b(actExit));
    }

    public String getServant() {
        return getServant(true, "/root/actions");
    }
}
