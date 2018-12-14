package com.shuame.rootgenius.p115ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p110g.C1435a;
import com.shuame.rootgenius.pojo.FeedBackBean;
import com.shuame.rootgenius.pojo.FeedBackBean.FeedBackInfo;
import com.shuame.rootgenius.pojo.FeedBackBean.FeedBackInfo.FeedBackForm;
import com.shuame.rootgenius.pojo.FeedBackBean.FeedBackInfo.FeedBackForm.C1458a;
import com.shuame.rootgenius.pojo.FeedBackBean.FeedBackInfo.FeedBackForm.FeedBackType;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/* renamed from: com.shuame.rootgenius.ui.FeedBackDetailActivity */
public class FeedBackDetailActivity extends Activity implements OnClickListener, OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {
    /* renamed from: a */
    private static final String f4133a = FeedBackDetailActivity.class.getSimpleName();
    /* renamed from: b */
    private C1435a f4134b;
    /* renamed from: c */
    private FeedBackBean f4135c;
    /* renamed from: d */
    private LinearLayout f4136d;
    /* renamed from: e */
    private int f4137e = 0;
    /* renamed from: f */
    private List<FeedBackForm> f4138f;
    /* renamed from: g */
    private HashSet<Integer> f4139g = new HashSet();
    /* renamed from: h */
    private String f4140h = "";
    /* renamed from: i */
    private String f4141i = "";
    /* renamed from: j */
    private String f4142j = "";
    /* renamed from: k */
    private String f4143k = "";
    /* renamed from: l */
    private int f4144l;
    /* renamed from: m */
    private int f4145m;
    /* renamed from: n */
    private LayoutParams f4146n;
    /* renamed from: o */
    private EditText f4147o;
    /* renamed from: p */
    private Drawable f4148p;
    /* renamed from: q */
    private Drawable f4149q;
    /* renamed from: r */
    private Drawable f4150r;
    /* renamed from: s */
    private Drawable f4151s;

    /* renamed from: a */
    private String m4210a(FeedBackForm feedBackForm, View view) {
        if (!feedBackForm.f3994c) {
            return "";
        }
        if (feedBackForm.f3992a == FeedBackType.single_select) {
            if (((RadioGroup) view).getCheckedRadioButtonId() != -1) {
                new StringBuilder("本题单选，已选择id：").append(((RadioGroup) view).getCheckedRadioButtonId());
                return "";
            }
        } else if (feedBackForm.f3992a == FeedBackType.multi_select) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= feedBackForm.f3998g.size()) {
                    break;
                } else if (this.f4139g.contains(Integer.valueOf(((C1458a) feedBackForm.f3998g.get(i2)).f3991b))) {
                    return "";
                } else {
                    i = i2 + 1;
                }
            }
        } else if (feedBackForm.f3992a == FeedBackType.texts && !((EditText) view).getText().toString().isEmpty()) {
            new StringBuilder("本题填空，已填写：").append(((EditText) view).getText().toString());
            return "";
        }
        return feedBackForm.f3995d;
    }

    /* renamed from: a */
    private void m4211a() {
        new C1379b(findViewById(C1450R.id.v_titlebar), (Activity) this, (int) C1450R.string.more_quick_feedback).mo7105b();
        this.f4136d = (LinearLayout) findViewById(C1450R.id.feedback_detail_ll);
        ((Button) findViewById(C1450R.id.feedback_detail_commit_btn)).setOnClickListener(this);
        this.f4147o = (EditText) findViewById(C1450R.id.feedback_detail_contact_et);
        for (int i = 0; i < this.f4138f.size(); i++) {
            LinearLayout linearLayout;
            int i2;
            FeedBackForm feedBackForm;
            if (((FeedBackForm) this.f4138f.get(i)).f3992a == FeedBackType.single_select) {
                View radioGroup = new RadioGroup(this);
                radioGroup.setTag(this.f4138f.get(i));
                TextView textView = new TextView(this);
                textView.setText(((FeedBackForm) this.f4138f.get(i)).f3993b);
                m4213a(textView, i);
                linearLayout = this.f4136d;
                i2 = this.f4137e;
                this.f4137e = i2 + 1;
                linearLayout.addView(textView, i2);
                feedBackForm = (FeedBackForm) this.f4138f.get(i);
                for (int i3 = 0; i3 < feedBackForm.f3998g.size(); i3++) {
                    RadioButton radioButton = (RadioButton) View.inflate(this, C1450R.layout.view_feedback_radiobtn, null);
                    radioButton.setId(((C1458a) feedBackForm.f3998g.get(i3)).f3991b);
                    radioButton.setText(((C1458a) feedBackForm.f3998g.get(i3)).f3990a);
                    radioButton.setOnClickListener(this);
                    radioGroup.addView(radioButton, i3, this.f4146n);
                    radioGroup.setOnCheckedChangeListener(this);
                }
                linearLayout = this.f4136d;
                int i4 = this.f4137e;
                this.f4137e = i4 + 1;
                linearLayout.addView(radioGroup, i4);
            } else if (((FeedBackForm) this.f4138f.get(i)).f3992a == FeedBackType.multi_select) {
                m4212a(i);
            } else if (((FeedBackForm) this.f4138f.get(i)).f3992a == FeedBackType.texts) {
                feedBackForm = (FeedBackForm) this.f4138f.get(i);
                EditText editText = (EditText) View.inflate(this, C1450R.layout.view_feedback_edittext, null);
                editText.setTag(feedBackForm);
                editText.setHint(feedBackForm.f3996e);
                editText.setFilters(new InputFilter[]{new LengthFilter(feedBackForm.f3997f)});
                ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.setMargins(0, this.f4144l / 2, 0, 0);
                }
                editText.setLayoutParams(layoutParams);
                linearLayout = this.f4136d;
                i2 = this.f4137e;
                this.f4137e = i2 + 1;
                linearLayout.addView(editText, i2);
            }
        }
    }

    /* renamed from: a */
    private void m4212a(int i) {
        TextView textView = new TextView(this);
        textView.setText(((FeedBackForm) this.f4138f.get(i)).f3993b);
        m4213a(textView, i);
        LinearLayout linearLayout = this.f4136d;
        int i2 = this.f4137e;
        this.f4137e = i2 + 1;
        linearLayout.addView(textView, i2);
        FeedBackForm feedBackForm = (FeedBackForm) this.f4138f.get(i);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < feedBackForm.f3998g.size()) {
                CheckBox checkBox = (CheckBox) View.inflate(this, C1450R.layout.view_feedback_checkbox, null);
                checkBox.setId(((C1458a) feedBackForm.f3998g.get(i4)).f3991b);
                checkBox.setText(((C1458a) feedBackForm.f3998g.get(i4)).f3990a);
                checkBox.setOnClickListener(this);
                checkBox.setOnCheckedChangeListener(this);
                LinearLayout linearLayout2 = this.f4136d;
                int i5 = this.f4137e;
                this.f4137e = i5 + 1;
                linearLayout2.addView(checkBox, i5, this.f4146n);
                i3 = i4 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m4213a(TextView textView, int i) {
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        if (i == 0) {
            layoutParams.setMargins(this.f4144l, this.f4145m, 0, this.f4145m);
        } else {
            layoutParams.setMargins(this.f4144l, this.f4145m * 3, 0, this.f4145m);
        }
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(getResources().getColor(C1450R.color.feedback_gray));
    }

    /* renamed from: a */
    private void m4214a(HashSet<Integer> hashSet, HashSet<Integer> hashSet2) {
        Object obj;
        hashSet.addAll(hashSet2);
        TreeSet treeSet = new TreeSet(hashSet);
        treeSet.comparator();
        String replace = treeSet.toString().replace(" ", "");
        this.f4141i = replace.substring(1, replace.length() - 1);
        new StringBuilder("choice_str:").append(this.f4141i);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.f4138f.size(); i++) {
            if (((FeedBackForm) this.f4138f.get(i)).f3992a == FeedBackType.texts) {
                obj = ((EditText) this.f4136d.findViewWithTag(this.f4138f.get(i))).getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    stringBuffer.append(obj + "||");
                }
            }
        }
        this.f4142j = stringBuffer.toString();
        if (this.f4142j.length() > 2 && this.f4142j.endsWith("||")) {
            this.f4142j = this.f4142j.substring(0, this.f4142j.length() - 2);
        }
        new StringBuilder("content_str:").append(this.f4142j);
        obj = this.f4147o.getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            this.f4143k = obj;
        }
        new StringBuilder("contact_str:").append(this.f4143k);
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            compoundButton.setCompoundDrawables(this.f4150r, null, null, null);
            this.f4139g.add(Integer.valueOf(compoundButton.getId()));
            return;
        }
        compoundButton.setCompoundDrawables(this.f4151s, null, null, null);
        this.f4139g.remove(Integer.valueOf(compoundButton.getId()));
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        new StringBuilder("group.checked_btnid:").append(radioGroup.getCheckedRadioButtonId());
        ((RadioButton) findViewById(i)).setCompoundDrawables(this.f4148p, null, null, null);
        new StringBuilder("group.btncount:").append(radioGroup.getChildCount());
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < radioGroup.getChildCount()) {
                RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i3);
                if (radioButton.getId() != i) {
                    radioButton.setCompoundDrawables(this.f4149q, null, null, null);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0076  */
    public void onClick(android.view.View r8) {
        /*
        r7 = this;
        r6 = -1;
        r0 = r8.getId();
        switch(r0) {
            case 2131427344: goto L_0x0009;
            default: goto L_0x0008;
        };
    L_0x0008:
        return;
    L_0x0009:
        r0 = com.shuame.rootgenius.common.util.NetworkUtils.m3851a(r7);
        if (r0 == 0) goto L_0x00ad;
    L_0x000f:
        r4 = new java.util.HashSet;
        r4.<init>();
        r1 = "";
        r0 = 0;
        r2 = r0;
        r0 = r1;
    L_0x0019:
        r1 = r7.f4138f;
        r1 = r1.size();
        if (r2 >= r1) goto L_0x00b5;
    L_0x0021:
        r0 = r7.f4138f;
        r0 = r0.get(r2);
        r0 = (com.shuame.rootgenius.pojo.FeedBackBean.FeedBackInfo.FeedBackForm) r0;
        r1 = r7.f4136d;
        r3 = r7.f4138f;
        r3 = r3.get(r2);
        r1 = r1.findViewWithTag(r3);
        r3 = r7.m4210a(r0, r1);
        r0 = r7.f4138f;
        r0 = r0.get(r2);
        r0 = (com.shuame.rootgenius.pojo.FeedBackBean.FeedBackInfo.FeedBackForm) r0;
        r1 = r7.f4136d;
        r5 = r7.f4138f;
        r5 = r5.get(r2);
        r1 = r1.findViewWithTag(r5);
        r0 = r0.f3992a;
        r5 = com.shuame.rootgenius.pojo.FeedBackBean.FeedBackInfo.FeedBackForm.FeedBackType.single_select;
        if (r0 != r5) goto L_0x00a5;
    L_0x0053:
        r0 = r1;
        r0 = (android.widget.RadioGroup) r0;
        r0 = r0.getCheckedRadioButtonId();
        if (r0 == r6) goto L_0x00a5;
    L_0x005c:
        r1 = (android.widget.RadioGroup) r1;
        r0 = r1.getCheckedRadioButtonId();
        r0 = java.lang.Integer.valueOf(r0);
    L_0x0066:
        if (r0 == 0) goto L_0x006b;
    L_0x0068:
        r4.add(r0);
    L_0x006b:
        r0 = "";
        if (r3 == r0) goto L_0x00a7;
    L_0x006f:
        com.shuame.rootgenius.common.util.C1416x.m3937a(r3);
    L_0x0072:
        r0 = "";
        if (r3 != r0) goto L_0x0008;
    L_0x0076:
        r0 = r7.f4139g;
        r7.m4214a(r4, r0);
        r0 = new com.shuame.rootgenius.common.event.f;
        r0.<init>();
        r1 = r7.f4140h;
        r2 = r7.f4141i;
        r3 = r7.f4142j;
        r4 = r7.f4143k;
        r0.f3648a = r1;
        r0.f3649b = r2;
        r0.f3650c = r3;
        r0.f3651d = r4;
        r1 = com.shuame.rootgenius.common.event.C1342g.m3746a();
        r1.mo7012a(r0);
        r0 = 2131492914; // 0x7f0c0032 float:1.8609293E38 double:1.053097423E-314;
        com.shuame.rootgenius.common.util.C1416x.m3936a(r0);
        r7.setResult(r6);
        r7.finish();
        goto L_0x0008;
    L_0x00a5:
        r0 = 0;
        goto L_0x0066;
    L_0x00a7:
        r0 = r2 + 1;
        r2 = r0;
        r0 = r3;
        goto L_0x0019;
    L_0x00ad:
        r0 = 2131493077; // 0x7f0c00d5 float:1.8609624E38 double:1.0530975037E-314;
        com.shuame.rootgenius.common.util.C1416x.m3936a(r0);
        goto L_0x0008;
    L_0x00b5:
        r3 = r0;
        goto L_0x0072;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.ui.FeedBackDetailActivity.onClick(android.view.View):void");
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.activity_feedback_detail);
        this.f4134b = C1435a.m3973a((Context) this);
        this.f4135c = this.f4134b.mo7154a();
        int intExtra = getIntent().getIntExtra("selectedProbId", 0);
        this.f4140h = String.valueOf(intExtra);
        for (int i = 0; i < this.f4135c.feedbacks.size(); i++) {
            if (((FeedBackInfo) this.f4135c.feedbacks.get(i)).f4000b == intExtra) {
                this.f4138f = ((FeedBackInfo) this.f4135c.feedbacks.get(i)).f4001c;
            }
        }
        this.f4144l = getResources().getDisplayMetrics().widthPixels / 18;
        this.f4145m = this.f4144l / 4;
        this.f4146n = new LayoutParams(-1, -2);
        this.f4148p = getResources().getDrawable(C1450R.drawable.feedback_schoice_checked);
        this.f4148p.setBounds(0, 0, this.f4148p.getMinimumWidth(), this.f4148p.getMinimumHeight());
        this.f4149q = getResources().getDrawable(C1450R.drawable.feedback_schoice_unchecked);
        this.f4149q.setBounds(0, 0, this.f4148p.getMinimumWidth(), this.f4148p.getMinimumHeight());
        this.f4150r = getResources().getDrawable(C1450R.drawable.feedback_mchoice_checked);
        this.f4150r.setBounds(0, 0, this.f4150r.getMinimumWidth(), this.f4150r.getMinimumHeight());
        this.f4151s = getResources().getDrawable(C1450R.drawable.feedback_mchoice_unchecked);
        this.f4151s.setBounds(0, 0, this.f4151s.getMinimumWidth(), this.f4151s.getMinimumHeight());
        m4211a();
    }
}
