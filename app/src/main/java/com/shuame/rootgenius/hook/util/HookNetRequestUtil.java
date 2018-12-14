package com.shuame.rootgenius.hook.util;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Xml;
import com.shuame.mobile.sdk.impl.utils.ShellUtils;
import com.shuame.p076b.p077a.C1140o;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.util.C1396i;
import com.shuame.rootgenius.common.util.C1402l;
import com.shuame.rootgenius.common.util.C1402l.C1400b;
import com.shuame.rootgenius.common.util.C1402l.C1401c;
import com.shuame.rootgenius.common.util.C1411s;
import com.shuame.rootgenius.common.util.C1412t;
import com.shuame.rootgenius.common.util.NetworkUtils;
import com.shuame.rootgenius.hook.HookModule;
import com.shuame.rootgenius.sdk.RgsdkConfig;
import com.shuame.rootgenius.sdk.RootGenius;
import com.shuame.rootgenius.sdk.proto.ProtoData.DeviceSolution;
import com.shuame.rootgenius.sdk.proto.ProtoEncoding;
import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public class HookNetRequestUtil {
    private static final String TAG = HookNetRequestUtil.class.getSimpleName();
    private static HookNetRequestUtil sInstance;

    static class HttpReq {
        public String productId;
        public String romType;
        public int sdkLevel;
        public String sdkVersion;
        public String versionCode;
        public String versionName;

        HttpReq() {
        }
    }

    private HookNetRequestUtil() {
    }

    private String decode(String str) {
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        String str2 = null;
        Object obj = null;
        int eventType = newPullParser.getEventType();
        while (obj == null && eventType != 1) {
            switch (eventType) {
                case 2:
                    if (!newPullParser.getName().equals("hook")) {
                        break;
                    }
                    str2 = newPullParser.nextText();
                    int obj2 = 1;
                    break;
                default:
                    break;
            }
            eventType = newPullParser.next();
        }
        return str2;
    }

    private String encode(HttpReq httpReq) {
        Writer stringWriter = new StringWriter();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.startDocument(null, Boolean.valueOf(true));
        newSerializer.startTag(null, "param");
        ProtoEncoding.addElement(newSerializer, "version_code", httpReq.versionCode);
        ProtoEncoding.addElement(newSerializer, "version_name", httpReq.versionName);
        ProtoEncoding.addElement(newSerializer, "product_id", httpReq.productId);
        ProtoEncoding.addElement(newSerializer, "android_version", httpReq.sdkVersion);
        ProtoEncoding.addElement(newSerializer, "android_sdk", httpReq.sdkLevel);
        ProtoEncoding.addElement(newSerializer, "rom_type", httpReq.romType);
        newSerializer.endTag(null, "param");
        newSerializer.endDocument();
        newSerializer.flush();
        stringWriter.close();
        return stringWriter.toString();
    }

    private HttpReq getHttpReq() {
        HttpReq httpReq = new HttpReq();
        C1323b.m3688a();
        httpReq.productId = C1323b.m3707l();
        C1140o.m3287a().mo6730a(HookModule.getContext());
        httpReq.romType = (String) C1140o.m3287a().mo6731b().get("rombrand");
        httpReq.sdkLevel = VERSION.SDK_INT;
        httpReq.sdkVersion = VERSION.RELEASE;
        httpReq.versionCode = String.valueOf(C1323b.m3711p());
        httpReq.versionName = RgsdkConfig.sChVersionName;
        return httpReq;
    }

    public static HookNetRequestUtil getInstance() {
        if (sInstance == null) {
            synchronized (HookNetRequestUtil.class) {
                if (sInstance == null) {
                    sInstance = new HookNetRequestUtil();
                }
            }
        }
        return sInstance;
    }

    private String initProductId() {
        C1323b.m3688a();
        String l = C1323b.m3707l();
        if (!TextUtils.isEmpty(l)) {
            return l;
        }
        try {
            DeviceSolution preQueryRoot = RootGenius.preQueryRoot();
            if (preQueryRoot == null || TextUtils.isEmpty(preQueryRoot.productId)) {
                return l;
            }
            l = preQueryRoot.productId;
            C1323b.m3688a();
            C1323b.m3689a(l);
            return l;
        } catch (Exception e) {
            e.printStackTrace();
            return l;
        }
    }

    private void saveTestLog() {
        Object a = C1411s.m3923a(true);
        if (!TextUtils.isEmpty(a)) {
            String str = a + "/hook_conf.log";
            if (!new File(str).exists()) {
                C1323b.m3688a();
                if (!TextUtils.isEmpty(C1323b.m3707l()) || !TextUtils.isEmpty(initProductId())) {
                    HttpReq httpReq = getHttpReq();
                    try {
                        FileWriter fileWriter = new FileWriter(str);
                        fileWriter.write("productId:" + httpReq.productId + "\n");
                        fileWriter.write("romType:" + httpReq.romType + "\n");
                        fileWriter.write("sdkLevel:" + httpReq.sdkLevel + "\n");
                        fileWriter.write("sdkVersion:" + httpReq.sdkVersion + "\n");
                        fileWriter.write("versionCode:" + httpReq.versionCode + "\n");
                        fileWriter.write("versionName:" + httpReq.versionName + "\n");
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String getServant() {
        String str = "http://api1.rootjl.%s/v2/m/root/cfg2?versionName=%s&versionCode=%s";
        Object[] objArr = new Object[3];
        objArr[0] = C1412t.f3902a ? "org" : "com";
        objArr[1] = C1323b.m3709n();
        objArr[2] = Integer.valueOf(C1323b.m3711p());
        return String.format(str, objArr);
    }

    public boolean isAllowHook() {
        if (C1412t.f3902a) {
            saveTestLog();
        }
        if (!ShellUtils.isRooted() || !NetworkUtils.m3852b() || TextUtils.isEmpty(initProductId())) {
            return false;
        }
        try {
            byte[] bytes = encode(getHttpReq()).getBytes("UTF-8");
            C1396i.m3893a(bytes, C1396i.f3874a);
            C1400b c1400b = new C1400b();
            c1400b.f3880a = getServant();
            c1400b.f3881b = bytes;
            c1400b.f3883d = 20000;
            c1400b.f3884e = 20000;
            new StringBuilder("url:").append(c1400b.f3880a);
            C1401c a = C1402l.m3903a(c1400b);
            new StringBuilder("response.statusCode:").append(a.f3885a);
            if (a.f3885a != 200 || a.f3886b.length <= 0) {
                return false;
            }
            C1396i.m3895b(a.f3886b, C1396i.f3874a);
            Object decode = decode(new String(a.f3886b, "UTF-8"));
            return !TextUtils.isEmpty(decode) ? Boolean.parseBoolean(decode) : false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
