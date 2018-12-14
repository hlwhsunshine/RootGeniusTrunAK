package com.shuame.rootgenius.service;

import android.text.TextUtils;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.util.C1402l;
import com.shuame.rootgenius.common.util.C1402l.C1400b;
import com.shuame.rootgenius.common.util.C1402l.C1401c;
import com.shuame.rootgenius.common.util.C1412t;
import com.shuame.rootgenius.common.util.NetworkUtils;
import com.shuame.rootgenius.p109f.C1433a;
import com.shuame.rootgenius.pojo.BbxCategoryInfo;
import com.shuame.rootgenius.pojo.BbxCategoryInfo.C1456a;
import com.shuame.rootgenius.pojo.BbxCategoryInfo.C1457b;
import com.shuame.rootgenius.pojo.BbxCategoryInfo.Item;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.shuame.rootgenius.service.c */
public class C1483c {
    /* renamed from: a */
    private static final String f4080a = C1483c.class.getSimpleName();
    /* renamed from: b */
    private static C1483c f4081b;
    /* renamed from: c */
    private C1433a f4082c = C1433a.m3964a();
    /* renamed from: d */
    private ArrayList<BbxCategoryInfo> f4083d = new ArrayList();
    /* renamed from: e */
    private HashMap<String, Item> f4084e = new HashMap();
    /* renamed from: f */
    private boolean f4085f = false;

    private C1483c() {
    }

    /* renamed from: a */
    private static int m4130a(XmlPullParser xmlPullParser, String str) {
        Object attributeValue = xmlPullParser.getAttributeValue("", str);
        if (!TextUtils.isEmpty(attributeValue)) {
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static C1483c m4131a() {
        if (f4081b == null) {
            synchronized (C1483c.class) {
                if (f4081b == null) {
                    f4081b = new C1483c();
                }
            }
        }
        return f4081b;
    }

    /* renamed from: a */
    private static void m4132a(String str, ArrayList<BbxCategoryInfo> arrayList, HashMap<String, Item> hashMap) {
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 2:
                    String name = newPullParser.getName();
                    if (!"bbx".equals(name) && "category".equals(name)) {
                        Object attributeValue = newPullParser.getAttributeValue("", "remind");
                        BbxCategoryInfo bbxCategoryInfo = new BbxCategoryInfo();
                        bbxCategoryInfo.index = C1483c.m4130a(newPullParser, "index");
                        C1483c.m4134a(newPullParser, bbxCategoryInfo, (HashMap) hashMap);
                        if (!TextUtils.isEmpty(attributeValue)) {
                            bbxCategoryInfo.isRemind = Boolean.parseBoolean(attributeValue);
                        }
                        if (bbxCategoryInfo.items.size() <= 0 && !C1323b.m3696c(bbxCategoryInfo.name)) {
                            break;
                        }
                        arrayList.add(bbxCategoryInfo);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /* renamed from: a */
    private static void m4133a(ArrayList<BbxCategoryInfo> arrayList) {
        int size = arrayList.size();
        if (size < 12) {
            for (int i = 0; i < 12 - size; i++) {
                arrayList.add(null);
            }
        }
    }

    /* JADX WARNING: Missing block: B:12:0x0031, code:
            r0 = r2;
     */
    /* JADX WARNING: Missing block: B:13:0x0032, code:
            r2 = r0;
     */
    /* renamed from: a */
    private static void m4134a(org.xmlpull.v1.XmlPullParser r10, com.shuame.rootgenius.pojo.BbxCategoryInfo r11, java.util.HashMap<java.lang.String, com.shuame.rootgenius.pojo.BbxCategoryInfo.Item> r12) {
        /*
        r1 = 1;
        r4 = 0;
        r10.getEventType();
        r3 = r4;
    L_0x0006:
        if (r3 != 0) goto L_0x0153;
    L_0x0008:
        r0 = r10.next();
        r2 = r10.getName();
        switch(r0) {
            case 2: goto L_0x0016;
            case 3: goto L_0x0148;
            default: goto L_0x0013;
        };
    L_0x0013:
        r0 = r3;
    L_0x0014:
        r3 = r0;
        goto L_0x0006;
    L_0x0016:
        r0 = "items";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0120;
    L_0x001e:
        r0 = 0;
        r10.getEventType();
        r2 = r4;
        r5 = r0;
    L_0x0024:
        if (r2 != 0) goto L_0x0006;
    L_0x0026:
        r0 = r10.next();
        r6 = r10.getName();
        switch(r0) {
            case 2: goto L_0x0034;
            case 3: goto L_0x0106;
            default: goto L_0x0031;
        };
    L_0x0031:
        r0 = r2;
    L_0x0032:
        r2 = r0;
        goto L_0x0024;
    L_0x0034:
        r0 = "item";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x004f;
    L_0x003c:
        r0 = new com.shuame.rootgenius.pojo.BbxCategoryInfo$Item;
        r0.<init>();
        r5 = "index";
        r5 = com.shuame.rootgenius.service.C1483c.m4130a(r10, r5);
        r0.index = r5;
        r5 = r11.name;
        r0.cName = r5;
        r5 = r0;
        goto L_0x0024;
    L_0x004f:
        r0 = "screenshots";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x0085;
    L_0x0057:
        r6 = r5.screenshots;
        r10.getEventType();
        r0 = r4;
    L_0x005d:
        if (r0 != 0) goto L_0x0024;
    L_0x005f:
        r7 = r10.next();
        r8 = r10.getName();
        switch(r7) {
            case 2: goto L_0x006b;
            case 3: goto L_0x007b;
            default: goto L_0x006a;
        };
    L_0x006a:
        goto L_0x005d;
    L_0x006b:
        r7 = r10.nextText();
        r9 = "screenshot";
        r8 = r9.equals(r8);
        if (r8 == 0) goto L_0x005d;
    L_0x0077:
        r6.add(r7);
        goto L_0x005d;
    L_0x007b:
        r7 = "screenshots";
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x005d;
    L_0x0083:
        r0 = r1;
        goto L_0x005d;
    L_0x0085:
        r0 = r10.nextText();
        r7 = "name";
        r7 = r7.equals(r6);
        if (r7 == 0) goto L_0x0099;
    L_0x0091:
        r5.name = r0;
        r0 = r5.name;
        r12.put(r0, r5);
        goto L_0x0024;
    L_0x0099:
        r7 = "display_name";
        r7 = r7.equals(r6);
        if (r7 == 0) goto L_0x00a4;
    L_0x00a1:
        r5.displayName = r0;
        goto L_0x0024;
    L_0x00a4:
        r7 = "icon";
        r7 = r7.equals(r6);
        if (r7 == 0) goto L_0x00b0;
    L_0x00ac:
        r5.iconUrl = r0;
        goto L_0x0024;
    L_0x00b0:
        r7 = "description";
        r7 = r7.equals(r6);
        if (r7 == 0) goto L_0x00bc;
    L_0x00b8:
        r5.description = r0;
        goto L_0x0024;
    L_0x00bc:
        r7 = "type";
        r7 = r7.equals(r6);
        if (r7 == 0) goto L_0x00cc;
    L_0x00c4:
        r0 = com.shuame.rootgenius.pojo.BbxCategoryInfo.Item.Type.toType(r0);
        r5.type = r0;
        goto L_0x0024;
    L_0x00cc:
        r7 = "package";
        r7 = r7.equals(r6);
        if (r7 == 0) goto L_0x00d8;
    L_0x00d4:
        r5.packageName = r0;
        goto L_0x0024;
    L_0x00d8:
        r7 = "url";
        r7 = r7.equals(r6);
        if (r7 == 0) goto L_0x00e4;
    L_0x00e0:
        r5.url = r0;
        goto L_0x0024;
    L_0x00e4:
        r7 = "md5";
        r7 = r7.equals(r6);
        if (r7 == 0) goto L_0x00f0;
    L_0x00ec:
        r5.md5 = r0;
        goto L_0x0024;
    L_0x00f0:
        r7 = "size";
        r6 = r7.equals(r6);
        if (r6 == 0) goto L_0x0031;
    L_0x00f8:
        r6 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x0100 }
        r5.size = r6;	 Catch:{ NumberFormatException -> 0x0100 }
        goto L_0x0024;
    L_0x0100:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0024;
    L_0x0106:
        r0 = "item";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x0115;
    L_0x010e:
        r0 = r11.items;
        r0.add(r5);
        goto L_0x0024;
    L_0x0115:
        r0 = "items";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x0031;
    L_0x011d:
        r0 = r1;
        goto L_0x0032;
    L_0x0120:
        r0 = r10.nextText();
        r5 = "name";
        r5 = r5.equals(r2);
        if (r5 == 0) goto L_0x0130;
    L_0x012c:
        r11.name = r0;
        goto L_0x0006;
    L_0x0130:
        r5 = "display_name";
        r5 = r5.equals(r2);
        if (r5 == 0) goto L_0x013c;
    L_0x0138:
        r11.displayName = r0;
        goto L_0x0006;
    L_0x013c:
        r5 = "icon";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x0013;
    L_0x0144:
        r11.iconUrl = r0;
        goto L_0x0006;
    L_0x0148:
        r0 = "category";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0013;
    L_0x0150:
        r0 = r1;
        goto L_0x0014;
    L_0x0153:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.service.c.a(org.xmlpull.v1.XmlPullParser, com.shuame.rootgenius.pojo.BbxCategoryInfo, java.util.HashMap):void");
    }

    /* renamed from: b */
    private static void m4135b(ArrayList<BbxCategoryInfo> arrayList) {
        BbxCategoryInfo bbxCategoryInfo = new BbxCategoryInfo();
        bbxCategoryInfo.name = "appuninstall";
        bbxCategoryInfo.displayName = "卸载预装";
        arrayList.add(bbxCategoryInfo);
        bbxCategoryInfo = new BbxCategoryInfo();
        bbxCategoryInfo.name = "autoboot";
        bbxCategoryInfo.displayName = "自启管理";
        arrayList.add(bbxCategoryInfo);
        bbxCategoryInfo = new BbxCategoryInfo();
        bbxCategoryInfo.name = "huangeziti";
        bbxCategoryInfo.displayName = "换个字体";
        arrayList.add(bbxCategoryInfo);
        bbxCategoryInfo = new BbxCategoryInfo();
        bbxCategoryInfo.name = "shuame_mobile";
        bbxCategoryInfo.displayName = "一键刷ROM";
        arrayList.add(bbxCategoryInfo);
    }

    /* renamed from: c */
    private static void m4136c(ArrayList<BbxCategoryInfo> arrayList) {
        BbxCategoryInfo bbxCategoryInfo;
        Object arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bbxCategoryInfo = (BbxCategoryInfo) it.next();
            if (!(bbxCategoryInfo == null || bbxCategoryInfo.index == -1)) {
                arrayList2.add(bbxCategoryInfo);
            }
            C1483c.m4137d(bbxCategoryInfo.items);
        }
        Collections.sort(arrayList2, new C1456a());
        it = arrayList2.iterator();
        while (it.hasNext()) {
            bbxCategoryInfo = (BbxCategoryInfo) it.next();
            if (bbxCategoryInfo != null) {
                int i = bbxCategoryInfo.index - 1;
                if (arrayList.indexOf(bbxCategoryInfo) != i) {
                    arrayList.remove(bbxCategoryInfo);
                    if (i < 0) {
                        i = 0;
                    } else if (i > arrayList.size()) {
                        i = arrayList.size();
                    }
                    arrayList.add(i, bbxCategoryInfo);
                }
            }
        }
    }

    /* renamed from: d */
    private static void m4137d(ArrayList<Item> arrayList) {
        if (arrayList != null && arrayList.size() > 1) {
            Item item;
            Object arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                item = (Item) it.next();
                if (!(item == null || item.index == -1)) {
                    arrayList2.add(item);
                }
            }
            Collections.sort(arrayList2, new C1457b());
            it = arrayList2.iterator();
            while (it.hasNext()) {
                item = (Item) it.next();
                if (item != null) {
                    int indexOf = arrayList.indexOf(item);
                    int i = item.index - 1;
                    if (indexOf != i) {
                        arrayList.remove(item);
                        if (i < 0) {
                            i = 0;
                        } else if (i > arrayList.size()) {
                            i = arrayList.size();
                        }
                        arrayList.add(i, item);
                    }
                    new StringBuilder("oldIndex:").append(indexOf).append("--newIndex:").append(i);
                }
            }
        }
    }

    /* renamed from: a */
    public final Item mo7304a(String str) {
        return (Item) this.f4084e.get(str);
    }

    /* renamed from: b */
    public final ArrayList<BbxCategoryInfo> mo7305b() {
        if (this.f4083d.isEmpty()) {
            synchronized (this.f4083d) {
                if (this.f4083d.isEmpty()) {
                    C1483c.m4135b(this.f4083d);
                    C1483c.m4133a(this.f4083d);
                }
            }
        }
        return this.f4083d;
    }

    /* renamed from: c */
    public final void mo7306c() {
        if (!this.f4085f) {
            this.f4085f = true;
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            if (NetworkUtils.m3852b()) {
                try {
                    C1400b c1400b = new C1400b();
                    String str = "http://client.shuame.com/api/rootandroid/bbx/?versionName=%s&versionCode=%s&format=xml&dataStatus=%s";
                    if (C1412t.f3902a) {
                        str = "http://client.shuame.org/api/rootandroid/bbx/?versionName=%s&versionCode=%s&format=xml&dataStatus=%s";
                    }
                    c1400b.f3880a = String.format(str, new Object[]{C1323b.m3709n(), Integer.valueOf(C1323b.m3711p()), Integer.valueOf(1)});
                    c1400b.f3883d = 20000;
                    new StringBuilder("url:").append(c1400b.f3880a);
                    C1401c b = C1402l.m3905b(c1400b);
                    new StringBuilder("response.statusCode:").append(b.f3885a);
                    if (b.f3885a == 200 && b.f3886b.length > 0) {
                        C1483c.m4132a(new String(b.f3886b, "UTF-8"), arrayList, hashMap);
                    }
                    new StringBuilder("bbx_infos共:").append(mo7305b().size());
                    C1483c.m4136c(arrayList);
                    new StringBuilder("bbx_infos:").append(mo7305b());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (this.f4083d) {
                if (arrayList.isEmpty()) {
                    C1483c.m4135b(arrayList);
                } else {
                    new C1484d(this).start();
                }
                C1483c.m4133a(arrayList);
                this.f4083d.clear();
                this.f4084e.clear();
                this.f4083d.addAll(arrayList);
                this.f4084e.putAll(hashMap);
                if (this.f4082c != null) {
                    this.f4082c.onChange();
                }
            }
            this.f4085f = false;
        }
    }
}
