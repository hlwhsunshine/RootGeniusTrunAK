package com.example.myfontsdk;

import android.graphics.Typeface;
import android.os.Message;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.example.myfontsdk.e */
final class C0448e extends Thread {
    /* renamed from: a */
    private final /* synthetic */ Font f1212a;
    /* renamed from: b */
    private final /* synthetic */ C0459q f1213b;

    C0448e(Font font, C0459q c0459q) {
        this.f1212a = font;
        this.f1213b = c0459q;
    }

    public final void run() {
        C0446c.m989b(this.f1212a);
        Object obj = null;
        String thumbnailLocalPath = this.f1212a.getThumbnailLocalPath();
        if (!(thumbnailLocalPath == null || "".equals(thumbnailLocalPath))) {
            File file = new File(thumbnailLocalPath);
            if (file.exists() && file.length() != 0) {
                try {
                    obj = Typeface.createFromFile(thumbnailLocalPath);
                } catch (Exception e) {
                    e.printStackTrace();
                    obj = Typeface.DEFAULT;
                }
            }
        }
        if (obj == null) {
            obj = Typeface.DEFAULT;
        }
        Message message = new Message();
        Map hashMap = new HashMap();
        hashMap.put("callback", this.f1213b);
        hashMap.put("typeface", obj);
        message.obj = hashMap;
        message.what = 0;
        C0446c.f1208b.sendMessage(message);
    }
}
