package com.shuame.rootgenius.p115ui;

import android.widget.ScrollView;
import com.loopj.android.http.C0911e;
import com.shuame.rootgenius.common.util.C1404n;
import com.shuame.rootgenius.hook.C1450R;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.shuame.rootgenius.ui.l */
final class C1597l extends C0911e {
    /* renamed from: a */
    final /* synthetic */ FontPreviewActivity f4388a;

    C1597l(FontPreviewActivity fontPreviewActivity) {
        this.f4388a = fontPreviewActivity;
    }

    /* renamed from: a */
    public final void mo6011a(int i, String str) {
        super.mo6011a(i, str);
        try {
            FontPreviewActivity.m4220a(this.f4388a, (ArrayList) C1404n.m3906a(new JSONObject(str)).get(String.valueOf(this.f4388a.f4168j.getFontId())));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void mo6013a(Throwable th, String str) {
        super.mo6013a(th, str);
        ((ScrollView) this.f4388a.findViewById(C1450R.id.view_Default)).setVisibility(0);
        this.f4388a.f4173o.setVisibility(8);
        this.f4388a.f4176r.setVisibility(8);
        this.f4388a.f4163d.setVisibility(8);
    }
}
