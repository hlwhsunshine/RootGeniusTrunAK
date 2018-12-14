package com.shuame.rootgenius.sdk.proto;

import com.shuame.rootgenius.sdk.C1473h;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlSerializer;

public class ProtoEncoding {
    public static String FilterDisableXmlChar(String str) {
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < 0 || charAt > 8) && ((charAt < 11 || charAt > 12) && (charAt < 14 || charAt > 31))) {
                str2 = str2 + charAt;
            }
        }
        return str2;
    }

    public static void addElement(XmlSerializer xmlSerializer, String str, String str2) {
        addElement(xmlSerializer, str, str2, null);
    }

    public static void addElement(XmlSerializer xmlSerializer, String str, String str2, HashMap hashMap) {
        if (str != null && str2 != null) {
            try {
                xmlSerializer.startTag(null, str);
                if (!(hashMap == null || hashMap.isEmpty())) {
                    for (Entry entry : hashMap.entrySet()) {
                        xmlSerializer.attribute(null, (String) entry.getKey(), (String) entry.getValue());
                    }
                }
                xmlSerializer.text(FilterDisableXmlChar(str2));
                xmlSerializer.endTag(null, str);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            } catch (Exception e4) {
                C1473h.m4106e(ProtoEncoding.class.getSimpleName(), e4.toString());
            }
        }
    }
}
