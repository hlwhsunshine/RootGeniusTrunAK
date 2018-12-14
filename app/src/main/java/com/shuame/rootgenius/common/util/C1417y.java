package com.shuame.rootgenius.common.util;

import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.shuame.rootgenius.common.C1325c;
import com.shuame.rootgenius.common.C1335e.C1330c;
import com.shuame.rootgenius.common.C1335e.C1331d;

/* renamed from: com.shuame.rootgenius.common.util.y */
final class C1417y implements Callback {
    C1417y() {
    }

    public final boolean handleMessage(Message message) {
        String str = (String) message.obj;
        if (C1416x.f3908b == null) {
            C1416x.f3908b = Toast.makeText(C1325c.m3724a(), str, 0);
            C1416x.f3909c = View.inflate(C1325c.m3724a(), C1331d.toast, null);
            C1416x.f3908b.setView(C1416x.f3909c);
        }
        if (C1416x.f3908b != null) {
            ((TextView) C1416x.f3908b.getView().findViewById(C1330c.msg)).setText(str);
            C1416x.f3908b.show();
        }
        return false;
    }
}
