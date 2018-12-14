package com.shuame.rootgenius.appmanager.p093c;

import com.shuame.rootgenius.appmanager.p091b.C1255b;
import com.shuame.rootgenius.common.util.C1396i;
import com.shuame.rootgenius.common.util.C1402l;
import com.shuame.rootgenius.common.util.C1402l.C1400b;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.shuame.rootgenius.appmanager.c.c */
final class C1265c extends Thread {
    /* renamed from: a */
    final /* synthetic */ C1264b f3391a;

    C1265c(C1264b c1264b) {
        this.f3391a = c1264b;
    }

    public final void run() {
        ArrayList b = C1255b.m3548a().mo6890b();
        if (b.isEmpty()) {
            this.f3391a.f3390c = false;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        C1264b.m3597a(stringBuilder);
        Iterator it = b.iterator();
        while (it.hasNext()) {
            C1263a c1263a = (C1263a) it.next();
            stringBuilder.append("<app>");
            if (c1263a.f3385a != null) {
                stringBuilder.append("<pkg_name>").append(c1263a.f3385a).append("</pkg_name>");
            }
            if (c1263a.f3386b != 0) {
                stringBuilder.append("<ver_code>").append(c1263a.f3386b).append("</ver_code>");
            }
            stringBuilder.append("</app>");
        }
        stringBuilder.append("</report>");
        Object obj = null;
        try {
            C1400b c1400b = new C1400b();
            byte[] bytes = stringBuilder.toString().getBytes("UTF-8");
            C1396i.m3893a(bytes, C1396i.f3874a);
            c1400b.f3880a = C1264b.m3600c();
            c1400b.f3881b = bytes;
            if (C1402l.m3903a(c1400b).f3885a == 200) {
                obj = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (obj != null) {
            C1264b.f3388a;
            new StringBuilder("上报net成功:").append(stringBuilder.toString());
            C1255b.m3548a().mo6889a(b);
        } else {
            C1264b.f3388a;
            new StringBuilder("上报net失败:").append(stringBuilder.toString());
        }
        this.f3391a.f3390c = false;
    }
}
