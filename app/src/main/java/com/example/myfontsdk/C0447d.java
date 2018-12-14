package com.example.myfontsdk;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Map;

/* renamed from: com.example.myfontsdk.d */
final class C0447d extends Handler {
    C0447d(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        Map map;
        Object obj;
        switch (message.what) {
            case 0:
                map = (Map) message.obj;
                ((C0459q) map.get("callback")).mo5359a((Typeface) map.get("typeface"));
                return;
            case 1:
                obj = message.obj;
                return;
            case 2:
                map = (Map) message.obj;
                map.get("callback");
                map.get("fonts");
                return;
            case 3:
                obj = message.obj;
                return;
            default:
                return;
        }
    }
}
