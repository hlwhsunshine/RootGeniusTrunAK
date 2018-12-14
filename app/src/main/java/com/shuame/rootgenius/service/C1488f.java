package com.shuame.rootgenius.service;

import android.content.Intent;
import android.content.p013pm.PackageInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Xml;
import com.shuame.rootgenius.C1446g;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.util.C1389b;
import com.shuame.rootgenius.common.util.C1396i;
import com.shuame.rootgenius.common.util.C1397j;
import com.shuame.rootgenius.common.util.C1402l;
import com.shuame.rootgenius.common.util.C1402l.C1400b;
import com.shuame.rootgenius.common.util.C1402l.C1401c;
import com.shuame.rootgenius.common.util.C1406p;
import com.shuame.rootgenius.common.util.C1412t;
import com.shuame.rootgenius.common.util.NetworkUtils;
import com.shuame.rootgenius.pojo.C1459a;
import com.shuame.rootgenius.sdk.CommUtils;
import com.shuame.rootgenius.sdk.RootGenius;
import com.shuame.rootgenius.sdk.proto.ProtoEncoding;
import com.tencent.stat.common.DeviceInfo;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.shuame.rootgenius.service.f */
public class C1488f {
    /* renamed from: a */
    private static final String f4096a = C1488f.class.getSimpleName();
    /* renamed from: b */
    private static C1488f f4097b;
    /* renamed from: c */
    private C1459a f4098c = new C1459a();

    /* renamed from: com.shuame.rootgenius.service.f$a */
    static class C1486a {
        /* renamed from: a */
        public String f4090a;
        /* renamed from: b */
        public String f4091b;
        /* renamed from: c */
        public String f4092c;
        /* renamed from: d */
        public ArrayList<C1487b> f4093d = new ArrayList();

        C1486a() {
        }
    }

    /* renamed from: com.shuame.rootgenius.service.f$b */
    static class C1487b {
        /* renamed from: a */
        public String f4094a;
        /* renamed from: b */
        public String f4095b;

        public C1487b(String str, String str2) {
            this.f4094a = str;
            this.f4095b = str2;
        }
    }

    private C1488f() {
    }

    /* renamed from: a */
    private static String m4144a(C1486a c1486a) {
        Writer stringWriter = new StringWriter();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.startDocument(null, Boolean.valueOf(true));
        newSerializer.startTag(null, "param");
        ProtoEncoding.addElement(newSerializer, "product_id", c1486a.f4090a);
        ProtoEncoding.addElement(newSerializer, "android_version", c1486a.f4091b);
        ProtoEncoding.addElement(newSerializer, "android_sdk", c1486a.f4092c);
        if (!c1486a.f4093d.isEmpty()) {
            HashMap hashMap = new HashMap();
            Iterator it = c1486a.f4093d.iterator();
            while (it.hasNext()) {
                C1487b c1487b = (C1487b) it.next();
                hashMap.clear();
                hashMap.put(DeviceInfo.TAG_VERSION, c1487b.f4095b);
                ProtoEncoding.addElement(newSerializer, "superuser", c1487b.f4094a, hashMap);
            }
        }
        newSerializer.endTag(null, "param");
        newSerializer.endDocument();
        newSerializer.flush();
        stringWriter.close();
        return stringWriter.toString();
    }

    /* renamed from: a */
    private void m4145a(String str) {
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 2:
                    if (!newPullParser.getName().equals("superuser")) {
                        String nextText = newPullParser.nextText();
                        if (!newPullParser.getName().equals("url")) {
                            if (!newPullParser.getName().equals("md5")) {
                                if (!newPullParser.getName().equals("size")) {
                                    break;
                                }
                                this.f4098c.f4004c = CommUtils.parseInt(nextText);
                                break;
                            }
                            this.f4098c.f4005d = nextText;
                            break;
                        }
                        this.f4098c.f4003b = nextText;
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /* renamed from: b */
    public static C1488f m4146b() {
        if (f4097b == null) {
            synchronized (C1488f.class) {
                if (f4097b == null) {
                    f4097b = new C1488f();
                }
            }
        }
        return f4097b;
    }

    /* renamed from: a */
    public final C1459a mo7309a() {
        return this.f4098c;
    }

    /* renamed from: c */
    public final String mo7310c() {
        if (!this.f4098c.mo7241a()) {
            return null;
        }
        QQDownloadFile a = C1361b.m3817a().mo7068a(C1361b.m3815a(this.f4098c.f4003b));
        if (a == null) {
            a = this.f4098c.mo7242b();
        }
        long j = a.f3727h;
        int i = a.f3728i / 10;
        if (i == 0) {
            return Formatter.formatFileSize(RootGeniusApp.m3523a(), j);
        }
        return Formatter.formatFileSize(RootGeniusApp.m3523a(), (long) (((double) j) - (((double) i) * (((double) j) / 100.0d))));
    }

    /* renamed from: d */
    public final boolean mo7311d() {
        if (!C1323b.m3698d()) {
            return false;
        }
        C1389b.m3884a();
        if (!C1389b.m3887b(false)) {
            return false;
        }
        if (TextUtils.isEmpty(C1406p.m3910a(false))) {
            return false;
        }
        C1459a c1459a = this.f4098c;
        c1459a.f4002a = 0;
        c1459a.f4003b = null;
        c1459a.f4004c = 0;
        c1459a.f4005d = null;
        C1486a c1486a = new C1486a();
        C1323b.m3688a();
        c1486a.f4090a = C1323b.m3707l();
        c1486a.f4092c = VERSION.SDK_INT;
        c1486a.f4091b = VERSION.RELEASE;
        try {
            C1446g.m4003a();
            List asList = Arrays.asList(C1446g.m4019m().split(","));
            for (PackageInfo packageInfo : RootGeniusApp.m3523a().getPackageManager().getInstalledPackages(0)) {
                if (asList.contains(packageInfo.packageName)) {
                    c1486a.f4093d.add(new C1487b(packageInfo.packageName, packageInfo.versionCode));
                }
            }
            if (!TextUtils.isEmpty(c1486a.f4090a)) {
                String a = C1488f.m4144a(c1486a);
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                C1400b c1400b = new C1400b();
                byte[] bytes = a.getBytes("UTF-8");
                C1396i.m3893a(bytes, C1396i.f3874a);
                String str = "http://api1.rootjl.%s/v2/m/root/superuser/update?versionName=%s&versionCode=%s";
                Object[] objArr = new Object[3];
                objArr[0] = C1412t.f3902a ? "org" : "com";
                objArr[1] = C1323b.m3709n();
                objArr[2] = Integer.valueOf(C1323b.m3711p());
                c1400b.f3880a = String.format(str, objArr);
                c1400b.f3881b = bytes;
                c1400b.f3882c = hashMap;
                c1400b.f3883d = 20000;
                C1401c a2 = C1402l.m3903a(c1400b);
                new StringBuilder("response.statusCode:").append(a2.f3885a);
                if (a2.f3885a == 200 && a2.f3886b.length > 0) {
                    C1396i.m3895b(a2.f3886b, C1396i.f3874a);
                    m4145a(new String(a2.f3886b, "UTF-8"));
                }
                this.f4098c.f4002a = a2.f3885a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean a3 = this.f4098c.mo7241a();
        if (a3) {
            RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3643n));
            C1459a c1459a2 = C1488f.m4146b().f4098c;
            if ((c1459a2.f4005d == null || !c1459a2.f4005d.equals(RootGenius.getBuildInKinguserMd5())) && c1459a2.mo7241a() && NetworkUtils.m3854d()) {
                QQDownloadFile a4 = C1361b.m3817a().mo7068a(C1361b.m3815a(c1459a2.f4003b));
                if (a4 == null) {
                    a4 = c1459a2.mo7242b();
                    a4.f3725f = C1397j.m3902b(a4);
                }
                C1389b.m3884a();
                if (C1389b.m3886a(false)) {
                    C1389b.m3884a();
                    if (C1389b.m3885a(a4, false)) {
                        C1361b.m3817a().mo7067a(a4, null);
                    }
                }
            }
        }
        return a3;
    }
}
