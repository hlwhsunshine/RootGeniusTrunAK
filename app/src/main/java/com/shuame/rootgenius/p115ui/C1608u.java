package com.shuame.rootgenius.p115ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.example.myfontsdk.Font;
import com.shuame.rootgenius.common.manager.AppManager;
import com.shuame.rootgenius.common.manager.AppManager.C1348b;
import com.shuame.rootgenius.common.manager.AppManager.HandleType;
import com.shuame.rootgenius.common.manager.AppManager.InstallLocation;
import com.shuame.rootgenius.common.p102c.C1324a;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;
import com.shuame.rootgenius.common.util.C1411s;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p110g.C1440c;
import java.io.File;

/* renamed from: com.shuame.rootgenius.ui.u */
final class C1608u implements OnItemClickListener {
    /* renamed from: a */
    final /* synthetic */ FontReplaceActivity f4406a;

    C1608u(FontReplaceActivity fontReplaceActivity) {
        this.f4406a = fontReplaceActivity;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        FontReplaceActivity.f4182f;
        if (this.f4406a.f4190i.size() > i) {
            Font font = (Font) this.f4406a.f4190i.get(i);
            Bundle bundle = new Bundle();
            bundle.putSerializable("font", font);
            Intent intent = new Intent(this.f4406a, FontPreviewActivity.class);
            intent.putExtras(bundle);
            this.f4406a.startActivity(intent);
            return;
        }
        this.f4406a.f4184b.clear();
        this.f4406a.f4184b.setProperty("MoreFont", "点击更多精美字体");
        C1324a c1324a = this.f4406a.f4185c;
        C1324a.m3723a("ChangeFont", this.f4406a.f4184b);
        int a = C1361b.m3815a("http://upaicdn.xinmei365.com/support/zitiguanjia_sjjl.apk");
        QQDownloadFile a2 = C1361b.m3817a().mo7068a(a);
        if (!this.f4406a.f4188g) {
            boolean a3 = this.f4406a.mo7352a("com.xinmei365.font");
            FontReplaceActivity.f4182f;
            if (a3) {
                this.f4406a.startActivity(this.f4406a.getPackageManager().getLaunchIntentForPackage("com.xinmei365.font"));
                return;
            }
            File a4 = FontReplaceActivity.m4244d();
            if (a4 == null) {
                return;
            }
            if (a4.exists()) {
                this.f4406a.f4193l.setText(this.f4406a.getResources().getText(C1450R.string.install_zitiguanjia));
                C1348b c1348b = new C1348b();
                c1348b.f3677b = a4.getAbsolutePath();
                c1348b.f3676a = a;
                c1348b.f3678c = "com.xinmei365.font";
                c1348b.f3682g = HandleType.SILENT_THEN_SYSTEM;
                c1348b.f3684i = InstallLocation.FLASH;
                AppManager.m3771a().mo7031a(c1348b, this.f4406a);
                FontReplaceActivity.f4182f;
                return;
            }
            if (a2 == null) {
                a2 = new QQDownloadFile();
                a2.f3724e = "http://upaicdn.xinmei365.com/support/zitiguanjia_sjjl.apk";
                a2.f3725f = a4.getAbsolutePath();
                a2.f3717A = 1;
                a2.f3734o = Type.FONT_MANAGER;
            } else {
                a2.f3717A = 1;
            }
            if (FontReplaceActivity.m4237a(this.f4406a, a2)) {
                long b = C1411s.m3926b(a4.getAbsolutePath());
                FontReplaceActivity.f4182f;
                if (b > 600000) {
                    this.f4406a.f4191j.setProgress(a2.f3728i / 10);
                    this.f4406a.f4191j.setVisibility(0);
                    this.f4406a.f4193l.setText(this.f4406a.getResources().getText(C1450R.string.download_zitiguanjia));
                    C1361b.m3817a().mo7075c(a);
                    C1361b.m3817a().mo7067a(a2, this.f4406a.f4187e);
                    FontReplaceActivity.f4182f;
                    new StringBuilder("startDownload downloadFile.long5 == ").append(a2.f3717A);
                    this.f4406a.f4188g = true;
                } else if (b == -1) {
                    C1440c.m3984a().mo7173d(this.f4406a);
                } else {
                    C1440c.m3984a().mo7172c(this.f4406a);
                }
            }
        } else if (a2 != null) {
            this.f4406a.f4193l.setText(this.f4406a.getResources().getText(C1450R.string.download_zitiguanjia));
            this.f4406a.f4191j.setVisibility(0);
            this.f4406a.f4191j.setProgress(a2.f3728i / 10);
        }
    }
}
