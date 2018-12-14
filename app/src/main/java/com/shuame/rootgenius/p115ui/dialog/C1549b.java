package com.shuame.rootgenius.p115ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.ui.dialog.b */
public final class C1549b extends Dialog {
    /* renamed from: a */
    private ImageView f4373a = ((ImageView) findViewById(C1450R.id.icon));
    /* renamed from: b */
    private TextView f4374b = ((TextView) findViewById(C1450R.id.message));
    /* renamed from: c */
    private Button f4375c = ((Button) findViewById(C1450R.id.cancel));
    /* renamed from: d */
    private Button f4376d = ((Button) findViewById(C1450R.id.ok));

    public C1549b(Context context) {
        super(context, C1450R.style.MyDialog);
        setContentView(C1450R.layout.alert_dialog);
        setCanceledOnTouchOutside(false);
        this.f4375c.setVisibility(8);
        this.f4376d.setVisibility(8);
    }

    /* renamed from: a */
    public final void mo7449a(int i) {
        this.f4374b.setText(i);
    }

    /* renamed from: a */
    public final void mo7450a(int i, OnClickListener onClickListener) {
        if (i > 0) {
            this.f4375c.setText(i);
        }
        this.f4375c.setOnClickListener(onClickListener);
        this.f4375c.setVisibility(0);
    }

    /* renamed from: b */
    public final void mo7451b(int i, OnClickListener onClickListener) {
        if (i > 0) {
            this.f4376d.setText(i);
        }
        this.f4376d.setOnClickListener(onClickListener);
        this.f4376d.setVisibility(0);
    }
}
