package com.shuame.rootgenius.p115ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.p015v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.C1029c;
import com.nostra13.universalimageloader.core.C1029c.C1025a;
import com.nostra13.universalimageloader.core.C1033d;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p115ui.adapter.C1519l;
import com.shuame.rootgenius.p115ui.view.MyViewPager;
import java.util.ArrayList;

/* renamed from: com.shuame.rootgenius.ui.FullViewPageActivity */
public class FullViewPageActivity extends Activity implements OnPageChangeListener {
    /* renamed from: a */
    static ArrayList<View> f4199a = new ArrayList();
    /* renamed from: b */
    private static final String f4200b = FullViewPageActivity.class.getSimpleName();
    /* renamed from: c */
    private MyViewPager f4201c;
    /* renamed from: d */
    private ArrayList<String> f4202d;
    /* renamed from: e */
    private C1029c f4203e;

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.full_viewpager);
        Intent intent = getIntent();
        ArrayList arrayList = new ArrayList();
        int flags = intent.getFlags();
        if (intent.getParcelableArrayListExtra("imageList") != null) {
            this.f4202d = intent.getStringArrayListExtra("imageList");
        }
        this.f4203e = new C1025a().mo6247a(true).mo6241a().mo6242a((int) C1450R.drawable.font_default_preview).mo6248b((int) C1450R.drawable.font_default_preview).mo6250c((int) C1450R.drawable.font_default_preview).mo6249b();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f4202d.size()) {
                ImageView imageView = (ImageView) getLayoutInflater().inflate(C1450R.layout.full_viewpager_item, null);
                imageView.setOnClickListener(new C1614x(this));
                C1033d.m2984a().mo6285a((String) this.f4202d.get(i2), imageView, this.f4203e);
                arrayList.add(imageView);
                i = i2 + 1;
            } else {
                this.f4201c = (MyViewPager) findViewById(C1450R.id.view_pager);
                this.f4201c.setAdapter(new C1519l(arrayList));
                this.f4201c.setCurrentItem(flags);
                return;
            }
        }
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
    }
}
