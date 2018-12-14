package com.baidu.mobads.p021j;

import java.io.File;

/* renamed from: com.baidu.mobads.j.h */
class C0334h implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f676a;
    /* renamed from: b */
    final /* synthetic */ C0333g f677b;

    C0334h(C0333g c0333g, String str) {
        this.f677b = c0333g;
        this.f676a = str;
    }

    public void run() {
        String[] list = new File(this.f676a).list();
        if (list != null && list.length > 0) {
            for (String file : list) {
                File file2 = new File(file);
                long currentTimeMillis = System.currentTimeMillis() - file2.lastModified();
                if (file2.exists() && currentTimeMillis > 604800000) {
                    file2.delete();
                }
            }
        }
    }
}
