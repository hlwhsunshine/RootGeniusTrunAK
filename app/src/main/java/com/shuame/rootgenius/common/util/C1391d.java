package com.shuame.rootgenius.common.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.C1029c.C1025a;
import com.nostra13.universalimageloader.core.C1033d;
import com.nostra13.universalimageloader.core.p066b.C1022b;
import com.shuame.rootgenius.common.C1325c;
import com.shuame.rootgenius.common.C1335e.C1329b;
import com.shuame.rootgenius.common.C1335e.C1330c;
import com.shuame.rootgenius.common.C1335e.C1331d;
import com.shuame.rootgenius.common.C1335e.C1332e;
import com.shuame.rootgenius.common.C1335e.C1333f;
import com.shuame.rootgenius.common.p087ui.p106a.C1374a;
import com.shuame.rootgenius.common.p087ui.p106a.C1374a.C1373a;
import com.shuame.rootgenius.common.p087ui.p106a.C1376b;
import com.shuame.rootgenius.common.p087ui.p106a.C1376b.C1375a;
import com.shuame.rootgenius.common.p087ui.view.C1382e;

/* renamed from: com.shuame.rootgenius.common.util.d */
public final class C1391d {
    /* renamed from: a */
    public static C1374a m3890a(Context context, int i, int i2, int i3, int i4, int i5, int i6, OnClickListener onClickListener, OnClickListener onClickListener2) {
        String str = null;
        if (i != 0) {
            str = C1325c.m3724a().getString(i);
        }
        String str2 = null;
        if (i2 != 0) {
            str2 = C1325c.m3724a().getString(i2);
        }
        String str3 = null;
        if (i3 != 0) {
            str3 = C1325c.m3724a().getString(i3);
        }
        String str4 = null;
        if (i4 != 0) {
            str4 = C1325c.m3724a().getString(i4);
        }
        return C1391d.m3891a(context, str, str2, null, str3, str4, i5, i6, onClickListener, onClickListener2);
    }

    /* renamed from: a */
    public static C1374a m3891a(Context context, String str, String str2, String str3, String str4, String str5, int i, int i2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        C1373a c1373a = new C1373a();
        c1373a.f3812a = context;
        c1373a.f3813b = C1333f.dialog21;
        c1373a.f3814c = C1331d.custom_dialog21;
        C1374a c1374a = new C1374a(c1373a);
        View a = c1374a.mo7089a();
        TextView textView = (TextView) a.findViewById(C1330c.tv_title);
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(str);
        }
        textView = (TextView) a.findViewById(C1330c.tv_content_msg);
        if (TextUtils.isEmpty(str2)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(str2);
        }
        ImageView imageView = (ImageView) a.findViewById(C1330c.tv_content_img);
        if (TextUtils.isEmpty(str3)) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.getLayoutParams().width = C1382e.m3849b(context, 711);
            imageView.getLayoutParams().height = C1382e.m3848a(context, 315);
            C1033d.m2984a().mo6286a(str3, imageView, new C1025a().mo6247a(true).mo6241a().mo6242a(C1329b.def_pop_img).mo6248b(C1329b.def_pop_img).mo6250c(C1329b.def_pop_img).mo6245a(new C1022b(6)).mo6249b(), null);
        }
        Button button = (Button) a.findViewById(C1330c.btn_cancel);
        if (TextUtils.isEmpty(str4)) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
            button.setText(str4);
            button.setOnClickListener(new C1392e(c1374a, onClickListener));
            if (i != 0) {
                button.setTextColor(context.getResources().getColor(i));
            }
        }
        button = (Button) a.findViewById(C1330c.btn_ok);
        if (TextUtils.isEmpty(str5)) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
            button.setText(str5);
            button.setOnClickListener(new C1393f(c1374a, onClickListener2));
            if (i2 != 0) {
                button.setTextColor(context.getResources().getColor(i2));
            }
        }
        c1374a.show();
        return c1374a;
    }

    /* renamed from: a */
    public static C1376b m3892a(Context context, OnClickListener onClickListener) {
        C1375a c1375a = new C1375a();
        c1375a.f3818b = C1331d.view_dialog_no_root;
        c1375a.f3822f = C1332e.later_to_say;
        c1375a.f3823g = C1332e.onekeyroot;
        C1376b c1376b = new C1376b(context, c1375a);
        View b = c1376b.mo7092b();
        b.findViewById(C1330c.btn_left).setOnClickListener(new C1394g(c1376b));
        b.findViewById(C1330c.btn_right).setOnClickListener(new C1395h(c1376b, onClickListener));
        c1376b.show();
        return c1376b;
    }
}
