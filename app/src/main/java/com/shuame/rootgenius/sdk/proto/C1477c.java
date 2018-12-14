package com.shuame.rootgenius.sdk.proto;

import android.util.Xml;
import com.shuame.rootgenius.sdk.C1473h;
import com.shuame.rootgenius.sdk.CommUtils;
import com.shuame.rootgenius.sdk.RgsdkConfig;
import com.shuame.rootgenius.sdk.proto.ProtoData.ServerConf;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.shuame.rootgenius.sdk.proto.c */
public final class C1477c extends ProtoBase {
    /* renamed from: b */
    private static C1477c f4074b = new C1477c();
    /* renamed from: a */
    private ServerConf f4075a = null;

    private C1477c() {
    }

    /* renamed from: a */
    public static C1477c m4116a() {
        return f4074b;
    }

    /* renamed from: b */
    private static String m4117b() {
        Writer stringWriter = new StringWriter();
        XmlSerializer newSerializer = Xml.newSerializer();
        try {
            newSerializer.setOutput(stringWriter);
            newSerializer.startDocument(null, Boolean.valueOf(true));
            newSerializer.startTag(null, "param");
            ProtoEncoding.addElement(newSerializer, "version_name", RgsdkConfig.sChVersionName);
            ProtoEncoding.addElement(newSerializer, "version_code", "84");
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

    public final void OnResponse(int i, String str) {
        if (ProtoBase.isSuccess(i) && this.f4075a != null) {
            ServerConf serverConf = this.f4075a;
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                newPullParser.setInput(new StringReader(str));
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                    switch (eventType) {
                        case 2:
                            if (!newPullParser.getName().equals("config")) {
                                break;
                            }
                            serverConf.val = CommUtils.parseInt(newPullParser.nextText());
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
    }

    /* renamed from: a */
    public final void mo7291a(ServerConf serverConf) {
        this.f4075a = serverConf;
        asyncPosReq(C1477c.m4117b());
    }

    public final String getServant() {
        return getServant(false, "/root/cfg");
    }
}
