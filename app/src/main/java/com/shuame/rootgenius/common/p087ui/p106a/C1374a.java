package com.shuame.rootgenius.common.p087ui.p106a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

/* renamed from: com.shuame.rootgenius.common.ui.a.a */
public final class C1374a extends Dialog {
    /* renamed from: a */
    private Context f3815a = null;
    /* renamed from: b */
    private View f3816b = null;

    /* renamed from: com.shuame.rootgenius.common.ui.a.a$a */
    public static class C1373a {
        /* renamed from: a */
        public Context f3812a;
        /* renamed from: b */
        public int f3813b;
        /* renamed from: c */
        public int f3814c;
    }

    public C1374a(C1373a c1373a) {
        super(c1373a.f3812a, c1373a.f3813b);
        this.f3815a = c1373a.f3812a;
        this.f3816b = LayoutInflater.from(this.f3815a).inflate(c1373a.f3814c, null);
        setContentView(this.f3816b);
    }

    /* renamed from: a */
    public final View mo7089a() {
        return this.f3816b;
    }

    public final void show() {
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(262144);
            window.setWindowAnimations(0);
        }
        setCanceledOnTouchOutside(false);
        if (this.f3815a != null) {
            try {
                if (!(this.f3815a instanceof Activity)) {
                    super.show();
                } else if (!((Activity) this.f3815a).isFinishing()) {
                    super.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                dismiss();
            }
        }
    }
}
