package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.event.C1735f;
import com.tencent.stat.event.C1741e;
import java.io.File;
import java.util.Iterator;

/* renamed from: com.tencent.stat.at */
class C1698at implements Runnable {
    /* renamed from: a */
    private Context f4943a = null;

    public C1698at(Context context) {
        this.f4943a = context;
    }

    public void run() {
        Iterator it = StatNativeCrashReport.m4616a(this.f4943a).iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            C1735f c1741e = new C1741e(this.f4943a, StatServiceImpl.m4619a(this.f4943a, false, null), StatNativeCrashReport.m4615a(file), 3, 10240, new Thread(), null);
            c1741e.mo7938a(StatNativeCrashReport.m4617b(file));
            new C1700av(c1741e).mo7867a();
            file.delete();
            if (StatConfig.isDebugEnable()) {
                StatServiceImpl.f4884q.mo7897d("delete tombstone file:" + file.getAbsolutePath().toString());
            }
        }
    }
}
