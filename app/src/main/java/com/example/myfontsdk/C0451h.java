package com.example.myfontsdk;

import android.content.Context;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.example.myfontsdk.h */
final class C0451h extends Thread {
    /* renamed from: a */
    private final /* synthetic */ C0453j f1217a;
    /* renamed from: b */
    private final /* synthetic */ Context f1218b;

    C0451h(C0453j c0453j, Context context) {
        this.f1217a = c0453j;
        this.f1218b = context;
    }

    public final void run() {
        List arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("src", "wenzisuoping");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Map hashMap = new HashMap();
            hashMap.put("param", jSONObject.toString());
            String a = C0452i.m991a("http://push.xinmei365.com/FontSDK/feedfont", hashMap);
            Message message;
            Map hashMap2;
            if (a == null || a.trim().length() <= 0 || "failed".equals(a)) {
                arrayList = C0446c.m981a();
                message = new Message();
                message.what = 2;
                hashMap2 = new HashMap();
                hashMap2.put("callback", this.f1217a);
                hashMap2.put("fonts", C0446c.m982a(this.f1218b, arrayList));
                message.obj = hashMap2;
                C0446c.f1208b.sendMessage(message);
            }
            JSONArray jSONArray = new JSONArray(a);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Font font = new Font();
                font.setFontId(jSONObject2.getInt("fontId"));
                font.setFontName(jSONObject2.getString("fontName"));
                font.setThumbnailUrl(jSONObject2.getString("fontPreviewUrl"));
                font.setDownloadUr(jSONObject2.getString("fontDownloadUrl"));
                font.setFontSize(jSONObject2.getLong("fontSize"));
                arrayList.add(font);
            }
            message = new Message();
            message.what = 2;
            hashMap2 = new HashMap();
            hashMap2.put("callback", this.f1217a);
            hashMap2.put("fonts", C0446c.m982a(this.f1218b, arrayList));
            message.obj = hashMap2;
            C0446c.f1208b.sendMessage(message);
        } catch (Exception e2) {
            Exception exception = e2;
            arrayList = C0446c.m981a();
            exception.printStackTrace();
        }
    }
}
