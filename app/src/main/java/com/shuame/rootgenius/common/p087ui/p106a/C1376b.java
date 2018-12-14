package com.shuame.rootgenius.common.p087ui.p106a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.shuame.rootgenius.common.C1335e.C1330c;
import com.shuame.rootgenius.common.C1335e.C1331d;
import com.shuame.rootgenius.common.C1335e.C1333f;

/* renamed from: com.shuame.rootgenius.common.ui.a.b */
public final class C1376b extends Dialog {
    /* renamed from: a */
    private Context f3825a = null;
    /* renamed from: b */
    private C1375a f3826b = null;
    /* renamed from: c */
    private View f3827c = null;
    /* renamed from: d */
    private TextView f3828d;
    /* renamed from: e */
    private View f3829e = null;
    /* renamed from: f */
    private OnClickListener f3830f = new C1377c(this);

    /* renamed from: com.shuame.rootgenius.common.ui.a.b$a */
    public static class C1375a {
        /* renamed from: a */
        public int f3817a = -1;
        /* renamed from: b */
        public int f3818b = -1;
        /* renamed from: c */
        public boolean f3819c = true;
        /* renamed from: d */
        public boolean f3820d = true;
        /* renamed from: e */
        public boolean f3821e = true;
        /* renamed from: f */
        public int f3822f = -1;
        /* renamed from: g */
        public int f3823g = -1;
        /* renamed from: h */
        public OnClickListener f3824h = null;
    }

    public C1376b(Context context, C1375a c1375a) {
        super(context, C1333f.dialog);
        this.f3825a = context;
        this.f3826b = c1375a;
        LayoutInflater from = LayoutInflater.from(this.f3825a);
        this.f3827c = from.inflate(C1331d.dialog_custom, null);
        this.f3828d = (TextView) this.f3827c.findViewById(C1330c.tv_content);
        if (this.f3826b.f3818b != -1) {
            ViewGroup viewGroup = (ViewGroup) this.f3827c.findViewById(C1330c.ll_custom_content);
            this.f3829e = from.inflate(this.f3826b.f3818b, null);
            viewGroup.addView(this.f3829e);
            viewGroup.setVisibility(0);
            this.f3828d.setVisibility(8);
        } else if (this.f3826b.f3817a != -1) {
            this.f3828d.setText(this.f3826b.f3817a);
        }
        if (this.f3826b.f3819c) {
            Button button = (Button) this.f3827c.findViewById(C1330c.btn_left);
            if (this.f3826b.f3820d) {
                if (this.f3826b.f3824h == null) {
                    button.setOnClickListener(this.f3830f);
                } else {
                    button.setOnClickListener(this.f3826b.f3824h);
                }
                if (this.f3826b.f3822f != -1) {
                    button.setText(this.f3826b.f3822f);
                }
            } else {
                button.setVisibility(8);
            }
            button = (Button) this.f3827c.findViewById(C1330c.btn_right);
            if (this.f3826b.f3821e) {
                if (this.f3826b.f3824h == null) {
                    button.setOnClickListener(this.f3830f);
                } else {
                    button.setOnClickListener(this.f3826b.f3824h);
                }
                if (this.f3826b.f3823g != -1) {
                    button.setText(this.f3826b.f3823g);
                }
            } else {
                button.setVisibility(8);
            }
        } else {
            this.f3827c.findViewById(C1330c.btn_layout).setVisibility(8);
        }
        setContentView(this.f3827c);
    }

    /* renamed from: a */
    public final View mo7091a() {
        return this.f3829e;
    }

    /* renamed from: b */
    public final View mo7092b() {
        return this.f3827c;
    }

    public final void show() {
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(262144);
            window.setWindowAnimations(0);
        }
        setCanceledOnTouchOutside(false);
        if (this.f3825a != null) {
            try {
                if (!(this.f3825a instanceof Activity)) {
                    super.show();
                } else if (!((Activity) this.f3825a).isFinishing()) {
                    super.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                dismiss();
            }
        }
    }
}
