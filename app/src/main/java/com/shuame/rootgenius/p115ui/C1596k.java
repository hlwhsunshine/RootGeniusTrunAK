package com.shuame.rootgenius.p115ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;

/* renamed from: com.shuame.rootgenius.ui.k */
final class C1596k implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ArrayList f4386a;
    /* renamed from: b */
    final /* synthetic */ FontPreviewActivity f4387b;

    C1596k(FontPreviewActivity fontPreviewActivity, ArrayList arrayList) {
        this.f4387b = fontPreviewActivity;
        this.f4386a = arrayList;
    }

    public final void onClick(View view) {
        FontPreviewActivity.f4159e;
        new StringBuilder("position == ").append(this.f4387b.f4165g);
        Intent intent = new Intent(this.f4387b, FullViewPageActivity.class);
        intent.addFlags(this.f4387b.f4165g);
        intent.putStringArrayListExtra("imageList", this.f4386a);
        this.f4387b.startActivity(intent);
    }
}
