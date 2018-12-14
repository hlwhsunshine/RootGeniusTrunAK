package com.shuame.rootgenius.service;

import android.content.Intent;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.util.C1396i;
import com.shuame.rootgenius.common.util.C1402l;
import com.shuame.rootgenius.common.util.C1402l.C1400b;
import com.shuame.rootgenius.common.util.C1402l.C1401c;
import com.shuame.rootgenius.common.util.C1412t;
import com.shuame.rootgenius.p107d.C1420b;
import com.shuame.rootgenius.p115ui.homepage.ScanFragment;
import com.shuame.rootgenius.pojo.BbxPopInfo;
import com.shuame.rootgenius.sdk.RgsdkConfig;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.shuame.rootgenius.service.e */
public class C1485e {
    /* renamed from: a */
    private static final String f4087a = C1485e.class.getSimpleName();
    /* renamed from: c */
    private static C1485e f4088c = new C1485e();
    /* renamed from: b */
    private BbxPopInfo f4089b = new BbxPopInfo();

    private C1485e() {
    }

    /* renamed from: a */
    public static C1485e m4141a() {
        return f4088c;
    }

    /* renamed from: a */
    private void m4142a(String str) {
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 2:
                    String name = newPullParser.getName();
                    if (!"config".equals(name)) {
                        String nextText = newPullParser.nextText();
                        if (!"option".equals(name)) {
                            if (!"name".equals(name)) {
                                if (!"title".equals(name)) {
                                    if (!"pic".equals(name)) {
                                        if (!"text".equals(name)) {
                                            break;
                                        }
                                        this.f4089b.text = nextText;
                                        break;
                                    }
                                    this.f4089b.pic = nextText;
                                    break;
                                }
                                this.f4089b.title = nextText;
                                break;
                            }
                            this.f4089b.name = nextText;
                            break;
                        }
                        this.f4089b.option = Integer.parseInt(nextText);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /* renamed from: b */
    public final void mo7308b() {
        this.f4089b.clear();
        try {
            C1400b c1400b = new C1400b();
            String str = RgsdkConfig.sChVersionName;
            String valueOf = String.valueOf(C1323b.m3711p());
            String str2 = "com";
            if (C1412t.f3902a) {
                str2 = "org";
            }
            c1400b.f3880a = String.format("http://cfg.rootjl.%s/v2/m/root/pop_config?versionName=%s&versionCode=%s", new Object[]{str2, str, valueOf});
            c1400b.f3883d = 5000;
            c1400b.f3884e = 5000;
            new StringBuilder("url:").append(c1400b.f3880a);
            C1401c a = C1402l.m3903a(c1400b);
            new StringBuilder("response.statusCode:").append(a.f3885a);
            if (a.f3885a == 200 && a.f3886b.length > 0) {
                C1396i.m3895b(a.f3886b, C1396i.f3874a);
                m4142a(new String(a.f3886b, "UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!(this.f4089b == null || this.f4089b.isEmpty())) {
            C1420b.m3944a().mo7138a(this.f4089b);
            while (ScanFragment.isScanChecking) {
                try {
                    Thread.sleep(100);
                } catch (Exception e2) {
                }
            }
        }
        Intent intent = new Intent(C1340e.f3635f);
        intent.putExtra("param_data", 1);
        RootGeniusApp.m3523a().sendBroadcast(intent);
    }
}
