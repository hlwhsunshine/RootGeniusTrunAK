package com.shuame.rootgenius.service;

import android.content.p013pm.PackageInfo;
import android.text.TextUtils;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.util.C1402l;
import com.shuame.rootgenius.common.util.C1402l.C1400b;
import com.shuame.rootgenius.common.util.C1402l.C1401c;
import com.shuame.rootgenius.common.util.NetworkUtils;
import com.shuame.rootgenius.pojo.OptimizeInfo;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.shuame.rootgenius.service.k */
public class C1493k {
    /* renamed from: a */
    private static final String f4110a = C1493k.class.getSimpleName();
    /* renamed from: b */
    private static volatile C1493k f4111b;
    /* renamed from: c */
    private boolean f4112c = false;
    /* renamed from: d */
    private ArrayList<OptimizeInfo> f4113d = new ArrayList();

    private C1493k() {
    }

    /* renamed from: a */
    public static C1493k m4179a() {
        if (f4111b == null) {
            synchronized (C1493k.class) {
                if (f4111b == null) {
                    f4111b = new C1493k();
                }
            }
        }
        return f4111b;
    }

    /* renamed from: a */
    private ArrayList<OptimizeInfo> m4181a(String str) {
        ArrayList<OptimizeInfo> arrayList = null;
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 2:
                    String name = newPullParser.getName();
                    if (!"optimize".equals(name)) {
                        if (!"flag".equals(name)) {
                            if (!"item".equals(name)) {
                                break;
                            }
                            OptimizeInfo optimizeInfo = new OptimizeInfo();
                            C1493k.m4183a(newPullParser, optimizeInfo);
                            arrayList.add(optimizeInfo);
                            break;
                        } else if (1 != Integer.parseInt(newPullParser.nextText())) {
                            this.f4112c = false;
                            break;
                        } else {
                            this.f4112c = true;
                            break;
                        }
                    }
                    arrayList = new ArrayList();
                    break;
                default:
                    break;
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m4183a(XmlPullParser xmlPullParser, OptimizeInfo optimizeInfo) {
        Object obj = null;
        xmlPullParser.getEventType();
        while (obj == null) {
            int next = xmlPullParser.next();
            String name = xmlPullParser.getName();
            switch (next) {
                case 2:
                    String nextText = xmlPullParser.nextText();
                    if (!"app_type".equals(name)) {
                        if (!"app_name".equals(name)) {
                            if (!"app_package".equals(name)) {
                                if (!"apk_url".equals(name)) {
                                    if (!"apk_md5".equals(name)) {
                                        if (!"similar_packages".equals(name)) {
                                            if (!"threat_cue".equals(name)) {
                                                if (!"button_text".equals(name)) {
                                                    if (!"score".equals(name)) {
                                                        if (!"app_size".equals(name)) {
                                                            break;
                                                        }
                                                        optimizeInfo.size = Long.parseLong(nextText);
                                                        break;
                                                    }
                                                    optimizeInfo.score = Integer.parseInt(nextText);
                                                    break;
                                                }
                                                optimizeInfo.btnText = nextText;
                                                break;
                                            }
                                            optimizeInfo.threatDesc = nextText;
                                            break;
                                        }
                                        optimizeInfo.similarPkgs = nextText;
                                        break;
                                    }
                                    optimizeInfo.md5 = nextText;
                                    break;
                                }
                                optimizeInfo.url = nextText;
                                break;
                            }
                            optimizeInfo.pkgName = nextText;
                            break;
                        }
                        optimizeInfo.appInfo = nextText;
                        break;
                    }
                    optimizeInfo.appType = nextText;
                    break;
                case 3:
                    if (!"item".equals(name)) {
                        break;
                    }
                    obj = 1;
                    break;
                default:
                    break;
            }
        }
    }

    /* renamed from: b */
    private static void m4184b(ArrayList<OptimizeInfo> arrayList) {
        Iterator it;
        Collections.sort(arrayList);
        HashSet hashSet = new HashSet();
        for (PackageInfo packageInfo : RootGeniusApp.m3523a().getPackageManager().getInstalledPackages(0)) {
            hashSet.add(packageInfo.packageName);
        }
        Collection arrayList2 = new ArrayList();
        Object arrayList3 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object[] objArr;
            OptimizeInfo optimizeInfo = (OptimizeInfo) it2.next();
            optimizeInfo.revertReportParam();
            optimizeInfo.similarPkgs = optimizeInfo.pkgName + "," + optimizeInfo.similarPkgs;
            if (TextUtils.isEmpty(optimizeInfo.similarPkgs)) {
                objArr = null;
            } else {
                String[] objArr2 = optimizeInfo.similarPkgs.split(",");
            }
            if (objArr2 == null || objArr2.length <= 0) {
                arrayList2.add(optimizeInfo);
            } else {
                for (Object contains : objArr2) {
                    if (hashSet.contains(contains)) {
                        optimizeInfo.isOptimized = true;
                        optimizeInfo.isCanOptimizeItem = false;
                        arrayList3.add(optimizeInfo);
                        break;
                    }
                }
                if (!optimizeInfo.isOptimized) {
                    optimizeInfo.isCanOptimizeItem = true;
                    arrayList2.add(optimizeInfo);
                }
            }
        }
        arrayList.clear();
        Collections.sort(arrayList2);
        Collections.sort(arrayList3);
        int size = arrayList2.size();
        if (size == 3) {
            arrayList.addAll(arrayList2);
        } else if (size > 3) {
            arrayList.addAll(arrayList2.subList(0, 3));
        } else if (size > 0 && size < 3) {
            arrayList.addAll(arrayList2);
            it = arrayList3.iterator();
            while (it.hasNext()) {
                arrayList.add((OptimizeInfo) it.next());
                if (arrayList.size() == 3) {
                    break;
                }
            }
        }
        new StringBuilder("allow display optimize item:").append(arrayList);
    }

    /* renamed from: b */
    public final ArrayList<OptimizeInfo> mo7321b() {
        Iterator it = this.f4113d.iterator();
        while (it.hasNext()) {
            OptimizeInfo optimizeInfo = (OptimizeInfo) it.next();
            if (!optimizeInfo.isOptimized) {
                optimizeInfo.reportTriger = 0;
            }
        }
        ArrayList<OptimizeInfo> arrayList = new ArrayList();
        arrayList.addAll(this.f4113d);
        return arrayList;
    }

    /* renamed from: c */
    public final ArrayList<OptimizeInfo> mo7322c() {
        new StringBuilder("mOptimizeInfos size:").append(this.f4113d.size());
        return this.f4113d;
    }

    /* renamed from: d */
    public final boolean mo7323d() {
        if (this.f4113d.isEmpty()) {
            return true;
        }
        Iterator it = this.f4113d.iterator();
        while (it.hasNext()) {
            if (!((OptimizeInfo) it.next()).isOptimized) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    public final int mo7324e() {
        int i = 0;
        if (this.f4113d.isEmpty()) {
            return 0;
        }
        Iterator it = this.f4113d.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return Math.round(((float) i2) / 0.72f);
            }
            i = ((OptimizeInfo) it.next()).score + i2;
        }
    }

    /* renamed from: f */
    public final int mo7325f() {
        if (this.f4113d.isEmpty()) {
            return 0;
        }
        int round = Math.round(((float) mo7324e()) * 0.28f);
        Iterator it = this.f4113d.iterator();
        while (true) {
            int i = round;
            if (!it.hasNext()) {
                return i;
            }
            OptimizeInfo optimizeInfo = (OptimizeInfo) it.next();
            round = optimizeInfo.isOptimized ? optimizeInfo.score + i : i;
        }
    }

    /* renamed from: g */
    public final int mo7326g() {
        if (this.f4113d.isEmpty()) {
            return 0;
        }
        return Math.round((((float) mo7325f()) * 100.0f) / ((float) mo7324e()));
    }

    /* renamed from: h */
    public final void mo7327h() {
        new C1494l(this).start();
    }

    /* renamed from: i */
    public final void mo7328i() {
        this.f4112c = false;
        this.f4113d.clear();
        if (NetworkUtils.m3852b()) {
            Collection collection = null;
            try {
                C1400b c1400b = new C1400b();
                c1400b.f3880a = String.format("http://client.shuame.com/api/rootandroid/optimize/?versionName=%s&versionCode=%s&format=xml", new Object[]{C1323b.m3709n(), Integer.valueOf(C1323b.m3711p())});
                c1400b.f3883d = 15000;
                new StringBuilder("url:").append(c1400b.f3880a);
                C1401c b = C1402l.m3905b(c1400b);
                new StringBuilder("response.statusCode:").append(b.f3885a);
                if (b.f3885a == 200 && b.f3886b.length > 0) {
                    collection = m4181a(new String(b.f3886b, "UTF-8"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (collection != null && !collection.isEmpty()) {
                if (this.f4112c) {
                    synchronized (this.f4113d) {
                        C1493k.m4184b(collection);
                        this.f4113d.addAll(collection);
                    }
                    return;
                }
                this.f4112c = false;
            }
        }
    }
}
