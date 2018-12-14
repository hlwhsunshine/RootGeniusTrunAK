package com.shuame.rootgenius.p115ui.view;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.nostra13.universalimageloader.core.C1029c;
import com.nostra13.universalimageloader.core.C1029c.C1025a;
import com.nostra13.universalimageloader.core.C1033d;
import com.shuame.rootgenius.common.util.C1413u;
import com.shuame.rootgenius.hook.C1450R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.shuame.rootgenius.ui.view.ScreenShotScrollView */
public class ScreenShotScrollView extends HorizontalScrollView {
    /* renamed from: a */
    private List<ImageView> f4545a;
    /* renamed from: b */
    private List<String> f4546b;
    /* renamed from: c */
    private Handler f4547c;
    /* renamed from: d */
    private int f4548d = -1;
    /* renamed from: e */
    private C1544a f4549e;
    /* renamed from: f */
    private LinearLayout f4550f;
    /* renamed from: g */
    private C1029c f4551g;

    /* renamed from: com.shuame.rootgenius.ui.view.ScreenShotScrollView$a */
    public interface C1544a {
    }

    public ScreenShotScrollView(Context context) {
        super(context);
        m4382a();
    }

    public ScreenShotScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4382a();
    }

    public ScreenShotScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4382a();
    }

    /* renamed from: a */
    private void m4382a() {
        this.f4547c = new Handler();
        this.f4545a = new ArrayList();
        this.f4546b = new ArrayList();
        this.f4550f = new LinearLayout(getContext());
        this.f4550f.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.f4550f);
        this.f4551g = new C1025a().mo6247a(false).mo6241a().mo6243a(Config.RGB_565).mo6242a((int) C1450R.drawable.def_lager_icon).mo6248b((int) C1450R.drawable.def_lager_icon).mo6250c((int) C1450R.drawable.def_lager_icon).mo6249b();
    }

    /* renamed from: b */
    private void m4383b() {
        for (ImageView imageView : this.f4545a) {
            if (imageView != null) {
                imageView.setOnClickListener(new C1611b(this));
            }
            if (imageView != null) {
                imageView.setOnLongClickListener(new C1612c(this));
            }
        }
    }

    private void getImages() {
        int i = getContext().getResources().getDisplayMetrics().widthPixels;
        for (int i2 = 0; i2 < this.f4546b.size(); i2++) {
            String str = (String) this.f4546b.get(i2);
            View imageView = new ImageView(getContext());
            imageView.setTag(C1450R.id.tag_data, Integer.valueOf(i2));
            if (getContext().getResources().getDisplayMetrics() != null) {
                imageView.setLayoutParams(new LayoutParams((i * 2) / 3, -1));
                imageView.setPadding(C1413u.m3930a(getContext(), 10), 0, C1413u.m3930a(getContext(), 10), 0);
                imageView.setScaleType(ScaleType.FIT_XY);
            }
            this.f4545a.add(imageView);
            C1033d.m2984a().mo6285a(str, imageView, this.f4551g);
            this.f4550f.addView(imageView);
        }
    }

    public void setData(List<String> list) {
        if (list != null) {
            this.f4546b = list;
        } else {
            this.f4546b = new ArrayList();
        }
        getImages();
        m4383b();
    }

    public void setDefaultIcon(int i) {
        this.f4548d = i;
    }

    public void setOnScrollViewListener(C1544a c1544a) {
        this.f4549e = c1544a;
        m4383b();
    }
}
