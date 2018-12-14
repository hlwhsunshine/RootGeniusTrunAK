package com.shuame.rootgenius.p115ui.adapter;

import android.graphics.Color;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p115ui.adapter.FontListAdapter.ViewHolder;

/* renamed from: com.shuame.rootgenius.ui.adapter.i */
final class C1516i implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1515h f4317a;

    C1516i(C1515h c1515h) {
        this.f4317a = c1515h;
    }

    public final void run() {
        C1361b.m3817a().mo7067a(this.f4317a.f4312a, null);
        ViewHolder viewHolder = (ViewHolder) this.f4317a.f4313b.getTag(C1450R.id.tag_font_holder);
        viewHolder.mTextFontSize.setText(((double) ((this.f4317a.f4314c.getFontSize() / 1024) / 1024)) + "MB");
        viewHolder.mTextFontSize.setTextColor(Color.parseColor("#666666"));
        viewHolder.mProgress.setProgress(this.f4317a.f4312a.f3728i / 10);
        if (this.f4317a.f4312a.f3719C == Status.PENDING) {
            FontListAdapter.m4309b(viewHolder, ((double) ((this.f4317a.f4314c.getFontSize() / 1024) / 1024)) + "MB", Color.parseColor("#666666"), this.f4317a.f4312a.f3728i / 10, (int) C1450R.string.text_pending);
        } else {
            FontListAdapter.m4309b(viewHolder, ((double) ((this.f4317a.f4314c.getFontSize() / 1024) / 1024)) + "MB", Color.parseColor("#666666"), this.f4317a.f4312a.f3728i / 10, (int) C1450R.string.text_downloading);
        }
    }
}
