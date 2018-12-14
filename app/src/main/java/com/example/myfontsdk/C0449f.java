package com.example.myfontsdk;

import android.graphics.Typeface;
import android.os.Message;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.example.myfontsdk.f */
final class C0449f extends Thread {
    /* renamed from: a */
    private final /* synthetic */ String f1214a;
    /* renamed from: b */
    private final /* synthetic */ Font f1215b;
    /* renamed from: c */
    private final /* synthetic */ C0459q f1216c;

    C0449f(String str, Font font, C0459q c0459q) {
        this.f1214a = str;
        this.f1215b = font;
        this.f1216c = c0459q;
    }

    public final void run() {
        C0446c.m986a(this.f1214a, this.f1215b);
        Object obj = null;
        String str = C0444a.f1189b + C0454k.m992a(new StringBuilder(String.valueOf(this.f1215b.getFontId())).append(this.f1214a).toString()) + ".dat";
        if (!(str == null || "".equals(str))) {
            File file = new File(str);
            if (file.exists() && file.length() != 0) {
                try {
                    obj = Typeface.createFromFile(str);
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
        hashMap.put("callback", this.f1216c);
        hashMap.put("typeface", obj);
        message.obj = hashMap;
        message.what = 0;
        C0446c.f1208b.sendMessage(message);
    }
}
