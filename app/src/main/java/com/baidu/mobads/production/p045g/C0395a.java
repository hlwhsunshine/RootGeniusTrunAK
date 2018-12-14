package com.baidu.mobads.production.p045g;

import android.app.Activity;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;

/* renamed from: com.baidu.mobads.production.g.a */
public interface C0395a {
    /* renamed from: a */
    void mo5207a(int i, int i2);

    /* renamed from: a */
    void mo5208a(Activity activity);

    /* renamed from: a */
    void mo5209a(Activity activity, RelativeLayout relativeLayout);

    /* renamed from: a */
    boolean mo5210a(int i, KeyEvent keyEvent);

    void addEventListener(String str, IOAdEventListener iOAdEventListener);

    /* renamed from: l */
    void mo5212l();

    /* renamed from: m */
    void mo5213m();

    /* renamed from: r */
    boolean mo5214r();

    void request();
}
