package com.shuame.rootgenius.p108e;

import com.shuame.rootgenius.common.util.C1396i;
import com.shuame.rootgenius.common.util.C1402l;
import com.shuame.rootgenius.common.util.C1402l.C1400b;
import com.shuame.rootgenius.p107d.C1419a;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.shuame.rootgenius.e.d */
final class C1425d extends Thread {
    /* renamed from: a */
    final /* synthetic */ C1423b f3926a;

    C1425d(C1423b c1423b) {
        this.f3926a = c1423b;
    }

    public final void run() {
        ArrayList b = C1419a.m3940a().mo7137b();
        if (b.isEmpty()) {
            this.f3926a.f3923c = false;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        C1423b.m3951a(stringBuilder);
        Iterator it = b.iterator();
        while (it.hasNext()) {
            C1422a c1422a = (C1422a) it.next();
            stringBuilder.append("<must>");
            if (c1422a.f3918a != null) {
                stringBuilder.append("<category>").append(c1422a.f3918a).append("</category>");
            }
            if (c1422a.f3919b != null) {
                stringBuilder.append("<name>").append(c1422a.f3919b).append("</name>");
            }
            stringBuilder.append("</must>");
        }
        stringBuilder.append("</report>");
        Object obj = null;
        try {
            C1400b c1400b = new C1400b();
            byte[] bytes = stringBuilder.toString().getBytes("UTF-8");
            C1396i.m3893a(bytes, C1396i.f3874a);
            c1400b.f3880a = C1423b.m3954c();
            c1400b.f3881b = bytes;
            c1400b.f3883d = 5000;
            if (C1402l.m3903a(c1400b).f3885a == 200) {
                obj = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (obj != null) {
            C1423b.f3921a;
            new StringBuilder("上报net成功:").append(stringBuilder.toString());
            C1419a.m3940a().mo7136a(b);
        } else {
            C1423b.f3921a;
            new StringBuilder("上报net失败:").append(stringBuilder.toString());
        }
        this.f3926a.f3923c = false;
    }
}
