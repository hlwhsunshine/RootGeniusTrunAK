package com.baidu.mobads.p033g;

import android.content.Context;
import android.support.p015v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.p021j.C0338m;

/* renamed from: com.baidu.mobads.g.d */
public class C0291d extends LinearLayout {
    /* renamed from: a */
    protected C0290b f529a;
    /* renamed from: b */
    private Context f530b;
    /* renamed from: c */
    private IXAdCommonUtils f531c = C0338m.m569a().mo5040m();

    /* renamed from: com.baidu.mobads.g.d$a */
    class C0289a extends TextView {
        public C0289a(Context context, String str) {
            super(context);
            m398a(str);
        }

        /* renamed from: a */
        private void m398a(String str) {
            setText(str);
            setTextColor(ViewCompat.MEASURED_STATE_MASK);
            setGravity(17);
            setBackgroundColor(-1);
            setTextSize(19.0f);
            setLayoutParams(new LayoutParams(-1, C0291d.this.f531c.getPixel(C0291d.this.f530b, 50)));
        }
    }

    /* renamed from: com.baidu.mobads.g.d$b */
    public interface C0290b {
        /* renamed from: a */
        void mo4471a();

        /* renamed from: b */
        void mo4472b();

        /* renamed from: c */
        void mo4473c();
    }

    public C0291d(Context context) {
        super(context);
        this.f530b = context;
        setBackgroundColor(-2236963);
        setOrientation(1);
        View c0289a = new C0289a(context, "刷新");
        LayoutParams layoutParams = (LayoutParams) c0289a.getLayoutParams();
        layoutParams.bottomMargin = this.f531c.getPixel(this.f530b, 2);
        addView(c0289a, layoutParams);
        View c0289a2 = new C0289a(context, "复制网址");
        layoutParams = (LayoutParams) c0289a2.getLayoutParams();
        layoutParams.bottomMargin = this.f531c.getPixel(this.f530b, 4);
        addView(c0289a2, layoutParams);
        View c0289a3 = new C0289a(context, "取消");
        addView(c0289a3);
        c0289a.setOnClickListener(new C0292e(this));
        c0289a2.setOnClickListener(new C0293f(this));
        c0289a3.setOnClickListener(new C0294g(this));
    }

    /* renamed from: a */
    public void mo4474a(C0290b c0290b) {
        this.f529a = c0290b;
    }
}
