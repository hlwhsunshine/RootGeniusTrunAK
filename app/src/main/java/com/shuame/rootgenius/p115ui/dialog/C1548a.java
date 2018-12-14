package com.shuame.rootgenius.p115ui.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.changefontmanager.sdk.ChangeFontManager;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.ui.dialog.a */
final class C1548a implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ MyActivityDialog f4372a;

    C1548a(MyActivityDialog myActivityDialog) {
        this.f4372a = myActivityDialog;
    }

    public final void onClick(View view) {
        switch (view.getId()) {
            case C1450R.id.cancel:
                this.f4372a.f4371g;
                this.f4372a.finish();
                return;
            case C1450R.id.ok:
                switch (this.f4372a.f4371g) {
                    case 0:
                        ChangeFontManager.getInstance().getChangefont(this.f4372a).changeSuccessed(this.f4372a);
                        break;
                    case 1:
                        ChangeFontManager.getInstance().getChangefont(this.f4372a).changeSuccessed(this.f4372a);
                        break;
                    case 2:
                        MyActivityDialog.m4363d(this.f4372a);
                        break;
                }
                this.f4372a.finish();
                return;
            default:
                return;
        }
    }
}
