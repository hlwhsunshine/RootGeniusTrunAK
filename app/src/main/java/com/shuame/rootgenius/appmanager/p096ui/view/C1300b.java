package com.shuame.rootgenius.appmanager.p096ui.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.nineoldandroids.p054a.C0932g;
import com.nineoldandroids.p054a.C0935i;
import com.nineoldandroids.p054a.C0954y;

/* renamed from: com.shuame.rootgenius.appmanager.ui.view.b */
public final class C1300b {
    /* renamed from: a */
    int f3536a = 60;
    /* renamed from: b */
    private C1299a[] f3537b;
    /* renamed from: c */
    private float f3538c;
    /* renamed from: d */
    private float f3539d;
    /* renamed from: e */
    private float f3540e;
    /* renamed from: f */
    private ImageView f3541f;
    /* renamed from: g */
    private View f3542g;
    /* renamed from: h */
    private Context f3543h;

    /* renamed from: com.shuame.rootgenius.appmanager.ui.view.b$a */
    public static class C1299a {
        /* renamed from: a */
        float f3534a;
        /* renamed from: b */
        float f3535b;

        public C1299a(float f, float f2) {
            this.f3534a = f;
            this.f3535b = f2;
        }
    }

    public C1300b(Context context, ImageView imageView, View view) {
        this.f3541f = imageView;
        this.f3542g = view;
        this.f3543h = context;
    }

    /* renamed from: a */
    private void m3670a(C1299a c1299a, C1299a c1299a2) {
        this.f3537b = new C1299a[this.f3536a];
        for (int i = 0; i < this.f3536a; i++) {
            float f = c1299a.f3534a + (((c1299a2.f3534a - c1299a.f3534a) * ((float) i)) / ((float) this.f3536a));
            this.f3537b[i] = new C1299a(f, (((this.f3538c * f) * f) + (this.f3539d * f)) + this.f3540e);
        }
    }

    /* renamed from: a */
    public final void mo6969a() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.f3543h).getWindow().getDecorView();
        View view = this.f3542g;
        int width = this.f3541f.getWidth();
        new StringBuilder("fromViewWidth: ").append(width).append(" fromViewheight: ").append(this.f3541f.getHeight());
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        this.f3541f.getLocationInWindow(iArr);
        viewGroup.getLocationInWindow(iArr2);
        int i = iArr[0] - iArr2[0];
        width = iArr[1] - iArr2[1];
        new StringBuilder("afterfix animationLeft: ").append(i).append(" animationTop: ").append(width);
        View imageView = new ImageView(this.f3543h);
        imageView.setImageDrawable(this.f3541f.getDrawable().getConstantState().newDrawable());
        imageView.setBackgroundColor(0);
        imageView.setScaleType(ScaleType.FIT_XY);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(90, 90);
        layoutParams.setMargins(i, width, 0, 0);
        layoutParams.gravity = 51;
        imageView.setLayoutParams(layoutParams);
        viewGroup.addView(imageView);
        this.f3541f.setVisibility(8);
        int[] iArr3 = new int[2];
        view.getLocationOnScreen(iArr3);
        int i2 = iArr3[0] - iArr2[0];
        int i3 = iArr3[1] - iArr2[1];
        new StringBuilder("toX->").append(i2).append(" toY->").append(i3);
        C1299a c1299a = new C1299a((float) i, (float) width);
        C1299a c1299a2 = new C1299a((float) ((view.getWidth() / 2) + i2), (float) (i3 + 150));
        float f = c1299a.f3534a;
        float f2 = c1299a.f3535b;
        float f3 = c1299a.f3534a + 20.0f;
        float f4 = c1299a.f3535b - 50.0f;
        float f5 = c1299a2.f3534a;
        this.f3538c = ((c1299a2.f3535b * (f - f3)) + (((f3 - f5) * f2) + ((f5 - f) * f4))) / (((f5 * f5) * (f - f3)) + (((f * f) * (f3 - f5)) + ((f3 * f3) * (f5 - f))));
        this.f3539d = ((f2 - f4) / (f - f3)) - ((f3 + f) * this.f3538c);
        this.f3540e = (f2 - ((f * f) * this.f3538c)) - (f * this.f3539d);
        new StringBuilder("-a->").append(this.f3538c).append(" b->").append(this.f3539d).append(" c->").append(this.f3540e);
        m3670a(c1299a, c1299a2);
        C0932g[] c0932gArr = new C0932g[this.f3537b.length];
        C0932g[] c0932gArr2 = new C0932g[this.f3537b.length];
        f2 = 1.0f / ((float) this.f3537b.length);
        float f6 = f2;
        for (int i4 = 0; i4 < this.f3537b.length; i4++) {
            c0932gArr[i4] = C0932g.m2565a(f6, this.f3537b[i4].f3534a);
            c0932gArr2[i4] = C0932g.m2565a(f6, this.f3537b[i4].f3535b);
            f6 += f2;
        }
        C0954y a = C0954y.m2629a("x", c0932gArr);
        C0935i e = C0935i.m2580a(imageView, C0954y.m2629a("y", c0932gArr2), a).mo6065e();
        e.mo6035a(new LinearInterpolator());
        e.mo6026a();
        e.mo6027a(new C1301c(this, viewGroup, imageView));
    }
}
