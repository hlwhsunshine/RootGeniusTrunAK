package com.shuame.rootgenius.p115ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.shuame.rootgenius.p108e.C1422a;
import com.shuame.rootgenius.p108e.C1423b;
import com.shuame.rootgenius.p113i.C1455a;
import com.shuame.rootgenius.pojo.BbxCategoryInfo.Item;
import com.shuame.rootgenius.pojo.BbxCategoryInfo.Item.Type;

/* renamed from: com.shuame.rootgenius.ui.g */
final class C1552g implements OnItemClickListener {
    /* renamed from: a */
    final /* synthetic */ BbxListActivity f4380a;

    C1552g(BbxListActivity bbxListActivity) {
        this.f4380a = bbxListActivity;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Item item = (Item) this.f4380a.f4129b.get(i);
        if (Type.APK == item.type) {
            Intent intent = new Intent(this.f4380a, BbxDetailActivity.class);
            intent.putExtra("info", item);
            this.f4380a.startActivity(intent);
        } else if (Type.URL == item.type) {
            C1455a.m4024a(this.f4380a, item.url);
        }
        C1423b.m3949a().mo7143b(new C1422a(item.cName, item.name));
    }
}
