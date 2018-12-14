package com.shuame.rootgenius.p115ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p015v4.view.ViewPager;
import android.support.p015v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.shuame.rootgenius.C1446g;
import com.shuame.rootgenius.common.util.C1416x;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p115ui.adapter.C1520m;
import com.shuame.rootgenius.p115ui.homepage.HomepageActivity;
import com.shuame.rootgenius.sdk.CommUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.shuame.rootgenius.ui.GuideActivity */
public class GuideActivity extends Activity implements OnPageChangeListener {
    /* renamed from: a */
    public static boolean f4204a = false;
    /* renamed from: b */
    private ViewPager f4205b;
    /* renamed from: c */
    private ViewGroup f4206c;
    /* renamed from: d */
    private C1520m f4207d;
    /* renamed from: e */
    private List<Drawable> f4208e = new ArrayList();
    /* renamed from: f */
    private int f4209f;
    /* renamed from: g */
    private View f4210g;
    /* renamed from: h */
    private int f4211h;
    /* renamed from: i */
    private OnClickListener f4212i = new C1616z(this);
    /* renamed from: j */
    private long f4213j = 0;

    /* renamed from: a */
    private void m4251a() {
        try {
            this.f4209f = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
            C1446g.m4003a();
            if (C1446g.m4016j() < this.f4209f) {
                TypedArray obtainTypedArray = getResources().obtainTypedArray(C1450R.array.sample_images);
                if (obtainTypedArray != null) {
                    for (int i = 0; i < obtainTypedArray.length(); i++) {
                        this.f4208e.add(obtainTypedArray.getDrawable(i));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onBackPressed() {
        if (System.currentTimeMillis() - this.f4213j > 2000) {
            C1416x.m3936a((int) C1450R.string.string_exit);
            this.f4213j = System.currentTimeMillis();
            return;
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle) {
        ImageView imageView;
        super.onCreate(bundle);
        setContentView(C1450R.layout.activity_guide);
        C1446g.m4003a();
        if (C1446g.m4017k()) {
            m4251a();
        } else {
            this.f4208e.add(getResources().getDrawable(C1450R.drawable.guide1));
            m4251a();
            this.f4208e.add(null);
        }
        List arrayList = new ArrayList();
        this.f4205b = (ViewPager) findViewById(C1450R.id.view_pager);
        this.f4206c = (ViewGroup) findViewById(C1450R.id.page_indicator);
        C1446g.m4003a();
        int i;
        if (C1446g.m4017k()) {
            for (i = 0; i < this.f4208e.size(); i++) {
                imageView = (ImageView) getLayoutInflater().inflate(C1450R.layout.view_guide_img, null);
                imageView.setImageDrawable((Drawable) this.f4208e.get(i));
                arrayList.add(imageView);
            }
            f4204a = true;
            imageView = (ImageView) getLayoutInflater().inflate(C1450R.layout.view_guide_img, null);
            imageView.setImageResource(C1450R.drawable.global_new_background_bg);
            arrayList.add(imageView);
        } else {
            for (i = 0; i < this.f4208e.size() - 1; i++) {
                imageView = (ImageView) getLayoutInflater().inflate(C1450R.layout.view_guide_img, null);
                imageView.setImageDrawable((Drawable) this.f4208e.get(i));
                arrayList.add(imageView);
            }
            this.f4210g = getLayoutInflater().inflate(C1450R.layout.view_login, null);
            ((TextView) this.f4210g.findViewById(C1450R.id.tv_ver)).setText(String.format("v%s", new Object[]{CommUtils.getVersionName(this)}));
            this.f4210g.findViewById(C1450R.id.iv_logo_name).setOnClickListener(this.f4212i);
            ((CheckBox) this.f4210g.findViewById(C1450R.id.cb_check)).setOnCheckedChangeListener(new C1615y(this));
            this.f4210g.findViewById(C1450R.id.tv_read_treaty).setOnClickListener(this.f4212i);
            this.f4210g.findViewById(C1450R.id.btn_login).setOnClickListener(this.f4212i);
            arrayList.add(this.f4210g);
            f4204a = false;
        }
        int i2 = 0;
        while (i2 < this.f4208e.size()) {
            imageView = (ImageView) getLayoutInflater().inflate(C1450R.layout.view_guide_dot, null);
            imageView.setImageResource(C1450R.drawable.selector_guide_dot);
            imageView.setEnabled(i2 == 0);
            this.f4206c.addView(imageView, new LayoutParams(-2, -2));
            i2++;
        }
        this.f4207d = new C1520m(arrayList);
        this.f4205b.setAdapter(this.f4207d);
        this.f4205b.setOnPageChangeListener(this);
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        int i2;
        if (f4204a) {
            this.f4206c.setVisibility(0);
            if (i == this.f4208e.size()) {
                startActivity(new Intent(this, HomepageActivity.class));
                C1446g.m4003a();
                C1446g.m4004a(this.f4209f);
                finish();
                return;
            }
            i2 = 0;
            while (i2 < this.f4208e.size()) {
                this.f4206c.getChildAt(i2).setEnabled(i2 == i);
                i2++;
            }
        } else if (i == this.f4208e.size() - 1) {
            this.f4206c.setVisibility(8);
        } else {
            i2 = 0;
            while (i2 < this.f4208e.size()) {
                this.f4206c.getChildAt(i2).setEnabled(i2 == i);
                i2++;
            }
            this.f4206c.setVisibility(0);
        }
    }
}
